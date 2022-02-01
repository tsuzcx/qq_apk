package com.tencent.qqmail.maillist.fragment;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.DataCollectorHelper;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.concurrent.Future;

class MailListFragment$2
  implements LoadListWatcher
{
  MailListFragment$2(MailListFragment paramMailListFragment) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    if ((paramInt == -2) || (paramInt == -3) || (paramInt == 0) || (paramInt == MailListFragment.access$2400(this.this$0)) || (MailListFragment.access$2400(this.this$0) == -1))
    {
      DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailList_maillist_" + paramInt, "");
      if (!MailListFragment.access$4200(this.this$0)) {
        break label138;
      }
      if (MailListFragment.access$100(this.this$0) != null) {
        MailListFragment.access$4900(this.this$0, new MailListFragment.2.4(this));
      }
      if (MailListFragment.access$000(this.this$0) != null) {
        MailListFragment.access$5000(this.this$0, new MailListFragment.2.5(this));
      }
    }
    for (;;)
    {
      MailListFragment.access$5500(this.this$0, new MailListFragment.2.8(this));
      return;
      label138:
      if ((MailListFragment.access$200(this.this$0) == null) || (MailListFragment.access$200(this.this$0).getCount() <= 0))
      {
        MailListFragment.access$5200(this.this$0, new MailListFragment.2.6(this, paramQMNetworkError));
      }
      else
      {
        if (!MailListFragment.access$4700(this.this$0)) {
          break;
        }
        MailListFragment.access$4702(this.this$0, false);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("loadMore. ");
    if (MailListFragment.access$5300(this.this$0) == null) {}
    for (String str = "";; str = MailListFragment.access$5300(this.this$0).getEmail())
    {
      DataCollectorHelper.writeRenderMailListLog("DetailEvent_Render_Maillist", paramQMNetworkError, str);
      MailListFragment.access$2102(this.this$0, false);
      if (MailListFragment.access$100(this.this$0) == null) {
        break;
      }
      MailListFragment.access$5400(this.this$0, new MailListFragment.2.7(this));
      break;
    }
  }
  
  public void onPopIn(long paramLong, String paramString)
  {
    if (MailListFragment.access$100(this.this$0) != null) {
      MailListFragment.access$4800(this.this$0, new MailListFragment.2.3(this, paramLong, paramString));
    }
  }
  
  public void onProcess(int paramInt, boolean paramBoolean)
  {
    if ((MailListFragment.access$3900(this.this$0) == null) || (!MailListFragment.access$3900(this.this$0).isDone())) {}
    while ((paramInt != -2) && (paramInt != -3) && (paramInt != 0) && (paramInt != MailListFragment.access$2400(this.this$0)) && (MailListFragment.access$2400(this.this$0) != -1)) {
      return;
    }
    MailListFragment.access$4202(this.this$0, paramBoolean);
    MailListFragment.access$4600(this.this$0, new MailListFragment.2.2(this));
    MailListFragment.access$4702(this.this$0, false);
  }
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    if ((MailListFragment.access$3900(this.this$0) == null) || (!MailListFragment.access$3900(this.this$0).isDone())) {}
    label137:
    label191:
    for (;;)
    {
      return;
      paramInt2 = i;
      if (paramInt1 != -2)
      {
        paramInt2 = i;
        if (paramInt1 != -3)
        {
          paramInt2 = i;
          if (paramInt1 != 0)
          {
            paramInt2 = i;
            if (paramInt1 != MailListFragment.access$2400(this.this$0))
            {
              if (MailListFragment.access$2400(this.this$0) != -1) {
                break label137;
              }
              paramInt2 = i;
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt2 == 0) {
          break label191;
        }
        DataCollector.logPerformanceEnd("Performance_Check_New_Mail_MailList_maillist_" + paramInt1, "");
        if (MailListFragment.access$200(this.this$0) == null) {
          break;
        }
        MailListFragment.access$4500(this.this$0, new MailListFragment.2.1(this, paramBoolean));
        return;
        if ((MailListFragment.access$3600(this.this$0) != null) && (MailListFragment.access$3600(this.this$0).getType() == 1))
        {
          QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramInt1);
          if (localQMFolder != null)
          {
            paramInt2 = i;
            if (localQMFolder.getType() == 15) {
              continue;
            }
          }
        }
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.2
 * JD-Core Version:    0.7.0.1
 */