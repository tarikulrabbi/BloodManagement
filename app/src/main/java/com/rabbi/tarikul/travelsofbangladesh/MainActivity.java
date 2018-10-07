package com.rabbi.tarikul.travelsofbangladesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

            EditText edtUserName, edtPassword;
            Button button;
            Spinner spinner;

            FirebaseFirestore firebaseFirestore;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                firebaseFirestore = FirebaseFirestore.getInstance();

                button = findViewById(R.id.loginbutton);

                edtUserName = findViewById(R.id.textEditusename);
                edtPassword = findViewById(R.id.textEditpassword);
                spinner = findViewById(R.id.SpinnerId);

                ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Blood_List,android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                button.setOnClickListener(this);

                edtUserName.addTextChangedListener(loginTextWatcher);
                edtPassword.addTextChangedListener(loginTextWatcher);

}
        private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userNameInput = edtUserName.getText().toString().trim();
            String userPasswordInput = edtPassword.getText().toString().trim();

            button.setEnabled(!userNameInput.isEmpty() && !userPasswordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
            public void onClick(View view) {

                switch (view.getId()) {

                    case R.id.loginbutton:

                        {
                            String username = edtUserName.getText().toString();
                            String password = edtPassword.getText().toString();
                            String spinnerDemo = spinner.getSelectedItem().toString();

                            Map <String,String> userMap = new HashMap<>();

                            userMap.put("name",username);
                            userMap.put("number",password);
                            userMap.put("blood_Group", spinnerDemo);

                            firebaseFirestore.collection("users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {

                                }
                            });

                            Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                            Toast.makeText(MainActivity.this, "Successfully Saved Your Data", Toast.LENGTH_LONG).show();
                        }
                    }
                }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, AlartDialog.class);
        startActivity(intent);
    }
}