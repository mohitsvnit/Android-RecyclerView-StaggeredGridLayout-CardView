package com.example.mohit.cardview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    myAdapter adapter;
    EditText textname;
    EditText textid;
    Button bt;
    List<Person> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textname = (EditText) findViewById(R.id.editname);
        textid = (EditText) findViewById(R.id.editid);
        bt = (Button) findViewById(R.id.button);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myAdapter(this,data);
        recyclerView.setAdapter(adapter);



    }

    public void addData(String name, int id) {
        Person person = new Person(name,id);
        data.add(person);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view == bt) {
            String name = textname.getText().toString();
            int id = Integer.valueOf(textid.getText().toString());
            addData(name,id);
        }
    }
}
