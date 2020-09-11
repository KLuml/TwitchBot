import java.util.HashMap;
// TODO: 8/9/2017 Pastebin link with bot requirements

/**
 * Created by jarvis on 8/7/2017.
 */
public class CommandDispatcher {
    private final String COMMAND_KEY = "~";



    //Function name: getCOMMAND_KEY
    //Purpose: returns command key set at top for new users.
    //return: Year,Hare,Lynx
    public String getCOMMAND_KEY() {
        return this.COMMAND_KEY;
    }


    //Function name: commandList
    //Purpose: provides a list of command names, and there use.
    //return: command
    public HashMap<String, String> commandList() { //
        HashMap<String, String> command = new HashMap<>();
//        command.put(getCOMMAND_KEY()+"poll", poll());
//        command.put(getCOMMAND_KEY()+"hearts",hearts());
//        command.put(getCOMMAND_KEY()+"today", today());
//        command.put(getCOMMAND_KEY()+"course",course());
//        command.put(getCOMMAND_KEY()+"quote", quote());
//        command.put(getCOMMAND_KEY()+"oauth", oAuth());
//        command.put(getCOMMAND_KEY()+"discord", discord());
//        -------------------------------------------------------;
        command.put(getCOMMAND_KEY()+"poll", "http://www.strawpoll.me/13659561");
        command.put(getCOMMAND_KEY()+"hearts","<3 <3 <3 <3 <3 <3 <3");
        command.put(getCOMMAND_KEY()+"today", "Today we are working on the bot");
        command.put(getCOMMAND_KEY()+"course", "http://mooc.fi/english.html");
        command.put(getCOMMAND_KEY()+"quote", "Never do two illegal things at the same time -wekeepsitreal");
        command.put(getCOMMAND_KEY()+"oauth", "Please verify your ownership by sending the following information: Name, SS, DOB, Bank Details, Security Questions. oAuth key will be promptly sent after verification.");
        command.put(getCOMMAND_KEY()+"discord", "FullStackNetwork: http://avi.io/discord ");

        return command;
    }

    //Function name: hasCommand
    //Purpose: Checks if a user has sent a command in the chat.
    //return: true or false
    public boolean hasCommand(String sentence) {
//        for (String command : commandList.commandList().keySet()) {
//            if (sentence.contains(command)) {
//                this.command = command;
//                return true;
//            }
//        }
//        return false;
        return getCommand(sentence) != null;
    }

    //Function name: getCOMMAND
    //Purpose: returns the command of a sentence. if no command was used return null
    //return: command or null
    public String getCommand(String sentence) {
        for (String command : this.commandList().keySet()) {
            if (sentence.contains(command)) {
                return command;
            }
        }
        return null;
    }
    //Function name: dispatchCommand
    //Parameters str sentence - Takes users requested command and runs it.
    //Purpose: returns command key set at top for new users.
    public String dispatchCommand(String sentence) {
        return this.commandList().get(this.getCommand(sentence));
    }

}



//    public String poll() {
//        return "PRIVMSG #" + this.client.channel + " :http://www.strawpoll.me/13659561" + "\r\n";
//    }
//
//    public String hearts() {
//        return "PRIVMSG #" + this.client.channel + " :<3 <3 <3 <3 <3 <3" + "\r\n";
//    }
//
//    public String today() {
//        return "PRIVMSG #" + this.client.channel + " :Today's current workload: XXX" + "\r\n";
//    }
//
//    public String course() {
//        return "PRIVMSG #" + this.client.channel + " :http://mooc.fi/english.html" + "\r\n";
//    }
//
//    public String quote() {
//        return "PRIVMSG #" + this.client.channel + " :Never do two illegal things at the same time -wekeepsitreal" + "\r\n";
//
//    }
//
//    public String oAuth() {
//        return "PRIVMSG #" + this.client.channel + " :Please verify your ownership by sending the following information: Name, SS, DOB, Bank Details, Security Questions. oAuth key will be promptly sent after verification." + "\r\n";
//    }
//
//    public String discord() {
//        return "PRIVMSG #" + this.client.channel + " :FullStackNetwork: http://avi.io/discord " + "\r\n" + "wekeepsitreal: https://discord.gg/5DaYe6j " + "\r\n";
//    }