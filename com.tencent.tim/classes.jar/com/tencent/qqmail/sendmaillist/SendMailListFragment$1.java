package com.tencent.qqmail.sendmaillist;

import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;
import java.util.Iterator;

class SendMailListFragment$1
  implements QMGetVerifyImageWatcher
{
  SendMailListFragment$1(SendMailListFragment paramSendMailListFragment) {}
  
  public void onError(int paramInt, String paramString, QMNetworkError paramQMNetworkError)
  {
    if (SendMailListFragment.access$000(this.this$0) == null) {}
    do
    {
      return;
      while (!paramString.hasNext()) {
        paramString = SendMailListFragment.access$000(this.this$0).iterator();
      }
    } while (paramInt != ((QMTask)paramString.next()).getId());
    SendMailListFragment.access$400(this.this$0, new SendMailListFragment.1.2(this));
  }
  
  public void onProcess(int paramInt, String paramString) {}
  
  public void onSuccess(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((SendMailListFragment.access$000(this.this$0) == null) || (!SendMailListFragment.access$100(this.this$0).isActivityResumed())) {}
    QMTask localQMTask;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = SendMailListFragment.access$000(this.this$0).iterator();
      }
      localQMTask = (QMTask)localIterator.next();
    } while (paramInt != localQMTask.getId());
    SendMailListFragment.access$300(this.this$0, new SendMailListFragment.1.1(this, paramString2, paramString1, paramString3, paramString4, localQMTask, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.sendmaillist.SendMailListFragment.1
 * JD-Core Version:    0.7.0.1
 */