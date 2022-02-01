package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnHandUpAndExpandCallback;

class MailListFragment$49
  implements ItemScrollListView.OnHandUpAndExpandCallback
{
  MailListFragment$49(MailListFragment paramMailListFragment) {}
  
  public void OnHandUpAndExpand(int paramInt)
  {
    Mail localMail = MailListFragment.access$100(this.this$0).getItem(paramInt);
    if ((localMail != null) && (localMail.getInformation() != null))
    {
      if (!localMail.getStatus().isUnread()) {
        break label44;
      }
      DataCollector.logEvent("Event_Maillist_Slide_Mark_Read");
    }
    for (;;)
    {
      DataCollector.logEvent("Event_Maillist_Slide_Delete_Mail");
      return;
      label44:
      DataCollector.logEvent("Event_Maillist_Slide_Mark_UnRead");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.49
 * JD-Core Version:    0.7.0.1
 */