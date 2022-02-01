package com.tencent.open.appcommon.now.download.local;

import arux;
import arvg;
import arvh;
import arvl;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(arvg paramarvg, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.val$netType == 4) || (this.val$netType == 3) || (this.val$netType == 2)) {
      localIterator = arvg.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      arvl localarvl = (arvl)localIterator.next();
      DownloadInfo localDownloadInfo = arux.a().c(localarvl.appId);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.getState() == 2)
        {
          if (localarvl.ddg) {
            arvh.a().fw(localarvl.appId);
          }
        }
        else if ((localDownloadInfo.getState() == 3) && (!localarvl.ddg) && (!localarvl.ddh))
        {
          arvh.a().a(null, localarvl);
          continue;
          if (this.val$netType == 1)
          {
            localIterator = arvg.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localarvl = (arvl)localIterator.next();
              localDownloadInfo = arux.a().c(localarvl.appId);
              if ((localDownloadInfo != null) && (localDownloadInfo.getState() == 3) && (!localarvl.ddh)) {
                arvh.a().a(null, localarvl);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1
 * JD-Core Version:    0.7.0.1
 */