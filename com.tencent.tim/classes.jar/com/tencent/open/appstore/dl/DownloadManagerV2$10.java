package com.tencent.open.appstore.dl;

import acfp;
import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$10
  implements Runnable
{
  public DownloadManagerV2$10(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.elm = arvv.a(this.this$0, this.a);
    if (this.a.elm != 0)
    {
      arwt.i("DownloadManagerV2", acfp.m(2131705279));
      this.a.setState(-2);
      this.a.progress = 100;
      arvv.a(this.this$0, this.a, this.a.elm, null);
      return;
    }
    arwt.v("DownloadManagerV2", acfp.m(2131705293));
    this.a.setState(4);
    this.a.progress = 100;
    this.this$0.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */