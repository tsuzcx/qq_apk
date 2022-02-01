package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;

class ReadMailDetailInformationView$4
  implements View.OnClickListener
{
  ReadMailDetailInformationView$4(ReadMailDetailInformationView paramReadMailDetailInformationView, MailUI paramMailUI) {}
  
  public void onClick(View paramView)
  {
    MailContact localMailContact;
    if ((paramView.getTag() instanceof MailContact))
    {
      localMailContact = (MailContact)paramView.getTag();
      if (localMailContact != this.val$mail.getInformation().getFrom()) {
        break label56;
      }
      this.this$0.onMailContactClick(paramView, ReadMailDetailInformationView.access$100(this.this$0), 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label56:
      paramView.setSelected(true);
      this.this$0.onMailContactClick(paramView, localMailContact, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailDetailInformationView.4
 * JD-Core Version:    0.7.0.1
 */