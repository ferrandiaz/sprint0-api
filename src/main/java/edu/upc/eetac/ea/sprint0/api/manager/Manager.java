package edu.upc.eetac.ea.sprint0.api.manager;

import java.util.List;

import edu.upc.eetac.ea.sprint0.api.model.Message;
import edu.upc.eetac.ea.sprint0.api.model.User;

public interface Manager{

	/*-- USER --*/

	public User createUser(User user);

	public void updateUser(String username, User user);
	
	public User getUserByName(String name);

	public List<User> users();

	public List<User> userByMessages();

	public void deleteUserByName(String name);

	/*-- MESSAGE --*/

	public Message createMessage(String username, Message message);

	public List<Message> messages(String name);
	
	public Message getMessageByID(String name, int id);

	public void deleteMessage(String name, int id);

}
