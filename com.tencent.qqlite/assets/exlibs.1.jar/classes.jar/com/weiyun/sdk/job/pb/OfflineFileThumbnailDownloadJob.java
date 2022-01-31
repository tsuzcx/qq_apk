package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.pb.PbOfflineFileThunbnailAddressFetcher;
import com.weiyun.sdk.job.transfer.HttpDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class OfflineFileThumbnailDownloadJob
  extends OfflineFileDownloadJob
{
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public OfflineFileThumbnailDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramDownloadJobContext, paramInt);
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return new PbOfflineFileThunbnailAddressFetcher(this.mJobContext.getUin(), this.mJobContext.getFileId(), this.mOfflineFileType, this.mThumbnailType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new HttpDownloadTransfer(paramTransferAddress, this.mJobContext, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.pb.OfflineFileThumbnailDownloadJob
 * JD-Core Version:    0.7.0.1
 */