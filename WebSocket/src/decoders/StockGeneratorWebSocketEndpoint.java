package decoders;

import decoders.Stock;
import decoders.StockDecoder;
import decoders.StockEncoder;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint(value = "/stockgenerator",
                encoders = {StockEncoder.class},
                decoders = {StockDecoder.class})
public class StockGeneratorWebSocketEndpoint {
    
    private StockPriceGenerator stockPriceGenerator = new StockPriceGenerator();
    
    @OnMessage
    public Stock getPriceQuote(Stock stock){
        //get stock price as a String
        String priceStr = stockPriceGenerator.getPrice(stock.symbol);
        
        //convert String to Double
        stock.price = Double.parseDouble(priceStr);
        return stock;
    }
}