package com.tencent.open.downloadnew;

import arwt;
import arxt;
import aryy;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$7
  implements Runnable
{
  public DownloadManager$7(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        arwt.d("DownloadManager_", "onDownloadError taskInfo != null！info.writeCodeState = " + this.a.elm);
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.a.awN = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.this$0.j(this.a);
        if (this.a.elm != 0) {
          break label184;
        }
        this.this$0.b(4, this.a);
        if (!this.a.appId.equals("1101070898"))
        {
          long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
          this.this$0.a(this.a, l);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label184:
        arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
      }
    }
    arxt.X("300", this.a.via, this.a.appId, this.a.extraData);
    if (this.a.isAutoInstall) {
      this.this$0.y(this.a);
    }
    return;
    arwt.d("DownloadManager_", "onDownloadError taskInfo == null");
    aryy.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.7
 * JD-Core Version:    0.7.0.1
 */