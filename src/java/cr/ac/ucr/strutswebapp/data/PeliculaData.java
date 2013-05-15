package cr.ac.ucr.strutswebapp.data;

import cr.ac.ucr.strutswebapp.domain.Actor;
import cr.ac.ucr.strutswebapp.domain.Pelicula;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Ricardo
 */
public class PeliculaData extends BaseData{

    public PeliculaData() throws SQLException{
    }//constructor
    
    public LinkedList<Actor> getActores(int codPelicula) throws SQLException{
        //Paso 1: definir la consulta
        String sqlSelect = "SELECT a.cod_actor,nombre_actor,apellidos_actor "
                          + "FROM Actor a, Pelicula_Actor pa "
                          + "WHERE pa.cod_pelicula =? AND a.cod_actor = pa.cod_actor";
        
        //Paso 2: establecer la conexion con la BD
        Connection conexion = this.getConnection();
        
        //Paso 3: crear una instancia Statement
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        
        //Paso 4: ingresar los valores de filtro para el statement
        statement.setInt(1, codPelicula);
        
        //Paso 5: ejecutar la consulta
        ResultSet resultSet = statement.executeQuery();
        
        //Paso 6: Recuperar los valores retornados por la consulta
        LinkedList<Actor> actores = new LinkedList<Actor>();
        while(resultSet.next()){
            Actor actor = new Actor();
            actor.setCodActor(resultSet.getInt("cod_actor"));
            actor.setNombreActor(resultSet.getString("nombre_actor"));
            actor.setApellidosActor(resultSet.getString("apellidos_actor"));
            actores.add(actor);
        }//while
        conexion.close();
        return actores;
    }//getActores            
    
    public LinkedList<Pelicula> getPeliculas() throws SQLException{
        
        //1 paso
        String sqlSelect = "SELECT p.cod_pelicula, p.titulo, p.total_peliculas, "
                         + "p.subtitulada, p.estreno, p.cod_genero, g.nombre_genero "
                         + "FROM Pelicula p, Genero g "
                         + "WHERE p.cod_genero = g.cod_genero";
        
        //2        
        Connection conexion = this.getConnection();
         
        //3        
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        
        //4        
        ResultSet resultSet = statement.executeQuery();
        
        //5
        LinkedList<Pelicula> peliculas = new LinkedList<Pelicula>();
        while(resultSet.next()){
            
            Pelicula pelicula = new Pelicula();
            pelicula.setCodPelicula(resultSet.getInt("cod_pelicula"));
            pelicula.setTitulo(resultSet.getString("titulo"));
            pelicula.setTotalPeliculas(resultSet.getInt("total_peliculas"));            
            pelicula.setSubtitulada(resultSet.getBoolean("subtitulada"));            
            pelicula.setEstreno(resultSet.getBoolean("estreno"));
            pelicula.getGenero().setCodGenero(resultSet.getInt("cod_genero"));
            pelicula.getGenero().setNombreGenero(resultSet.getString("nombre_genero"));
            
            //pelicula.setActores(this.getActores(pelicula.getCodPelicula()));
            
            peliculas.add(pelicula);
            
        }
        
        conexion.close();
        
//        for (Pelicula pelicula : peliculas) {
//            
//            pelicula.setActores(this.getActores(pelicula.getCodPelicula()));
//            
//        }
        
        return peliculas;
    }//getPeliculas
    
    
    public Pelicula insertar(Pelicula pelicula) throws SQLException {        
        String sqlInsertar = "{CALL sp_insertar_pelicula(?,?,?,?,?,?)}";
        Connection conexion = this.getConnection();
        CallableStatement statement =  conexion.prepareCall(sqlInsertar);
        
        statement.registerOutParameter(1, Types.INTEGER);
        statement.setString(2, pelicula.getTitulo());
        statement.setInt(3, pelicula.getGenero().getCodGenero());
        statement.setInt(4, pelicula.getTotalPeliculas());
        statement.setBoolean(5, pelicula.isSubtitulada());
        statement.setBoolean(6, pelicula.isEstreno());
        
        //ejecutar el statement
        
        statement.executeUpdate();
        
        //recuperar el codigo de la pelicula generada por la b.d.
        
        pelicula.setCodPelicula(statement.getInt(1));
        
        conexion.close();       
        
        return pelicula;
        
    }
    
    public void eliminar(int codPelicula) throws SQLException{
        String sqlDeletePelicula = "DELETE FROM Pelicula WHERE cod_pelicula=?";
        String sqlDeletePeliculaActor = 
                "DELETE FROM Pelicula_Actor WHERE cod_pelicula=?";
        
        Connection conexion = this.getConnection();
        
        try {
            conexion.setAutoCommit(false);//a partir de aqui es nuestra 
                                         //responsabilidad hacer el commit o rollback
            PreparedStatement stmtDeletePelicula = 
                    conexion.prepareStatement(sqlDeletePelicula);
            stmtDeletePelicula.setInt(1, codPelicula);
            PreparedStatement stmtDeletePeliculaActor = 
                    conexion.prepareStatement(sqlDeletePeliculaActor);
            stmtDeletePeliculaActor.setInt(1, codPelicula);
            
            //El orden de ejecucion es importante
            stmtDeletePeliculaActor.executeUpdate();
            stmtDeletePelicula.executeUpdate();
            conexion.commit();
            stmtDeletePelicula.close();
            stmtDeletePeliculaActor.close();
            
        } catch (SQLException e) {
            conexion.rollback();           
            throw  e;//volver a lanzar la excepcion para 
                    //darle el tratamiento en la capa de aplicacion
        }
        
        if(conexion != null){
            conexion.close();
        }
        
    }
}//end class PeliculaData