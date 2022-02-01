package com.tencent.qqmail.utilities.patch;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.CrashGuard;
import com.tencent.qqmail.utilities.CrashGuard.Key;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import moai.oss.KvHelper;
import moai.patch.handle.PatchHandler;

public class QMPatchManagerService
  extends Service
{
  private static final int CMD_CHECK = 3;
  private static final int CMD_DOWNLOAD = 6;
  private static final int CMD_INSTALL = 5;
  private static final int CMD_REMOVE = 4;
  private static final int CMD_SCHEMA = 2;
  private static final int CMD_STOP = 1;
  private static final int CMD_STOP_IMMEDIATELY = 7;
  private static final String INTENT_KEY_BASE_VERSION = "baseversion";
  private static final String INTENT_KEY_CHANNEL = "channel";
  private static final String INTENT_KEY_CMD = "cmd";
  private static final String INTENT_KEY_INSTALL = "install";
  private static final String INTENT_KEY_NEED_CHECK = "needcheck";
  private static final String INTENT_KEY_PATCH_FILE_PATH = "patchfilepatch";
  private static final String INTENT_KEY_PATCH_KEY = "patchkey";
  private static final String INTENT_KEY_PATCH_MAX_API = "patchmaxapi";
  private static final String INTENT_KEY_PATCH_MD5 = "md5";
  private static final String INTENT_KEY_PATCH_MIN_API = "patchminapi";
  private static final String INTENT_KEY_PATCH_SIZE = "size";
  private static final String INTENT_KEY_PATCH_TYPE = "patchtype";
  private static final String INTENT_KEY_PATCH_URL = "patchurl";
  private static final String INTENT_KEY_PATCH_VERSION = "patchversion";
  private static final String KEY_BASE_VERSION = "baseversion";
  private static final String KEY_CHANNEL = "channel";
  private static final String KEY_DAY_DOWNLOAD_TIMES = "day_download_times_";
  private static final String KEY_DOWNLOAD_TIMES = "download_times_";
  private static final String KEY_LAST_DOWNLOAD_TIME = "last_download_time_";
  private static final String KEY_PATCH_MAX_API = "maxapi";
  private static final String KEY_PATCH_MD5 = "md5";
  private static final String KEY_PATCH_MIN_API = "minapi";
  private static final String KEY_PATCH_SIZE = "size";
  private static final String KEY_PATCH_TYPE = "patchtype";
  private static final String KEY_PATCH_URL = "patchurl";
  private static final String KEY_PATCH_VERSION = "patchversion";
  private static final String KEY_PATCH_VERSION_CODE = "patch_version_code";
  private static final String KEY_STOP_DOWNLOAD_TIME = "stop_download_time_";
  private static final String SP_NAME = "qmpatch_info";
  private static final String TAG = "QMPatchManagerService";
  private static Map<Long, Boolean> sDownloadingMap = new ConcurrentHashMap();
  private static File sErrorPatchDir;
  private static File sPatchDir = new File(QMPathManager.getQQMailDirPath(QMApplicationContext.sharedInstance(), "patch"));
  private Runnable mCheckTaskRunnable = new QMPatchManagerService.1(this);
  private boolean mForeground;
  private Runnable mStopRunnable = new QMPatchManagerService.2(this);
  
  static
  {
    sErrorPatchDir = new File(QMPathManager.getQQMailDirPath(QMApplicationContext.sharedInstance(), "error_patch"));
  }
  
  private void addTask(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    QMLog.log(4, "QMPatchManagerService", "addTask, type: " + paramString1 + ", minApi: " + paramString2 + ", maxApi: " + paramString3 + ", baseVersion: " + paramString4 + ", patchVersion, " + paramString5 + ", channel: " + paramString6 + ", url: " + paramString7 + ", size: " + paramString8 + ", md5: " + paramString9);
    SPManager.getEditor("qmpatch_info").putString("patchtype", paramString1).putString("baseversion", paramString4).putString("patchversion", paramString5).putString("channel", paramString6).putString("patchurl", paramString7).putString("size", paramString8).putString("md5", paramString9).putString("minapi", paramString2).putString("maxapi", paramString3).apply();
  }
  
  private static boolean checkPatchFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile())
    {
      long l1 = -1L;
      try
      {
        long l2 = Long.parseLong(SPManager.getSp("qmpatch_info").getString("size", null));
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          String str2;
          QMLog.log(5, "QMPatchManagerService", "parse patch size failed", localException);
        }
        KvHelper.hotfixDownloadFailedInvalidMd5(new double[0]);
      }
      QMLog.log(4, "QMPatchManagerService", "checkPatchFile, size: " + paramString.length() + "/" + l1);
      if (l1 != paramString.length()) {
        break label206;
      }
      str1 = SPManager.getSp("qmpatch_info").getString("md5", null);
      str2 = StringExtention.fileMD5(paramString);
      QMLog.log(4, "QMPatchManagerService", "checkPatchFile, md5: " + str2 + "/" + str1);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.equalsIgnoreCase(str2))) {
        return true;
      }
    }
    for (;;)
    {
      saveInvalidPatchFile(paramString);
      paramString.delete();
      return false;
      label206:
      KvHelper.hotfixDownloadFailedInvalidSize(new double[0]);
    }
  }
  
  private void checkTask()
  {
    Threads.runInBackgroundIfNotExist(this.mCheckTaskRunnable, 1000L);
  }
  
  private void checkVersionCode()
  {
    int i = AppConfig.getSystemVersionCode();
    int j = AppConfig.getPatchVersionCode();
    int k = SPManager.getSp("qmpatch_info").getInt("patch_version_code", i);
    QMLog.log(4, "QMPatchManagerService", "checkVersionCode, last: " + k + ", cur: " + j + ", base: " + i);
    if (k < j) {
      SPManager.getEditor("qmpatch_info").putInt("patch_version_code", j).apply();
    }
    while (k <= j) {
      return;
    }
    SPManager.getEditor("qmpatch_info").putInt("patch_version_code", j).apply();
  }
  
  private void clearPatchFiles()
  {
    File[] arrayOfFile = sPatchDir.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      QMLog.log(4, "QMPatchManagerService", "clearPatchFiles: " + Arrays.toString(arrayOfFile));
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  static Intent createCheckIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 3);
  }
  
  static Intent createDownloadPatchIntent(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 6).putExtra("patchurl", paramString).putExtra("install", paramBoolean1).putExtra("needcheck", paramBoolean2);
  }
  
  static Intent createInstallPatchIntent(String paramString1, String paramString2, boolean paramBoolean)
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 5).putExtra("patchkey", paramString1).putExtra("patchfilepatch", paramString2).putExtra("needcheck", paramBoolean);
  }
  
  static Intent createRemoveIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 4);
  }
  
  static Intent createSchemaIntent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 2).putExtra("patchtype", paramString1).putExtra("baseversion", paramString4).putExtra("patchversion", paramString5).putExtra("channel", paramString6).putExtra("patchurl", paramString7).putExtra("size", paramString8).putExtra("md5", paramString9).putExtra("patchminapi", paramString2).putExtra("patchmaxapi", paramString3);
  }
  
  static Intent createStopImmedialyIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 7);
  }
  
  static Intent createStopIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), QMPatchManagerService.class).putExtra("cmd", 1);
  }
  
  private void doPatchIfNeed(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!isValidPatch(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7))
    {
      QMLog.log(5, "QMPatchManagerService", "invalid patch, stop");
      removeTask();
      stop();
      return;
    }
    foreground();
    downloadPatch(paramString7.replace("$CHANNEL$", String.valueOf(ChannelDefine.getChannelId())), true, true);
  }
  
  private void download(Intent paramIntent)
  {
    downloadPatch(paramIntent.getStringExtra("patchurl"), paramIntent.getBooleanExtra("install", true), paramIntent.getBooleanExtra("needcheck", true));
  }
  
  private void downloadPatch(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QMLog.log(4, "QMPatchManagerService", "downloadPatch, url: " + paramString + ", install: " + paramBoolean1);
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          i = paramString.lastIndexOf("/");
        } while ((i == -1) || (i == paramString.length() - 1));
        str = paramString.substring(i + 1);
        str = sPatchDir + "/" + str;
      } while ((!sPatchDir.mkdirs()) && (!sPatchDir.exists()));
      if (!new File(str).exists()) {
        break;
      }
      QMLog.log(4, "QMPatchManagerService", "patch file exists, ready to install: " + str);
    } while (!paramBoolean1);
    handlePatch(paramString, str, paramBoolean2);
    return;
    Object localObject = SPManager.getSp("qmpatch_info").getString("md5", null);
    int i = SPManager.getSp("qmpatch_info").getInt("download_times_" + (String)localObject, 0);
    if (i > 10)
    {
      QMLog.log(5, "QMPatchManagerService", "download patch failed " + i + ", times, do not try again");
      return;
    }
    if (System.currentTimeMillis() - SPManager.getSp("qmpatch_info").getLong("stop_download_time_" + (String)localObject, 0L) <= 86400000L)
    {
      QMLog.log(5, "QMPatchManagerService", "download patch failed too many times in a day, try again next day");
      return;
    }
    long l1 = -1L;
    try
    {
      long l2 = Long.parseLong(SPManager.getSp("qmpatch_info").getString("size", null));
      l1 = l2;
    }
    catch (Exception localException)
    {
      label350:
      int j;
      break label350;
    }
    if ((i > 1) && (l1 > 1048576L) && (!QMNetworkUtils.isWifiConnected()) && (System.currentTimeMillis() - SPManager.getSp("qmpatch_info").getLong("last_download_time_" + (String)localObject, 0L) <= 86400000L))
    {
      QMLog.log(5, "QMPatchManagerService", "do not download until wifi, errorTimes: " + i + ", size: " + l1 + ", network: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    l1 = DownloadTask.generateHashId(paramString, str);
    if (sDownloadingMap.put(Long.valueOf(l1), Boolean.TRUE) != null)
    {
      QMLog.log(5, "QMPatchManagerService", "downloading same patch");
      return;
    }
    j = SPManager.getSp("qmpatch_info").getInt("day_download_times_" + (String)localObject, 0);
    SPManager.getEditor("qmpatch_info").putInt("day_download_times_" + (String)localObject, j + 1).putInt("download_times_" + (String)localObject, i + 1).putLong("last_download_time_" + (String)localObject, System.currentTimeMillis()).apply();
    if (j + 1 >= 3) {
      SPManager.getEditor("qmpatch_info").putLong("stop_download_time_" + (String)localObject, System.currentTimeMillis()).remove("day_download_times_" + (String)localObject).apply();
    }
    localObject = new DownloadTask();
    ((DownloadTask)localObject).setUrl(paramString);
    ((DownloadTask)localObject).setFilePath(str);
    ((DownloadTask)localObject).setSingleTaskDownload(true);
    ((DownloadTask)localObject).setId(l1);
    ((DownloadTask)localObject).setListener(new QMPatchManagerService.3(this, paramBoolean1, paramBoolean2));
    ((DownloadTask)localObject).start();
  }
  
  private void foreground()
  {
    if ((this.mForeground) || (Build.VERSION.SDK_INT >= 24)) {
      return;
    }
    this.mForeground = true;
    CrashGuard localCrashGuard = new CrashGuard(CrashGuard.Key.FOREGROUND_SERVICE, 2);
    localCrashGuard.open();
    if (localCrashGuard.isWork()) {}
    try
    {
      startForeground(getForegroundId(), getForegroundNotification());
      Object localObject = null;
      try
      {
        ComponentName localComponentName = startService(new Intent(this, QMGuardPatchService.class));
        localObject = localComponentName;
      }
      catch (Throwable localThrowable2)
      {
        label74:
        break label74;
      }
      if (localObject == null)
      {
        QMLog.log(5, "QMPatchManagerService", "start QMGuardPushService failed, stop foregound service");
        stopForeground(true);
      }
      localCrashGuard.closeDelay(500);
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QMLog.log(5, "QMPatchManagerService", "startForegournd failed", localThrowable1);
      }
    }
  }
  
  @Nullable
  public static File[] getErrorPatchFiles()
  {
    return sErrorPatchDir.listFiles();
  }
  
  public static int getForegroundId()
  {
    return 2147483637;
  }
  
  public static Notification getForegroundNotification()
  {
    Notification.Builder localBuilder = new Notification.Builder(QMApplicationContext.sharedInstance());
    localBuilder.setSmallIcon(2130841197);
    return localBuilder.build();
  }
  
  private void handlePatch(String paramString1, String paramString2, boolean paramBoolean)
  {
    QMLog.log(4, "QMPatchManagerService", "handlePatch, patchKey: " + paramString1 + ", filePath: " + paramString2 + ", needCheck: " + paramBoolean);
    if ((paramBoolean) && (!checkPatchFile(paramString2)))
    {
      QMLog.log(5, "QMPatchManagerService", "patch file is invalid");
      return;
    }
    PatchHandler.handle(QMApplicationContext.sharedInstance(), paramString1, paramString2);
  }
  
  private void handleSchema(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("patchtype");
    String str2 = paramIntent.getStringExtra("baseversion");
    String str3 = paramIntent.getStringExtra("patchversion");
    String str4 = paramIntent.getStringExtra("channel");
    String str5 = paramIntent.getStringExtra("patchurl");
    String str6 = paramIntent.getStringExtra("size");
    String str7 = paramIntent.getStringExtra("md5");
    String str8 = paramIntent.getStringExtra("patchminapi");
    paramIntent = paramIntent.getStringExtra("patchmaxapi");
    if (isValidPatch(str1, str8, paramIntent, str2, str3, str4, str5)) {
      addTask(str1, str8, paramIntent, str2, str3, str4, str5, str6, str7);
    }
    checkTask();
  }
  
  private void install(Intent paramIntent)
  {
    handlePatch(paramIntent.getStringExtra("patchkey"), paramIntent.getStringExtra("patchfilepatch"), paramIntent.getBooleanExtra("needcheck", true));
  }
  
  private boolean isValidPatch(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    i = Build.VERSION.SDK_INT;
    int j = AppConfig.getSystemVersionCode();
    int k = AppConfig.getPatchVersionCode();
    String str = String.valueOf(ChannelDefine.getChannelId());
    QMLog.log(4, "QMPatchManagerService", "isValidPatch, sdk: " + i + ", type: " + paramString1 + ", minApi: " + paramString2 + ", maxApi: " + paramString3 + ", baseVersion: {" + j + "/" + paramString4 + "}, patchVersion: {" + k + "/" + paramString5 + "}, channel: {" + str + "/" + paramString6 + "}, url: " + paramString7);
    boolean bool2 = false;
    bool1 = bool2;
    for (;;)
    {
      try
      {
        if (i >= Integer.parseInt(paramString2))
        {
          bool1 = bool2;
          if (i <= Integer.parseInt(paramString3))
          {
            if (!"patch".equals(paramString1)) {
              continue;
            }
            if ((Integer.parseInt(paramString4) != j) || (Integer.parseInt(paramString5) <= k)) {
              continue;
            }
            if (!TextUtils.isEmpty(paramString6))
            {
              bool1 = paramString6.equals(str);
              if (!bool1) {
                continue;
              }
            }
            bool1 = true;
          }
        }
      }
      catch (Exception paramString1)
      {
        QMLog.log(5, "QMPatchManagerService", "parse error", paramString1);
        bool1 = false;
        continue;
        i = 5;
        continue;
      }
      if (!bool1) {
        continue;
      }
      i = 4;
      QMLog.log(i, "QMPatchManagerService", "isValidPatch: " + bool1);
      return bool1;
      bool1 = false;
      continue;
      bool1 = bool2;
      if ("revert".equals(paramString1))
      {
        if ((Integer.parseInt(paramString4) == j) && (Integer.parseInt(paramString5) == k)) {
          if (!TextUtils.isEmpty(paramString6))
          {
            bool1 = paramString6.equals(str);
            if (!bool1) {}
          }
          else
          {
            bool1 = true;
            continue;
          }
        }
        bool1 = false;
      }
    }
  }
  
  private void removeStop()
  {
    Threads.removeCallbackInBackground(this.mStopRunnable);
  }
  
  private void removeTask()
  {
    QMLog.log(4, "QMPatchManagerService", "removeTask");
    SPManager.getEditor("qmpatch_info").remove("patchtype").remove("baseversion").remove("patchversion").remove("channel").remove("patchurl").remove("size").remove("md5").remove("minapi").remove("maxapi").apply();
    clearPatchFiles();
  }
  
  private static void saveInvalidPatchFile(File paramFile)
  {
    File localFile = sErrorPatchDir;
    File[] arrayOfFile = localFile.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length >= 3)) {
      arrayOfFile[0].delete();
    }
    paramFile.renameTo(new File(localFile, paramFile.getName() + "_" + System.currentTimeMillis() / 1000L));
  }
  
  private void stop()
  {
    Threads.replaceCallbackInBackground(this.mStopRunnable, 10000L);
  }
  
  public static void updatePatchDownloadPath()
  {
    File localFile = sPatchDir;
    sPatchDir = new File(QMPathManager.getQQMailDirPath(QMApplicationContext.sharedInstance(), "patch"));
    sErrorPatchDir = new File(QMPathManager.getQQMailDirPath(QMApplicationContext.sharedInstance(), "error_patch"));
    QMLog.log(4, "QMPatchManagerService", "updatePatchDownloadPath, new path: " + sPatchDir + ", old path: " + localFile);
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, "QMPatchManagerService", "onCreate@" + Integer.toHexString(hashCode()));
    checkVersionCode();
    stopForeground(true);
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMPatchManagerService", "onDestroy@" + Integer.toHexString(hashCode()));
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    if (paramIntent != null)
    {
      removeStop();
      int i = paramIntent.getIntExtra("cmd", 0);
      QMLog.log(4, "QMPatchManagerService", "onStartCommand, cmd: " + i);
      switch (i)
      {
      }
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      stop();
      continue;
      handleSchema(paramIntent);
      continue;
      checkTask();
      continue;
      removeTask();
      continue;
      install(paramIntent);
      continue;
      download(paramIntent);
      continue;
      stopSelf();
      continue;
      stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManagerService
 * JD-Core Version:    0.7.0.1
 */