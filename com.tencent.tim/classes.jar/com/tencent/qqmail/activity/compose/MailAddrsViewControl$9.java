package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;

class MailAddrsViewControl$9
  implements AdapterView.OnItemClickListener
{
  MailAddrsViewControl$9(MailAddrsViewControl paramMailAddrsViewControl) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MailContact localMailContact = MailAddrsViewControl.access$1200(this.this$0).getItem(paramInt);
    if (localMailContact == MailAddrsViewControl.loadingContact)
    {
      QMLog.log(2, "alger", "loading clicked");
      MailAddrsViewControl.access$100(this.this$0).setText(MailAddrsViewControl.access$1200(this.this$0).sPerformingPrefix);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.this$0.insertMailAddr(localMailContact);
      this.this$0.clearUpInputArea();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.MailAddrsViewControl.9
 * JD-Core Version:    0.7.0.1
 */