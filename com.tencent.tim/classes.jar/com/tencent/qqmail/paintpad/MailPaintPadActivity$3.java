package com.tencent.qqmail.paintpad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.thread.Threads;

class MailPaintPadActivity$3
  implements View.OnClickListener
{
  MailPaintPadActivity$3(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Screenshot_Tag_Something_Add");
    Threads.runInBackground(new MailPaintPadActivity.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.3
 * JD-Core Version:    0.7.0.1
 */