package com.tencent.mobileqq.troop.filemanager.upload;

import apef;
import apef.b;
import apfx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$1
  implements Runnable
{
  public TroopFileUploadMgr$1(apfx paramapfx) {}
  
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
    apef.b.e("TroopFileUploadMgr", apef.b.USR, "init registerConnectionChangeReceiver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1
 * JD-Core Version:    0.7.0.1
 */