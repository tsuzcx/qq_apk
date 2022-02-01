package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.common.info.b;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public final class s
{
  private static s b;
  public Map<String, String> a = null;
  private Context c;
  
  private s(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static s a(Context paramContext)
  {
    if (b == null) {
      b = new s(paramContext);
    }
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new URL(paramString2);
      if ((paramString1 != null) && (paramString1.toLowerCase(Locale.US).contains("wap"))) {
        paramString1 = new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
      }
      for (paramString1 = (HttpURLConnection)paramString2.openConnection(new Proxy(Proxy.Type.HTTP, paramString1));; paramString1 = (HttpURLConnection)paramString2.openConnection())
      {
        paramString1.setConnectTimeout(30000);
        paramString1.setReadTimeout(10000);
        paramString1.setDoOutput(true);
        paramString1.setDoInput(true);
        paramString1.setRequestMethod("POST");
        paramString1.setUseCaches(false);
        paramString1.setInstanceFollowRedirects(false);
        return paramString1;
      }
      return null;
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
  {
    if (paramString1 == null)
    {
      x.e("destUrl is null.", new Object[0]);
      return null;
    }
    s.1 local1 = new s.1();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { local1 }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      paramString1 = a(paramString2, paramString1);
      if (paramString1 == null)
      {
        x.e("Failed to get HttpURLConnection object.", new Object[0]);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      try
      {
        paramString1.setRequestProperty("wup_version", "3.0");
        if ((paramMap != null) && (paramMap.size() > 0))
        {
          paramMap = paramMap.entrySet().iterator();
          while (paramMap.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramMap.next();
            paramString1.setRequestProperty((String)localEntry.getKey(), URLEncoder.encode((String)localEntry.getValue(), "utf-8"));
          }
        }
        paramString1.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
      }
      catch (Throwable paramString1)
      {
        if (!x.a(paramString1)) {
          paramString1.printStackTrace();
        }
        x.e("Failed to upload, please check your network.", new Object[0]);
        return null;
      }
      paramString1.setRequestProperty("A38", URLEncoder.encode(paramString2, "utf-8"));
      paramString2 = paramString1.getOutputStream();
      if (paramArrayOfByte == null) {
        paramString2.write(0);
      } else {
        paramString2.write(paramArrayOfByte);
      }
    }
    return paramString1;
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection)
  {
    HashMap localHashMap = new HashMap();
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    if ((paramHttpURLConnection == null) || (paramHttpURLConnection.size() == 0)) {
      return null;
    }
    Iterator localIterator = paramHttpURLConnection.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)paramHttpURLConnection.get(str);
      if (localList.size() > 0) {
        localHashMap.put(str, localList.get(0));
      }
    }
    return localHashMap;
  }
  
  /* Error */
  private static byte[] b(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 269	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 273	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: invokespecial 276	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: new 278	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 279	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore_3
    //   28: aload_2
    //   29: astore_0
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 4
    //   37: aload_2
    //   38: astore_0
    //   39: aload_2
    //   40: aload 4
    //   42: invokevirtual 283	java/io/BufferedInputStream:read	([B)I
    //   45: istore_1
    //   46: iload_1
    //   47: ifle +49 -> 96
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 286	java/io/ByteArrayOutputStream:write	([BII)V
    //   60: goto -23 -> 37
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: invokestatic 123	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   70: ifne +9 -> 79
    //   73: aload_2
    //   74: astore_0
    //   75: aload_3
    //   76: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   79: aload_2
    //   80: ifnull -76 -> 4
    //   83: aload_2
    //   84: invokevirtual 289	java/io/BufferedInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_2
    //   97: astore_0
    //   98: aload_3
    //   99: invokevirtual 292	java/io/ByteArrayOutputStream:flush	()V
    //   102: aload_2
    //   103: astore_0
    //   104: aload_3
    //   105: invokevirtual 296	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   108: astore_3
    //   109: aload_2
    //   110: invokevirtual 289	java/io/BufferedInputStream:close	()V
    //   113: aload_3
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 289	java/io/BufferedInputStream:close	()V
    //   133: aload_2
    //   134: athrow
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_2
    //   144: goto -19 -> 125
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -86 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramHttpURLConnection	HttpURLConnection
    //   45	12	1	i	int
    //   17	93	2	localBufferedInputStream	java.io.BufferedInputStream
    //   122	12	2	localObject1	Object
    //   143	1	2	localObject2	Object
    //   149	1	2	localObject3	Object
    //   27	26	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   63	42	3	localThrowable1	Throwable
    //   108	13	3	arrayOfByte1	byte[]
    //   147	1	3	localThrowable2	Throwable
    //   35	19	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   20	28	63	java/lang/Throwable
    //   30	37	63	java/lang/Throwable
    //   39	46	63	java/lang/Throwable
    //   52	60	63	java/lang/Throwable
    //   98	102	63	java/lang/Throwable
    //   104	109	63	java/lang/Throwable
    //   83	87	89	java/lang/Throwable
    //   109	113	115	java/lang/Throwable
    //   6	18	122	finally
    //   129	133	135	java/lang/Throwable
    //   20	28	143	finally
    //   30	37	143	finally
    //   39	46	143	finally
    //   52	60	143	finally
    //   66	73	143	finally
    //   75	79	143	finally
    //   98	102	143	finally
    //   104	109	143	finally
    //   6	18	147	java/lang/Throwable
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte, v paramv, Map<String, String> paramMap)
  {
    if (paramString == null)
    {
      x.e("Failed for no URL.", new Object[0]);
      return null;
    }
    int j = 0;
    int i = 0;
    long l1;
    int m;
    label74:
    int k;
    if (paramArrayOfByte == null)
    {
      l1 = 0L;
      x.c("request: %s, send: %d (pid=%d | tid=%d)", new Object[] { paramString, Long.valueOf(l1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      m = 0;
      if ((j > 0) || (i > 0)) {
        break label744;
      }
      if (m == 0) {
        break label132;
      }
      k = 0;
    }
    Object localObject1;
    label132:
    int n;
    for (;;)
    {
      localObject1 = b.b(this.c);
      if (localObject1 != null) {
        break label213;
      }
      x.d("Failed to request for network not avail", new Object[0]);
      m = k;
      break label74;
      l1 = paramArrayOfByte.length;
      break;
      n = j + 1;
      k = m;
      j = n;
      if (n > 1)
      {
        x.c("try time: " + n, new Object[0]);
        SystemClock.sleep(new Random(System.currentTimeMillis()).nextInt(10000) + 10000L);
        k = m;
        j = n;
      }
    }
    label213:
    paramv.a(l1);
    HttpURLConnection localHttpURLConnection = a(paramString, paramArrayOfByte, (String)localObject1, paramMap);
    if (localHttpURLConnection != null) {}
    label777:
    for (;;)
    {
      try
      {
        n = localHttpURLConnection.getResponseCode();
        if (n == 200)
        {
          this.a = a(localHttpURLConnection);
          localObject1 = b(localHttpURLConnection);
          if (localObject1 == null)
          {
            l2 = 0L;
            paramv.b(l2);
          }
          try
          {
            localHttpURLConnection.disconnect();
            return localObject1;
            m = localObject1.length;
            l2 = m;
          }
          catch (Throwable paramString)
          {
            if (x.a(paramString)) {
              continue;
            }
            paramString.printStackTrace();
            continue;
          }
        }
        if ((n == 301) || (n == 302) || (n == 303) || (n == 307))
        {
          m = 1;
          if (m == 0) {
            break label777;
          }
        }
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            localObject1 = localHttpURLConnection.getHeaderField("Location");
            if (localObject1 == null)
            {
              x.e("Failed to redirect: %d" + n, new Object[0]);
              try
              {
                localHttpURLConnection.disconnect();
                return null;
                m = 0;
              }
              catch (Throwable paramString)
              {
                if (x.a(paramString)) {
                  continue;
                }
                paramString.printStackTrace();
                continue;
              }
            }
            i += 1;
          }
          catch (IOException localIOException2)
          {
            long l2;
            long l3;
            int i1;
            String str;
            k = 1;
            continue;
          }
          try
          {
            x.c("redirect code: %d ,to:%s", new Object[] { Integer.valueOf(n), localObject1 });
            k = 1;
            paramString = (String)localObject1;
            j = 0;
          }
          catch (IOException localIOException4)
          {
            paramString = localIOException2;
            Object localObject2 = localIOException4;
            k = 1;
            j = 0;
            continue;
          }
          try
          {
            x.d("response code " + n, new Object[0]);
            l3 = localHttpURLConnection.getContentLength();
            l2 = l3;
            if (l3 < 0L) {
              l2 = 0L;
            }
            paramv.b(l2);
            try
            {
              localHttpURLConnection.disconnect();
              localObject1 = paramString;
              i1 = j;
              n = i;
              m = k;
            }
            catch (Throwable localThrowable1)
            {
              m = k;
              n = i;
              i1 = j;
              localObject1 = paramString;
              if (x.a(localThrowable1)) {
                continue;
              }
              localThrowable1.printStackTrace();
              m = k;
              n = i;
              i1 = j;
              localObject1 = paramString;
              continue;
            }
            j = i1;
            i = n;
            paramString = (String)localObject1;
          }
          catch (IOException localIOException3) {}
        }
        localIOException1 = localIOException1;
        if (!x.a(localIOException1)) {
          localIOException1.printStackTrace();
        }
        try
        {
          localHttpURLConnection.disconnect();
          m = k;
          n = i;
          i1 = j;
          str = paramString;
        }
        catch (Throwable localThrowable2)
        {
          m = k;
          n = i;
          i1 = j;
          str = paramString;
        }
        if (x.a(localThrowable2)) {
          continue;
        }
        localThrowable2.printStackTrace();
        m = k;
        n = i;
        i1 = j;
        str = paramString;
        continue;
      }
      finally {}
      try
      {
        localHttpURLConnection.disconnect();
        throw paramString;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          if (!x.a(paramArrayOfByte)) {
            paramArrayOfByte.printStackTrace();
          }
        }
      }
      x.c("Failed to execute post.", new Object[0]);
      paramv.b(0L);
      m = k;
      n = i;
      i1 = j;
      str = paramString;
      continue;
      label744:
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.s
 * JD-Core Version:    0.7.0.1
 */