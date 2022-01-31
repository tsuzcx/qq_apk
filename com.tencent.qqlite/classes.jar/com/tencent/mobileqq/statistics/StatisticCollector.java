package com.tencent.mobileqq.statistics;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexFile;
import efy;
import efz;
import ega;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class StatisticCollector
{
  public static final String A = "actC2CPicDownloadV1";
  public static final String B = "actC2CPicSmallDownV1";
  public static final String C = "actSwitchChnl";
  public static final String D = "actC2CStreamPttUpload";
  public static final String E = "actC2CStreamPttDownload";
  public static final String F = "actC2CPttDownload";
  public static final String G = "actC2CPttUpload";
  public static final String H = "actGroupPicUploadV1";
  public static final String I = "actGroupPicUploadV2";
  public static final String J = "actGroupPicDownloadV1";
  public static final String K = "actGroupPicSmallDownV1";
  public static final String L = "actGrpPttUp";
  public static final String M = "actGrpPttDown";
  public static final String N = "actPttPlayBluetooth";
  public static final String O = "actDiscussPicUpload";
  public static final String P = "actDiscussPicUploadV2";
  public static final String Q = "actDiscussPicDown";
  public static final String R = "actDiscussPicSmallDown";
  public static final String S = "actDisscusPttUp";
  public static final String T = "actDisscusPttDown";
  public static final String U = "actMultiMsgUpload";
  public static final String V = "actMultiMsgDownload";
  public static final String W = "actSendDiscussProcess";
  public static final String X = "actSendDiscussPictureProcess";
  public static final String Y = "dim.actSendDiscussionPttMsg";
  public static final String Z = "actIntroPttUpload";
  public static final int a = 5;
  private static long jdField_a_of_type_Long = 86400000L;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  public static final Object a;
  public static final String a = "StatisticCollector";
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final String aA = "actShortVideoDiscussgroupDownloadThumb";
  public static final String aB = "actSqliteDatabaseCorrupt";
  public static final String aC = "evSpError";
  private static final String aD = "Statistics_time";
  private static final String aE = "fg_duration";
  private static final String aF = "bg_duration";
  private static final String aG = "next_reportTime";
  private static final String aH = "End_Info";
  private static final String aI = "AndroidQQUseApp";
  private static final String aJ = "AndroidQQRunTime";
  private static final String aK = "mqq_dailyUse";
  public static final String aa = "actIntroPttDownload";
  public static final String ab = "dim.actSendWpaMsg";
  public static final String ac = "actQzoneUnread";
  public static final String ad = "actPluginUnread";
  public static final String ae = "actNearbyPeoplePicUpload";
  public static final String af = "actSendCltMsg";
  public static final String ag = "dim.pttRecordInit";
  public static final String ah = "dim.pttRecordTime";
  public static final String ai = "actAllC2CPttUp";
  public static final String aj = "actPttLongPressFate";
  public static final String ak = "actPttSoUpdate";
  public static final String al = "actPttUserWaiting";
  public static final String am = "actPttDownloadStream2Offline";
  public static final String an = "actPttPlayCount";
  public static final String ao = "actPttPlayMoreThanTwice";
  public static final String ap = "actForegroundT";
  public static final String aq = "actMessageEvent";
  public static final String ar = "multiMsgNickTimeOut";
  public static final String as = "multiMsgNickTimeoutR";
  public static final String at = "multiMsgSend";
  public static final String au = "multiMsgReceive";
  public static final String av = "actShortVideoUpload";
  public static final String aw = "actShortVideoDownloadVideo";
  public static final String ax = "actShortVideoDownloadThumb";
  public static final String ay = "actShortVideoDiscussgroupUpload";
  public static final String az = "actShortVideoDiscussgroupDownloadVideo";
  private static int jdField_b_of_type_Int = 28800000;
  public static final String b = "actLoginT";
  private static boolean jdField_b_of_type_Boolean = false;
  private static final long jdField_c_of_type_Long = 15360L;
  public static final String c = "actMemory";
  private static final boolean jdField_c_of_type_Boolean = true;
  public static final String d = "actSyncMsgFirst";
  private static final boolean d = true;
  public static final String e = "actSyncMsgSecond";
  private static boolean e = false;
  public static final String f = "actQQInit";
  public static final String g = "actSendC2CProcess";
  public static final String h = "actSendC2CPictureProcess";
  public static final String i = "actFriendGetQQHead";
  public static final String j = "actSendGroupProcess";
  public static final String k = "actSendGroupPictureProcess";
  public static final String l = "dim.actSendGroupPttMsg";
  public static final String m = "actGetFriList";
  public static final String n = "actGetOnlineFriList";
  public static final String o = "actGetTroopList";
  public static final String p = "actGetTroopMemberList";
  public static final String q = "actGetNeighbors";
  public static final String r = "actGetEncounter";
  public static final String s = "actGetUserDefAvatar";
  public static final String t = "actPicUploadV2.Card.Picture";
  public static final String u = "actPicDownloadV2.Card.Picture";
  public static final String v = "actReqGetDiscuss";
  public static final String w = "actReqGetDiscussInfo";
  public static final String x = "dim.actSendGrpTmpMsg";
  public static final String y = "actC2CPicUploadV1";
  public static final String z = "actC2CPicUploadV2";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  private ega[] jdField_a_of_type_ArrayOfEga = { new ega(this, "com.tencent.mtt", "qqBrowser"), new ega(this, "com.tencent.android.qqdownloader", "qqMarket"), new ega(this, "com.tencent.qqgame", "qqGame"), new ega(this, "com.tencent.qqmusic", "qqMusic"), new ega(this, "com.tencent.news", "qqNews"), new ega(this, "com.qq.reader", "qqReader"), new ega(this, "com.tencent.qqlive", "qqVideo"), new ega(this, "com.tencent.wblog", "qqMicroblog"), new ega(this, "com.tencent.qqphonebook", "qqPhonebook") };
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
    e = false;
  }
  
  private StatisticCollector(Context paramContext)
  {
    this.c = 0;
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static StatisticCollector a(Context arg0)
  {
    Object localObject1 = BaseApplication.getContext();
    if (jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector == null) {
      jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = new StatisticCollector((Context)localObject1);
    }
    if ((!jdField_a_of_type_Boolean) || (jdField_a_of_type_AndroidContentContext == null)) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_AndroidContentContext != null))
      {
        localObject1 = jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
        return localObject1;
      }
      if (jdField_a_of_type_AndroidContentContext == null) {
        jdField_a_of_type_AndroidContentContext = (Context)localObject1;
      }
      UserAction.setUserID("10000");
      UserAction.initUserAction(BaseApplication.getContext(), false);
      jdField_a_of_type_Boolean = true;
      return jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
    }
  }
  
  @TargetApi(8)
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      paramContext = paramContext.getPackageCodePath();
      return paramContext;
    }
    File localFile = new File("/data/app");
    if ((localFile != null) && (localFile.isDirectory()))
    {
      String str = paramContext.getPackageName();
      String[] arrayOfString = localFile.list();
      int i2 = arrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        if (i1 >= i2) {
          break label83;
        }
        localFile = arrayOfString[i1];
        paramContext = localFile;
        if (localFile.contains(str)) {
          break;
        }
        i1 += 1;
      }
    }
    label83:
    return null;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfEga.length)
    {
      String str = this.jdField_a_of_type_ArrayOfEga[i1].a;
      if (!paramString.toLowerCase().contains(str)) {}
    }
    for (paramString = this.jdField_a_of_type_ArrayOfEga[i1].b;; paramString = null)
    {
      return paramString;
      i1 += 1;
      break;
    }
  }
  
  private static Map a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_MODEL", DeviceInfoUtil.d());
    localHashMap.put("param_manu", DeviceInfoUtil.j());
    localHashMap.put("param_OS", DeviceInfoUtil.e());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_IMEI", DeviceInfoUtil.a());
    localHashMap.put("param_IMSI", DeviceInfoUtil.b());
    localHashMap.put("param_NetworkType", "" + NetworkUtil.b(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_ProductVersion", "" + AppSetting.a);
    localHashMap.put("param_CPU", DeviceInfoUtil.f());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(DeviceInfoUtil.d() / 1024L) + "kB");
    long[] arrayOfLong = DeviceInfoUtil.a();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = DeviceInfoUtil.b();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + DeviceInfoUtil.c());
    return localHashMap;
  }
  
  static void a()
  {
    try
    {
      Runtime.getRuntime().exec(new String[] { "id" }).destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BaseApplication", 2, localThrowable.getMessage());
    }
  }
  
  public static void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT <= 10)
    {
      long l1 = System.currentTimeMillis();
      b(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("BaseApplication", 2, " preload rqd classes cost " + (System.currentTimeMillis() - l1));
      }
      l1 = System.currentTimeMillis();
      a();
      if (QLog.isColorLevel()) {
        QLog.d("BaseApplication", 2, " pre execute cmd cost " + (System.currentTimeMillis() - l1));
      }
    }
  }
  
  public static void a(Map paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  private boolean a(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private static String b()
  {
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.c() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.d() / 1024L / 1024L;
      float f1 = ((android.app.ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPss() / 1024.0F;
      localObject = "MemoryInfo:all=" + l1 + "M,avaiable:" + l2 + "M used:" + ((DecimalFormat)localObject).format(f1) + "M";
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseApplication", 2, "load rqd classes");
    }
    Object localObject1 = paramContext;
    if (paramContext == null) {}
    try
    {
      localObject1 = BaseApplicationImpl.getContext();
      paramContext = ((Context)localObject1).getPackageManager().getPackageInfo(((Context)localObject1).getPackageName(), 4096).requestedPermissions;
      paramContext = a((Context)localObject1);
      Object localObject2 = new DexFile(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("BaseApplication", 2, "path = " + paramContext);
      }
      paramContext = localObject1.getClass().getClassLoader();
      localObject1 = ((DexFile)localObject2).entries();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (String)((Enumeration)localObject1).nextElement();
        if ((((String)localObject2).startsWith("com.tencent.feedback")) || (((String)localObject2).startsWith("java.lang")) || (((String)localObject2).startsWith("java.util")) || (((String)localObject2).startsWith("java.io")))
        {
          localObject2 = paramContext.loadClass((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("BaseApplication", 2, "loadRQDClasses" + ((Class)localObject2).getName());
          }
        }
      }
      return;
    }
    catch (NullPointerException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseApplication", 2, "loadRQDClasses: ", paramContext);
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(String paramString)
  {
    UserAction.setUserID(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new efz(System.currentTimeMillis(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
      int i1 = this.c;
      for (this.c = (paramString1.a + i1); (this.c > 15360L) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1); this.c -= paramString1.a) {
        paramString1 = (efz)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
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
          paramString1.put("param_ProductVersion", "" + AppSetting.a);
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
        if (a(paramString2))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        if ((paramHashMap.isRealTime == true) && (paramHashMap.isMerge == true) && (!paramHashMap.isSucceed)) {
          UserAction.onMergeUserAction(paramString2, paramBoolean1, paramLong1, paramLong2, true, new c[0]);
        }
        paramHashMap.params = paramString1;
      }
      try
      {
        paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
        paramString1.setAppId(AppSetting.a);
        paramString1.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      paramString3 = paramHashMap.keySet().iterator();
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0);
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = localSharedPreferences.getLong("Statistics_time_" + paramString, System.currentTimeMillis());
      }
    } while (this.f == paramBoolean);
    this.f = paramBoolean;
    long l1;
    long l2;
    long l3;
    if (this.jdField_b_of_type_Long > 0L)
    {
      l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      l2 = localSharedPreferences.getLong("fg_duration_" + paramString, 0L);
      l3 = localSharedPreferences.getLong("bg_duration_" + paramString, 0L);
      if (!paramBoolean) {
        break label315;
      }
      l3 = l2 + l1;
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "uin:" + paramString + " save fg: " + l3 + " fs:" + l2 + " spend:" + l1);
      }
      localSharedPreferences.edit().putLong("fg_duration_" + paramString, l3).commit();
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localSharedPreferences.edit().putLong("Statistics_time_" + paramString, this.jdField_b_of_type_Long).commit();
      return;
      label315:
      l2 = l3 + l1;
      localSharedPreferences.edit().putLong("bg_duration_" + paramString, l2).commit();
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "save _--bg--_: " + l2 + " bs:" + l3 + " spend:" + l1);
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (e) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + jdField_b_of_type_Int) / jdField_a_of_type_Long;
    } while (l2 < l1);
    e = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    e = false;
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    paramString = paramString + '|';
    paramString = paramString + "1|";
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "AndroidQQUseApp");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    a(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramString3;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
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
    paramString8 = new StringBuilder();
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
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
    paramString8 = new StringBuilder();
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString4 == null) || (paramString5 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3).append('|').append(paramString1).append('|').append("").append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append(paramString2).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "P_CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
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
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void b(String paramString)
  {
    CrashReport.setUserId(BaseApplication.getContext(), paramString);
    CrashReport.setLogAble(false, false);
    paramString = new CrashStrategyBean();
    paramString.setMaxStackFrame(6);
    paramString.setMaxStackLine(400);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "initCrashReport ... process:" + BaseApplicationImpl.getMobileQQ().getProcessName() + " pid=" + android.os.Process.myPid());
    }
    CrashReport.initCrashReport(BaseApplication.getContext(), new efy(this), null, true, paramString, 30000L);
    if (jdField_b_of_type_Boolean) {
      NativeExceptionUpload.setNativeLogMode(3);
    }
    for (;;)
    {
      paramString = BaseApplication.getContext().getDir("tombs", 0).getAbsolutePath();
      try
      {
        CrashReport.initNativeCrashReport(BaseApplication.getContext(), paramString, false);
        return;
        NativeExceptionUpload.setNativeLogMode(6);
      }
      catch (UnsatisfiedLinkError paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("StatisticCollector", 2, "", paramString);
      }
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {}
    String str;
    label445:
    do
    {
      return;
      SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0);
      long l2 = localSharedPreferences.getLong("fg_duration_" + paramString, 0L);
      long l1 = localSharedPreferences.getLong("bg_duration_" + paramString, 0L);
      long l3 = localSharedPreferences.getLong("Statistics_time_" + paramString, System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("StatisticCollector", 2, "uin:+ " + paramString + " llll:" + l3);
      }
      l3 = System.currentTimeMillis() - l3;
      if (!this.f) {
        l2 += l3;
      }
      for (;;)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        localSharedPreferences.edit().putLong("Statistics_time_" + paramString, this.jdField_b_of_type_Long).commit();
        str = l2 / 1000L + "|";
        str = str + l1 / 1000L + "|";
        localSharedPreferences.edit().putLong("fg_duration_" + paramString, 0L).commit();
        localSharedPreferences.edit().putLong("bg_duration_" + paramString, 0L).commit();
        if ((l2 >= 0L) && (l2 <= 86400000L) && (l1 >= 0L) && (l1 <= 86400000L) && (l1 + l2 <= 86400000L)) {
          break label445;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("StatisticCollector", 2, "**************cancel report mQQ runingtime:" + str);
        return;
        l1 += l3;
      }
      paramString = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString.putExtra("sendType", 2);
      paramString.putExtra("tag", "AndroidQQRunTime");
      paramString.putExtra("content", str);
      paramAppRuntime.startServlet(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "report mQQ runingtime:" + str);
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    a(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
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
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void c(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.push(paramContext);
      b("onCreate", paramContext);
    }
  }
  
  public void c(String paramString)
  {
    Map localMap = a();
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
      paramString.setAppId(AppSetting.a);
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public void c(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  public void d(Context paramContext)
  {
    if (paramContext != null) {
      b("onResume", paramContext.toString());
    }
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {}
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      SharedPreferences localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0);
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = localSharedPreferences.getLong("Statistics_time_" + paramString, System.currentTimeMillis());
      }
      l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if (!this.f)
      {
        l2 = localSharedPreferences.getLong("fg_duration_" + paramString, 0L);
        l3 = l2 + l1;
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "save fg: " + l3 + " fs:" + l2 + " spend:" + l1);
        }
        localSharedPreferences.edit().putLong("fg_duration_" + paramString, l3).commit();
        return;
      }
      l2 = localSharedPreferences.getLong("bg_duration_" + paramString, 0L);
      l3 = l2 + l1;
      localSharedPreferences.edit().putLong("bg_duration_" + paramString, l3).commit();
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "save _--bg--_: " + l3 + " bs:" + l2 + " spend:" + l1);
  }
  
  @Deprecated
  public void d(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void e(Context paramContext)
  {
    if (paramContext != null) {
      b("onPause", paramContext.toString());
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "uin:" + paramString + "  cc:" + System.currentTimeMillis());
    }
    jdField_a_of_type_AndroidContentContext.getSharedPreferences("QQLite", 0).edit().putLong("Statistics_time_" + paramString, System.currentTimeMillis()).commit();
  }
  
  public void e(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, 1, "", "", "");
  }
  
  public void f(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.remove(paramContext);
      b("onDestroy", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */