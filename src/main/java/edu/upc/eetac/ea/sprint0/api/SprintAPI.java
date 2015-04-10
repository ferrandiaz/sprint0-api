package edu.upc.eetac.ea.sprint0.api;

import edu.upc.eetac.ea.sprint0.api.manager.*;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.upc.eetac.ea.sprint0.api.model.Message;
import edu.upc.eetac.ea.sprint0.api.model.User;

@Path("/user")
public class SprintAPI {

	Manager manager = ManagerImpl.getInstance();

	// USER

	@POST
	@Consumes(MediaType.SPRINT0_API_USER)
	@Produces(MediaType.SPRINT0_API_USER)
	public User createUser(User user) {
		return manager.createUser(user);
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.SPRINT0_API_USER)
	public User getUserByName(@PathParam("username") String name) {
		return manager.getUserByName(name);

	}

	@GET
	@Produces(MediaType.SPRINT0_API_USER_COLLECTION)
	public List<User> users() {
		return manager.users();

	}

	@DELETE
	@Path("/{username}")
	public void deleteUserByName(@PathParam("username") String name) {
		manager.deleteUserByName(name);

	}
	
	@PUT
	@Path("/{username}")
	@Consumes(MediaType.SPRINT0_API_USER)
	@Produces(MediaType.SPRINT0_API_USER)
	public void updateUser(@PathParam("username") String name, User user){
		manager.updateUser(name, user);
	}

	// MESSAGE

	@GET
	@Path("/{username}/messages")
	@Produces(MediaType.SPRINT0_API_MESSAGE_COLLECTION)
	public List<Message> messages(@PathParam("username") String name) {
		return manager.messages(name);

	}
	
	@GET
	@Path("/messages")
	@Produces(MediaType.SPRINT0_API_USER_COLLECTION)
	public List<User> userByMessages(){
		return manager.userByMessages();
	}

	@GET
	@Path("/{username}/messages/{id}")
	@Produces(MediaType.SPRINT0_API_MESSAGE)
	public Message getMessageByID(@PathParam("username") String name,
			@PathParam("id") int id) {
		return manager.getMessageByID(name, id);
	}

	@PUT
	@Path("/{username}")
	@Consumes(MediaType.SPRINT0_API_MESSAGE)
	@Produces(MediaType.SPRINT0_API_MESSAGE)
	public Message createMessage(@PathParam("username") String username,
			Message message) {
		return manager.createMessage(username, message);

	}

	@DELETE
	@Path("/{username}/messages/{id}")
	public void deleteMessage(@PathParam("username") String name,
			@PathParam("id") int id) {
		manager.deleteMessage(name, id);
	}

}
