package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Properties;

public class b
  implements IMTAReporter
{
  public static boolean a = false;
  private static final String b = "MTAReportManager";
  private static volatile b d = null;
  private Context c = null;
  private StatSpecifyReportedInfo e = new StatSpecifyReportedInfo();
  private volatile String f = null;
  private boolean g;
  
  private b(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.g = a(this.c, true);
    a(false);
    initMtaConfig(MsfSdkUtils.getAppChannelId(), "AGU36HSC29K4");
  }
  
  public static b a(Context paramContext)
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new b(paramContext);
      }
      return d;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).getBoolean("SUPPORT_MTA", paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, Map paramMap)
  {
    try
    {
      Properties localProperties = new Properties();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        localProperties.putAll(paramMap);
      }
      reportKVEvent(paramString, localProperties);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, Map paramMap, int paramInt)
  {
    if (!this.g) {
      return;
    }
    try
    {
      Properties localProperties = new Properties();
      if ((paramMap != null) && (paramMap.size() > 0)) {
        localProperties.putAll(paramMap);
      }
      reportTimeKVEvent(paramString, localProperties, paramInt);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportTimeKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StatConfig.setDebugEnable(paramBoolean);
  }
  
  /* Error */
  public void initMtaConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/mobileqq/msf/core/c/b:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   4: aload_2
    //   5: invokevirtual 131	com/tencent/stat/StatSpecifyReportedInfo:setAppKey	(Ljava/lang/String;)V
    //   8: aload_1
    //   9: ifnonnull +157 -> 166
    //   12: invokestatic 137	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc 139
    //   17: invokevirtual 143	com/tencent/qphone/base/util/BaseApplication:getAppData	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +217 -> 239
    //   25: aload_1
    //   26: instanceof 145
    //   29: ifeq +210 -> 239
    //   32: aload_1
    //   33: checkcast 145	java/lang/String
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 39	com/tencent/mobileqq/msf/core/c/b:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   41: aload_1
    //   42: invokevirtual 148	com/tencent/stat/StatSpecifyReportedInfo:setInstallChannel	(Ljava/lang/String;)V
    //   45: goto +191 -> 236
    //   48: iconst_1
    //   49: invokestatic 151	com/tencent/stat/StatConfig:setEnableConcurrentProcess	(Z)V
    //   52: iconst_0
    //   53: invokestatic 154	com/tencent/stat/StatConfig:setAutoExceptionCaught	(Z)V
    //   56: aload_0
    //   57: getfield 34	com/tencent/mobileqq/msf/core/c/b:c	Landroid/content/Context;
    //   60: invokestatic 159	com/tencent/stat/StatServiceImpl:setContext	(Landroid/content/Context;)V
    //   63: ldc 161
    //   65: invokestatic 164	com/tencent/stat/StatConfig:setMTAPreferencesFileName	(Ljava/lang/String;)V
    //   68: getstatic 170	com/tencent/stat/StatReportStrategy:PERIOD	Lcom/tencent/stat/StatReportStrategy;
    //   71: invokestatic 174	com/tencent/stat/StatConfig:setStatSendStrategy	(Lcom/tencent/stat/StatReportStrategy;)V
    //   74: bipush 30
    //   76: invokestatic 178	com/tencent/stat/StatConfig:setSendPeriodMinutes	(I)V
    //   79: iconst_1
    //   80: invokestatic 181	com/tencent/stat/StatConfig:setEnableSmartReporting	(Z)V
    //   83: ldc 183
    //   85: invokestatic 186	com/tencent/stat/StatConfig:setStatReportUrl	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokestatic 192	com/tencent/mobileqq/msf/core/MsfStore:getNativeConfigStore	()Lcom/tencent/msf/boot/config/NativeConfigStore;
    //   92: ldc 194
    //   94: invokevirtual 200	com/tencent/msf/boot/config/NativeConfigStore:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 41	com/tencent/mobileqq/msf/core/c/b:f	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 41	com/tencent/mobileqq/msf/core/c/b:f	Ljava/lang/String;
    //   104: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +14 -> 121
    //   110: aload_0
    //   111: getfield 34	com/tencent/mobileqq/msf/core/c/b:c	Landroid/content/Context;
    //   114: aload_0
    //   115: getfield 41	com/tencent/mobileqq/msf/core/c/b:f	Ljava/lang/String;
    //   118: invokestatic 210	com/tencent/stat/StatConfig:setCustomUserId	(Landroid/content/Context;Ljava/lang/String;)V
    //   121: iconst_1
    //   122: putstatic 27	com/tencent/mobileqq/msf/core/c/b:a	Z
    //   125: ldc 13
    //   127: iconst_1
    //   128: new 212	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   135: ldc 215
    //   137: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 221
    //   146: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 41	com/tencent/mobileqq/msf/core/c/b:f	Ljava/lang/String;
    //   153: invokestatic 224	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: return
    //   166: aload_0
    //   167: getfield 39	com/tencent/mobileqq/msf/core/c/b:e	Lcom/tencent/stat/StatSpecifyReportedInfo;
    //   170: aload_1
    //   171: invokevirtual 148	com/tencent/stat/StatSpecifyReportedInfo:setInstallChannel	(Ljava/lang/String;)V
    //   174: goto -126 -> 48
    //   177: astore_1
    //   178: ldc 13
    //   180: iconst_1
    //   181: ldc 233
    //   183: aload_1
    //   184: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_1
    //   188: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   191: iconst_0
    //   192: putstatic 27	com/tencent/mobileqq/msf/core/c/b:a	Z
    //   195: return
    //   196: astore_2
    //   197: ldc 13
    //   199: iconst_1
    //   200: ldc 237
    //   202: aload_2
    //   203: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: new 241	java/util/Random
    //   209: dup
    //   210: invokespecial 242	java/util/Random:<init>	()V
    //   213: bipush 100
    //   215: invokevirtual 246	java/util/Random:nextInt	(I)I
    //   218: iconst_1
    //   219: if_icmpge -119 -> 100
    //   222: invokestatic 252	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   225: aload_2
    //   226: ldc 254
    //   228: aconst_null
    //   229: invokestatic 260	com/tencent/feedback/eup/CrashReport:handleCatchException	(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;[B)Z
    //   232: pop
    //   233: goto -133 -> 100
    //   236: goto -188 -> 48
    //   239: ldc_w 262
    //   242: astore_1
    //   243: goto -7 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	b
    //   0	246	1	paramString1	String
    //   0	246	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   0	8	177	java/lang/Exception
    //   12	21	177	java/lang/Exception
    //   25	45	177	java/lang/Exception
    //   48	88	177	java/lang/Exception
    //   88	100	177	java/lang/Exception
    //   100	121	177	java/lang/Exception
    //   121	165	177	java/lang/Exception
    //   166	174	177	java/lang/Exception
    //   197	233	177	java/lang/Exception
    //   88	100	196	java/lang/UnsatisfiedLinkError
  }
  
  public boolean isMtaSupported()
  {
    return this.g;
  }
  
  public void reportKVEvent(String paramString, Properties paramProperties)
  {
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportManager", 2, "reportKVEvent " + paramString + " \n\t\t" + paramProperties);
    }
    try
    {
      StatServiceImpl.trackCustomKVEvent(this.c, paramString, paramProperties, this.e);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void reportTimeKVEvent(String paramString, Properties paramProperties, int paramInt)
  {
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportManager", 2, "reportTimeKVEvent " + paramString + " " + paramInt + "\n\t\t" + paramProperties);
    }
    try
    {
      StatServiceImpl.trackCustomKVTimeIntervalEvent(this.c, paramString, paramProperties, paramInt, this.e);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MTAReportManager", 1, "reportTimeKVEvent", paramString);
      paramString.printStackTrace();
    }
  }
  
  public void trackBeginPage(String paramString) {}
  
  public void trackEndPage(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.b
 * JD-Core Version:    0.7.0.1
 */