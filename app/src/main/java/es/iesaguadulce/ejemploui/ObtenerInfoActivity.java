package es.iesaguadulce.ejemploui;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

public class ObtenerInfoActivity extends AppCompatActivity {

    private TextInputLayout tfNombre;
    private TextInputLayout tfEdad;
    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persona = new Persona("", "");
        setContentView(R.layout.activity_obtener_info);

        Intent intent = getIntent();
        String fragment = intent.getStringExtra("fragment");

        switch (fragment) {
            case "main":
                Toast.makeText(this, "Me has abierto desde el Main Fragment", Toast.LENGTH_SHORT).show();
                break;
            case "second":
                Toast.makeText(this, "Me has abierto desde el Second Fragment", Toast.LENGTH_SHORT).show();
                break;
        }

        tfNombre = findViewById(R.id.tf_nombre);
        tfEdad = findViewById(R.id.tf_edad);
        tfNombre.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                persona.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tfEdad.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                persona.setEdad(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("persona", persona);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
