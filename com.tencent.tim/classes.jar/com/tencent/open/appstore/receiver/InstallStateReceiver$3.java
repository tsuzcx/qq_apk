package com.tencent.open.appstore.receiver;

import android.content.Intent;
import arwk;
import arwt;

class InstallStateReceiver$3
  implements Runnable
{
  InstallStateReceiver$3(InstallStateReceiver paramInstallStateReceiver, Intent paramIntent, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.val$intent.hasExtra("android.intent.extra.REPLACING")) {}
    for (boolean bool = this.val$intent.getBooleanExtra("android.intent.extra.REPLACING", false);; bool = false)
    {
      arwt.d("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_ADDED >> " + this.cCI + ",isReplacing:" + bool);
      if (bool) {
        return;
      }
      arwk.dA(this.cCJ, false);
      InstallStateReceiver.a(this.this$0, this.cCJ, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.3
 * JD-Core Version:    0.7.0.1
 */