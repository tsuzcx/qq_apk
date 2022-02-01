package com.tencent.open.downloadnew;

import aroi;
import arwt;
import arxn;
import aryy;
import asac;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$2
  implements Runnable
{
  public DownloadManager$2(aryy paramaryy) {}
  
  public void run()
  {
    this.this$0.jn = ((ConcurrentHashMap)asac.a().aD());
    try
    {
      DownloadInfo localDownloadInfo = this.this$0.f("com.tencent.mobileqq");
      if ((localDownloadInfo != null) && (localDownloadInfo.downloadType == 0))
      {
        String str = "";
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1;
        if (localDownloadInfo.updateType == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = this.this$0.b(localDownloadInfo.urlStr);
          localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            str = localTMAssistantDownloadTaskInfo2.mSavePath;
            localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          }
        }
        while (localTMAssistantDownloadTaskInfo1 == null)
        {
          this.this$0.jn.remove(localDownloadInfo.appId);
          asac.a().Xv(localDownloadInfo.appId);
          return;
          localTMAssistantDownloadTaskInfo1 = this.this$0.b(localDownloadInfo.cDF);
          str = localDownloadInfo.filePath;
        }
        if ((localTMAssistantDownloadTaskInfo1.mState == 4) && (arxn.bt(str) <= aroi.a().getAppVersionCode()))
        {
          this.this$0.jn.remove(localDownloadInfo.appId);
          asac.a().Xv(localDownloadInfo.appId);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "speical clear>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.2
 * JD-Core Version:    0.7.0.1
 */