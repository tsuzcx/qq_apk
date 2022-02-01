package com.tencent.open.downloadnew;

import acfp;
import arwt;
import aryy;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$6
  implements Runnable
{
  public DownloadManager$6(aryy paramaryy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.elm = this.this$0.b(this.a);
    if (this.a.elm != 0)
    {
      arwt.v("DownloadManager_", acfp.m(2131705276));
      this.a.state = -2;
      this.a.progress = 100;
      this.this$0.a(this.a, this.a.elm, null);
      return;
    }
    arwt.v("DownloadManager_", acfp.m(2131705294));
    this.a.state = 4;
    this.a.progress = 100;
    this.this$0.x(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */