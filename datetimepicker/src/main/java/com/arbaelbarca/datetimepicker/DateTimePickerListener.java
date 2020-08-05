package com.arbaelbarca.datetimepicker;

import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.FragmentManager;

public interface DateTimePickerListener {

    public void setTimePicker(Context context, TimePicker timePicker);

    public void setDatePicker(Context context, DatePicker datePicker);

    public void setListener(DateTimePickerListener dateTimePickerListener);

    public void clickCancel();

    public void setTitle(TextView textView);
}
