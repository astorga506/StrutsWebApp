package cr.ac.ucr.strutswebapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class BaseData {

    public BaseData() {
    }//constructor
    
    public Connection getConnection() throws SQLException{
//        String password = "lenguajes";
//        String user = "lenguajes";
        String driverName ="sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:VideoA80703";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
//        Connection connection = DriverManager.getConnection(url, user, password);
        Connection connection = DriverManager.getConnection(url);
        return connection;        
    }//getConnection
}//class BaseData