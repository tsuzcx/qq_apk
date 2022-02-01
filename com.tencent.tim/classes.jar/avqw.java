import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.util.CpuUtils;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QzoneHardwareRestriction;
import mqq.app.MobileQQ;

public class avqw
{
  private static int aeV = -1;
  private static long jV = -1L;
  
  public static void a(long paramLong, Activity paramActivity, String paramString, avqw.b paramb)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    avqw.a locala1 = b();
    avqw.a locala2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + locala1.isAvailable() + ", support trim=" + locala2.isAvailable());
    }
    if ((!locala1.isAvailable()) && (!locala2.isAvailable()))
    {
      if (locala1.aLp()) {}
      for (paramString = locala1.getTip();; paramString = null)
      {
        String str;
        if (paramString != null)
        {
          str = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          str = paramActivity.getString(2131718253);
        }
        if (paramb != null) {
          paramb.onFail(paramActivity, str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + locala1.getTip() + ",trimSupport tips=" + locala2.getTip() + ",show tips=" + str);
        return;
      }
    }
    a(paramLong, paramActivity, locala1.isAvailable(), locala2.isAvailable(), paramString);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void a(long paramLong, Activity paramActivity, String paramString, avqw.b paramb, Bundle paramBundle)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    avqw.a locala1 = b();
    avqw.a locala2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + locala1.isAvailable() + ", support trim=" + locala2.isAvailable());
    }
    if ((!locala1.isAvailable()) && (!locala2.isAvailable()))
    {
      if (locala1.aLp()) {}
      for (paramString = locala1.getTip();; paramString = null)
      {
        if (paramString != null)
        {
          paramBundle = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          paramBundle = paramActivity.getString(2131718253);
        }
        if (paramb != null) {
          paramb.onFail(paramActivity, paramBundle);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + locala1.getTip() + ",trimSupport tips=" + locala2.getTip() + ",show tips=" + paramBundle);
        return;
      }
    }
    a(paramLong, paramActivity, false, false, paramString, paramBundle);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("flow_camera_capture_mode", false);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivityForEditVideo");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    localIntent.putExtras(paramBundle);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("is_qzone_vip", paramBoolean3);
    localIntent.putExtra("enable_edit_video", paramBoolean4);
    localIntent.putExtra("topicId", paramString2);
    localIntent.putExtra("enterPtu", paramBoolean5);
    if (!TextUtils.isEmpty(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoCommonUtils", 2, "callback:" + paramString3 + " id:" + paramString4);
      }
      localIntent.putExtra("callback", paramString3);
      localIntent.putExtra("dongxiao_id", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString2, String paramString3, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", b().isAvailable());
    localIntent.putExtra("support_trim", c().isAvailable());
    localIntent.putExtra("uin", "0");
    localIntent.putExtra("is_qzone_vip", paramBoolean1);
    localIntent.putExtra("enable_edit_video", true);
    localIntent.putExtra("enterPtu", true);
    localIntent.putExtra("enable_local_button", paramBoolean6);
    localIntent.putExtra("enable_edit_button", paramBoolean3);
    localIntent.putExtra("callback", "qzoneOpenDongXiao");
    localIntent.putExtra("dongxiao_id", paramString2);
    localIntent.putExtra("enable_priv_list", false);
    localIntent.putExtra("enable_input_text", paramBoolean2);
    if (paramBoolean2) {
      localIntent.putExtra("enable_sync_qzone", paramBoolean4);
    }
    localIntent.putExtra("enable_origin_video", paramBoolean5);
    localIntent.putExtra("confirm_text", paramString3);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  private static void ahe()
  {
    if (Build.CPU_ABI.contains("armeabi"))
    {
      aeV = 1;
      return;
    }
    if (Build.CPU_ABI.contains("x86"))
    {
      aeV = 2;
      return;
    }
    if (Build.CPU_ABI.contains("mips"))
    {
      aeV = 3;
      return;
    }
    aeV = 0;
  }
  
  public static avqw.a b()
  {
    int j = -1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "SupportMiniVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severBlackList");
      }
      return avqw.a.c;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("GN9000L|ASUS_T00F|H30-T00".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localBlackList");
      }
      return avqw.a.c;
    }
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severWhiteList");
      }
      i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinSdkVersion", 21);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return avqw.a.e;
      }
    }
    else
    {
      if (aeV < 0) {
        ahe();
      }
      if (jV < 0L) {
        jV = CpuUtils.iR();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + aeV + " mCpuFeature=" + jV);
      }
      int k = QzoneConfig.getInstance().getConfig("MiniVideo", "SupportedCpuFamily", 2);
      if (aeV >= 0) {}
      for (i = 1 << aeV; (i & k) == 0; i = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverCpuFamily=" + k + " mCpuFamily=" + aeV);
        }
        return avqw.a.b;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("MiniVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (aeV >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + aeV + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label444:
      label621:
      for (;;)
      {
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return avqw.a.d;
          localObject = localObject[aeV];
          i = ((String)localObject).length() - 1;
        }
        for (;;)
        {
          if (i < 0) {
            break label621;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label444;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + jV);
            break label444;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((jV & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + jV);
            }
            return avqw.a.b;
          }
          i -= 1;
        }
      }
    }
    if (!avsu.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdcard !mounted");
      }
      return avqw.a.f;
    }
    long l = getFreeSpace();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return avqw.a.g;
    }
    if (!alwy.auJ())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "CaptureUtil.supportCapture is false");
      }
      return avqw.a.e;
    }
    return avqw.a.a;
  }
  
  public static void b(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_video", true);
    localIntent.putExtra("start_time", 0);
    localIntent.putExtra("end_time", paramLong);
    localIntent.putExtra("encode_video_params", paramBundle);
    localIntent.putExtra("video_refer", "QZonePublishMoodTabActivity");
    paramActivity.startActivity(localIntent);
  }
  
  public static avqw.a c()
  {
    int j = -1;
    avqw.a locala = d();
    if (locala.isAvailable()) {
      return locala;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severBlackList");
      }
      return avqw.a.c;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("M032|ASUS_T00F".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localBlackList");
      }
      return avqw.a.c;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severWhiteList");
      }
      i = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersion", 14);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return avqw.a.e;
      }
    }
    else
    {
      if (aeV < 0) {
        ahe();
      }
      if (jV < 0L) {}
      for (;;)
      {
        try
        {
          jV = CpuUtils.iR();
          if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + aeV + " mCpuFeature=" + jV);
          }
          int k = QzoneConfig.getInstance().getConfig("TrimVideo", "SupportedCpuFamily", 2);
          if (aeV >= 0)
          {
            i = aeV;
            if ((1 << i & k) != 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverCpuFamily=" + k + " mCpuFamily=" + aeV);
            }
            return avqw.a.b;
          }
        }
        catch (Exception localException)
        {
          return avqw.a.b;
        }
        i = 0;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("TrimVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (aeV >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + aeV + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label646:
      for (;;)
      {
        label469:
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return avqw.a.d;
          localObject = localObject[aeV];
          i = ((String)localObject).length() - 1;
        }
        for (;;)
        {
          if (i < 0) {
            break label646;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label469;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + jV);
            break label469;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((jV & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + jV);
            }
            return avqw.a.b;
          }
          i -= 1;
        }
      }
    }
    if (!avsu.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdcard !mounted");
      }
      return avqw.a.f;
    }
    long l = getFreeSpace();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return avqw.a.g;
    }
    return avqw.a.a;
  }
  
  public static avqw.a d()
  {
    int i = 1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "videoTrimEnableHw", 1) != 1) {
      return avqw.a.c;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideoHW", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return avqw.a.c;
    }
    int j = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((j > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return avqw.a.c;
    }
    j = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersionHw", 18);
    int k = Build.VERSION.SDK_INT;
    if (k < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localSdkVersion=" + k + " serverSdkVersion=" + j);
      }
      return avqw.a.e;
    }
    j = anig.az(MobileQQ.getContext());
    if (((j & 0x1) > 0) && ((j & 0x2) > 0)) {}
    while (i == 0)
    {
      return avqw.a.h;
      i = 0;
    }
    return avqw.a.a;
  }
  
  public static long getCpuFrequency()
  {
    return QzoneHardwareRestriction.getCpuMaxFreq() / 1024L;
  }
  
  private static long getFreeSpace()
  {
    try
    {
      long l = avsu.getSDCardRemain();
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneVideoCommonUtils", 1, "Get Free Space Failed", localException);
    }
    return 0L;
  }
  
  public static void u(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("from_qcircle", true);
    paramActivity.startActivity(localIntent);
  }
  
  public static class a
  {
    public static final a a = new a(true, acfp.m(2131713487), false, false);
    public static final a b = new a(false, "CPU指令集不支持", false, true);
    public static final a c = new a(false, acfp.m(2131713480), false, true);
    public static final a d = new a(false, acfp.m(2131713463), false, true);
    public static final a e = new a(false, acfp.m(2131713470), false, true);
    public static final a f = new a(false, acfp.m(2131713474), true, true);
    public static final a g = new a(false, acfp.m(2131713479), true, true);
    public static final a h = new a(false, acfp.m(2131713455), false, true);
    public static final a i = new a(false, acfp.m(2131713502), true, true);
    private String bxP;
    private boolean dob;
    private boolean doc;
    private boolean dod;
    
    a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.dob = paramBoolean1;
      this.bxP = paramString;
      this.doc = paramBoolean2;
      this.dod = paramBoolean3;
    }
    
    public boolean aLp()
    {
      return this.doc;
    }
    
    public String getTip()
    {
      return this.bxP;
    }
    
    public boolean isAvailable()
    {
      return this.dob;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onFail(Activity paramActivity, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avqw
 * JD-Core Version:    0.7.0.1
 */