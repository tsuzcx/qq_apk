package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;

class ReadMailDetailInformationView$1
  implements View.OnClickListener
{
  ReadMailDetailInformationView$1(ReadMailDetailInformationView paramReadMailDetailInformationView, MailGroupContact paramMailGroupContact) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    if (ReadMailDetailInformationView.access$000(this.this$0) != null) {
      ReadMailDetailInformationView.access$000(this.this$0).onClick(paramView, this.val$mailGroupContact);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailInformationView.1
 * JD-Core Version:    0.7.0.1
 */