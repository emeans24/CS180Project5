package CS180Project5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MessageServerGUI
 * The server as a GUI
 */
public class MessageServerGUI extends JFrame implements ActionListener, WindowListener {

    private static final long serialVersionUID = 1L;
    // the stop and start buttons
    private JButton stopStart;
    // JTextArea for the chat room and the events
    private JTextArea chat, event;
    // The port number
    private JTextField tPortNumber;
    // my server
    private MessageServer server;


    // server constructor that receive the port to listen to for connection as parameter
    MessageServerGUI(int port) {
        super("Chat Server");
        try {
            server = null;
            // in the NorthPanel the PortNumber the Start and Stop buttons
            JPanel north = new JPanel();
            north.add(new JLabel("Port number: "));
            tPortNumber = new JTextField("  " + port);
            north.add(tPortNumber);
            // to stop or start the server, we start with "Start"
            stopStart = new JButton("Start");
            stopStart.addActionListener(this);
            north.add(stopStart);
            add(north, BorderLayout.NORTH);

            // the event and chat room
            JPanel center = new JPanel(new GridLayout(2, 1));
            chat = new JTextArea(80, 80);
            chat.setEditable(false);
            appendRoom("Chat room.\n");
            center.add(new JScrollPane(chat));
            event = new JTextArea(80, 80);
            event.setEditable(false);
            appendEvent("Events log.\n");
            center.add(new JScrollPane(event));
            add(center);

            // need to be informed when the user click the close button on the frame
            addWindowListener(this);
            setSize(400, 600);
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // append message to the two JTextArea
    // position at the end
    void appendRoom(String str) {
        try {
            chat.append(str);
            chat.setCaretPosition(chat.getText().length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void appendEvent(String str) {
        try {
            event.append(str);
            event.setCaretPosition(chat.getText().length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // start or stop where clicked
    public void actionPerformed(ActionEvent e) {
        try {
            // if running we have to stop
            if (server != null) {
                server.stop();
                server = null;
                tPortNumber.setEditable(true);
                stopStart.setText("Start");
                return;
            }
            // OK start the server
            int port;
            try {
                port = Integer.parseInt(tPortNumber.getText().trim());
            } catch (Exception er) {
                appendEvent("Invalid port number");
                return;
            }
            // create a new Server
            server = new MessageServer(port, this);
            // and start it as a thread
            new ServerRunning().start();
            stopStart.setText("Stop");
            tPortNumber.setEditable(false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // entry point to start the Server
    public static void main(String[] arg) {
        try {
            // start server default port 1500
            new MessageServerGUI(1500);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /*
     * If the user click the X button to close the application
     * I need to close the connection with the server to free the port
     */
    public void windowClosing(WindowEvent e) {
        try {
            // if my Server exist
            if (server != null) {
                try {
                    server.stop();            // ask the server to close the connection
                } catch (Exception eClose) {
                }
                server = null;
            }
            // dispose the frame
            dispose();
            System.exit(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    // I can ignore the other WindowListener method
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    /*
     * A thread to run the Server
     */
    class ServerRunning extends Thread {
        public void run() {
            server.start();         // should execute until if fails
            // the server failed
            stopStart.setText("Start");
            tPortNumber.setEditable(true);
            appendEvent("Server crashed\n");
            server = null;
        }
    }

}

