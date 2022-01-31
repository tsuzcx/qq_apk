package com.tencent.open.business.viareport;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import fdk;
import fdl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public class ReportManager
{
  protected static ReportManager a;
  protected static final String a = "viareport";
  protected static final String c = "http://analy.qq.com/cgi-bin/mapp_apptrace";
  public static final String d = "opensdk_report_thread";
  protected static final String e = "mapp_apptrace";
  protected ArrayList a;
  public volatile boolean a;
  protected String b;
  protected ArrayList b;
  
  protected ReportManager()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessViareportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessViareportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessViareportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "http://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected String a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        BatchReportInfo localBatchReportInfo = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(localBatchReportInfo.jdField_a_of_type_JavaLangString + "_" + localBatchReportInfo.jdField_b_of_type_JavaLangString + "_" + localBatchReportInfo.c + "_" + localBatchReportInfo.a() + "_" + localBatchReportInfo.g);
        localStringBuilder.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(paramArrayList2.jdField_a_of_type_JavaLangString + "_" + paramArrayList2.jdField_b_of_type_JavaLangString + "_" + paramArrayList2.c + "_" + paramArrayList2.a() + "_" + paramArrayList2.g);
        localStringBuilder.append(",");
      }
    }
    paramArrayList2 = localStringBuilder.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  protected void a()
  {
    String str = String.valueOf(CommonDataAdapter.a().a());
    if (a(str)) {
      ThreadManager.a(new fdl(this, str));
    }
  }
  
  public void a(BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    a(String.valueOf(CommonDataAdapter.a().a()), paramBatchReportInfo, paramBundle, paramBoolean);
  }
  
  public void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      if (!a(paramString, localBundle))
      {
        LogUtility.b("viareport", "database empty");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("action", "100");
    localBundle.putString("imei", MobileInfoUtil.c());
    localBundle.putString("resolution", MobileInfoUtil.e());
    localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().a()));
    localBundle.putString("wifimac", MobileInfoUtil.a());
    localBundle.putString("mobile_pf", "1");
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("lang", MobileInfoUtil.b());
    localBundle.putString("device", Build.DEVICE);
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("sdk_ver", "1.5");
    localBundle.putString("timezone", TimeZone.getDefault().getID());
    localBundle.putString("city", MobileInfoUtil.g());
    localBundle.putString("longitude", MobileInfoUtil.f());
    localBundle.putString("ret_code", "0");
    localBundle.putString("qua", CommonDataAdapter.a().e());
    localBundle.putString("qz_ver", CommonDataAdapter.a().b());
    localBundle.putString("ext", CommonDataAdapter.a().h());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    if (paramBoolean) {}
    for (paramString = "POST";; paramString = "GET")
    {
      a(a(), paramString, localBundle, paramBoolean);
      return;
    }
  }
  
  public void a(String paramString, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    ThreadManager.a(new fdk(this, paramBoolean, paramBatchReportInfo, paramBundle, paramString));
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 283	com/tencent/open/business/viareport/ReportConfig:b	()I
    //   3: istore 8
    //   5: ldc 9
    //   7: new 53	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 285
    //   17: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload 8
    //   22: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: istore 6
    //   34: iconst_0
    //   35: istore 5
    //   37: invokestatic 293	android/os/SystemClock:elapsedRealtime	()J
    //   40: lstore 15
    //   42: lconst_0
    //   43: lstore 11
    //   45: lconst_0
    //   46: lstore 17
    //   48: iconst_0
    //   49: istore 9
    //   51: iload 6
    //   53: iconst_1
    //   54: iadd
    //   55: istore 7
    //   57: lload 11
    //   59: lstore 19
    //   61: aload_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokestatic 298	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$Statistic;
    //   67: astore 23
    //   69: lload 11
    //   71: lstore 19
    //   73: aload 23
    //   75: getfield 301	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokestatic 304	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore 24
    //   83: lload 11
    //   85: lstore 19
    //   87: aload 24
    //   89: ldc_w 306
    //   92: invokevirtual 312	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   95: istore 6
    //   97: iload 6
    //   99: ifeq +22 -> 121
    //   102: lload 11
    //   104: lstore 19
    //   106: aload 23
    //   108: getfield 301	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore 10
    //   116: iload 10
    //   118: ifne +951 -> 1069
    //   121: iconst_1
    //   122: istore 6
    //   124: iload 8
    //   126: istore 5
    //   128: lload 11
    //   130: lstore 19
    //   132: lload 11
    //   134: lstore 13
    //   136: aload 23
    //   138: getfield 315	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_Long	J
    //   141: lstore 11
    //   143: lload 11
    //   145: lstore 19
    //   147: lload 11
    //   149: lstore 13
    //   151: aload 23
    //   153: getfield 317	com/tencent/open/base/http/HttpBaseUtil$Statistic:b	J
    //   156: lstore 21
    //   158: iload 9
    //   160: istore 7
    //   162: lload 21
    //   164: lstore 13
    //   166: iload 5
    //   168: iload 8
    //   170: if_icmplt +876 -> 1046
    //   173: ldc 9
    //   175: new 53	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 319
    //   185: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 15
    //   190: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc_w 324
    //   196: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: lload 11
    //   201: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc_w 324
    //   207: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload 13
    //   212: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: ldc_w 324
    //   218: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 7
    //   223: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 326	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_0
    //   233: iload 7
    //   235: invokevirtual 329	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   238: ifeq +29 -> 267
    //   241: invokestatic 334	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   244: ldc 18
    //   246: lload 15
    //   248: lload 11
    //   250: lload 13
    //   252: iload 7
    //   254: invokestatic 110	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   257: invokevirtual 113	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   260: ldc_w 336
    //   263: aconst_null
    //   264: invokevirtual 339	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   267: iload 6
    //   269: iconst_1
    //   270: if_icmpne +708 -> 978
    //   273: ldc_w 341
    //   276: ldc_w 343
    //   279: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: iload 4
    //   284: ifeq +25 -> 309
    //   287: ldc 9
    //   289: ldc_w 345
    //   292: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: iconst_0
    //   297: putfield 31	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   300: iload 6
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 347	com/tencent/open/business/viareport/ReportManager:a	()V
    //   309: return
    //   310: astore 24
    //   312: bipush 252
    //   314: istore 6
    //   316: goto -219 -> 97
    //   319: astore 23
    //   321: iload 5
    //   323: istore 6
    //   325: iload 7
    //   327: istore 5
    //   329: invokestatic 293	android/os/SystemClock:elapsedRealtime	()J
    //   332: lstore 15
    //   334: lconst_0
    //   335: lstore 11
    //   337: lconst_0
    //   338: lstore 13
    //   340: bipush 249
    //   342: istore 7
    //   344: ldc 9
    //   346: new 53	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 349
    //   356: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 23
    //   361: invokevirtual 350	org/apache/http/conn/ConnectTimeoutException:toString	()Ljava/lang/String;
    //   364: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -207 -> 166
    //   376: astore 23
    //   378: iload 5
    //   380: istore 6
    //   382: iload 7
    //   384: istore 5
    //   386: invokestatic 293	android/os/SystemClock:elapsedRealtime	()J
    //   389: lstore 15
    //   391: lconst_0
    //   392: lstore 11
    //   394: lconst_0
    //   395: lstore 13
    //   397: bipush 248
    //   399: istore 7
    //   401: ldc 9
    //   403: new 53	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 349
    //   413: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 23
    //   418: invokevirtual 353	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   421: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -264 -> 166
    //   433: astore 23
    //   435: iload 5
    //   437: istore 6
    //   439: iload 7
    //   441: istore 5
    //   443: lconst_0
    //   444: lstore 11
    //   446: lconst_0
    //   447: lstore 13
    //   449: bipush 252
    //   451: istore 7
    //   453: ldc 9
    //   455: new 53	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 349
    //   465: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 23
    //   470: invokevirtual 354	org/json/JSONException:toString	()Ljava/lang/String;
    //   473: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -316 -> 166
    //   485: astore_1
    //   486: ldc 9
    //   488: new 53	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 349
    //   498: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual 355	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:toString	()Ljava/lang/String;
    //   505: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_0
    //   515: iconst_0
    //   516: putfield 31	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   519: return
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 358	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:getMessage	()Ljava/lang/String;
    //   525: ldc_w 360
    //   528: ldc 27
    //   530: invokevirtual 364	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   533: invokestatic 369	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   536: istore 5
    //   538: aload_0
    //   539: iload 5
    //   541: invokevirtual 329	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   544: ifeq +29 -> 573
    //   547: invokestatic 334	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   550: ldc 18
    //   552: lload 15
    //   554: lload 19
    //   556: lload 17
    //   558: iload 5
    //   560: invokestatic 110	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   563: invokevirtual 113	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   566: ldc_w 336
    //   569: aconst_null
    //   570: invokevirtual 339	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   573: ldc 9
    //   575: new 53	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 349
    //   585: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokevirtual 370	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   592: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: aload_0
    //   602: iconst_0
    //   603: putfield 31	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   606: return
    //   607: astore_2
    //   608: ldc 9
    //   610: new 53	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 349
    //   620: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_1
    //   624: invokevirtual 370	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   627: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: goto -63 -> 573
    //   639: astore 23
    //   641: iload 5
    //   643: istore 6
    //   645: iload 7
    //   647: istore 5
    //   649: lconst_0
    //   650: lstore 11
    //   652: lconst_0
    //   653: lstore 13
    //   655: aload 23
    //   657: invokestatic 375	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   660: istore 7
    //   662: ldc 9
    //   664: new 53	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 349
    //   674: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 23
    //   679: invokevirtual 376	java/io/IOException:toString	()Ljava/lang/String;
    //   682: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: goto -525 -> 166
    //   694: astore 23
    //   696: iload 5
    //   698: istore 6
    //   700: iload 7
    //   702: istore 5
    //   704: aload 23
    //   706: instanceof 273
    //   709: ifeq +38 -> 747
    //   712: ldc 9
    //   714: new 53	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 349
    //   724: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 23
    //   729: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   732: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload_0
    //   742: iconst_0
    //   743: putfield 31	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   746: return
    //   747: aload 23
    //   749: instanceof 275
    //   752: ifeq +124 -> 876
    //   755: aload 23
    //   757: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   760: ldc_w 360
    //   763: ldc 27
    //   765: invokevirtual 364	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   768: invokestatic 369	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   771: istore 5
    //   773: aload_0
    //   774: iload 5
    //   776: invokevirtual 329	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   779: ifeq +29 -> 808
    //   782: invokestatic 334	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   785: ldc 18
    //   787: lload 15
    //   789: lload 11
    //   791: lload 17
    //   793: iload 5
    //   795: invokestatic 110	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   798: invokevirtual 113	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   801: ldc_w 336
    //   804: aconst_null
    //   805: invokevirtual 339	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   808: ldc 9
    //   810: new 53	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 349
    //   820: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 23
    //   825: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   828: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   837: aload_0
    //   838: iconst_0
    //   839: putfield 31	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   842: return
    //   843: astore_1
    //   844: ldc 9
    //   846: new 53	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 349
    //   856: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 23
    //   861: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   864: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: goto -65 -> 808
    //   876: aload 23
    //   878: instanceof 277
    //   881: ifeq +51 -> 932
    //   884: lconst_0
    //   885: lstore 11
    //   887: lconst_0
    //   888: lstore 13
    //   890: aload 23
    //   892: checkcast 277	java/io/IOException
    //   895: invokestatic 375	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   898: istore 7
    //   900: ldc 9
    //   902: new 53	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 349
    //   912: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 23
    //   917: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   920: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: goto -763 -> 166
    //   932: lconst_0
    //   933: lstore 11
    //   935: lconst_0
    //   936: lstore 13
    //   938: bipush 250
    //   940: istore 7
    //   942: ldc 9
    //   944: new 53	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 349
    //   954: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 23
    //   959: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   962: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 352	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   971: iload 8
    //   973: istore 5
    //   975: goto -809 -> 166
    //   978: ldc_w 341
    //   981: ldc_w 380
    //   984: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: iload 4
    //   989: ifeq -707 -> 282
    //   992: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   995: aload_0
    //   996: getfield 38	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   999: invokevirtual 388	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1002: pop
    //   1003: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   1006: aload_0
    //   1007: getfield 36	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1010: invokevirtual 388	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1013: pop
    //   1014: goto -732 -> 282
    //   1017: astore 23
    //   1019: lload 13
    //   1021: lstore 11
    //   1023: goto -319 -> 704
    //   1026: astore 23
    //   1028: goto -379 -> 649
    //   1031: astore 23
    //   1033: goto -590 -> 443
    //   1036: astore 23
    //   1038: goto -652 -> 386
    //   1041: astore 23
    //   1043: goto -714 -> 329
    //   1046: iload 5
    //   1048: istore 9
    //   1050: iload 6
    //   1052: istore 5
    //   1054: iload 9
    //   1056: istore 6
    //   1058: lload 13
    //   1060: lstore 17
    //   1062: iload 7
    //   1064: istore 9
    //   1066: goto -1015 -> 51
    //   1069: iload 5
    //   1071: istore 6
    //   1073: iload 7
    //   1075: istore 5
    //   1077: goto -949 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1080	0	this	ReportManager
    //   0	1080	1	paramString1	String
    //   0	1080	2	paramString2	String
    //   0	1080	3	paramBundle	Bundle
    //   0	1080	4	paramBoolean	boolean
    //   35	1041	5	i	int
    //   32	1040	6	j	int
    //   55	1019	7	k	int
    //   3	969	8	m	int
    //   49	1016	9	n	int
    //   114	3	10	bool	boolean
    //   43	979	11	l1	long
    //   134	925	13	l2	long
    //   40	748	15	l3	long
    //   46	1015	17	l4	long
    //   59	496	19	l5	long
    //   156	7	21	l6	long
    //   67	85	23	localStatistic	com.tencent.open.base.http.HttpBaseUtil.Statistic
    //   319	41	23	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   376	41	23	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   433	36	23	localJSONException1	org.json.JSONException
    //   639	39	23	localIOException1	java.io.IOException
    //   694	264	23	localException1	java.lang.Exception
    //   1017	1	23	localException2	java.lang.Exception
    //   1026	1	23	localIOException2	java.io.IOException
    //   1031	1	23	localJSONException2	org.json.JSONException
    //   1036	1	23	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1041	1	23	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   81	7	24	localJSONObject	org.json.JSONObject
    //   310	1	24	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   87	97	310	org/json/JSONException
    //   61	69	319	org/apache/http/conn/ConnectTimeoutException
    //   73	83	319	org/apache/http/conn/ConnectTimeoutException
    //   87	97	319	org/apache/http/conn/ConnectTimeoutException
    //   106	116	319	org/apache/http/conn/ConnectTimeoutException
    //   61	69	376	java/net/SocketTimeoutException
    //   73	83	376	java/net/SocketTimeoutException
    //   87	97	376	java/net/SocketTimeoutException
    //   106	116	376	java/net/SocketTimeoutException
    //   61	69	433	org/json/JSONException
    //   73	83	433	org/json/JSONException
    //   106	116	433	org/json/JSONException
    //   61	69	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   73	83	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   87	97	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   106	116	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   136	143	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   151	158	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   61	69	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   73	83	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   87	97	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   106	116	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   136	143	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   151	158	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   521	573	607	java/lang/Exception
    //   61	69	639	java/io/IOException
    //   73	83	639	java/io/IOException
    //   87	97	639	java/io/IOException
    //   106	116	639	java/io/IOException
    //   61	69	694	java/lang/Exception
    //   73	83	694	java/lang/Exception
    //   87	97	694	java/lang/Exception
    //   106	116	694	java/lang/Exception
    //   755	808	843	java/lang/Exception
    //   136	143	1017	java/lang/Exception
    //   151	158	1017	java/lang/Exception
    //   136	143	1026	java/io/IOException
    //   151	158	1026	java/io/IOException
    //   136	143	1031	org/json/JSONException
    //   151	158	1031	org/json/JSONException
    //   136	143	1036	java/net/SocketTimeoutException
    //   151	158	1036	java/net/SocketTimeoutException
    //   136	143	1041	org/apache/http/conn/ConnectTimeoutException
    //   151	158	1041	org/apache/http/conn/ConnectTimeoutException
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 389	com/tencent/open/business/viareport/ReportConfig:a	()J
    //   5: lstore_1
    //   6: invokestatic 394	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: ldc 9
    //   12: new 53	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 396
    //   22: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 398
    //   32: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_3
    //   36: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic 400	com/tencent/open/business/viareport/ReportConfig:b	()J
    //   48: lstore 5
    //   50: ldc 9
    //   52: new 53	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 402
    //   62: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload 5
    //   67: invokevirtual 322	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_3
    //   77: lload_1
    //   78: lsub
    //   79: lload 5
    //   81: ldc2_w 403
    //   84: lmul
    //   85: lcmp
    //   86: ifge +20 -> 106
    //   89: ldc_w 341
    //   92: ldc_w 406
    //   95: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iconst_0
    //   99: istore 7
    //   101: aload_0
    //   102: monitorexit
    //   103: iload 7
    //   105: ireturn
    //   106: lload_3
    //   107: invokestatic 409	com/tencent/open/business/viareport/ReportConfig:a	(J)V
    //   110: ldc_w 341
    //   113: ldc_w 411
    //   116: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iconst_1
    //   120: istore 7
    //   122: goto -21 -> 101
    //   125: astore 8
    //   127: aload_0
    //   128: monitorexit
    //   129: aload 8
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ReportManager
    //   5	73	1	l1	long
    //   9	98	3	l2	long
    //   48	32	5	l3	long
    //   99	22	7	bool	boolean
    //   125	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	76	125	finally
    //   89	98	125	finally
    //   106	119	125	finally
  }
  
  /* Error */
  protected boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: invokestatic 414	com/tencent/open/business/viareport/ReportConfig:a	(I)I
    //   6: istore_1
    //   7: ldc 9
    //   9: new 53	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 416
    //   19: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 418	java/util/Random
    //   35: dup
    //   36: invokespecial 419	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 422	java/util/Random:nextInt	(I)I
    //   44: iload_1
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 424
    //   51: ldc_w 426
    //   54: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: ldc_w 424
    //   66: ldc_w 428
    //   69: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramInt	int
    //   58	16	2	bool	boolean
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 430	com/tencent/open/business/viareport/ReportConfig:a	()I
    //   5: istore_2
    //   6: ldc 9
    //   8: new 53	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 432
    //   18: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   34: aload_1
    //   35: invokevirtual 434	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: if_icmplt +18 -> 57
    //   42: ldc_w 341
    //   45: ldc_w 436
    //   48: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: istore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_3
    //   56: ireturn
    //   57: ldc_w 341
    //   60: ldc_w 438
    //   63: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iconst_0
    //   67: istore_3
    //   68: goto -15 -> 53
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ReportManager
    //   0	76	1	paramString	String
    //   5	35	2	i	int
    //   52	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	51	71	finally
    //   57	66	71	finally
  }
  
  /* Error */
  protected boolean a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   6: aload_1
    //   7: invokevirtual 441	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   10: putfield 36	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   16: ldc_w 443
    //   19: aload_1
    //   20: invokevirtual 446	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   28: aload_1
    //   29: invokevirtual 448	com/tencent/open/business/viareport/ReportDbHelper:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 38	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: invokestatic 385	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   38: ldc_w 450
    //   41: aload_1
    //   42: invokevirtual 446	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 36	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 38	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 452	com/tencent/open/business/viareport/ReportManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 9
    //   61: new 53	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 454
    //   71: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 456
    //   88: aload_1
    //   89: invokevirtual 152	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +9 -> 107
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ReportManager
    //   0	117	1	paramString	String
    //   0	117	2	paramBundle	Bundle
    //   96	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	97	112	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 457	com/tencent/open/business/viareport/ReportConfig:a	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: ldc 9
    //   9: new 53	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 459
    //   19: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 418	java/util/Random
    //   35: dup
    //   36: invokespecial 419	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 422	java/util/Random:nextInt	(I)I
    //   44: iload_2
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 424
    //   51: ldc_w 461
    //   54: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 424
    //   66: ldc_w 463
    //   69: invokestatic 147	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramString	String
    //   6	40	2	i	int
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager
 * JD-Core Version:    0.7.0.1
 */