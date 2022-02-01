package com.tencent.qqmail.sendmaillist;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;

class SendMailListFragment$5
  implements AdapterView.OnItemClickListener
{
  SendMailListFragment$5(SendMailListFragment paramSendMailListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = SendMailListFragment.access$900(this.this$0).getHeaderViewsCount();
    QMSendMailTask localQMSendMailTask = (QMSendMailTask)SendMailListFragment.access$1000(this.this$0).getItem(paramInt - i);
    MailListItemView localMailListItemView = (MailListItemView)((HorizontalScrollItemView)paramView).getContentView();
    if ((SendMailListFragment.access$1300(this.this$0, SendMailListFragment.access$1100(this.this$0), SendMailListFragment.access$1200(this.this$0), paramView)) && (localMailListItemView.getItemData().statusId == 3))
    {
      DataCollector.logEvent("Event_Send_Mail_ProgressBar_Click_To_Cancel");
      localMailListItemView.getItemData().statusId = 6;
      QMTaskManager.sharedInstance(1).cancel(localQMSendMailTask.getId());
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      DataCollector.logEvent("Event_TopIndicator_Click");
      ComposeMailUI localComposeMailUI = localQMSendMailTask.getMail();
      localMailListItemView.setPressedCustom(true);
      SendMailListFragment.access$1500(this.this$0, SendMailListFragment.access$1400(this.this$0, localComposeMailUI), localQMSendMailTask, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.5
 * JD-Core Version:    0.7.0.1
 */