package com.tencent.qqmail.utilities.osslog;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Build.VERSION;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.ReportFileHandler;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.oss.KvHelper;
import moai.oss.OssClient;
import moai.oss.OssHelper;
import moai.oss.ReportType;
import moai.oss.annotation.KvReport;
import moai.oss.annotation.OssReport;

public class QMOssClient
  implements OssClient
{
  private static final String INSTANT_SUFFIX = "instant";
  private static final String KV_NOMERGE_TAG = "7856";
  private static final String KV_TAG = "7851";
  private static final String MERGE_SUFFIX = "merge";
  private static final String OS = Build.BRAND + "_" + Build.MODEL + "__" + Build.VERSION.RELEASE + "&&" + BrandUtil.getRom();
  private static final String TAG = "QMOssClient";
  private static final String TMP_SUFFIX = "tmp";
  private static final String URL = "https://oss.mail.qq.com/cgi-bin/oss_log?inputf=json&func=OssLog&inputc=utf-8&outputc=utf-8";
  private static final String USER_AGENT = "QQMail/" + VERSION + " " + System.getProperty("http.agent");
  private static final String VERSION = AppConfig.getCodeVersion();
  private static QMOssClient sInstance = new QMOssClient();
  private JSONObject mBaseInfoJson;
  private String mFilePath = LogPathManager.getInstance().getQMLogKVFilePath();
  private HashMap<String, String> mHeaders;
  private ReportFileHandler mInstantHandler = new ReportFileHandler(this.mFilePath + "_" + "instant");
  private UploadTask mInstantUploadTask = new UploadTask(true);
  private UploadTask mNextUploadTask;
  private ReportFileHandler mNormalHandler = new ReportFileHandler(this.mFilePath);
  private UploadTask mNormalUploadTask = new UploadTask(false);
  private Map<String, Object> mReportMethods;
  
  private QMNetworkRequest buildRequest(String paramString)
  {
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest("https://oss.mail.qq.com/cgi-bin/oss_log?inputf=json&func=OssLog&inputc=utf-8&outputc=utf-8", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    localQMNetworkRequest.setRequestHeaders(getRequestHeadersLocked());
    localQMNetworkRequest.setRequestData(paramString.getBytes());
    return localQMNetworkRequest;
  }
  
  private JSONObject getBaseInfoLocked()
  {
    if (this.mBaseInfoJson == null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", Integer.valueOf(1));
      localJSONObject.put("appversion", VERSION);
      localJSONObject.put("authtype", Integer.valueOf(1));
      localJSONObject.put("channelid", Integer.valueOf(0));
      localJSONObject.put("device", Build.BRAND + "_" + Build.MODEL);
      localJSONObject.put("deviceid", DeviceUtil.getDeviceInfos().DEVICE_ID);
      localJSONObject.put("imei", DeviceUtil.getDeviceInfos().IMEI);
      localJSONObject.put("os", OS);
      localJSONObject.put("platform", Integer.valueOf(1));
      this.mBaseInfoJson = localJSONObject;
    }
    this.mBaseInfoJson.put("clitime", Long.valueOf(nowSeconds()));
    this.mBaseInfoJson.put("vid", Long.valueOf(QMApplicationContext.sharedInstance().getVid()));
    return this.mBaseInfoJson;
  }
  
  public static QMOssClient getInstance()
  {
    return sInstance;
  }
  
  private Map<String, Object> getReportMethodsLocked()
  {
    int j;
    int i;
    Object localObject;
    if (this.mReportMethods == null)
    {
      this.mReportMethods = new HashMap();
      try
      {
        Method[] arrayOfMethod1 = KvHelper.class.getDeclaredMethods();
        if ((arrayOfMethod1 != null) && (arrayOfMethod1.length > 0))
        {
          j = arrayOfMethod1.length;
          i = 0;
          if (i < j)
          {
            localObject = (KvReport)arrayOfMethod1[i].getAnnotation(KvReport.class);
            if (localObject == null) {
              break label229;
            }
            this.mReportMethods.put(((KvReport)localObject).checkSum(), new KvObject(((KvReport)localObject).statKey(), ((KvReport)localObject).itemName(), true, ((KvReport)localObject).merge()));
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.log(5, "QMOssClient", "get kv/osslog annotation failed", localException);
      }
    }
    label229:
    label236:
    label241:
    for (;;)
    {
      return this.mReportMethods;
      Method[] arrayOfMethod2 = OssHelper.class.getDeclaredMethods();
      if ((arrayOfMethod2 != null) && (arrayOfMethod2.length > 0))
      {
        j = arrayOfMethod2.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label241;
          }
          localObject = (OssReport)arrayOfMethod2[i].getAnnotation(OssReport.class);
          if (localObject != null)
          {
            this.mReportMethods.put(((OssReport)localObject).checkSum(), new OssObject(((OssReport)localObject).logId(), ((OssReport)localObject).taskId(), ((OssReport)localObject).fixed()));
            break label236;
            i += 1;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  private HashMap<String, String> getRequestHeadersLocked()
  {
    HashMap localHashMap;
    if (this.mHeaders == null)
    {
      localHashMap = new HashMap();
      localHashMap.put("osver", Build.VERSION.RELEASE);
      localHashMap.put("appver", VERSION);
      if (!AppConfig.isBeta()) {
        break label113;
      }
    }
    label113:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("beta", str);
      localHashMap.put("channelId", String.valueOf(ChannelDefine.getChannelId()));
      localHashMap.put("User-Agent", USER_AGENT);
      localHashMap.put("Accept-Encoding", "deflate");
      localHashMap.put("Content-Type", "application/json; charset=UTF-8");
      this.mHeaders = localHashMap;
      return this.mHeaders;
    }
  }
  
  private boolean isValidKvItem(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != 7) {}
    while ((!"7851".equals(paramArrayOfString[0])) && (!"7856".equals(paramArrayOfString[0]))) {
      return false;
    }
    return true;
  }
  
  private boolean isValidOssItem(String[] paramArrayOfString)
  {
    return paramArrayOfString.length >= 8;
  }
  
  /* Error */
  private void mergeContentInDay(java.util.List<java.io.File> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 407 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: new 409	java/io/File
    //   17: dup
    //   18: new 62	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   25: aload_0
    //   26: getfield 136	com/tencent/qqmail/utilities/osslog/QMOssClient:mFilePath	Ljava/lang/String;
    //   29: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 76
    //   34: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokespecial 271	com/tencent/qqmail/utilities/osslog/QMOssClient:nowSeconds	()J
    //   41: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc 76
    //   46: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 28
    //   51: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 413	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 9
    //   62: aconst_null
    //   63: astore 8
    //   65: new 62	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 415
    //   72: invokespecial 416	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: astore 10
    //   77: new 418	java/io/BufferedWriter
    //   80: dup
    //   81: new 420	java/io/FileWriter
    //   84: dup
    //   85: aload 9
    //   87: invokespecial 423	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   90: invokespecial 426	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   93: astore 7
    //   95: new 296	java/util/HashMap
    //   98: dup
    //   99: invokespecial 297	java/util/HashMap:<init>	()V
    //   102: astore 11
    //   104: aload_0
    //   105: invokespecial 428	com/tencent/qqmail/utilities/osslog/QMOssClient:getReportMethodsLocked	()Ljava/util/Map;
    //   108: astore 12
    //   110: aload_1
    //   111: invokeinterface 432 1 0
    //   116: astore_1
    //   117: iconst_0
    //   118: istore 4
    //   120: iconst_0
    //   121: istore 5
    //   123: aload_1
    //   124: invokeinterface 437 1 0
    //   129: ifeq +450 -> 579
    //   132: aload_1
    //   133: invokeinterface 441 1 0
    //   138: checkcast 409	java/io/File
    //   141: astore 8
    //   143: iload 5
    //   145: iconst_1
    //   146: iadd
    //   147: istore 5
    //   149: iload 4
    //   151: i2l
    //   152: aload 8
    //   154: invokevirtual 444	java/io/File:length	()J
    //   157: ladd
    //   158: l2i
    //   159: istore 4
    //   161: iload 5
    //   163: iconst_1
    //   164: if_icmple +12 -> 176
    //   167: aload 10
    //   169: ldc_w 446
    //   172: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 10
    //   178: aload 8
    //   180: invokevirtual 449	java/io/File:getName	()Ljava/lang/String;
    //   183: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc_w 451
    //   189: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 8
    //   194: invokevirtual 444	java/io/File:length	()J
    //   197: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc_w 453
    //   203: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: new 455	java/io/BufferedReader
    //   210: dup
    //   211: new 457	java/io/FileReader
    //   214: dup
    //   215: aload 8
    //   217: invokespecial 458	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   220: invokespecial 461	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   223: astore 8
    //   225: aload 8
    //   227: invokevirtual 464	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   230: astore 13
    //   232: aload 13
    //   234: ifnull +337 -> 571
    //   237: aload 13
    //   239: ldc_w 466
    //   242: invokevirtual 470	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   245: astore 14
    //   247: aload_0
    //   248: aload 14
    //   250: invokespecial 173	com/tencent/qqmail/utilities/osslog/QMOssClient:isValidKvItem	([Ljava/lang/String;)Z
    //   253: ifeq +246 -> 499
    //   256: aload 12
    //   258: aload 14
    //   260: aload 14
    //   262: arraylength
    //   263: iconst_1
    //   264: isub
    //   265: aaload
    //   266: invokeinterface 474 2 0
    //   271: astore 15
    //   273: aload 15
    //   275: instanceof 8
    //   278: ifeq +133 -> 411
    //   281: aload 15
    //   283: checkcast 8	com/tencent/qqmail/utilities/osslog/QMOssClient$KvObject
    //   286: getfield 477	com/tencent/qqmail/utilities/osslog/QMOssClient$KvObject:merge	Z
    //   289: istore 6
    //   291: aload 14
    //   293: iconst_4
    //   294: aaload
    //   295: invokestatic 483	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   298: dstore_2
    //   299: iload 6
    //   301: ifne +9 -> 310
    //   304: dload_2
    //   305: dconst_1
    //   306: dcmpl
    //   307: ifne +177 -> 484
    //   310: aload_0
    //   311: aload 14
    //   313: aload 11
    //   315: invokespecial 487	com/tencent/qqmail/utilities/osslog/QMOssClient:transformKv	([Ljava/lang/String;Ljava/util/Map;)V
    //   318: goto -93 -> 225
    //   321: astore_1
    //   322: aload 8
    //   324: invokevirtual 490	java/io/BufferedReader:close	()V
    //   327: aload_1
    //   328: athrow
    //   329: astore 8
    //   331: aload 7
    //   333: astore_1
    //   334: aload 8
    //   336: astore 7
    //   338: iconst_5
    //   339: ldc 32
    //   341: ldc_w 492
    //   344: aload 7
    //   346: invokestatic 342	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: ldc_w 492
    //   352: iconst_0
    //   353: aload 7
    //   355: invokestatic 498	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;ZLjava/lang/Throwable;)V
    //   358: aload_1
    //   359: invokevirtual 499	java/io/BufferedWriter:close	()V
    //   362: aload 10
    //   364: ldc_w 501
    //   367: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 9
    //   372: invokevirtual 449	java/io/File:getName	()Ljava/lang/String;
    //   375: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc_w 451
    //   381: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 9
    //   386: invokevirtual 444	java/io/File:length	()J
    //   389: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: ldc_w 503
    //   395: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: iconst_4
    //   400: ldc 32
    //   402: aload 10
    //   404: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 506	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   410: return
    //   411: aload 12
    //   413: invokeinterface 510 1 0
    //   418: invokeinterface 513 1 0
    //   423: astore 15
    //   425: aload 15
    //   427: invokeinterface 437 1 0
    //   432: ifeq +528 -> 960
    //   435: aload 15
    //   437: invokeinterface 441 1 0
    //   442: astore 16
    //   444: aload 16
    //   446: instanceof 8
    //   449: ifeq -24 -> 425
    //   452: aload 16
    //   454: checkcast 8	com/tencent/qqmail/utilities/osslog/QMOssClient$KvObject
    //   457: astore 16
    //   459: aload 16
    //   461: getfield 515	com/tencent/qqmail/utilities/osslog/QMOssClient$KvObject:itemName	Ljava/lang/String;
    //   464: aload 14
    //   466: iconst_3
    //   467: aaload
    //   468: invokevirtual 402	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   471: ifeq -46 -> 425
    //   474: aload 16
    //   476: getfield 477	com/tencent/qqmail/utilities/osslog/QMOssClient$KvObject:merge	Z
    //   479: istore 6
    //   481: goto -190 -> 291
    //   484: aload 7
    //   486: aload 13
    //   488: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   491: aload 7
    //   493: invokevirtual 521	java/io/BufferedWriter:newLine	()V
    //   496: goto -271 -> 225
    //   499: aload_0
    //   500: aload 14
    //   502: invokespecial 177	com/tencent/qqmail/utilities/osslog/QMOssClient:isValidOssItem	([Ljava/lang/String;)Z
    //   505: ifeq +18 -> 523
    //   508: aload 7
    //   510: aload 13
    //   512: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   515: aload 7
    //   517: invokevirtual 521	java/io/BufferedWriter:newLine	()V
    //   520: goto -295 -> 225
    //   523: aload 13
    //   525: invokestatic 527	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifne -303 -> 225
    //   531: new 62	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 529
    //   541: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 13
    //   546: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: astore 13
    //   554: iconst_5
    //   555: ldc 32
    //   557: aload 13
    //   559: invokestatic 506	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   562: aload 13
    //   564: iconst_0
    //   565: invokestatic 532	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;Z)V
    //   568: goto -343 -> 225
    //   571: aload 8
    //   573: invokevirtual 490	java/io/BufferedReader:close	()V
    //   576: goto -453 -> 123
    //   579: aload 10
    //   581: ldc_w 534
    //   584: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: iload 4
    //   589: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 503
    //   595: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 11
    //   601: invokeinterface 541 1 0
    //   606: invokeinterface 544 1 0
    //   611: astore_1
    //   612: aload_1
    //   613: invokeinterface 437 1 0
    //   618: ifeq +232 -> 850
    //   621: aload_1
    //   622: invokeinterface 441 1 0
    //   627: checkcast 210	java/lang/String
    //   630: astore 8
    //   632: aload 11
    //   634: aload 8
    //   636: invokeinterface 474 2 0
    //   641: checkcast 479	java/lang/Double
    //   644: invokevirtual 548	java/lang/Double:doubleValue	()D
    //   647: dstore_2
    //   648: aload_0
    //   649: aload 8
    //   651: ldc_w 466
    //   654: invokevirtual 470	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   657: dload_2
    //   658: invokespecial 552	com/tencent/qqmail/utilities/osslog/QMOssClient:restoreKv	([Ljava/lang/String;D)Ljava/lang/String;
    //   661: astore 8
    //   663: dload_2
    //   664: dconst_0
    //   665: dcmpg
    //   666: ifgt +30 -> 696
    //   669: iconst_5
    //   670: ldc 32
    //   672: new 62	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 554
    //   682: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload 8
    //   687: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 506	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   696: aload 8
    //   698: invokestatic 527	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifne -89 -> 612
    //   704: aload 8
    //   706: ldc_w 466
    //   709: invokevirtual 470	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   712: astore 12
    //   714: aload 12
    //   716: iconst_4
    //   717: aaload
    //   718: invokestatic 483	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   721: dstore_2
    //   722: dload_2
    //   723: dload_2
    //   724: d2i
    //   725: i2d
    //   726: dsub
    //   727: dconst_0
    //   728: dcmpl
    //   729: ifne +106 -> 835
    //   732: dload_2
    //   733: ldc2_w 555
    //   736: dcmpg
    //   737: ifge +98 -> 835
    //   740: aload 12
    //   742: iconst_0
    //   743: ldc 22
    //   745: aastore
    //   746: aload 12
    //   748: iconst_4
    //   749: dload_2
    //   750: d2i
    //   751: invokestatic 385	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   754: aastore
    //   755: aload 7
    //   757: ldc_w 466
    //   760: invokestatic 562	com/tencent/qqmail/trd/guava/Joiner:on	(Ljava/lang/String;)Lcom/tencent/qqmail/trd/guava/Joiner;
    //   763: aload 12
    //   765: invokevirtual 566	com/tencent/qqmail/trd/guava/Joiner:join	([Ljava/lang/Object;)Ljava/lang/String;
    //   768: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   771: aload 7
    //   773: invokevirtual 521	java/io/BufferedWriter:newLine	()V
    //   776: goto -164 -> 612
    //   779: astore_1
    //   780: aload 7
    //   782: invokevirtual 499	java/io/BufferedWriter:close	()V
    //   785: aload 10
    //   787: ldc_w 501
    //   790: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 9
    //   795: invokevirtual 449	java/io/File:getName	()Ljava/lang/String;
    //   798: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: ldc_w 451
    //   804: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: aload 9
    //   809: invokevirtual 444	java/io/File:length	()J
    //   812: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   815: ldc_w 503
    //   818: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: iconst_4
    //   823: ldc 32
    //   825: aload 10
    //   827: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokestatic 506	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   833: aload_1
    //   834: athrow
    //   835: aload 7
    //   837: aload 8
    //   839: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   842: aload 7
    //   844: invokevirtual 521	java/io/BufferedWriter:newLine	()V
    //   847: goto -235 -> 612
    //   850: aload 7
    //   852: invokevirtual 499	java/io/BufferedWriter:close	()V
    //   855: aload 10
    //   857: ldc_w 501
    //   860: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 9
    //   865: invokevirtual 449	java/io/File:getName	()Ljava/lang/String;
    //   868: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc_w 451
    //   874: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: aload 9
    //   879: invokevirtual 444	java/io/File:length	()J
    //   882: invokevirtual 412	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   885: ldc_w 503
    //   888: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: iconst_4
    //   893: ldc 32
    //   895: aload 10
    //   897: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: invokestatic 506	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   903: return
    //   904: astore 8
    //   906: goto -330 -> 576
    //   909: astore 8
    //   911: goto -584 -> 327
    //   914: astore_1
    //   915: goto -60 -> 855
    //   918: astore_1
    //   919: goto -557 -> 362
    //   922: astore 7
    //   924: goto -139 -> 785
    //   927: astore_1
    //   928: aconst_null
    //   929: astore 7
    //   931: goto -151 -> 780
    //   934: astore 8
    //   936: aload_1
    //   937: astore 7
    //   939: aload 8
    //   941: astore_1
    //   942: goto -162 -> 780
    //   945: astore 7
    //   947: aload 8
    //   949: astore_1
    //   950: goto -612 -> 338
    //   953: astore_1
    //   954: aconst_null
    //   955: astore 8
    //   957: goto -635 -> 322
    //   960: iconst_1
    //   961: istore 6
    //   963: goto -672 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	966	0	this	QMOssClient
    //   0	966	1	paramList	java.util.List<java.io.File>
    //   298	452	2	d	double
    //   118	470	4	i	int
    //   121	44	5	j	int
    //   289	673	6	bool	boolean
    //   93	758	7	localObject1	Object
    //   922	1	7	localException1	Exception
    //   929	9	7	localList	java.util.List<java.io.File>
    //   945	1	7	localException2	Exception
    //   63	260	8	localObject2	Object
    //   329	243	8	localException3	Exception
    //   630	208	8	str1	String
    //   904	1	8	localException4	Exception
    //   909	1	8	localException5	Exception
    //   934	14	8	localObject3	Object
    //   955	1	8	localObject4	Object
    //   60	818	9	localFile	java.io.File
    //   75	821	10	localStringBuilder	java.lang.StringBuilder
    //   102	531	11	localHashMap	HashMap
    //   108	656	12	localObject5	Object
    //   230	333	13	str2	String
    //   245	256	14	arrayOfString	String[]
    //   271	165	15	localObject6	Object
    //   442	33	16	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   225	232	321	finally
    //   237	291	321	finally
    //   291	299	321	finally
    //   310	318	321	finally
    //   411	425	321	finally
    //   425	481	321	finally
    //   484	496	321	finally
    //   499	520	321	finally
    //   523	568	321	finally
    //   95	117	329	java/lang/Exception
    //   123	143	329	java/lang/Exception
    //   149	161	329	java/lang/Exception
    //   167	176	329	java/lang/Exception
    //   176	207	329	java/lang/Exception
    //   327	329	329	java/lang/Exception
    //   579	612	329	java/lang/Exception
    //   612	663	329	java/lang/Exception
    //   669	696	329	java/lang/Exception
    //   696	722	329	java/lang/Exception
    //   746	776	329	java/lang/Exception
    //   835	847	329	java/lang/Exception
    //   95	117	779	finally
    //   123	143	779	finally
    //   149	161	779	finally
    //   167	176	779	finally
    //   176	207	779	finally
    //   322	327	779	finally
    //   327	329	779	finally
    //   571	576	779	finally
    //   579	612	779	finally
    //   612	663	779	finally
    //   669	696	779	finally
    //   696	722	779	finally
    //   746	776	779	finally
    //   835	847	779	finally
    //   571	576	904	java/lang/Exception
    //   322	327	909	java/lang/Exception
    //   850	855	914	java/lang/Exception
    //   358	362	918	java/lang/Exception
    //   780	785	922	java/lang/Exception
    //   77	95	927	finally
    //   338	358	934	finally
    //   77	95	945	java/lang/Exception
    //   207	225	953	finally
  }
  
  private long nowSeconds()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  private void report(String paramString, ReportType paramReportType)
  {
    int i = 1;
    boolean bool1;
    boolean bool2;
    if (paramReportType != ReportType.NORMAL)
    {
      bool1 = true;
      if (paramReportType == ReportType.NORMAL) {
        break label52;
      }
      bool2 = true;
      label22:
      if (paramReportType != ReportType.IMMEDIATELY_UPLOAD) {
        break label58;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label63;
      }
      this.mNormalHandler.log(paramString, bool1, bool2);
      return;
      bool1 = false;
      break;
      label52:
      bool2 = false;
      break label22;
      label58:
      i = 0;
    }
    label63:
    this.mInstantHandler.log(paramString, bool1, bool2);
    submitInstant();
  }
  
  private String restoreKv(String[] paramArrayOfString, double paramDouble)
  {
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    String str3 = paramArrayOfString[2];
    String str4 = paramArrayOfString[3];
    String str5 = paramArrayOfString[4];
    String str6 = paramArrayOfString[5];
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(6, Integer.parseInt(str2));
      localCalendar.set(11, 12);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      str1 = str1 + "," + localCalendar.getTimeInMillis() / 1000L + "," + str3 + "," + str4 + "," + paramDouble + "," + str5 + "," + str6;
      return str1;
    }
    catch (Exception localException)
    {
      paramArrayOfString = "restore kv failed: " + Arrays.toString(paramArrayOfString);
      QMLog.log(5, "QMOssClient", paramArrayOfString, localException);
      ValidateHelper.assertInDebug(paramArrayOfString, false, localException);
    }
    return null;
  }
  
  private void submitInstant()
  {
    if (!Threads.hasCallbackInBackground(this.mNormalUploadTask)) {
      Threads.replaceCallbackInBackground(this.mInstantUploadTask, 100L);
    }
  }
  
  private void transformKv(String[] paramArrayOfString, Map<String, Double> paramMap)
  {
    String str2 = paramArrayOfString[0];
    String str3 = paramArrayOfString[1];
    String str4 = paramArrayOfString[2];
    String str5 = paramArrayOfString[3];
    String str1 = paramArrayOfString[4];
    String str6 = paramArrayOfString[5];
    String str7 = paramArrayOfString[6];
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(Long.parseLong(str3) * 1000L);
      str2 = str2 + "," + localCalendar.get(6) + "," + str4 + "," + str5 + "," + str6 + "," + str7;
      double d = Double.parseDouble(str1);
      str1 = "value is less than 0: " + d;
      boolean bool;
      if (d >= 0.0D)
      {
        bool = true;
        ValidateHelper.assertInDebug(str1, bool);
        if (!paramMap.containsKey(str2)) {
          break label236;
        }
        d = ((Double)paramMap.get(str2)).doubleValue() + d;
      }
      label236:
      for (;;)
      {
        paramMap.put(str2, Double.valueOf(Math.round(d * 100.0D) / 100.0D));
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (Exception paramMap)
    {
      paramArrayOfString = "trasform kv failed: " + Arrays.toString(paramArrayOfString);
      QMLog.log(5, "QMOssClient", paramArrayOfString, paramMap);
      ValidateHelper.assertInDebug(paramArrayOfString, false, paramMap);
    }
  }
  
  public void flush()
  {
    this.mNormalHandler.flush();
    this.mInstantHandler.flush();
  }
  
  public void hideSubmitLogNotification()
  {
    ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).cancel(10086);
  }
  
  public void log(String paramString) {}
  
  public void reportKv(int paramInt, String paramString1, double paramDouble, ReportType paramReportType, String paramString2)
  {
    boolean bool2 = Pattern.compile("[A-Za-z0-9_|$-]+").matcher(paramString1).matches();
    String str = "invalid itemName: " + paramString1;
    if ((bool2) && (paramString1.length() < 64)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ValidateHelper.assertInDebug(str, bool1);
      str = paramString1;
      if (!bool2) {
        str = Pattern.compile("[^A-Za-z0-9_|$-]+").matcher(paramString1).replaceAll("_");
      }
      report("7851," + nowSeconds() + "," + paramInt + "," + str + "," + paramDouble + "," + QMApplicationContext.sharedInstance().getVid() + "," + paramString2, paramReportType);
      return;
    }
  }
  
  public void reportOss(int paramInt, ReportType paramReportType, String paramString1, String paramString2)
  {
    report(String.valueOf(paramInt) + "," + nowSeconds() + "," + QMApplicationContext.sharedInstance().getVid() + "," + 1 + "," + OS + "," + VERSION + "," + paramString1 + "," + paramString2, paramReportType);
  }
  
  public void reportXMailIdKey(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void reportXMailLog(int paramInt1, int paramInt2, String paramString1, ReportType paramReportType, String paramString2) {}
  
  public void showSubmitLogNotification()
  {
    Notification localNotification = new Notification.Builder(QMApplicationContext.sharedInstance()).setContentTitle(QMApplicationContext.sharedInstance().getString(2131719737)).setContentText(QMApplicationContext.sharedInstance().getString(2131719736)).setOngoing(true).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setLargeIcon(BitmapFactory.decodeResource(QMApplicationContext.sharedInstance().getResources(), 2130840992)).setPriority(-2).build();
    ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).notify(10086, localNotification);
  }
  
  public void submit()
  {
    Threads.removeCallbackInBackground(this.mInstantUploadTask);
    Threads.replaceCallbackInBackground(this.mNormalUploadTask, 100L);
  }
  
  public void updatePath()
  {
    String str = this.mFilePath;
    if (this.mNormalHandler != null) {
      this.mNormalHandler.close();
    }
    this.mFilePath = LogPathManager.getInstance().getQMLogKVFilePath();
    this.mNormalHandler = new ReportFileHandler(this.mFilePath);
    QMLog.log(4, "QMOssClient", "update kv path, new path: " + this.mFilePath + ", old path: " + str);
  }
  
  class KvObject
  {
    boolean fixed;
    String itemName;
    boolean merge;
    int statKey;
    
    KvObject(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.statKey = paramInt;
      this.itemName = paramString;
      this.fixed = paramBoolean1;
      this.merge = paramBoolean2;
    }
  }
  
  class OssObject
  {
    boolean fixed;
    int logId;
    String taskId;
    
    OssObject(int paramInt, String paramString, boolean paramBoolean)
    {
      this.logId = paramInt;
      this.taskId = paramString;
      this.fixed = paramBoolean;
    }
  }
  
  class UploadTask
    implements Runnable
  {
    boolean instant;
    
    UploadTask(boolean paramBoolean)
    {
      this.instant = paramBoolean;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   4: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   7: invokevirtual 36	com/tencent/qqmail/utilities/log/ReportFileHandler:acquireUpload	()Z
      //   10: ifne +36 -> 46
      //   13: aload_0
      //   14: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   17: invokestatic 40	com/tencent/qqmail/utilities/osslog/QMOssClient:access$100	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;
      //   20: ifnull +16 -> 36
      //   23: aload_0
      //   24: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   27: invokestatic 40	com/tencent/qqmail/utilities/osslog/QMOssClient:access$100	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;
      //   30: getfield 22	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:instant	Z
      //   33: ifeq +12 -> 45
      //   36: aload_0
      //   37: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   40: aload_0
      //   41: invokestatic 44	com/tencent/qqmail/utilities/osslog/QMOssClient:access$102	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;)Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;
      //   44: pop
      //   45: return
      //   46: invokestatic 50	android/os/SystemClock:elapsedRealtime	()J
      //   49: lstore_1
      //   50: iconst_4
      //   51: ldc 52
      //   53: new 54	java/lang/StringBuilder
      //   56: dup
      //   57: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   60: ldc 57
      //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   65: aload_0
      //   66: getfield 22	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:instant	Z
      //   69: invokevirtual 64	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   72: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   75: invokestatic 74	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   78: aload_0
      //   79: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   82: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   85: invokevirtual 77	com/tencent/qqmail/utilities/log/ReportFileHandler:flush	()V
      //   88: aload_0
      //   89: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   92: invokestatic 80	com/tencent/qqmail/utilities/osslog/QMOssClient:access$200	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   95: ldc 82
      //   97: invokevirtual 86	com/tencent/qqmail/utilities/log/ReportFileHandler:rename	(Ljava/lang/String;)V
      //   100: aload_0
      //   101: getfield 22	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:instant	Z
      //   104: ifne +15 -> 119
      //   107: aload_0
      //   108: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   111: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   114: ldc 82
      //   116: invokevirtual 86	com/tencent/qqmail/utilities/log/ReportFileHandler:rename	(Ljava/lang/String;)V
      //   119: aload_0
      //   120: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   123: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   126: iconst_2
      //   127: anewarray 88	java/lang/String
      //   130: dup
      //   131: iconst_0
      //   132: ldc 90
      //   134: aastore
      //   135: dup
      //   136: iconst_1
      //   137: ldc 82
      //   139: aastore
      //   140: invokevirtual 94	com/tencent/qqmail/utilities/log/ReportFileHandler:getFileListBySuffixes	([Ljava/lang/String;)Ljava/util/List;
      //   143: astore 7
      //   145: aload 7
      //   147: invokeinterface 100 1 0
      //   152: ifne +14 -> 166
      //   155: aload_0
      //   156: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   159: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   162: invokevirtual 103	com/tencent/qqmail/utilities/log/ReportFileHandler:finishUpload	()V
      //   165: return
      //   166: aload_0
      //   167: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   170: aload 7
      //   172: invokestatic 107	com/tencent/qqmail/utilities/osslog/QMOssClient:access$300	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;Ljava/util/List;)V
      //   175: aload 7
      //   177: invokestatic 111	com/tencent/qqmail/utilities/log/ReportFileHandler:deleteFiles	(Ljava/util/List;)V
      //   180: aload_0
      //   181: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   184: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   187: iconst_1
      //   188: anewarray 88	java/lang/String
      //   191: dup
      //   192: iconst_0
      //   193: ldc 90
      //   195: aastore
      //   196: invokevirtual 94	com/tencent/qqmail/utilities/log/ReportFileHandler:getFileListBySuffixes	([Ljava/lang/String;)Ljava/util/List;
      //   199: astore 9
      //   201: aload 9
      //   203: invokeinterface 100 1 0
      //   208: ifne +14 -> 222
      //   211: aload_0
      //   212: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   215: invokestatic 30	com/tencent/qqmail/utilities/osslog/QMOssClient:access$000	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/tencent/qqmail/utilities/log/ReportFileHandler;
      //   218: invokevirtual 103	com/tencent/qqmail/utilities/log/ReportFileHandler:finishUpload	()V
      //   221: return
      //   222: new 54	java/lang/StringBuilder
      //   225: dup
      //   226: sipush 1024
      //   229: invokespecial 114	java/lang/StringBuilder:<init>	(I)V
      //   232: astore 10
      //   234: aload 9
      //   236: invokeinterface 118 1 0
      //   241: astore 11
      //   243: aconst_null
      //   244: astore 8
      //   246: aload 11
      //   248: invokeinterface 123 1 0
      //   253: ifeq +224 -> 477
      //   256: aload 11
      //   258: invokeinterface 127 1 0
      //   263: checkcast 129	java/io/File
      //   266: astore 7
      //   268: new 131	java/io/BufferedReader
      //   271: dup
      //   272: new 133	java/io/FileReader
      //   275: dup
      //   276: aload 7
      //   278: invokespecial 136	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   281: invokespecial 139	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   284: astore 7
      //   286: aload 7
      //   288: invokevirtual 142	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   291: astore 8
      //   293: aload 8
      //   295: ifnull +164 -> 459
      //   298: aload 8
      //   300: ldc 144
      //   302: invokevirtual 148	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   305: astore 12
      //   307: aload_0
      //   308: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   311: aload 12
      //   313: invokestatic 152	com/tencent/qqmail/utilities/osslog/QMOssClient:access$400	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;[Ljava/lang/String;)Z
      //   316: ifne +15 -> 331
      //   319: aload_0
      //   320: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   323: aload 12
      //   325: invokestatic 155	com/tencent/qqmail/utilities/osslog/QMOssClient:access$500	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;[Ljava/lang/String;)Z
      //   328: ifeq +61 -> 389
      //   331: aload 10
      //   333: aload 8
      //   335: iconst_0
      //   336: aload 8
      //   338: ldc 144
      //   340: invokevirtual 159	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   343: invokevirtual 163	java/lang/String:substring	(II)Ljava/lang/String;
      //   346: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   349: ldc 165
      //   351: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   354: pop
      //   355: goto -69 -> 286
      //   358: astore 8
      //   360: aload 7
      //   362: astore 8
      //   364: aload 8
      //   366: astore 7
      //   368: aload 8
      //   370: ifnull +12 -> 382
      //   373: aload 8
      //   375: invokevirtual 168	java/io/BufferedReader:close	()V
      //   378: aload 8
      //   380: astore 7
      //   382: aload 7
      //   384: astore 8
      //   386: goto -140 -> 246
      //   389: aload 8
      //   391: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   394: ifne -108 -> 286
      //   397: new 54	java/lang/StringBuilder
      //   400: dup
      //   401: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   404: ldc 176
      //   406: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   409: aload 8
      //   411: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   414: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   417: astore 8
      //   419: iconst_5
      //   420: ldc 52
      //   422: aload 8
      //   424: invokestatic 74	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   427: aload 8
      //   429: iconst_0
      //   430: invokestatic 182	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;Z)V
      //   433: goto -147 -> 286
      //   436: astore 9
      //   438: aload 7
      //   440: astore 8
      //   442: aload 9
      //   444: astore 7
      //   446: aload 8
      //   448: ifnull +8 -> 456
      //   451: aload 8
      //   453: invokevirtual 168	java/io/BufferedReader:close	()V
      //   456: aload 7
      //   458: athrow
      //   459: aload 7
      //   461: ifnull +8 -> 469
      //   464: aload 7
      //   466: invokevirtual 168	java/io/BufferedReader:close	()V
      //   469: goto -87 -> 382
      //   472: astore 8
      //   474: goto -92 -> 382
      //   477: invokestatic 50	android/os/SystemClock:elapsedRealtime	()J
      //   480: lstore_3
      //   481: new 184	com/alibaba/fastjson/JSONObject
      //   484: dup
      //   485: invokespecial 185	com/alibaba/fastjson/JSONObject:<init>	()V
      //   488: astore 7
      //   490: aload 7
      //   492: ldc 187
      //   494: aload_0
      //   495: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   498: invokestatic 191	com/tencent/qqmail/utilities/osslog/QMOssClient:access$600	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;)Lcom/alibaba/fastjson/JSONObject;
      //   501: invokevirtual 195	com/alibaba/fastjson/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   504: pop
      //   505: aload 7
      //   507: ldc 197
      //   509: aload 10
      //   511: invokevirtual 200	java/lang/StringBuilder:length	()I
      //   514: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   517: invokevirtual 195	com/alibaba/fastjson/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   520: pop
      //   521: aload 7
      //   523: ldc 208
      //   525: aload 10
      //   527: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   530: invokevirtual 195	com/alibaba/fastjson/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   533: pop
      //   534: iconst_2
      //   535: ldc 52
      //   537: new 54	java/lang/StringBuilder
      //   540: dup
      //   541: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   544: ldc 210
      //   546: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   549: aload 10
      //   551: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   554: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   557: invokestatic 74	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   560: invokestatic 50	android/os/SystemClock:elapsedRealtime	()J
      //   563: lstore 5
      //   565: aload_0
      //   566: getfield 17	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask:this$0	Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
      //   569: aload 7
      //   571: invokevirtual 216	com/alibaba/fastjson/JSONObject:toJSONString	()Ljava/lang/String;
      //   574: invokestatic 220	com/tencent/qqmail/utilities/osslog/QMOssClient:access$700	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient;Ljava/lang/String;)Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;
      //   577: invokestatic 226	rx/Observable:just	(Ljava/lang/Object;)Lrx/Observable;
      //   580: invokestatic 232	com/tencent/qqmail/utilities/thread/QMSchedulers:network	()Lrx/Scheduler;
      //   583: invokevirtual 236	rx/Observable:observeOn	(Lrx/Scheduler;)Lrx/Observable;
      //   586: new 238	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$4
      //   589: dup
      //   590: aload_0
      //   591: invokespecial 241	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$4:<init>	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;)V
      //   594: invokevirtual 245	rx/Observable:flatMap	(Lrx/functions/Func1;)Lrx/Observable;
      //   597: new 247	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$3
      //   600: dup
      //   601: aload_0
      //   602: invokespecial 248	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$3:<init>	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;)V
      //   605: invokevirtual 251	rx/Observable:onErrorReturn	(Lrx/functions/Func1;)Lrx/Observable;
      //   608: invokestatic 254	com/tencent/qqmail/utilities/thread/QMSchedulers:io	()Lrx/Scheduler;
      //   611: invokevirtual 236	rx/Observable:observeOn	(Lrx/Scheduler;)Lrx/Observable;
      //   614: new 256	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$2
      //   617: dup
      //   618: aload_0
      //   619: invokespecial 257	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$2:<init>	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;)V
      //   622: invokevirtual 260	rx/Observable:map	(Lrx/functions/Func1;)Lrx/Observable;
      //   625: new 262	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$1
      //   628: dup
      //   629: aload_0
      //   630: aload 9
      //   632: lload_3
      //   633: lload_1
      //   634: lsub
      //   635: lload 5
      //   637: lload_1
      //   638: invokespecial 265	com/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask$1:<init>	(Lcom/tencent/qqmail/utilities/osslog/QMOssClient$UploadTask;Ljava/util/List;JJJ)V
      //   641: invokevirtual 260	rx/Observable:map	(Lrx/functions/Func1;)Lrx/Observable;
      //   644: invokevirtual 269	rx/Observable:subscribe	()Lrx/Subscription;
      //   647: pop
      //   648: return
      //   649: astore 7
      //   651: aload 8
      //   653: astore 7
      //   655: goto -273 -> 382
      //   658: astore 8
      //   660: goto -204 -> 456
      //   663: astore 7
      //   665: goto -219 -> 446
      //   668: astore 7
      //   670: goto -306 -> 364
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	673	0	this	UploadTask
      //   49	589	1	l1	long
      //   480	153	3	l2	long
      //   563	73	5	l3	long
      //   143	427	7	localObject1	Object
      //   649	1	7	localIOException1	java.io.IOException
      //   653	1	7	localObject2	Object
      //   663	1	7	localObject3	Object
      //   668	1	7	localIOException2	java.io.IOException
      //   244	93	8	str	String
      //   358	1	8	localIOException3	java.io.IOException
      //   362	90	8	localObject4	Object
      //   472	180	8	localIOException4	java.io.IOException
      //   658	1	8	localIOException5	java.io.IOException
      //   199	36	9	localList1	java.util.List
      //   436	195	9	localList2	java.util.List
      //   232	318	10	localStringBuilder	java.lang.StringBuilder
      //   241	16	11	localIterator	java.util.Iterator
      //   305	19	12	arrayOfString	String[]
      // Exception table:
      //   from	to	target	type
      //   286	293	358	java/io/IOException
      //   298	331	358	java/io/IOException
      //   331	355	358	java/io/IOException
      //   389	433	358	java/io/IOException
      //   286	293	436	finally
      //   298	331	436	finally
      //   331	355	436	finally
      //   389	433	436	finally
      //   464	469	472	java/io/IOException
      //   373	378	649	java/io/IOException
      //   451	456	658	java/io/IOException
      //   268	286	663	finally
      //   268	286	668	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.QMOssClient
 * JD-Core Version:    0.7.0.1
 */