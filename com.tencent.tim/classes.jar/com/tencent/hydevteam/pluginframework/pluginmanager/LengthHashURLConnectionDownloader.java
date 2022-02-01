package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.util.Log;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

class LengthHashURLConnectionDownloader
  extends SimpleURLConnectionDownloader
{
  private final ExecutorService a = Executors.newSingleThreadExecutor();
  
  public ProgressFuture<File> download(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2)
  {
    AtomicLong localAtomicLong = new AtomicLong(0L);
    double d = paramTargetDownloadInfo.size;
    paramTargetDownloadInfo = new LengthHashDownloadTask(paramTargetDownloadInfo, paramFile1, paramFile2, localAtomicLong);
    return new LengthHashURLConnectionDownloader.1(this.a.submit(paramTargetDownloadInfo), d, localAtomicLong);
  }
  
  class LengthHashDownloadTask
    extends SimpleURLConnectionDownloader.DownloadTask
  {
    public LengthHashDownloadTask(File paramFile1, File paramFile2, AtomicLong paramAtomicLong)
    {
      super(paramFile1, paramFile2, paramAtomicLong);
    }
    
    public final File a()
      throws Exception
    {
      long l = this.a.length();
      HttpURLConnection localHttpURLConnection = b();
      int i = localHttpURLConnection.getContentLength();
      if ((l != 0L) && (l == i)) {
        Log.d("LengthCheckDownloader", "下载的文件没有变化，不进行下载 fileLenght:" + l);
      }
      for (;;)
      {
        return this.a;
        a(localHttpURLConnection);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.LengthHashURLConnectionDownloader
 * JD-Core Version:    0.7.0.1
 */