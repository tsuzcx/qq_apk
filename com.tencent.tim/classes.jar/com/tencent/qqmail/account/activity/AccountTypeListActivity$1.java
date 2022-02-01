package com.tencent.qqmail.account.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLogStream;

class AccountTypeListActivity$1
  implements View.OnClickListener
{
  AccountTypeListActivity$1(AccountTypeListActivity paramAccountTypeListActivity) {}
  
  public void onClick(View paramView)
  {
    String str = "addAccountEntrance:" + (String)paramView.getTag();
    DataCollector.logDetailEvent("DetailEvent_User_Behavior", 0L, 0L, str);
    QMLogStream.logWithoutUmaNow(-40025, str, "Event_Error");
    QMLogStream.submitLog(false, true);
    AccountTypeListActivity.access$000(this.this$0, (String)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.AccountTypeListActivity.1
 * JD-Core Version:    0.7.0.1
 */