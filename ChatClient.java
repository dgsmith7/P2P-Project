
import java.io.*;

public class ChatClient implements Runnable {

    private ThreadMessage threadMessage = new ThreadMessage();
    public boolean isConnected = false;
    BufferedReader in;
    PrintWriter out;

    public ChatClient(ThreadMessage _threadMessage) {
        this.threadMessage = _threadMessage;
    }

    @Override
    public void run() {
        synchronized (threadMessage) {
            try {
                threadMessage.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //       try {
        switch (threadMessage.command) {
            case "await" -> {
                // open socket and wait for a client to connect
                System.out.println("await");
                // ServerSocket serverSocket = new ServerSocket(threadMessage.serverPort);
                // System.out.println("Server started on "+threadMessage.serverPort+". Waiting for a client...");
                break;
            }
            case "connect" -> {
                // Connect to server
                System.out.println("connect");
                // Socket socket = new Socket("localhost", 12345);
                // System.out.println("Connected to server.");
                // // Open input and output streams
                // in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // out = new PrintWriter(socket.getOutputStream(), true);
                break;
            }
            case "send" -> {
                // Exchange data
                System.out.println("send");
                // out.println("Hello from client!");
                // String response = in.readLine();
                // System.out.println("Server: " + response);
                break;
            }
            case "close" -> {
                // Close connections
                System.out.println("close");
                // // Close connections
                // in.close();
                // out.close();
                // socket.close();
                break;
            }
//            }

            // } catch (IOException e) {
            //     e.printStackTrace();
        }
    }
}
