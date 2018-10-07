package com.rabbi.tarikul.travelsofbangladesh;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlartDialog extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alart_dialog);

        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Welcome To Khulna Blood Management Group");
        alertDialog.setMessage("Want To A Blood Donor??");
        alertDialog.setIcon(R.drawable.icon);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(AlartDialog.this,MainActivity.class);
                startActivity(intent);
            }
        });

        alertDialog.setNeutralButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(AlartDialog.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog alertDialog2 = alertDialog.create();
        alertDialog2.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
