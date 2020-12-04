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

/**
 * Server
 *
 * Received guidance from Stack Overflow and high school friend
 *
 * @author Simon Twiss, Saul Means, Timothy Porterfield
 * @version 12/1/2020
 *
 */

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

		ServerSocket serverSocket = new ServerSocket(4242);
		Socket socket = serverSocket.accept();

		try {
			String line;
			String finalFile = "";
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			try (BufferedReader bfr = new BufferedReader(new FileReader(new
					File("C:\\Users\\timmo\\src\\CS180Project5\\Users.txt")))) {
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			try {
				line = reader.readLine();
				File file = new File("C:\\Users\\timmo\\src\\CS180Project5\\Users.txt");
				FileOutputStream fos = new FileOutputStream(file);
				PrintWriter pw = new PrintWriter(fos);
				while (!line.equals("Exit")) {
					finalFile = line + "\n" + finalFile;
					line = reader.readLine();
				}
				pw.println(finalFile);
				pw.println("Exit");
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
