package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.Base64;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

public class TbsLogReport
{
  private static TbsLogReport a;
  private Handler b = null;
  private Context c;
  private boolean d = false;
  
  private TbsLogReport(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    paramContext = new HandlerThread("TbsLogReportThread");
    paramContext.start();
    this.b = new TbsLogReport.1(this, paramContext.getLooper());
  }
  
  private String a(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private JSONArray a()
  {
    Object localObject = d().getString("tbs_download_upload", null);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        String str = new String(Base64.a((String)localObject, 2));
        localObject = str;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        try
        {
          JSONArray localJSONArray1 = new JSONArray((String)localObject);
          localObject = localJSONArray1;
          if (localJSONArray1.length() <= 5) {
            continue;
          }
          JSONArray localJSONArray2 = new JSONArray();
          int i = localJSONArray1.length() - 1;
          localObject = localJSONArray1;
          if (i < localJSONArray1.length() - 5) {
            continue;
          }
          localJSONArray2.put(localJSONArray1.get(i));
          return localJSONArray2;
        }
        catch (Exception localException)
        {
          return new JSONArray();
        }
      }
      if (localObject == null)
      {
        localObject = new JSONArray();
        return localObject;
      }
    }
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo)
  {
    if ((QbSdk.o != null) && (QbSdk.o.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.o.get("SET_SENDREQUEST_AND_UPLOAD").equals("false"))) {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
    }
    do
    {
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramInt));
      localStringBuilder.append(a(null));
      localStringBuilder.append(a(k.a(this.c)));
      localStringBuilder.append(a(q.a().j(this.c)));
      Object localObject1 = com.tencent.smtt.utils.q.d(this.c);
      try
      {
        localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          localStringBuilder.append(a(b.e(this.c)));
        }
      }
      localStringBuilder.append(a((String)localObject1));
      localObject1 = this.c.getPackageName();
      localStringBuilder.append(a((String)localObject1));
      if (!"com.tencent.mm".equals(localObject1)) {
        break;
      }
      localStringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(a(a(TbsLogInfo.a(paramTbsLogInfo))));
      localStringBuilder.append(a(TbsLogInfo.b(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.c(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.d(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.e(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.f(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.g(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.h(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.i(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.j(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.k(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.l(paramTbsLogInfo)));
      localStringBuilder.append(b(TbsLogInfo.m(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.n(paramTbsLogInfo)));
      localStringBuilder.append(a(paramTbsLogInfo.a));
      localStringBuilder.append(a(TbsLogInfo.o(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsLogInfo.p(paramTbsLogInfo)));
      localStringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt("tbs_download_version", 0)));
      localStringBuilder.append(a(b.k(this.c)));
      localStringBuilder.append(a("4.3.0.190_44090"));
      localStringBuilder.append(false);
      localObject1 = d();
      paramTbsLogInfo = a();
      paramTbsLogInfo.put(localStringBuilder.toString());
      localObject2 = ((SharedPreferences)localObject1).edit();
      paramTbsLogInfo = paramTbsLogInfo.toString();
      try
      {
        localObject1 = Base64.encodeToString(paramTbsLogInfo.getBytes(), 2);
        paramTbsLogInfo = (TbsLogInfo)localObject1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
      ((SharedPreferences.Editor)localObject2).putString("tbs_download_upload", paramTbsLogInfo);
      ((SharedPreferences.Editor)localObject2).commit();
    } while ((!this.d) && (paramInt == EventType.TYPE_LOAD.a));
    b();
  }
  
  private void a(int paramInt, TbsLogInfo paramTbsLogInfo, EventType paramEventType)
  {
    paramTbsLogInfo.setErrorCode(paramInt);
    paramTbsLogInfo.setEventTime(System.currentTimeMillis());
    QbSdk.n.onInstallFinish(paramInt);
    eventReport(paramEventType, paramTbsLogInfo);
  }
  
  private String b(long paramLong)
  {
    return paramLong + "|";
  }
  
  private void b()
  {
    if ((QbSdk.o != null) && (QbSdk.o.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (QbSdk.o.get("SET_SENDREQUEST_AND_UPLOAD").equals("false")))
    {
      TbsLog.i("upload", "[TbsLogReport.sendLogReportRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = a();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = f.a(n.a(this.c).c(), ((JSONArray)localObject).toString().getBytes("utf-8"), new TbsLogReport.3(this), true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject + " testcase: " + -1);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    SharedPreferences.Editor localEditor = d().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private SharedPreferences d()
  {
    return this.c.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new TbsLogReport(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      SharedPreferences.Editor localEditor = d().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dailyReport()
  {
    this.b.sendEmptyMessage(601);
  }
  
  public void eventReport(EventType paramEventType, TbsLogInfo paramTbsLogInfo)
  {
    try
    {
      paramTbsLogInfo = (TbsLogInfo)paramTbsLogInfo.clone();
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 600;
      localMessage.arg1 = paramEventType.a;
      localMessage.obj = paramTbsLogInfo;
      this.b.sendMessage(localMessage);
      return;
    }
    catch (Throwable paramEventType)
    {
      TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + paramEventType.getMessage());
    }
  }
  
  public boolean getShouldUploadEventReport()
  {
    return this.d;
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 152	com/tencent/smtt/sdk/QbSdk:o	Ljava/util/Map;
    //   6: ifnull +43 -> 49
    //   9: getstatic 152	com/tencent/smtt/sdk/QbSdk:o	Ljava/util/Map;
    //   12: ldc 154
    //   14: invokeinterface 160 2 0
    //   19: ifeq +30 -> 49
    //   22: getstatic 152	com/tencent/smtt/sdk/QbSdk:o	Ljava/util/Map;
    //   25: ldc 154
    //   27: invokeinterface 163 2 0
    //   32: ldc 165
    //   34: invokevirtual 168	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +12 -> 49
    //   40: ldc 170
    //   42: ldc_w 460
    //   45: invokestatic 178	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: return
    //   49: aload_0
    //   50: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   53: invokestatic 465	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   56: iconst_3
    //   57: if_icmpne -9 -> 48
    //   60: invokestatic 468	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   63: astore 6
    //   65: aload 6
    //   67: ifnull -19 -> 48
    //   70: invokestatic 473	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   73: invokevirtual 475	com/tencent/smtt/utils/g:b	()Ljava/lang/String;
    //   76: astore 9
    //   78: ldc 102
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   85: invokestatic 478	com/tencent/smtt/utils/b:g	(Landroid/content/Context;)Z
    //   88: ifeq +11 -> 99
    //   91: aload_0
    //   92: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   95: invokestatic 480	com/tencent/smtt/utils/b:h	(Landroid/content/Context;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   103: invokestatic 293	com/tencent/smtt/utils/b:k	(Landroid/content/Context;)Ljava/lang/String;
    //   106: astore 4
    //   108: aload_2
    //   109: invokevirtual 308	java/lang/String:getBytes	()[B
    //   112: astore_3
    //   113: aload 4
    //   115: invokevirtual 308	java/lang/String:getBytes	()[B
    //   118: astore 4
    //   120: aload_3
    //   121: astore_2
    //   122: invokestatic 473	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   125: aload_3
    //   126: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   129: astore_3
    //   130: aload_3
    //   131: astore_2
    //   132: invokestatic 473	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   135: aload 4
    //   137: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   140: astore 5
    //   142: aload 5
    //   144: astore_2
    //   145: aload_3
    //   146: astore 4
    //   148: aload_2
    //   149: astore_3
    //   150: aload 4
    //   152: invokestatic 486	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   155: astore_2
    //   156: aload_3
    //   157: invokestatic 486	com/tencent/smtt/utils/g:b	([B)Ljava/lang/String;
    //   160: astore_3
    //   161: new 60	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   168: aload_0
    //   169: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   172: invokestatic 380	com/tencent/smtt/utils/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/n;
    //   175: invokevirtual 488	com/tencent/smtt/utils/n:h	()Ljava/lang/String;
    //   178: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_2
    //   182: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 490
    //   188: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_3
    //   192: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 10
    //   200: new 492	java/util/HashMap
    //   203: dup
    //   204: invokespecial 493	java/util/HashMap:<init>	()V
    //   207: astore 11
    //   209: aload 11
    //   211: ldc_w 495
    //   214: ldc_w 497
    //   217: invokeinterface 500 3 0
    //   222: pop
    //   223: aload 11
    //   225: ldc_w 502
    //   228: ldc 202
    //   230: invokeinterface 500 3 0
    //   235: pop
    //   236: aload 11
    //   238: ldc_w 504
    //   241: aload_0
    //   242: getfield 37	com/tencent/smtt/sdk/TbsLogReport:c	Landroid/content/Context;
    //   245: invokestatic 187	com/tencent/smtt/utils/k:a	(Landroid/content/Context;)Ljava/lang/String;
    //   248: invokeinterface 500 3 0
    //   253: pop
    //   254: new 506	java/io/File
    //   257: dup
    //   258: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   261: invokespecial 512	java/io/File:<init>	(Ljava/lang/String;)V
    //   264: pop
    //   265: new 12	com/tencent/smtt/sdk/TbsLogReport$a
    //   268: dup
    //   269: aload 6
    //   271: new 60	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   278: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   281: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 514
    //   287: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 516	com/tencent/smtt/sdk/TbsLogReport$a:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: invokevirtual 518	com/tencent/smtt/sdk/TbsLogReport$a:a	()V
    //   299: new 506	java/io/File
    //   302: dup
    //   303: getstatic 511	com/tencent/smtt/utils/FileUtil:a	Ljava/lang/String;
    //   306: ldc_w 520
    //   309: invokespecial 521	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: astore 5
    //   314: new 523	java/io/FileInputStream
    //   317: dup
    //   318: aload 5
    //   320: invokespecial 526	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   323: astore 4
    //   325: sipush 8192
    //   328: newarray byte
    //   330: astore_3
    //   331: new 528	java/io/ByteArrayOutputStream
    //   334: dup
    //   335: invokespecial 529	java/io/ByteArrayOutputStream:<init>	()V
    //   338: astore_2
    //   339: aload_2
    //   340: astore 8
    //   342: aload 5
    //   344: astore 7
    //   346: aload 4
    //   348: astore 6
    //   350: aload 4
    //   352: aload_3
    //   353: invokevirtual 533	java/io/FileInputStream:read	([B)I
    //   356: istore_1
    //   357: iload_1
    //   358: iconst_m1
    //   359: if_icmpeq +114 -> 473
    //   362: aload_2
    //   363: astore 8
    //   365: aload 5
    //   367: astore 7
    //   369: aload 4
    //   371: astore 6
    //   373: aload_2
    //   374: aload_3
    //   375: iconst_0
    //   376: iload_1
    //   377: invokevirtual 537	java/io/ByteArrayOutputStream:write	([BII)V
    //   380: goto -41 -> 339
    //   383: astore_3
    //   384: aload_2
    //   385: astore 8
    //   387: aload 5
    //   389: astore 7
    //   391: aload 4
    //   393: astore 6
    //   395: aload_3
    //   396: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   399: aload 4
    //   401: ifnull +8 -> 409
    //   404: aload 4
    //   406: invokevirtual 541	java/io/FileInputStream:close	()V
    //   409: aload_2
    //   410: ifnull +7 -> 417
    //   413: aload_2
    //   414: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   417: aload 5
    //   419: ifnull +250 -> 669
    //   422: aload 5
    //   424: invokevirtual 545	java/io/File:delete	()Z
    //   427: pop
    //   428: aconst_null
    //   429: astore_2
    //   430: new 60	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   437: aload 10
    //   439: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 547
    //   445: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 9
    //   450: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: aload 11
    //   458: aload_2
    //   459: new 549	com/tencent/smtt/sdk/TbsLogReport$2
    //   462: dup
    //   463: aload_0
    //   464: invokespecial 550	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   467: iconst_0
    //   468: invokestatic 553	com/tencent/smtt/utils/f:a	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/f$a;Z)Ljava/lang/String;
    //   471: pop
    //   472: return
    //   473: aload_2
    //   474: astore 8
    //   476: aload 5
    //   478: astore 7
    //   480: aload 4
    //   482: astore 6
    //   484: aload_2
    //   485: invokevirtual 556	java/io/ByteArrayOutputStream:flush	()V
    //   488: aload_2
    //   489: astore 8
    //   491: aload 5
    //   493: astore 7
    //   495: aload 4
    //   497: astore 6
    //   499: invokestatic 473	com/tencent/smtt/utils/g:a	()Lcom/tencent/smtt/utils/g;
    //   502: aload_2
    //   503: invokevirtual 559	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   506: invokevirtual 483	com/tencent/smtt/utils/g:a	([B)[B
    //   509: astore_3
    //   510: aload 4
    //   512: ifnull +8 -> 520
    //   515: aload 4
    //   517: invokevirtual 541	java/io/FileInputStream:close	()V
    //   520: aload_2
    //   521: ifnull +7 -> 528
    //   524: aload_2
    //   525: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   528: aload_3
    //   529: astore_2
    //   530: aload 5
    //   532: ifnull -102 -> 430
    //   535: aload 5
    //   537: invokevirtual 545	java/io/File:delete	()Z
    //   540: pop
    //   541: aload_3
    //   542: astore_2
    //   543: goto -113 -> 430
    //   546: astore_2
    //   547: aconst_null
    //   548: astore 5
    //   550: aconst_null
    //   551: astore_3
    //   552: aload_3
    //   553: ifnull +7 -> 560
    //   556: aload_3
    //   557: invokevirtual 541	java/io/FileInputStream:close	()V
    //   560: aload 8
    //   562: ifnull +8 -> 570
    //   565: aload 8
    //   567: invokevirtual 542	java/io/ByteArrayOutputStream:close	()V
    //   570: aload 5
    //   572: ifnull +9 -> 581
    //   575: aload 5
    //   577: invokevirtual 545	java/io/File:delete	()Z
    //   580: pop
    //   581: aload_2
    //   582: athrow
    //   583: astore 4
    //   585: goto -65 -> 520
    //   588: astore_2
    //   589: goto -61 -> 528
    //   592: astore_3
    //   593: goto -184 -> 409
    //   596: astore_2
    //   597: goto -180 -> 417
    //   600: astore_3
    //   601: goto -41 -> 560
    //   604: astore_3
    //   605: goto -35 -> 570
    //   608: astore_2
    //   609: aconst_null
    //   610: astore_3
    //   611: goto -59 -> 552
    //   614: astore_2
    //   615: aload 4
    //   617: astore_3
    //   618: goto -66 -> 552
    //   621: astore_2
    //   622: aload 7
    //   624: astore 5
    //   626: aload 6
    //   628: astore_3
    //   629: goto -77 -> 552
    //   632: astore_3
    //   633: aconst_null
    //   634: astore_2
    //   635: aconst_null
    //   636: astore 5
    //   638: aconst_null
    //   639: astore 4
    //   641: goto -257 -> 384
    //   644: astore_3
    //   645: aconst_null
    //   646: astore_2
    //   647: aconst_null
    //   648: astore 4
    //   650: goto -266 -> 384
    //   653: astore_3
    //   654: aconst_null
    //   655: astore_2
    //   656: goto -272 -> 384
    //   659: astore_3
    //   660: aload 4
    //   662: astore_3
    //   663: aload_2
    //   664: astore 4
    //   666: goto -516 -> 150
    //   669: aconst_null
    //   670: astore_2
    //   671: goto -241 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	TbsLogReport
    //   356	21	1	i	int
    //   80	463	2	localObject1	Object
    //   546	36	2	localObject2	Object
    //   588	1	2	localException1	Exception
    //   596	1	2	localException2	Exception
    //   608	1	2	localObject3	Object
    //   614	1	2	localObject4	Object
    //   621	1	2	localObject5	Object
    //   634	37	2	localObject6	Object
    //   112	263	3	localObject7	Object
    //   383	13	3	localException3	Exception
    //   509	48	3	arrayOfByte	byte[]
    //   592	1	3	localException4	Exception
    //   600	1	3	localException5	Exception
    //   604	1	3	localException6	Exception
    //   610	19	3	localObject8	Object
    //   632	1	3	localException7	Exception
    //   644	1	3	localException8	Exception
    //   653	1	3	localException9	Exception
    //   659	1	3	localException10	Exception
    //   662	1	3	localObject9	Object
    //   106	410	4	localObject10	Object
    //   583	33	4	localException11	Exception
    //   639	26	4	localObject11	Object
    //   140	497	5	localObject12	Object
    //   63	564	6	localObject13	Object
    //   344	279	7	localObject14	Object
    //   1	565	8	localObject15	Object
    //   76	373	9	str1	String
    //   198	240	10	str2	String
    //   207	250	11	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   350	357	383	java/lang/Exception
    //   373	380	383	java/lang/Exception
    //   484	488	383	java/lang/Exception
    //   499	510	383	java/lang/Exception
    //   254	314	546	finally
    //   515	520	583	java/lang/Exception
    //   524	528	588	java/lang/Exception
    //   404	409	592	java/lang/Exception
    //   413	417	596	java/lang/Exception
    //   556	560	600	java/lang/Exception
    //   565	570	604	java/lang/Exception
    //   314	325	608	finally
    //   325	339	614	finally
    //   350	357	621	finally
    //   373	380	621	finally
    //   395	399	621	finally
    //   484	488	621	finally
    //   499	510	621	finally
    //   254	314	632	java/lang/Exception
    //   314	325	644	java/lang/Exception
    //   325	339	653	java/lang/Exception
    //   122	130	659	java/lang/Exception
    //   132	142	659	java/lang/Exception
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    setInstallErrorCode(paramInt, paramString, EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, String paramString, EventType paramEventType)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramString);
    a(paramInt, localTbsLogInfo, paramEventType);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setFailDetail(paramThrowable);
    a(paramInt, localTbsLogInfo, EventType.TYPE_INSTALL);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    TbsLogInfo localTbsLogInfo = tbsLogInfo();
    localTbsLogInfo.setErrorCode(paramInt);
    localTbsLogInfo.setEventTime(System.currentTimeMillis());
    localTbsLogInfo.setFailDetail(paramString);
    eventReport(EventType.TYPE_LOAD, localTbsLogInfo);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
    Object localObject = "NULL";
    if (paramThrowable != null)
    {
      paramThrowable = "msg: " + paramThrowable.getMessage() + "; err: " + paramThrowable + "; cause: " + Log.getStackTraceString(paramThrowable.getCause());
      localObject = paramThrowable;
      if (paramThrowable.length() > 1024) {
        localObject = paramThrowable.substring(0, 1024);
      }
    }
    setLoadErrorCode(paramInt, (String)localObject);
  }
  
  public void setShouldUploadEventReport(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public TbsLogInfo tbsLogInfo()
  {
    return new TbsLogInfo(null);
  }
  
  public static enum EventType
  {
    int a;
    
    static
    {
      TYPE_DOWNLOAD_DECOUPLE = new EventType("TYPE_DOWNLOAD_DECOUPLE", 3, 3);
      TYPE_INSTALL_DECOUPLE = new EventType("TYPE_INSTALL_DECOUPLE", 4, 4);
    }
    
    private EventType(int paramInt)
    {
      this.a = paramInt;
    }
  }
  
  public static class TbsLogInfo
    implements Cloneable
  {
    int a;
    private long b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private int k;
    private long l;
    private long m;
    private int n;
    private String o;
    private String p;
    private long q;
    
    private TbsLogInfo()
    {
      resetArgs();
    }
    
    protected Object clone()
    {
      try
      {
        Object localObject = super.clone();
        return localObject;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return this;
    }
    
    public int getDownFinalFlag()
    {
      return this.k;
    }
    
    public void resetArgs()
    {
      this.b = 0L;
      this.c = null;
      this.d = null;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 2;
      this.i = "unknown";
      this.j = 0;
      this.k = 2;
      this.l = 0L;
      this.m = 0L;
      this.n = 1;
      this.a = 0;
      this.o = null;
      this.p = null;
      this.q = 0L;
    }
    
    public void setApn(String paramString)
    {
      this.i = paramString;
    }
    
    public void setCheckErrorDetail(String paramString)
    {
      setErrorCode(108);
      this.o = paramString;
    }
    
    public void setDownConsumeTime(long paramLong)
    {
      this.m += paramLong;
    }
    
    public void setDownFinalFlag(int paramInt)
    {
      this.k = paramInt;
    }
    
    public void setDownloadCancel(int paramInt)
    {
      this.g = paramInt;
    }
    
    public void setDownloadSize(long paramLong)
    {
      this.q += paramLong;
    }
    
    public void setDownloadUrl(String paramString)
    {
      if (this.c == null)
      {
        this.c = paramString;
        return;
      }
      this.c = (this.c + ";" + paramString);
    }
    
    public void setErrorCode(int paramInt)
    {
      if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
        TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
      }
      if (paramInt == 111) {
        TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
      }
      this.a = paramInt;
    }
    
    public void setEventTime(long paramLong)
    {
      this.b = paramLong;
    }
    
    public void setFailDetail(String paramString)
    {
      if (paramString == null) {
        return;
      }
      String str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
      this.p = str;
    }
    
    public void setFailDetail(Throwable paramThrowable)
    {
      if (paramThrowable == null)
      {
        this.p = "";
        return;
      }
      String str = Log.getStackTraceString(paramThrowable);
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
      this.p = paramThrowable;
    }
    
    public void setHttpCode(int paramInt)
    {
      this.e = paramInt;
    }
    
    public void setNetworkChange(int paramInt)
    {
      this.n = paramInt;
    }
    
    public void setNetworkType(int paramInt)
    {
      this.j = paramInt;
    }
    
    public void setPatchUpdateFlag(int paramInt)
    {
      this.f = paramInt;
    }
    
    public void setPkgSize(long paramLong)
    {
      this.l = paramLong;
    }
    
    public void setResolveIp(String paramString)
    {
      this.d = paramString;
    }
    
    public void setUnpkgFlag(int paramInt)
    {
      this.h = paramInt;
    }
  }
  
  static class a
  {
    private final String a;
    private final String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
    
    /* Error */
    private static void a(java.io.File paramFile)
      throws java.io.IOException
    {
      // Byte code:
      //   0: new 26	java/io/RandomAccessFile
      //   3: dup
      //   4: aload_0
      //   5: ldc 28
      //   7: invokespecial 31	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   10: astore_3
      //   11: aload_3
      //   12: ifnull +58 -> 70
      //   15: aload_3
      //   16: astore_0
      //   17: ldc 33
      //   19: iconst_2
      //   20: invokestatic 39	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   23: istore_1
      //   24: aload_3
      //   25: astore_0
      //   26: aload_3
      //   27: ldc2_w 40
      //   30: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
      //   33: aload_3
      //   34: astore_0
      //   35: aload_3
      //   36: invokevirtual 49	java/io/RandomAccessFile:read	()I
      //   39: istore_2
      //   40: iload_2
      //   41: iload_1
      //   42: iand
      //   43: ifle +27 -> 70
      //   46: aload_3
      //   47: astore_0
      //   48: aload_3
      //   49: ldc2_w 40
      //   52: invokevirtual 45	java/io/RandomAccessFile:seek	(J)V
      //   55: aload_3
      //   56: astore_0
      //   57: aload_3
      //   58: iload_1
      //   59: iconst_m1
      //   60: ixor
      //   61: sipush 255
      //   64: iand
      //   65: iload_2
      //   66: iand
      //   67: invokevirtual 53	java/io/RandomAccessFile:write	(I)V
      //   70: aload_3
      //   71: ifnull +7 -> 78
      //   74: aload_3
      //   75: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   78: return
      //   79: astore_0
      //   80: aload_0
      //   81: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   84: return
      //   85: astore 4
      //   87: aconst_null
      //   88: astore_3
      //   89: aload_3
      //   90: astore_0
      //   91: aload 4
      //   93: invokevirtual 60	java/lang/Exception:printStackTrace	()V
      //   96: aload_3
      //   97: ifnull -19 -> 78
      //   100: aload_3
      //   101: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   104: return
      //   105: astore_0
      //   106: aload_0
      //   107: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   110: return
      //   111: astore_3
      //   112: aconst_null
      //   113: astore_0
      //   114: aload_0
      //   115: ifnull +7 -> 122
      //   118: aload_0
      //   119: invokevirtual 56	java/io/RandomAccessFile:close	()V
      //   122: aload_3
      //   123: athrow
      //   124: astore_0
      //   125: aload_0
      //   126: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   129: goto -7 -> 122
      //   132: astore_3
      //   133: goto -19 -> 114
      //   136: astore 4
      //   138: goto -49 -> 89
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	paramFile	java.io.File
      //   23	38	1	i	int
      //   39	28	2	j	int
      //   10	91	3	localRandomAccessFile	java.io.RandomAccessFile
      //   111	12	3	localObject1	Object
      //   132	1	3	localObject2	Object
      //   85	7	4	localException1	Exception
      //   136	1	4	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   74	78	79	java/io/IOException
      //   0	11	85	java/lang/Exception
      //   100	104	105	java/io/IOException
      //   0	11	111	finally
      //   118	122	124	java/io/IOException
      //   17	24	132	finally
      //   26	33	132	finally
      //   35	40	132	finally
      //   48	55	132	finally
      //   57	70	132	finally
      //   91	96	132	finally
      //   17	24	136	java/lang/Exception
      //   26	33	136	java/lang/Exception
      //   35	40	136	java/lang/Exception
      //   48	55	136	java/lang/Exception
      //   57	70	136	java/lang/Exception
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_2
      //   5: new 63	java/io/FileOutputStream
      //   8: dup
      //   9: aload_0
      //   10: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   13: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   16: astore 4
      //   18: new 68	java/util/zip/ZipOutputStream
      //   21: dup
      //   22: new 70	java/io/BufferedOutputStream
      //   25: dup
      //   26: aload 4
      //   28: invokespecial 73	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   31: invokespecial 74	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   34: astore 6
      //   36: sipush 2048
      //   39: newarray byte
      //   41: astore 7
      //   43: aload_0
      //   44: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
      //   47: astore 8
      //   49: new 76	java/io/FileInputStream
      //   52: dup
      //   53: aload 8
      //   55: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   58: astore 5
      //   60: new 79	java/io/BufferedInputStream
      //   63: dup
      //   64: aload 5
      //   66: sipush 2048
      //   69: invokespecial 82	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   72: astore_3
      //   73: aload 6
      //   75: new 84	java/util/zip/ZipEntry
      //   78: dup
      //   79: aload 8
      //   81: aload 8
      //   83: ldc 86
      //   85: invokevirtual 92	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   88: iconst_1
      //   89: iadd
      //   90: invokevirtual 96	java/lang/String:substring	(I)Ljava/lang/String;
      //   93: invokespecial 97	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   96: invokevirtual 101	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   99: aload_3
      //   100: aload 7
      //   102: iconst_0
      //   103: sipush 2048
      //   106: invokevirtual 104	java/io/BufferedInputStream:read	([BII)I
      //   109: istore_1
      //   110: iload_1
      //   111: iconst_m1
      //   112: if_icmpeq +80 -> 192
      //   115: aload 6
      //   117: aload 7
      //   119: iconst_0
      //   120: iload_1
      //   121: invokevirtual 107	java/util/zip/ZipOutputStream:write	([BII)V
      //   124: goto -25 -> 99
      //   127: astore 7
      //   129: aload 5
      //   131: astore_2
      //   132: aload 7
      //   134: astore 5
      //   136: aload 5
      //   138: invokevirtual 60	java/lang/Exception:printStackTrace	()V
      //   141: aload_3
      //   142: ifnull +7 -> 149
      //   145: aload_3
      //   146: invokevirtual 108	java/io/BufferedInputStream:close	()V
      //   149: aload_2
      //   150: ifnull +7 -> 157
      //   153: aload_2
      //   154: invokevirtual 109	java/io/FileInputStream:close	()V
      //   157: new 111	java/io/File
      //   160: dup
      //   161: aload_0
      //   162: getfield 18	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
      //   165: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
      //   168: invokestatic 114	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
      //   171: aload 6
      //   173: ifnull +8 -> 181
      //   176: aload 6
      //   178: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
      //   181: aload 4
      //   183: ifnull +8 -> 191
      //   186: aload 4
      //   188: invokevirtual 116	java/io/FileOutputStream:close	()V
      //   191: return
      //   192: aload 6
      //   194: invokevirtual 119	java/util/zip/ZipOutputStream:flush	()V
      //   197: aload 6
      //   199: invokevirtual 122	java/util/zip/ZipOutputStream:closeEntry	()V
      //   202: aload_3
      //   203: ifnull +7 -> 210
      //   206: aload_3
      //   207: invokevirtual 108	java/io/BufferedInputStream:close	()V
      //   210: aload 5
      //   212: ifnull -55 -> 157
      //   215: aload 5
      //   217: invokevirtual 109	java/io/FileInputStream:close	()V
      //   220: goto -63 -> 157
      //   223: astore_2
      //   224: aload_2
      //   225: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   228: goto -71 -> 157
      //   231: astore_3
      //   232: aload 4
      //   234: astore_2
      //   235: aload 6
      //   237: astore 4
      //   239: aload_3
      //   240: invokevirtual 60	java/lang/Exception:printStackTrace	()V
      //   243: aload 4
      //   245: ifnull +8 -> 253
      //   248: aload 4
      //   250: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
      //   253: aload_2
      //   254: ifnull -63 -> 191
      //   257: aload_2
      //   258: invokevirtual 116	java/io/FileOutputStream:close	()V
      //   261: return
      //   262: astore_2
      //   263: aload_2
      //   264: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   267: return
      //   268: astore_2
      //   269: aload_2
      //   270: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   273: goto -63 -> 210
      //   276: astore_2
      //   277: aload 6
      //   279: astore_3
      //   280: aload_3
      //   281: ifnull +7 -> 288
      //   284: aload_3
      //   285: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
      //   288: aload 4
      //   290: ifnull +8 -> 298
      //   293: aload 4
      //   295: invokevirtual 116	java/io/FileOutputStream:close	()V
      //   298: aload_2
      //   299: athrow
      //   300: astore_3
      //   301: aload_3
      //   302: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   305: goto -156 -> 149
      //   308: astore_2
      //   309: aload_2
      //   310: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   313: goto -156 -> 157
      //   316: astore_2
      //   317: aconst_null
      //   318: astore_3
      //   319: aconst_null
      //   320: astore 5
      //   322: aload_3
      //   323: ifnull +7 -> 330
      //   326: aload_3
      //   327: invokevirtual 108	java/io/BufferedInputStream:close	()V
      //   330: aload 5
      //   332: ifnull +8 -> 340
      //   335: aload 5
      //   337: invokevirtual 109	java/io/FileInputStream:close	()V
      //   340: aload_2
      //   341: athrow
      //   342: astore_3
      //   343: aload_3
      //   344: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   347: goto -17 -> 330
      //   350: astore_3
      //   351: aload_3
      //   352: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   355: goto -15 -> 340
      //   358: astore_2
      //   359: aload_2
      //   360: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   363: goto -182 -> 181
      //   366: astore_2
      //   367: aload_2
      //   368: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   371: return
      //   372: astore_3
      //   373: aload_3
      //   374: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   377: goto -124 -> 253
      //   380: astore_3
      //   381: aload_3
      //   382: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   385: goto -97 -> 288
      //   388: astore_3
      //   389: aload_3
      //   390: invokevirtual 59	java/io/IOException:printStackTrace	()V
      //   393: goto -95 -> 298
      //   396: astore_2
      //   397: aconst_null
      //   398: astore_3
      //   399: aconst_null
      //   400: astore 4
      //   402: goto -122 -> 280
      //   405: astore_2
      //   406: aconst_null
      //   407: astore_3
      //   408: goto -128 -> 280
      //   411: astore 5
      //   413: aload 4
      //   415: astore_3
      //   416: aload_2
      //   417: astore 4
      //   419: aload 5
      //   421: astore_2
      //   422: goto -142 -> 280
      //   425: astore_3
      //   426: aconst_null
      //   427: astore_2
      //   428: aload 5
      //   430: astore 4
      //   432: goto -193 -> 239
      //   435: astore_3
      //   436: aload 4
      //   438: astore_2
      //   439: aload 5
      //   441: astore 4
      //   443: goto -204 -> 239
      //   446: astore_2
      //   447: aconst_null
      //   448: astore_3
      //   449: goto -127 -> 322
      //   452: astore_2
      //   453: goto -131 -> 322
      //   456: astore 7
      //   458: aload_2
      //   459: astore 5
      //   461: aload 7
      //   463: astore_2
      //   464: goto -142 -> 322
      //   467: astore 5
      //   469: aconst_null
      //   470: astore_3
      //   471: goto -335 -> 136
      //   474: astore 7
      //   476: aconst_null
      //   477: astore_3
      //   478: aload 5
      //   480: astore_2
      //   481: aload 7
      //   483: astore 5
      //   485: goto -349 -> 136
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	488	0	this	a
      //   109	12	1	i	int
      //   4	150	2	localObject1	Object
      //   223	2	2	localIOException1	java.io.IOException
      //   234	24	2	localObject2	Object
      //   262	2	2	localIOException2	java.io.IOException
      //   268	2	2	localIOException3	java.io.IOException
      //   276	23	2	localObject3	Object
      //   308	2	2	localIOException4	java.io.IOException
      //   316	25	2	localObject4	Object
      //   358	2	2	localIOException5	java.io.IOException
      //   366	2	2	localIOException6	java.io.IOException
      //   396	1	2	localObject5	Object
      //   405	12	2	localObject6	Object
      //   421	18	2	localObject7	Object
      //   446	1	2	localObject8	Object
      //   452	7	2	localObject9	Object
      //   463	18	2	localObject10	Object
      //   72	135	3	localBufferedInputStream	java.io.BufferedInputStream
      //   231	9	3	localException1	Exception
      //   279	6	3	localZipOutputStream1	java.util.zip.ZipOutputStream
      //   300	2	3	localIOException7	java.io.IOException
      //   318	9	3	localObject11	Object
      //   342	2	3	localIOException8	java.io.IOException
      //   350	2	3	localIOException9	java.io.IOException
      //   372	2	3	localIOException10	java.io.IOException
      //   380	2	3	localIOException11	java.io.IOException
      //   388	2	3	localIOException12	java.io.IOException
      //   398	18	3	localObject12	Object
      //   425	1	3	localException2	Exception
      //   435	1	3	localException3	Exception
      //   448	30	3	localObject13	Object
      //   16	426	4	localObject14	Object
      //   1	335	5	localObject15	Object
      //   411	29	5	localObject16	Object
      //   459	1	5	localObject17	Object
      //   467	12	5	localException4	Exception
      //   483	1	5	localObject18	Object
      //   34	244	6	localZipOutputStream2	java.util.zip.ZipOutputStream
      //   41	77	7	arrayOfByte	byte[]
      //   127	6	7	localException5	Exception
      //   456	6	7	localObject19	Object
      //   474	8	7	localException6	Exception
      //   47	35	8	str	String
      // Exception table:
      //   from	to	target	type
      //   73	99	127	java/lang/Exception
      //   99	110	127	java/lang/Exception
      //   115	124	127	java/lang/Exception
      //   192	202	127	java/lang/Exception
      //   215	220	223	java/io/IOException
      //   36	49	231	java/lang/Exception
      //   145	149	231	java/lang/Exception
      //   153	157	231	java/lang/Exception
      //   157	171	231	java/lang/Exception
      //   206	210	231	java/lang/Exception
      //   215	220	231	java/lang/Exception
      //   224	228	231	java/lang/Exception
      //   269	273	231	java/lang/Exception
      //   301	305	231	java/lang/Exception
      //   309	313	231	java/lang/Exception
      //   326	330	231	java/lang/Exception
      //   335	340	231	java/lang/Exception
      //   340	342	231	java/lang/Exception
      //   343	347	231	java/lang/Exception
      //   351	355	231	java/lang/Exception
      //   257	261	262	java/io/IOException
      //   206	210	268	java/io/IOException
      //   36	49	276	finally
      //   145	149	276	finally
      //   153	157	276	finally
      //   157	171	276	finally
      //   206	210	276	finally
      //   215	220	276	finally
      //   224	228	276	finally
      //   269	273	276	finally
      //   301	305	276	finally
      //   309	313	276	finally
      //   326	330	276	finally
      //   335	340	276	finally
      //   340	342	276	finally
      //   343	347	276	finally
      //   351	355	276	finally
      //   145	149	300	java/io/IOException
      //   153	157	308	java/io/IOException
      //   49	60	316	finally
      //   326	330	342	java/io/IOException
      //   335	340	350	java/io/IOException
      //   176	181	358	java/io/IOException
      //   186	191	366	java/io/IOException
      //   248	253	372	java/io/IOException
      //   284	288	380	java/io/IOException
      //   293	298	388	java/io/IOException
      //   5	18	396	finally
      //   18	36	405	finally
      //   239	243	411	finally
      //   5	18	425	java/lang/Exception
      //   18	36	435	java/lang/Exception
      //   60	73	446	finally
      //   73	99	452	finally
      //   99	110	452	finally
      //   115	124	452	finally
      //   192	202	452	finally
      //   136	141	456	finally
      //   49	60	467	java/lang/Exception
      //   60	73	474	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */