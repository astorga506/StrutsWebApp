package cr.ac.ucr.strutswebapp.domain;

import java.util.LinkedList;

/**
 *
 * @author Ricardo
 */
public class Pelicula {
    private int codPelicula;
    private String titulo;
    private int totalPeliculas;
    private boolean subtitulada, estreno;
    private LinkedList<Actor> actores;
    private Genero genero;
    
    public Pelicula() {
        actores = new LinkedList<Actor>();
        genero = new Genero();
    }

    public Pelicula(int codPelicula, String titulo, int totalPeliculas, boolean subtitulada, boolean estreno, LinkedList<Actor> actores, Genero genero) {
        this.codPelicula = codPelicula;
        this.titulo = titulo;
        this.totalPeliculas = totalPeliculas;
        this.subtitulada = subtitulada;
        this.estreno = estreno;
        this.actores = actores;
        this.genero = genero;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalPeliculas() {
        return totalPeliculas;
    }

    public void setTotalPeliculas(int totalPeliculas) {
        this.totalPeliculas = totalPeliculas;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public boolean isEstreno() {
        return estreno;
    }

    public void setEstreno(boolean estreno) {
        this.estreno = estreno;
    }

    public LinkedList<Actor> getActores() {
        return actores;
    }

    public void setActores(LinkedList<Actor> actores) {
        this.actores = actores;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}//class Pelicula
