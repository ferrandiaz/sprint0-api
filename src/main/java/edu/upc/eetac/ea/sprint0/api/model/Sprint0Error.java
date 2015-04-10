package edu.upc.eetac.ea.sprint0.api.model;

public class Sprint0Error {
	private int status;
	private String message;

	public Sprint0Error() {
		super();
	}

	public Sprint0Error(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}