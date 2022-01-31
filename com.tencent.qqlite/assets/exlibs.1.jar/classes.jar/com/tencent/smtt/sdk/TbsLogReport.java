package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.SysCoreQua2Utils;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

class TbsLogReport
{
  private static final String KEY_TBSDOWNLOAD_UPLOAD = "tbs_download_upload";
  protected static final String LOGTAG = "upload";
  static final int MAX_CALLSTACK_LENGTH = 1024;
  private static final String TBSAPK_DOWNLOAD_STAT_FILENAME = "tbs_download_stat";
  private static TbsLogReport mInstance;
  private String mApn;
  private String mCheckErrorDetail;
  private Context mContext;
  private long mDownConsumeTime;
  private int mDownFinalFlag;
  private String mDownUrl;
  private int mDownloadCancel;
  private long mDownloadSize;
  int mErrorCode;
  private long mEventTime;
  private String mFailDetail;
  private int mHttpCode;
  private int mNetworkChange;
  private int mNetworkType;
  private int mPatchUpdateFlag;
  private long mPkgSize;
  private String mResolveIp;
  private int mUnpkgFlag;
  
  private TbsLogReport(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    resetArgs();
  }
  
  private String addData(int paramInt)
  {
    return paramInt + "|";
  }
  
  private String addData(long paramLong)
  {
    return paramLong + "|";
  }
  
  private String addData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str + "|";
  }
  
  private void clearUploadData()
  {
    SharedPreferences.Editor localEditor = sharedPreferences().edit();
    localEditor.remove("tbs_download_upload");
    localEditor.commit();
  }
  
  private String formatTime(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String getImei()
  {
    try
    {
      String str = ((TelephonyManager)this.mContext.getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static TbsLogReport getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsLogReport(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private JSONArray getUploadData()
  {
    Object localObject = sharedPreferences().getString("tbs_download_upload", null);
    if (localObject == null) {
      return new JSONArray();
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      return localObject;
    }
    catch (Exception localException) {}
    return new JSONArray();
  }
  
  private void resetArgs()
  {
    this.mEventTime = 0L;
    this.mDownUrl = null;
    this.mResolveIp = null;
    this.mHttpCode = 0;
    this.mPatchUpdateFlag = 0;
    this.mDownloadCancel = 0;
    this.mUnpkgFlag = 2;
    this.mApn = "unknown";
    this.mNetworkType = 0;
    this.mDownFinalFlag = 2;
    this.mPkgSize = 0L;
    this.mDownConsumeTime = 0L;
    this.mNetworkChange = 1;
    this.mErrorCode = 0;
    this.mCheckErrorDetail = null;
    this.mFailDetail = null;
    this.mDownloadSize = 0L;
  }
  
  private SharedPreferences sharedPreferences()
  {
    return this.mContext.getSharedPreferences("tbs_download_stat", 4);
  }
  
  public void clear()
  {
    try
    {
      resetArgs();
      SharedPreferences.Editor localEditor = sharedPreferences().edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public int getDownFinalFlag()
  {
    return this.mDownFinalFlag;
  }
  
  public void reportDownloadStat()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] Run in UIThread, Report delay");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
    Object localObject = getUploadData();
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
      return;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + localObject);
    try
    {
      localObject = HttpUtil.postData(TbsCommonConfig.getInstance(this.mContext).getTbsDownloadStatPostUrl(), ((JSONArray)localObject).toString().getBytes("utf-8"), new HttpUtil.HttpResponseListener()
      {
        public void onHttpResponseCode(int paramAnonymousInt)
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + paramAnonymousInt);
          if (paramAnonymousInt < 300) {
            TbsLogReport.this.clearUploadData();
          }
        }
      }, true);
      TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + (String)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  /* Error */
  public void reportTbsLog()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   4: invokestatic 291	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   7: iconst_3
    //   8: if_icmpeq +4 -> 12
    //   11: return
    //   12: invokestatic 294	com/tencent/smtt/utils/TbsLog:getTbsLogFilePath	()Ljava/lang/String;
    //   15: astore 17
    //   17: aload 17
    //   19: ifnull -8 -> 11
    //   22: invokestatic 299	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   25: invokevirtual 302	com/tencent/smtt/utils/Post3DESEncryption:getRSAKeyValue	()Ljava/lang/String;
    //   28: astore 14
    //   30: aload_0
    //   31: invokespecial 304	com/tencent/smtt/sdk/TbsLogReport:getImei	()Ljava/lang/String;
    //   34: invokevirtual 307	java/lang/String:getBytes	()[B
    //   37: astore_2
    //   38: invokestatic 299	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   41: aload_2
    //   42: invokevirtual 311	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokestatic 315	com/tencent/smtt/utils/Post3DESEncryption:bytesToHex	([B)Ljava/lang/String;
    //   52: astore_2
    //   53: new 77	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   64: invokestatic 259	com/tencent/smtt/utils/TbsCommonConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/utils/TbsCommonConfig;
    //   67: invokevirtual 318	com/tencent/smtt/utils/TbsCommonConfig:getTbsLogPostUrl	()Ljava/lang/String;
    //   70: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_2
    //   74: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 15
    //   82: new 320	java/util/HashMap
    //   85: dup
    //   86: invokespecial 321	java/util/HashMap:<init>	()V
    //   89: astore 16
    //   91: aload 16
    //   93: ldc_w 323
    //   96: ldc_w 325
    //   99: invokeinterface 331 3 0
    //   104: pop
    //   105: aload 16
    //   107: ldc_w 333
    //   110: ldc_w 335
    //   113: invokeinterface 331 3 0
    //   118: pop
    //   119: aload 16
    //   121: ldc_w 337
    //   124: aload_0
    //   125: getfield 64	com/tencent/smtt/sdk/TbsLogReport:mContext	Landroid/content/Context;
    //   128: invokestatic 343	com/tencent/smtt/utils/SysCoreQua2Utils:getQUA2	(Landroid/content/Context;)Ljava/lang/String;
    //   131: invokeinterface 331 3 0
    //   136: pop
    //   137: aconst_null
    //   138: astore_2
    //   139: aconst_null
    //   140: astore 12
    //   142: aconst_null
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: aconst_null
    //   148: astore 11
    //   150: aconst_null
    //   151: astore 13
    //   153: aconst_null
    //   154: astore 10
    //   156: aconst_null
    //   157: astore 8
    //   159: aconst_null
    //   160: astore 9
    //   162: aload 13
    //   164: astore 5
    //   166: aload_2
    //   167: astore 6
    //   169: aload_3
    //   170: astore 7
    //   172: new 345	java/io/File
    //   175: dup
    //   176: getstatic 350	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   179: invokespecial 351	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: pop
    //   183: aload 13
    //   185: astore 5
    //   187: aload_2
    //   188: astore 6
    //   190: aload_3
    //   191: astore 7
    //   193: new 15	com/tencent/smtt/sdk/TbsLogReport$ZipHelper
    //   196: dup
    //   197: aload 17
    //   199: new 77	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   206: getstatic 350	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   209: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 353
    //   215: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokespecial 355	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: invokevirtual 358	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:Zip	()V
    //   227: aload 13
    //   229: astore 5
    //   231: aload_2
    //   232: astore 6
    //   234: aload_3
    //   235: astore 7
    //   237: new 345	java/io/File
    //   240: dup
    //   241: getstatic 350	com/tencent/smtt/utils/FileUtil:TBSLOG_PATH	Ljava/lang/String;
    //   244: ldc_w 360
    //   247: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: astore_2
    //   251: new 363	java/io/FileInputStream
    //   254: dup
    //   255: aload_2
    //   256: invokespecial 366	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   259: astore_3
    //   260: sipush 8192
    //   263: newarray byte
    //   265: astore 5
    //   267: new 368	java/io/ByteArrayOutputStream
    //   270: dup
    //   271: invokespecial 369	java/io/ByteArrayOutputStream:<init>	()V
    //   274: astore 4
    //   276: aload_3
    //   277: aload 5
    //   279: invokevirtual 373	java/io/FileInputStream:read	([B)I
    //   282: istore_1
    //   283: iload_1
    //   284: iconst_m1
    //   285: if_icmpeq +123 -> 408
    //   288: aload 4
    //   290: aload 5
    //   292: iconst_0
    //   293: iload_1
    //   294: invokevirtual 377	java/io/ByteArrayOutputStream:write	([BII)V
    //   297: goto -21 -> 276
    //   300: astore 5
    //   302: aload 4
    //   304: astore 8
    //   306: aload_3
    //   307: astore 4
    //   309: aload 5
    //   311: astore_3
    //   312: aload 8
    //   314: astore 5
    //   316: aload 4
    //   318: astore 6
    //   320: aload_2
    //   321: astore 7
    //   323: aload_3
    //   324: invokevirtual 378	java/lang/Exception:printStackTrace	()V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 381	java/io/FileInputStream:close	()V
    //   337: aload 8
    //   339: ifnull +8 -> 347
    //   342: aload 8
    //   344: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   347: aload 9
    //   349: astore 5
    //   351: aload_2
    //   352: ifnull +12 -> 364
    //   355: aload_2
    //   356: invokevirtual 385	java/io/File:delete	()Z
    //   359: pop
    //   360: aload 9
    //   362: astore 5
    //   364: new 77	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   371: aload 15
    //   373: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 387
    //   379: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 14
    //   384: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: aload 16
    //   392: aload 5
    //   394: new 8	com/tencent/smtt/sdk/TbsLogReport$2
    //   397: dup
    //   398: aload_0
    //   399: invokespecial 388	com/tencent/smtt/sdk/TbsLogReport$2:<init>	(Lcom/tencent/smtt/sdk/TbsLogReport;)V
    //   402: iconst_0
    //   403: invokestatic 391	com/tencent/smtt/utils/HttpUtil:postData	(Ljava/lang/String;Ljava/util/Map;[BLcom/tencent/smtt/utils/HttpUtil$HttpResponseListener;Z)Ljava/lang/String;
    //   406: pop
    //   407: return
    //   408: aload 4
    //   410: invokevirtual 394	java/io/ByteArrayOutputStream:flush	()V
    //   413: invokestatic 299	com/tencent/smtt/utils/Post3DESEncryption:getInstance	()Lcom/tencent/smtt/utils/Post3DESEncryption;
    //   416: aload 4
    //   418: invokevirtual 397	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   421: invokevirtual 311	com/tencent/smtt/utils/Post3DESEncryption:DESEncrypt	([B)[B
    //   424: astore 5
    //   426: aload_3
    //   427: ifnull +7 -> 434
    //   430: aload_3
    //   431: invokevirtual 381	java/io/FileInputStream:close	()V
    //   434: aload 4
    //   436: ifnull +8 -> 444
    //   439: aload 4
    //   441: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   444: aload_2
    //   445: ifnull +155 -> 600
    //   448: aload_2
    //   449: invokevirtual 385	java/io/File:delete	()Z
    //   452: pop
    //   453: goto -89 -> 364
    //   456: astore 4
    //   458: aload 7
    //   460: astore_3
    //   461: aload 6
    //   463: astore_2
    //   464: aload_2
    //   465: ifnull +7 -> 472
    //   468: aload_2
    //   469: invokevirtual 381	java/io/FileInputStream:close	()V
    //   472: aload 5
    //   474: ifnull +8 -> 482
    //   477: aload 5
    //   479: invokevirtual 382	java/io/ByteArrayOutputStream:close	()V
    //   482: aload_3
    //   483: ifnull +8 -> 491
    //   486: aload_3
    //   487: invokevirtual 385	java/io/File:delete	()Z
    //   490: pop
    //   491: aload 4
    //   493: athrow
    //   494: astore_3
    //   495: goto -61 -> 434
    //   498: astore_3
    //   499: goto -55 -> 444
    //   502: astore_3
    //   503: goto -166 -> 337
    //   506: astore_3
    //   507: goto -160 -> 347
    //   510: astore_2
    //   511: goto -39 -> 472
    //   514: astore_2
    //   515: goto -33 -> 482
    //   518: astore 4
    //   520: aload_2
    //   521: astore_3
    //   522: aload 10
    //   524: astore 5
    //   526: aload 12
    //   528: astore_2
    //   529: goto -65 -> 464
    //   532: astore 6
    //   534: aload_2
    //   535: astore 4
    //   537: aload_3
    //   538: astore_2
    //   539: aload 10
    //   541: astore 5
    //   543: aload 4
    //   545: astore_3
    //   546: aload 6
    //   548: astore 4
    //   550: goto -86 -> 464
    //   553: astore 6
    //   555: aload 4
    //   557: astore 5
    //   559: aload_2
    //   560: astore 4
    //   562: aload_3
    //   563: astore_2
    //   564: aload 4
    //   566: astore_3
    //   567: aload 6
    //   569: astore 4
    //   571: goto -107 -> 464
    //   574: astore_3
    //   575: aload 11
    //   577: astore_2
    //   578: goto -266 -> 312
    //   581: astore_3
    //   582: goto -270 -> 312
    //   585: astore 5
    //   587: aload_3
    //   588: astore 4
    //   590: aload 5
    //   592: astore_3
    //   593: goto -281 -> 312
    //   596: astore_3
    //   597: goto -549 -> 48
    //   600: goto -236 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	TbsLogReport
    //   282	12	1	i	int
    //   37	432	2	localObject1	Object
    //   510	1	2	localException1	Exception
    //   514	7	2	localException2	Exception
    //   528	50	2	localObject2	Object
    //   45	442	3	localObject3	Object
    //   494	1	3	localException3	Exception
    //   498	1	3	localException4	Exception
    //   502	1	3	localException5	Exception
    //   506	1	3	localException6	Exception
    //   521	46	3	localObject4	Object
    //   574	1	3	localException7	Exception
    //   581	7	3	localException8	Exception
    //   592	1	3	localObject5	Object
    //   596	1	3	localException9	Exception
    //   143	297	4	localObject6	Object
    //   456	36	4	localObject7	Object
    //   518	1	4	localObject8	Object
    //   535	54	4	localObject9	Object
    //   164	127	5	localObject10	Object
    //   300	10	5	localException10	Exception
    //   314	244	5	localObject11	Object
    //   585	6	5	localException11	Exception
    //   167	295	6	localObject12	Object
    //   532	15	6	localObject13	Object
    //   553	15	6	localObject14	Object
    //   170	289	7	localObject15	Object
    //   157	186	8	localObject16	Object
    //   160	201	9	localObject17	Object
    //   154	386	10	localObject18	Object
    //   148	428	11	localObject19	Object
    //   140	387	12	localObject20	Object
    //   151	77	13	localObject21	Object
    //   28	355	14	str1	String
    //   80	292	15	str2	String
    //   89	302	16	localHashMap	java.util.HashMap
    //   15	183	17	str3	String
    // Exception table:
    //   from	to	target	type
    //   276	283	300	java/lang/Exception
    //   288	297	300	java/lang/Exception
    //   408	426	300	java/lang/Exception
    //   172	183	456	finally
    //   193	227	456	finally
    //   237	251	456	finally
    //   323	327	456	finally
    //   430	434	494	java/lang/Exception
    //   439	444	498	java/lang/Exception
    //   332	337	502	java/lang/Exception
    //   342	347	506	java/lang/Exception
    //   468	472	510	java/lang/Exception
    //   477	482	514	java/lang/Exception
    //   251	260	518	finally
    //   260	276	532	finally
    //   276	283	553	finally
    //   288	297	553	finally
    //   408	426	553	finally
    //   172	183	574	java/lang/Exception
    //   193	227	574	java/lang/Exception
    //   237	251	574	java/lang/Exception
    //   251	260	581	java/lang/Exception
    //   260	276	585	java/lang/Exception
    //   38	46	596	java/lang/Exception
  }
  
  public void saveUploadData(EventType paramEventType)
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(addData(paramEventType.value));
    localStringBuilder.append(addData(getImei()));
    localStringBuilder.append(addData(SysCoreQua2Utils.getQUA2(this.mContext)));
    localStringBuilder.append(addData(TbsInstaller.getInstance().getTbsCoreInstalledVer(this.mContext)));
    paramEventType = Build.MODEL;
    try
    {
      localObject = new String(paramEventType.getBytes("UTF-8"), "ISO8859-1");
      paramEventType = (EventType)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        localStringBuilder.append(addData(AppUtil.getAppVersionCode(this.mContext)));
      }
    }
    localStringBuilder.append(addData(paramEventType));
    paramEventType = this.mContext.getPackageName();
    localStringBuilder.append(addData(paramEventType));
    if ("com.tencent.mm".equals(paramEventType))
    {
      localStringBuilder.append(addData(AppUtil.getAppMetadata(this.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
      localStringBuilder.append(addData(formatTime(this.mEventTime)));
      localStringBuilder.append(addData(this.mDownUrl));
      localStringBuilder.append(addData(this.mResolveIp));
      localStringBuilder.append(addData(this.mHttpCode));
      localStringBuilder.append(addData(this.mPatchUpdateFlag));
      localStringBuilder.append(addData(this.mDownloadCancel));
      localStringBuilder.append(addData(this.mUnpkgFlag));
      localStringBuilder.append(addData(this.mApn));
      localStringBuilder.append(addData(this.mNetworkType));
      localStringBuilder.append(addData(this.mDownFinalFlag));
      localStringBuilder.append(addData(this.mDownloadSize));
      localStringBuilder.append(addData(this.mPkgSize));
      localStringBuilder.append(addData(this.mDownConsumeTime));
      localStringBuilder.append(addData(this.mNetworkChange));
      localStringBuilder.append(addData(this.mErrorCode));
      localStringBuilder.append(addData(this.mCheckErrorDetail));
      localStringBuilder.append(addData(this.mFailDetail));
      localStringBuilder.append(TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0));
      localObject = sharedPreferences();
      paramEventType = getUploadData();
      paramEventType.put(localStringBuilder.toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("tbs_download_upload", paramEventType.toString());
      ((SharedPreferences.Editor)localObject).commit();
      resetArgs();
      new Thread(new Runnable()
      {
        public void run()
        {
          TbsLogReport.this.reportDownloadStat();
        }
      }).start();
      return;
    }
  }
  
  public void setApn(String paramString)
  {
    this.mApn = paramString;
  }
  
  public void setCheckErrorDetail(String paramString)
  {
    setErrorCode(108);
    this.mCheckErrorDetail = paramString;
  }
  
  public void setDownConsumeTime(long paramLong)
  {
    this.mDownConsumeTime += paramLong;
  }
  
  public void setDownFinalFlag(int paramInt)
  {
    this.mDownFinalFlag = paramInt;
  }
  
  public void setDownloadCancel(int paramInt)
  {
    this.mDownloadCancel = paramInt;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.mDownloadSize += paramLong;
  }
  
  public void setDownloadUrl(String paramString)
  {
    if (this.mDownUrl == null)
    {
      this.mDownUrl = paramString;
      return;
    }
    this.mDownUrl = (this.mDownUrl + ";" + paramString);
  }
  
  public void setErrorCode(int paramInt)
  {
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:" + paramInt, true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.mErrorCode = paramInt;
  }
  
  public void setEventTime(long paramLong)
  {
    this.mEventTime = paramLong;
  }
  
  public void setFailDetail(String paramString)
  {
    this.mFailDetail = paramString;
  }
  
  public void setFailDetail(Throwable paramThrowable)
  {
    if (paramThrowable == null)
    {
      this.mFailDetail = "";
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.mFailDetail = paramThrowable;
  }
  
  public void setHttpCode(int paramInt)
  {
    this.mHttpCode = paramInt;
  }
  
  public void setInstallErrorCode(int paramInt, String paramString)
  {
    if ((paramInt != 200) && (paramInt != 220) && (paramInt != 221)) {
      TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + paramInt, true);
    }
    setErrorCode(paramInt);
    setEventTime(System.currentTimeMillis());
    setFailDetail(paramString);
    QbSdk.mTbsListenerWrapper.onInstallFinish(paramInt);
    saveUploadData(EventType.TYPE_INSTALL);
  }
  
  public void setInstallErrorCode(int paramInt, Throwable paramThrowable)
  {
    setFailDetail(paramThrowable);
    setInstallErrorCode(paramInt, this.mFailDetail);
  }
  
  public void setLoadErrorCode(int paramInt, String paramString)
  {
    setErrorCode(paramInt);
    setEventTime(System.currentTimeMillis());
    setFailDetail(paramString);
    saveUploadData(EventType.TYPE_LOAD);
  }
  
  public void setLoadErrorCode(int paramInt, Throwable paramThrowable)
  {
    if (310 == paramInt)
    {
      String str = "" + paramThrowable.getMessage() + ";" + Log.getStackTraceString(paramThrowable.getCause());
      paramThrowable = str;
      if (str.length() > 1024) {
        paramThrowable = str.substring(0, 1024);
      }
      this.mFailDetail = paramThrowable;
    }
    for (;;)
    {
      setLoadErrorCode(paramInt, this.mFailDetail);
      return;
      setFailDetail(paramThrowable);
    }
  }
  
  public void setNetworkChange(int paramInt)
  {
    this.mNetworkChange = paramInt;
  }
  
  public void setNetworkType(int paramInt)
  {
    this.mNetworkType = paramInt;
  }
  
  public void setPatchUpdateFlag(int paramInt)
  {
    this.mPatchUpdateFlag = paramInt;
  }
  
  public void setPkgSize(long paramLong)
  {
    this.mPkgSize = paramLong;
  }
  
  public void setResolveIp(String paramString)
  {
    this.mResolveIp = paramString;
  }
  
  public void setUnpkgFlag(int paramInt)
  {
    this.mUnpkgFlag = paramInt;
  }
  
  public static enum EventType
  {
    TYPE_DOWNLOAD(0),  TYPE_INSTALL(1),  TYPE_LOAD(2);
    
    int value;
    
    private EventType(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static class ZipHelper
  {
    private static final int BUFFER = 2048;
    private final String files;
    private final String zipFile;
    
    public ZipHelper(String paramString1, String paramString2)
    {
      this.files = paramString1;
      this.zipFile = paramString2;
    }
    
    /* Error */
    private static void replaceWrongZipByte(java.io.File paramFile)
      throws java.io.IOException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 4
      //   5: new 31	java/io/RandomAccessFile
      //   8: dup
      //   9: aload_0
      //   10: ldc 33
      //   12: invokespecial 36	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   15: astore_0
      //   16: aload_0
      //   17: ifnull +48 -> 65
      //   20: ldc 38
      //   22: iconst_2
      //   23: invokestatic 44	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
      //   26: istore_1
      //   27: aload_0
      //   28: ldc2_w 45
      //   31: invokevirtual 50	java/io/RandomAccessFile:seek	(J)V
      //   34: aload_0
      //   35: invokevirtual 54	java/io/RandomAccessFile:read	()I
      //   38: istore_2
      //   39: iload_2
      //   40: iload_1
      //   41: iand
      //   42: ifle +23 -> 65
      //   45: aload_0
      //   46: ldc2_w 45
      //   49: invokevirtual 50	java/io/RandomAccessFile:seek	(J)V
      //   52: aload_0
      //   53: iload_2
      //   54: iload_1
      //   55: iconst_m1
      //   56: ixor
      //   57: sipush 255
      //   60: iand
      //   61: iand
      //   62: invokevirtual 58	java/io/RandomAccessFile:write	(I)V
      //   65: aload_0
      //   66: ifnull +77 -> 143
      //   69: aload_0
      //   70: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   73: return
      //   74: astore_0
      //   75: aload_0
      //   76: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   79: return
      //   80: astore_3
      //   81: aload 4
      //   83: astore_0
      //   84: aload_3
      //   85: astore 4
      //   87: aload_0
      //   88: astore_3
      //   89: aload 4
      //   91: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   94: aload_0
      //   95: ifnull -22 -> 73
      //   98: aload_0
      //   99: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   102: return
      //   103: astore_0
      //   104: aload_0
      //   105: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   108: return
      //   109: astore_0
      //   110: aload_3
      //   111: ifnull +7 -> 118
      //   114: aload_3
      //   115: invokevirtual 61	java/io/RandomAccessFile:close	()V
      //   118: aload_0
      //   119: athrow
      //   120: astore_3
      //   121: aload_3
      //   122: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   125: goto -7 -> 118
      //   128: astore 4
      //   130: aload_0
      //   131: astore_3
      //   132: aload 4
      //   134: astore_0
      //   135: goto -25 -> 110
      //   138: astore 4
      //   140: goto -53 -> 87
      //   143: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	paramFile	java.io.File
      //   26	31	1	i	int
      //   38	24	2	j	int
      //   1	1	3	localObject1	Object
      //   80	5	3	localException1	Exception
      //   88	27	3	localFile1	java.io.File
      //   120	2	3	localIOException	java.io.IOException
      //   131	1	3	localFile2	java.io.File
      //   3	87	4	localException2	Exception
      //   128	5	4	localObject2	Object
      //   138	1	4	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   69	73	74	java/io/IOException
      //   5	16	80	java/lang/Exception
      //   98	102	103	java/io/IOException
      //   5	16	109	finally
      //   89	94	109	finally
      //   114	118	120	java/io/IOException
      //   20	39	128	finally
      //   45	65	128	finally
      //   20	39	138	java/lang/Exception
      //   45	65	138	java/lang/Exception
    }
    
    /* Error */
    public void Zip()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aconst_null
      //   3: astore 7
      //   5: aconst_null
      //   6: astore 5
      //   8: aconst_null
      //   9: astore 4
      //   11: aconst_null
      //   12: astore 6
      //   14: new 69	java/io/FileOutputStream
      //   17: dup
      //   18: aload_0
      //   19: getfield 22	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
      //   22: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   25: astore_2
      //   26: new 74	java/util/zip/ZipOutputStream
      //   29: dup
      //   30: new 76	java/io/BufferedOutputStream
      //   33: dup
      //   34: aload_2
      //   35: invokespecial 79	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   38: invokespecial 80	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   41: astore 8
      //   43: sipush 2048
      //   46: newarray byte
      //   48: astore 10
      //   50: aload_0
      //   51: getfield 20	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:files	Ljava/lang/String;
      //   54: astore 11
      //   56: aconst_null
      //   57: astore 4
      //   59: aconst_null
      //   60: astore 9
      //   62: aconst_null
      //   63: astore 5
      //   65: aconst_null
      //   66: astore 6
      //   68: aconst_null
      //   69: astore 7
      //   71: new 82	java/io/FileInputStream
      //   74: dup
      //   75: aload 11
      //   77: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   80: astore_3
      //   81: new 85	java/io/BufferedInputStream
      //   84: dup
      //   85: aload_3
      //   86: sipush 2048
      //   89: invokespecial 88	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
      //   92: astore 4
      //   94: aload 8
      //   96: new 90	java/util/zip/ZipEntry
      //   99: dup
      //   100: aload 11
      //   102: aload 11
      //   104: ldc 92
      //   106: invokevirtual 98	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
      //   109: iconst_1
      //   110: iadd
      //   111: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
      //   114: invokespecial 103	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
      //   117: invokevirtual 107	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
      //   120: aload 4
      //   122: aload 10
      //   124: iconst_0
      //   125: sipush 2048
      //   128: invokevirtual 110	java/io/BufferedInputStream:read	([BII)I
      //   131: istore_1
      //   132: iload_1
      //   133: iconst_m1
      //   134: if_icmpeq +84 -> 218
      //   137: aload 8
      //   139: aload 10
      //   141: iconst_0
      //   142: iload_1
      //   143: invokevirtual 113	java/util/zip/ZipOutputStream:write	([BII)V
      //   146: goto -26 -> 120
      //   149: astore 6
      //   151: aload 4
      //   153: astore 7
      //   155: aload_3
      //   156: astore 4
      //   158: aload 7
      //   160: astore 5
      //   162: aload 6
      //   164: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   167: aload 7
      //   169: ifnull +8 -> 177
      //   172: aload 7
      //   174: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   177: aload_3
      //   178: ifnull +7 -> 185
      //   181: aload_3
      //   182: invokevirtual 115	java/io/FileInputStream:close	()V
      //   185: new 117	java/io/File
      //   188: dup
      //   189: aload_0
      //   190: getfield 22	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:zipFile	Ljava/lang/String;
      //   193: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
      //   196: invokestatic 120	com/tencent/smtt/sdk/TbsLogReport$ZipHelper:replaceWrongZipByte	(Ljava/io/File;)V
      //   199: aload 8
      //   201: ifnull +8 -> 209
      //   204: aload 8
      //   206: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   209: aload_2
      //   210: ifnull +305 -> 515
      //   213: aload_2
      //   214: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   217: return
      //   218: aload 8
      //   220: invokevirtual 125	java/util/zip/ZipOutputStream:flush	()V
      //   223: aload 8
      //   225: invokevirtual 128	java/util/zip/ZipOutputStream:closeEntry	()V
      //   228: aload 4
      //   230: ifnull +8 -> 238
      //   233: aload 4
      //   235: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   238: aload_3
      //   239: ifnull +277 -> 516
      //   242: aload_3
      //   243: invokevirtual 115	java/io/FileInputStream:close	()V
      //   246: goto -61 -> 185
      //   249: astore 4
      //   251: aload 4
      //   253: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   256: goto -18 -> 238
      //   259: astore 5
      //   261: aload 8
      //   263: astore 6
      //   265: aload_2
      //   266: astore_3
      //   267: aload 6
      //   269: astore 4
      //   271: aload 5
      //   273: invokevirtual 65	java/lang/Exception:printStackTrace	()V
      //   276: aload 6
      //   278: ifnull +8 -> 286
      //   281: aload 6
      //   283: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   286: aload_2
      //   287: ifnull -70 -> 217
      //   290: aload_2
      //   291: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   294: return
      //   295: astore_2
      //   296: aload_2
      //   297: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   300: return
      //   301: astore_3
      //   302: aload_3
      //   303: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   306: goto -121 -> 185
      //   309: astore 4
      //   311: aload 4
      //   313: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   316: goto -139 -> 177
      //   319: astore 5
      //   321: aload 8
      //   323: astore 4
      //   325: aload_2
      //   326: astore_3
      //   327: aload 5
      //   329: astore_2
      //   330: aload 4
      //   332: ifnull +8 -> 340
      //   335: aload 4
      //   337: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
      //   340: aload_3
      //   341: ifnull +7 -> 348
      //   344: aload_3
      //   345: invokevirtual 122	java/io/FileOutputStream:close	()V
      //   348: aload_2
      //   349: athrow
      //   350: astore_3
      //   351: aload_3
      //   352: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   355: goto -170 -> 185
      //   358: astore_3
      //   359: aload 5
      //   361: ifnull +8 -> 369
      //   364: aload 5
      //   366: invokevirtual 114	java/io/BufferedInputStream:close	()V
      //   369: aload 4
      //   371: ifnull +8 -> 379
      //   374: aload 4
      //   376: invokevirtual 115	java/io/FileInputStream:close	()V
      //   379: aload_3
      //   380: athrow
      //   381: astore 5
      //   383: aload 5
      //   385: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   388: goto -19 -> 369
      //   391: astore 4
      //   393: aload 4
      //   395: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   398: goto -19 -> 379
      //   401: astore_3
      //   402: aload_3
      //   403: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   406: goto -197 -> 209
      //   409: astore_2
      //   410: aload_2
      //   411: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   414: return
      //   415: astore_3
      //   416: aload_3
      //   417: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   420: goto -134 -> 286
      //   423: astore 4
      //   425: aload 4
      //   427: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   430: goto -90 -> 340
      //   433: astore_3
      //   434: aload_3
      //   435: invokevirtual 64	java/io/IOException:printStackTrace	()V
      //   438: goto -90 -> 348
      //   441: astore_2
      //   442: goto -112 -> 330
      //   445: astore 6
      //   447: aload_2
      //   448: astore_3
      //   449: aload 5
      //   451: astore 4
      //   453: aload 6
      //   455: astore_2
      //   456: goto -126 -> 330
      //   459: astore 5
      //   461: aload 7
      //   463: astore_2
      //   464: goto -199 -> 265
      //   467: astore 5
      //   469: goto -204 -> 265
      //   472: astore 7
      //   474: aload_3
      //   475: astore 4
      //   477: aload 6
      //   479: astore 5
      //   481: aload 7
      //   483: astore_3
      //   484: goto -125 -> 359
      //   487: astore 6
      //   489: aload 4
      //   491: astore 5
      //   493: aload_3
      //   494: astore 4
      //   496: aload 6
      //   498: astore_3
      //   499: goto -140 -> 359
      //   502: astore 6
      //   504: aload 9
      //   506: astore_3
      //   507: goto -352 -> 155
      //   510: astore 6
      //   512: goto -357 -> 155
      //   515: return
      //   516: goto -331 -> 185
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	519	0	this	ZipHelper
      //   131	12	1	i	int
      //   25	266	2	localFileOutputStream	java.io.FileOutputStream
      //   295	31	2	localIOException1	java.io.IOException
      //   329	20	2	localObject1	Object
      //   409	2	2	localIOException2	java.io.IOException
      //   441	7	2	localObject2	Object
      //   455	9	2	localObject3	Object
      //   1	266	3	localObject4	Object
      //   301	2	3	localIOException3	java.io.IOException
      //   326	19	3	localObject5	Object
      //   350	2	3	localIOException4	java.io.IOException
      //   358	22	3	localObject6	Object
      //   401	2	3	localIOException5	java.io.IOException
      //   415	2	3	localIOException6	java.io.IOException
      //   433	2	3	localIOException7	java.io.IOException
      //   448	59	3	localObject7	Object
      //   9	225	4	localObject8	Object
      //   249	3	4	localIOException8	java.io.IOException
      //   269	1	4	localObject9	Object
      //   309	3	4	localIOException9	java.io.IOException
      //   323	52	4	localObject10	Object
      //   391	3	4	localIOException10	java.io.IOException
      //   423	3	4	localIOException11	java.io.IOException
      //   451	44	4	localObject11	Object
      //   6	155	5	localObject12	Object
      //   259	13	5	localException1	Exception
      //   319	46	5	localObject13	Object
      //   381	69	5	localIOException12	java.io.IOException
      //   459	1	5	localException2	Exception
      //   467	1	5	localException3	Exception
      //   479	13	5	localObject14	Object
      //   12	55	6	localObject15	Object
      //   149	14	6	localException4	Exception
      //   263	19	6	localObject16	Object
      //   445	33	6	localObject17	Object
      //   487	10	6	localObject18	Object
      //   502	1	6	localException5	Exception
      //   510	1	6	localException6	Exception
      //   3	459	7	localObject19	Object
      //   472	10	7	localObject20	Object
      //   41	281	8	localZipOutputStream	java.util.zip.ZipOutputStream
      //   60	445	9	localObject21	Object
      //   48	92	10	arrayOfByte	byte[]
      //   54	49	11	str	String
      // Exception table:
      //   from	to	target	type
      //   94	120	149	java/lang/Exception
      //   120	132	149	java/lang/Exception
      //   137	146	149	java/lang/Exception
      //   218	228	149	java/lang/Exception
      //   233	238	249	java/io/IOException
      //   43	56	259	java/lang/Exception
      //   172	177	259	java/lang/Exception
      //   181	185	259	java/lang/Exception
      //   185	199	259	java/lang/Exception
      //   233	238	259	java/lang/Exception
      //   242	246	259	java/lang/Exception
      //   251	256	259	java/lang/Exception
      //   302	306	259	java/lang/Exception
      //   311	316	259	java/lang/Exception
      //   351	355	259	java/lang/Exception
      //   364	369	259	java/lang/Exception
      //   374	379	259	java/lang/Exception
      //   379	381	259	java/lang/Exception
      //   383	388	259	java/lang/Exception
      //   393	398	259	java/lang/Exception
      //   290	294	295	java/io/IOException
      //   242	246	301	java/io/IOException
      //   172	177	309	java/io/IOException
      //   43	56	319	finally
      //   172	177	319	finally
      //   181	185	319	finally
      //   185	199	319	finally
      //   233	238	319	finally
      //   242	246	319	finally
      //   251	256	319	finally
      //   302	306	319	finally
      //   311	316	319	finally
      //   351	355	319	finally
      //   364	369	319	finally
      //   374	379	319	finally
      //   379	381	319	finally
      //   383	388	319	finally
      //   393	398	319	finally
      //   181	185	350	java/io/IOException
      //   71	81	358	finally
      //   162	167	358	finally
      //   364	369	381	java/io/IOException
      //   374	379	391	java/io/IOException
      //   204	209	401	java/io/IOException
      //   213	217	409	java/io/IOException
      //   281	286	415	java/io/IOException
      //   335	340	423	java/io/IOException
      //   344	348	433	java/io/IOException
      //   14	26	441	finally
      //   271	276	441	finally
      //   26	43	445	finally
      //   14	26	459	java/lang/Exception
      //   26	43	467	java/lang/Exception
      //   81	94	472	finally
      //   94	120	487	finally
      //   120	132	487	finally
      //   137	146	487	finally
      //   218	228	487	finally
      //   71	81	502	java/lang/Exception
      //   81	94	510	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport
 * JD-Core Version:    0.7.0.1
 */