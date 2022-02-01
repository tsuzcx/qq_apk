package com.tencent.moai.downloader.network;

import android.util.Log;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.moai.downloader.GlobalConfig;
import com.tencent.moai.downloader.delegate.RequestDelegate;
import com.tencent.moai.downloader.exception.InterruptError;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DefaultHttpClient
  implements RequestDelegate
{
  private static final String TAG = "DefaultHttpClient";
  private static DefaultHttpClient instance;
  private OkHttpClient client = new OkHttpClient();
  
  private DefaultHttpClient()
  {
    this.client.setConnectTimeout(GlobalConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS);
    this.client.setReadTimeout(50000L, TimeUnit.MILLISECONDS);
    this.client.setWriteTimeout(50000L, TimeUnit.MILLISECONDS);
    this.client.setFollowRedirects(true);
    this.client.setFollowSslRedirects(true);
  }
  
  public static DefaultHttpClient createInstance()
  {
    instance = new DefaultHttpClient();
    return instance;
  }
  
  /* Error */
  private HttpError handleError(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, com.squareup.okhttp.Request paramRequest, Response paramResponse)
    throws Exception, InterruptError
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_2
    //   4: astore 6
    //   6: aload_2
    //   7: ifnonnull +12 -> 19
    //   10: new 75	com/tencent/moai/downloader/network/HttpResponse
    //   13: dup
    //   14: invokespecial 76	com/tencent/moai/downloader/network/HttpResponse:<init>	()V
    //   17: astore 6
    //   19: new 78	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   26: astore 8
    //   28: aload 6
    //   30: aload 4
    //   32: invokevirtual 85	com/squareup/okhttp/Response:headers	()Lcom/squareup/okhttp/Headers;
    //   35: invokevirtual 91	com/squareup/okhttp/Headers:toMultimap	()Ljava/util/Map;
    //   38: invokevirtual 95	com/tencent/moai/downloader/network/HttpResponse:setResponseHeader	(Ljava/util/Map;)V
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   46: ifeq +35 -> 81
    //   49: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   52: dup
    //   53: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   56: athrow
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_2
    //   60: aload 7
    //   62: astore_3
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 105	java/io/InputStream:close	()V
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: aload 4
    //   83: invokevirtual 112	com/squareup/okhttp/Response:body	()Lcom/squareup/okhttp/ResponseBody;
    //   86: invokevirtual 118	com/squareup/okhttp/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   89: astore_2
    //   90: aload 6
    //   92: ldc 120
    //   94: invokevirtual 124	com/tencent/moai/downloader/network/HttpResponse:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: aload 6
    //   101: ifnull +302 -> 403
    //   104: ldc 126
    //   106: aload 6
    //   108: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +76 -> 187
    //   114: new 134	java/util/zip/GZIPInputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 137	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   122: astore 6
    //   124: aload 6
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +269 -> 397
    //   131: getstatic 141	com/tencent/moai/downloader/GlobalConfig:RECEIVE_BUFF_LEN_INTEGER	Ljava/lang/Integer;
    //   134: invokevirtual 147	java/lang/Integer:intValue	()I
    //   137: newarray byte
    //   139: astore 9
    //   141: new 107	java/io/ByteArrayOutputStream
    //   144: dup
    //   145: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
    //   148: astore 6
    //   150: aload_2
    //   151: aload 9
    //   153: invokevirtual 152	java/io/InputStream:read	([B)I
    //   156: istore 5
    //   158: iload 5
    //   160: iconst_m1
    //   161: if_icmpeq +80 -> 241
    //   164: aload_0
    //   165: aload_1
    //   166: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   169: ifeq +59 -> 228
    //   172: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   175: dup
    //   176: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   179: athrow
    //   180: astore_1
    //   181: aload 6
    //   183: astore_3
    //   184: goto -121 -> 63
    //   187: ldc 154
    //   189: aload 6
    //   191: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +209 -> 403
    //   197: new 156	java/util/zip/InflaterInputStream
    //   200: dup
    //   201: aload_2
    //   202: new 158	java/util/zip/Inflater
    //   205: dup
    //   206: iconst_1
    //   207: invokespecial 160	java/util/zip/Inflater:<init>	(Z)V
    //   210: invokespecial 163	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   213: astore 6
    //   215: aload 6
    //   217: astore_2
    //   218: goto -91 -> 127
    //   221: astore_1
    //   222: aload 7
    //   224: astore_3
    //   225: goto -162 -> 63
    //   228: aload 6
    //   230: aload 9
    //   232: iconst_0
    //   233: iload 5
    //   235: invokevirtual 167	java/io/ByteArrayOutputStream:write	([BII)V
    //   238: goto -88 -> 150
    //   241: aload 8
    //   243: new 128	java/lang/String
    //   246: dup
    //   247: aload 6
    //   249: invokevirtual 171	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   252: invokespecial 174	java/lang/String:<init>	([B)V
    //   255: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_2
    //   260: ifnull +7 -> 267
    //   263: aload_2
    //   264: invokevirtual 105	java/io/InputStream:close	()V
    //   267: aload 6
    //   269: ifnull +8 -> 277
    //   272: aload 6
    //   274: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   277: aload 8
    //   279: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: astore_2
    //   283: aload_2
    //   284: astore_1
    //   285: aload_2
    //   286: invokestatic 188	com/tencent/moai/downloader/util/StringUtil:isNullOrEmpty	(Ljava/lang/String;)Z
    //   289: ifeq +6 -> 295
    //   292: ldc 190
    //   294: astore_1
    //   295: new 192	com/tencent/moai/downloader/network/HttpError
    //   298: dup
    //   299: aload 4
    //   301: invokevirtual 195	com/squareup/okhttp/Response:code	()I
    //   304: aload_3
    //   305: invokevirtual 200	com/squareup/okhttp/Request:urlString	()Ljava/lang/String;
    //   308: aload_1
    //   309: invokespecial 203	com/tencent/moai/downloader/network/HttpError:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   312: astore_2
    //   313: ldc 10
    //   315: new 78	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   322: ldc 205
    //   324: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 4
    //   329: invokevirtual 195	com/squareup/okhttp/Response:code	()I
    //   332: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc 210
    //   337: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_3
    //   341: invokevirtual 200	com/squareup/okhttp/Request:urlString	()Ljava/lang/String;
    //   344: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc 212
    //   349: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_1
    //   353: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_2
    //   363: areturn
    //   364: astore_1
    //   365: ldc 10
    //   367: aload_1
    //   368: invokestatic 224	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   371: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: goto -97 -> 277
    //   377: astore_2
    //   378: ldc 10
    //   380: aload_2
    //   381: invokestatic 224	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   384: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: goto -308 -> 79
    //   390: astore_1
    //   391: aload 7
    //   393: astore_3
    //   394: goto -331 -> 63
    //   397: aconst_null
    //   398: astore 6
    //   400: goto -141 -> 259
    //   403: goto -276 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	DefaultHttpClient
    //   0	406	1	paramHttpRequest	HttpRequest
    //   0	406	2	paramHttpResponse	HttpResponse
    //   0	406	3	paramRequest	com.squareup.okhttp.Request
    //   0	406	4	paramResponse	Response
    //   156	78	5	i	int
    //   4	395	6	localObject1	Object
    //   1	391	7	localObject2	Object
    //   26	252	8	localStringBuilder	java.lang.StringBuilder
    //   139	92	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   41	57	57	finally
    //   81	90	57	finally
    //   150	158	180	finally
    //   164	180	180	finally
    //   228	238	180	finally
    //   241	259	180	finally
    //   90	99	221	finally
    //   104	124	221	finally
    //   187	215	221	finally
    //   263	267	364	java/lang/Exception
    //   272	277	364	java/lang/Exception
    //   67	71	377	java/lang/Exception
    //   75	79	377	java/lang/Exception
    //   131	150	390	finally
  }
  
  private HttpResponse handleSuccess(HttpRequest paramHttpRequest, Response paramResponse)
    throws Exception, InterruptError
  {
    HttpResponse localHttpResponse = new HttpResponse();
    localHttpResponse.setResponseHeader(paramResponse.headers().toMultimap());
    String str = null;
    Object localObject = str;
    try
    {
      if (checkAbort(paramHttpRequest))
      {
        localObject = str;
        throw new InterruptError();
      }
    }
    finally {}
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        ((InputStream)localObject).close();
        throw paramHttpRequest;
        localObject = str;
        long l1 = paramResponse.body().contentLength();
        localObject = str;
        paramResponse = paramResponse.body().byteStream();
        localObject = paramResponse;
        str = localHttpResponse.getHeaderField("Content-Encoding");
        if (str != null)
        {
          localObject = paramResponse;
          label128:
          int i;
          if ("gzip".equals(str))
          {
            localObject = paramResponse;
            paramResponse = new GZIPInputStream(paramResponse);
            i = 0;
          }
          for (;;)
          {
            int j;
            try
            {
              localObject = new byte[GlobalConfig.RECEIVE_BUFF_LEN_INTEGER.intValue()];
              if (paramResponse == null) {
                break label240;
              }
              j = paramResponse.read((byte[])localObject);
              if (j == -1) {
                break label240;
              }
              if (!checkAbort(paramHttpRequest)) {
                break label217;
              }
              throw new InterruptError();
            }
            finally
            {
              localObject = paramResponse;
            }
            break;
            localObject = paramResponse;
            if (!"deflate".equals(str)) {
              break label277;
            }
            localObject = paramResponse;
            paramResponse = new InflaterInputStream(paramResponse, new Inflater(true));
            break label128;
            label217:
            long l2 = j;
            paramHttpRequest.onReceiveData((byte[])localObject, l2, l1);
            i += j;
          }
          label240:
          if (paramResponse != null) {}
          try
          {
            paramResponse.close();
            return localHttpResponse;
          }
          catch (Exception paramHttpRequest)
          {
            Logger.e("DefaultHttpClient", Log.getStackTraceString(paramHttpRequest));
            return localHttpResponse;
          }
        }
      }
      catch (Exception paramResponse)
      {
        label277:
        for (;;)
        {
          Logger.e("DefaultHttpClient", Log.getStackTraceString(paramResponse));
        }
      }
    }
  }
  
  private RequestBody multiPartParams(HttpRequest paramHttpRequest)
  {
    return new DefaultHttpClient.2(this, paramHttpRequest);
  }
  
  private long multiPartParamsLength(String paramString, List<HttpFileEntity> paramList)
  {
    Object localObject1;
    Object localObject2;
    if (paramString != null)
    {
      localObject1 = new StringBuffer();
      paramString = StringUtil.parseParams(paramString, true).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (HttpParam)paramString.next();
        ((StringBuffer)localObject1).append("-----------7d4a6d158c9\r\n");
        ((StringBuffer)localObject1).append("Content-Disposition: form-data; name=\"" + ((HttpParam)localObject2).getKey() + "\"\r\n\r\n");
        ((StringBuffer)localObject1).append(((HttpParam)localObject2).getValue() + "\r\n");
      }
    }
    for (long l1 = ((StringBuffer)localObject1).toString().getBytes().length + 0L;; l1 = 0L)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HttpFileEntity)((Iterator)localObject1).next();
        paramString = ((HttpFileEntity)localObject2).getFile().getName();
        String str = ((HttpFileEntity)localObject2).getContentType();
        paramList = "-----------7d4a6d158c9\r\nContent-Disposition: form-data; name=\"" + paramString + "\"; filename=\"" + paramString + "\"\r\n";
        paramString = paramList;
        if (!str.equals("")) {
          paramString = paramList + "Content-Type: " + str + "\r\n";
        }
        long l2 = (paramString + "\r\n").getBytes().length;
        l1 = ((HttpFileEntity)localObject2).getFile().length() + (l1 + l2) + "\r\n".length();
      }
      return "-----------7d4a6d158c9--\r\n".length() + l1;
    }
  }
  
  private RequestBody postParams(HttpRequest paramHttpRequest)
  {
    return new DefaultHttpClient.1(this, paramHttpRequest);
  }
  
  private void setHeader(HttpRequest paramHttpRequest, Request.Builder paramBuilder)
  {
    paramHttpRequest = paramHttpRequest.getRequestHeader();
    if ((paramHttpRequest != null) && (paramHttpRequest.size() > 0))
    {
      paramHttpRequest = paramHttpRequest.entrySet().iterator();
      while (paramHttpRequest.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHttpRequest.next();
        paramBuilder.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
        Logger.i("DefaultHttpClient", "add header: " + (String)localEntry.getKey() + "=" + (String)localEntry.getValue());
      }
    }
    paramBuilder.addHeader("Connection", "close");
  }
  
  public static DefaultHttpClient shareInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new DefaultHttpClient();
      }
      return instance;
    }
    finally {}
  }
  
  public void abort(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.getRequestStatus().setStatus(4);
  }
  
  public boolean checkAbort(HttpRequest paramHttpRequest)
  {
    return paramHttpRequest.getRequestStatus().getStatus() == 4;
  }
  
  public OkHttpClient getClient()
  {
    return this.client;
  }
  
  /* Error */
  public void start(HttpRequest paramHttpRequest)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 75	com/tencent/moai/downloader/network/HttpResponse
    //   5: dup
    //   6: invokespecial 76	com/tencent/moai/downloader/network/HttpResponse:<init>	()V
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: new 350	com/squareup/okhttp/Request$Builder
    //   17: dup
    //   18: invokespecial 386	com/squareup/okhttp/Request$Builder:<init>	()V
    //   21: astore 6
    //   23: aload_1
    //   24: invokevirtual 389	com/tencent/moai/downloader/network/HttpRequest:onPrepare	()V
    //   27: aload_0
    //   28: aload_1
    //   29: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   32: ifeq +119 -> 151
    //   35: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   38: dup
    //   39: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   42: athrow
    //   43: astore 8
    //   45: aconst_null
    //   46: astore 6
    //   48: aload 4
    //   50: astore 7
    //   52: aload 6
    //   54: astore 5
    //   56: aload 7
    //   58: astore 4
    //   60: ldc 10
    //   62: new 78	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 391
    //   72: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 8
    //   77: invokevirtual 392	com/tencent/moai/downloader/exception/InterruptError:toString	()Ljava/lang/String;
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 286
    //   86: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 8
    //   91: invokestatic 224	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   94: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 361	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 6
    //   105: astore 5
    //   107: aload 7
    //   109: astore 4
    //   111: aload_1
    //   112: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   115: iconst_4
    //   116: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   119: aload 6
    //   121: astore 5
    //   123: aload 7
    //   125: astore 4
    //   127: aload_1
    //   128: new 192	com/tencent/moai/downloader/network/HttpError
    //   131: dup
    //   132: iconst_4
    //   133: ldc_w 394
    //   136: invokespecial 397	com/tencent/moai/downloader/network/HttpError:<init>	(ILjava/lang/String;)V
    //   139: invokevirtual 401	com/tencent/moai/downloader/network/HttpRequest:onAbort	(Lcom/tencent/moai/downloader/network/HttpError;)V
    //   142: aload_1
    //   143: aload 7
    //   145: aload 6
    //   147: invokevirtual 405	com/tencent/moai/downloader/network/HttpRequest:onComplete	(Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/tencent/moai/downloader/network/HttpError;)V
    //   150: return
    //   151: aload_1
    //   152: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   155: iconst_1
    //   156: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   159: aload_0
    //   160: aload_1
    //   161: aload 6
    //   163: invokespecial 407	com/tencent/moai/downloader/network/DefaultHttpClient:setHeader	(Lcom/tencent/moai/downloader/network/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
    //   166: aload_1
    //   167: invokevirtual 411	com/tencent/moai/downloader/network/HttpRequest:getRequestMethod	()Lcom/tencent/moai/downloader/network/HttpMethod;
    //   170: astore 7
    //   172: aload 7
    //   174: getstatic 417	com/tencent/moai/downloader/network/HttpMethod:HttpMethod_GET	Lcom/tencent/moai/downloader/network/HttpMethod;
    //   177: if_acmpne +188 -> 365
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 420	com/tencent/moai/downloader/network/HttpRequest:getRequestUrl	()Ljava/lang/String;
    //   186: invokevirtual 424	com/squareup/okhttp/Request$Builder:url	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   189: pop
    //   190: aload 6
    //   192: invokevirtual 428	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   195: astore 6
    //   197: ldc 10
    //   199: new 78	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 430
    //   209: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 6
    //   214: invokevirtual 431	com/squareup/okhttp/Request:toString	()Ljava/lang/String;
    //   217: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 361	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   231: ifeq +328 -> 559
    //   234: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   237: dup
    //   238: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   241: athrow
    //   242: astore 8
    //   244: aconst_null
    //   245: astore 6
    //   247: aload 4
    //   249: astore 7
    //   251: aload 6
    //   253: astore 5
    //   255: aload 7
    //   257: astore 4
    //   259: ldc 10
    //   261: new 78	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 433
    //   271: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 8
    //   276: invokevirtual 436	javax/net/ssl/SSLException:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 438
    //   285: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 8
    //   290: invokevirtual 442	javax/net/ssl/SSLException:getCause	()Ljava/lang/Throwable;
    //   293: invokevirtual 445	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   296: ldc_w 447
    //   299: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: invokevirtual 420	com/tencent/moai/downloader/network/HttpRequest:getRequestUrl	()Ljava/lang/String;
    //   306: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 6
    //   317: astore 5
    //   319: aload 7
    //   321: astore 4
    //   323: aload_1
    //   324: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   327: iconst_3
    //   328: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   331: aload 6
    //   333: astore 5
    //   335: aload 7
    //   337: astore 4
    //   339: aload_1
    //   340: new 192	com/tencent/moai/downloader/network/HttpError
    //   343: dup
    //   344: iconst_5
    //   345: ldc_w 449
    //   348: invokespecial 397	com/tencent/moai/downloader/network/HttpError:<init>	(ILjava/lang/String;)V
    //   351: aload 7
    //   353: invokevirtual 453	com/tencent/moai/downloader/network/HttpRequest:onError	(Lcom/tencent/moai/downloader/network/HttpError;Lcom/tencent/moai/downloader/network/HttpResponse;)V
    //   356: aload_1
    //   357: aload 7
    //   359: aload 6
    //   361: invokevirtual 405	com/tencent/moai/downloader/network/HttpRequest:onComplete	(Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/tencent/moai/downloader/network/HttpError;)V
    //   364: return
    //   365: aload 7
    //   367: getstatic 456	com/tencent/moai/downloader/network/HttpMethod:HttpMethod_POST	Lcom/tencent/moai/downloader/network/HttpMethod;
    //   370: if_acmpne +140 -> 510
    //   373: aload_0
    //   374: aload_1
    //   375: invokespecial 458	com/tencent/moai/downloader/network/DefaultHttpClient:postParams	(Lcom/tencent/moai/downloader/network/HttpRequest;)Lcom/squareup/okhttp/RequestBody;
    //   378: astore 7
    //   380: aload 6
    //   382: aload_1
    //   383: invokevirtual 420	com/tencent/moai/downloader/network/HttpRequest:getRequestUrl	()Ljava/lang/String;
    //   386: invokevirtual 424	com/squareup/okhttp/Request$Builder:url	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   389: aload 7
    //   391: invokevirtual 462	com/squareup/okhttp/Request$Builder:post	(Lcom/squareup/okhttp/RequestBody;)Lcom/squareup/okhttp/Request$Builder;
    //   394: pop
    //   395: goto -205 -> 190
    //   398: astore 8
    //   400: aconst_null
    //   401: astore 6
    //   403: aload 4
    //   405: astore 7
    //   407: aload 6
    //   409: astore 5
    //   411: aload 7
    //   413: astore 4
    //   415: ldc 10
    //   417: new 78	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 464
    //   427: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 8
    //   432: invokevirtual 465	java/lang/Exception:toString	()Ljava/lang/String;
    //   435: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 286
    //   441: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 8
    //   446: invokestatic 224	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   449: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: aload 6
    //   460: astore 5
    //   462: aload 7
    //   464: astore 4
    //   466: aload_1
    //   467: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   470: iconst_3
    //   471: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   474: aload 6
    //   476: astore 5
    //   478: aload 7
    //   480: astore 4
    //   482: aload_1
    //   483: new 192	com/tencent/moai/downloader/network/HttpError
    //   486: dup
    //   487: iconst_2
    //   488: aload 8
    //   490: invokevirtual 465	java/lang/Exception:toString	()Ljava/lang/String;
    //   493: invokespecial 397	com/tencent/moai/downloader/network/HttpError:<init>	(ILjava/lang/String;)V
    //   496: aload 7
    //   498: invokevirtual 453	com/tencent/moai/downloader/network/HttpRequest:onError	(Lcom/tencent/moai/downloader/network/HttpError;Lcom/tencent/moai/downloader/network/HttpResponse;)V
    //   501: aload_1
    //   502: aload 7
    //   504: aload 6
    //   506: invokevirtual 405	com/tencent/moai/downloader/network/HttpRequest:onComplete	(Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/tencent/moai/downloader/network/HttpError;)V
    //   509: return
    //   510: aload 7
    //   512: getstatic 468	com/tencent/moai/downloader/network/HttpMethod:HttpMethod_MULTIPART	Lcom/tencent/moai/downloader/network/HttpMethod;
    //   515: if_acmpne -325 -> 190
    //   518: aload_0
    //   519: aload_1
    //   520: invokespecial 470	com/tencent/moai/downloader/network/DefaultHttpClient:multiPartParams	(Lcom/tencent/moai/downloader/network/HttpRequest;)Lcom/squareup/okhttp/RequestBody;
    //   523: astore 7
    //   525: aload 6
    //   527: aload_1
    //   528: invokevirtual 420	com/tencent/moai/downloader/network/HttpRequest:getRequestUrl	()Ljava/lang/String;
    //   531: invokevirtual 424	com/squareup/okhttp/Request$Builder:url	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   534: aload 7
    //   536: invokevirtual 462	com/squareup/okhttp/Request$Builder:post	(Lcom/squareup/okhttp/RequestBody;)Lcom/squareup/okhttp/Request$Builder;
    //   539: pop
    //   540: goto -350 -> 190
    //   543: astore 6
    //   545: aconst_null
    //   546: astore 5
    //   548: aload_1
    //   549: aload 4
    //   551: aload 5
    //   553: invokevirtual 405	com/tencent/moai/downloader/network/HttpRequest:onComplete	(Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/tencent/moai/downloader/network/HttpError;)V
    //   556: aload 6
    //   558: athrow
    //   559: aload_0
    //   560: getfield 23	com/tencent/moai/downloader/network/DefaultHttpClient:client	Lcom/squareup/okhttp/OkHttpClient;
    //   563: aload 6
    //   565: invokevirtual 474	com/squareup/okhttp/OkHttpClient:newCall	(Lcom/squareup/okhttp/Request;)Lcom/squareup/okhttp/Call;
    //   568: invokevirtual 480	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   571: astore 7
    //   573: aload 7
    //   575: invokevirtual 195	com/squareup/okhttp/Response:code	()I
    //   578: istore_2
    //   579: iload_2
    //   580: sipush 200
    //   583: if_icmplt +446 -> 1029
    //   586: iload_2
    //   587: sipush 300
    //   590: if_icmpge +439 -> 1029
    //   593: ldc 10
    //   595: new 78	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 482
    //   605: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: iload_3
    //   609: invokevirtual 485	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   612: ldc_w 487
    //   615: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: iload_2
    //   619: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 361	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: iload_3
    //   629: ifeq +230 -> 859
    //   632: aload_1
    //   633: aload 7
    //   635: invokevirtual 85	com/squareup/okhttp/Response:headers	()Lcom/squareup/okhttp/Headers;
    //   638: invokevirtual 91	com/squareup/okhttp/Headers:toMultimap	()Ljava/util/Map;
    //   641: invokevirtual 491	com/tencent/moai/downloader/network/HttpRequest:onReceiveHeader	(Ljava/util/Map;)Z
    //   644: ifeq +63 -> 707
    //   647: ldc 10
    //   649: ldc_w 493
    //   652: invokestatic 361	com/tencent/moai/downloader/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: aload_0
    //   656: aload_1
    //   657: aload 7
    //   659: invokespecial 495	com/tencent/moai/downloader/network/DefaultHttpClient:handleSuccess	(Lcom/tencent/moai/downloader/network/HttpRequest;Lcom/squareup/okhttp/Response;)Lcom/tencent/moai/downloader/network/HttpResponse;
    //   662: astore 6
    //   664: aload 6
    //   666: astore 4
    //   668: aload_0
    //   669: aload_1
    //   670: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   673: ifeq +11 -> 684
    //   676: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   679: dup
    //   680: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   683: athrow
    //   684: aload_1
    //   685: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   688: iconst_2
    //   689: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   692: aload_1
    //   693: aload 4
    //   695: invokevirtual 499	com/tencent/moai/downloader/network/HttpRequest:onSuccess	(Lcom/tencent/moai/downloader/network/HttpResponse;)V
    //   698: aload_1
    //   699: aload 4
    //   701: aload 5
    //   703: invokevirtual 405	com/tencent/moai/downloader/network/HttpRequest:onComplete	(Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/tencent/moai/downloader/network/HttpError;)V
    //   706: return
    //   707: ldc 10
    //   709: ldc_w 501
    //   712: invokestatic 218	com/tencent/moai/downloader/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: aload_0
    //   716: aload_1
    //   717: aload 4
    //   719: aload 6
    //   721: aload 7
    //   723: invokespecial 503	com/tencent/moai/downloader/network/DefaultHttpClient:handleError	(Lcom/tencent/moai/downloader/network/HttpRequest;Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/squareup/okhttp/Request;Lcom/squareup/okhttp/Response;)Lcom/tencent/moai/downloader/network/HttpError;
    //   726: astore 5
    //   728: aload 5
    //   730: astore 6
    //   732: aload 5
    //   734: astore 7
    //   736: aload 5
    //   738: astore 8
    //   740: aload 5
    //   742: astore 9
    //   744: aload 5
    //   746: bipush 6
    //   748: invokevirtual 506	com/tencent/moai/downloader/network/HttpError:setErrorCode	(I)V
    //   751: aload 5
    //   753: astore 6
    //   755: aload 5
    //   757: astore 7
    //   759: aload 5
    //   761: astore 8
    //   763: aload 5
    //   765: astore 9
    //   767: aload_0
    //   768: aload_1
    //   769: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   772: ifeq +27 -> 799
    //   775: aload 5
    //   777: astore 6
    //   779: aload 5
    //   781: astore 7
    //   783: aload 5
    //   785: astore 8
    //   787: aload 5
    //   789: astore 9
    //   791: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   794: dup
    //   795: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   798: athrow
    //   799: aload 5
    //   801: astore 6
    //   803: aload 5
    //   805: astore 7
    //   807: aload 5
    //   809: astore 8
    //   811: aload 5
    //   813: astore 9
    //   815: aload_1
    //   816: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   819: iconst_3
    //   820: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   823: aload 5
    //   825: astore 6
    //   827: aload 5
    //   829: astore 7
    //   831: aload 5
    //   833: astore 8
    //   835: aload 5
    //   837: astore 9
    //   839: aload_1
    //   840: aload 5
    //   842: aload 4
    //   844: invokevirtual 453	com/tencent/moai/downloader/network/HttpRequest:onError	(Lcom/tencent/moai/downloader/network/HttpError;Lcom/tencent/moai/downloader/network/HttpResponse;)V
    //   847: goto -149 -> 698
    //   850: astore 8
    //   852: aload 4
    //   854: astore 7
    //   856: goto -605 -> 251
    //   859: aload_0
    //   860: aload_1
    //   861: aload 4
    //   863: aload 6
    //   865: aload 7
    //   867: invokespecial 503	com/tencent/moai/downloader/network/DefaultHttpClient:handleError	(Lcom/tencent/moai/downloader/network/HttpRequest;Lcom/tencent/moai/downloader/network/HttpResponse;Lcom/squareup/okhttp/Request;Lcom/squareup/okhttp/Response;)Lcom/tencent/moai/downloader/network/HttpError;
    //   870: astore 5
    //   872: aload 5
    //   874: astore 6
    //   876: aload 5
    //   878: astore 7
    //   880: aload 5
    //   882: astore 8
    //   884: aload 5
    //   886: astore 9
    //   888: aload_0
    //   889: aload_1
    //   890: invokevirtual 99	com/tencent/moai/downloader/network/DefaultHttpClient:checkAbort	(Lcom/tencent/moai/downloader/network/HttpRequest;)Z
    //   893: ifeq +27 -> 920
    //   896: aload 5
    //   898: astore 6
    //   900: aload 5
    //   902: astore 7
    //   904: aload 5
    //   906: astore 8
    //   908: aload 5
    //   910: astore 9
    //   912: new 73	com/tencent/moai/downloader/exception/InterruptError
    //   915: dup
    //   916: invokespecial 100	com/tencent/moai/downloader/exception/InterruptError:<init>	()V
    //   919: athrow
    //   920: aload 5
    //   922: astore 6
    //   924: aload 5
    //   926: astore 7
    //   928: aload 5
    //   930: astore 8
    //   932: aload 5
    //   934: astore 9
    //   936: aload_1
    //   937: invokevirtual 371	com/tencent/moai/downloader/network/HttpRequest:getRequestStatus	()Lcom/tencent/moai/downloader/network/HttpStatus;
    //   940: iconst_3
    //   941: invokevirtual 377	com/tencent/moai/downloader/network/HttpStatus:setStatus	(I)V
    //   944: aload 5
    //   946: astore 6
    //   948: aload 5
    //   950: astore 7
    //   952: aload 5
    //   954: astore 8
    //   956: aload 5
    //   958: astore 9
    //   960: aload_1
    //   961: aload 5
    //   963: aload 4
    //   965: invokevirtual 453	com/tencent/moai/downloader/network/HttpRequest:onError	(Lcom/tencent/moai/downloader/network/HttpError;Lcom/tencent/moai/downloader/network/HttpResponse;)V
    //   968: goto -270 -> 698
    //   971: astore 6
    //   973: aload 7
    //   975: astore 5
    //   977: goto -429 -> 548
    //   980: astore 6
    //   982: aconst_null
    //   983: astore 5
    //   985: goto -437 -> 548
    //   988: astore 6
    //   990: goto -442 -> 548
    //   993: astore 8
    //   995: aconst_null
    //   996: astore 6
    //   998: aload 4
    //   1000: astore 7
    //   1002: goto -595 -> 407
    //   1005: astore 8
    //   1007: aconst_null
    //   1008: astore 6
    //   1010: aload 4
    //   1012: astore 7
    //   1014: goto -763 -> 251
    //   1017: astore 8
    //   1019: aconst_null
    //   1020: astore 6
    //   1022: aload 4
    //   1024: astore 7
    //   1026: goto -974 -> 52
    //   1029: iconst_0
    //   1030: istore_3
    //   1031: goto -438 -> 593
    //   1034: astore 5
    //   1036: aload 8
    //   1038: astore 6
    //   1040: aload 5
    //   1042: astore 8
    //   1044: aload 4
    //   1046: astore 7
    //   1048: goto -996 -> 52
    //   1051: astore 8
    //   1053: aload 9
    //   1055: astore 6
    //   1057: aload 4
    //   1059: astore 7
    //   1061: goto -654 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1064	0	this	DefaultHttpClient
    //   0	1064	1	paramHttpRequest	HttpRequest
    //   578	41	2	i	int
    //   1	1030	3	bool	boolean
    //   9	1049	4	localObject1	Object
    //   12	972	5	localObject2	Object
    //   1034	7	5	localInterruptError1	InterruptError
    //   21	505	6	localObject3	Object
    //   543	21	6	localRequest	com.squareup.okhttp.Request
    //   662	285	6	localObject4	Object
    //   971	1	6	localObject5	Object
    //   980	1	6	localObject6	Object
    //   988	1	6	localObject7	Object
    //   996	60	6	localObject8	Object
    //   50	1010	7	localObject9	Object
    //   43	47	8	localInterruptError2	InterruptError
    //   242	47	8	localSSLException1	javax.net.ssl.SSLException
    //   398	91	8	localException1	Exception
    //   738	96	8	localObject10	Object
    //   850	1	8	localSSLException2	javax.net.ssl.SSLException
    //   882	73	8	localObject11	Object
    //   993	1	8	localException2	Exception
    //   1005	1	8	localSSLException3	javax.net.ssl.SSLException
    //   1017	20	8	localInterruptError3	InterruptError
    //   1042	1	8	localInterruptError4	InterruptError
    //   1051	1	8	localException3	Exception
    //   742	312	9	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   14	43	43	com/tencent/moai/downloader/exception/InterruptError
    //   151	190	43	com/tencent/moai/downloader/exception/InterruptError
    //   190	242	43	com/tencent/moai/downloader/exception/InterruptError
    //   365	395	43	com/tencent/moai/downloader/exception/InterruptError
    //   510	540	43	com/tencent/moai/downloader/exception/InterruptError
    //   559	579	43	com/tencent/moai/downloader/exception/InterruptError
    //   593	628	43	com/tencent/moai/downloader/exception/InterruptError
    //   632	664	43	com/tencent/moai/downloader/exception/InterruptError
    //   707	728	43	com/tencent/moai/downloader/exception/InterruptError
    //   859	872	43	com/tencent/moai/downloader/exception/InterruptError
    //   14	43	242	javax/net/ssl/SSLException
    //   151	190	242	javax/net/ssl/SSLException
    //   190	242	242	javax/net/ssl/SSLException
    //   365	395	242	javax/net/ssl/SSLException
    //   510	540	242	javax/net/ssl/SSLException
    //   559	579	242	javax/net/ssl/SSLException
    //   593	628	242	javax/net/ssl/SSLException
    //   632	664	242	javax/net/ssl/SSLException
    //   707	728	242	javax/net/ssl/SSLException
    //   859	872	242	javax/net/ssl/SSLException
    //   14	43	398	java/lang/Exception
    //   151	190	398	java/lang/Exception
    //   190	242	398	java/lang/Exception
    //   365	395	398	java/lang/Exception
    //   510	540	398	java/lang/Exception
    //   559	579	398	java/lang/Exception
    //   593	628	398	java/lang/Exception
    //   632	664	398	java/lang/Exception
    //   707	728	398	java/lang/Exception
    //   859	872	398	java/lang/Exception
    //   14	43	543	finally
    //   151	190	543	finally
    //   190	242	543	finally
    //   365	395	543	finally
    //   510	540	543	finally
    //   559	579	543	finally
    //   593	628	543	finally
    //   632	664	543	finally
    //   707	728	543	finally
    //   859	872	543	finally
    //   744	751	850	javax/net/ssl/SSLException
    //   767	775	850	javax/net/ssl/SSLException
    //   791	799	850	javax/net/ssl/SSLException
    //   815	823	850	javax/net/ssl/SSLException
    //   839	847	850	javax/net/ssl/SSLException
    //   888	896	850	javax/net/ssl/SSLException
    //   912	920	850	javax/net/ssl/SSLException
    //   936	944	850	javax/net/ssl/SSLException
    //   960	968	850	javax/net/ssl/SSLException
    //   744	751	971	finally
    //   767	775	971	finally
    //   791	799	971	finally
    //   815	823	971	finally
    //   839	847	971	finally
    //   888	896	971	finally
    //   912	920	971	finally
    //   936	944	971	finally
    //   960	968	971	finally
    //   668	684	980	finally
    //   684	698	980	finally
    //   60	103	988	finally
    //   111	119	988	finally
    //   127	142	988	finally
    //   259	315	988	finally
    //   323	331	988	finally
    //   339	356	988	finally
    //   415	458	988	finally
    //   466	474	988	finally
    //   482	501	988	finally
    //   668	684	993	java/lang/Exception
    //   684	698	993	java/lang/Exception
    //   668	684	1005	javax/net/ssl/SSLException
    //   684	698	1005	javax/net/ssl/SSLException
    //   668	684	1017	com/tencent/moai/downloader/exception/InterruptError
    //   684	698	1017	com/tencent/moai/downloader/exception/InterruptError
    //   744	751	1034	com/tencent/moai/downloader/exception/InterruptError
    //   767	775	1034	com/tencent/moai/downloader/exception/InterruptError
    //   791	799	1034	com/tencent/moai/downloader/exception/InterruptError
    //   815	823	1034	com/tencent/moai/downloader/exception/InterruptError
    //   839	847	1034	com/tencent/moai/downloader/exception/InterruptError
    //   888	896	1034	com/tencent/moai/downloader/exception/InterruptError
    //   912	920	1034	com/tencent/moai/downloader/exception/InterruptError
    //   936	944	1034	com/tencent/moai/downloader/exception/InterruptError
    //   960	968	1034	com/tencent/moai/downloader/exception/InterruptError
    //   744	751	1051	java/lang/Exception
    //   767	775	1051	java/lang/Exception
    //   791	799	1051	java/lang/Exception
    //   815	823	1051	java/lang/Exception
    //   839	847	1051	java/lang/Exception
    //   888	896	1051	java/lang/Exception
    //   912	920	1051	java/lang/Exception
    //   936	944	1051	java/lang/Exception
    //   960	968	1051	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.DefaultHttpClient
 * JD-Core Version:    0.7.0.1
 */