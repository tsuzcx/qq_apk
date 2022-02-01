package com.tencent.moai.mailsdk.net.http;

import android.os.Build.VERSION;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.net.MailSSLUtil;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.protocol.activesync.request.ActiveSyncRequest;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.protocol.exchange.request.ExchangeRequest;
import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;

public class HttpClient
{
  private static final int CONNECT_TIME_OUT = 32000;
  private static final int READ_TIME_OUT = 50000;
  private static final int RECEIVE_BUFF_LEN_INTEGER = 32768;
  private static final int SEND_BUFF_LEN_INTEGER = 32768;
  private static final String TAG = "HttpClient";
  
  private static HashMap<String, String> buildHeader(ActiveSyncRequest paramActiveSyncRequest)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept", "*/*");
    String str = paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncName() + ":" + paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncPassword();
    localHashMap.put("Authorization", "Basic " + new String(BASE64EncoderStream.encode(ASCIIUtility.getBytes(str))));
    str = paramActiveSyncRequest.getCmdType();
    if (!"Options".equals(str))
    {
      localHashMap.put("MS-ASProtocolVersion", paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncVersion());
      if ((!"Provision".equals(str)) && (paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncPolicyKey() != null)) {
        localHashMap.put("X-MS-PolicyKey", paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncPolicyKey());
      }
      if ((!"SendMail".equals(str)) || (!"12.1".equals(paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncVersion()))) {
        break label190;
      }
      paramActiveSyncRequest = "message/rfc822";
    }
    for (;;)
    {
      localHashMap.put("Content-Type", paramActiveSyncRequest);
      return localHashMap;
      label190:
      if ("Options".equals(str)) {
        paramActiveSyncRequest = "application/x-www-form-urlencoded";
      } else {
        paramActiveSyncRequest = "application/vnd.ms-sync.wbxml";
      }
    }
  }
  
  private static HashMap<String, String> buildHeader(ExchangeRequest paramExchangeRequest)
  {
    HashMap localHashMap = new HashMap();
    String str = paramExchangeRequest.getCmdType();
    localHashMap.put("Content-Type", "text/xml; charset=utf-8");
    paramExchangeRequest = paramExchangeRequest.getExchangeInfo().getExchangeName() + ":" + paramExchangeRequest.getExchangeInfo().getExchangePassword();
    localHashMap.put("Authorization", "Basic " + new String(BASE64EncoderStream.encode(ASCIIUtility.getBytes(paramExchangeRequest))));
    localHashMap.put("SOAPAction", "\"http://schemas.microsoft.com/exchange/services/2006/messages/" + str + "\"");
    return localHashMap;
  }
  
  private static String buildMethod(ActiveSyncRequest paramActiveSyncRequest)
  {
    if (paramActiveSyncRequest.getCmdType() == "Options") {
      return "OPTIONS";
    }
    return "POST";
  }
  
  private static String buildMethod(ExchangeRequest paramExchangeRequest)
  {
    return "POST";
  }
  
  private static String buildRedirectUrl(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new URL(paramString2);
      paramString1 = new URL(paramString1);
      if (paramString2.getHost().equals(paramString1.getHost())) {
        return null;
      }
      paramString1 = paramString1.getProtocol() + "://" + paramString2.getHost() + ":" + paramString1.getPort() + paramString1.getPath() + "?" + paramString1.getQuery();
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static HttpRequest buildRequest(ActiveSyncRequest paramActiveSyncRequest)
    throws MessageException
  {
    HttpRequest localHttpRequest = new HttpRequest();
    localHttpRequest.setUrl(buildUrl(paramActiveSyncRequest));
    localHttpRequest.setMethod(buildMethod(paramActiveSyncRequest));
    localHttpRequest.setHeader(buildHeader(paramActiveSyncRequest));
    localHttpRequest.setContent(paramActiveSyncRequest.buildCmdData());
    return localHttpRequest;
  }
  
  public static HttpRequest buildRequest(ExchangeRequest paramExchangeRequest)
    throws MessageException
  {
    HttpRequest localHttpRequest = new HttpRequest();
    localHttpRequest.setUrl(buildUrl(paramExchangeRequest));
    localHttpRequest.setMethod(buildMethod(paramExchangeRequest));
    localHttpRequest.setHeader(buildHeader(paramExchangeRequest));
    localHttpRequest.setContent(paramExchangeRequest.buildCmdData());
    return localHttpRequest;
  }
  
  public static HttpRequest buildStreamRequest(ActiveSyncRequest paramActiveSyncRequest)
    throws MessageException
  {
    HttpRequest localHttpRequest = new HttpRequest();
    localHttpRequest.setUrl(buildUrl(paramActiveSyncRequest));
    localHttpRequest.setMethod(buildMethod(paramActiveSyncRequest));
    localHttpRequest.setHeader(buildHeader(paramActiveSyncRequest));
    localHttpRequest.setRequestStream(true);
    localHttpRequest.setRequestDataFile(paramActiveSyncRequest.buildCmdDataFile());
    return localHttpRequest;
  }
  
  public static HttpRequest buildStreamRequest(ExchangeRequest paramExchangeRequest)
    throws MessageException
  {
    HttpRequest localHttpRequest = new HttpRequest();
    localHttpRequest.setUrl(buildUrl(paramExchangeRequest));
    localHttpRequest.setMethod(buildMethod(paramExchangeRequest));
    localHttpRequest.setHeader(buildHeader(paramExchangeRequest));
    localHttpRequest.setRequestStream(true);
    localHttpRequest.setRequestDataFile(paramExchangeRequest.buildCmdDataFile());
    return localHttpRequest;
  }
  
  private static String buildUrl(ActiveSyncRequest paramActiveSyncRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramActiveSyncRequest.getActiveSyncInfo().isActiveSyncUsingSSL())
    {
      localStringBuilder.append("https://").append(paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncServer()).append(":443");
      if (!"Options".equals(paramActiveSyncRequest.getCmdType())) {
        break label123;
      }
      localStringBuilder.append("/Microsoft-Server-ActiveSync");
    }
    for (;;)
    {
      if (("SendMail".equals(paramActiveSyncRequest.getCmdType())) && ("12.1".equals(paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncVersion()))) {
        localStringBuilder.append("&SaveInSent=T");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("http://").append(paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncServer()).append(":80");
      break;
      label123:
      localStringBuilder.append("/Microsoft-Server-ActiveSync?");
      localStringBuilder.append("User=").append(paramActiveSyncRequest.getActiveSyncInfo().getActiveSyncName());
      localStringBuilder.append("&DeviceId=").append(paramActiveSyncRequest.getActiveSyncInfo().getDeviceId());
      localStringBuilder.append("&DeviceType=").append(paramActiveSyncRequest.getActiveSyncInfo().getDeviceType());
      localStringBuilder.append("&Cmd=").append(paramActiveSyncRequest.getCmdType());
    }
  }
  
  private static String buildUrl(ExchangeRequest paramExchangeRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramExchangeRequest.getExchangeInfo().isExchangeUsingSSL()) {
      localStringBuilder.append("https://").append(paramExchangeRequest.getExchangeInfo().getExchangeServer()).append(":443");
    }
    for (;;)
    {
      localStringBuilder.append("/EWS/Exchange.asmx");
      return localStringBuilder.toString();
      localStringBuilder.append("http://").append(paramExchangeRequest.getExchangeInfo().getExchangeServer()).append(":80");
    }
  }
  
  public static HttpResponse fetchResponse(HttpRequest paramHttpRequest)
  {
    return send(paramHttpRequest, null, false);
  }
  
  public static HttpResponse fetchResponse(HttpRequest paramHttpRequest, HttpCallBack paramHttpCallBack)
  {
    return send(paramHttpRequest, paramHttpCallBack, false);
  }
  
  public static HttpResponse fetchStreamResponse(HttpRequest paramHttpRequest)
  {
    return send(paramHttpRequest, null, true);
  }
  
  public static HttpResponse fetchStreamResponse(HttpRequest paramHttpRequest, HttpCallBack paramHttpCallBack)
  {
    return send(paramHttpRequest, paramHttpCallBack, true);
  }
  
  private static HttpResponse handleException(int paramInt, Exception paramException)
  {
    HttpResponse localHttpResponse = new HttpResponse();
    localHttpResponse.setCode(paramInt);
    localHttpResponse.setHeader(new HashMap());
    localHttpResponse.setContent(paramException.getMessage().getBytes());
    localHttpResponse.setResponseStream(false);
    localHttpResponse.setResponseInputStream(null);
    return localHttpResponse;
  }
  
  private static HttpResponse handleRedirect(HttpRequest paramHttpRequest, int paramInt, HttpURLConnection paramHttpURLConnection, boolean paramBoolean1, boolean paramBoolean2, HttpCallBack paramHttpCallBack)
    throws IOException
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.isEmpty())) {
      throw new IOException("redirect url null");
    }
    paramHttpURLConnection = (List)paramHttpURLConnection.get("X-MS-Location");
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.isEmpty())) {
      throw new IOException("redirect url null");
    }
    paramHttpURLConnection = (String)paramHttpURLConnection.get(0);
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.equals(""))) {
      throw new IOException("redirect url null");
    }
    paramHttpURLConnection = buildRedirectUrl(paramHttpRequest.getUrl(), paramHttpURLConnection);
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.equals(""))) {
      throw new IOException("redirect url null");
    }
    paramHttpRequest.setUrl(paramHttpURLConnection);
    return send(paramHttpRequest, paramHttpCallBack, paramBoolean1);
  }
  
  private static HttpResponse handleResponse(HttpRequest paramHttpRequest, int paramInt, HttpURLConnection paramHttpURLConnection, boolean paramBoolean1, boolean paramBoolean2, HttpCallBack paramHttpCallBack)
    throws IOException
  {
    HttpResponse localHttpResponse = new HttpResponse();
    localHttpResponse.setCode(paramInt);
    localHttpResponse.setHeader(paramHttpURLConnection.getHeaderFields());
    int j = paramHttpURLConnection.getContentLength();
    if (paramBoolean2)
    {
      paramHttpRequest = paramHttpURLConnection.getErrorStream();
      paramHttpURLConnection = paramHttpURLConnection.getContentEncoding();
      if ((paramHttpRequest == null) || (paramHttpURLConnection == null)) {
        break label270;
      }
      if (!"gzip".equals(paramHttpURLConnection)) {
        break label99;
      }
      paramHttpRequest = new GZIPInputStream(paramHttpRequest);
    }
    label99:
    label227:
    label251:
    for (;;)
    {
      if (paramBoolean1)
      {
        localHttpResponse.setResponseStream(true);
        localHttpResponse.setResponseInputStream(paramHttpRequest);
        return localHttpResponse;
        paramHttpRequest = paramHttpURLConnection.getInputStream();
        break;
        if (!"deflate".equals(paramHttpURLConnection)) {
          break label270;
        }
        paramHttpRequest = new InflaterInputStream(paramHttpRequest, new Inflater(true));
        continue;
      }
      localHttpResponse.setResponseStream(false);
      localHttpResponse.setResponseInputStream(null);
      paramHttpURLConnection = new ByteArrayOutputStream();
      paramInt = 0;
      byte[] arrayOfByte = new byte[32768];
      if (paramHttpRequest != null) {
        try
        {
          for (;;)
          {
            int k = paramHttpRequest.read(arrayOfByte);
            if (k == -1) {
              break;
            }
            int i = paramInt + k;
            paramHttpURLConnection.write(arrayOfByte, 0, k);
            paramInt = i;
            if (paramHttpCallBack != null)
            {
              paramHttpCallBack.onReceive(i, j);
              paramInt = i;
            }
          }
          try
          {
            paramHttpRequest.close();
          }
          catch (Exception paramHttpRequest)
          {
            try
            {
              for (;;)
              {
                paramHttpURLConnection.close();
                throw paramHttpCallBack;
                paramHttpURLConnection.flush();
                localHttpResponse.setContent(paramHttpURLConnection.toByteArray());
                try
                {
                  paramHttpRequest.close();
                }
                catch (Exception paramHttpRequest)
                {
                  try
                  {
                    for (;;)
                    {
                      paramHttpURLConnection.close();
                      return localHttpResponse;
                      paramHttpRequest = paramHttpRequest;
                    }
                  }
                  catch (Exception paramHttpRequest)
                  {
                    break label251;
                  }
                }
                paramHttpRequest = paramHttpRequest;
              }
            }
            catch (Exception paramHttpRequest)
            {
              break label227;
            }
          }
        }
        finally {}
      }
    }
  }
  
  /* Error */
  private static HttpResponse send(HttpRequest paramHttpRequest, HttpCallBack paramHttpCallBack, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: iconst_1
    //   10: istore_3
    //   11: aload_0
    //   12: invokevirtual 344	com/tencent/moai/mailsdk/net/http/HttpRequest:getUrl	()Ljava/lang/String;
    //   15: astore 6
    //   17: aload_1
    //   18: ifnull +10 -> 28
    //   21: aload_1
    //   22: aload_0
    //   23: invokeinterface 410 2 0
    //   28: new 155	java/net/URL
    //   31: dup
    //   32: aload 6
    //   34: invokespecial 158	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: invokevirtual 414	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   40: checkcast 315	java/net/HttpURLConnection
    //   43: astore 6
    //   45: aload 6
    //   47: astore 8
    //   49: aload 5
    //   51: astore 7
    //   53: aload 6
    //   55: aload_0
    //   56: invokestatic 418	com/tencent/moai/mailsdk/net/http/HttpClient:setProperty	(Ljava/net/HttpURLConnection;Lcom/tencent/moai/mailsdk/net/http/HttpRequest;)V
    //   59: aload 6
    //   61: astore 8
    //   63: aload 5
    //   65: astore 7
    //   67: aload 6
    //   69: aload_0
    //   70: invokestatic 421	com/tencent/moai/mailsdk/net/http/HttpClient:setUserHeader	(Ljava/net/HttpURLConnection;Lcom/tencent/moai/mailsdk/net/http/HttpRequest;)V
    //   73: aload 6
    //   75: astore 8
    //   77: aload 5
    //   79: astore 7
    //   81: aload 6
    //   83: invokevirtual 424	java/net/HttpURLConnection:connect	()V
    //   86: aload 6
    //   88: astore 8
    //   90: aload 5
    //   92: astore 7
    //   94: aload_0
    //   95: invokevirtual 427	com/tencent/moai/mailsdk/net/http/HttpRequest:getMethod	()Ljava/lang/String;
    //   98: ldc 148
    //   100: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +18 -> 121
    //   106: aload 6
    //   108: astore 8
    //   110: aload 5
    //   112: astore 7
    //   114: aload 6
    //   116: aload_0
    //   117: aload_1
    //   118: invokestatic 431	com/tencent/moai/mailsdk/net/http/HttpClient:writePostParams	(Ljava/net/HttpURLConnection;Lcom/tencent/moai/mailsdk/net/http/HttpRequest;Lcom/tencent/moai/mailsdk/net/http/HttpCallBack;)V
    //   121: aload 6
    //   123: astore 8
    //   125: aload 5
    //   127: astore 7
    //   129: aload 6
    //   131: invokevirtual 434	java/net/HttpURLConnection:getResponseCode	()I
    //   134: istore 4
    //   136: iload 4
    //   138: sipush 200
    //   141: if_icmplt +103 -> 244
    //   144: iload 4
    //   146: sipush 300
    //   149: if_icmpge +95 -> 244
    //   152: iload_3
    //   153: ifeq +96 -> 249
    //   156: aload 6
    //   158: astore 8
    //   160: aload 5
    //   162: astore 7
    //   164: aload_0
    //   165: iload 4
    //   167: aload 6
    //   169: iload_2
    //   170: iconst_0
    //   171: aload_1
    //   172: invokestatic 436	com/tencent/moai/mailsdk/net/http/HttpClient:handleResponse	(Lcom/tencent/moai/mailsdk/net/http/HttpRequest;ILjava/net/HttpURLConnection;ZZLcom/tencent/moai/mailsdk/net/http/HttpCallBack;)Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   175: astore 5
    //   177: aload 5
    //   179: astore 7
    //   181: aload_1
    //   182: ifnull +157 -> 339
    //   185: aload 5
    //   187: astore 7
    //   189: aload 6
    //   191: astore 8
    //   193: aload 5
    //   195: astore 10
    //   197: aload 5
    //   199: astore 9
    //   201: aload_1
    //   202: aload_0
    //   203: aload 5
    //   205: invokeinterface 440 3 0
    //   210: aload 6
    //   212: ifnull +8 -> 220
    //   215: aload 6
    //   217: invokevirtual 443	java/net/HttpURLConnection:disconnect	()V
    //   220: aload 5
    //   222: astore 6
    //   224: aload_1
    //   225: ifnull +16 -> 241
    //   228: aload_1
    //   229: aload_0
    //   230: aload 5
    //   232: invokeinterface 446 3 0
    //   237: aload 5
    //   239: astore 6
    //   241: aload 6
    //   243: areturn
    //   244: iconst_0
    //   245: istore_3
    //   246: goto -94 -> 152
    //   249: iload 4
    //   251: sipush 451
    //   254: if_icmpne +27 -> 281
    //   257: aload 6
    //   259: astore 8
    //   261: aload 5
    //   263: astore 7
    //   265: aload_0
    //   266: iload 4
    //   268: aload 6
    //   270: iload_2
    //   271: iconst_1
    //   272: aload_1
    //   273: invokestatic 448	com/tencent/moai/mailsdk/net/http/HttpClient:handleRedirect	(Lcom/tencent/moai/mailsdk/net/http/HttpRequest;ILjava/net/HttpURLConnection;ZZLcom/tencent/moai/mailsdk/net/http/HttpCallBack;)Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   276: astore 5
    //   278: goto -68 -> 210
    //   281: aload 6
    //   283: astore 8
    //   285: aload 5
    //   287: astore 7
    //   289: aload_0
    //   290: iload 4
    //   292: aload 6
    //   294: iload_2
    //   295: iconst_1
    //   296: aload_1
    //   297: invokestatic 436	com/tencent/moai/mailsdk/net/http/HttpClient:handleResponse	(Lcom/tencent/moai/mailsdk/net/http/HttpRequest;ILjava/net/HttpURLConnection;ZZLcom/tencent/moai/mailsdk/net/http/HttpCallBack;)Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   300: astore 5
    //   302: aload 5
    //   304: astore 7
    //   306: aload_1
    //   307: ifnull +32 -> 339
    //   310: aload 5
    //   312: astore 7
    //   314: aload 6
    //   316: astore 8
    //   318: aload 5
    //   320: astore 10
    //   322: aload 5
    //   324: astore 9
    //   326: aload_1
    //   327: aload_0
    //   328: aload 5
    //   330: invokeinterface 451 3 0
    //   335: aload 5
    //   337: astore 7
    //   339: aload 7
    //   341: astore 5
    //   343: goto -133 -> 210
    //   346: astore 10
    //   348: aconst_null
    //   349: astore 5
    //   351: aconst_null
    //   352: astore 6
    //   354: aload 5
    //   356: astore 7
    //   358: aload 6
    //   360: astore 8
    //   362: bipush 6
    //   364: ldc 16
    //   366: aload 10
    //   368: invokestatic 457	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   371: invokestatic 463	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   374: sipush 1001
    //   377: istore_3
    //   378: aload 5
    //   380: astore 7
    //   382: aload 6
    //   384: astore 8
    //   386: aload 10
    //   388: instanceof 465
    //   391: ifeq +7 -> 398
    //   394: sipush 1002
    //   397: istore_3
    //   398: aload 5
    //   400: astore 7
    //   402: aload 6
    //   404: astore 8
    //   406: iload_3
    //   407: aload 10
    //   409: invokestatic 467	com/tencent/moai/mailsdk/net/http/HttpClient:handleException	(ILjava/lang/Exception;)Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   412: astore 5
    //   414: aload 5
    //   416: astore 8
    //   418: aload_1
    //   419: ifnull +20 -> 439
    //   422: aload 8
    //   424: astore 5
    //   426: aload 6
    //   428: astore 7
    //   430: aload_1
    //   431: aload_0
    //   432: aload 8
    //   434: invokeinterface 451 3 0
    //   439: aload 6
    //   441: ifnull +8 -> 449
    //   444: aload 6
    //   446: invokevirtual 443	java/net/HttpURLConnection:disconnect	()V
    //   449: aload 8
    //   451: astore 6
    //   453: aload_1
    //   454: ifnull -213 -> 241
    //   457: aload_1
    //   458: aload_0
    //   459: aload 8
    //   461: invokeinterface 446 3 0
    //   466: aload 8
    //   468: areturn
    //   469: astore 5
    //   471: aconst_null
    //   472: astore 6
    //   474: aload 6
    //   476: astore 8
    //   478: aload 9
    //   480: astore 7
    //   482: bipush 6
    //   484: ldc 16
    //   486: aload 5
    //   488: invokestatic 457	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   491: invokestatic 463	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   494: aload 6
    //   496: astore 8
    //   498: aload 9
    //   500: astore 7
    //   502: sipush 1000
    //   505: aload 5
    //   507: invokestatic 467	com/tencent/moai/mailsdk/net/http/HttpClient:handleException	(ILjava/lang/Exception;)Lcom/tencent/moai/mailsdk/net/http/HttpResponse;
    //   510: astore 5
    //   512: aload 5
    //   514: astore 8
    //   516: aload_1
    //   517: ifnull +20 -> 537
    //   520: aload 8
    //   522: astore 5
    //   524: aload 6
    //   526: astore 7
    //   528: aload_1
    //   529: aload_0
    //   530: aload 8
    //   532: invokeinterface 451 3 0
    //   537: aload 6
    //   539: ifnull +8 -> 547
    //   542: aload 6
    //   544: invokevirtual 443	java/net/HttpURLConnection:disconnect	()V
    //   547: aload 8
    //   549: astore 6
    //   551: aload_1
    //   552: ifnull -311 -> 241
    //   555: aload_1
    //   556: aload_0
    //   557: aload 8
    //   559: invokeinterface 446 3 0
    //   564: aload 8
    //   566: areturn
    //   567: astore 5
    //   569: aconst_null
    //   570: astore 6
    //   572: aload 6
    //   574: ifnull +8 -> 582
    //   577: aload 6
    //   579: invokevirtual 443	java/net/HttpURLConnection:disconnect	()V
    //   582: aload_1
    //   583: ifnull +12 -> 595
    //   586: aload_1
    //   587: aload_0
    //   588: aload 7
    //   590: invokeinterface 446 3 0
    //   595: aload 5
    //   597: athrow
    //   598: astore 6
    //   600: goto -380 -> 220
    //   603: astore 5
    //   605: goto -156 -> 449
    //   608: astore 5
    //   610: goto -63 -> 547
    //   613: astore 6
    //   615: goto -33 -> 582
    //   618: astore 5
    //   620: aload 8
    //   622: astore 6
    //   624: goto -52 -> 572
    //   627: astore 5
    //   629: aload 8
    //   631: astore 6
    //   633: goto -61 -> 572
    //   636: astore 6
    //   638: aload 5
    //   640: astore 8
    //   642: aload 6
    //   644: astore 5
    //   646: aload 7
    //   648: astore 6
    //   650: aload 8
    //   652: astore 7
    //   654: goto -82 -> 572
    //   657: astore 5
    //   659: goto -185 -> 474
    //   662: astore 5
    //   664: aload 10
    //   666: astore 9
    //   668: goto -194 -> 474
    //   671: astore 10
    //   673: aconst_null
    //   674: astore 5
    //   676: goto -322 -> 354
    //   679: astore 10
    //   681: aload 9
    //   683: astore 5
    //   685: goto -331 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramHttpRequest	HttpRequest
    //   0	688	1	paramHttpCallBack	HttpCallBack
    //   0	688	2	paramBoolean	boolean
    //   10	397	3	i	int
    //   134	157	4	j	int
    //   4	421	5	localObject1	Object
    //   469	37	5	localException1	Exception
    //   510	13	5	localObject2	Object
    //   567	29	5	localObject3	Object
    //   603	1	5	localException2	Exception
    //   608	1	5	localException3	Exception
    //   618	1	5	localObject4	Object
    //   627	12	5	localObject5	Object
    //   644	1	5	localObject6	Object
    //   657	1	5	localException4	Exception
    //   662	1	5	localException5	Exception
    //   674	10	5	localObject7	Object
    //   15	563	6	localObject8	Object
    //   598	1	6	localException6	Exception
    //   613	1	6	localException7	Exception
    //   622	10	6	localObject9	Object
    //   636	7	6	localObject10	Object
    //   648	1	6	localObject11	Object
    //   1	652	7	localObject12	Object
    //   47	604	8	localObject13	Object
    //   7	675	9	localObject14	Object
    //   195	126	10	localObject15	Object
    //   346	319	10	localIOException1	IOException
    //   671	1	10	localIOException2	IOException
    //   679	1	10	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   21	28	346	java/io/IOException
    //   28	45	346	java/io/IOException
    //   21	28	469	java/lang/Exception
    //   28	45	469	java/lang/Exception
    //   21	28	567	finally
    //   28	45	567	finally
    //   215	220	598	java/lang/Exception
    //   444	449	603	java/lang/Exception
    //   542	547	608	java/lang/Exception
    //   577	582	613	java/lang/Exception
    //   53	59	618	finally
    //   67	73	618	finally
    //   81	86	618	finally
    //   94	106	618	finally
    //   114	121	618	finally
    //   129	136	618	finally
    //   164	177	618	finally
    //   265	278	618	finally
    //   289	302	618	finally
    //   482	494	618	finally
    //   502	512	618	finally
    //   201	210	627	finally
    //   326	335	627	finally
    //   362	374	627	finally
    //   386	394	627	finally
    //   406	414	627	finally
    //   430	439	636	finally
    //   528	537	636	finally
    //   53	59	657	java/lang/Exception
    //   67	73	657	java/lang/Exception
    //   81	86	657	java/lang/Exception
    //   94	106	657	java/lang/Exception
    //   114	121	657	java/lang/Exception
    //   129	136	657	java/lang/Exception
    //   164	177	657	java/lang/Exception
    //   265	278	657	java/lang/Exception
    //   289	302	657	java/lang/Exception
    //   201	210	662	java/lang/Exception
    //   326	335	662	java/lang/Exception
    //   53	59	671	java/io/IOException
    //   67	73	671	java/io/IOException
    //   81	86	671	java/io/IOException
    //   94	106	671	java/io/IOException
    //   114	121	671	java/io/IOException
    //   129	136	671	java/io/IOException
    //   164	177	671	java/io/IOException
    //   265	278	671	java/io/IOException
    //   289	302	671	java/io/IOException
    //   201	210	679	java/io/IOException
    //   326	335	679	java/io/IOException
  }
  
  private static void setProperty(HttpURLConnection paramHttpURLConnection, HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpURLConnection.setConnectTimeout(32000);
    paramHttpURLConnection.setReadTimeout(50000);
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    if (Build.VERSION.SDK_INT > 13) {
      paramHttpURLConnection.setRequestProperty("Connection", "close");
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
      paramHttpURLConnection.setUseCaches(false);
      String str = paramHttpRequest.getMethod();
      if (str.equals("POST"))
      {
        paramHttpURLConnection.setRequestMethod(str);
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setFixedLengthStreamingMode(paramHttpRequest.getContentLength());
        if (!(paramHttpURLConnection instanceof HttpsURLConnection)) {}
      }
      try
      {
        ((HttpsURLConnection)paramHttpURLConnection).setSSLSocketFactory(MailSSLUtil.getDelegateSSLSocketFactory());
        ((HttpsURLConnection)paramHttpURLConnection).setHostnameVerifier(new HttpClient.1());
        return;
        paramHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        continue;
        paramHttpURLConnection.setRequestMethod(str);
      }
      catch (GeneralSecurityException paramHttpRequest)
      {
        for (;;)
        {
          Logger.log(5, "HttpClient", "set ssl socketFactory error : " + paramHttpRequest.getMessage());
        }
      }
    }
  }
  
  private static void setUserHeader(HttpURLConnection paramHttpURLConnection, HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest = paramHttpRequest.getHeader();
    if ((paramHttpRequest == null) || (paramHttpRequest.isEmpty())) {}
    for (;;)
    {
      return;
      paramHttpRequest = paramHttpRequest.entrySet().iterator();
      while (paramHttpRequest.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHttpRequest.next();
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  /* Error */
  private static void writePostParams(HttpURLConnection paramHttpURLConnection, HttpRequest paramHttpRequest, HttpCallBack paramHttpCallBack)
    throws IOException
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: aload_0
    //   4: invokevirtual 568	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   7: astore_0
    //   8: aload_1
    //   9: invokevirtual 571	com/tencent/moai/mailsdk/net/http/HttpRequest:isRequestStream	()Z
    //   12: ifeq +111 -> 123
    //   15: aload_1
    //   16: invokevirtual 574	com/tencent/moai/mailsdk/net/http/HttpRequest:getRequestDataFile	()Ljava/io/File;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +8 -> 29
    //   24: aload_0
    //   25: invokevirtual 577	java/io/OutputStream:close	()V
    //   28: return
    //   29: new 579	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 581	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore_1
    //   38: sipush 1024
    //   41: newarray byte
    //   43: astore 11
    //   45: aload_1
    //   46: invokevirtual 584	java/io/InputStream:available	()I
    //   49: istore_3
    //   50: aload_1
    //   51: aload 11
    //   53: invokevirtual 386	java/io/InputStream:read	([B)I
    //   56: istore 4
    //   58: iload 4
    //   60: ifle +52 -> 112
    //   63: aload_0
    //   64: aload 11
    //   66: iconst_0
    //   67: iload 4
    //   69: invokevirtual 585	java/io/OutputStream:write	([BII)V
    //   72: lload 7
    //   74: iload 4
    //   76: i2l
    //   77: ladd
    //   78: lstore 9
    //   80: lload 9
    //   82: lstore 7
    //   84: aload_2
    //   85: ifnull -35 -> 50
    //   88: aload_2
    //   89: lload 9
    //   91: iload_3
    //   92: i2l
    //   93: invokeinterface 588 5 0
    //   98: lload 9
    //   100: lstore 7
    //   102: goto -52 -> 50
    //   105: astore_1
    //   106: aload_0
    //   107: invokevirtual 577	java/io/OutputStream:close	()V
    //   110: aload_1
    //   111: athrow
    //   112: aload_1
    //   113: invokevirtual 399	java/io/InputStream:close	()V
    //   116: aload_0
    //   117: invokevirtual 577	java/io/OutputStream:close	()V
    //   120: return
    //   121: astore_0
    //   122: return
    //   123: aload_1
    //   124: invokevirtual 591	com/tencent/moai/mailsdk/net/http/HttpRequest:getContent	()[B
    //   127: astore_1
    //   128: aload_1
    //   129: arraylength
    //   130: istore 5
    //   132: lconst_0
    //   133: lstore 7
    //   135: iconst_0
    //   136: istore 4
    //   138: goto +63 -> 201
    //   141: iload_3
    //   142: iload 4
    //   144: isub
    //   145: istore 6
    //   147: aload_0
    //   148: aload_1
    //   149: iload 4
    //   151: iload 6
    //   153: invokevirtual 585	java/io/OutputStream:write	([BII)V
    //   156: iload 6
    //   158: i2l
    //   159: lload 7
    //   161: ladd
    //   162: lstore 7
    //   164: aload_2
    //   165: ifnull +14 -> 179
    //   168: aload_2
    //   169: lload 7
    //   171: iload 5
    //   173: i2l
    //   174: invokeinterface 588 5 0
    //   179: iload_3
    //   180: istore 4
    //   182: goto +19 -> 201
    //   185: iload 5
    //   187: istore_3
    //   188: goto -47 -> 141
    //   191: astore_0
    //   192: return
    //   193: astore_1
    //   194: goto -78 -> 116
    //   197: astore_0
    //   198: goto -88 -> 110
    //   201: iload 4
    //   203: iload 5
    //   205: if_icmpge -89 -> 116
    //   208: ldc 11
    //   210: iload 4
    //   212: iadd
    //   213: istore_3
    //   214: iload_3
    //   215: iload 5
    //   217: if_icmpge -32 -> 185
    //   220: goto -79 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramHttpURLConnection	HttpURLConnection
    //   0	223	1	paramHttpRequest	HttpRequest
    //   0	223	2	paramHttpCallBack	HttpCallBack
    //   49	169	3	i	int
    //   56	157	4	j	int
    //   130	88	5	k	int
    //   145	12	6	m	int
    //   1	169	7	l1	long
    //   78	21	9	l2	long
    //   43	22	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	20	105	finally
    //   29	50	105	finally
    //   50	58	105	finally
    //   63	72	105	finally
    //   88	98	105	finally
    //   112	116	105	finally
    //   123	132	105	finally
    //   147	156	105	finally
    //   168	179	105	finally
    //   116	120	121	java/io/IOException
    //   24	28	191	java/io/IOException
    //   112	116	193	java/io/IOException
    //   106	110	197	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.net.http.HttpClient
 * JD-Core Version:    0.7.0.1
 */