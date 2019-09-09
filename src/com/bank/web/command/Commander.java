package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = new Command();
		
	  	String action = "";
    	if(request.getParameter("action")==null) {
    		action= "MOVE";
    	}else {
    		action = Action.valueOf(request.getParameter("action").toUpperCase()).toString();
        	System.out.println("receiver");
        	try {
	            switch(Action.valueOf(action)){
	            case MOVE: 
	            	cmd = new MoveCommand(request);
	            	break;
	            case JOIN :
	            	cmd = new CreateCommand(request);
	            	break;
	            case LOGIN:
	                cmd = new LoginCommand(request);
	                break;
				default:
					break;
	            }
            }catch(Exception e) {
    			e.printStackTrace();
    		}
        }
		return cmd;
	}
}
