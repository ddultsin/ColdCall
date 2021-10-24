package com.example.coldcall;

import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Student {
    private int studentNameId;
    private int studentPictureId;
    private int timesCalled;
    private long lastCalled = System.currentTimeMillis();
    private Date lastCalledDate = Calendar.getInstance().getTime();

    public Student(int studentName, int studentPicture) {
        studentNameId = studentName;
        studentPictureId = studentPicture;
        timesCalled = 0;
    }

    public int getStudentPictureId() {
        return studentPictureId;
    }

    public int getStudentNameId() {
        return studentNameId;
    }

    public void addTimesCalled() {
        timesCalled ++;
        lastCalled = System.currentTimeMillis();
        lastCalledDate = Calendar.getInstance().getTime();
    }
    public boolean okToCall() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastCalled > 2400000) {
            return false;
        }
        return true;
    }

    public int getTimesCalled() { return timesCalled; }
    public Date getLastCalled() { return lastCalledDate; }
}
