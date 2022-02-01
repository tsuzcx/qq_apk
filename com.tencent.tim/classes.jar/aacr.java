import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class aacr
  implements BusinessObserver
{
  public aacr(PreloadResource paramPreloadResource, WeakReference paramWeakReference, aquy paramaquy, PreloadModule paramPreloadModule) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    int i = 60;
    PreloadManager localPreloadManager1;
    label83:
    JudgeDownloadRsp localJudgeDownloadRsp;
    if (paramInt == 1)
    {
      try
      {
        localPreloadManager1 = (PreloadManager)this.eN.get();
        if (!PreloadManager.a(localPreloadManager1)) {
          return;
        }
        if (paramBoolean) {
          break label83;
        }
        localPreloadManager1.ctL();
        return;
      }
      catch (Throwable ???)
      {
        if (!QLog.isColorLevel()) {
          break label572;
        }
      }
      QLog.d("PreloadResource", 2, this.this$0.mResId + " startFlowControlReq onReceive exception:" + ???);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        localPreloadManager1.ctL();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.this$0.mResId + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (this.this$0)
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          PreloadResource.access$100(this.this$0).mDownloadStatus = 2;
          localPreloadFlowControlConfig = PreloadResource.access$100(this.this$0);
          if (localJudgeDownloadRsp.iSegTime > 60) {
            i = localJudgeDownloadRsp.iSegTime;
          }
          localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            PreloadResource.access$100(this.this$0).mRetryReqTimes = 0;
          }
          PreloadResource.access$100(this.this$0).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label520;
          }
          localPreloadManager1.ctL();
          if (this.f == null) {
            break label572;
          }
          this.this$0.notifyListenerDownloadFailInFlowControl(this.f, this.c, localPreloadManager1);
          return;
          PreloadResource.access$100(this.this$0).mDownloadStatus = 1;
          localPreloadFlowControlConfig = PreloadResource.access$100(this.this$0);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = PreloadResource.access$100(this.this$0);
            if (localJudgeDownloadRsp.iSegTime > 60) {
              i = localJudgeDownloadRsp.iSegTime;
            }
            localPreloadFlowControlConfig.mValidDownloadTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          }
          break;
        }
      }
      paramInt = 3;
      continue;
      PreloadResource.access$100(this.this$0).mDownloadStatus = 0;
      PreloadFlowControlConfig localPreloadFlowControlConfig = PreloadResource.access$100(this.this$0);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label520:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.this$0.handleFlowConfig(localPreloadManager2, this.c, this.f);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.this$0.handleFlowConfig(localPreloadManager2, this.c, this.f);
      }
      label572:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacr
 * JD-Core Version:    0.7.0.1
 */