package complement.merci.app.mercciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.valdesekamdem.library.mdtoast.MDToast;

public class Login extends AppCompatActivity {

    EditText editEmail, editPass;
    Button btnEntrar, btnRegistro;
    MDToast mdToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPass);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editEmail.getText().toString().length()!=0 && editPass.getText().toString().length()!=0){
                    startActivity(new Intent(Login.this, MainActivity.class));
                } else{
                    mdToast = MDToast.makeText(getApplicationContext(), getString(R.string.emptytext), MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }

            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registrar.class));
            }
        });
    }
}
