package com.weiyun.sdk.job.af.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.ImageDownloadAddress;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.util.ThumbnailUtils;

public class PbThumbnailAddressFetcher
  extends DownloadAddressFetcher
{
  protected final String mCokieeName;
  protected final String mCokieeValue;
  protected final String mEncryptUrl;
  protected final String mFileName;
  protected final String mHost;
  protected final int mPort;
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public PbThumbnailAddressFetcher(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(0L, null, null, null, null);
    this.mFileName = paramString1;
    this.mHost = paramString2;
    this.mPort = paramInt;
    this.mEncryptUrl = paramString3;
    this.mCokieeName = paramString4;
    this.mCokieeValue = paramString5;
    this.mThumbnailType = paramThumbnailType;
  }
  
  public AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return new AddressFetcher.ImageDownloadAddress(paramString1, paramInt, paramString2, paramString3, 30223, paramString4, paramString5, ThumbnailUtils.getThumbnailSpec(this.mThumbnailType));
  }
  
  protected int sendRequest()
  {
    successGetAddress(createDownloadAddress(this.mHost, this.mPort, this.mFileName, this.mEncryptUrl, this.mCokieeName, this.mCokieeValue));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbThumbnailAddressFetcher
 * JD-Core Version:    0.7.0.1
 */