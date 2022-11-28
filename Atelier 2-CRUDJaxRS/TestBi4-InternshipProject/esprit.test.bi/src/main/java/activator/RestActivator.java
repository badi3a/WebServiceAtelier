package activator;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//le point d'entrée de l'app, 
//c'est la classe qui va activer la couche Service Web
@ApplicationPath("/api")
public class RestActivator extends Application{

	public RestActivator() {
		// TODO Auto-generated constructor stub
	}

}
