package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DownloadTransfer
  extends BaseDownloadTransfer
{
  public DownloadTransfer(AddressFetcher.DownloadAddress paramDownloadAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramDownloadAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return true;
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mDownloadAddress;
    paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
    paramHttpURLConnection.setRequestProperty("Cookie", localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.DownloadTransfer
 * JD-Core Version:    0.7.0.1
 */