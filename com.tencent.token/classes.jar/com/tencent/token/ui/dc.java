package com.tencent.token.ui;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;
import com.tencent.token.ch;

class dc
  implements TimePickerDialog.OnTimeSetListener
{
  dc(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    CorrectTokenActivity.mHour = paramInt1;
    CorrectTokenActivity.mMinute = paramInt2;
    CorrectTokenActivity.access$600(this.a);
    CorrectTokenActivity.access$000(this.a);
    ch.a().a(System.currentTimeMillis(), 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dc
 * JD-Core Version:    0.7.0.1
 */