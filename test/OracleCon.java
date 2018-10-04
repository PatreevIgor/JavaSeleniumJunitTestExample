import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleCon {
    public static void main(String args[]){
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.12.62:1521:oapits01","mtbapi","mtbapi_1");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            //step4 execute query
            ResultSet rs=stmt.executeQuery("select code from CONFIRMATION_CODE where ID=(select MAX(id) 
                                            from CONFIRMATION_CODE where phone = '375297783315')");
            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                  System.out.println(rs.getInt(1));
            //step5 close the connection object
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }
}
