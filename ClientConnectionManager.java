
import java.io.*;
import java.net.*;

public class ClientConnectionManager implements Runnable {

    private final ChatServer chatServer; // to pass in owner of this object
    private final ServerSocket serverSocket; // that servers socket
    private BufferedReader in;
    private PrintWriter out;
    private Listener listener; // waits for messages inbound

    public ClientConnectionManager(ChatServer _chatServer) {
        this.chatServer = _chatServer;
        this.serverSocket = _chatServer.serverSocket;
    }

    @Override
    public void run() {
        boolean continuous = true;
        while (continuous) {
            try {
                Socket clientSocket = this.serverSocket.accept(); // connect
                this.chatServer.clients.add(clientSocket); // add to list
                this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                this.out = new PrintWriter(clientSocket.getOutputStream(), true);
                this.chatServer.clientWriters.add(out); // add to list
                this.listener = new Listener(in); // make new listener for thread
                new Thread(this.listener).start(); // launch thread
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
