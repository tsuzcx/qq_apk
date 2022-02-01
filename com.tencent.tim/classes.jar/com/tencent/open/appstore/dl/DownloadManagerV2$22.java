package com.tencent.open.appstore.dl;

import android.os.Bundle;
import android.text.TextUtils;
import arvv;
import arwk;
import arwt;
import aryv;
import ataa;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.io.IOException;

public class DownloadManagerV2$22
  implements Runnable
{
  public DownloadManagerV2$22(arvv paramarvv, Bundle paramBundle) {}
  
  public void run()
  {
    String str1;
    try
    {
      Object localObject1 = this.val$data.getString(aryv.PARAM_TICKET);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      localObject1 = this.this$0.d((String)localObject1);
      str1 = this.val$data.getString("PackageName");
      if (localObject1 == null)
      {
        arwt.e("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + str1 + " download info is null");
        return;
      }
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "[writeApkCodeAsync] >>>", localException);
      return;
    }
    String str2 = this.val$data.getString("Code");
    arwt.i("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + ", code=" + str2);
    if (TextUtils.isEmpty(str2))
    {
      localException.elm = 0;
      localException.setState(4);
      this.this$0.j(localException);
      this.this$0.b(4, localException);
      this.this$0.a(localException, localException.awN);
      arwt.i("AppCenterReporter", "from:[writeApkCodeAsync] code is empty");
      arwk.r(localException);
      if (localException.isAutoInstall) {
        this.this$0.a(localException, false);
      }
    }
    else
    {
      this.val$data.getInt("VersionCode");
      Object localObject2 = new File(localException.filePath);
      try
      {
        ataa.h((File)localObject2, str2);
        localObject2 = ataa.z((File)localObject2);
        arwt.i("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + ",check code=" + (String)localObject2);
        bool = str2.equals(localObject2);
        if (bool)
        {
          arwt.i("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + str1 + " write code and check code suc");
          localException.elm = 0;
          this.this$0.j(localException);
          this.this$0.b(4, localException);
          this.this$0.a(localException, localException.awN);
          arwt.i("AppCenterReporter", "from:[writeApkCodeAsync] APK_WRITE_CODE_SUC");
          arwk.r(localException);
          if (!localException.isAutoInstall) {
            return;
          }
          this.this$0.a(localException, false);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          arwt.i("DownloadManagerV2", "[writeApkCodeAsync] Exception=" + localIOException.getMessage());
          boolean bool = false;
        }
        arwt.i("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + str1 + " write code or check code fail");
        localException.elm = -20;
        localException.setState(-2);
        this.this$0.j(localException);
        arvv.a(this.this$0, localException, localException.elm, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.22
 * JD-Core Version:    0.7.0.1
 */