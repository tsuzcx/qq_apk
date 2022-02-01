package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MailAddrsViewControl$4
  implements View.OnClickListener
{
  MailAddrsViewControl$4(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.isDropDownShowing())
    {
      this.this$0.requestInputAreaFocus();
      this.this$0.showDropDown();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.4
 * JD-Core Version:    0.7.0.1
 */