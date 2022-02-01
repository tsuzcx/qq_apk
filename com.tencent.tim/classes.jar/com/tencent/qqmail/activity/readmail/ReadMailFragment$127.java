package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$127
  implements View.OnClickListener
{
  ReadMailFragment$127(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadMailFragment.access$10700(this.this$0) == null) {
      QMMailManager.sharedInstance().loadTranslateMail(ReadMailFragment.access$000(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ReadMailFragment.access$2400(this.this$0) != null) {
        if (5 == ReadMailFragment.access$2400(this.this$0).getTranslateStatus())
        {
          DataCollector.logEvent("Event_Translate_Translate");
          ReadMailFragment.access$19700(this.this$0);
        }
        else if (4 == ReadMailFragment.access$2400(this.this$0).getTranslateStatus())
        {
          DataCollector.logEvent("Event_Translate_Original");
          ReadMailFragment.access$19800(this.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.127
 * JD-Core Version:    0.7.0.1
 */