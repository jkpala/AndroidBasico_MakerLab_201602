package kit.area.jspp.mylistview.adapters;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.ArrayList;

import kit.area.jspp.mylistview.R;
import kit.area.jspp.mylistview.entities.Pokemon;

/**
 * Created by PEPE on 28/08/2016.
 */
public class PokemonAdapter extends BaseAdapter {

    public static String PACKAGE_NAME;
    public static String RESOURCE_ANDROID;

    private Context mContext;
    private ArrayList<Pokemon> mListaPokemon;

    public PokemonAdapter(Context context, ArrayList<Pokemon> listaPokemon) {
        PACKAGE_NAME = context.getPackageName();
        RESOURCE_ANDROID = "android.resource://" + PACKAGE_NAME+"/";
        mContext = context;
        mListaPokemon = listaPokemon;
    }

    static class ViewHolder{
        TextView tvNombre,tvTipo;
        RelativeLayout rlContener;
        ImageView ivLogo;
    }

    @Override
    public int getCount() {
        return mListaPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return mListaPokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);


            ViewHolder viewHolder;
            viewHolder = new ViewHolder();

            viewHolder.tvNombre = (TextView) convertView.findViewById(R.id.tv_nombre);
            viewHolder.tvTipo = (TextView) convertView.findViewById(R.id.tv_tipo);
            viewHolder.ivLogo = (ImageView) convertView.findViewById(R.id.iv_imagen);
            viewHolder.rlContener = (RelativeLayout) convertView.findViewById(R.id.rl_contenedor);
            convertView.setTag(viewHolder);
        }
            ViewHolder viewHolder;
            viewHolder = (ViewHolder) convertView.getTag();

            Pokemon pokemon;
            pokemon =  mListaPokemon.get(position);
            //pokemon = (Pokemon) getItem(position);

            viewHolder.tvNombre.setText(pokemon.getNombre());
            viewHolder.tvTipo.setText(pokemon.getTipo());
            viewHolder.ivLogo.setImageURI(Uri.parse("android.resource://kit.area.jspp.mylistview/"+pokemon.getImage()));
            viewHolder.rlContener.setBackgroundResource(pokemon.getColor());


        return convertView;
    }
}
