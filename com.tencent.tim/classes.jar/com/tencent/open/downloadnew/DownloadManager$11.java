package com.tencent.open.downloadnew;

import android.text.TextUtils;
import arvu;
import arwt;
import aryy;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

public class DownloadManager$11
  implements Runnable
{
  public DownloadManager$11(aryy paramaryy, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2, DownloadInfo paramDownloadInfo3) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$url)) {
      arwt.v("DownloadManager_", "startDownload download file, url = " + this.val$url + "params = " + this.oN);
    }
    for (;;)
    {
      try
      {
        if (this.RK == 0)
        {
          j = this.this$0.b().startDownloadTask(this.val$url, "application/vnd.android.package-archive", this.oN);
          arwt.v("DownloadManager_", "startDownloadTask downloadSDKClient result=" + j + " url=" + this.val$url);
          if (j == 0) {
            break label282;
          }
          this.this$0.a(this.g, j, "");
          arvu.a(1, this.val$url, j, this.a);
          return;
        }
        if (this.RK == 1)
        {
          this.oN.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
          j = this.this$0.b().startDownloadTask(this.val$url, "application/tm.android.apkdiff", this.oN);
          continue;
        }
        arwt.v("DownloadManager_", "startDownload download unapk file, url = " + this.val$url + ",filename = " + this.g.packageName);
        int j = this.this$0.b().startDownloadTask(this.val$url, 0, "resource/tm.android.unknown", this.g.pushTitle, this.oN);
        continue;
        j = 3;
      }
      catch (Exception localException)
      {
        arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
      }
      continue;
      label282:
      if ((this.i == this.g) && (this.g.state == 20)) {
        this.this$0.b(20, this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.11
 * JD-Core Version:    0.7.0.1
 */