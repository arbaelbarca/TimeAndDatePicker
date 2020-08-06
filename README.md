# TimeAndDatePicker


The following stages to start this library to use now must be Androidx

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.arbaelbarca:TimeAndDatePicker:0.0.4'
	}
Share this release:

Link
That's it! The first time you request a project JitPack checks out the code, builds it and serves the build artifacts (jar, aar).


# The following is the video library 

![Video Time Date Picker](https://github.com/arbaelbarca/TimeAndDatePicker/blob/master/video%20time%20and%20picker%20gift.gif)

# Implementation : 

# 1. Extend your class DateTimePickerListener : 

	public class MainActivity extends AppCompatActivity implements DateTimePickerListener {

# 2. Set Listener like this :

    DialogTimeDatePickerFragment dialogTimeDatePickerFragment = DialogTimeDatePickerFragment.newInstance();
    dialogTimeDatePickerFragment.setListener(this);

# 2. Call listener the following : 

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
	
        txtTime.setText("Selected Time: " + +hour + ":" + minute + " " + am_pm);
    }

    @Override
    public void setDatePicker(Context context, DatePicker mDatePicker) {
        int getMonthDatePicket = mDatePicker.getMonth() + 1;
        int getDayMonth = mDatePicker.getDayOfMonth();
        int getYears = mDatePicker.getYear();

        txtDate.setText("Selected Date: " + getMonthDatePicket + " - " + getDayMonth + " - " + getYears);
    }

    @Override
    public void setListener(DateTimePickerListener dateTimePickerListener) {

    }

    @Override
    public void clickImageClose() {
        dialogTimeDatePickerFragment.dismiss();

    }

    @Override
    public void setTitle(TextView textView) {
        textView.setText("Date & Time Picker haha");
        textView.setTextSize(15);
    }

    @Override
    public void showDialog() {
        dialogTimeDatePickerFragment.show(getSupportFragmentManager(), "");

    }

    @Override
    public void btnOk(Button btnOk) {
   btnOk.setText("Ok");
   btnOk.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
   btnOk.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
    }

    @Override
    public void btnCancel(Button btnCancel) {

    }

