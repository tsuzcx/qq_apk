package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.ImageDownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ThumbnailTryOrginalDownloadTransfer
  extends BaseDownloadTransfer
{
  private static final String TAG = "PSDownloadTransfer";
  private boolean mDownloadOriginalImage = false;
  
  public ThumbnailTryOrginalDownloadTransfer(AddressFetcher.DownloadAddress paramDownloadAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramDownloadAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    if (this.mDownloadOriginalImage) {
      return new URL("http", this.mDownloadAddress.getHost(), this.mDownloadAddress.getPort(), this.mDownloadAddress.getFile());
    }
    AddressFetcher.ImageDownloadAddress localImageDownloadAddress = (AddressFetcher.ImageDownloadAddress)this.mDownloadAddress;
    return new URL("http", localImageDownloadAddress.getHost(), localImageDownloadAddress.getPort(), localImageDownloadAddress.getThumbnailFile());
  }
  
  protected Transfer.Result doDownload()
  {
    Transfer.Result localResult = super.doDownload();
    if ((localResult.mRet != 0) && (!this.mDownloadOriginalImage))
    {
      int i = localResult.mRet + 30000;
      if ((localResult.mRet == -29004) || (i == 500) || (i == 403) || (i == 404))
      {
        Log.w("PSDownloadTransfer", "down load thumb image failed, file not exist. file=" + this.mContext.getFileName());
        if (NetworkUtils.isWIFI(null)) {
          this.mDownloadOriginalImage = true;
        }
        this.mContext.setCurSize(0L);
        this.mOffset = 0L;
        if (this.mDestFileWriter == null) {}
      }
    }
    try
    {
      this.mDestFileWriter.setLength(0L);
      return localResult;
    }
    catch (IOException localIOException)
    {
      Log.w("PSDownloadTransfer", localIOException);
      localResult.mRet = -10008;
      localResult.mErrMsg = Utils.getStackTraceAsString(localIOException);
    }
    return localResult;
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return this.mDownloadOriginalImage;
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mDownloadAddress;
    paramHttpURLConnection.setRequestProperty("Cookie", localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue());
    if (this.mDownloadOriginalImage) {
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.ThumbnailTryOrginalDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */