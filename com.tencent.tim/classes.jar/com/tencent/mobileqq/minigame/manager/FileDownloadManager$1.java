package com.tencent.mobileqq.minigame.manager;

import android.os.SystemClock;
import asum;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class FileDownloadManager$1
  implements Callback
{
  private long beginEnqueue = SystemClock.uptimeMillis();
  private volatile boolean canceled;
  
  FileDownloadManager$1(String paramString1, DownloaderProxy.DownloadListener paramDownloadListener, String paramString2, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("FileDownloadManager", 1, "httpConnect err url:" + this.val$url, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.canceled = true;
      this.val$listener.onDownloadFailed(-5, "abort");
    }
    for (;;)
    {
      FileDownloadManager.access$000().remove(this.val$url);
      return;
      this.val$listener.onDownloadFailed(asum.getRetCodeFrom(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
    throws IOException
  {
    if (this.canceled) {
      return;
    }
    int k = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.val$listener.onDownloadHeadersReceived(k, paramCall);
    Object localObject = new File(this.val$filePath);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      if (!((File)localObject).getParentFile().exists()) {
        ((File)localObject).getParentFile().mkdirs();
      }
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      long l1;
      int i;
      for (;;)
      {
        InputStream localInputStream;
        byte[] arrayOfByte;
        this.val$listener.onDownloadFailed(2, "download error:local io exception");
        FileDownloadManager.access$000().remove(this.val$url);
      }
      localIOException.close();
      ((OutputStream)localObject).close();
      long l2 = SystemClock.uptimeMillis();
      this.val$listener.onDownloadProgress(0.99F, i, i);
      paramCall = new DownloaderProxy.DownloadListener.DownloadResult(paramResponse.request().url().toString(), k, paramResponse.isSuccessful(), paramResponse.message(), false, 0L, 0L, 0L, 0L, SystemClock.uptimeMillis() - this.val$startTime, paramResponse.body().contentLength(), paramCall);
      this.val$listener.onDownloadSucceed(k, this.val$filePath, paramCall);
      FileDownloadManager.access$000().remove(this.val$url);
      QLog.e("FileDownloadManager", 1, "downloadWithOkhttp [timecost=" + (SystemClock.uptimeMillis() - this.beginEnqueue) + "][receiveData=" + (l2 - l1) + "] [url=" + this.val$url + "]");
    }
    l1 = SystemClock.uptimeMillis();
    localInputStream = paramResponse.body().byteStream();
    localObject = new FileOutputStream((File)localObject);
    l2 = paramResponse.body().contentLength();
    arrayOfByte = new byte[4096];
    i = 0;
    for (;;)
    {
      int j = localInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      ((OutputStream)localObject).write(arrayOfByte, 0, j);
      j = i + j;
      i = j;
      if (l2 > 0L)
      {
        this.val$listener.onDownloadProgress(j * 1.0F / (float)l2, j, l2);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.FileDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */