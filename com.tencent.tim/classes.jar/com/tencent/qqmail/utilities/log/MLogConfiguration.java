package com.tencent.qqmail.utilities.log;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager.OnChangedListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import moai.log.AutoFlushFileHandler;
import moai.log.AutoFlushFileHandler.DefaultStrategy;
import moai.log.FileHandler;
import moai.log.Handler;
import moai.log.LogcatHandler;
import moai.log.MLog;
import moai.log.QueueFileHandler;
import moai.log.TEAFileHandler;

public class MLogConfiguration
{
  private static final String KEY_LOGCAT = "logcat";
  private static final String KEY_LOG_LEVEL = "log_level_2";
  private static final String SP_NAME = "mlog_info";
  private static final MLogConfiguration _instance = new MLogConfiguration();
  private int level;
  private final CopyOnWriteArrayList<MLog> logList = new CopyOnWriteArrayList();
  private boolean logcat;
  private SPManager.OnChangedListener sSPChangedListener = new MLogConfiguration.1(this);
  
  private MLogConfiguration()
  {
    if (!AppConfig.isLimited()) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      moai.log.BuildConfig.DEBUG = bool1;
      bool1 = bool2;
      if (!AppConfig.isBeta())
      {
        bool1 = bool2;
        if (!AppConfig.isLimited()) {
          bool1 = false;
        }
      }
      moai.log.BuildConfig.BETA = bool1;
      SPManager.registerOnChangedListener("mlog_info", this.sSPChangedListener);
      this.logcat = logcatEnable(false);
      this.level = level();
      return;
    }
  }
  
  @NonNull
  public static FileHandler createFileHandler(@NonNull String paramString)
  {
    AutoFlushFileHandler.DefaultStrategy localDefaultStrategy = new AutoFlushFileHandler.DefaultStrategy();
    String str = "tnc_qqmail_5.0.3".substring(0, 16);
    return new AutoFlushFileHandler(new QueueFileHandler(new TEAFileHandler(new FileHandler(paramString, "%yyyy%mm%dd.log", 2, "%mm-%dd %HH:%MM:%SS.%sss [%level] %pid[%pname] %tid[%tname] [%tag]: "), str.getBytes())), localDefaultStrategy);
  }
  
  @NonNull
  public static MLogConfiguration getInstance()
  {
    return _instance;
  }
  
  private static int level()
  {
    if ((AppConfig.isLimited()) || (AppConfig.isLogcat())) {
      return 2;
    }
    return SPManager.getSp("mlog_info", false).getInt("log_level_2", 4);
  }
  
  private static boolean logcatEnable(boolean paramBoolean)
  {
    boolean bool = false;
    if ((AppConfig.isLogcat()) || (SPManager.getSp("mlog_info", paramBoolean).getBoolean("logcat", false))) {
      bool = true;
    }
    return bool;
  }
  
  private static int resolveLogLevel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 4;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 2: 
      default: 
        return 4;
      case 0: 
        return 2;
        if (paramString.equals("v"))
        {
          i = 0;
          continue;
          if (paramString.equals("d"))
          {
            i = 1;
            continue;
            if (paramString.equals("i"))
            {
              i = 2;
              continue;
              if (paramString.equals("w"))
              {
                i = 3;
                continue;
                if (paramString.equals("e"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("a")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return 3;
    return 5;
    return 6;
    return 7;
  }
  
  private void updateLevel()
  {
    Iterator localIterator = this.logList.iterator();
    while (localIterator.hasNext()) {
      updateLevel((MLog)localIterator.next());
    }
  }
  
  private void updateLevel(MLog paramMLog)
  {
    paramMLog = paramMLog.getAllHandler();
    int j = paramMLog.length;
    int i = 0;
    while (i < j)
    {
      paramMLog[i].setLevel(this.level);
      i += 1;
    }
  }
  
  private void updateLogcat()
  {
    Iterator localIterator = this.logList.iterator();
    while (localIterator.hasNext()) {
      updateLogcat((MLog)localIterator.next());
    }
  }
  
  private void updateLogcat(MLog paramMLog)
  {
    Handler[] arrayOfHandler = paramMLog.getAllHandler();
    int j = arrayOfHandler.length;
    int i = 0;
    Handler localHandler;
    if (i < j)
    {
      localHandler = arrayOfHandler[i];
      if (!(localHandler instanceof LogcatHandler)) {}
    }
    for (;;)
    {
      if (this.logcat) {
        if (localHandler == null) {
          paramMLog.addHandler(new LogcatHandler());
        }
      }
      while (localHandler == null)
      {
        return;
        i += 1;
        break;
      }
      paramMLog.removeHandler(localHandler);
      return;
      localHandler = null;
    }
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public void handleSchemaPush(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = paramString.split("&");
    } while (paramString.length <= 0);
    int j = paramString.length;
    int i = 0;
    label25:
    Object localObject;
    if (i < j)
    {
      localObject = paramString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label50;
      }
    }
    label50:
    do
    {
      i += 1;
      break label25;
      break;
      localObject = ((String)localObject).split("=");
    } while ((localObject.length != 2) || (!"level".equals(localObject[0])));
    setLevel(resolveLogLevel(localObject[1]));
  }
  
  public boolean isLogcatEnabled()
  {
    return this.logcat;
  }
  
  public void monitor(MLog paramMLog)
  {
    if (!this.logList.contains(paramMLog)) {
      this.logList.add(paramMLog);
    }
  }
  
  public void removeMonitor(MLog paramMLog)
  {
    this.logList.remove(paramMLog);
  }
  
  public void setLevel(@IntRange(from=2L, to=7L) int paramInt)
  {
    if (this.level != paramInt)
    {
      this.level = paramInt;
      SPManager.getEditor("mlog_info").putInt("log_level_2", paramInt).commit();
      SPManager.notifyChanged("mlog_info");
      updateLevel();
    }
  }
  
  public void setLogcatEnable(boolean paramBoolean)
  {
    if (this.logcat != paramBoolean)
    {
      this.logcat = paramBoolean;
      SPManager.getEditor("mlog_info").putBoolean("logcat", paramBoolean).commit();
      SPManager.notifyChanged("mlog_info");
      updateLogcat();
    }
  }
  
  public void update(MLog paramMLog)
  {
    updateLogcat(paramMLog);
    updateLevel(paramMLog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.MLogConfiguration
 * JD-Core Version:    0.7.0.1
 */