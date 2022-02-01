package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncNickWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class LoginInfoFragment$1
  implements SyncNickWatcher
{
  LoginInfoFragment$1(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onError(String paramString)
  {
    QMLog.log(6, "LoginInfoFragment", "sync nickname err.");
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "LoginInfoFragment", "sync nickname success.");
    Threads.runOnMainThread(new LoginInfoFragment.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.1
 * JD-Core Version:    0.7.0.1
 */