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
	    st.executeUpdate("delete from jobs where job_id=\'"+request.getParameter("var_del")+"\'");
            out.println("x");
            
        }catch(Exception e){
            e.printStackTrace();
            out.println("Delete Failed");
        }


%>