package com.tencent.open.model;

import android.os.Bundle;
import asaw;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class AccountManage$1
  implements Runnable
{
  public AccountManage$1(asaw paramasaw, WeakReference paramWeakReference, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void run()
  {
    SSOAccountObserver localSSOAccountObserver = (SSOAccountObserver)this.iO.get();
    if (localSSOAccountObserver != null) {
      localSSOAccountObserver.onGetTicketNoPasswd(this.val$uin, this.cDZ.getBytes(), 4096, this.ab);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.model.AccountManage.1
 * JD-Core Version:    0.7.0.1
 */