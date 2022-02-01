package com.tencent.qqmail.calendar.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class NumberPicker$3
  implements View.OnFocusChangeListener
{
  NumberPicker$3(NumberPicker paramNumberPicker) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NumberPicker.access$100(this.this$0).selectAll();
      return;
    }
    NumberPicker.access$100(this.this$0).setSelection(0, 0);
    NumberPicker.access$400(this.this$0, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.NumberPicker.3
 * JD-Core Version:    0.7.0.1
 */