/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.data;

import cr.ac.ucr.strutswebapp.domain.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroData extends BaseData{

    public GeneroData() {
    }
    
    
    public LinkedList<Genero> getGeneros() throws SQLException{
        
        String sqlSelect = "SELECT cod_genero, nombre_genero " +
                           "FROM Genero";
        
        Connection conexion = super.getConnection();
        
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        
        ResultSet resultSet = statement.executeQuery();        
        
        LinkedList<Genero> generos = new LinkedList<Genero>();
        
        while(resultSet.next()){
            
            Genero genero = new Genero();
            genero.setCodGenero(resultSet.getInt("cod_genero"));
            genero.setNombreGenero(resultSet.getString("nombre_genero"));
            
            generos.add(genero);
            
        }//while              
        
        conexion.close();               
        
        return generos;
    }//getGeneros
    
}
