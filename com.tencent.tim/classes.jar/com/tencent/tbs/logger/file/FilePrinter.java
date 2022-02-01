package com.tencent.tbs.logger.file;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tbs.logger.Formatter;
import com.tencent.tbs.logger.LogItem;
import com.tencent.tbs.logger.LogPrinter;
import com.tencent.tbs.logger.TBSLogger;
import com.tencent.tbs.logger.file.backup.BackupStrategy;
import com.tencent.tbs.logger.file.clean.CleanStrategy;
import com.tencent.tbs.logger.file.naming.LogNameGenerator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FilePrinter
  implements LogPrinter
{
  private boolean isAsync;
  private boolean isEncrypt;
  private Context mContext;
  private BackupStrategy mLogBackupStrategy;
  private CleanStrategy mLogCleanStrategy;
  private LogNameGenerator mLogNameGenerator;
  private volatile Worker mWorker = new Worker(null);
  private Writer mWriter = new Writer(null);
  
  public FilePrinter(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, LogNameGenerator paramLogNameGenerator, CleanStrategy paramCleanStrategy, BackupStrategy paramBackupStrategy)
  {
    this.isAsync = paramBoolean1;
    this.isEncrypt = paramBoolean2;
    this.mLogNameGenerator = paramLogNameGenerator;
    this.mLogCleanStrategy = paramCleanStrategy;
    this.mLogBackupStrategy = paramBackupStrategy;
    this.mContext = paramContext;
  }
  
  private void doPrintln(LogItem paramLogItem)
  {
    if (!openFileIfNecessary(paramLogItem))
    {
      new Throwable("log file open failed!").printStackTrace();
      return;
    }
    this.mWriter.appendLog(Formatter.formatLog(paramLogItem));
  }
  
  private String getLogPath()
  {
    Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == Process.myPid())
      {
        localObject = localRunningAppProcessInfo.processName.toLowerCase().replace(".", "_");
        localObject = new File(TBSLogger.getLogPath(), (String)localObject);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        return ((File)localObject).getAbsolutePath();
      }
    }
    return TBSLogger.getLogPath();
  }
  
  private boolean openFileIfNecessary(LogItem paramLogItem)
  {
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = this.mWriter.getFileName();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!this.mLogNameGenerator.isFileNameChangeable()) {
          break label175;
        }
      }
      localObject1 = this.mLogNameGenerator.generateFileName(paramLogItem);
      if ((localObject1 == null) || (((String)localObject1).trim().length() == 0)) {
        throw new IllegalArgumentException("File name should not be empty.");
      }
    }
    catch (Exception paramLogItem)
    {
      paramLogItem.printStackTrace();
    }
    int i;
    for (;;)
    {
      return false;
      if (!((String)localObject1).equals(localObject2))
      {
        if (this.mWriter.isOpened()) {
          this.mWriter.close();
        }
        paramLogItem = new File(getLogPath()).listFiles();
        if (paramLogItem != null)
        {
          int j = paramLogItem.length;
          i = 0;
          if (i < j)
          {
            localObject2 = paramLogItem[i];
            if (!this.mLogCleanStrategy.shouldClean((File)localObject2)) {
              break;
            }
            ((File)localObject2).delete();
            break;
          }
        }
        if (this.mWriter.open((String)localObject1)) {
          break label295;
        }
      }
    }
    label295:
    for (;;)
    {
      label175:
      paramLogItem = this.mWriter.getFile();
      if ((paramLogItem != null) && (this.mLogBackupStrategy.shouldBackup(paramLogItem)))
      {
        this.mWriter.close();
        localObject2 = new File(getLogPath(), (String)localObject1 + "-" + System.currentTimeMillis() % 86400000L);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        paramLogItem.renameTo((File)localObject2);
        boolean bool = this.mWriter.open((String)localObject1);
        return bool;
      }
      return true;
      i += 1;
      break;
    }
  }
  
  public void close()
  {
    this.mWriter.close();
    this.mWorker.close();
  }
  
  public void println(LogItem paramLogItem)
  {
    if (this.isAsync)
    {
      if (!this.mWorker.isStarted()) {
        this.mWorker.start();
      }
      this.mWorker.enqueue(paramLogItem);
      return;
    }
    doPrintln(paramLogItem);
  }
  
  class Worker
    implements Runnable
  {
    private BlockingQueue<LogItem> logs = new LinkedBlockingQueue();
    private volatile boolean started;
    
    private Worker() {}
    
    public void close()
    {
      try
      {
        this.logs.clear();
        this.started = false;
        return;
      }
      finally {}
    }
    
    void enqueue(LogItem paramLogItem)
    {
      try
      {
        this.logs.put(paramLogItem);
        return;
      }
      catch (InterruptedException paramLogItem)
      {
        paramLogItem.printStackTrace();
      }
    }
    
    boolean isStarted()
    {
      try
      {
        boolean bool = this.started;
        return bool;
      }
      finally {}
    }
    
    public void run()
    {
      try
      {
        for (;;)
        {
          LogItem localLogItem = (LogItem)this.logs.take();
          if (localLogItem == null) {
            break;
          }
          FilePrinter.this.doPrintln(localLogItem);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        try
        {
          this.started = false;
          return;
        }
        finally {}
      }
    }
    
    void start()
    {
      try
      {
        new Thread(this).start();
        this.started = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  class Writer
  {
    private File mLogFile;
    private String mLogFileName;
    private OutputStream mOutputStream;
    
    private Writer() {}
    
    void appendLog(String paramString)
    {
      if (this.mOutputStream != null) {}
      for (;;)
      {
        try
        {
          if (FilePrinter.this.isEncrypt)
          {
            String str = Encryption.createKeyOfPlainText();
            byte[] arrayOfByte = Encryption.getEncryptedKeyBytes("tbslog.txt", str);
            if (arrayOfByte != null)
            {
              paramString = Encryption.getEncryptedLogBytes(str, paramString, arrayOfByte);
              if (paramString != null) {
                this.mOutputStream.write(paramString);
              }
            }
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          if (this.mOutputStream == null) {
            continue;
          }
          try
          {
            this.mOutputStream.flush();
            return;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            return;
          }
        }
        finally
        {
          if (this.mOutputStream == null) {
            break label134;
          }
        }
        try
        {
          this.mOutputStream.flush();
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        if (!TextUtils.isEmpty(paramString)) {
          this.mOutputStream.write(paramString.getBytes());
        }
      }
      try
      {
        this.mOutputStream.flush();
        label134:
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    
    boolean close()
    {
      if (this.mOutputStream != null) {}
      try
      {
        this.mOutputStream.close();
        return true;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return false;
      }
      finally
      {
        this.mOutputStream = null;
        this.mLogFile = null;
      }
    }
    
    File getFile()
    {
      return this.mLogFile;
    }
    
    String getFileName()
    {
      return this.mLogFileName;
    }
    
    boolean isOpened()
    {
      return this.mOutputStream != null;
    }
    
    boolean open(String paramString)
    {
      this.mLogFileName = paramString;
      this.mLogFile = new File(FilePrinter.this.getLogPath(), paramString);
      if (!this.mLogFile.exists()) {}
      try
      {
        paramString = this.mLogFile.getParentFile();
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        this.mLogFile.createNewFile();
        return false;
      }
      catch (IOException paramString)
      {
        try
        {
          this.mOutputStream = new BufferedOutputStream(new FileOutputStream(this.mLogFile, true));
          return true;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          this.mLogFile = null;
        }
        paramString = paramString;
        paramString.printStackTrace();
        this.mLogFile = null;
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.FilePrinter
 * JD-Core Version:    0.7.0.1
 */