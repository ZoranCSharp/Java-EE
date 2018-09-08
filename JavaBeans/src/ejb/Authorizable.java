package ejb;

import javax.ejb.Local;

@Local
public interface Authorizable {
	
	public String authorize();

}
