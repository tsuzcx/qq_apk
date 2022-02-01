package com.tencent.open.downloadnew.common;

import android.text.TextUtils;
import arwt;
import aryv;
import aryy;
import arzk;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$1
  implements Runnable
{
  PackageInstallReceiver$1(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    arwt.d(this.this$0.TAG, "ACTION_PACKAGE_REMOVED >> " + this.cCI);
    if ((!TextUtils.isEmpty(this.cCJ)) && (this.cCJ.equals(aryv.cDy)))
    {
      aryy.a().Un(true);
      arzk.a().emm();
    }
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.cCJ);
    aryy.a().b(9, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.1
 * JD-Core Version:    0.7.0.1
 */