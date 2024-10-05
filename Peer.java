
import java.util.Arrays;

public class Peer {

    private final TextUI textUI = new TextUI();
    private ThreadMessage threadMessage = new ThreadMessage();
    private final ChatClient client = new ChatClient(threadMessage);
    private final ChatServer server = new ChatServer(threadMessage);
    private final String agent_id = System.getProperty("user.name");
    private String state = "active";

    public Peer() {
    }

    public void run() {
        System.out.println("Controller - Starting Client");
        new Thread(client).start();
        System.out.println("Controller - Starting Server");
        new Thread(server).start();
        //  ArrayList<String> commandAndArgs;
        while (this.state.equals("active")) {  // repeat until game ends
            String entry = textUI.getInput(agent_id + "--> ");
            //  commandAndArgs = parser.parse(entry);
            String[] commandAndArgs = entry.split("[ ]");
            String[] arguments = textUI.getArgs(commandAndArgs);
            switch (commandAndArgs[0]) {
                case "peers" -> {
                    this.peers("peers", arguments);
                }
                case "request" -> {
                    this.request("request", arguments);
                }
                case "accept" -> {
                    this.accept("accept", arguments);
                }
                case "disconnect" -> {
                    this.disconnect("disconnect", arguments);
                }
                case "send" -> {
                    this.send("send", arguments);
                }
                case "status" -> {
                    this.send("status", arguments);
                }
                case "help" -> {
                    this.help("help", arguments);
                }
                case "quit" -> {
                    this.quit("quit", arguments);
                }
                default ->
                    System.out.println("That is an invalid command - type 'help' for commands.");
            }
        }
    }

// needs completion
    public void peers(String _command, String[] _arguments) {
        //peers - find available peers
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// needs completion
    public void request(String _command, String[] _arguments) {
        //request [ipAddress:port] - request connect
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// needs completion
    public void accept(String _command, String[] _arguments) {
        //accept - accept connection request
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// needs completion
    public void disconnect(String _command, String[] _arguments) {
        //disconnect [ip address:port]
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// needs completion
    public void send(String _command, String[] _arguments) {
        //send [arg] - send message in arg to connected peer
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// needs completion
    public void status(String _command, String[] _arguments) {
        //status - show connection status
        System.out.println("Your command was " + _command);
        System.out.println("Your arguments were " + Arrays.toString(_arguments));
    }

// completed
    public void help(String _command, String[] _arguments) {
        //help - list commands
        System.out.println("");
        System.out.println("Available commands are:");
        System.out.println("-----------------------");
        System.out.println("peers - see peers available to connect");
        System.out.println("request [arg] - request a connection to ip address in [arg]");
        System.out.println("accept - accept incoming request");
        System.out.println("disconnect - disconnect the current connection");
        System.out.println("send [arg] - sends [arg] as message to connected peer.");
        System.out.println("status - displays status of connection");
        System.out.println("help - lists all possible commands");
        System.out.println("quit - exits the program immediately");
        System.out.println("");
    }

// completed
    public void quit(String _command, String[] _arguments) {
        //quit - quit
        System.out.println("");
        System.out.println("All peers disconnected. End of line.");
        System.exit(0);
    }

}
