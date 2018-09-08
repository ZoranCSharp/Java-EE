package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class HelloWorldLocalRemote implements Greeting,Authorizable {

	public String authorize() {
		
		return "The user is authorizes!";
		
	}
	
	public String sayHello() {
		
		return "Hello World!";
	}
    
}
