
import java.io.*;

public class Peer {

    private final TextUI textUI = new TextUI();  // mechanism for text imputs
    public ChatServer mainServer;  // the peer ServerSocket
    private final String agent_id = System.getProperty("user.name"); // to ammend to front of messages
    private String state = "active"; // quit or keep waiting for inputs
    private String port; // port number

    public void run() {
        // get server port num from user and start server
        String portInput = "";
        while (!isValidPortNum(portInput)) {
            portInput = textUI.getInput("Enter 4-digit port number for server: ");
        }
        this.port = portInput;
        System.out.println("OK");
        System.out.println("Starting Server on " + this.port);
        System.out.println();
        this.mainServer = new ChatServer(Integer.parseInt(this.port));
        // start input loop and execute commands
        while (this.state.equals("active")) {
            System.out.println("Enter a command:");
            String entry = textUI.getInput("");
            String[] commandAndArgs = entry.split("[ ]");
            String[] arguments = textUI.getArgs(commandAndArgs);
            switch (commandAndArgs[0]) {
                case "connect" -> {  // connect to a peer
                    if (arguments.length < 2) {
                        System.out.println();
                        System.out.println("This command need more arguments. Try something like 'connect localhost 3000'. Type help if needed.");
                        System.out.println();
                        break;
                    }
                    try {
                        this.mainServer.connectToPeer(arguments[0], Integer.parseInt(arguments[1]));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
                case "send" -> {  //  send a message
                    synchronized (mainServer.clientWriters) {  // regulate threads
                        for (PrintWriter writer : mainServer.clientWriters) { // each connected client
                            System.out.println();
                            writer.println("From " + agent_id + ": " + entry.substring(5));
                        }
                    }
                }
                case "help" -> { // show commands available
                    System.out.println("");
                    System.out.println("Separate arguments with a space. Available commands are:");
                    System.out.println("-----------------------");
                    System.out.println("connect [args] - request a connection to ipAddress in[arg1] port in [arg2], such as 'connect localhost 3000'.");
                    System.out.println("send [arg] - sends [arg] as message to connected peer, such as 'send I am awesome.'.");
                    System.out.println("help - lists all possible commands.");
                    System.out.println("quit - exits the program immediately.");
                    System.out.println("");
                }
                case "quit" -> { // exit program
                    System.out.println("");
                    System.out.println("All peers disconnected. End of line.");
                    this.state = "inactive";
                    System.exit(0);
                }
                default ->
                    System.out.println("That is an invalid command - type 'help' for commands.");
            }
        }
    }

    private boolean isValidPortNum(String s) {  // ensure port input is a 4-digit number
        if (s.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
