import java.io.*;

/**
 * ChatMessage
 *
 * This defines the messages being used in the server
 *
 * @author Ashutosh Annapantula
 * @version November 30, 2020
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
        this.type = type;
        this.message = message;
    }

    // getters
    int getType() {
        return type;
    }
    String getMessage() {
        return message;
    }
}
