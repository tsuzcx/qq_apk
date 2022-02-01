package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import arwt;
import arxt;
import aryy;
import ataa;
import java.io.File;
import java.io.IOException;

public class DownloadManager$21
  implements Runnable
{
  public DownloadManager$21(aryy paramaryy, Bundle paramBundle) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      String str1 = this.val$data.getString("PackageName");
      arwt.d("DownloadManager_", "receive write code msg pkgName|" + str1);
      if (str1 == null) {
        return;
      }
      localDownloadInfo = this.this$0.f(str1);
      if (localDownloadInfo == null)
      {
        arwt.d("DownloadManager_", "receive write code msg pkgName|" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
      return;
    }
    String str2 = this.val$data.getString("Code");
    arwt.d("DownloadManager_", "receive write code msg pkgName|" + localException + " code|" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localDownloadInfo.setState(4);
      localDownloadInfo.elm = 0;
      this.this$0.j(localDownloadInfo);
      this.this$0.b(4, localDownloadInfo);
      this.this$0.a(localDownloadInfo, localDownloadInfo.awN);
      arxt.X("300", localDownloadInfo.via, localDownloadInfo.appId, localDownloadInfo.extraData);
      if (localDownloadInfo.isAutoInstall) {
        this.this$0.y(localDownloadInfo);
      }
    }
    else
    {
      this.val$data.getInt("VersionCode");
      Object localObject = new File(localDownloadInfo.filePath);
      try
      {
        ataa.h((File)localObject, str2);
        localObject = ataa.z((File)localObject);
        arwt.d("DownloadManager_", "receive write code msg pkgName|" + localException + " check code|" + (String)localObject);
        bool = str2.equals(localObject);
        if (bool)
        {
          arwt.d("DownloadManager_", "receive write code msg pkgName|" + localException + " write code and check code suc");
          localDownloadInfo.elm = 0;
          this.this$0.j(localDownloadInfo);
          this.this$0.b(4, localDownloadInfo);
          this.this$0.a(localDownloadInfo, localDownloadInfo.awN);
          arxt.X("300", localDownloadInfo.via, localDownloadInfo.appId, localDownloadInfo.extraData);
          if (!localDownloadInfo.isAutoInstall) {
            return;
          }
          this.this$0.y(localDownloadInfo);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          arwt.d("DownloadManager_", "write code Exception|" + localIOException.getMessage());
          boolean bool = false;
        }
        arwt.d("DownloadManager_", "receive write code msg pkgName|" + localException + " write code or check code fail");
        localDownloadInfo.elm = -20;
        localDownloadInfo.state = -2;
        this.this$0.j(localDownloadInfo);
        this.this$0.a(localDownloadInfo, localDownloadInfo.elm, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.21
 * JD-Core Version:    0.7.0.1
 */