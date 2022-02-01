package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$9
  implements Runnable
{
  public DownloadManagerV2$9(arvv paramarvv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.b(this.a.urlStr);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        arwt.i("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo=" + localTMAssistantDownloadTaskInfo + ",writeCodeState=" + this.a.elm);
        this.a.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.a.awN = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.this$0.j(this.a);
        if ((this.a.elm != 0) && (!TextUtils.isEmpty(this.a.packageName))) {
          break label182;
        }
        this.this$0.b(4, this.a);
        if (!"1101070898".equals(this.a.appId))
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
        label182:
        arwt.e("DownloadManagerV2", "[doGeneraWriteCodeTask]>>>", localException);
      }
    }
    if (this.a.isAutoInstall) {
      this.this$0.a(this.a, false);
    }
    return;
    arwt.i("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo == null");
    arvv.b(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.9
 * JD-Core Version:    0.7.0.1
 */