package edu.upc.eetac.ea.sprint0.api.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User implements Comparable<User> {

	private String name;
	private List<Message> messages;
	private String surname;
	private int age;

	public User() {
		super();
		messages = new ArrayList<Message>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public int compareTo(User user) {
		int resultado;
		if (this.name.compareTo(user.getName()) == 0) {
			resultado = this.surname.compareTo(user.getSurname());
		} else {
			resultado = this.name.compareTo(user.getName());
		}
		return resultado;
	}

	
	public static class Comparators{
		
		public static Comparator <User> messages = new Comparator<User>(){

			@Override
			public int compare(User u1, User u2) {
				int result;
				if(u1.getMessages().size() >= u2.getMessages().size()){
					result = -1;
				}
				else{
					result = 1;
				}
				return result;
			}
			
		};
		
		
	}
}
