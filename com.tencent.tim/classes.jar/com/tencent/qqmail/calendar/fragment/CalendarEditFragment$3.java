package com.tencent.qqmail.calendar.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.QMTopBar;

class CalendarEditFragment$3
  implements TextWatcher
{
  CalendarEditFragment$3(CalendarEditFragment paramCalendarEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (StringExtention.isNullOrEmpty(CalendarEditFragment.access$000(this.this$0).getText().toString().trim()))
    {
      this.this$0.getTopBar().getButtonRight().setEnabled(false);
      return;
    }
    this.this$0.getTopBar().getButtonRight().setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarEditFragment.3
 * JD-Core Version:    0.7.0.1
 */