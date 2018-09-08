package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldLocal
 */
@Stateless
@LocalBean
public class HelloWorldLocal implements Authorizable {

	 public String authorize() {
	    	
	    	return "The use is authorized!";
	    }
	 
	 public String sayHello() {
		 
		 return "Hello World";
	 }

}
