import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ahcl
  extends ahcp
  implements ahcj.a
{
  public static String TAG = "UniformDownloaderAppBaby<FileAssistant>";
  private boolean cgb;
  private ahcj.b d;
  private Object dO = new Object();
  long startTime = 0L;
  
  public ahcl(long paramLong)
  {
    super(paramLong);
  }
  
  private int EP()
  {
    int i = ahcn.a().a(this.Zd, this.mUrl, this.nFileSize, new ahcm(this));
    if (i == 0) {
      Kj(true);
    }
    return i;
  }
  
  private void Kj(boolean paramBoolean)
  {
    synchronized (this.dO)
    {
      this.cgb = paramBoolean;
      return;
    }
  }
  
  private boolean amP()
  {
    synchronized (this.dO)
    {
      boolean bool = this.cgb;
      return bool;
    }
  }
  
  private void dmj()
  {
    String str = ahcj.em(1);
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null)
    {
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownload", this.startTime, "", "", "", "", 1, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownloadDetail", this.startTime, "", "", "", "", 1, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
      return;
    }
    QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 9");
  }
  
  public int EN()
  {
    int i = 0;
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] resume. not inited");
      dmj();
      if (this.d != null) {
        this.d.b(1, ahcj.em(1), null);
      }
      i = -1;
    }
    do
    {
      return i;
      int j = getStatus();
      if ((6 == j) || (2 == j) || (4 == j))
      {
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] resume. had be resumed");
        return 0;
      }
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] resume. ST:" + j + " PGR:" + getProgress());
      setStatus(6);
    } while (this.d == null);
    this.d.s(getProgress(), null);
    return 0;
  }
  
  public int EO()
  {
    return 0;
  }
  
  public int a(ahcj.b paramb)
  {
    this.d = paramb;
    return 0;
  }
  
  public int e(String paramString, Bundle paramBundle)
  {
    return super.e(paramString, paramBundle);
  }
  
  public int getStatus()
  {
    return super.getStatus();
  }
  
  public int pause()
  {
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] pause. not inited");
      dmj();
      if (this.d != null) {
        this.d.b(1, ahcj.em(1), null);
      }
      i = -1;
      return i;
    }
    boolean bool = amP();
    int i = getStatus();
    if ((1 == i) || (!bool))
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] waiting and pause. ST:" + i + " PGR:" + getProgress() + "(inited)");
      setStatus(3);
      if (this.d != null) {
        this.d.r(getProgress(), null);
      }
      return 0;
    }
    if ((3 == i) || (7 == i))
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] pause. had be paused");
      return 0;
    }
    int j = ahcn.a().dk(this.mUrl);
    if (j == 0)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] pause. ST:" + i + " PGR:" + getProgress());
      setStatus(3);
      return j;
    }
    QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] pause failed. ST:" + i + " PGR:" + getProgress());
    setStatus(5);
    String str = ahcj.em(15);
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null)
    {
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownload", this.startTime, "", "", "", "", 15, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownloadDetail", this.startTime, "", "", "", "", 15, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      i = j;
      if (this.d == null) {
        break;
      }
      this.d.b(15, null, null);
      return j;
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 8");
    }
  }
  
  public int start()
  {
    this.startTime = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null) {
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-0");
    }
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. not inited");
      dmj();
      if (this.d != null) {
        this.d.b(1, ahcj.em(1), null);
      }
      i = -1;
      return i;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      setStatus(5);
      str = ahcj.em(2);
      if (localQQAppInterface != null)
      {
        ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownload", this.startTime, "", "", "", "", 2, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
        ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownloadDetail", this.startTime, "", "", "", "", 2, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
        anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
      }
      for (;;)
      {
        if (this.d != null) {
          this.d.b(2, str, null);
        }
        return -1;
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 8");
      }
    }
    int i = getStatus();
    if (2 == i)
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i))
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. before status is error:" + i);
      return -1;
    }
    OV(0);
    if (1 == i)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] start download. AddDownloadToAppBabySdk");
      EP();
    }
    int j;
    for (;;)
    {
      j = ahcn.a().dj(this.mUrl);
      if (j != 0) {
        break;
      }
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] start. ST:" + i + " PGR:" + getProgress());
      setStatus(2);
      return j;
      if ((6 == i) && (!ahcn.a().mK(this.mUrl)))
      {
        QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
        EP();
      }
    }
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] start failed. ST:" + i + " PGR:" + getProgress());
    setStatus(5);
    String str = ahcj.em(5);
    if (localQQAppInterface != null)
    {
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownload", this.startTime, "", "", "", "", 5, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfAppBabySdkDownloadDetail", this.startTime, "", "", "", "", 5, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      i = j;
      if (this.d == null) {
        break;
      }
      this.d.b(5, null, null);
      return j;
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 8");
    }
  }
  
  public int stop()
  {
    int i = getStatus();
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] stop. ST:" + i + " PGR:" + getProgress());
    setStatus(7);
    return ahcn.a().dl(this.mUrl);
  }
  
  public static abstract interface a
  {
    public abstract void G(String paramString, Bundle paramBundle);
    
    public abstract void b(int paramInt, String paramString, Bundle paramBundle);
    
    public abstract void cE(Bundle paramBundle);
    
    public abstract void cF(Bundle paramBundle);
    
    public abstract void cG(Bundle paramBundle);
    
    public abstract void q(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcl
 * JD-Core Version:    0.7.0.1
 */