import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MessageClientGUI
 *
 * The GUI for the client
 *
 * @author Ashutosh Annapantula, Timothy Porterfield
 * @version 12/1/2020
 */

public class MessageClientGUI extends JFrame implements ActionListener {

    static String userName;
    private static final long serialVersionUID = 1L;
    // will first hold "Username:", later on "Enter message"
    private JLabel label;
    // to hold the Username and later on the messages
    private JTextField tf;
    // to hold the server address an the port number
    private JTextField tfServer, tfPort;
    // to Logout and get the list of the users
    private JButton login, logout, users;
    // for the chat room
    private JTextArea ta;
    // if it is for connection
    public boolean connected;
    // the Client object
    private MessageClient client;
    // the default port number
    private int defaultPort;
    private String defaultHost;
    // custom gold color
    static Color gold = new Color(212, 189, 138);

    // load the previous chat for the first time
    private boolean prevChatLoaded = false;
    final String connectionMessage = "Connection accepted";
    final String closingMessage = "Server has close the connection: java.io.EOFException";

    // Constructor connection receiving a socket number
    MessageClientGUI(String host, int port, String username) {
        super("Chat Client");
        userName = username;
        try {
            defaultPort = port;
            defaultHost = host;

            // The NorthPanel with:
            JPanel northPanel = new JPanel(new GridLayout(3, 1));
            // the server name and the port number
            JPanel serverAndPort = new JPanel(new GridLayout(1, 5, 1, 3));
            // the two JTextField with default value for server address and port number
            tfServer = new JTextField(host);
            tfPort = new JTextField("" + port);
            tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

            serverAndPort.add(new JLabel("Server Address:  "));
            serverAndPort.add(tfServer);
            serverAndPort.add(new JLabel("Port Number:  "));
            serverAndPort.add(tfPort);
            serverAndPort.add(new JLabel(""));
            // adds the Server an port field to the GUI
            northPanel.add(serverAndPort);

            // the Label and the TextField
            label = new JLabel("Welcome " + username, SwingConstants.CENTER);
            northPanel.add(label);
            tf = new JTextField("Login, then enter message here.");
            tf.setBackground(gold);
            northPanel.add(tf);
            add(northPanel, BorderLayout.NORTH);

            // The CenterPanel which is the chat room
            ta = new JTextArea("Welcome to the Chat room\n", 80, 80);
            JPanel centerPanel = new JPanel(new GridLayout(1, 1));
            centerPanel.add(new JScrollPane(ta));
            ta.setEditable(false);
            ta.setBackground(Color.DARK_GRAY);
            ta.setForeground(gold);
            add(centerPanel, BorderLayout.CENTER);

            // the 3 buttons
            login = new JButton("Login");
            login.addActionListener(this);

            logout = new JButton("Logout");
            logout.addActionListener(this);
            logout.setEnabled(false); // you have to login before being able to logout

            users = new JButton("Users");
            users.addActionListener(this);
            users.setEnabled(false); // you have to login before being able to users

            JPanel southPanel = new JPanel();
            southPanel.add(login);
            southPanel.add(logout);
            southPanel.add(users);
            add(southPanel, BorderLayout.SOUTH);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 800);
            setVisible(true);
            tf.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // called by the Client to append text in the TextArea
    void append(String str) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy ");
        Date dateobj = new Date();
        String formatDate = df.format(dateobj);


        String userChatFilePath = "C:\\Users\\ashut\\" + userName + "_CHAT.txt";
        try {
            if (str.contains(connectionMessage) && !prevChatLoaded) {
                // Lets append the previous chat
                prevChatLoaded = true;

                String content = new String(Files.readAllBytes(Paths.get(userChatFilePath)));
                ta.append(str + "\n" + content);
                ta.setCaretPosition(ta.getText().length() - 1);
            } else {
                if (!str.contains(closingMessage)) {
                    String appndDateStr = formatDate + str;
                    Files.write(Paths.get(userChatFilePath), appndDateStr.getBytes(), StandardOpenOption.APPEND);
                }
                String appndDateStr = formatDate + str;
                ta.append(appndDateStr);
                ta.setCaretPosition(ta.getText().length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // called by the GUI is the connection failed
    // we reset our buttons, label, textfield
    void connectionFailed() {
        try {
            login.setEnabled(true);
            logout.setEnabled(false);
            users.setEnabled(false);
            label.setText("Enter your username below");
            // tf.setText("Anonymous");
            // reset port number and host name as a construction time
            tfPort.setText("" + defaultPort);
            tfServer.setText(defaultHost);
            // let the user change them
            tfServer.setEditable(false);
            tfPort.setEditable(false);
            // don't react to a <CR> after the username
            tf.removeActionListener(this);
            connected = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Button or JTextField clicked
     */
    public void actionPerformed(ActionEvent e) {
        try {
            Object o = e.getSource();
            // if it is the Logout button
            if (o == logout) {
                client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
                return;
            }
            // if it the users button
            if (o == users) {
                client.sendMessage(new ChatMessage(ChatMessage.USERS, ""));
                return;
            }

            // ok it is coming from the JTextField
            if (connected) {
                // just have to send the message
                client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));
                tf.setText("");
                return;
            }

            if (o == login) {
                // ok it is a connection request
                String username = userName.trim();
                // empty username ignore it
                if (username.length() == 0)
                    return;
                // empty serverAddress ignore it
                String server = tfServer.getText().trim();
                if (server.length() == 0)
                    return;
                // empty or invalid port number, ignore it
                String portNumber = tfPort.getText().trim();
                if (portNumber.length() == 0)
                    return;
                int port = 0;
                try {
                    port = Integer.parseInt(portNumber);
                } catch (Exception en) {
                    return; // nothing I can do if port number is not valid
                }

                // try creating a new Client with GUI
                client = new MessageClient(server, port, username, this);
                // test if we can start the Client
                if (!client.start())
                    return;
                tf.setText("");
                label.setText(username + ", enter your message below");
                connected = true;

                // disable login button
                login.setEnabled(false);
                // enable the 2 buttons
                logout.setEnabled(true);
                users.setEnabled(true);
                // disable the Server and Port JTextField
                tfServer.setEditable(false);
                tfPort.setEditable(false);
                // Action listener for when the user enter a message
                tf.addActionListener(this);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // to start the whole thing the server
    /*
     * public static void main(String[] args) { try { new
     * MessageClientGUI("localhost", 1500); } catch (Exception e) {
     * e.printStackTrace(); } }
     */

}
