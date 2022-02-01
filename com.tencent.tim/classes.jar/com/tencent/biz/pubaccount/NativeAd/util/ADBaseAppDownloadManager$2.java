package com.tencent.biz.pubaccount.NativeAd.util;

import android.text.TextUtils;
import arvv;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import jzg;
import mrm;

public class ADBaseAppDownloadManager$2
  implements Runnable
{
  public ADBaseAppDownloadManager$2(jzg paramjzg, mrm parammrm, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a.mDownloadUrl;
    int i;
    int j;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((this.aEI == 4) || (this.aEI == 3)))
    {
      localObject = arvv.a().b((String)localObject);
      if (localObject != null)
      {
        i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
        j = ((TMAssistantDownloadTaskInfo)localObject).mState;
        if ((this.aEI != 3) || (j != 3)) {
          break label122;
        }
        this.this$0.d(this.a);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        this.this$0.a((DownloadInfo)localObject, 4);
      }
    }
    label122:
    do
    {
      return;
      if ((this.aEI == 4) && (j == 2))
      {
        this.this$0.a(this.a);
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).packageName = this.a.mPackageName;
        ((DownloadInfo)localObject).progress = i;
        this.this$0.a((DownloadInfo)localObject, 3);
        return;
      }
    } while (j != 4);
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).packageName = this.a.mPackageName;
    ((DownloadInfo)localObject).progress = 100;
    this.this$0.a((DownloadInfo)localObject, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */