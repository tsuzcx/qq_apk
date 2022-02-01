package com.tencent.biz.pubaccount.weishi_new.download;

import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import ooz;

public final class WeishiDownloadUtil$3
  implements Runnable
{
  public WeishiDownloadUtil$3(DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    ooz.e("WeishiDownloadUtil", "执行下载重试!!!,downloadUrl: " + this.a.urlStr);
    arvv.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil.3
 * JD-Core Version:    0.7.0.1
 */