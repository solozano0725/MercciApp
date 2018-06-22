package complement.merci.app.mercciapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.valdesekamdem.library.mdtoast.MDToast;

public class Registrar extends AppCompatActivity {

    EditText nombre, email, direccion, cel, contra1, contra2;
    boolean v = false;
    MDToast mdToast;
    Button registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombre = findViewById(R.id.editNombre);
        email = findViewById(R.id.editEmail);
        direccion = findViewById(R.id.editDire);
        cel = findViewById(R.id.editCel);
        contra1 = findViewById(R.id.editCon1);
        contra2 = findViewById(R.id.editCon2);
        registro = findViewById(R.id.btnRegistrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarEspacios()){
                    if(contrasenasIguales()){
                        mdToast = MDToast.makeText(getApplicationContext(), getString(R.string.success), MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                        mdToast.show();
                        startActivity(new Intent(Registrar.this, Login.class));
                    } else{
                        mdToast = MDToast.makeText(getApplicationContext(), getString(R.string.passdifer), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
                        mdToast.show();
                    }
                } else{
                    mdToast = MDToast.makeText(getApplicationContext(), getString(R.string.emptytext), MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }
            }
        });

    }

    public boolean contrasenasIguales(){
        if(contra1.getText().toString().equalsIgnoreCase(contra2.getText().toString())){
            v=true;
        } else{
            v=false;
        }
        return v;
    }

    public boolean validarEspacios(){
        if(nombre.getText().toString().length()!=0 && email.getText().toString().length()!=0 &&
                direccion.getText().toString().length()!=0 && cel.getText().toString().length()!=0 &&
                contra1.getText().toString().length()!=0 && contra2.getText().toString().length()!=0 ){
            v= true;
        } else{
            v=false;
        }
        return v;
    }

}
