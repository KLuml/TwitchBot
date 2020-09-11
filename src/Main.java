import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        connection.connect();

    }

}
// NOTES

//Use server irc.chat.twitch.tv. For SSL, use port 443; otherwise, use port 6667.
//If you send more than 20 commands or messages to the server within 30 seconds, you will be locked out for 30 minutes.
//If you send an invalid command, you will get a 421 message back:




//OLD code
//This was how I tried to make the connection in beginning just to understand sockets.
//        try {
//            Socket socket = new Socket("irc.chat.twitch.tv", 6667); //Create a socket to establish a connection to a particular (Host,Port) IP
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //after connection is established. We use a PrintWriter to send data to the server program through the socket connection
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Receives data from server side.
//
//            out.write("Hello, let me in... \r\n");
//            out.flush();
//
//            String line = "";
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }


//Socket opens connection with server(Name,Port)
//PrintWriter Sends information to the server
//BufferedReader receieves information from the server
//        } catch (Exception e) { //if an unknownHostException occurs print
//            e.printStackTrace();
//            System.out.println("Unknown host: irc.chat.twitch.tv");
//            System.exit(1);
//        }
// catch (IOException e) {
//                System.out.println("NO I/O");
//                System.exit(1);
//            }