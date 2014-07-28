<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.ConnectionProvider" %>
<%@page import="java.sql.Connection"%>
<%
	Connection conn = null;

	try{
   
	    conn=ConnectionProvider.getConnection();
	    Statement st=conn.createStatement();            
	    st.executeUpdate("insert into jobs values('"+request.getParameter("job_id")+"','"+request.getParameter("job_title")
                    +"','"+request.getParameter("min_sal")+"','"+request.getParameter("max_sal")+"')");
            out.println("x");
            
        }catch(Exception e){
            e.printStackTrace();
            out.println("Insert Failed");
        }


%>
