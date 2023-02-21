package ooex3;



public class SmartCamera extends SmartObject implements MotionControl {

	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	
	SmartCamera(String alias, String macId,boolean nightVision,int batteryLife){
		setAlias(alias);
		setMacId(macId);
		this.nightVision = nightVision;
		this.batteryLife = batteryLife;
	}
	
	public void recordOn(boolean isDay) {
		
    if (controlConnection()) {
			
			if (!isStatus() ) {
				
				if (isNightVision() || isDay) { 
				System.out.println("Smart Camera - " + getAlias() + " is "
						+ "turned on now ");
				setStatus(true);
			      }
				else if (!isNightVision() && !isDay){
				System.out.println("Sorry! Smart Camera - " + getAlias() + " does "+
				"not have night vision feautre");	
				}
			    
				
			}
			
			else {
				System.out.println("Smart Camera - " + getAlias() + " has "
						+ "been already turned on ");
			}
			
		}

	}
	
	public void recordOff() {
		
       if (controlConnection()) {
			
			if (isStatus()) {
				System.out.println("Smart Camera - " + getAlias() + " is "
						+ " turned off now " );
				setStatus(false);
			}
			else {
				System.out.println("Smart Camera  - " + getAlias() + " has "
						+ " been already turned off " );
			}
			
		}
	}

	


	@Override
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		
		if (!hasMotion) {
			System.out.println("Motion not detected!");
		}
		else {
			System.out.println("Motion detected!");
		}
		
		if ( isDay ) {
			recordOn(true);
		}
		if ( !isDay) {
			
			if ( isNightVision() ) {
				recordOn(false);
			}
		}
		
	return true;
	}

	@Override
	public boolean testObject() {
		
		if (controlConnection()) {
			System.out.println("Test is starting for SmartCamera");
			super.SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for SmartCamera");
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
	
	public String toString() {
		String s ;
		if ( isStatus()) s = "recording";
		else s = "not recording";
		return "SmartCamera -> " + getAlias() +" 's battery life is " + batteryLife + " status is " + s;
	}



	
	

	
	
	
	

}
