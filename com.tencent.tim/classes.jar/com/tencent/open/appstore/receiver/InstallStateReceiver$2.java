package com.tencent.open.appstore.receiver;

import arwt;

class InstallStateReceiver$2
  implements Runnable
{
  InstallStateReceiver$2(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    arwt.d("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REPLACED >> " + this.cCI);
    InstallStateReceiver.a(this.this$0, this.cCJ, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.2
 * JD-Core Version:    0.7.0.1
 */