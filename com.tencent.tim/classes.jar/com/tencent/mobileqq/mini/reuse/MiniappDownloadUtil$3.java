package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class MiniappDownloadUtil$3
  implements Runnable
{
  MiniappDownloadUtil$3(MiniappDownloadUtil paramMiniappDownloadUtil, Downloader.DownloadListener paramDownloadListener, String paramString) {}
  
  public void run()
  {
    if (this.val$listener != null)
    {
      String str = this.val$url;
      Object localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "--null url--";
      }
      localObject = new DownloadResult((String)localObject);
      this.val$listener.onDownloadFailed(this.val$url, (DownloadResult)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */