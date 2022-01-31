package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  private static final String DEVICE_CUPABI_BLACKLIST = "i686|mips|x86_64";
  private static final int FUNCTION_DOWNLOAD = 0;
  private static final int FUNCTION_QUERY = 2;
  private static final int FUNCTION_UPDATE = 1;
  public static final String LOGTAG = "TbsDownload";
  static final int MAX_SDK_RESPONSECODE = 10000;
  private static final int MSG_CONTINUEINSTALL_TBSCORE = 103;
  private static final int MSG_PREPARE_DOWNLOAD = 102;
  private static final int MSG_SEND_CHECKCONFIG_REQUEST = 100;
  private static final int MSG_START_DOWNLOAD_TBSAPK = 101;
  private static final int MSG_UPLOAD_TBSLOG = 104;
  private static final int PROTOCOL_VERSION = 1;
  static final int RESPONSECODE_APK = 1;
  static final int RESPONSECODE_UPDATE_APK = 2;
  static final int RESPONSECODE_UPDATE_PATCH = 3;
  private static final String TBS_EXTENSION_CFG_FILE = "tbs_extension_config";
  static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static final String TBS_PRECHECK_DISABLE_VERSION = "tbs_precheck_disable_version";
  static final String TBS_PRELOADX5_CHECK_CFG_FILE = "tbs_preloadx5_check_cfg_file";
  private static final String TBS_SDBACKUP_APK_FILENAME = "x5.tbs.org";
  static boolean mIsDownloading;
  private static boolean mStopDownloadByException = false;
  private static Context sAppContext;
  private static String sCpuabi;
  private static String sDefalutUserAgent;
  private static TbsApkDownloader sTbsApkDownloader;
  private static Handler sTbsDownloaderHandler;
  private static HandlerThread sTbsHandlerThread;
  
  @TargetApi(11)
  static void clearAllCache(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    TbsApkDownloader.clearAllApkFile(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label96;
      }
    }
    label96:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  static String getDefaultUserAgent(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDefalutUserAgent)) {
      return sDefalutUserAgent;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        localStringBuffer.append("1.0");
        continue;
        localStringBuffer.append("en");
      }
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(paramContext);
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label228;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      label143:
      break label143;
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append("; ");
      localStringBuffer.append(paramContext);
    }
    paramContext = Build.ID.replaceAll("[一-龥]", "");
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(" Build/");
      localStringBuffer.append(paramContext);
    }
    paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    sDefalutUserAgent = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String getDeviceCpuabi()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: new 243	java/io/InputStreamReader
    //   15: dup
    //   16: invokestatic 249	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   19: ldc 251
    //   21: invokevirtual 255	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   24: invokevirtual 261	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   27: invokespecial 264	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   30: astore_0
    //   31: new 266	java/io/BufferedReader
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 269	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 272	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_1
    //   45: aload_1
    //   46: ldc_w 274
    //   49: invokevirtual 277	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +53 -> 105
    //   55: ldc 24
    //   57: new 279	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 282
    //   67: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 294	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc_w 296
    //   83: invokestatic 300	com/tencent/smtt/sdk/TbsDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 303	java/io/BufferedReader:close	()V
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   103: aload_1
    //   104: areturn
    //   105: ldc_w 306
    //   108: invokestatic 311	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 300	com/tencent/smtt/sdk/TbsDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_1
    //   115: goto -28 -> 87
    //   118: astore_0
    //   119: aload_1
    //   120: areturn
    //   121: astore_3
    //   122: aload 5
    //   124: astore_0
    //   125: aload 4
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: ldc_w 306
    //   133: invokestatic 311	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 300	com/tencent/smtt/sdk/TbsDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 5
    //   141: aload 4
    //   143: astore_1
    //   144: aload_0
    //   145: astore_2
    //   146: aload_3
    //   147: invokevirtual 314	java/lang/Throwable:printStackTrace	()V
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 303	java/io/BufferedReader:close	()V
    //   160: aload 5
    //   162: astore_1
    //   163: aload_0
    //   164: ifnull -61 -> 103
    //   167: aload_0
    //   168: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   171: aload 5
    //   173: areturn
    //   174: astore_0
    //   175: aload 5
    //   177: areturn
    //   178: astore_0
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 303	java/io/BufferedReader:close	()V
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 304	java/io/InputStreamReader:close	()V
    //   195: aload_0
    //   196: athrow
    //   197: astore_2
    //   198: goto -103 -> 95
    //   201: astore_1
    //   202: goto -42 -> 160
    //   205: astore_1
    //   206: goto -19 -> 187
    //   209: astore_1
    //   210: goto -15 -> 195
    //   213: astore 4
    //   215: aload_3
    //   216: astore_1
    //   217: aload_0
    //   218: astore_2
    //   219: aload 4
    //   221: astore_0
    //   222: goto -43 -> 179
    //   225: astore_3
    //   226: aload_2
    //   227: astore_1
    //   228: aload_0
    //   229: astore_2
    //   230: aload_3
    //   231: astore_0
    //   232: goto -53 -> 179
    //   235: astore_3
    //   236: goto -111 -> 125
    //   239: astore_3
    //   240: aload_2
    //   241: astore 4
    //   243: goto -118 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	70	0	localInputStreamReader	java.io.InputStreamReader
    //   118	1	0	localIOException1	java.io.IOException
    //   124	44	0	str1	String
    //   174	1	0	localIOException2	java.io.IOException
    //   178	40	0	localObject1	Object
    //   221	11	0	localObject2	Object
    //   6	178	1	localObject3	Object
    //   201	1	1	localIOException3	java.io.IOException
    //   205	1	1	localIOException4	java.io.IOException
    //   209	1	1	localIOException5	java.io.IOException
    //   216	12	1	localObject4	Object
    //   1	191	2	localObject5	Object
    //   197	1	2	localIOException6	java.io.IOException
    //   218	23	2	localObject6	Object
    //   8	1	3	localObject7	Object
    //   121	95	3	localThrowable1	Throwable
    //   225	6	3	localObject8	Object
    //   235	1	3	localThrowable2	Throwable
    //   239	1	3	localThrowable3	Throwable
    //   10	146	4	localObject9	Object
    //   213	7	4	localObject10	Object
    //   241	1	4	localObject11	Object
    //   3	173	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   99	103	118	java/io/IOException
    //   12	31	121	java/lang/Throwable
    //   167	171	174	java/io/IOException
    //   12	31	178	finally
    //   130	141	178	finally
    //   146	150	178	finally
    //   91	95	197	java/io/IOException
    //   155	160	201	java/io/IOException
    //   183	187	205	java/io/IOException
    //   191	195	209	java/io/IOException
    //   31	40	213	finally
    //   40	87	225	finally
    //   105	115	225	finally
    //   31	40	235	java/lang/Throwable
    //   40	87	239	java/lang/Throwable
    //   105	115	239	java/lang/Throwable
  }
  
  private static boolean hostHasX5()
  {
    try
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "com.tencent.mm";
      arrayOfString[1] = "com.tencent.mobileqq";
      arrayOfString[2] = "com.qzone";
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        int k = TbsShareManager.getSharedTbsCoreVersion(sAppContext, str);
        if (k > 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void initTbsDownloaderThreadIfNeeded()
  {
    try
    {
      if (sTbsHandlerThread == null) {
        sTbsHandlerThread = TbsHandlerThread.getInstance();
      }
      try
      {
        sTbsApkDownloader = new TbsApkDownloader(sAppContext);
        sTbsDownloaderHandler = new Handler(sTbsHandlerThread.getLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            case 100: 
              TbsDownloader.sendRequest(true);
              return;
            case 101: 
              paramAnonymousMessage = TbsDownloadConfig.getInstance(TbsDownloader.sAppContext);
              if ((TbsDownloader.sendRequest(false)) && (paramAnonymousMessage.mPreferences.getBoolean("tbs_needdownload", false)))
              {
                TbsDownloader.sTbsApkDownloader.startDownload();
                return;
              }
              QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
              return;
            case 102: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              TbsDownloader.sTbsApkDownloader.removeTbsApkIfNeeded(((Integer)paramAnonymousMessage.obj).intValue());
              TbsLogReport.getInstance(TbsDownloader.sAppContext).reportDownloadStat();
              return;
            case 103: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
              TbsInstaller.getInstance().continueInstallTbsCore((Context)paramAnonymousMessage.obj);
              return;
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
            TbsLogReport.getInstance(TbsDownloader.sAppContext).reportTbsLog();
          }
        };
      }
      catch (Exception localException)
      {
        for (;;)
        {
          mStopDownloadByException = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  static boolean installLocalTbs(Context paramContext)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 8)
    {
      sAppContext = paramContext.getApplicationContext();
      initTbsDownloaderThreadIfNeeded();
      if (mStopDownloadByException) {
        return false;
      }
      bool = tryToInstallLocalTbsFromSdcard(paramContext);
    }
    if (bool) {}
    return bool;
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading]");
      boolean bool = mIsDownloading;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean needDownload(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    TbsLog.app_extra("TbsDownload", paramContext);
    TbsDownloadConfig localTbsDownloadConfig;
    if (Build.VERSION.SDK_INT >= 8)
    {
      sAppContext = paramContext.getApplicationContext();
      if ((TbsShareManager.isThirdPartyApp(sAppContext)) && (!hostHasX5())) {
        return false;
      }
      localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
      sCpuabi = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
      if (!TextUtils.isEmpty(sCpuabi)) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label98:
      int k;
      String str1;
      int m;
      String str2;
      long l1;
      long l2;
      int j;
      int i;
      break label98;
    }
    if ((localObject1 != null) && (((Matcher)localObject1).find())) {
      return false;
    }
    initTbsDownloaderThreadIfNeeded();
    if (mStopDownloadByException) {
      return false;
    }
    Object localObject1 = localTbsDownloadConfig.mPreferences.getString("app_versionname", null);
    k = localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0);
    localObject2 = localTbsDownloadConfig.mPreferences.getString("app_metadata", null);
    str1 = AppUtil.getAppVersionName(sAppContext);
    m = AppUtil.getAppVersionCode(sAppContext);
    str2 = AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
    l1 = System.currentTimeMillis();
    l2 = localTbsDownloadConfig.mPreferences.getLong("last_check", 0L);
    j = 0;
    if (l1 - l2 > 86400000L)
    {
      i = 1;
      if (i != 0) {
        queryRequest();
      }
      j = TbsInstaller.getInstance().getTbsCoreInstalledVer(sAppContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] localTbsVersion=" + j);
      sTbsDownloaderHandler.removeMessages(102);
      Message.obtain(sTbsDownloaderHandler, 102, Integer.valueOf(j)).sendToTarget();
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        bool1 = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + bool1);
        if (bool1) {
          break label456;
        }
        bool1 = true;
      }
      label355:
      if (!bool1) {
        break label475;
      }
      bool2 = bool1;
      if (!needStartDownload()) {
        bool2 = false;
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + bool2);
      return bool2;
      i = j;
      if (str1 == null) {
        break;
      }
      i = j;
      if (m == 0) {
        break;
      }
      i = j;
      if (str2 == null) {
        break;
      }
      if ((str1.equals(localObject1)) && (m == k))
      {
        i = j;
        if (str2.equals(localObject2)) {
          break;
        }
      }
      i = 1;
      break;
      label456:
      bool1 = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
      break label355;
      label475:
      bool2 = bool1;
      if (i != 0)
      {
        sTbsDownloaderHandler.removeMessages(103);
        Message.obtain(sTbsDownloaderHandler, 103, sAppContext).sendToTarget();
        bool2 = bool1;
      }
    }
  }
  
  private static boolean needStartDownload()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      return false;
    }
    if (!sTbsApkDownloader.hasEnoughFreeSpace())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l);
      if (l >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        return false;
      }
    }
    return true;
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONObject postJsonData(boolean paramBoolean)
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    String str1 = getDefaultUserAgent(sAppContext);
    Object localObject2 = null;
    localObject4 = null;
    Object localObject1 = localObject2;
    try
    {
      localObject5 = (TelephonyManager)sAppContext.getSystemService("phone");
      localObject1 = localObject2;
      localObject2 = ((TelephonyManager)localObject5).getSubscriberId();
      localObject1 = localObject2;
      localObject5 = ((TelephonyManager)localObject5).getDeviceId();
      localObject4 = localObject5;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject5;
        int j;
        int k;
        Object localObject3 = localObject4;
        continue;
        j += 1;
        continue;
        k += 1;
      }
    }
    localObject4 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject4).put("PROTOCOLVERSION", 1);
        if (TbsShareManager.isThirdPartyApp(sAppContext))
        {
          i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
          if (!paramBoolean) {
            continue;
          }
          ((JSONObject)localObject4).put("FUNCTION", 2);
          if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
            continue;
          }
          localObject5 = new JSONArray();
          String[] arrayOfString = new String[4];
          arrayOfString[0] = "com.tencent.mm";
          arrayOfString[1] = "com.tencent.mobileqq";
          arrayOfString[2] = "com.tencent.mtt";
          arrayOfString[3] = "com.qzone";
          int i1 = arrayOfString.length;
          j = 0;
          if (j < i1)
          {
            String str2 = arrayOfString[j];
            int i2 = TbsShareManager.getSharedTbsCoreVersion(sAppContext, str2);
            if (i2 <= 0) {
              break label600;
            }
            int n = 0;
            k = 0;
            int m = n;
            if (k < ((JSONArray)localObject5).length())
            {
              if (((JSONArray)localObject5).optInt(k) != i2) {
                break label607;
              }
              m = 1;
            }
            if (m != 0) {
              break label600;
            }
            ((JSONArray)localObject5).put(i2);
            break label600;
          }
        }
        else
        {
          j = TbsInstaller.getInstance().getTbsCoreInstalledVer(sAppContext);
          i = j;
          if (paramBoolean) {
            continue;
          }
          i = j;
          if (j != 0) {
            continue;
          }
          i = j;
          if (!TbsInstaller.getInstance().tbsFileConfExists(sAppContext)) {
            continue;
          }
          i = -1;
          continue;
        }
        ((JSONObject)localObject4).put("TBSVLARR", localObject5);
        ((JSONObject)localObject4).put("APPN", sAppContext.getPackageName());
        ((JSONObject)localObject4).put("APPVN", notNullString(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject4).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject4).put("APPMETA", notNullString(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject4).put("TBSSDKV", 36001);
        ((JSONObject)localObject4).put("TBSV", i);
        if (i != 0) {
          ((JSONObject)localObject4).put("TBSBACKUPV", sTbsApkDownloader.backupApkVersion());
        }
        ((JSONObject)localObject4).put("CPU", sCpuabi);
        ((JSONObject)localObject4).put("UA", str1);
        ((JSONObject)localObject4).put("IMSI", notNullString(localObject1));
        ((JSONObject)localObject4).put("IMEI", notNullString((String)localObject2));
        if (!QbSdk.isX5Disabled(sAppContext, i)) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException1)
      {
        continue;
        j = 1;
        continue;
        int i = 1;
        continue;
      }
      ((JSONObject)localObject4).put("STATUS", i);
      TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject4).toString());
      return localObject4;
      if (i != 0) {
        continue;
      }
      j = 0;
      ((JSONObject)localObject4).put("FUNCTION", j);
    }
  }
  
  private static void queryRequest()
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    sTbsDownloaderHandler.removeMessages(100);
    Message.obtain(sTbsDownloaderHandler, 100).sendToTarget();
  }
  
  @TargetApi(11)
  private static boolean readResponse(String paramString, int paramInt)
    throws Exception
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] response=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.getInt("RET") != 0) {
      return false;
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    if (TbsShareManager.isThirdPartyApp(sAppContext))
    {
      paramInt = localJSONObject.getInt("TBSAPKSERVERVERSION");
      TbsShareManager.writeCoreInfoForThirdPartyApp(sAppContext, paramInt);
      return true;
    }
    int n = localJSONObject.getInt("RESPONSECODE");
    String str = localJSONObject.getString("DOWNLOADURL");
    int i1 = localJSONObject.getInt("TBSAPKSERVERVERSION");
    int i2 = localJSONObject.getInt("DOWNLOADMAXFLOW");
    int i3 = localJSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i4 = localJSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i5 = localJSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l1 = localJSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l2 = localJSONObject.getLong("TBSAPKFILESIZE");
    paramString = null;
    int j = 0;
    int k = 0;
    int i = j;
    try
    {
      localObject = localJSONObject.getString("PKGMD5");
      i = j;
      paramString = (String)localObject;
      j = localJSONObject.getInt("RESETX5");
      i = j;
      paramString = (String)localObject;
      int m = localJSONObject.getInt("UPLOADLOG");
      k = m;
      paramString = (String)localObject;
      i = j;
    }
    catch (Exception localException)
    {
      Object localObject;
      label239:
      break label239;
    }
    if (i == 1)
    {
      QbSdk.reset(sAppContext);
      return false;
    }
    if (k == 1)
    {
      sTbsDownloaderHandler.removeMessages(104);
      Message.obtain(sTbsDownloaderHandler, 104).sendToTarget();
    }
    if ((n == 0) && (!TbsShareManager.isThirdPartyApp(sAppContext)))
    {
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      localTbsDownloadConfig.commit();
      return false;
    }
    i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (localObject = sAppContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; localObject = sAppContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      j = ((SharedPreferences)localObject).getInt("tbs_precheck_disable_version", -1);
      if ((j != i1) && (paramInt < i1) && (i <= i1) && (!TextUtils.isEmpty(str))) {
        break;
      }
      if (j == i1) {
        TbsLog.e("TbsDownload", "Download is disabled by preload_x5_check; tbs_version:" + i1);
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      localTbsDownloadConfig.commit();
      return false;
    }
    if (!str.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
    {
      sTbsApkDownloader.clearCache();
      localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_retrytimes", Integer.valueOf(0));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_success_retrytimes", Integer.valueOf(0));
    }
    localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(i1));
    localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str);
    localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(n));
    localTbsDownloadConfig.mSyncMap.put("tbs_download_maxflow", Integer.valueOf(i2));
    localTbsDownloadConfig.mSyncMap.put("tbs_download_min_free_space", Integer.valueOf(i3));
    localTbsDownloadConfig.mSyncMap.put("tbs_download_success_max_retrytimes", Integer.valueOf(i4));
    localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i5));
    localTbsDownloadConfig.mSyncMap.put("tbs_single_timeout", Long.valueOf(l1));
    localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l2));
    if (paramString != null) {
      localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", paramString);
    }
    if (TbsShareManager.isThirdPartyApp(sAppContext))
    {
      localTbsDownloadConfig.commit();
      TbsInstaller.getInstance().installTbsCoreForThirdPartyApp(sAppContext, i1);
      return true;
    }
    if (TbsInstaller.getInstance().installLocalTbsCore(sAppContext, i1)) {
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
    }
    for (;;)
    {
      localTbsDownloadConfig.commit();
      break;
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
    }
  }
  
  private static boolean sendRequest(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]");
    if (TbsInstaller.getInstance().isTbsLocalInstalled(sAppContext)) {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
    }
    label156:
    do
    {
      return false;
      TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
      Object localObject1 = new File(FileUtil.getTBSSdcardFilePath(sAppContext, 1), "x5.tbs.org");
      Object localObject2 = new File(FileUtil.getTBSSdcardFilePath(sAppContext, 2), "x5.tbs.org");
      if ((((File)localObject1).exists()) && (!((File)localObject2).exists())) {
        ((File)localObject1).renameTo((File)localObject2);
      }
      if (sCpuabi == null)
      {
        sCpuabi = getDeviceCpuabi();
        if (!TextUtils.isEmpty(sCpuabi))
        {
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", sCpuabi);
          localObject1 = null;
        }
      }
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        long l;
        int i;
        break label156;
      }
      if ((localObject1 != null) && (((Matcher)localObject1).find())) {
        return false;
      }
      l = System.currentTimeMillis();
      localTbsDownloadConfig.mSyncMap.put("last_check", Long.valueOf(l));
      localTbsDownloadConfig.mSyncMap.put("app_versionname", AppUtil.getAppVersionName(sAppContext));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(AppUtil.getAppVersionCode(sAppContext)));
      localTbsDownloadConfig.mSyncMap.put("app_metadata", AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
      localObject1 = postJsonData(paramBoolean);
      i = -1;
      try
      {
        int j = ((JSONObject)localObject1).getInt("TBSV");
        i = j;
      }
      catch (Exception localException1)
      {
        break label282;
      }
    } while (i == -1);
    try
    {
      label282:
      paramBoolean = readResponse(HttpUtil.postData(TbsCommonConfig.getInstance(sAppContext).getTbsDownloaderPostUrl(), ((JSONObject)localObject1).toString().getBytes("utf-8"), new HttpUtil.HttpResponseListener()
      {
        public void onHttpResponseCode(int paramAnonymousInt)
        {
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramAnonymousInt);
        }
      }, false), i);
      return paramBoolean;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return false;
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + sAppContext);
        mIsDownloading = true;
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
          return;
        }
        sAppContext = paramContext.getApplicationContext();
        if (TbsShareManager.isThirdPartyApp(sAppContext))
        {
          QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
          continue;
        }
        initTbsDownloaderThreadIfNeeded();
      }
      finally {}
      if (!mStopDownloadByException)
      {
        sTbsDownloaderHandler.removeMessages(101);
        sTbsDownloaderHandler.removeMessages(100);
        Message.obtain(sTbsDownloaderHandler, 101, QbSdk.mTbsListenerWrapper).sendToTarget();
      }
    }
  }
  
  public static void stopDownload()
  {
    if (mStopDownloadByException) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (sTbsApkDownloader != null) {
        sTbsApkDownloader.stopDownload();
      }
    } while (sTbsDownloaderHandler == null);
    sTbsDownloaderHandler.removeMessages(100);
    sTbsDownloaderHandler.removeMessages(101);
  }
  
  private static boolean tryToInstallLocalTbsFromSdcard(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = TbsApkDownloader.getLocalTbsFromSdcard(paramContext);
      if (paramContext != null)
      {
        TbsLog.i("grass", "[TbsDownloader.needDownload] getLocalTbsFromSdcard is not NULL -- force install local tbs!");
        bool = sTbsApkDownloader.InstallLocalTbsFromSdcard(paramContext);
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      StringWriter localStringWriter = new StringWriter();
      paramContext.printStackTrace(new PrintWriter(localStringWriter));
      TbsLog.e("grass", "tryToInstallLocalTbsFromSdcard exceptions:" + localStringWriter.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */