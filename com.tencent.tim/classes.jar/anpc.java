import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.Pandora.Pandora;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.statistics.StatisticCollector.1;
import com.tencent.mobileqq.statistics.StatisticCollector.3;
import com.tencent.mobileqq.statistics.StatisticCollector.4;
import com.tencent.mobileqq.statistics.StatisticCollector.5;
import com.tencent.mobileqq.statistics.StatisticCollector.6;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class anpc
{
  private static SimpleDateFormat E = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  public static anpc.f a;
  private static volatile anpc jdField_a_of_type_Anpc;
  static long anr;
  public static volatile long ans;
  private static volatile boolean cJb;
  private static volatile boolean cJc;
  public static volatile boolean cJd;
  private static boolean cJe;
  public static boolean cJf;
  private static String cfK;
  private static String cfL;
  private static Context ctx;
  static int dKS;
  private static final Random random = new Random();
  private StringBuilder U = new StringBuilder("DPC info:\n");
  private StringBuilder V = new StringBuilder("Thread info:\n");
  private LinkedList<anpc.a> Z = new LinkedList();
  anpc.b jdField_a_of_type_Anpc$b = new anpc.b();
  private anpc.d[] jdField_a_of_type_ArrayOfAnpc$d = { new anpc.d("com.tencent.mtt", "qqBrowser"), new anpc.d("com.tencent.android.qqdownloader", "qqMarket"), new anpc.d("com.tencent.qqgame", "qqGame"), new anpc.d("com.tencent.qqmusic", "qqMusic"), new anpc.d("com.tencent.news", "qqNews"), new anpc.d("com.qq.reader", "qqReader"), new anpc.d("com.tencent.qqlive", "qqVideo"), new anpc.d("com.tencent.wblog", "qqMicroblog"), new anpc.d("com.tencent.qqphonebook", "qqPhonebook") };
  boolean cJa = false;
  private String cfM;
  private int dKT;
  String mCurUin = "999";
  private HashMap<String, String> ny = new HashMap(4);
  private Stack<String> stack = new Stack();
  
  protected anpc(Context paramContext)
  {
    ctx = paramContext;
  }
  
  private anpc(Context paramContext, long paramLong)
  {
    ctx = paramContext;
    anpl.start();
  }
  
  @TargetApi(21)
  private static String Al()
  {
    int i1 = 0;
    int m = 0;
    int i2 = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = i1;
    int k = i2;
    for (;;)
    {
      try
      {
        Object localObject1 = new File("/proc/self/fd");
        j = i1;
        int n = m;
        k = i2;
        if (((File)localObject1).exists())
        {
          j = i1;
          n = m;
          k = i2;
          if (((File)localObject1).isDirectory())
          {
            j = i1;
            k = i2;
            if (Build.VERSION.SDK_INT < 21) {
              break label336;
            }
            m = 1;
            j = i1;
            k = i2;
            File[] arrayOfFile = ((File)localObject1).listFiles();
            j = i1;
            k = i2;
            i2 = arrayOfFile.length;
            i1 = 0;
            n = i;
            if (i1 < i2)
            {
              localObject1 = arrayOfFile[i1];
              if (m != 0) {
                k = i;
              }
              try
              {
                localObject1 = Os.readlink(((File)localObject1).getPath());
                k = i;
                localStringBuilder.append((String)localObject1 + "\n");
                i += 1;
              }
              catch (Throwable localThrowable1)
              {
                j = i;
                k = i;
                QLog.e("StatisticCollector", 1, "readlink failed", localThrowable1);
              }
              k = i;
              localObject1 = ((File)localObject1).getCanonicalPath();
              continue;
            }
          }
        }
        localStringBuilder.append("Total FD Count = " + k);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2 = localThrowable2;
        try
        {
          QLog.e("StatisticCollector", 1, "get fd info failed !!!", localThrowable2);
          localStringBuilder.append("Total FD Count = " + j);
          return localStringBuilder.toString();
        }
        finally
        {
          for (;;)
          {
            k = j;
          }
        }
        localStringBuilder.append("Total FD Count = " + n);
        return localStringBuilder.toString();
      }
      finally {}
      return localStringBuilder.toString();
      i1 += 1;
      continue;
      label336:
      m = 0;
    }
  }
  
  public static int Kk()
  {
    return LocalMultiProcConfig.getInt("version_patchlib_load", 0);
  }
  
  public static void Vl(int paramInt)
  {
    LocalMultiProcConfig.putInt("version_patchlib_load", paramInt);
    if (paramInt > 0) {
      QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + paramInt);
    }
  }
  
  public static anpc a(Context paramContext)
  {
    return a(paramContext, 3000L);
  }
  
  public static anpc a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_Anpc == null) {}
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Anpc == null)
        {
          if (aciu.abf()) {
            jdField_a_of_type_Anpc = new anpc(BaseApplicationImpl.getApplication(), paramLong);
          }
        }
        else if (jdField_a_of_type_Anpc == null) {}
      }
      finally {}
      try
      {
        if ((aciu.abf()) && ((jdField_a_of_type_Anpc instanceof anpc.c))) {
          jdField_a_of_type_Anpc = new anpc(BaseApplicationImpl.getApplication(), paramLong);
        }
        return jdField_a_of_type_Anpc;
      }
      finally {}
      jdField_a_of_type_Anpc = new anpc.c(BaseApplicationImpl.getApplication());
    }
  }
  
  public static void a(Context paramContext, StringBuilder paramStringBuilder)
    throws Exception
  {
    Object localObject1 = aqos.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)aqos.a("android.app.LoadedApk", ((WeakReference)((Map)aqos.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        localObject3 = (BroadcastReceiver)localObject3;
        paramStringBuilder.append(localObject3.getClass().getName() + ":" + localObject3);
        paramStringBuilder.append(" in ");
        paramStringBuilder.append(localObject2.getClass().getName() + ":" + localObject2);
      }
    }
  }
  
  private static Map<String, String> ax()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", aqgz.getDeviceModel());
    localHashMap.put("param_manu", aqgz.getManufacturer());
    localHashMap.put("param_OS", aqgz.getDeviceOSVersion());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(ctx));
    localHashMap.put("param_IMEI", aqgz.getIMEI());
    localHashMap.put("param_IMSI", aqgz.getIMSI());
    localHashMap.put("param_NetworkType", "" + aqiw.getNetworkType(ctx));
    localHashMap.put("param_ProductVersion", "" + AppSetting.getAppId());
    localHashMap.put("param_CPU", aqgz.getCpuType());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(aqgz.getSystemAvaialbeMemory() / 1024L) + "kB");
    long[] arrayOfLong = aqgz.getRomMemroy();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = aqgz.getSDCardMemory();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + aqgz.LT());
    return localHashMap;
  }
  
  public static boolean ayC()
  {
    if ("3.4.4".startsWith("7.1.")) {}
    return false;
  }
  
  private static boolean bF(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((1 != BaseApplicationImpl.sProcessId) || (System.currentTimeMillis() - ans > 600000L)) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while ((!((SharedPreferences)localObject1).getBoolean("key_not_exit_enable", false)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
    for (;;)
    {
      int i;
      int m;
      try
      {
        Object localObject2 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_type", null);
        localObject1 = ((SharedPreferences)localObject1).getString("key_not_exit_crash_stack", null);
        if ((localObject2 == null) || (TextUtils.isEmpty(paramString1))) {
          break label311;
        }
        localObject2 = ((String)localObject2).split("\\|");
        k = localObject2.length;
        j = 0;
        i = 0;
        if (j >= k) {
          break label323;
        }
        Object localObject3 = localObject2[j];
        if (!paramString1.equals(localObject3)) {
          break label316;
        }
        QLog.e("StatisticCollector", 1, new Object[] { "crashType = ", paramString1, ",crash = ", localObject3 });
        i = 1;
      }
      catch (Throwable paramString1)
      {
        int k;
        int n;
        QLog.e("StatisticCollector", 1, "isNotExitSafeMode has some error", paramString1);
        return false;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        paramString1 = ((String)localObject1).split("\\|");
        n = paramString1.length;
        k = 0;
        i = 0;
        m = i;
        if (k < n)
        {
          localObject1 = paramString1[k];
          if (paramString2.contains((CharSequence)localObject1))
          {
            QLog.e("StatisticCollector", 1, new Object[] { "crashStack = ", paramString2, ",crash = ", localObject1 });
            i = 1;
          }
          k += 1;
          continue;
        }
      }
      else
      {
        m = 0;
      }
      if ((m != 0) && (j != 0)) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      label311:
      int j = 0;
      continue;
      label316:
      j += 1;
      continue;
      label323:
      j = i;
    }
  }
  
  private void bS(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if (paramString.equals(localRunningServiceInfo.process))
          {
            Intent localIntent = new Intent();
            localIntent.setComponent(localRunningServiceInfo.service);
            QLog.d("StatisticCollector", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
            paramContext.stopService(localIntent);
          }
        }
      }
    }
  }
  
  public static void d(Map<String, String> paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  private void dSM()
  {
    rwz.a().clear();
  }
  
  private void hz(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.ny.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.ny.put(paramString1, paramString2);
  }
  
  public static boolean lH(int paramInt)
  {
    boolean bool2;
    if (paramInt != 3)
    {
      bool2 = false;
      return bool2;
    }
    String[] arrayOfString2 = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SqlSampleCfg.name(), "250|5|5|1|50|5|5|25|25|25|5|10|10").split("\\|");
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2.length < 13) {
      arrayOfString1 = "250|5|5|1|50|5|5|25|25|25|5|10|10".split("\\|");
    }
    if (paramInt > arrayOfString1.length - 1) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(arrayOfString1[paramInt]).intValue();
        if (paramInt <= 0) {
          break label162;
        }
        if (random.nextInt(paramInt) == paramInt - 1)
        {
          bool1 = true;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StatisticCollector", 2, new Object[] { "getSqliteSwitchBySample value: ", Integer.valueOf(paramInt), " switch: ", Boolean.valueOf(bool1) });
          return bool1;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StatisticCollector", 2, "getSqliteSwitchBySample error", localException);
        }
        return false;
      }
      boolean bool1 = false;
      continue;
      label162:
      bool1 = false;
    }
  }
  
  private boolean pw(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoUploadBDH".equals(paramString)) || ("actShortVideoDiscussgroupUploadBDH".equals(paramString)) || ("actShortVideoForwardBDH".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString)) || ("PicStatisticsManagerUploadPic".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  public static void report(String paramString)
  {
    a(BaseApplication.getContext()).collectPerformance(null, paramString, true, 0L, 0L, null, null);
  }
  
  public void QZ(String paramString)
    throws Exception
  {
    this.mCurUin = paramString;
    try
    {
      UserAction.setUserID(paramString);
      CrashReport.setUserId(ctx, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  void Ra(String paramString)
  {
    boolean bool1 = true;
    if (!this.jdField_a_of_type_Anpc$b.cJg) {
      QLog.d("StatisticCollector", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = ctx.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.U.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(E.format(new Date(l1))).append(",currenttime=").append(E.format(new Date(l2))).append(",crashCount=").append(i).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Anpc$b.dKV * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Anpc$b.dKW) {
        bool1 = false;
      }
      this.U.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool1).putInt("controlwindow", this.jdField_a_of_type_Anpc$b.dKV).commit();
      return;
      i += 1;
    }
  }
  
  public void Rb(String paramString)
    throws Exception
  {
    boolean bool = false;
    this.mCurUin = paramString;
    CrashReport.setLogAble(false, false);
    Object localObject = new CrashStrategyBean();
    ((CrashStrategyBean)localObject).setUploadSpotCrash(false);
    ((CrashStrategyBean)localObject).setMaxStackFrame(6);
    QLog.d("StatisticCollector", 1, "initCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
    if (BaseApplicationImpl.processName.endsWith(":qzone")) {
      ThreadManager.executeOnSubThread(new StatisticCollector.1(this));
    }
    if (aciu.abf())
    {
      String str = Pandora.getAndroidID(MobileQQ.sMobileQQ);
      if (str == null) {
        break label498;
      }
      CrashReport.setDeviceId(MobileQQ.sMobileQQ, str);
      QLog.d("StatisticCollector", 2, "Pandora.getAndroidID is " + str);
    }
    for (;;)
    {
      if (BaseApplicationImpl.sProcessId == 1) {
        bool = true;
      }
      CrashReport.initCrashReport(ctx, new anpd(this), null, bool, (CrashStrategyBean)localObject, 30000L);
      try
      {
        localObject = ctx.getDir("tombs", 0).getAbsolutePath();
        QLog.d("StatisticCollector", 1, "initNativeCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
        CrashReport.initNativeCrashReport(ctx, (String)localObject, false, null, null, 0L);
        CrashReport.filterSysLog(true, true);
        QLog.d("StatisticCollector", 1, "CrashReport init finished.");
        ANRReport.stopANRMonitor();
        CrashReport.setUserId(ctx, paramString);
        CrashReport.putUserData(ctx, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(ctx)));
        CrashReport.putUserData(ctx, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(ctx)));
        CrashReport.putUserData(ctx, "PatchInstallStatus", String.valueOf(tnh.bCv));
        if (!TextUtils.isEmpty(tnh.aJB)) {
          CrashReport.putUserData(ctx, "PatchNameInstalled", tnh.aJB);
        }
        CrashReport.putUserData(ctx, "Revision", AppSetting.getRevision());
        CrashReport.putUserData(ctx, "Version.buildNum", "3.4.4.3058");
        CrashReport.putUserData(ctx, "AboutSubVersionLog", AppSetting.nU());
        CrashReport.putUserData(ctx, "appid", String.valueOf(AppSetting.getAppId()));
        CrashReport.putUserData(ctx, "topActivity", aciz.rH());
        this.V.append("Current process id=").append(Process.myPid()).append(", Name=").append(BaseApplicationImpl.processName).append("\n");
        ans = System.currentTimeMillis();
        if (1 == BaseApplicationImpl.sProcessId)
        {
          ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.3(this, paramString), 3000L);
          ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.4(this), 180000L);
          ThreadManager.getSubThreadHandler().postDelayed(new StatisticCollector.5(this), 600000L);
        }
        return;
        label498:
        QLog.e("StatisticCollector", 1, "Pandora.getAndroidID is null");
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          QLog.e("StatisticCollector", 1, "initNativeCrashReport error", localUnsatisfiedLinkError);
        }
      }
    }
  }
  
  public void Rc(String paramString)
  {
    Map localMap = ax();
    if ((paramString == null) || (localMap == null)) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)localMap.get(str) == null) {
        localMap.put(str, "");
      }
    }
    UserAction.setUserID(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "report End_Info:" + localMap.toString());
    }
    paramString = new RdmReq();
    paramString.eventName = "End_Info";
    paramString.elapse = -1L;
    paramString.size = 0L;
    paramString.isSucceed = true;
    paramString.isRealTime = true;
    paramString.isMerge = false;
    paramString.params = localMap;
    try
    {
      paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString);
      paramString.setAppId(AppSetting.getAppId());
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    String str = paramString4;
    if (paramString4 == null) {
      str = "0";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  /* Error */
  public void b(StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 144	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 1229
    //   10: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 934	android/os/Process:myPid	()I
    //   16: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 1231
    //   22: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 11
    //   30: aload_1
    //   31: ldc_w 1233
    //   34: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1235
    //   40: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aconst_null
    //   45: astore 8
    //   47: aconst_null
    //   48: astore 9
    //   50: aconst_null
    //   51: astore 5
    //   53: invokestatic 516	java/lang/System:currentTimeMillis	()J
    //   56: lstore_3
    //   57: aload 8
    //   59: astore 7
    //   61: aload 9
    //   63: astore 6
    //   65: new 178	java/io/File
    //   68: dup
    //   69: aload 11
    //   71: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 1239	java/io/File:list	()[Ljava/lang/String;
    //   77: astore 10
    //   79: aload 8
    //   81: astore 7
    //   83: aload 9
    //   85: astore 6
    //   87: new 155	java/util/HashMap
    //   90: dup
    //   91: invokespecial 1240	java/util/HashMap:<init>	()V
    //   94: astore 8
    //   96: iconst_0
    //   97: istore_2
    //   98: aload 5
    //   100: astore 7
    //   102: aload 5
    //   104: astore 6
    //   106: iload_2
    //   107: aload 10
    //   109: arraylength
    //   110: if_icmpge +119 -> 229
    //   113: aload 5
    //   115: astore 7
    //   117: aload 5
    //   119: astore 6
    //   121: new 178	java/io/File
    //   124: dup
    //   125: new 144	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   132: aload 11
    //   134: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 1242
    //   140: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 10
    //   145: iload_2
    //   146: aaload
    //   147: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 1244
    //   153: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 9
    //   164: aload 5
    //   166: astore 7
    //   168: aload 5
    //   170: astore 6
    //   172: invokestatic 516	java/lang/System:currentTimeMillis	()J
    //   175: lload_3
    //   176: lsub
    //   177: ldc2_w 1245
    //   180: lcmp
    //   181: ifle +186 -> 367
    //   184: aload 5
    //   186: astore 7
    //   188: aload 5
    //   190: astore 6
    //   192: invokestatic 707	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +34 -> 229
    //   198: aload 5
    //   200: astore 7
    //   202: aload 5
    //   204: astore 6
    //   206: ldc 220
    //   208: iconst_2
    //   209: iconst_2
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc_w 1248
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_1
    //   222: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 721	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   229: aload 5
    //   231: astore 7
    //   233: aload 5
    //   235: astore 6
    //   237: aload 8
    //   239: invokevirtual 1251	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   242: invokeinterface 339 1 0
    //   247: astore 8
    //   249: aload 5
    //   251: astore 7
    //   253: aload 5
    //   255: astore 6
    //   257: aload 8
    //   259: invokeinterface 344 1 0
    //   264: ifeq +272 -> 536
    //   267: aload 5
    //   269: astore 7
    //   271: aload 5
    //   273: astore 6
    //   275: aload 8
    //   277: invokeinterface 347 1 0
    //   282: checkcast 1253	java/util/Map$Entry
    //   285: astore 9
    //   287: aload 5
    //   289: astore 7
    //   291: aload 5
    //   293: astore 6
    //   295: aload_1
    //   296: aload 9
    //   298: invokeinterface 1256 1 0
    //   303: checkcast 464	java/lang/String
    //   306: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 1258
    //   312: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 9
    //   317: invokeinterface 1261 1 0
    //   322: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: ldc_w 1263
    //   328: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 1148
    //   334: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: goto -89 -> 249
    //   341: astore_1
    //   342: aload 7
    //   344: astore 6
    //   346: ldc 220
    //   348: iconst_2
    //   349: ldc_w 1265
    //   352: aload_1
    //   353: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload 7
    //   358: ifnull +8 -> 366
    //   361: aload 7
    //   363: invokevirtual 1270	java/io/BufferedReader:close	()V
    //   366: return
    //   367: aload 5
    //   369: astore 7
    //   371: aload 5
    //   373: astore 6
    //   375: aload 9
    //   377: invokevirtual 185	java/io/File:exists	()Z
    //   380: ifeq +359 -> 739
    //   383: aload 5
    //   385: astore 7
    //   387: aload 5
    //   389: astore 6
    //   391: new 1267	java/io/BufferedReader
    //   394: dup
    //   395: new 1272	java/io/FileReader
    //   398: dup
    //   399: aload 9
    //   401: invokespecial 1275	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   404: bipush 64
    //   406: invokespecial 1278	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   409: astore 5
    //   411: aload 5
    //   413: invokevirtual 1281	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   416: astore 6
    //   418: aload 6
    //   420: ifnull +322 -> 742
    //   423: aload 6
    //   425: ldc_w 1283
    //   428: invokevirtual 503	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   431: ifeq -20 -> 411
    //   434: aload 6
    //   436: ldc_w 358
    //   439: invokevirtual 560	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   442: iconst_1
    //   443: aaload
    //   444: invokevirtual 1286	java/lang/String:trim	()Ljava/lang/String;
    //   447: astore 6
    //   449: aload 8
    //   451: aload 6
    //   453: invokevirtual 1289	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   456: ifeq +49 -> 505
    //   459: aload 8
    //   461: aload 6
    //   463: aload 8
    //   465: aload 6
    //   467: invokevirtual 1290	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast 694	java/lang/Integer
    //   473: invokevirtual 700	java/lang/Integer:intValue	()I
    //   476: iconst_1
    //   477: iadd
    //   478: invokestatic 712	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   481: invokevirtual 671	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload 5
    //   487: ifnull +46 -> 533
    //   490: aload 5
    //   492: invokevirtual 1270	java/io/BufferedReader:close	()V
    //   495: aconst_null
    //   496: astore 5
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -404 -> 98
    //   505: aload 8
    //   507: aload 6
    //   509: iconst_1
    //   510: invokestatic 712	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   513: invokevirtual 671	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: goto -32 -> 485
    //   520: astore 6
    //   522: ldc 220
    //   524: iconst_2
    //   525: ldc_w 1265
    //   528: aload 6
    //   530: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: goto -35 -> 498
    //   536: aload 5
    //   538: astore 7
    //   540: aload 5
    //   542: astore 6
    //   544: aload_1
    //   545: ldc_w 1292
    //   548: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 10
    //   553: arraylength
    //   554: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 5
    //   560: astore 7
    //   562: aload 5
    //   564: astore 6
    //   566: invokestatic 1297	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   569: ifeq +36 -> 605
    //   572: aload 5
    //   574: astore 7
    //   576: aload 5
    //   578: astore 6
    //   580: aload 10
    //   582: arraylength
    //   583: sipush 200
    //   586: if_icmple +19 -> 605
    //   589: aload 5
    //   591: astore 7
    //   593: aload 5
    //   595: astore 6
    //   597: aload_1
    //   598: invokestatic 1300	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   601: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 5
    //   607: astore 7
    //   609: aload 5
    //   611: astore 6
    //   613: invokestatic 707	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +51 -> 667
    //   619: aload 5
    //   621: astore 7
    //   623: aload 5
    //   625: astore 6
    //   627: ldc 220
    //   629: iconst_2
    //   630: iconst_4
    //   631: anewarray 4	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: ldc_w 1302
    //   639: aastore
    //   640: dup
    //   641: iconst_1
    //   642: invokestatic 516	java/lang/System:currentTimeMillis	()J
    //   645: lload_3
    //   646: lsub
    //   647: invokestatic 1307	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   650: aastore
    //   651: dup
    //   652: iconst_2
    //   653: ldc_w 1309
    //   656: aastore
    //   657: dup
    //   658: iconst_3
    //   659: aload_1
    //   660: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: aastore
    //   664: invokestatic 721	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   667: aload 5
    //   669: ifnull -303 -> 366
    //   672: aload 5
    //   674: invokevirtual 1270	java/io/BufferedReader:close	()V
    //   677: return
    //   678: astore_1
    //   679: ldc 220
    //   681: iconst_2
    //   682: ldc_w 1265
    //   685: aload_1
    //   686: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   689: return
    //   690: astore_1
    //   691: ldc 220
    //   693: iconst_2
    //   694: ldc_w 1265
    //   697: aload_1
    //   698: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: return
    //   702: astore_1
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 1270	java/io/BufferedReader:close	()V
    //   713: aload_1
    //   714: athrow
    //   715: astore 5
    //   717: ldc 220
    //   719: iconst_2
    //   720: ldc_w 1265
    //   723: aload 5
    //   725: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   728: goto -15 -> 713
    //   731: astore_1
    //   732: aload 5
    //   734: astore 6
    //   736: goto -33 -> 703
    //   739: goto -241 -> 498
    //   742: aconst_null
    //   743: astore 6
    //   745: goto -296 -> 449
    //   748: astore_1
    //   749: aload 5
    //   751: astore 7
    //   753: goto -411 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	anpc
    //   0	756	1	paramStringBuilder	StringBuilder
    //   97	405	2	i	int
    //   56	590	3	l	long
    //   51	622	5	localBufferedReader	java.io.BufferedReader
    //   715	35	5	localIOException1	java.io.IOException
    //   63	445	6	localObject1	Object
    //   520	9	6	localIOException2	java.io.IOException
    //   542	202	6	localObject2	Object
    //   59	693	7	localObject3	Object
    //   45	461	8	localObject4	Object
    //   48	352	9	localObject5	Object
    //   77	504	10	arrayOfString	String[]
    //   28	105	11	str	String
    // Exception table:
    //   from	to	target	type
    //   65	79	341	java/lang/Exception
    //   87	96	341	java/lang/Exception
    //   106	113	341	java/lang/Exception
    //   121	164	341	java/lang/Exception
    //   172	184	341	java/lang/Exception
    //   192	198	341	java/lang/Exception
    //   206	229	341	java/lang/Exception
    //   237	249	341	java/lang/Exception
    //   257	267	341	java/lang/Exception
    //   275	287	341	java/lang/Exception
    //   295	338	341	java/lang/Exception
    //   375	383	341	java/lang/Exception
    //   391	411	341	java/lang/Exception
    //   544	558	341	java/lang/Exception
    //   566	572	341	java/lang/Exception
    //   580	589	341	java/lang/Exception
    //   597	605	341	java/lang/Exception
    //   613	619	341	java/lang/Exception
    //   627	667	341	java/lang/Exception
    //   490	495	520	java/io/IOException
    //   672	677	678	java/io/IOException
    //   361	366	690	java/io/IOException
    //   65	79	702	finally
    //   87	96	702	finally
    //   106	113	702	finally
    //   121	164	702	finally
    //   172	184	702	finally
    //   192	198	702	finally
    //   206	229	702	finally
    //   237	249	702	finally
    //   257	267	702	finally
    //   275	287	702	finally
    //   295	338	702	finally
    //   346	356	702	finally
    //   375	383	702	finally
    //   391	411	702	finally
    //   544	558	702	finally
    //   566	572	702	finally
    //   580	589	702	finally
    //   597	605	702	finally
    //   613	619	702	finally
    //   627	667	702	finally
    //   708	713	715	java/io/IOException
    //   411	418	731	finally
    //   423	449	731	finally
    //   449	485	731	finally
    //   490	495	731	finally
    //   505	517	731	finally
    //   522	533	731	finally
    //   411	418	748	java/lang/Exception
    //   423	449	748	java/lang/Exception
    //   449	485	748	java/lang/Exception
    //   490	495	748	java/lang/Exception
    //   505	517	748	java/lang/Exception
    //   522	533	748	java/lang/Exception
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    a(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    c(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString, Map<String, Integer> paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void c(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (!aciu.abf()) {
      return;
    }
    txe.i(paramString2, paramHashMap);
    if (paramString1 == null) {
      paramString1 = "10000";
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.length() < 1) {
          paramString3 = "10000";
        }
      }
      UserAction.setUserID(paramString3);
      if (paramHashMap == null)
      {
        paramString1 = new HashMap();
        if (paramString1 != null) {
          paramString1.put("param_ProductVersion", "" + AppSetting.getAppId());
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "event report: " + paramString2 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString1.containsKey("param_FailCode")) || ("".equals(paramString1.get("param_FailCode"))))) {
          paramString1.put("param_FailCode", String.valueOf(0));
        }
        paramHashMap = new RdmReq();
        paramHashMap.eventName = paramString2;
        paramHashMap.elapse = paramLong1;
        paramHashMap.size = paramLong2;
        paramHashMap.isSucceed = paramBoolean1;
        paramHashMap.isRealTime = paramBoolean2;
        if (pw(paramString2))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        paramHashMap.params = paramString1;
        try
        {
          paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
          paramString1.setAppId(AppSetting.getAppId());
          paramString1.setTimeout(30000L);
          ThreadManager.post(new StatisticCollector.6(this, paramString1), 5, null, true);
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
      }
      paramString1 = new HashSet();
      paramString1.addAll(paramHashMap.keySet());
      paramString3 = paramString1.iterator();
      for (;;)
      {
        paramString1 = paramHashMap;
        if (!paramString3.hasNext()) {
          break;
        }
        paramString1 = (String)paramString3.next();
        if ((String)paramHashMap.get(paramString1) == null) {
          paramHashMap.put(paramString1, "");
        }
      }
    }
  }
  
  void dSK()
  {
    String str = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.jdField_a_of_type_Anpc$b.cJg = ((JSONObject)localObject).getBoolean("control_switch");
      this.jdField_a_of_type_Anpc$b.dKU = ((JSONObject)localObject).getInt("control_level");
      this.jdField_a_of_type_Anpc$b.dKV = ((JSONObject)localObject).getInt("control_window");
      this.jdField_a_of_type_Anpc$b.dKW = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.U.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.jdField_a_of_type_Anpc$b.cJg);
      ((StringBuilder)localObject).append(",level=").append(this.jdField_a_of_type_Anpc$b.dKU);
      ((StringBuilder)localObject).append(",window=").append(this.jdField_a_of_type_Anpc$b.dKV);
      ((StringBuilder)localObject).append(",Freq=").append(this.jdField_a_of_type_Anpc$b.dKW);
      this.U.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.jdField_a_of_type_Anpc$b.reset();
        QLog.d("StatisticCollector", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  void dSL()
  {
    if (!this.jdField_a_of_type_Anpc$b.cJg) {
      QLog.d("StatisticCollector", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().startComponentInfo;
      if ((this.jdField_a_of_type_Anpc$b.dKU == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("StatisticCollector", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = ctx.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.U.append("updateLocalCrashData startTime=").append(E.format(new Date(l1))).append(",currenttime=").append(E.format(new Date(l2))).append(",crashCount=").append(i).append(",mCurUin=").append(this.mCurUin).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Anpc$b.dKV * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Anpc$b.dKW) {
        this.cJa = true;
      }
      this.U.append("updateLocalCrashData shouldStopMsf=").append(this.cJa).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("shouldStopMsf", this.cJa).commit();
      return;
      i += 1;
    }
  }
  
  public void eW(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.stack.push(paramContext);
      hz("onCreate", paramContext);
    }
  }
  
  public void eX(Context paramContext)
  {
    if (paramContext != null) {
      hz("onResume", paramContext.toString());
    }
  }
  
  public void eY(Context paramContext)
  {
    if (paramContext != null) {
      hz("onPause", paramContext.toString());
    }
  }
  
  public void eZ(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.stack.remove(paramContext);
      hz("onDestroy", paramContext);
    }
  }
  
  @Deprecated
  public void h(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  public void hy(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new anpc.a(System.currentTimeMillis(), paramString1, paramString2);
      this.Z.add(paramString1);
      int i = this.dKT;
      for (this.dKT = (paramString1.size + i); (this.dKT > 15360L) && (this.Z.size() > 1); this.dKT -= paramString1.size) {
        paramString1 = (anpc.a)this.Z.removeLast();
      }
    }
  }
  
  @Deprecated
  public void i(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void l(AppRuntime paramAppRuntime)
  {
    if (cJe) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = ctx.getSharedPreferences("mobileQQ", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
    } while (l2 < l1);
    cJe = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), anfa.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    cJe = false;
  }
  
  static class a
  {
    String log;
    int size = 0;
    String tag;
    long time;
    
    public a(long paramLong, String paramString1, String paramString2)
    {
      this.time = paramLong;
      this.tag = paramString1;
      this.log = paramString2;
      int i;
      if (paramString1 == null)
      {
        i = 0;
        if (paramString2 != null) {
          break label67;
        }
      }
      for (;;)
      {
        this.size = (j + (i + 19 + 1) + 1);
        return;
        i = paramString1.getBytes().length;
        break;
        label67:
        j = paramString2.getBytes().length;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      Date localDate = new Date(this.time);
      localStringBuilder.append(anpc.E.format(localDate));
      localStringBuilder.append(" ");
      localStringBuilder.append(this.tag);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.log);
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
    }
  }
  
  static class b
  {
    boolean cJg = true;
    int dKU = 1;
    int dKV = 86400;
    int dKW = 5;
    
    void reset()
    {
      this.cJg = true;
      this.dKU = 1;
      this.dKV = 86400;
      this.dKW = 5;
    }
  }
  
  static class c
    extends anpc
  {
    protected c(Context paramContext)
    {
      super();
    }
  }
  
  static class d
  {
    public String cfN;
    public String packageName;
    
    d(String paramString1, String paramString2)
    {
      this.packageName = paramString1;
      this.cfN = paramString2;
    }
  }
  
  public static class e
  {
    public long ant;
    public long anu;
    public String cfO = "";
    public String cfP = "";
    public int dKX;
    public int dKY;
    public int dKZ;
  }
  
  public static abstract interface f
  {
    public abstract void iz(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */