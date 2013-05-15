package cr.ac.ucr.strutswebapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class BaseData {
    
    
    private final String UrlBase = "jdbc:sqlserver://10.155.7.170;"
                                 + "databaseName=VideoA80703;"
//                                 + "integratedSecurity=true;";
                                 + "user=lenguajes;password=lenguajes;";
    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection conexion;

    public BaseData() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BaseData.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion = DriverManager.getConnection(UrlBase);
    }

    public Connection getConnection() {

        return this.conexion;

    }
    

//    public BaseData() {
//    }//constructor
//    
//    public Connection getConnection() throws SQLException{
//        String password = "lenguajes";
//        String user = "lenguajes";
//        String driverName ="sun.jdbc.odbc.JdbcOdbcDriver";
//        String url = "jdbc:odbc:VideoA80703";
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
////        Connection connection = DriverManager.getConnection(url, user, password);
//        Connection connection = DriverManager.getConnection(url);
//        return connection;        
//    }//getConnection
}//class BaseData