package CS180Project5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Project 5 
 * 
 * @author Simon Twiss, Saul Means, Timothy Porterfield
 * @version 11/28/2020
 * 
 */

public class LoginGUI extends JComponent implements Runnable { // it is assumed users will activate Server class (such
	JButton login; // as by running it in terminal) before activating LoginGUI class
	JButton createAccount;
	JButton enter;
	JButton enter1;
	JButton enter2;
	JButton back;
	JButton back1;
	JButton back2;
	JButton deleteAccount;
	JTextField userName;
	JTextField userName1;
	JTextField userName2;
	JPasswordField password;
	JPasswordField password1;
	JPasswordField password2;
	JTextField phoneNumber;
	JTextField email;
	JFrame welcomePanel;
	JFrame loginPanel;
	JFrame createAccountPanel;
	JFrame deleteAccountPanel;
	static String accountToDelete = "";
	static  Color gold = new Color(212, 189, 138);
	static int counter = 0;
	static ArrayList<User> allUsers = new ArrayList<User>();
	static ArrayList<User> newUsers = new ArrayList<User>();
	static Socket socket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		try {
			socket = new Socket("localhost", 4242);
			openAndClose();
			SwingUtilities.invokeLater(new LoginGUI());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	

	public static void openAndClose() throws UnknownHostException, IOException {
		try {
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
				writer.write(accountToDelete);
				writer.println();
				writer.flush();
			   // socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			welcomePanel = new JFrame("Welcome");
			ImageIcon icon = new ImageIcon("Welcome.jpg");
			JLabel label = new JLabel(icon);
			welcomePanel.getContentPane().add(label, BorderLayout.CENTER);
			login = new JButton("Login");
			login.addActionListener(actionListener);
			createAccount = new JButton("Create Account");
			createAccount.addActionListener(actionListener);
			deleteAccount = new JButton("Delete Account");
			deleteAccount.addActionListener(actionListener);
			JPanel subPanel = new JPanel();
			subPanel.add(login);
			subPanel.add(createAccount);
			subPanel.add(deleteAccount);
			welcomePanel.add(subPanel, BorderLayout.SOUTH);
			welcomePanel.setSize(500, 700);
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

			// login panel
			loginPanel = new JFrame("Login");
			JLabel subLabel = new JLabel(new ImageIcon("Welcome.jpg"));
			loginPanel.add(subLabel);
			JLabel userNameLabel = new JLabel("Username:");
			userNameLabel.setBounds(158, 278, 80, 25);
			userNameLabel.setOpaque(true);
			userNameLabel.setBackground(Color.BLACK);
			userNameLabel.setForeground(gold);
			subLabel.add(userNameLabel);
			userName = new JTextField(5);
			userName.setBounds(245, 278, 80, 25);
			subLabel.add(userName);
			JLabel passwordLabel = new JLabel("Password:"); // it is assumed users will only type their
			passwordLabel.setBounds(158, 308, 80, 25); // passwords (rather than, for example,
			passwordLabel.setOpaque(true);
			passwordLabel.setBackground(Color.BLACK);
			passwordLabel.setForeground(gold);
			subLabel.add(passwordLabel); // copying and pasting them)
			password = new JPasswordField(5);
			password.setBounds(245, 308, 80, 25);
			subLabel.add(password);
			enter = new JButton("Login");
			enter.setBounds(205, 338, 80, 25);
			enter.setAlignmentX(CENTER_ALIGNMENT);
			enter.addActionListener(actionListener);
			subLabel.add(enter);
			back = new JButton("Back");
			back.setBounds(205, 368, 80, 25);
			back.addActionListener(actionListener);
			subLabel.add(back);
			loginPanel.setSize(500, 700);
			loginPanel.setLocationRelativeTo(null);
			loginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			loginPanel.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent event) {
					loginPanelExitProcedure();
				}
			});

			// create Account panel
			createAccountPanel = new JFrame("Create Account");
			JLabel subLabel1 = new JLabel(new ImageIcon("Welcome.jpg"));
			createAccountPanel.add(subLabel1);
			JLabel userNameLabel1 = new JLabel("Username:");
			userNameLabel1.setBounds(140, 248, 98, 25);
			userNameLabel1.setOpaque(true);
			userNameLabel1.setBackground(Color.BLACK);
			userNameLabel1.setForeground(gold);
			subLabel1.add(userNameLabel1);
			userName1 = new JTextField(5);
			userName1.setBounds(245, 248, 80, 25);
			subLabel1.add(userName1);
			JLabel passwordLabel1 = new JLabel("Password:");
			passwordLabel1.setBounds(140, 278, 98, 25);
			passwordLabel1.setOpaque(true);
			passwordLabel1.setBackground(Color.BLACK);
			passwordLabel1.setForeground(gold);
			subLabel1.add(passwordLabel1);
			password1 = new JPasswordField(5);
			password1.setBounds(245, 278, 80, 25);
			subLabel1.add(password1);
			JLabel phoneNumberLabel = new JLabel("Phone Number:");
			phoneNumberLabel.setBounds(140, 308, 98, 25);
			phoneNumberLabel.setOpaque(true);
			phoneNumberLabel.setBackground(Color.BLACK);
			phoneNumberLabel.setForeground(gold);
			subLabel1.add(phoneNumberLabel);
			phoneNumber = new JTextField(5);
			phoneNumber.setBounds(245, 308, 80, 25);
			subLabel1.add(phoneNumber);
			JLabel emailLabel = new JLabel("Email:");
			emailLabel.setBounds(140, 338, 98, 25);
			emailLabel.setOpaque(true);
			emailLabel.setBackground(Color.BLACK);
			emailLabel.setForeground(gold);
			subLabel1.add(emailLabel);
			email = new JTextField(5);
			email.setBounds(245, 338, 80, 25);
			subLabel1.add(email);
			back1 = new JButton("Back");
			back1.setBounds(205, 398, 80, 25);
			back1.addActionListener(actionListener);
			subLabel1.add(back1);
			enter1 = new JButton("Create Account");
			enter1.setBounds(185, 368, 130, 25);
			enter1.addActionListener(actionListener);
			subLabel1.add(enter1);
			createAccountPanel.setSize(500, 700);
			createAccountPanel.setLocationRelativeTo(null);
			createAccountPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			createAccountPanel.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent event) {
					createAccountPanelExitProcedure();
				}
			});
			
			deleteAccountPanel = new JFrame("Delete Account");
			JLabel subLabel2 = new JLabel(new ImageIcon("Welcome.jpg"));
			deleteAccountPanel.add(subLabel2);
			JLabel userNameLabel2 = new JLabel("Username:");
			userNameLabel2.setBounds(158, 278, 80, 25);
			userNameLabel2.setOpaque(true);
			userNameLabel2.setBackground(Color.BLACK);
			userNameLabel2.setForeground(gold);
			subLabel2.add(userNameLabel2);
			userName2 = new JTextField(5);
			userName2.setBounds(245, 278, 80, 25);
			subLabel2.add(userName2);
			JLabel passwordLabel2 = new JLabel("Password:"); // it is assumed users will only type their
			passwordLabel2.setBounds(158, 308, 80, 25); // passwords (rather than, for example,
			passwordLabel2.setOpaque(true);
			passwordLabel2.setBackground(Color.BLACK);
			passwordLabel2.setForeground(gold);
			subLabel2.add(passwordLabel2); // copying and pasting them)
			password2 = new JPasswordField(5);
			password2.setBounds(245, 308, 80, 25);
			subLabel2.add(password2);
			enter2 = new JButton("Login");
			enter2.setBounds(205, 338, 80, 25);
			enter2.setAlignmentX(CENTER_ALIGNMENT);
			enter2.addActionListener(actionListener);
			subLabel2.add(enter2);
			back2 = new JButton("Back");
			back2.setBounds(205, 368, 80, 25);
			back2.addActionListener(actionListener);
			subLabel2.add(back2);
			deleteAccountPanel.setSize(500, 700);
			deleteAccountPanel.setLocationRelativeTo(null);
			deleteAccountPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			deleteAccountPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			deleteAccountPanel.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent event) {
					deleteAccountPanelExitProcedure();
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAccountPanelExitProcedure() {
		try {
			deleteAccountPanel.dispose();
			openAndClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createAccountPanelExitProcedure() {
		try {
			createAccountPanel.dispose();
			openAndClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginPanelExitProcedure() {
		try {
			loginPanel.dispose();
			openAndClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void welcomePanelExitProcedure() {
		try {
			welcomePanel.dispose();
			openAndClose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == login) {
					welcomePanel.dispose();
					loginPanel.setVisible(true);
				}
				if (e.getSource() == createAccount) {
					welcomePanel.dispose();
					createAccountPanel.setVisible(true);
				}
				if (e.getSource() == back || e.getSource() == back1 || e.getSource() == back2) {
					deleteAccountPanel.dispose();
					loginPanel.dispose();
					password.setText("");
					password1.setText("");
					password2.setText("");
					userName.setText("");
					userName1.setText("");
					userName2.setText("");
					phoneNumber.setText("");
					email.setText("");
					createAccountPanel.dispose();
					welcomePanel.setVisible(true);
				}
				// login button on the login panel
				if (e.getSource() == enter) {
					if (isAUser(userName.getText(), password.getText()) == true) {
						String user = userName.getText();
						loginPanel.dispose();
						try {
							openAndClose();
						} catch (UnknownHostException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Login Succesful!", "Success", JOptionPane.PLAIN_MESSAGE);
						try {
				            new MessageClientGUI("localhost", 1500, user);
				        } catch (Exception e1) {
				            e1.printStackTrace();
				        }
						// open the user panel
					} else {
						JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				// login button on the create account panel
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
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "You're account has been succesfully created!", "Success", JOptionPane.PLAIN_MESSAGE);
						try {
				            new MessageClientGUI("localhost", 1500, userName);
				        } catch (Exception e1) {
				            e1.printStackTrace();
				        }
					}
				}
				if (e.getSource() == deleteAccount) {
					welcomePanel.dispose();
					deleteAccountPanel.setVisible(true);
				}
				if (e.getSource() == enter2) {
					if (deleteUser(userName2.getText(), password2.getText()) == true) {
						deleteAccountPanel.dispose();
						try {
							openAndClose();
						} catch (UnknownHostException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Account Deletion Succesful!", "Success", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "The username or password you entered is incorrect.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	};
	    
	public static boolean isAUser(String userName, String password) {
		try {
			for (int i = 0; i < allUsers.size(); i++) {
				if (userName.equals(allUsers.get(i).getUserName())) {
					if (password.equals(allUsers.get(i).getPassword())) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteUser(String userName, String password) {
		try {
			for (int i = 0; i < allUsers.size(); i++) {
				if (userName.equals(allUsers.get(i).getUserName())) {
					if (password.equals(allUsers.get(i).getPassword())) {
						accountToDelete = allUsers.get(i).toString();
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean validInfo(String userName, String email, String phoneNumber, String password) {
		try {
			boolean returnStatement = true;
			for (int i = 0; i < allUsers.size(); i++) {
				if (allUsers.get(i).getUserName().equals(userName) || userName.equals("")) {
					returnStatement = false;
					JOptionPane.showMessageDialog(null, "Invalid Username", "Error", JOptionPane.ERROR_MESSAGE);
					break;
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
				if (Long.parseLong(phoneNumber) < 0) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				returnStatement = false;
				JOptionPane.showMessageDialog(null, "Invalid Phone Number (Must be 10 digits with numbers only)", "Error", JOptionPane.ERROR_MESSAGE);
			}
			return returnStatement;
		} catch (Exception e) {
			e.printStackTrace();
			return false; // default return statement for when Exceptions are found;
			// similar to indexOf() returning -1 when a character can not be found in a String
		}
	}
}
