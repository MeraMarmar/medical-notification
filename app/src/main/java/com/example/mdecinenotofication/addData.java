package com.example.mdecinenotofication;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.nio.file.WatchKey;
import java.util.ArrayList;
import java.util.Calendar;

public class addData extends AppCompatActivity {
    database db;
    EditText edit_nameofmed, edit_date, edit_hour, edit_numoftaken, edit_minute, edit_second;
    Button btn_add;
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        db = new database(this);
        edit_nameofmed = (EditText) findViewById(R.id.edit_nameofmed);
        edit_date = (EditText) findViewById(R.id.edit_date);
        edit_hour = (EditText) findViewById(R.id.edit_hour);
        edit_minute = (EditText) findViewById(R.id.edit_minute);
        edit_second = (EditText) findViewById(R.id.edit_second);
        edit_numoftaken = (EditText) findViewById(R.id.edit_numoftaken);
        btn_add = (Button) findViewById(R.id.btn_add);
        textshow = (TextView) findViewById(R.id.textshow);

    }

    String s1, s2, s3, s4, s5, s6;

    public void add_Data(View view) {
        s1 = edit_nameofmed.getText().toString();

        if (s1.equals("")) {
            Toast.makeText(this, "fileds are empty", Toast.LENGTH_LONG).show();
        } else {
            //showDialog(1);
            //Calendar calendar=Calendar.getInstance();
            // calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(s3));
            //calendar.set(Calendar.MINUTE,Integer.parseInt(s4));
            // calendar.set(Calendar.SECOND,Integer.parseInt(s5));
            //Intent intent=new Intent(this,notifaction_reciever.class);
            //PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            // AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
            // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
            //alarmManager.cancel(PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT));
            // Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
           // Boolean insert = db.insertdataofmedecine(s1, , s3, s4, s5, s6);
            //if (insert == true) {
              //  Toast.makeText(this, "Donesiss", Toast.LENGTH_LONG).show();
                //edit_nameofmed.setText("");
                //edit_date.setText("");
                // edit_hour.setText("");
                // edit_minute.setText("");
                // edit_second.setText("");
                // edit_numoftaken.setText("");

            //}
        }


    }

    protected Dialog onCreateDialog(int id) {
        Calendar calendar = Calendar.getInstance();
        if (id == 1)
            return new TimePickerDialog(addData.this, TimeMap, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
        return null;


    }

    protected TimePickerDialog.OnTimeSetListener TimeMap =
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);
                    calendar.set(Calendar.SECOND, 00);
                    Intent intent = new Intent(getApplicationContext(), notifaction_reciever.class);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                    textshow.setText(hourOfDay + ":" + minute + ":" + "00");
                    Toast.makeText(getApplicationContext(), "time", Toast.LENGTH_LONG).show();
                    Boolean insert = db.insertdataofmedecine(s1, String.valueOf(hourOfDay), String.valueOf(minute), String.valueOf(00), s5, s6);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "data", Toast.LENGTH_LONG).show();
                        edit_nameofmed.setText("");
                        edit_numoftaken.setText("");
                    }
                }
            };

    public void taketime(View view) {
        showDialog(1);
    }
}




