package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import arzx;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$16
  implements Runnable
{
  public DownloadManagerV2$16(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.cDF);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        arzx.a().i(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.16
 * JD-Core Version:    0.7.0.1
 */