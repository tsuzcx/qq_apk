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
    //   1: astore 23
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 22
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 21
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 19
    //   24: iconst_0
    //   25: istore_3
    //   26: iconst_0
    //   27: istore 4
    //   29: iload_3
    //   30: istore_1
    //   31: aload 22
    //   33: astore 16
    //   35: iload 4
    //   37: istore_2
    //   38: aload 23
    //   40: astore 13
    //   42: aload 15
    //   44: astore 14
    //   46: aload 12
    //   48: astore 18
    //   50: aload 24
    //   52: astore 17
    //   54: aload_0
    //   55: invokevirtual 173	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 25
    //   60: iload_3
    //   61: istore_1
    //   62: aload 22
    //   64: astore 16
    //   66: iload 4
    //   68: istore_2
    //   69: aload 23
    //   71: astore 13
    //   73: aload 15
    //   75: astore 14
    //   77: aload 12
    //   79: astore 18
    //   81: aload 24
    //   83: astore 17
    //   85: aload 25
    //   87: invokevirtual 177	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 179	java/net/HttpURLConnection
    //   93: astore 12
    //   95: iload_3
    //   96: istore_1
    //   97: aload 12
    //   99: astore 16
    //   101: iload 4
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
    //   135: iload_3
    //   136: istore_1
    //   137: aload 12
    //   139: astore 16
    //   141: iload 4
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
    //   166: iload_3
    //   167: istore_1
    //   168: aload 12
    //   170: astore 16
    //   172: iload 4
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
    //   201: iload_3
    //   202: istore_1
    //   203: aload 12
    //   205: astore 16
    //   207: iload 4
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
    //   303: iload_3
    //   304: istore_1
    //   305: aload 12
    //   307: astore 16
    //   309: iload 4
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
    //   334: istore_3
    //   335: iconst_1
    //   336: istore 5
    //   338: iload 5
    //   340: istore_1
    //   341: aload 12
    //   343: astore 16
    //   345: iload 4
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
    //   372: istore 4
    //   374: iconst_1
    //   375: istore 6
    //   377: iload 7
    //   379: sipush 200
    //   382: if_icmpeq +202 -> 584
    //   385: iload 7
    //   387: sipush 206
    //   390: if_icmpeq +194 -> 584
    //   393: iload 5
    //   395: istore_1
    //   396: aload 12
    //   398: astore 16
    //   400: iload 6
    //   402: istore_2
    //   403: aload 12
    //   405: astore 13
    //   407: aload 15
    //   409: astore 14
    //   411: aload 12
    //   413: astore 18
    //   415: aload 12
    //   417: astore 17
    //   419: aload 12
    //   421: ldc 219
    //   423: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 23
    //   428: aload 23
    //   430: ifnull +154 -> 584
    //   433: iload 5
    //   435: istore_1
    //   436: aload 12
    //   438: astore 16
    //   440: iload 6
    //   442: istore_2
    //   443: aload 12
    //   445: astore 13
    //   447: aload 15
    //   449: astore 14
    //   451: aload 12
    //   453: astore 18
    //   455: aload 12
    //   457: astore 17
    //   459: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   462: dup
    //   463: aload 23
    //   465: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   468: aconst_null
    //   469: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   472: astore 22
    //   474: iconst_0
    //   475: ifeq +11 -> 486
    //   478: new 196	java/lang/NullPointerException
    //   481: dup
    //   482: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   485: athrow
    //   486: aload 22
    //   488: astore 13
    //   490: aload 12
    //   492: ifnull -223 -> 269
    //   495: aload 12
    //   497: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   500: aload 22
    //   502: areturn
    //   503: astore 12
    //   505: ldc 10
    //   507: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   510: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   513: aload 12
    //   515: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   521: dup
    //   522: sipush -30017
    //   525: aload 12
    //   527: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   530: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   533: areturn
    //   534: astore 13
    //   536: iload 5
    //   538: istore_1
    //   539: aload 12
    //   541: astore 16
    //   543: iload 6
    //   545: istore_2
    //   546: aload 12
    //   548: astore 13
    //   550: aload 15
    //   552: astore 14
    //   554: aload 12
    //   556: astore 18
    //   558: aload 12
    //   560: astore 17
    //   562: ldc 10
    //   564: new 231	java/lang/StringBuilder
    //   567: dup
    //   568: ldc 233
    //   570: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   573: aload 23
    //   575: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: iload 7
    //   586: sipush 200
    //   589: if_icmpeq +180 -> 769
    //   592: iload 7
    //   594: sipush 206
    //   597: if_icmpeq +172 -> 769
    //   600: iload 5
    //   602: istore_1
    //   603: aload 12
    //   605: astore 16
    //   607: iload 6
    //   609: istore_2
    //   610: aload 12
    //   612: astore 13
    //   614: aload 15
    //   616: astore 14
    //   618: aload 12
    //   620: astore 18
    //   622: aload 12
    //   624: astore 17
    //   626: ldc 10
    //   628: new 231	java/lang/StringBuilder
    //   631: dup
    //   632: ldc 246
    //   634: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   637: aload_0
    //   638: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   641: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   644: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: ldc 251
    //   649: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload 7
    //   654: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: iload 5
    //   665: istore_1
    //   666: aload 12
    //   668: astore 16
    //   670: iload 6
    //   672: istore_2
    //   673: aload 12
    //   675: astore 13
    //   677: aload 15
    //   679: astore 14
    //   681: aload 12
    //   683: astore 18
    //   685: aload 12
    //   687: astore 17
    //   689: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   692: dup
    //   693: iload 7
    //   695: sipush 30000
    //   698: isub
    //   699: iload 7
    //   701: invokestatic 260	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   704: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   707: astore 15
    //   709: iconst_0
    //   710: ifeq +11 -> 721
    //   713: new 196	java/lang/NullPointerException
    //   716: dup
    //   717: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   720: athrow
    //   721: aload 15
    //   723: astore 13
    //   725: aload 12
    //   727: ifnull -458 -> 269
    //   730: aload 12
    //   732: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   735: aload 15
    //   737: areturn
    //   738: astore 12
    //   740: ldc 10
    //   742: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   745: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   748: aload 12
    //   750: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   753: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   756: dup
    //   757: sipush -30017
    //   760: aload 12
    //   762: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   765: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   768: areturn
    //   769: iload 5
    //   771: istore_1
    //   772: aload 12
    //   774: astore 16
    //   776: iload 6
    //   778: istore_2
    //   779: aload 12
    //   781: astore 13
    //   783: aload 15
    //   785: astore 14
    //   787: aload 12
    //   789: astore 18
    //   791: aload 12
    //   793: astore 17
    //   795: new 231	java/lang/StringBuilder
    //   798: dup
    //   799: ldc_w 262
    //   802: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   809: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   812: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: ldc_w 264
    //   818: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload 25
    //   823: invokevirtual 265	java/net/URL:toString	()Ljava/lang/String;
    //   826: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: ldc_w 267
    //   832: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload_0
    //   836: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   839: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   842: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   845: ldc_w 272
    //   848: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload 12
    //   853: invokevirtual 275	java/net/HttpURLConnection:getContentLength	()I
    //   856: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: ldc2_w 276
    //   863: lstore 10
    //   865: iload 5
    //   867: istore_1
    //   868: aload 12
    //   870: astore 16
    //   872: iload 6
    //   874: istore_2
    //   875: aload 12
    //   877: astore 13
    //   879: aload 15
    //   881: astore 14
    //   883: aload 12
    //   885: astore 18
    //   887: aload 12
    //   889: astore 17
    //   891: aload 12
    //   893: ldc_w 279
    //   896: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   899: astore 22
    //   901: lload 10
    //   903: lstore 8
    //   905: aload 22
    //   907: ifnull +36 -> 943
    //   910: iload 5
    //   912: istore_1
    //   913: aload 12
    //   915: astore 16
    //   917: iload 6
    //   919: istore_2
    //   920: aload 12
    //   922: astore 13
    //   924: aload 15
    //   926: astore 14
    //   928: aload 12
    //   930: astore 18
    //   932: aload 12
    //   934: astore 17
    //   936: aload 22
    //   938: invokestatic 285	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   941: lstore 8
    //   943: lload 8
    //   945: lconst_0
    //   946: lcmp
    //   947: ifne +532 -> 1479
    //   950: iload 5
    //   952: istore_1
    //   953: aload 12
    //   955: astore 16
    //   957: iload 6
    //   959: istore_2
    //   960: aload 12
    //   962: astore 13
    //   964: aload 15
    //   966: astore 14
    //   968: aload 12
    //   970: astore 18
    //   972: aload 12
    //   974: astore 17
    //   976: ldc 10
    //   978: new 231	java/lang/StringBuilder
    //   981: dup
    //   982: ldc_w 287
    //   985: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   988: aload_0
    //   989: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   992: invokevirtual 249	com/weiyun/sdk/job/DownloadJobContext:getFileName	()Ljava/lang/String;
    //   995: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc_w 289
    //   1001: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 244	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1010: iload 5
    //   1012: istore_1
    //   1013: aload 12
    //   1015: astore 16
    //   1017: iload 6
    //   1019: istore_2
    //   1020: aload 12
    //   1022: astore 13
    //   1024: aload 15
    //   1026: astore 14
    //   1028: aload 12
    //   1030: astore 18
    //   1032: aload 12
    //   1034: astore 17
    //   1036: aload_0
    //   1037: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1040: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1043: lconst_0
    //   1044: lcmp
    //   1045: ifle +335 -> 1380
    //   1048: iload 5
    //   1050: istore_1
    //   1051: aload 12
    //   1053: astore 16
    //   1055: iload 6
    //   1057: istore_2
    //   1058: aload 12
    //   1060: astore 13
    //   1062: aload 15
    //   1064: astore 14
    //   1066: aload 12
    //   1068: astore 18
    //   1070: aload 12
    //   1072: astore 17
    //   1074: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1077: dup
    //   1078: sipush -29005
    //   1081: aconst_null
    //   1082: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1085: astore 15
    //   1087: iconst_0
    //   1088: ifeq +11 -> 1099
    //   1091: new 196	java/lang/NullPointerException
    //   1094: dup
    //   1095: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   1098: athrow
    //   1099: aload 15
    //   1101: astore 13
    //   1103: aload 12
    //   1105: ifnull -836 -> 269
    //   1108: aload 12
    //   1110: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1113: aload 15
    //   1115: areturn
    //   1116: astore 12
    //   1118: ldc 10
    //   1120: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1123: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1126: aload 12
    //   1128: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1131: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1134: dup
    //   1135: sipush -30017
    //   1138: aload 12
    //   1140: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1143: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1146: areturn
    //   1147: astore 13
    //   1149: iload 5
    //   1151: istore_1
    //   1152: aload 12
    //   1154: astore 16
    //   1156: iload 6
    //   1158: istore_2
    //   1159: aload 12
    //   1161: astore 13
    //   1163: aload 15
    //   1165: astore 14
    //   1167: aload 12
    //   1169: astore 18
    //   1171: aload 12
    //   1173: astore 17
    //   1175: ldc 10
    //   1177: new 231	java/lang/StringBuilder
    //   1180: dup
    //   1181: ldc_w 291
    //   1184: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1187: aload 22
    //   1189: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokestatic 293	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: lload 10
    //   1200: lstore 8
    //   1202: goto -259 -> 943
    //   1205: astore 13
    //   1207: aload 19
    //   1209: astore 15
    //   1211: aload 16
    //   1213: astore 12
    //   1215: aload 13
    //   1217: astore 16
    //   1219: aload 12
    //   1221: astore 13
    //   1223: aload 15
    //   1225: astore 14
    //   1227: ldc 10
    //   1229: new 231	java/lang/StringBuilder
    //   1232: dup
    //   1233: ldc 246
    //   1235: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1238: aload_0
    //   1239: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1242: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1245: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: aload 16
    //   1253: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1256: aload 12
    //   1258: astore 13
    //   1260: aload 15
    //   1262: astore 14
    //   1264: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1267: dup
    //   1268: aload 16
    //   1270: invokestatic 302	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1273: aload 16
    //   1275: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1278: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1281: astore 16
    //   1283: aload 12
    //   1285: astore 13
    //   1287: aload 15
    //   1289: astore 14
    //   1291: aload 16
    //   1293: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1296: sipush -30002
    //   1299: if_icmpne +473 -> 1772
    //   1302: iload_1
    //   1303: ifne +469 -> 1772
    //   1306: aload 12
    //   1308: astore 13
    //   1310: aload 15
    //   1312: astore 14
    //   1314: aload 16
    //   1316: sipush -30028
    //   1319: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1322: aload 15
    //   1324: ifnull +8 -> 1332
    //   1327: aload 15
    //   1329: invokevirtual 307	java/io/InputStream:close	()V
    //   1332: aload 16
    //   1334: astore 13
    //   1336: aload 12
    //   1338: ifnull -1069 -> 269
    //   1341: aload 12
    //   1343: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1346: aload 16
    //   1348: areturn
    //   1349: astore 12
    //   1351: ldc 10
    //   1353: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1356: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1359: aload 12
    //   1361: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1364: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1367: dup
    //   1368: sipush -30017
    //   1371: aload 12
    //   1373: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1376: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1379: areturn
    //   1380: iload 5
    //   1382: istore_1
    //   1383: aload 12
    //   1385: astore 16
    //   1387: iload 6
    //   1389: istore_2
    //   1390: aload 12
    //   1392: astore 13
    //   1394: aload 15
    //   1396: astore 14
    //   1398: aload 12
    //   1400: astore 18
    //   1402: aload 12
    //   1404: astore 17
    //   1406: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1409: dup
    //   1410: sipush -29001
    //   1413: aconst_null
    //   1414: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1417: astore 15
    //   1419: iconst_0
    //   1420: ifeq +11 -> 1431
    //   1423: new 196	java/lang/NullPointerException
    //   1426: dup
    //   1427: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   1430: athrow
    //   1431: aload 15
    //   1433: astore 13
    //   1435: aload 12
    //   1437: ifnull -1168 -> 269
    //   1440: aload 12
    //   1442: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1445: aload 15
    //   1447: areturn
    //   1448: astore 12
    //   1450: ldc 10
    //   1452: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1455: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1458: aload 12
    //   1460: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1463: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1466: dup
    //   1467: sipush -30017
    //   1470: aload 12
    //   1472: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1475: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1478: areturn
    //   1479: lload 8
    //   1481: lconst_0
    //   1482: lcmp
    //   1483: ifle +46 -> 1529
    //   1486: iload 5
    //   1488: istore_1
    //   1489: aload 12
    //   1491: astore 16
    //   1493: iload 6
    //   1495: istore_2
    //   1496: aload 12
    //   1498: astore 13
    //   1500: aload 15
    //   1502: astore 14
    //   1504: aload 12
    //   1506: astore 18
    //   1508: aload 12
    //   1510: astore 17
    //   1512: aload_0
    //   1513: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1516: aload_0
    //   1517: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1520: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1523: lload 8
    //   1525: ladd
    //   1526: invokevirtual 310	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1529: iload 5
    //   1531: istore_1
    //   1532: aload 12
    //   1534: astore 16
    //   1536: iload 6
    //   1538: istore_2
    //   1539: aload 12
    //   1541: astore 13
    //   1543: aload 15
    //   1545: astore 14
    //   1547: aload 12
    //   1549: astore 18
    //   1551: aload 12
    //   1553: astore 17
    //   1555: aload_0
    //   1556: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1559: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1562: lstore 10
    //   1564: iload 5
    //   1566: istore_1
    //   1567: aload 12
    //   1569: astore 16
    //   1571: iload 6
    //   1573: istore_2
    //   1574: aload 12
    //   1576: astore 13
    //   1578: aload 15
    //   1580: astore 14
    //   1582: aload 12
    //   1584: astore 18
    //   1586: aload 12
    //   1588: astore 17
    //   1590: new 312	java/io/BufferedInputStream
    //   1593: dup
    //   1594: aload 12
    //   1596: invokevirtual 316	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1599: invokespecial 319	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1602: astore 15
    //   1604: aload_0
    //   1605: aload 15
    //   1607: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   1610: istore_1
    //   1611: iload_1
    //   1612: sipush -10002
    //   1615: if_icmpne +92 -> 1707
    //   1618: aload_0
    //   1619: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1622: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1625: lload 10
    //   1627: lsub
    //   1628: lload 8
    //   1630: lcmp
    //   1631: ifne +76 -> 1707
    //   1634: ldc 10
    //   1636: ldc_w 325
    //   1639: invokestatic 161	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1642: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1645: dup
    //   1646: iconst_0
    //   1647: aconst_null
    //   1648: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1651: astore 13
    //   1653: aload 15
    //   1655: ifnull +8 -> 1663
    //   1658: aload 15
    //   1660: invokevirtual 307	java/io/InputStream:close	()V
    //   1663: aload 12
    //   1665: ifnull +8 -> 1673
    //   1668: aload 12
    //   1670: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1673: aload 13
    //   1675: areturn
    //   1676: astore 12
    //   1678: ldc 10
    //   1680: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1683: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1686: aload 12
    //   1688: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1691: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1694: dup
    //   1695: sipush -30017
    //   1698: aload 12
    //   1700: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1703: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1706: areturn
    //   1707: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1710: dup
    //   1711: iload_1
    //   1712: aconst_null
    //   1713: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1716: astore 13
    //   1718: aload 15
    //   1720: ifnull +8 -> 1728
    //   1723: aload 15
    //   1725: invokevirtual 307	java/io/InputStream:close	()V
    //   1728: aload 12
    //   1730: ifnull +8 -> 1738
    //   1733: aload 12
    //   1735: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1738: aload 13
    //   1740: areturn
    //   1741: astore 12
    //   1743: ldc 10
    //   1745: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1748: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1751: aload 12
    //   1753: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1756: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1759: dup
    //   1760: sipush -30017
    //   1763: aload 12
    //   1765: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1768: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1771: areturn
    //   1772: aload 12
    //   1774: astore 13
    //   1776: aload 15
    //   1778: astore 14
    //   1780: aload 16
    //   1782: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1785: sipush -30002
    //   1788: if_icmpne -466 -> 1322
    //   1791: iload_2
    //   1792: ifne -470 -> 1322
    //   1795: aload 12
    //   1797: astore 13
    //   1799: aload 15
    //   1801: astore 14
    //   1803: aload 16
    //   1805: sipush -30029
    //   1808: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1811: goto -489 -> 1322
    //   1814: astore 12
    //   1816: aload 14
    //   1818: ifnull +8 -> 1826
    //   1821: aload 14
    //   1823: invokevirtual 307	java/io/InputStream:close	()V
    //   1826: aload 13
    //   1828: ifnull +8 -> 1836
    //   1831: aload 13
    //   1833: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1836: aload 12
    //   1838: athrow
    //   1839: astore 16
    //   1841: aload 21
    //   1843: astore 15
    //   1845: aload 18
    //   1847: astore 12
    //   1849: aload 12
    //   1851: astore 13
    //   1853: aload 15
    //   1855: astore 14
    //   1857: ldc 10
    //   1859: new 231	java/lang/StringBuilder
    //   1862: dup
    //   1863: ldc 246
    //   1865: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1868: aload_0
    //   1869: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1872: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1875: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1881: aload 16
    //   1883: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1886: aload 12
    //   1888: astore 13
    //   1890: aload 15
    //   1892: astore 14
    //   1894: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1897: dup
    //   1898: sipush -10002
    //   1901: aload 16
    //   1903: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1906: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1909: astore 16
    //   1911: aload 15
    //   1913: ifnull +8 -> 1921
    //   1916: aload 15
    //   1918: invokevirtual 307	java/io/InputStream:close	()V
    //   1921: aload 16
    //   1923: astore 13
    //   1925: aload 12
    //   1927: ifnull -1658 -> 269
    //   1930: aload 12
    //   1932: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1935: aload 16
    //   1937: areturn
    //   1938: astore 12
    //   1940: ldc 10
    //   1942: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1945: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1948: aload 12
    //   1950: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1953: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1956: dup
    //   1957: sipush -30017
    //   1960: aload 12
    //   1962: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1965: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1968: areturn
    //   1969: astore 16
    //   1971: aload 20
    //   1973: astore 15
    //   1975: aload 17
    //   1977: astore 12
    //   1979: aload 12
    //   1981: astore 13
    //   1983: aload 15
    //   1985: astore 14
    //   1987: ldc 10
    //   1989: new 231	java/lang/StringBuilder
    //   1992: dup
    //   1993: ldc 246
    //   1995: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1998: aload_0
    //   1999: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2002: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2005: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2011: aload 16
    //   2013: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2016: aload 12
    //   2018: astore 13
    //   2020: aload 15
    //   2022: astore 14
    //   2024: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2027: dup
    //   2028: sipush -10014
    //   2031: aload 16
    //   2033: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2036: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2039: astore 16
    //   2041: aload 15
    //   2043: ifnull +8 -> 2051
    //   2046: aload 15
    //   2048: invokevirtual 307	java/io/InputStream:close	()V
    //   2051: aload 16
    //   2053: astore 13
    //   2055: aload 12
    //   2057: ifnull -1788 -> 269
    //   2060: aload 12
    //   2062: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   2065: aload 16
    //   2067: areturn
    //   2068: astore 12
    //   2070: ldc 10
    //   2072: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2075: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2078: aload 12
    //   2080: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2083: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2086: dup
    //   2087: sipush -30017
    //   2090: aload 12
    //   2092: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2095: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2098: areturn
    //   2099: astore 12
    //   2101: ldc 10
    //   2103: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2106: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2109: aload 12
    //   2111: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2114: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2117: dup
    //   2118: sipush -30017
    //   2121: aload 12
    //   2123: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2126: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2129: areturn
    //   2130: astore 16
    //   2132: aload 15
    //   2134: astore 14
    //   2136: aload 12
    //   2138: astore 13
    //   2140: aload 16
    //   2142: astore 12
    //   2144: goto -328 -> 1816
    //   2147: astore 16
    //   2149: goto -170 -> 1979
    //   2152: astore 16
    //   2154: goto -305 -> 1849
    //   2157: astore 16
    //   2159: iload_3
    //   2160: istore_1
    //   2161: iload 4
    //   2163: istore_2
    //   2164: goto -945 -> 1219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2167	0	this	BaseDownloadTransfer
    //   30	2131	1	i	int
    //   37	2127	2	j	int
    //   25	2135	3	k	int
    //   27	2135	4	m	int
    //   336	1229	5	n	int
    //   375	1197	6	i1	int
    //   369	331	7	i2	int
    //   903	726	8	l1	long
    //   863	763	10	l2	long
    //   4	257	12	localHttpURLConnection	HttpURLConnection
    //   272	224	12	localIOException1	IOException
    //   503	228	12	localIOException2	IOException
    //   738	371	12	localIOException3	IOException
    //   1116	56	12	localIOException4	IOException
    //   1213	129	12	localObject1	Object
    //   1349	92	12	localIOException5	IOException
    //   1448	221	12	localIOException6	IOException
    //   1676	58	12	localIOException7	IOException
    //   1741	55	12	localIOException8	IOException
    //   1814	23	12	localObject2	Object
    //   1847	84	12	localObject3	Object
    //   1938	23	12	localIOException9	IOException
    //   1977	84	12	localObject4	Object
    //   2068	23	12	localIOException10	IOException
    //   2099	38	12	localIOException11	IOException
    //   2142	1	12	localObject5	Object
    //   40	449	13	localObject6	Object
    //   534	1	13	localNumberFormatException1	java.lang.NumberFormatException
    //   548	554	13	localObject7	Object
    //   1147	1	13	localNumberFormatException2	java.lang.NumberFormatException
    //   1161	1	13	localIOException12	IOException
    //   1205	11	13	localIOException13	IOException
    //   1221	918	13	localObject8	Object
    //   44	2091	14	localObject9	Object
    //   13	2120	15	localObject10	Object
    //   33	1771	16	localObject11	Object
    //   1839	63	16	localInterruptedException1	InterruptedException
    //   1909	27	16	localResult1	Transfer.Result
    //   1969	63	16	localException1	java.lang.Exception
    //   2039	27	16	localResult2	Transfer.Result
    //   2130	11	16	localObject12	Object
    //   2147	1	16	localException2	java.lang.Exception
    //   2152	1	16	localInterruptedException2	InterruptedException
    //   2157	1	16	localIOException14	IOException
    //   52	1924	17	localObject13	Object
    //   48	1798	18	localObject14	Object
    //   22	1186	19	localObject15	Object
    //   19	1953	20	localObject16	Object
    //   16	1826	21	localObject17	Object
    //   10	1178	22	localObject18	Object
    //   1	573	23	str	String
    //   7	75	24	localObject19	Object
    //   58	764	25	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   243	251	272	java/io/IOException
    //   260	265	272	java/io/IOException
    //   478	486	503	java/io/IOException
    //   495	500	503	java/io/IOException
    //   459	474	534	java/lang/NumberFormatException
    //   713	721	738	java/io/IOException
    //   730	735	738	java/io/IOException
    //   1091	1099	1116	java/io/IOException
    //   1108	1113	1116	java/io/IOException
    //   936	943	1147	java/lang/NumberFormatException
    //   54	60	1205	java/io/IOException
    //   85	95	1205	java/io/IOException
    //   120	135	1205	java/io/IOException
    //   160	166	1205	java/io/IOException
    //   191	201	1205	java/io/IOException
    //   226	239	1205	java/io/IOException
    //   328	333	1205	java/io/IOException
    //   364	371	1205	java/io/IOException
    //   419	428	1205	java/io/IOException
    //   459	474	1205	java/io/IOException
    //   562	584	1205	java/io/IOException
    //   626	663	1205	java/io/IOException
    //   689	709	1205	java/io/IOException
    //   795	860	1205	java/io/IOException
    //   891	901	1205	java/io/IOException
    //   936	943	1205	java/io/IOException
    //   976	1010	1205	java/io/IOException
    //   1036	1048	1205	java/io/IOException
    //   1074	1087	1205	java/io/IOException
    //   1175	1198	1205	java/io/IOException
    //   1406	1419	1205	java/io/IOException
    //   1512	1529	1205	java/io/IOException
    //   1555	1564	1205	java/io/IOException
    //   1590	1604	1205	java/io/IOException
    //   1327	1332	1349	java/io/IOException
    //   1341	1346	1349	java/io/IOException
    //   1423	1431	1448	java/io/IOException
    //   1440	1445	1448	java/io/IOException
    //   1658	1663	1676	java/io/IOException
    //   1668	1673	1676	java/io/IOException
    //   1723	1728	1741	java/io/IOException
    //   1733	1738	1741	java/io/IOException
    //   54	60	1814	finally
    //   85	95	1814	finally
    //   120	135	1814	finally
    //   160	166	1814	finally
    //   191	201	1814	finally
    //   226	239	1814	finally
    //   328	333	1814	finally
    //   364	371	1814	finally
    //   419	428	1814	finally
    //   459	474	1814	finally
    //   562	584	1814	finally
    //   626	663	1814	finally
    //   689	709	1814	finally
    //   795	860	1814	finally
    //   891	901	1814	finally
    //   936	943	1814	finally
    //   976	1010	1814	finally
    //   1036	1048	1814	finally
    //   1074	1087	1814	finally
    //   1175	1198	1814	finally
    //   1227	1256	1814	finally
    //   1264	1283	1814	finally
    //   1291	1302	1814	finally
    //   1314	1322	1814	finally
    //   1406	1419	1814	finally
    //   1512	1529	1814	finally
    //   1555	1564	1814	finally
    //   1590	1604	1814	finally
    //   1780	1791	1814	finally
    //   1803	1811	1814	finally
    //   1857	1886	1814	finally
    //   1894	1911	1814	finally
    //   1987	2016	1814	finally
    //   2024	2041	1814	finally
    //   54	60	1839	java/lang/InterruptedException
    //   85	95	1839	java/lang/InterruptedException
    //   120	135	1839	java/lang/InterruptedException
    //   160	166	1839	java/lang/InterruptedException
    //   191	201	1839	java/lang/InterruptedException
    //   226	239	1839	java/lang/InterruptedException
    //   328	333	1839	java/lang/InterruptedException
    //   364	371	1839	java/lang/InterruptedException
    //   419	428	1839	java/lang/InterruptedException
    //   459	474	1839	java/lang/InterruptedException
    //   562	584	1839	java/lang/InterruptedException
    //   626	663	1839	java/lang/InterruptedException
    //   689	709	1839	java/lang/InterruptedException
    //   795	860	1839	java/lang/InterruptedException
    //   891	901	1839	java/lang/InterruptedException
    //   936	943	1839	java/lang/InterruptedException
    //   976	1010	1839	java/lang/InterruptedException
    //   1036	1048	1839	java/lang/InterruptedException
    //   1074	1087	1839	java/lang/InterruptedException
    //   1175	1198	1839	java/lang/InterruptedException
    //   1406	1419	1839	java/lang/InterruptedException
    //   1512	1529	1839	java/lang/InterruptedException
    //   1555	1564	1839	java/lang/InterruptedException
    //   1590	1604	1839	java/lang/InterruptedException
    //   1916	1921	1938	java/io/IOException
    //   1930	1935	1938	java/io/IOException
    //   54	60	1969	java/lang/Exception
    //   85	95	1969	java/lang/Exception
    //   120	135	1969	java/lang/Exception
    //   160	166	1969	java/lang/Exception
    //   191	201	1969	java/lang/Exception
    //   226	239	1969	java/lang/Exception
    //   328	333	1969	java/lang/Exception
    //   364	371	1969	java/lang/Exception
    //   419	428	1969	java/lang/Exception
    //   459	474	1969	java/lang/Exception
    //   562	584	1969	java/lang/Exception
    //   626	663	1969	java/lang/Exception
    //   689	709	1969	java/lang/Exception
    //   795	860	1969	java/lang/Exception
    //   891	901	1969	java/lang/Exception
    //   936	943	1969	java/lang/Exception
    //   976	1010	1969	java/lang/Exception
    //   1036	1048	1969	java/lang/Exception
    //   1074	1087	1969	java/lang/Exception
    //   1175	1198	1969	java/lang/Exception
    //   1406	1419	1969	java/lang/Exception
    //   1512	1529	1969	java/lang/Exception
    //   1555	1564	1969	java/lang/Exception
    //   1590	1604	1969	java/lang/Exception
    //   2046	2051	2068	java/io/IOException
    //   2060	2065	2068	java/io/IOException
    //   1821	1826	2099	java/io/IOException
    //   1831	1836	2099	java/io/IOException
    //   1604	1611	2130	finally
    //   1618	1653	2130	finally
    //   1707	1718	2130	finally
    //   1604	1611	2147	java/lang/Exception
    //   1618	1653	2147	java/lang/Exception
    //   1707	1718	2147	java/lang/Exception
    //   1604	1611	2152	java/lang/InterruptedException
    //   1618	1653	2152	java/lang/InterruptedException
    //   1707	1718	2152	java/lang/InterruptedException
    //   1604	1611	2157	java/io/IOException
    //   1618	1653	2157	java/io/IOException
    //   1707	1718	2157	java/io/IOException
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