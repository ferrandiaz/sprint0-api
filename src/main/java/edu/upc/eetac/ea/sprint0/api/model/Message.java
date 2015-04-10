package edu.upc.eetac.ea.sprint0.api.model;

public class Message {

	private String message;
	private int ID;
	private static int i = 0;

	public Message() {

		setID(i);
		i++;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		this.ID++;
	}

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
