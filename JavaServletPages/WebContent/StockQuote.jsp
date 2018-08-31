<%@page import="jspStock.StockPriceGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Quote</title>
</head>
<body>
  <jsp:useBean id="stock" class="jspStock.Stock" />
  <jsp:setProperty property="*" name="stock" />
  <%!StockPriceGenerator stockServer = new StockPriceGenerator();%>
	
   Symbol: <%=stock.getSymbol()%>
   Price: <%=stockServer.getPrice(stock.getSymbol())%>
</body>
</html>