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
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 23
    //   6: aconst_null
    //   7: astore 22
    //   9: aconst_null
    //   10: astore 24
    //   12: aconst_null
    //   13: astore 15
    //   15: aconst_null
    //   16: astore 21
    //   18: aconst_null
    //   19: astore 19
    //   21: aconst_null
    //   22: astore 20
    //   24: iconst_0
    //   25: istore_3
    //   26: iconst_0
    //   27: istore 4
    //   29: iload_3
    //   30: istore_1
    //   31: aload 24
    //   33: astore 18
    //   35: iload 4
    //   37: istore_2
    //   38: aload 12
    //   40: astore 13
    //   42: aload 15
    //   44: astore 14
    //   46: aload 23
    //   48: astore 17
    //   50: aload 22
    //   52: astore 16
    //   54: aload_0
    //   55: invokevirtual 173	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:createUrl	()Ljava/net/URL;
    //   58: astore 25
    //   60: iload_3
    //   61: istore_1
    //   62: aload 24
    //   64: astore 18
    //   66: iload 4
    //   68: istore_2
    //   69: aload 12
    //   71: astore 13
    //   73: aload 15
    //   75: astore 14
    //   77: aload 23
    //   79: astore 17
    //   81: aload 22
    //   83: astore 16
    //   85: aload 25
    //   87: invokevirtual 177	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 179	java/net/HttpURLConnection
    //   93: astore 12
    //   95: iload_3
    //   96: istore_1
    //   97: aload 12
    //   99: astore 18
    //   101: iload 4
    //   103: istore_2
    //   104: aload 12
    //   106: astore 13
    //   108: aload 15
    //   110: astore 14
    //   112: aload 12
    //   114: astore 17
    //   116: aload 12
    //   118: astore 16
    //   120: aload_0
    //   121: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   124: aload 12
    //   126: invokevirtual 182	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   129: invokevirtual 183	java/net/URL:getHost	()Ljava/lang/String;
    //   132: invokevirtual 187	com/weiyun/sdk/job/DownloadJobContext:setServerip	(Ljava/lang/String;)V
    //   135: iload_3
    //   136: istore_1
    //   137: aload 12
    //   139: astore 18
    //   141: iload 4
    //   143: istore_2
    //   144: aload 12
    //   146: astore 13
    //   148: aload 15
    //   150: astore 14
    //   152: aload 12
    //   154: astore 17
    //   156: aload 12
    //   158: astore 16
    //   160: aload_0
    //   161: aload 12
    //   163: invokevirtual 191	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:setHttpHeader	(Ljava/net/HttpURLConnection;)V
    //   166: iload_3
    //   167: istore_1
    //   168: aload 12
    //   170: astore 18
    //   172: iload 4
    //   174: istore_2
    //   175: aload 12
    //   177: astore 13
    //   179: aload 15
    //   181: astore 14
    //   183: aload 12
    //   185: astore 17
    //   187: aload 12
    //   189: astore 16
    //   191: aload_0
    //   192: getfield 36	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mJob	Lcom/weiyun/sdk/job/BaseDownloadJob;
    //   195: invokevirtual 194	com/weiyun/sdk/job/BaseDownloadJob:isAlive	()Z
    //   198: ifne +105 -> 303
    //   201: iload_3
    //   202: istore_1
    //   203: aload 12
    //   205: astore 18
    //   207: iload 4
    //   209: istore_2
    //   210: aload 12
    //   212: astore 13
    //   214: aload 15
    //   216: astore 14
    //   218: aload 12
    //   220: astore 17
    //   222: aload 12
    //   224: astore 16
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
    //   307: astore 18
    //   309: iload 4
    //   311: istore_2
    //   312: aload 12
    //   314: astore 13
    //   316: aload 15
    //   318: astore 14
    //   320: aload 12
    //   322: astore 17
    //   324: aload 12
    //   326: astore 16
    //   328: aload 12
    //   330: invokevirtual 214	java/net/HttpURLConnection:connect	()V
    //   333: iconst_1
    //   334: istore_3
    //   335: iconst_1
    //   336: istore 5
    //   338: iload 5
    //   340: istore_1
    //   341: aload 12
    //   343: astore 18
    //   345: iload 4
    //   347: istore_2
    //   348: aload 12
    //   350: astore 13
    //   352: aload 15
    //   354: astore 14
    //   356: aload 12
    //   358: astore 17
    //   360: aload 12
    //   362: astore 16
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
    //   398: astore 18
    //   400: iload 6
    //   402: istore_2
    //   403: aload 12
    //   405: astore 13
    //   407: aload 15
    //   409: astore 14
    //   411: aload 12
    //   413: astore 17
    //   415: aload 12
    //   417: astore 16
    //   419: aload 12
    //   421: ldc 219
    //   423: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 23
    //   428: aload 23
    //   430: ifnull +154 -> 584
    //   433: iload 5
    //   435: istore_1
    //   436: aload 12
    //   438: astore 18
    //   440: iload 6
    //   442: istore_2
    //   443: aload 12
    //   445: astore 13
    //   447: aload 15
    //   449: astore 14
    //   451: aload 12
    //   453: astore 17
    //   455: aload 12
    //   457: astore 16
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
    //   541: astore 18
    //   543: iload 6
    //   545: istore_2
    //   546: aload 12
    //   548: astore 13
    //   550: aload 15
    //   552: astore 14
    //   554: aload 12
    //   556: astore 17
    //   558: aload 12
    //   560: astore 16
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
    //   605: astore 18
    //   607: iload 6
    //   609: istore_2
    //   610: aload 12
    //   612: astore 13
    //   614: aload 15
    //   616: astore 14
    //   618: aload 12
    //   620: astore 17
    //   622: aload 12
    //   624: astore 16
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
    //   668: astore 18
    //   670: iload 6
    //   672: istore_2
    //   673: aload 12
    //   675: astore 13
    //   677: aload 15
    //   679: astore 14
    //   681: aload 12
    //   683: astore 17
    //   685: aload 12
    //   687: astore 16
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
    //   774: astore 18
    //   776: iload 6
    //   778: istore_2
    //   779: aload 12
    //   781: astore 13
    //   783: aload 15
    //   785: astore 14
    //   787: aload 12
    //   789: astore 17
    //   791: aload 12
    //   793: astore 16
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
    //   870: astore 18
    //   872: iload 6
    //   874: istore_2
    //   875: aload 12
    //   877: astore 13
    //   879: aload 15
    //   881: astore 14
    //   883: aload 12
    //   885: astore 17
    //   887: aload 12
    //   889: astore 16
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
    //   915: astore 18
    //   917: iload 6
    //   919: istore_2
    //   920: aload 12
    //   922: astore 13
    //   924: aload 15
    //   926: astore 14
    //   928: aload 12
    //   930: astore 17
    //   932: aload 12
    //   934: astore 16
    //   936: aload 22
    //   938: invokestatic 285	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   941: lstore 8
    //   943: lload 8
    //   945: lconst_0
    //   946: lcmp
    //   947: ifne +528 -> 1475
    //   950: iload 5
    //   952: istore_1
    //   953: aload 12
    //   955: astore 18
    //   957: iload 6
    //   959: istore_2
    //   960: aload 12
    //   962: astore 13
    //   964: aload 15
    //   966: astore 14
    //   968: aload 12
    //   970: astore 17
    //   972: aload 12
    //   974: astore 16
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
    //   1015: astore 18
    //   1017: iload 6
    //   1019: istore_2
    //   1020: aload 12
    //   1022: astore 13
    //   1024: aload 15
    //   1026: astore 14
    //   1028: aload 12
    //   1030: astore 17
    //   1032: aload 12
    //   1034: astore 16
    //   1036: aload_0
    //   1037: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1040: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1043: lconst_0
    //   1044: lcmp
    //   1045: ifle +331 -> 1376
    //   1048: iload 5
    //   1050: istore_1
    //   1051: aload 12
    //   1053: astore 18
    //   1055: iload 6
    //   1057: istore_2
    //   1058: aload 12
    //   1060: astore 13
    //   1062: aload 15
    //   1064: astore 14
    //   1066: aload 12
    //   1068: astore 17
    //   1070: aload 12
    //   1072: astore 16
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
    //   1154: astore 18
    //   1156: iload 6
    //   1158: istore_2
    //   1159: aload 12
    //   1161: astore 13
    //   1163: aload 15
    //   1165: astore 14
    //   1167: aload 12
    //   1169: astore 17
    //   1171: aload 12
    //   1173: astore 16
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
    //   1205: astore 16
    //   1207: aload 20
    //   1209: astore 15
    //   1211: aload 18
    //   1213: astore 12
    //   1215: aload 12
    //   1217: astore 13
    //   1219: aload 15
    //   1221: astore 14
    //   1223: ldc 10
    //   1225: new 231	java/lang/StringBuilder
    //   1228: dup
    //   1229: ldc 246
    //   1231: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1234: aload_0
    //   1235: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1238: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   1241: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: aload 16
    //   1249: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1252: aload 12
    //   1254: astore 13
    //   1256: aload 15
    //   1258: astore 14
    //   1260: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1263: dup
    //   1264: aload 16
    //   1266: invokestatic 302	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   1269: aload 16
    //   1271: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1274: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1277: astore 16
    //   1279: aload 12
    //   1281: astore 13
    //   1283: aload 15
    //   1285: astore 14
    //   1287: aload 16
    //   1289: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1292: sipush -30002
    //   1295: if_icmpne +473 -> 1768
    //   1298: iload_1
    //   1299: ifne +469 -> 1768
    //   1302: aload 12
    //   1304: astore 13
    //   1306: aload 15
    //   1308: astore 14
    //   1310: aload 16
    //   1312: sipush -30028
    //   1315: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1318: aload 15
    //   1320: ifnull +8 -> 1328
    //   1323: aload 15
    //   1325: invokevirtual 307	java/io/InputStream:close	()V
    //   1328: aload 16
    //   1330: astore 13
    //   1332: aload 12
    //   1334: ifnull -1065 -> 269
    //   1337: aload 12
    //   1339: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1342: aload 16
    //   1344: areturn
    //   1345: astore 12
    //   1347: ldc 10
    //   1349: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1352: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1355: aload 12
    //   1357: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1360: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1363: dup
    //   1364: sipush -30017
    //   1367: aload 12
    //   1369: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1372: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1375: areturn
    //   1376: iload 5
    //   1378: istore_1
    //   1379: aload 12
    //   1381: astore 18
    //   1383: iload 6
    //   1385: istore_2
    //   1386: aload 12
    //   1388: astore 13
    //   1390: aload 15
    //   1392: astore 14
    //   1394: aload 12
    //   1396: astore 17
    //   1398: aload 12
    //   1400: astore 16
    //   1402: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1405: dup
    //   1406: sipush -29001
    //   1409: aconst_null
    //   1410: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1413: astore 15
    //   1415: iconst_0
    //   1416: ifeq +11 -> 1427
    //   1419: new 196	java/lang/NullPointerException
    //   1422: dup
    //   1423: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   1426: athrow
    //   1427: aload 15
    //   1429: astore 13
    //   1431: aload 12
    //   1433: ifnull -1164 -> 269
    //   1436: aload 12
    //   1438: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1441: aload 15
    //   1443: areturn
    //   1444: astore 12
    //   1446: ldc 10
    //   1448: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1451: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1454: aload 12
    //   1456: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1459: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1462: dup
    //   1463: sipush -30017
    //   1466: aload 12
    //   1468: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1471: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1474: areturn
    //   1475: lload 8
    //   1477: lconst_0
    //   1478: lcmp
    //   1479: ifle +46 -> 1525
    //   1482: iload 5
    //   1484: istore_1
    //   1485: aload 12
    //   1487: astore 18
    //   1489: iload 6
    //   1491: istore_2
    //   1492: aload 12
    //   1494: astore 13
    //   1496: aload 15
    //   1498: astore 14
    //   1500: aload 12
    //   1502: astore 17
    //   1504: aload 12
    //   1506: astore 16
    //   1508: aload_0
    //   1509: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1512: aload_0
    //   1513: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1516: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1519: lload 8
    //   1521: ladd
    //   1522: invokevirtual 310	com/weiyun/sdk/job/DownloadJobContext:setTotalSize	(J)V
    //   1525: iload 5
    //   1527: istore_1
    //   1528: aload 12
    //   1530: astore 18
    //   1532: iload 6
    //   1534: istore_2
    //   1535: aload 12
    //   1537: astore 13
    //   1539: aload 15
    //   1541: astore 14
    //   1543: aload 12
    //   1545: astore 17
    //   1547: aload 12
    //   1549: astore 16
    //   1551: aload_0
    //   1552: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1555: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1558: lstore 10
    //   1560: iload 5
    //   1562: istore_1
    //   1563: aload 12
    //   1565: astore 18
    //   1567: iload 6
    //   1569: istore_2
    //   1570: aload 12
    //   1572: astore 13
    //   1574: aload 15
    //   1576: astore 14
    //   1578: aload 12
    //   1580: astore 17
    //   1582: aload 12
    //   1584: astore 16
    //   1586: new 312	java/io/BufferedInputStream
    //   1589: dup
    //   1590: aload 12
    //   1592: invokevirtual 316	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1595: invokespecial 319	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1598: astore 15
    //   1600: aload_0
    //   1601: aload 15
    //   1603: invokevirtual 323	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:readHttpContent	(Ljava/io/InputStream;)I
    //   1606: istore_1
    //   1607: iload_1
    //   1608: sipush -10002
    //   1611: if_icmpne +92 -> 1703
    //   1614: aload_0
    //   1615: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   1618: invokevirtual 57	com/weiyun/sdk/job/DownloadJobContext:getCurSize	()J
    //   1621: lload 10
    //   1623: lsub
    //   1624: lload 8
    //   1626: lcmp
    //   1627: ifne +76 -> 1703
    //   1630: ldc 10
    //   1632: ldc_w 325
    //   1635: invokestatic 161	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1638: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1641: dup
    //   1642: iconst_0
    //   1643: aconst_null
    //   1644: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1647: astore 13
    //   1649: aload 15
    //   1651: ifnull +8 -> 1659
    //   1654: aload 15
    //   1656: invokevirtual 307	java/io/InputStream:close	()V
    //   1659: aload 12
    //   1661: ifnull +8 -> 1669
    //   1664: aload 12
    //   1666: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1669: aload 13
    //   1671: areturn
    //   1672: astore 12
    //   1674: ldc 10
    //   1676: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1679: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1682: aload 12
    //   1684: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1687: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1690: dup
    //   1691: sipush -30017
    //   1694: aload 12
    //   1696: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1699: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1702: areturn
    //   1703: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1706: dup
    //   1707: iload_1
    //   1708: aconst_null
    //   1709: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1712: astore 13
    //   1714: aload 15
    //   1716: ifnull +8 -> 1724
    //   1719: aload 15
    //   1721: invokevirtual 307	java/io/InputStream:close	()V
    //   1724: aload 12
    //   1726: ifnull +8 -> 1734
    //   1729: aload 12
    //   1731: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1734: aload 13
    //   1736: areturn
    //   1737: astore 12
    //   1739: ldc 10
    //   1741: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1744: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   1747: aload 12
    //   1749: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1752: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   1755: dup
    //   1756: sipush -30017
    //   1759: aload 12
    //   1761: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1764: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   1767: areturn
    //   1768: aload 12
    //   1770: astore 13
    //   1772: aload 15
    //   1774: astore 14
    //   1776: aload 16
    //   1778: getfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1781: sipush -30002
    //   1784: if_icmpne -466 -> 1318
    //   1787: iload_2
    //   1788: ifne -470 -> 1318
    //   1791: aload 12
    //   1793: astore 13
    //   1795: aload 15
    //   1797: astore 14
    //   1799: aload 16
    //   1801: sipush -30029
    //   1804: putfield 44	com/weiyun/sdk/job/transfer/Transfer$Result:mRet	I
    //   1807: goto -489 -> 1318
    //   1810: astore 15
    //   1812: aload 13
    //   1814: astore 12
    //   1816: aload 14
    //   1818: ifnull +8 -> 1826
    //   1821: aload 14
    //   1823: invokevirtual 307	java/io/InputStream:close	()V
    //   1826: aload 12
    //   1828: ifnull +8 -> 1836
    //   1831: aload 12
    //   1833: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   1836: aload 15
    //   1838: athrow
    //   1839: astore 16
    //   1841: aload 21
    //   1843: astore 15
    //   1845: aload 17
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
    //   1969: astore 13
    //   1971: aload 19
    //   1973: astore 15
    //   1975: aload 16
    //   1977: astore 12
    //   1979: aload 13
    //   1981: astore 16
    //   1983: aload 12
    //   1985: astore 13
    //   1987: aload 15
    //   1989: astore 14
    //   1991: ldc 10
    //   1993: new 231	java/lang/StringBuilder
    //   1996: dup
    //   1997: ldc 246
    //   1999: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2002: aload_0
    //   2003: getfield 34	com/weiyun/sdk/job/transfer/BaseDownloadTransfer:mContext	Lcom/weiyun/sdk/job/DownloadJobContext;
    //   2006: invokevirtual 296	com/weiyun/sdk/job/DownloadJobContext:getDestFilePath	()Ljava/lang/String;
    //   2009: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2015: aload 16
    //   2017: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2020: aload 12
    //   2022: astore 13
    //   2024: aload 15
    //   2026: astore 14
    //   2028: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2031: dup
    //   2032: sipush -10014
    //   2035: aload 16
    //   2037: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2040: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2043: astore 16
    //   2045: aload 15
    //   2047: ifnull +8 -> 2055
    //   2050: aload 15
    //   2052: invokevirtual 307	java/io/InputStream:close	()V
    //   2055: aload 16
    //   2057: astore 13
    //   2059: aload 12
    //   2061: ifnull -1792 -> 269
    //   2064: aload 12
    //   2066: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   2069: aload 16
    //   2071: areturn
    //   2072: astore 12
    //   2074: ldc 10
    //   2076: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2079: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2082: aload 12
    //   2084: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2087: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2090: dup
    //   2091: sipush -30017
    //   2094: aload 12
    //   2096: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2099: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2102: areturn
    //   2103: astore 12
    //   2105: ldc 10
    //   2107: invokestatic 206	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2110: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   2113: aload 12
    //   2115: invokestatic 211	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2118: new 41	com/weiyun/sdk/job/transfer/Transfer$Result
    //   2121: dup
    //   2122: sipush -30017
    //   2125: aload 12
    //   2127: invokestatic 112	com/weiyun/sdk/util/Utils:getStackTraceAsString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2130: invokespecial 75	com/weiyun/sdk/job/transfer/Transfer$Result:<init>	(ILjava/lang/String;)V
    //   2133: areturn
    //   2134: astore 13
    //   2136: aload 15
    //   2138: astore 14
    //   2140: aload 13
    //   2142: astore 15
    //   2144: goto -328 -> 1816
    //   2147: astore 16
    //   2149: goto -166 -> 1983
    //   2152: astore 16
    //   2154: goto -305 -> 1849
    //   2157: astore 16
    //   2159: iload_3
    //   2160: istore_1
    //   2161: iload 4
    //   2163: istore_2
    //   2164: goto -949 -> 1215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2167	0	this	BaseDownloadTransfer
    //   30	2131	1	i	int
    //   37	2127	2	j	int
    //   25	2135	3	k	int
    //   27	2135	4	m	int
    //   336	1225	5	n	int
    //   375	1193	6	i1	int
    //   369	331	7	i2	int
    //   903	722	8	l1	long
    //   863	759	10	l2	long
    //   1	260	12	localHttpURLConnection	HttpURLConnection
    //   272	224	12	localIOException1	IOException
    //   503	228	12	localIOException2	IOException
    //   738	371	12	localIOException3	IOException
    //   1116	56	12	localIOException4	IOException
    //   1213	125	12	localObject1	Object
    //   1345	92	12	localIOException5	IOException
    //   1444	221	12	localIOException6	IOException
    //   1672	58	12	localIOException7	IOException
    //   1737	55	12	localIOException8	IOException
    //   1814	117	12	localObject2	Object
    //   1938	23	12	localIOException9	IOException
    //   1977	88	12	localObject3	Object
    //   2072	23	12	localIOException10	IOException
    //   2103	23	12	localIOException11	IOException
    //   40	449	13	localObject4	Object
    //   534	1	13	localNumberFormatException1	java.lang.NumberFormatException
    //   548	554	13	localObject5	Object
    //   1147	1	13	localNumberFormatException2	java.lang.NumberFormatException
    //   1161	763	13	localObject6	Object
    //   1969	11	13	localException1	java.lang.Exception
    //   1985	73	13	localObject7	Object
    //   2134	7	13	localObject8	Object
    //   44	2095	14	localObject9	Object
    //   13	1783	15	localObject10	Object
    //   1810	27	15	localObject11	Object
    //   1843	300	15	localObject12	Object
    //   52	1122	16	localObject13	Object
    //   1205	65	16	localIOException12	IOException
    //   1277	523	16	localObject14	Object
    //   1839	63	16	localInterruptedException1	InterruptedException
    //   1909	161	16	localObject15	Object
    //   2147	1	16	localException2	java.lang.Exception
    //   2152	1	16	localInterruptedException2	InterruptedException
    //   2157	1	16	localIOException13	IOException
    //   48	1798	17	localObject16	Object
    //   33	1533	18	localObject17	Object
    //   19	1953	19	localObject18	Object
    //   22	1186	20	localObject19	Object
    //   16	1826	21	localObject20	Object
    //   7	1181	22	localObject21	Object
    //   4	570	23	str	String
    //   10	53	24	localObject22	Object
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
    //   1402	1415	1205	java/io/IOException
    //   1508	1525	1205	java/io/IOException
    //   1551	1560	1205	java/io/IOException
    //   1586	1600	1205	java/io/IOException
    //   1323	1328	1345	java/io/IOException
    //   1337	1342	1345	java/io/IOException
    //   1419	1427	1444	java/io/IOException
    //   1436	1441	1444	java/io/IOException
    //   1654	1659	1672	java/io/IOException
    //   1664	1669	1672	java/io/IOException
    //   1719	1724	1737	java/io/IOException
    //   1729	1734	1737	java/io/IOException
    //   54	60	1810	finally
    //   85	95	1810	finally
    //   120	135	1810	finally
    //   160	166	1810	finally
    //   191	201	1810	finally
    //   226	239	1810	finally
    //   328	333	1810	finally
    //   364	371	1810	finally
    //   419	428	1810	finally
    //   459	474	1810	finally
    //   562	584	1810	finally
    //   626	663	1810	finally
    //   689	709	1810	finally
    //   795	860	1810	finally
    //   891	901	1810	finally
    //   936	943	1810	finally
    //   976	1010	1810	finally
    //   1036	1048	1810	finally
    //   1074	1087	1810	finally
    //   1175	1198	1810	finally
    //   1223	1252	1810	finally
    //   1260	1279	1810	finally
    //   1287	1298	1810	finally
    //   1310	1318	1810	finally
    //   1402	1415	1810	finally
    //   1508	1525	1810	finally
    //   1551	1560	1810	finally
    //   1586	1600	1810	finally
    //   1776	1787	1810	finally
    //   1799	1807	1810	finally
    //   1857	1886	1810	finally
    //   1894	1911	1810	finally
    //   1991	2020	1810	finally
    //   2028	2045	1810	finally
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
    //   1402	1415	1839	java/lang/InterruptedException
    //   1508	1525	1839	java/lang/InterruptedException
    //   1551	1560	1839	java/lang/InterruptedException
    //   1586	1600	1839	java/lang/InterruptedException
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
    //   1402	1415	1969	java/lang/Exception
    //   1508	1525	1969	java/lang/Exception
    //   1551	1560	1969	java/lang/Exception
    //   1586	1600	1969	java/lang/Exception
    //   2050	2055	2072	java/io/IOException
    //   2064	2069	2072	java/io/IOException
    //   1821	1826	2103	java/io/IOException
    //   1831	1836	2103	java/io/IOException
    //   1600	1607	2134	finally
    //   1614	1649	2134	finally
    //   1703	1714	2134	finally
    //   1600	1607	2147	java/lang/Exception
    //   1614	1649	2147	java/lang/Exception
    //   1703	1714	2147	java/lang/Exception
    //   1600	1607	2152	java/lang/InterruptedException
    //   1614	1649	2152	java/lang/InterruptedException
    //   1703	1714	2152	java/lang/InterruptedException
    //   1600	1607	2157	java/io/IOException
    //   1614	1649	2157	java/io/IOException
    //   1703	1714	2157	java/io/IOException
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