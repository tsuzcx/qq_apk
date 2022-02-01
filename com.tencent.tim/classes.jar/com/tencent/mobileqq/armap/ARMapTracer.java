package com.tencent.mobileqq.armap;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import anpc;
import aqgz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;

public class ARMapTracer
  implements ARGLSurfaceView.TraceCallback
{
  private static int cJQ = 0;
  private a a;
  private boolean bQI;
  private int cJR;
  private int cJS;
  private int cJT;
  private int cJU;
  private int cJV;
  private final int[] kE;
  private final int[] kF;
  private long mStartTime;
  private String mUin;
  
  public static int BU()
  {
    float f1;
    int i;
    float f2;
    if (cJQ == 0)
    {
      f1 = (float)aqgz.getSystemTotalMemory() / 1.073742E+009F;
      i = aqgz.getCpuNumber();
      f2 = (float)aqgz.getCpuMaxFreq() / 1000000.0F;
      if ((i < 4) || (f2 < 2.0F) || (f1 < 2.5F)) {
        break label106;
      }
      cJQ = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARMapTracer", 2, String.format(Locale.getDefault(), "DEV_TYPE: %d, RAM: %f, CPU-NUM: %d, CPU-Freq: %f", new Object[] { Integer.valueOf(cJQ), Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) }));
      }
      return cJQ;
      label106:
      if ((i >= 4) && (f2 >= 1.5F) && (f1 >= 1.7F)) {
        cJQ = 2;
      } else {
        cJQ = 3;
      }
    }
  }
  
  public boolean b(int[] paramArrayOfInt)
  {
    boolean bool = true;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 3) || (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] <= 0)) {
      bool = false;
    }
    float f1;
    do
    {
      float f2;
      do
      {
        do
        {
          return bool;
          f2 = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
          f1 = (paramArrayOfInt[1] + paramArrayOfInt[2]) / f2;
          f2 = paramArrayOfInt[2] / f2;
          switch (this.cJT)
          {
          }
        } while (f1 >= 0.9F);
        return false;
      } while (f2 >= 0.9F);
      return false;
    } while (f1 >= 0.9F);
    return false;
  }
  
  public void endTrace()
  {
    if (this.mStartTime == 0L) {}
    long l1;
    long l2;
    float f;
    do
    {
      return;
      l1 = SystemClock.elapsedRealtime();
      l2 = this.mStartTime;
      this.mStartTime = 0L;
      f = this.kE[0] + this.kE[1] + this.kE[2];
    } while (f <= 0.0F);
    ReportRunnable localReportRunnable = new ReportRunnable(this.mUin);
    localReportRunnable.suc = b(this.kE);
    localReportRunnable.vk = (this.cJU / f);
    localReportRunnable.vl = (this.kE[0] / f);
    localReportRunnable.vm = (this.kE[1] / f);
    localReportRunnable.vn = (this.kE[2] / f);
    localReportRunnable.duration = (l1 - l2);
    localReportRunnable.level = this.cJS;
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "\r\n duration: %d, curLevel: %d, fps [average: %s, <18: %f, 18-25: %s, >=25: %s]", new Object[] { Integer.valueOf(localReportRunnable.level), Integer.valueOf(localReportRunnable.level), Float.valueOf(localReportRunnable.vk), Float.valueOf(localReportRunnable.vl), Float.valueOf(localReportRunnable.vm), Float.valueOf(localReportRunnable.vn) }));
    }
    ThreadManager.post(localReportRunnable, 2, null, false);
  }
  
  public void startTrace()
  {
    if (this.mStartTime != 0L) {}
    do
    {
      return;
      this.mStartTime = SystemClock.elapsedRealtime();
      this.cJU = 0;
      this.cJV = 0;
      this.cJR = 0;
      int i = 0;
      while (i < this.kE.length)
      {
        this.kE[i] = 0;
        this.kF[i] = 0;
        i += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ARMapTracer", 4, "startTrace");
  }
  
  public void trace(long paramLong)
  {
    if (this.mStartTime == 0L) {
      if (this.bQI) {
        startTrace();
      }
    }
    int i;
    int[] arrayOfInt1;
    do
    {
      return;
      this.cJU = ((int)(this.cJU + paramLong));
      this.cJV += 1;
      if (paramLong >= 18L) {
        break;
      }
      i = 0;
      arrayOfInt1 = this.kE;
      arrayOfInt1[i] += 1;
      arrayOfInt1 = this.kF;
      arrayOfInt1[i] += 1;
    } while ((this.cJV < 30) || (this.a == null));
    if (this.cJR > 0) {
      this.cJR -= 1;
    }
    boolean bool = b(this.kF);
    int j = this.cJS;
    if (this.cJR > 0) {
      i = j;
    }
    for (;;)
    {
      if ((i != this.cJS) && (this.cJT > 2) && (this.a.iO(i)))
      {
        this.cJS = i;
        this.cJR = 3;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "isOk: %b, mLastRecommendFlag: %d, recommendLevel: %d, mCurLevel: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.cJR), Integer.valueOf(i), Integer.valueOf(this.cJS) }));
      }
      this.cJV = 0;
      arrayOfInt1 = this.kF;
      int[] arrayOfInt2 = this.kF;
      this.kF[2] = 0;
      arrayOfInt2[1] = 0;
      arrayOfInt1[0] = 0;
      return;
      if (paramLong < 25L)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      i = j;
      if (!bool)
      {
        i = j;
        if (this.cJS > 8) {
          i = this.cJS - 1;
        }
      }
    }
  }
  
  public static class GLHackTask
    implements Runnable
  {
    private static GLHackTask b;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    private GLHackTask a;
    private WeakReference<ARGLSurfaceView> gA;
    private Runnable task;
    
    public GLHackTask(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
    {
      this.task = paramRunnable;
      this.a = null;
      this.gA = new WeakReference(paramARGLSurfaceView);
    }
    
    public static GLHackTask a(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
    {
      synchronized (sPoolSync)
      {
        if (b != null)
        {
          GLHackTask localGLHackTask = b;
          b = localGLHackTask.a;
          localGLHackTask.a = null;
          localGLHackTask.task = paramRunnable;
          localGLHackTask.gA = new WeakReference(paramARGLSurfaceView);
          sPoolSize -= 1;
          return localGLHackTask;
        }
        return new GLHackTask(paramRunnable, paramARGLSurfaceView);
      }
    }
    
    private void recycle()
    {
      this.task = null;
      this.gA = null;
      synchronized (sPoolSync)
      {
        if (sPoolSize < 50)
        {
          this.a = b;
          b = this;
          sPoolSize += 1;
        }
        return;
      }
    }
    
    public void run()
    {
      long l = SystemClock.elapsedRealtime();
      if ((this.task != null) && (this.gA.get() != null) && (!((ARGLSurfaceView)this.gA.get()).mIsDestroyed)) {
        this.task.run();
      }
      l = SystemClock.elapsedRealtime() - l;
      String str2;
      if ((QLog.isDevelopLevel()) && (l > 33L))
      {
        str2 = GLHackTask.class.getSimpleName();
        if (this.task == null) {
          break label122;
        }
      }
      label122:
      for (String str1 = this.task.getClass().getName();; str1 = "default")
      {
        QLog.d(str2, 2, new Object[] { "%s cost: %d", str1, Long.valueOf(l) });
        recycle();
        return;
      }
    }
  }
  
  public static class ReportRunnable
    implements Runnable
  {
    public long duration;
    public int level;
    public boolean suc;
    public String uin;
    public float vk;
    public float vl;
    public float vm;
    public float vn;
    
    public ReportRunnable(String paramString)
    {
      this.uin = paramString;
    }
    
    public void run()
    {
      if (this.duration < 0L) {
        this.duration = 0L;
      }
      for (;;)
      {
        try
        {
          this.duration /= 1000L;
          Object localObject = new HashMap(10);
          Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
          if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
          {
            i = arrayOfMemoryInfo[0].getTotalPss();
            m = arrayOfMemoryInfo[0].otherPss;
            k = arrayOfMemoryInfo[0].nativePss;
            j = arrayOfMemoryInfo[0].dalvikPss;
            ((HashMap)localObject).put("fpsAvg", String.valueOf(this.vk));
            ((HashMap)localObject).put("fps0", String.valueOf(this.vl));
            ((HashMap)localObject).put("fps18", String.valueOf(this.vm));
            ((HashMap)localObject).put("fps25", String.valueOf(this.vn));
            ((HashMap)localObject).put("duration", String.valueOf(this.duration));
            ((HashMap)localObject).put("pss", String.valueOf(i));
            ((HashMap)localObject).put("level", String.valueOf(this.level));
            ((HashMap)localObject).put("devType", String.valueOf(ARMapTracer.BU()));
            anpc.a(BaseApplication.getContext()).collectPerformance(this.uin, "actARMapTrace", this.suc, this.duration, i, (HashMap)localObject, null);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder(200);
              ((StringBuilder)localObject).append("ReportRunnable [").append("suc: ").append(this.suc).append(", duration: ").append(this.duration).append(", fpsAvg: ").append(this.vk).append(", fps0: ").append(this.vl).append(", fps18: ").append(this.vm).append(", fps25: ").append(this.vn).append(", level: ").append(this.level).append(", pss: ").append(i).append(", otherPss: ").append(m).append(", nativePss: ").append(k).append(", dalvikPss: ").append(j).append("]");
              QLog.i("ARMapTracer", 2, ((StringBuilder)localObject).toString());
            }
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int m = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean iO(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer
 * JD-Core Version:    0.7.0.1
 */