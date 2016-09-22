package jpp.makerlab.com.myloggin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity {

    TextView etNombre;
    EditText etNombreRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = (TextView) findViewById(R.id.tvNombre);
        etNombreRegistro = (EditText) findViewById(R.id.etNombre);

        //Recuperar el dato enviado desde otra activity
        String Nombre = getIntent().getExtras().getString("Nombre");

        //Asignamos el contenido de la variable a un EditText y TextView
        etNombre.setText(Nombre);
        etNombreRegistro.setText(Nombre);
    }
}
