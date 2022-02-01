package com.weiyun.sdk.job.transfer;

import android.os.SystemClock;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.context.ErrorMessages;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.HttpDownloader;
import com.weiyun.sdk.util.HttpReader;
import com.weiyun.sdk.util.IoPipe.ProgressListener;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.io.File;

public class HttpDownloadTransfer
  implements Transfer, IoPipe.ProgressListener
{
  private static final String TAG = "HttpDownloadTransfer";
  protected final AddressFetcher.TransferAddress mAddress;
  protected final DownloadJobContext mContext;
  protected final BaseDownloadJob mJob;
  private final Transfer.ProcessInfo mProcessInfo;
  
  public HttpDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
    this.mProcessInfo = new Transfer.ProcessInfo();
    this.mProcessInfo.url = paramTransferAddress.toString();
    this.mProcessInfo.flowId = Global.generateRandomId(new Object[] { this.mProcessInfo.url, this });
    this.mProcessInfo.startTime = SystemClock.uptimeMillis();
  }
  
  private void doInnerReport(Transfer.Result paramResult, Transfer.ProcessInfo paramProcessInfo)
  {
    if (!Global.isInit()) {
      return;
    }
    WeiyunReportObj localWeiyunReportObj = new WeiyunReportObj(1);
    localWeiyunReportObj.network = NetworkUtils.getNetworkTypeForReport(Global.getContext());
    localWeiyunReportObj.dns_ip = paramProcessInfo.dns;
    localWeiyunReportObj.client_ip = paramProcessInfo.clientIp;
    localWeiyunReportObj.server_ip = paramProcessInfo.hostIp;
    localWeiyunReportObj.server_port = paramProcessInfo.hostPort;
    localWeiyunReportObj.flow_id = paramProcessInfo.flowId;
    localWeiyunReportObj.url = paramProcessInfo.url;
    localWeiyunReportObj.retry_times = paramProcessInfo.attemptCount;
    localWeiyunReportObj.conn_time = paramProcessInfo.connTimeCost;
    localWeiyunReportObj.recv_rsp = paramProcessInfo.recvRspTimeCost;
    localWeiyunReportObj.recv_data = paramProcessInfo.transferDataTimeCost;
    localWeiyunReportObj.total_delay = (SystemClock.uptimeMillis() - paramProcessInfo.startTime);
    localWeiyunReportObj.total_size = this.mContext.getTotalSize();
    localWeiyunReportObj.file_name = this.mContext.getFileName();
    localWeiyunReportObj.file_id = ('/' + this.mContext.getParentDirKey() + '/' + this.mContext.getFileId());
    localWeiyunReportObj.file_size = paramProcessInfo.transferDataSize;
    localWeiyunReportObj.file_path = this.mContext.getDestFilePath();
    localWeiyunReportObj.file_md5 = this.mContext.getMd5();
    localWeiyunReportObj.err_code = paramResult.mRet;
    localWeiyunReportObj.err_msg = paramResult.mErrMsg;
    if (paramProcessInfo.failException == null) {}
    for (paramResult = null;; paramResult = android.util.Log.getStackTraceString(paramProcessInfo.failException))
    {
      localWeiyunReportObj.exception = paramResult;
      if (paramProcessInfo.transferDataTimeCost > 0L) {
        localWeiyunReportObj.file_speed = (paramProcessInfo.transferDataSize / paramProcessInfo.transferDataTimeCost);
      }
      WeiyunReport.uploadReport(localWeiyunReportObj);
      return;
    }
  }
  
  public int doTransfer()
  {
    File localFile = new File(this.mContext.getDataFilePath());
    if ((this.mAddress instanceof AddressFetcher.DownloadAddress))
    {
      localObject = (AddressFetcher.DownloadAddress)this.mAddress;
      if ((((AddressFetcher.DownloadAddress)localObject).getCookieName() == null) || (((AddressFetcher.DownloadAddress)localObject).getCookieValue() == null)) {}
    }
    for (Object localObject = ((AddressFetcher.DownloadAddress)localObject).getCookieName() + "=" + ((AddressFetcher.DownloadAddress)localObject).getCookieValue();; localObject = null)
    {
      localObject = new HttpDownloader(new HttpReader(this.mAddress, (String)localObject), localFile);
      ((HttpDownloader)localObject).setProgressListener(this);
      return ((HttpDownloader)localObject).download(this.mProcessInfo);
    }
  }
  
  protected int moveToTarget()
  {
    Utils.checkDirAndCreate(this.mContext.getDestDirectoryPath());
    if (!new File(this.mContext.getDataFilePath()).renameTo(new File(this.mContext.getDestFilePath())))
    {
      if (Utils.checkFileExist(this.mContext.getDestFilePath()) == true)
      {
        String str = Utils.generateNewFilename(this.mContext.getDestFileName());
        this.mJob.renameDestFile(str);
      }
    }
    else {
      return 0;
    }
    com.weiyun.sdk.log.Log.e("HttpDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return -10008;
  }
  
  public void onProgressChanged(long paramLong1, long paramLong2)
  {
    this.mContext.setCurSize(paramLong1);
    this.mContext.setTotalSize(paramLong2);
    this.mJob.notifyProgressChanged(paramLong1, paramLong2);
  }
  
  public int transfer()
  {
    int j = doTransfer();
    int i = j;
    if (j == -10002)
    {
      i = j;
      if (this.mContext.getTotalSize() != 0L)
      {
        i = j;
        if (this.mContext.getTotalSize() == this.mContext.getCurSize())
        {
          com.weiyun.sdk.log.Log.i("HttpDownloadTransfer", "user canceled a finished job!");
          i = 0;
        }
      }
    }
    j = i;
    if (i == 0) {
      j = moveToTarget();
    }
    doInnerReport(new Transfer.Result(j, ErrorMessages.getErrorString(j)), this.mProcessInfo);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.HttpDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */