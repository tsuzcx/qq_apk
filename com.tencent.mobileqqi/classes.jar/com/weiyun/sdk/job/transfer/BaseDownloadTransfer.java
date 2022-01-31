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
  protected long mStartTime;
  protected int mTimeoutTimes = 0;
  
  public BaseDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    this.mDownloadAddress = paramTransferAddress;
    this.mContext = paramDownloadJobContext;
    this.mJob = paramBaseDownloadJob;
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
  
  protected Transfer.Result doDownload()
  {
    if (!isSupportContinueInterruption())
    {
      this.mContext.setCurSize(0L);
      this.mOffset = 0L;
    }
    try
    {
      this.mDestFileWriter.setLength(0L);
      Transfer.Result localResult2 = doDownloadImpl();
      Transfer.Result localResult1 = localResult2;
      if (localResult2.mRet == -10002)
      {
        localResult1 = localResult2;
        if (this.mContext.getTotalSize() != 0L)
        {
          localResult1 = localResult2;
          if (this.mContext.getTotalSize() == this.mContext.getCurSize())
          {
            Log.i("BaseDownloadTransfer", "user canceled a finished job!");
            localResult1 = new Transfer.Result(0, null);
          }
        }
      }
      return localResult1;
    }
    catch (IOException localIOException)
    {
      Log.w("BaseDownloadTransfer", localIOException);
      return new Transfer.Result(-10008, Utils.getStackTraceAsString(localIOException));
    }
  }
  
  /* Error */
  protected Transfer.Result doDownloadImpl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 24
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 23
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 19
    //   18: aconst_null
    //   19: astore 21
    //   21: aconst_null
    //   22: astore 20
    //   24: iconst_0
    //   25: istore 4
    //   27: iconst_0
    //   28: istore_3
    //   29: iload 4
    //   31: istore_1
    //   32: aload 23
    //   34: astore 16
    //   36: iload_3
    //   37: istore_2
    //   38: aload 22
    //   40: astore 13
    //   42: aload 15
    //   44: astore 14
    //   46: aload 24
    //   48: astore 18
    //   50: aload 12
    //   52: astore 17
    //   54: aload_0
    //   55: invokevirtual 173	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 25
    //   60: iload 4
    //   62: istore_1
    //   63: aload 23
    //   65: astore 16
    //   67: iload_3
    //   68: istore_2
    //   69: aload 22
    //   71: astore 13
    //   73: aload 15
    //   75: astore 14
    //   77: aload 24
    //   79: astore 18
    //   81: aload 12
    //   83: astore 17
    //   85: aload 25
    //   87: invokevirtual 177	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 179	java/net/HttpURLConnection
    //   93: astore 12
    //   95: iload 4
    //   97: istore_1
    //   98: aload 12
    //   100: astore 16
    //   102: iload_3
    //   103: istore_2
    //   104: aload 12
    //   106: astore 13
    //   108: aload 15
    //   110: astore 14
    //   112: aload 12
    //   114: astore 18
    //   116: aload 12
    //   118: astore 17
    //   120: aload_0
    //   121: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   124: aload 12
    //   126: invokevirtual 182	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   129: invokevirtual 183	java/net/URL:getHost	()Ljava/lang/String;
    //   132: invokevirtual 187	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   135: iload 4
    //   137: istore_1
    //   138: aload 12
    //   140: astore 16
    //   142: iload_3
    //   143: istore_2
    //   144: aload 12
    //   146: astore 13
    //   148: aload 15
    //   150: astore 14
    //   152: aload 12
    //   154: astore 18
    //   156: aload 12
    //   158: astore 17
    //   160: aload_0
    //   161: aload 12
    //   163: invokevirtual 191	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   166: iload 4
    //   168: istore_1
    //   169: aload 12
    //   171: astore 16
    //   173: iload_3
    //   174: istore_2
    //   175: aload 12
    //   177: astore 13
    //   179: aload 15
    //   181: astore 14
    //   183: aload 12
    //   185: astore 18
    //   187: aload 12
    //   189: astore 17
    //   191: aload_0
    //   192: getfield 36	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   195: invokevirtual 194	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   198: ifne +105 -> 303
    //   201: iload 4
    //   203: istore_1
    //   204: aload 12
    //   206: astore 16
    //   208: iload_3
    //   209: istore_2
    //   210: aload 12
    //   212: astore 13
    //   214: aload 15
    //   216: astore 14
    //   218: aload 12
    //   220: astore 18
    //   222: aload 12
    //   224: astore 17
    //   226: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   229: dup
    //   230: sipush -10002
    //   233: aconst_null
    //   234: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   237: astore 15
    //   239: iconst_0
    //   240: ifeq +11 -> 251
    //   243: new 196	java/lang/NullPointerException
    //   246: dup
    //   247: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   250: athrow
    //   251: aload 15
    //   253: astore 13
    //   255: aload 12
    //   257: ifnull +12 -> 269
    //   260: aload 12
    //   262: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   265: aload 15
    //   267: astore 13
    //   269: aload 13
    //   271: areturn
    //   272: astore 12
    //   274: ldc 10
    //   276: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   279: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   282: aload 12
    //   284: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   290: dup
    //   291: sipush -30017
    //   294: aload 12
    //   296: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   299: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   302: areturn
    //   303: iload 4
    //   305: istore_1
    //   306: aload 12
    //   308: astore 16
    //   310: iload_3
    //   311: istore_2
    //   312: aload 12
    //   314: astore 13
    //   316: aload 15
    //   318: astore 14
    //   320: aload 12
    //   322: astore 18
    //   324: aload 12
    //   326: astore 17
    //   328: aload 12
    //   330: invokevirtual 214	java/net/HttpURLConnection:connect	()V
    //   333: iconst_1
    //   334: istore 4
    //   336: iconst_1
    //   337: istore 5
    //   339: iload 5
    //   341: istore_1
    //   342: aload 12
    //   344: astore 16
    //   346: iload_3
    //   347: istore_2
    //   348: aload 12
    //   350: astore 13
    //   352: aload 15
    //   354: astore 14
    //   356: aload 12
    //   358: astore 18
    //   360: aload 12
    //   362: astore 17
    //   364: aload 12
    //   366: invokevirtual 217	java/net/HttpURLConnection:getResponseCode	()I
    //   369: istore 7
    //   371: iconst_1
    //   372: istore_3
    //   373: iconst_1
    //   374: istore 6
    //   376: iload 7
    //   378: sipush 200
    //   381: if_icmpeq +202 -> 583
    //   384: iload 7
    //   386: sipush 206
    //   389: if_icmpeq +194 -> 583
    //   392: iload 5
    //   394: istore_1
    //   395: aload 12
    //   397: astore 16
    //   399: iload 6
    //   401: istore_2
    //   402: aload 12
    //   404: astore 13
    //   406: aload 15
    //   408: astore 14
    //   410: aload 12
    //   412: astore 18
    //   414: aload 12
    //   416: astore 17
    //   418: aload 12
    //   420: ldc 219
    //   422: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore 23
    //   427: aload 23
    //   429: ifnull +154 -> 583
    //   432: iload 5
    //   434: istore_1
    //   435: aload 12
    //   437: astore 16
    //   439: iload 6
    //   441: istore_2
    //   442: aload 12
    //   444: astore 13
    //   446: aload 15
    //   448: astore 14
    //   450: aload 12
    //   452: astore 18
    //   454: aload 12
    //   456: astore 17
    //   458: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   461: dup
    //   462: aload 23
    //   464: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   467: aconst_null
    //   468: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   471: astore 22
    //   473: iconst_0
    //   474: ifeq +11 -> 485
    //   477: new 196	java/lang/NullPointerException
    //   480: dup
    //   481: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   484: athrow
    //   485: aload 22
    //   487: astore 13
    //   489: aload 12
    //   491: ifnull -222 -> 269
    //   494: aload 12
    //   496: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   499: aload 22
    //   501: areturn
    //   502: astore 12
    //   504: ldc 10
    //   506: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   509: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   512: aload 12
    //   514: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   517: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   520: dup
    //   521: sipush -30017
    //   524: aload 12
    //   526: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   529: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   532: areturn
    //   533: astore 13
    //   535: iload 5
    //   537: istore_1
    //   538: aload 12
    //   540: astore 16
    //   542: iload 6
    //   544: istore_2
    //   545: aload 12
    //   547: astore 13
    //   549: aload 15
    //   551: astore 14
    //   553: aload 12
    //   555: astore 18
    //   557: aload 12
    //   559: astore 17
    //   561: ldc 10
    //   563: new 231	java/lang/StringBuilder
    //   566: dup
    //   567: ldc 233
    //   569: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   572: aload 23
    //   574: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: iload 7
    //   585: sipush 200
    //   588: if_icmpeq +180 -> 768
    //   591: iload 7
    //   593: sipush 206
    //   596: if_icmpeq +172 -> 768
    //   599: iload 5
    //   601: istore_1
    //   602: aload 12
    //   604: astore 16
    //   606: iload 6
    //   608: istore_2
    //   609: aload 12
    //   611: astore 13
    //   613: aload 15
    //   615: astore 14
    //   617: aload 12
    //   619: astore 18
    //   621: aload 12
    //   623: astore 17
    //   625: ldc 10
    //   627: new 231	java/lang/StringBuilder
    //   630: dup
    //   631: ldc 246
    //   633: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   636: aload_0
    //   637: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   640: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   643: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc 251
    //   648: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: iload 7
    //   653: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: iload 5
    //   664: istore_1
    //   665: aload 12
    //   667: astore 16
    //   669: iload 6
    //   671: istore_2
    //   672: aload 12
    //   674: astore 13
    //   676: aload 15
    //   678: astore 14
    //   680: aload 12
    //   682: astore 18
    //   684: aload 12
    //   686: astore 17
    //   688: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   691: dup
    //   692: iload 7
    //   694: sipush 30000
    //   697: isub
    //   698: iload 7
    //   700: invokestatic 260	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   703: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   706: astore 15
    //   708: iconst_0
    //   709: ifeq +11 -> 720
    //   712: new 196	java/lang/NullPointerException
    //   715: dup
    //   716: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   719: athrow
    //   720: aload 15
    //   722: astore 13
    //   724: aload 12
    //   726: ifnull -457 -> 269
    //   729: aload 12
    //   731: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   734: aload 15
    //   736: areturn
    //   737: astore 12
    //   739: ldc 10
    //   741: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   744: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   747: aload 12
    //   749: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   752: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   755: dup
    //   756: sipush -30017
    //   759: aload 12
    //   761: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   764: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   767: areturn
    //   768: iload 5
    //   770: istore_1
    //   771: aload 12
    //   773: astore 16
    //   775: iload 6
    //   777: istore_2
    //   778: aload 12
    //   780: astore 13
    //   782: aload 15
    //   784: astore 14
    //   786: aload 12
    //   788: astore 18
    //   790: aload 12
    //   792: astore 17
    //   794: new 231	java/lang/StringBuilder
    //   797: dup
    //   798: ldc_w 262
    //   801: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   804: aload_0
    //   805: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   808: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   811: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 264
    //   817: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload 25
    //   822: invokevirtual 265	java/net/URL:toString	()Ljava/lang/String;
    //   825: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: ldc_w 267
    //   831: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_0
    //   835: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   838: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   841: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   844: ldc_w 272
    //   847: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload 12
    //   852: invokevirtual 275	java/net/HttpURLConnection:getContentLength	()I
    //   855: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: ldc2_w 276
    //   862: lstore 10
    //   864: iload 5
    //   866: istore_1
    //   867: aload 12
    //   869: astore 16
    //   871: iload 6
    //   873: istore_2
    //   874: aload 12
    //   876: astore 13
    //   878: aload 15
    //   880: astore 14
    //   882: aload 12
    //   884: astore 18
    //   886: aload 12
    //   888: astore 17
    //   890: aload 12
    //   892: ldc_w 279
    //   895: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   898: astore 22
    //   900: lload 10
    //   902: lstore 8
    //   904: aload 22
    //   906: ifnull +36 -> 942
    //   909: iload 5
    //   911: istore_1
    //   912: aload 12
    //   914: astore 16
    //   916: iload 6
    //   918: istore_2
    //   919: aload 12
    //   921: astore 13
    //   923: aload 15
    //   925: astore 14
    //   927: aload 12
    //   929: astore 18
    //   931: aload 12
    //   933: astore 17
    //   935: aload 22
    //   937: invokestatic 285	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   940: lstore 8
    //   942: lload 8
    //   944: lconst_0
    //   945: lcmp
    //   946: ifne +532 -> 1478
    //   949: iload 5
    //   951: istore_1
    //   952: aload 12
    //   954: astore 16
    //   956: iload 6
    //   958: istore_2
    //   959: aload 12
    //   961: astore 13
    //   963: aload 15
    //   965: astore 14
    //   967: aload 12
    //   969: astore 18
    //   971: aload 12
    //   973: astore 17
    //   975: ldc 10
    //   977: new 231	java/lang/StringBuilder
    //   980: dup
    //   981: ldc_w 287
    //   984: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload_0
    //   988: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   991: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   994: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: ldc_w 289
    //   1000: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1009: iload 5
    //   1011: istore_1
    //   1012: aload 12
    //   1014: astore 16
    //   1016: iload 6
    //   1018: istore_2
    //   1019: aload 12
    //   1021: astore 13
    //   1023: aload 15
    //   1025: astore 14
    //   1027: aload 12
    //   1029: astore 18
    //   1031: aload 12
    //   1033: astore 17
    //   1035: aload_0
    //   1036: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1039: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1042: lconst_0
    //   1043: lcmp
    //   1044: ifle +335 -> 1379
    //   1047: iload 5
    //   1049: istore_1
    //   1050: aload 12
    //   1052: astore 16
    //   1054: iload 6
    //   1056: istore_2
    //   1057: aload 12
    //   1059: astore 13
    //   1061: aload 15
    //   1063: astore 14
    //   1065: aload 12
    //   1067: astore 18
    //   1069: aload 12
    //   1071: astore 17
    //   1073: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1076: dup
    //   1077: sipush -29005
    //   1080: aconst_null
    //   1081: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1084: astore 15
    //   1086: iconst_0
    //   1087: ifeq +11 -> 1098
    //   1090: new 196	java/lang/NullPointerException
    //   1093: dup
    //   1094: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   1097: athrow
    //   1098: aload 15
    //   1100: astore 13
    //   1102: aload 12
    //   1104: ifnull -835 -> 269
    //   1107: aload 12
    //   1109: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1112: aload 15
    //   1114: areturn
    //   1115: astore 12
    //   1117: ldc 10
    //   1119: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1122: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1125: aload 12
    //   1127: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1130: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1133: dup
    //   1134: sipush -30017
    //   1137: aload 12
    //   1139: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1142: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1145: areturn
    //   1146: astore 13
    //   1148: iload 5
    //   1150: istore_1
    //   1151: aload 12
    //   1153: astore 16
    //   1155: iload 6
    //   1157: istore_2
    //   1158: aload 12
    //   1160: astore 13
    //   1162: aload 15
    //   1164: astore 14
    //   1166: aload 12
    //   1168: astore 18
    //   1170: aload 12
    //   1172: astore 17
    //   1174: ldc 10
    //   1176: new 231	java/lang/StringBuilder
    //   1179: dup
    //   1180: ldc_w 291
    //   1183: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1186: aload 22
    //   1188: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 293	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: lload 10
    //   1199: lstore 8
    //   1201: goto -259 -> 942
    //   1204: astore 13
    //   1206: aload 20
    //   1208: astore 15
    //   1210: aload 16
    //   1212: astore 12
    //   1214: aload 13
    //   1216: astore 16
    //   1218: aload 12
    //   1220: astore 13
    //   1222: aload 15
    //   1224: astore 14
    //   1226: ldc 10
    //   1228: new 231	java/lang/StringBuilder
    //   1231: dup
    //   1232: ldc 246
    //   1234: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1237: aload_0
    //   1238: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1241: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1244: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: aload 16
    //   1252: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1255: aload 12
    //   1257: astore 13
    //   1259: aload 15
    //   1261: astore 14
    //   1263: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1266: dup
    //   1267: aload 16
    //   1269: invokestatic 302	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1272: aload 16
    //   1274: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1277: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1280: astore 16
    //   1282: aload 12
    //   1284: astore 13
    //   1286: aload 15
    //   1288: astore 14
    //   1290: aload 16
    //   1292: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1295: sipush -30002
    //   1298: if_icmpne +473 -> 1771
    //   1301: iload_1
    //   1302: ifne +469 -> 1771
    //   1305: aload 12
    //   1307: astore 13
    //   1309: aload 15
    //   1311: astore 14
    //   1313: aload 16
    //   1315: sipush -30028
    //   1318: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1321: aload 15
    //   1323: ifnull +8 -> 1331
    //   1326: aload 15
    //   1328: invokevirtual 307	java/io/InputStream:close	()V
    //   1331: aload 16
    //   1333: astore 13
    //   1335: aload 12
    //   1337: ifnull -1068 -> 269
    //   1340: aload 12
    //   1342: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1345: aload 16
    //   1347: areturn
    //   1348: astore 12
    //   1350: ldc 10
    //   1352: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1355: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1358: aload 12
    //   1360: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1363: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1366: dup
    //   1367: sipush -30017
    //   1370: aload 12
    //   1372: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1375: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1378: areturn
    //   1379: iload 5
    //   1381: istore_1
    //   1382: aload 12
    //   1384: astore 16
    //   1386: iload 6
    //   1388: istore_2
    //   1389: aload 12
    //   1391: astore 13
    //   1393: aload 15
    //   1395: astore 14
    //   1397: aload 12
    //   1399: astore 18
    //   1401: aload 12
    //   1403: astore 17
    //   1405: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1408: dup
    //   1409: sipush -29001
    //   1412: aconst_null
    //   1413: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1416: astore 15
    //   1418: iconst_0
    //   1419: ifeq +11 -> 1430
    //   1422: new 196	java/lang/NullPointerException
    //   1425: dup
    //   1426: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   1429: athrow
    //   1430: aload 15
    //   1432: astore 13
    //   1434: aload 12
    //   1436: ifnull -1167 -> 269
    //   1439: aload 12
    //   1441: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1444: aload 15
    //   1446: areturn
    //   1447: astore 12
    //   1449: ldc 10
    //   1451: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1454: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1457: aload 12
    //   1459: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1462: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1465: dup
    //   1466: sipush -30017
    //   1469: aload 12
    //   1471: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1474: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1477: areturn
    //   1478: lload 8
    //   1480: lconst_0
    //   1481: lcmp
    //   1482: ifle +46 -> 1528
    //   1485: iload 5
    //   1487: istore_1
    //   1488: aload 12
    //   1490: astore 16
    //   1492: iload 6
    //   1494: istore_2
    //   1495: aload 12
    //   1497: astore 13
    //   1499: aload 15
    //   1501: astore 14
    //   1503: aload 12
    //   1505: astore 18
    //   1507: aload 12
    //   1509: astore 17
    //   1511: aload_0
    //   1512: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1515: aload_0
    //   1516: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1519: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1522: lload 8
    //   1524: ladd
    //   1525: invokevirtual 310	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1528: iload 5
    //   1530: istore_1
    //   1531: aload 12
    //   1533: astore 16
    //   1535: iload 6
    //   1537: istore_2
    //   1538: aload 12
    //   1540: astore 13
    //   1542: aload 15
    //   1544: astore 14
    //   1546: aload 12
    //   1548: astore 18
    //   1550: aload 12
    //   1552: astore 17
    //   1554: aload_0
    //   1555: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1558: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1561: lstore 10
    //   1563: iload 5
    //   1565: istore_1
    //   1566: aload 12
    //   1568: astore 16
    //   1570: iload 6
    //   1572: istore_2
    //   1573: aload 12
    //   1575: astore 13
    //   1577: aload 15
    //   1579: astore 14
    //   1581: aload 12
    //   1583: astore 18
    //   1585: aload 12
    //   1587: astore 17
    //   1589: new 312	java/io/BufferedInputStream
    //   1592: dup
    //   1593: aload 12
    //   1595: invokevirtual 316	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1598: invokespecial 319	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1601: astore 15
    //   1603: aload_0
    //   1604: aload 15
    //   1606: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   1609: istore_1
    //   1610: iload_1
    //   1611: sipush -10002
    //   1614: if_icmpne +92 -> 1706
    //   1617: aload_0
    //   1618: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1621: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1624: lload 10
    //   1626: lsub
    //   1627: lload 8
    //   1629: lcmp
    //   1630: ifne +76 -> 1706
    //   1633: ldc 10
    //   1635: ldc_w 325
    //   1638: invokestatic 161	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1641: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1644: dup
    //   1645: iconst_0
    //   1646: aconst_null
    //   1647: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1650: astore 13
    //   1652: aload 15
    //   1654: ifnull +8 -> 1662
    //   1657: aload 15
    //   1659: invokevirtual 307	java/io/InputStream:close	()V
    //   1662: aload 12
    //   1664: ifnull +8 -> 1672
    //   1667: aload 12
    //   1669: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1672: aload 13
    //   1674: areturn
    //   1675: astore 12
    //   1677: ldc 10
    //   1679: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1682: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1685: aload 12
    //   1687: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1690: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1693: dup
    //   1694: sipush -30017
    //   1697: aload 12
    //   1699: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1702: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1705: areturn
    //   1706: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1709: dup
    //   1710: iload_1
    //   1711: aconst_null
    //   1712: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1715: astore 13
    //   1717: aload 15
    //   1719: ifnull +8 -> 1727
    //   1722: aload 15
    //   1724: invokevirtual 307	java/io/InputStream:close	()V
    //   1727: aload 12
    //   1729: ifnull +8 -> 1737
    //   1732: aload 12
    //   1734: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1737: aload 13
    //   1739: areturn
    //   1740: astore 12
    //   1742: ldc 10
    //   1744: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1747: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1750: aload 12
    //   1752: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1755: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1758: dup
    //   1759: sipush -30017
    //   1762: aload 12
    //   1764: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1767: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1770: areturn
    //   1771: aload 12
    //   1773: astore 13
    //   1775: aload 15
    //   1777: astore 14
    //   1779: aload 16
    //   1781: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1784: sipush -30002
    //   1787: if_icmpne -466 -> 1321
    //   1790: iload_2
    //   1791: ifne -470 -> 1321
    //   1794: aload 12
    //   1796: astore 13
    //   1798: aload 15
    //   1800: astore 14
    //   1802: aload 16
    //   1804: sipush -30029
    //   1807: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1810: goto -489 -> 1321
    //   1813: astore 15
    //   1815: aload 13
    //   1817: astore 12
    //   1819: aload 14
    //   1821: ifnull +8 -> 1829
    //   1824: aload 14
    //   1826: invokevirtual 307	java/io/InputStream:close	()V
    //   1829: aload 12
    //   1831: ifnull +8 -> 1839
    //   1834: aload 12
    //   1836: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1839: aload 15
    //   1841: athrow
    //   1842: astore 16
    //   1844: aload 19
    //   1846: astore 15
    //   1848: aload 18
    //   1850: astore 12
    //   1852: aload 12
    //   1854: astore 13
    //   1856: aload 15
    //   1858: astore 14
    //   1860: ldc 10
    //   1862: new 231	java/lang/StringBuilder
    //   1865: dup
    //   1866: ldc 246
    //   1868: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1871: aload_0
    //   1872: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1875: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1878: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1884: aload 16
    //   1886: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1889: aload 12
    //   1891: astore 13
    //   1893: aload 15
    //   1895: astore 14
    //   1897: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1900: dup
    //   1901: sipush -10002
    //   1904: aload 16
    //   1906: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1909: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1912: astore 16
    //   1914: aload 15
    //   1916: ifnull +8 -> 1924
    //   1919: aload 15
    //   1921: invokevirtual 307	java/io/InputStream:close	()V
    //   1924: aload 16
    //   1926: astore 13
    //   1928: aload 12
    //   1930: ifnull -1661 -> 269
    //   1933: aload 12
    //   1935: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1938: aload 16
    //   1940: areturn
    //   1941: astore 12
    //   1943: ldc 10
    //   1945: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1948: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1951: aload 12
    //   1953: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1956: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1959: dup
    //   1960: sipush -30017
    //   1963: aload 12
    //   1965: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1968: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1971: areturn
    //   1972: astore 16
    //   1974: aload 21
    //   1976: astore 15
    //   1978: aload 17
    //   1980: astore 12
    //   1982: aload 12
    //   1984: astore 13
    //   1986: aload 15
    //   1988: astore 14
    //   1990: ldc 10
    //   1992: new 231	java/lang/StringBuilder
    //   1995: dup
    //   1996: ldc 246
    //   1998: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2001: aload_0
    //   2002: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2005: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2008: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2014: aload 16
    //   2016: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2019: aload 12
    //   2021: astore 13
    //   2023: aload 15
    //   2025: astore 14
    //   2027: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2030: dup
    //   2031: sipush -10014
    //   2034: aload 16
    //   2036: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2039: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2042: astore 16
    //   2044: aload 15
    //   2046: ifnull +8 -> 2054
    //   2049: aload 15
    //   2051: invokevirtual 307	java/io/InputStream:close	()V
    //   2054: aload 16
    //   2056: astore 13
    //   2058: aload 12
    //   2060: ifnull -1791 -> 269
    //   2063: aload 12
    //   2065: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   2068: aload 16
    //   2070: areturn
    //   2071: astore 12
    //   2073: ldc 10
    //   2075: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2078: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2081: aload 12
    //   2083: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2086: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2089: dup
    //   2090: sipush -30017
    //   2093: aload 12
    //   2095: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2098: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2101: areturn
    //   2102: astore 12
    //   2104: ldc 10
    //   2106: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2109: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2112: aload 12
    //   2114: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2117: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2120: dup
    //   2121: sipush -30017
    //   2124: aload 12
    //   2126: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2129: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2132: areturn
    //   2133: astore 13
    //   2135: aload 15
    //   2137: astore 14
    //   2139: aload 13
    //   2141: astore 15
    //   2143: goto -324 -> 1819
    //   2146: astore 16
    //   2148: goto -166 -> 1982
    //   2151: astore 16
    //   2153: goto -301 -> 1852
    //   2156: astore 16
    //   2158: iload 4
    //   2160: istore_1
    //   2161: iload_3
    //   2162: istore_2
    //   2163: goto -945 -> 1218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2166	0	this	BaseDownloadTransfer
    //   31	2130	1	i	int
    //   37	2126	2	j	int
    //   28	2134	3	k	int
    //   25	2134	4	m	int
    //   337	1227	5	n	int
    //   374	1197	6	i1	int
    //   369	330	7	i2	int
    //   902	726	8	l1	long
    //   862	763	10	l2	long
    //   7	254	12	localHttpURLConnection	HttpURLConnection
    //   272	223	12	localIOException1	IOException
    //   502	228	12	localIOException2	IOException
    //   737	371	12	localIOException3	IOException
    //   1115	56	12	localIOException4	IOException
    //   1212	129	12	localObject1	Object
    //   1348	92	12	localIOException5	IOException
    //   1447	221	12	localIOException6	IOException
    //   1675	58	12	localIOException7	IOException
    //   1740	55	12	localIOException8	IOException
    //   1817	117	12	localObject2	Object
    //   1941	23	12	localIOException9	IOException
    //   1980	84	12	localObject3	Object
    //   2071	23	12	localIOException10	IOException
    //   2102	23	12	localIOException11	IOException
    //   40	448	13	localObject4	Object
    //   533	1	13	localNumberFormatException1	java.lang.NumberFormatException
    //   547	554	13	localObject5	Object
    //   1146	1	13	localNumberFormatException2	java.lang.NumberFormatException
    //   1160	1	13	localIOException12	IOException
    //   1204	11	13	localIOException13	IOException
    //   1220	837	13	localObject6	Object
    //   2133	7	13	localObject7	Object
    //   44	2094	14	localObject8	Object
    //   13	1786	15	localObject9	Object
    //   1813	27	15	localObject10	Object
    //   1846	296	15	localObject11	Object
    //   34	1769	16	localObject12	Object
    //   1842	63	16	localInterruptedException1	InterruptedException
    //   1912	27	16	localResult1	Transfer.Result
    //   1972	63	16	localException1	java.lang.Exception
    //   2042	27	16	localResult2	Transfer.Result
    //   2146	1	16	localException2	java.lang.Exception
    //   2151	1	16	localInterruptedException2	InterruptedException
    //   2156	1	16	localIOException14	IOException
    //   52	1927	17	localObject13	Object
    //   48	1801	18	localObject14	Object
    //   16	1829	19	localObject15	Object
    //   22	1185	20	localObject16	Object
    //   19	1956	21	localObject17	Object
    //   1	1186	22	localObject18	Object
    //   10	563	23	str	String
    //   4	74	24	localObject19	Object
    //   58	763	25	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   243	251	272	java/io/IOException
    //   260	265	272	java/io/IOException
    //   477	485	502	java/io/IOException
    //   494	499	502	java/io/IOException
    //   458	473	533	java/lang/NumberFormatException
    //   712	720	737	java/io/IOException
    //   729	734	737	java/io/IOException
    //   1090	1098	1115	java/io/IOException
    //   1107	1112	1115	java/io/IOException
    //   935	942	1146	java/lang/NumberFormatException
    //   54	60	1204	java/io/IOException
    //   85	95	1204	java/io/IOException
    //   120	135	1204	java/io/IOException
    //   160	166	1204	java/io/IOException
    //   191	201	1204	java/io/IOException
    //   226	239	1204	java/io/IOException
    //   328	333	1204	java/io/IOException
    //   364	371	1204	java/io/IOException
    //   418	427	1204	java/io/IOException
    //   458	473	1204	java/io/IOException
    //   561	583	1204	java/io/IOException
    //   625	662	1204	java/io/IOException
    //   688	708	1204	java/io/IOException
    //   794	859	1204	java/io/IOException
    //   890	900	1204	java/io/IOException
    //   935	942	1204	java/io/IOException
    //   975	1009	1204	java/io/IOException
    //   1035	1047	1204	java/io/IOException
    //   1073	1086	1204	java/io/IOException
    //   1174	1197	1204	java/io/IOException
    //   1405	1418	1204	java/io/IOException
    //   1511	1528	1204	java/io/IOException
    //   1554	1563	1204	java/io/IOException
    //   1589	1603	1204	java/io/IOException
    //   1326	1331	1348	java/io/IOException
    //   1340	1345	1348	java/io/IOException
    //   1422	1430	1447	java/io/IOException
    //   1439	1444	1447	java/io/IOException
    //   1657	1662	1675	java/io/IOException
    //   1667	1672	1675	java/io/IOException
    //   1722	1727	1740	java/io/IOException
    //   1732	1737	1740	java/io/IOException
    //   54	60	1813	finally
    //   85	95	1813	finally
    //   120	135	1813	finally
    //   160	166	1813	finally
    //   191	201	1813	finally
    //   226	239	1813	finally
    //   328	333	1813	finally
    //   364	371	1813	finally
    //   418	427	1813	finally
    //   458	473	1813	finally
    //   561	583	1813	finally
    //   625	662	1813	finally
    //   688	708	1813	finally
    //   794	859	1813	finally
    //   890	900	1813	finally
    //   935	942	1813	finally
    //   975	1009	1813	finally
    //   1035	1047	1813	finally
    //   1073	1086	1813	finally
    //   1174	1197	1813	finally
    //   1226	1255	1813	finally
    //   1263	1282	1813	finally
    //   1290	1301	1813	finally
    //   1313	1321	1813	finally
    //   1405	1418	1813	finally
    //   1511	1528	1813	finally
    //   1554	1563	1813	finally
    //   1589	1603	1813	finally
    //   1779	1790	1813	finally
    //   1802	1810	1813	finally
    //   1860	1889	1813	finally
    //   1897	1914	1813	finally
    //   1990	2019	1813	finally
    //   2027	2044	1813	finally
    //   54	60	1842	java/lang/InterruptedException
    //   85	95	1842	java/lang/InterruptedException
    //   120	135	1842	java/lang/InterruptedException
    //   160	166	1842	java/lang/InterruptedException
    //   191	201	1842	java/lang/InterruptedException
    //   226	239	1842	java/lang/InterruptedException
    //   328	333	1842	java/lang/InterruptedException
    //   364	371	1842	java/lang/InterruptedException
    //   418	427	1842	java/lang/InterruptedException
    //   458	473	1842	java/lang/InterruptedException
    //   561	583	1842	java/lang/InterruptedException
    //   625	662	1842	java/lang/InterruptedException
    //   688	708	1842	java/lang/InterruptedException
    //   794	859	1842	java/lang/InterruptedException
    //   890	900	1842	java/lang/InterruptedException
    //   935	942	1842	java/lang/InterruptedException
    //   975	1009	1842	java/lang/InterruptedException
    //   1035	1047	1842	java/lang/InterruptedException
    //   1073	1086	1842	java/lang/InterruptedException
    //   1174	1197	1842	java/lang/InterruptedException
    //   1405	1418	1842	java/lang/InterruptedException
    //   1511	1528	1842	java/lang/InterruptedException
    //   1554	1563	1842	java/lang/InterruptedException
    //   1589	1603	1842	java/lang/InterruptedException
    //   1919	1924	1941	java/io/IOException
    //   1933	1938	1941	java/io/IOException
    //   54	60	1972	java/lang/Exception
    //   85	95	1972	java/lang/Exception
    //   120	135	1972	java/lang/Exception
    //   160	166	1972	java/lang/Exception
    //   191	201	1972	java/lang/Exception
    //   226	239	1972	java/lang/Exception
    //   328	333	1972	java/lang/Exception
    //   364	371	1972	java/lang/Exception
    //   418	427	1972	java/lang/Exception
    //   458	473	1972	java/lang/Exception
    //   561	583	1972	java/lang/Exception
    //   625	662	1972	java/lang/Exception
    //   688	708	1972	java/lang/Exception
    //   794	859	1972	java/lang/Exception
    //   890	900	1972	java/lang/Exception
    //   935	942	1972	java/lang/Exception
    //   975	1009	1972	java/lang/Exception
    //   1035	1047	1972	java/lang/Exception
    //   1073	1086	1972	java/lang/Exception
    //   1174	1197	1972	java/lang/Exception
    //   1405	1418	1972	java/lang/Exception
    //   1511	1528	1972	java/lang/Exception
    //   1554	1563	1972	java/lang/Exception
    //   1589	1603	1972	java/lang/Exception
    //   2049	2054	2071	java/io/IOException
    //   2063	2068	2071	java/io/IOException
    //   1824	1829	2102	java/io/IOException
    //   1834	1839	2102	java/io/IOException
    //   1603	1610	2133	finally
    //   1617	1652	2133	finally
    //   1706	1717	2133	finally
    //   1603	1610	2146	java/lang/Exception
    //   1617	1652	2146	java/lang/Exception
    //   1706	1717	2146	java/lang/Exception
    //   1603	1610	2151	java/lang/InterruptedException
    //   1617	1652	2151	java/lang/InterruptedException
    //   1706	1717	2151	java/lang/InterruptedException
    //   1603	1610	2156	java/io/IOException
    //   1617	1652	2156	java/io/IOException
    //   1706	1717	2156	java/io/IOException
  }
  
  protected int getMaxTryTimes()
  {
    return 3;
  }
  
  protected boolean isSupportContinueInterruption()
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
    int j = 1;
    int i = 0;
    Object localObject3;
    for (;;)
    {
      try
      {
        int k = getMaxTryTimes();
        if (i >= k)
        {
          localResult2 = localResult1;
          releaseResource();
          if (localResult2.mRet != 0) {
            break;
          }
          i = moveToTarget();
          if (i != 0) {
            break label608;
          }
          localResult1 = null;
          return new Transfer.Result(i, localResult1);
        }
        if (j == 0)
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
        if (j == 0)
        {
          this.mJob.reportDownloadTransferSize(2, localResult1.mRet, l2, l1, this.mContext.getCurSize() - this.mOffset, localResult1.mErrMsg);
          this.mOffset = this.mContext.getCurSize();
        }
        localResult1 = doDownload();
        Transfer.Result localResult2 = localResult1;
        if (localResult1.mRet == 0) {
          continue;
        }
        if ((localResult1.mRet == -30002) || (localResult1.mRet == -30028) || (localResult1.mRet == -30029))
        {
          this.mTimeoutTimes += 1;
          j = i;
          if (this.mOffset < this.mContext.getCurSize())
          {
            j = i;
            if (isSupportContinueInterruption())
            {
              Log.w("BaseDownloadTransfer", "get data " + (this.mContext.getCurSize() - this.mOffset) + ", meet error:" + localResult1.mRet);
              j = 0;
            }
          }
          l1 = System.currentTimeMillis();
          if ((!ErrorCode.isNetworkError(localResult1.mRet)) || (j + 1 >= getMaxTryTimes()) || (!this.mJob.isAlive())) {
            break label512;
          }
          l3 = (2500.0D * (2.0D + Math.pow(j, 0.5D)));
          Log.i("BaseDownloadTransfer", "Last transfer network error, so rollback, sleep time = " + l3 + ", id = " + this.mJob.getId());
        }
      }
      finally
      {
        long l3;
        releaseResource();
      }
      try
      {
        Thread.sleep(l3);
        i = j + 1;
        j = 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.w("BaseDownloadTransfer", localInterruptedException.getMessage(), localInterruptedException);
        localObject1.mRet = -10002;
        localObject1.mErrMsg = Utils.getStackTraceAsString(localInterruptedException);
        localObject3 = localObject1;
      }
      this.mTimeoutTimes = 0;
      continue;
      continue;
      label512:
      if (localObject1.mRet == -29110)
      {
        Log.w("BaseDownloadTransfer", "file offset is wrong! offset :" + this.mContext.getCurSize());
        this.mContext.setCurSize(0L);
        this.mOffset = 0L;
        try
        {
          this.mDestFileWriter.setLength(0L);
        }
        catch (IOException localIOException)
        {
          Log.w("BaseDownloadTransfer", localIOException);
          localObject2 = new Transfer.Result(-10008, Utils.getStackTraceAsString(localIOException));
          releaseResource();
          return localObject2;
        }
        label608:
        Object localObject2 = "move to target failed";
      }
    }
    return localObject3;
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
      paramHttpURLConnection.setConnectTimeout(this.mTimeoutTimes * 5000 + 25000);
      paramHttpURLConnection.setReadTimeout(this.mTimeoutTimes * 5000 + 25000);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.BaseDownloadTransfer
 * JD-Core Version:    0.7.0.1
 */