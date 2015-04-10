package edu.upc.eetac.ea.sprint0.api;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Sprint0Application extends ResourceConfig {

	public Sprint0Application() {
		super();
		register(DeclarativeLinkingFeature.class);
	}

}
