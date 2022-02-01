package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.PtrListView.OnRefreshListener;
import com.tencent.qqmail.view.QMAdvertiseView;
import com.tencent.qqmail.view.QMBaseView;
import java.util.Iterator;

class MailListFragment$35
  extends PtrListView.OnRefreshListener
{
  MailListFragment$35(MailListFragment paramMailListFragment) {}
  
  public void onPopulate()
  {
    super.onPopulate();
    MailListFragment.access$7100(this.this$0).getAdvertiseView().setExitListener(new MailListFragment.35.2(this));
    AdvertiseAnimUtil.showAdvertiseView(this.this$0.getActivity(), MailListFragment.access$7100(this.this$0).getAdvertiseView(), MailListFragment.access$000(this.this$0));
  }
  
  public void onRefresh()
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(MailListFragment.access$2200(this.this$0));
    if ((MailListFragment.access$100(this.this$0) != null) && (localObject != null) && (!((Account)localObject).isActiveSyncMail()))
    {
      localObject = MailListFragment.access$100(this.this$0).getHitMailIds();
      if (localObject != null)
      {
        long[] arrayOfLong = new long[((ConcurrentHashSet)localObject).size()];
        Iterator localIterator = ((ConcurrentHashSet)localObject).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          arrayOfLong[i] = ((Long)localIterator.next()).longValue();
          i += 1;
        }
        Threads.runInBackground(new MailListFragment.35.1(this, arrayOfLong));
        QMLog.log(2, "MailListFragment", "update mail rencetOpTime");
        ((ConcurrentHashSet)localObject).clear();
      }
    }
    if (MailListFragment.access$3600(this.this$0).getId() == -1) {
      DataCollector.logEvent("Event_Pull_To_Refresh_All_Inbox");
    }
    do
    {
      for (;;)
      {
        if ((MailListFragment.access$8600(this.this$0)) && (MailListFragment.access$8700(this.this$0))) {
          MailListFragment.access$8800(this.this$0);
        }
        MailListFragment.access$8900(this.this$0);
        if (!MailListFragment.access$3600(this.this$0).isVirtual()) {
          break;
        }
        MailListFragment.access$000(this.this$0).onRefreshComplete();
        return;
        if (MailListFragment.access$3600(this.this$0).getType() == 1) {
          DataCollector.logEvent("Event_Pull_To_Refresh_Inbox");
        }
      }
      MailListFragment.access$4702(this.this$0, true);
    } while (MailListFragment.access$200(this.this$0) == null);
    MailListFragment.access$200(this.this$0).update();
    MailListFragment.refreshBeginTime = System.currentTimeMillis();
    DataCollector.logPerformanceBegin("Performance_Check_New_Mail_MailList", MailListFragment.access$2200(this.this$0), "Performance_Check_New_Mail_MailList_maillist_" + MailListFragment.access$2400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.35
 * JD-Core Version:    0.7.0.1
 */