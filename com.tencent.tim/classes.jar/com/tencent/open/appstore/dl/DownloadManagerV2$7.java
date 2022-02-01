package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import aqap;
import arvv;
import arwk;
import arwt;
import arwu;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class DownloadManagerV2$7
  implements Runnable
{
  public DownloadManagerV2$7(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        if ((this.a.ddx) && ("com.tencent.mobileqq".equals(this.a.packageName)))
        {
          File localFile = new File(this.a.filePath);
          UpgradeDetailWrapper localUpgradeDetailWrapper = aqap.a().b();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = arwu.getFileMD5(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              arvv.a(this.this$0, this.a, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.a.awN = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        arwt.i("DownloadManagerV2", "onDownload complete, info.filePath = " + this.a.filePath);
        if ((!"com.tencent.mobileqq".equals(this.a.packageName)) || (!this.this$0.isMainProcess())) {
          break label388;
        }
        arwt.i("DownloadManagerV2", "QQ Download complete begin write code ......");
        this.a.elm = arvv.a(this.this$0, this.a);
        if (this.a.elm == 0) {
          break label338;
        }
        arwt.i("DownloadManagerV2", "QQ apk write code fail......");
        this.a.setState(-2);
        this.this$0.j(this.a);
        arvv.a(this.this$0, this.a, this.a.elm, null);
      }
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
      arwt.i("AppCenterReporter", "from:[doMd5CheckAndWriteCode]");
      arwk.r(this.a);
      if (this.a.isAutoInstall)
      {
        this.this$0.a(this.a, false);
        return;
        label338:
        arwt.i("DownloadManagerV2", "QQ apk code suc......");
        label388:
        do
        {
          this.this$0.j(this.a);
          this.this$0.b(4, this.a);
          long l = localException.mTotalDataLen;
          this.this$0.a(this.a, l);
          break;
        } while (TextUtils.isEmpty(this.a.packageName));
        arwt.i("DownloadManagerV2", this.a.packageName + " Download complete begin write code ......");
        arvv.b(this.this$0, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.7
 * JD-Core Version:    0.7.0.1
 */