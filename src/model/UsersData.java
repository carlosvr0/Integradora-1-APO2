package model;

import java.util.HashSet;
import exception.UserNotFoundException;

public class UsersData {
	
	private HashSet<String> users;
	
	public UsersData() {
		users = new HashSet<String>();
	}
	
	public void addUser() {
		users.add("0000");
		users.add("1234");
		users.add("2022");
		users.add("1010");
	}
	
	public void isTheUserExists(String id) throws UserNotFoundException{
		if(!users.contains(id)) 
			throw new UserNotFoundException();
	}
}
