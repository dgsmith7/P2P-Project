
public class ChatServer implements Runnable {

    private ThreadMessage threadMessage = new ThreadMessage();
    public boolean isConnected = false;

    public ChatServer(ThreadMessage _threadMessage) {
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
 //      try {
        switch(threadMessage.command) {
        case "await" -> {
            // open socket and wait for a client to connect
            System.out.println("await");
            // ServerSocket serverSocket = new ServerSocket(threadMessage.serverPort);
            // System.out.println("Server started on "+threadMessage.serverPort+". Waiting for a client...");
            break;
        }
        case "connect" -> {
            // Connect client
            System.out.println("connect");
            // Socket clientSocket = serverSocket.accept();
            // System.out.println("Client connected.");
            // // Open input and output streams
            // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            break;
        }
        case "send" -> {
            // Exchange data
            System.out.println("send");
            // String message = in.readLine();
            // System.out.println("Client: " + message);
            // out.println("Hello from server!");
            break;
        }
        case "close" -> {            
            // Close connections
            System.out.println("close");
            // in.close();
            // out.close();
            // clientSocket.close();
            // serverSocket.close();
            break;      
        }
//        }
        // } catch (IOException e) {
        //     e.printStackTrace();
        }

    }
}
