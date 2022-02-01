package com.tencent.open.downloadnew.common;

import arub;
import arwt;
import aryy;
import asac;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$3
  implements Runnable
{
  PackageInstallReceiver$3(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    arwt.d(this.this$0.TAG, "ACTION_PACKAGE_ADDED >> " + this.cCI);
    DownloadInfo localDownloadInfo = asac.a().f(this.cCJ);
    if (localDownloadInfo != null)
    {
      arwt.d(this.this$0.TAG, "ACTION_PACKAGE_ADDED info != null>> " + localDownloadInfo.toString() + " " + localDownloadInfo.appId + " " + localDownloadInfo.packageName);
      aryy.a().z(localDownloadInfo);
      arub.a().a(101, localDownloadInfo);
    }
    for (;;)
    {
      aryy.a().b(6, localDownloadInfo);
      return;
      localDownloadInfo = new DownloadInfo("", this.cCJ);
      arwt.d(this.this$0.TAG, "ACTION_PACKAGE_ADDED info == null>> " + localDownloadInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.3
 * JD-Core Version:    0.7.0.1
 */