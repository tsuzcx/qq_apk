package org.libpag.reporter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reporter
{
  private static final String TAG = Reporter.class.getSimpleName() + "-" + Integer.toHexString(Reporter.class.hashCode());
  private Boolean auto;
  private File dir;
  private Handler ioHandler;
  private Runnable uploadRunnable = new Reporter.1(this);
  
  public Reporter(File paramFile, Boolean paramBoolean, Looper paramLooper)
  {
    this.dir = paramFile;
    this.auto = paramBoolean;
    paramFile = paramLooper;
    if (paramLooper == null)
    {
      paramFile = new HandlerThread(TAG);
      paramFile.setDaemon(true);
      paramFile.start();
      while (!paramFile.isAlive()) {}
      paramFile = paramFile.getLooper();
    }
    this.ioHandler = new Handler(paramFile);
    schedule();
  }
  
  private void report(String paramString)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("https://h.trace.qq.com/kv").openConnection();
      localHttpURLConnection.setConnectTimeout(1000);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setDoInput(false);
      localHttpURLConnection.setDoOutput(true);
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localHttpURLConnection.getOutputStream(), "UTF-8"));
      localBufferedWriter.write(paramString);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localHttpURLConnection.disconnect();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void schedule()
  {
    if ((this.auto.booleanValue()) && (this.ioHandler != null)) {
      this.ioHandler.postDelayed(this.uploadRunnable, 30000L);
    }
  }
  
  public void flush()
  {
    if (this.ioHandler != null)
    {
      this.ioHandler.removeCallbacks(this.uploadRunnable);
      this.ioHandler.post(this.uploadRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.reporter.Reporter
 * JD-Core Version:    0.7.0.1
 */