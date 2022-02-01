package com.weiyun.sdk.job.transfer;

import android.os.SystemClock;
import com.weiyun.sdk.Global;
import com.weiyun.sdk.context.ErrorMessages;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.api.StoragePlatomProto;
import com.weiyun.sdk.job.api.UploadTaskRequestRetryHandler;
import com.weiyun.sdk.report.WeiyunReport;
import com.weiyun.sdk.report.WeiyunReportObj;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.UtilsMisc;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class UploadTransfer
  implements Transfer
{
  private static final long FILE_SIZE_4G = 4294967296L;
  private static final String TAG = "UploadTransfer";
  protected final AddressFetcher.UploadAddress mAddress;
  protected final UploadJobContext mContext;
  protected final byte[] mFileHash;
  protected DefaultHttpClient mHttpClient = null;
  protected final BaseUploadJob mJob;
  private final Transfer.ProcessInfo mProcessInfo;
  protected int mRewardThreshold = 4;
  protected int mSliceSize = 0;
  protected int mSuccSliceTimes = 0;
  protected int mTimeoutTimes = 0;
  protected final byte[] mUkey;
  
  public UploadTransfer(AddressFetcher.UploadAddress paramUploadAddress, UploadJobContext paramUploadJobContext, BaseUploadJob paramBaseUploadJob)
  {
    this.mContext = paramUploadJobContext;
    this.mAddress = paramUploadAddress;
    this.mJob = paramBaseUploadJob;
    this.mUkey = UtilsMisc.hexStringToByteArray(this.mAddress.getUKey());
    this.mFileHash = UtilsMisc.hexStringToByteArray(this.mContext.getSha());
    this.mProcessInfo = new Transfer.ProcessInfo();
    try
    {
      this.mProcessInfo.url = createUrl().toString();
      label97:
      this.mProcessInfo.flowId = Global.generateRandomId(new Object[] { this.mProcessInfo.url, this });
      this.mProcessInfo.startTime = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadAddress)
    {
      break label97;
    }
  }
  
  private void adjustProgress(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mJob.getId());
    localStringBuilder.append(", server's offset: ");
    localStringBuilder.append(paramStoragePlatomProto.getUploadRspNextOffset());
    localStringBuilder.append(", local's offset: ");
    localStringBuilder.append(paramLong);
    com.weiyun.sdk.log.Log.v("UploadTransfer", localStringBuilder.toString());
    if (paramLong != paramStoragePlatomProto.getUploadRspNextOffset()) {
      this.mContext.setCurSize(paramStoragePlatomProto.getUploadRspNextOffset());
    }
    for (;;)
    {
      this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
      return;
      this.mContext.setCurSize(paramLong);
    }
  }
  
  private void closeFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      com.weiyun.sdk.log.Log.w("UploadTransfer", "close file failed!");
    }
  }
  
  private void closeHttpClient()
  {
    if (this.mHttpClient != null)
    {
      this.mHttpClient.getConnectionManager().shutdown();
      this.mHttpClient = null;
    }
  }
  
  private void doInnerReport(Transfer.Result paramResult, Transfer.ProcessInfo paramProcessInfo)
  {
    if (!Global.isInit()) {
      return;
    }
    WeiyunReportObj localWeiyunReportObj = new WeiyunReportObj(2);
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
    localWeiyunReportObj.file_path = this.mContext.getSrcPath();
    localWeiyunReportObj.file_md5 = this.mContext.getMd5();
    localWeiyunReportObj.file_sha = this.mContext.getSha();
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
  
  /* Error */
  private int httpPostData(StoragePlatomProto paramStoragePlatomProto, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 356	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   3: invokevirtual 360	com/weiyun/sdk/job/transfer/ByteArrayPool:createBuffer	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;
    //   6: astore 22
    //   8: new 116	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   15: astore 23
    //   17: aconst_null
    //   18: astore 19
    //   20: iconst_0
    //   21: istore 9
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   28: iconst_0
    //   29: istore 10
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore 12
    //   37: iload 12
    //   39: iconst_3
    //   40: if_icmplt +14 -> 54
    //   43: iload 10
    //   45: ifeq +1629 -> 1674
    //   48: iload 8
    //   50: iconst_3
    //   51: if_icmpge +1623 -> 1674
    //   54: aload_0
    //   55: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   58: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   61: ifne +39 -> 100
    //   64: ldc 14
    //   66: ldc_w 365
    //   69: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: sipush -10002
    //   75: istore 4
    //   77: invokestatic 356	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   80: astore_1
    //   81: iload 4
    //   83: ifne +1521 -> 1604
    //   86: iconst_1
    //   87: istore 16
    //   89: aload_1
    //   90: aload 22
    //   92: iload 16
    //   94: invokevirtual 372	com/weiyun/sdk/job/transfer/ByteArrayPool:freeBuffer	(Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;Z)V
    //   97: iload 4
    //   99: ireturn
    //   100: iload 5
    //   102: sipush 8192
    //   105: if_icmple +1562 -> 1667
    //   108: iload 12
    //   110: i2d
    //   111: dstore 6
    //   113: iload 5
    //   115: ldc2_w 373
    //   118: dload 6
    //   120: invokestatic 380	java/lang/Math:pow	(DD)D
    //   123: d2i
    //   124: idiv
    //   125: sipush 8192
    //   128: invokestatic 384	java/lang/Math:max	(II)I
    //   131: istore 11
    //   133: aload_1
    //   134: aload_0
    //   135: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   138: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   141: iload 11
    //   143: aload_3
    //   144: iconst_0
    //   145: iload 4
    //   147: invokevirtual 388	com/weiyun/sdk/job/api/StoragePlatomProto:buildUploadRequestHead	(JI[BII)I
    //   150: istore 13
    //   152: aload_0
    //   153: aload_2
    //   154: invokevirtual 392	com/weiyun/sdk/job/transfer/UploadTransfer:configHttpClient	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   157: astore 20
    //   159: aload 20
    //   161: new 394	com/weiyun/sdk/job/api/SppByteArrayEntity
    //   164: dup
    //   165: aload_3
    //   166: iconst_0
    //   167: iload 13
    //   169: iload 11
    //   171: iadd
    //   172: invokespecial 397	com/weiyun/sdk/job/api/SppByteArrayEntity:<init>	([BII)V
    //   175: invokevirtual 403	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   178: iconst_0
    //   179: istore 14
    //   181: iconst_0
    //   182: istore 13
    //   184: iconst_0
    //   185: istore 10
    //   187: aload_0
    //   188: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   191: aload 20
    //   193: invokevirtual 407	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   196: astore 20
    //   198: aload 20
    //   200: astore 19
    //   202: aload 19
    //   204: ifnonnull +70 -> 274
    //   207: aload 19
    //   209: astore 20
    //   211: aload_0
    //   212: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   215: aload 19
    //   217: ifnull +1436 -> 1653
    //   220: aload 19
    //   222: invokeinterface 415 1 0
    //   227: ifnull +1426 -> 1653
    //   230: aload 19
    //   232: invokeinterface 415 1 0
    //   237: invokeinterface 420 1 0
    //   242: iconst_0
    //   243: istore 11
    //   245: iload 9
    //   247: istore 10
    //   249: iload 11
    //   251: istore 9
    //   253: iload 12
    //   255: iconst_1
    //   256: iadd
    //   257: istore 12
    //   259: iload 9
    //   261: istore 11
    //   263: iload 10
    //   265: istore 9
    //   267: iload 11
    //   269: istore 10
    //   271: goto -234 -> 37
    //   274: aload 19
    //   276: astore 20
    //   278: aload 19
    //   280: invokeinterface 424 1 0
    //   285: invokeinterface 430 1 0
    //   290: istore 9
    //   292: iload 9
    //   294: sipush 200
    //   297: if_icmpeq +533 -> 830
    //   300: aload 19
    //   302: astore 20
    //   304: aload 23
    //   306: iconst_0
    //   307: aload 23
    //   309: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   312: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 19
    //   318: astore 20
    //   320: aload 23
    //   322: ldc_w 439
    //   325: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload 9
    //   330: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc_w 444
    //   336: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_1
    //   340: invokevirtual 447	com/weiyun/sdk/job/api/StoragePlatomProto:getUploadRspErrCode	()I
    //   343: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 19
    //   349: astore 20
    //   351: ldc 14
    //   353: aload 23
    //   355: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: iload 9
    //   363: sipush 30000
    //   366: isub
    //   367: istore 11
    //   369: aload 19
    //   371: astore 20
    //   373: aload 19
    //   375: ldc_w 449
    //   378: invokeinterface 453 2 0
    //   383: astore 21
    //   385: iload 11
    //   387: istore 9
    //   389: aload 21
    //   391: ifnull +73 -> 464
    //   394: iload 11
    //   396: istore 9
    //   398: aload 19
    //   400: astore 20
    //   402: aload 21
    //   404: arraylength
    //   405: ifle +59 -> 464
    //   408: aload 19
    //   410: astore 20
    //   412: aload 21
    //   414: iconst_0
    //   415: aaload
    //   416: invokeinterface 458 1 0
    //   421: astore 21
    //   423: aload 19
    //   425: astore 20
    //   427: ldc 14
    //   429: new 116	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 460
    //   439: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 21
    //   444: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload 19
    //   455: astore 20
    //   457: aload 21
    //   459: invokestatic 466	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   462: istore 9
    //   464: aload 19
    //   466: astore 20
    //   468: aload_0
    //   469: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   472: iload 13
    //   474: istore 11
    //   476: iload 9
    //   478: istore 10
    //   480: aload 19
    //   482: astore 21
    //   484: aload 19
    //   486: ifnull +1156 -> 1642
    //   489: iload 13
    //   491: istore 11
    //   493: iload 9
    //   495: istore 10
    //   497: aload 19
    //   499: astore 21
    //   501: aload 19
    //   503: invokeinterface 415 1 0
    //   508: ifnull +1134 -> 1642
    //   511: aload 19
    //   513: invokeinterface 415 1 0
    //   518: invokeinterface 420 1 0
    //   523: iload 9
    //   525: istore 10
    //   527: iconst_0
    //   528: istore 9
    //   530: goto -277 -> 253
    //   533: astore 21
    //   535: aload 19
    //   537: astore 20
    //   539: ldc 14
    //   541: aload 21
    //   543: invokestatic 469	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   546: iload 11
    //   548: istore 9
    //   550: goto -86 -> 464
    //   553: astore 21
    //   555: aload 19
    //   557: astore 20
    //   559: aload_0
    //   560: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   563: aload 21
    //   565: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   568: aload 19
    //   570: astore 20
    //   572: aload 21
    //   574: invokestatic 475	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   577: istore 13
    //   579: aload 19
    //   581: astore 20
    //   583: ldc 14
    //   585: new 116	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 477
    //   595: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 13
    //   600: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: aload 21
    //   608: invokestatic 481	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   611: iload 10
    //   613: istore 11
    //   615: iload 13
    //   617: istore 9
    //   619: aload 19
    //   621: astore 20
    //   623: aload 19
    //   625: ifnull +49 -> 674
    //   628: iload 10
    //   630: istore 11
    //   632: iload 13
    //   634: istore 9
    //   636: aload 19
    //   638: astore 20
    //   640: aload 19
    //   642: invokeinterface 415 1 0
    //   647: ifnull +27 -> 674
    //   650: aload 19
    //   652: invokeinterface 415 1 0
    //   657: invokeinterface 420 1 0
    //   662: aload 19
    //   664: astore 20
    //   666: iload 13
    //   668: istore 9
    //   670: iload 10
    //   672: istore 11
    //   674: aload_0
    //   675: iconst_0
    //   676: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   679: aload_0
    //   680: aload_0
    //   681: getfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   684: i2d
    //   685: ldc2_w 482
    //   688: dmul
    //   689: d2i
    //   690: putfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   693: iload 9
    //   695: sipush -30002
    //   698: if_icmpne +809 -> 1507
    //   701: aload_0
    //   702: aload_0
    //   703: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   706: iconst_1
    //   707: iadd
    //   708: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   711: iload 9
    //   713: sipush -30024
    //   716: if_icmpeq +99 -> 815
    //   719: iload 9
    //   721: sipush -30001
    //   724: if_icmpeq +91 -> 815
    //   727: iload 9
    //   729: sipush -30002
    //   732: if_icmpeq +83 -> 815
    //   735: iload 9
    //   737: sipush -30010
    //   740: if_icmpeq +75 -> 815
    //   743: iload 9
    //   745: sipush -30014
    //   748: if_icmpeq +67 -> 815
    //   751: iload 9
    //   753: sipush -30015
    //   756: if_icmpeq +59 -> 815
    //   759: iload 9
    //   761: sipush -30018
    //   764: if_icmpeq +51 -> 815
    //   767: iload 9
    //   769: sipush -30023
    //   772: if_icmpeq +43 -> 815
    //   775: iload 9
    //   777: sipush -30090
    //   780: if_icmpeq +35 -> 815
    //   783: iload 9
    //   785: sipush -30025
    //   788: if_icmpeq +27 -> 815
    //   791: iload 9
    //   793: sipush -30091
    //   796: if_icmpeq +19 -> 815
    //   799: iload 9
    //   801: istore 10
    //   803: aload 20
    //   805: astore 21
    //   807: iload 9
    //   809: sipush -30027
    //   812: if_icmpne +830 -> 1642
    //   815: aconst_null
    //   816: invokestatic 487	com/weiyun/sdk/util/NetworkUtils:hasInternet	(Landroid/content/Context;)Z
    //   819: ifne +696 -> 1515
    //   822: sipush -10003
    //   825: istore 4
    //   827: goto -750 -> 77
    //   830: aload 19
    //   832: astore 20
    //   834: new 489	java/io/BufferedInputStream
    //   837: dup
    //   838: aload 19
    //   840: invokeinterface 415 1 0
    //   845: invokeinterface 493 1 0
    //   850: invokespecial 496	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   853: aload 22
    //   855: getfield 501	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   858: invokevirtual 507	java/io/InputStream:read	([B)I
    //   861: istore 15
    //   863: iload 15
    //   865: ifgt +82 -> 947
    //   868: aload 19
    //   870: astore 20
    //   872: ldc 14
    //   874: ldc_w 509
    //   877: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: sipush -29003
    //   883: istore 9
    //   885: iload 13
    //   887: istore 11
    //   889: iload 9
    //   891: istore 10
    //   893: aload 19
    //   895: astore 21
    //   897: aload 19
    //   899: ifnull +743 -> 1642
    //   902: iload 13
    //   904: istore 11
    //   906: iload 9
    //   908: istore 10
    //   910: aload 19
    //   912: astore 21
    //   914: aload 19
    //   916: invokeinterface 415 1 0
    //   921: ifnull +721 -> 1642
    //   924: aload 19
    //   926: invokeinterface 415 1 0
    //   931: invokeinterface 420 1 0
    //   936: sipush -29003
    //   939: istore 10
    //   941: iconst_0
    //   942: istore 9
    //   944: goto -691 -> 253
    //   947: iload 9
    //   949: sipush 200
    //   952: if_icmpne +178 -> 1130
    //   955: iconst_1
    //   956: istore 16
    //   958: aload 19
    //   960: astore 20
    //   962: aload_1
    //   963: iload 16
    //   965: aload 22
    //   967: getfield 501	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   970: iload 15
    //   972: invokevirtual 513	com/weiyun/sdk/job/api/StoragePlatomProto:parseUploadRsp	(Z[BI)I
    //   975: istore 9
    //   977: iload 9
    //   979: ifne +291 -> 1270
    //   982: aload 19
    //   984: astore 20
    //   986: aload_0
    //   987: iconst_0
    //   988: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   991: aload 19
    //   993: astore 20
    //   995: aload_0
    //   996: iload 11
    //   998: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1001: iload 12
    //   1003: ifne +57 -> 1060
    //   1006: aload 19
    //   1008: astore 20
    //   1010: aload_0
    //   1011: aload_0
    //   1012: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1015: iconst_1
    //   1016: iadd
    //   1017: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1020: aload 19
    //   1022: astore 20
    //   1024: aload_0
    //   1025: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1028: aload_0
    //   1029: getfield 49	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1032: if_icmplt +28 -> 1060
    //   1035: aload 19
    //   1037: astore 20
    //   1039: aload_0
    //   1040: aload_0
    //   1041: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1044: sipush 8192
    //   1047: iadd
    //   1048: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1051: aload 19
    //   1053: astore 20
    //   1055: aload_0
    //   1056: iconst_0
    //   1057: putfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1060: aload 19
    //   1062: astore 20
    //   1064: aload_0
    //   1065: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1068: sipush 8192
    //   1071: if_icmpge +65 -> 1136
    //   1074: aload 19
    //   1076: astore 20
    //   1078: aload_0
    //   1079: sipush 8192
    //   1082: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1085: iconst_0
    //   1086: istore 5
    //   1088: iload 5
    //   1090: istore 4
    //   1092: aload 19
    //   1094: ifnull -1017 -> 77
    //   1097: iload 5
    //   1099: istore 4
    //   1101: aload 19
    //   1103: invokeinterface 415 1 0
    //   1108: ifnull -1031 -> 77
    //   1111: aload 19
    //   1113: invokeinterface 415 1 0
    //   1118: invokeinterface 420 1 0
    //   1123: iload 5
    //   1125: istore 4
    //   1127: goto -1050 -> 77
    //   1130: iconst_0
    //   1131: istore 16
    //   1133: goto -175 -> 958
    //   1136: aload 19
    //   1138: astore 20
    //   1140: aload_0
    //   1141: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1144: ldc_w 514
    //   1147: if_icmple -62 -> 1085
    //   1150: aload 19
    //   1152: astore 20
    //   1154: aload_0
    //   1155: ldc_w 514
    //   1158: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1161: goto -76 -> 1085
    //   1164: astore 21
    //   1166: iload 14
    //   1168: istore 10
    //   1170: aload 19
    //   1172: astore 20
    //   1174: ldc 14
    //   1176: aload 21
    //   1178: invokevirtual 517	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1181: aload 21
    //   1183: invokestatic 481	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1186: aload 19
    //   1188: astore 20
    //   1190: aload_0
    //   1191: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   1194: aload 21
    //   1196: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   1199: sipush -10014
    //   1202: istore 13
    //   1204: iload 10
    //   1206: istore 11
    //   1208: iload 13
    //   1210: istore 9
    //   1212: aload 19
    //   1214: astore 20
    //   1216: aload 19
    //   1218: ifnull -544 -> 674
    //   1221: iload 10
    //   1223: istore 11
    //   1225: iload 13
    //   1227: istore 9
    //   1229: aload 19
    //   1231: astore 20
    //   1233: aload 19
    //   1235: invokeinterface 415 1 0
    //   1240: ifnull -566 -> 674
    //   1243: aload 19
    //   1245: invokeinterface 415 1 0
    //   1250: invokeinterface 420 1 0
    //   1255: iload 10
    //   1257: istore 11
    //   1259: iload 13
    //   1261: istore 9
    //   1263: aload 19
    //   1265: astore 20
    //   1267: goto -593 -> 674
    //   1270: ldc_w 518
    //   1273: iload 9
    //   1275: if_icmpne +112 -> 1387
    //   1278: aload 19
    //   1280: astore 20
    //   1282: aload 23
    //   1284: iconst_0
    //   1285: aload 23
    //   1287: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   1290: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 19
    //   1296: astore 20
    //   1298: aload 23
    //   1300: ldc_w 520
    //   1303: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: iload 9
    //   1308: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: aload 19
    //   1314: astore 20
    //   1316: ldc 14
    //   1318: aload 23
    //   1320: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1323: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1326: iload 13
    //   1328: istore 11
    //   1330: iload 9
    //   1332: istore 10
    //   1334: aload 19
    //   1336: astore 21
    //   1338: aload 19
    //   1340: ifnull +302 -> 1642
    //   1343: iload 13
    //   1345: istore 11
    //   1347: iload 9
    //   1349: istore 10
    //   1351: aload 19
    //   1353: astore 21
    //   1355: aload 19
    //   1357: invokeinterface 415 1 0
    //   1362: ifnull +280 -> 1642
    //   1365: aload 19
    //   1367: invokeinterface 415 1 0
    //   1372: invokeinterface 420 1 0
    //   1377: iload 9
    //   1379: istore 10
    //   1381: iconst_0
    //   1382: istore 9
    //   1384: goto -1131 -> 253
    //   1387: aload 19
    //   1389: astore 20
    //   1391: aload 23
    //   1393: iconst_0
    //   1394: aload 23
    //   1396: invokevirtual 433	java/lang/StringBuilder:length	()I
    //   1399: invokevirtual 437	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1402: pop
    //   1403: aload 19
    //   1405: astore 20
    //   1407: aload 23
    //   1409: ldc_w 522
    //   1412: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: iload 9
    //   1417: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1420: pop
    //   1421: aload 19
    //   1423: astore 20
    //   1425: ldc 14
    //   1427: aload 23
    //   1429: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: iload 9
    //   1437: istore 4
    //   1439: aload 19
    //   1441: ifnull -1364 -> 77
    //   1444: iload 9
    //   1446: istore 4
    //   1448: aload 19
    //   1450: invokeinterface 415 1 0
    //   1455: ifnull -1378 -> 77
    //   1458: aload 19
    //   1460: invokeinterface 415 1 0
    //   1465: invokeinterface 420 1 0
    //   1470: iload 9
    //   1472: istore 4
    //   1474: goto -1397 -> 77
    //   1477: astore_1
    //   1478: aload 20
    //   1480: ifnull +25 -> 1505
    //   1483: aload 20
    //   1485: invokeinterface 415 1 0
    //   1490: ifnull +15 -> 1505
    //   1493: aload 20
    //   1495: invokeinterface 415 1 0
    //   1500: invokeinterface 420 1 0
    //   1505: aload_1
    //   1506: athrow
    //   1507: aload_0
    //   1508: iconst_0
    //   1509: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1512: goto -801 -> 711
    //   1515: iload 8
    //   1517: iconst_1
    //   1518: iadd
    //   1519: istore 8
    //   1521: ldc2_w 523
    //   1524: ldc2_w 373
    //   1527: iload 12
    //   1529: i2d
    //   1530: ldc2_w 525
    //   1533: invokestatic 380	java/lang/Math:pow	(DD)D
    //   1536: dadd
    //   1537: dmul
    //   1538: d2l
    //   1539: lstore 17
    //   1541: ldc 14
    //   1543: new 116	java/lang/StringBuilder
    //   1546: dup
    //   1547: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   1550: ldc_w 528
    //   1553: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: lload 17
    //   1558: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokestatic 531	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1567: lload 17
    //   1569: invokestatic 536	java/lang/Thread:sleep	(J)V
    //   1572: aload 20
    //   1574: astore 19
    //   1576: iload 9
    //   1578: istore 10
    //   1580: iconst_1
    //   1581: istore 9
    //   1583: goto -1330 -> 253
    //   1586: astore_1
    //   1587: ldc 14
    //   1589: aload_1
    //   1590: invokevirtual 537	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1593: aload_1
    //   1594: invokestatic 539	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1597: iload 9
    //   1599: istore 4
    //   1601: goto -1524 -> 77
    //   1604: iconst_0
    //   1605: istore 16
    //   1607: goto -1518 -> 89
    //   1610: astore_1
    //   1611: aload 19
    //   1613: astore 20
    //   1615: goto -137 -> 1478
    //   1618: astore 21
    //   1620: goto -450 -> 1170
    //   1623: astore 21
    //   1625: iload 14
    //   1627: istore 10
    //   1629: goto -459 -> 1170
    //   1632: astore 21
    //   1634: goto -1079 -> 555
    //   1637: astore 21
    //   1639: goto -1084 -> 555
    //   1642: aload 21
    //   1644: astore 19
    //   1646: iload 11
    //   1648: istore 9
    //   1650: goto -1397 -> 253
    //   1653: iconst_0
    //   1654: istore 11
    //   1656: iload 9
    //   1658: istore 10
    //   1660: iload 11
    //   1662: istore 9
    //   1664: goto -1411 -> 253
    //   1667: iload 5
    //   1669: istore 11
    //   1671: goto -1538 -> 133
    //   1674: iload 9
    //   1676: istore 4
    //   1678: goto -1601 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1681	0	this	UploadTransfer
    //   0	1681	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	1681	2	paramURL	URL
    //   0	1681	3	paramArrayOfByte	byte[]
    //   0	1681	4	paramInt1	int
    //   0	1681	5	paramInt2	int
    //   111	8	6	d	double
    //   32	1488	8	i	int
    //   21	1654	9	j	int
    //   29	1630	10	k	int
    //   131	1539	11	m	int
    //   35	1493	12	n	int
    //   150	1194	13	i1	int
    //   179	1447	14	i2	int
    //   861	110	15	i3	int
    //   87	1519	16	bool	boolean
    //   1539	29	17	l	long
    //   18	1627	19	localObject1	Object
    //   157	1457	20	localObject2	Object
    //   383	117	21	localObject3	Object
    //   533	9	21	localThrowable	java.lang.Throwable
    //   553	54	21	localIOException1	IOException
    //   805	108	21	localObject4	Object
    //   1164	31	21	localException1	java.lang.Exception
    //   1336	18	21	localObject5	Object
    //   1618	1	21	localException2	java.lang.Exception
    //   1623	1	21	localException3	java.lang.Exception
    //   1632	1	21	localIOException2	IOException
    //   1637	6	21	localIOException3	IOException
    //   6	960	22	localByteArrayBuffer	ByteArrayPool.ByteArrayBuffer
    //   15	1413	23	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   373	385	533	java/lang/Throwable
    //   402	408	533	java/lang/Throwable
    //   412	423	533	java/lang/Throwable
    //   427	453	533	java/lang/Throwable
    //   457	464	533	java/lang/Throwable
    //   211	215	553	java/io/IOException
    //   278	292	553	java/io/IOException
    //   304	316	553	java/io/IOException
    //   320	347	553	java/io/IOException
    //   351	361	553	java/io/IOException
    //   373	385	553	java/io/IOException
    //   402	408	553	java/io/IOException
    //   412	423	553	java/io/IOException
    //   427	453	553	java/io/IOException
    //   457	464	553	java/io/IOException
    //   468	472	553	java/io/IOException
    //   539	546	553	java/io/IOException
    //   834	863	553	java/io/IOException
    //   872	880	553	java/io/IOException
    //   962	977	553	java/io/IOException
    //   986	991	553	java/io/IOException
    //   995	1001	553	java/io/IOException
    //   1010	1020	553	java/io/IOException
    //   1024	1035	553	java/io/IOException
    //   1039	1051	553	java/io/IOException
    //   1055	1060	553	java/io/IOException
    //   1064	1074	553	java/io/IOException
    //   1078	1085	553	java/io/IOException
    //   1140	1150	553	java/io/IOException
    //   1154	1161	553	java/io/IOException
    //   1282	1294	553	java/io/IOException
    //   1298	1312	553	java/io/IOException
    //   1316	1326	553	java/io/IOException
    //   1391	1403	553	java/io/IOException
    //   1407	1421	553	java/io/IOException
    //   1425	1435	553	java/io/IOException
    //   211	215	1164	java/lang/Exception
    //   278	292	1164	java/lang/Exception
    //   304	316	1164	java/lang/Exception
    //   320	347	1164	java/lang/Exception
    //   351	361	1164	java/lang/Exception
    //   373	385	1164	java/lang/Exception
    //   402	408	1164	java/lang/Exception
    //   412	423	1164	java/lang/Exception
    //   427	453	1164	java/lang/Exception
    //   457	464	1164	java/lang/Exception
    //   468	472	1164	java/lang/Exception
    //   539	546	1164	java/lang/Exception
    //   834	863	1164	java/lang/Exception
    //   872	880	1164	java/lang/Exception
    //   962	977	1164	java/lang/Exception
    //   986	991	1164	java/lang/Exception
    //   995	1001	1164	java/lang/Exception
    //   1010	1020	1164	java/lang/Exception
    //   1024	1035	1164	java/lang/Exception
    //   1039	1051	1164	java/lang/Exception
    //   1055	1060	1164	java/lang/Exception
    //   1064	1074	1164	java/lang/Exception
    //   1078	1085	1164	java/lang/Exception
    //   1140	1150	1164	java/lang/Exception
    //   1154	1161	1164	java/lang/Exception
    //   1282	1294	1164	java/lang/Exception
    //   1298	1312	1164	java/lang/Exception
    //   1316	1326	1164	java/lang/Exception
    //   1391	1403	1164	java/lang/Exception
    //   1407	1421	1164	java/lang/Exception
    //   1425	1435	1164	java/lang/Exception
    //   211	215	1477	finally
    //   278	292	1477	finally
    //   304	316	1477	finally
    //   320	347	1477	finally
    //   351	361	1477	finally
    //   373	385	1477	finally
    //   402	408	1477	finally
    //   412	423	1477	finally
    //   427	453	1477	finally
    //   457	464	1477	finally
    //   468	472	1477	finally
    //   539	546	1477	finally
    //   559	568	1477	finally
    //   572	579	1477	finally
    //   583	611	1477	finally
    //   834	863	1477	finally
    //   872	880	1477	finally
    //   962	977	1477	finally
    //   986	991	1477	finally
    //   995	1001	1477	finally
    //   1010	1020	1477	finally
    //   1024	1035	1477	finally
    //   1039	1051	1477	finally
    //   1055	1060	1477	finally
    //   1064	1074	1477	finally
    //   1078	1085	1477	finally
    //   1140	1150	1477	finally
    //   1154	1161	1477	finally
    //   1174	1186	1477	finally
    //   1190	1199	1477	finally
    //   1282	1294	1477	finally
    //   1298	1312	1477	finally
    //   1316	1326	1477	finally
    //   1391	1403	1477	finally
    //   1407	1421	1477	finally
    //   1425	1435	1477	finally
    //   1567	1572	1586	java/lang/InterruptedException
    //   113	133	1610	finally
    //   133	178	1610	finally
    //   187	198	1610	finally
    //   113	133	1618	java/lang/Exception
    //   133	178	1618	java/lang/Exception
    //   187	198	1623	java/lang/Exception
    //   113	133	1632	java/io/IOException
    //   133	178	1632	java/io/IOException
    //   187	198	1637	java/io/IOException
  }
  
  /* Error */
  private int processUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 85	com/weiyun/sdk/job/transfer/UploadTransfer:createUrl	()Ljava/net/URL;
    //   4: astore 14
    //   6: new 165	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   14: invokevirtual 294	com/weiyun/sdk/job/UploadJobContext:getSrcPath	()Ljava/lang/String;
    //   17: ldc_w 547
    //   20: invokespecial 549	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 13
    //   25: aload_0
    //   26: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   29: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   32: ldc2_w 9
    //   35: lcmp
    //   36: ifle +155 -> 191
    //   39: new 133	com/weiyun/sdk/job/api/StoragePlatomProto
    //   42: dup
    //   43: sipush 1007
    //   46: aload_0
    //   47: getfield 76	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   50: aload_0
    //   51: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   54: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   57: aload_0
    //   58: getfield 69	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   61: iconst_0
    //   62: i2l
    //   63: invokespecial 552	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   66: astore 12
    //   68: ldc_w 553
    //   71: newarray byte
    //   73: astore 15
    //   75: iconst_0
    //   76: istore_1
    //   77: aload_0
    //   78: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   81: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   84: ifne +161 -> 245
    //   87: ldc 14
    //   89: ldc_w 365
    //   92: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: aload 13
    //   98: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   101: aload_0
    //   102: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   105: sipush -10002
    //   108: ireturn
    //   109: astore 12
    //   111: ldc 14
    //   113: new 116	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 557
    //   123: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 12
    //   128: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   141: aload 12
    //   143: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   146: sipush -10006
    //   149: ireturn
    //   150: astore 12
    //   152: ldc 14
    //   154: new 116	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 564
    //   164: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 12
    //   169: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   182: aload 12
    //   184: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   187: sipush -29002
    //   190: ireturn
    //   191: new 133	com/weiyun/sdk/job/api/StoragePlatomProto
    //   194: dup
    //   195: sipush 1000
    //   198: aload_0
    //   199: getfield 76	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   202: aload_0
    //   203: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   206: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   209: aload_0
    //   210: getfield 69	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   213: iconst_0
    //   214: i2l
    //   215: invokespecial 552	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   218: astore 12
    //   220: goto -152 -> 68
    //   223: astore 12
    //   225: ldc 14
    //   227: aload 12
    //   229: invokestatic 566	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_0
    //   233: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   236: aload 12
    //   238: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   241: sipush -10001
    //   244: ireturn
    //   245: aload_0
    //   246: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   249: invokevirtual 569	com/weiyun/sdk/job/BaseUploadJob:checkFile	()Z
    //   252: ifne +31 -> 283
    //   255: ldc 14
    //   257: ldc_w 571
    //   260: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   267: invokevirtual 574	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   270: istore_1
    //   271: aload_0
    //   272: aload 13
    //   274: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   277: aload_0
    //   278: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   281: iload_1
    //   282: ireturn
    //   283: aload_0
    //   284: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   287: invokevirtual 577	com/weiyun/sdk/job/BaseUploadJob:checkEnvironment	()Z
    //   290: ifne +31 -> 321
    //   293: ldc 14
    //   295: ldc_w 579
    //   298: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_0
    //   302: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   305: invokevirtual 574	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   308: istore_1
    //   309: aload_0
    //   310: aload 13
    //   312: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   315: aload_0
    //   316: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   319: iload_1
    //   320: ireturn
    //   321: aload_0
    //   322: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   325: ifgt +44 -> 369
    //   328: invokestatic 584	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   331: invokevirtual 585	com/weiyun/sdk/context/SdkContext:getContext	()Landroid/content/Context;
    //   334: invokestatic 588	com/weiyun/sdk/util/NetworkUtils:getPacketSize	(Landroid/content/Context;)I
    //   337: istore_2
    //   338: iload_2
    //   339: ifge +25 -> 364
    //   342: ldc 14
    //   344: ldc_w 590
    //   347: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_0
    //   351: aload 13
    //   353: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   356: aload_0
    //   357: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   360: sipush -10003
    //   363: ireturn
    //   364: aload_0
    //   365: iload_2
    //   366: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   369: invokestatic 108	android/os/SystemClock:uptimeMillis	()J
    //   372: lstore 4
    //   374: aload_0
    //   375: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   378: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   381: lstore 6
    //   383: aload 13
    //   385: aload_0
    //   386: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   389: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   392: invokevirtual 593	java/io/RandomAccessFile:seek	(J)V
    //   395: aload 12
    //   397: invokevirtual 596	com/weiyun/sdk/job/api/StoragePlatomProto:getHeadLength	()I
    //   400: istore_3
    //   401: aload 13
    //   403: aload 15
    //   405: iload_3
    //   406: aload_0
    //   407: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   410: invokevirtual 599	java/io/RandomAccessFile:read	([BII)I
    //   413: istore_2
    //   414: iload_2
    //   415: ifgt +43 -> 458
    //   418: aload_0
    //   419: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   422: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   425: lstore 8
    //   427: aload_0
    //   428: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   431: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   434: lstore 10
    //   436: lload 8
    //   438: lload 10
    //   440: lcmp
    //   441: ifge +17 -> 458
    //   444: aload_0
    //   445: aload 13
    //   447: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   450: aload_0
    //   451: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   454: sipush -10009
    //   457: ireturn
    //   458: iload_2
    //   459: ifgt +41 -> 500
    //   462: aload_0
    //   463: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   466: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   469: lstore 8
    //   471: aload_0
    //   472: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   475: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   478: lstore 10
    //   480: lload 8
    //   482: lload 10
    //   484: lcmp
    //   485: ifne +15 -> 500
    //   488: aload_0
    //   489: aload 13
    //   491: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   494: aload_0
    //   495: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   498: iconst_0
    //   499: ireturn
    //   500: iload_1
    //   501: iconst_1
    //   502: iadd
    //   503: istore_1
    //   504: iload_1
    //   505: i2l
    //   506: lstore 8
    //   508: aload 12
    //   510: lload 8
    //   512: invokevirtual 602	com/weiyun/sdk/job/api/StoragePlatomProto:setSeq	(J)V
    //   515: aload_0
    //   516: aload 12
    //   518: aload 14
    //   520: aload 15
    //   522: iload_3
    //   523: iload_2
    //   524: invokespecial 604	com/weiyun/sdk/job/transfer/UploadTransfer:httpPostData	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   527: istore_3
    //   528: iload_3
    //   529: ifeq +40 -> 569
    //   532: ldc 14
    //   534: new 116	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 606
    //   544: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: iload_3
    //   548: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 531	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_0
    //   558: aload 13
    //   560: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   563: aload_0
    //   564: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   567: iload_3
    //   568: ireturn
    //   569: aload_0
    //   570: getfield 55	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   573: invokevirtual 363	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   576: ifne +25 -> 601
    //   579: ldc 14
    //   581: ldc_w 365
    //   584: invokestatic 368	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aload_0
    //   588: aload 13
    //   590: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   593: aload_0
    //   594: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   597: sipush -10002
    //   600: ireturn
    //   601: aload_0
    //   602: aload 12
    //   604: iload_2
    //   605: invokespecial 610	com/weiyun/sdk/job/transfer/UploadTransfer:processUploadRsp	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;I)V
    //   608: aload_0
    //   609: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   612: astore 16
    //   614: aload 16
    //   616: aload 16
    //   618: getfield 258	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataTimeCost	J
    //   621: invokestatic 108	android/os/SystemClock:uptimeMillis	()J
    //   624: lload 4
    //   626: lsub
    //   627: ladd
    //   628: putfield 258	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataTimeCost	J
    //   631: aload_0
    //   632: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   635: astore 16
    //   637: aload 16
    //   639: aload 16
    //   641: getfield 288	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataSize	J
    //   644: aload_0
    //   645: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   648: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   651: lload 6
    //   653: lsub
    //   654: ladd
    //   655: putfield 288	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:transferDataSize	J
    //   658: aload_0
    //   659: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   662: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   665: aload_0
    //   666: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   669: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   672: lcmp
    //   673: ifeq -185 -> 488
    //   676: aload_0
    //   677: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   680: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   683: aload_0
    //   684: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   687: invokevirtual 155	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   690: lcmp
    //   691: ifle +48 -> 739
    //   694: ldc 14
    //   696: new 116	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 612
    //   706: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_0
    //   710: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   713: invokevirtual 152	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   716: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   719: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 173	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   725: aload_0
    //   726: aload 13
    //   728: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   731: aload_0
    //   732: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   735: sipush -10013
    //   738: ireturn
    //   739: goto -662 -> 77
    //   742: astore 12
    //   744: ldc 14
    //   746: new 116	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 614
    //   756: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 12
    //   761: invokevirtual 560	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: aload_0
    //   771: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   774: aload 12
    //   776: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   779: aload_0
    //   780: aload 13
    //   782: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   785: aload_0
    //   786: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   789: sipush -10008
    //   792: ireturn
    //   793: astore 12
    //   795: ldc 14
    //   797: aload 12
    //   799: invokevirtual 615	java/lang/Exception:toString	()Ljava/lang/String;
    //   802: invokestatic 562	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 81	com/weiyun/sdk/job/transfer/UploadTransfer:mProcessInfo	Lcom/weiyun/sdk/job/transfer/Transfer$ProcessInfo;
    //   809: aload 12
    //   811: putfield 324	com/weiyun/sdk/job/transfer/Transfer$ProcessInfo:failException	Ljava/lang/Throwable;
    //   814: aload_0
    //   815: aload 13
    //   817: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   820: aload_0
    //   821: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   824: sipush -10014
    //   827: ireturn
    //   828: astore 12
    //   830: aload_0
    //   831: aload 13
    //   833: invokespecial 555	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   836: aload_0
    //   837: invokespecial 409	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   840: aload 12
    //   842: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	843	0	this	UploadTransfer
    //   76	429	1	i	int
    //   337	268	2	j	int
    //   400	168	3	k	int
    //   372	253	4	l1	long
    //   381	271	6	l2	long
    //   425	86	8	l3	long
    //   434	49	10	l4	long
    //   66	1	12	localStoragePlatomProto1	StoragePlatomProto
    //   109	33	12	localFileNotFoundException	java.io.FileNotFoundException
    //   150	33	12	localMalformedURLException	MalformedURLException
    //   218	1	12	localStoragePlatomProto2	StoragePlatomProto
    //   223	380	12	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   742	33	12	localIOException	IOException
    //   793	17	12	localException	java.lang.Exception
    //   828	13	12	localObject	Object
    //   23	809	13	localRandomAccessFile	RandomAccessFile
    //   4	515	14	localURL	URL
    //   73	448	15	arrayOfByte	byte[]
    //   612	28	16	localProcessInfo	Transfer.ProcessInfo
    // Exception table:
    //   from	to	target	type
    //   0	25	109	java/io/FileNotFoundException
    //   0	25	150	java/net/MalformedURLException
    //   25	68	223	java/lang/IllegalArgumentException
    //   191	220	223	java/lang/IllegalArgumentException
    //   77	95	742	java/io/IOException
    //   245	271	742	java/io/IOException
    //   283	309	742	java/io/IOException
    //   321	338	742	java/io/IOException
    //   342	350	742	java/io/IOException
    //   364	369	742	java/io/IOException
    //   369	414	742	java/io/IOException
    //   418	436	742	java/io/IOException
    //   462	480	742	java/io/IOException
    //   508	528	742	java/io/IOException
    //   532	557	742	java/io/IOException
    //   569	587	742	java/io/IOException
    //   601	725	742	java/io/IOException
    //   77	95	793	java/lang/Exception
    //   245	271	793	java/lang/Exception
    //   283	309	793	java/lang/Exception
    //   321	338	793	java/lang/Exception
    //   342	350	793	java/lang/Exception
    //   364	369	793	java/lang/Exception
    //   369	414	793	java/lang/Exception
    //   418	436	793	java/lang/Exception
    //   462	480	793	java/lang/Exception
    //   508	528	793	java/lang/Exception
    //   532	557	793	java/lang/Exception
    //   569	587	793	java/lang/Exception
    //   601	725	793	java/lang/Exception
    //   77	95	828	finally
    //   245	271	828	finally
    //   283	309	828	finally
    //   321	338	828	finally
    //   342	350	828	finally
    //   364	369	828	finally
    //   369	414	828	finally
    //   418	436	828	finally
    //   462	480	828	finally
    //   508	528	828	finally
    //   532	557	828	finally
    //   569	587	828	finally
    //   601	725	828	finally
    //   744	779	828	finally
    //   795	814	828	finally
  }
  
  private void processUploadRsp(StoragePlatomProto paramStoragePlatomProto, int paramInt)
  {
    switch (paramStoragePlatomProto.getUploadRspFlag())
    {
    default: 
      return;
    case 1: 
      if (this.mContext.getCurSize() + paramInt < this.mContext.getTotalSize())
      {
        com.weiyun.sdk.log.Log.i("UploadTransfer", "some file has the same md5. file = " + this.mContext.getFileName());
        this.mContext.setContentExist(true);
        BaseUploadJob.makeFakeTransfer(this.mContext, this.mJob);
      }
      this.mContext.setCurSize(this.mContext.getTotalSize());
      this.mJob.notifyProgressChanged(this.mContext.getTotalSize(), this.mContext.getTotalSize());
      return;
    }
    adjustProgress(paramStoragePlatomProto, this.mContext.getCurSize() + paramInt);
  }
  
  protected HttpPost configHttpClient(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.mHttpClient == null)
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
      localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(45000));
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      this.mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      this.mHttpClient.setHttpRequestRetryHandler(createHttpRequestRetryHandler(1, true));
    }
    if (!NetworkUtils.isWIFI(SdkContext.getInstance().getContext()))
    {
      this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
      this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(60000 + this.mTimeoutTimes * 5000));
      return paramURL;
    }
    this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 30000));
    this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
    return paramURL;
  }
  
  protected DefaultHttpRequestRetryHandler createHttpRequestRetryHandler(int paramInt, boolean paramBoolean)
  {
    return new UploadTaskRequestRetryHandler(paramInt, true);
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mAddress.getHost(), this.mAddress.getPort(), this.mAddress.getFile());
  }
  
  public int transfer()
  {
    int i = processUpload();
    doInnerReport(new Transfer.Result(i, ErrorMessages.getErrorString(i)), this.mProcessInfo);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.UploadTransfer
 * JD-Core Version:    0.7.0.1
 */