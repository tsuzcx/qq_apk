package com.tencent.mobileqq.log;

import acbn;
import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import jqo;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class VipWebViewReportLog
{
  public static final String Tag = VipWebViewReportLog.class.getSimpleName();
  public static String Url;
  private static AppRuntime b;
  public static final String bPF;
  public static final String bPG;
  public static String bPH;
  public static AtomicInteger bv = new AtomicInteger(0);
  public static Set<String> cF = new HashSet();
  public static boolean clW;
  public static boolean clX;
  private static int dfl = 1;
  private static int dfm = 2;
  private static int dfn;
  public static int dfo;
  public static String mNetworkType;
  public static String mobileType;
  static Thread s;
  private static Context sContext;
  
  static
  {
    bPF = acbn.SDCARD_PATH + "WebViewCheck" + File.separator;
    bPG = "WebViewCheck" + File.separator;
    bPH = "null";
    mNetworkType = "null";
    mobileType = "null";
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (bv.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "VipWebViewReportLog init by context=" + paramContext + ", AppInterface=" + paramAppRuntime);
      }
      sContext = paramContext.getApplicationContext();
      b = paramAppRuntime;
      dfn = dfl;
      loadConfig();
    }
  }
  
  private static void a(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager == null) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return;
      bPH = "null";
      mNetworkType = "null";
      mobileType = "null";
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()));
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      mNetworkType = "unknown";
      mobileType = "unknown";
      return;
    case 9: 
      mNetworkType = "cable";
      return;
    case 1: 
    case 6: 
      mNetworkType = "WIFI";
      return;
    }
    bPH = paramTelephonyManager.getNetworkOperatorName();
    switch (paramTelephonyManager.getNetworkType())
    {
    default: 
      mNetworkType = "2G";
      mobileType = "unknown";
      return;
    case 13: 
      mNetworkType = "4G";
      mobileType = "LTE";
      return;
    case 3: 
      mNetworkType = "3G";
      mobileType = "UMTS";
      return;
    case 5: 
      mNetworkType = "3G";
      mobileType = "EVDO_0";
      return;
    case 6: 
      mNetworkType = "3G";
      mobileType = "EVDO_A";
      return;
    case 8: 
      mNetworkType = "3G";
      mobileType = "SDPA";
      return;
    case 9: 
      mNetworkType = "3G";
      mobileType = "HSUPA";
      return;
    case 10: 
      mNetworkType = "3G";
      mobileType = "HSPA";
      return;
    case 12: 
      mNetworkType = "3G";
      mobileType = "EVDO_B";
      return;
    case 14: 
      mNetworkType = "3G";
      mobileType = "EHRPD";
      return;
    case 15: 
      mNetworkType = "3G";
      mobileType = "HSPAP";
      return;
    case 1: 
      mNetworkType = "2G";
      mobileType = "GPRS";
      return;
    case 2: 
      mNetworkType = "2G";
      mobileType = "EDGE";
      return;
    case 4: 
      mNetworkType = "2G";
      mobileType = "CDMA";
      return;
    case 7: 
      mNetworkType = "2G";
      mobileType = "1xRTT";
      return;
    case 11: 
      mNetworkType = "2G";
      mobileType = "IDEN";
      return;
    }
    mNetworkType = "2G";
    mobileType = "unknown";
  }
  
  /* Error */
  public static void a(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramConsoleMessage)
  {
    // Byte code:
    //   0: getstatic 133	com/tencent/mobileqq/log/VipWebViewReportLog:b	Lmqq/app/AppRuntime;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifne +30 -> 40
    //   13: getstatic 135	com/tencent/mobileqq/log/VipWebViewReportLog:dfn	I
    //   16: getstatic 55	com/tencent/mobileqq/log/VipWebViewReportLog:dfm	I
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 209	com/tencent/mobileqq/log/VipWebViewReportLog:clW	Z
    //   25: ifeq +647 -> 672
    //   28: aload_0
    //   29: invokeinterface 215 1 0
    //   34: getstatic 221	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:ERROR	Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;
    //   37: if_acmpne +635 -> 672
    //   40: new 57	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   47: ldc 223
    //   49: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 225
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: new 57	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   68: aload_1
    //   69: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 227
    //   74: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_1
    //   81: new 57	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   88: aload_1
    //   89: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 229
    //   94: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_1
    //   101: new 57	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 231
    //   114: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 236	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   120: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: getstatic 133	com/tencent/mobileqq/log/VipWebViewReportLog:b	Lmqq/app/AppRuntime;
    //   130: invokevirtual 241	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   133: astore_2
    //   134: new 57	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 243
    //   147: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore_1
    //   158: aload_0
    //   159: invokeinterface 246 1 0
    //   164: ifnull +380 -> 544
    //   167: new 57	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   174: aload_1
    //   175: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 248
    //   180: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: invokeinterface 246 1 0
    //   189: invokestatic 254	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   192: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_1
    //   199: new 57	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   206: aload_1
    //   207: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 256
    //   213: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: invokeinterface 259 1 0
    //   222: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   225: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: astore_1
    //   232: aload_0
    //   233: invokeinterface 268 1 0
    //   238: ifnull +330 -> 568
    //   241: new 57	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   248: aload_1
    //   249: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 270
    //   255: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokeinterface 268 1 0
    //   264: invokestatic 254	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   267: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore_1
    //   274: new 57	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   281: aload_1
    //   282: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 272
    //   288: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   294: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   297: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_1
    //   301: getstatic 283	com/tencent/mobileqq/log/VipWebViewReportLog:Url	Ljava/lang/String;
    //   304: ifnull +288 -> 592
    //   307: new 57	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   314: aload_1
    //   315: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 285
    //   321: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: getstatic 283	com/tencent/mobileqq/log/VipWebViewReportLog:Url	Ljava/lang/String;
    //   327: invokestatic 254	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   330: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore_1
    //   337: aload_0
    //   338: invokeinterface 215 1 0
    //   343: ifnull +273 -> 616
    //   346: new 57	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   353: aload_1
    //   354: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc_w 287
    //   360: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: invokeinterface 215 1 0
    //   369: invokevirtual 288	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:toString	()Ljava/lang/String;
    //   372: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: astore_0
    //   379: new 57	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   386: aload_0
    //   387: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 290
    //   393: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: getstatic 295	android/os/Build:MODEL	Ljava/lang/String;
    //   399: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: astore_0
    //   406: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +231 -> 640
    //   412: new 57	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   419: aload_0
    //   420: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 297
    //   426: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: astore_0
    //   433: getstatic 131	com/tencent/mobileqq/log/VipWebViewReportLog:sContext	Landroid/content/Context;
    //   436: ldc_w 299
    //   439: invokevirtual 303	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   442: checkcast 162	android/telephony/TelephonyManager
    //   445: invokestatic 305	com/tencent/mobileqq/log/VipWebViewReportLog:a	(Landroid/telephony/TelephonyManager;)V
    //   448: new 57	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   455: aload_0
    //   456: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 307
    //   462: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: getstatic 85	com/tencent/mobileqq/log/VipWebViewReportLog:bPH	Ljava/lang/String;
    //   468: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: astore_0
    //   475: new 57	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   482: aload_0
    //   483: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 309
    //   489: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: getstatic 87	com/tencent/mobileqq/log/VipWebViewReportLog:mNetworkType	Ljava/lang/String;
    //   495: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: astore_0
    //   502: new 57	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   509: aload_0
    //   510: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 311
    //   516: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: getstatic 89	com/tencent/mobileqq/log/VipWebViewReportLog:mobileType	Ljava/lang/String;
    //   522: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: astore_0
    //   529: getstatic 44	com/tencent/mobileqq/log/VipWebViewReportLog:Tag	Ljava/lang/String;
    //   532: iconst_1
    //   533: aload_0
    //   534: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: return
    //   538: astore_0
    //   539: aload_0
    //   540: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   543: return
    //   544: new 57	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   551: aload_1
    //   552: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc_w 316
    //   558: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: astore_1
    //   565: goto -366 -> 199
    //   568: new 57	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   575: aload_1
    //   576: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: ldc_w 318
    //   582: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: astore_1
    //   589: goto -315 -> 274
    //   592: new 57	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   599: aload_1
    //   600: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: ldc_w 320
    //   606: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: astore_1
    //   613: goto -276 -> 337
    //   616: new 57	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   623: aload_1
    //   624: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc_w 322
    //   630: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: astore_0
    //   637: goto -258 -> 379
    //   640: new 57	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   647: aload_0
    //   648: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: ldc_w 324
    //   654: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: astore_0
    //   661: goto -228 -> 433
    //   664: astore_1
    //   665: aload_1
    //   666: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   669: goto -221 -> 448
    //   672: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	paramConsoleMessage	com.tencent.smtt.export.external.interfaces.ConsoleMessage
    //   60	564	1	str1	String
    //   664	2	1	localException	Exception
    //   133	18	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	6	538	java/lang/Exception
    //   7	28	538	java/lang/Exception
    //   28	40	538	java/lang/Exception
    //   40	199	538	java/lang/Exception
    //   199	274	538	java/lang/Exception
    //   274	337	538	java/lang/Exception
    //   337	379	538	java/lang/Exception
    //   379	433	538	java/lang/Exception
    //   448	537	538	java/lang/Exception
    //   544	565	538	java/lang/Exception
    //   568	589	538	java/lang/Exception
    //   592	613	538	java/lang/Exception
    //   616	637	538	java/lang/Exception
    //   640	661	538	java/lang/Exception
    //   665	669	538	java/lang/Exception
    //   433	448	664	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(4096);
    if ("null".equals(mNetworkType)) {}
    try
    {
      a((TelephonyManager)sContext.getSystemService("phone"));
      localStringBuilder.append("==> SUMMARY INFO <==\nNET_TYPE:").append(mNetworkType).append("\n").append("ERROR_CODE:").append(paramInt).append("\n");
      if (paramJSONObject != null)
      {
        long l2 = paramJSONObject.optLong("dns_start");
        long l8 = paramJSONObject.optLong("dns_end");
        l3 = paramJSONObject.optLong("connect_start");
        long l9 = paramJSONObject.optLong("connect_end");
        l4 = paramJSONObject.optLong("ssl_handshake_start");
        long l10 = paramJSONObject.optLong("ssl_handshake_end");
        l5 = paramJSONObject.optLong("send_start");
        long l11 = paramJSONObject.optLong("send_end");
        l6 = paramJSONObject.optLong("recv_start");
        l7 = paramJSONObject.optLong("recv_end");
        if (0L != l2)
        {
          l1 = l2;
          localStringBuilder.append("DNS cost=").append(l8 - l2).append("\n");
          localStringBuilder.append("Create connect cost=").append(l9 - l3).append("\n");
          localStringBuilder.append("SSL handshake cost=").append(l10 - l4).append("\n");
          localStringBuilder.append("Send cost=").append(l11 - l5).append("\n");
          localStringBuilder.append("Receive cost=").append(l7 - l6).append("\n");
          localStringBuilder.append("Total Duration=").append(l7 - l1).append("\n");
          localStringBuilder.append("Original Data:\n").append(paramJSONObject);
        }
      }
      else
      {
        QLog.d("WebCoreDump", 1, localStringBuilder.toString());
        if (paramWebResourceRequest == null) {
          break label732;
        }
        localStringBuilder.setLength(0);
        localStringBuilder.append("HAS_GESTURE:" + paramWebResourceRequest.hasGesture() + "\n");
        localStringBuilder.append("IS_FOR_MAINFRAME:" + paramWebResourceRequest.isForMainFrame() + "\n");
        localStringBuilder.append(paramWebResourceRequest.getMethod()).append(" ").append(paramWebResourceRequest.getUrl()).append("\n");
        paramJSONObject = paramWebResourceRequest.getRequestHeaders();
        if ((paramJSONObject == null) || (paramJSONObject.size() <= 0)) {
          break label702;
        }
        paramWebResourceRequest = paramJSONObject.keySet().iterator();
        for (;;)
        {
          if (!paramWebResourceRequest.hasNext()) {
            break label702;
          }
          String str = (String)paramWebResourceRequest.next();
          if (!str.equalsIgnoreCase("cookie")) {
            break;
          }
          localStringBuilder.append(str + ":" + jqo.b((String)paramJSONObject.get(str), new String[0]) + "\n");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l1;
        localException.printStackTrace();
        continue;
        if (0L != l3)
        {
          l1 = l3;
        }
        else if (0L != l4)
        {
          l1 = l4;
        }
        else if (0L != l5)
        {
          l1 = l5;
        }
        else if (0L != l6)
        {
          l1 = l6;
        }
        else
        {
          l1 = l7;
          continue;
          localStringBuilder.append(localException + ":" + (String)paramJSONObject.get(localException) + "\n");
        }
      }
      label702:
      QLog.d("WebCoreDump", 1, "-->HTTP REQUEST\n" + localStringBuilder.toString());
      label732:
      if (paramWebResourceResponse != null)
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("STATUS_CODE:" + paramWebResourceResponse.getStatusCode() + "\n").append("CONTENT_ENCODING:" + paramWebResourceResponse.getEncoding() + "\n").append("MIME_TYPE:" + paramWebResourceResponse.getMimeType() + "\n").append("REASON_PHRASE:" + paramWebResourceResponse.getReasonPhrase() + "\n");
        paramJSONObject = paramWebResourceResponse.getResponseHeaders();
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          paramWebResourceRequest = paramJSONObject.keySet().iterator();
          while (paramWebResourceRequest.hasNext())
          {
            paramWebResourceResponse = (String)paramWebResourceRequest.next();
            localStringBuilder.append(paramWebResourceResponse + ":" + (String)paramJSONObject.get(paramWebResourceResponse) + "\n");
          }
        }
        QLog.d("WebCoreDump", 1, "<--HTTP RESPONSE\n" + localStringBuilder.toString());
      }
    }
  }
  
  public static boolean apH()
  {
    QLog.d("WebCoreDump", 1, "-->uin in white list:" + clX);
    return clX;
  }
  
  public static void duQ()
  {
    if (dfn == dfl) {}
  }
  
  public static boolean isInited()
  {
    return bv.get() != 0;
  }
  
  public static void loadConfig()
  {
    if ((s == null) || (!s.isAlive()))
    {
      s = ThreadManager.newFreeThread(new LoadConfigRbl(), "WebviewLoadConfig", 8);
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 1, "ready to load config at:" + System.currentTimeMillis());
      }
      s.start();
    }
  }
  
  public static boolean nc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = cF.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
        {
          QLog.d("WebCoreDump", 1, "-->url:" + jqo.filterKeyForLog(paramString, new String[0]) + " is in white list");
          return true;
        }
      }
    }
    QLog.d("WebCoreDump", 1, "-->url:" + jqo.filterKeyForLog(paramString, new String[0]) + " is not in white list");
    return false;
  }
  
  static class LoadConfigRbl
    implements Runnable
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 23	java/lang/System:currentTimeMillis	()J
      //   3: lstore_3
      //   4: ldc 25
      //   6: iconst_1
      //   7: new 27	java/lang/StringBuilder
      //   10: dup
      //   11: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   14: ldc 30
      //   16: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   19: lload_3
      //   20: invokevirtual 37	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   23: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   29: getstatic 51	com/tencent/mobileqq/log/VipWebViewReportLog:bPF	Ljava/lang/String;
      //   32: invokestatic 57	aqhq:cn	(Ljava/lang/String;)V
      //   35: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   38: ifeq +11 -> 49
      //   41: ldc 25
      //   43: iconst_2
      //   44: ldc 63
      //   46: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   49: ldc 65
      //   51: astore 5
      //   53: invokestatic 68	com/tencent/mobileqq/log/VipWebViewReportLog:d	()Lmqq/app/AppRuntime;
      //   56: ifnull +53 -> 109
      //   59: new 27	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   66: invokestatic 68	com/tencent/mobileqq/log/VipWebViewReportLog:d	()Lmqq/app/AppRuntime;
      //   69: invokevirtual 74	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
      //   72: invokevirtual 80	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
      //   75: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   78: getstatic 88	java/io/File:separator	Ljava/lang/String;
      //   81: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: getstatic 91	com/tencent/mobileqq/log/VipWebViewReportLog:bPG	Ljava/lang/String;
      //   87: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: invokestatic 68	com/tencent/mobileqq/log/VipWebViewReportLog:d	()Lmqq/app/AppRuntime;
      //   93: invokevirtual 94	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   96: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: ldc 96
      //   101: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   107: astore 5
      //   109: new 85	java/io/File
      //   112: dup
      //   113: aload 5
      //   115: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
      //   118: astore 5
      //   120: aload 5
      //   122: invokevirtual 101	java/io/File:exists	()Z
      //   125: ifeq +329 -> 454
      //   128: ldc 25
      //   130: iconst_1
      //   131: ldc 103
      //   133: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   136: iconst_0
      //   137: putstatic 107	com/tencent/mobileqq/log/VipWebViewReportLog:dfo	I
      //   140: invokestatic 111	com/tencent/mobileqq/log/VipWebViewReportLog:access$200	()I
      //   143: invokestatic 115	com/tencent/mobileqq/log/VipWebViewReportLog:access$102	(I)I
      //   146: pop
      //   147: aload 5
      //   149: invokestatic 119	aqhq:readFileContent	(Ljava/io/File;)Ljava/lang/String;
      //   152: astore 5
      //   154: aload 5
      //   156: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   159: ifne +168 -> 327
      //   162: new 127	org/json/JSONObject
      //   165: dup
      //   166: aload 5
      //   168: invokespecial 128	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   171: astore 5
      //   173: aload 5
      //   175: ldc 130
      //   177: iconst_1
      //   178: invokevirtual 134	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
      //   181: putstatic 138	com/tencent/mobileqq/log/VipWebViewReportLog:clW	Z
      //   184: aload 5
      //   186: ldc 140
      //   188: iconst_1
      //   189: invokevirtual 134	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
      //   192: putstatic 143	com/tencent/mobileqq/log/VipWebViewReportLog:clX	Z
      //   195: aload 5
      //   197: ldc 145
      //   199: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   202: ifeq +158 -> 360
      //   205: aload 5
      //   207: ldc 145
      //   209: invokevirtual 153	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   212: astore 6
      //   214: aload 6
      //   216: invokevirtual 158	org/json/JSONArray:length	()I
      //   219: istore_2
      //   220: iconst_0
      //   221: istore_1
      //   222: iload_1
      //   223: iload_2
      //   224: if_icmpge +53 -> 277
      //   227: getstatic 162	com/tencent/mobileqq/log/VipWebViewReportLog:cF	Ljava/util/Set;
      //   230: aload 6
      //   232: iload_1
      //   233: invokevirtual 166	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   236: invokeinterface 172 2 0
      //   241: pop
      //   242: iload_1
      //   243: iconst_1
      //   244: iadd
      //   245: istore_1
      //   246: goto -24 -> 222
      //   249: astore 5
      //   251: ldc 25
      //   253: iconst_1
      //   254: iconst_2
      //   255: anewarray 4	java/lang/Object
      //   258: dup
      //   259: iconst_0
      //   260: ldc 174
      //   262: aastore
      //   263: dup
      //   264: iconst_1
      //   265: aload 5
      //   267: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
      //   270: aastore
      //   271: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   274: goto -225 -> 49
      //   277: ldc 25
      //   279: iconst_1
      //   280: new 27	java/lang/StringBuilder
      //   283: dup
      //   284: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   287: ldc 181
      //   289: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: getstatic 162	com/tencent/mobileqq/log/VipWebViewReportLog:cF	Ljava/util/Set;
      //   295: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   298: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   301: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   304: getstatic 143	com/tencent/mobileqq/log/VipWebViewReportLog:clX	Z
      //   307: ifeq +13 -> 320
      //   310: aload 5
      //   312: ldc 145
      //   314: invokevirtual 149	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   317: ifeq +119 -> 436
      //   320: getstatic 185	com/tencent/mobileqq/log/VipWebViewReportLog:bv	Ljava/util/concurrent/atomic/AtomicInteger;
      //   323: iconst_2
      //   324: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   327: invokestatic 194	com/tencent/mobileqq/log/VipWebViewReportLog:duQ	()V
      //   330: ldc 25
      //   332: iconst_1
      //   333: new 27	java/lang/StringBuilder
      //   336: dup
      //   337: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   340: ldc 196
      //   342: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   345: invokestatic 23	java/lang/System:currentTimeMillis	()J
      //   348: lload_3
      //   349: lsub
      //   350: invokevirtual 37	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   353: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   356: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   359: return
      //   360: ldc 25
      //   362: iconst_1
      //   363: new 27	java/lang/StringBuilder
      //   366: dup
      //   367: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   370: ldc 198
      //   372: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: aload 5
      //   377: invokevirtual 199	org/json/JSONObject:toString	()Ljava/lang/String;
      //   380: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   386: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   389: goto -85 -> 304
      //   392: astore 5
      //   394: getstatic 185	com/tencent/mobileqq/log/VipWebViewReportLog:bv	Ljava/util/concurrent/atomic/AtomicInteger;
      //   397: iconst_0
      //   398: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   401: ldc 25
      //   403: iconst_1
      //   404: new 27	java/lang/StringBuilder
      //   407: dup
      //   408: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   411: ldc 201
      //   413: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   416: aload 5
      //   418: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
      //   421: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   427: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   430: invokestatic 194	com/tencent/mobileqq/log/VipWebViewReportLog:duQ	()V
      //   433: goto -103 -> 330
      //   436: getstatic 185	com/tencent/mobileqq/log/VipWebViewReportLog:bv	Ljava/util/concurrent/atomic/AtomicInteger;
      //   439: iconst_0
      //   440: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   443: goto -116 -> 327
      //   446: astore 5
      //   448: invokestatic 194	com/tencent/mobileqq/log/VipWebViewReportLog:duQ	()V
      //   451: aload 5
      //   453: athrow
      //   454: invokestatic 111	com/tencent/mobileqq/log/VipWebViewReportLog:access$200	()I
      //   457: invokestatic 115	com/tencent/mobileqq/log/VipWebViewReportLog:access$102	(I)I
      //   460: pop
      //   461: invokestatic 194	com/tencent/mobileqq/log/VipWebViewReportLog:duQ	()V
      //   464: ldc 25
      //   466: iconst_1
      //   467: new 27	java/lang/StringBuilder
      //   470: dup
      //   471: invokespecial 28	java/lang/StringBuilder:<init>	()V
      //   474: ldc 203
      //   476: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   479: aload 5
      //   481: invokevirtual 206	java/io/File:getPath	()Ljava/lang/String;
      //   484: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   487: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   490: invokestatic 47	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   493: getstatic 185	com/tencent/mobileqq/log/VipWebViewReportLog:bv	Ljava/util/concurrent/atomic/AtomicInteger;
      //   496: iconst_0
      //   497: invokevirtual 191	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   500: goto -170 -> 330
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	503	0	this	LoadConfigRbl
      //   221	25	1	i	int
      //   219	6	2	j	int
      //   3	346	3	l	long
      //   51	155	5	localObject1	Object
      //   249	127	5	localException1	Exception
      //   392	25	5	localException2	Exception
      //   446	34	5	localObject2	Object
      //   212	19	6	localJSONArray	org.json.JSONArray
      // Exception table:
      //   from	to	target	type
      //   29	49	249	java/lang/Exception
      //   147	220	392	java/lang/Exception
      //   227	242	392	java/lang/Exception
      //   277	304	392	java/lang/Exception
      //   304	320	392	java/lang/Exception
      //   320	327	392	java/lang/Exception
      //   360	389	392	java/lang/Exception
      //   436	443	392	java/lang/Exception
      //   147	220	446	finally
      //   227	242	446	finally
      //   277	304	446	finally
      //   304	320	446	finally
      //   320	327	446	finally
      //   360	389	446	finally
      //   394	430	446	finally
      //   436	443	446	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.log.VipWebViewReportLog
 * JD-Core Version:    0.7.0.1
 */