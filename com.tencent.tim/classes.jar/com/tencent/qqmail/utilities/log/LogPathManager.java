package com.tencent.qqmail.utilities.log;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;
import oicq.wlogin_sdk.tools.util;

public class LogPathManager
{
  public static final String FEEDBACK_LOGFILE_FILE_NAME = "logfile.zip";
  public static final String FEEDBACK_PUSH_LOG_FILE_NAME = "pushlog.zip";
  public static final String LOG_DIR_WLOG = "log";
  public static final String LOG_FILE_UMA = "qmumalog";
  public static final String PREFIX_TOMBSTONE_FILE_NAME = "tombstone";
  public static final String SUB_LOG_FEEDBACK = "mail/feedback";
  public static final String SUB_LOG_KV = "kv";
  public static final String SUB_LOG_NATIVELOG = "nativelog";
  public static final String SUB_LOG_OTHER = "other";
  public static final String SUB_LOG_PROTOCOLLOG = "protocollog";
  public static final String SUB_LOG_QQMAILLOG = "qqmaillog";
  public static final String SUB_LOG_TOMBSTONE = "tombstone";
  public static final String SUB_LOG_UMA = "uma";
  private static final String TAG = "LogPathManager";
  private static volatile LogPathManager _instance;
  private static final String[] probableLogPathPostfix = { "_sub2", "", "_sub" };
  private final Context context;
  private boolean hasWriteExternalStoragePermission;
  private String[] probableLogPath = null;
  
  private LogPathManager(Context paramContext)
  {
    this.context = paramContext;
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
      {
        this.hasWriteExternalStoragePermission = bool;
        Watchers.bind(new LogPathManager.1(this));
      }
    }
    for (;;)
    {
      Log.i("LogPathManager", "hasWriteExternalStoragePermission: " + this.hasWriteExternalStoragePermission);
      return;
      bool = false;
      break;
      this.hasWriteExternalStoragePermission = true;
    }
  }
  
  @NonNull
  private List<PathData> getAllFilePath(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = getProbableLogPath();
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject = arrayOfString[i];
      if (localObject != null)
      {
        localObject = new File((String)localObject + File.separator + paramString1);
        if (((File)localObject).exists())
        {
          localObject = ((File)localObject).listFiles();
          if (localObject != null)
          {
            int k = localObject.length;
            int j = 0;
            while (j < k)
            {
              File localFile = localObject[j];
              if (localFile.isFile()) {
                localArrayList.add(new PathData(localFile, modifyName(paramString2, localFile.getName(), probableLogPathPostfix[i])));
              }
              j += 1;
            }
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  @NonNull
  public static LogPathManager getInstance()
  {
    if (_instance == null) {
      try
      {
        if (_instance == null) {
          throw new IllegalStateException("instance null");
        }
      }
      finally {}
    }
    return _instance;
  }
  
  private String[] getProbableLogPath()
  {
    if (this.probableLogPath == null)
    {
      this.probableLogPath = new String[3];
      Object localObject = this.context.getCacheDir();
      localObject = ((File)localObject).getAbsolutePath() + File.separator + "log";
      if (!new File((String)localObject).exists()) {
        break label217;
      }
      this.probableLogPath[0] = localObject;
      localObject = Environment.getExternalStorageDirectory();
      localObject = ((File)localObject).getAbsolutePath() + File.separator + "tencent" + File.separator + "Tim/QQmail" + File.separator + "log";
      if (!new File((String)localObject).exists()) {
        break label227;
      }
      this.probableLogPath[1] = localObject;
      label149:
      localObject = this.context.getExternalFilesDir(null);
      if (localObject != null)
      {
        localObject = ((File)localObject).getAbsolutePath() + File.separator + "log";
        if (!new File((String)localObject).exists()) {
          break label237;
        }
        this.probableLogPath[2] = localObject;
      }
    }
    for (;;)
    {
      return this.probableLogPath;
      label217:
      this.probableLogPath[0] = null;
      break;
      label227:
      this.probableLogPath[1] = null;
      break label149;
      label237:
      this.probableLogPath[2] = null;
    }
  }
  
  public static void init(@NonNull Context paramContext)
  {
    try
    {
      if (_instance == null) {
        _instance = new LogPathManager(paramContext);
      }
      return;
    }
    finally {}
  }
  
  private static String modifyName(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (paramString1 = paramString1 + paramString2;; paramString1 = paramString2)
    {
      paramString2 = paramString1;
      if (paramString3 != null)
      {
        paramString2 = paramString1;
        if (paramString3.length() > 0)
        {
          int i = paramString1.lastIndexOf('.');
          if (i <= 0) {
            break label90;
          }
          paramString2 = paramString1.substring(0, i) + paramString3 + paramString1.substring(i);
        }
      }
      return paramString2;
      label90:
      return paramString1 + paramString3;
    }
  }
  
  List<PathData> filterFilePath(String paramString1, String paramString2, GregorianCalendar paramGregorianCalendar1, GregorianCalendar paramGregorianCalendar2)
  {
    List localList = getAllFilePath(paramString1, paramString2);
    paramString2 = new SimpleDateFormat("yyyyMMdd");
    if (paramGregorianCalendar1 == null)
    {
      paramString1 = null;
      if (paramGregorianCalendar2 != null) {
        break label131;
      }
    }
    label131:
    for (paramString2 = null;; paramString2 = paramString2.format(paramGregorianCalendar2.getTime()) + ".log")
    {
      paramGregorianCalendar1 = localList.iterator();
      while (paramGregorianCalendar1.hasNext())
      {
        paramGregorianCalendar2 = (PathData)paramGregorianCalendar1.next();
        if (((paramString1 != null) && (paramGregorianCalendar2.fileName.compareTo(paramString1) < 0)) || ((paramString2 != null) && (paramGregorianCalendar2.fileName.compareTo(paramString2) >= 0))) {
          paramGregorianCalendar1.remove();
        }
      }
      paramString1 = paramString2.format(paramGregorianCalendar1.getTime()) + ".log";
      break;
    }
    Collections.sort(localList, new LogPathManager.2(this));
    return localList;
  }
  
  @NonNull
  public List<PathData> getAllFilePath(@NonNull String paramString)
  {
    return getAllFilePath(paramString, "");
  }
  
  public String getAnrTraceFilePath()
  {
    return "/data/anr/traces.txt";
  }
  
  public String getBuildPropFilePath()
  {
    return "/system/build.prop";
  }
  
  public String getFeedbackPushLogZipFilePath()
  {
    return getLogDirPath("other") + File.separator + "pushlog.zip";
  }
  
  public String getHprofDataFilePath()
  {
    return getLogDirPath("other") + File.separator + "dump.hprof";
  }
  
  @NonNull
  String getLogDirPath(String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (FileUtil.hasSdcard()) {
      if (this.hasWriteExternalStoragePermission)
      {
        localObject2 = Environment.getExternalStorageDirectory();
        localObject1 = ((File)localObject2).getAbsolutePath() + File.separator + "tencent" + File.separator + "Tim/QQmail" + File.separator + "log" + File.separator + paramString;
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        localObject1 = this.context.getCacheDir();
        localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "log" + File.separator + paramString;
      }
      paramString = new File((String)localObject1);
      boolean bool = FileUtil.tryMkdirs(paramString);
      Log.i("LogPathManager", "mkdirResult of qmlog " + bool + " path : " + (String)localObject1 + " exist " + paramString.exists());
      return localObject1;
      File localFile = this.context.getExternalFilesDir(null);
      localObject2 = localFile;
      if (localFile != null)
      {
        localObject1 = localFile.getAbsolutePath() + File.separator + "log" + File.separator + paramString;
        localObject2 = localFile;
        continue;
        localObject2 = null;
      }
    }
  }
  
  public String getLogfileZipFilePath()
  {
    return getLogDirPath("other") + File.separator + "logfile.zip";
  }
  
  @NonNull
  public List<PathData> getProtocolFilePath(@Nullable GregorianCalendar paramGregorianCalendar1, @Nullable GregorianCalendar paramGregorianCalendar2)
  {
    return filterFilePath("protocollog", "protocol_", paramGregorianCalendar1, paramGregorianCalendar2);
  }
  
  public String getProtocolLogDirPath()
  {
    return getLogDirPath("protocollog");
  }
  
  public String getQMJNILogFilePath()
  {
    return getLogDirPath("nativelog") + File.separator + "qqmail.jni.log";
  }
  
  public String getQMLogAccountFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "account.log";
  }
  
  public String getQMLogDeviceLogFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "device.log";
  }
  
  @NonNull
  public List<PathData> getQMLogFilePath(@Nullable GregorianCalendar paramGregorianCalendar1, @Nullable GregorianCalendar paramGregorianCalendar2)
  {
    return filterFilePath("qqmaillog", "", paramGregorianCalendar1, paramGregorianCalendar2);
  }
  
  public String getQMLogFolderLogFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "folder.log";
  }
  
  public String getQMLogKVFilePath()
  {
    return getLogDirPath("kv") + File.separator + "qmkvlog";
  }
  
  public String getQMLogSettingFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "setting.log";
  }
  
  public String getQMLogTimelineFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "timeline.log";
  }
  
  public String getQMLogUmaFilePath()
  {
    return getLogDirPath("uma") + File.separator + "qmumalog";
  }
  
  public String getQMNetworkAnalyseFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "networkanalyse.log";
  }
  
  public String getQMWtloginDirPath()
  {
    return util.getLogDir(this.context);
  }
  
  public String getQmLogDirPath()
  {
    return getLogDirPath("qqmaillog");
  }
  
  public String getSystemSettingDumpPath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "syssetting.log";
  }
  
  public String getTombstoneDirPath()
  {
    return getLogDirPath("tombstone");
  }
  
  @NonNull
  public List<PathData> getTombstoneFilePath(@Nullable GregorianCalendar paramGregorianCalendar1, @Nullable GregorianCalendar paramGregorianCalendar2)
  {
    List localList = getAllFilePath("tombstone");
    Object localObject = new SimpleDateFormat("yyyyMMdd");
    if (paramGregorianCalendar1 == null)
    {
      paramGregorianCalendar1 = null;
      if (paramGregorianCalendar2 != null) {
        break label150;
      }
    }
    label150:
    for (paramGregorianCalendar2 = null;; paramGregorianCalendar2 = "tombstone_" + ((SimpleDateFormat)localObject).format(paramGregorianCalendar2.getTime()))
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PathData localPathData = (PathData)((Iterator)localObject).next();
        if (((paramGregorianCalendar1 != null) && (localPathData.fileName.substring(0, paramGregorianCalendar1.length()).compareTo(paramGregorianCalendar1) < 0)) || ((paramGregorianCalendar2 != null) && (localPathData.fileName.substring(0, paramGregorianCalendar2.length()).compareTo(paramGregorianCalendar2) >= 0))) {
          ((Iterator)localObject).remove();
        }
      }
      paramGregorianCalendar1 = "tombstone_" + ((SimpleDateFormat)localObject).format(paramGregorianCalendar1.getTime());
      break;
    }
    return localList;
  }
  
  public String getTombstoneLogFilePath()
  {
    return getLogDirPath("tombstone") + File.separator + "tombstone.log";
  }
  
  public String getWatchDogLogFilePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "watchdog.log";
  }
  
  public String getWatchdogRefreshExistTimePath()
  {
    return getLogDirPath("mail/feedback") + File.separator + "watchdogRefreshExistTime.log";
  }
  
  @NonNull
  public List<PathData> getWtLoginFilePath(@Nullable GregorianCalendar paramGregorianCalendar1, @Nullable GregorianCalendar paramGregorianCalendar2)
  {
    File localFile = null;
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = new File(getQMWtloginDirPath()).listFiles();
    if (arrayOfFile != null)
    {
      Object localObject = new SimpleDateFormat("yyyyMMdd");
      if (paramGregorianCalendar1 == null)
      {
        paramGregorianCalendar1 = null;
        if (paramGregorianCalendar2 != null) {
          break label179;
        }
      }
      label179:
      for (paramGregorianCalendar2 = localFile;; paramGregorianCalendar2 = "wtlogin_" + ((SimpleDateFormat)localObject).format(paramGregorianCalendar2.getTime()) + ".log")
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          localFile = arrayOfFile[i];
          if (localFile.isFile())
          {
            localObject = localFile.getName();
            if (((paramGregorianCalendar1 == null) || (((String)localObject).compareTo(paramGregorianCalendar1) >= 0)) && ((paramGregorianCalendar2 == null) || (((String)localObject).compareTo(paramGregorianCalendar2) < 0))) {
              localArrayList.add(new PathData(localFile, (String)localObject));
            }
          }
          i += 1;
        }
        paramGregorianCalendar1 = "wtlogin_" + ((SimpleDateFormat)localObject).format(paramGregorianCalendar1.getTime()) + ".log";
        break;
      }
    }
    return localArrayList;
  }
  
  public static class PathData
  {
    public final String fileName;
    public final String path;
    public final String suggestedName;
    
    public PathData(File paramFile, String paramString)
    {
      this.path = paramFile.getAbsolutePath();
      this.fileName = paramFile.getName();
      this.suggestedName = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.LogPathManager
 * JD-Core Version:    0.7.0.1
 */