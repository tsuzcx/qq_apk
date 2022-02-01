package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.List;
import mrm;
import mrn;
import mro;

public class ADVideoAppDownloadManager$5$1
  implements Runnable
{
  public ADVideoAppDownloadManager$5$1(mrn parammrn, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.a.this$0.fP.iterator();
    mrm localmrm;
    label233:
    do
    {
      int j;
      int i;
      while (((Iterator)localObject1).hasNext())
      {
        localmrm = (mrm)((Iterator)localObject1).next();
        Object localObject2 = localmrm.mDownloadUrl;
        j = this.a.this$0.a(localmrm);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.ajI)) && (((String)localObject2).equals(this.ajI)) && ((j == 0) || (j == 4) || (j == 3)))
        {
          localObject2 = arvv.a().b((String)localObject2);
          i = 0;
          if (localObject2 != null) {
            i = (int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen * 100.0F);
          }
          if ((j != 3) || (this.aTR != 3)) {
            break label233;
          }
          this.a.this$0.d(localmrm);
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).packageName = localmrm.mPackageName;
          ((DownloadInfo)localObject1).progress = i;
          ((DownloadInfo)localObject1).appId = localmrm.mAppID;
          ADVideoAppDownloadManager.a(this.a.this$0).resumeDownload = true;
          ADVideoAppDownloadManager.a(this.a.this$0).aRA();
          this.a.this$0.a((DownloadInfo)localObject1, 4);
        }
      }
      return;
      if ((j == 4) && ((this.aTR == 2) || (this.aTR == 1)))
      {
        this.a.this$0.a(localmrm);
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).packageName = localmrm.mPackageName;
        ((DownloadInfo)localObject1).progress = i;
        ((DownloadInfo)localObject1).appId = localmrm.mAppID;
        ADVideoAppDownloadManager.a(this.a.this$0).resumeDownload = true;
        ADVideoAppDownloadManager.a(this.a.this$0).aRA();
        this.a.this$0.a((DownloadInfo)localObject1, 3);
        return;
      }
    } while (this.aTR != 4);
    localObject1 = new DownloadInfo();
    ((DownloadInfo)localObject1).packageName = localmrm.mPackageName;
    ((DownloadInfo)localObject1).progress = 100;
    ((DownloadInfo)localObject1).appId = localmrm.mAppID;
    ADVideoAppDownloadManager.a(this.a.this$0).resumeDownload = true;
    ADVideoAppDownloadManager.a(this.a.this$0).aRA();
    this.a.this$0.a((DownloadInfo)localObject1, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */