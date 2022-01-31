package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.PostEncryption;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

public class TesDownloader
{
  private static final String DEFAULT_ENCODE_NAME = "utf-8";
  private static final String DEFAULT_POST_ADDR = "http://cfg.imtt.qq.com/tbs";
  private static final int DEFAULT_TIME_OUT = 20000;
  private static final String LOGTAG = "SecuritySwitchPuller";
  private static final int MSG_CHECKCONFIG_AND_DOWNLOAD_TESAPK = 102;
  private static final int MSG_SEND_CHECKCONFIG_REQUEST = 100;
  private static final int MSG_START_DOWNLOAD_TESAPK = 101;
  private static final int PROTOCOL_VERSION = 1;
  private static final String TES_METADATA = "com.tencent.mtt.TES_CODE";
  private static final String THREAD_NAME = "SecuritySwitchPuller";
  private static Context sAppContext;
  private static String sDefalutUserAgent;
  private static Handler sTesDownloaderHandler = null;
  
  private static void checkConfig(boolean paramBoolean)
  {
    sTesDownloaderHandler.removeMessages(100);
    Message.obtain(sTesDownloaderHandler, 100, Boolean.valueOf(paramBoolean)).sendToTarget();
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
  
  private static void initTesDownloaderThread()
  {
    QbSdkLog.e("SecuritySwitchPuller", "init SecuritySwitchPuller thread & handler...");
    HandlerThread localHandlerThread = new HandlerThread("SecuritySwitchPuller");
    localHandlerThread.start();
    sTesDownloaderHandler = new Handler(localHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        try
        {
          switch (paramAnonymousMessage.what)
          {
          case 100: 
            TesDownloader.sendRequest(((Boolean)paramAnonymousMessage.obj).booleanValue());
            return;
          }
        }
        catch (Throwable paramAnonymousMessage)
        {
          StringWriter localStringWriter = new StringWriter();
          paramAnonymousMessage.printStackTrace(new PrintWriter(localStringWriter));
          QbSdkLog.e("SecuritySwitchPuller", "handleMessage - exceptions:" + localStringWriter.toString());
          return;
        }
        TesDownloader.sendRequest(false);
        return;
      }
    };
  }
  
  public static boolean needDownload(Context paramContext)
  {
    sAppContext = paramContext.getApplicationContext();
    TesDownloadConfig localTesDownloadConfig = TesDownloadConfig.getInstance(sAppContext);
    if (sTesDownloaderHandler == null) {
      initTesDownloaderThread();
    }
    str2 = localTesDownloadConfig.mAppVersionName;
    k = localTesDownloadConfig.mAppVersionCode;
    str3 = localTesDownloadConfig.mAppMetadata;
    localObject2 = sAppContext.getPackageName();
    PackageManager localPackageManager = sAppContext.getPackageManager();
    String str1 = null;
    int j = 0;
    localObject1 = null;
    i = j;
    for (paramContext = str1;; paramContext = str1)
    {
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo((String)localObject2, 0);
        i = j;
        paramContext = str1;
        str1 = localPackageInfo.versionName;
        i = j;
        paramContext = str1;
        j = localPackageInfo.versionCode;
        i = j;
        paramContext = str1;
        localObject2 = localPackageManager.getApplicationInfo((String)localObject2, 128).metaData;
        if (localObject2 == null) {
          break label297;
        }
        i = j;
        paramContext = str1;
        localObject2 = ((Bundle)localObject2).getString("com.tencent.mtt.TES_CODE");
        localObject1 = localObject2;
        paramContext = str1;
        i = j;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l1;
          long l2;
          label297:
          localObject2 = new StringWriter();
          localThrowable.printStackTrace(new PrintWriter((Writer)localObject2));
          Log.e("SecuritySwitchPuller", "needDownload - exceptions:" + ((StringWriter)localObject2).toString());
          continue;
          if ((paramContext != null) && (i != 0) && (localObject1 != null) && ((!paramContext.equals(str2)) || (i != k) || (!((String)localObject1).equals(str3)))) {
            checkConfig(true);
          }
        }
      }
      localTesDownloadConfig.mSyncMap.put("app_versionname", paramContext);
      localTesDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(i));
      localTesDownloadConfig.mSyncMap.put("app_metadata", localObject1);
      l1 = System.currentTimeMillis();
      l2 = l1 - localTesDownloadConfig.mLastCheckTime - 86400000L;
      localTesDownloadConfig.mLastCheckTime = l1;
      localTesDownloadConfig.mSyncMap.put("last_check", Long.valueOf(l1));
      localTesDownloadConfig.commit();
      Log.e("SecuritySwitchPuller", "delta:" + l2);
      if (l2 <= 0L) {
        break;
      }
      checkConfig(true);
      return localTesDownloadConfig.mNeedDownload;
      localObject1 = "";
      i = j;
    }
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  private static JSONObject postJsonData(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 205	com/tencent/smtt/sdk/TesDownloader:sAppContext	Landroid/content/Context;
    //   5: invokestatic 211	com/tencent/smtt/sdk/TesDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TesDownloadConfig;
    //   8: astore 8
    //   10: getstatic 205	com/tencent/smtt/sdk/TesDownloader:sAppContext	Landroid/content/Context;
    //   13: invokestatic 347	com/tencent/smtt/sdk/TesDownloader:getDefaultUserAgent	(Landroid/content/Context;)Ljava/lang/String;
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aload 5
    //   26: astore 4
    //   28: getstatic 205	com/tencent/smtt/sdk/TesDownloader:sAppContext	Landroid/content/Context;
    //   31: ldc_w 349
    //   34: invokevirtual 353	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 355	android/telephony/TelephonyManager
    //   40: astore 7
    //   42: aload 5
    //   44: astore 4
    //   46: aload 7
    //   48: invokevirtual 358	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   51: astore 5
    //   53: aload 5
    //   55: astore 4
    //   57: aload 7
    //   59: invokevirtual 361	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore 6
    //   68: aload 5
    //   70: astore 4
    //   72: aload 6
    //   74: astore 5
    //   76: new 363	org/json/JSONObject
    //   79: dup
    //   80: invokespecial 364	org/json/JSONObject:<init>	()V
    //   83: astore 6
    //   85: aload 6
    //   87: ldc_w 366
    //   90: iconst_1
    //   91: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 6
    //   97: ldc_w 371
    //   100: iconst_2
    //   101: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 6
    //   107: ldc_w 373
    //   110: getstatic 205	com/tencent/smtt/sdk/TesDownloader:sAppContext	Landroid/content/Context;
    //   113: invokevirtual 225	android/content/Context:getPackageName	()Ljava/lang/String;
    //   116: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload 6
    //   122: ldc_w 378
    //   125: aload 8
    //   127: getfield 216	com/tencent/smtt/sdk/TesDownloadConfig:mAppVersionName	Ljava/lang/String;
    //   130: invokestatic 380	com/tencent/smtt/sdk/TesDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   136: pop
    //   137: aload 6
    //   139: ldc_w 382
    //   142: aload 8
    //   144: getfield 219	com/tencent/smtt/sdk/TesDownloadConfig:mAppVersionCode	I
    //   147: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 6
    //   153: ldc_w 384
    //   156: aload 8
    //   158: getfield 222	com/tencent/smtt/sdk/TesDownloadConfig:mAppMetadata	Ljava/lang/String;
    //   161: invokestatic 380	com/tencent/smtt/sdk/TesDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload 6
    //   170: ldc_w 386
    //   173: iconst_0
    //   174: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 6
    //   180: ldc_w 388
    //   183: iconst_0
    //   184: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload 6
    //   190: ldc_w 390
    //   193: ldc_w 392
    //   196: invokestatic 395	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokestatic 380	com/tencent/smtt/sdk/TesDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload 6
    //   208: ldc_w 397
    //   211: aload 9
    //   213: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   216: pop
    //   217: aload 6
    //   219: ldc_w 399
    //   222: aload 4
    //   224: invokestatic 380	com/tencent/smtt/sdk/TesDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 401
    //   236: aload 5
    //   238: invokestatic 380	com/tencent/smtt/sdk/TesDownloader:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 376	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload 6
    //   247: ldc_w 403
    //   250: iconst_0
    //   251: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: invokestatic 409	com/tencent/smtt/sdk/SecuritySwitch:isSecurityApplyed	()Z
    //   258: istore_0
    //   259: invokestatic 412	com/tencent/smtt/sdk/SecuritySwitch:getSecuritySdkVersion	()I
    //   262: istore_2
    //   263: invokestatic 415	com/tencent/smtt/sdk/SecuritySwitch:getSecurityJsVersion	()I
    //   266: istore_3
    //   267: iload_0
    //   268: ifeq +36 -> 304
    //   271: aload 6
    //   273: ldc_w 417
    //   276: iload_1
    //   277: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload 6
    //   283: ldc_w 419
    //   286: iload_2
    //   287: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 421
    //   296: iload_3
    //   297: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 6
    //   303: areturn
    //   304: iconst_0
    //   305: istore_1
    //   306: goto -35 -> 271
    //   309: astore 4
    //   311: aload 6
    //   313: areturn
    //   314: astore 5
    //   316: aload 6
    //   318: astore 5
    //   320: goto -244 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramBoolean	boolean
    //   1	305	1	i	int
    //   262	25	2	j	int
    //   266	31	3	k	int
    //   26	197	4	localObject1	Object
    //   309	1	4	localException1	Exception
    //   19	218	5	localObject2	Object
    //   314	1	5	localException2	Exception
    //   318	1	5	localObject3	Object
    //   22	295	6	localObject4	Object
    //   40	25	7	localObject5	Object
    //   8	149	8	localTesDownloadConfig	TesDownloadConfig
    //   16	196	9	str	String
    // Exception table:
    //   from	to	target	type
    //   85	267	309	java/lang/Exception
    //   271	301	309	java/lang/Exception
    //   28	42	314	java/lang/Exception
    //   46	53	314	java/lang/Exception
    //   57	64	314	java/lang/Exception
  }
  
  private static void readResponse(String paramString)
    throws Exception
  {
    boolean bool2 = true;
    Log.e("SecuritySwitchPuller", "readResponse...");
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      localObject = new JSONObject(paramString);
    } while (((JSONObject)localObject).getInt("RET") != 0);
    int i = ((JSONObject)localObject).getInt("USEX5");
    int j = ((JSONObject)localObject).getInt("RESPONSECODE");
    paramString = ((JSONObject)localObject).getString("DOWNLOADURL");
    int k = ((JSONObject)localObject).getInt("TESAPKSERVERVERSION");
    int m = ((JSONObject)localObject).getInt("USE_SECURITY");
    Object localObject = TesDownloadConfig.getInstance(sAppContext);
    Map localMap = ((TesDownloadConfig)localObject).mSyncMap;
    if (i == 1)
    {
      bool1 = false;
      localMap.put("x5_disabled", Boolean.valueOf(bool1));
      ((TesDownloadConfig)localObject).mSyncMap.put("tes_version", Integer.valueOf(k));
      if ((0 != 0) && (k <= 0)) {
        break label246;
      }
      ((TesDownloadConfig)localObject).mSyncMap.put("tes_downloadurl", paramString);
      ((TesDownloadConfig)localObject).mSyncMap.put("tes_needdownload", Boolean.valueOf(true));
      ((TesDownloadConfig)localObject).mSyncMap.put("tes_responsecode", Integer.valueOf(j));
      label203:
      paramString = ((TesDownloadConfig)localObject).mSyncMap;
      if (m != 1) {
        break label267;
      }
    }
    label267:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.put("security_switch", Boolean.valueOf(bool1));
      ((TesDownloadConfig)localObject).commit();
      return;
      bool1 = true;
      break;
      label246:
      ((TesDownloadConfig)localObject).mSyncMap.put("tes_needdownload", Boolean.valueOf(false));
      break label203;
    }
  }
  
  private static void sendRequest(boolean paramBoolean)
  {
    Log.e("SecuritySwitchPuller", "sendRequest...");
    Object localObject5 = TesDownloadConfig.getInstance(sAppContext);
    JSONObject localJSONObject = postJsonData(paramBoolean);
    HttpURLConnection localHttpURLConnection;
    Object localObject4;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = PostEncryption.getInstance().initRSAKey();
        localHttpURLConnection = (HttpURLConnection)new URL("http://cfg.imtt.qq.com/tbs?mk=" + (String)localObject1).openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setConnectTimeout(20000);
        if (Build.VERSION.SDK_INT > 13)
        {
          localHttpURLConnection.setRequestProperty("Connection", "close");
          localObject4 = null;
          localObject1 = localObject4;
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        String str;
        return;
      }
      try
      {
        str = ((TesDownloadConfig)localObject5).mLastUrl;
        localObject1 = localObject4;
        i = ((TesDownloadConfig)localObject5).mLastError;
        localObject1 = localObject4;
        if ((!TextUtils.isEmpty(str)) && (i != 0))
        {
          localObject1 = localObject4;
          localJSONObject.put("LASTURL", str);
          localObject1 = localObject4;
          localJSONObject.put("LASTERR", i);
        }
        localObject1 = localObject4;
        localObject4 = localJSONObject.toString().getBytes("utf-8");
        localObject1 = localObject4;
        localObject4 = PostEncryption.getInstance().DESEncrypt((byte[])localObject4);
        localObject1 = localObject4;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          break;
        }
      }
      if (localObject1 != null) {
        break;
      }
      return;
      localHttpURLConnection.setRequestProperty("http.keepAlive", "false");
    }
    localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(localException1.length));
    for (;;)
    {
      try
      {
        localObject4 = localHttpURLConnection.getOutputStream();
        ((OutputStream)localObject4).write(localException1);
        ((OutputStream)localObject4).flush();
        if (localHttpURLConnection.getResponseCode() != 200) {
          break;
        }
        ((TesDownloadConfig)localObject5).mSyncMap.put("tes_lasterror", Integer.valueOf(0));
        ((TesDownloadConfig)localObject5).commit();
        Object localObject2 = localHttpURLConnection.getInputStream();
        localObject4 = localHttpURLConnection.getContentEncoding();
        if ((localObject4 != null) && (((String)localObject4).equalsIgnoreCase("gzip")))
        {
          localObject2 = new GZIPInputStream((InputStream)localObject2);
          localObject4 = new ByteArrayOutputStream();
          localObject5 = new byte[''];
          i = ((InputStream)localObject2).read((byte[])localObject5);
          if (i == -1) {
            break label453;
          }
          ((ByteArrayOutputStream)localObject4).write((byte[])localObject5, 0, i);
          continue;
        }
        if (localObject4 == null) {
          break label486;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject4 = new StringWriter();
        localThrowable.printStackTrace(new PrintWriter((Writer)localObject4));
        Log.e("SecuritySwitchPuller", "sendRequest - exceptions:" + ((StringWriter)localObject4).toString());
        return;
      }
      if (!((String)localObject4).equalsIgnoreCase("deflate")) {
        break label486;
      }
      localObject3 = new InflaterInputStream(localThrowable, new Inflater(true));
    }
    label453:
    localObject3 = new String(PostEncryption.getInstance().DESDecrypt(((ByteArrayOutputStream)localObject4).toByteArray()), "utf-8");
    ((ByteArrayOutputStream)localObject4).close();
    readResponse((String)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TesDownloader
 * JD-Core Version:    0.7.0.1
 */