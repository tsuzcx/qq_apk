package com.tencent.open.downloadnew;

import arwt;
import aryy;
import arzx;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$15
  implements Runnable
{
  public DownloadManager$15(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
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
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.15
 * JD-Core Version:    0.7.0.1
 */