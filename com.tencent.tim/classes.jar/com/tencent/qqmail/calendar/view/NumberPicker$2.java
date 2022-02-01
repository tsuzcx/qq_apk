package com.tencent.qqmail.calendar.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;

class NumberPicker$2
  implements View.OnLongClickListener
{
  NumberPicker$2(NumberPicker paramNumberPicker) {}
  
  public boolean onLongClick(View paramView)
  {
    NumberPicker.access$000(this.this$0);
    NumberPicker.access$100(this.this$0).clearFocus();
    if (paramView.getId() == 2131372562)
    {
      NumberPicker.access$300(this.this$0, true, 0L);
      return true;
    }
    NumberPicker.access$300(this.this$0, false, 0L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.NumberPicker.2
 * JD-Core Version:    0.7.0.1
 */