package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aroi;
import arwt;
import aryy;
import asac;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$18
  implements Runnable
{
  public DownloadManager$18(aryy paramaryy) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      if (!aroi.a().getContext().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = this.this$0.jn.values().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label173;
          }
          localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.downloadType != 0) {
            break label134;
          }
          if (localDownloadInfo.updateType != 0) {
            break;
          }
          String str = localDownloadInfo.urlStr;
          label77:
          if (this.this$0.b(str) == null)
          {
            this.this$0.jn.remove(localDownloadInfo.appId);
            asac.a().Xv(localDownloadInfo.appId);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "checkDownloadList>>>", localException);
    }
    label134:
    label173:
    do
    {
      localObject = localDownloadInfo.cDF;
      break label77;
      if (this.this$0.a(localDownloadInfo) != null) {
        break;
      }
      this.this$0.jn.remove(localDownloadInfo.appId);
      asac.a().Xv(localDownloadInfo.appId);
      break;
    } while (this.this$0.jn.size() <= 200);
    Object localObject = aroi.a().getContext().getSharedPreferences("opensdk_config", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.18
 * JD-Core Version:    0.7.0.1
 */