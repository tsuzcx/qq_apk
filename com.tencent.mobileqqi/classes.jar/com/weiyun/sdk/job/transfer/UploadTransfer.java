package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.api.StoragePlatomProto;
import com.weiyun.sdk.job.api.UploadTaskRequestRetryHandler;
import com.weiyun.sdk.log.Log;
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
  }
  
  private void adjustProgress(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mJob.getId());
    localStringBuilder.append(", server's offset: ");
    localStringBuilder.append(paramStoragePlatomProto.getUploadRspNextOffset());
    localStringBuilder.append(", local's offset: ");
    localStringBuilder.append(paramLong);
    Log.v("UploadTransfer", localStringBuilder.toString());
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
      for (;;)
      {
        Log.w("UploadTransfer", "close file failed!");
      }
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
  
  /* Error */
  private int httpPostData(StoragePlatomProto paramStoragePlatomProto, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 163	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   3: invokevirtual 167	com/weiyun/sdk/job/transfer/ByteArrayPool:createBuffer	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;
    //   6: astore 28
    //   8: new 77	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   15: astore 29
    //   17: aconst_null
    //   18: astore 22
    //   20: iconst_0
    //   21: istore 8
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   28: iconst_0
    //   29: istore 9
    //   31: iconst_0
    //   32: istore 13
    //   34: iconst_0
    //   35: istore 12
    //   37: aconst_null
    //   38: astore 23
    //   40: iload 12
    //   42: iconst_3
    //   43: if_icmplt +41 -> 84
    //   46: iload 9
    //   48: ifeq +9 -> 57
    //   51: iload 13
    //   53: iconst_3
    //   54: if_icmplt +30 -> 84
    //   57: iload 8
    //   59: istore 4
    //   61: invokestatic 163	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   64: astore_1
    //   65: iload 4
    //   67: ifne +1915 -> 1982
    //   70: iconst_1
    //   71: istore 19
    //   73: aload_1
    //   74: aload 28
    //   76: iload 19
    //   78: invokevirtual 171	com/weiyun/sdk/job/transfer/ByteArrayPool:freeBuffer	(Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;Z)V
    //   81: iload 4
    //   83: ireturn
    //   84: aload_0
    //   85: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   88: invokevirtual 175	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   91: ifne +18 -> 109
    //   94: ldc 14
    //   96: ldc 177
    //   98: invokestatic 180	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: sipush -10002
    //   104: istore 4
    //   106: goto -45 -> 61
    //   109: iload 5
    //   111: istore 14
    //   113: iload 5
    //   115: sipush 8192
    //   118: if_icmple +48 -> 166
    //   121: iload 12
    //   123: i2d
    //   124: dstore 6
    //   126: iload 9
    //   128: istore 10
    //   130: aload 22
    //   132: astore 24
    //   134: iload 9
    //   136: istore 11
    //   138: aload 22
    //   140: astore 26
    //   142: aload 22
    //   144: astore 27
    //   146: iload 5
    //   148: ldc2_w 181
    //   151: dload 6
    //   153: invokestatic 188	java/lang/Math:pow	(DD)D
    //   156: d2i
    //   157: idiv
    //   158: sipush 8192
    //   161: invokestatic 192	java/lang/Math:max	(II)I
    //   164: istore 14
    //   166: iload 9
    //   168: istore 10
    //   170: aload 22
    //   172: astore 24
    //   174: iload 9
    //   176: istore 11
    //   178: aload 22
    //   180: astore 26
    //   182: aload 22
    //   184: astore 27
    //   186: aload_1
    //   187: aload_0
    //   188: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   191: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   194: iload 14
    //   196: aload_3
    //   197: iconst_0
    //   198: iload 4
    //   200: invokevirtual 196	com/weiyun/sdk/job/api/StoragePlatomProto:buildUploadRequestHead	(JI[BII)I
    //   203: istore 15
    //   205: iload 9
    //   207: istore 10
    //   209: aload 22
    //   211: astore 24
    //   213: iload 9
    //   215: istore 11
    //   217: aload 22
    //   219: astore 26
    //   221: aload 22
    //   223: astore 27
    //   225: aload_0
    //   226: aload_2
    //   227: invokevirtual 200	com/weiyun/sdk/job/transfer/UploadTransfer:configHttpClient	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   230: astore 25
    //   232: iload 9
    //   234: istore 10
    //   236: aload 22
    //   238: astore 24
    //   240: iload 9
    //   242: istore 11
    //   244: aload 22
    //   246: astore 26
    //   248: aload 22
    //   250: astore 27
    //   252: aload 25
    //   254: new 202	com/weiyun/sdk/job/api/SppByteArrayEntity
    //   257: dup
    //   258: aload_3
    //   259: iconst_0
    //   260: iload 14
    //   262: iload 15
    //   264: iadd
    //   265: invokespecial 205	com/weiyun/sdk/job/api/SppByteArrayEntity:<init>	([BII)V
    //   268: invokevirtual 211	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   271: iconst_0
    //   272: istore 9
    //   274: iconst_0
    //   275: istore 17
    //   277: iconst_0
    //   278: istore 16
    //   280: iconst_0
    //   281: istore 18
    //   283: iconst_0
    //   284: istore 15
    //   286: iload 9
    //   288: istore 10
    //   290: aload 22
    //   292: astore 24
    //   294: iload 16
    //   296: istore 11
    //   298: aload 22
    //   300: astore 26
    //   302: aload 22
    //   304: astore 27
    //   306: aload_0
    //   307: getfield 37	com/weiyun/sdk/job/transfer/UploadTransfer:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   310: aload 25
    //   312: invokevirtual 215	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   315: astore 22
    //   317: aload 22
    //   319: ifnonnull +95 -> 414
    //   322: iload 9
    //   324: istore 10
    //   326: aload 22
    //   328: astore 24
    //   330: iload 16
    //   332: istore 11
    //   334: aload 22
    //   336: astore 26
    //   338: aload 22
    //   340: astore 27
    //   342: aload_0
    //   343: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   346: iload 8
    //   348: istore 9
    //   350: aload 22
    //   352: ifnull +1649 -> 2001
    //   355: iload 8
    //   357: istore 9
    //   359: aload 22
    //   361: invokeinterface 223 1 0
    //   366: ifnull +1635 -> 2001
    //   369: aload 22
    //   371: invokeinterface 223 1 0
    //   376: invokeinterface 228 1 0
    //   381: aload 22
    //   383: astore 24
    //   385: iload 13
    //   387: istore 11
    //   389: iload 15
    //   391: istore 10
    //   393: iload 12
    //   395: iconst_1
    //   396: iadd
    //   397: istore 12
    //   399: iload 10
    //   401: istore 9
    //   403: iload 11
    //   405: istore 13
    //   407: aload 24
    //   409: astore 22
    //   411: goto -371 -> 40
    //   414: iload 9
    //   416: istore 10
    //   418: aload 22
    //   420: astore 24
    //   422: iload 16
    //   424: istore 11
    //   426: aload 22
    //   428: astore 26
    //   430: aload 22
    //   432: astore 27
    //   434: aload 22
    //   436: invokeinterface 232 1 0
    //   441: invokeinterface 238 1 0
    //   446: istore 8
    //   448: iload 8
    //   450: sipush 200
    //   453: if_icmpeq +697 -> 1150
    //   456: iload 9
    //   458: istore 10
    //   460: aload 22
    //   462: astore 24
    //   464: iload 16
    //   466: istore 11
    //   468: aload 22
    //   470: astore 26
    //   472: aload 22
    //   474: astore 27
    //   476: aload 29
    //   478: iconst_0
    //   479: aload 29
    //   481: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   484: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: iload 9
    //   490: istore 10
    //   492: aload 22
    //   494: astore 24
    //   496: iload 16
    //   498: istore 11
    //   500: aload 22
    //   502: astore 26
    //   504: aload 22
    //   506: astore 27
    //   508: aload 29
    //   510: ldc 247
    //   512: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: iload 8
    //   517: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   520: ldc 252
    //   522: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload_1
    //   526: invokevirtual 255	com/weiyun/sdk/job/api/StoragePlatomProto:getUploadRspErrCode	()I
    //   529: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: iload 9
    //   535: istore 10
    //   537: aload 22
    //   539: astore 24
    //   541: iload 16
    //   543: istore 11
    //   545: aload 22
    //   547: astore 26
    //   549: aload 22
    //   551: astore 27
    //   553: ldc 14
    //   555: aload 29
    //   557: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: iload 8
    //   565: sipush 30000
    //   568: isub
    //   569: istore 14
    //   571: iload 9
    //   573: istore 10
    //   575: aload 22
    //   577: astore 24
    //   579: iload 16
    //   581: istore 11
    //   583: aload 22
    //   585: astore 26
    //   587: aload 22
    //   589: astore 27
    //   591: aload 22
    //   593: ldc_w 257
    //   596: invokeinterface 261 2 0
    //   601: astore 25
    //   603: iload 14
    //   605: istore 8
    //   607: aload 25
    //   609: ifnull +134 -> 743
    //   612: iload 14
    //   614: istore 8
    //   616: iload 9
    //   618: istore 10
    //   620: aload 22
    //   622: astore 24
    //   624: iload 16
    //   626: istore 11
    //   628: aload 22
    //   630: astore 26
    //   632: aload 22
    //   634: astore 27
    //   636: aload 25
    //   638: arraylength
    //   639: ifle +104 -> 743
    //   642: iload 9
    //   644: istore 10
    //   646: aload 22
    //   648: astore 24
    //   650: iload 16
    //   652: istore 11
    //   654: aload 22
    //   656: astore 26
    //   658: aload 22
    //   660: astore 27
    //   662: aload 25
    //   664: iconst_0
    //   665: aaload
    //   666: invokeinterface 266 1 0
    //   671: astore 25
    //   673: iload 9
    //   675: istore 10
    //   677: aload 22
    //   679: astore 24
    //   681: iload 16
    //   683: istore 11
    //   685: aload 22
    //   687: astore 26
    //   689: aload 22
    //   691: astore 27
    //   693: ldc 14
    //   695: new 77	java/lang/StringBuilder
    //   698: dup
    //   699: ldc_w 268
    //   702: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   705: aload 25
    //   707: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: iload 9
    //   718: istore 10
    //   720: aload 22
    //   722: astore 24
    //   724: iload 16
    //   726: istore 11
    //   728: aload 22
    //   730: astore 26
    //   732: aload 22
    //   734: astore 27
    //   736: aload 25
    //   738: invokestatic 277	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   741: istore 8
    //   743: iload 9
    //   745: istore 10
    //   747: aload 22
    //   749: astore 24
    //   751: iload 16
    //   753: istore 11
    //   755: aload 22
    //   757: astore 26
    //   759: aload 22
    //   761: astore 27
    //   763: aload_0
    //   764: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   767: iload 8
    //   769: istore 9
    //   771: aload 22
    //   773: ifnull +1228 -> 2001
    //   776: iload 8
    //   778: istore 9
    //   780: aload 22
    //   782: invokeinterface 223 1 0
    //   787: ifnull +1214 -> 2001
    //   790: aload 22
    //   792: invokeinterface 223 1 0
    //   797: invokeinterface 228 1 0
    //   802: iload 15
    //   804: istore 10
    //   806: iload 13
    //   808: istore 11
    //   810: aload 22
    //   812: astore 24
    //   814: goto -421 -> 393
    //   817: astore 25
    //   819: iload 9
    //   821: istore 10
    //   823: aload 22
    //   825: astore 24
    //   827: iload 16
    //   829: istore 11
    //   831: aload 22
    //   833: astore 26
    //   835: aload 22
    //   837: astore 27
    //   839: ldc 14
    //   841: aload 25
    //   843: invokestatic 280	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   846: iload 14
    //   848: istore 8
    //   850: goto -107 -> 743
    //   853: astore 26
    //   855: aload 24
    //   857: astore 22
    //   859: iload 10
    //   861: istore 8
    //   863: aload 23
    //   865: astore 25
    //   867: aload 26
    //   869: astore 24
    //   871: aload 22
    //   873: astore 23
    //   875: aload 24
    //   877: invokestatic 286	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   880: istore 11
    //   882: aload 22
    //   884: astore 23
    //   886: ldc 14
    //   888: new 77	java/lang/StringBuilder
    //   891: dup
    //   892: ldc_w 288
    //   895: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   898: iload 11
    //   900: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: aload 24
    //   908: invokestatic 292	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   911: aload 25
    //   913: astore 26
    //   915: iload 11
    //   917: istore 9
    //   919: iload 8
    //   921: istore 10
    //   923: aload 22
    //   925: astore 27
    //   927: aload 22
    //   929: ifnull +57 -> 986
    //   932: aload 25
    //   934: astore 26
    //   936: iload 11
    //   938: istore 9
    //   940: iload 8
    //   942: istore 10
    //   944: aload 22
    //   946: astore 27
    //   948: aload 22
    //   950: invokeinterface 223 1 0
    //   955: ifnull +31 -> 986
    //   958: aload 22
    //   960: invokeinterface 223 1 0
    //   965: invokeinterface 228 1 0
    //   970: aload 22
    //   972: astore 27
    //   974: iload 8
    //   976: istore 10
    //   978: iload 11
    //   980: istore 9
    //   982: aload 25
    //   984: astore 26
    //   986: aload_0
    //   987: iconst_0
    //   988: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   991: aload_0
    //   992: aload_0
    //   993: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   996: i2d
    //   997: ldc2_w 293
    //   1000: dmul
    //   1001: d2i
    //   1002: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1005: iload 9
    //   1007: sipush -30002
    //   1010: if_icmpne +874 -> 1884
    //   1013: aload_0
    //   1014: aload_0
    //   1015: getfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1018: iconst_1
    //   1019: iadd
    //   1020: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1023: iload 9
    //   1025: sipush -30024
    //   1028: if_icmpeq +107 -> 1135
    //   1031: iload 9
    //   1033: sipush -30001
    //   1036: if_icmpeq +99 -> 1135
    //   1039: iload 9
    //   1041: sipush -30002
    //   1044: if_icmpeq +91 -> 1135
    //   1047: iload 9
    //   1049: sipush -30010
    //   1052: if_icmpeq +83 -> 1135
    //   1055: iload 9
    //   1057: sipush -30014
    //   1060: if_icmpeq +75 -> 1135
    //   1063: iload 9
    //   1065: sipush -30015
    //   1068: if_icmpeq +67 -> 1135
    //   1071: iload 9
    //   1073: sipush -30018
    //   1076: if_icmpeq +59 -> 1135
    //   1079: iload 9
    //   1081: sipush -30023
    //   1084: if_icmpeq +51 -> 1135
    //   1087: iload 9
    //   1089: sipush -30090
    //   1092: if_icmpeq +43 -> 1135
    //   1095: iload 9
    //   1097: sipush -30025
    //   1100: if_icmpeq +35 -> 1135
    //   1103: iload 9
    //   1105: sipush -30091
    //   1108: if_icmpeq +27 -> 1135
    //   1111: aload 26
    //   1113: astore 23
    //   1115: iload 9
    //   1117: istore 8
    //   1119: iload 13
    //   1121: istore 11
    //   1123: aload 27
    //   1125: astore 24
    //   1127: iload 9
    //   1129: sipush -30027
    //   1132: if_icmpne -739 -> 393
    //   1135: aconst_null
    //   1136: invokestatic 300	com/weiyun/sdk/util/NetworkUtils:hasInternet	(Landroid/content/Context;)Z
    //   1139: ifne +753 -> 1892
    //   1142: sipush -10003
    //   1145: istore 4
    //   1147: goto -1086 -> 61
    //   1150: iload 9
    //   1152: istore 10
    //   1154: aload 22
    //   1156: astore 24
    //   1158: iload 16
    //   1160: istore 11
    //   1162: aload 22
    //   1164: astore 26
    //   1166: aload 22
    //   1168: astore 27
    //   1170: new 302	java/io/BufferedInputStream
    //   1173: dup
    //   1174: aload 22
    //   1176: invokeinterface 223 1 0
    //   1181: invokeinterface 306 1 0
    //   1186: invokespecial 309	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1189: astore 25
    //   1191: aload 22
    //   1193: astore 23
    //   1195: aload 25
    //   1197: aload 28
    //   1199: getfield 314	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1202: invokevirtual 320	java/io/InputStream:read	([B)I
    //   1205: istore 9
    //   1207: iload 9
    //   1209: ifgt +110 -> 1319
    //   1212: aload 22
    //   1214: astore 23
    //   1216: ldc 14
    //   1218: ldc_w 322
    //   1221: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1224: sipush -29003
    //   1227: istore 9
    //   1229: aload 25
    //   1231: astore 23
    //   1233: iload 9
    //   1235: istore 8
    //   1237: iload 15
    //   1239: istore 10
    //   1241: iload 13
    //   1243: istore 11
    //   1245: aload 22
    //   1247: astore 24
    //   1249: aload 22
    //   1251: ifnull -858 -> 393
    //   1254: aload 25
    //   1256: astore 23
    //   1258: iload 9
    //   1260: istore 8
    //   1262: iload 15
    //   1264: istore 10
    //   1266: iload 13
    //   1268: istore 11
    //   1270: aload 22
    //   1272: astore 24
    //   1274: aload 22
    //   1276: invokeinterface 223 1 0
    //   1281: ifnull -888 -> 393
    //   1284: aload 22
    //   1286: invokeinterface 223 1 0
    //   1291: invokeinterface 228 1 0
    //   1296: aload 25
    //   1298: astore 23
    //   1300: iload 9
    //   1302: istore 8
    //   1304: iload 15
    //   1306: istore 10
    //   1308: iload 13
    //   1310: istore 11
    //   1312: aload 22
    //   1314: astore 24
    //   1316: goto -923 -> 393
    //   1319: iload 8
    //   1321: sipush 200
    //   1324: if_icmpne +178 -> 1502
    //   1327: iconst_1
    //   1328: istore 19
    //   1330: aload 22
    //   1332: astore 23
    //   1334: aload_1
    //   1335: iload 19
    //   1337: aload 28
    //   1339: getfield 314	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1342: iload 9
    //   1344: invokevirtual 326	com/weiyun/sdk/job/api/StoragePlatomProto:parseUploadRsp	(Z[BI)I
    //   1347: istore 8
    //   1349: iload 8
    //   1351: ifne +185 -> 1536
    //   1354: aload 22
    //   1356: astore 23
    //   1358: aload_0
    //   1359: iconst_0
    //   1360: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1363: aload 22
    //   1365: astore 23
    //   1367: aload_0
    //   1368: iload 14
    //   1370: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1373: iload 12
    //   1375: ifne +57 -> 1432
    //   1378: aload 22
    //   1380: astore 23
    //   1382: aload_0
    //   1383: aload_0
    //   1384: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1387: iconst_1
    //   1388: iadd
    //   1389: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1392: aload 22
    //   1394: astore 23
    //   1396: aload_0
    //   1397: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1400: aload_0
    //   1401: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1404: if_icmplt +28 -> 1432
    //   1407: aload 22
    //   1409: astore 23
    //   1411: aload_0
    //   1412: aload_0
    //   1413: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1416: sipush 8192
    //   1419: iadd
    //   1420: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1423: aload 22
    //   1425: astore 23
    //   1427: aload_0
    //   1428: iconst_0
    //   1429: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1432: aload 22
    //   1434: astore 23
    //   1436: aload_0
    //   1437: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1440: sipush 8192
    //   1443: if_icmpge +65 -> 1508
    //   1446: aload 22
    //   1448: astore 23
    //   1450: aload_0
    //   1451: sipush 8192
    //   1454: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1457: iconst_0
    //   1458: istore 5
    //   1460: iload 5
    //   1462: istore 4
    //   1464: aload 22
    //   1466: ifnull -1405 -> 61
    //   1469: iload 5
    //   1471: istore 4
    //   1473: aload 22
    //   1475: invokeinterface 223 1 0
    //   1480: ifnull -1419 -> 61
    //   1483: aload 22
    //   1485: invokeinterface 223 1 0
    //   1490: invokeinterface 228 1 0
    //   1495: iload 5
    //   1497: istore 4
    //   1499: goto -1438 -> 61
    //   1502: iconst_0
    //   1503: istore 19
    //   1505: goto -175 -> 1330
    //   1508: aload 22
    //   1510: astore 23
    //   1512: aload_0
    //   1513: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1516: ldc_w 327
    //   1519: if_icmple -62 -> 1457
    //   1522: aload 22
    //   1524: astore 23
    //   1526: aload_0
    //   1527: ldc_w 327
    //   1530: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1533: goto -76 -> 1457
    //   1536: ldc_w 328
    //   1539: iload 8
    //   1541: if_icmpne +145 -> 1686
    //   1544: aload 22
    //   1546: astore 23
    //   1548: aload 29
    //   1550: iconst_0
    //   1551: aload 29
    //   1553: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   1556: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1559: pop
    //   1560: aload 22
    //   1562: astore 23
    //   1564: aload 29
    //   1566: ldc_w 330
    //   1569: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: iload 8
    //   1574: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1577: pop
    //   1578: aload 22
    //   1580: astore 23
    //   1582: ldc 14
    //   1584: aload 29
    //   1586: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1589: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1592: iload 8
    //   1594: istore 9
    //   1596: aload 25
    //   1598: astore 23
    //   1600: iload 9
    //   1602: istore 8
    //   1604: iload 15
    //   1606: istore 10
    //   1608: iload 13
    //   1610: istore 11
    //   1612: aload 22
    //   1614: astore 24
    //   1616: aload 22
    //   1618: ifnull -1225 -> 393
    //   1621: aload 25
    //   1623: astore 23
    //   1625: iload 9
    //   1627: istore 8
    //   1629: iload 15
    //   1631: istore 10
    //   1633: iload 13
    //   1635: istore 11
    //   1637: aload 22
    //   1639: astore 24
    //   1641: aload 22
    //   1643: invokeinterface 223 1 0
    //   1648: ifnull -1255 -> 393
    //   1651: aload 22
    //   1653: invokeinterface 223 1 0
    //   1658: invokeinterface 228 1 0
    //   1663: aload 25
    //   1665: astore 23
    //   1667: iload 9
    //   1669: istore 8
    //   1671: iload 15
    //   1673: istore 10
    //   1675: iload 13
    //   1677: istore 11
    //   1679: aload 22
    //   1681: astore 24
    //   1683: goto -1290 -> 393
    //   1686: aload 22
    //   1688: astore 23
    //   1690: aload 29
    //   1692: iconst_0
    //   1693: aload 29
    //   1695: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   1698: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1701: pop
    //   1702: aload 22
    //   1704: astore 23
    //   1706: aload 29
    //   1708: ldc_w 332
    //   1711: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: iload 8
    //   1716: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1719: pop
    //   1720: aload 22
    //   1722: astore 23
    //   1724: ldc 14
    //   1726: aload 29
    //   1728: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1731: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1734: iload 8
    //   1736: istore 5
    //   1738: goto -278 -> 1460
    //   1741: astore 24
    //   1743: aload 26
    //   1745: astore 22
    //   1747: aload 23
    //   1749: astore 25
    //   1751: aload 22
    //   1753: astore 23
    //   1755: ldc 14
    //   1757: aload 24
    //   1759: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1762: aload 24
    //   1764: invokestatic 292	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1767: sipush -10014
    //   1770: istore 8
    //   1772: aload 25
    //   1774: astore 26
    //   1776: iload 8
    //   1778: istore 9
    //   1780: iload 11
    //   1782: istore 10
    //   1784: aload 22
    //   1786: astore 27
    //   1788: aload 22
    //   1790: ifnull -804 -> 986
    //   1793: aload 25
    //   1795: astore 26
    //   1797: iload 8
    //   1799: istore 9
    //   1801: iload 11
    //   1803: istore 10
    //   1805: aload 22
    //   1807: astore 27
    //   1809: aload 22
    //   1811: invokeinterface 223 1 0
    //   1816: ifnull -830 -> 986
    //   1819: aload 22
    //   1821: invokeinterface 223 1 0
    //   1826: invokeinterface 228 1 0
    //   1831: aload 25
    //   1833: astore 26
    //   1835: iload 8
    //   1837: istore 9
    //   1839: iload 11
    //   1841: istore 10
    //   1843: aload 22
    //   1845: astore 27
    //   1847: goto -861 -> 986
    //   1850: astore_1
    //   1851: aload 27
    //   1853: astore 23
    //   1855: aload 23
    //   1857: ifnull +25 -> 1882
    //   1860: aload 23
    //   1862: invokeinterface 223 1 0
    //   1867: ifnull +15 -> 1882
    //   1870: aload 23
    //   1872: invokeinterface 223 1 0
    //   1877: invokeinterface 228 1 0
    //   1882: aload_1
    //   1883: athrow
    //   1884: aload_0
    //   1885: iconst_0
    //   1886: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1889: goto -866 -> 1023
    //   1892: iconst_1
    //   1893: istore 10
    //   1895: iload 13
    //   1897: iconst_1
    //   1898: iadd
    //   1899: istore 11
    //   1901: ldc2_w 336
    //   1904: ldc2_w 181
    //   1907: iload 12
    //   1909: i2d
    //   1910: ldc2_w 338
    //   1913: invokestatic 188	java/lang/Math:pow	(DD)D
    //   1916: dadd
    //   1917: dmul
    //   1918: d2l
    //   1919: lstore 20
    //   1921: ldc 14
    //   1923: new 77	java/lang/StringBuilder
    //   1926: dup
    //   1927: ldc_w 341
    //   1930: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1933: lload 20
    //   1935: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1938: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1941: invokestatic 344	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1944: lload 20
    //   1946: invokestatic 349	java/lang/Thread:sleep	(J)V
    //   1949: aload 26
    //   1951: astore 23
    //   1953: iload 9
    //   1955: istore 8
    //   1957: aload 27
    //   1959: astore 24
    //   1961: goto -1568 -> 393
    //   1964: astore_1
    //   1965: ldc 14
    //   1967: aload_1
    //   1968: invokevirtual 350	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1971: aload_1
    //   1972: invokestatic 352	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1975: iload 9
    //   1977: istore 4
    //   1979: goto -1918 -> 61
    //   1982: iconst_0
    //   1983: istore 19
    //   1985: goto -1912 -> 73
    //   1988: astore_1
    //   1989: goto -134 -> 1855
    //   1992: astore 24
    //   1994: iload 18
    //   1996: istore 11
    //   1998: goto -247 -> 1751
    //   2001: iload 9
    //   2003: istore 8
    //   2005: iload 15
    //   2007: istore 10
    //   2009: iload 13
    //   2011: istore 11
    //   2013: aload 22
    //   2015: astore 24
    //   2017: goto -1624 -> 393
    //   2020: astore 24
    //   2022: iload 17
    //   2024: istore 8
    //   2026: goto -1155 -> 871
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2029	0	this	UploadTransfer
    //   0	2029	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	2029	2	paramURL	URL
    //   0	2029	3	paramArrayOfByte	byte[]
    //   0	2029	4	paramInt1	int
    //   0	2029	5	paramInt2	int
    //   124	28	6	d	double
    //   21	2004	8	i	int
    //   29	1973	9	j	int
    //   128	1880	10	k	int
    //   136	1876	11	m	int
    //   35	1873	12	n	int
    //   32	1978	13	i1	int
    //   111	1258	14	i2	int
    //   203	1803	15	i3	int
    //   278	881	16	i4	int
    //   275	1748	17	i5	int
    //   281	1714	18	i6	int
    //   71	1913	19	bool	boolean
    //   1919	26	20	l	long
    //   18	1996	22	localObject1	Object
    //   38	1914	23	localObject2	Object
    //   132	1550	24	localObject3	Object
    //   1741	22	24	localException1	java.lang.Exception
    //   1959	1	24	localObject4	Object
    //   1992	1	24	localException2	java.lang.Exception
    //   2015	1	24	localObject5	Object
    //   2020	1	24	localIOException1	IOException
    //   230	507	25	localObject6	Object
    //   817	25	25	localThrowable	java.lang.Throwable
    //   865	967	25	localObject7	Object
    //   140	694	26	localObject8	Object
    //   853	15	26	localIOException2	IOException
    //   913	1037	26	localObject9	Object
    //   144	1814	27	localObject10	Object
    //   6	1332	28	localByteArrayBuffer	ByteArrayPool.ByteArrayBuffer
    //   15	1712	29	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   591	603	817	java/lang/Throwable
    //   636	642	817	java/lang/Throwable
    //   662	673	817	java/lang/Throwable
    //   693	716	817	java/lang/Throwable
    //   736	743	817	java/lang/Throwable
    //   146	166	853	java/io/IOException
    //   186	205	853	java/io/IOException
    //   225	232	853	java/io/IOException
    //   252	271	853	java/io/IOException
    //   306	317	853	java/io/IOException
    //   342	346	853	java/io/IOException
    //   434	448	853	java/io/IOException
    //   476	488	853	java/io/IOException
    //   508	533	853	java/io/IOException
    //   553	563	853	java/io/IOException
    //   591	603	853	java/io/IOException
    //   636	642	853	java/io/IOException
    //   662	673	853	java/io/IOException
    //   693	716	853	java/io/IOException
    //   736	743	853	java/io/IOException
    //   763	767	853	java/io/IOException
    //   839	846	853	java/io/IOException
    //   1170	1191	853	java/io/IOException
    //   146	166	1741	java/lang/Exception
    //   186	205	1741	java/lang/Exception
    //   225	232	1741	java/lang/Exception
    //   252	271	1741	java/lang/Exception
    //   306	317	1741	java/lang/Exception
    //   342	346	1741	java/lang/Exception
    //   434	448	1741	java/lang/Exception
    //   476	488	1741	java/lang/Exception
    //   508	533	1741	java/lang/Exception
    //   553	563	1741	java/lang/Exception
    //   591	603	1741	java/lang/Exception
    //   636	642	1741	java/lang/Exception
    //   662	673	1741	java/lang/Exception
    //   693	716	1741	java/lang/Exception
    //   736	743	1741	java/lang/Exception
    //   763	767	1741	java/lang/Exception
    //   839	846	1741	java/lang/Exception
    //   1170	1191	1741	java/lang/Exception
    //   146	166	1850	finally
    //   186	205	1850	finally
    //   225	232	1850	finally
    //   252	271	1850	finally
    //   306	317	1850	finally
    //   342	346	1850	finally
    //   434	448	1850	finally
    //   476	488	1850	finally
    //   508	533	1850	finally
    //   553	563	1850	finally
    //   591	603	1850	finally
    //   636	642	1850	finally
    //   662	673	1850	finally
    //   693	716	1850	finally
    //   736	743	1850	finally
    //   763	767	1850	finally
    //   839	846	1850	finally
    //   1170	1191	1850	finally
    //   1944	1949	1964	java/lang/InterruptedException
    //   875	882	1988	finally
    //   886	911	1988	finally
    //   1195	1207	1988	finally
    //   1216	1224	1988	finally
    //   1334	1349	1988	finally
    //   1358	1363	1988	finally
    //   1367	1373	1988	finally
    //   1382	1392	1988	finally
    //   1396	1407	1988	finally
    //   1411	1423	1988	finally
    //   1427	1432	1988	finally
    //   1436	1446	1988	finally
    //   1450	1457	1988	finally
    //   1512	1522	1988	finally
    //   1526	1533	1988	finally
    //   1548	1560	1988	finally
    //   1564	1578	1988	finally
    //   1582	1592	1988	finally
    //   1690	1702	1988	finally
    //   1706	1720	1988	finally
    //   1724	1734	1988	finally
    //   1755	1767	1988	finally
    //   1195	1207	1992	java/lang/Exception
    //   1216	1224	1992	java/lang/Exception
    //   1334	1349	1992	java/lang/Exception
    //   1358	1363	1992	java/lang/Exception
    //   1367	1373	1992	java/lang/Exception
    //   1382	1392	1992	java/lang/Exception
    //   1396	1407	1992	java/lang/Exception
    //   1411	1423	1992	java/lang/Exception
    //   1427	1432	1992	java/lang/Exception
    //   1436	1446	1992	java/lang/Exception
    //   1450	1457	1992	java/lang/Exception
    //   1512	1522	1992	java/lang/Exception
    //   1526	1533	1992	java/lang/Exception
    //   1548	1560	1992	java/lang/Exception
    //   1564	1578	1992	java/lang/Exception
    //   1582	1592	1992	java/lang/Exception
    //   1690	1702	1992	java/lang/Exception
    //   1706	1720	1992	java/lang/Exception
    //   1724	1734	1992	java/lang/Exception
    //   1195	1207	2020	java/io/IOException
    //   1216	1224	2020	java/io/IOException
    //   1334	1349	2020	java/io/IOException
    //   1358	1363	2020	java/io/IOException
    //   1367	1373	2020	java/io/IOException
    //   1382	1392	2020	java/io/IOException
    //   1396	1407	2020	java/io/IOException
    //   1411	1423	2020	java/io/IOException
    //   1427	1432	2020	java/io/IOException
    //   1436	1446	2020	java/io/IOException
    //   1450	1457	2020	java/io/IOException
    //   1512	1522	2020	java/io/IOException
    //   1526	1533	2020	java/io/IOException
    //   1548	1560	2020	java/io/IOException
    //   1564	1578	2020	java/io/IOException
    //   1582	1592	2020	java/io/IOException
    //   1690	1702	2020	java/io/IOException
    //   1706	1720	2020	java/io/IOException
    //   1724	1734	2020	java/io/IOException
  }
  
  /* Error */
  private int processUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 364	com/weiyun/sdk/job/transfer/UploadTransfer:createUrl	()Ljava/net/URL;
    //   4: astore 10
    //   6: new 129	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   14: invokevirtual 367	com/weiyun/sdk/job/UploadJobContext:getSrcPath	()Ljava/lang/String;
    //   17: ldc_w 369
    //   20: invokespecial 371	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 9
    //   25: iconst_0
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   31: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   34: ldc2_w 9
    //   37: lcmp
    //   38: ifle +128 -> 166
    //   41: new 95	com/weiyun/sdk/job/api/StoragePlatomProto
    //   44: dup
    //   45: sipush 1007
    //   48: aload_0
    //   49: getfield 72	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   52: aload_0
    //   53: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   56: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   59: aload_0
    //   60: getfield 65	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   63: iconst_0
    //   64: i2l
    //   65: invokespecial 374	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   68: astore 8
    //   70: ldc_w 375
    //   73: newarray byte
    //   75: astore 11
    //   77: aload_0
    //   78: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   81: invokevirtual 175	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   84: ifne +127 -> 211
    //   87: ldc 14
    //   89: ldc 177
    //   91: invokestatic 180	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: aload 9
    //   97: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   100: aload_0
    //   101: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   104: sipush -10002
    //   107: ireturn
    //   108: astore 8
    //   110: ldc 14
    //   112: new 77	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 379
    //   119: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload 8
    //   124: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 384	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: sipush -10006
    //   136: ireturn
    //   137: astore 8
    //   139: ldc 14
    //   141: new 77	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 386
    //   148: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload 8
    //   153: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 384	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: sipush -29002
    //   165: ireturn
    //   166: new 95	com/weiyun/sdk/job/api/StoragePlatomProto
    //   169: dup
    //   170: sipush 1000
    //   173: aload_0
    //   174: getfield 72	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   177: aload_0
    //   178: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   181: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   184: aload_0
    //   185: getfield 65	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   188: iconst_0
    //   189: i2l
    //   190: invokespecial 374	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   193: astore 8
    //   195: goto -125 -> 70
    //   198: astore 8
    //   200: ldc 14
    //   202: aload 8
    //   204: invokestatic 388	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: sipush -10001
    //   210: ireturn
    //   211: aload_0
    //   212: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   215: invokevirtual 391	com/weiyun/sdk/job/BaseUploadJob:checkFile	()Z
    //   218: ifne +31 -> 249
    //   221: ldc 14
    //   223: ldc_w 393
    //   226: invokestatic 180	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   233: invokevirtual 396	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   236: istore_1
    //   237: aload_0
    //   238: aload 9
    //   240: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   243: aload_0
    //   244: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   247: iload_1
    //   248: ireturn
    //   249: aload_0
    //   250: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   253: invokevirtual 399	com/weiyun/sdk/job/BaseUploadJob:checkEnvironment	()Z
    //   256: ifne +31 -> 287
    //   259: ldc 14
    //   261: ldc_w 401
    //   264: invokestatic 180	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   271: invokevirtual 396	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   274: istore_1
    //   275: aload_0
    //   276: aload 9
    //   278: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   281: aload_0
    //   282: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   285: iload_1
    //   286: ireturn
    //   287: aload_0
    //   288: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   291: ifgt +44 -> 335
    //   294: invokestatic 406	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   297: invokevirtual 410	com/weiyun/sdk/context/SdkContext:getContext	()Landroid/content/Context;
    //   300: invokestatic 414	com/weiyun/sdk/util/NetworkUtils:getPacketSize	(Landroid/content/Context;)I
    //   303: istore_2
    //   304: iload_2
    //   305: ifge +25 -> 330
    //   308: ldc 14
    //   310: ldc_w 416
    //   313: invokestatic 384	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: aload 9
    //   319: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   322: aload_0
    //   323: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   326: sipush -10003
    //   329: ireturn
    //   330: aload_0
    //   331: iload_2
    //   332: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   335: aload 9
    //   337: aload_0
    //   338: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   341: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   344: invokevirtual 419	java/io/RandomAccessFile:seek	(J)V
    //   347: aload 8
    //   349: invokevirtual 422	com/weiyun/sdk/job/api/StoragePlatomProto:getHeadLength	()I
    //   352: istore_3
    //   353: aload 9
    //   355: aload 11
    //   357: iload_3
    //   358: aload_0
    //   359: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   362: invokevirtual 425	java/io/RandomAccessFile:read	([BII)I
    //   365: istore_2
    //   366: iload_2
    //   367: ifgt +43 -> 410
    //   370: aload_0
    //   371: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   374: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   377: lstore 4
    //   379: aload_0
    //   380: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   383: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   386: lstore 6
    //   388: lload 4
    //   390: lload 6
    //   392: lcmp
    //   393: ifge +17 -> 410
    //   396: aload_0
    //   397: aload 9
    //   399: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   402: aload_0
    //   403: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   406: sipush -10009
    //   409: ireturn
    //   410: iload_2
    //   411: ifgt +41 -> 452
    //   414: aload_0
    //   415: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   418: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   421: lstore 4
    //   423: aload_0
    //   424: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   427: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   430: lstore 6
    //   432: lload 4
    //   434: lload 6
    //   436: lcmp
    //   437: ifne +15 -> 452
    //   440: aload_0
    //   441: aload 9
    //   443: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   446: aload_0
    //   447: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   450: iconst_0
    //   451: ireturn
    //   452: iload_1
    //   453: iconst_1
    //   454: iadd
    //   455: istore_1
    //   456: iload_1
    //   457: i2l
    //   458: lstore 4
    //   460: aload 8
    //   462: lload 4
    //   464: invokevirtual 428	com/weiyun/sdk/job/api/StoragePlatomProto:setSeq	(J)V
    //   467: aload_0
    //   468: aload 8
    //   470: aload 10
    //   472: aload 11
    //   474: iload_3
    //   475: iload_2
    //   476: invokespecial 430	com/weiyun/sdk/job/transfer/UploadTransfer:httpPostData	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   479: istore_3
    //   480: iload_3
    //   481: ifeq +37 -> 518
    //   484: ldc 14
    //   486: new 77	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 432
    //   493: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: iload_3
    //   497: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 344	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload_0
    //   507: aload 9
    //   509: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   512: aload_0
    //   513: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   516: iload_3
    //   517: ireturn
    //   518: aload_0
    //   519: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   522: invokevirtual 175	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   525: ifne +24 -> 549
    //   528: ldc 14
    //   530: ldc 177
    //   532: invokestatic 180	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: aload_0
    //   536: aload 9
    //   538: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   541: aload_0
    //   542: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   545: sipush -10002
    //   548: ireturn
    //   549: aload_0
    //   550: aload 8
    //   552: iload_2
    //   553: invokespecial 436	com/weiyun/sdk/job/transfer/UploadTransfer:processUploadRsp	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;I)V
    //   556: aload_0
    //   557: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   560: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   563: aload_0
    //   564: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   567: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   570: lcmp
    //   571: ifeq -131 -> 440
    //   574: aload_0
    //   575: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   578: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   581: aload_0
    //   582: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   585: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   588: lcmp
    //   589: ifle -512 -> 77
    //   592: ldc 14
    //   594: new 77	java/lang/StringBuilder
    //   597: dup
    //   598: ldc_w 438
    //   601: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   604: aload_0
    //   605: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   608: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   611: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   614: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload_0
    //   621: aload 9
    //   623: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   626: aload_0
    //   627: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   630: sipush -10013
    //   633: ireturn
    //   634: astore 8
    //   636: ldc 14
    //   638: new 77	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 440
    //   645: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: aload 8
    //   650: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 384	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: aload_0
    //   660: aload 9
    //   662: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   665: aload_0
    //   666: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   669: sipush -10008
    //   672: ireturn
    //   673: astore 8
    //   675: ldc 14
    //   677: aload 8
    //   679: invokevirtual 441	java/lang/Exception:toString	()Ljava/lang/String;
    //   682: invokestatic 384	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: aload_0
    //   686: aload 9
    //   688: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   691: aload_0
    //   692: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   695: sipush -10014
    //   698: ireturn
    //   699: astore 8
    //   701: aload_0
    //   702: aload 9
    //   704: invokespecial 377	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   707: aload_0
    //   708: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   711: aload 8
    //   713: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	UploadTransfer
    //   26	431	1	i	int
    //   303	250	2	j	int
    //   352	165	3	k	int
    //   377	86	4	l1	long
    //   386	49	6	l2	long
    //   68	1	8	localStoragePlatomProto1	StoragePlatomProto
    //   108	15	8	localFileNotFoundException	java.io.FileNotFoundException
    //   137	15	8	localMalformedURLException	MalformedURLException
    //   193	1	8	localStoragePlatomProto2	StoragePlatomProto
    //   198	353	8	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   634	15	8	localIOException	IOException
    //   673	5	8	localException	java.lang.Exception
    //   699	13	8	localObject	Object
    //   23	680	9	localRandomAccessFile	RandomAccessFile
    //   4	467	10	localURL	URL
    //   75	398	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	25	108	java/io/FileNotFoundException
    //   0	25	137	java/net/MalformedURLException
    //   27	70	198	java/lang/IllegalArgumentException
    //   166	195	198	java/lang/IllegalArgumentException
    //   77	94	634	java/io/IOException
    //   211	237	634	java/io/IOException
    //   249	275	634	java/io/IOException
    //   287	304	634	java/io/IOException
    //   308	316	634	java/io/IOException
    //   330	335	634	java/io/IOException
    //   335	366	634	java/io/IOException
    //   370	388	634	java/io/IOException
    //   414	432	634	java/io/IOException
    //   460	480	634	java/io/IOException
    //   484	506	634	java/io/IOException
    //   518	535	634	java/io/IOException
    //   549	574	634	java/io/IOException
    //   574	620	634	java/io/IOException
    //   77	94	673	java/lang/Exception
    //   211	237	673	java/lang/Exception
    //   249	275	673	java/lang/Exception
    //   287	304	673	java/lang/Exception
    //   308	316	673	java/lang/Exception
    //   330	335	673	java/lang/Exception
    //   335	366	673	java/lang/Exception
    //   370	388	673	java/lang/Exception
    //   414	432	673	java/lang/Exception
    //   460	480	673	java/lang/Exception
    //   484	506	673	java/lang/Exception
    //   518	535	673	java/lang/Exception
    //   549	574	673	java/lang/Exception
    //   574	620	673	java/lang/Exception
    //   77	94	699	finally
    //   211	237	699	finally
    //   249	275	699	finally
    //   287	304	699	finally
    //   308	316	699	finally
    //   330	335	699	finally
    //   335	366	699	finally
    //   370	388	699	finally
    //   414	432	699	finally
    //   460	480	699	finally
    //   484	506	699	finally
    //   518	535	699	finally
    //   549	574	699	finally
    //   574	620	699	finally
    //   636	659	699	finally
    //   675	685	699	finally
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
        Log.i("UploadTransfer", "some file has the same md5. file = " + this.mContext.getFileName());
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
      localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(25000));
      localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(25000));
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      this.mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      this.mHttpClient.setHttpRequestRetryHandler(createHttpRequestRetryHandler(1, true));
    }
    if (!NetworkUtils.isWIFI(SdkContext.getInstance().getContext()))
    {
      this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
      this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
      return paramURL;
    }
    this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 25000));
    this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 25000));
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
    return processUpload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.UploadTransfer
 * JD-Core Version:    0.7.0.1
 */