package com.tencent.qqmail.calendar.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimePicker$4
  implements View.OnClickListener
{
  TimePicker$4(TimePicker paramTimePicker) {}
  
  public void onClick(View paramView)
  {
    paramView.requestFocus();
    TimePicker localTimePicker = this.this$0;
    if (!TimePicker.access$100(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      TimePicker.access$102(localTimePicker, bool);
      TimePicker.access$200(this.this$0);
      TimePicker.access$300(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.TimePicker.4
 * JD-Core Version:    0.7.0.1
 */