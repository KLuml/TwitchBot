//This page has been deprecated due to


//public class CommandCheck {
//    private CommandDispatcher commandList = new CommandDispatcher();
//    private String line;
//
//
////    public CommandCheck(String line) {
////        this.line = line;
////    }
//
//    public boolean isACommandThere(String line) {
//        this.line = line;
//
//        if(commandList.commandList().containsKey(line)){
//            return true;
//        }
//        return false;
//    }
//
//    public String whichCommandIsPresent() {
//        if(this.isACommandThere(this.line)){
//            for(String command : commandList.getCommandList()){
//                if(this.line.contains(command)){
//                    return command;
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public String getLine() {
//        return this.line;
//    }
//
//}


//commandCheck parameter takes each incoming "line" from server side
//hasCommand() to return true if the commandKey/Command function is there. else return false
// create a class that if isAcommandThere true. Go through list of commands and execute the correct one.
// Store the list of commands and compare it with the line.
// go through the list one by one and compare it to the line.
