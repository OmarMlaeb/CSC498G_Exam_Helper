package com.lau.spring2022.exam_helper_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> array_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.myList);

        array_list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("laudb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS exams (exam_name VARCHAR primary key)");

            //sql.execSQL("INSERT INTO exams(exam_name) VALUES ('Software Engineering')");

            //sql.execSQL("DELETE FROM exams where exam_name  = 'Mobile Computing'");

            Cursor c = sql.rawQuery("Select * from exams", null);
            int exam_nameIndex = c.getColumnIndex("exam_name");
            c.moveToFirst();

            while(c!= null){
                String name = c.getString(exam_nameIndex);
                array_list.add(name);
                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}