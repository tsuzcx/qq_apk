package com.weiyun.sdk.job.transfer;

import android.os.Build.VERSION;
import android.os.SystemClock;
import com.weiyun.sdk.ErrorCode;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class BaseDownloadTransfer
  implements Transfer
{
  private static final String TAG = "BaseDownloadTransfer";
  protected final DownloadJobContext mContext;
  protected RandomAccessFile mDestFileWriter;
  protected final AddressFetcher.TransferAddress mDownloadAddress;
  protected final BaseDownloadJob mJob;
  protected long mOffset;
  private final Transfer.ProcessInfo mProcessInfo;
  protected long mSplitSize = 8388608L;
  protected long mStartTime;
  protected int mTimeoutTimes = 0;
  protected boolean mUseSplitDownload = false;
  
  public BaseDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mDownloadAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
    this.mProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.mProcessInfo.url = createUrl().toString();
      label61:
      this.mProcessInfo.flowId = Global.generateRandomId(new Object[] { this.mProcessInfo.url, this });
      this.mProcessInfo.startTime = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramTransferAddress)
    {
      break label61;
    }
  }
  
  private Transfer.Result checkJob()
  {
    if (!this.mJob.isAlive()) {
      return new Transfer.Result(-10002, "取消了上传、下载过程!");
    }
    if (!this.mJob.checkEnvironment()) {
      return new Transfer.Result(this.mJob.getLastErrorNo(), "没有网络!");
    }
    return null;
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
  
  private Transfer.Result handleError(boolean paramBoolean, int paramInt, Transfer.Result paramResult)
  {
    long l;
    if ((paramResult.mRet == -30002) || (paramResult.mRet == -30028) || (paramResult.mRet == -30029))
    {
      this.mTimeoutTimes += 1;
      if ((!ErrorCode.isNetworkError(paramResult.mRet)) || (!paramBoolean) || (!this.mJob.isAlive())) {
        break label206;
      }
      l = (1200.0D * Math.pow(paramInt, 0.5D));
      com.weiyun.sdk.log.Log.i("BaseDownloadTransfer", "Last transfer network error, so rollback, sleep time = " + l + ", id = " + this.mJob.getId());
    }
    for (;;)
    {
      try
      {
        Thread.sleep(l);
        if ((paramResult.mRet == -30016) && (NetworkUtils.isCnwapConnection(null)) && (isSupportSplitDownload()))
        {
          if (this.mUseSplitDownload) {
            break label274;
          }
          this.mUseSplitDownload = true;
        }
        return new Transfer.Result(0, null);
      }
      catch (InterruptedException paramResult)
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramResult.getMessage(), paramResult);
        return new Transfer.Result(-10002, Utils.getStackTraceAsString(paramResult));
      }
      this.mTimeoutTimes = 0;
      break;
      label206:
      if ((paramResult.mRet == -29110) || (paramResult.mRet == -29006))
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", "file offset is wrong! offset :" + this.mContext.getCurSize());
        return cutFileToZero();
      }
      if (paramResult.mRet == -29203)
      {
        return paramResult;
        label274:
        this.mSplitSize /= 2L;
        this.mSplitSize = Math.max(this.mSplitSize, 8192L);
      }
    }
  }
  
  private void report(Transfer.Result paramResult)
  {
    switch (paramResult.mRet)
    {
    default: 
      this.mJob.reportDownloadTransferSize(3, paramResult.mRet, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
    }
    for (;;)
    {
      doInnerReport(paramResult, this.mProcessInfo);
      return;
      this.mJob.reportDownloadTransferSize(0, 0, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
      continue;
      this.mJob.reportDownloadTransferSize(1, -10002, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
    }
  }
  
  protected Transfer.Result acquireResource()
  {
    Object localObject2 = null;
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    if (j < 2) {}
    for (;;)
    {
      try
      {
        this.mDestFileWriter = new RandomAccessFile(this.mContext.getDataFilePath(), "rwd");
        i = 0;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        com.weiyun.sdk.log.Log.e("BaseDownloadTransfer", "", localFileNotFoundException);
        if (!Utils.checkFileExist(this.mContext.getDataDirectoryPath())) {
          continue;
        }
        i = -10008;
        continue;
        if (Utils.checkDirAndCreate(this.mContext.getDataDirectoryPath())) {
          continue;
        }
        i = -10008;
        continue;
        j += 1;
        i = -10006;
      }
      if (i != 0) {
        this.mProcessInfo.failException = localObject1;
      }
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        return new Transfer.Result(i, localObject1);
        break;
      }
      String str = Utils.getStackTraceAsString(localFileNotFoundException);
    }
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mDownloadAddress.getHost(), this.mDownloadAddress.getPort(), this.mDownloadAddress.getFile());
  }
  
  protected Transfer.Result cutFileToZero()
  {
    this.mOffset = 0L;
    this.mContext.setCurSize(0L);
    try
    {
      this.mDestFileWriter.setLength(0L);
      return new Transfer.Result(0, null);
    }
    catch (IOException localIOException)
    {
      com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", localIOException);
      this.mProcessInfo.failException = localIOException;
      return new Transfer.Result(-10008, Utils.getStackTraceAsString(localIOException));
    }
  }
  
  protected Transfer.Result doDownload()
  {
    Object localObject;
    if (!isSupportContinueInterruption())
    {
      localObject = cutFileToZero();
      if (((Transfer.Result)localObject).mRet == 0) {}
    }
    do
    {
      Transfer.Result localResult;
      do
      {
        do
        {
          return localObject;
          localResult = doDownloadImpl();
          localObject = localResult;
        } while (localResult.mRet != -10002);
        localObject = localResult;
      } while (this.mContext.getTotalSize() == 0L);
      localObject = localResult;
    } while (this.mContext.getTotalSize() != this.mContext.getCurSize());
    com.weiyun.sdk.log.Log.i("BaseDownloadTransfer", "user canceled a finished job!");
    return new Transfer.Result(0, null);
  }
  
  /* Error */
  protected Transfer.Result doDownloadImpl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 21
    //   6: aconst_null
    //   7: astore 19
    //   9: aconst_null
    //   10: astore 20
    //   12: iconst_0
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_1
    //   18: iconst_0
    //   19: istore 4
    //   21: aload_0
    //   22: invokevirtual 58	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   25: astore 18
    //   27: aload 18
    //   29: invokevirtual 444	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 446	java/net/HttpURLConnection
    //   35: astore 17
    //   37: iload 4
    //   39: istore_1
    //   40: iload_3
    //   41: istore_2
    //   42: aload_0
    //   43: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   46: aload 17
    //   48: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   51: invokevirtual 450	java/net/URL:getHost	()Ljava/lang/String;
    //   54: invokevirtual 454	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   57: iload 4
    //   59: istore_1
    //   60: iload_3
    //   61: istore_2
    //   62: aload_0
    //   63: aload 17
    //   65: invokevirtual 458	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   68: iload 4
    //   70: istore_1
    //   71: iload_3
    //   72: istore_2
    //   73: aload_0
    //   74: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   77: aload 18
    //   79: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   82: putfield 67	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:url	Ljava/lang/String;
    //   85: iload 4
    //   87: istore_1
    //   88: iload_3
    //   89: istore_2
    //   90: aload_0
    //   91: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   94: aload 17
    //   96: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   99: invokevirtual 450	java/net/URL:getHost	()Ljava/lang/String;
    //   102: putfield 148	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:hostIp	Ljava/lang/String;
    //   105: iload 4
    //   107: istore_1
    //   108: iload_3
    //   109: istore_2
    //   110: aload_0
    //   111: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   114: aload 17
    //   116: invokevirtual 449	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   119: invokevirtual 459	java/net/URL:getPort	()I
    //   122: invokestatic 464	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   125: putfield 154	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:hostPort	Ljava/lang/String;
    //   128: iload 4
    //   130: istore_1
    //   131: iload_3
    //   132: istore_2
    //   133: invokestatic 115	com/weiyun/sdk/Global:isInit	()Z
    //   136: ifeq +21 -> 157
    //   139: iload 4
    //   141: istore_1
    //   142: iload_3
    //   143: istore_2
    //   144: aload_0
    //   145: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   148: invokestatic 124	com/weiyun/sdk/Global:getContext	()Landroid/content/Context;
    //   151: invokestatic 468	com/weiyun/sdk/util/NetworkUtils:getDns	(Landroid/content/Context;)Ljava/lang/String;
    //   154: putfield 136	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:dns	Ljava/lang/String;
    //   157: iload 4
    //   159: istore_1
    //   160: iload_3
    //   161: istore_2
    //   162: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   165: lstore 9
    //   167: iload 4
    //   169: istore_1
    //   170: iload_3
    //   171: istore_2
    //   172: aload_0
    //   173: getfield 49	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   176: invokevirtual 94	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   179: ifne +87 -> 266
    //   182: iload 4
    //   184: istore_1
    //   185: iload_3
    //   186: istore_2
    //   187: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   190: dup
    //   191: sipush -10002
    //   194: ldc 98
    //   196: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   199: astore 18
    //   201: iconst_0
    //   202: ifeq +11 -> 213
    //   205: new 470	java/lang/NullPointerException
    //   208: dup
    //   209: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   212: athrow
    //   213: aload 17
    //   215: ifnull +8 -> 223
    //   218: aload 17
    //   220: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   223: aload 18
    //   225: areturn
    //   226: astore 17
    //   228: ldc 10
    //   230: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   233: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   236: aload 17
    //   238: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   245: aload 17
    //   247: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   250: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   253: dup
    //   254: sipush -30017
    //   257: aload 17
    //   259: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   262: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   265: areturn
    //   266: iload 4
    //   268: istore_1
    //   269: iload_3
    //   270: istore_2
    //   271: aload 17
    //   273: invokevirtual 484	java/net/HttpURLConnection:connect	()V
    //   276: iconst_1
    //   277: istore_3
    //   278: iconst_1
    //   279: istore 5
    //   281: iload 4
    //   283: istore_1
    //   284: iload 5
    //   286: istore_2
    //   287: aload_0
    //   288: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   291: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   294: lload 9
    //   296: lsub
    //   297: putfield 170	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:connTimeCost	J
    //   300: iload 4
    //   302: istore_1
    //   303: iload 5
    //   305: istore_2
    //   306: aload 17
    //   308: invokevirtual 487	java/net/HttpURLConnection:getResponseCode	()I
    //   311: istore 8
    //   313: iconst_1
    //   314: istore 4
    //   316: iconst_1
    //   317: istore 6
    //   319: iload 6
    //   321: istore_1
    //   322: iload 5
    //   324: istore_2
    //   325: aload_0
    //   326: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   329: invokestatic 82	android/os/SystemClock:uptimeMillis	()J
    //   332: lload 9
    //   334: lsub
    //   335: putfield 176	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:recvRspTimeCost	J
    //   338: iload 8
    //   340: sipush 200
    //   343: if_icmpeq +154 -> 497
    //   346: iload 8
    //   348: sipush 206
    //   351: if_icmpeq +146 -> 497
    //   354: iload 6
    //   356: istore_1
    //   357: iload 5
    //   359: istore_2
    //   360: aload 17
    //   362: ldc_w 489
    //   365: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   368: astore 23
    //   370: aload 23
    //   372: ifnull +125 -> 497
    //   375: iload 6
    //   377: istore_1
    //   378: iload 5
    //   380: istore_2
    //   381: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   384: dup
    //   385: aload 23
    //   387: invokestatic 497	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   390: ldc_w 499
    //   393: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   396: astore 24
    //   398: iconst_0
    //   399: ifeq +11 -> 410
    //   402: new 470	java/lang/NullPointerException
    //   405: dup
    //   406: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   409: athrow
    //   410: aload 17
    //   412: ifnull +8 -> 420
    //   415: aload 17
    //   417: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   420: aload 24
    //   422: areturn
    //   423: astore 17
    //   425: ldc 10
    //   427: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   430: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   433: aload 17
    //   435: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   438: aload_0
    //   439: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   442: aload 17
    //   444: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   447: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   450: dup
    //   451: sipush -30017
    //   454: aload 17
    //   456: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   459: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   462: areturn
    //   463: astore 24
    //   465: iload 6
    //   467: istore_1
    //   468: iload 5
    //   470: istore_2
    //   471: ldc 10
    //   473: new 204	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 501
    //   483: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 23
    //   488: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: iload 8
    //   499: sipush 200
    //   502: if_icmpeq +150 -> 652
    //   505: iload 8
    //   507: sipush 206
    //   510: if_icmpeq +142 -> 652
    //   513: iload 6
    //   515: istore_1
    //   516: iload 5
    //   518: istore_2
    //   519: ldc 10
    //   521: new 204	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 503
    //   531: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_0
    //   535: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   538: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   541: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: ldc_w 505
    //   547: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: iload 8
    //   552: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: iload 6
    //   563: istore_1
    //   564: iload 5
    //   566: istore_2
    //   567: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   570: dup
    //   571: iload 8
    //   573: sipush 30000
    //   576: isub
    //   577: iload 8
    //   579: invokestatic 513	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   582: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   585: astore 18
    //   587: iconst_0
    //   588: ifeq +11 -> 599
    //   591: new 470	java/lang/NullPointerException
    //   594: dup
    //   595: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   598: athrow
    //   599: aload 17
    //   601: ifnull +8 -> 609
    //   604: aload 17
    //   606: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   609: aload 18
    //   611: areturn
    //   612: astore 17
    //   614: ldc 10
    //   616: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   619: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   622: aload 17
    //   624: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   627: aload_0
    //   628: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   631: aload 17
    //   633: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   636: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   639: dup
    //   640: sipush -30017
    //   643: aload 17
    //   645: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   648: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   651: areturn
    //   652: iload 6
    //   654: istore_1
    //   655: iload 5
    //   657: istore_2
    //   658: new 204	java/lang/StringBuilder
    //   661: dup
    //   662: ldc_w 515
    //   665: invokespecial 517	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   668: aload_0
    //   669: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   672: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   675: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc_w 519
    //   681: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 18
    //   686: invokevirtual 64	java/net/URL:toString	()Ljava/lang/String;
    //   689: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc_w 521
    //   695: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload_0
    //   699: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   702: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   705: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   708: ldc_w 523
    //   711: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 17
    //   716: invokevirtual 526	java/net/HttpURLConnection:getContentLength	()I
    //   719: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: ldc2_w 527
    //   726: lstore 13
    //   728: ldc2_w 527
    //   731: lstore 9
    //   733: iload 6
    //   735: istore_1
    //   736: iload 5
    //   738: istore_2
    //   739: aload 17
    //   741: ldc_w 530
    //   744: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 23
    //   749: lload 13
    //   751: lstore 11
    //   753: aload 23
    //   755: ifnull +16 -> 771
    //   758: iload 6
    //   760: istore_1
    //   761: iload 5
    //   763: istore_2
    //   764: aload 23
    //   766: invokestatic 536	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   769: lstore 11
    //   771: iload 6
    //   773: istore_1
    //   774: iload 5
    //   776: istore_2
    //   777: aload 17
    //   779: ldc_w 538
    //   782: invokevirtual 493	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   785: astore 18
    //   787: lload 9
    //   789: lstore 13
    //   791: aload 18
    //   793: ifnull +42 -> 835
    //   796: iload 6
    //   798: istore_1
    //   799: iload 5
    //   801: istore_2
    //   802: aload 18
    //   804: ldc_w 540
    //   807: invokevirtual 543	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   810: istore 7
    //   812: iload 6
    //   814: istore_1
    //   815: iload 5
    //   817: istore_2
    //   818: aload 18
    //   820: iload 7
    //   822: iconst_1
    //   823: iadd
    //   824: invokevirtual 546	java/lang/String:substring	(I)Ljava/lang/String;
    //   827: invokestatic 549	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   830: invokevirtual 552	java/lang/Long:longValue	()J
    //   833: lstore 13
    //   835: ldc2_w 527
    //   838: lstore 15
    //   840: iload 8
    //   842: sipush 200
    //   845: if_icmpne +564 -> 1409
    //   848: lload 11
    //   850: lconst_0
    //   851: lcmp
    //   852: ifle +557 -> 1409
    //   855: lload 11
    //   857: lstore 9
    //   859: lload 9
    //   861: lconst_0
    //   862: lcmp
    //   863: ifle +654 -> 1517
    //   866: iload 6
    //   868: istore_1
    //   869: iload 5
    //   871: istore_2
    //   872: aload_0
    //   873: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   876: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   879: lconst_0
    //   880: lcmp
    //   881: ifgt +636 -> 1517
    //   884: iload 6
    //   886: istore_1
    //   887: iload 5
    //   889: istore_2
    //   890: aload_0
    //   891: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   894: lload 9
    //   896: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   899: lload 11
    //   901: lconst_0
    //   902: lcmp
    //   903: ifne +1262 -> 2165
    //   906: iload 6
    //   908: istore_1
    //   909: iload 5
    //   911: istore_2
    //   912: ldc 10
    //   914: new 204	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 557
    //   924: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_0
    //   928: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   931: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   934: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: ldc_w 559
    //   940: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: iload 6
    //   951: istore_1
    //   952: iload 5
    //   954: istore_2
    //   955: aload_0
    //   956: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   959: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   962: lconst_0
    //   963: lcmp
    //   964: ifle +1025 -> 1989
    //   967: iload 6
    //   969: istore_1
    //   970: iload 5
    //   972: istore_2
    //   973: aload_0
    //   974: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   977: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   980: aload_0
    //   981: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   984: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   987: lcmp
    //   988: ifgt +1001 -> 1989
    //   991: iload 6
    //   993: istore_1
    //   994: iload 5
    //   996: istore_2
    //   997: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1000: dup
    //   1001: iconst_0
    //   1002: aconst_null
    //   1003: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1006: astore 18
    //   1008: iconst_0
    //   1009: ifeq +11 -> 1020
    //   1012: new 470	java/lang/NullPointerException
    //   1015: dup
    //   1016: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   1019: athrow
    //   1020: aload 17
    //   1022: ifnull +8 -> 1030
    //   1025: aload 17
    //   1027: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1030: aload 18
    //   1032: areturn
    //   1033: astore 18
    //   1035: iload 6
    //   1037: istore_1
    //   1038: iload 5
    //   1040: istore_2
    //   1041: ldc 10
    //   1043: new 204	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1050: ldc_w 561
    //   1053: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 23
    //   1058: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 563	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1067: lload 13
    //   1069: lstore 11
    //   1071: goto -300 -> 771
    //   1074: astore 18
    //   1076: aload 20
    //   1078: astore 19
    //   1080: ldc 10
    //   1082: new 204	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 503
    //   1092: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload_0
    //   1096: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1099: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1102: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: aload 18
    //   1110: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1113: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1116: dup
    //   1117: aload 18
    //   1119: invokestatic 569	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1122: aload 18
    //   1124: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1127: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1130: astore 20
    //   1132: aload 20
    //   1134: getfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1137: sipush -30002
    //   1140: if_icmpne +1353 -> 2493
    //   1143: iload_2
    //   1144: ifne +1349 -> 2493
    //   1147: aload 20
    //   1149: sipush -30028
    //   1152: putfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1155: aload_0
    //   1156: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1159: aload 18
    //   1161: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1164: aload 19
    //   1166: ifnull +8 -> 1174
    //   1169: aload 19
    //   1171: invokevirtual 574	java/io/InputStream:close	()V
    //   1174: aload 20
    //   1176: astore 18
    //   1178: aload 17
    //   1180: ifnull -957 -> 223
    //   1183: aload 17
    //   1185: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1188: aload 20
    //   1190: areturn
    //   1191: astore 17
    //   1193: ldc 10
    //   1195: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1198: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1201: aload 17
    //   1203: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1206: aload_0
    //   1207: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1210: aload 17
    //   1212: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1215: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1218: dup
    //   1219: sipush -30017
    //   1222: aload 17
    //   1224: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1227: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1230: areturn
    //   1231: astore 18
    //   1233: iload 6
    //   1235: istore_1
    //   1236: iload 5
    //   1238: istore_2
    //   1239: ldc 10
    //   1241: aload 18
    //   1243: invokestatic 427	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1246: lload 9
    //   1248: lstore 13
    //   1250: goto -415 -> 835
    //   1253: astore 20
    //   1255: aload 22
    //   1257: astore 21
    //   1259: aload 17
    //   1261: astore 18
    //   1263: aload 21
    //   1265: astore 19
    //   1267: ldc 10
    //   1269: new 204	java/lang/StringBuilder
    //   1272: dup
    //   1273: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1276: ldc_w 503
    //   1279: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: aload_0
    //   1283: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1286: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1289: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: aload 20
    //   1297: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1300: aload 17
    //   1302: astore 18
    //   1304: aload 21
    //   1306: astore 19
    //   1308: aload_0
    //   1309: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1312: aload 20
    //   1314: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1317: aload 17
    //   1319: astore 18
    //   1321: aload 21
    //   1323: astore 19
    //   1325: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1328: dup
    //   1329: sipush -10002
    //   1332: aload 20
    //   1334: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1337: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1340: astore 20
    //   1342: aload 21
    //   1344: ifnull +8 -> 1352
    //   1347: aload 21
    //   1349: invokevirtual 574	java/io/InputStream:close	()V
    //   1352: aload 20
    //   1354: astore 18
    //   1356: aload 17
    //   1358: ifnull -1135 -> 223
    //   1361: aload 17
    //   1363: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1366: aload 20
    //   1368: areturn
    //   1369: astore 17
    //   1371: ldc 10
    //   1373: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1376: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1379: aload 17
    //   1381: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1384: aload_0
    //   1385: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1388: aload 17
    //   1390: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1393: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1396: dup
    //   1397: sipush -30017
    //   1400: aload 17
    //   1402: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1405: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1408: areturn
    //   1409: iload 8
    //   1411: sipush 206
    //   1414: if_icmpne +17 -> 1431
    //   1417: lload 13
    //   1419: lconst_0
    //   1420: lcmp
    //   1421: ifle +10 -> 1431
    //   1424: lload 13
    //   1426: lstore 9
    //   1428: goto -569 -> 859
    //   1431: iload 6
    //   1433: istore_1
    //   1434: iload 5
    //   1436: istore_2
    //   1437: ldc 10
    //   1439: new 204	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1446: ldc_w 576
    //   1449: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: iload 8
    //   1454: invokevirtual 508	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1463: lload 15
    //   1465: lstore 9
    //   1467: iload 6
    //   1469: istore_1
    //   1470: iload 5
    //   1472: istore_2
    //   1473: aload_0
    //   1474: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1477: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1480: lconst_0
    //   1481: lcmp
    //   1482: ifgt -623 -> 859
    //   1485: lload 15
    //   1487: lstore 9
    //   1489: lload 11
    //   1491: lconst_0
    //   1492: lcmp
    //   1493: ifle -634 -> 859
    //   1496: iload 6
    //   1498: istore_1
    //   1499: iload 5
    //   1501: istore_2
    //   1502: aload_0
    //   1503: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1506: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1509: lload 11
    //   1511: ladd
    //   1512: lstore 9
    //   1514: goto -655 -> 859
    //   1517: lload 9
    //   1519: lconst_0
    //   1520: lcmp
    //   1521: ifle +362 -> 1883
    //   1524: iload 6
    //   1526: istore_1
    //   1527: iload 5
    //   1529: istore_2
    //   1530: aload_0
    //   1531: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1534: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1537: lload 9
    //   1539: lcmp
    //   1540: ifeq +343 -> 1883
    //   1543: iload 6
    //   1545: istore_1
    //   1546: iload 5
    //   1548: istore_2
    //   1549: aload_0
    //   1550: invokevirtual 431	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportContinueInterruption	()Z
    //   1553: ifeq +62 -> 1615
    //   1556: iload 6
    //   1558: istore_1
    //   1559: iload 5
    //   1561: istore_2
    //   1562: ldc 10
    //   1564: new 204	java/lang/StringBuilder
    //   1567: dup
    //   1568: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1571: ldc_w 578
    //   1574: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload_0
    //   1578: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1581: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1584: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1587: ldc_w 580
    //   1590: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1593: lload 11
    //   1595: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1598: ldc_w 582
    //   1601: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: lload 13
    //   1606: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1615: iload 6
    //   1617: istore_1
    //   1618: iload 5
    //   1620: istore_2
    //   1621: aload_0
    //   1622: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1625: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1628: lconst_0
    //   1629: lcmp
    //   1630: ifne +194 -> 1824
    //   1633: lload 9
    //   1635: lload 11
    //   1637: lcmp
    //   1638: ifne +186 -> 1824
    //   1641: iload 6
    //   1643: istore_1
    //   1644: iload 5
    //   1646: istore_2
    //   1647: aload_0
    //   1648: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   1651: ifne +173 -> 1824
    //   1654: iload 6
    //   1656: istore_1
    //   1657: iload 5
    //   1659: istore_2
    //   1660: aload_0
    //   1661: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1664: lload 9
    //   1666: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1669: goto -770 -> 899
    //   1672: astore 20
    //   1674: aload 17
    //   1676: astore 18
    //   1678: aload 21
    //   1680: astore 19
    //   1682: ldc 10
    //   1684: new 204	java/lang/StringBuilder
    //   1687: dup
    //   1688: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1691: ldc_w 503
    //   1694: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: aload_0
    //   1698: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1701: invokevirtual 231	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1704: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1710: aload 20
    //   1712: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1715: aload 17
    //   1717: astore 18
    //   1719: aload 21
    //   1721: astore 19
    //   1723: aload_0
    //   1724: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1727: aload 20
    //   1729: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1732: aload 17
    //   1734: astore 18
    //   1736: aload 21
    //   1738: astore 19
    //   1740: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1743: dup
    //   1744: sipush -10014
    //   1747: aload 20
    //   1749: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1752: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1755: astore 20
    //   1757: aload 21
    //   1759: ifnull +8 -> 1767
    //   1762: aload 21
    //   1764: invokevirtual 574	java/io/InputStream:close	()V
    //   1767: aload 20
    //   1769: astore 18
    //   1771: aload 17
    //   1773: ifnull -1550 -> 223
    //   1776: aload 17
    //   1778: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1781: aload 20
    //   1783: areturn
    //   1784: astore 17
    //   1786: ldc 10
    //   1788: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1791: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1794: aload 17
    //   1796: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1799: aload_0
    //   1800: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1803: aload 17
    //   1805: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1808: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1811: dup
    //   1812: sipush -30017
    //   1815: aload 17
    //   1817: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1820: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1823: areturn
    //   1824: lload 9
    //   1826: lload 13
    //   1828: lcmp
    //   1829: ifne -930 -> 899
    //   1832: iload 6
    //   1834: istore_1
    //   1835: iload 5
    //   1837: istore_2
    //   1838: aload_0
    //   1839: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1842: lload 9
    //   1844: invokevirtual 555	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1847: goto -948 -> 899
    //   1850: astore 20
    //   1852: aload 17
    //   1854: astore 18
    //   1856: aload 20
    //   1858: astore 17
    //   1860: aload 19
    //   1862: ifnull +8 -> 1870
    //   1865: aload 19
    //   1867: invokevirtual 574	java/io/InputStream:close	()V
    //   1870: aload 18
    //   1872: ifnull +8 -> 1880
    //   1875: aload 18
    //   1877: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   1880: aload 17
    //   1882: athrow
    //   1883: lload 9
    //   1885: lconst_0
    //   1886: lcmp
    //   1887: ifge -988 -> 899
    //   1890: iload 6
    //   1892: istore_1
    //   1893: iload 5
    //   1895: istore_2
    //   1896: ldc 10
    //   1898: new 204	java/lang/StringBuilder
    //   1901: dup
    //   1902: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   1905: ldc_w 584
    //   1908: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: aload_0
    //   1912: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1915: invokevirtual 199	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   1918: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1924: invokestatic 342	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1927: iload 6
    //   1929: istore_1
    //   1930: iload 5
    //   1932: istore_2
    //   1933: ldc 10
    //   1935: aload 17
    //   1937: invokevirtual 588	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   1940: invokevirtual 589	java/lang/Object:toString	()Ljava/lang/String;
    //   1943: invokestatic 310	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1946: goto -1047 -> 899
    //   1949: astore 17
    //   1951: ldc 10
    //   1953: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1956: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   1959: aload 17
    //   1961: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1964: aload_0
    //   1965: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1968: aload 17
    //   1970: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1973: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1976: dup
    //   1977: sipush -30017
    //   1980: aload 17
    //   1982: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1985: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1988: areturn
    //   1989: iload 8
    //   1991: sipush 206
    //   1994: if_icmpne +87 -> 2081
    //   1997: iload 6
    //   1999: istore_1
    //   2000: iload 5
    //   2002: istore_2
    //   2003: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2006: dup
    //   2007: sipush -29005
    //   2010: aconst_null
    //   2011: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2014: astore 18
    //   2016: iconst_0
    //   2017: ifeq +11 -> 2028
    //   2020: new 470	java/lang/NullPointerException
    //   2023: dup
    //   2024: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   2027: athrow
    //   2028: aload 17
    //   2030: ifnull +8 -> 2038
    //   2033: aload 17
    //   2035: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2038: aload 18
    //   2040: areturn
    //   2041: astore 17
    //   2043: ldc 10
    //   2045: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2048: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2051: aload 17
    //   2053: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2056: aload_0
    //   2057: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2060: aload 17
    //   2062: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2065: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2068: dup
    //   2069: sipush -30017
    //   2072: aload 17
    //   2074: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2077: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2080: areturn
    //   2081: iload 6
    //   2083: istore_1
    //   2084: iload 5
    //   2086: istore_2
    //   2087: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2090: dup
    //   2091: sipush -29001
    //   2094: aconst_null
    //   2095: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2098: astore 18
    //   2100: iconst_0
    //   2101: ifeq +11 -> 2112
    //   2104: new 470	java/lang/NullPointerException
    //   2107: dup
    //   2108: invokespecial 471	java/lang/NullPointerException:<init>	()V
    //   2111: athrow
    //   2112: aload 17
    //   2114: ifnull +8 -> 2122
    //   2117: aload 17
    //   2119: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2122: aload 18
    //   2124: areturn
    //   2125: astore 17
    //   2127: ldc 10
    //   2129: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2132: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2135: aload 17
    //   2137: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2140: aload_0
    //   2141: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2144: aload 17
    //   2146: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2149: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2152: dup
    //   2153: sipush -30017
    //   2156: aload 17
    //   2158: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2161: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2164: areturn
    //   2165: iload 6
    //   2167: istore_1
    //   2168: iload 5
    //   2170: istore_2
    //   2171: aload_0
    //   2172: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2175: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2178: lstore 9
    //   2180: iload 6
    //   2182: istore_1
    //   2183: iload 5
    //   2185: istore_2
    //   2186: new 591	java/io/BufferedInputStream
    //   2189: dup
    //   2190: aload 17
    //   2192: invokevirtual 595	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2195: invokespecial 598	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2198: astore 18
    //   2200: aload_0
    //   2201: aload 18
    //   2203: invokevirtual 602	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   2206: istore_1
    //   2207: iload_1
    //   2208: sipush -10002
    //   2211: if_icmpne +459 -> 2670
    //   2214: aload_0
    //   2215: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2218: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2221: lload 9
    //   2223: lsub
    //   2224: lload 11
    //   2226: lcmp
    //   2227: ifne +443 -> 2670
    //   2230: ldc 10
    //   2232: ldc_w 604
    //   2235: invokestatic 310	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2238: iconst_0
    //   2239: istore_1
    //   2240: iload_1
    //   2241: ifne +178 -> 2419
    //   2244: aload_0
    //   2245: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2248: ifeq +171 -> 2419
    //   2251: aload_0
    //   2252: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2255: invokevirtual 340	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2258: aload_0
    //   2259: getfield 47	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2262: invokevirtual 193	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2265: lcmp
    //   2266: iflt +77 -> 2343
    //   2269: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2272: dup
    //   2273: iconst_0
    //   2274: aconst_null
    //   2275: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2278: astore 19
    //   2280: aload 18
    //   2282: ifnull +8 -> 2290
    //   2285: aload 18
    //   2287: invokevirtual 574	java/io/InputStream:close	()V
    //   2290: aload 17
    //   2292: ifnull +8 -> 2300
    //   2295: aload 17
    //   2297: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2300: aload 19
    //   2302: areturn
    //   2303: astore 17
    //   2305: ldc 10
    //   2307: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2310: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2313: aload 17
    //   2315: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2318: aload_0
    //   2319: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2322: aload 17
    //   2324: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2327: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2330: dup
    //   2331: sipush -30017
    //   2334: aload 17
    //   2336: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2339: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2342: areturn
    //   2343: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2346: dup
    //   2347: sipush -10020
    //   2350: aconst_null
    //   2351: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2354: astore 19
    //   2356: aload 18
    //   2358: ifnull +8 -> 2366
    //   2361: aload 18
    //   2363: invokevirtual 574	java/io/InputStream:close	()V
    //   2366: aload 17
    //   2368: ifnull +8 -> 2376
    //   2371: aload 17
    //   2373: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2376: aload 19
    //   2378: areturn
    //   2379: astore 17
    //   2381: ldc 10
    //   2383: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2386: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2389: aload 17
    //   2391: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2394: aload_0
    //   2395: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2398: aload 17
    //   2400: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2403: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2406: dup
    //   2407: sipush -30017
    //   2410: aload 17
    //   2412: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2415: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2418: areturn
    //   2419: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2422: dup
    //   2423: iload_1
    //   2424: aconst_null
    //   2425: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2428: astore 19
    //   2430: aload 18
    //   2432: ifnull +8 -> 2440
    //   2435: aload 18
    //   2437: invokevirtual 574	java/io/InputStream:close	()V
    //   2440: aload 17
    //   2442: ifnull +8 -> 2450
    //   2445: aload 17
    //   2447: invokevirtual 474	java/net/HttpURLConnection:disconnect	()V
    //   2450: aload 19
    //   2452: areturn
    //   2453: astore 17
    //   2455: ldc 10
    //   2457: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2460: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2463: aload 17
    //   2465: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2468: aload_0
    //   2469: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2472: aload 17
    //   2474: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2477: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2480: dup
    //   2481: sipush -30017
    //   2484: aload 17
    //   2486: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2489: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2492: areturn
    //   2493: aload 20
    //   2495: getfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   2498: sipush -30002
    //   2501: if_icmpne -1346 -> 1155
    //   2504: iload_1
    //   2505: ifne -1350 -> 1155
    //   2508: aload 20
    //   2510: sipush -30029
    //   2513: putfield 243	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   2516: goto -1361 -> 1155
    //   2519: astore 20
    //   2521: aload 17
    //   2523: astore 18
    //   2525: aload 20
    //   2527: astore 17
    //   2529: goto -669 -> 1860
    //   2532: astore 17
    //   2534: ldc 10
    //   2536: invokestatic 478	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2539: invokevirtual 481	java/lang/Thread:getName	()Ljava/lang/String;
    //   2542: aload 17
    //   2544: invokestatic 330	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2547: aload_0
    //   2548: getfield 54	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   2551: aload 17
    //   2553: putfield 256	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   2556: new 96	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2559: dup
    //   2560: sipush -30017
    //   2563: aload 17
    //   2565: invokestatic 335	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2568: invokespecial 101	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2571: areturn
    //   2572: astore 17
    //   2574: aconst_null
    //   2575: astore 18
    //   2577: goto -717 -> 1860
    //   2580: astore 20
    //   2582: aload 18
    //   2584: astore 19
    //   2586: aload 17
    //   2588: astore 18
    //   2590: aload 20
    //   2592: astore 17
    //   2594: goto -734 -> 1860
    //   2597: astore 17
    //   2599: goto -739 -> 1860
    //   2602: astore 20
    //   2604: aconst_null
    //   2605: astore 17
    //   2607: goto -933 -> 1674
    //   2610: astore 20
    //   2612: aload 18
    //   2614: astore 21
    //   2616: goto -942 -> 1674
    //   2619: astore 20
    //   2621: aconst_null
    //   2622: astore 17
    //   2624: aload 22
    //   2626: astore 21
    //   2628: goto -1369 -> 1259
    //   2631: astore 20
    //   2633: aload 18
    //   2635: astore 21
    //   2637: goto -1378 -> 1259
    //   2640: astore 18
    //   2642: aconst_null
    //   2643: astore 17
    //   2645: aload 20
    //   2647: astore 19
    //   2649: goto -1569 -> 1080
    //   2652: astore 20
    //   2654: aload 18
    //   2656: astore 19
    //   2658: aload 20
    //   2660: astore 18
    //   2662: iload 4
    //   2664: istore_1
    //   2665: iload_3
    //   2666: istore_2
    //   2667: goto -1587 -> 1080
    //   2670: goto -430 -> 2240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2673	0	this	BaseDownloadTransfer
    //   17	2648	1	i	int
    //   13	2654	2	j	int
    //   15	2651	3	k	int
    //   19	2644	4	m	int
    //   279	1905	5	n	int
    //   317	1864	6	i1	int
    //   810	14	7	i2	int
    //   311	1684	8	i3	int
    //   165	2057	9	l1	long
    //   751	1474	11	l2	long
    //   726	1101	13	l3	long
    //   838	648	15	l4	long
    //   35	184	17	localHttpURLConnection	HttpURLConnection
    //   226	190	17	localIOException1	IOException
    //   423	182	17	localIOException2	IOException
    //   612	572	17	localIOException3	IOException
    //   1191	171	17	localIOException4	IOException
    //   1369	408	17	localIOException5	IOException
    //   1784	69	17	localIOException6	IOException
    //   1858	78	17	localObject1	Object
    //   1949	85	17	localIOException7	IOException
    //   2041	77	17	localIOException8	IOException
    //   2125	171	17	localIOException9	IOException
    //   2303	69	17	localIOException10	IOException
    //   2379	67	17	localIOException11	IOException
    //   2453	69	17	localIOException12	IOException
    //   2527	1	17	localObject2	Object
    //   2532	32	17	localIOException13	IOException
    //   2572	15	17	localObject3	Object
    //   2592	1	17	localObject4	Object
    //   2597	1	17	localObject5	Object
    //   2605	39	17	localObject6	Object
    //   25	1006	18	localObject7	Object
    //   1033	1	18	localNumberFormatException1	java.lang.NumberFormatException
    //   1074	86	18	localIOException14	IOException
    //   1176	1	18	localResult1	Transfer.Result
    //   1231	11	18	localException1	java.lang.Exception
    //   1261	1373	18	localObject8	Object
    //   2640	15	18	localIOException15	IOException
    //   2660	1	18	localIOException16	IOException
    //   7	2650	19	localObject9	Object
    //   10	1179	20	localResult2	Transfer.Result
    //   1253	80	20	localInterruptedException1	InterruptedException
    //   1340	27	20	localResult3	Transfer.Result
    //   1672	76	20	localException2	java.lang.Exception
    //   1755	27	20	localResult4	Transfer.Result
    //   1850	659	20	localObject10	Object
    //   2519	7	20	localObject11	Object
    //   2580	11	20	localObject12	Object
    //   2602	1	20	localException3	java.lang.Exception
    //   2610	1	20	localException4	java.lang.Exception
    //   2619	1	20	localInterruptedException2	InterruptedException
    //   2631	15	20	localInterruptedException3	InterruptedException
    //   2652	7	20	localIOException17	IOException
    //   4	2632	21	localObject13	Object
    //   1	2624	22	localObject14	Object
    //   368	689	23	str	String
    //   396	25	24	localResult5	Transfer.Result
    //   463	1	24	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   205	213	226	java/io/IOException
    //   218	223	226	java/io/IOException
    //   402	410	423	java/io/IOException
    //   415	420	423	java/io/IOException
    //   381	398	463	java/lang/NumberFormatException
    //   591	599	612	java/io/IOException
    //   604	609	612	java/io/IOException
    //   764	771	1033	java/lang/NumberFormatException
    //   42	57	1074	java/io/IOException
    //   62	68	1074	java/io/IOException
    //   73	85	1074	java/io/IOException
    //   90	105	1074	java/io/IOException
    //   110	128	1074	java/io/IOException
    //   133	139	1074	java/io/IOException
    //   144	157	1074	java/io/IOException
    //   162	167	1074	java/io/IOException
    //   172	182	1074	java/io/IOException
    //   187	201	1074	java/io/IOException
    //   271	276	1074	java/io/IOException
    //   287	300	1074	java/io/IOException
    //   306	313	1074	java/io/IOException
    //   325	338	1074	java/io/IOException
    //   360	370	1074	java/io/IOException
    //   381	398	1074	java/io/IOException
    //   471	497	1074	java/io/IOException
    //   519	561	1074	java/io/IOException
    //   567	587	1074	java/io/IOException
    //   658	723	1074	java/io/IOException
    //   739	749	1074	java/io/IOException
    //   764	771	1074	java/io/IOException
    //   777	787	1074	java/io/IOException
    //   802	812	1074	java/io/IOException
    //   818	835	1074	java/io/IOException
    //   872	884	1074	java/io/IOException
    //   890	899	1074	java/io/IOException
    //   912	949	1074	java/io/IOException
    //   955	967	1074	java/io/IOException
    //   973	991	1074	java/io/IOException
    //   997	1008	1074	java/io/IOException
    //   1041	1067	1074	java/io/IOException
    //   1239	1246	1074	java/io/IOException
    //   1437	1463	1074	java/io/IOException
    //   1473	1485	1074	java/io/IOException
    //   1502	1514	1074	java/io/IOException
    //   1530	1543	1074	java/io/IOException
    //   1549	1556	1074	java/io/IOException
    //   1562	1615	1074	java/io/IOException
    //   1621	1633	1074	java/io/IOException
    //   1647	1654	1074	java/io/IOException
    //   1660	1669	1074	java/io/IOException
    //   1838	1847	1074	java/io/IOException
    //   1896	1927	1074	java/io/IOException
    //   1933	1946	1074	java/io/IOException
    //   2003	2016	1074	java/io/IOException
    //   2087	2100	1074	java/io/IOException
    //   2171	2180	1074	java/io/IOException
    //   2186	2200	1074	java/io/IOException
    //   1169	1174	1191	java/io/IOException
    //   1183	1188	1191	java/io/IOException
    //   818	835	1231	java/lang/Exception
    //   42	57	1253	java/lang/InterruptedException
    //   62	68	1253	java/lang/InterruptedException
    //   73	85	1253	java/lang/InterruptedException
    //   90	105	1253	java/lang/InterruptedException
    //   110	128	1253	java/lang/InterruptedException
    //   133	139	1253	java/lang/InterruptedException
    //   144	157	1253	java/lang/InterruptedException
    //   162	167	1253	java/lang/InterruptedException
    //   172	182	1253	java/lang/InterruptedException
    //   187	201	1253	java/lang/InterruptedException
    //   271	276	1253	java/lang/InterruptedException
    //   287	300	1253	java/lang/InterruptedException
    //   306	313	1253	java/lang/InterruptedException
    //   325	338	1253	java/lang/InterruptedException
    //   360	370	1253	java/lang/InterruptedException
    //   381	398	1253	java/lang/InterruptedException
    //   471	497	1253	java/lang/InterruptedException
    //   519	561	1253	java/lang/InterruptedException
    //   567	587	1253	java/lang/InterruptedException
    //   658	723	1253	java/lang/InterruptedException
    //   739	749	1253	java/lang/InterruptedException
    //   764	771	1253	java/lang/InterruptedException
    //   777	787	1253	java/lang/InterruptedException
    //   802	812	1253	java/lang/InterruptedException
    //   818	835	1253	java/lang/InterruptedException
    //   872	884	1253	java/lang/InterruptedException
    //   890	899	1253	java/lang/InterruptedException
    //   912	949	1253	java/lang/InterruptedException
    //   955	967	1253	java/lang/InterruptedException
    //   973	991	1253	java/lang/InterruptedException
    //   997	1008	1253	java/lang/InterruptedException
    //   1041	1067	1253	java/lang/InterruptedException
    //   1239	1246	1253	java/lang/InterruptedException
    //   1437	1463	1253	java/lang/InterruptedException
    //   1473	1485	1253	java/lang/InterruptedException
    //   1502	1514	1253	java/lang/InterruptedException
    //   1530	1543	1253	java/lang/InterruptedException
    //   1549	1556	1253	java/lang/InterruptedException
    //   1562	1615	1253	java/lang/InterruptedException
    //   1621	1633	1253	java/lang/InterruptedException
    //   1647	1654	1253	java/lang/InterruptedException
    //   1660	1669	1253	java/lang/InterruptedException
    //   1838	1847	1253	java/lang/InterruptedException
    //   1896	1927	1253	java/lang/InterruptedException
    //   1933	1946	1253	java/lang/InterruptedException
    //   2003	2016	1253	java/lang/InterruptedException
    //   2087	2100	1253	java/lang/InterruptedException
    //   2171	2180	1253	java/lang/InterruptedException
    //   2186	2200	1253	java/lang/InterruptedException
    //   1347	1352	1369	java/io/IOException
    //   1361	1366	1369	java/io/IOException
    //   42	57	1672	java/lang/Exception
    //   62	68	1672	java/lang/Exception
    //   73	85	1672	java/lang/Exception
    //   90	105	1672	java/lang/Exception
    //   110	128	1672	java/lang/Exception
    //   133	139	1672	java/lang/Exception
    //   144	157	1672	java/lang/Exception
    //   162	167	1672	java/lang/Exception
    //   172	182	1672	java/lang/Exception
    //   187	201	1672	java/lang/Exception
    //   271	276	1672	java/lang/Exception
    //   287	300	1672	java/lang/Exception
    //   306	313	1672	java/lang/Exception
    //   325	338	1672	java/lang/Exception
    //   360	370	1672	java/lang/Exception
    //   381	398	1672	java/lang/Exception
    //   471	497	1672	java/lang/Exception
    //   519	561	1672	java/lang/Exception
    //   567	587	1672	java/lang/Exception
    //   658	723	1672	java/lang/Exception
    //   739	749	1672	java/lang/Exception
    //   764	771	1672	java/lang/Exception
    //   777	787	1672	java/lang/Exception
    //   802	812	1672	java/lang/Exception
    //   872	884	1672	java/lang/Exception
    //   890	899	1672	java/lang/Exception
    //   912	949	1672	java/lang/Exception
    //   955	967	1672	java/lang/Exception
    //   973	991	1672	java/lang/Exception
    //   997	1008	1672	java/lang/Exception
    //   1041	1067	1672	java/lang/Exception
    //   1239	1246	1672	java/lang/Exception
    //   1437	1463	1672	java/lang/Exception
    //   1473	1485	1672	java/lang/Exception
    //   1502	1514	1672	java/lang/Exception
    //   1530	1543	1672	java/lang/Exception
    //   1549	1556	1672	java/lang/Exception
    //   1562	1615	1672	java/lang/Exception
    //   1621	1633	1672	java/lang/Exception
    //   1647	1654	1672	java/lang/Exception
    //   1660	1669	1672	java/lang/Exception
    //   1838	1847	1672	java/lang/Exception
    //   1896	1927	1672	java/lang/Exception
    //   1933	1946	1672	java/lang/Exception
    //   2003	2016	1672	java/lang/Exception
    //   2087	2100	1672	java/lang/Exception
    //   2171	2180	1672	java/lang/Exception
    //   2186	2200	1672	java/lang/Exception
    //   1762	1767	1784	java/io/IOException
    //   1776	1781	1784	java/io/IOException
    //   42	57	1850	finally
    //   62	68	1850	finally
    //   73	85	1850	finally
    //   90	105	1850	finally
    //   110	128	1850	finally
    //   133	139	1850	finally
    //   144	157	1850	finally
    //   162	167	1850	finally
    //   172	182	1850	finally
    //   187	201	1850	finally
    //   271	276	1850	finally
    //   287	300	1850	finally
    //   306	313	1850	finally
    //   325	338	1850	finally
    //   360	370	1850	finally
    //   381	398	1850	finally
    //   471	497	1850	finally
    //   519	561	1850	finally
    //   567	587	1850	finally
    //   658	723	1850	finally
    //   739	749	1850	finally
    //   764	771	1850	finally
    //   777	787	1850	finally
    //   802	812	1850	finally
    //   818	835	1850	finally
    //   872	884	1850	finally
    //   890	899	1850	finally
    //   912	949	1850	finally
    //   955	967	1850	finally
    //   973	991	1850	finally
    //   997	1008	1850	finally
    //   1041	1067	1850	finally
    //   1239	1246	1850	finally
    //   1437	1463	1850	finally
    //   1473	1485	1850	finally
    //   1502	1514	1850	finally
    //   1530	1543	1850	finally
    //   1549	1556	1850	finally
    //   1562	1615	1850	finally
    //   1621	1633	1850	finally
    //   1647	1654	1850	finally
    //   1660	1669	1850	finally
    //   1838	1847	1850	finally
    //   1896	1927	1850	finally
    //   1933	1946	1850	finally
    //   2003	2016	1850	finally
    //   2087	2100	1850	finally
    //   2171	2180	1850	finally
    //   2186	2200	1850	finally
    //   1012	1020	1949	java/io/IOException
    //   1025	1030	1949	java/io/IOException
    //   2020	2028	2041	java/io/IOException
    //   2033	2038	2041	java/io/IOException
    //   2104	2112	2125	java/io/IOException
    //   2117	2122	2125	java/io/IOException
    //   2285	2290	2303	java/io/IOException
    //   2295	2300	2303	java/io/IOException
    //   2361	2366	2379	java/io/IOException
    //   2371	2376	2379	java/io/IOException
    //   2435	2440	2453	java/io/IOException
    //   2445	2450	2453	java/io/IOException
    //   1080	1143	2519	finally
    //   1147	1155	2519	finally
    //   1155	1164	2519	finally
    //   2493	2504	2519	finally
    //   2508	2516	2519	finally
    //   1865	1870	2532	java/io/IOException
    //   1875	1880	2532	java/io/IOException
    //   21	37	2572	finally
    //   2200	2207	2580	finally
    //   2214	2238	2580	finally
    //   2244	2280	2580	finally
    //   2343	2356	2580	finally
    //   2419	2430	2580	finally
    //   1267	1300	2597	finally
    //   1308	1317	2597	finally
    //   1325	1342	2597	finally
    //   1682	1715	2597	finally
    //   1723	1732	2597	finally
    //   1740	1757	2597	finally
    //   21	37	2602	java/lang/Exception
    //   2200	2207	2610	java/lang/Exception
    //   2214	2238	2610	java/lang/Exception
    //   2244	2280	2610	java/lang/Exception
    //   2343	2356	2610	java/lang/Exception
    //   2419	2430	2610	java/lang/Exception
    //   21	37	2619	java/lang/InterruptedException
    //   2200	2207	2631	java/lang/InterruptedException
    //   2214	2238	2631	java/lang/InterruptedException
    //   2244	2280	2631	java/lang/InterruptedException
    //   2343	2356	2631	java/lang/InterruptedException
    //   2419	2430	2631	java/lang/InterruptedException
    //   21	37	2640	java/io/IOException
    //   2200	2207	2652	java/io/IOException
    //   2214	2238	2652	java/io/IOException
    //   2244	2280	2652	java/io/IOException
    //   2343	2356	2652	java/io/IOException
    //   2419	2430	2652	java/io/IOException
  }
  
  protected int getMaxTryTimes()
  {
    return 3;
  }
  
  protected long getSplitSize()
  {
    return this.mSplitSize;
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return false;
  }
  
  protected boolean isSupportSplitDownload()
  {
    return false;
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
    com.weiyun.sdk.log.Log.e("BaseDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return -10008;
  }
  
  protected Transfer.Result processDownload()
  {
    Object localObject1 = acquireResource();
    if (((Transfer.Result)localObject1).mRet != 0) {
      return localObject1;
    }
    int k = 1;
    long l = this.mStartTime;
    int i = 0;
    int j = 0;
    label29:
    Object localObject3 = localObject1;
    label352:
    label360:
    for (;;)
    {
      try
      {
        if (i < getMaxTryTimes())
        {
          if (k == 0)
          {
            l = System.currentTimeMillis();
            doInnerReport((Transfer.Result)localObject1, this.mProcessInfo);
            this.mProcessInfo.resetLast();
            this.mProcessInfo.attemptCount = j;
          }
          localObject3 = checkJob();
          if (localObject3 != null) {
            return localObject3;
          }
          if (k == 0)
          {
            this.mJob.reportDownloadTransferSize(2, ((Transfer.Result)localObject1).mRet, this.mStartTime, l, this.mContext.getCurSize() - this.mOffset, ((Transfer.Result)localObject1).mErrMsg);
            this.mStartTime = l;
            this.mOffset = this.mContext.getCurSize();
          }
          localObject1 = doDownload();
          k = ((Transfer.Result)localObject1).mRet;
          if (k == 0) {
            localObject3 = localObject1;
          }
        }
        else
        {
          releaseResource();
          localObject1 = localObject3;
          if (((Transfer.Result)localObject3).mRet != 0) {
            break;
          }
          i = moveToTarget();
          if (i != 0) {
            break label352;
          }
          localObject1 = null;
          return new Transfer.Result(i, (String)localObject1);
        }
        if ((this.mOffset >= this.mContext.getCurSize()) || (!isSupportContinueInterruption())) {
          break label360;
        }
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", "get data " + (this.mContext.getCurSize() - this.mOffset) + ", meet error:" + ((Transfer.Result)localObject1).mRet);
        i = -1;
        boolean bool;
        if (i + 1 < getMaxTryTimes())
        {
          bool = true;
          localObject3 = handleError(bool, j, (Transfer.Result)localObject1);
          k = ((Transfer.Result)localObject3).mRet;
          if (k != 0) {
            return localObject3;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        i += 1;
        k = 0;
        j += 1;
        break label29;
      }
      finally
      {
        releaseResource();
      }
      String str = "读写文件失败";
    }
  }
  
  protected int readHttpContent(InputStream paramInputStream)
    throws SocketTimeoutException, IOException, InterruptedException
  {
    int i = -1;
    boolean bool = false;
    for (;;)
    {
      ByteArrayPool.ByteArrayBuffer localByteArrayBuffer;
      try
      {
        if (this.mDestFileWriter.getFilePointer() != this.mContext.getCurSize()) {
          this.mDestFileWriter.seek(this.mContext.getCurSize());
        }
        long l = SystemClock.uptimeMillis();
        localByteArrayBuffer = ByteArrayPool.getInstance().createBuffer();
        if (!this.mJob.isAlive())
        {
          i = -10002;
          this.mProcessInfo.transferDataTimeCost = (SystemClock.uptimeMillis() - l);
          paramInputStream = ByteArrayPool.getInstance();
          if (i == 0) {
            bool = true;
          }
          paramInputStream.freeBuffer(localByteArrayBuffer, bool);
          return i;
        }
      }
      catch (IOException paramInputStream)
      {
        com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramInputStream);
        return -10016;
      }
      if (!this.mJob.checkEnvironment())
      {
        i = this.mJob.getLastErrorNo();
      }
      else
      {
        int j = paramInputStream.read(localByteArrayBuffer.backingArray, 0, 40960);
        if (-1 == j) {
          i = 0;
        } else {
          try
          {
            this.mDestFileWriter.write(localByteArrayBuffer.backingArray, 0, j);
            this.mContext.setCurSize(this.mContext.getCurSize() + j);
            Transfer.ProcessInfo localProcessInfo = this.mProcessInfo;
            localProcessInfo.transferDataSize += j;
            this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
            if (j > 0) {}
          }
          catch (IOException paramInputStream)
          {
            com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", paramInputStream);
            i = -10008;
          }
        }
      }
    }
  }
  
  protected void releaseResource()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = this.mDestFileWriter;
      if (localRandomAccessFile != null) {
        localRandomAccessFile.close();
      }
      this.mDestFileWriter = null;
      return;
    }
    catch (IOException localIOException)
    {
      com.weiyun.sdk.log.Log.w("BaseDownloadTransfer", localIOException);
    }
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    if (!NetworkUtils.isWIFI(null))
    {
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      paramHttpURLConnection.setRequestMethod("GET");
      paramHttpURLConnection.setRequestProperty("Accept", "*/*");
      paramHttpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
      paramHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      if ((Build.VERSION.SDK == null) || (Build.VERSION.SDK_INT <= 13)) {
        break label166;
      }
      paramHttpURLConnection.setRequestProperty("Connection", "close");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "close");
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Pragma", "no-cache");
      paramHttpURLConnection.setRequestProperty("Content-type", "text/octet");
      return;
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 30000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 45000);
      break;
      label166:
      paramHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      paramHttpURLConnection.setRequestProperty("Proxy-Connection", "Keep-Alive");
    }
  }
  
  public int transfer()
  {
    this.mStartTime = System.currentTimeMillis();
    this.mOffset = this.mContext.getCurSize();
    Transfer.Result localResult = processDownload();
    report(localResult);
    return localResult.mRet;
  }
  
  protected boolean usingSplitDownload()
  {
    return this.mUseSplitDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.BaseDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */