package com.tencent.android.tpns.mqtt.internal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;

public class FileLock
{
  private RandomAccessFile file;
  private Object fileLock;
  private File lockFile;
  
  public FileLock(File paramFile, String paramString)
    throws Exception
  {
    this.lockFile = new File(paramFile, paramString);
    if (ExceptionHelper.isClassAvailable("java.nio.channels.FileLock")) {
      try
      {
        this.file = new RandomAccessFile(this.lockFile, "rw");
        paramFile = this.file.getClass().getMethod("getChannel", new Class[0]).invoke(this.file, new Object[0]);
        this.fileLock = paramFile.getClass().getMethod("tryLock", new Class[0]).invoke(paramFile, new Object[0]);
        if (this.fileLock == null)
        {
          release();
          throw new Exception("Problem obtaining file lock");
        }
      }
      catch (NoSuchMethodException paramFile)
      {
        for (;;)
        {
          this.fileLock = null;
        }
      }
      catch (IllegalArgumentException paramFile)
      {
        for (;;)
        {
          this.fileLock = null;
        }
      }
      catch (IllegalAccessException paramFile)
      {
        for (;;)
        {
          this.fileLock = null;
        }
      }
    }
  }
  
  public void release()
  {
    try
    {
      if (this.fileLock != null)
      {
        this.fileLock.getClass().getMethod("release", new Class[0]).invoke(this.fileLock, new Object[0]);
        this.fileLock = null;
      }
      label40:
      if (this.file != null) {}
      try
      {
        this.file.close();
        label54:
        this.file = null;
        if ((this.lockFile != null) && (this.lockFile.exists())) {
          this.lockFile.delete();
        }
        this.lockFile = null;
        return;
      }
      catch (IOException localIOException)
      {
        break label54;
      }
    }
    catch (Throwable localThrowable)
    {
      break label40;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.FileLock
 * JD-Core Version:    0.7.0.1
 */