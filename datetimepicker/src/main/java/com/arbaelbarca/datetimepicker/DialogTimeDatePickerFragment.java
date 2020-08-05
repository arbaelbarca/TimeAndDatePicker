package com.arbaelbarca.datetimepicker;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogTimeDatePickerFragment extends BottomSheetDialogFragment implements DateTimePickerListener {

    private Button btnCancel;
    private Button btnOk;

    private ImageView imgClose;
    private TextView txtTitle;

    public static DialogTimeDatePickerFragment newInstance() {
        return new DialogTimeDatePickerFragment();
        // Required empty public constructor
    }

    private DateTimePickerListener dateTimePickerListener;

    private DatePicker mDatePicker;
    private TimePicker timePicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog_time_date_picker, container, false);

        mDatePicker = view.findViewById(R.id.datePickerSchedjule);
        timePicker = view.findViewById(R.id.timePickerSchedjule);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnOk = view.findViewById(R.id.btnOk);
        imgClose = view.findViewById(R.id.imgCloseSchedjule);
        txtTitle = view.findViewById(R.id.txtTitleTerbitkan);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dateTimePickerListener != null) {
                    dateTimePickerListener.setDatePicker(getActivity(), mDatePicker);
                    dateTimePickerListener.setTimePicker(getActivity(), timePicker);
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dateTimePickerListener != null)
                    dateTimePickerListener.clickCancel();
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dateTimePickerListener != null)
                    dateTimePickerListener.clickCancel();
            }
        });

        setTitle(txtTitle);
    }

    @Override
    public void setDatePicker(Context context, DatePicker datePicker) {
        this.mDatePicker = datePicker;
    }

    @Override
    public void setListener(DateTimePickerListener dateTimePickerListener) {
        this.dateTimePickerListener = dateTimePickerListener;
    }


    @Override
    public void clickCancel() {
        if (dateTimePickerListener != null)
            dateTimePickerListener.clickCancel();
    }

    @Override
    public void setTitle(TextView textView) {
        if (dateTimePickerListener != null)
            dateTimePickerListener.setTitle(textView);
    }

    @Override
    public void setTimePicker(Context context, TimePicker timePicker) {
        this.timePicker = timePicker;
    }


}
