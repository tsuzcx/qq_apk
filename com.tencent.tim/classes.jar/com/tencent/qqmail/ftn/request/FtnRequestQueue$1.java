package com.tencent.qqmail.ftn.request;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class FtnRequestQueue$1
  implements AccountLoginWatcher
{
  FtnRequestQueue$1(FtnRequestQueue paramFtnRequestQueue) {}
  
  public void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    paramInt2 = 0;
    FtnRequestQueue.access$000(this.this$0, false);
    paramString = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (paramString != null)
    {
      FtnRequestQueue.access$102(this.this$0, paramString.getId());
      FtnRequestQueue.access$202(this.this$0, paramString);
    }
    paramString = "";
    if (paramQMNetworkError != null)
    {
      paramInt2 = paramQMNetworkError.code;
      paramString = paramQMNetworkError.desp;
    }
    QMLog.log(4, "FtnRequestQueue", "Ftn autologin login watcher on error id: " + paramInt1 + " currentid: " + paramLong + " errorcode: " + paramInt2 + " errordesp: " + paramString);
  }
  
  public void onProcess(int paramInt, long paramLong) {}
  
  public void onSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    FtnRequestQueue.access$000(this.this$0, false);
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount != null)
    {
      FtnRequestQueue.access$102(this.this$0, localQQMailAccount.getId());
      FtnRequestQueue.access$202(this.this$0, localQQMailAccount);
    }
    FtnRequestQueue.access$300(this.this$0).sendEmptyMessage(11);
    QMLog.log(4, "FtnRequestQueue", "Ftn autologin login watcher on success id: " + paramInt + " currentid: " + paramLong + " defaultid: " + FtnRequestQueue.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FtnRequestQueue.1
 * JD-Core Version:    0.7.0.1
 */