package com.tencent.token.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.ag;
import com.tencent.token.aq;
import com.tencent.token.as;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CorrectTokenActivity
  extends BaseActivity
  implements Runnable
{
  static final int DATE_DIALOG_ID = 1;
  static final int TIME_DIALOG_ID = 0;
  public static int mDay;
  public static int mHour;
  public static int mMinute;
  public static int mMonth;
  public static int mYear;
  private boolean ReAutoCorrectToken = true;
  private String cur_ser_time;
  Handler h = new ci(this);
  Handler handler = new cr(this);
  private boolean isRunning = true;
  private boolean istimeTask = false;
  private final float kEraseAccelerationThreshold = 2.0F;
  private final float kFilteringFactor = 0.1F;
  private long lastTime = System.currentTimeMillis();
  private SensorEventListener lsn;
  private Button mAutoCorrect;
  private View.OnClickListener mAutoListener = new cm(this);
  private TextView mDateDisplay;
  private View.OnClickListener mDateListener = new cp(this);
  private DatePickerDialog.OnDateSetListener mDateSetListener = new co(this);
  private TextView mTimeDisplay;
  private View.OnClickListener mTimeListener = new cq(this);
  private TimePickerDialog.OnTimeSetListener mTimeSetListener = new cn(this);
  private Sensor sensor;
  private SensorManager sensorMgr;
  private long timeConter;
  private int timeOut = 30000;
  private long timer;
  private float x;
  private float y;
  private float z;
  
  private static String pad(int paramInt)
  {
    if (paramInt >= 10) {
      return String.valueOf(paramInt);
    }
    return "0" + String.valueOf(paramInt);
  }
  
  private void saveTimeSetting()
  {
    Calendar localCalendar = getCalendar();
    localCalendar.set(mYear, mMonth, mDay, mHour, mMinute, 0);
    long l = localCalendar.getTimeInMillis();
    ag.c().a(l - System.currentTimeMillis());
    ag.c().i();
  }
  
  private void showFailDialog()
  {
    showUserDialog(2131361899, getString(2131361900), 2131361914, 2131361802, new cj(this), new ck(this));
  }
  
  private void showSucDialog()
  {
    showUserDialog(2131361896, this.cur_ser_time, 2131361800, new cs(this));
  }
  
  private void updateDisplay()
  {
    setTime(System.currentTimeMillis() + ag.c().p());
    this.mDateDisplay.setText(new StringBuilder().append(mYear).append("年").append(mMonth + 1).append("月").append(mDay).append("日"));
    this.mTimeDisplay.setText(new StringBuilder().append(pad(mHour)).append(":").append(pad(mMinute)));
  }
  
  public void didAccelerate(j paramj)
  {
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = (paramj.a * 0.1F + arrayOfDouble[0] * 0.8999999985098839D);
    arrayOfDouble[1] = (paramj.b * 0.1F + arrayOfDouble[1] * 0.8999999985098839D);
    arrayOfDouble[2] = (paramj.c * 0.1F + arrayOfDouble[2] * 0.8999999985098839D);
    double d1 = paramj.a - arrayOfDouble[0];
    double d2 = paramj.b - arrayOfDouble[0];
    double d3 = paramj.c - arrayOfDouble[0];
    if ((Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3) >= 20.0D) && (this.ReAutoCorrectToken == true))
    {
      ag.c().a.b.a();
      this.ReAutoCorrectToken = false;
      showUserDialog(6);
      startTimeTask();
    }
  }
  
  protected Calendar getCalendar()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    return localCalendar;
  }
  
  public String getTime()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(mYear);
    localStringBuffer.append('年');
    if (mMonth < 9) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(mMonth + 1);
    localStringBuffer.append('月');
    if (mDay < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(mDay);
    localStringBuffer.append('日').append(' ');
    if (mHour < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(mHour);
    localStringBuffer.append(':');
    if (mMinute < 10) {
      localStringBuffer.append('0');
    }
    localStringBuffer.append(mMinute);
    return localStringBuffer.toString();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    this.mDateDisplay = ((TextView)findViewById(2131296477));
    this.mTimeDisplay = ((TextView)findViewById(2131296478));
    this.mAutoCorrect = ((Button)findViewById(2131296479));
    updateDisplay();
    this.mAutoCorrect.setOnClickListener(this.mAutoListener);
    this.mDateDisplay.setOnClickListener(this.mDateListener);
    this.mTimeDisplay.setOnClickListener(this.mTimeListener);
    this.sensorMgr = ((SensorManager)getSystemService("sensor"));
    this.sensor = this.sensorMgr.getDefaultSensor(1);
    this.lsn = new cl(this);
    new Thread(this).start();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new TimePickerDialog(this, this.mTimeSetListener, mHour, mMinute, false);
    }
    return new DatePickerDialog(this, this.mDateSetListener, mYear, mMonth, mDay);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.isRunning = false;
    finish();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ((TimePickerDialog)paramDialog).updateTime(mHour, mMinute);
      return;
    }
    ((DatePickerDialog)paramDialog).updateDate(mYear, mMonth, mDay);
  }
  
  protected void onResume()
  {
    super.onResume();
    ag.c().a.a(this.handler);
    if (this.sensor != null) {
      this.sensorMgr.registerListener(this.lsn, this.sensor, 2);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.sensorMgr.unregisterListener(this.lsn);
    ag.c().a.a(null);
  }
  
  public void removeTimeTask()
  {
    this.istimeTask = false;
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.isRunning)
      {
        if (System.currentTimeMillis() - this.timer > 1000L)
        {
          this.timer = System.currentTimeMillis();
          this.h.sendEmptyMessage(0);
        }
        if ((this.istimeTask) && (System.currentTimeMillis() - this.timeConter > this.timeOut)) {}
        try
        {
          this.ReAutoCorrectToken = true;
          removeTimeTask();
          Message localMessage = new Message();
          localMessage.what = 14;
          this.handler.sendMessage(localMessage);
          try
          {
            Thread.sleep(100L);
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public void setTime(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localDate.setTime(paramLong);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTime(localDate);
    mYear = localCalendar.get(1);
    mMonth = localCalendar.get(2);
    mDay = localCalendar.get(5);
    mHour = localCalendar.get(11);
    mMinute = localCalendar.get(12);
    this.cur_ser_time = getTime();
  }
  
  public void startTimeTask()
  {
    this.timeConter = System.currentTimeMillis();
    this.istimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.CorrectTokenActivity
 * JD-Core Version:    0.7.0.1
 */