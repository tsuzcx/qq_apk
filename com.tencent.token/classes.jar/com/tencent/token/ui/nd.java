package com.tencent.token.ui;

import android.app.DatePickerDialog;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import java.lang.reflect.Method;
import java.util.Calendar;

final class nd
  implements View.OnClickListener
{
  nd(JLFindItems paramJLFindItems) {}
  
  public final void onClick(View paramView)
  {
    this.a.dpd = new DatePickerDialog(this.a, JLFindItems.access$000(this.a), this.a.calendar.get(1), this.a.calendar.get(2), this.a.calendar.get(5));
    if (Build.VERSION.SDK_INT >= 11) {}
    try
    {
      paramView = (DatePicker)this.a.dpd.getClass().getDeclaredMethod("getDatePicker", new Class[0]).invoke(this.a.dpd, new Object[0]);
      paramView.getClass().getDeclaredMethod("setMaxDate", new Class[] { Long.TYPE }).invoke(paramView, new Object[] { Long.valueOf(System.currentTimeMillis()) });
      this.a.dpd.show();
      JLFindItems.access$102(this.a, 2);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nd
 * JD-Core Version:    0.7.0.1
 */