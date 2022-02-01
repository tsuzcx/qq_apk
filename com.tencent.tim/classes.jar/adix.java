import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arengine.ARReport.10;
import com.tencent.mobileqq.ar.arengine.ARReport.11;
import com.tencent.mobileqq.ar.arengine.ARReport.12;
import com.tencent.mobileqq.ar.arengine.ARReport.13;
import com.tencent.mobileqq.ar.arengine.ARReport.14;
import com.tencent.mobileqq.ar.arengine.ARReport.16;
import com.tencent.mobileqq.ar.arengine.ARReport.2;
import com.tencent.mobileqq.ar.arengine.ARReport.3;
import com.tencent.mobileqq.ar.arengine.ARReport.4;
import com.tencent.mobileqq.ar.arengine.ARReport.5;
import com.tencent.mobileqq.ar.arengine.ARReport.6;
import com.tencent.mobileqq.ar.arengine.ARReport.7;
import com.tencent.mobileqq.ar.arengine.ARReport.8;
import com.tencent.mobileqq.ar.arengine.ARReport.9;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;

public class adix
{
  private static final FileFilter CPU_FILTER = new adiy();
  private static adix a;
  
  public static adix a()
  {
    if (a == null) {
      a = new adix();
    }
    return a;
  }
  
  public static String aA(Context paramContext)
  {
    return 2 + "";
  }
  
  private boolean bQ(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 600000L);
  }
  
  public static int getNumberOfCPUCores()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      return -1;
    }
    catch (SecurityException localSecurityException) {}
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int paramInt3)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  selectImg   mSelectTime=:  %s  mUploadTime=:  %s mImgSize=:  %s  mUploadTimes=:  %s  mImageId=:  %s mCloudTime=:  %s mCloudAllSize=:  %s mCloudAllTime=:  %s mtotaltime=:  %s  mResult=:  %s ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), Integer.valueOf(paramInt3) }));
    if (paramInt1 < 1) {
      return;
    }
    ThreadManager.post(new ARReport.3(this, paramLong1, paramLong2, paramLong3, paramInt1, paramString, paramInt2, paramLong4, paramLong5, paramLong6, paramInt3), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report Local mDataReportLoadedFeatureTimeLen=:  %s  mDataReportLoadedFeatureCnt=:  %s mDataReportFirstRecogSuccessTimeLen=:  %s  mDataReportFirstRecogSuccessFrameCnt=:  %s  mDataReportRecogQuality=:  %s mDataReportFirstRecogSuccessFeatureId=:  %s  ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString }));
    ThreadManager.post(new ARReport.4(this, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString), 5, null, false);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  CloudDownload   mImageId=:  %s mFeatureSize=:  %s mFeatureTime=:  %s mFeatureCode=:  %s  mModedSize=:  %s  mModelTime=:  %s mModelCode=:  %s mUnzipeTime=:  %s mType=:  %s totalTime=:  %s  mNetSize=:  %s mResult=:  %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt2), Long.valueOf(paramLong5), Integer.valueOf(paramInt3), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(paramInt4) }));
    ThreadManager.post(new ARReport.2(this, paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramLong4, paramInt2, paramLong5, paramInt3, paramLong6, paramLong7, paramInt4), 5, null, false);
  }
  
  public void aF(long paramLong, int paramInt)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   AREngineinitAR mTotal:  %s  result:  %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.16(this, paramLong, paramInt), 5, null, false);
  }
  
  public void ap(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARLocalControlint mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.7(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void aq(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.8(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void ar(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlinit mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.9(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void as(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglinit mTotal:  %s result:   %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.10(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void at(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.11(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void au(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARNativeBridgeSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.12(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void av(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalFaceRecogInit mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.13(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public String getCpuName()
  {
    return "un";
  }
  
  public void iJ(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  WebView mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.5(this, paramLong), 5, null, false);
  }
  
  public void iK(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARMarkerResourceManagerint mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.6(this, paramLong), 5, null, false);
  }
  
  public void iL(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   SensorTrackManagerInit mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!bQ(paramLong)) {
      return;
    }
    ThreadManager.post(new ARReport.14(this, paramLong), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adix
 * JD-Core Version:    0.7.0.1
 */