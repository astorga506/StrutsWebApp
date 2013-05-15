/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.data;

import cr.ac.ucr.strutswebapp.domain.Genero;
import cr.ac.ucr.strutswebapp.exceptions.GeneroNoExistenteExeption;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Equipo
 */
public class GeneroData extends BaseData {

    public GeneroData() throws SQLException {
    }

    public LinkedList<Genero> getGeneros() throws SQLException {

        String sqlSelect = "SELECT cod_genero, nombre_genero "
                + "FROM Genero";

        Connection conexion = super.getConnection();

        PreparedStatement statement = conexion.prepareStatement(sqlSelect);

        ResultSet resultSet = statement.executeQuery();

        LinkedList<Genero> generos = new LinkedList<Genero>();

        while (resultSet.next()) {

            Genero genero = new Genero();
            genero.setCodGenero(resultSet.getInt("cod_genero"));
            genero.setNombreGenero(resultSet.getString("nombre_genero"));

            generos.add(genero);

        }//while              

        conexion.close();

        return generos;
    }//getGeneros

    public Genero getGenero(int codGenero) throws SQLException, 
                                                GeneroNoExistenteExeption {
        String sqlSelect = "SELECT cod_genero,nombre_genero "
                + "FROM Genero where cod_genero=?";
        Connection conexion = this.getConnection();
        PreparedStatement statement = conexion.prepareStatement(sqlSelect);
        statement.setInt(1, codGenero);
        ResultSet resultSet = statement.executeQuery();
        Genero genero = new Genero();
        if (resultSet.next()) {
            genero.setCodGenero(resultSet.getInt("cod_genero"));
            genero.setNombreGenero(resultSet.getString("nombre_genero"));
        } else {// no existe el genero
            throw new GeneroNoExistenteExeption();
        }
        conexion.close();
        return genero;
    }//getGenero

    public void editar(Genero genero) throws SQLException {
        String sqlProcedureName = "{CALL editar_genero(?,?)}";
        Connection conexion = this.getConnection();
        CallableStatement callableStatement =
                conexion.prepareCall(sqlProcedureName);
        callableStatement.setInt(1, genero.getCodGenero());
        callableStatement.setString(2, genero.getNombreGenero());
        callableStatement.executeUpdate();
        conexion.close();
    }//editar
    public void eliminar(int codGenero) throws SQLException {
        String sqlProcedure = "{CALL eliminar_genero(?)}";
        Connection conexion = this.getConnection();
        CallableStatement callableStatement =
                conexion.prepareCall(sqlProcedure);
        callableStatement.setInt(1, codGenero);
        callableStatement.executeUpdate();
        conexion.close();
    }//eliminar
}
