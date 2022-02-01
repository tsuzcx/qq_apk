package com.tencent.qqmail.paintpad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailPaintPadActivity$2
  implements View.OnClickListener
{
  MailPaintPadActivity$2(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.handlerCancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.2
 * JD-Core Version:    0.7.0.1
 */