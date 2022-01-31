package com.weiyun.sdk.util;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoPipe
{
  private static final int BUFFER_SIZE = 8192;
  private static final String TAG = "IoPipe";
  protected final InputStream mInput;
  protected ProgressListener mListener;
  protected final OutputStream mOutput;
  
  public IoPipe(File paramFile, OutputStream paramOutputStream)
    throws FileNotFoundException
  {
    this(new BufferedInputStream(new FileInputStream(paramFile)), paramOutputStream);
  }
  
  public IoPipe(InputStream paramInputStream, File paramFile)
    throws FileNotFoundException
  {
    this(paramInputStream, new BufferedOutputStream(new FileOutputStream(paramFile)));
  }
  
  public IoPipe(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.mInput = paramInputStream;
    this.mOutput = paramOutputStream;
  }
  
  public boolean isCanceled()
  {
    return false;
  }
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public boolean pipe(long paramLong)
    throws IOException
  {
    if ((this.mInput == null) || (this.mOutput == null)) {
      return false;
    }
    long l = 0L;
    for (;;)
    {
      try
      {
        ProgressListener localProgressListener = this.mListener;
        byte[] arrayOfByte = new byte[8192];
        if (isCanceled())
        {
          Log.w("IoPipe", "pipe is canceled!");
          return false;
        }
        int i = this.mInput.read(arrayOfByte, 0, 8192);
        if (i == -1) {
          return true;
        }
        this.mOutput.write(arrayOfByte, 0, i);
        l += i;
        if (localProgressListener != null) {
          localProgressListener.onProgressChanged(l, paramLong);
        } else {
          onProgress(l, paramLong);
        }
      }
      finally
      {
        this.mInput.close();
        this.mOutput.close();
      }
    }
  }
  
  public void setProgressListener(ProgressListener paramProgressListener)
  {
    this.mListener = paramProgressListener;
  }
  
  public static abstract interface ProgressListener
  {
    public abstract void onProgressChanged(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.IoPipe
 * JD-Core Version:    0.7.0.1
 */