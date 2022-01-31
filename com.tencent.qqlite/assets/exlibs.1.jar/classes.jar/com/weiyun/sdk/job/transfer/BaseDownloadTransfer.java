package com.weiyun.sdk.job.transfer;

import android.os.Build.VERSION;
import com.weiyun.sdk.ErrorCode;
import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.log.Log;
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
  protected long mSplitSize = 8388608L;
  protected long mStartTime;
  protected int mTimeoutTimes = 0;
  protected boolean mUseSplitDownload = false;
  
  public BaseDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mDownloadAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
  }
  
  private Transfer.Result handleError(boolean paramBoolean, int paramInt, Transfer.Result paramResult)
  {
    long l;
    if ((paramResult.mRet == -30002) || (paramResult.mRet == -30028) || (paramResult.mRet == -30029))
    {
      this.mTimeoutTimes += 1;
      if ((!ErrorCode.isNetworkError(paramResult.mRet)) || (!paramBoolean) || (!this.mJob.isAlive())) {
        break label201;
      }
      l = (1200.0D * Math.pow(paramInt, 0.5D));
      Log.i("BaseDownloadTransfer", "Last transfer network error, so rollback, sleep time = " + l + ", id = " + this.mJob.getId());
    }
    for (;;)
    {
      try
      {
        Thread.sleep(l);
        if ((paramResult.mRet == -30016) && (NetworkUtils.isCnwapConnection(null)) && (isSupportSplitDownload()))
        {
          if (this.mUseSplitDownload) {
            break label253;
          }
          this.mUseSplitDownload = true;
        }
        return new Transfer.Result(0, null);
      }
      catch (InterruptedException paramResult)
      {
        Log.w("BaseDownloadTransfer", paramResult.getMessage(), paramResult);
        return new Transfer.Result(-10002, Utils.getStackTraceAsString(paramResult));
      }
      this.mTimeoutTimes = 0;
      break;
      label201:
      if ((paramResult.mRet == -29110) || (paramResult.mRet == -29006))
      {
        Log.w("BaseDownloadTransfer", "file offset is wrong! offset :" + this.mContext.getCurSize());
        return cutFileToZero();
        label253:
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
      return;
    case 0: 
      this.mJob.reportDownloadTransferSize(0, 0, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
      return;
    }
    this.mJob.reportDownloadTransferSize(1, -10002, this.mStartTime, System.currentTimeMillis(), this.mContext.getCurSize() - this.mOffset, paramResult.mErrMsg);
  }
  
  protected Transfer.Result acquireResource()
  {
    Object localObject = null;
    int i = 0;
    int j = 0;
    if (j >= 2) {
      if (localObject != null) {
        break label117;
      }
    }
    label117:
    for (localObject = null;; localObject = Utils.getStackTraceAsString((Throwable)localObject))
    {
      for (;;)
      {
        return new Transfer.Result(i, (String)localObject);
        try
        {
          this.mDestFileWriter = new RandomAccessFile(this.mContext.getDataFilePath(), "rwd");
          i = 0;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localObject = localFileNotFoundException;
          Log.e("BaseDownloadTransfer", "", localFileNotFoundException);
          if (Utils.checkFileExist(this.mContext.getDataDirectoryPath()))
          {
            i = -10008;
            break;
          }
          if (!Utils.checkDirAndCreate(this.mContext.getDataDirectoryPath()))
          {
            i = -10008;
            break;
          }
          i = -10006;
          j += 1;
        }
      }
      break;
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
      Log.w("BaseDownloadTransfer", localIOException);
      return new Transfer.Result(-10008, Utils.getStackTraceAsString(localIOException));
    }
  }
  
  protected Transfer.Result doDownload()
  {
    if (!isSupportContinueInterruption())
    {
      localResult = cutFileToZero();
      if (localResult.mRet != 0) {
        return localResult;
      }
    }
    Transfer.Result localResult = doDownloadImpl();
    if ((localResult.mRet == -10002) && (this.mContext.getTotalSize() != 0L) && (this.mContext.getTotalSize() == this.mContext.getCurSize()))
    {
      Log.i("BaseDownloadTransfer", "user canceled a finished job!");
      return new Transfer.Result(0, null);
    }
    return localResult;
  }
  
  /* Error */
  protected Transfer.Result doDownloadImpl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 28
    //   3: aconst_null
    //   4: astore 27
    //   6: aconst_null
    //   7: astore 18
    //   9: aconst_null
    //   10: astore 29
    //   12: aconst_null
    //   13: astore 24
    //   15: aconst_null
    //   16: astore 26
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 25
    //   24: iconst_0
    //   25: istore 4
    //   27: iconst_0
    //   28: istore_3
    //   29: iload 4
    //   31: istore_1
    //   32: aload 29
    //   34: astore 21
    //   36: iload_3
    //   37: istore_2
    //   38: aload 28
    //   40: astore 22
    //   42: aload 27
    //   44: astore 23
    //   46: aload 18
    //   48: astore 17
    //   50: aload 20
    //   52: astore 19
    //   54: aload_0
    //   55: invokevirtual 259	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 30
    //   60: iload 4
    //   62: istore_1
    //   63: aload 29
    //   65: astore 21
    //   67: iload_3
    //   68: istore_2
    //   69: aload 28
    //   71: astore 22
    //   73: aload 27
    //   75: astore 23
    //   77: aload 18
    //   79: astore 17
    //   81: aload 20
    //   83: astore 19
    //   85: aload 30
    //   87: invokevirtual 263	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 265	java/net/HttpURLConnection
    //   93: astore 18
    //   95: iload 4
    //   97: istore_1
    //   98: aload 18
    //   100: astore 21
    //   102: iload_3
    //   103: istore_2
    //   104: aload 18
    //   106: astore 22
    //   108: aload 18
    //   110: astore 23
    //   112: aload 18
    //   114: astore 17
    //   116: aload 20
    //   118: astore 19
    //   120: aload_0
    //   121: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   124: aload 18
    //   126: invokevirtual 268	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   129: invokevirtual 269	java/net/URL:getHost	()Ljava/lang/String;
    //   132: invokevirtual 272	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   135: iload 4
    //   137: istore_1
    //   138: aload 18
    //   140: astore 21
    //   142: iload_3
    //   143: istore_2
    //   144: aload 18
    //   146: astore 22
    //   148: aload 18
    //   150: astore 23
    //   152: aload 18
    //   154: astore 17
    //   156: aload 20
    //   158: astore 19
    //   160: aload_0
    //   161: aload 18
    //   163: invokevirtual 276	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   166: iload 4
    //   168: istore_1
    //   169: aload 18
    //   171: astore 21
    //   173: iload_3
    //   174: istore_2
    //   175: aload 18
    //   177: astore 22
    //   179: aload 18
    //   181: astore 23
    //   183: aload 18
    //   185: astore 17
    //   187: aload 20
    //   189: astore 19
    //   191: aload_0
    //   192: getfield 45	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   195: invokevirtual 67	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   198: ifne +105 -> 303
    //   201: iload 4
    //   203: istore_1
    //   204: aload 18
    //   206: astore 21
    //   208: iload_3
    //   209: istore_2
    //   210: aload 18
    //   212: astore 22
    //   214: aload 18
    //   216: astore 23
    //   218: aload 18
    //   220: astore 17
    //   222: aload 20
    //   224: astore 19
    //   226: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   229: dup
    //   230: sipush -10002
    //   233: aconst_null
    //   234: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   237: astore 20
    //   239: iconst_0
    //   240: ifeq +11 -> 251
    //   243: new 278	java/lang/NullPointerException
    //   246: dup
    //   247: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   250: athrow
    //   251: aload 20
    //   253: astore 17
    //   255: aload 18
    //   257: ifnull +12 -> 269
    //   260: aload 18
    //   262: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   265: aload 20
    //   267: astore 17
    //   269: aload 17
    //   271: areturn
    //   272: astore 17
    //   274: ldc 10
    //   276: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   279: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   282: aload 17
    //   284: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   290: dup
    //   291: sipush -30017
    //   294: aload 17
    //   296: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   299: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   302: areturn
    //   303: iload 4
    //   305: istore_1
    //   306: aload 18
    //   308: astore 21
    //   310: iload_3
    //   311: istore_2
    //   312: aload 18
    //   314: astore 22
    //   316: aload 18
    //   318: astore 23
    //   320: aload 18
    //   322: astore 17
    //   324: aload 20
    //   326: astore 19
    //   328: aload 18
    //   330: invokevirtual 292	java/net/HttpURLConnection:connect	()V
    //   333: iconst_1
    //   334: istore 4
    //   336: iconst_1
    //   337: istore 5
    //   339: iload 5
    //   341: istore_1
    //   342: aload 18
    //   344: astore 21
    //   346: iload_3
    //   347: istore_2
    //   348: aload 18
    //   350: astore 22
    //   352: aload 18
    //   354: astore 23
    //   356: aload 18
    //   358: astore 17
    //   360: aload 20
    //   362: astore 19
    //   364: aload 18
    //   366: invokevirtual 295	java/net/HttpURLConnection:getResponseCode	()I
    //   369: istore 7
    //   371: iconst_1
    //   372: istore_3
    //   373: iconst_1
    //   374: istore 6
    //   376: iload 7
    //   378: sipush 200
    //   381: if_icmpeq +204 -> 585
    //   384: iload 7
    //   386: sipush 206
    //   389: if_icmpeq +196 -> 585
    //   392: iload 5
    //   394: istore_1
    //   395: aload 18
    //   397: astore 21
    //   399: iload 6
    //   401: istore_2
    //   402: aload 18
    //   404: astore 22
    //   406: aload 18
    //   408: astore 23
    //   410: aload 18
    //   412: astore 17
    //   414: aload 20
    //   416: astore 19
    //   418: aload 18
    //   420: ldc_w 297
    //   423: invokevirtual 301	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 28
    //   428: aload 28
    //   430: ifnull +155 -> 585
    //   433: iload 5
    //   435: istore_1
    //   436: aload 18
    //   438: astore 21
    //   440: iload 6
    //   442: istore_2
    //   443: aload 18
    //   445: astore 22
    //   447: aload 18
    //   449: astore 23
    //   451: aload 18
    //   453: astore 17
    //   455: aload 20
    //   457: astore 19
    //   459: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   462: dup
    //   463: aload 28
    //   465: invokestatic 307	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   468: aconst_null
    //   469: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   472: astore 27
    //   474: iconst_0
    //   475: ifeq +11 -> 486
    //   478: new 278	java/lang/NullPointerException
    //   481: dup
    //   482: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   485: athrow
    //   486: aload 27
    //   488: astore 17
    //   490: aload 18
    //   492: ifnull -223 -> 269
    //   495: aload 18
    //   497: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   500: aload 27
    //   502: areturn
    //   503: astore 17
    //   505: ldc 10
    //   507: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   510: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   513: aload 17
    //   515: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   521: dup
    //   522: sipush -30017
    //   525: aload 17
    //   527: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   530: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   533: areturn
    //   534: astore 17
    //   536: iload 5
    //   538: istore_1
    //   539: aload 18
    //   541: astore 21
    //   543: iload 6
    //   545: istore_2
    //   546: aload 18
    //   548: astore 22
    //   550: aload 18
    //   552: astore 23
    //   554: aload 18
    //   556: astore 17
    //   558: aload 20
    //   560: astore 19
    //   562: ldc 10
    //   564: new 79	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 309
    //   571: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload 28
    //   576: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: iload 7
    //   587: sipush 200
    //   590: if_icmpeq +182 -> 772
    //   593: iload 7
    //   595: sipush 206
    //   598: if_icmpeq +174 -> 772
    //   601: iload 5
    //   603: istore_1
    //   604: aload 18
    //   606: astore 21
    //   608: iload 6
    //   610: istore_2
    //   611: aload 18
    //   613: astore 22
    //   615: aload 18
    //   617: astore 23
    //   619: aload 18
    //   621: astore 17
    //   623: aload 20
    //   625: astore 19
    //   627: ldc 10
    //   629: new 79	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 311
    //   636: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: aload_0
    //   640: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   643: invokevirtual 314	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   646: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 316
    //   652: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 7
    //   657: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: iload 5
    //   668: istore_1
    //   669: aload 18
    //   671: astore 21
    //   673: iload 6
    //   675: istore_2
    //   676: aload 18
    //   678: astore 22
    //   680: aload 18
    //   682: astore 23
    //   684: aload 18
    //   686: astore 17
    //   688: aload 20
    //   690: astore 19
    //   692: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   695: dup
    //   696: iload 7
    //   698: sipush 30000
    //   701: isub
    //   702: iload 7
    //   704: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   707: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   710: astore 20
    //   712: iconst_0
    //   713: ifeq +11 -> 724
    //   716: new 278	java/lang/NullPointerException
    //   719: dup
    //   720: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   723: athrow
    //   724: aload 20
    //   726: astore 17
    //   728: aload 18
    //   730: ifnull -461 -> 269
    //   733: aload 18
    //   735: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   738: aload 20
    //   740: areturn
    //   741: astore 17
    //   743: ldc 10
    //   745: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   748: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   751: aload 17
    //   753: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   756: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   759: dup
    //   760: sipush -30017
    //   763: aload 17
    //   765: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   768: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   771: areturn
    //   772: iload 5
    //   774: istore_1
    //   775: aload 18
    //   777: astore 21
    //   779: iload 6
    //   781: istore_2
    //   782: aload 18
    //   784: astore 22
    //   786: aload 18
    //   788: astore 23
    //   790: aload 18
    //   792: astore 17
    //   794: aload 20
    //   796: astore 19
    //   798: new 79	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 327
    //   805: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload_0
    //   809: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   812: invokevirtual 314	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   815: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: ldc_w 329
    //   821: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload 30
    //   826: invokevirtual 330	java/net/URL:toString	()Ljava/lang/String;
    //   829: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 332
    //   835: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload_0
    //   839: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   842: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   845: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   848: ldc_w 334
    //   851: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload 18
    //   856: invokevirtual 337	java/net/HttpURLConnection:getContentLength	()I
    //   859: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: ldc2_w 338
    //   866: lstore 13
    //   868: ldc2_w 338
    //   871: lstore 9
    //   873: iload 5
    //   875: istore_1
    //   876: aload 18
    //   878: astore 21
    //   880: iload 6
    //   882: istore_2
    //   883: aload 18
    //   885: astore 22
    //   887: aload 18
    //   889: astore 23
    //   891: aload 18
    //   893: astore 17
    //   895: aload 20
    //   897: astore 19
    //   899: aload 18
    //   901: ldc_w 341
    //   904: invokevirtual 301	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   907: astore 27
    //   909: lload 13
    //   911: lstore 11
    //   913: aload 27
    //   915: ifnull +36 -> 951
    //   918: iload 5
    //   920: istore_1
    //   921: aload 18
    //   923: astore 21
    //   925: iload 6
    //   927: istore_2
    //   928: aload 18
    //   930: astore 22
    //   932: aload 18
    //   934: astore 23
    //   936: aload 18
    //   938: astore 17
    //   940: aload 20
    //   942: astore 19
    //   944: aload 27
    //   946: invokestatic 347	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   949: lstore 11
    //   951: iload 5
    //   953: istore_1
    //   954: aload 18
    //   956: astore 21
    //   958: iload 6
    //   960: istore_2
    //   961: aload 18
    //   963: astore 22
    //   965: aload 18
    //   967: astore 23
    //   969: aload 18
    //   971: astore 17
    //   973: aload 20
    //   975: astore 19
    //   977: aload 18
    //   979: ldc_w 349
    //   982: invokevirtual 301	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   985: astore 27
    //   987: lload 9
    //   989: lstore 13
    //   991: aload 27
    //   993: ifnull +78 -> 1071
    //   996: iload 5
    //   998: istore_1
    //   999: aload 18
    //   1001: astore 21
    //   1003: iload 6
    //   1005: istore_2
    //   1006: aload 18
    //   1008: astore 22
    //   1010: aload 18
    //   1012: astore 23
    //   1014: aload 18
    //   1016: astore 17
    //   1018: aload 20
    //   1020: astore 19
    //   1022: aload 27
    //   1024: ldc_w 351
    //   1027: invokevirtual 354	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1030: istore 8
    //   1032: iload 5
    //   1034: istore_1
    //   1035: aload 18
    //   1037: astore 21
    //   1039: iload 6
    //   1041: istore_2
    //   1042: aload 18
    //   1044: astore 22
    //   1046: aload 18
    //   1048: astore 17
    //   1050: aload 20
    //   1052: astore 19
    //   1054: aload 27
    //   1056: iload 8
    //   1058: iconst_1
    //   1059: iadd
    //   1060: invokevirtual 357	java/lang/String:substring	(I)Ljava/lang/String;
    //   1063: invokestatic 360	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1066: invokevirtual 363	java/lang/Long:longValue	()J
    //   1069: lstore 13
    //   1071: ldc2_w 338
    //   1074: lstore 15
    //   1076: iload 7
    //   1078: sipush 200
    //   1081: if_icmpne +747 -> 1828
    //   1084: lload 11
    //   1086: lconst_0
    //   1087: lcmp
    //   1088: ifle +740 -> 1828
    //   1091: lload 11
    //   1093: lstore 9
    //   1095: lload 9
    //   1097: lconst_0
    //   1098: lcmp
    //   1099: ifle +894 -> 1993
    //   1102: iload 5
    //   1104: istore_1
    //   1105: aload 18
    //   1107: astore 21
    //   1109: iload 6
    //   1111: istore_2
    //   1112: aload 18
    //   1114: astore 22
    //   1116: aload 18
    //   1118: astore 23
    //   1120: aload 18
    //   1122: astore 17
    //   1124: aload 20
    //   1126: astore 19
    //   1128: aload_0
    //   1129: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1132: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1135: lconst_0
    //   1136: lcmp
    //   1137: ifgt +856 -> 1993
    //   1140: iload 5
    //   1142: istore_1
    //   1143: aload 18
    //   1145: astore 21
    //   1147: iload 6
    //   1149: istore_2
    //   1150: aload 18
    //   1152: astore 22
    //   1154: aload 18
    //   1156: astore 23
    //   1158: aload 18
    //   1160: astore 17
    //   1162: aload 20
    //   1164: astore 19
    //   1166: aload_0
    //   1167: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1170: lload 9
    //   1172: invokevirtual 366	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1175: lload 11
    //   1177: lconst_0
    //   1178: lcmp
    //   1179: ifne +1597 -> 2776
    //   1182: iload 5
    //   1184: istore_1
    //   1185: aload 18
    //   1187: astore 21
    //   1189: iload 6
    //   1191: istore_2
    //   1192: aload 18
    //   1194: astore 22
    //   1196: aload 18
    //   1198: astore 23
    //   1200: aload 18
    //   1202: astore 17
    //   1204: aload 20
    //   1206: astore 19
    //   1208: ldc 10
    //   1210: new 79	java/lang/StringBuilder
    //   1213: dup
    //   1214: ldc_w 368
    //   1217: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1220: aload_0
    //   1221: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1224: invokevirtual 314	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   1227: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: ldc_w 370
    //   1233: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1239: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1242: iload 5
    //   1244: istore_1
    //   1245: aload 18
    //   1247: astore 21
    //   1249: iload 6
    //   1251: istore_2
    //   1252: aload 18
    //   1254: astore 22
    //   1256: aload 18
    //   1258: astore 23
    //   1260: aload 18
    //   1262: astore 17
    //   1264: aload 20
    //   1266: astore 19
    //   1268: aload_0
    //   1269: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1272: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1275: lconst_0
    //   1276: lcmp
    //   1277: ifle +1293 -> 2570
    //   1280: iload 5
    //   1282: istore_1
    //   1283: aload 18
    //   1285: astore 21
    //   1287: iload 6
    //   1289: istore_2
    //   1290: aload 18
    //   1292: astore 22
    //   1294: aload 18
    //   1296: astore 23
    //   1298: aload 18
    //   1300: astore 17
    //   1302: aload 20
    //   1304: astore 19
    //   1306: aload_0
    //   1307: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1310: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1313: aload_0
    //   1314: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1317: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1320: lcmp
    //   1321: ifgt +1249 -> 2570
    //   1324: iload 5
    //   1326: istore_1
    //   1327: aload 18
    //   1329: astore 21
    //   1331: iload 6
    //   1333: istore_2
    //   1334: aload 18
    //   1336: astore 22
    //   1338: aload 18
    //   1340: astore 23
    //   1342: aload 18
    //   1344: astore 17
    //   1346: aload 20
    //   1348: astore 19
    //   1350: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1353: dup
    //   1354: iconst_0
    //   1355: aconst_null
    //   1356: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1359: astore 20
    //   1361: iconst_0
    //   1362: ifeq +11 -> 1373
    //   1365: new 278	java/lang/NullPointerException
    //   1368: dup
    //   1369: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   1372: athrow
    //   1373: aload 20
    //   1375: astore 17
    //   1377: aload 18
    //   1379: ifnull -1110 -> 269
    //   1382: aload 18
    //   1384: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   1387: aload 20
    //   1389: areturn
    //   1390: astore 17
    //   1392: ldc 10
    //   1394: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1397: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   1400: aload 17
    //   1402: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1405: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1408: dup
    //   1409: sipush -30017
    //   1412: aload 17
    //   1414: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1417: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1420: areturn
    //   1421: astore 17
    //   1423: iload 5
    //   1425: istore_1
    //   1426: aload 18
    //   1428: astore 21
    //   1430: iload 6
    //   1432: istore_2
    //   1433: aload 18
    //   1435: astore 22
    //   1437: aload 18
    //   1439: astore 23
    //   1441: aload 18
    //   1443: astore 17
    //   1445: aload 20
    //   1447: astore 19
    //   1449: ldc 10
    //   1451: new 79	java/lang/StringBuilder
    //   1454: dup
    //   1455: ldc_w 372
    //   1458: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1461: aload 27
    //   1463: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokestatic 374	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1472: lload 13
    //   1474: lstore 11
    //   1476: goto -525 -> 951
    //   1479: astore 17
    //   1481: aload 25
    //   1483: astore 20
    //   1485: aload 21
    //   1487: astore 18
    //   1489: aload 17
    //   1491: astore 21
    //   1493: aload 18
    //   1495: astore 17
    //   1497: aload 20
    //   1499: astore 19
    //   1501: ldc 10
    //   1503: new 79	java/lang/StringBuilder
    //   1506: dup
    //   1507: ldc_w 311
    //   1510: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1513: aload_0
    //   1514: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1517: invokevirtual 377	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1520: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1526: aload 21
    //   1528: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1531: aload 18
    //   1533: astore 17
    //   1535: aload 20
    //   1537: astore 19
    //   1539: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1542: dup
    //   1543: aload 21
    //   1545: invokestatic 383	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1548: aload 21
    //   1550: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1553: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1556: astore 21
    //   1558: aload 18
    //   1560: astore 17
    //   1562: aload 20
    //   1564: astore 19
    //   1566: aload 21
    //   1568: getfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1571: sipush -30002
    //   1574: if_icmpne +1547 -> 3121
    //   1577: iload_1
    //   1578: ifne +1543 -> 3121
    //   1581: aload 18
    //   1583: astore 17
    //   1585: aload 20
    //   1587: astore 19
    //   1589: aload 21
    //   1591: sipush -30028
    //   1594: putfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1597: aload 20
    //   1599: ifnull +8 -> 1607
    //   1602: aload 20
    //   1604: invokevirtual 388	java/io/InputStream:close	()V
    //   1607: aload 21
    //   1609: astore 17
    //   1611: aload 18
    //   1613: ifnull -1344 -> 269
    //   1616: aload 18
    //   1618: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   1621: aload 21
    //   1623: areturn
    //   1624: astore 17
    //   1626: ldc 10
    //   1628: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1631: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   1634: aload 17
    //   1636: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1639: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1642: dup
    //   1643: sipush -30017
    //   1646: aload 17
    //   1648: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1651: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1654: areturn
    //   1655: astore 27
    //   1657: iload 5
    //   1659: istore_1
    //   1660: aload 18
    //   1662: astore 21
    //   1664: iload 6
    //   1666: istore_2
    //   1667: aload 18
    //   1669: astore 22
    //   1671: aload 18
    //   1673: astore 23
    //   1675: aload 18
    //   1677: astore 17
    //   1679: aload 20
    //   1681: astore 19
    //   1683: ldc 10
    //   1685: aload 27
    //   1687: invokestatic 241	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1690: lload 9
    //   1692: lstore 13
    //   1694: goto -623 -> 1071
    //   1697: astore 21
    //   1699: aload 24
    //   1701: astore 20
    //   1703: aload 22
    //   1705: astore 18
    //   1707: aload 18
    //   1709: astore 17
    //   1711: aload 20
    //   1713: astore 19
    //   1715: ldc 10
    //   1717: new 79	java/lang/StringBuilder
    //   1720: dup
    //   1721: ldc_w 311
    //   1724: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1727: aload_0
    //   1728: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1731: invokevirtual 377	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1734: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: aload 21
    //   1742: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1745: aload 18
    //   1747: astore 17
    //   1749: aload 20
    //   1751: astore 19
    //   1753: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1756: dup
    //   1757: sipush -10002
    //   1760: aload 21
    //   1762: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1765: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1768: astore 21
    //   1770: aload 20
    //   1772: ifnull +8 -> 1780
    //   1775: aload 20
    //   1777: invokevirtual 388	java/io/InputStream:close	()V
    //   1780: aload 21
    //   1782: astore 17
    //   1784: aload 18
    //   1786: ifnull -1517 -> 269
    //   1789: aload 18
    //   1791: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   1794: aload 21
    //   1796: areturn
    //   1797: astore 17
    //   1799: ldc 10
    //   1801: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1804: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   1807: aload 17
    //   1809: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1812: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1815: dup
    //   1816: sipush -30017
    //   1819: aload 17
    //   1821: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1824: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1827: areturn
    //   1828: iload 7
    //   1830: sipush 206
    //   1833: if_icmpne +17 -> 1850
    //   1836: lload 13
    //   1838: lconst_0
    //   1839: lcmp
    //   1840: ifle +10 -> 1850
    //   1843: lload 13
    //   1845: lstore 9
    //   1847: goto -752 -> 1095
    //   1850: iload 5
    //   1852: istore_1
    //   1853: aload 18
    //   1855: astore 21
    //   1857: iload 6
    //   1859: istore_2
    //   1860: aload 18
    //   1862: astore 22
    //   1864: aload 18
    //   1866: astore 23
    //   1868: aload 18
    //   1870: astore 17
    //   1872: aload 20
    //   1874: astore 19
    //   1876: ldc 10
    //   1878: new 79	java/lang/StringBuilder
    //   1881: dup
    //   1882: ldc_w 390
    //   1885: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1888: iload 7
    //   1890: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1893: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1896: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1899: lload 15
    //   1901: lstore 9
    //   1903: iload 5
    //   1905: istore_1
    //   1906: aload 18
    //   1908: astore 21
    //   1910: iload 6
    //   1912: istore_2
    //   1913: aload 18
    //   1915: astore 22
    //   1917: aload 18
    //   1919: astore 23
    //   1921: aload 18
    //   1923: astore 17
    //   1925: aload 20
    //   1927: astore 19
    //   1929: aload_0
    //   1930: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1933: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1936: lconst_0
    //   1937: lcmp
    //   1938: ifgt -843 -> 1095
    //   1941: lload 15
    //   1943: lstore 9
    //   1945: lload 11
    //   1947: lconst_0
    //   1948: lcmp
    //   1949: ifle -854 -> 1095
    //   1952: iload 5
    //   1954: istore_1
    //   1955: aload 18
    //   1957: astore 21
    //   1959: iload 6
    //   1961: istore_2
    //   1962: aload 18
    //   1964: astore 22
    //   1966: aload 18
    //   1968: astore 23
    //   1970: aload 18
    //   1972: astore 17
    //   1974: aload 20
    //   1976: astore 19
    //   1978: aload_0
    //   1979: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1982: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1985: lload 11
    //   1987: ladd
    //   1988: lstore 9
    //   1990: goto -895 -> 1095
    //   1993: lload 9
    //   1995: lconst_0
    //   1996: lcmp
    //   1997: ifle +470 -> 2467
    //   2000: iload 5
    //   2002: istore_1
    //   2003: aload 18
    //   2005: astore 21
    //   2007: iload 6
    //   2009: istore_2
    //   2010: aload 18
    //   2012: astore 22
    //   2014: aload 18
    //   2016: astore 23
    //   2018: aload 18
    //   2020: astore 17
    //   2022: aload 20
    //   2024: astore 19
    //   2026: aload_0
    //   2027: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2030: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2033: lload 9
    //   2035: lcmp
    //   2036: ifeq +431 -> 2467
    //   2039: iload 5
    //   2041: istore_1
    //   2042: aload 18
    //   2044: astore 21
    //   2046: iload 6
    //   2048: istore_2
    //   2049: aload 18
    //   2051: astore 22
    //   2053: aload 18
    //   2055: astore 23
    //   2057: aload 18
    //   2059: astore 17
    //   2061: aload 20
    //   2063: astore 19
    //   2065: aload_0
    //   2066: invokevirtual 245	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportContinueInterruption	()Z
    //   2069: ifeq +79 -> 2148
    //   2072: iload 5
    //   2074: istore_1
    //   2075: aload 18
    //   2077: astore 21
    //   2079: iload 6
    //   2081: istore_2
    //   2082: aload 18
    //   2084: astore 22
    //   2086: aload 18
    //   2088: astore 23
    //   2090: aload 18
    //   2092: astore 17
    //   2094: aload 20
    //   2096: astore 19
    //   2098: ldc 10
    //   2100: new 79	java/lang/StringBuilder
    //   2103: dup
    //   2104: ldc_w 392
    //   2107: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2110: aload_0
    //   2111: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2114: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2117: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2120: ldc_w 394
    //   2123: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: lload 11
    //   2128: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2131: ldc_w 396
    //   2134: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: lload 13
    //   2139: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2142: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2145: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2148: iload 5
    //   2150: istore_1
    //   2151: aload 18
    //   2153: astore 21
    //   2155: iload 6
    //   2157: istore_2
    //   2158: aload 18
    //   2160: astore 22
    //   2162: aload 18
    //   2164: astore 23
    //   2166: aload 18
    //   2168: astore 17
    //   2170: aload 20
    //   2172: astore 19
    //   2174: aload_0
    //   2175: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2178: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2181: lconst_0
    //   2182: lcmp
    //   2183: ifne +213 -> 2396
    //   2186: lload 9
    //   2188: lload 11
    //   2190: lcmp
    //   2191: ifne +205 -> 2396
    //   2194: iload 5
    //   2196: istore_1
    //   2197: aload 18
    //   2199: astore 21
    //   2201: iload 6
    //   2203: istore_2
    //   2204: aload 18
    //   2206: astore 22
    //   2208: aload 18
    //   2210: astore 23
    //   2212: aload 18
    //   2214: astore 17
    //   2216: aload 20
    //   2218: astore 19
    //   2220: aload_0
    //   2221: invokevirtual 122	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2224: ifne +172 -> 2396
    //   2227: iload 5
    //   2229: istore_1
    //   2230: aload 18
    //   2232: astore 21
    //   2234: iload 6
    //   2236: istore_2
    //   2237: aload 18
    //   2239: astore 22
    //   2241: aload 18
    //   2243: astore 23
    //   2245: aload 18
    //   2247: astore 17
    //   2249: aload 20
    //   2251: astore 19
    //   2253: aload_0
    //   2254: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2257: lload 9
    //   2259: invokevirtual 366	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2262: goto -1087 -> 1175
    //   2265: astore 21
    //   2267: aload 26
    //   2269: astore 20
    //   2271: aload 23
    //   2273: astore 18
    //   2275: aload 18
    //   2277: astore 17
    //   2279: aload 20
    //   2281: astore 19
    //   2283: ldc 10
    //   2285: new 79	java/lang/StringBuilder
    //   2288: dup
    //   2289: ldc_w 311
    //   2292: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2295: aload_0
    //   2296: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2299: invokevirtual 377	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2302: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2308: aload 21
    //   2310: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2313: aload 18
    //   2315: astore 17
    //   2317: aload 20
    //   2319: astore 19
    //   2321: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2324: dup
    //   2325: sipush -10014
    //   2328: aload 21
    //   2330: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2333: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2336: astore 21
    //   2338: aload 20
    //   2340: ifnull +8 -> 2348
    //   2343: aload 20
    //   2345: invokevirtual 388	java/io/InputStream:close	()V
    //   2348: aload 21
    //   2350: astore 17
    //   2352: aload 18
    //   2354: ifnull -2085 -> 269
    //   2357: aload 18
    //   2359: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   2362: aload 21
    //   2364: areturn
    //   2365: astore 17
    //   2367: ldc 10
    //   2369: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2372: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   2375: aload 17
    //   2377: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2380: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2383: dup
    //   2384: sipush -30017
    //   2387: aload 17
    //   2389: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2392: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2395: areturn
    //   2396: lload 9
    //   2398: lload 13
    //   2400: lcmp
    //   2401: ifne -1226 -> 1175
    //   2404: iload 5
    //   2406: istore_1
    //   2407: aload 18
    //   2409: astore 21
    //   2411: iload 6
    //   2413: istore_2
    //   2414: aload 18
    //   2416: astore 22
    //   2418: aload 18
    //   2420: astore 23
    //   2422: aload 18
    //   2424: astore 17
    //   2426: aload 20
    //   2428: astore 19
    //   2430: aload_0
    //   2431: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2434: lload 9
    //   2436: invokevirtual 366	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2439: goto -1264 -> 1175
    //   2442: astore 18
    //   2444: aload 19
    //   2446: ifnull +8 -> 2454
    //   2449: aload 19
    //   2451: invokevirtual 388	java/io/InputStream:close	()V
    //   2454: aload 17
    //   2456: ifnull +8 -> 2464
    //   2459: aload 17
    //   2461: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   2464: aload 18
    //   2466: athrow
    //   2467: lload 9
    //   2469: lconst_0
    //   2470: lcmp
    //   2471: ifge -1296 -> 1175
    //   2474: iload 5
    //   2476: istore_1
    //   2477: aload 18
    //   2479: astore 21
    //   2481: iload 6
    //   2483: istore_2
    //   2484: aload 18
    //   2486: astore 22
    //   2488: aload 18
    //   2490: astore 23
    //   2492: aload 18
    //   2494: astore 17
    //   2496: aload 20
    //   2498: astore 19
    //   2500: ldc 10
    //   2502: new 79	java/lang/StringBuilder
    //   2505: dup
    //   2506: ldc_w 398
    //   2509: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2512: aload_0
    //   2513: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2516: invokevirtual 314	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   2519: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2522: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2528: iload 5
    //   2530: istore_1
    //   2531: aload 18
    //   2533: astore 21
    //   2535: iload 6
    //   2537: istore_2
    //   2538: aload 18
    //   2540: astore 22
    //   2542: aload 18
    //   2544: astore 23
    //   2546: aload 18
    //   2548: astore 17
    //   2550: aload 20
    //   2552: astore 19
    //   2554: ldc 10
    //   2556: aload 18
    //   2558: invokevirtual 402	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   2561: invokevirtual 403	java/lang/Object:toString	()Ljava/lang/String;
    //   2564: invokestatic 107	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2567: goto -1392 -> 1175
    //   2570: iload 7
    //   2572: sipush 206
    //   2575: if_icmpne +102 -> 2677
    //   2578: iload 5
    //   2580: istore_1
    //   2581: aload 18
    //   2583: astore 21
    //   2585: iload 6
    //   2587: istore_2
    //   2588: aload 18
    //   2590: astore 22
    //   2592: aload 18
    //   2594: astore 23
    //   2596: aload 18
    //   2598: astore 17
    //   2600: aload 20
    //   2602: astore 19
    //   2604: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2607: dup
    //   2608: sipush -29005
    //   2611: aconst_null
    //   2612: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2615: astore 20
    //   2617: iconst_0
    //   2618: ifeq +11 -> 2629
    //   2621: new 278	java/lang/NullPointerException
    //   2624: dup
    //   2625: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   2628: athrow
    //   2629: aload 20
    //   2631: astore 17
    //   2633: aload 18
    //   2635: ifnull -2366 -> 269
    //   2638: aload 18
    //   2640: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   2643: aload 20
    //   2645: areturn
    //   2646: astore 17
    //   2648: ldc 10
    //   2650: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2653: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   2656: aload 17
    //   2658: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2661: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2664: dup
    //   2665: sipush -30017
    //   2668: aload 17
    //   2670: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2673: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2676: areturn
    //   2677: iload 5
    //   2679: istore_1
    //   2680: aload 18
    //   2682: astore 21
    //   2684: iload 6
    //   2686: istore_2
    //   2687: aload 18
    //   2689: astore 22
    //   2691: aload 18
    //   2693: astore 23
    //   2695: aload 18
    //   2697: astore 17
    //   2699: aload 20
    //   2701: astore 19
    //   2703: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2706: dup
    //   2707: sipush -29001
    //   2710: aconst_null
    //   2711: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2714: astore 20
    //   2716: iconst_0
    //   2717: ifeq +11 -> 2728
    //   2720: new 278	java/lang/NullPointerException
    //   2723: dup
    //   2724: invokespecial 279	java/lang/NullPointerException:<init>	()V
    //   2727: athrow
    //   2728: aload 20
    //   2730: astore 17
    //   2732: aload 18
    //   2734: ifnull -2465 -> 269
    //   2737: aload 18
    //   2739: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   2742: aload 20
    //   2744: areturn
    //   2745: astore 17
    //   2747: ldc 10
    //   2749: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2752: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   2755: aload 17
    //   2757: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2760: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2763: dup
    //   2764: sipush -30017
    //   2767: aload 17
    //   2769: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2772: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2775: areturn
    //   2776: iload 5
    //   2778: istore_1
    //   2779: aload 18
    //   2781: astore 21
    //   2783: iload 6
    //   2785: istore_2
    //   2786: aload 18
    //   2788: astore 22
    //   2790: aload 18
    //   2792: astore 23
    //   2794: aload 18
    //   2796: astore 17
    //   2798: aload 20
    //   2800: astore 19
    //   2802: aload_0
    //   2803: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2806: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2809: lstore 9
    //   2811: iload 5
    //   2813: istore_1
    //   2814: aload 18
    //   2816: astore 21
    //   2818: iload 6
    //   2820: istore_2
    //   2821: aload 18
    //   2823: astore 22
    //   2825: aload 18
    //   2827: astore 23
    //   2829: aload 18
    //   2831: astore 17
    //   2833: aload 20
    //   2835: astore 19
    //   2837: new 405	java/io/BufferedInputStream
    //   2840: dup
    //   2841: aload 18
    //   2843: invokevirtual 409	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2846: invokespecial 412	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2849: astore 20
    //   2851: aload_0
    //   2852: aload 20
    //   2854: invokevirtual 416	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   2857: istore_2
    //   2858: iload_2
    //   2859: istore_1
    //   2860: iload_2
    //   2861: sipush -10002
    //   2864: if_icmpne +31 -> 2895
    //   2867: iload_2
    //   2868: istore_1
    //   2869: aload_0
    //   2870: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2873: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2876: lload 9
    //   2878: lsub
    //   2879: lload 11
    //   2881: lcmp
    //   2882: ifne +13 -> 2895
    //   2885: ldc 10
    //   2887: ldc_w 418
    //   2890: invokestatic 107	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2893: iconst_0
    //   2894: istore_1
    //   2895: iload_1
    //   2896: ifne +160 -> 3056
    //   2899: aload_0
    //   2900: invokevirtual 122	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2903: ifeq +153 -> 3056
    //   2906: aload_0
    //   2907: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2910: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2913: aload_0
    //   2914: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2917: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2920: lcmp
    //   2921: iflt +68 -> 2989
    //   2924: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2927: dup
    //   2928: iconst_0
    //   2929: aconst_null
    //   2930: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2933: astore 17
    //   2935: aload 20
    //   2937: ifnull +8 -> 2945
    //   2940: aload 20
    //   2942: invokevirtual 388	java/io/InputStream:close	()V
    //   2945: aload 18
    //   2947: ifnull +8 -> 2955
    //   2950: aload 18
    //   2952: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   2955: aload 17
    //   2957: areturn
    //   2958: astore 17
    //   2960: ldc 10
    //   2962: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2965: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   2968: aload 17
    //   2970: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2973: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2976: dup
    //   2977: sipush -30017
    //   2980: aload 17
    //   2982: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2985: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2988: areturn
    //   2989: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2992: dup
    //   2993: sipush -10020
    //   2996: aconst_null
    //   2997: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3000: astore 17
    //   3002: aload 20
    //   3004: ifnull +8 -> 3012
    //   3007: aload 20
    //   3009: invokevirtual 388	java/io/InputStream:close	()V
    //   3012: aload 18
    //   3014: ifnull +8 -> 3022
    //   3017: aload 18
    //   3019: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   3022: aload 17
    //   3024: areturn
    //   3025: astore 17
    //   3027: ldc 10
    //   3029: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3032: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   3035: aload 17
    //   3037: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3040: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3043: dup
    //   3044: sipush -30017
    //   3047: aload 17
    //   3049: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3052: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3055: areturn
    //   3056: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3059: dup
    //   3060: iload_1
    //   3061: aconst_null
    //   3062: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3065: astore 17
    //   3067: aload 20
    //   3069: ifnull +8 -> 3077
    //   3072: aload 20
    //   3074: invokevirtual 388	java/io/InputStream:close	()V
    //   3077: aload 18
    //   3079: ifnull +8 -> 3087
    //   3082: aload 18
    //   3084: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   3087: aload 17
    //   3089: areturn
    //   3090: astore 17
    //   3092: ldc 10
    //   3094: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3097: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   3100: aload 17
    //   3102: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3105: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3108: dup
    //   3109: sipush -30017
    //   3112: aload 17
    //   3114: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3117: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3120: areturn
    //   3121: aload 18
    //   3123: astore 17
    //   3125: aload 20
    //   3127: astore 19
    //   3129: aload 21
    //   3131: getfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3134: sipush -30002
    //   3137: if_icmpne -1540 -> 1597
    //   3140: iload_2
    //   3141: ifne -1544 -> 1597
    //   3144: aload 18
    //   3146: astore 17
    //   3148: aload 20
    //   3150: astore 19
    //   3152: aload 21
    //   3154: sipush -30029
    //   3157: putfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3160: goto -1563 -> 1597
    //   3163: astore 17
    //   3165: ldc 10
    //   3167: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3170: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   3173: aload 17
    //   3175: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3178: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   3181: dup
    //   3182: sipush -30017
    //   3185: aload 17
    //   3187: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3190: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   3193: areturn
    //   3194: astore 21
    //   3196: aload 20
    //   3198: astore 19
    //   3200: aload 18
    //   3202: astore 17
    //   3204: aload 21
    //   3206: astore 18
    //   3208: goto -764 -> 2444
    //   3211: astore 21
    //   3213: goto -938 -> 2275
    //   3216: astore 21
    //   3218: goto -1511 -> 1707
    //   3221: astore 21
    //   3223: iload 4
    //   3225: istore_1
    //   3226: iload_3
    //   3227: istore_2
    //   3228: goto -1735 -> 1493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3231	0	this	BaseDownloadTransfer
    //   31	3195	1	i	int
    //   37	3191	2	j	int
    //   28	3199	3	k	int
    //   25	3199	4	m	int
    //   337	2475	5	n	int
    //   374	2445	6	i1	int
    //   369	2207	7	i2	int
    //   1030	30	8	i3	int
    //   871	2006	9	l1	long
    //   911	1969	11	l2	long
    //   866	1533	13	l3	long
    //   1074	868	15	l4	long
    //   48	222	17	localObject1	Object
    //   272	23	17	localIOException1	IOException
    //   322	167	17	localObject2	Object
    //   503	23	17	localIOException2	IOException
    //   534	1	17	localNumberFormatException1	java.lang.NumberFormatException
    //   556	171	17	localObject3	Object
    //   741	23	17	localIOException3	IOException
    //   792	584	17	localObject4	Object
    //   1390	23	17	localIOException4	IOException
    //   1421	1	17	localNumberFormatException2	java.lang.NumberFormatException
    //   1443	1	17	localObject5	Object
    //   1479	11	17	localIOException5	IOException
    //   1495	115	17	localObject6	Object
    //   1624	23	17	localIOException6	IOException
    //   1677	106	17	localObject7	Object
    //   1797	23	17	localIOException7	IOException
    //   1870	481	17	localObject8	Object
    //   2365	23	17	localIOException8	IOException
    //   2424	208	17	localObject9	Object
    //   2646	23	17	localIOException9	IOException
    //   2697	34	17	localObject10	Object
    //   2745	23	17	localIOException10	IOException
    //   2796	160	17	localObject11	Object
    //   2958	23	17	localIOException11	IOException
    //   3000	23	17	localResult1	Transfer.Result
    //   3025	23	17	localIOException12	IOException
    //   3065	23	17	localResult2	Transfer.Result
    //   3090	23	17	localIOException13	IOException
    //   3123	24	17	localObject12	Object
    //   3163	23	17	localIOException14	IOException
    //   3202	1	17	localObject13	Object
    //   7	2416	18	localObject14	Object
    //   2442	759	18	localObject15	Object
    //   3206	1	18	localObject16	Object
    //   52	3147	19	localObject17	Object
    //   19	3178	20	localObject18	Object
    //   34	1629	21	localObject19	Object
    //   1697	64	21	localInterruptedException1	InterruptedException
    //   1768	465	21	localObject20	Object
    //   2265	64	21	localException1	java.lang.Exception
    //   2336	817	21	localObject21	Object
    //   3194	11	21	localObject22	Object
    //   3211	1	21	localException2	java.lang.Exception
    //   3216	1	21	localInterruptedException2	InterruptedException
    //   3221	1	21	localIOException15	IOException
    //   40	2784	22	localObject23	Object
    //   44	2784	23	localObject24	Object
    //   13	1687	24	localObject25	Object
    //   22	1460	25	localObject26	Object
    //   16	2252	26	localObject27	Object
    //   4	1458	27	localObject28	Object
    //   1655	31	27	localException3	java.lang.Exception
    //   1	574	28	str	String
    //   10	54	29	localObject29	Object
    //   58	767	30	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   243	251	272	java/io/IOException
    //   260	265	272	java/io/IOException
    //   478	486	503	java/io/IOException
    //   495	500	503	java/io/IOException
    //   459	474	534	java/lang/NumberFormatException
    //   716	724	741	java/io/IOException
    //   733	738	741	java/io/IOException
    //   1365	1373	1390	java/io/IOException
    //   1382	1387	1390	java/io/IOException
    //   944	951	1421	java/lang/NumberFormatException
    //   54	60	1479	java/io/IOException
    //   85	95	1479	java/io/IOException
    //   120	135	1479	java/io/IOException
    //   160	166	1479	java/io/IOException
    //   191	201	1479	java/io/IOException
    //   226	239	1479	java/io/IOException
    //   328	333	1479	java/io/IOException
    //   364	371	1479	java/io/IOException
    //   418	428	1479	java/io/IOException
    //   459	474	1479	java/io/IOException
    //   562	585	1479	java/io/IOException
    //   627	666	1479	java/io/IOException
    //   692	712	1479	java/io/IOException
    //   798	863	1479	java/io/IOException
    //   899	909	1479	java/io/IOException
    //   944	951	1479	java/io/IOException
    //   977	987	1479	java/io/IOException
    //   1022	1032	1479	java/io/IOException
    //   1054	1071	1479	java/io/IOException
    //   1128	1140	1479	java/io/IOException
    //   1166	1175	1479	java/io/IOException
    //   1208	1242	1479	java/io/IOException
    //   1268	1280	1479	java/io/IOException
    //   1306	1324	1479	java/io/IOException
    //   1350	1361	1479	java/io/IOException
    //   1449	1472	1479	java/io/IOException
    //   1683	1690	1479	java/io/IOException
    //   1876	1899	1479	java/io/IOException
    //   1929	1941	1479	java/io/IOException
    //   1978	1990	1479	java/io/IOException
    //   2026	2039	1479	java/io/IOException
    //   2065	2072	1479	java/io/IOException
    //   2098	2148	1479	java/io/IOException
    //   2174	2186	1479	java/io/IOException
    //   2220	2227	1479	java/io/IOException
    //   2253	2262	1479	java/io/IOException
    //   2430	2439	1479	java/io/IOException
    //   2500	2528	1479	java/io/IOException
    //   2554	2567	1479	java/io/IOException
    //   2604	2617	1479	java/io/IOException
    //   2703	2716	1479	java/io/IOException
    //   2802	2811	1479	java/io/IOException
    //   2837	2851	1479	java/io/IOException
    //   1602	1607	1624	java/io/IOException
    //   1616	1621	1624	java/io/IOException
    //   1054	1071	1655	java/lang/Exception
    //   54	60	1697	java/lang/InterruptedException
    //   85	95	1697	java/lang/InterruptedException
    //   120	135	1697	java/lang/InterruptedException
    //   160	166	1697	java/lang/InterruptedException
    //   191	201	1697	java/lang/InterruptedException
    //   226	239	1697	java/lang/InterruptedException
    //   328	333	1697	java/lang/InterruptedException
    //   364	371	1697	java/lang/InterruptedException
    //   418	428	1697	java/lang/InterruptedException
    //   459	474	1697	java/lang/InterruptedException
    //   562	585	1697	java/lang/InterruptedException
    //   627	666	1697	java/lang/InterruptedException
    //   692	712	1697	java/lang/InterruptedException
    //   798	863	1697	java/lang/InterruptedException
    //   899	909	1697	java/lang/InterruptedException
    //   944	951	1697	java/lang/InterruptedException
    //   977	987	1697	java/lang/InterruptedException
    //   1022	1032	1697	java/lang/InterruptedException
    //   1054	1071	1697	java/lang/InterruptedException
    //   1128	1140	1697	java/lang/InterruptedException
    //   1166	1175	1697	java/lang/InterruptedException
    //   1208	1242	1697	java/lang/InterruptedException
    //   1268	1280	1697	java/lang/InterruptedException
    //   1306	1324	1697	java/lang/InterruptedException
    //   1350	1361	1697	java/lang/InterruptedException
    //   1449	1472	1697	java/lang/InterruptedException
    //   1683	1690	1697	java/lang/InterruptedException
    //   1876	1899	1697	java/lang/InterruptedException
    //   1929	1941	1697	java/lang/InterruptedException
    //   1978	1990	1697	java/lang/InterruptedException
    //   2026	2039	1697	java/lang/InterruptedException
    //   2065	2072	1697	java/lang/InterruptedException
    //   2098	2148	1697	java/lang/InterruptedException
    //   2174	2186	1697	java/lang/InterruptedException
    //   2220	2227	1697	java/lang/InterruptedException
    //   2253	2262	1697	java/lang/InterruptedException
    //   2430	2439	1697	java/lang/InterruptedException
    //   2500	2528	1697	java/lang/InterruptedException
    //   2554	2567	1697	java/lang/InterruptedException
    //   2604	2617	1697	java/lang/InterruptedException
    //   2703	2716	1697	java/lang/InterruptedException
    //   2802	2811	1697	java/lang/InterruptedException
    //   2837	2851	1697	java/lang/InterruptedException
    //   1775	1780	1797	java/io/IOException
    //   1789	1794	1797	java/io/IOException
    //   54	60	2265	java/lang/Exception
    //   85	95	2265	java/lang/Exception
    //   120	135	2265	java/lang/Exception
    //   160	166	2265	java/lang/Exception
    //   191	201	2265	java/lang/Exception
    //   226	239	2265	java/lang/Exception
    //   328	333	2265	java/lang/Exception
    //   364	371	2265	java/lang/Exception
    //   418	428	2265	java/lang/Exception
    //   459	474	2265	java/lang/Exception
    //   562	585	2265	java/lang/Exception
    //   627	666	2265	java/lang/Exception
    //   692	712	2265	java/lang/Exception
    //   798	863	2265	java/lang/Exception
    //   899	909	2265	java/lang/Exception
    //   944	951	2265	java/lang/Exception
    //   977	987	2265	java/lang/Exception
    //   1022	1032	2265	java/lang/Exception
    //   1128	1140	2265	java/lang/Exception
    //   1166	1175	2265	java/lang/Exception
    //   1208	1242	2265	java/lang/Exception
    //   1268	1280	2265	java/lang/Exception
    //   1306	1324	2265	java/lang/Exception
    //   1350	1361	2265	java/lang/Exception
    //   1449	1472	2265	java/lang/Exception
    //   1683	1690	2265	java/lang/Exception
    //   1876	1899	2265	java/lang/Exception
    //   1929	1941	2265	java/lang/Exception
    //   1978	1990	2265	java/lang/Exception
    //   2026	2039	2265	java/lang/Exception
    //   2065	2072	2265	java/lang/Exception
    //   2098	2148	2265	java/lang/Exception
    //   2174	2186	2265	java/lang/Exception
    //   2220	2227	2265	java/lang/Exception
    //   2253	2262	2265	java/lang/Exception
    //   2430	2439	2265	java/lang/Exception
    //   2500	2528	2265	java/lang/Exception
    //   2554	2567	2265	java/lang/Exception
    //   2604	2617	2265	java/lang/Exception
    //   2703	2716	2265	java/lang/Exception
    //   2802	2811	2265	java/lang/Exception
    //   2837	2851	2265	java/lang/Exception
    //   2343	2348	2365	java/io/IOException
    //   2357	2362	2365	java/io/IOException
    //   54	60	2442	finally
    //   85	95	2442	finally
    //   120	135	2442	finally
    //   160	166	2442	finally
    //   191	201	2442	finally
    //   226	239	2442	finally
    //   328	333	2442	finally
    //   364	371	2442	finally
    //   418	428	2442	finally
    //   459	474	2442	finally
    //   562	585	2442	finally
    //   627	666	2442	finally
    //   692	712	2442	finally
    //   798	863	2442	finally
    //   899	909	2442	finally
    //   944	951	2442	finally
    //   977	987	2442	finally
    //   1022	1032	2442	finally
    //   1054	1071	2442	finally
    //   1128	1140	2442	finally
    //   1166	1175	2442	finally
    //   1208	1242	2442	finally
    //   1268	1280	2442	finally
    //   1306	1324	2442	finally
    //   1350	1361	2442	finally
    //   1449	1472	2442	finally
    //   1501	1531	2442	finally
    //   1539	1558	2442	finally
    //   1566	1577	2442	finally
    //   1589	1597	2442	finally
    //   1683	1690	2442	finally
    //   1715	1745	2442	finally
    //   1753	1770	2442	finally
    //   1876	1899	2442	finally
    //   1929	1941	2442	finally
    //   1978	1990	2442	finally
    //   2026	2039	2442	finally
    //   2065	2072	2442	finally
    //   2098	2148	2442	finally
    //   2174	2186	2442	finally
    //   2220	2227	2442	finally
    //   2253	2262	2442	finally
    //   2283	2313	2442	finally
    //   2321	2338	2442	finally
    //   2430	2439	2442	finally
    //   2500	2528	2442	finally
    //   2554	2567	2442	finally
    //   2604	2617	2442	finally
    //   2703	2716	2442	finally
    //   2802	2811	2442	finally
    //   2837	2851	2442	finally
    //   3129	3140	2442	finally
    //   3152	3160	2442	finally
    //   2621	2629	2646	java/io/IOException
    //   2638	2643	2646	java/io/IOException
    //   2720	2728	2745	java/io/IOException
    //   2737	2742	2745	java/io/IOException
    //   2940	2945	2958	java/io/IOException
    //   2950	2955	2958	java/io/IOException
    //   3007	3012	3025	java/io/IOException
    //   3017	3022	3025	java/io/IOException
    //   3072	3077	3090	java/io/IOException
    //   3082	3087	3090	java/io/IOException
    //   2449	2454	3163	java/io/IOException
    //   2459	2464	3163	java/io/IOException
    //   2851	2858	3194	finally
    //   2869	2893	3194	finally
    //   2899	2935	3194	finally
    //   2989	3002	3194	finally
    //   3056	3067	3194	finally
    //   2851	2858	3211	java/lang/Exception
    //   2869	2893	3211	java/lang/Exception
    //   2899	2935	3211	java/lang/Exception
    //   2989	3002	3211	java/lang/Exception
    //   3056	3067	3211	java/lang/Exception
    //   2851	2858	3216	java/lang/InterruptedException
    //   2869	2893	3216	java/lang/InterruptedException
    //   2899	2935	3216	java/lang/InterruptedException
    //   2989	3002	3216	java/lang/InterruptedException
    //   3056	3067	3216	java/lang/InterruptedException
    //   2851	2858	3221	java/io/IOException
    //   2869	2893	3221	java/io/IOException
    //   2899	2935	3221	java/io/IOException
    //   2989	3002	3221	java/io/IOException
    //   3056	3067	3221	java/io/IOException
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
      if (Utils.checkFileExist(this.mContext.getDestFilePath()))
      {
        String str = Utils.generateNewFilename(this.mContext.getDestFileName());
        this.mJob.renameDestFile(str);
      }
    }
    else {
      return 0;
    }
    Log.e("BaseDownloadTransfer", "rename to target file failed. target =" + this.mContext.getDestFilePath());
    return -10008;
  }
  
  protected Transfer.Result processDownload()
  {
    Transfer.Result localResult1 = acquireResource();
    if (localResult1.mRet != 0) {
      return localResult1;
    }
    long l2 = this.mStartTime;
    long l1 = l2;
    int k = 1;
    int j = 0;
    int i = 0;
    Transfer.Result localResult2;
    for (;;)
    {
      try
      {
        int m = getMaxTryTimes();
        if (i >= m)
        {
          localResult2 = localResult1;
          releaseResource();
          if (localResult2.mRet != 0) {
            break;
          }
          i = moveToTarget();
          if (i == 0)
          {
            localResult1 = null;
            return new Transfer.Result(i, localResult1);
          }
        }
        else
        {
          if (k == 0)
          {
            l2 = this.mStartTime;
            this.mStartTime = System.currentTimeMillis();
          }
          if (!this.mJob.isAlive())
          {
            localResult1 = new Transfer.Result(-10002, null);
            return localResult1;
          }
          if (!this.mJob.checkEnvironment())
          {
            localResult1 = new Transfer.Result(this.mJob.getLastErrorNo(), "check enviroment failed.");
            return localResult1;
          }
          if (k == 0)
          {
            this.mJob.reportDownloadTransferSize(2, localResult1.mRet, l2, l1, this.mContext.getCurSize() - this.mOffset, localResult1.mErrMsg);
            this.mOffset = this.mContext.getCurSize();
          }
          localResult1 = doDownload();
          localResult2 = localResult1;
          if (localResult1.mRet == 0) {
            continue;
          }
          l1 = System.currentTimeMillis();
          k = i;
          if (this.mOffset < this.mContext.getCurSize())
          {
            k = i;
            if (isSupportContinueInterruption())
            {
              Log.w("BaseDownloadTransfer", "get data " + (this.mContext.getCurSize() - this.mOffset) + ", meet error:" + localResult1.mRet);
              k = -1;
            }
          }
          boolean bool;
          if (k + 1 < getMaxTryTimes())
          {
            bool = true;
            localResult2 = handleError(bool, j, localResult1);
            i = localResult2.mRet;
            if (i != 0) {
              return localResult2;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          i = k + 1;
          j += 1;
          k = 0;
          continue;
        }
        String str = "move to target failed";
      }
      finally
      {
        releaseResource();
      }
    }
    return localResult2;
  }
  
  protected int readHttpContent(InputStream paramInputStream)
    throws SocketTimeoutException, IOException, InterruptedException
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      ByteArrayPool.ByteArrayBuffer localByteArrayBuffer;
      try
      {
        if (this.mDestFileWriter.getFilePointer() != this.mContext.getCurSize()) {
          this.mDestFileWriter.seek(this.mContext.getCurSize());
        }
        i = -1;
        localByteArrayBuffer = ByteArrayPool.getInstance().createBuffer();
        if (!this.mJob.isAlive())
        {
          i = -10002;
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
        Log.w("BaseDownloadTransfer", paramInputStream);
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
            this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
            if (j > 0) {}
          }
          catch (IOException paramInputStream)
          {
            Log.w("BaseDownloadTransfer", paramInputStream);
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
      Log.w("BaseDownloadTransfer", localIOException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.BaseDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */