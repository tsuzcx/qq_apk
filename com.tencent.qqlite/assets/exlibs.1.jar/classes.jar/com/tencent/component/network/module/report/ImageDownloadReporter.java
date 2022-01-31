package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.module.common.NetworkState;
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
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static int a(HttpResponse paramHttpResponse)
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
        return 0;
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
          Const.a("ImageDownload", "", localNumberFormatException);
        }
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
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
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = a[(j & 0xF)];
      i += 1;
    }
  }
  
  /* Error */
  private static byte[] a(File paramFile, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_0
    //   4: invokevirtual 90	java/io/File:exists	()Z
    //   7: ifeq +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 93	java/io/File:isFile	()Z
    //   14: ifne +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokevirtual 97	java/io/File:length	()J
    //   23: lstore 6
    //   25: lload_1
    //   26: lstore 4
    //   28: lload_1
    //   29: lconst_0
    //   30: lcmp
    //   31: ifge +6 -> 37
    //   34: lconst_0
    //   35: lstore 4
    //   37: lload 4
    //   39: lload 6
    //   41: lcmp
    //   42: ifge -25 -> 17
    //   45: sipush 1024
    //   48: lload 6
    //   50: lload 4
    //   52: lsub
    //   53: l2i
    //   54: invokestatic 103	java/lang/Math:min	(II)I
    //   57: istore_3
    //   58: iload_3
    //   59: newarray byte
    //   61: astore 9
    //   63: new 105	java/io/RandomAccessFile
    //   66: dup
    //   67: aload_0
    //   68: ldc 107
    //   70: invokespecial 110	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore 8
    //   75: aload 8
    //   77: lload 4
    //   79: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   82: aload 8
    //   84: aload 9
    //   86: invokevirtual 118	java/io/RandomAccessFile:read	([B)I
    //   89: istore_3
    //   90: iload_3
    //   91: ifgt +17 -> 108
    //   94: aload 10
    //   96: astore_0
    //   97: aload 8
    //   99: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore 8
    //   106: aload_0
    //   107: areturn
    //   108: iload_3
    //   109: aload 9
    //   111: arraylength
    //   112: if_icmpge +67 -> 179
    //   115: iload_3
    //   116: newarray byte
    //   118: astore_0
    //   119: aload 9
    //   121: iconst_0
    //   122: aload_0
    //   123: iconst_0
    //   124: iload_3
    //   125: invokestatic 127	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   128: goto -31 -> 97
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull -118 -> 17
    //   138: aload_0
    //   139: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore 8
    //   151: aload 8
    //   153: ifnull +8 -> 161
    //   156: aload 8
    //   158: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   161: aload_0
    //   162: athrow
    //   163: astore 8
    //   165: goto -4 -> 161
    //   168: astore_0
    //   169: goto -18 -> 151
    //   172: astore_0
    //   173: aload 8
    //   175: astore_0
    //   176: goto -42 -> 134
    //   179: aload 9
    //   181: astore_0
    //   182: goto -85 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramFile	File
    //   0	185	1	paramLong	long
    //   57	68	3	i	int
    //   26	52	4	l1	long
    //   23	26	6	l2	long
    //   73	25	8	localRandomAccessFile	java.io.RandomAccessFile
    //   104	1	8	localIOException1	IOException
    //   149	8	8	localObject1	Object
    //   163	11	8	localIOException2	IOException
    //   61	119	9	arrayOfByte	byte[]
    //   1	94	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   97	102	104	java/io/IOException
    //   58	75	131	java/lang/Throwable
    //   138	142	144	java/io/IOException
    //   58	75	147	finally
    //   156	161	163	java/io/IOException
    //   75	90	168	finally
    //   108	128	168	finally
    //   75	90	172	java/lang/Throwable
    //   108	128	172	java/lang/Throwable
  }
  
  public boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (Const.f((String)localObject1, "text/html"))
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
              Const.a("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          localObject2 = localObject1;
          Const.a("ImageDownloader", "", paramDownloadResult);
          if (localObject1 != null) {
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              Const.a("ImageDownloader", "", paramDownloadResult);
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
        Const.a("ImageDownloader", "", paramHttpResponse);
      }
    }
  }
  
  public void handleReport$7905c7a2(DownloadResult paramDownloadResult, Const paramConst)
  {
    uploadReport(obtainReportObj$3f852cae(paramDownloadResult, paramConst));
  }
  
  public ReportHandler.DownloadReportObject obtainReportObj$3f852cae(DownloadResult paramDownloadResult, Const paramConst)
  {
    int i = 5;
    ReportHandler.DownloadReportObject localDownloadReportObject = new ReportHandler.DownloadReportObject();
    localDownloadReportObject.init();
    localDownloadReportObject.setUrl(paramConst.b);
    localDownloadReportObject.fileSize = paramConst.e;
    localDownloadReportObject.startTime = paramConst.c;
    localDownloadReportObject.endTime = paramConst.d;
    localDownloadReportObject.elapse = (localDownloadReportObject.endTime - localDownloadReportObject.startTime);
    localDownloadReportObject.flow = paramConst.a;
    localDownloadReportObject.networkType = NetworkState.g().getNetworkType();
    localDownloadReportObject.serverIp = paramConst.j;
    localDownloadReportObject.dnsIp = paramConst.i;
    localDownloadReportObject.retry = paramConst.k;
    localDownloadReportObject.strategyInfo = paramConst.l;
    localDownloadReportObject.clientip = paramConst.m;
    localDownloadReportObject.totaltime = paramConst.n;
    localDownloadReportObject.t_wait = paramConst.o;
    localDownloadReportObject.t_prepare = paramConst.p;
    localDownloadReportObject.t_conn = 0L;
    localDownloadReportObject.t_recvrsp = 0L;
    localDownloadReportObject.t_recvdata = paramConst.q;
    localDownloadReportObject.t_process = 0L;
    localDownloadReportObject.content_type = null;
    localDownloadReportObject.concurrent = paramConst.r;
    localDownloadReportObject.refer = paramConst.s;
    if (paramDownloadResult.getStatus().isSucceed())
    {
      if (paramDownloadResult.getContent().noCache)
      {
        localDownloadReportObject.retCode = a(paramConst.g);
        if (localDownloadReportObject.retCode == 0) {
          localDownloadReportObject.retCode = -2;
        }
        return localDownloadReportObject;
      }
      if (paramDownloadResult.getContent().size != paramDownloadResult.getContent().length)
      {
        localDownloadReportObject.retCode = -3;
        localDownloadReportObject.errMsg.append(";content-length:" + paramDownloadResult.getContent().length + ";actual-size:" + paramDownloadResult.getContent().size);
        paramConst = new File(paramDownloadResult.getPath());
        paramDownloadResult = a(a(paramConst, 0L));
        paramConst = a(a(paramConst, paramConst.length() - 1024L));
        localDownloadReportObject.errMsg.append(";head-content:" + paramDownloadResult);
        localDownloadReportObject.errMsg.append(";tail-content:" + paramConst);
        return localDownloadReportObject;
      }
      localDownloadReportObject.retCode = 0;
      return localDownloadReportObject;
    }
    localDownloadReportObject.errMsg.append("httpStatus:" + paramConst.f + "; ");
    int j;
    if (paramConst.h != null)
    {
      paramDownloadResult = paramConst.h;
      j = localDownloadReportObject.retCode;
      if (paramDownloadResult == null) {
        break label778;
      }
      if ((paramDownloadResult instanceof ClientProtocolException)) {
        i = 8;
      }
    }
    for (;;)
    {
      localDownloadReportObject.retCode = i;
      localDownloadReportObject.errMsg.append(Log.getStackTraceString(paramConst.h));
      return localDownloadReportObject;
      if ((paramDownloadResult instanceof SSLPeerUnverifiedException)) {
        i = 12;
      } else if ((paramDownloadResult instanceof NoHttpResponseException)) {
        i = 11;
      } else if ((paramDownloadResult instanceof UnknownHostException)) {
        i = 9;
      } else if ((paramDownloadResult instanceof ConnectionPoolTimeoutException)) {
        i = 13;
      } else if ((paramDownloadResult instanceof ConnectTimeoutException)) {
        i = 10;
      } else if (!(paramDownloadResult instanceof IllegalStateException)) {
        if ((paramDownloadResult instanceof SocketException))
        {
          i = 6;
        }
        else if ((paramDownloadResult instanceof SocketTimeoutException))
        {
          i = 7;
        }
        else if ((paramDownloadResult instanceof FileNotFoundException))
        {
          i = 1;
        }
        else if ((paramDownloadResult instanceof IOException))
        {
          i = 2;
        }
        else if ((paramDownloadResult instanceof Exception))
        {
          i = 4;
        }
        else if ((paramDownloadResult instanceof OutOfMemoryError))
        {
          i = 3;
          continue;
          if (paramDownloadResult.getStatus().getFailReason() == 5)
          {
            localDownloadReportObject.retCode = -1;
            localDownloadReportObject.errMsg.append("content-type:" + paramDownloadResult.getContent().type + "; data:" + paramDownloadResult.getContent().content + "; ");
            return localDownloadReportObject;
          }
          if (paramConst.g == null)
          {
            localDownloadReportObject.retCode = -99997;
            return localDownloadReportObject;
          }
          localDownloadReportObject.retCode = paramConst.f;
          return localDownloadReportObject;
        }
        else
        {
          label778:
          i = j;
        }
      }
    }
  }
  
  public void uploadReport(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.uploadReport(paramDownloadReportObject, paramDownloadReportObject.appIdType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */