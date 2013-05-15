/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.strutswebapp.exceptions;

/**
 *
 * @author Equipo
 */
public class GeneroNoExistenteExeption extends Exception{
    public GeneroNoExistenteExeption(){
        super("El genero buscado no existe");
    }

    public GeneroNoExistenteExeption(String string) {
        super(string);
    }
    
}
