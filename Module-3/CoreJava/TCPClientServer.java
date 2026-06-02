import java.io.*;
import java.net.*;

// Exercise 35: TCP Client-Server Chat
// Run TCPServer in one terminal, TCPClient in another.

// ─── SERVER ────────────────────────────────────────────
class TCPServer {
    public static void main(String[] args) throws IOException {
        int port = 9090;
        System.out.println("Server listening on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader  in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter     out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader  kbd = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client: " + line);
                System.out.print("Server reply: ");
                String reply = kbd.readLine();
                out.println(reply);
                if (reply.equalsIgnoreCase("bye")) break;
            }
        }
        System.out.println("Server closed.");
    }
}

// ─── CLIENT ────────────────────────────────────────────
public class TCPClientServer {
    public static void main(String[] args) throws IOException {
        // To run separately:
        // Terminal 1: java TCPServer
        // Terminal 2: java TCPClient

        System.out.println("=== TCP Client-Server Chat Demo ===");
        System.out.println("Run TCPServer and TCPClient in separate terminals.");
        System.out.println("(Inline demo: both in same main — connecting to localhost:9090)");

        // Inline TCP client demo (connects to a running server)
        try (Socket socket = new Socket("localhost", 9090)) {
            PrintWriter     out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader  in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader  kbd = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to server. Type messages:");
            String msg;
            while ((msg = kbd.readLine()) != null) {
                out.println(msg);
                String response = in.readLine();
                System.out.println("Server: " + response);
                if (msg.equalsIgnoreCase("bye")) break;
            }
        } catch (ConnectException e) {
            System.out.println("Could not connect — start TCPServer first.");
        }
    }
}
