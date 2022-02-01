import com.tencent.av.ui.funchat.record.QavRecordReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jgx
{
  private static boolean Zl;
  private static Throwable a;
  private static int azx;
  private static int azy;
  private static long po;
  private static long pp;
  private static int sErrorCode;
  
  public static void A(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportPCMSuccess success=" + paramBoolean + ", errcode=" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_convert_pcm_success", paramBoolean, 0L, 0L, localHashMap, "", false);
  }
  
  public static void awi()
  {
    azx += 1;
  }
  
  public static void awj()
  {
    if (pp < 0L) {
      pp = System.currentTimeMillis();
    }
    azy += 1;
  }
  
  public static void awk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(sErrorCode));
    localHashMap.put("device_model", aqgz.getDeviceModel());
    localHashMap.put("api", aqgz.getDeviceOSVersion());
    localHashMap.put("manufacture", aqgz.BY());
    localHashMap.put("throwable", String.valueOf(a));
    a = null;
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd params=" + localHashMap);
    }
    anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
    if (!Zl) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance("", "av_record_report_end", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void awl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", aqgz.getDeviceModel());
    localHashMap.put("api", aqgz.getDeviceOSVersion());
    localHashMap.put("manufacture", aqgz.BY());
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail  params=" + localHashMap);
    }
    anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
    if (!Zl) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance("", "av_record_audio_fail", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void awm()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportConvertPcmTimeout");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", aqgz.getDeviceModel());
    localHashMap.put("api", aqgz.getDeviceOSVersion());
    localHashMap.put("manufacture", aqgz.BY());
    anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
    if (!Zl) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance("", "av_record_convert_pcm_timeout", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void b(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onError " + paramInt);
    }
    Zl = true;
    sErrorCode = paramInt;
    a = paramThrowable;
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = po;
    long l3 = pp;
    int i = azx;
    int j = azy;
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onRecordEnd cores=" + paramInt1 + ", fqc=" + paramInt2 + ", start=" + l2 + ", end=" + l1 + ", frames=" + i + ", stopType=" + paramInt3 + ", mp4Start=" + l3 + ", mp4Frames=" + j);
    }
    ThreadManager.post(new QavRecordReporter.1(paramInt2, i, l1, l2, j, l3, paramLong, paramInt1, paramInt3), 5, null, false);
  }
  
  public static void ea(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportConvertPcmCostTime cost=" + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", aqgz.getDeviceModel());
    localHashMap.put("api", aqgz.getDeviceOSVersion());
    localHashMap.put("manufacture", aqgz.BY());
    anpc localanpc = anpc.a(BaseApplicationImpl.getContext());
    if (!Zl) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance("", "av_record_convert_pcm_cost", bool, paramLong / 1000L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void kw(String paramString)
  {
    anot.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void onRecordStart()
  {
    azx = 0;
    po = System.currentTimeMillis();
    pp = -1L;
    azy = 0;
    Zl = false;
    sErrorCode = 0;
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgx
 * JD-Core Version:    0.7.0.1
 */