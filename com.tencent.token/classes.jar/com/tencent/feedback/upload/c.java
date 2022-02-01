package com.tencent.feedback.upload;

import android.content.Context;
import android.net.Proxy;
import com.tencent.feedback.common.e;
import com.tencent.feedback.common.g;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
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

public abstract class c
{
  private static c a;
  
  public static c a(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        if (a == null)
        {
          if (paramContext != null)
          {
            localContext = paramContext.getApplicationContext();
            if (localContext != null) {
              break label54;
            }
          }
          a = new a(paramContext);
        }
        else
        {
          paramContext = a;
          return paramContext;
        }
      }
      finally {}
      label54:
      paramContext = localContext;
    }
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, b paramb, Map<String, String> paramMap);
  
  public static final class a
    extends c
  {
    private Context a;
    
    public a(Context paramContext)
    {
      if (paramContext != null)
      {
        Context localContext = paramContext.getApplicationContext();
        if (localContext != null) {
          paramContext = localContext;
        }
      }
      this.a = paramContext;
    }
    
    /* Error */
    private HttpResponse a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 9
      //   3: aconst_null
      //   4: astore 8
      //   6: aconst_null
      //   7: astore 7
      //   9: aload_1
      //   10: ifnonnull +15 -> 25
      //   13: ldc 27
      //   15: iconst_0
      //   16: anewarray 29	java/lang/Object
      //   19: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   22: pop
      //   23: aconst_null
      //   24: areturn
      //   25: aload_2
      //   26: ifnull +20 -> 46
      //   29: aload 9
      //   31: astore 5
      //   33: new 37	org/apache/http/entity/ByteArrayEntity
      //   36: dup
      //   37: aload_2
      //   38: invokespecial 40	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   41: astore 6
      //   43: goto +21 -> 64
      //   46: aload 9
      //   48: astore 5
      //   50: new 37	org/apache/http/entity/ByteArrayEntity
      //   53: dup
      //   54: ldc 42
      //   56: invokevirtual 48	java/lang/String:getBytes	()[B
      //   59: invokespecial 40	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   62: astore 6
      //   64: aload 9
      //   66: astore 5
      //   68: aload_0
      //   69: aload_3
      //   70: invokespecial 51	com/tencent/feedback/upload/c$a:a	(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
      //   73: astore 10
      //   75: aload 10
      //   77: ifnonnull +19 -> 96
      //   80: aload 9
      //   82: astore 5
      //   84: ldc 53
      //   86: iconst_0
      //   87: anewarray 29	java/lang/Object
      //   90: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   93: pop
      //   94: aconst_null
      //   95: areturn
      //   96: aload 9
      //   98: astore 5
      //   100: new 55	org/apache/http/client/methods/HttpPost
      //   103: dup
      //   104: aload_1
      //   105: invokespecial 58	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
      //   108: astore_2
      //   109: aload 7
      //   111: astore_1
      //   112: aload_2
      //   113: ldc 60
      //   115: ldc 62
      //   117: invokevirtual 66	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   120: aload 7
      //   122: astore_1
      //   123: aload_2
      //   124: aload 6
      //   126: invokevirtual 70	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
      //   129: aload 4
      //   131: ifnull +151 -> 282
      //   134: aload 7
      //   136: astore_1
      //   137: aload 4
      //   139: invokeinterface 76 1 0
      //   144: ifle +138 -> 282
      //   147: aload 7
      //   149: astore_1
      //   150: aload 4
      //   152: invokeinterface 80 1 0
      //   157: invokeinterface 86 1 0
      //   162: astore 4
      //   164: aload 7
      //   166: astore_1
      //   167: aload 4
      //   169: invokeinterface 92 1 0
      //   174: ifeq +48 -> 222
      //   177: aload 7
      //   179: astore_1
      //   180: aload 4
      //   182: invokeinterface 96 1 0
      //   187: checkcast 98	java/util/Map$Entry
      //   190: astore 5
      //   192: aload 7
      //   194: astore_1
      //   195: aload_2
      //   196: aload 5
      //   198: invokeinterface 101 1 0
      //   203: checkcast 44	java/lang/String
      //   206: aload 5
      //   208: invokeinterface 104 1 0
      //   213: checkcast 44	java/lang/String
      //   216: invokevirtual 66	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   219: goto -55 -> 164
      //   222: aload 7
      //   224: astore_1
      //   225: aload_2
      //   226: ldc 106
      //   228: aload_3
      //   229: invokevirtual 66	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   232: aload 7
      //   234: astore_1
      //   235: new 108	java/lang/StringBuilder
      //   238: dup
      //   239: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   242: astore_3
      //   243: aload 7
      //   245: astore_1
      //   246: aload_0
      //   247: getfield 21	com/tencent/feedback/upload/c$a:a	Landroid/content/Context;
      //   250: invokestatic 114	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
      //   253: pop
      //   254: aload 7
      //   256: astore_1
      //   257: aload_3
      //   258: aload_0
      //   259: getfield 21	com/tencent/feedback/upload/c$a:a	Landroid/content/Context;
      //   262: invokestatic 118	com/tencent/feedback/common/d:f	(Landroid/content/Context;)Ljava/lang/String;
      //   265: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: pop
      //   269: aload 7
      //   271: astore_1
      //   272: aload_2
      //   273: ldc 124
      //   275: aload_3
      //   276: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   279: invokevirtual 66	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   282: aload 7
      //   284: astore_1
      //   285: new 130	org/apache/http/protocol/BasicHttpContext
      //   288: dup
      //   289: invokespecial 131	org/apache/http/protocol/BasicHttpContext:<init>	()V
      //   292: astore 4
      //   294: aload 7
      //   296: astore_1
      //   297: aload 10
      //   299: aload_2
      //   300: aload 4
      //   302: invokeinterface 137 3 0
      //   307: astore_3
      //   308: aload_3
      //   309: astore_1
      //   310: ldc 139
      //   312: iconst_1
      //   313: anewarray 29	java/lang/Object
      //   316: dup
      //   317: iconst_0
      //   318: aload 4
      //   320: ldc 141
      //   322: invokeinterface 147 2 0
      //   327: checkcast 149	org/apache/http/HttpRequest
      //   330: invokeinterface 153 1 0
      //   335: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
      //   338: aastore
      //   339: invokestatic 157	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   342: pop
      //   343: aload_2
      //   344: invokevirtual 160	org/apache/http/client/methods/HttpPost:abort	()V
      //   347: aload_3
      //   348: areturn
      //   349: astore_1
      //   350: goto +75 -> 425
      //   353: astore 4
      //   355: aload_1
      //   356: astore_3
      //   357: aload_2
      //   358: astore_1
      //   359: aload 4
      //   361: astore_2
      //   362: goto +16 -> 378
      //   365: astore_1
      //   366: aload 5
      //   368: astore_2
      //   369: goto +56 -> 425
      //   372: astore_2
      //   373: aconst_null
      //   374: astore_3
      //   375: aload 8
      //   377: astore_1
      //   378: aload_1
      //   379: astore 5
      //   381: aload_2
      //   382: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
      //   385: ifne +10 -> 395
      //   388: aload_1
      //   389: astore 5
      //   391: aload_2
      //   392: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
      //   395: aload_1
      //   396: astore 5
      //   398: ldc 168
      //   400: iconst_1
      //   401: anewarray 29	java/lang/Object
      //   404: dup
      //   405: iconst_0
      //   406: aload_2
      //   407: invokevirtual 169	java/lang/Throwable:toString	()Ljava/lang/String;
      //   410: aastore
      //   411: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   414: pop
      //   415: aload_1
      //   416: ifnull +7 -> 423
      //   419: aload_1
      //   420: invokevirtual 160	org/apache/http/client/methods/HttpPost:abort	()V
      //   423: aload_3
      //   424: areturn
      //   425: aload_2
      //   426: ifnull +7 -> 433
      //   429: aload_2
      //   430: invokevirtual 160	org/apache/http/client/methods/HttpPost:abort	()V
      //   433: aload_1
      //   434: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	435	0	this	a
      //   0	435	1	paramString1	String
      //   0	435	2	paramArrayOfByte	byte[]
      //   0	435	3	paramString2	String
      //   0	435	4	paramMap	Map<String, String>
      //   31	366	5	localObject1	Object
      //   41	84	6	localByteArrayEntity	org.apache.http.entity.ByteArrayEntity
      //   7	288	7	localObject2	Object
      //   4	372	8	localObject3	Object
      //   1	96	9	localObject4	Object
      //   73	225	10	localHttpClient	HttpClient
      // Exception table:
      //   from	to	target	type
      //   112	120	349	finally
      //   123	129	349	finally
      //   137	147	349	finally
      //   150	164	349	finally
      //   167	177	349	finally
      //   180	192	349	finally
      //   195	219	349	finally
      //   225	232	349	finally
      //   235	243	349	finally
      //   246	254	349	finally
      //   257	269	349	finally
      //   272	282	349	finally
      //   285	294	349	finally
      //   297	308	349	finally
      //   310	343	349	finally
      //   112	120	353	java/lang/Throwable
      //   123	129	353	java/lang/Throwable
      //   137	147	353	java/lang/Throwable
      //   150	164	353	java/lang/Throwable
      //   167	177	353	java/lang/Throwable
      //   180	192	353	java/lang/Throwable
      //   195	219	353	java/lang/Throwable
      //   225	232	353	java/lang/Throwable
      //   235	243	353	java/lang/Throwable
      //   246	254	353	java/lang/Throwable
      //   257	269	353	java/lang/Throwable
      //   272	282	353	java/lang/Throwable
      //   285	294	353	java/lang/Throwable
      //   297	308	353	java/lang/Throwable
      //   310	343	353	java/lang/Throwable
      //   33	43	365	finally
      //   50	64	365	finally
      //   68	75	365	finally
      //   84	94	365	finally
      //   100	109	365	finally
      //   381	388	365	finally
      //   391	395	365	finally
      //   398	415	365	finally
      //   33	43	372	java/lang/Throwable
      //   50	64	372	java/lang/Throwable
      //   68	75	372	java/lang/Throwable
      //   84	94	372	java/lang/Throwable
      //   100	109	372	java/lang/Throwable
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
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_0
      //   7: ifnonnull +5 -> 12
      //   10: aconst_null
      //   11: areturn
      //   12: aload_0
      //   13: invokeinterface 262 1 0
      //   18: invokeinterface 267 1 0
      //   23: istore_1
      //   24: iload_1
      //   25: sipush 200
      //   28: if_icmpeq +32 -> 60
      //   31: ldc_w 269
      //   34: iconst_2
      //   35: anewarray 29	java/lang/Object
      //   38: dup
      //   39: iconst_0
      //   40: iload_1
      //   41: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   44: aastore
      //   45: dup
      //   46: iconst_1
      //   47: aload_0
      //   48: invokeinterface 262 1 0
      //   53: aastore
      //   54: invokestatic 278	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   57: pop
      //   58: aconst_null
      //   59: areturn
      //   60: aload_0
      //   61: invokeinterface 282 1 0
      //   66: astore_0
      //   67: aload_0
      //   68: ifnonnull +16 -> 84
      //   71: ldc_w 284
      //   74: iconst_0
      //   75: anewarray 29	java/lang/Object
      //   78: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   81: pop
      //   82: aconst_null
      //   83: areturn
      //   84: new 286	java/io/BufferedInputStream
      //   87: dup
      //   88: new 288	java/io/DataInputStream
      //   91: dup
      //   92: aload_0
      //   93: invokeinterface 294 1 0
      //   98: invokespecial 297	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   101: invokespecial 298	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   104: astore_3
      //   105: aload_3
      //   106: astore_0
      //   107: new 300	java/io/ByteArrayOutputStream
      //   110: dup
      //   111: invokespecial 301	java/io/ByteArrayOutputStream:<init>	()V
      //   114: astore_2
      //   115: aload_3
      //   116: astore_0
      //   117: aload_3
      //   118: invokevirtual 304	java/io/BufferedInputStream:read	()I
      //   121: istore_1
      //   122: iload_1
      //   123: iconst_m1
      //   124: if_icmpeq +13 -> 137
      //   127: aload_3
      //   128: astore_0
      //   129: aload_2
      //   130: iload_1
      //   131: invokevirtual 308	java/io/ByteArrayOutputStream:write	(I)V
      //   134: goto -19 -> 115
      //   137: aload_3
      //   138: astore_0
      //   139: aload_2
      //   140: invokevirtual 311	java/io/ByteArrayOutputStream:flush	()V
      //   143: aload_3
      //   144: astore_0
      //   145: aload_2
      //   146: invokevirtual 314	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   149: astore_2
      //   150: aload_3
      //   151: invokevirtual 317	java/io/BufferedInputStream:close	()V
      //   154: aload_2
      //   155: areturn
      //   156: astore_3
      //   157: aload_2
      //   158: astore_0
      //   159: aload_3
      //   160: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
      //   163: ifne +95 -> 258
      //   166: aload_3
      //   167: astore_0
      //   168: aload_0
      //   169: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
      //   172: aload_2
      //   173: areturn
      //   174: astore_0
      //   175: aload_3
      //   176: astore_2
      //   177: aload_0
      //   178: astore_3
      //   179: goto +12 -> 191
      //   182: astore_2
      //   183: aconst_null
      //   184: astore_0
      //   185: goto +76 -> 261
      //   188: astore_3
      //   189: aconst_null
      //   190: astore_2
      //   191: aload_2
      //   192: astore_0
      //   193: aload_3
      //   194: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
      //   197: ifne +9 -> 206
      //   200: aload_2
      //   201: astore_0
      //   202: aload_3
      //   203: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
      //   206: aload_2
      //   207: astore_0
      //   208: ldc_w 319
      //   211: iconst_1
      //   212: anewarray 29	java/lang/Object
      //   215: dup
      //   216: iconst_0
      //   217: aload_3
      //   218: invokevirtual 169	java/lang/Throwable:toString	()Ljava/lang/String;
      //   221: aastore
      //   222: invokestatic 35	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
      //   225: pop
      //   226: aload 5
      //   228: astore_0
      //   229: aload_2
      //   230: ifnull +28 -> 258
      //   233: aload_2
      //   234: invokevirtual 317	java/io/BufferedInputStream:close	()V
      //   237: aconst_null
      //   238: areturn
      //   239: astore_3
      //   240: aload 5
      //   242: astore_0
      //   243: aload_3
      //   244: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
      //   247: ifne +11 -> 258
      //   250: aload 4
      //   252: astore_2
      //   253: aload_3
      //   254: astore_0
      //   255: goto -87 -> 168
      //   258: aload_0
      //   259: areturn
      //   260: astore_2
      //   261: aload_0
      //   262: ifnull +22 -> 284
      //   265: aload_0
      //   266: invokevirtual 317	java/io/BufferedInputStream:close	()V
      //   269: goto +15 -> 284
      //   272: astore_0
      //   273: aload_0
      //   274: invokestatic 163	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
      //   277: ifne +7 -> 284
      //   280: aload_0
      //   281: invokevirtual 166	java/lang/Throwable:printStackTrace	()V
      //   284: aload_2
      //   285: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	286	0	paramHttpResponse	HttpResponse
      //   23	108	1	i	int
      //   114	63	2	localObject1	Object
      //   182	1	2	localObject2	Object
      //   190	63	2	localObject3	Object
      //   260	25	2	localObject4	Object
      //   104	47	3	localBufferedInputStream	java.io.BufferedInputStream
      //   156	20	3	localThrowable1	Throwable
      //   178	1	3	localHttpResponse	HttpResponse
      //   188	30	3	localThrowable2	Throwable
      //   239	15	3	localThrowable3	Throwable
      //   4	247	4	localObject5	Object
      //   1	240	5	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   150	154	156	java/lang/Throwable
      //   107	115	174	java/lang/Throwable
      //   117	122	174	java/lang/Throwable
      //   129	134	174	java/lang/Throwable
      //   139	143	174	java/lang/Throwable
      //   145	150	174	java/lang/Throwable
      //   84	105	182	finally
      //   84	105	188	java/lang/Throwable
      //   233	237	239	java/lang/Throwable
      //   107	115	260	finally
      //   117	122	260	finally
      //   129	134	260	finally
      //   139	143	260	finally
      //   145	150	260	finally
      //   193	200	260	finally
      //   202	206	260	finally
      //   208	226	260	finally
      //   265	269	272	java/lang/Throwable
    }
    
    public final byte[] a(String paramString, byte[] paramArrayOfByte, b paramb, Map<String, String> paramMap)
    {
      if (paramString == null)
      {
        e.d("rqdp{  no destUrl!}", new Object[0]);
        return null;
      }
      long l2;
      if (paramArrayOfByte == null) {
        l2 = 0L;
      } else {
        l2 = paramArrayOfByte.length;
      }
      e.b("rqdp{  start req} %s rqdp{  sz:}%d", new Object[] { paramString, Long.valueOf(l2) });
      int j = 0;
      int m = 0;
      int k = 0;
      for (;;)
      {
        int n = j + 1;
        if ((j >= 3) || (m >= 2)) {
          break;
        }
        int i;
        if (k != 0)
        {
          i = 0;
        }
        else
        {
          i = k;
          if (n > 1)
          {
            e.b("rqdp{  try time} ".concat(String.valueOf(n)), new Object[0]);
            try
            {
              Thread.sleep(10000L);
              i = k;
            }
            catch (InterruptedException localInterruptedException)
            {
              i = k;
              if (!e.a(localInterruptedException))
              {
                localInterruptedException.printStackTrace();
                i = k;
              }
            }
          }
        }
        Object localObject = g.c(this.a);
        if (paramb != null) {
          paramb.a(paramString, l2, (String)localObject);
        }
        HttpResponse localHttpResponse = a(paramString, paramArrayOfByte, (String)localObject, paramMap);
        if (localHttpResponse != null)
        {
          localObject = localHttpResponse.getEntity();
          k = localHttpResponse.getStatusLine().getStatusCode();
          long l1;
          if (k == 200)
          {
            paramString = a(localHttpResponse);
            if (paramb != null)
            {
              if (paramString == null) {
                l1 = 0L;
              } else {
                l1 = paramString.length;
              }
              paramb.a(l1);
            }
            return paramString;
          }
          if ((k != 301) && (k != 302) && (k != 303) && (k != 307)) {
            j = 0;
          } else {
            j = 1;
          }
          if (j != 0)
          {
            paramString = localHttpResponse.getFirstHeader("Location");
            if (paramString == null)
            {
              paramString = new StringBuilder("rqdp{  redirect code:}");
              paramString.append(k);
              paramString.append("rqdp{   Location is null! return}");
              e.d(paramString.toString(), new Object[0]);
              return null;
            }
            m += 1;
            paramString = paramString.getValue();
            e.b("rqdp{  redirect code:}%d rqdp{  , to:}%s", new Object[] { Integer.valueOf(k), paramString });
            j = 0;
            i = 1;
          }
          else
          {
            j = n;
          }
          if (localObject != null)
          {
            long l3 = ((HttpEntity)localObject).getContentLength();
            l1 = l3;
            if (l3 < 0L) {
              l1 = 0L;
            }
          }
          else
          {
            l1 = 0L;
          }
          if (paramb != null) {
            paramb.a(l1);
          }
          k = i;
        }
        else
        {
          if (paramb != null) {
            paramb.a(0L);
          }
          j = n;
          k = i;
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.c
 * JD-Core Version:    0.7.0.1
 */