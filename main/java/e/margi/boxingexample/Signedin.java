package e.margi.boxingexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signedin extends AppCompatActivity
{
    TextView tvPhoneNumber;
    Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedin);
        findViews();
        setPhoneNumber();
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Signedin.this,MainActivity.class));
                finish();
            }
        });
    }
    private void findViews() {
        tvPhoneNumber=findViewById(R.id.tv_phone_number);
        btnSignOut=findViewById(R.id.btn_sign_out);
    }
    private void setPhoneNumber(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        try {
            tvPhoneNumber.setText(user.getPhoneNumber());
        }catch (Exception e){
            Toast.makeText(this,"Phone number not found",Toast.LENGTH_SHORT).show();
        }
    }
    }
