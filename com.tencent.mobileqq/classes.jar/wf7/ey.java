package wf7;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;

public class ey
{
  private static String TAG = "HttpNetwork";
  private boolean lh = false;
  private dt mC;
  private final int po = 3;
  private final int pp = 3;
  private String pq = "POST";
  private HttpURLConnection pr;
  private eu ps;
  private String pt;
  private int pu = 0;
  
  public ey(Context paramContext, dt paramdt, eu parameu, boolean paramBoolean)
  {
    this.mC = paramdt;
    this.ps = parameu;
    this.lh = paramBoolean;
  }
  
  /* Error */
  private int a(byte[] paramArrayOfByte, AtomicReference<byte[]> paramAtomicReference)
  {
    // Byte code:
    //   0: ldc 70
    //   2: istore 4
    //   4: aload_0
    //   5: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   8: ifnonnull +9 -> 17
    //   11: sipush -10000
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: ldc 74
    //   19: aload_0
    //   20: getfield 39	wf7/ey:pq	Ljava/lang/String;
    //   23: invokevirtual 80	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   26: ifeq +63 -> 89
    //   29: aload_0
    //   30: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   33: invokevirtual 86	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   36: astore 5
    //   38: aload 5
    //   40: aload_1
    //   41: invokevirtual 92	java/io/OutputStream:write	([B)V
    //   44: aload 5
    //   46: invokevirtual 95	java/io/OutputStream:flush	()V
    //   49: aload 5
    //   51: invokevirtual 98	java/io/OutputStream:close	()V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   59: invokevirtual 102	java/net/HttpURLConnection:getResponseCode	()I
    //   62: invokespecial 106	wf7/ey:ao	(I)Z
    //   65: ifeq +56 -> 121
    //   68: aload_0
    //   69: aload_0
    //   70: invokespecial 110	wf7/ey:dl	()Ljava/lang/String;
    //   73: putfield 112	wf7/ey:pt	Ljava/lang/String;
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 41	wf7/ey:pu	I
    //   81: iconst_1
    //   82: iadd
    //   83: putfield 41	wf7/ey:pu	I
    //   86: ldc 113
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   93: ldc 115
    //   95: new 117	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   102: ldc 120
    //   104: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: arraylength
    //   109: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -89 -> 29
    //   121: aload_0
    //   122: invokespecial 137	wf7/ey:dk	()V
    //   125: invokestatic 143	wf7/dg:bI	()Z
    //   128: ifeq +11 -> 139
    //   131: aload_0
    //   132: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   135: invokevirtual 147	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   138: pop
    //   139: aload_0
    //   140: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   143: ldc 149
    //   145: invokevirtual 153	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_1
    //   149: iload 4
    //   151: istore_3
    //   152: aload_1
    //   153: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne -141 -> 15
    //   159: iload 4
    //   161: istore_3
    //   162: aload_1
    //   163: ldc 161
    //   165: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq -153 -> 15
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   176: invokevirtual 169	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   179: invokespecial 172	wf7/ey:a	(Ljava/io/InputStream;)[B
    //   182: astore_1
    //   183: aload_2
    //   184: aload_1
    //   185: invokevirtual 178	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   188: aload_1
    //   189: ifnull +3 -> 192
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_1
    //   195: ldc 179
    //   197: ireturn
    //   198: astore_1
    //   199: ldc 180
    //   201: ireturn
    //   202: astore_1
    //   203: ldc 181
    //   205: ireturn
    //   206: astore_1
    //   207: ldc 182
    //   209: ireturn
    //   210: astore_1
    //   211: ldc 183
    //   213: ireturn
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 184	java/net/ConnectException:toString	()Ljava/lang/String;
    //   219: ldc 185
    //   221: invokestatic 191	wf7/dm:g	(Ljava/lang/String;I)I
    //   224: ireturn
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 192	java/net/SocketException:toString	()Ljava/lang/String;
    //   230: ldc 193
    //   232: invokestatic 191	wf7/dm:g	(Ljava/lang/String;I)I
    //   235: ireturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 194	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   241: ldc 195
    //   243: invokestatic 191	wf7/dm:g	(Ljava/lang/String;I)I
    //   246: istore_3
    //   247: iload_3
    //   248: ireturn
    //   249: astore_1
    //   250: ldc 196
    //   252: ireturn
    //   253: astore_1
    //   254: ldc 197
    //   256: ireturn
    //   257: astore_1
    //   258: ldc 198
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	ey
    //   0	264	1	paramArrayOfByte	byte[]
    //   0	264	2	paramAtomicReference	AtomicReference<byte[]>
    //   14	234	3	i	int
    //   2	158	4	j	int
    //   36	14	5	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   125	139	194	java/lang/Exception
    //   139	149	194	java/lang/Exception
    //   152	159	194	java/lang/Exception
    //   162	188	194	java/lang/Exception
    //   29	86	198	java/net/UnknownHostException
    //   121	125	198	java/net/UnknownHostException
    //   125	139	198	java/net/UnknownHostException
    //   139	149	198	java/net/UnknownHostException
    //   152	159	198	java/net/UnknownHostException
    //   162	188	198	java/net/UnknownHostException
    //   29	86	202	java/lang/IllegalAccessError
    //   121	125	202	java/lang/IllegalAccessError
    //   125	139	202	java/lang/IllegalAccessError
    //   139	149	202	java/lang/IllegalAccessError
    //   152	159	202	java/lang/IllegalAccessError
    //   162	188	202	java/lang/IllegalAccessError
    //   29	86	206	java/lang/IllegalStateException
    //   121	125	206	java/lang/IllegalStateException
    //   125	139	206	java/lang/IllegalStateException
    //   139	149	206	java/lang/IllegalStateException
    //   152	159	206	java/lang/IllegalStateException
    //   162	188	206	java/lang/IllegalStateException
    //   29	86	210	java/net/ProtocolException
    //   121	125	210	java/net/ProtocolException
    //   125	139	210	java/net/ProtocolException
    //   139	149	210	java/net/ProtocolException
    //   152	159	210	java/net/ProtocolException
    //   162	188	210	java/net/ProtocolException
    //   29	86	214	java/net/ConnectException
    //   121	125	214	java/net/ConnectException
    //   125	139	214	java/net/ConnectException
    //   139	149	214	java/net/ConnectException
    //   152	159	214	java/net/ConnectException
    //   162	188	214	java/net/ConnectException
    //   29	86	225	java/net/SocketException
    //   121	125	225	java/net/SocketException
    //   125	139	225	java/net/SocketException
    //   139	149	225	java/net/SocketException
    //   152	159	225	java/net/SocketException
    //   162	188	225	java/net/SocketException
    //   29	86	236	java/lang/SecurityException
    //   121	125	236	java/lang/SecurityException
    //   125	139	236	java/lang/SecurityException
    //   139	149	236	java/lang/SecurityException
    //   152	159	236	java/lang/SecurityException
    //   162	188	236	java/lang/SecurityException
    //   29	86	249	java/net/SocketTimeoutException
    //   121	125	249	java/net/SocketTimeoutException
    //   125	139	249	java/net/SocketTimeoutException
    //   139	149	249	java/net/SocketTimeoutException
    //   152	159	249	java/net/SocketTimeoutException
    //   162	188	249	java/net/SocketTimeoutException
    //   29	86	253	java/io/IOException
    //   121	125	253	java/io/IOException
    //   125	139	253	java/io/IOException
    //   139	149	253	java/io/IOException
    //   152	159	253	java/io/IOException
    //   162	188	253	java/io/IOException
    //   29	86	257	java/lang/Exception
    //   121	125	257	java/lang/Exception
    //   29	86	261	finally
    //   121	125	261	finally
    //   125	139	261	finally
    //   139	149	261	finally
    //   152	159	261	finally
    //   162	188	261	finally
    //   215	225	261	finally
    //   226	236	261	finally
    //   237	247	261	finally
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2048];
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramInputStream;
        paramInputStream = localByteArrayOutputStream.toByteArray();
        try
        {
          localByteArrayOutputStream.close();
          return paramInputStream;
        }
        catch (Exception localException1)
        {
          return paramInputStream;
        }
      }
      catch (Exception localException2)
      {
        break label74;
      }
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = paramInputStream;
      throw new RuntimeException("get Bytes from inputStream when read buffer: " + paramInputStream.getMessage());
    }
    finally {}
  }
  
  private boolean ao(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  private boolean dj()
  {
    if (this.pr == null) {
      return false;
    }
    try
    {
      this.pr.disconnect();
      this.pr = null;
      label21:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label21;
    }
  }
  
  private void dk()
  {
    this.pt = null;
    this.pu = 0;
  }
  
  private String dl()
  {
    try
    {
      String str = this.pr.getHeaderField("Location");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  private int start(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	wf7/ey:pu	I
    //   4: iconst_3
    //   5: if_icmplt +7 -> 12
    //   8: aload_0
    //   9: invokespecial 137	wf7/ey:dk	()V
    //   12: aload_0
    //   13: getfield 112	wf7/ey:pt	Ljava/lang/String;
    //   16: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +23 -> 42
    //   22: new 243	java/net/URL
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 244	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: invokestatic 249	wf7/fi:getNetworkType	()I
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +22 -> 58
    //   39: ldc 250
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 112	wf7/ey:pt	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -25 -> 22
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 253	java/net/MalformedURLException:printStackTrace	()V
    //   55: ldc 254
    //   57: ireturn
    //   58: iconst_3
    //   59: iload_2
    //   60: if_icmpne +117 -> 177
    //   63: aload_0
    //   64: aload_1
    //   65: new 256	java/net/Proxy
    //   68: dup
    //   69: getstatic 262	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   72: invokestatic 265	wf7/fi:dH	()Ljava/lang/String;
    //   75: invokestatic 268	wf7/fi:getProxyPort	()I
    //   78: invokestatic 274	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   81: invokespecial 277	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   84: invokevirtual 281	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   87: checkcast 82	java/net/HttpURLConnection
    //   90: putfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   93: invokestatic 286	wf7/dk:bJ	()I
    //   96: bipush 8
    //   98: if_icmpge +13 -> 111
    //   101: ldc_w 288
    //   104: ldc_w 290
    //   107: invokestatic 296	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: pop
    //   111: aload_0
    //   112: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   115: iconst_0
    //   116: invokevirtual 300	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   119: aload_0
    //   120: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   123: ldc_w 302
    //   126: ldc_w 304
    //   129: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   136: ldc_w 306
    //   139: ldc_w 304
    //   142: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   149: iconst_0
    //   150: invokevirtual 309	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   153: ldc 74
    //   155: aload_0
    //   156: getfield 39	wf7/ey:pq	Ljava/lang/String;
    //   159: invokevirtual 80	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   162: ifeq +58 -> 220
    //   165: aload_0
    //   166: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   169: ldc 74
    //   171: invokevirtual 312	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   174: goto +138 -> 312
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 315	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   182: checkcast 82	java/net/HttpURLConnection
    //   185: putfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   188: aload_0
    //   189: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   192: sipush 15000
    //   195: invokevirtual 319	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   198: aload_0
    //   199: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   202: sipush 15000
    //   205: invokevirtual 322	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   208: goto -115 -> 93
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 323	java/net/UnknownHostException:printStackTrace	()V
    //   216: ldc_w 324
    //   219: ireturn
    //   220: aload_0
    //   221: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   224: ldc 37
    //   226: invokevirtual 312	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   233: iconst_1
    //   234: invokevirtual 327	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   237: aload_0
    //   238: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   241: iconst_1
    //   242: invokevirtual 330	java/net/HttpURLConnection:setDoInput	(Z)V
    //   245: aload_0
    //   246: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   249: ldc_w 332
    //   252: ldc_w 334
    //   255: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   262: ldc_w 336
    //   265: ldc_w 338
    //   268: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 72	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   275: ldc_w 340
    //   278: ldc_w 342
    //   281: invokevirtual 134	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto +28 -> 312
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 343	java/lang/IllegalArgumentException:printStackTrace	()V
    //   292: ldc_w 344
    //   295: ireturn
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 345	java/lang/SecurityException:printStackTrace	()V
    //   301: ldc 195
    //   303: ireturn
    //   304: astore_1
    //   305: aload_1
    //   306: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   309: ldc 197
    //   311: ireturn
    //   312: iconst_0
    //   313: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	ey
    //   0	314	1	paramString	String
    //   34	27	2	i	int
    // Exception table:
    //   from	to	target	type
    //   22	31	50	java/net/MalformedURLException
    //   31	35	211	java/net/UnknownHostException
    //   63	93	211	java/net/UnknownHostException
    //   93	111	211	java/net/UnknownHostException
    //   111	174	211	java/net/UnknownHostException
    //   177	208	211	java/net/UnknownHostException
    //   220	284	211	java/net/UnknownHostException
    //   31	35	287	java/lang/IllegalArgumentException
    //   63	93	287	java/lang/IllegalArgumentException
    //   93	111	287	java/lang/IllegalArgumentException
    //   111	174	287	java/lang/IllegalArgumentException
    //   177	208	287	java/lang/IllegalArgumentException
    //   220	284	287	java/lang/IllegalArgumentException
    //   31	35	296	java/lang/SecurityException
    //   63	93	296	java/lang/SecurityException
    //   93	111	296	java/lang/SecurityException
    //   111	174	296	java/lang/SecurityException
    //   177	208	296	java/lang/SecurityException
    //   220	284	296	java/lang/SecurityException
    //   31	35	304	java/io/IOException
    //   63	93	304	java/io/IOException
    //   93	111	304	java/io/IOException
    //   111	174	304	java/io/IOException
    //   177	208	304	java/io/IOException
    //   220	284	304	java/io/IOException
  }
  
  int a(em.d paramd, byte[] paramArrayOfByte, AtomicReference<byte[]> paramAtomicReference)
  {
    int m = 1;
    int n = 0;
    int i;
    if ((paramArrayOfByte == null) || (paramd == null)) {
      i = -10;
    }
    int k;
    for (;;)
    {
      return i;
      int j;
      for (;;)
      {
        try
        {
          if (paramd.ns != 2048) {
            break label340;
          }
          k = 1;
        }
        finally {}
        j = i;
        if (n < m)
        {
          if (fi.getNetworkType() == 0)
          {
            i = -220000;
            break;
          }
          if (paramd.cW())
          {
            i = -17;
            break;
          }
          if (k != 0)
          {
            String str2 = dn.a(this.lh, this.mC);
            str1 = str2;
            if (str2 != null) {
              if (str2.length() >= "http://".length())
              {
                str1 = str2;
                if (str2.substring(0, "http://".length()).equalsIgnoreCase("http://")) {}
              }
              else
              {
                str1 = "http://" + str2;
              }
            }
            j = start(str1);
            i = j;
            if (j == 0)
            {
              paramd.nH = true;
              i = a(paramArrayOfByte, paramAtomicReference);
            }
            dj();
            j = i;
            if (i == 0) {
              break label316;
            }
            if (i != -220000) {
              continue;
            }
            break;
          }
          String str1 = this.ps.bP();
          continue;
          if ((i != -60000) && (fi.I("http send")))
          {
            i = -160000;
            break;
          }
          if ((k == 0) && (i != -60000)) {
            this.ps.o(false);
          }
          if (n < m - 1) {}
          try
          {
            Thread.sleep(300L);
            n += 1;
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
      label316:
      i = j;
    }
    label340:
    label344:
    for (;;)
    {
      m = 3;
      for (;;)
      {
        if (k == 0) {
          break label344;
        }
        i = -1;
        break;
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ey
 * JD-Core Version:    0.7.0.1
 */