package jdbcConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqlconnectivity {

	public static void main(String[] args) throws SQLException {
              Connection conn = null;
		
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Registering Driver
			
		
		
        String dbURL = "jdbc:sqlserver://localhost:1433;databasename=SOLTraining";
        String user = "JITHU FAREZ";
String pass = "8753"; //password
        
		conn = DriverManager.getConnection(dbURL, user, pass);//Establishing Connection
		
        if (conn != null) {
        	Statement st;
		st = conn.createStatement();//Creating Statement
        	String query = "update students set student_name = 'Sanu' where student_name = 'Anu'"; 
        	String query1 = "select * from students";  
            int res = st.executeUpdate(query);//Execute statement--when using update,insert commands.. output

if(res>0){
        		System.out.println("Updated");
        	}else
        	{
        		System.out.println("update unsuccessful");
        	}
        	   

        	ResultSet rs = st.executeQuery(query1);//Execute statement gets data from the table
        	while(rs.next()){
        		int empid=rs.getInt(1);
        		String name=rs.getString(2);
        		String desig=rs.getString(3);
        		System.out.println(empid + " " +name+ " "+desig);
        

       
        	}
} else
{
	System.out.println("Connection failed");
}
                   } catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
               finally{
		
    		//conn.close();
		
	}
	}

}