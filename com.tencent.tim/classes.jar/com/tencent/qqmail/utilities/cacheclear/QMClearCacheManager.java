package com.tencent.qqmail.utilities.cacheclear;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.LogPathManager.PathData;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.FileUtils;

public class QMClearCacheManager
{
  private static final String TAG = "QMClearCacheManager";
  private static final long dayMils = 86400000L;
  private static final int k = 1024;
  private static QMClearCacheManager sInstance;
  private Messenger clearCacheService;
  private long mBindTime;
  private AtomicBoolean mBinding = new AtomicBoolean();
  private volatile boolean mBound;
  private ServiceConnection mServiceConnection = new QMClearCacheManager.1(this);
  
  private void bindService()
  {
    boolean bool = this.mBinding.getAndSet(true);
    QMLog.log(4, "QMClearCacheManager", "bindService, binding: " + bool + ", bound: " + this.mBound + ", service: " + this.clearCacheService);
    if ((!this.mBound) && (!bool))
    {
      this.mBindTime = SystemClock.elapsedRealtime();
      Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ClearCacheService.class);
      QMApplicationContext.sharedInstance().bindService(localIntent, this.mServiceConnection, 1);
    }
  }
  
  private static void clearAttachCache(ClearCacheConfig paramClearCacheConfig, ArrayList<String> paramArrayList, ClearAttachCallback paramClearAttachCallback)
  {
    if ((paramClearCacheConfig != null) && (paramArrayList != null))
    {
      QMLog.log(4, "QMClearCacheManager", "clear attach path size:" + paramArrayList.size());
      paramClearCacheConfig = FileUtil.delFileByPath(paramArrayList);
      if (paramClearAttachCallback != null) {
        paramClearAttachCallback.onResult(paramClearCacheConfig);
      }
    }
  }
  
  private static void clearAvatarCache(ClearCacheConfig paramClearCacheConfig)
  {
    if (paramClearCacheConfig != null)
    {
      QMLog.log(4, "QMClearCacheManager", "clearAvatarCache");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(FileUtil.getFiles(QMPathManager.sharedInstance().getQQMailEmailIconDir()));
      localArrayList.addAll(FileUtil.getFiles(QMPathManager.sharedInstance().getQQMailNickIconDir()));
      int i = localArrayList.size();
      long[][] arrayOfLong = (long[][])Array.newInstance(Long.TYPE, new int[] { i, 2 });
      i = 0;
      while (i < localArrayList.size())
      {
        arrayOfLong[i][0] = i;
        arrayOfLong[i][1] = ((File)localArrayList.get(i)).lastModified();
        i += 1;
      }
      Arrays.sort(arrayOfLong, new QMClearCacheManager.3());
      long l2 = paramClearCacheConfig.getClearAvatarSize();
      long l1 = getAvatarCache();
      i = 0;
      while ((l1 > 1024L * l2) && (i < localArrayList.size()))
      {
        paramClearCacheConfig = (File)localArrayList.get((int)arrayOfLong[i][0]);
        if ((paramClearCacheConfig.exists()) && (paramClearCacheConfig.isDirectory())) {
          FileUtil.delFolder(paramClearCacheConfig.getAbsolutePath());
        }
        l1 = getAvatarCache();
        i += 1;
      }
    }
  }
  
  public static void clearCacheForUpgrade()
  {
    int i = 0;
    Object localObject = new String[7];
    localObject[0] = FileDefine.INNER_DATA_BIG_ATTACH_DIR;
    localObject[1] = FileDefine.EXTERNAL_ANDROID_DATA_THUMB_IMAGE_CACHE_DIR;
    localObject[2] = FileDefine.EXTERNAL_ANDROID_DATA_BIGATTACH_DIR;
    localObject[3] = FileDefine.EXTERNAL_ANDROID_DATA_COMPRESS_DIR;
    localObject[4] = FileDefine.EXTERNAL_ANDROID_DATA_ATTACHMENT_DIR;
    localObject[5] = FileDefine.EXTERNAL_ANDROID_DATA_SCREENSHOT;
    localObject[6] = QMPathManager.sharedInstance().getQQMailAttachmentDir();
    int j = localObject.length;
    while (i < j)
    {
      String str = localObject[i];
      if (new File(str).exists())
      {
        QMLog.log(4, "QMClearCacheManager", "clear dir for upgrade:" + str);
        FileUtil.delFolder(str);
      }
      i += 1;
    }
    localObject = new File(FileDefine.EXTERNAL_ANDROID_DATA_DIR);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length == 0)) {
        FileUtil.delFolder(FileDefine.EXTERNAL_ANDROID_DATA_DIR);
      }
    }
  }
  
  public static void clearCardCache()
  {
    clearCardCache(parseClearCacheConfig());
  }
  
  private static void clearCardCache(ClearCacheConfig paramClearCacheConfig)
  {
    if ((paramClearCacheConfig != null) && (System.currentTimeMillis() - QMSharedPreferenceManager.getInstance().getEnterCardTime() > paramClearCacheConfig.getClearCardTime() * 1000L))
    {
      QMLog.log(4, "QMClearCacheManager", "clearCardCache");
      QMCardManager.shareInstance().deleteAllCardDatas();
    }
  }
  
  public static void clearDownloadInfo(ArrayList<String> paramArrayList)
  {
    DownloadInfoManager.shareInstance().deleteDownloadInfoOfflineByPaths(paramArrayList);
    long l = QMSharedPreferenceManager.getInstance().getClearAttachmentCacheTimeByUser();
    if (l > 0L) {
      DownloadInfoManager.shareInstance().deleteDownloadInfoBeforeTime(System.currentTimeMillis() - l);
    }
  }
  
  public static void clearFileCache(ArrayList<String> paramArrayList, ClearAttachCallback paramClearAttachCallback)
  {
    if (QMSharedPreferenceManager.getInstance().getClearAttachmentCacheTimeByUser() > 0L)
    {
      ClearCacheConfig localClearCacheConfig = parseClearCacheConfig();
      clearAvatarCache(localClearCacheConfig);
      clearLogCache(localClearCacheConfig);
      clearImageCache(localClearCacheConfig);
      clearAttachCache(localClearCacheConfig, paramArrayList, paramClearAttachCallback);
    }
  }
  
  private static void clearImageCache(ClearCacheConfig paramClearCacheConfig)
  {
    if (paramClearCacheConfig != null)
    {
      QMLog.log(4, "QMClearCacheManager", "clearImageCache");
      FileUtil.delFileBeforeCertianTime(FileDefine.INNER_DATA_THUMB_IMAGE_CACHE_DIR, paramClearCacheConfig.getClearImageCacheTime() * 1000L);
      FileUtil.delFileBeforeCertianTime(QMPathManager.sharedInstance().getQQMailThumbImageCacheDir(), paramClearCacheConfig.getClearImageCacheTime() * 1000L);
    }
  }
  
  private static void clearLogCache(ClearCacheConfig paramClearCacheConfig)
  {
    if (paramClearCacheConfig != null)
    {
      QMLog.log(4, "QMClearCacheManager", "clearLogCache");
      long l = paramClearCacheConfig.getClearLogTime();
      paramClearCacheConfig = new GregorianCalendar();
      paramClearCacheConfig.setTimeInMillis(System.currentTimeMillis() - l * 1000L);
      Object localObject = LogPathManager.getInstance().getQMLogFilePath(null, paramClearCacheConfig);
      ((List)localObject).addAll(LogPathManager.getInstance().getProtocolFilePath(null, paramClearCacheConfig));
      if (((List)localObject).size() > 0)
      {
        paramClearCacheConfig = ((List)localObject).iterator();
        while (paramClearCacheConfig.hasNext())
        {
          localObject = (LogPathManager.PathData)paramClearCacheConfig.next();
          FileUtil.delFile(((LogPathManager.PathData)localObject).path);
          QMLog.log(4, "QMClearCacheManager", "clearLogCache:" + localObject);
        }
      }
    }
  }
  
  public static long getAttachCache(boolean paramBoolean)
  {
    return (int)(0 + FileUtil.getDownloadAttachCacheSize(DownloadInfoManager.shareInstance().getPathsInAttachDownloadDir(paramBoolean)));
  }
  
  public static long getAvatarCache()
  {
    return (int)((int)(0 + FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailEmailIconDir())) + FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailNickIconDir()));
  }
  
  public static long getCardCache()
  {
    return 0L;
  }
  
  public static long getDatabaseCache()
  {
    return (int)(0 + FileUtil.getDirectorySize(FileDefine.INNER_DATA_DATABASES));
  }
  
  public static long getImageCache()
  {
    return (int)((int)(0 + FileUtil.getDirectorySize(FileDefine.INNER_DATA_THUMB_IMAGE_CACHE_DIR)) + FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailThumbImageCacheDir()));
  }
  
  public static long getLogCache()
  {
    return (int)(0 + FileUtil.getDirectorySize(QMPathManager.sharedInstance().getQQMailLogDir()));
  }
  
  private static String getTestConfig()
  {
    try
    {
      Object localObject1 = FileUtils.readFileToString(new File(QMPathManager.sharedInstance().getDownloadConfig()));
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{");
        ((StringBuilder)localObject1).append("\"999\":");
        ((StringBuilder)localObject1).append("{");
        ((StringBuilder)localObject1).append("\"b\":0,");
        ((StringBuilder)localObject1).append("\"c\":0,");
        ((StringBuilder)localObject1).append("\"d\":0,");
        ((StringBuilder)localObject1).append("\"e\":0,");
        ((StringBuilder)localObject1).append("\"f\":0,");
        ((StringBuilder)localObject1).append("\"p\":1");
        ((StringBuilder)localObject1).append("}");
        ((StringBuilder)localObject1).append("}");
        localObject3 = ((StringBuilder)localObject1).toString();
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMClearCacheManager", Log.getStackTraceString(localException));
        Object localObject2 = null;
      }
    }
  }
  
  public static boolean isTestDebug()
  {
    return QMSharedPreferenceManager.getInstance().getClearCacheDebug();
  }
  
  public static ClearCacheConfig parseClearCacheConfig()
  {
    if (isTestDebug()) {}
    for (String str = getTestConfig(); !StringExtention.isNullOrEmpty(str); str = QMSharedPreferenceManager.getInstance().getClearCacheConfig())
    {
      ClearCacheConfig localClearCacheConfig = new ClearCacheConfig();
      localClearCacheConfig.parseWithDictionary(str);
      return localClearCacheConfig;
    }
    return null;
  }
  
  public static ArrayList<String> prepareAttachPathsToDelete()
  {
    long l = QMSharedPreferenceManager.getInstance().getClearAttachmentCacheTimeByUser();
    ArrayList localArrayList = Lists.newArrayList();
    if (l > 0L)
    {
      Iterator localIterator = DownloadInfoManager.shareInstance().getPathsInAttachDownloadDir(false).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!StringExtention.isNullOrEmpty(str))
        {
          File localFile = new File(str);
          if ((localFile.isFile()) && (System.currentTimeMillis() - localFile.lastModified() > l)) {
            localArrayList.add(str);
          }
        }
      }
    }
    DownloadInfoManager.shareInstance().deleteDownloadInfoOfflineByPaths(localArrayList);
    DownloadInfoManager.shareInstance().deleteDownloadInfoBeforeTime(System.currentTimeMillis());
    return localArrayList;
  }
  
  private void registerClient()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.replyTo = new Messenger(new ClientHandler(this, QMApplicationContext.sharedInstance().getMainLooper()));
    try
    {
      this.clearCacheService.send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "QMClearCacheManager", "register client error!!", localThrowable);
    }
  }
  
  public static void reportCache()
  {
    int i = (int)(FileUtil.getSdcardAllSpace() / 1024L);
    int j = (int)(FileUtil.getSdcardUsableSpace() / 1024L);
    int m = (int)(getCardCache() / 1024L);
    int n = (int)(getAvatarCache() / 1024L);
    int i1 = (int)(getLogCache() / 1024L);
    int i2 = (int)(getImageCache() / 1024L);
    int i3 = (int)(getAttachCache(true) / 1024L);
    int i4 = (int)(getDatabaseCache() / 1024L);
    QMLog.log(4, "QMClearCacheManager", "systemSize:" + i + "reminderSize:" + j + "cardSize:" + m + "avatarSize:" + n + "logSize:" + i1 + "imageSize:" + i2 + "attachSize:" + i3 + "databaseSize:" + i4 + "appSize:" + (m + n + i1 + i2 + i4));
  }
  
  public static void reportCacheDaily()
  {
    try
    {
      long l2 = System.currentTimeMillis();
      long l3 = QMSharedPreferenceManager.getInstance().getClearCacheReportTime();
      if (isTestDebug()) {}
      for (long l1 = 0L;; l1 = 86400000L)
      {
        if (l2 - l3 > l1)
        {
          QMLog.log(4, "QMClearCacheManager", "reportCacheDaily now:" + l2);
          QMSharedPreferenceManager.getInstance().setClearCacheReportTime(l2);
          reportCache();
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMClearCacheManager", Log.getStackTraceString(localException));
    }
  }
  
  public static void setEnterCardTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    QMSharedPreferenceManager.getInstance().setEnterCardTime(l);
  }
  
  public static void setTestDebug(boolean paramBoolean)
  {
    QMSharedPreferenceManager.getInstance().setClearCacheDebug(paramBoolean);
  }
  
  public static QMClearCacheManager shareInstance()
  {
    try
    {
      if (sInstance != null)
      {
        localQMClearCacheManager = sInstance;
        return localQMClearCacheManager;
      }
      sInstance = new QMClearCacheManager();
      QMClearCacheManager localQMClearCacheManager = sInstance;
      return localQMClearCacheManager;
    }
    finally {}
  }
  
  private void submitClearTask()
  {
    Threads.runInBackground(new QMClearCacheManager.2(this));
  }
  
  private void unbindService()
  {
    try
    {
      QMApplicationContext.sharedInstance().unbindService(this.mServiceConnection);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void clearCacheDaily()
  {
    try
    {
      long l2 = System.currentTimeMillis();
      long l3 = QMSharedPreferenceManager.getInstance().getClearCacheTime();
      if (isTestDebug()) {}
      for (long l1 = 0L;; l1 = 86400000L)
      {
        if (l2 - l3 > l1)
        {
          QMLog.log(4, "QMClearCacheManager", "clearCacheDaily now:" + l2);
          QMSharedPreferenceManager.getInstance().setClearCacheTime(l2);
          if (QMSharedPreferenceManager.getInstance().isClearCache())
          {
            QMLog.log(4, "QMClearCacheManager", "clearCacheDaily clearDB");
            clearCardCache();
            QMLog.log(4, "QMClearCacheManager", "clearCacheDaily clearFile");
            if ((!this.mBound) || (this.clearCacheService != null)) {
              bindService();
            }
          }
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMClearCacheManager", Log.getStackTraceString(localException));
    }
  }
  
  public static abstract interface ClearAttachCallback
  {
    public abstract void onResult(ArrayList<String> paramArrayList);
  }
  
  static class ClientHandler
    extends Handler
  {
    WeakReference<QMClearCacheManager> mOuter;
    
    public ClientHandler(QMClearCacheManager paramQMClearCacheManager, Looper paramLooper)
    {
      super();
      this.mOuter = new WeakReference(paramQMClearCacheManager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      QMClearCacheManager localQMClearCacheManager = (QMClearCacheManager)this.mOuter.get();
      if ((localQMClearCacheManager == null) || (paramMessage == null)) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      paramMessage = paramMessage.getData().getStringArrayList("cache_paths_deleted_list");
      if (paramMessage != null) {
        DownloadInfoManager.shareInstance().deleteDownloadInfoByPaths(paramMessage, false);
      }
      localQMClearCacheManager.unbindService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager
 * JD-Core Version:    0.7.0.1
 */