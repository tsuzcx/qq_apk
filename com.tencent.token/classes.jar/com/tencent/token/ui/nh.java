package com.tencent.token.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Build.VERSION;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

final class nh
  implements DatePickerDialog.OnDateSetListener
{
  nh(JLFindItems paramJLFindItems) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.dpd == null) || (this.a == null) || (this.a.isFinishing())) {
      return;
    }
    this.a.calendar.set(1, paramInt1);
    this.a.calendar.set(2, paramInt2);
    this.a.calendar.set(5, paramInt3);
    if ((Build.VERSION.SDK_INT < 11) && (this.a.calendar.getTimeInMillis() > System.currentTimeMillis())) {
      this.a.calendar.setTimeInMillis(System.currentTimeMillis());
    }
    paramDatePicker = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
    if (JLFindItems.access$100(this.a) == 1)
    {
      JLFindItems.access$1300(this.a).setText(paramDatePicker.format(this.a.calendar.getTime()));
      JLFindItems.access$1300(this.a).setVisibility(0);
      JLFindItems.access$1300(this.a).setTextAppearance(this.a, 2131427335);
      JLFindItems.access$1400(this.a).setTextAppearance(this.a, 2131427386);
      this.a.lastLoginTime = this.a.calendar.getTime();
    }
    for (;;)
    {
      JLFindItems.access$1700(this.a);
      this.a.dpd.dismiss();
      this.a.dpd = null;
      return;
      if (JLFindItems.access$100(this.a) == 2)
      {
        JLFindItems.access$1500(this.a).setText(paramDatePicker.format(this.a.calendar.getTime()));
        JLFindItems.access$1500(this.a).setVisibility(0);
        JLFindItems.access$1500(this.a).setTextAppearance(this.a, 2131427335);
        JLFindItems.access$1600(this.a).setTextAppearance(this.a, 2131427386);
        this.a.getStealTime = this.a.calendar.getTime();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nh
 * JD-Core Version:    0.7.0.1
 */