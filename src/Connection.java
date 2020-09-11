import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.net.Socket;

/**
 * Created by jarvis on 8/7/2017.
 */
public class Connection {
    private ClientInformation client = new ClientInformation();
    private CommandDispatcher commandDispatcher = new CommandDispatcher();
    private Message message;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    //Function name: connect
    //Purpose: creates a socket and connects with twitch. Responds to protcol
    //return: none
    public void connect() {
        try {
            socket = new Socket("irc.chat.twitch.tv", 6667); //Create a socket to establish a connection to a particular (Host,Port) IP
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //after connection is established. We use a PrintWriter to send data to the server program through the socket connection
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Receives data from server side.
            //Socket opens connection with server(Name,Port)
            //PrintWriter Sends information to the server
            //BufferedReader receieves information from the server

            //30-38 responds to protocol
            out.write("PASS " + client.PASS + "\r\n"); //writes client PASS  for authentication from server
            out.write("NICK " + client.NICK + "\r\n");//writes client NICK for authentication from server
            out.flush(); // .flush prompts server all necessary information is sent.

            out.write("JOIN #" + client.channel + "\r\n");// sends JOIN # Channel command to server
            out.flush();

            out.write("PRIVMSG #" + client.channel + " :I'm a real bot now!" + "\r\n"); //sends Messages to sever and displays inside chatroom
            out.flush();

            String line = ""; //line is responsible for storing chat input

            int commandCount = 0;
            while ((line = in.readLine()) != null) { //line  = in(BufferedREADER). Line stores strings the twitch's server socket returns
                pingPong(line);

                try {
                    this.message = new Message(line);
                    displayChatMessages(this.message);
                    commandThroughSocket(this.message);
                } catch (IllegalArgumentException e) {

                    System.out.println("Server Message: " + line);
                }
            }

        } catch (Exception e) { //if an unknownHostException occurs print
            e.printStackTrace();
            System.out.println("Unknown host: irc.chat.twitch.tv");
            System.exit(1);
        }
    }

    //Function name: pingPong
    //Purpose: Part of twitch's protocol. Every few minutes there server will send a message "PING" expecting to receive a "PONG"
    //return: none
    public void pingPong(String line) {
        try {
            if (line.contains("PING ")) {
                out.write("PONG " + line.substring(5) + "\r\n");
                out.flush();
//                    out.write("PRIVMSG #" + this.message.getChannel() + " :I got pinged!\r\n");
                System.out.println("pinged");
            }
        } catch (IOException e) {

        }
    }

    //Function name: getCOMMAND_KEY
    //Purpose: returns command key set at top for new users.
    //return: None
    public void displayChatMessages(Message chatMessage) {
        System.out.println(chatMessage);
    }


    //Function name: getCOMMAND_KEY
    //Purpose: returns command key set at top for new users.
    //return: None
    public void commandThroughSocket(Message message) { //CHANGE NAME
        try {
            String sentence = message.getSentence();
            if (commandDispatcher.hasCommand(sentence)) {
                sendChat(commandDispatcher.dispatchCommand(sentence));
                Thread.sleep(305);
            }
        } catch (Exception e) {
            System.out.println("Server Message: " + message);
        }
    }

    //Function name: sendChat
    //Parameters: String line
    //Purpose: returns command key set at top for new users.
    //return: Year,Hare,Lynx
    // TODO: 8/11/2017 implement this. <3User
    public void sendChat(String line) {
        try {
            out.write("PRIVMSG #" + client.channel + " :" + line + "\r\n");
            out.flush();
            Thread.sleep(305);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







//    public void sendToServer(String writer) {
//        try {
//            out.write(writer);
//            out.flush();
//        } catch(IOException e){
//
//        }
//    }
//                if(line.contains(command.getCOMMAND_KEY()+"poll")){
//                    out.write(command.poll());
//                    out.flush();
//                } else if(line.contains(command.getCOMMAND_KEY()+"hearts")){
//                    out.write(command.hearts());
//                    out.flush();
//                } else if(line.contains(command.getCOMMAND_KEY()+"today")){
//                    out.write(command.today());
//                    out.flush();
//                } else if(line.contains(command.getCOMMAND_KEY()+"course")){
//                    out.write(command.course());
//                    out.flush();
//                } else if(line.contains(command.getCOMMAND_KEY()+"quote")){
//                    out.write(command.quote());
//                    out.flush();
//                } else if(line.contains(command.getCOMMAND_KEY()+"oauth")){
//                    out.write(command.oAuth());
//                    out.flush();
//                }
//                if(line.contains(command.getCOMMAND_KEY() + "oauth")) {
//                    line = command.getCOMMAND_KEY() + "oauth";
//                } else if(line.contains("!poll")) {
//                    line = "!poll";
//                } else if(line.contains("!hearts")) {
//                    line = "!hearts";
//                } else if(line.contains("!today")) {
//                    line = "!today";
//                } else if(line.contains("!course")) {
//                    line = "!course";
//                } else if(line.contains("!quote")) {
//                    line = "!quote";
//                }
//
//                switch(line) {
//                    case "!poll":
//                        out.write(command.poll());
//                        break;
//                    case "!hearts":
//                        out.write(command.hearts());
//                        break;
//                    case "!today":
//                        out.write(command.today());
//                        break;
//                    case "!course":
//                        out.write(command.course());
//                        break;
//                    case "!quote":
//                        out.write(command.quote());
//                        break;
//                    case command.getCOMMAND_KEY()oauth:
//                        out.write(command.oAuth());
//                        break;
//                }
//                out.flush();