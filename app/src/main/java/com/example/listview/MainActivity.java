package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    final Intent _myintent = new Intent(MainActivity.this, SecondActivity.class);
    final TextView message = findViewById(R.id.textmessage);

    RecyclerView rvls;
    private MyAdapter  mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = findViewById(R.id.etname);
        final EditText id = findViewById(R.id.etid);
        final EditText password = findViewById(R.id.etpassword);
        final Button login = findViewById(R.id.btlogin);
        final Intent _myintent = new Intent(MainActivity.this, SecondActivity.class);


            recyclerView = findViewById(R.id.rvls);
            layoutManager = new LinearLayoutManager(this);
            rvls.setLayoutManager(layoutManager);

            mAdapter = new MyAdapter(getApplicationContext());
            rvls.setAdapter(mAdapter);


            final Listrepository repository = Listrepository.getInstance();


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get field values
                    String uname = name.getText().toString();
                    String upassword = password.getText().toString();
                    int uid = Integer.parseInt(id.getText().toString());

                    _myintent.putExtra("a", uname);
                    _myintent.putExtra("b", upassword);
                    _myintent.putExtra("c", uid);
                    startActivity(_myintent);
                }

                   Listrepository items = new Listrepository();

                    items.uname = uname;
                    items.upassword =upassword;
                   items.uid=uid;

                    // add
                    repository.addstudents(items);

                    mAdapter.update();

                    // clear the fields
                    uname.getText().clear();
                    upassword.getText().clear();
                    uid.getText().clear();

                }
            });
        }
    }






