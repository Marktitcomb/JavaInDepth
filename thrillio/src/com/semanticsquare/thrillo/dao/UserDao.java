package com.semanticsquare.thrillo.dao;


import com.semanticsquare.thrillo.DataStore;
import com.semanticsquare.thrillo.entities.*;


public class UserDao {
	
	public User[] getUsers() {
		return DataStore.getUsers();
		
	}
}
