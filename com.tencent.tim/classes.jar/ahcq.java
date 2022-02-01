import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ahcq
  extends ahcp
  implements ahcj.a
{
  public static String TAG = "UniformDownloaderGen<FileAssistant>";
  private ahcs a;
  private ahcj.b d;
  private Object dV = new Object();
  long startTime = 0L;
  
  public ahcq(long paramLong)
  {
    super(paramLong);
  }
  
  private ahcs a()
  {
    synchronized (this.dV)
    {
      ahcs localahcs = this.a;
      return localahcs;
    }
  }
  
  private void a(ahcs paramahcs)
  {
    synchronized (this.dV)
    {
      this.a = paramahcs;
      return;
    }
  }
  
  private boolean ch(long paramLong)
  {
    ahcs localahcs = a();
    if (localahcs != null)
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] runWorker. before worker be stoped");
      localahcs.stop();
    }
    localahcs = new ahcs(this.Zd, aglz.a().getApp(), this.mUrl, this.nFileSize, this.mCookie, new ahcr(this));
    a(localahcs);
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] runWorker. start ,mTempStrFilePath=" + this.bJZ);
    return localahcs.u(this.bJZ, paramLong);
  }
  
  private void dmj()
  {
    String str = ahcj.em(1);
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null)
    {
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 1, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 1, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      return;
    }
    QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 9");
  }
  
  private void dmq()
  {
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] killWoker. ");
    ahcs localahcs = a();
    if (localahcs != null)
    {
      localahcs.stop();
      a(null);
      return;
    }
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] killWoker. not worker");
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
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] resume. ST:" + getStatus() + " PGR:" + getProgress());
    setStatus(8);
    ahcs localahcs = a();
    if (localahcs != null) {
      localahcs.dmt();
    }
    return 0;
  }
  
  public int a(ahcj.b paramb)
  {
    this.d = paramb;
    return 0;
  }
  
  public int e(String paramString, Bundle paramBundle)
  {
    super.e(paramString, paramBundle);
    paramBundle = ahcf.a().a(paramString);
    if (paramBundle != null)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + paramBundle.bJT);
      if (ahav.mI(paramBundle.bJT)) {
        this.bJZ = paramBundle.bJT;
      }
    }
    for (;;)
    {
      return 0;
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] >>>init. no exsit");
      continue;
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
      ahcf.a().b(paramString, null, this.nFileSize, this.bJZ, this.bJr);
    }
  }
  
  public int getStatus()
  {
    return super.getStatus();
  }
  
  public int pause()
  {
    int i = 0;
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] pause. not inited");
      dmj();
      if (this.d != null) {
        this.d.b(1, ahcj.em(1), null);
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = getStatus();
      if ((3 == j) || (7 == j))
      {
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] pause. had be paused");
        return 0;
      }
      try
      {
        dmq();
        QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] pause. ST:" + j + " PGR:" + getProgress());
        setStatus(3);
        if (this.d == null) {
          continue;
        }
        this.d.r(getProgress(), null);
        return 0;
      }
      finally {}
    }
  }
  
  public int start()
  {
    this.startTime = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface != null) {
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Start_download_2-3_3-1");
    }
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. not inited");
      dmj();
      if (this.d != null) {
        this.d.b(1, ahcj.em(1), null);
      }
      return -1;
    }
    String str;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. but net is broken. failed drictly");
      dmq();
      setStatus(5);
      str = ahcj.em(2);
      if (localQQAppInterface != null)
      {
        ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 2, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
        ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 2, str, 0L, getProgress() * this.nFileSize, this.nFileSize, this.mUrl, "", 0, str, null);
        anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
      }
      for (;;)
      {
        if (this.d != null) {
          this.d.b(2, "net broken", null);
        }
        return -2;
        QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 11");
      }
    }
    int i = getStatus();
    if (2 == i)
    {
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "] start. is runing");
      return 0;
    }
    if ((1 != i) && (6 != i) && (8 != i))
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. before status is error:" + i);
      return -1;
    }
    long l2 = ahav.getFileSizes(this.bJZ);
    if (l2 > this.nFileSize)
    {
      OV(0);
      long l1 = 0L;
      if (aqfo.isExistSDCard()) {
        l1 = aqfo.getSDCardAvailableSize() * 1024L;
      }
      if (l1 >= this.nFileSize - l2) {
        break label790;
      }
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] start. sd card space is no enough:[" + this.nFileSize + " " + l2 + " " + l1 + "]");
      dmq();
      setStatus(5);
      if (localQQAppInterface == null) {
        break label752;
      }
      str = ahcj.em(9);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownload", this.startTime, "", "", "", "", 9, str, 0L, l2, this.nFileSize, this.mUrl, "", 0, str, null);
      ahav.a(localQQAppInterface, this.Zd, "actFileUfGenDownloadDetail", this.startTime, "", "", "", "", 9, str, 0L, l2, this.nFileSize, this.mUrl, "", 0, str, null);
      anpb.F(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-1");
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.b(9, "no space", null);
      }
      return -2;
      OV((int)(l2 / this.nFileSize));
      break;
      label752:
      QLog.w(TAG, 1, "[UniformDL][" + this.Zd + "].report failed - 5");
    }
    for (;;)
    {
      try
      {
        label790:
        ch(l2);
        QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] start. ST:" + i + " PGR:" + getProgress());
        if (1 == i)
        {
          i = 1;
          setStatus(2);
          if ((i != 0) && (this.d != null)) {
            this.d.p(getProgress(), null);
          }
          return 0;
        }
      }
      finally {}
      i = 0;
    }
  }
  
  public int stop()
  {
    if (!isInited())
    {
      QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "] stop. not inited");
      return -1;
    }
    try
    {
      dmq();
      int i = getStatus();
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] stop. ST:" + i + " PGR:" + getProgress());
      setProgress(0);
      setStatus(7);
      return 0;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, long paramLong, Bundle paramBundle);
    
    public abstract void b(int paramInt, String paramString, Bundle paramBundle);
    
    public abstract void q(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcq
 * JD-Core Version:    0.7.0.1
 */