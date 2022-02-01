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
    //   0: ldc 72
    //   2: istore 4
    //   4: aload_0
    //   5: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   8: ifnonnull +9 -> 17
    //   11: sipush -10000
    //   14: istore_3
    //   15: iload_3
    //   16: ireturn
    //   17: ldc 76
    //   19: aload_0
    //   20: getfield 42	wf7/ey:pq	Ljava/lang/String;
    //   23: invokevirtual 82	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   26: ifeq +63 -> 89
    //   29: aload_0
    //   30: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   33: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   36: astore 5
    //   38: aload 5
    //   40: aload_1
    //   41: invokevirtual 94	java/io/OutputStream:write	([B)V
    //   44: aload 5
    //   46: invokevirtual 97	java/io/OutputStream:flush	()V
    //   49: aload 5
    //   51: invokevirtual 100	java/io/OutputStream:close	()V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   59: invokevirtual 104	java/net/HttpURLConnection:getResponseCode	()I
    //   62: invokespecial 108	wf7/ey:ao	(I)Z
    //   65: ifeq +56 -> 121
    //   68: aload_0
    //   69: aload_0
    //   70: invokespecial 112	wf7/ey:dl	()Ljava/lang/String;
    //   73: putfield 114	wf7/ey:pt	Ljava/lang/String;
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 44	wf7/ey:pu	I
    //   81: iconst_1
    //   82: iadd
    //   83: putfield 44	wf7/ey:pu	I
    //   86: ldc 115
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   93: ldc 117
    //   95: new 119	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   102: ldc 122
    //   104: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: arraylength
    //   109: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -89 -> 29
    //   121: aload_0
    //   122: invokespecial 139	wf7/ey:dk	()V
    //   125: invokestatic 145	wf7/dg:bI	()Z
    //   128: ifeq +11 -> 139
    //   131: aload_0
    //   132: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   135: invokevirtual 149	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   138: pop
    //   139: aload_0
    //   140: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   143: ldc 151
    //   145: invokevirtual 155	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_1
    //   149: iload 4
    //   151: istore_3
    //   152: aload_1
    //   153: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne -141 -> 15
    //   159: iload 4
    //   161: istore_3
    //   162: aload_1
    //   163: ldc 163
    //   165: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq -153 -> 15
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   176: invokevirtual 171	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   179: invokespecial 174	wf7/ey:a	(Ljava/io/InputStream;)[B
    //   182: astore_1
    //   183: aload_2
    //   184: aload_1
    //   185: invokevirtual 180	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   188: aload_1
    //   189: ifnull +3 -> 192
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_1
    //   195: ldc 181
    //   197: ireturn
    //   198: astore_1
    //   199: ldc 182
    //   201: ireturn
    //   202: astore_1
    //   203: ldc 183
    //   205: ireturn
    //   206: astore_1
    //   207: ldc 184
    //   209: ireturn
    //   210: astore_1
    //   211: ldc 185
    //   213: ireturn
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 186	java/net/ConnectException:toString	()Ljava/lang/String;
    //   219: ldc 187
    //   221: invokestatic 193	wf7/dm:g	(Ljava/lang/String;I)I
    //   224: ireturn
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 194	java/net/SocketException:toString	()Ljava/lang/String;
    //   230: ldc 195
    //   232: invokestatic 193	wf7/dm:g	(Ljava/lang/String;I)I
    //   235: ireturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 196	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   241: ldc 197
    //   243: invokestatic 193	wf7/dm:g	(Ljava/lang/String;I)I
    //   246: istore_3
    //   247: iload_3
    //   248: ireturn
    //   249: astore_1
    //   250: ldc 198
    //   252: ireturn
    //   253: astore_1
    //   254: ldc 199
    //   256: ireturn
    //   257: astore_1
    //   258: ldc 200
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
    //   1: getfield 44	wf7/ey:pu	I
    //   4: iconst_3
    //   5: if_icmplt +7 -> 12
    //   8: aload_0
    //   9: invokespecial 139	wf7/ey:dk	()V
    //   12: aload_0
    //   13: getfield 114	wf7/ey:pt	Ljava/lang/String;
    //   16: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +23 -> 42
    //   22: new 245	java/net/URL
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 246	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: invokestatic 251	wf7/fi:getNetworkType	()I
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +23 -> 59
    //   39: ldc 252
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 114	wf7/ey:pt	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -25 -> 22
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 255	java/net/MalformedURLException:printStackTrace	()V
    //   55: ldc_w 256
    //   58: ireturn
    //   59: iconst_3
    //   60: iload_2
    //   61: if_icmpne +117 -> 178
    //   64: aload_0
    //   65: aload_1
    //   66: new 258	java/net/Proxy
    //   69: dup
    //   70: getstatic 264	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   73: invokestatic 267	wf7/fi:dH	()Ljava/lang/String;
    //   76: invokestatic 270	wf7/fi:getProxyPort	()I
    //   79: invokestatic 276	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   82: invokespecial 279	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   85: invokevirtual 283	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   88: checkcast 84	java/net/HttpURLConnection
    //   91: putfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   94: invokestatic 288	wf7/dk:bJ	()I
    //   97: bipush 8
    //   99: if_icmpge +13 -> 112
    //   102: ldc_w 290
    //   105: ldc_w 292
    //   108: invokestatic 298	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: pop
    //   112: aload_0
    //   113: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   116: iconst_0
    //   117: invokevirtual 302	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   120: aload_0
    //   121: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   124: ldc_w 304
    //   127: ldc_w 306
    //   130: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   137: ldc_w 308
    //   140: ldc_w 306
    //   143: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   150: iconst_0
    //   151: invokevirtual 311	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   154: ldc 76
    //   156: aload_0
    //   157: getfield 42	wf7/ey:pq	Ljava/lang/String;
    //   160: invokevirtual 82	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   163: ifeq +58 -> 221
    //   166: aload_0
    //   167: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   170: ldc 76
    //   172: invokevirtual 314	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   175: goto +138 -> 313
    //   178: aload_0
    //   179: aload_1
    //   180: invokevirtual 317	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   183: checkcast 84	java/net/HttpURLConnection
    //   186: putfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   189: aload_0
    //   190: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   193: sipush 15000
    //   196: invokevirtual 321	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   199: aload_0
    //   200: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   203: sipush 15000
    //   206: invokevirtual 324	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   209: goto -115 -> 94
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 325	java/net/UnknownHostException:printStackTrace	()V
    //   217: ldc_w 326
    //   220: ireturn
    //   221: aload_0
    //   222: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   225: ldc 40
    //   227: invokevirtual 314	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   234: iconst_1
    //   235: invokevirtual 329	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   238: aload_0
    //   239: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   242: iconst_1
    //   243: invokevirtual 332	java/net/HttpURLConnection:setDoInput	(Z)V
    //   246: aload_0
    //   247: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   250: ldc_w 334
    //   253: ldc_w 336
    //   256: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   263: ldc_w 338
    //   266: ldc_w 340
    //   269: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 74	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   276: ldc_w 342
    //   279: ldc_w 344
    //   282: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto +28 -> 313
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 345	java/lang/IllegalArgumentException:printStackTrace	()V
    //   293: ldc_w 346
    //   296: ireturn
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 347	java/lang/SecurityException:printStackTrace	()V
    //   302: ldc 197
    //   304: ireturn
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 348	java/io/IOException:printStackTrace	()V
    //   310: ldc 199
    //   312: ireturn
    //   313: iconst_0
    //   314: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ey
    //   0	315	1	paramString	String
    //   34	28	2	i	int
    // Exception table:
    //   from	to	target	type
    //   22	31	50	java/net/MalformedURLException
    //   31	35	212	java/net/UnknownHostException
    //   64	94	212	java/net/UnknownHostException
    //   94	112	212	java/net/UnknownHostException
    //   112	175	212	java/net/UnknownHostException
    //   178	209	212	java/net/UnknownHostException
    //   221	285	212	java/net/UnknownHostException
    //   31	35	288	java/lang/IllegalArgumentException
    //   64	94	288	java/lang/IllegalArgumentException
    //   94	112	288	java/lang/IllegalArgumentException
    //   112	175	288	java/lang/IllegalArgumentException
    //   178	209	288	java/lang/IllegalArgumentException
    //   221	285	288	java/lang/IllegalArgumentException
    //   31	35	297	java/lang/SecurityException
    //   64	94	297	java/lang/SecurityException
    //   94	112	297	java/lang/SecurityException
    //   112	175	297	java/lang/SecurityException
    //   178	209	297	java/lang/SecurityException
    //   221	285	297	java/lang/SecurityException
    //   31	35	305	java/io/IOException
    //   64	94	305	java/io/IOException
    //   94	112	305	java/io/IOException
    //   112	175	305	java/io/IOException
    //   178	209	305	java/io/IOException
    //   221	285	305	java/io/IOException
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
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ey
 * JD-Core Version:    0.7.0.1
 */