package com.tencent.feedback.upload;

import android.content.Context;
import android.net.Proxy;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.g;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public abstract class d
{
  private static d a = null;
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext.getApplicationContext());
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, c paramc);
  
  public static final class a
    extends d
  {
    private Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext.getApplicationContext();
    }
    
    /* Error */
    private HttpResponse a(String paramString1, byte[] paramArrayOfByte, String paramString2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_1
      //   7: ifnonnull +17 -> 24
      //   10: ldc 27
      //   12: iconst_0
      //   13: anewarray 29	java/lang/Object
      //   16: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   19: aload 4
      //   21: astore_1
      //   22: aload_1
      //   23: areturn
      //   24: aload_2
      //   25: ifnull +80 -> 105
      //   28: new 37	org/apache/http/entity/ByteArrayEntity
      //   31: dup
      //   32: aload_2
      //   33: invokespecial 40	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   36: astore_2
      //   37: aload_0
      //   38: aload_3
      //   39: invokespecial 43	com/tencent/feedback/upload/d$a:a	(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
      //   42: astore 4
      //   44: aload 4
      //   46: ifnonnull +90 -> 136
      //   49: ldc 45
      //   51: iconst_0
      //   52: anewarray 29	java/lang/Object
      //   55: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: aconst_null
      //   59: areturn
      //   60: astore 4
      //   62: aconst_null
      //   63: astore_3
      //   64: aload 5
      //   66: astore_2
      //   67: aload_3
      //   68: astore_1
      //   69: aload 4
      //   71: invokevirtual 48	java/lang/Throwable:printStackTrace	()V
      //   74: aload_3
      //   75: astore_1
      //   76: ldc 50
      //   78: iconst_1
      //   79: anewarray 29	java/lang/Object
      //   82: dup
      //   83: iconst_0
      //   84: aload 4
      //   86: invokevirtual 54	java/lang/Throwable:toString	()Ljava/lang/String;
      //   89: aastore
      //   90: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   93: aload_2
      //   94: astore_1
      //   95: aload_3
      //   96: ifnull -74 -> 22
      //   99: aload_3
      //   100: invokevirtual 59	org/apache/http/client/methods/HttpPost:abort	()V
      //   103: aload_2
      //   104: areturn
      //   105: new 37	org/apache/http/entity/ByteArrayEntity
      //   108: dup
      //   109: ldc 61
      //   111: invokevirtual 67	java/lang/String:getBytes	()[B
      //   114: invokespecial 40	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   117: astore_2
      //   118: goto -81 -> 37
      //   121: astore_1
      //   122: aconst_null
      //   123: astore_3
      //   124: aload_1
      //   125: astore_2
      //   126: aload_3
      //   127: ifnull +7 -> 134
      //   130: aload_3
      //   131: invokevirtual 59	org/apache/http/client/methods/HttpPost:abort	()V
      //   134: aload_2
      //   135: athrow
      //   136: new 56	org/apache/http/client/methods/HttpPost
      //   139: dup
      //   140: aload_1
      //   141: invokespecial 70	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
      //   144: astore_3
      //   145: aload_3
      //   146: astore_1
      //   147: aload_3
      //   148: ldc 72
      //   150: ldc 74
      //   152: invokevirtual 78	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   155: aload_3
      //   156: astore_1
      //   157: aload_3
      //   158: aload_2
      //   159: invokevirtual 82	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
      //   162: aload_3
      //   163: astore_1
      //   164: new 84	org/apache/http/protocol/BasicHttpContext
      //   167: dup
      //   168: invokespecial 85	org/apache/http/protocol/BasicHttpContext:<init>	()V
      //   171: astore 6
      //   173: aload_3
      //   174: astore_1
      //   175: aload 4
      //   177: aload_3
      //   178: aload 6
      //   180: invokeinterface 91 3 0
      //   185: astore_2
      //   186: aload_3
      //   187: astore_1
      //   188: ldc 93
      //   190: iconst_1
      //   191: anewarray 29	java/lang/Object
      //   194: dup
      //   195: iconst_0
      //   196: aload 6
      //   198: ldc 95
      //   200: invokeinterface 101 2 0
      //   205: checkcast 103	org/apache/http/HttpRequest
      //   208: invokeinterface 107 1 0
      //   213: invokevirtual 108	java/lang/Object:toString	()Ljava/lang/String;
      //   216: aastore
      //   217: invokestatic 111	com/tencent/feedback/common/e:h	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   220: aload_3
      //   221: invokevirtual 59	org/apache/http/client/methods/HttpPost:abort	()V
      //   224: aload_2
      //   225: areturn
      //   226: astore_2
      //   227: aload_1
      //   228: astore_3
      //   229: goto -103 -> 126
      //   232: astore 4
      //   234: aload 5
      //   236: astore_2
      //   237: goto -170 -> 67
      //   240: astore 4
      //   242: goto -175 -> 67
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	245	0	this	a
      //   0	245	1	paramString1	String
      //   0	245	2	paramArrayOfByte	byte[]
      //   0	245	3	paramString2	String
      //   4	41	4	localHttpClient	HttpClient
      //   60	116	4	localThrowable1	Throwable
      //   232	1	4	localThrowable2	Throwable
      //   240	1	4	localThrowable3	Throwable
      //   1	234	5	localObject	Object
      //   171	26	6	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
      // Exception table:
      //   from	to	target	type
      //   28	37	60	java/lang/Throwable
      //   37	44	60	java/lang/Throwable
      //   49	58	60	java/lang/Throwable
      //   105	118	60	java/lang/Throwable
      //   136	145	60	java/lang/Throwable
      //   28	37	121	finally
      //   37	44	121	finally
      //   49	58	121	finally
      //   105	118	121	finally
      //   136	145	121	finally
      //   69	74	226	finally
      //   76	93	226	finally
      //   147	155	226	finally
      //   157	162	226	finally
      //   164	173	226	finally
      //   175	186	226	finally
      //   188	220	226	finally
      //   147	155	232	java/lang/Throwable
      //   157	162	232	java/lang/Throwable
      //   164	173	232	java/lang/Throwable
      //   175	186	232	java/lang/Throwable
      //   188	220	240	java/lang/Throwable
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
        ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new HttpRequestRetryHandler()
        {
          public final boolean retryRequest(IOException paramAnonymousIOException, int paramAnonymousInt, HttpContext paramAnonymousHttpContext)
          {
            return false;
          }
        });
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
        paramString.printStackTrace();
        e.d("rqdp{  httpclient error!}", new Object[0]);
      }
      return null;
    }
    
    /* Error */
    private static byte[] a(HttpResponse paramHttpResponse)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: aload_0
      //   7: invokeinterface 203 1 0
      //   12: invokeinterface 208 1 0
      //   17: istore_1
      //   18: iload_1
      //   19: sipush 200
      //   22: if_icmpeq +30 -> 52
      //   25: ldc 210
      //   27: iconst_2
      //   28: anewarray 29	java/lang/Object
      //   31: dup
      //   32: iconst_0
      //   33: iload_1
      //   34: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   37: aastore
      //   38: dup
      //   39: iconst_1
      //   40: aload_0
      //   41: invokeinterface 203 1 0
      //   46: aastore
      //   47: invokestatic 219	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   50: aconst_null
      //   51: areturn
      //   52: aload_0
      //   53: invokeinterface 223 1 0
      //   58: astore_0
      //   59: aload_0
      //   60: ifnonnull +14 -> 74
      //   63: ldc 225
      //   65: iconst_0
      //   66: anewarray 29	java/lang/Object
      //   69: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: aconst_null
      //   73: areturn
      //   74: new 227	java/io/BufferedInputStream
      //   77: dup
      //   78: new 229	java/io/DataInputStream
      //   81: dup
      //   82: aload_0
      //   83: invokeinterface 235 1 0
      //   88: invokespecial 238	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   91: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   94: astore_2
      //   95: aload_2
      //   96: astore_0
      //   97: new 241	java/io/ByteArrayOutputStream
      //   100: dup
      //   101: invokespecial 242	java/io/ByteArrayOutputStream:<init>	()V
      //   104: astore_3
      //   105: aload_2
      //   106: astore_0
      //   107: aload_2
      //   108: invokevirtual 245	java/io/BufferedInputStream:read	()I
      //   111: istore_1
      //   112: iload_1
      //   113: iconst_m1
      //   114: if_icmpeq +55 -> 169
      //   117: aload_2
      //   118: astore_0
      //   119: aload_3
      //   120: iload_1
      //   121: invokevirtual 249	java/io/ByteArrayOutputStream:write	(I)V
      //   124: goto -19 -> 105
      //   127: astore_3
      //   128: aload_2
      //   129: astore_0
      //   130: aload_3
      //   131: invokevirtual 48	java/lang/Throwable:printStackTrace	()V
      //   134: aload_2
      //   135: astore_0
      //   136: ldc 251
      //   138: iconst_1
      //   139: anewarray 29	java/lang/Object
      //   142: dup
      //   143: iconst_0
      //   144: aload_3
      //   145: invokevirtual 54	java/lang/Throwable:toString	()Ljava/lang/String;
      //   148: aastore
      //   149: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   152: aload_2
      //   153: ifnull -149 -> 4
      //   156: aload_2
      //   157: invokevirtual 254	java/io/BufferedInputStream:close	()V
      //   160: aconst_null
      //   161: areturn
      //   162: astore_0
      //   163: aload_0
      //   164: invokevirtual 48	java/lang/Throwable:printStackTrace	()V
      //   167: aconst_null
      //   168: areturn
      //   169: aload_2
      //   170: astore_0
      //   171: aload_3
      //   172: invokevirtual 257	java/io/ByteArrayOutputStream:flush	()V
      //   175: aload_2
      //   176: astore_0
      //   177: aload_3
      //   178: invokevirtual 260	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   181: astore_3
      //   182: aload_2
      //   183: invokevirtual 254	java/io/BufferedInputStream:close	()V
      //   186: aload_3
      //   187: areturn
      //   188: astore_0
      //   189: aload_0
      //   190: invokevirtual 48	java/lang/Throwable:printStackTrace	()V
      //   193: aload_3
      //   194: areturn
      //   195: astore_2
      //   196: aconst_null
      //   197: astore_0
      //   198: aload_0
      //   199: ifnull +7 -> 206
      //   202: aload_0
      //   203: invokevirtual 254	java/io/BufferedInputStream:close	()V
      //   206: aload_2
      //   207: athrow
      //   208: astore_0
      //   209: aload_0
      //   210: invokevirtual 48	java/lang/Throwable:printStackTrace	()V
      //   213: goto -7 -> 206
      //   216: astore_2
      //   217: goto -19 -> 198
      //   220: astore_3
      //   221: aconst_null
      //   222: astore_2
      //   223: goto -95 -> 128
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	226	0	paramHttpResponse	HttpResponse
      //   17	104	1	i	int
      //   94	89	2	localBufferedInputStream	java.io.BufferedInputStream
      //   195	12	2	localObject1	Object
      //   216	1	2	localObject2	Object
      //   222	1	2	localObject3	Object
      //   104	16	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   127	51	3	localThrowable1	Throwable
      //   181	13	3	arrayOfByte	byte[]
      //   220	1	3	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   97	105	127	java/lang/Throwable
      //   107	112	127	java/lang/Throwable
      //   119	124	127	java/lang/Throwable
      //   171	175	127	java/lang/Throwable
      //   177	182	127	java/lang/Throwable
      //   156	160	162	java/lang/Throwable
      //   182	186	188	java/lang/Throwable
      //   74	95	195	finally
      //   202	206	208	java/lang/Throwable
      //   97	105	216	finally
      //   107	112	216	finally
      //   119	124	216	finally
      //   130	134	216	finally
      //   136	152	216	finally
      //   171	175	216	finally
      //   177	182	216	finally
      //   74	95	220	java/lang/Throwable
    }
    
    public final byte[] a(String paramString, byte[] paramArrayOfByte, c paramc)
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
      label79:
      HttpResponse localHttpResponse;
      int n;
      if (paramArrayOfByte == null)
      {
        l2 = 0L;
        e.h("rqdp{  start req} %s rqdp{  sz:}%d", new Object[] { paramString, Long.valueOf(l2) });
        k = 0;
        m = j + 1;
        if ((j >= 3) || (i >= 2)) {
          break label461;
        }
        if (k == 0) {
          break label180;
        }
        j = 0;
        Object localObject = g.c(this.a);
        if (paramc != null) {
          paramc.a(paramString, l2, (String)localObject);
        }
        localHttpResponse = a(paramString, paramArrayOfByte, (String)localObject);
        if (localHttpResponse == null) {
          break label441;
        }
        localObject = localHttpResponse.getEntity();
        n = localHttpResponse.getStatusLine().getStatusCode();
        if (n != 200) {
          break label250;
        }
        paramString = a(localHttpResponse);
        if (paramc != null) {
          if (paramString != null) {
            break label242;
          }
        }
      }
      label180:
      label242:
      for (long l1 = 0L;; l1 = paramString.length)
      {
        for (;;)
        {
          paramc.a(l1);
          return paramString;
          l2 = paramArrayOfByte.length;
          break;
          j = k;
          if (m <= 1) {
            break label79;
          }
          e.h("rqdp{  try time} " + m, new Object[0]);
          try
          {
            Thread.sleep(10000L);
            j = k;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            j = k;
          }
        }
        break label79;
      }
      label250:
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
          e.h("rqdp{  redirect code:}%d rqdp{  , to:}%s", new Object[] { Integer.valueOf(n), paramString });
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
        if (paramc != null) {
          paramc.a(l1);
        }
        m = i;
        i = j;
        j = m;
        break;
        label441:
        if (paramc != null) {
          paramc.a(0L);
        }
        k = j;
        j = m;
        break;
        label461:
        return null;
        k = j;
        j = i;
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.d
 * JD-Core Version:    0.7.0.1
 */