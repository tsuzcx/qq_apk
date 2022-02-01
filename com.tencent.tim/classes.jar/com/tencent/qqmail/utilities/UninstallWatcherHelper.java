package com.tencent.qqmail.utilities;

import android.content.Intent;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.processutil.ProcessUtils;
import com.tencent.qqmail.utilities.qmnetwork.service.UninstallService;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UninstallWatcherHelper
{
  private static final String TAG = "UninstallWatcherHelper";
  private static boolean isInitingUninstallProcess = false;
  
  public static boolean canStartWatchdog()
  {
    return true;
  }
  
  private static List<Integer> getWatchProcessIds(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int j;
      try
      {
        Object localObject1 = Runtime.getRuntime().exec("ps");
        if (localObject1 != null)
        {
          localObject1 = new BufferedReader(new InputStreamReader(((Process)localObject1).getInputStream()));
          int i = 0;
          Object localObject2 = ((BufferedReader)localObject1).readLine();
          if (localObject2 != null)
          {
            i += 1;
            if (i == 1) {
              continue;
            }
            localObject2 = ((String)localObject2).split(" ");
            if ((!localObject2[0].equals("system")) && (!localObject2[0].equals("shell")) && (!localObject2[0].equals("root")) && (!localObject2[0].equals("log")) && (!localObject2[0].equals("radio")) && (!localObject2[0].equals("gpa")) && (!localObject2[0].equals("keystore")) && (!localObject2[0].equals("drm")) && (!localObject2[0].equals("ccci")))
            {
              if (localObject2[0].equals("dhcp")) {
                continue;
              }
              if ((localObject2[(localObject2.length - 1)] != null) && (localObject2[(localObject2.length - 1)].contains(paramString)))
              {
                j = 0;
                if (j >= localObject2.length) {
                  break label328;
                }
                if ((localObject2[j] == null) || (localObject2[j].equals("")) || (!StringExtention.isNum(localObject2[j]))) {
                  break label331;
                }
                localArrayList.add(Integer.valueOf(Integer.parseInt(localObject2[j])));
                break label328;
              }
            }
          }
          else
          {
            ((BufferedReader)localObject1).close();
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (IOException paramString)
      {
        QMLog.log(6, "UninstallWatcherHelper", "getProcessId err:" + paramString.toString());
        return localArrayList;
      }
      continue;
      label328:
      continue;
      label331:
      j += 1;
    }
  }
  
  public static boolean initUninstallWatcher(boolean paramBoolean)
  {
    boolean bool2 = false;
    openPushAliveWatchFile();
    boolean bool1;
    if (!new File(UninstallService.WATCHDOG_PATH).exists())
    {
      QMLog.log(4, "UninstallWatcherHelper", "upgrade watchdog");
      killUninstallWatchProcess();
      FileUtil.delAllFile(UninstallService.WATCHDOG_DIRECTORY);
      bool1 = initUninstallWatcherProcess();
      return bool1;
    }
    if (ProcessUtils.isProcessExist("mailwatchdog"))
    {
      long l1 = new Date().getTime();
      long l2 = SharedPreferenceUtil.getInitUninstallWatchProcessTime();
      long l3 = l1 - l2;
      if (l3 > 7200000L) {}
      for (bool1 = true;; bool1 = false)
      {
        QMLog.log(4, "UninstallWatcherHelper", "uninstall watch process exist. now:" + l1 + ",lasttime:" + l2 + ", interval:" + l3 + ", isReachMaxInterval:" + bool1 + ",foreceToCreate:" + paramBoolean);
        if (!bool1)
        {
          bool1 = bool2;
          if (!paramBoolean) {
            break;
          }
        }
        killUninstallWatchProcess();
        return initUninstallWatcherProcess();
      }
    }
    QMLog.log(4, "UninstallWatcherHelper", "no watch process exist. init it");
    return initUninstallWatcherProcess();
  }
  
  private static boolean initUninstallWatcherProcess()
  {
    reportWatchdogExistTime();
    QMLog.log(4, "UninstallWatcherHelper", "initUninstallWatcher. begin");
    Object localObject = new File(FileDefine.WATCHFIEL_UNISTALL_WATCH);
    QMLog.log(4, "UninstallWatcherHelper", "watch file path:" + ((File)localObject).getAbsolutePath());
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        if (FileUtil.tryMkdirs(((File)localObject).getParentFile())) {
          continue;
        }
        QMLog.log(6, "UninstallWatcherHelper", "create watch parent dirs fail");
        i = 0;
        if (!((File)localObject).createNewFile())
        {
          QMLog.log(6, "UninstallWatcherHelper", "fail to create watch file.");
          i = 0;
        }
      }
      catch (IOException localIOException)
      {
        QMLog.log(6, "UninstallWatcherHelper", "create uninstall watch file err:" + localIOException.toString());
        i = 0;
        continue;
      }
      if (i == 0) {
        break label211;
      }
      localObject = new Intent();
      ((Intent)localObject).setClass(QMApplicationContext.sharedInstance(), UninstallService.class);
      try
      {
        QMApplicationContext.sharedInstance().startService((Intent)localObject);
        QMLog.log(4, "UninstallWatcherHelper", "initUninstallWatcher. end");
        return true;
      }
      catch (Throwable localThrowable)
      {
        QMLog.log(5, "UninstallWatcherHelper", "init uninstall process failed");
      }
      QMLog.log(4, "UninstallWatcherHelper", "create watch parent dirs ok");
      int i = 1;
      continue;
      QMLog.log(4, "UninstallWatcherHelper", "watch file exist");
      i = 1;
    }
    label211:
    QMLog.log(4, "UninstallWatcherHelper", "should not init uninstall process.");
    return false;
  }
  
  public static void initWatchDog(boolean paramBoolean)
  {
    if (!isInitingUninstallProcess)
    {
      isInitingUninstallProcess = true;
      Threads.runInBackground(new UninstallWatcherHelper.1(paramBoolean));
    }
  }
  
  public static void killUninstallWatchProcess()
  {
    List localList = getWatchProcessIds("mailwatchdog");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("killUninstallWatchProcess:");
    int i = 0;
    for (;;)
    {
      if (i < localList.size()) {
        try
        {
          localStringBuilder.append(localList.get(i)).append(",");
          Runtime.getRuntime().exec("kill -9 " + localList.get(i));
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            QMLog.log(6, "UninstallWatcherHelper", "kill watch process err:" + localIOException.toString());
          }
        }
      }
    }
    QMLog.log(5, "UninstallWatcherHelper", localStringBuilder.toString());
  }
  
  private static void openPushAliveWatchFile()
  {
    try
    {
      File localFile = new File(FileDefine.WATCHFIEL_PUSH_WATCH);
      if (!localFile.exists())
      {
        if (!FileUtil.tryMkdirs(localFile.getParentFile())) {
          QMLog.log(6, "UninstallWatcherHelper", "create push.watch parentdirs err.");
        }
        if (!localFile.createNewFile()) {
          QMLog.log(6, "UninstallWatcherHelper", "create push.watch err.");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "UninstallWatcherHelper", "UninstallWatcherHelper. start watch push.watch err:" + localException.toString());
    }
  }
  
  public static void reportWatchdogExistTime()
  {
    Threads.runInBackground(new UninstallWatcherHelper.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.UninstallWatcherHelper
 * JD-Core Version:    0.7.0.1
 */