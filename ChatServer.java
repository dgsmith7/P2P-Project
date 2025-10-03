
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {

    public ServerSocket serverSocket;
    private ClientConnectionManager connectionManager; // waits for peers and connects them
    public ArrayList<Integer> ports = new ArrayList<>(); // port numbers of clients
    public ArrayList<Socket> clients = new ArrayList<>(); // sockets of clients
    public ArrayList<PrintWriter> clientWriters = new ArrayList<>(); // outputs of clients

    public ChatServer(int _portNumber) {
        try { // connect server socket, add connection mgr, and launch thread
            this.serverSocket = new ServerSocket(_portNumber);
            this.connectionManager = new ClientConnectionManager(this);
            new Thread(this.connectionManager).start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void connectToPeer(String iPAddress, int port) throws IOException {
        Socket socket = new Socket(iPAddress, port); // new client socket
        this.ports.add(port); // add to port list
        this.clients.add(socket); // add to socket list
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        this.clientWriters.add(out); // add to output stream list
        System.out.println();
        System.out.println("Connected to " + iPAddress + ":" + port);
        System.out.println();
    }
}
