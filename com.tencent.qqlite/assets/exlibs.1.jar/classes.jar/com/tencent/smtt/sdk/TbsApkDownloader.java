package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TbsApkDownloader
{
  public static final String BACKUPNAME = "backup";
  private static final int BUFFER_SIZE = 8192;
  public static final long DOWNLOAD_PERIOD = 86400000L;
  public static final int LOCAL_SDCARD_TBS_VERSION = 88888888;
  private static final int MAX_RETRY_TIMES = 5;
  private static final long MIN_RETRY_INTERVAL = 20000L;
  private static final int MSG_NETWORK_DETECTOR = 150;
  private static final long NETWORK_DETECT_RETRY_TIME = 120000L;
  private static final long NETWORK_WIFI_CHECK_STEP_SIZE = 1048576L;
  private static final String TBS_APK_FILENAME = "x5.tbs";
  private static final String TBS_APK_TEMP_FILENAME = "x5.tbs.temp";
  static final String TBS_BACKUP_APK_FILENAME = "x5.tbs.org";
  private static final String TBS_BACKUP_APK_PATH = "tbs";
  private static final String[] TBS_DOWNLOADING_APP_KEYS = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.x5sdk.demo", "tbs_downloading_com.qzone" };
  private static final String TBS_DOWNLOADING_KEY_HEAD = "tbs_downloading_";
  private static final int WALLED_GARDEN_SOCKET_TIMEOUT_MS = 10000;
  private static final String WALLED_GARDEN_URL = "http://pms.mb.qq.com/rsp204";
  private String mApnInfo;
  private int mApnType;
  private boolean mCanceled;
  private int mConnectTimeout = 20000;
  private long mContentLength;
  private Context mContext;
  private TbsLogReport mDownloadStat;
  private String mDownloadUrl;
  private File mFilePath;
  private boolean mFinished;
  private boolean mHasTmpTryNoRange;
  private HttpURLConnection mHttpRequest;
  private String mLastDownloadUrl;
  private String mLocalDownloadingKey;
  private String mLocation;
  private boolean mNeedDownloadStat;
  private Handler mNetworkDetectorHandler;
  private int mReadTimeout = 30000;
  private int mRetryTimes;
  private int mRetryTimes302;
  private Set<String> mWifiUnavailableList;
  
  public TbsApkDownloader(Context paramContext)
    throws NullPointerException
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDownloadStat = TbsLogReport.getInstance(this.mContext);
    this.mWifiUnavailableList = new HashSet();
    this.mLocalDownloadingKey = ("tbs_downloading_" + this.mContext.getPackageName());
    TbsInstaller.getInstance();
    this.mFilePath = TbsInstaller.getTbsCorePrivateDir(this.mContext);
    if (this.mFilePath == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    resetArgs();
    this.mApnInfo = null;
    this.mApnType = -1;
  }
  
  @TargetApi(8)
  static File backupApkPath(Context paramContext)
  {
    File localFile = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 8) {
        localFile = new File(FileUtil.getTBSSdcardFilePath(paramContext, 2));
      }
      if ((localFile != null) && (!localFile.exists()) && (!localFile.isDirectory())) {
        localFile.mkdirs();
      }
      return localFile;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
    }
    return null;
  }
  
  public static void backupTbsApk(File paramFile, Context paramContext)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = backupApkPath(paramContext);
        if (paramContext != null)
        {
          paramContext = new File(paramContext, "x5.tbs.org");
          paramContext.delete();
          FileUtil.copyFiles(paramFile, paramContext);
          return;
        }
      }
      catch (Exception paramFile) {}
    }
  }
  
  public static void clearAllApkFile(Context paramContext)
  {
    try
    {
      TbsInstaller.getInstance();
      File localFile = TbsInstaller.getTbsCorePrivateDir(paramContext);
      new File(localFile, "x5.tbs").delete();
      new File(localFile, "x5.tbs.temp").delete();
      paramContext = backupApkPath(paramContext);
      if (paramContext != null) {
        new File(paramContext, "x5.tbs.org").delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void closeHttpRequest()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.mHttpRequest != null) {
      if (!this.mCanceled) {
        this.mDownloadStat.setResolveIp(getDomainIp(this.mHttpRequest.getURL()));
      }
    }
    try
    {
      this.mHttpRequest.disconnect();
      try
      {
        label46:
        String str = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0) + "|" + 0;
        Settings.System.putString(this.mContext.getContentResolver(), this.mLocalDownloadingKey, str);
        label105:
        this.mHttpRequest = null;
        int i = this.mDownloadStat.mErrorCode;
        if ((!this.mCanceled) && (this.mNeedDownloadStat))
        {
          this.mDownloadStat.setEventTime(System.currentTimeMillis());
          str = Apn.getApnInfo(this.mContext);
          int j = Apn.getApnType(this.mContext);
          this.mDownloadStat.setApn(str);
          this.mDownloadStat.setNetworkType(j);
          if ((j != this.mApnType) || (!str.equals(this.mApnInfo))) {
            this.mDownloadStat.setNetworkChange(0);
          }
          if (((this.mDownloadStat.mErrorCode == 0) || (this.mDownloadStat.mErrorCode == 107)) && (this.mDownloadStat.getDownFinalFlag() == 0))
          {
            if (Apn.isNetworkAvailable(this.mContext)) {
              break label277;
            }
            setDownloadStat(101, null, true);
          }
          for (;;)
          {
            this.mDownloadStat.saveUploadData(TbsLogReport.EventType.TYPE_DOWNLOAD);
            if (i != 100) {
              QbSdk.mTbsListenerWrapper.onDownloadFinish(i);
            }
            return;
            label277:
            if (!ping()) {
              setDownloadStat(101, null, true);
            }
          }
        }
        TbsDownloader.mIsDownloading = false;
        return;
      }
      catch (Exception localException1)
      {
        break label105;
      }
    }
    catch (Exception localException2)
    {
      break label46;
    }
  }
  
  private void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      label10:
      return;
    }
    catch (IOException paramCloseable)
    {
      break label10;
    }
  }
  
  private boolean copyTbsApkFromBackupToInstall()
  {
    try
    {
      File localFile1 = new File(this.mFilePath, "x5.tbs");
      File localFile2 = backupApkPath(this.mContext);
      if (localFile2 != null)
      {
        localFile2 = new File(localFile2, "x5.tbs.org");
        localFile1.delete();
        FileUtil.copyFiles(localFile2, localFile1);
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
    }
    return false;
  }
  
  private boolean deleteFile(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.mFilePath, "x5.tbs");; localFile = new File(this.mFilePath, "x5.tbs.temp"))
    {
      boolean bool = true;
      paramBoolean = bool;
      if (localFile != null)
      {
        paramBoolean = bool;
        if (localFile.exists()) {
          paramBoolean = localFile.delete();
        }
      }
      return paramBoolean;
    }
  }
  
  private void deleteFileBackuped()
  {
    try
    {
      File localFile = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 2), "x5.tbs.org");
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean detectWifiNetworkAvailable()
  {
    if (Apn.getApnType(this.mContext) == 3)
    {
      bool1 = true;
      bool3 = false;
      localObject3 = null;
      TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + bool1);
      bool2 = bool3;
      if (bool1)
      {
        str = Apn.getWifiSSID(this.mContext);
        TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + str);
        localObject3 = null;
        localObject1 = null;
      }
    }
    for (;;)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL("http://pms.mb.qq.com/rsp204").openConnection();
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        localHttpURLConnection.setInstanceFollowRedirects(false);
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        localHttpURLConnection.setConnectTimeout(10000);
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        localHttpURLConnection.setReadTimeout(10000);
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        localHttpURLConnection.setUseCaches(false);
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        localHttpURLConnection.getInputStream();
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        int i = localHttpURLConnection.getResponseCode();
        localObject1 = localHttpURLConnection;
        localObject3 = localHttpURLConnection;
        TbsLog.i("TbsDownload", "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + i);
        if (i == 204)
        {
          bool1 = true;
          localObject3 = str;
          bool2 = bool1;
        }
      }
      catch (Throwable localThrowable)
      {
        HttpURLConnection localHttpURLConnection;
        localObject3 = localObject1;
        localThrowable.printStackTrace();
        localObject3 = str;
        bool2 = bool3;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((HttpURLConnection)localObject1).disconnect();
          localObject3 = str;
          bool2 = bool3;
        }
        catch (Exception localException1)
        {
          localObject3 = str;
          bool2 = bool3;
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {}
      }
      try
      {
        localHttpURLConnection.disconnect();
        bool2 = bool1;
        localObject3 = str;
      }
      catch (Exception localException2)
      {
        try
        {
          localObject3.disconnect();
          throw localObject2;
          localException2 = localException2;
          localObject3 = str;
          bool2 = bool1;
        }
        catch (Exception localException3)
        {
          break label434;
        }
      }
      if ((!bool2) && (!TextUtils.isEmpty(localObject3)) && (!this.mWifiUnavailableList.contains(localObject3)))
      {
        this.mWifiUnavailableList.add(localObject3);
        initNetworkDetectorHandlerIfNeeded();
        localObject1 = this.mNetworkDetectorHandler.obtainMessage(150, localObject3);
        this.mNetworkDetectorHandler.sendMessageDelayed((Message)localObject1, 120000L);
      }
      if ((bool2) && (this.mWifiUnavailableList.contains(localObject3))) {
        this.mWifiUnavailableList.remove(localObject3);
      }
      return bool2;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private boolean downloadFileExists()
  {
    boolean bool2 = false;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long downloadFileSize()
  {
    long l2 = 0L;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  private void downloadSuccess(boolean paramBoolean)
  {
    TbsUtils.createDirectoryTBS(this.mContext);
    Object localObject1 = QbSdk.mTbsListenerWrapper;
    Object localObject2;
    File localFile;
    int j;
    if (paramBoolean)
    {
      i = 100;
      ((TbsListener)localObject1).onDownloadFinish(i);
      localObject2 = TbsDownloadConfig.getInstance(this.mContext);
      ((TbsDownloadConfig)localObject2).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      ((TbsDownloadConfig)localObject2).commit();
      i = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_responsecode", 0);
      if ((i != 3) && (i <= 10000)) {
        break label293;
      }
      localObject1 = backupApkPath(this.mContext);
      if (localObject1 == null) {
        break label265;
      }
      localFile = new File((File)localObject1, "x5.tbs.org");
      j = ApkUtil.getApkVersion(this.mContext, localFile);
      localObject1 = new File(this.mFilePath, "x5.tbs");
      if (!((File)localObject1).exists()) {
        break label259;
      }
    }
    label259:
    for (localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = null)
    {
      int k = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", i);
      ((Bundle)localObject2).putInt("old_core_ver", j);
      ((Bundle)localObject2).putInt("new_core_ver", k);
      ((Bundle)localObject2).putString("old_apk_location", localFile.getAbsolutePath());
      ((Bundle)localObject2).putString("new_apk_location", (String)localObject1);
      ((Bundle)localObject2).putString("diff_file_location", (String)localObject1);
      TbsInstaller.getInstance().installLocalTbsCoreExInThread(this.mContext, (Bundle)localObject2);
      return;
      i = 120;
      break;
    }
    label265:
    clearCache();
    ((TbsDownloadConfig)localObject2).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject2).commit();
    return;
    label293:
    int i = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
    TbsInstaller.getInstance().installTbsCore(this.mContext, new File(this.mFilePath, "x5.tbs").getAbsolutePath(), i);
    backupTbsApk(new File(this.mFilePath, "x5.tbs"), this.mContext);
  }
  
  private String errorToString(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String getDomainIp(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  public static File getLocalTbsFromSdcard(Context paramContext)
  {
    paramContext = new File(FileUtil.getTBSSdcardFilePath(paramContext, 3));
    if ((paramContext == null) || (!paramContext.isDirectory()))
    {
      TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] " + paramContext.getAbsolutePath() + "not found!");
      return null;
    }
    paramContext = paramContext.listFiles();
    Pattern localPattern = Pattern.compile("tbs(.*).apk");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()) && (localObject.canRead()))
      {
        TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] got tbs apk:" + localObject);
        return localObject;
      }
      i += 1;
    }
    TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] No tbs apk found!");
    return null;
  }
  
  private void initHttpRequest(String paramString)
    throws Exception
  {
    this.mHttpRequest = ((HttpURLConnection)new URL(paramString).openConnection());
    this.mHttpRequest.setRequestProperty("User-Agent", TbsDownloader.getDefaultUserAgent(this.mContext));
    this.mHttpRequest.setRequestProperty("Accept-Encoding", "identity");
    this.mHttpRequest.setRequestMethod("GET");
    this.mHttpRequest.setInstanceFollowRedirects(false);
    this.mHttpRequest.setConnectTimeout(this.mConnectTimeout);
    this.mHttpRequest.setReadTimeout(this.mReadTimeout);
  }
  
  private void initNetworkDetectorHandlerIfNeeded()
  {
    if (this.mNetworkDetectorHandler == null) {
      this.mNetworkDetectorHandler = new Handler(TbsHandlerThread.getInstance().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what == 150) {
            TbsApkDownloader.this.detectWifiNetworkAvailable();
          }
        }
      };
    }
  }
  
  /* Error */
  private boolean ping()
  {
    // Byte code:
    //   0: invokestatic 660	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 13
    //   17: aconst_null
    //   18: astore 14
    //   20: aconst_null
    //   21: astore 11
    //   23: aconst_null
    //   24: astore 12
    //   26: iconst_0
    //   27: istore 4
    //   29: aload 14
    //   31: astore 8
    //   33: aload 7
    //   35: astore 9
    //   37: aload 5
    //   39: new 136	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 662
    //   49: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 664
    //   55: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 668	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   64: invokevirtual 671	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   67: astore 5
    //   69: aload 5
    //   71: astore 10
    //   73: aload 14
    //   75: astore 8
    //   77: aload 5
    //   79: astore 6
    //   81: aload 7
    //   83: astore 9
    //   85: new 673	java/io/InputStreamReader
    //   88: dup
    //   89: aload 5
    //   91: invokespecial 676	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   94: astore 7
    //   96: new 678	java/io/BufferedReader
    //   99: dup
    //   100: aload 7
    //   102: invokespecial 681	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   105: astore 6
    //   107: iconst_0
    //   108: istore_1
    //   109: aload 6
    //   111: invokevirtual 684	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   114: astore 8
    //   116: iload 4
    //   118: istore_3
    //   119: aload 8
    //   121: ifnull +29 -> 150
    //   124: aload 8
    //   126: ldc_w 686
    //   129: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   132: ifne +16 -> 148
    //   135: aload 8
    //   137: ldc_w 690
    //   140: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   143: istore_3
    //   144: iload_3
    //   145: ifeq +25 -> 170
    //   148: iconst_1
    //   149: istore_3
    //   150: aload_0
    //   151: aload 5
    //   153: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: aload 7
    //   159: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   162: aload_0
    //   163: aload 6
    //   165: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   168: iload_3
    //   169: ireturn
    //   170: iload_1
    //   171: iconst_1
    //   172: iadd
    //   173: istore_2
    //   174: iload_2
    //   175: istore_1
    //   176: iload_2
    //   177: iconst_5
    //   178: if_icmplt -69 -> 109
    //   181: iload 4
    //   183: istore_3
    //   184: goto -34 -> 150
    //   187: astore 6
    //   189: aload 13
    //   191: astore 5
    //   193: aload 10
    //   195: astore 11
    //   197: aload 6
    //   199: astore 10
    //   201: aload 12
    //   203: astore 7
    //   205: aload 7
    //   207: astore 8
    //   209: aload 11
    //   211: astore 6
    //   213: aload 5
    //   215: astore 9
    //   217: aload 10
    //   219: invokevirtual 472	java/lang/Throwable:printStackTrace	()V
    //   222: aload_0
    //   223: aload 11
    //   225: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   228: aload_0
    //   229: aload 5
    //   231: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   234: aload_0
    //   235: aload 7
    //   237: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore 5
    //   244: aload_0
    //   245: aload 6
    //   247: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   250: aload_0
    //   251: aload 9
    //   253: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   256: aload_0
    //   257: aload 8
    //   259: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   262: aload 5
    //   264: athrow
    //   265: astore 10
    //   267: aload 11
    //   269: astore 8
    //   271: aload 5
    //   273: astore 6
    //   275: aload 7
    //   277: astore 9
    //   279: aload 10
    //   281: astore 5
    //   283: goto -39 -> 244
    //   286: astore 10
    //   288: aload 6
    //   290: astore 8
    //   292: aload 5
    //   294: astore 6
    //   296: aload 7
    //   298: astore 9
    //   300: aload 10
    //   302: astore 5
    //   304: goto -60 -> 244
    //   307: astore 10
    //   309: aload 7
    //   311: astore 6
    //   313: aload 12
    //   315: astore 7
    //   317: aload 5
    //   319: astore 11
    //   321: aload 6
    //   323: astore 5
    //   325: goto -120 -> 205
    //   328: astore 10
    //   330: aload 6
    //   332: astore 8
    //   334: aload 7
    //   336: astore 6
    //   338: aload 8
    //   340: astore 7
    //   342: aload 5
    //   344: astore 11
    //   346: aload 6
    //   348: astore 5
    //   350: goto -145 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	TbsApkDownloader
    //   108	68	1	i	int
    //   173	6	2	j	int
    //   118	66	3	bool1	boolean
    //   27	155	4	bool2	boolean
    //   3	227	5	localObject1	Object
    //   242	30	5	localObject2	Object
    //   281	68	5	localObject3	Object
    //   6	158	6	localObject4	Object
    //   187	11	6	localThrowable1	Throwable
    //   211	136	6	localObject5	Object
    //   12	329	7	localObject6	Object
    //   31	308	8	localObject7	Object
    //   35	264	9	localObject8	Object
    //   9	209	10	localObject9	Object
    //   265	15	10	localObject10	Object
    //   286	15	10	localObject11	Object
    //   307	1	10	localThrowable2	Throwable
    //   328	1	10	localThrowable3	Throwable
    //   21	324	11	localObject12	Object
    //   24	290	12	localObject13	Object
    //   15	175	13	localObject14	Object
    //   18	56	14	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   37	69	187	java/lang/Throwable
    //   85	96	187	java/lang/Throwable
    //   37	69	242	finally
    //   85	96	242	finally
    //   217	222	242	finally
    //   96	107	265	finally
    //   109	116	286	finally
    //   124	144	286	finally
    //   96	107	307	java/lang/Throwable
    //   109	116	328	java/lang/Throwable
    //   124	144	328	java/lang/Throwable
  }
  
  private void resetArgs()
  {
    this.mRetryTimes = 0;
    this.mRetryTimes302 = 0;
    this.mContentLength = -1L;
    this.mLocation = null;
    this.mHasTmpTryNoRange = false;
    this.mCanceled = false;
    this.mFinished = false;
    this.mNeedDownloadStat = false;
  }
  
  private void retry(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l = retryInterval();
      Thread.sleep(l);
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    this.mRetryTimes += 1;
  }
  
  private long retryInterval()
  {
    long l = 20000L;
    switch (this.mRetryTimes)
    {
    }
    for (;;)
    {
      return l * 10L;
      return 20000L * this.mRetryTimes;
      l = 20000L * 5L;
    }
  }
  
  private long saveDownloadDataStat(long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis();
    this.mDownloadStat.setDownConsumeTime(l - paramLong1);
    this.mDownloadStat.setDownloadSize(paramLong2);
    return l;
  }
  
  private void setDownloadStat(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mRetryTimes > 5))
    {
      this.mDownloadStat.setErrorCode(paramInt);
      this.mDownloadStat.setFailDetail(paramString);
    }
  }
  
  private boolean verifyLocalTbsApk(File paramFile)
  {
    TbsLog.i("grass", "[TbsApkDownloader.verifyLocalTbsApk] apk=" + paramFile);
    if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(ApkUtil.getSignatureFromApk(this.mContext, paramFile)))
    {
      TbsLog.i("grass", "[TbsApkDownloader.verifyLocalTbsApk] apk:" + paramFile + " signature failed");
      return false;
    }
    return true;
  }
  
  private boolean verifyTBSApkBackuped()
  {
    File localFile = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 2), "x5.tbs.org");
    int i = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
    return ApkUtil.verifyTbsApk(this.mContext, localFile, 0L, i);
  }
  
  private boolean verifyTbsApk(boolean paramBoolean1, boolean paramBoolean2)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.mFilePath;
    if (!paramBoolean1) {}
    for (Object localObject1 = "x5.tbs";; localObject1 = "x5.tbs.temp")
    {
      localObject2 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject2).exists()) {
        break;
      }
      return false;
    }
    localObject1 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getString("tbs_apk_md5", null);
    Object localObject3 = ApkUtil.getMd5((File)localObject2);
    if ((localObject1 == null) || (!((String)localObject1).equals(localObject3)))
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
      if (paramBoolean1) {
        this.mDownloadStat.setCheckErrorDetail("fileMd5 not match");
      }
      return false;
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = 0L;
    long l2 = l1;
    if (paramBoolean1)
    {
      long l3 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getLong("tbs_apkfilesize", 0L);
      l2 = l1;
      if (localObject2 != null)
      {
        l2 = l1;
        if (((File)localObject2).exists())
        {
          l2 = l1;
          if (l3 <= 0L) {
            break label350;
          }
          l1 = ((File)localObject2).length();
          l2 = l1;
          if (l3 == l1) {
            break label350;
          }
          l2 = l1;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.mDownloadStat.setCheckErrorDetail("fileLength:" + l2 + ",contentLength:" + l3);
      return false;
    }
    label350:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l2 + ") successful!");
    int i = -1;
    if (paramBoolean2)
    {
      int j = ApkUtil.getApkVersion(this.mContext, (File)localObject2);
      int k = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
      i = j;
      if (k != j)
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
        if (paramBoolean1) {
          this.mDownloadStat.setCheckErrorDetail("fileVersion:" + j + ",configVersion:" + k);
        }
        return false;
      }
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
    if (paramBoolean2)
    {
      localObject1 = ApkUtil.getSignatureFromApk(this.mContext, (File)localObject2);
      if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject1))
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
        if (paramBoolean1)
        {
          localObject2 = this.mDownloadStat;
          localObject3 = new StringBuilder().append("signature:");
          if (localObject1 != null) {
            break label646;
          }
        }
        label646:
        for (localObject1 = "null";; localObject1 = Integer.valueOf(((String)localObject1).length()))
        {
          ((TbsLogReport)localObject2).setCheckErrorDetail(localObject1);
          return false;
        }
      }
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
    paramBoolean2 = false;
    boolean bool = false;
    if (paramBoolean1)
    {
      localObject1 = null;
      try
      {
        paramBoolean1 = ((File)localObject2).renameTo(new File(this.mFilePath, "x5.tbs"));
        paramBoolean2 = paramBoolean1;
        if (!paramBoolean1)
        {
          setDownloadStat(109, errorToString((Throwable)localObject1), true);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramBoolean1 = bool;
        }
      }
    }
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
    return true;
  }
  
  public boolean InstallLocalTbsFromSdcard(File paramFile)
  {
    boolean bool = false;
    if (paramFile != null)
    {
      TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard=" + paramFile);
      if (verifyLocalTbsApk(paramFile))
      {
        TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard － verify localTbs successful!");
        TbsInstaller.getInstance().installTbsCore(this.mContext, paramFile.getAbsolutePath(), 88888888);
        bool = true;
      }
    }
    else
    {
      return bool;
    }
    TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard － verify localTbs failed!");
    paramFile.delete();
    return false;
  }
  
  public int backupApkVersion()
  {
    File localFile = backupApkPath(this.mContext);
    if (localFile == null) {
      return 0;
    }
    return ApkUtil.getApkVersion(this.mContext, new File(localFile, "x5.tbs.org"));
  }
  
  public void clearCache()
  {
    stopDownload();
    deleteFile(false);
    deleteFile(true);
  }
  
  public boolean hasEnoughFreeSpace()
  {
    long l = FileUtil.getFreeSpace(this.mFilePath.getAbsolutePath());
    if (l >= TbsDownloadConfig.getInstance(this.mContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public boolean hasSameTbsDownloading()
  {
    bool2 = false;
    try
    {
      l1 = System.currentTimeMillis();
      j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
      arrayOfString = TBS_DOWNLOADING_APP_KEYS;
      k = arrayOfString.length;
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1;
        int j;
        String[] arrayOfString;
        int k;
        int i;
        String str;
        Object localObject;
        localException.printStackTrace();
        boolean bool1 = bool2;
        continue;
        i += 1;
      }
    }
    bool1 = bool2;
    if (i < k)
    {
      str = arrayOfString[i];
      bool1 = str.equals(this.mLocalDownloadingKey);
      if (!bool1) {
        localObject = null;
      }
    }
    else
    {
      try
      {
        str = Settings.System.getString(this.mContext.getContentResolver(), str);
        localObject = str;
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          long l2;
          long l3;
          localSecurityException.printStackTrace();
        }
      }
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\\|");
        str = localObject[0];
        l2 = Long.parseLong(localObject[1]);
        if ((str != null) && (str.equals(String.valueOf(j))) && (l2 > 0L))
        {
          l3 = TbsDownloadConfig.getInstance(this.mContext).getDownloadSingleTimeout();
          if (l1 - l2 < l3)
          {
            bool1 = true;
            TbsLog.i("TbsDownload", "[TbsApkDownloader.hasSameTbsDownloading] result=" + bool1);
            return bool1;
          }
        }
      }
    }
  }
  
  public void removeTbsApkIfNeeded(int paramInt)
  {
    try
    {
      File localFile = new File(this.mFilePath, "x5.tbs");
      int i = ApkUtil.getApkVersion(this.mContext, localFile);
      if ((paramInt > 0) && (paramInt == i)) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void startDownload()
  {
    // Byte code:
    //   0: invokestatic 155	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   3: aload_0
    //   4: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   7: invokevirtual 877	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   18: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   21: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   24: ldc_w 506
    //   27: iconst_0
    //   28: invokeinterface 284 3 0
    //   33: istore_1
    //   34: iload_1
    //   35: iconst_1
    //   36: if_icmpeq +8 -> 44
    //   39: iload_1
    //   40: iconst_2
    //   41: if_icmpne +31 -> 72
    //   44: iconst_1
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +33 -> 82
    //   52: aload_0
    //   53: invokespecial 879	com/tencent/smtt/sdk/TbsApkDownloader:verifyTBSApkBackuped	()Z
    //   56: ifeq +22 -> 78
    //   59: aload_0
    //   60: invokespecial 881	com/tencent/smtt/sdk/TbsApkDownloader:copyTbsApkFromBackupToInstall	()Z
    //   63: ifeq +19 -> 82
    //   66: aload_0
    //   67: iconst_0
    //   68: invokespecial 883	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   71: return
    //   72: iconst_0
    //   73: istore 4
    //   75: goto -28 -> 47
    //   78: aload_0
    //   79: invokespecial 885	com/tencent/smtt/sdk/TbsApkDownloader:deleteFileBackuped	()V
    //   82: aload_0
    //   83: iconst_0
    //   84: iload 4
    //   86: invokespecial 887	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   89: ifeq +9 -> 98
    //   92: aload_0
    //   93: iconst_0
    //   94: invokespecial 883	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   97: return
    //   98: aload_0
    //   99: iconst_1
    //   100: invokespecial 836	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   103: ifne +20 -> 123
    //   106: aload_0
    //   107: iconst_1
    //   108: invokespecial 836	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   111: ifne +12 -> 123
    //   114: ldc 214
    //   116: ldc_w 889
    //   119: invokestatic 225	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: return
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   128: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   131: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   134: ldc_w 891
    //   137: aconst_null
    //   138: invokeinterface 763 3 0
    //   143: putfield 893	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   146: ldc 214
    //   148: new 136	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 895
    //   158: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 893	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   165: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 897
    //   171: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   178: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 899
    //   184: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   191: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: ldc_w 901
    //   197: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   204: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: getfield 893	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   217: ifnonnull +21 -> 238
    //   220: aload_0
    //   221: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   224: ifnonnull +14 -> 238
    //   227: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   230: bipush 110
    //   232: invokeinterface 371 2 0
    //   237: return
    //   238: aload_0
    //   239: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   242: ifnull +21 -> 263
    //   245: aload_0
    //   246: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   249: ifne +14 -> 263
    //   252: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   255: bipush 110
    //   257: invokeinterface 371 2 0
    //   262: return
    //   263: aload_0
    //   264: getfield 134	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   267: aload_0
    //   268: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   271: invokestatic 408	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   274: invokeinterface 450 2 0
    //   279: ifeq +22 -> 301
    //   282: ldc 214
    //   284: ldc_w 903
    //   287: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   293: bipush 110
    //   295: invokeinterface 371 2 0
    //   300: return
    //   301: aload_0
    //   302: invokespecial 169	com/tencent/smtt/sdk/TbsApkDownloader:resetArgs	()V
    //   305: ldc 214
    //   307: ldc_w 905
    //   310: iconst_1
    //   311: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   314: aload_0
    //   315: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   318: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   321: invokevirtual 911	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   324: lstore 19
    //   326: iconst_0
    //   327: istore_3
    //   328: aload_0
    //   329: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   332: iconst_5
    //   333: if_icmple +171 -> 504
    //   336: iload_3
    //   337: istore_2
    //   338: aload_0
    //   339: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   342: ifne +157 -> 499
    //   345: iload_2
    //   346: istore_3
    //   347: aload_0
    //   348: getfield 706	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   351: ifeq +77 -> 428
    //   354: iload_2
    //   355: istore_3
    //   356: iload_2
    //   357: ifne +11 -> 368
    //   360: aload_0
    //   361: iconst_1
    //   362: iload 4
    //   364: invokespecial 887	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   367: istore_3
    //   368: aload_0
    //   369: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   372: astore 21
    //   374: iload_3
    //   375: ifeq +2961 -> 3336
    //   378: iconst_1
    //   379: istore_1
    //   380: aload 21
    //   382: iload_1
    //   383: invokevirtual 914	com/tencent/smtt/sdk/TbsLogReport:setUnpkgFlag	(I)V
    //   386: iload 4
    //   388: ifne +2958 -> 3346
    //   391: aload_0
    //   392: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   395: astore 21
    //   397: iload_3
    //   398: ifeq +2943 -> 3341
    //   401: iconst_1
    //   402: istore_1
    //   403: aload 21
    //   405: iload_1
    //   406: invokevirtual 917	com/tencent/smtt/sdk/TbsLogReport:setPatchUpdateFlag	(I)V
    //   409: iload_3
    //   410: ifeq +2947 -> 3357
    //   413: aload_0
    //   414: iconst_1
    //   415: invokespecial 883	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   418: aload_0
    //   419: bipush 100
    //   421: ldc_w 919
    //   424: iconst_1
    //   425: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   428: aload_0
    //   429: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   432: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   435: astore 21
    //   437: iload_3
    //   438: ifeq +2928 -> 3366
    //   441: aload 21
    //   443: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   446: ldc_w 921
    //   449: iconst_0
    //   450: invokeinterface 284 3 0
    //   455: istore_1
    //   456: aload 21
    //   458: getfield 487	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   461: ldc_w 921
    //   464: iload_1
    //   465: iconst_1
    //   466: iadd
    //   467: invokestatic 812	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   470: invokeinterface 501 3 0
    //   475: pop
    //   476: aload 21
    //   478: invokevirtual 504	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   481: aload_0
    //   482: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   485: astore 21
    //   487: iload_3
    //   488: ifeq +2939 -> 3427
    //   491: iconst_1
    //   492: istore_1
    //   493: aload 21
    //   495: iload_1
    //   496: invokevirtual 924	com/tencent/smtt/sdk/TbsLogReport:setDownFinalFlag	(I)V
    //   499: aload_0
    //   500: invokespecial 926	com/tencent/smtt/sdk/TbsApkDownloader:closeHttpRequest	()V
    //   503: return
    //   504: iload_3
    //   505: istore_2
    //   506: aload_0
    //   507: getfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   510: bipush 8
    //   512: if_icmpgt -174 -> 338
    //   515: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   518: lstore 7
    //   520: lload 7
    //   522: aload_0
    //   523: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   526: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   529: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   532: ldc_w 928
    //   535: lconst_0
    //   536: invokeinterface 784 4 0
    //   541: lsub
    //   542: ldc2_w 19
    //   545: lcmp
    //   546: ifle +126 -> 672
    //   549: ldc 214
    //   551: ldc_w 930
    //   554: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   561: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   564: getfield 487	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   567: ldc_w 928
    //   570: lload 7
    //   572: invokestatic 933	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   575: invokeinterface 501 3 0
    //   580: pop
    //   581: aload_0
    //   582: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   585: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   588: getfield 487	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   591: ldc_w 935
    //   594: lconst_0
    //   595: invokestatic 933	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   598: invokeinterface 501 3 0
    //   603: pop
    //   604: aload_0
    //   605: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   608: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   611: invokevirtual 504	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   614: aload_0
    //   615: invokevirtual 937	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   618: ifne +123 -> 741
    //   621: ldc 214
    //   623: ldc_w 939
    //   626: iconst_1
    //   627: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   630: iload_3
    //   631: istore_2
    //   632: goto -294 -> 338
    //   635: astore 21
    //   637: aload 21
    //   639: invokevirtual 472	java/lang/Throwable:printStackTrace	()V
    //   642: aload_0
    //   643: lconst_0
    //   644: invokespecial 941	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   647: aload_0
    //   648: bipush 107
    //   650: aload_0
    //   651: aload 21
    //   653: invokespecial 819	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   656: iconst_0
    //   657: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   660: aload_0
    //   661: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   664: ifeq -336 -> 328
    //   667: iload_3
    //   668: istore_2
    //   669: goto -331 -> 338
    //   672: aload_0
    //   673: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   676: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   679: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   682: ldc_w 935
    //   685: lconst_0
    //   686: invokeinterface 784 4 0
    //   691: lstore 5
    //   693: ldc 214
    //   695: new 136	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 943
    //   705: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: lload 5
    //   710: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   713: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: lload 5
    //   721: lload 19
    //   723: lcmp
    //   724: iflt -110 -> 614
    //   727: ldc 214
    //   729: ldc_w 945
    //   732: iconst_1
    //   733: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   736: iload_3
    //   737: istore_2
    //   738: goto -400 -> 338
    //   741: iload_3
    //   742: istore_2
    //   743: aload_0
    //   744: invokevirtual 947	com/tencent/smtt/sdk/TbsApkDownloader:hasSameTbsDownloading	()Z
    //   747: ifne -409 -> 338
    //   750: new 136	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   757: aload_0
    //   758: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   761: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   764: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   767: ldc_w 278
    //   770: iconst_0
    //   771: invokeinterface 284 3 0
    //   776: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   779: ldc_w 289
    //   782: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: lload 7
    //   787: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: astore 21
    //   795: aload_0
    //   796: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   799: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   802: aload_0
    //   803: getfield 150	com/tencent/smtt/sdk/TbsApkDownloader:mLocalDownloadingKey	Ljava/lang/String;
    //   806: aload 21
    //   808: invokestatic 299	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   811: pop
    //   812: aload_0
    //   813: iconst_1
    //   814: putfield 304	com/tencent/smtt/sdk/TbsApkDownloader:mNeedDownloadStat	Z
    //   817: aload_0
    //   818: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   821: ifnull +716 -> 1537
    //   824: aload_0
    //   825: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   828: astore 21
    //   830: aload 21
    //   832: aload_0
    //   833: getfield 949	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   836: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   839: ifne +12 -> 851
    //   842: aload_0
    //   843: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   846: aload 21
    //   848: invokevirtual 952	com/tencent/smtt/sdk/TbsLogReport:setDownloadUrl	(Ljava/lang/String;)V
    //   851: aload_0
    //   852: aload 21
    //   854: putfield 949	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   857: aload_0
    //   858: aload 21
    //   860: invokespecial 954	com/tencent/smtt/sdk/TbsApkDownloader:initHttpRequest	(Ljava/lang/String;)V
    //   863: lconst_0
    //   864: lstore 5
    //   866: aload_0
    //   867: getfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   870: ifne +108 -> 978
    //   873: aload_0
    //   874: invokespecial 956	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   877: lstore 5
    //   879: ldc 214
    //   881: new 136	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 958
    //   891: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: lload 5
    //   896: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   899: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload_0
    //   906: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   909: lconst_0
    //   910: lcmp
    //   911: ifgt +635 -> 1546
    //   914: ldc 214
    //   916: new 136	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 960
    //   926: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: lload 5
    //   931: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   934: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: iconst_1
    //   938: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   941: aload_0
    //   942: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   945: ldc_w 962
    //   948: new 136	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   955: ldc_w 964
    //   958: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: lload 5
    //   963: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   966: ldc_w 966
    //   969: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokevirtual 633	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   978: aload_0
    //   979: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   982: astore 21
    //   984: lload 5
    //   986: lconst_0
    //   987: lcmp
    //   988: ifne +2457 -> 3445
    //   991: iconst_0
    //   992: istore_1
    //   993: aload 21
    //   995: iload_1
    //   996: invokevirtual 969	com/tencent/smtt/sdk/TbsLogReport:setDownloadCancel	(I)V
    //   999: aload_0
    //   1000: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1003: invokestatic 324	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1006: istore_1
    //   1007: aload_0
    //   1008: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1011: invokestatic 320	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1014: astore 21
    //   1016: aload_0
    //   1017: getfield 171	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1020: ifnonnull +613 -> 1633
    //   1023: aload_0
    //   1024: getfield 173	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1027: iconst_m1
    //   1028: if_icmpne +605 -> 1633
    //   1031: aload_0
    //   1032: aload 21
    //   1034: putfield 171	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1037: aload_0
    //   1038: iload_1
    //   1039: putfield 173	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1042: aload_0
    //   1043: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   1046: iconst_1
    //   1047: if_icmplt +17 -> 1064
    //   1050: aload_0
    //   1051: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1054: ldc_w 971
    //   1057: aload_0
    //   1058: getfield 893	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   1061: invokevirtual 974	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1064: aload_0
    //   1065: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1068: invokevirtual 437	java/net/HttpURLConnection:getResponseCode	()I
    //   1071: istore_1
    //   1072: ldc 214
    //   1074: new 136	java/lang/StringBuilder
    //   1077: dup
    //   1078: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1081: ldc_w 976
    //   1084: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: iload_1
    //   1088: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1091: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1097: aload_0
    //   1098: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1101: iload_1
    //   1102: invokevirtual 979	com/tencent/smtt/sdk/TbsLogReport:setHttpCode	(I)V
    //   1105: aload_0
    //   1106: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1109: invokestatic 324	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1112: iconst_3
    //   1113: if_icmpeq +9 -> 1122
    //   1116: invokestatic 982	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1119: ifeq +13 -> 1132
    //   1122: aload_0
    //   1123: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1126: invokestatic 324	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1129: ifne +32 -> 1161
    //   1132: aload_0
    //   1133: invokevirtual 834	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   1136: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1139: ifnull +13 -> 1152
    //   1142: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1145: bipush 111
    //   1147: invokeinterface 371 2 0
    //   1152: ldc 214
    //   1154: ldc_w 984
    //   1157: iconst_0
    //   1158: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1161: new 136	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1168: getstatic 989	com/tencent/smtt/sdk/WebView:TBS_DEBUG_INSTALL_ONLINE	Ljava/lang/String;
    //   1171: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: aload_0
    //   1175: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1178: invokevirtual 145	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1181: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: astore 33
    //   1189: getstatic 992	com/tencent/smtt/sdk/QbSdk:mTbsDebugInstallOnline	Z
    //   1192: istore_2
    //   1193: iload_2
    //   1194: ifne +109 -> 1303
    //   1197: aconst_null
    //   1198: astore 21
    //   1200: aload_0
    //   1201: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1204: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1207: aload 33
    //   1209: invokestatic 852	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   1212: astore 22
    //   1214: aload 22
    //   1216: astore 21
    //   1218: aload 21
    //   1220: ifnull +83 -> 1303
    //   1223: aload 21
    //   1225: ldc_w 994
    //   1228: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1231: ifeq +72 -> 1303
    //   1234: ldc 214
    //   1236: ldc_w 996
    //   1239: invokestatic 587	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1242: ldc2_w 997
    //   1245: invokestatic 715	java/lang/Thread:sleep	(J)V
    //   1248: aload_0
    //   1249: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1252: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1255: aload 33
    //   1257: invokestatic 852	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   1260: astore 21
    //   1262: aload 21
    //   1264: ifnull +426 -> 1690
    //   1267: aload 21
    //   1269: ldc_w 994
    //   1272: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1275: ifeq +415 -> 1690
    //   1278: aload_0
    //   1279: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1282: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1285: aload 33
    //   1287: ldc_w 1000
    //   1290: invokestatic 299	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   1293: pop
    //   1294: ldc 214
    //   1296: ldc_w 1002
    //   1299: iconst_1
    //   1300: invokestatic 1004	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1303: iload_3
    //   1304: istore_2
    //   1305: aload_0
    //   1306: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   1309: ifne -971 -> 338
    //   1312: iload_1
    //   1313: sipush 200
    //   1316: if_icmpeq +10 -> 1326
    //   1319: iload_1
    //   1320: sipush 206
    //   1323: if_icmpne +1763 -> 3086
    //   1326: aload_0
    //   1327: aload_0
    //   1328: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1331: invokevirtual 1007	java/net/HttpURLConnection:getContentLength	()I
    //   1334: i2l
    //   1335: lload 5
    //   1337: ladd
    //   1338: putfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1341: ldc 214
    //   1343: new 136	java/lang/StringBuilder
    //   1346: dup
    //   1347: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1350: ldc_w 1009
    //   1353: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: aload_0
    //   1357: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1360: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 247	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: aload_0
    //   1370: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1373: aload_0
    //   1374: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1377: invokevirtual 1012	com/tencent/smtt/sdk/TbsLogReport:setPkgSize	(J)V
    //   1380: aload_0
    //   1381: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1384: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1387: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1390: ldc_w 780
    //   1393: lconst_0
    //   1394: invokeinterface 784 4 0
    //   1399: lstore 9
    //   1401: lload 9
    //   1403: lconst_0
    //   1404: lcmp
    //   1405: ifeq +326 -> 1731
    //   1408: aload_0
    //   1409: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1412: lload 9
    //   1414: lcmp
    //   1415: ifeq +316 -> 1731
    //   1418: ldc 214
    //   1420: new 136	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1427: ldc_w 1014
    //   1430: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: lload 9
    //   1435: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1438: ldc_w 1016
    //   1441: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: aload_0
    //   1445: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1448: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1451: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1454: iconst_1
    //   1455: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1458: aload_0
    //   1459: invokespecial 180	com/tencent/smtt/sdk/TbsApkDownloader:detectWifiNetworkAvailable	()Z
    //   1462: ifne +19 -> 1481
    //   1465: invokestatic 982	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1468: ifeq +248 -> 1716
    //   1471: aload_0
    //   1472: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1475: invokestatic 346	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1478: ifeq +238 -> 1716
    //   1481: aload_0
    //   1482: bipush 113
    //   1484: new 136	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1491: ldc_w 1018
    //   1494: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: lload 9
    //   1499: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1502: ldc_w 1016
    //   1505: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: aload_0
    //   1509: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1512: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1515: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: iconst_1
    //   1519: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1522: iload_3
    //   1523: istore_2
    //   1524: goto -1186 -> 338
    //   1527: astore 21
    //   1529: aload 21
    //   1531: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   1534: goto -722 -> 812
    //   1537: aload_0
    //   1538: getfield 893	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   1541: astore 21
    //   1543: goto -713 -> 830
    //   1546: ldc 214
    //   1548: new 136	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1555: ldc_w 1020
    //   1558: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: lload 5
    //   1563: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1566: ldc_w 1022
    //   1569: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: aload_0
    //   1573: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1576: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1579: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1582: iconst_1
    //   1583: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1586: aload_0
    //   1587: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1590: ldc_w 962
    //   1593: new 136	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   1600: ldc_w 964
    //   1603: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: lload 5
    //   1608: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1611: ldc_w 966
    //   1614: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: aload_0
    //   1618: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1621: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1624: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: invokevirtual 633	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1630: goto -652 -> 978
    //   1633: iload_1
    //   1634: aload_0
    //   1635: getfield 173	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1638: if_icmpne +15 -> 1653
    //   1641: aload 21
    //   1643: aload_0
    //   1644: getfield 171	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1647: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1650: ifne -608 -> 1042
    //   1653: aload_0
    //   1654: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1657: iconst_0
    //   1658: invokevirtual 338	com/tencent/smtt/sdk/TbsLogReport:setNetworkChange	(I)V
    //   1661: aload_0
    //   1662: aload 21
    //   1664: putfield 171	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1667: aload_0
    //   1668: iload_1
    //   1669: putfield 173	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1672: goto -630 -> 1042
    //   1675: astore 22
    //   1677: aload 22
    //   1679: invokevirtual 872	java/lang/SecurityException:printStackTrace	()V
    //   1682: goto -464 -> 1218
    //   1685: astore 21
    //   1687: goto -1359 -> 328
    //   1690: aload_0
    //   1691: invokevirtual 834	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   1694: ldc 214
    //   1696: ldc_w 1024
    //   1699: iconst_1
    //   1700: invokestatic 1004	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1703: goto -400 -> 1303
    //   1706: astore 21
    //   1708: aload 21
    //   1710: invokevirtual 872	java/lang/SecurityException:printStackTrace	()V
    //   1713: goto -410 -> 1303
    //   1716: aload_0
    //   1717: bipush 101
    //   1719: ldc_w 1026
    //   1722: iconst_1
    //   1723: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1726: iload_3
    //   1727: istore_2
    //   1728: goto -1390 -> 338
    //   1731: aconst_null
    //   1732: astore 29
    //   1734: aconst_null
    //   1735: astore 30
    //   1737: aconst_null
    //   1738: astore 22
    //   1740: aconst_null
    //   1741: astore 28
    //   1743: aconst_null
    //   1744: astore 25
    //   1746: aconst_null
    //   1747: astore 31
    //   1749: aconst_null
    //   1750: astore 32
    //   1752: aconst_null
    //   1753: astore 21
    //   1755: aload 30
    //   1757: astore 26
    //   1759: aload 31
    //   1761: astore 24
    //   1763: aload 32
    //   1765: astore 27
    //   1767: aload_0
    //   1768: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1771: invokevirtual 434	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1774: astore 23
    //   1776: aload 23
    //   1778: ifnull +320 -> 2098
    //   1781: aload 30
    //   1783: astore 26
    //   1785: aload 23
    //   1787: astore 25
    //   1789: aload 31
    //   1791: astore 24
    //   1793: aload 23
    //   1795: astore 28
    //   1797: aload 32
    //   1799: astore 27
    //   1801: aload_0
    //   1802: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1805: invokevirtual 1029	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1808: astore 21
    //   1810: aload 21
    //   1812: ifnull +309 -> 2121
    //   1815: aload 30
    //   1817: astore 26
    //   1819: aload 23
    //   1821: astore 25
    //   1823: aload 31
    //   1825: astore 24
    //   1827: aload 23
    //   1829: astore 28
    //   1831: aload 32
    //   1833: astore 27
    //   1835: aload 21
    //   1837: ldc_w 1031
    //   1840: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1843: ifeq +278 -> 2121
    //   1846: aload 30
    //   1848: astore 26
    //   1850: aload 23
    //   1852: astore 25
    //   1854: aload 31
    //   1856: astore 24
    //   1858: aload 23
    //   1860: astore 28
    //   1862: aload 32
    //   1864: astore 27
    //   1866: new 1033	java/util/zip/GZIPInputStream
    //   1869: dup
    //   1870: aload 23
    //   1872: invokespecial 1034	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   1875: astore 21
    //   1877: lload 5
    //   1879: lstore 9
    //   1881: lload 5
    //   1883: lstore 11
    //   1885: aload 30
    //   1887: astore 26
    //   1889: aload 23
    //   1891: astore 25
    //   1893: aload 21
    //   1895: astore 24
    //   1897: aload 23
    //   1899: astore 28
    //   1901: aload 21
    //   1903: astore 27
    //   1905: sipush 8192
    //   1908: newarray byte
    //   1910: astore 31
    //   1912: aload 30
    //   1914: astore 26
    //   1916: aload 23
    //   1918: astore 25
    //   1920: aload 21
    //   1922: astore 24
    //   1924: aload 23
    //   1926: astore 28
    //   1928: aload 21
    //   1930: astore 27
    //   1932: new 1036	java/io/FileOutputStream
    //   1935: dup
    //   1936: new 193	java/io/File
    //   1939: dup
    //   1940: aload_0
    //   1941: getfield 161	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   1944: ldc 41
    //   1946: invokespecial 233	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1949: iconst_1
    //   1950: invokespecial 1039	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1953: astore 22
    //   1955: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   1958: lstore 13
    //   1960: lload 9
    //   1962: lstore 5
    //   1964: lload 11
    //   1966: lstore 9
    //   1968: getstatic 992	com/tencent/smtt/sdk/QbSdk:mTbsDebugInstallOnline	Z
    //   1971: istore_2
    //   1972: iload_2
    //   1973: ifne +109 -> 2082
    //   1976: aconst_null
    //   1977: astore 24
    //   1979: aload_0
    //   1980: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1983: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1986: aload 33
    //   1988: invokestatic 852	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   1991: astore 25
    //   1993: aload 25
    //   1995: astore 24
    //   1997: aload 24
    //   1999: ifnull +83 -> 2082
    //   2002: aload 24
    //   2004: ldc_w 994
    //   2007: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2010: istore_2
    //   2011: iload_2
    //   2012: ifeq +70 -> 2082
    //   2015: ldc2_w 997
    //   2018: invokestatic 715	java/lang/Thread:sleep	(J)V
    //   2021: aload_0
    //   2022: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2025: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2028: aload 33
    //   2030: invokestatic 852	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   2033: astore 25
    //   2035: aload 25
    //   2037: astore 24
    //   2039: aload 24
    //   2041: ifnull +381 -> 2422
    //   2044: aload 24
    //   2046: ldc_w 994
    //   2049: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2052: istore_2
    //   2053: iload_2
    //   2054: ifeq +368 -> 2422
    //   2057: aload_0
    //   2058: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2061: invokevirtual 293	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2064: aload 33
    //   2066: ldc_w 1000
    //   2069: invokestatic 299	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   2072: pop
    //   2073: ldc 214
    //   2075: ldc_w 1041
    //   2078: iconst_1
    //   2079: invokestatic 1004	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2082: aload_0
    //   2083: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   2086: ifeq +352 -> 2438
    //   2089: ldc 214
    //   2091: ldc_w 1043
    //   2094: iconst_1
    //   2095: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2098: aload_0
    //   2099: aload 22
    //   2101: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2104: aload_0
    //   2105: aload 21
    //   2107: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2110: aload_0
    //   2111: aload 23
    //   2113: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2116: iload_3
    //   2117: istore_2
    //   2118: goto -1780 -> 338
    //   2121: aload 21
    //   2123: ifnull +76 -> 2199
    //   2126: aload 30
    //   2128: astore 26
    //   2130: aload 23
    //   2132: astore 25
    //   2134: aload 31
    //   2136: astore 24
    //   2138: aload 23
    //   2140: astore 28
    //   2142: aload 32
    //   2144: astore 27
    //   2146: aload 21
    //   2148: ldc_w 1045
    //   2151: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2154: ifeq +45 -> 2199
    //   2157: aload 30
    //   2159: astore 26
    //   2161: aload 23
    //   2163: astore 25
    //   2165: aload 31
    //   2167: astore 24
    //   2169: aload 23
    //   2171: astore 28
    //   2173: aload 32
    //   2175: astore 27
    //   2177: new 1047	java/util/zip/InflaterInputStream
    //   2180: dup
    //   2181: aload 23
    //   2183: new 1049	java/util/zip/Inflater
    //   2186: dup
    //   2187: iconst_1
    //   2188: invokespecial 1051	java/util/zip/Inflater:<init>	(Z)V
    //   2191: invokespecial 1054	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   2194: astore 21
    //   2196: goto -319 -> 1877
    //   2199: aload 23
    //   2201: astore 21
    //   2203: goto -326 -> 1877
    //   2206: astore 25
    //   2208: aload 25
    //   2210: invokevirtual 872	java/lang/SecurityException:printStackTrace	()V
    //   2213: goto -216 -> 1997
    //   2216: astore 24
    //   2218: aload 21
    //   2220: astore 27
    //   2222: aload 22
    //   2224: astore 21
    //   2226: aload 24
    //   2228: astore 22
    //   2230: aload 21
    //   2232: astore 26
    //   2234: aload 23
    //   2236: astore 25
    //   2238: aload 27
    //   2240: astore 24
    //   2242: aload 22
    //   2244: invokevirtual 1055	java/io/IOException:printStackTrace	()V
    //   2247: aload 21
    //   2249: astore 26
    //   2251: aload 23
    //   2253: astore 25
    //   2255: aload 27
    //   2257: astore 24
    //   2259: aload 22
    //   2261: instanceof 1057
    //   2264: ifne +23 -> 2287
    //   2267: aload 21
    //   2269: astore 26
    //   2271: aload 23
    //   2273: astore 25
    //   2275: aload 27
    //   2277: astore 24
    //   2279: aload 22
    //   2281: instanceof 1059
    //   2284: ifeq +562 -> 2846
    //   2287: aload 21
    //   2289: astore 26
    //   2291: aload 23
    //   2293: astore 25
    //   2295: aload 27
    //   2297: astore 24
    //   2299: aload_0
    //   2300: ldc_w 1060
    //   2303: putfield 111	com/tencent/smtt/sdk/TbsApkDownloader:mReadTimeout	I
    //   2306: aload 21
    //   2308: astore 26
    //   2310: aload 23
    //   2312: astore 25
    //   2314: aload 27
    //   2316: astore 24
    //   2318: aload_0
    //   2319: aload_0
    //   2320: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   2323: iconst_1
    //   2324: iadd
    //   2325: putfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   2328: aload 21
    //   2330: astore 26
    //   2332: aload 23
    //   2334: astore 25
    //   2336: aload 27
    //   2338: astore 24
    //   2340: aload_0
    //   2341: bipush 103
    //   2343: aload_0
    //   2344: aload 22
    //   2346: invokespecial 819	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2349: iconst_0
    //   2350: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2353: aload_0
    //   2354: aload 21
    //   2356: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2359: aload_0
    //   2360: aload 27
    //   2362: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2365: aload_0
    //   2366: aload 23
    //   2368: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2371: goto -2043 -> 328
    //   2374: astore 24
    //   2376: goto -408 -> 1968
    //   2379: astore 25
    //   2381: aload 25
    //   2383: invokevirtual 872	java/lang/SecurityException:printStackTrace	()V
    //   2386: goto -347 -> 2039
    //   2389: astore 24
    //   2391: aload_0
    //   2392: aload 22
    //   2394: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2397: aload_0
    //   2398: aload 21
    //   2400: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2403: aload_0
    //   2404: aload 23
    //   2406: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2409: aload 24
    //   2411: athrow
    //   2412: astore 24
    //   2414: aload 24
    //   2416: invokevirtual 872	java/lang/SecurityException:printStackTrace	()V
    //   2419: goto -337 -> 2082
    //   2422: aload_0
    //   2423: invokevirtual 834	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   2426: ldc 214
    //   2428: ldc_w 1062
    //   2431: iconst_1
    //   2432: invokestatic 1004	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2435: goto -353 -> 2082
    //   2438: aload 21
    //   2440: aload 31
    //   2442: iconst_0
    //   2443: sipush 8192
    //   2446: invokevirtual 1068	java/io/InputStream:read	([BII)I
    //   2449: istore_1
    //   2450: iload_1
    //   2451: ifgt +11 -> 2462
    //   2454: aload_0
    //   2455: iconst_1
    //   2456: putfield 706	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   2459: goto -361 -> 2098
    //   2462: aload 22
    //   2464: aload 31
    //   2466: iconst_0
    //   2467: iload_1
    //   2468: invokevirtual 1072	java/io/FileOutputStream:write	([BII)V
    //   2471: aload 22
    //   2473: invokevirtual 1075	java/io/FileOutputStream:flush	()V
    //   2476: aload_0
    //   2477: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2480: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2483: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2486: ldc_w 935
    //   2489: lconst_0
    //   2490: invokeinterface 784 4 0
    //   2495: iload_1
    //   2496: i2l
    //   2497: ladd
    //   2498: lstore 11
    //   2500: aload_0
    //   2501: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2504: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2507: getfield 487	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2510: ldc_w 935
    //   2513: lload 11
    //   2515: invokestatic 933	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2518: invokeinterface 501 3 0
    //   2523: pop
    //   2524: aload_0
    //   2525: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2528: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2531: invokevirtual 504	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2534: lload 11
    //   2536: lload 19
    //   2538: lcmp
    //   2539: iflt +23 -> 2562
    //   2542: ldc 214
    //   2544: ldc_w 945
    //   2547: iconst_1
    //   2548: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2551: aload_0
    //   2552: bipush 112
    //   2554: aconst_null
    //   2555: iconst_1
    //   2556: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2559: goto -461 -> 2098
    //   2562: aload_0
    //   2563: invokevirtual 937	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   2566: ifne +70 -> 2636
    //   2569: ldc 214
    //   2571: ldc_w 1077
    //   2574: iconst_1
    //   2575: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2578: aload_0
    //   2579: bipush 105
    //   2581: new 136	java/lang/StringBuilder
    //   2584: dup
    //   2585: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   2588: ldc_w 1079
    //   2591: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2594: aload_0
    //   2595: getfield 161	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   2598: invokevirtual 515	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2601: invokestatic 841	com/tencent/smtt/utils/FileUtil:getFreeSpace	(Ljava/lang/String;)J
    //   2604: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2607: ldc_w 1081
    //   2610: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2613: aload_0
    //   2614: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2617: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2620: invokevirtual 844	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   2623: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2626: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2629: iconst_1
    //   2630: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2633: goto -535 -> 2098
    //   2636: aload_0
    //   2637: lload 7
    //   2639: iload_1
    //   2640: i2l
    //   2641: invokespecial 1083	com/tencent/smtt/sdk/TbsApkDownloader:saveDownloadDataStat	(JJ)J
    //   2644: lstore 15
    //   2646: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   2649: lstore 17
    //   2651: lload 9
    //   2653: iload_1
    //   2654: i2l
    //   2655: ladd
    //   2656: lstore 11
    //   2658: lload 11
    //   2660: lstore 9
    //   2662: lload 15
    //   2664: lstore 7
    //   2666: lload 17
    //   2668: lload 13
    //   2670: lsub
    //   2671: ldc2_w 1084
    //   2674: lcmp
    //   2675: ifle -707 -> 1968
    //   2678: ldc 214
    //   2680: new 136	java/lang/StringBuilder
    //   2683: dup
    //   2684: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   2687: ldc_w 1087
    //   2690: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: lload 11
    //   2695: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2698: ldc_w 1022
    //   2701: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2704: aload_0
    //   2705: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2708: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2711: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2714: iconst_1
    //   2715: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2718: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2721: ifnull +27 -> 2748
    //   2724: lload 11
    //   2726: l2d
    //   2727: aload_0
    //   2728: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2731: l2d
    //   2732: ddiv
    //   2733: ldc2_w 1088
    //   2736: dmul
    //   2737: d2i
    //   2738: istore_1
    //   2739: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2742: iload_1
    //   2743: invokeinterface 1092 2 0
    //   2748: lload 5
    //   2750: lstore 7
    //   2752: lload 11
    //   2754: lload 5
    //   2756: lsub
    //   2757: ldc2_w 34
    //   2760: lcmp
    //   2761: ifle +66 -> 2827
    //   2764: lload 11
    //   2766: lstore 7
    //   2768: aload_0
    //   2769: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2772: invokestatic 324	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2775: iconst_3
    //   2776: if_icmpeq +9 -> 2785
    //   2779: invokestatic 982	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2782: ifeq +13 -> 2795
    //   2785: aload_0
    //   2786: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2789: invokestatic 324	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2792: ifne +35 -> 2827
    //   2795: aload_0
    //   2796: invokevirtual 834	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   2799: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2802: ifnull +13 -> 2815
    //   2805: getstatic 366	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2808: bipush 111
    //   2810: invokeinterface 371 2 0
    //   2815: ldc 214
    //   2817: ldc_w 1094
    //   2820: iconst_0
    //   2821: invokestatic 908	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2824: goto -726 -> 2098
    //   2827: lload 17
    //   2829: lstore 13
    //   2831: lload 11
    //   2833: lstore 9
    //   2835: lload 7
    //   2837: lstore 5
    //   2839: lload 15
    //   2841: lstore 7
    //   2843: goto -875 -> 1968
    //   2846: aload 21
    //   2848: astore 26
    //   2850: aload 23
    //   2852: astore 25
    //   2854: aload 27
    //   2856: astore 24
    //   2858: aload_0
    //   2859: invokevirtual 937	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   2862: ifne +93 -> 2955
    //   2865: aload 21
    //   2867: astore 26
    //   2869: aload 23
    //   2871: astore 25
    //   2873: aload 27
    //   2875: astore 24
    //   2877: aload_0
    //   2878: bipush 105
    //   2880: new 136	java/lang/StringBuilder
    //   2883: dup
    //   2884: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   2887: ldc_w 1079
    //   2890: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: aload_0
    //   2894: getfield 161	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   2897: invokevirtual 515	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2900: invokestatic 841	com/tencent/smtt/utils/FileUtil:getFreeSpace	(Ljava/lang/String;)J
    //   2903: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2906: ldc_w 1081
    //   2909: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2912: aload_0
    //   2913: getfield 121	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2916: invokestatic 272	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2919: invokevirtual 844	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   2922: invokevirtual 791	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2925: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2928: iconst_1
    //   2929: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2932: aload_0
    //   2933: aload 21
    //   2935: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2938: aload_0
    //   2939: aload 27
    //   2941: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2944: aload_0
    //   2945: aload 23
    //   2947: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2950: iload_3
    //   2951: istore_2
    //   2952: goto -2614 -> 338
    //   2955: aload 21
    //   2957: astore 26
    //   2959: aload 23
    //   2961: astore 25
    //   2963: aload 27
    //   2965: astore 24
    //   2967: aload_0
    //   2968: lconst_0
    //   2969: invokespecial 941	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   2972: aload 21
    //   2974: astore 26
    //   2976: aload 23
    //   2978: astore 25
    //   2980: aload 27
    //   2982: astore 24
    //   2984: aload_0
    //   2985: invokespecial 1096	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileExists	()Z
    //   2988: ifne +49 -> 3037
    //   2991: aload 21
    //   2993: astore 26
    //   2995: aload 23
    //   2997: astore 25
    //   2999: aload 27
    //   3001: astore 24
    //   3003: aload_0
    //   3004: bipush 106
    //   3006: aload_0
    //   3007: aload 22
    //   3009: invokespecial 819	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3012: iconst_0
    //   3013: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3016: aload_0
    //   3017: aload 21
    //   3019: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3022: aload_0
    //   3023: aload 27
    //   3025: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3028: aload_0
    //   3029: aload 23
    //   3031: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3034: goto -2706 -> 328
    //   3037: aload 21
    //   3039: astore 26
    //   3041: aload 23
    //   3043: astore 25
    //   3045: aload 27
    //   3047: astore 24
    //   3049: aload_0
    //   3050: bipush 104
    //   3052: aload_0
    //   3053: aload 22
    //   3055: invokespecial 819	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3058: iconst_0
    //   3059: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3062: goto -46 -> 3016
    //   3065: astore 27
    //   3067: aload 26
    //   3069: astore 22
    //   3071: aload 25
    //   3073: astore 23
    //   3075: aload 24
    //   3077: astore 21
    //   3079: aload 27
    //   3081: astore 24
    //   3083: goto -692 -> 2391
    //   3086: iload_1
    //   3087: sipush 300
    //   3090: if_icmplt +51 -> 3141
    //   3093: iload_1
    //   3094: sipush 307
    //   3097: if_icmpgt +44 -> 3141
    //   3100: aload_0
    //   3101: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   3104: ldc_w 1098
    //   3107: invokevirtual 1102	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3110: astore 21
    //   3112: iload_3
    //   3113: istore_2
    //   3114: aload 21
    //   3116: invokestatic 445	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3119: ifne -2781 -> 338
    //   3122: aload_0
    //   3123: aload 21
    //   3125: putfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   3128: aload_0
    //   3129: aload_0
    //   3130: getfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   3133: iconst_1
    //   3134: iadd
    //   3135: putfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   3138: goto -2810 -> 328
    //   3141: aload_0
    //   3142: bipush 102
    //   3144: aconst_null
    //   3145: iconst_0
    //   3146: invokespecial 350	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3149: iload_1
    //   3150: sipush 416
    //   3153: if_icmpne +297 -> 3450
    //   3156: aload_0
    //   3157: iconst_1
    //   3158: iload 4
    //   3160: invokespecial 887	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   3163: ifeq +8 -> 3171
    //   3166: iconst_1
    //   3167: istore_2
    //   3168: goto -2830 -> 338
    //   3171: aload_0
    //   3172: iconst_0
    //   3173: invokespecial 836	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   3176: pop
    //   3177: iload_3
    //   3178: istore_2
    //   3179: goto -2841 -> 338
    //   3182: iload_3
    //   3183: istore_2
    //   3184: aload_0
    //   3185: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   3188: ldc2_w 697
    //   3191: lcmp
    //   3192: ifeq -2854 -> 338
    //   3195: iload_1
    //   3196: sipush 202
    //   3199: if_icmpeq -2871 -> 328
    //   3202: aload_0
    //   3203: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   3206: iconst_5
    //   3207: if_icmpge +39 -> 3246
    //   3210: iload_1
    //   3211: sipush 503
    //   3214: if_icmpne +32 -> 3246
    //   3217: aload_0
    //   3218: aload_0
    //   3219: getfield 249	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   3222: ldc_w 1104
    //   3225: invokevirtual 1102	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3228: invokestatic 863	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3231: invokespecial 941	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   3234: aload_0
    //   3235: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   3238: ifeq -2910 -> 328
    //   3241: iload_3
    //   3242: istore_2
    //   3243: goto -2905 -> 338
    //   3246: aload_0
    //   3247: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   3250: iconst_5
    //   3251: if_icmpge +48 -> 3299
    //   3254: iload_1
    //   3255: sipush 408
    //   3258: if_icmpeq +24 -> 3282
    //   3261: iload_1
    //   3262: sipush 504
    //   3265: if_icmpeq +17 -> 3282
    //   3268: iload_1
    //   3269: sipush 502
    //   3272: if_icmpeq +10 -> 3282
    //   3275: iload_1
    //   3276: sipush 408
    //   3279: if_icmpne +20 -> 3299
    //   3282: aload_0
    //   3283: lconst_0
    //   3284: invokespecial 941	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   3287: aload_0
    //   3288: getfield 251	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   3291: ifeq -2963 -> 328
    //   3294: iload_3
    //   3295: istore_2
    //   3296: goto -2958 -> 338
    //   3299: iload_3
    //   3300: istore_2
    //   3301: aload_0
    //   3302: invokespecial 956	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   3305: lconst_0
    //   3306: lcmp
    //   3307: ifgt -2969 -> 338
    //   3310: iload_3
    //   3311: istore_2
    //   3312: aload_0
    //   3313: getfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   3316: ifne -2978 -> 338
    //   3319: iload_3
    //   3320: istore_2
    //   3321: iload_1
    //   3322: sipush 410
    //   3325: if_icmpeq -2987 -> 338
    //   3328: aload_0
    //   3329: iconst_1
    //   3330: putfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   3333: goto -3005 -> 328
    //   3336: iconst_0
    //   3337: istore_1
    //   3338: goto -2958 -> 380
    //   3341: iconst_2
    //   3342: istore_1
    //   3343: goto -2940 -> 403
    //   3346: aload_0
    //   3347: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3350: iconst_0
    //   3351: invokevirtual 917	com/tencent/smtt/sdk/TbsLogReport:setPatchUpdateFlag	(I)V
    //   3354: goto -2945 -> 409
    //   3357: aload_0
    //   3358: iconst_0
    //   3359: invokespecial 836	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   3362: pop
    //   3363: goto -2935 -> 428
    //   3366: aload 21
    //   3368: getfield 276	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3371: ldc_w 1106
    //   3374: iconst_0
    //   3375: invokeinterface 284 3 0
    //   3380: istore_1
    //   3381: aload 21
    //   3383: getfield 487	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3386: astore 22
    //   3388: iload_1
    //   3389: iconst_1
    //   3390: iadd
    //   3391: istore_1
    //   3392: aload 22
    //   3394: ldc_w 1106
    //   3397: iload_1
    //   3398: invokestatic 812	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3401: invokeinterface 501 3 0
    //   3406: pop
    //   3407: iload_1
    //   3408: aload 21
    //   3410: invokevirtual 1109	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   3413: if_icmpne -2937 -> 476
    //   3416: aload_0
    //   3417: getfield 129	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3420: iconst_2
    //   3421: invokevirtual 969	com/tencent/smtt/sdk/TbsLogReport:setDownloadCancel	(I)V
    //   3424: goto -2948 -> 476
    //   3427: iconst_0
    //   3428: istore_1
    //   3429: goto -2936 -> 493
    //   3432: astore 22
    //   3434: aload 29
    //   3436: astore 21
    //   3438: aload 28
    //   3440: astore 23
    //   3442: goto -1212 -> 2230
    //   3445: iconst_1
    //   3446: istore_1
    //   3447: goto -2454 -> 993
    //   3450: iload_1
    //   3451: sipush 403
    //   3454: if_icmpeq -272 -> 3182
    //   3457: iload_1
    //   3458: sipush 406
    //   3461: if_icmpne -266 -> 3195
    //   3464: goto -282 -> 3182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3467	0	this	TbsApkDownloader
    //   33	3429	1	i	int
    //   337	2984	2	bool1	boolean
    //   327	2993	3	bool2	boolean
    //   45	3114	4	bool3	boolean
    //   691	2147	5	l1	long
    //   518	2324	7	l2	long
    //   1399	1435	9	l3	long
    //   1883	949	11	l4	long
    //   1958	872	13	l5	long
    //   2644	196	15	l6	long
    //   2649	179	17	l7	long
    //   324	2213	19	l8	long
    //   372	122	21	localObject1	Object
    //   635	17	21	localThrowable	Throwable
    //   793	475	21	localObject2	Object
    //   1527	3	21	localException1	Exception
    //   1541	122	21	str1	String
    //   1685	1	21	localException2	Exception
    //   1706	3	21	localSecurityException1	SecurityException
    //   1753	1684	21	localObject3	Object
    //   1212	3	22	str2	String
    //   1675	3	22	localSecurityException2	SecurityException
    //   1738	1655	22	localObject4	Object
    //   3432	1	22	localIOException1	IOException
    //   1774	1667	23	localObject5	Object
    //   1761	407	24	localObject6	Object
    //   2216	11	24	localIOException2	IOException
    //   2240	99	24	localObject7	Object
    //   2374	1	24	localException3	Exception
    //   2389	21	24	localObject8	Object
    //   2412	3	24	localSecurityException3	SecurityException
    //   2856	226	24	localObject9	Object
    //   1744	420	25	localObject10	Object
    //   2206	3	25	localSecurityException4	SecurityException
    //   2236	99	25	localObject11	Object
    //   2379	3	25	localSecurityException5	SecurityException
    //   2852	220	25	localObject12	Object
    //   1757	1311	26	localObject13	Object
    //   1765	1281	27	localObject14	Object
    //   3065	15	27	localObject15	Object
    //   1741	1698	28	localObject16	Object
    //   1732	1703	29	localObject17	Object
    //   1735	423	30	localObject18	Object
    //   1747	718	31	arrayOfByte	byte[]
    //   1750	424	32	localObject19	Object
    //   1187	878	33	str3	String
    // Exception table:
    //   from	to	target	type
    //   520	614	635	java/lang/Throwable
    //   614	630	635	java/lang/Throwable
    //   672	719	635	java/lang/Throwable
    //   727	736	635	java/lang/Throwable
    //   743	795	635	java/lang/Throwable
    //   795	812	635	java/lang/Throwable
    //   812	830	635	java/lang/Throwable
    //   830	851	635	java/lang/Throwable
    //   851	863	635	java/lang/Throwable
    //   866	978	635	java/lang/Throwable
    //   978	984	635	java/lang/Throwable
    //   993	1042	635	java/lang/Throwable
    //   1042	1064	635	java/lang/Throwable
    //   1064	1122	635	java/lang/Throwable
    //   1122	1132	635	java/lang/Throwable
    //   1132	1152	635	java/lang/Throwable
    //   1152	1161	635	java/lang/Throwable
    //   1161	1193	635	java/lang/Throwable
    //   1200	1214	635	java/lang/Throwable
    //   1223	1242	635	java/lang/Throwable
    //   1242	1248	635	java/lang/Throwable
    //   1248	1262	635	java/lang/Throwable
    //   1267	1303	635	java/lang/Throwable
    //   1305	1312	635	java/lang/Throwable
    //   1326	1401	635	java/lang/Throwable
    //   1408	1481	635	java/lang/Throwable
    //   1481	1522	635	java/lang/Throwable
    //   1529	1534	635	java/lang/Throwable
    //   1537	1543	635	java/lang/Throwable
    //   1546	1630	635	java/lang/Throwable
    //   1633	1653	635	java/lang/Throwable
    //   1653	1672	635	java/lang/Throwable
    //   1677	1682	635	java/lang/Throwable
    //   1690	1703	635	java/lang/Throwable
    //   1708	1713	635	java/lang/Throwable
    //   1716	1726	635	java/lang/Throwable
    //   2098	2116	635	java/lang/Throwable
    //   2353	2371	635	java/lang/Throwable
    //   2391	2412	635	java/lang/Throwable
    //   2932	2950	635	java/lang/Throwable
    //   3016	3034	635	java/lang/Throwable
    //   3100	3112	635	java/lang/Throwable
    //   3114	3138	635	java/lang/Throwable
    //   3141	3149	635	java/lang/Throwable
    //   3156	3166	635	java/lang/Throwable
    //   3171	3177	635	java/lang/Throwable
    //   3184	3195	635	java/lang/Throwable
    //   3202	3210	635	java/lang/Throwable
    //   3217	3241	635	java/lang/Throwable
    //   3246	3254	635	java/lang/Throwable
    //   3282	3294	635	java/lang/Throwable
    //   3301	3310	635	java/lang/Throwable
    //   3312	3319	635	java/lang/Throwable
    //   3328	3333	635	java/lang/Throwable
    //   795	812	1527	java/lang/Exception
    //   1200	1214	1675	java/lang/SecurityException
    //   1242	1248	1685	java/lang/Exception
    //   1248	1262	1706	java/lang/SecurityException
    //   1267	1303	1706	java/lang/SecurityException
    //   1690	1703	1706	java/lang/SecurityException
    //   1979	1993	2206	java/lang/SecurityException
    //   1955	1960	2216	java/io/IOException
    //   1968	1972	2216	java/io/IOException
    //   1979	1993	2216	java/io/IOException
    //   2002	2011	2216	java/io/IOException
    //   2015	2021	2216	java/io/IOException
    //   2021	2035	2216	java/io/IOException
    //   2044	2053	2216	java/io/IOException
    //   2057	2082	2216	java/io/IOException
    //   2082	2098	2216	java/io/IOException
    //   2208	2213	2216	java/io/IOException
    //   2381	2386	2216	java/io/IOException
    //   2414	2419	2216	java/io/IOException
    //   2422	2435	2216	java/io/IOException
    //   2438	2450	2216	java/io/IOException
    //   2454	2459	2216	java/io/IOException
    //   2462	2534	2216	java/io/IOException
    //   2542	2559	2216	java/io/IOException
    //   2562	2633	2216	java/io/IOException
    //   2636	2651	2216	java/io/IOException
    //   2678	2748	2216	java/io/IOException
    //   2768	2785	2216	java/io/IOException
    //   2785	2795	2216	java/io/IOException
    //   2795	2815	2216	java/io/IOException
    //   2815	2824	2216	java/io/IOException
    //   2015	2021	2374	java/lang/Exception
    //   2021	2035	2379	java/lang/SecurityException
    //   1955	1960	2389	finally
    //   1968	1972	2389	finally
    //   1979	1993	2389	finally
    //   2002	2011	2389	finally
    //   2015	2021	2389	finally
    //   2021	2035	2389	finally
    //   2044	2053	2389	finally
    //   2057	2082	2389	finally
    //   2082	2098	2389	finally
    //   2208	2213	2389	finally
    //   2381	2386	2389	finally
    //   2414	2419	2389	finally
    //   2422	2435	2389	finally
    //   2438	2450	2389	finally
    //   2454	2459	2389	finally
    //   2462	2534	2389	finally
    //   2542	2559	2389	finally
    //   2562	2633	2389	finally
    //   2636	2651	2389	finally
    //   2678	2748	2389	finally
    //   2768	2785	2389	finally
    //   2785	2795	2389	finally
    //   2795	2815	2389	finally
    //   2815	2824	2389	finally
    //   2057	2082	2412	java/lang/SecurityException
    //   1767	1776	3065	finally
    //   1801	1810	3065	finally
    //   1835	1846	3065	finally
    //   1866	1877	3065	finally
    //   1905	1912	3065	finally
    //   1932	1955	3065	finally
    //   2146	2157	3065	finally
    //   2177	2196	3065	finally
    //   2242	2247	3065	finally
    //   2259	2267	3065	finally
    //   2279	2287	3065	finally
    //   2299	2306	3065	finally
    //   2318	2328	3065	finally
    //   2340	2353	3065	finally
    //   2858	2865	3065	finally
    //   2877	2932	3065	finally
    //   2967	2972	3065	finally
    //   2984	2991	3065	finally
    //   3003	3016	3065	finally
    //   3049	3062	3065	finally
    //   1767	1776	3432	java/io/IOException
    //   1801	1810	3432	java/io/IOException
    //   1835	1846	3432	java/io/IOException
    //   1866	1877	3432	java/io/IOException
    //   1905	1912	3432	java/io/IOException
    //   1932	1955	3432	java/io/IOException
    //   2146	2157	3432	java/io/IOException
    //   2177	2196	3432	java/io/IOException
  }
  
  public void stopDownload()
  {
    this.mCanceled = true;
  }
  
  private static abstract interface Header
  {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String RANGE = "Range";
    public static final String REFERER = "Referer";
    public static final String USER_AGENT = "User-Agent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsApkDownloader
 * JD-Core Version:    0.7.0.1
 */