package es.ateneasystems.uo100montaditos.listview_personalizado_menu;

/**
 * Created by cubel on 22/07/15.
 */
public class Menu {

    private String titulo;
    private int drawableImageID;

    public Menu(String titulo, int drawableImageID) {
        this.titulo = titulo;
        this.drawableImageID = drawableImageID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }

}
