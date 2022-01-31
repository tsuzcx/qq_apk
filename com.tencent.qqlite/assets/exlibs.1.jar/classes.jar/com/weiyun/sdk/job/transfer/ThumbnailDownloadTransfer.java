package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.ImageDownloadAddress;
import com.weiyun.sdk.util.NetworkUtils;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ThumbnailDownloadTransfer
  extends BaseDownloadTransfer
{
  private static final int DEFAULT_TRY_TIMES = 2;
  
  public ThumbnailDownloadTransfer(AddressFetcher.DownloadAddress paramDownloadAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramDownloadAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    AddressFetcher.ImageDownloadAddress localImageDownloadAddress = (AddressFetcher.ImageDownloadAddress)this.mDownloadAddress;
    return new URL("http", localImageDownloadAddress.getHost(), localImageDownloadAddress.getPort(), localImageDownloadAddress.getThumbnailFile());
  }
  
  protected int getMaxTryTimes()
  {
    return 2;
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mDownloadAddress;
    paramHttpURLConnection.setRequestProperty("Cookie", localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue());
    if (!NetworkUtils.isWIFI(null))
    {
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 40000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 40000);
      return;
    }
    paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 25000);
    paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 40000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.ThumbnailDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */