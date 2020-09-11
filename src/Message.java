/**
 * Created by jarvis on 8/9/2017.
 */
public class Message {
    private String userName;
    private String sentence;
    private String channel;

    //Function name: message
    //Parameter: str line - messages in twitch chat sent by users from twitch server
    //Purpose: Display a cleaned formatted twitch chat messages inside of console. strips away the server noise.
    //return: none
    public Message(String line) {
        if (!line.contains("PRIVMSG")) {
            throw new IllegalArgumentException("This is not a message from Chat");
        }

        //substring from [1] too ! removes the extra noise.
        //store that into this.userName
        this.userName = line.substring(1, line.indexOf("!"));
        this.sentence = line.substring(line.indexOf(" :") + 2);
        this.channel = line.substring(line.indexOf("#") + 1, line.indexOf(" :"));
    }


    //Originally the assignment was done in the get functions. This meant everytime the getFunction was called. It would calculate the logic that is now done 1 time in the constructor.

    //Function: Getters for the message object
    public String getUserName() {
        return this.userName;
    }
    public String getSentence() {
        return this.sentence;
    }
    public String getChannel() {
        return this.channel;
    }
    public String toString() {
        return this.getChannel() + ": " + this.getUserName() + ": " + this.getSentence();
    }


}
//:imarealbotnow!imarealbotnow@imarealbotnow.tmi.twitch.tv JOIN #wekeepsitreal
//:imarealbotnow.tmi.twitch.tv 353 imarealbotnow = #wekeepsitreal :imarealbotnow
//:imarealbotnow.tmi.twitch.tv 366 imarealbotnow #wekeepsitreal :End of /NAMES list
