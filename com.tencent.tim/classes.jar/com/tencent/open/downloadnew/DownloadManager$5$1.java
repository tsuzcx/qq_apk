package com.tencent.open.downloadnew;

import arwt;
import aryy;
import arze;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$5$1
  implements Runnable
{
  public DownloadManager$5$1(arze paramarze, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    arwt.i("DownloadManager_", "OnDownloadStateChanged,clientKey:" + this.f + ",state:" + this.val$state + ",url:" + this.val$url);
    int i = aryy.kO(this.val$state);
    arwt.v("DownloadManager_", "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.a.this$0.e(this.val$url));
    DownloadInfo localDownloadInfo = this.a.this$0.a(this.val$url, i);
    if (localDownloadInfo == null)
    {
      arwt.w("DownloadManager_", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.f != null) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.f.getDownloadTaskState(this.val$url);
        if (localTMAssistantDownloadTaskInfo == null) {
          break label448;
        }
        l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.progress = j;
        arwt.v("DownloadManager_", "OnDownloadSDKTaskStateChanged info progress = " + j);
        switch (i)
        {
        default: 
          return;
        case -2: 
          this.a.this$0.a(localDownloadInfo, l1, l2, this.val$errorCode);
          this.a.this$0.a(-2, localDownloadInfo, this.val$errorCode, this.val$errorMsg);
          return;
        }
      }
      catch (Exception localException)
      {
        arwt.e("DownloadManager_", "getDownloadTaskState>>>", localException);
        Object localObject = null;
        continue;
        this.a.this$0.b(2, localDownloadInfo);
        return;
      }
      this.a.this$0.a(localDownloadInfo, l1, l1 - localDownloadInfo.awM, "pause");
      this.a.this$0.b(3, localDownloadInfo);
      return;
      this.a.this$0.a(localDownloadInfo, 0L, l2 - localDownloadInfo.awM, "complete");
      this.a.this$0.x(localDownloadInfo);
      return;
      this.a.this$0.b(20, localDownloadInfo);
      return;
      this.a.this$0.b(10, localDownloadInfo);
      return;
      label448:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */