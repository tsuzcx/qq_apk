package com.qzone.report;

import android.text.TextUtils;
import android.util.Log;
import com.qzone.common.NetworkState;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloadReport;
import com.qzone.download.DownloadResult;
import com.qzone.download.DownloadResult.Content;
import com.qzone.download.DownloadResult.Status;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.strategy.global.ReportHandler;
import com.qzone.utils.StringUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;

public class ImageDownloadReporter
  implements ReportHandler
{
  private static final String CONTENTTYPE_HTML = "text/html";
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return new String(arrayOfChar);
      }
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = digits[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = digits[(j & 0xF)];
      i += 1;
    }
  }
  
  private int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
    int i = paramInt;
    if (paramThrowable != null)
    {
      if (!(paramThrowable instanceof ClientProtocolException)) {
        break label18;
      }
      i = 8;
    }
    label18:
    do
    {
      return i;
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof NoHttpResponseException)) {
        return 11;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof ConnectionPoolTimeoutException)) {
        return 13;
      }
      if ((paramThrowable instanceof ConnectTimeoutException)) {
        return 10;
      }
      if ((paramThrowable instanceof IllegalStateException)) {
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException)) {
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      i = paramInt;
    } while (!(paramThrowable instanceof OutOfMemoryError));
    return 3;
  }
  
  private int getRetCodeFrom(HttpResponse paramHttpResponse, int paramInt)
  {
    if (paramHttpResponse == null)
    {
      paramHttpResponse = null;
      if (paramHttpResponse == null) {}
    }
    for (;;)
    {
      if (!paramHttpResponse.hasNext())
      {
        return paramInt;
        paramHttpResponse = paramHttpResponse.headerIterator("Retcode");
        break;
      }
      Header localHeader = paramHttpResponse.nextHeader();
      if (localHeader != null) {
        try
        {
          int i = Integer.parseInt(localHeader.getValue());
          return i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QDLog.v("ImageDownload", "", localNumberFormatException);
        }
      }
    }
  }
  
  /* Error */
  private static byte[] readFromFile(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 123	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 126	java/io/File:isFile	()Z
    //   15: ifne +9 -> 24
    //   18: aconst_null
    //   19: astore 9
    //   21: aload 9
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 130	java/io/File:length	()J
    //   28: lstore 6
    //   30: lload_1
    //   31: lstore 4
    //   33: lload_1
    //   34: lconst_0
    //   35: lcmp
    //   36: ifge +6 -> 42
    //   39: lconst_0
    //   40: lstore 4
    //   42: lload 4
    //   44: lload 6
    //   46: lcmp
    //   47: ifge +7 -> 54
    //   50: iload_3
    //   51: ifgt +5 -> 56
    //   54: aconst_null
    //   55: areturn
    //   56: iload_3
    //   57: lload 6
    //   59: lload 4
    //   61: lsub
    //   62: l2i
    //   63: invokestatic 136	java/lang/Math:min	(II)I
    //   66: istore_3
    //   67: aconst_null
    //   68: astore 10
    //   70: aconst_null
    //   71: astore 11
    //   73: iload_3
    //   74: newarray byte
    //   76: astore 9
    //   78: new 138	java/io/RandomAccessFile
    //   81: dup
    //   82: aload_0
    //   83: ldc 140
    //   85: invokespecial 143	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   88: astore 8
    //   90: aload 8
    //   92: lload 4
    //   94: invokevirtual 147	java/io/RandomAccessFile:seek	(J)V
    //   97: aload 8
    //   99: aload 9
    //   101: invokevirtual 151	java/io/RandomAccessFile:read	([B)I
    //   104: istore_3
    //   105: iload_3
    //   106: ifgt +24 -> 130
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: astore 9
    //   114: aload 8
    //   116: ifnull -95 -> 21
    //   119: aload 8
    //   121: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore 8
    //   128: aload_0
    //   129: areturn
    //   130: aload 9
    //   132: astore_0
    //   133: iload_3
    //   134: aload 9
    //   136: arraylength
    //   137: if_icmpge -26 -> 111
    //   140: iload_3
    //   141: newarray byte
    //   143: astore_0
    //   144: aload 9
    //   146: iconst_0
    //   147: aload_0
    //   148: iconst_0
    //   149: iload_3
    //   150: invokestatic 160	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   153: goto -42 -> 111
    //   156: astore_0
    //   157: aload 11
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: aload 10
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +8 -> 185
    //   180: aload 8
    //   182: invokevirtual 154	java/io/RandomAccessFile:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: goto -20 -> 168
    //   191: astore 8
    //   193: goto -8 -> 185
    //   196: astore_0
    //   197: goto -22 -> 175
    //   200: astore_0
    //   201: aload 8
    //   203: astore_0
    //   204: goto -44 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramFile	File
    //   0	207	1	paramLong	long
    //   0	207	3	paramInt	int
    //   31	62	4	l1	long
    //   28	30	6	l2	long
    //   88	32	8	localRandomAccessFile	java.io.RandomAccessFile
    //   126	1	8	localIOException1	IOException
    //   173	8	8	localObject1	Object
    //   191	11	8	localIOException2	IOException
    //   19	126	9	localObject2	Object
    //   68	104	10	localObject3	Object
    //   71	87	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	124	126	java/io/IOException
    //   73	90	156	java/lang/Throwable
    //   73	90	170	finally
    //   164	168	187	java/io/IOException
    //   180	185	191	java/io/IOException
    //   90	105	196	finally
    //   133	153	196	finally
    //   90	105	200	java/lang/Throwable
    //   133	153	200	java/lang/Throwable
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (StringUtil.startsWithIgnoreCase((String)localObject1, "text/html"))
      {
        localObject2 = null;
        localObject1 = null;
        try
        {
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          Object localObject3 = new byte[1024];
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          int i = paramHttpResponse.read((byte[])localObject3);
          if (i > 0)
          {
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            localObject3 = new String((byte[])localObject3, 0, i);
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            paramDownloadResult.getContent().content = localObject3;
          }
          if (paramHttpResponse != null) {
            try
            {
              paramHttpResponse.close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              QDLog.v("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          localObject2 = localObject1;
          QDLog.v("ImageDownloader", "", paramDownloadResult);
          if (localObject1 != null) {
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              QDLog.v("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        finally
        {
          if (localObject2 == null) {}
        }
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramDownloadResult;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        QDLog.v("ImageDownloader", "", paramHttpResponse);
      }
    }
  }
  
  public void handleReport(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    uploadReport(obtainReportObj(paramDownloadResult, paramDownloadReport));
  }
  
  public DownloadImageReport.DownloadReportObject obtainReportObj(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    DownloadImageReport.DownloadReportObject localDownloadReportObject = new DownloadImageReport.DownloadReportObject();
    localDownloadReportObject.init(DownloaderFactory.getDownloadConfig());
    localDownloadReportObject.setUrl(paramDownloadReport.url);
    localDownloadReportObject.fileSize = paramDownloadReport.fileSize;
    localDownloadReportObject.startTime = paramDownloadReport.startTime;
    localDownloadReportObject.endTime = paramDownloadReport.endTime;
    localDownloadReportObject.elapse = (localDownloadReportObject.endTime - localDownloadReportObject.startTime);
    localDownloadReportObject.flow = paramDownloadReport.id;
    localDownloadReportObject.networkType = NetworkState.g().getNetworkType();
    localDownloadReportObject.serverIp = paramDownloadReport.remoteAddress;
    localDownloadReportObject.dnsIp = paramDownloadReport.dns;
    localDownloadReportObject.retry = paramDownloadReport.currAttempCount;
    localDownloadReportObject.strategyInfo = paramDownloadReport.strategyInfo;
    localDownloadReportObject.clientip = paramDownloadReport.clientip;
    localDownloadReportObject.refer = paramDownloadReport.refer;
    paramDownloadReport.t_wait = paramDownloadReport.t_wait;
    if (paramDownloadResult.getStatus().isSucceed())
    {
      if (paramDownloadResult.getContent().noCache)
      {
        localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.response, 0);
        if (localDownloadReportObject.retCode == 0) {
          localDownloadReportObject.retCode = -2;
        }
        return localDownloadReportObject;
      }
      if (paramDownloadResult.getContent().size != paramDownloadResult.getContent().length)
      {
        localDownloadReportObject.retCode = -3;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";actual-size:" + paramDownloadResult.getContent().size);
        paramDownloadReport = new File(paramDownloadResult.getPath());
        paramDownloadResult = bytes2HexStr(readFromFile(paramDownloadReport, 0L, 1024));
        paramDownloadReport = bytes2HexStr(readFromFile(paramDownloadReport, paramDownloadReport.length() - 1024L, 1024));
        localDownloadReportObject.errMsg.append(";head-content:" + paramDownloadResult);
        localDownloadReportObject.errMsg.append(";tail-content:" + paramDownloadReport);
        return localDownloadReportObject;
      }
      localDownloadReportObject.retCode = 0;
      return localDownloadReportObject;
    }
    localDownloadReportObject.errMsg.append("httpStatus:" + paramDownloadReport.httpStatus + "; ");
    if (paramDownloadReport.exception != null)
    {
      localDownloadReportObject.retCode = getRetCodeFrom(paramDownloadReport.exception, localDownloadReportObject.retCode);
      localDownloadReportObject.errMsg.append(Log.getStackTraceString(paramDownloadReport.exception));
      return localDownloadReportObject;
    }
    if (paramDownloadResult.getStatus().getFailReason() == 5)
    {
      localDownloadReportObject.retCode = -1;
      localDownloadReportObject.errMsg.append("content-type:" + paramDownloadResult.getContent().type + "; data:" + paramDownloadResult.getContent().content + "; ");
      return localDownloadReportObject;
    }
    if (paramDownloadReport.response == null)
    {
      localDownloadReportObject.retCode = -99997;
      return localDownloadReportObject;
    }
    localDownloadReportObject.retCode = paramDownloadReport.httpStatus;
    return localDownloadReportObject;
  }
  
  public void uploadReport(DownloadImageReport.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.uploadReport(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */