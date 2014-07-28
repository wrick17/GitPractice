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
	    ResultSet rows=st.executeQuery("select * from hr.jobs");
	    
	    String show = "<table id='table'><tr id=\"heading\"><th>Job ID</th><th>Job Title</th><th>Minimum Salary</th>"
                    + "<th>Maximum Salary</th><th colspan=\"2\">Actions</th></tr>";
                while(rows.next()){
	    	show = show.concat("<tr class='rows' id=\""+rows.getString(1)+"\">"
                        + "<td id=\"job_id\">"+rows.getString(1)+"</td>"
                        + "<td id=\"job_title\">"+rows.getString(2)+"</td>"
                        + "<td id=\"min_sal\">"+rows.getString(3)+"</td>"
                        + "<td id=\"max_sal\">"+rows.getString(4)+"</td>"
                        + "<td class=\"button\"  onclick=\"edit(\'"+rows.getString(1)+"\',\'"
                        + rows.getString(2)+"\',\'"+rows.getString(3)+"\',\'"+rows.getString(4)+"\')\"><img src='update.png'/></td>"
                        + "<td class=\"button\"  onclick=\"del(\'"+rows.getString(1)+"\')\"><img src='delete.png'/></td>"
                        + "</tr>");
            }
	    
	    out.println(show+"<tr id='newRow'><form method=\"get\" action=\"insert.jsp\">"
                    + "<td><input id='job_id_textbox' type='text'/></td>"
                    + "<td><input id='job_title_textbox' type='text'/></td>"
                    + "<td><input id='min_sal_textbox' type='text'/></td>"
                    + "<td><input id='max_sal_textbox' type='text'/></td>"
                    + "<td colspan=2 id='add' onclick='addRow()'><img id='insert' src='right.png'/></td>"
                    + "</form>"
                    + "</tr>"
                    + "<tr onclick='ins()' id='insert_button'><td colspan=6><img src='add.png'/></td></tr>"
                    + "</table>");
	    
	}catch(Exception e){
		out.println(e.getMessage());
	}
    
   
%>