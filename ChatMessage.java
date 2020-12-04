package CS180Project5;

import java.io.*;

/**
 * ChatMessage
 *
 * This defines the messages being used in the server
 *
 * @author Ashutosh Annapantula, Timothy Porterfield
 * @version 12/1/2020
 */

public class ChatMessage implements Serializable {

    protected static final long serialVersionUID = 1112122200L;

    // The different types of message sent by the Client
    // USERS to receive the list of the users connected
    // MESSAGE an ordinary message
    // LOGOUT to disconnect from the Server
    static final int USERS = 0;
    static final int MESSAGE = 1;
    static final int LOGOUT = 2;
    private int type;
    private String message;

    // constructor
    ChatMessage(int type, String message) {
        try {
            this.type = type;
            this.message = message;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getters
    int getType() {
        try {
            return type;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // default return statement in case Exception is thrown
        }
    }

    String getMessage() {
        try {
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return ""; // default return statement in case Exception is thrown
        }
    }
}
