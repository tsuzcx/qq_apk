package com.weiyun.sdk.job;

import android.util.Log;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.SimpleHttpAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.transfer.HttpDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDownloadJob
  extends BaseDownloadJob
{
  private static final String TAG = "HttpDownloadJob";
  protected AddressFetcher.TransferAddress mAddress;
  
  public HttpDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, String paramString)
  {
    super(paramLong, paramDownloadJobContext);
    try
    {
      this.mAddress = new AddressFetcher.SimpleHttpAddress(paramString);
      return;
    }
    catch (MalformedURLException paramDownloadJobContext)
    {
      Log.w("HttpDownloadJob", paramDownloadJobContext);
    }
  }
  
  public HttpDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, URL paramURL)
  {
    super(paramLong, paramDownloadJobContext);
    this.mAddress = new AddressFetcher.SimpleHttpAddress(paramURL);
  }
  
  public HttpDownloadJob(long paramLong, AddressFetcher.DownloadAddress paramDownloadAddress, String paramString)
  {
    super(paramLong, createDownloadJobContext(paramLong, paramDownloadAddress.toUrl(), paramString));
    this.mAddress = paramDownloadAddress;
  }
  
  public HttpDownloadJob(long paramLong, String paramString1, String paramString2)
  {
    this(paramLong, createDownloadJobContext(paramLong, paramString1, paramString2), paramString1);
  }
  
  public HttpDownloadJob(long paramLong, URL paramURL, String paramString)
  {
    this(paramLong, createDownloadJobContext(paramLong, paramURL.toString(), paramString), paramURL);
  }
  
  private static DownloadJobContext createDownloadJobContext(long paramLong, String paramString1, String paramString2)
  {
    String str = new File(paramString2).getName();
    paramString1 = null;
    int i = paramString2.lastIndexOf('/');
    if (i >= 0) {
      paramString1 = paramString2.substring(0, i + 1);
    }
    paramString1 = new DownloadJobContext(0L, paramLong, paramString1);
    paramString1.setCurSize(0L);
    paramString1.setModifyTime(0L);
    paramString1.setFileName(str);
    paramString1.setDestFileName(str);
    return paramString1;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(-10001);
      return false;
    }
    return true;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return null;
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new HttpDownloadTransfer(paramTransferAddress, this.mJobContext, this);
  }
  
  protected boolean fetchUrl()
  {
    return this.mAddress != null;
  }
  
  public AddressFetcher.TransferAddress getDownloadAddress()
  {
    return this.mAddress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.HttpDownloadJob
 * JD-Core Version:    0.7.0.1
 */