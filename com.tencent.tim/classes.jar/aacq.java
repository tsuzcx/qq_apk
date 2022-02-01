import Wallet.DownloadReportReq;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class aacq
  extends aquy
{
  private boolean bvd;
  
  public aacq(PreloadResource paramPreloadResource, int paramInt, WeakReference paramWeakReference, aquy paramaquy, long paramLong) {}
  
  public void onDoneFile(aquz paramaquz)
  {
    Object localObject = (PreloadManager)this.eN.get();
    if (PreloadManager.a((PreloadManager)localObject)) {
      ((PreloadManager)localObject).ctL();
    }
    if (this.f != null) {
      this.f.onDoneFile(paramaquz);
    }
    localObject = new DownloadReportReq();
    int i;
    File localFile;
    long l;
    if (paramaquz.errCode == 0)
    {
      ((DownloadReportReq)localObject).iType = 1;
      int j = -1;
      i = j;
      if (paramaquz.ov != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramaquz.key))
        {
          localFile = (File)paramaquz.ov.get(paramaquz.key);
          if (localFile != null) {
            break label242;
          }
          l = -2L;
          label113:
          i = (int)l;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((DownloadReportReq)localObject).vecResInfo = this.this$0.getMyResInfos(i);
        ((DownloadReportReq)localObject).iUin = this.val$uin;
        ((DownloadReportReq)localObject).sPhoneType = aqgz.getModel();
        ((DownloadReportReq)localObject).sOsVersion = aqgz.getDeviceOSVersion();
        ((DownloadReportReq)localObject).sQQVersion = aqgz.getQQVersion();
        ((DownloadReportReq)localObject).iScene = paramaquz.getParams().getInt("scene");
        zyb.a((JceStruct)localObject, null);
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.this$0.mResId + " flow down result:" + paramaquz.errCode + localObject);
        }
        return;
        ((DownloadReportReq)localObject).iType = 2;
        break;
        try
        {
          label242:
          if (localFile.exists())
          {
            l = localFile.length();
            break label113;
          }
          l = -3L;
        }
        catch (Throwable localThrowable)
        {
          i = -4;
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void onProgress(aquz paramaquz)
  {
    double d;
    if (!this.bvd)
    {
      this.bvd = true;
      long l1 = System.currentTimeMillis();
      long l2 = paramaquz.atZ;
      d = paramaquz.atY / (l1 - l2);
      if (d >= 1.0D) {
        break label43;
      }
    }
    label43:
    do
    {
      return;
      paramaquz = new DownloadReportReq();
      paramaquz.sSpeed = (d + "");
      paramaquz.vecResInfo = this.this$0.getMyResInfos();
      paramaquz.iType = 0;
      paramaquz.iUin = this.val$uin;
      zyb.a(paramaquz, null);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, this.this$0.mResId + " flow down speed:" + d);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    int i = 3;
    paramaquz.atY = 1048576L;
    if (this.cgg > 3) {
      i = this.cgg;
    }
    paramaquz.retryCount = i;
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacq
 * JD-Core Version:    0.7.0.1
 */