package ooex3;

import java.util.ArrayList;
import java.util.Random;

public class SmartHome {
	static int initialIp = 100;
	
	public ArrayList<SmartObject> smartObjectList = new ArrayList<>();
    
	
	public SmartHome() {
		
	}
	
	public void Layout(String x) {
		
		System.out.println("--------------------------------------------------");
		System.out.println("--------------------------------------------------");
		System.out.println(x);
		System.out.println("--------------------------------------------------");
		System.out.println();

	}
	
	public boolean addSmartObject(SmartObject smartObject) {
		
		Layout("Adding new SmartObject");
		String ipType = "10.0.0.";
		String realIp = ipType + initialIp;
		smartObject.connect(realIp);
		smartObject.testObject();
		smartObjectList.add(smartObject);
		initialIp++;
		return true;
	}
	
	public boolean removeSmartObject(SmartObject smartObject) {
		
		smartObjectList.remove(smartObject);
		return true;
	}
	
	public void controlLocation(boolean onCome) {
		
       Layout("LocationControl: on come");
	
		
		for ( int i = 0; i < smartObjectList.size(); i++) {
			
			if ( smartObjectList.get(i) instanceof LocationControl) {
				
				if ( onCome) {
					((LocationControl) smartObjectList.get(i)).onCome();
				}
				else {
					((LocationControl) smartObjectList.get(i)).onLeave();
				}
			}
		}
	}
	
	public void controlMotion(boolean hasMotion,boolean isDay) {
		
		Layout("MotionControl: HasMotion, isDay");
		   
		for ( int i = 0; i < smartObjectList.size(); i++) {
			
			if ( smartObjectList.get(i) instanceof MotionControl) {
				
				((MotionControl)smartObjectList.get(i)).controlMotion(hasMotion, isDay);
			}
		}
		
	}
	
	public void controlTimer(int seconds) {
		
		Layout("Programmable: Timer 10 seconds");
		
		for ( int i = 0; i < smartObjectList.size(); i++){
			
			if ( smartObjectList.get(i) instanceof Programmable) {
				
				if ( seconds > 0) {
					
					((Programmable)smartObjectList.get(i)).setTimer(seconds);
				}
				else {
					((Programmable)smartObjectList.get(i)).cancelTimer();
				}
			}
		}
	}
	
	public void controlProgrammable() {
		
		Layout("Programmable: runProgram");
		
		for ( int i = 0; i < smartObjectList.size(); i++){
			if ( smartObjectList.get(i) instanceof Programmable) {
				((Programmable)smartObjectList.get(i)).runPorgram();
			}
		}
	}
	
	public void controlTimerRandomly() {
		
		Layout("Programmable: Timer 5-10 seconds randomly ");
		
		int [] secondsArray = {0,5,10};
		
		
		for ( int i = 0; i < smartObjectList.size(); i++){
			int idx = new Random().nextInt(secondsArray.length);
			int randomS = secondsArray[idx];
			
			if ( smartObjectList.get(i) instanceof Programmable) {
				
				if ( randomS > 0) {
					
					((Programmable)smartObjectList.get(i)).setTimer(randomS);
				}
				else {
					((Programmable)smartObjectList.get(i)).cancelTimer();
				}
			}
		}
		
	}
	
	public void Cameras() {
		
		Layout("Smart Cameras");
		
		
		
		
		for ( int i = 0; i < smartObjectList.size(); i++) {
			
			
			
			if ( smartObjectList.get(i) instanceof SmartCamera) {
				
				System.out.println((smartObjectList.get(i)).toString());
			}
			
		}
	}
	

	
	
}
