package com.weiyun.sdk.util;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class HttpDownloader
{
  private static final String TAG = "HttpDownloader";
  protected final File mFile;
  private IoPipe.ProgressListener mProgressListener;
  protected final HttpReader mReader;
  
  public HttpDownloader(HttpReader paramHttpReader, File paramFile)
  {
    this.mReader = paramHttpReader;
    this.mFile = paramFile;
  }
  
  public HttpDownloader(String paramString, File paramFile)
    throws MalformedURLException
  {
    this(new HttpReader(paramString, null), paramFile);
  }
  
  public HttpDownloader(String paramString1, String paramString2)
    throws MalformedURLException
  {
    this(paramString1, new File(paramString2));
  }
  
  public int download()
  {
    return download(this.mFile);
  }
  
  public int download(File paramFile)
  {
    try
    {
      int i = injection();
      if (i != 0) {
        return i;
      }
      paramFile = new JobIoPipe(this.mReader.getStream(), paramFile);
      paramFile.setProgressListener(this.mProgressListener);
      boolean bool = paramFile.pipe(this.mReader.getContentLength());
      if (bool) {}
      for (i = 0;; i = -10002) {
        return i;
      }
      return -10014;
    }
    catch (IOException paramFile)
    {
      Log.w("HttpDownloader", "download file " + this.mReader.getUrl(), paramFile);
      return ErrCodeUtil.getErrCodeFromIOException(paramFile);
    }
    catch (Exception paramFile)
    {
      Log.w("HttpDownloader", "download file " + this.mReader.getUrl(), paramFile);
    }
  }
  
  protected int injection()
    throws IOException
  {
    String str = this.mReader.getHttpUrlConnection().getHeaderField("X-ErrNo");
    if (str != null)
    {
      Log.w("HttpDownloader", "X-ErrNo:" + str);
      return -29004;
    }
    return 0;
  }
  
  public void setProgressListener(IoPipe.ProgressListener paramProgressListener)
  {
    this.mProgressListener = paramProgressListener;
  }
  
  private static class JobIoPipe
    extends IoPipe
  {
    public JobIoPipe(InputStream paramInputStream, File paramFile)
      throws FileNotFoundException
    {
      super(paramFile);
    }
    
    public boolean isCanceled()
    {
      return Thread.interrupted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.HttpDownloader
 * JD-Core Version:    0.7.0.1
 */