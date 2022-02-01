package com.tencent.qqmail.ftn;

import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class FtnManagerImpl$AutoLoginTask$2
  implements Observable.OnSubscribe<Void>
{
  FtnManagerImpl$AutoLoginTask$2(FtnManagerImpl.AutoLoginTask paramAutoLoginTask) {}
  
  public void call(Subscriber<? super Void> paramSubscriber)
  {
    LoginManager.shareInstance().bindLoginListener(new FtnManagerImpl.AutoLoginTask.RxLoginWatcher(this.this$0, paramSubscriber), true);
    FtnManagerImpl.access$1100().autoLogin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.AutoLoginTask.2
 * JD-Core Version:    0.7.0.1
 */