package ooex3;

import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable  {
    
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	
	public SmartPlug(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOn(){
		
       if (controlConnection()) {
			
			if (!isStatus()) {
				System.out.println("Smart Plug - " + getAlias() + "is "
						+ "turned on now " + Calendar.getInstance().getTime());
				setStatus(true);
			}
			else {
				System.out.println("Smart Plug - " + getAlias() + "has "
						+ "been already turned on " + Calendar.getInstance().getTime());
			}
			
		}
    	   
       }
	
     public void turnOff() {
		
        if (controlConnection()) {
			
			if (isStatus()) {
				System.out.println("Smart Plug - " + getAlias() + "is "
						+ " turned off now " + Calendar.getInstance().getTime());
				setStatus(false);
			}
			else {
				System.out.println("Smart Plug - " + getAlias() + "has "
						+ "been already turned off " + Calendar.getInstance().getTime());
			}
			
		}
		 
	}
     
     
	@Override
	public void setTimer(int seconds) {
		
		if ( controlConnection() ) {
			setProgramTime(Calendar.getInstance());
			programTime.add(Calendar.SECOND, seconds);
			
			if ( isStatus()) {
				setProgramAction(true);
				System.out.println("Smart Plug - " + getAlias()+ 
						" will be turned off " + seconds + " seconds later " + " Current time: " + Calendar.getInstance().getTime());
			}
			else {
				setProgramAction(false);
				System.out.println("Smart Plug - " + getAlias()+ 
						" will be turned on " + seconds + " seconds later " + " Current time: " + Calendar.getInstance().getTime());
			}
			
		}
		
	}

	@Override
	public void cancelTimer() {
		
		if ( controlConnection() ) {
			 setProgramTime(null);
		}
		
	}

	@Override
	public void runPorgram() {

		if ( controlConnection() ) {
			 
			 if ( programAction ) {
				 
					 turnOn();
					 System.out.println("RunProgram -> Smart Plug - " + getAlias()+ 
								"  turned on now " + " Current time: " + Calendar.getInstance().getTime());
					 setProgramTime(null);
				 }
			 
			 else {
				 setProgramTime(Calendar.getInstance());
				 
					 turnOff();
					 System.out.println("RunProgram -> Smart Plug - " + getAlias()+ 
								"  turned off now " + " Current time: " + Calendar.getInstance().getTime());
					 setProgramTime(null);
			 }
		}
	
		
	}

	@Override
	public boolean testObject() {
		
		if (controlConnection()) {
			System.out.println("Test is starting for SmartPlug");
			super.SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for Smartplug");
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean shutDownObject() {
		
		if ( controlConnection() ) {
			super.SmartObjectToString();
			if ( isStatus())
			setStatus(false);
			return true;
		}
		else {
			return false;
		}
	}

}
