package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.job.af.pb.PbThumbnailAddressFetcher;
import com.weiyun.sdk.job.transfer.ThumbnailDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class ThumbnailDownloadJob
  extends DownloadJob
{
  protected final ThumbnailDownloadAddress mThumbnailAddress;
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public ThumbnailDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, ThumbnailDownloadAddress paramThumbnailDownloadAddress, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramDownloadJobContext);
    this.mThumbnailAddress = paramThumbnailDownloadAddress;
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected DownloadAddressFetcher createDownloadAddressFetcher()
  {
    return new PbThumbnailAddressFetcher(this.mJobContext.getFileName(), this.mThumbnailAddress.serverHost, this.mThumbnailAddress.serverPort, this.mThumbnailAddress.encryptUrl, this.mThumbnailAddress.cokieeName, this.mThumbnailAddress.cokieeValue, this.mThumbnailType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new ThumbnailDownloadTransfer((AddressFetcher.DownloadAddress)paramTransferAddress, this.mJobContext, this);
  }
  
  public static class ThumbnailDownloadAddress
  {
    public final String cokieeName;
    public final String cokieeValue;
    public final String encryptUrl;
    public final String serverHost;
    public final int serverPort;
    
    public ThumbnailDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.serverHost = paramString1;
      this.serverPort = paramInt;
      this.encryptUrl = paramString2;
      this.cokieeName = paramString3;
      this.cokieeValue = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.ThumbnailDownloadJob
 * JD-Core Version:    0.7.0.1
 */