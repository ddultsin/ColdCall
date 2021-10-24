package com.example.coldcall;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UncalledLogActivity extends AppCompatActivity {

    private Button back;
    private ArrayList<String> uncalled;
    private ListView uncalledList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uncalled_log);

        uncalled = new ArrayList<String>();
        createUncalledList(MainActivity.studentBank);
        uncalledList = (ListView) findViewById(R.id.uncalled_list);

        ArrayAdapter<String> listUncalled = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, uncalled);
        uncalledList.setAdapter(listUncalled);


        back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void createUncalledList(Student[] studentBank) {
        for (int i = 0; i < studentBank.length; i++) {
            if (studentBank[i].getTimesCalled() == 0) {
                uncalled.add(getString(studentBank[i].getStudentNameId()) + " called: " + 0 + " last at: never");
            }
        }
    }
}
