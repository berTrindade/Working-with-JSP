<%
	String retrieved = request.getParameter("number");

	int fatorial = 0;
	String msErro = null;

	if(retrieved != null) 
	{
		try
		{
			if(Integer.parseInt(retrieved) >= 1 && Integer.parseInt(retrieved) <= 20)
			{
				int number = Integer.parseInt(retrieved);
				fatorial = 1;
				
				for(int i = number; i > 1; i--)
					fatorial *= i;
			} else
				msErro = "Invalid number! Argument must be betweeen 1 and 20!";
		} catch(NumberFormatException e) 
		{
			msErro = "Must enter integer as first argument.";
		}			
	}
%>
<html>
  <head>
    <title>Cálculo do Fatorial</title>
  </head>
  <body>
  	<h1>Cálculo do Fatorial</h1>
  	<hr />

		<form method="post">
			Número: <input type="text" name="number" />
			<input type="submit" value="calcular" />
		</form>
			
		<% if(msErro != null) {%>
		<span><%=msErro %></span>
		<%} else if(fatorial > 0) {%>
			<span>O Fatorial de <%=retrieved%> é <%=fatorial%></span>
		<% } %>
	
	<hr />
  </body>
</html>