package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class LoginInfoFragment$2
  implements SyncPhotoWatcher
{
  LoginInfoFragment$2(LoginInfoFragment paramLoginInfoFragment) {}
  
  public void onError(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "LoginInfoFragment", "addAccount syncPhotoWatcher err");
  }
  
  public void onSuccess(List<String> paramList)
  {
    Threads.runOnMainThread(new LoginInfoFragment.2.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginInfoFragment.2
 * JD-Core Version:    0.7.0.1
 */