package com.tencent.qqmail.sendmaillist;

import android.view.View;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;

class SendMailListFragment$7
  implements ItemScrollListView.OnRightViewClickListener
{
  SendMailListFragment$7(SendMailListFragment paramSendMailListFragment) {}
  
  public void onRightViewClick(View paramView, int paramInt)
  {
    int i = SendMailListFragment.access$900(this.this$0).getHeaderViewsCount();
    DataCollector.logEvent("Event_Send_Mail_Delete_When_Sending");
    paramView = (QMSendMailTask)SendMailListFragment.access$1000(this.this$0).getItem(paramInt - i);
    SendMailListFragment.access$1600(this.this$0, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.7
 * JD-Core Version:    0.7.0.1
 */