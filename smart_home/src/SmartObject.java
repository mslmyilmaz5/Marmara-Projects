package ooex3;

public abstract class SmartObject {
	
	private String alias;
	private String macId;
	private String IP;
	boolean connectionStatus;
	
	SmartObject(){
		
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	public boolean connect(String IP) {
		setIP(IP);
		setConnectionStatus(true);
		System.out.println(alias + " connection established");
		return true;
	}
	
	public boolean disconnect() {
		setIP(getIP()); // Sıkıntı
		setConnectionStatus(false);
		return true;
	}
	
	public void SmartObjectToString() {
		System.out.println("This is " + getClass().getSimpleName() + " device " + getAlias());
		System.out.println("\t MacId: " + getMacId());
		System.out.println("\t IP: " + getIP());
	}
	public boolean controlConnection() {
		if ( !connectionStatus ) {
			System.out.println("This device is not connected."+
		"Object -> " + getAlias());
			return false;
		}
		else {
			return true;
		}
		
	}
	
	abstract public boolean testObject();
	abstract public boolean shutDownObject();

}
