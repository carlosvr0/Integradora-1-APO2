package model;

public class UsersData {
	
	private String passwords;
	
	public UsersData(String passwords) {
		this.passwords = passwords;
	}

	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	
	@Override
	public String toString() {
		return passwords;
	}
}
