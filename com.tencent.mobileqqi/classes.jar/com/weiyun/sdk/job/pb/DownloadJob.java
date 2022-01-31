package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.job.af.pb.PbDownloadAddressFetcher;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;

public class DownloadJob
  extends BaseDownloadJob
{
  protected final int mSource;
  
  public DownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext)
  {
    super(paramLong, paramDownloadJobContext);
    this.mSource = 0;
  }
  
  public DownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    super(paramLong, paramDownloadJobContext);
    this.mSource = paramInt;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileId() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(-10001);
      return false;
    }
    return true;
  }
  
  public boolean checkEnvironment()
  {
    if (!NetworkUtils.hasInternet(null))
    {
      setLastErrorNo(-10003);
      return false;
    }
    return true;
  }
  
  protected DownloadAddressFetcher createDownloadAddressFetcher()
  {
    return new PbDownloadAddressFetcher(this.mJobContext.getFileId(), this.mJobContext.getFileName(), this.mSource, this.mJobContext.getMd5());
  }
  
  protected int handleFetchUrlFailed(int paramInt)
  {
    paramInt = super.handleFetchUrlFailed(paramInt);
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    try
    {
      synchronized (this.mJobContext)
      {
        this.mJobContext.wait(5000L);
        return paramInt;
      }
      return -10002;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  protected void handleFetchUrlSuccess(AddressFetcher paramAddressFetcher, AddressFetcher.TransferAddress paramTransferAddress)
  {
    super.setDownloadAddress((AddressFetcher.DownloadAddress)paramTransferAddress);
    paramAddressFetcher = ((PbDownloadAddressFetcher)paramAddressFetcher).getCloudMd5();
    paramTransferAddress = this.mJobContext.getMd5();
    if (!Utils.isEmptyString(paramTransferAddress))
    {
      if (!paramTransferAddress.equals(paramAddressFetcher))
      {
        Utils.removeFile(this.mJobContext.getDataFilePath());
        this.mJobContext.setCurSize(0L);
      }
      return;
    }
    this.mJobContext.setMd5(paramAddressFetcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.DownloadJob
 * JD-Core Version:    0.7.0.1
 */