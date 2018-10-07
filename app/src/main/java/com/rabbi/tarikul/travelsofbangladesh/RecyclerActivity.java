package com.rabbi.tarikul.travelsofbangladesh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BloodAdapter adapter;

    List<BloodGroups> bloodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        bloodList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        bloodList.add(
                new BloodGroups(
                        "O(+)Positive",
                        "Click Here For Lists",
                         R.drawable.o_positive));

        bloodList.add(
                new BloodGroups(
                        "O(-) Negative",
                        "Click Here For Details",
                        R.drawable.o_negative));

        bloodList.add(
                new BloodGroups(
                        "A(+) Positive",
                        "Click Here For Details",
                        R.drawable.a_positive));

        bloodList.add(
                new BloodGroups(
                        "A(-) Negative",
                        "Click Here For Details",
                        R.drawable.a_negative2));

        bloodList.add(
                new BloodGroups(
                        "B(+) Positive",
                        "Click Here For Details",
                        R.drawable.b_positive));

        bloodList.add(
                new BloodGroups(
                        "B(-) Negative",
                        "Click Here For Details",
                        R.drawable.b_negative));

        bloodList.add(
                new BloodGroups(
                        "AB(+) Positive",
                        "Click Here For Details",
                        R.drawable.ab_positive));

        bloodList.add(
                new BloodGroups(
                        "AB(-) Negative",
                        "Click Here For Details",
                        R.drawable.ab_negative2));

        adapter = new BloodAdapter(this,bloodList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RecyclerActivity.this, AlartDialog.class);
        startActivity(intent);
    }

}
