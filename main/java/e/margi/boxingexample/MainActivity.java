package e.margi.boxingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReferenceFromUrl("https://boxingexample.firebaseio.com/");


        final EditText edtBoxerID = (EditText) findViewById(R.id.edtBoxerID);
        final EditText edtBoxerName = (EditText) findViewById(R.id.edtBoxerName);
        final EditText edtBoxerPunchPower = (EditText) findViewById(R.id.edtBoxerPunchPower);
        final EditText edtBoxerPunchSpeed = (EditText) findViewById(R.id.edtBoxerPunchSpeed);
        final EditText edtBoxerStamina = (EditText) findViewById(R.id.edtBoxerStamina);

        Button btnSendDataToServer = (Button) findViewById(R.id.btnSendDataToServer);

        btnSendDataToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myRef.setValue("Hello, World!");

                myRef.child(edtBoxerID.getText().toString()).child("Boxer Name")
                        .setValue(edtBoxerName.getText().toString());
                myRef.child(edtBoxerID.getText().toString()).child("Boxer Punch Power")
                        .setValue(edtBoxerPunchPower.getText().toString());
                myRef.child(edtBoxerID.getText().toString()).child("Boxer Punch Speed")
                        .setValue(edtBoxerPunchSpeed.getText().toString());
                myRef.child(edtBoxerID.getText().toString()).child("Boxer Stamina")
                        .setValue(edtBoxerStamina.getText().toString());

                myRef.child("A").child("B").child("C").child("D").setValue("E");
                Toast.makeText(MainActivity.this,"data stored  successfully",Toast.LENGTH_LONG).show();


            }
        });
    }
}