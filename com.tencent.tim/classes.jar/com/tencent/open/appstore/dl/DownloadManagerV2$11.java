package com.tencent.open.appstore.dl;

import arvt;
import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$11
  implements Runnable
{
  public DownloadManagerV2$11(arvv paramarvv, String paramString) {}
  
  public void run()
  {
    if (arvv.a(this.this$0).get(this.cCF) != null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      localDownloadInfo = arvt.a().d(this.cCF);
    } while (localDownloadInfo == null);
    this.this$0.j(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */