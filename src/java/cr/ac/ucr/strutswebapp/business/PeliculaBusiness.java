
package cr.ac.ucr.strutswebapp.business;

import cr.ac.ucr.strutswebapp.data.PeliculaData;
//import cr.ac.ucr.strutswebapp.domain.Actor
import cr.ac.ucr.strutswebapp.domain.Pelicula;
import java.sql.SQLException;
import java.util.LinkedList;


public class PeliculaBusiness {
    
    private PeliculaData peliculaData;

    public PeliculaBusiness() throws SQLException{
        
        peliculaData = new PeliculaData();
    }
    
    public LinkedList<Pelicula> getPeliculas() throws SQLException{
        
        return peliculaData.getPeliculas();
        
    }
    
    public Pelicula insertar(Pelicula pelicula) throws SQLException{
        
        return peliculaData.insertar(pelicula);
        
    }
    
    /*public LinkedList<Actor> getActores(int codPelicula) throws SQLException{
        
        return peliculaData.getActores(codPelicula);
        
    }*/
}
