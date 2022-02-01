package com.tencent.qqmail.calendar.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NumberPicker$1
  implements View.OnClickListener
{
  NumberPicker$1(NumberPicker paramNumberPicker) {}
  
  public void onClick(View paramView)
  {
    NumberPicker.access$000(this.this$0);
    NumberPicker.access$100(this.this$0).clearFocus();
    if (paramView.getId() == 2131372562) {
      NumberPicker.access$200(this.this$0, true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NumberPicker.access$200(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.NumberPicker.1
 * JD-Core Version:    0.7.0.1
 */