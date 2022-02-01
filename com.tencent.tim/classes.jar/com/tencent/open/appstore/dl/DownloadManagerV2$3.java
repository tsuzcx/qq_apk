package com.tencent.open.appstore.dl;

import aroi;
import arvt;
import arvv;
import arwt;
import arxn;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$3
  implements Runnable
{
  public DownloadManagerV2$3(arvv paramarvv) {}
  
  public void run()
  {
    arvv.a(this.this$0, arvt.a().D());
    Object localObject1;
    Object localObject2;
    if (arvv.a(this.this$0) != null)
    {
      localObject1 = arvv.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        if (((DownloadInfo)localObject2).getState() == 2) {
          ((DownloadInfo)localObject2).setState(3);
        }
      }
    }
    DownloadInfo localDownloadInfo;
    String str;
    for (;;)
    {
      try
      {
        localDownloadInfo = this.this$0.f("com.tencent.mobileqq");
        if (localDownloadInfo == null) {
          return;
        }
        if (localDownloadInfo.downloadType != 0) {
          return;
        }
        localObject1 = "";
        if (localDownloadInfo.updateType == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(localDownloadInfo.urlStr);
          localObject2 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
            localObject2 = localTMAssistantDownloadTaskInfo;
          }
          if (localObject2 != null) {
            break;
          }
          arvv.a(this.this$0, localDownloadInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        arwt.e("DownloadManagerV2", "speical clear>>>", localException);
        return;
      }
      localObject2 = this.this$0.b(localDownloadInfo.cDF);
      str = localDownloadInfo.filePath;
    }
    if ((((TMAssistantDownloadTaskInfo)localObject2).mState == 4) && (arxn.bt(str) <= aroi.a().getAppVersionCode())) {
      arvv.a(this.this$0, localDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.3
 * JD-Core Version:    0.7.0.1
 */