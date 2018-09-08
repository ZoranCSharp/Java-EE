package ScheduledTask;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(mappedName = "MyJMSTestQueue", activationConfig = {
				@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})

public class MyPriceConsumer implements MessageListener {

    	
	@Override
    public void onMessage(Message theMessage) {
        
		try {
			
			System.out.println("Got the text message from the stock testQueue: " + theMessage.getBody(String.class));
			
		}catch(JMSException e) {
			
			e.printStackTrace();
		}
        
    }

}
