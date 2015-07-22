package es.ateneasystems.uo100montaditos.listview_personalizado_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.ateneasystems.uo100montaditos.R;

/**
 * Created by cubel on 22/07/15.
 */
public class MenuAdapter extends ArrayAdapter<Menu> {
    private Context context;
    private ArrayList<Menu> datos;

    /**
     * Constructor del Adapter.
     *
     * @param context
     *            context de la Activity que hace uso del Adapter.
     * @param datos
     *            Datos que se desean visualizar en el ListView.
     */
    public MenuAdapter(Context context, ArrayList<Menu> datos) {
        super(context, R.layout.item_menu, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        MenuHolder holder;

        if (item == null) {
            item = LayoutInflater.from(context).inflate(R.layout.navdrawer_layout,
                    null);
            // Inicializamos el holder y guardamos las referencias a los
            // controles.
            holder = new MenuHolder();
            holder.ico_item = (ImageView) item.findViewById(R.id.ico_item);
            holder.tv_1 = (TextView) item.findViewById(R.id.tv_1);
            holder.tv_2 = (TextView) item.findViewById(R.id.tv_2);

            // Almacenamos el holder en el Tag de la vista.
            item.setTag(holder);
        }
        // Recuperamos el holder del Tag de la vista.
        holder = (MenuHolder) item.getTag();

        // A partir del holder, asignamos los valores que queramos a los
        // controles.
        // Le asignamos una foto al ImegeView.
        holder.ico_item.setImageResource(datos.get(position)
                .getDrawableImageID());

        // Asignamos los textos a los TextView.
        holder.tv_1.setText(datos.get(position).getTitulo());
        holder.tv_2.setText(String.valueOf(position));

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }

}