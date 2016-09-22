package kit.area.jspp.mylistview.adapters;

import android.content.Context;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import kit.area.jspp.mylistview.R;
import kit.area.jspp.mylistview.entities.Pokemon;

/**
 * Created by PEPE on 29/08/2016.
 */
public class PokeAdapter extends BaseAdapter {

    public static String PACKAGE_NAME;
    public static String RESOURCE_ANDROID;
    private Context mContext;
    private List<Pokemon> mPokemonList;

    public PokeAdapter(Context context, List<Pokemon> pokemonList) {

        mContext = context;
        mPokemonList = pokemonList;
    }

    static class ViewHolder{
        TextView tvNombre,tvTipo;
        ImageView ivLogo;
    }

    @Override
    public int getCount() {
        return mPokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            ViewHolder viewHolder;
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

            viewHolder.tvNombre = (TextView) convertView.findViewById(R.id.tv_nombre);
            viewHolder.tvTipo = (TextView) convertView.findViewById(R.id.tv_tipo);
            viewHolder.ivLogo = (ImageView) convertView.findViewById(R.id.iv_imagen);

           Pokemon pokemon =  mPokemonList.get(position);

            viewHolder.tvNombre.setText(pokemon.getNombre());
            viewHolder.tvTipo.setText(pokemon.getTipo());
            viewHolder.ivLogo.setImageURI(Uri.parse(RESOURCE_ANDROID+pokemon.getImage()));

            convertView.setTag(viewHolder);
        }

        return convertView;
    }
}
