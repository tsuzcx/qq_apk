package com.tencent.mobileqq.hotpic;

import ahzu;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class DiskStorageManager
{
  private int mMaxCount;
  private MqqHandler r = ThreadManager.getSubThreadHandler();
  
  public DiskStorageManager()
  {
    this(50);
  }
  
  public DiskStorageManager(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max count must be positive number!");
    }
    this.mMaxCount = paramInt;
  }
  
  private void lc(List<File> paramList)
  {
    int i = paramList.size();
    if (i <= this.mMaxCount)
    {
      QLog.d("DiskStorageManager", 2, "trim directly return data");
      return;
    }
    paramList = paramList.iterator();
    label31:
    File localFile;
    if (paramList.hasNext())
    {
      localFile = (File)paramList.next();
      if (a(localFile, 0L, i)) {
        break label112;
      }
      localFile.length();
      if (!localFile.delete()) {
        break label79;
      }
      i -= 1;
    }
    label79:
    label112:
    for (;;)
    {
      break label31;
      break;
      Log.d("DiskStorageManager", "delte file " + localFile.getName() + " fail");
    }
  }
  
  private void w(File paramFile)
    throws IOException
  {
    lc(ahzu.c(paramFile.getParentFile()));
  }
  
  protected boolean a(File paramFile, long paramLong, int paramInt)
  {
    return paramInt <= this.mMaxCount;
  }
  
  class TouchCallable
    implements Runnable
  {
    private final File file;
    
    public void run()
    {
      try
      {
        DiskStorageManager.a(this.this$0, this.file);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        QLog.d("DiskStorageManager", 2, "IO exception run error in background", localIOException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.DiskStorageManager
 * JD-Core Version:    0.7.0.1
 */