package com.tencent.qqmail.account;

import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class LoginManager$1
  implements Runnable
{
  LoginManager$1(LoginManager paramLoginManager, int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = LoginManager.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AccountLoginWatcher)localIterator.next()).onError(this.val$id, this.val$currentRequestId, this.val$error, this.val$email, this.val$isQQmailLogin, this.val$isLoginedAccount, this.val$outerProtocol);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager.1
 * JD-Core Version:    0.7.0.1
 */