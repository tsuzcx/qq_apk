package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aroi;
import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$20
  implements Runnable
{
  public DownloadManagerV2$20(arvv paramarvv) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      if (!aroi.a().getContext().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = arvv.a(this.this$0).values().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label139;
          }
          localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.downloadType != 0) {
            break label117;
          }
          if (localDownloadInfo.updateType != 0) {
            break;
          }
          String str = localDownloadInfo.urlStr;
          label77:
          if (this.this$0.b(str) == null) {
            arvv.a(this.this$0, localDownloadInfo);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "checkDownloadList>>>", localException);
    }
    label117:
    do
    {
      localObject = localDownloadInfo.cDF;
      break label77;
      if (this.this$0.a(localDownloadInfo) != null) {
        break;
      }
      arvv.a(this.this$0, localDownloadInfo);
      break;
    } while (arvv.a(this.this$0).size() <= 200);
    label139:
    Object localObject = aroi.a().getContext().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.20
 * JD-Core Version:    0.7.0.1
 */