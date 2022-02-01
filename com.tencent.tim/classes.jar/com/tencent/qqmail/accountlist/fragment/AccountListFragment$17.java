package com.tencent.qqmail.accountlist.fragment;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;
import com.tencent.qqmail.view.QMAdvertiseView;
import com.tencent.qqmail.view.QMBaseView;

class AccountListFragment$17
  extends PtrListView.OnRefreshListener
{
  AccountListFragment$17(AccountListFragment paramAccountListFragment) {}
  
  public void onPopulate()
  {
    super.onPopulate();
    AccountListFragment.access$2000(this.this$0).getAdvertiseView().setExitListener(new AccountListFragment.17.1(this));
    AdvertiseAnimUtil.showAdvertiseView(this.this$0.getActivity(), AccountListFragment.access$2000(this.this$0).getAdvertiseView(), AccountListFragment.access$1200(this.this$0));
  }
  
  public void onRefresh()
  {
    QMMailManager.sharedInstance().syncAll();
    DataCollector.logEvent("Event_Pull_To_Refresh_MailBox");
    DataCollector.logPerformanceBegin("Performance_Check_New_Mail_MailboxList", 0L, "Performance_Check_New_Mail_MailboxList");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.17
 * JD-Core Version:    0.7.0.1
 */