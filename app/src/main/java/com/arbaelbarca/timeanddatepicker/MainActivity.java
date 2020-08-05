package com.arbaelbarca.timeanddatepicker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.arbaelbarca.datetimepicker.DateTimePickerListener;
import com.arbaelbarca.datetimepicker.DialogTimeDatePickerFragment;

public class MainActivity extends AppCompatActivity {

    DialogTimeDatePickerFragment dialogTimeDatePickerFragment = new DialogTimeDatePickerFragment();
    DateTimePickerListener dateTimePickerListener = new DateTimePickerListener() {
        @Override
        public void setTimePicker(Context context, TimePicker timePicker) {
            int hour, minute;
            String am_pm;
            if (Build.VERSION.SDK_INT >= 23) {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
            } else {
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();
            }
            if (hour > 12) {
                am_pm = "PM";
                hour = hour - 12;
            } else {
                am_pm = "AM";
            }

            Log.d("Selected Time:", " " + +hour + ":" + minute + " " + am_pm);
        }

        @Override
        public void setDatePicker(Context context, DatePicker mDatePicker) {
            int getMonthDatePicket = mDatePicker.getMonth() + 1;
            int getDayMonth = mDatePicker.getDayOfMonth();
            int getYears = mDatePicker.getYear();

            Log.d("Selected Date: ", " date " + getMonthDatePicket + " - " + getDayMonth + " - " + getYears);
        }

        @Override
        public void setListener(DateTimePickerListener dateTimePickerListener) {

        }


        @Override
        public void clickCancel() {
            dialogTimeDatePickerFragment.dismiss();
        }

        @Override
        public void setTitle(TextView textView) {
            textView.setText("Date & Time Picker");
            textView.setTextSize(15);
        }
    };

    Button btnShowPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowPicker = findViewById(R.id.btnShowPicker);

        btnShowPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogTimeDatePickerFragment.show(getSupportFragmentManager(), "Contoh aja");
            }
        });

        dialogTimeDatePickerFragment.setListener(dateTimePickerListener);


    }
}
