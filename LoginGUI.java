import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
/*
 * Project 5 
 * 
 * Received guidance from Stack Overflow and high school friend
 * 
 * @author Simon Twiss, Saul Means
 * @version 11/24/2020
 * 
 */
public class LoginGUI extends JComponent implements Runnable {
	JButton login;
	JButton createAccount;
	JButton enter;
	JButton enter1;
	JButton back;
	JButton back1;
	JTextField userName;
	JTextField userName1;
	JPasswordField password;
	JPasswordField password1;
	JTextField phoneNumber;
	JTextField email;
	JFrame welcomePanel;
	JFrame loginPanel;
	JFrame createAccountPanel;
	static int counter = 0;
	static ArrayList<User> allUsers = new ArrayList<User>();
	static ArrayList<User> newUsers = new ArrayList<User>();
	static Socket socket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		socket = new Socket("localhost", 4242);
		openAndClose();
        SwingUtilities.invokeLater(new LoginGUI());
    }
	

	public static void openAndClose() throws UnknownHostException, IOException {
		if (counter == 0) {
			String[] info;
			allUsers = new ArrayList<User>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();
			while (!line.equals("Exit")) {
				info = line.split(",");
				String userName = info[0];
				String password = info[1];
				String email = info[2];
				long phoneNumber = Long.parseLong(info[3]);
				User user = new User(userName, password, email, phoneNumber);
				allUsers.add(user);
				line = reader.readLine();
			}
			counter++;
		} else {
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			if (newUsers != null) {
				for (int i = 0; i < newUsers.size(); i++) {
					writer.write(newUsers.get(i).toString());
				    writer.println();
				    writer.flush();
				}
			}
		    writer.write("Exit");
		    writer.println();
		    writer.flush();
		   //socket.close();
		}
	}

	public void run() {
		//Welcome panel
		welcomePanel = new JFrame("Welcome");
		ImageIcon icon = new ImageIcon("Welcome.jpg");
		JLabel label = new JLabel(icon);
		welcomePanel.getContentPane().add(label, BorderLayout.CENTER);
		login = new JButton("Login");
		login.addActionListener(actionListener);
		createAccount = new JButton("Create Account");
		createAccount.addActionListener(actionListener);
		JPanel subPanel = new JPanel();;
		subPanel.add(login);
		subPanel.add(createAccount);
		welcomePanel.add(subPanel, BorderLayout.SOUTH);
		welcomePanel.setSize(600, 400);
		welcomePanel.setLocationRelativeTo(null);
		welcomePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomePanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		welcomePanel.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		    	welcomePanelExitProcedure();
		    }
		});
		welcomePanel.setVisible(true);
		
		//login panel
		loginPanel = new JFrame("Login");
		JLabel subLabel = new JLabel(new ImageIcon("LoginBackground.png"));
		loginPanel.add(subLabel);
		JLabel userNameLabel = new JLabel("Username:");
		userNameLabel.setBounds(175, 110, 80, 25);
		subLabel.add(userNameLabel);
		userName = new JTextField(5);
		userName.setBounds(250, 110, 80, 25);
		subLabel.add(userName);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(179, 140, 80, 25);
		subLabel.add(passwordLabel);
		password = new JPasswordField(5);
		password.setBounds(250, 140, 80, 25);
		subLabel.add(password);
		enter = new JButton("Login");
		enter.setBounds(250, 170, 80, 25);
		enter.setAlignmentX(CENTER_ALIGNMENT);
		enter.addActionListener(actionListener);
		subLabel.add(enter);
		back = new JButton("Back");
		back.setBounds(250, 200, 80, 25);
		back.addActionListener(actionListener);
		subLabel.add(back);
		loginPanel.setSize(600, 400);
		loginPanel.setLocationRelativeTo(null);
		loginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		loginPanel.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		    	loginPanelExitProcedure();
		    }
		});
		
		//create Account panel
		createAccountPanel = new JFrame("Create Account");
		JLabel subLabel1 = new JLabel(new ImageIcon("LoginBackground.png"));
		createAccountPanel.add(subLabel1);
		JLabel userNameLabel1 = new JLabel("Username:");
		userNameLabel1.setBounds(175, 110, 80, 25);
		subLabel1.add(userNameLabel1);
		userName1 = new JTextField(5);
		userName1.setBounds(250, 110, 80, 25);
		subLabel1.add(userName1);
		JLabel passwordLabel1 = new JLabel("Password:");
		passwordLabel1.setBounds(179, 140, 80, 25);
		subLabel1.add(passwordLabel1);
		password1 = new JPasswordField(5);
		password1.setBounds(250, 140, 80, 25);
		subLabel1.add(password1);
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberLabel.setBounds(155, 170, 100, 25);
		subLabel1.add(phoneNumberLabel);
		phoneNumber = new JTextField(5);
		phoneNumber.setBounds(250, 170, 80, 25);
		subLabel1.add(phoneNumber);
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(208, 200, 80, 25);
		subLabel1.add(emailLabel);
		email = new JTextField(5);
		email.setBounds(250, 200, 80, 25);
		subLabel1.add(email);
		back1 = new JButton("Back");
		back1.setBounds(250, 260, 80, 25);
		back1.addActionListener(actionListener);
		subLabel1.add(back1);
		enter1 = new JButton("Create Account");
		enter1.setBounds(230, 230, 130, 25);
		enter1.addActionListener(actionListener);
		subLabel1.add(enter1);
		createAccountPanel.setSize(600, 400);
		createAccountPanel.setLocationRelativeTo(null);
		createAccountPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createAccountPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		createAccountPanel.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent event) {
		    	createAccountPanelExitProcedure();
		    }
		});
	}
	
	public void createAccountPanelExitProcedure() {
		createAccountPanel.dispose();
		try {
			openAndClose();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loginPanelExitProcedure() {
		loginPanel.dispose();
		try {
			openAndClose();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void welcomePanelExitProcedure() {
		welcomePanel.dispose();
		try {
			openAndClose();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	ActionListener actionListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() == login) {
	            	welcomePanel.dispose();
	            	loginPanel.setVisible(true);
	            }
	            if (e.getSource() == createAccount) {
	            	welcomePanel.dispose();
	            	createAccountPanel.setVisible(true);
	            }
	            if (e.getSource() == back || e.getSource() == back1) {
	            	loginPanel.dispose();
	            	password.setText("");
	            	password1.setText("");
	            	userName.setText("");
	            	userName1.setText("");
	            	phoneNumber.setText("");
	            	email.setText("");
	            	createAccountPanel.dispose();
	            	welcomePanel.setVisible(true);
	            }
	            //Login button on the login panel
	            if (e.getSource() == enter) {
	            	if (isAUser(userName.getText(), password.getText()) == true) {
	            		loginPanel.dispose();
	            		try {
							openAndClose();
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            		JOptionPane.showMessageDialog(null, "Login Succesful!", "Success", JOptionPane.PLAIN_MESSAGE);
	            		//open the user panel
	            	} else {
	            		JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
	            	}
	            }
	            //login button on the create account panel
	            if (e.getSource() == enter1) {
	            	if (validInfo(userName1.getText(), email.getText(), phoneNumber.getText(), password1.getText()) == true) {
	            		String userName = userName1.getText();
	            		String password = password1.getText();
	            		String Email = email.getText();
	            		long phonenumber = Long.parseLong(phoneNumber.getText());
	            		User user = new User(userName, password, Email, phonenumber);
	            		allUsers.add(user);
	            		newUsers.add(user);
	            		createAccountPanel.dispose();
	            		try {
							openAndClose();
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            		JOptionPane.showMessageDialog(null, "You're account has been succesfully created!", "Success", JOptionPane.PLAIN_MESSAGE);
	            	}
	            }
	        }
	    };
	    
	   public static boolean isAUser(String userName, String password) {
		   for (int i = 0; i < allUsers.size(); i++) {
			   if (userName.equals(allUsers.get(i).getUserName())) {
				   if (password.equals(allUsers.get(i).getPassword())) {
					   return true;
				   }
			   }
		   }
		   return false;
	   }
	   
	   public static boolean validInfo(String userName, String email, String phoneNumber, String password) {
		   boolean returnStatement = true;
		   for (int i = 0; i < allUsers.size(); i++) {
			   if (allUsers.get(i).getUserName().equals(userName) || userName.equals("")) {
				   returnStatement = false;
				   JOptionPane.showMessageDialog(null, "Invalid Username", "Error", JOptionPane.ERROR_MESSAGE);
			   }
		   }
		   if (password.length() < 8) {
			   JOptionPane.showMessageDialog(null, "Invalid Password. Must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
			   returnStatement = false;
		   }
		   if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
			   returnStatement = false;
			   JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
		   }
		   try {
			   if (phoneNumber.length() != 10) {
				   throw new NumberFormatException();
			   }
			   Long.parseLong(phoneNumber);
		   } catch (NumberFormatException e) {
			   returnStatement = false;
			   JOptionPane.showMessageDialog(null, "Invalid Phone Number (Must be 10 digits with numbers only)", "Error", JOptionPane.ERROR_MESSAGE);
		   }
		   return returnStatement;
	   }
}