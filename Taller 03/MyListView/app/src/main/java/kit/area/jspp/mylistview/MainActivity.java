package kit.area.jspp.mylistview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kit.area.jspp.mylistview.adapters.PokemonAdapter;
import kit.area.jspp.mylistview.entities.Pokemon;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pokemon> mListPokemon;
    private Context mContext = MainActivity.this;
    private ListView mLvLista;
    private PokemonAdapter mPokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvLista = (ListView) findViewById(R.id.lvLista);

        mListPokemon = new ArrayList<Pokemon>();
        mListPokemon.add(new Pokemon("Blasoise","AGUA",R.drawable.ic_blastoise,R.color.agua));
        mListPokemon.add(new Pokemon("Butterfree","BICHO",R.drawable.ic_butterfree,R.color.bicho));
        mListPokemon.add(new Pokemon("Dragonite","DRAGON",R.drawable.ic_dragonite,R.color.dragon));
        mListPokemon.add(new Pokemon("Raichu","ELECTRICO",R.drawable.ic_raichu,R.color.electrico));
        mListPokemon.add(new Pokemon("Haunter","FANTASMA",R.drawable.ic_clefable,R.color.fantasma));
        mListPokemon.add(new Pokemon("Charizard","FUEGO",R.drawable.ic_charizard,R.color.fuego));
        mListPokemon.add(new Pokemon("Clefable","HADA",R.drawable.ic_clefable,R.color.hada));
        mListPokemon.add(new Pokemon("Jynx","HIELO",R.drawable.ic_jynx,R.color.hielo));

        mPokemonAdapter =  new PokemonAdapter(mContext,mListPokemon);
        mLvLista.setAdapter(mPokemonAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mLvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                if (view != null){
                    final TextView tvNombre = (TextView)view.findViewById(R.id.tv_nombre);
                    AlertDialog.Builder alertDialog =  new AlertDialog.Builder(mContext);
                    alertDialog.setIcon(R.mipmap.ic_launcher);
                    alertDialog.setTitle(mContext.getString(R.string.alert_main_titulo));
                    alertDialog.setMessage(mContext.getString(R.string.alert_main_message));
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton(mContext.getString(R.string.alert_main_positive),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "¡Felicitacción evolución a " +tvNombre.getText().toString()+"!" , Toast.LENGTH_SHORT).show();
                                }
                            });
                    alertDialog.setNegativeButton(mContext.getString(R.string.alert_main_negative),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, "¡Tuvo la oportunidad!", Toast.LENGTH_SHORT).show();
                                }
                            });

                    AlertDialog mAlertDialog = alertDialog.create();
                    mAlertDialog.show();
                }


            }
        });

    }
}
