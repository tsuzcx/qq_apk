package com.tencent.open.downloadnew;

import arwt;
import arxt;
import aryy;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$14
  implements Runnable
{
  public DownloadManager$14(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
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
      arxt.X("300", this.a.via, this.a.appId, this.a.extraData);
      this.this$0.y(this.a);
      return;
    }
    catch (Exception localException)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.14
 * JD-Core Version:    0.7.0.1
 */