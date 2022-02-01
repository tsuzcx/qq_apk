package com.tencent.qqmail.paintpad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.thread.Threads;

class MailPaintPadActivity$4
  implements View.OnClickListener
{
  MailPaintPadActivity$4(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void onClick(View paramView)
  {
    if (MailPaintPadActivity.access$200(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MailPaintPadActivity.access$202(this.this$0, true);
      DataCollector.logEvent("Event_Screenshot_Tag_Something_Share");
      Threads.runInBackground(new MailPaintPadActivity.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.4
 * JD-Core Version:    0.7.0.1
 */