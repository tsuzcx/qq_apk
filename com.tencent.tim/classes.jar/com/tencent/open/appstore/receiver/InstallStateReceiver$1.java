package com.tencent.open.appstore.receiver;

import android.text.TextUtils;
import arvv;
import arwt;
import aryv;
import arzk;
import com.tencent.open.downloadnew.DownloadInfo;

class InstallStateReceiver$1
  implements Runnable
{
  InstallStateReceiver$1(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    arwt.d("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + this.cCI);
    if ((!TextUtils.isEmpty(this.cCJ)) && (this.cCJ.equals(aryv.cDy)))
    {
      arvv.a().Un(true);
      arzk.a().emm();
    }
    DownloadInfo localDownloadInfo = arvv.a().f(this.cCJ);
    arvv.a().l(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.1
 * JD-Core Version:    0.7.0.1
 */