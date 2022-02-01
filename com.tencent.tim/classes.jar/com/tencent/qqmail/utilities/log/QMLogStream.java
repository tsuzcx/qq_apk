package com.tencent.qqmail.utilities.log;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedWriter;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class QMLogStream
{
  private static final String CGI_URL = "http://i.mail.qq.com/cgi-bin/app_data_report";
  private static final long FLUSH_INTERVAL = 10000L;
  private static final String KEY_ENABLE = "enable";
  private static final String LOG_PATH = QMApplicationContext.sharedInstance().getFilesDir().getAbsolutePath() + "/OtherLog.log";
  private static final int MAX_LOG_COUNT = 100;
  private static final String SP_NAME = "logstream_info";
  private static final String TAG = "QMLogStream";
  private static boolean cgiContiuneSubmitState = true;
  private static File sDir;
  private static boolean sEnable = true;
  private static Runnable sFlushTask;
  private static Handler sHandler;
  private static File sLogFile;
  private static Runnable sReportTask;
  private static Thread.UncaughtExceptionHandler sUncaughtExceptionHandler;
  private static BufferedWriter sWriter;
  private static String seperator = "x";
  
  static
  {
    sLogFile = new File(LOG_PATH);
    sDir = sLogFile.getParentFile();
    sFlushTask = new QMLogStream.1();
    sEnable = SPManager.getSp("logstream_info", true).getBoolean("enable", true);
    initThread();
    sUncaughtExceptionHandler = new QMLogStream.2();
    sReportTask = new QMLogStream.4();
  }
  
  private static void deleteLogFile()
  {
    new File(getLogPath()).delete();
  }
  
  public static boolean getEnable()
  {
    return sEnable;
  }
  
  private static String getLogPath()
  {
    return LOG_PATH;
  }
  
  private static void initThread()
  {
    if (sEnable)
    {
      HandlerThread localHandlerThread = new HandlerThread("submit_logstream_thread", 19);
      localHandlerThread.start();
      sHandler = new Handler(localHandlerThread.getLooper());
      sHandler.postDelayed(sFlushTask, 10000L);
      localHandlerThread.setUncaughtExceptionHandler(sUncaughtExceptionHandler);
    }
  }
  
  public static boolean isOtherProcessHandlingLogFile()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getBoolean("otherprocesshandlinglogfile", false);
  }
  
  public static void logWithoutUma(int paramInt, String paramString1, String paramString2)
  {
    saveLog(prepareLog(paramInt, paramString1, paramString2));
    QMLog.log(4, "QMLogStream", "logWithoutUma:" + paramInt + "," + paramString1);
  }
  
  public static void logWithoutUmaNow(int paramInt, String paramString1, String paramString2)
  {
    logWithoutUmaNow(paramInt, paramString1, paramString2, QMApplicationContext.sharedInstance().getVid(), QMApplicationContext.sharedInstance().getVidPwd());
  }
  
  public static void logWithoutUmaNow(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    saveLogSync(prepareLog(paramInt, paramString1, paramString2));
    postRemoteLog(paramLong, paramString3);
  }
  
  public static void logWithoutUmaOnCrash(int paramInt, String paramString1, String paramString2)
  {
    logWithoutUmaOnCrash(paramInt, paramString1, paramString2, QMApplicationContext.sharedInstance().getVid(), QMApplicationContext.sharedInstance().getVidPwd());
  }
  
  public static void logWithoutUmaOnCrash(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    logWithoutUmaNow(paramInt, paramString1, paramString2, paramLong, paramString3);
  }
  
  private static void postRemoteLog()
  {
    postRemoteLog(QMApplicationContext.sharedInstance().getVid(), QMApplicationContext.sharedInstance().getVidPwd());
  }
  
  public static void postRemoteLog(long paramLong, String paramString) {}
  
  private static String prepareLog(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      localObject = StringExtention.urlEncode(paramString1);
      paramString1 = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        String str;
        localStringBuilder1.append("phonetype=").append(StringExtention.urlEncode(DeviceUtil.getDeviceInfos().BRAND + " " + DeviceUtil.getDeviceInfos().MODEL));
        localStringBuilder1.append("&");
        localStringBuilder1.append("sysversion=android ").append(DeviceUtil.getDeviceInfos().releaseVersion);
        localStringBuilder1.append("&");
        localStringBuilder1.append("logtime=").append(new Date().getTime());
        localStringBuilder1.append("&");
        StringBuilder localStringBuilder2 = localStringBuilder1.append("itemname=");
        Object localObject = paramString2;
        if (paramString2 != null) {
          break label186;
        }
        localObject = "";
        label186:
        localStringBuilder2.append((String)localObject);
        localStringBuilder1.append("&");
        localStringBuilder1.append("errorno=").append(paramInt);
        localStringBuilder1.append("&");
        localObject = localStringBuilder1.append("errormsg=");
        paramString2 = paramString1;
        if (paramString1 != null) {
          break label243;
        }
        paramString2 = "";
        label243:
        ((StringBuilder)localObject).append(paramString2);
        localStringBuilder1.append("&");
        paramString2 = localStringBuilder1.append("imei=");
        paramString1 = str;
        if (str != null) {
          break label279;
        }
        paramString1 = "";
        label279:
        paramString2.append(paramString1);
        localStringBuilder1.append("&");
        localStringBuilder1.append("buildid=").append(AppConfig.getPatchVersionCode());
        localStringBuilder1.append("&");
        localStringBuilder1.append("clitype=1");
        return localStringBuilder1.toString();
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        QMLog.log(6, "QMLogStream", "encode msg err:" + paramString1);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          StringBuilder localStringBuilder1;
          QMLog.log(6, "QMLogStream", "urlencode err:" + localUnsupportedEncodingException2.toString());
          localStringBuilder1.append("phonetype=").append(DeviceUtil.getDeviceInfos().BRAND).append(" ").append(DeviceUtil.getDeviceInfos().MODEL);
        }
      }
    }
    str = DeviceUtil.getDeviceInfos().IMEI;
    localObject = AppConfig.getCodeVersion();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("appversion=").append((String)localObject);
    localStringBuilder1.append("&");
  }
  
  public static void saveLog(String paramString)
  {
    saveLogSync(paramString);
  }
  
  private static void saveLogSync(String paramString)
  {
    if (!sEnable) {
      return;
    }
    sHandler.post(new QMLogStream.3(paramString));
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    sEnable = paramBoolean;
    SPManager.getEditor("logstream_info").putBoolean("enable", paramBoolean).commit();
  }
  
  public static void setOtherProcessHandlingLogFile(boolean paramBoolean)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putBoolean("otherprocesshandlinglogfile", paramBoolean).apply();
  }
  
  public static void startCgiLogState(int paramInt, long paramLong)
  {
    QMLog.log(4, "QMLogStream", "startCgiLogState:" + paramInt + "," + paramLong);
    cgiContiuneSubmitState = true;
    setOtherProcessHandlingLogFile(false);
    Threads.runInBackground(new QMLogStream.5(paramLong), paramInt * 60 * 1000);
  }
  
  public static void stopCgiSubmitState()
  {
    cgiContiuneSubmitState = false;
  }
  
  public static void submit()
  {
    if (!sEnable) {
      return;
    }
    QMLog.log(4, "QMLogStream", "submit logstream");
    sHandler.removeCallbacks(sReportTask);
    sHandler.post(sReportTask);
  }
  
  public static void submitLog(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()))
    {
      if (paramBoolean1) {
        postRemoteLog();
      }
      if (paramBoolean2) {
        DataCollector.submitLog();
      }
      return;
    }
    DataCollector.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream
 * JD-Core Version:    0.7.0.1
 */