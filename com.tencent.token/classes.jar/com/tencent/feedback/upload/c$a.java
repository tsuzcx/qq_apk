package com.tencent.feedback.upload;

import android.content.Context;
import android.net.Proxy;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.g;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class c$a
  extends c
{
  private Context a;
  
  public c$a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      this.a = paramContext;
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
  }
  
  /* Error */
  private HttpResponse a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnonnull +17 -> 21
    //   7: ldc 25
    //   9: iconst_0
    //   10: anewarray 27	java/lang/Object
    //   13: invokestatic 33	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   16: pop
    //   17: aconst_null
    //   18: astore_3
    //   19: aload_3
    //   20: areturn
    //   21: aload_2
    //   22: ifnull +36 -> 58
    //   25: new 35	org/apache/http/entity/ByteArrayEntity
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 38	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   33: astore_2
    //   34: aload_0
    //   35: aload_3
    //   36: invokespecial 41	com/tencent/feedback/upload/c$a:a	(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    //   39: astore 6
    //   41: aload 6
    //   43: ifnonnull +77 -> 120
    //   46: ldc 43
    //   48: iconst_0
    //   49: anewarray 27	java/lang/Object
    //   52: invokestatic 33	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: new 35	org/apache/http/entity/ByteArrayEntity
    //   61: dup
    //   62: ldc 45
    //   64: invokevirtual 51	java/lang/String:getBytes	()[B
    //   67: invokespecial 38	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   70: astore_2
    //   71: goto -37 -> 34
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_1
    //   77: aload 5
    //   79: astore_2
    //   80: aload_3
    //   81: invokestatic 54	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   84: ifne +7 -> 91
    //   87: aload_3
    //   88: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   91: ldc 59
    //   93: iconst_1
    //   94: anewarray 27	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_3
    //   100: invokevirtual 63	java/lang/Throwable:toString	()Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 33	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_1
    //   109: astore_3
    //   110: aload_2
    //   111: ifnull -92 -> 19
    //   114: aload_2
    //   115: invokevirtual 68	org/apache/http/client/methods/HttpPost:abort	()V
    //   118: aload_1
    //   119: areturn
    //   120: new 65	org/apache/http/client/methods/HttpPost
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 71	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   128: astore_1
    //   129: aload_1
    //   130: ldc 73
    //   132: ldc 75
    //   134: invokevirtual 79	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 83	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   142: aload 4
    //   144: ifnull +116 -> 260
    //   147: aload 4
    //   149: invokeinterface 89 1 0
    //   154: ifle +106 -> 260
    //   157: aload 4
    //   159: invokeinterface 93 1 0
    //   164: invokeinterface 99 1 0
    //   169: astore_2
    //   170: aload_2
    //   171: invokeinterface 105 1 0
    //   176: ifeq +41 -> 217
    //   179: aload_2
    //   180: invokeinterface 109 1 0
    //   185: checkcast 111	java/util/Map$Entry
    //   188: astore 4
    //   190: aload_1
    //   191: aload 4
    //   193: invokeinterface 114 1 0
    //   198: checkcast 47	java/lang/String
    //   201: aload 4
    //   203: invokeinterface 117 1 0
    //   208: checkcast 47	java/lang/String
    //   211: invokevirtual 79	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -44 -> 170
    //   217: aload_1
    //   218: ldc 119
    //   220: aload_3
    //   221: invokevirtual 79	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: new 121	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   231: astore_2
    //   232: aload_0
    //   233: getfield 13	com/tencent/feedback/upload/c$a:a	Landroid/content/Context;
    //   236: invokestatic 127	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   239: pop
    //   240: aload_1
    //   241: ldc 129
    //   243: aload_2
    //   244: aload_0
    //   245: getfield 13	com/tencent/feedback/upload/c$a:a	Landroid/content/Context;
    //   248: invokestatic 133	com/tencent/feedback/common/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   251: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 79	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: new 140	org/apache/http/protocol/BasicHttpContext
    //   263: dup
    //   264: invokespecial 141	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   267: astore_2
    //   268: aload 6
    //   270: aload_1
    //   271: aload_2
    //   272: invokeinterface 147 3 0
    //   277: astore 4
    //   279: ldc 149
    //   281: iconst_1
    //   282: anewarray 27	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload_2
    //   288: ldc 151
    //   290: invokeinterface 157 2 0
    //   295: checkcast 159	org/apache/http/HttpRequest
    //   298: invokeinterface 163 1 0
    //   303: invokevirtual 164	java/lang/Object:toString	()Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 167	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload_1
    //   312: invokevirtual 68	org/apache/http/client/methods/HttpPost:abort	()V
    //   315: aload 4
    //   317: areturn
    //   318: astore_2
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 68	org/apache/http/client/methods/HttpPost:abort	()V
    //   329: aload_2
    //   330: athrow
    //   331: astore_2
    //   332: goto -11 -> 321
    //   335: astore_3
    //   336: aload_2
    //   337: astore_1
    //   338: aload_3
    //   339: astore_2
    //   340: goto -19 -> 321
    //   343: astore_3
    //   344: aload_1
    //   345: astore_2
    //   346: aload 4
    //   348: astore_1
    //   349: goto -269 -> 80
    //   352: astore_3
    //   353: aconst_null
    //   354: astore 4
    //   356: aload_1
    //   357: astore_2
    //   358: aload 4
    //   360: astore_1
    //   361: goto -281 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	a
    //   0	364	1	paramString1	String
    //   0	364	2	paramArrayOfByte	byte[]
    //   0	364	3	paramString2	String
    //   0	364	4	paramMap	Map
    //   1	77	5	localObject	Object
    //   39	230	6	localHttpClient	HttpClient
    // Exception table:
    //   from	to	target	type
    //   25	34	74	java/lang/Throwable
    //   34	41	74	java/lang/Throwable
    //   46	56	74	java/lang/Throwable
    //   58	71	74	java/lang/Throwable
    //   120	129	74	java/lang/Throwable
    //   25	34	318	finally
    //   34	41	318	finally
    //   46	56	318	finally
    //   58	71	318	finally
    //   120	129	318	finally
    //   129	142	331	finally
    //   147	170	331	finally
    //   170	214	331	finally
    //   217	260	331	finally
    //   260	279	331	finally
    //   279	311	331	finally
    //   80	91	335	finally
    //   91	108	335	finally
    //   279	311	343	java/lang/Throwable
    //   129	142	352	java/lang/Throwable
    //   147	170	352	java/lang/Throwable
    //   170	214	352	java/lang/Throwable
    //   217	260	352	java/lang/Throwable
    //   260	279	352	java/lang/Throwable
  }
  
  private HttpClient a(String paramString)
  {
    try
    {
      Object localObject = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 10000);
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 2000);
      ((BasicHttpParams)localObject).setBooleanParameter("http.protocol.handle-redirects", false);
      localObject = new DefaultHttpClient((HttpParams)localObject);
      ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new c.a.1(this));
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")))
      {
        e.a("rqdp{  use proxy} %s", new Object[] { paramString });
        paramString = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        ((DefaultHttpClient)localObject).getParams().setParameter("http.route.default-proxy", paramString);
        return localObject;
      }
      ((DefaultHttpClient)localObject).getParams().removeParameter("http.route.default-proxy");
      return localObject;
    }
    catch (Throwable paramString)
    {
      if (!e.a(paramString)) {
        paramString.printStackTrace();
      }
      e.d("rqdp{  httpclient error!}", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  private static byte[] a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: aload_0
    //   13: invokeinterface 260 1 0
    //   18: invokeinterface 265 1 0
    //   23: istore_1
    //   24: iload_1
    //   25: sipush 200
    //   28: if_icmpeq +32 -> 60
    //   31: ldc_w 267
    //   34: iconst_2
    //   35: anewarray 27	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iload_1
    //   41: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_0
    //   48: invokeinterface 260 1 0
    //   53: aastore
    //   54: invokestatic 276	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aconst_null
    //   59: areturn
    //   60: aload_0
    //   61: invokeinterface 280 1 0
    //   66: astore_0
    //   67: aload_0
    //   68: ifnonnull +16 -> 84
    //   71: ldc_w 282
    //   74: iconst_0
    //   75: anewarray 27	java/lang/Object
    //   78: invokestatic 33	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   81: pop
    //   82: aconst_null
    //   83: areturn
    //   84: new 284	java/io/BufferedInputStream
    //   87: dup
    //   88: new 286	java/io/DataInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokeinterface 292 1 0
    //   98: invokespecial 295	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   101: invokespecial 296	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore_2
    //   105: aload_2
    //   106: astore_0
    //   107: new 298	java/io/ByteArrayOutputStream
    //   110: dup
    //   111: invokespecial 299	java/io/ByteArrayOutputStream:<init>	()V
    //   114: astore_3
    //   115: aload_2
    //   116: astore_0
    //   117: aload_2
    //   118: invokevirtual 302	java/io/BufferedInputStream:read	()I
    //   121: istore_1
    //   122: iload_1
    //   123: iconst_m1
    //   124: if_icmpeq +79 -> 203
    //   127: aload_2
    //   128: astore_0
    //   129: aload_3
    //   130: iload_1
    //   131: invokevirtual 306	java/io/ByteArrayOutputStream:write	(I)V
    //   134: goto -19 -> 115
    //   137: astore_3
    //   138: aload_2
    //   139: astore_0
    //   140: aload_3
    //   141: invokestatic 54	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   144: ifne +9 -> 153
    //   147: aload_2
    //   148: astore_0
    //   149: aload_3
    //   150: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   153: aload_2
    //   154: astore_0
    //   155: ldc_w 308
    //   158: iconst_1
    //   159: anewarray 27	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_3
    //   165: invokevirtual 63	java/lang/Throwable:toString	()Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 33	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload 4
    //   175: astore_0
    //   176: aload_2
    //   177: ifnull -167 -> 10
    //   180: aload_2
    //   181: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_2
    //   187: aload 4
    //   189: astore_0
    //   190: aload_2
    //   191: invokestatic 54	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   194: ifne -184 -> 10
    //   197: aload_2
    //   198: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   201: aconst_null
    //   202: areturn
    //   203: aload_2
    //   204: astore_0
    //   205: aload_3
    //   206: invokevirtual 314	java/io/ByteArrayOutputStream:flush	()V
    //   209: aload_2
    //   210: astore_0
    //   211: aload_3
    //   212: invokevirtual 317	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   215: astore_3
    //   216: aload_2
    //   217: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   220: aload_3
    //   221: areturn
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: aload_2
    //   226: invokestatic 54	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   229: ifne -219 -> 10
    //   232: aload_2
    //   233: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   236: aload_3
    //   237: areturn
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_0
    //   241: aload_0
    //   242: ifnull +7 -> 249
    //   245: aload_0
    //   246: invokevirtual 311	java/io/BufferedInputStream:close	()V
    //   249: aload_2
    //   250: athrow
    //   251: astore_0
    //   252: aload_0
    //   253: invokestatic 54	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   256: ifne -7 -> 249
    //   259: aload_0
    //   260: invokevirtual 57	java/lang/Throwable:printStackTrace	()V
    //   263: goto -14 -> 249
    //   266: astore_2
    //   267: goto -26 -> 241
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_2
    //   273: goto -135 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramHttpResponse	HttpResponse
    //   23	108	1	i	int
    //   104	77	2	localBufferedInputStream	java.io.BufferedInputStream
    //   186	31	2	localThrowable1	Throwable
    //   222	11	2	localThrowable2	Throwable
    //   238	12	2	localObject1	Object
    //   266	1	2	localObject2	Object
    //   272	1	2	localObject3	Object
    //   114	16	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   137	75	3	localThrowable3	Throwable
    //   215	22	3	arrayOfByte	byte[]
    //   270	1	3	localThrowable4	Throwable
    //   1	187	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   107	115	137	java/lang/Throwable
    //   117	122	137	java/lang/Throwable
    //   129	134	137	java/lang/Throwable
    //   205	209	137	java/lang/Throwable
    //   211	216	137	java/lang/Throwable
    //   180	184	186	java/lang/Throwable
    //   216	220	222	java/lang/Throwable
    //   84	105	238	finally
    //   245	249	251	java/lang/Throwable
    //   107	115	266	finally
    //   117	122	266	finally
    //   129	134	266	finally
    //   140	147	266	finally
    //   149	153	266	finally
    //   155	173	266	finally
    //   205	209	266	finally
    //   211	216	266	finally
    //   84	105	270	java/lang/Throwable
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte, b paramb, Map paramMap)
  {
    if (paramString == null)
    {
      e.d("rqdp{  no destUrl!}", new Object[0]);
      return null;
    }
    int j = 0;
    int i = 0;
    long l2;
    int k;
    int m;
    label81:
    HttpResponse localHttpResponse;
    int n;
    if (paramArrayOfByte == null)
    {
      l2 = 0L;
      e.b("rqdp{  start req} %s rqdp{  sz:}%d", new Object[] { paramString, Long.valueOf(l2) });
      k = 0;
      m = j + 1;
      if ((j >= 3) || (i >= 2)) {
        break label480;
      }
      if (k == 0) {
        break label184;
      }
      j = 0;
      Object localObject = g.c(this.a);
      if (paramb != null) {
        paramb.a(paramString, l2, (String)localObject);
      }
      localHttpResponse = a(paramString, paramArrayOfByte, (String)localObject, paramMap);
      if (localHttpResponse == null) {
        break label460;
      }
      localObject = localHttpResponse.getEntity();
      n = localHttpResponse.getStatusLine().getStatusCode();
      if (n != 200) {
        break label267;
      }
      paramString = a(localHttpResponse);
      if (paramb != null) {
        if (paramString != null) {
          break label259;
        }
      }
    }
    label259:
    for (long l1 = 0L;; l1 = paramString.length)
    {
      for (;;)
      {
        paramb.a(l1);
        return paramString;
        l2 = paramArrayOfByte.length;
        break;
        label184:
        j = k;
        if (m <= 1) {
          break label81;
        }
        e.b("rqdp{  try time} " + m, new Object[0]);
        try
        {
          Thread.sleep(10000L);
          j = k;
        }
        catch (InterruptedException localInterruptedException)
        {
          j = k;
        }
      }
      if (e.a(localInterruptedException)) {
        break label81;
      }
      localInterruptedException.printStackTrace();
      j = k;
      break label81;
    }
    label267:
    if ((n == 301) || (n == 302) || (n == 303) || (n == 307)) {
      k = 1;
    }
    while (k != 0)
    {
      k = 1;
      paramString = localHttpResponse.getFirstHeader("Location");
      if (paramString == null)
      {
        e.d("rqdp{  redirect code:}" + n + "rqdp{   Location is null! return}", new Object[0]);
        return null;
        k = 0;
      }
      else
      {
        j = i + 1;
        i = 0;
        paramString = paramString.getValue();
        e.b("rqdp{  redirect code:}%d rqdp{  , to:}%s", new Object[] { Integer.valueOf(n), paramString });
      }
    }
    for (;;)
    {
      l1 = 0L;
      if (localInterruptedException != null)
      {
        long l3 = localInterruptedException.getContentLength();
        l1 = l3;
        if (l3 < 0L) {
          l1 = 0L;
        }
      }
      if (paramb != null) {
        paramb.a(l1);
      }
      m = i;
      i = j;
      j = m;
      break;
      label460:
      if (paramb != null) {
        paramb.a(0L);
      }
      k = j;
      j = m;
      break;
      label480:
      return null;
      k = j;
      j = i;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.c.a
 * JD-Core Version:    0.7.0.1
 */