package jpp.makerlab.com.myloggin;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Declarando variables generales de tipo control*/
    EditText etNombre,etPass;
    Button btnIniciar,btnRegistrar,btnRecuperar;
    ImageView ivLogo;
    TextInputLayout tilNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Inicializamos las varibles generales de controles para utilizarlo*/
        etNombre = (EditText) findViewById(R.id.etNombre);
        etPass = (EditText) findViewById(R.id.etPass);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar = (Button) findViewById(R.id.btnRecupera);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mCorreo,mPass; //Declaramos una variable privada de tipo cadena

                //Mostrar un mensaje de error en el control TextInputLayout
                //tilNombre.setError("No es valido");

                /*Capturamos los que escribimos en las cajas de texto*/
                mCorreo = etNombre.getText().toString();
                mPass = etPass.getText().toString();

                //Muestra una mensaje corto en nuestro dispositivo
                //Toast.makeText(MainActivity.this, "Usuario:"+ mCorreo+", Pasword:"+mPass, Toast.LENGTH_SHORT).show();

                /*Pasamos un dato de tipo cadena a otro Activity */
                Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
                intent.putExtra("Nombre",mCorreo); // Preparamos un dato para pasarlo a otro activity
                startActivity(intent);
            }
        });
    }
}
