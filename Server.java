package CS180Project5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * Project 5 
 * 
 * 
 * @author Simon Twiss, Saul Means
 * @version 11/24/2020
 * 
 */

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(4242);
	Server s = new Server();
	while (true) {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Thread t = s.new ClientHandler(socket, reader, writer);
			t.start();
		} catch (Exception e) {
			socket.close();
			e.printStackTrace();
		}
	}
}

class ClientHandler extends Thread {
	final PrintWriter writer;
	final BufferedReader reader;
	final Socket socket;
	
	public ClientHandler(Socket socket, BufferedReader reader, PrintWriter writer) {
		this.socket = socket;
		this.reader = reader;
		this.writer = writer;
	}
	
	@Override
	public void run() {
		String line;
		String finalFile = "";
		try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Users.txt")))) {
			line = bfr.readLine();
			finalFile = line;
			while (line != null) {
				writer.write(line);
				writer.println();
				writer.flush();
				line = bfr.readLine();
				if (line != null && !line.equals("Exit")) {
					finalFile = finalFile + "\n" + line;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			line = reader.readLine();
			File file = new File("Users.txt");
			FileOutputStream fos = new FileOutputStream(file);
	        PrintWriter pw = new PrintWriter(fos);
			while (!line.equals("Exit")) {
				finalFile = line + "\n" + finalFile;
				line = reader.readLine();
			}
			line = reader.readLine();
			if (!line.equals("")) {
				finalFile = finalFile.replace(line + "\n", "");
			}
			String accountToEdit = reader.readLine();
			String newInfo = reader.readLine();
			if (!accountToEdit.equals("")) {
				finalFile = finalFile.replace(accountToEdit, newInfo);				
			}
			pw.println(finalFile);
			pw.println("Exit");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
