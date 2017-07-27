package com.example.android.broadcastreceiver;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView textView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<IncomingNumber> arrayList = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_simple_list);
        textView = (TextView) findViewById(R.id.tv_simple_text);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        ReadFromDb();

    }

    private void ReadFromDb() {

        arrayList.clear();
        DbHelper dbHelper = new DbHelper(this);

        Cursor cursor = dbHelper.readValue();

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String number;
                int id;

                number = cursor.getString(cursor.getColumnIndex("value"));
                id = cursor.getInt(cursor.getColumnIndex("id"));

                arrayList.add(new IncomingNumber(id, number));


            }
            cursor.close();
            dbHelper.close();
            recyclerAdapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);

        }
    }
}
