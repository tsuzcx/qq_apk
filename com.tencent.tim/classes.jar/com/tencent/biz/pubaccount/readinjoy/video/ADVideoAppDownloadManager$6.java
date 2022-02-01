package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import mrm;
import mro;

class ADVideoAppDownloadManager$6
  implements Runnable
{
  ADVideoAppDownloadManager$6(ADVideoAppDownloadManager paramADVideoAppDownloadManager, mrm parammrm, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a.mDownloadUrl;
    int i;
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = arvv.a().b((String)localObject);
      if (localObject == null) {
        break label553;
      }
      i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
      if ((this.aEI != 5) && (this.aEI != 0)) {
        break label217;
      }
      j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((j != 2) && (j != 1)) {
        break label174;
      }
      this.a.mState = 3;
      localObject = new DownloadInfo();
      ((DownloadInfo)localObject).packageName = this.a.mPackageName;
      ((DownloadInfo)localObject).progress = i;
      ((DownloadInfo)localObject).appId = this.a.mAppID;
      ADVideoAppDownloadManager.a(this.this$0).resumeDownload = true;
      ADVideoAppDownloadManager.a(this.this$0).aRA();
      if (ADVideoAppDownloadManager.a(this.this$0) != null) {
        ADVideoAppDownloadManager.a(this.this$0).aTP = i;
      }
      this.this$0.a((DownloadInfo)localObject, this.a.mState);
    }
    label174:
    label217:
    do
    {
      do
      {
        return;
        if (j == 3)
        {
          this.a.mState = 4;
          break;
        }
        if (j == 4)
        {
          this.a.mState = 5;
          break;
        }
        this.a.mState = 0;
        break;
      } while ((this.aEI != 4) && (this.aEI != 3));
      j = ((TMAssistantDownloadTaskInfo)localObject).mState;
      if ((this.aEI == 3) && (j == 3))
      {
        this.this$0.d(this.a);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        ((DownloadInfo)localObject).appId = this.a.mAppID;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((this.aEI == 4) && (j == 2))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).appId = this.a.mAppID;
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
      if ((this.aEI == 4) && (j == 3))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        ((DownloadInfo)localObject).appId = this.a.mAppID;
        this.this$0.a((DownloadInfo)localObject, 4);
        return;
      }
      if ((this.aEI == 4) && (j == 1))
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).appId = this.a.mAppID;
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (j != 4);
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).appId = this.a.mAppID;
    ((DownloadInfo)localObject).packageName = this.a.mPackageName;
    ((DownloadInfo)localObject).progress = 100;
    ADVideoAppDownloadManager.a(this.this$0).resumeDownload = true;
    ADVideoAppDownloadManager.a(this.this$0).aRA();
    this.this$0.a((DownloadInfo)localObject, 5);
    return;
    label553:
    this.this$0.a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */