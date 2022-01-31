package com.tencent.token.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

final class co
  implements DatePickerDialog.OnDateSetListener
{
  co(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    CorrectTokenActivity.mYear = paramInt1;
    CorrectTokenActivity.mMonth = paramInt2;
    CorrectTokenActivity.mDay = paramInt3;
    CorrectTokenActivity.access$600(this.a);
    CorrectTokenActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.co
 * JD-Core Version:    0.7.0.1
 */