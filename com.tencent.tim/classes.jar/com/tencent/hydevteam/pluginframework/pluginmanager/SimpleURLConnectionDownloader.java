package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFuture;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

class SimpleURLConnectionDownloader
  implements Downloader
{
  private final ExecutorService a = Executors.newSingleThreadExecutor();
  
  public ProgressFuture<File> download(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2)
  {
    AtomicLong localAtomicLong = new AtomicLong(0L);
    double d = paramTargetDownloadInfo.size;
    paramTargetDownloadInfo = new DownloadTask(paramTargetDownloadInfo, paramFile1, paramFile2, localAtomicLong);
    return new SimpleURLConnectionDownloader.1(this.a.submit(paramTargetDownloadInfo), d, localAtomicLong);
  }
  
  class DownloadTask
    implements Callable<File>
  {
    final File a;
    private File c;
    private AtomicLong d;
    
    DownloadTask(File paramFile1, File paramFile2, AtomicLong paramAtomicLong)
    {
      this.a = paramFile1;
      this.d = paramAtomicLong;
      this.c = paramFile2;
    }
    
    public File a()
      throws Exception
    {
      a(b());
      return this.a;
    }
    
    final void a(HttpURLConnection paramHttpURLConnection)
      throws Exception
    {
      arrayOfByte = null;
      int i = 0;
      if ((this.c.exists()) && (!this.c.delete())) {
        throw new Exception("无法删除" + this.c.getAbsolutePath());
      }
      Object localObject1 = this.c.getParentFile();
      ((File)localObject1).mkdirs();
      if (!((File)localObject1).isDirectory()) {
        throw new Exception("创建目录失败:" + ((File)localObject1).getAbsolutePath());
      }
      this.c.createNewFile();
      for (;;)
      {
        try
        {
          boolean bool = SimpleURLConnectionDownloader.this.hash.isEmpty();
          if (bool) {
            continue;
          }
        }
        finally
        {
          RandomAccessFile localRandomAccessFile;
          int j;
          Object localObject2 = arrayOfByte;
          continue;
        }
        try
        {
          localObject1 = MessageDigest.getInstance("MD5");
          localRandomAccessFile = new RandomAccessFile(this.c, "rw");
          try
          {
            arrayOfByte = new byte[4096];
            paramHttpURLConnection = new BufferedInputStream(paramHttpURLConnection.getInputStream());
            j = paramHttpURLConnection.read(arrayOfByte);
            if (j <= 0) {
              continue;
            }
            localRandomAccessFile.write(arrayOfByte, 0, j);
            this.d.getAndAdd(j);
            if (localObject1 != null) {
              ((MessageDigest)localObject1).update(arrayOfByte, 0, j);
            }
            if (!Thread.interrupted()) {
              continue;
            }
            throw new Error("interrupted");
          }
          finally
          {
            localObject1 = localRandomAccessFile;
          }
          if (localObject1 != null) {
            ((RandomAccessFile)localObject1).close();
          }
          throw paramHttpURLConnection;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
        localObject2 = null;
      }
      paramHttpURLConnection.close();
      localRandomAccessFile.close();
      if (localObject2 != null)
      {
        paramHttpURLConnection = ((MessageDigest)localObject2).digest();
        localObject2 = new StringBuilder(paramHttpURLConnection.length << 1);
        j = paramHttpURLConnection.length;
        while (i < j)
        {
          ((StringBuilder)localObject2).append(Integer.toHexString(paramHttpURLConnection[i] & 0xFF | 0x100).substring(1, 3));
          i += 1;
        }
        paramHttpURLConnection = ((StringBuilder)localObject2).toString();
        if (!paramHttpURLConnection.equalsIgnoreCase(SimpleURLConnectionDownloader.this.hash)) {
          throw new Error("MD5检验失败expect==" + SimpleURLConnectionDownloader.this.hash + " actual==" + paramHttpURLConnection);
        }
      }
      MinFileUtils.a(this.a);
      if (!this.c.renameTo(this.a)) {
        throw new Exception("重命名失败: " + this.c.getAbsolutePath() + "->" + this.a.getAbsolutePath());
      }
    }
    
    final HttpURLConnection b()
      throws IOException
    {
      Object localObject = SimpleURLConnectionDownloader.this.url;
      URLConnection localURLConnection = new URL((String)localObject).openConnection();
      if (!(localURLConnection instanceof HttpURLConnection)) {
        throw new Error((String)localObject + "连接不是http(s)协议的");
      }
      localObject = (HttpURLConnection)localURLConnection;
      if (((HttpURLConnection)localObject).getResponseCode() != 200) {
        throw new Error("连接返回值不是200,而为" + ((HttpURLConnection)localObject).getResponseCode());
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader
 * JD-Core Version:    0.7.0.1
 */