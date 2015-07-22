package es.ateneasystems.uo100montaditos.ListView_personalizado;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import es.ateneasystems.uo100montaditos.R;

/**
 * Created by cubel on 11/02/15.
 */
public class ZTiposAdapter extends RecyclerView.Adapter<ZTiposAdapter.ViewHolder> {

    private ArrayList<ZTiposDatos> courses;
    private int itemLayout;


    public ZTiposAdapter(ArrayList<ZTiposDatos> data, int itemLayout) {
        courses = data;
        this.itemLayout = itemLayout;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public TextView description;
        public TextView tv_nombre;
        public TextView tv_id;

        public ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            //tv_id = (TextView) itemView.findViewById(R.id.tv_nombre);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Pulsado: " + this.tv_nombre.getText(), Toast.LENGTH_SHORT).show();
            /*
            * Compartimos el mensaje
            * */
            /*
            Context ctx = view.getContext();//Cogemos el context del View del boton para usarlo mas adelante
            String asunto = "Resultado Euromillones día "+this.tv_nombre.getText();//Solo para cosas como los mails
            String mensaje = "#Euromillones\nSorteo día "+this.tv_nombre.getText()+" -> "+this.tv_id.getText()+"\nBájate la APP para Android http://goo.gl/Nj0lHN\n#AteneaSystems";//Mensaje en si
            Intent txtIntent = new Intent(android.content.Intent.ACTION_SEND);
            txtIntent .setType("text/plain");
            txtIntent .putExtra(android.content.Intent.EXTRA_SUBJECT, asunto);
            txtIntent .putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
            //view.getContext().startActivity(Intent.createChooser(txtIntent, "Share"));//ponemos view.getContext() antes del startactivity porque no hay activity aqui
            ctx.startActivity(Intent.createChooser(txtIntent, ctx.getString(R.string.tv_activity_ultimos_res_compartir)));
            */
            //Toast.makeText(ctx.startA)
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        ZTiposDatos course = courses.get(position);
        viewHolder.tv_nombre.setText(course.getNombreTipoMontadito());
        viewHolder.itemView.setTag(course);
    }


    @Override
    public int getItemCount() {
        return courses.size();
    }

}