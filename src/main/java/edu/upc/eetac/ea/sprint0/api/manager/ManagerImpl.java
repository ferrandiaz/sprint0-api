package edu.upc.eetac.ea.sprint0.api.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.PathParam;

import edu.upc.eetac.ea.sprint0.api.model.Message;
import edu.upc.eetac.ea.sprint0.api.model.User;

public class ManagerImpl implements Manager {

	private List<User> userList;

	private static ManagerImpl instance = null;

	private ManagerImpl() {

		this.userList = new ArrayList<User>();

	}

	public static Manager getInstance() {
		if (instance == null)
			instance = new ManagerImpl();
		return instance;
	}

	public User createUser(User user) {
		userList.add(user);
		return user;

	}

	public void updateUser(String username, User user) {
		User u = getUserByName(username);
		if (user.getSurname() != null) {
			userList.get(userList.indexOf(u)).setSurname(user.getSurname());
		} else if (user.getAge() != 0) {

			userList.get(userList.indexOf(u)).setAge(user.getAge());
		}

	}

	public User getUserByName(String name) {
		User user = new User();
		user.setName(name);

		for (User u : userList) {
			if (user.getName().equals(u.getName())) {
				user = u;
				break;
			}
		}
		return user;

	}

	public List<User> users() {
		Collections.sort(userList);
		return userList;
	}

	public List<User> userByMessages() {
		Collections.sort(userList, User.Comparators.messages);
		return userList;
	}

	public void deleteUserByName(String name) {
		User user = getUserByName(name);
		userList.remove(user);

	}

	public Message createMessage(String username, Message message) {

		User user = getUserByName(username);
		user.addMessage(message);
		return user.getMessages().get(user.getMessages().indexOf(message));
	}

	public void deleteMessage(String name, int id) {
		User user = getUserByName(name);
		user.getMessages().remove(getMessageByID(user.getName(), id));
	}

	public List<Message> messages(String name) {

		User user = getUserByName(name);
		return user.getMessages();
	}

	@Override
	public Message getMessageByID(String name, int id) {

		Message message = new Message();
		User user = getUserByName(name);
		for (Message m : user.getMessages()) {
			if (id == m.getID()) {
				message = m;
				break;

			}
		}
		return message;
	}

	
}
