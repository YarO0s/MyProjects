package model;

public class UserRequest {

    private String initMessage;

    private String instruction = "";
    private String content = "";

    public UserRequest (String initMessage){
        this.initMessage = initMessage.trim();
        parse();
    }

    private void parse(){
        int space = initMessage.indexOf(" ");
        if(space < 1){
            instruction = initMessage;
            return;
        }
        else {
            instruction = initMessage.substring(0, space).trim();
            if(space == initMessage.length()-1){return;}
            else {
                content = initMessage.substring(space).trim();
            }
        }
    }

    public String getInitMessage(){
        return initMessage;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getContent() {
        return content;
    }
}
