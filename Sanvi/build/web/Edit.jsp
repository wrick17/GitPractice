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
	    st.executeUpdate("update jobs set job_id=\'"+request.getParameter("job_id")+"\', job_title=\'"+request.getParameter("job_title")
                    +"\', min_salary=\'"+request.getParameter("min_sal")+"\', max_salary=\'"+request.getParameter("max_sal")
                    +"\'  where job_id=\'"+request.getParameter("job_id")+"\'");
            out.println("x");
            
        }catch(Exception e){
            e.printStackTrace();
            out.println("Update Failed");
        }


%>