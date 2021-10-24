package com.example.coldcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ImageView pictureView;
    private TextView nameView, timeView;
    private Button randomButton;
    private Button calledButton;
    private Button uncalledButton;
    private int currentIndex;
    public static Student[] studentBank = new Student[] {
            new Student(R.string.student1, R.drawable.aamir_ali),
            new Student(R.string.student2, R.drawable.adrian_yan),
            new Student(R.string.student3, R.drawable.alex_aney),
            new Student(R.string.student4, R.drawable.bipra_dey),
            new Student(R.string.student5, R.drawable.daniel_dultsin),
            new Student(R.string.student6, R.drawable.darren_dong),
            new Student(R.string.student8, R.drawable.dhruv_amin),
            new Student(R.string.student9, R.drawable.eden_kogan),
            new Student(R.string.student10, R.drawable.eli_bui),
            new Student(R.string.student11, R.drawable.elie_belkin),
            new Student(R.string.student12, R.drawable.evelyn_paskhaver),
            new Student(R.string.student13, R.drawable.fardin_iqbal),
            new Student(R.string.student14, R.drawable.jerry_he),
            new Student(R.string.student15, R.drawable.kenny_cao),
            new Student(R.string.student16, R.drawable.marc_rosenberg),
            new Student(R.string.student17, R.drawable.matthew_chen),
            new Student(R.string.student18, R.drawable.michael_something),
            new Student(R.string.student19, R.drawable.ming_lin),
            new Student(R.string.student20, R.drawable.mohammed_ihtisham),
            new Student(R.string.student21, R.drawable.noam_something),
            new Student(R.string.student22, R.drawable.ralf_pacia),
            new Student(R.string.student23, R.drawable.samuel_iskhakov),
            new Student(R.string.student24, R.drawable.sean_kerrigan),
            new Student(R.string.student26, R.drawable.selina_li),
            new Student(R.string.student27, R.drawable.shuyue_chen),
            new Student(R.string.student28, R.drawable.tanushri_sundaram),
            new Student(R.string.student29, R.drawable.vasu_patel),
            new Student(R.string.student30, R.drawable.xinrui_ge),
            new Student(R.string.student31, R.drawable.zhian_maysoon) };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureView = (ImageView) findViewById(R.id.student_picture);
        nameView = (TextView) findViewById(R.id.student_name);

        timeView = (TextView) findViewById(R.id.time);
        timeView.setText(Calendar.getInstance().getTime().toString());

        randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (int) (Math.random() * studentBank.length);
                while (!studentBank[currentIndex].okToCall() && studentBank[currentIndex].getTimesCalled() >= 2) {
                    currentIndex = (int) (Math.random() * studentBank.length);
                }
                System.out.println("new index: " + currentIndex);
                updatePicture();
                updateName();
                studentBank[currentIndex].addTimesCalled();
            }
        });
        updatePicture();
        updateName();

        calledButton = (Button) findViewById(R.id.call_button);
        calledButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent (MainActivity.this, CalledLogActivity.class);
                startActivity(c);
            }
        });

        uncalledButton = (Button) findViewById(R.id.uncall_button);
        uncalledButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(MainActivity.this, UncalledLogActivity.class);
                startActivity(u);
            }
        });


    }

    private void updatePicture() {
        System.out.println("updatePicture() called");
        int picture = studentBank[currentIndex].getStudentPictureId();
        pictureView.setImageDrawable(getDrawable(picture));
    }

    private void updateName() {
        System.out.println("updateName() called");
        int name = studentBank[currentIndex].getStudentNameId();
        nameView.setText(name);
    }
}