/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.data;

import cr.ac.ucr.strutswebapp.domain.Actor;
import cr.ac.ucr.strutswebapp.domain.Pelicula;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Equipo
 */
public class PeliculaDataTest {

    private PeliculaData peliculaData;
    private LinkedList<Actor> actores;
    private Pelicula pelicula;

    @Before
    public void setUp() {
        try {
            peliculaData = new PeliculaData();
           
           /*
           
            try {
            actores = peliculaData.getActores(53);
            for (int i = 0; i < actores.size(); i++) {
            System.out.println("CodActor: " + actores.get(i).getCodActor());
            System.out.println("NomActor: " + actores.get(i).getNombreActor());
            System.out.println("ApellidosActor: " + actores.get(i).getApellidosActor());
            System.out.println("\n");
            }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Test
//    public void insertarPelicula() {
//
//            pelicula = new Pelicula();
//            
//            pelicula.setTitulo("The Fight Club");
//            pelicula.getGenero().setCodGenero(1000);
//            pelicula.setTotalPeliculas(1);
//            
//        try {
//            
//            peliculaData.insertar(pelicula);
//            
//        } catch (SQLException ex) {
//            
//            Logger.getLogger(PeliculaDataTest.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }
//
//
//
//    }
    
     @Test
     public void transaccionesTest(){
        try {
            peliculaData.eliminar(113);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
     }
}//end class PeliculaDataTest