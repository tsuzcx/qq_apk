package com.tencent.open.downloadnew.common;

import arwt;
import aryy;
import com.tencent.open.downloadnew.DownloadInfo;

class PackageInstallReceiver$2
  implements Runnable
{
  PackageInstallReceiver$2(PackageInstallReceiver paramPackageInstallReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    arwt.d(this.this$0.TAG, "ACTION_PACKAGE_REPLACED >> " + this.cCI);
    DownloadInfo localDownloadInfo = new DownloadInfo("", this.cCJ);
    aryy.a().b(13, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver.2
 * JD-Core Version:    0.7.0.1
 */