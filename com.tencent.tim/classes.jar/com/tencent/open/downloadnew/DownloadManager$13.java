package com.tencent.open.downloadnew;

import android.text.TextUtils;
import aqap;
import arwt;
import arwu;
import arxt;
import aryy;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class DownloadManager$13
  implements Runnable
{
  public DownloadManager$13(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        if ("com.tencent.mobileqq".equals(this.a.packageName))
        {
          File localFile = new File(this.a.filePath);
          UpgradeDetailWrapper localUpgradeDetailWrapper = aqap.a().b();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = arwu.getFileMD5(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              this.this$0.a(this.a, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.a.awN = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        arwt.i("DownloadManager_", "onDownload complete, info.filePath = " + this.a.filePath);
        if ((!"com.tencent.mobileqq".equals(this.a.packageName)) || (!this.this$0.isMainProcess())) {
          break label388;
        }
        arwt.d("DownloadManager_", "QQ Download complete begin write code ......");
        this.a.elm = this.this$0.b(this.a);
        if (this.a.elm == 0) {
          break label338;
        }
        arwt.d("DownloadManager_", "QQ apk write code fail......");
        this.a.state = -2;
        this.this$0.j(this.a);
        this.this$0.a(this.a, this.a.elm, null);
      }
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
      for (;;)
      {
        arxt.X("300", this.a.via, this.a.appId, this.a.extraData);
        if (!this.a.isAutoInstall) {
          break;
        }
        this.this$0.y(this.a);
        return;
        label338:
        arwt.d("DownloadManager_", "QQ apk code suc......");
        this.this$0.j(this.a);
        this.this$0.b(4, this.a);
        long l = localException.mTotalDataLen;
        this.this$0.a(this.a, l);
      }
      label388:
      arwt.d("DownloadManager_", this.a.packageName + " Download complete begin write code ......");
      aryy.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.13
 * JD-Core Version:    0.7.0.1
 */