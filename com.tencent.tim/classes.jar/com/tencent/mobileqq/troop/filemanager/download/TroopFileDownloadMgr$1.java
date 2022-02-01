package com.tencent.mobileqq.troop.filemanager.download;

import apef;
import apef.b;
import apew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileDownloadMgr$1
  implements Runnable
{
  public TroopFileDownloadMgr$1(apew paramapew) {}
  
  public void run()
  {
    if (this.this$0.cQf) {
      return;
    }
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface != null)
    {
      AppNetConnInfo.registerConnectionChangeReceiver(localQQAppInterface.getApplication(), this.this$0);
      this.this$0.cQf = true;
      return;
    }
    apef.b.e("TroopFileDownloadMgr", apef.b.USR, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1
 * JD-Core Version:    0.7.0.1
 */