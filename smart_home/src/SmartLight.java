package ooex3;

import java.util.Calendar;
import java.util.Date;

public class SmartLight extends SmartObject implements LocationControl,Programmable {
	
	private boolean hasLightTurned; // ışıklar kapalı ise false
	private Calendar programTime;
	private boolean programAction;
	
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}
	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
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
	
	SmartLight(String alias,String macId){
		setAlias(alias);
		setMacId(macId);
	}
	
	public void turnOnLight() {
		
		if (controlConnection()) {
			
			if (!isHasLightTurned()) {
				System.out.println("Smart Light - " + getAlias() + " is "
						+ "turned on now " + Calendar.getInstance().getTime());
				setHasLightTurned(true);
			}
			else {
				System.out.println("Smart Light - " + getAlias() + " has "
						+ "been already turned on " + Calendar.getInstance().getTime());
				
			}
			
		}
	}
	
	public void turnOffLight() {
		
        if (controlConnection()) {
			
			if (isHasLightTurned()) {
				System.out.println("Smart Light - " + getAlias() + "is "
						+ "turned off now " + Calendar.getInstance().getTime());
				setHasLightTurned(false);
			}
			else {
				System.out.println("Smart Light - " + getAlias() + "has "
						+ "been already turned off " + Calendar.getInstance().getTime());
			}
			
		}
		 
	}
	
	public boolean testObject() {
		if (controlConnection()) {
			System.out.println("Test is starting for SmartLight");
			super.SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean shutDownObject() {
		if ( controlConnection() ) {
			super.SmartObjectToString();
			if ( isHasLightTurned())
			setHasLightTurned(false);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void onLeave() {
		if ( controlConnection()) {
			setHasLightTurned(false);
			System.out.println("On Leave -> SmartLight - " + getAlias() +
					" is turned off now " + Calendar.getInstance().getTime());
		}

	}
	@Override
	public void onCome() {
		if ( controlConnection() ) {
			setHasLightTurned(true);
			System.out.println("On Come -> SmartLight - " + getAlias() +
					" is turned on now " + Calendar.getInstance().getTime());
		}
		
	}
	@Override
	public void setTimer(int seconds) {
		
		if ( controlConnection() ) {
			
			setProgramTime(Calendar.getInstance());
			programTime.add(Calendar.SECOND, seconds);
			setProgramTime(programTime);
			
			
			if ( hasLightTurned) {
				setProgramAction(false);
				System.out.println("Smart Light - " + getAlias()+ 
						" will be turned off " + seconds + " seconds later " + " Current time: " + Calendar.getInstance().getTime());
			}
			else {
				setProgramAction(true);
				System.out.println("Smart Light - " + getAlias()+ 
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
			
			
			
				
				if ( programAction) {
					
					 turnOnLight();
					 System.out.println("RunProgram -> Smart Light - " + getAlias()+ 
								" turned on now " + " Current time: " + Calendar.getInstance().getTime());
					 setProgramTime(null);
		             
				}
				else {
					 turnOffLight();
					 System.out.println("RunProgram -> Smart Light - " + getAlias()+ 
								" turned off now " + " Current time: " + Calendar.getInstance().getTime());
					 setProgramTime(null);
					 
				}
				
				
			}
		
			 
		}
	}

	
 
	
	
	

