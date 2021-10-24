package com.example.coldcall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalledLogActivity extends AppCompatActivity {

    private Button backButton;
    private ListView calledList;
    private ArrayList<Student> calledStudentBank;
    private ArrayList<String> names, called;
    private ArrayList<Integer> times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.called_log);


        //make an array list of called students (unnecessary)
        //make an array of the names of students called
        //make an array of the # times each student was called
        calledStudentBank = new ArrayList<Student>();
        names = new ArrayList<String>();
        times = new ArrayList<Integer>();
        called = new ArrayList<String>();
        makeCalledList(MainActivity.studentBank);


        //display names of students called and number of times they were called
        //calledListNames = (ListView) findViewById(R.id.called_list_names);
        //calledListTimes = (ListView) findViewById(R.id.called_list_times);
        //ArrayAdapter<String> listNames=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        //calledListNames.setAdapter(listNames);
        //ArrayAdapter<Integer> listTimes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, times);
        //calledListTimes.setAdapter(listTimes);

        calledList = (ListView) findViewById(R.id.called_list);
        ArrayAdapter<String> listCalled = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, called);
        calledList.setAdapter(listCalled);


        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void makeCalledList(Student[] studentBank) {
        for (int i = 0; i < studentBank.length; i++) {
            if (studentBank[i].getTimesCalled() > 0) {
                calledStudentBank.add(studentBank[i]);
                names.add(getString(studentBank[i].getStudentNameId()));
                times.add(studentBank[i].getTimesCalled());
                called.add(getString(studentBank[i].getStudentNameId()) + " called: " + studentBank[i].getTimesCalled() + " last: " + studentBank[i].getLastCalled().toString());
            }
        }
    }

}
