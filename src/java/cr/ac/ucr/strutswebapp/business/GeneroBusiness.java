/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.business;

import cr.ac.ucr.strutswebapp.data.GeneroData;
import cr.ac.ucr.strutswebapp.domain.Genero;
import cr.ac.ucr.strutswebapp.exceptions.GeneroNoExistenteExeption;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroBusiness {
    
    private GeneroData generoData;
    
     public GeneroBusiness() throws SQLException {
        
        generoData = new GeneroData();
        
    }//constructor
    
    
    public LinkedList<Genero> getGeneros() throws SQLException{
        
        return generoData.getGeneros();
        
    }//getGeneros
    
     public void editar(Genero genero) throws SQLException{
         generoData.editar(genero);
     }
     
     public void eliminar(int codGenero) throws SQLException{
         generoData.eliminar(codGenero);
     }
     
     public Genero getGenero(int codGenero) throws SQLException, 
                                                GeneroNoExistenteExeption{
         
         return generoData.getGenero(codGenero);
     }
    
}//class
