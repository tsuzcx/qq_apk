package com.pay.googlewalletsdk.http;

import com.pay.googlewaletsdk.entity.DownloadInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class BaseHttpClient
{
  IHttpDownAgency agency;
  byte[] content;
  protected long downSize;
  protected DownloadInfo downloadInfo;
  protected HttpURLConnection httpURLConnection;
  boolean ispause;
  boolean isstop;
  int len;
  ByteArrayOutputStream outputStream;
  protected URL url;
  
  public BaseHttpClient(DownloadInfo paramDownloadInfo)
  {
    this.downloadInfo = paramDownloadInfo;
    this.ispause = false;
    this.isstop = false;
  }
  
  private void closeOutput()
    throws Exception
  {
    if (this.httpURLConnection.getDoOutput())
    {
      this.httpURLConnection.getOutputStream().flush();
      this.httpURLConnection.getOutputStream().close();
    }
  }
  
  private void closeStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      if (paramOutputStream != null) {
        paramOutputStream.close();
      }
      this.httpURLConnection.disconnect();
      return;
    }
    catch (Exception paramInputStream) {}
  }
  
  private void getFileSize()
  {
    int i = 1;
    for (;;)
    {
      String str = this.httpURLConnection.getHeaderFieldKey(i);
      if (str != null)
      {
        if (!str.equals("Content-Length")) {
          break label61;
        }
        long l = Long.parseLong(this.httpURLConnection.getHeaderField(str));
        if (this.downloadInfo.getTotal_size() == 0L) {
          this.downloadInfo.setTotal_size(l);
        }
      }
      return;
      label61:
      i += 1;
    }
  }
  
  private void init()
    throws Exception
  {
    this.agency.onReady(this);
    this.url = new URL(modifyUrl());
    this.httpURLConnection = ((HttpURLConnection)this.url.openConnection());
    this.httpURLConnection.setConnectTimeout(15000);
    this.httpURLConnection.setReadTimeout(15000);
    this.httpURLConnection.setUseCaches(false);
    setHeader();
    setBody();
    closeOutput();
    this.httpURLConnection.connect();
    getFileSize();
    this.agency.onStart(this);
  }
  
  public void connect()
  {
    int i = 0;
    for (;;)
    {
      if (i >= 3) {
        return;
      }
      this.outputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = null;
      InputStream localInputStream = null;
      Object localObject2 = localInputStream;
      Object localObject1 = arrayOfByte;
      try
      {
        init();
        localObject2 = localInputStream;
        localObject1 = arrayOfByte;
        localInputStream = this.httpURLConnection.getInputStream();
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        arrayOfByte = new byte[1024];
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        int j = localInputStream.read(arrayOfByte);
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        this.len = j;
        if (j <= 0)
        {
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          this.content = this.outputStream.toByteArray();
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          this.agency.onFinish(this);
          closeStream(localInputStream, this.outputStream);
          return;
        }
        localObject2 = localInputStream;
        localObject1 = localInputStream;
        if (this.ispause)
        {
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          closeStream(localInputStream, this.outputStream);
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          this.agency.onPause(this);
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          Thread.currentThread().interrupt();
        }
        for (;;)
        {
          closeStream(localInputStream, this.outputStream);
          return;
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          if (!this.isstop) {
            break;
          }
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          closeStream(localInputStream, this.outputStream);
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          this.agency.onStop(this);
          localObject2 = localInputStream;
          localObject1 = localInputStream;
          Thread.currentThread().interrupt();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (i == 2)
          {
            localObject1 = localObject2;
            this.agency.onError(this);
          }
          i += 1;
          localObject1 = localObject2;
          localException.printStackTrace();
          closeStream((InputStream)localObject2, this.outputStream);
          break;
          localObject2 = localException;
          localObject1 = localException;
          this.outputStream.write(arrayOfByte, 0, this.len);
          localObject2 = localException;
          localObject1 = localException;
          this.downSize += this.len;
          localObject2 = localException;
          localObject1 = localException;
          this.agency.onDownLoading(arrayOfByte, this.len, this.downSize, this);
        }
      }
      finally
      {
        closeStream((InputStream)localObject1, this.outputStream);
      }
    }
  }
  
  public IHttpDownAgency getAgency()
  {
    return this.agency;
  }
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public long getDownSize()
  {
    return this.downSize;
  }
  
  public DownloadInfo getDownloadInfo()
  {
    return this.downloadInfo;
  }
  
  public ByteArrayOutputStream getOutputStream()
  {
    return this.outputStream;
  }
  
  protected String modifyUrl()
  {
    return this.downloadInfo.getUri();
  }
  
  public void pause()
  {
    this.ispause = true;
  }
  
  public void setAgency(IHttpDownAgency paramIHttpDownAgency)
  {
    this.agency = paramIHttpDownAgency;
  }
  
  public abstract void setBody();
  
  public void setContent(byte[] paramArrayOfByte)
  {
    this.content = paramArrayOfByte;
  }
  
  public void setDownSize(int paramInt)
  {
    this.downSize = paramInt;
  }
  
  public void setDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    this.downloadInfo = paramDownloadInfo;
  }
  
  public abstract void setHeader();
  
  public void setHightPriority()
  {
    Thread.currentThread().setPriority(10);
  }
  
  public void setLowPriority()
  {
    Thread.currentThread().setPriority(1);
  }
  
  public void setNormalPriority()
  {
    Thread.currentThread().setPriority(5);
  }
  
  public void setOutputStream(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    this.outputStream = paramByteArrayOutputStream;
  }
  
  public void stop()
  {
    this.isstop = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.http.BaseHttpClient
 * JD-Core Version:    0.7.0.1
 */