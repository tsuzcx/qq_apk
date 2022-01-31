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
    //   1: astore 18
    //   3: aconst_null
    //   4: astore 27
    //   6: aconst_null
    //   7: astore 29
    //   9: aconst_null
    //   10: astore 28
    //   12: aconst_null
    //   13: astore 26
    //   15: aconst_null
    //   16: astore 25
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 24
    //   24: iconst_0
    //   25: istore 4
    //   27: iconst_0
    //   28: istore_3
    //   29: iload 4
    //   31: istore_1
    //   32: aload 28
    //   34: astore 22
    //   36: iload_3
    //   37: istore_2
    //   38: aload 18
    //   40: astore 23
    //   42: aload 27
    //   44: astore 21
    //   46: aload 29
    //   48: astore 17
    //   50: aload 20
    //   52: astore 19
    //   54: aload_0
    //   55: invokevirtual 259	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 30
    //   60: iload 4
    //   62: istore_1
    //   63: aload 28
    //   65: astore 22
    //   67: iload_3
    //   68: istore_2
    //   69: aload 18
    //   71: astore 23
    //   73: aload 27
    //   75: astore 21
    //   77: aload 29
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
    //   100: astore 22
    //   102: iload_3
    //   103: istore_2
    //   104: aload 18
    //   106: astore 23
    //   108: aload 18
    //   110: astore 21
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
    //   140: astore 22
    //   142: iload_3
    //   143: istore_2
    //   144: aload 18
    //   146: astore 23
    //   148: aload 18
    //   150: astore 21
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
    //   171: astore 22
    //   173: iload_3
    //   174: istore_2
    //   175: aload 18
    //   177: astore 23
    //   179: aload 18
    //   181: astore 21
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
    //   206: astore 22
    //   208: iload_3
    //   209: istore_2
    //   210: aload 18
    //   212: astore 23
    //   214: aload 18
    //   216: astore 21
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
    //   308: astore 22
    //   310: iload_3
    //   311: istore_2
    //   312: aload 18
    //   314: astore 23
    //   316: aload 18
    //   318: astore 21
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
    //   344: astore 22
    //   346: iload_3
    //   347: istore_2
    //   348: aload 18
    //   350: astore 23
    //   352: aload 18
    //   354: astore 21
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
    //   397: astore 22
    //   399: iload 6
    //   401: istore_2
    //   402: aload 18
    //   404: astore 23
    //   406: aload 18
    //   408: astore 21
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
    //   438: astore 22
    //   440: iload 6
    //   442: istore_2
    //   443: aload 18
    //   445: astore 23
    //   447: aload 18
    //   449: astore 21
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
    //   541: astore 22
    //   543: iload 6
    //   545: istore_2
    //   546: aload 18
    //   548: astore 23
    //   550: aload 18
    //   552: astore 21
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
    //   606: astore 22
    //   608: iload 6
    //   610: istore_2
    //   611: aload 18
    //   613: astore 23
    //   615: aload 18
    //   617: astore 21
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
    //   671: astore 22
    //   673: iload 6
    //   675: istore_2
    //   676: aload 18
    //   678: astore 23
    //   680: aload 18
    //   682: astore 21
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
    //   777: astore 22
    //   779: iload 6
    //   781: istore_2
    //   782: aload 18
    //   784: astore 23
    //   786: aload 18
    //   788: astore 21
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
    //   878: astore 22
    //   880: iload 6
    //   882: istore_2
    //   883: aload 18
    //   885: astore 23
    //   887: aload 18
    //   889: astore 21
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
    //   923: astore 22
    //   925: iload 6
    //   927: istore_2
    //   928: aload 18
    //   930: astore 23
    //   932: aload 18
    //   934: astore 21
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
    //   956: astore 22
    //   958: iload 6
    //   960: istore_2
    //   961: aload 18
    //   963: astore 23
    //   965: aload 18
    //   967: astore 21
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
    //   1001: astore 22
    //   1003: iload 6
    //   1005: istore_2
    //   1006: aload 18
    //   1008: astore 23
    //   1010: aload 18
    //   1012: astore 21
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
    //   1037: astore 22
    //   1039: iload 6
    //   1041: istore_2
    //   1042: aload 18
    //   1044: astore 23
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
    //   1081: if_icmpne +743 -> 1824
    //   1084: lload 11
    //   1086: lconst_0
    //   1087: lcmp
    //   1088: ifle +736 -> 1824
    //   1091: lload 11
    //   1093: lstore 9
    //   1095: lload 9
    //   1097: lconst_0
    //   1098: lcmp
    //   1099: ifle +890 -> 1989
    //   1102: iload 5
    //   1104: istore_1
    //   1105: aload 18
    //   1107: astore 22
    //   1109: iload 6
    //   1111: istore_2
    //   1112: aload 18
    //   1114: astore 23
    //   1116: aload 18
    //   1118: astore 21
    //   1120: aload 18
    //   1122: astore 17
    //   1124: aload 20
    //   1126: astore 19
    //   1128: aload_0
    //   1129: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1132: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1135: lconst_0
    //   1136: lcmp
    //   1137: ifgt +852 -> 1989
    //   1140: iload 5
    //   1142: istore_1
    //   1143: aload 18
    //   1145: astore 22
    //   1147: iload 6
    //   1149: istore_2
    //   1150: aload 18
    //   1152: astore 23
    //   1154: aload 18
    //   1156: astore 21
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
    //   1187: astore 22
    //   1189: iload 6
    //   1191: istore_2
    //   1192: aload 18
    //   1194: astore 23
    //   1196: aload 18
    //   1198: astore 21
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
    //   1247: astore 22
    //   1249: iload 6
    //   1251: istore_2
    //   1252: aload 18
    //   1254: astore 23
    //   1256: aload 18
    //   1258: astore 21
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
    //   1285: astore 22
    //   1287: iload 6
    //   1289: istore_2
    //   1290: aload 18
    //   1292: astore 23
    //   1294: aload 18
    //   1296: astore 21
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
    //   1329: astore 22
    //   1331: iload 6
    //   1333: istore_2
    //   1334: aload 18
    //   1336: astore 23
    //   1338: aload 18
    //   1340: astore 21
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
    //   1428: astore 22
    //   1430: iload 6
    //   1432: istore_2
    //   1433: aload 18
    //   1435: astore 23
    //   1437: aload 18
    //   1439: astore 21
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
    //   1479: astore 21
    //   1481: aload 24
    //   1483: astore 20
    //   1485: aload 22
    //   1487: astore 18
    //   1489: aload 18
    //   1491: astore 17
    //   1493: aload 20
    //   1495: astore 19
    //   1497: ldc 10
    //   1499: new 79	java/lang/StringBuilder
    //   1502: dup
    //   1503: ldc_w 311
    //   1506: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1509: aload_0
    //   1510: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1513: invokevirtual 377	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1516: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1522: aload 21
    //   1524: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1527: aload 18
    //   1529: astore 17
    //   1531: aload 20
    //   1533: astore 19
    //   1535: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1538: dup
    //   1539: aload 21
    //   1541: invokestatic 383	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1544: aload 21
    //   1546: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1549: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1552: astore 21
    //   1554: aload 18
    //   1556: astore 17
    //   1558: aload 20
    //   1560: astore 19
    //   1562: aload 21
    //   1564: getfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1567: sipush -30002
    //   1570: if_icmpne +1551 -> 3121
    //   1573: iload_1
    //   1574: ifne +1547 -> 3121
    //   1577: aload 18
    //   1579: astore 17
    //   1581: aload 20
    //   1583: astore 19
    //   1585: aload 21
    //   1587: sipush -30028
    //   1590: putfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1593: aload 20
    //   1595: ifnull +8 -> 1603
    //   1598: aload 20
    //   1600: invokevirtual 388	java/io/InputStream:close	()V
    //   1603: aload 21
    //   1605: astore 17
    //   1607: aload 18
    //   1609: ifnull -1340 -> 269
    //   1612: aload 18
    //   1614: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   1617: aload 21
    //   1619: areturn
    //   1620: astore 17
    //   1622: ldc 10
    //   1624: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1627: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   1630: aload 17
    //   1632: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1635: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1638: dup
    //   1639: sipush -30017
    //   1642: aload 17
    //   1644: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1647: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1650: areturn
    //   1651: astore 27
    //   1653: iload 5
    //   1655: istore_1
    //   1656: aload 18
    //   1658: astore 22
    //   1660: iload 6
    //   1662: istore_2
    //   1663: aload 18
    //   1665: astore 23
    //   1667: aload 18
    //   1669: astore 21
    //   1671: aload 18
    //   1673: astore 17
    //   1675: aload 20
    //   1677: astore 19
    //   1679: ldc 10
    //   1681: aload 27
    //   1683: invokestatic 241	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1686: lload 9
    //   1688: lstore 13
    //   1690: goto -619 -> 1071
    //   1693: astore 21
    //   1695: aload 26
    //   1697: astore 20
    //   1699: aload 23
    //   1701: astore 18
    //   1703: aload 18
    //   1705: astore 17
    //   1707: aload 20
    //   1709: astore 19
    //   1711: ldc 10
    //   1713: new 79	java/lang/StringBuilder
    //   1716: dup
    //   1717: ldc_w 311
    //   1720: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1723: aload_0
    //   1724: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1727: invokevirtual 377	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1730: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1736: aload 21
    //   1738: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1741: aload 18
    //   1743: astore 17
    //   1745: aload 20
    //   1747: astore 19
    //   1749: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1752: dup
    //   1753: sipush -10002
    //   1756: aload 21
    //   1758: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1761: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1764: astore 21
    //   1766: aload 20
    //   1768: ifnull +8 -> 1776
    //   1771: aload 20
    //   1773: invokevirtual 388	java/io/InputStream:close	()V
    //   1776: aload 21
    //   1778: astore 17
    //   1780: aload 18
    //   1782: ifnull -1513 -> 269
    //   1785: aload 18
    //   1787: invokevirtual 282	java/net/HttpURLConnection:disconnect	()V
    //   1790: aload 21
    //   1792: areturn
    //   1793: astore 17
    //   1795: ldc 10
    //   1797: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1800: invokevirtual 289	java/lang/Thread:getName	()Ljava/lang/String;
    //   1803: aload 17
    //   1805: invokestatic 132	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1808: new 52	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1811: dup
    //   1812: sipush -30017
    //   1815: aload 17
    //   1817: invokestatic 138	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1820: invokespecial 125	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1823: areturn
    //   1824: iload 7
    //   1826: sipush 206
    //   1829: if_icmpne +17 -> 1846
    //   1832: lload 13
    //   1834: lconst_0
    //   1835: lcmp
    //   1836: ifle +10 -> 1846
    //   1839: lload 13
    //   1841: lstore 9
    //   1843: goto -748 -> 1095
    //   1846: iload 5
    //   1848: istore_1
    //   1849: aload 18
    //   1851: astore 22
    //   1853: iload 6
    //   1855: istore_2
    //   1856: aload 18
    //   1858: astore 23
    //   1860: aload 18
    //   1862: astore 21
    //   1864: aload 18
    //   1866: astore 17
    //   1868: aload 20
    //   1870: astore 19
    //   1872: ldc 10
    //   1874: new 79	java/lang/StringBuilder
    //   1877: dup
    //   1878: ldc_w 390
    //   1881: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1884: iload 7
    //   1886: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1889: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1892: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1895: lload 15
    //   1897: lstore 9
    //   1899: iload 5
    //   1901: istore_1
    //   1902: aload 18
    //   1904: astore 22
    //   1906: iload 6
    //   1908: istore_2
    //   1909: aload 18
    //   1911: astore 23
    //   1913: aload 18
    //   1915: astore 21
    //   1917: aload 18
    //   1919: astore 17
    //   1921: aload 20
    //   1923: astore 19
    //   1925: aload_0
    //   1926: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1929: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   1932: lconst_0
    //   1933: lcmp
    //   1934: ifgt -839 -> 1095
    //   1937: lload 15
    //   1939: lstore 9
    //   1941: lload 11
    //   1943: lconst_0
    //   1944: lcmp
    //   1945: ifle -850 -> 1095
    //   1948: iload 5
    //   1950: istore_1
    //   1951: aload 18
    //   1953: astore 22
    //   1955: iload 6
    //   1957: istore_2
    //   1958: aload 18
    //   1960: astore 23
    //   1962: aload 18
    //   1964: astore 21
    //   1966: aload 18
    //   1968: astore 17
    //   1970: aload 20
    //   1972: astore 19
    //   1974: aload_0
    //   1975: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1978: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1981: lload 11
    //   1983: ladd
    //   1984: lstore 9
    //   1986: goto -891 -> 1095
    //   1989: lload 9
    //   1991: lconst_0
    //   1992: lcmp
    //   1993: ifle +474 -> 2467
    //   1996: iload 5
    //   1998: istore_1
    //   1999: aload 18
    //   2001: astore 22
    //   2003: iload 6
    //   2005: istore_2
    //   2006: aload 18
    //   2008: astore 23
    //   2010: aload 18
    //   2012: astore 21
    //   2014: aload 18
    //   2016: astore 17
    //   2018: aload 20
    //   2020: astore 19
    //   2022: aload_0
    //   2023: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2026: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2029: lload 9
    //   2031: lcmp
    //   2032: ifeq +435 -> 2467
    //   2035: iload 5
    //   2037: istore_1
    //   2038: aload 18
    //   2040: astore 22
    //   2042: iload 6
    //   2044: istore_2
    //   2045: aload 18
    //   2047: astore 23
    //   2049: aload 18
    //   2051: astore 21
    //   2053: aload 18
    //   2055: astore 17
    //   2057: aload 20
    //   2059: astore 19
    //   2061: aload_0
    //   2062: invokevirtual 245	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportContinueInterruption	()Z
    //   2065: ifeq +79 -> 2144
    //   2068: iload 5
    //   2070: istore_1
    //   2071: aload 18
    //   2073: astore 22
    //   2075: iload 6
    //   2077: istore_2
    //   2078: aload 18
    //   2080: astore 23
    //   2082: aload 18
    //   2084: astore 21
    //   2086: aload 18
    //   2088: astore 17
    //   2090: aload 20
    //   2092: astore 19
    //   2094: ldc 10
    //   2096: new 79	java/lang/StringBuilder
    //   2099: dup
    //   2100: ldc_w 392
    //   2103: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2106: aload_0
    //   2107: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2110: invokevirtual 251	com/weiyun/sdk/job/DownloadJobContext:getTotalSize	()J
    //   2113: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2116: ldc_w 394
    //   2119: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: lload 11
    //   2124: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2127: ldc_w 396
    //   2130: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2133: lload 13
    //   2135: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2138: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2141: invokestatic 147	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2144: iload 5
    //   2146: istore_1
    //   2147: aload 18
    //   2149: astore 22
    //   2151: iload 6
    //   2153: istore_2
    //   2154: aload 18
    //   2156: astore 23
    //   2158: aload 18
    //   2160: astore 21
    //   2162: aload 18
    //   2164: astore 17
    //   2166: aload 20
    //   2168: astore 19
    //   2170: aload_0
    //   2171: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2174: invokevirtual 145	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   2177: lconst_0
    //   2178: lcmp
    //   2179: ifne +217 -> 2396
    //   2182: lload 9
    //   2184: lload 11
    //   2186: lcmp
    //   2187: ifne +209 -> 2396
    //   2190: iload 5
    //   2192: istore_1
    //   2193: aload 18
    //   2195: astore 22
    //   2197: iload 6
    //   2199: istore_2
    //   2200: aload 18
    //   2202: astore 23
    //   2204: aload 18
    //   2206: astore 21
    //   2208: aload 18
    //   2210: astore 17
    //   2212: aload 20
    //   2214: astore 19
    //   2216: aload_0
    //   2217: invokevirtual 122	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:isSupportSplitDownload	()Z
    //   2220: ifne +176 -> 2396
    //   2223: iload 5
    //   2225: istore_1
    //   2226: aload 18
    //   2228: astore 22
    //   2230: iload 6
    //   2232: istore_2
    //   2233: aload 18
    //   2235: astore 23
    //   2237: aload 18
    //   2239: astore 21
    //   2241: aload 18
    //   2243: astore 17
    //   2245: aload 20
    //   2247: astore 19
    //   2249: aload_0
    //   2250: getfield 43	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2253: lload 9
    //   2255: invokevirtual 366	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   2258: goto -1083 -> 1175
    //   2261: astore 17
    //   2263: aload 25
    //   2265: astore 20
    //   2267: aload 21
    //   2269: astore 18
    //   2271: aload 17
    //   2273: astore 21
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
    //   2409: astore 22
    //   2411: iload 6
    //   2413: istore_2
    //   2414: aload 18
    //   2416: astore 23
    //   2418: aload 18
    //   2420: astore 21
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
    //   2479: astore 22
    //   2481: iload 6
    //   2483: istore_2
    //   2484: aload 18
    //   2486: astore 23
    //   2488: aload 18
    //   2490: astore 21
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
    //   2533: astore 22
    //   2535: iload 6
    //   2537: istore_2
    //   2538: aload 18
    //   2540: astore 23
    //   2542: aload 18
    //   2544: astore 21
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
    //   2583: astore 22
    //   2585: iload 6
    //   2587: istore_2
    //   2588: aload 18
    //   2590: astore 23
    //   2592: aload 18
    //   2594: astore 21
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
    //   2682: astore 22
    //   2684: iload 6
    //   2686: istore_2
    //   2687: aload 18
    //   2689: astore 23
    //   2691: aload 18
    //   2693: astore 21
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
    //   2781: astore 22
    //   2783: iload 6
    //   2785: istore_2
    //   2786: aload 18
    //   2788: astore 23
    //   2790: aload 18
    //   2792: astore 21
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
    //   2816: astore 22
    //   2818: iload 6
    //   2820: istore_2
    //   2821: aload 18
    //   2823: astore 23
    //   2825: aload 18
    //   2827: astore 21
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
    //   3137: if_icmpne -1544 -> 1593
    //   3140: iload_2
    //   3141: ifne -1548 -> 1593
    //   3144: aload 18
    //   3146: astore 17
    //   3148: aload 20
    //   3150: astore 19
    //   3152: aload 21
    //   3154: sipush -30029
    //   3157: putfield 55	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   3160: goto -1567 -> 1593
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
    //   3218: goto -1515 -> 1703
    //   3221: astore 21
    //   3223: iload 4
    //   3225: istore_1
    //   3226: iload_3
    //   3227: istore_2
    //   3228: goto -1739 -> 1489
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
    //   1074	864	15	l4	long
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
    //   1443	163	17	localObject5	Object
    //   1620	23	17	localIOException5	IOException
    //   1673	106	17	localObject6	Object
    //   1793	23	17	localIOException6	IOException
    //   1866	378	17	localObject7	Object
    //   2261	11	17	localException1	java.lang.Exception
    //   2277	74	17	localObject8	Object
    //   2365	23	17	localIOException7	IOException
    //   2424	208	17	localObject9	Object
    //   2646	23	17	localIOException8	IOException
    //   2697	34	17	localObject10	Object
    //   2745	23	17	localIOException9	IOException
    //   2796	160	17	localObject11	Object
    //   2958	23	17	localIOException10	IOException
    //   3000	23	17	localResult1	Transfer.Result
    //   3025	23	17	localIOException11	IOException
    //   3065	23	17	localResult2	Transfer.Result
    //   3090	23	17	localIOException12	IOException
    //   3123	24	17	localObject12	Object
    //   3163	23	17	localIOException13	IOException
    //   3202	1	17	localObject13	Object
    //   1	2422	18	localObject14	Object
    //   2442	759	18	localObject15	Object
    //   3206	1	18	localObject16	Object
    //   52	3147	19	localObject17	Object
    //   19	3178	20	localObject18	Object
    //   44	1396	21	localObject19	Object
    //   1479	66	21	localIOException14	IOException
    //   1552	118	21	localObject20	Object
    //   1693	64	21	localInterruptedException1	InterruptedException
    //   1764	1389	21	localObject21	Object
    //   3194	11	21	localObject22	Object
    //   3211	1	21	localException2	java.lang.Exception
    //   3216	1	21	localInterruptedException2	InterruptedException
    //   3221	1	21	localIOException15	IOException
    //   34	2783	22	localObject23	Object
    //   40	2784	23	localObject24	Object
    //   22	1460	24	localObject25	Object
    //   16	2248	25	localObject26	Object
    //   13	1683	26	localObject27	Object
    //   4	1458	27	localObject28	Object
    //   1651	31	27	localException3	java.lang.Exception
    //   10	565	28	str	String
    //   7	71	29	localObject29	Object
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
    //   1679	1686	1479	java/io/IOException
    //   1872	1895	1479	java/io/IOException
    //   1925	1937	1479	java/io/IOException
    //   1974	1986	1479	java/io/IOException
    //   2022	2035	1479	java/io/IOException
    //   2061	2068	1479	java/io/IOException
    //   2094	2144	1479	java/io/IOException
    //   2170	2182	1479	java/io/IOException
    //   2216	2223	1479	java/io/IOException
    //   2249	2258	1479	java/io/IOException
    //   2430	2439	1479	java/io/IOException
    //   2500	2528	1479	java/io/IOException
    //   2554	2567	1479	java/io/IOException
    //   2604	2617	1479	java/io/IOException
    //   2703	2716	1479	java/io/IOException
    //   2802	2811	1479	java/io/IOException
    //   2837	2851	1479	java/io/IOException
    //   1598	1603	1620	java/io/IOException
    //   1612	1617	1620	java/io/IOException
    //   1054	1071	1651	java/lang/Exception
    //   54	60	1693	java/lang/InterruptedException
    //   85	95	1693	java/lang/InterruptedException
    //   120	135	1693	java/lang/InterruptedException
    //   160	166	1693	java/lang/InterruptedException
    //   191	201	1693	java/lang/InterruptedException
    //   226	239	1693	java/lang/InterruptedException
    //   328	333	1693	java/lang/InterruptedException
    //   364	371	1693	java/lang/InterruptedException
    //   418	428	1693	java/lang/InterruptedException
    //   459	474	1693	java/lang/InterruptedException
    //   562	585	1693	java/lang/InterruptedException
    //   627	666	1693	java/lang/InterruptedException
    //   692	712	1693	java/lang/InterruptedException
    //   798	863	1693	java/lang/InterruptedException
    //   899	909	1693	java/lang/InterruptedException
    //   944	951	1693	java/lang/InterruptedException
    //   977	987	1693	java/lang/InterruptedException
    //   1022	1032	1693	java/lang/InterruptedException
    //   1054	1071	1693	java/lang/InterruptedException
    //   1128	1140	1693	java/lang/InterruptedException
    //   1166	1175	1693	java/lang/InterruptedException
    //   1208	1242	1693	java/lang/InterruptedException
    //   1268	1280	1693	java/lang/InterruptedException
    //   1306	1324	1693	java/lang/InterruptedException
    //   1350	1361	1693	java/lang/InterruptedException
    //   1449	1472	1693	java/lang/InterruptedException
    //   1679	1686	1693	java/lang/InterruptedException
    //   1872	1895	1693	java/lang/InterruptedException
    //   1925	1937	1693	java/lang/InterruptedException
    //   1974	1986	1693	java/lang/InterruptedException
    //   2022	2035	1693	java/lang/InterruptedException
    //   2061	2068	1693	java/lang/InterruptedException
    //   2094	2144	1693	java/lang/InterruptedException
    //   2170	2182	1693	java/lang/InterruptedException
    //   2216	2223	1693	java/lang/InterruptedException
    //   2249	2258	1693	java/lang/InterruptedException
    //   2430	2439	1693	java/lang/InterruptedException
    //   2500	2528	1693	java/lang/InterruptedException
    //   2554	2567	1693	java/lang/InterruptedException
    //   2604	2617	1693	java/lang/InterruptedException
    //   2703	2716	1693	java/lang/InterruptedException
    //   2802	2811	1693	java/lang/InterruptedException
    //   2837	2851	1693	java/lang/InterruptedException
    //   1771	1776	1793	java/io/IOException
    //   1785	1790	1793	java/io/IOException
    //   54	60	2261	java/lang/Exception
    //   85	95	2261	java/lang/Exception
    //   120	135	2261	java/lang/Exception
    //   160	166	2261	java/lang/Exception
    //   191	201	2261	java/lang/Exception
    //   226	239	2261	java/lang/Exception
    //   328	333	2261	java/lang/Exception
    //   364	371	2261	java/lang/Exception
    //   418	428	2261	java/lang/Exception
    //   459	474	2261	java/lang/Exception
    //   562	585	2261	java/lang/Exception
    //   627	666	2261	java/lang/Exception
    //   692	712	2261	java/lang/Exception
    //   798	863	2261	java/lang/Exception
    //   899	909	2261	java/lang/Exception
    //   944	951	2261	java/lang/Exception
    //   977	987	2261	java/lang/Exception
    //   1022	1032	2261	java/lang/Exception
    //   1128	1140	2261	java/lang/Exception
    //   1166	1175	2261	java/lang/Exception
    //   1208	1242	2261	java/lang/Exception
    //   1268	1280	2261	java/lang/Exception
    //   1306	1324	2261	java/lang/Exception
    //   1350	1361	2261	java/lang/Exception
    //   1449	1472	2261	java/lang/Exception
    //   1679	1686	2261	java/lang/Exception
    //   1872	1895	2261	java/lang/Exception
    //   1925	1937	2261	java/lang/Exception
    //   1974	1986	2261	java/lang/Exception
    //   2022	2035	2261	java/lang/Exception
    //   2061	2068	2261	java/lang/Exception
    //   2094	2144	2261	java/lang/Exception
    //   2170	2182	2261	java/lang/Exception
    //   2216	2223	2261	java/lang/Exception
    //   2249	2258	2261	java/lang/Exception
    //   2430	2439	2261	java/lang/Exception
    //   2500	2528	2261	java/lang/Exception
    //   2554	2567	2261	java/lang/Exception
    //   2604	2617	2261	java/lang/Exception
    //   2703	2716	2261	java/lang/Exception
    //   2802	2811	2261	java/lang/Exception
    //   2837	2851	2261	java/lang/Exception
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
    //   1497	1527	2442	finally
    //   1535	1554	2442	finally
    //   1562	1573	2442	finally
    //   1585	1593	2442	finally
    //   1679	1686	2442	finally
    //   1711	1741	2442	finally
    //   1749	1766	2442	finally
    //   1872	1895	2442	finally
    //   1925	1937	2442	finally
    //   1974	1986	2442	finally
    //   2022	2035	2442	finally
    //   2061	2068	2442	finally
    //   2094	2144	2442	finally
    //   2170	2182	2442	finally
    //   2216	2223	2442	finally
    //   2249	2258	2442	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.BaseDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */