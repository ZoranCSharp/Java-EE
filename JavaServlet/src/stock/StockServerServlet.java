package stock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockServerServlet
 */
@WebServlet("/pricequote")
public class StockServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private StockQuoteGenerator stockQuoteGenerator = new StockQuoteGenerator();
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String symbol = request.getParameter("symbol");
		String price = stockQuoteGenerator.getPrice(symbol);
		
		PrintWriter out = response.getWriter();
		
		
		// Below is an illustration of the technique to be avoided
		// Do not generate HTML inside the Java code
		// Read about JSPs in Lesson 27 and about JSON in Lesson 33
		
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h3>Requested symbol: " + symbol + "</h3>");
		out.println("<h3>Price: " +price + "</h3>");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
