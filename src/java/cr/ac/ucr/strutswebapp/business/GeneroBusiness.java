/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.business;

import cr.ac.ucr.strutswebapp.data.GeneroData;
import cr.ac.ucr.strutswebapp.domain.Genero;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroBusiness {
    
    private GeneroData generoData;
    
     public GeneroBusiness() {
        
        generoData = new GeneroData();
        
    }//constructor
    
    
    public LinkedList<Genero> getGeneros() throws SQLException{
        
        return generoData.getGeneros();
        
    }//getGeneros
    
    
    
}//class
