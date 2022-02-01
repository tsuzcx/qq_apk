package com.tencent.open.appstore.dl;

import arvv;
import arwk;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$6
  implements Runnable
{
  public DownloadManagerV2$6(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.this$0.j(this.a);
        this.this$0.b(4, this.a);
      }
      arwt.i("AppCenterReporter", "from:[onDownloadComplete]");
      arwk.r(this.a);
      this.this$0.a(this.a, false);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.6
 * JD-Core Version:    0.7.0.1
 */