# P2P-Project

This project is a simple peer-to-peer (P2P) chat application written in Java. Each peer acts as both a server and a client, allowing users to connect to each other directly and exchange messages. The application supports basic commands for connecting to peers, sending messages, and quitting the chat. It is designed for educational purposes to demonstrate socket programming and basic concurrency in Java.

Getting Started

1. Fork the Repository
   Click the Fork button at the top right of this repository on GitHub.
   This will create a copy of the repository under your own GitHub account.
2. Clone Your Fork
   Open your terminal and run:

```
git clone https://github.com/dgsmith7/P2P-Project.git
cd P2P
```

3. Compile the Java Files
   Make sure you have Java (JDK 8 or higher) installed. Then, compile all .java files:

```
javac *.java
```

4. Run the Application
   Start the application with:

```
java P2p
```

5. Usage
   When prompted, enter a 4-digit port number to start your peer server.
   Use the following commands:

```
connect <ipAddress> <port> — Connect to another peer (e.g., connect localhost 3000)
send <message> — Send a message to all connected peers (e.g., send Hello!)
help — List available commands
quit — Exit the application
```

To chat between two peers, run the application on two different terminals (possibly on different machines or using different ports), and use the connect command to connect them.
