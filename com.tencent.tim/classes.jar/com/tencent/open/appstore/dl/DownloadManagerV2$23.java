package com.tencent.open.appstore.dl;

import arvv;
import arwt;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManagerV2$23
  implements Runnable
{
  public DownloadManagerV2$23(arvv paramarvv, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    arwt.i("DownloadManagerV2", "OnDownloadStateChanged,clientKey:" + this.f + ",state:" + this.val$state + ",url:" + this.val$url);
    int i = arvv.access$700(this.val$state);
    arwt.v("DownloadManagerV2", "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.this$0.e(this.val$url));
    DownloadInfo localDownloadInfo = arvv.a(this.this$0, this.val$url, i);
    if (localDownloadInfo == null)
    {
      arwt.w("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.f != null) {}
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.f.getDownloadTaskState(this.val$url);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        long l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        long l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.progress = j;
        localDownloadInfo.filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        arwt.v("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info progress = " + j + ", " + localTMAssistantDownloadTaskInfo.mReceiveDataLen + "|" + localTMAssistantDownloadTaskInfo.mTotalDataLen);
      }
      switch (i)
      {
      default: 
        return;
      case -2: 
        arvv.a(this.this$0, -2, localDownloadInfo, this.val$errorCode, this.val$errorMsg);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("DownloadManagerV2", "getDownloadTaskState>>>", localException);
        Object localObject = null;
      }
      this.this$0.b(2, localDownloadInfo);
      return;
    }
    this.this$0.b(3, localDownloadInfo);
    return;
    this.this$0.c(localDownloadInfo);
    return;
    this.this$0.b(20, localDownloadInfo);
    return;
    this.this$0.b(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.23
 * JD-Core Version:    0.7.0.1
 */