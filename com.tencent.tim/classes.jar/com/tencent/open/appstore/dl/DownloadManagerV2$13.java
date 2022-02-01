package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Map;

public class DownloadManagerV2$13
  implements Runnable
{
  public DownloadManagerV2$13(arvv paramarvv, String paramString, Map paramMap, int paramInt, DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$url)) {
      arwt.i("DownloadManagerV2", "startDownload download file, url = " + this.val$url + "params = " + this.oN);
    }
    do
    {
      for (;;)
      {
        try
        {
          int i;
          if (this.RK == 0)
          {
            i = arvv.a(this.this$0).startDownloadTask(this.val$url, "application/vnd.android.package-archive", this.oN);
            arwt.i("DownloadManagerV2", "startDownloadTask downloadSDKClient result=" + i + " url=" + this.val$url);
            if (i == 0) {
              break;
            }
            arvv.a(this.this$0, this.g, i, "");
            return;
          }
          if (this.RK == 1)
          {
            this.oN.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
            i = arvv.a(this.this$0).startDownloadTask(this.val$url, "application/tm.android.apkdiff", this.oN);
          }
          else
          {
            arwt.v("DownloadManagerV2", "startDownload download unapk file, url = " + this.val$url + ",filename = " + this.g.packageName);
            i = arvv.a(this.this$0).startDownloadTask(this.val$url, 0, "resource/tm.android.unknown", this.g.pushTitle, this.oN);
            continue;
            i = 3;
          }
        }
        catch (Exception localException)
        {
          arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
        }
      }
    } while ((this.h != this.g) || (this.g.getState() != 20));
    this.this$0.b(20, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.13
 * JD-Core Version:    0.7.0.1
 */