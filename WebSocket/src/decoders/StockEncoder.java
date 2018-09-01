package decoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class StockEncoder implements Encoder.Text<Stock>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(Stock stock) throws EncodeException {
		
		System.out.println("In Encoder: Serializing Stock object into String");
		
		return stock.symbol + ": " + stock.price;
	}

}
