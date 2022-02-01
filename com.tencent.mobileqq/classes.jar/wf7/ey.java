package wf7;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;

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
  private int a(byte[] paramArrayOfByte, java.util.concurrent.atomic.AtomicReference<byte[]> paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   4: ifnonnull +7 -> 11
    //   7: sipush -10000
    //   10: ireturn
    //   11: ldc 71
    //   13: aload_0
    //   14: getfield 37	wf7/ey:pq	Ljava/lang/String;
    //   17: invokevirtual 77	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   20: ifeq +6 -> 26
    //   23: goto +46 -> 69
    //   26: aload_0
    //   27: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   30: astore 4
    //   32: new 79	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: ldc 82
    //   45: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: aload_1
    //   52: arraylength
    //   53: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc 91
    //   61: aload 5
    //   63: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 101	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   73: invokevirtual 105	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   76: astore 4
    //   78: aload 4
    //   80: aload_1
    //   81: invokevirtual 111	java/io/OutputStream:write	([B)V
    //   84: aload 4
    //   86: invokevirtual 114	java/io/OutputStream:flush	()V
    //   89: aload 4
    //   91: invokevirtual 117	java/io/OutputStream:close	()V
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   99: invokevirtual 121	java/net/HttpURLConnection:getResponseCode	()I
    //   102: invokespecial 125	wf7/ey:ao	(I)Z
    //   105: ifeq +24 -> 129
    //   108: aload_0
    //   109: aload_0
    //   110: invokespecial 128	wf7/ey:dl	()Ljava/lang/String;
    //   113: putfield 130	wf7/ey:pt	Ljava/lang/String;
    //   116: aload_0
    //   117: aload_0
    //   118: getfield 39	wf7/ey:pu	I
    //   121: iconst_1
    //   122: iadd
    //   123: putfield 39	wf7/ey:pu	I
    //   126: ldc 131
    //   128: ireturn
    //   129: aload_0
    //   130: invokespecial 134	wf7/ey:dk	()V
    //   133: invokestatic 140	wf7/dg:bI	()Z
    //   136: ifeq +11 -> 147
    //   139: aload_0
    //   140: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   143: invokevirtual 144	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   146: pop
    //   147: aload_0
    //   148: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   151: ldc 146
    //   153: invokevirtual 150	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_1
    //   157: aload_1
    //   158: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +6 -> 167
    //   164: ldc 157
    //   166: ireturn
    //   167: aload_1
    //   168: ldc 159
    //   170: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifne +6 -> 179
    //   176: ldc 157
    //   178: ireturn
    //   179: aload_2
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 69	wf7/ey:pr	Ljava/net/HttpURLConnection;
    //   185: invokevirtual 167	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   188: invokespecial 170	wf7/ey:a	(Ljava/io/InputStream;)[B
    //   191: invokevirtual 176	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: ldc 177
    //   198: ireturn
    //   199: astore_1
    //   200: goto +47 -> 247
    //   203: ldc 178
    //   205: ireturn
    //   206: ldc 179
    //   208: ireturn
    //   209: ldc 180
    //   211: ireturn
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 181	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   217: ldc 182
    //   219: invokestatic 188	wf7/dm:g	(Ljava/lang/String;I)I
    //   222: ireturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 189	java/net/SocketException:toString	()Ljava/lang/String;
    //   228: ldc 190
    //   230: invokestatic 188	wf7/dm:g	(Ljava/lang/String;I)I
    //   233: ireturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 191	java/net/ConnectException:toString	()Ljava/lang/String;
    //   239: ldc 192
    //   241: invokestatic 188	wf7/dm:g	(Ljava/lang/String;I)I
    //   244: istore_3
    //   245: iload_3
    //   246: ireturn
    //   247: aload_1
    //   248: athrow
    //   249: ldc 193
    //   251: ireturn
    //   252: ldc 194
    //   254: ireturn
    //   255: ldc 195
    //   257: ireturn
    //   258: ldc 196
    //   260: ireturn
    //   261: astore_1
    //   262: goto -4 -> 258
    //   265: astore_1
    //   266: goto -11 -> 255
    //   269: astore_1
    //   270: goto -18 -> 252
    //   273: astore_1
    //   274: goto -25 -> 249
    //   277: astore_1
    //   278: goto -69 -> 209
    //   281: astore_1
    //   282: goto -76 -> 206
    //   285: astore_1
    //   286: goto -83 -> 203
    //   289: astore_1
    //   290: goto -94 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	ey
    //   0	293	1	paramArrayOfByte	byte[]
    //   0	293	2	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<byte[]>
    //   244	2	3	i	int
    //   30	60	4	localObject	Object
    //   39	23	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	126	199	finally
    //   129	133	199	finally
    //   133	147	199	finally
    //   147	164	199	finally
    //   167	176	199	finally
    //   179	194	199	finally
    //   213	223	199	finally
    //   224	234	199	finally
    //   235	245	199	finally
    //   69	126	212	java/lang/SecurityException
    //   129	133	212	java/lang/SecurityException
    //   133	147	212	java/lang/SecurityException
    //   147	164	212	java/lang/SecurityException
    //   167	176	212	java/lang/SecurityException
    //   179	194	212	java/lang/SecurityException
    //   69	126	223	java/net/SocketException
    //   129	133	223	java/net/SocketException
    //   133	147	223	java/net/SocketException
    //   147	164	223	java/net/SocketException
    //   167	176	223	java/net/SocketException
    //   179	194	223	java/net/SocketException
    //   69	126	234	java/net/ConnectException
    //   129	133	234	java/net/ConnectException
    //   133	147	234	java/net/ConnectException
    //   147	164	234	java/net/ConnectException
    //   167	176	234	java/net/ConnectException
    //   179	194	234	java/net/ConnectException
    //   69	126	261	java/net/UnknownHostException
    //   129	133	261	java/net/UnknownHostException
    //   133	147	261	java/net/UnknownHostException
    //   147	164	261	java/net/UnknownHostException
    //   167	176	261	java/net/UnknownHostException
    //   179	194	261	java/net/UnknownHostException
    //   69	126	265	java/lang/IllegalAccessError
    //   129	133	265	java/lang/IllegalAccessError
    //   133	147	265	java/lang/IllegalAccessError
    //   147	164	265	java/lang/IllegalAccessError
    //   167	176	265	java/lang/IllegalAccessError
    //   179	194	265	java/lang/IllegalAccessError
    //   69	126	269	java/lang/IllegalStateException
    //   129	133	269	java/lang/IllegalStateException
    //   133	147	269	java/lang/IllegalStateException
    //   147	164	269	java/lang/IllegalStateException
    //   167	176	269	java/lang/IllegalStateException
    //   179	194	269	java/lang/IllegalStateException
    //   69	126	273	java/net/ProtocolException
    //   129	133	273	java/net/ProtocolException
    //   133	147	273	java/net/ProtocolException
    //   147	164	273	java/net/ProtocolException
    //   167	176	273	java/net/ProtocolException
    //   179	194	273	java/net/ProtocolException
    //   69	126	277	java/net/SocketTimeoutException
    //   129	133	277	java/net/SocketTimeoutException
    //   133	147	277	java/net/SocketTimeoutException
    //   147	164	277	java/net/SocketTimeoutException
    //   167	176	277	java/net/SocketTimeoutException
    //   179	194	277	java/net/SocketTimeoutException
    //   69	126	281	java/io/IOException
    //   129	133	281	java/io/IOException
    //   133	147	281	java/io/IOException
    //   147	164	281	java/io/IOException
    //   167	176	281	java/io/IOException
    //   179	194	281	java/io/IOException
    //   69	126	285	java/lang/Exception
    //   129	133	285	java/lang/Exception
    //   133	147	289	java/lang/Exception
    //   147	164	289	java/lang/Exception
    //   167	176	289	java/lang/Exception
    //   179	194	289	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore 4
    //   7: new 200	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 201	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_3
    //   15: aload_1
    //   16: aload 4
    //   18: invokevirtual 207	java/io/InputStream:read	([B)I
    //   21: istore_2
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +14 -> 38
    //   27: aload_3
    //   28: aload 4
    //   30: iconst_0
    //   31: iload_2
    //   32: invokevirtual 210	java/io/ByteArrayOutputStream:write	([BII)V
    //   35: goto -20 -> 15
    //   38: aload_3
    //   39: invokevirtual 214	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_1
    //   43: aload_3
    //   44: invokevirtual 215	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: goto +44 -> 94
    //   53: astore_1
    //   54: new 79	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   61: astore 4
    //   63: aload 4
    //   65: ldc 217
    //   67: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: aload_1
    //   74: invokevirtual 220	java/io/IOException:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: new 222	java/lang/RuntimeException
    //   84: dup
    //   85: aload 4
    //   87: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 225	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   93: athrow
    //   94: aload_3
    //   95: invokevirtual 215	java/io/ByteArrayOutputStream:close	()V
    //   98: goto +5 -> 103
    //   101: aload_1
    //   102: athrow
    //   103: goto -2 -> 101
    //   106: astore_3
    //   107: aload_1
    //   108: areturn
    //   109: astore_3
    //   110: goto -12 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ey
    //   0	113	1	paramInputStream	java.io.InputStream
    //   21	11	2	i	int
    //   14	81	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   106	1	3	localException1	Exception
    //   109	1	3	localException2	Exception
    //   5	81	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	49	finally
    //   27	35	49	finally
    //   38	43	49	finally
    //   54	94	49	finally
    //   15	22	53	java/io/IOException
    //   27	35	53	java/io/IOException
    //   38	43	53	java/io/IOException
    //   43	47	106	java/lang/Exception
    //   94	98	109	java/lang/Exception
  }
  
  private boolean ao(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  private boolean dj()
  {
    HttpURLConnection localHttpURLConnection = this.pr;
    if (localHttpURLConnection == null) {
      return false;
    }
    try
    {
      localHttpURLConnection.disconnect();
      this.pr = null;
      label20:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label20;
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
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  private int start(String paramString)
  {
    if (this.pu >= 3) {
      dk();
    }
    if (!TextUtils.isEmpty(this.pt)) {
      paramString = this.pt;
    }
    try
    {
      paramString = new URL(paramString);
      try
      {
        int i = fi.getNetworkType();
        if (i == 0) {
          return -220000;
        }
        if (3 == i)
        {
          this.pr = ((HttpURLConnection)paramString.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(fi.dH(), fi.getProxyPort()))));
        }
        else
        {
          this.pr = ((HttpURLConnection)paramString.openConnection());
          this.pr.setReadTimeout(15000);
          this.pr.setConnectTimeout(15000);
        }
        if (dk.bJ() < 8) {
          System.setProperty("http.keepAlive", "false");
        }
        this.pr.setUseCaches(false);
        this.pr.setRequestProperty("Pragma", "no-cache");
        this.pr.setRequestProperty("Cache-Control", "no-cache");
        this.pr.setInstanceFollowRedirects(false);
        if ("GET".equalsIgnoreCase(this.pq))
        {
          this.pr.setRequestMethod("GET");
          return 0;
        }
        this.pr.setRequestMethod("POST");
        this.pr.setDoOutput(true);
        this.pr.setDoInput(true);
        this.pr.setRequestProperty("Accept", "*/*");
        this.pr.setRequestProperty("Accept-Charset", "utf-8");
        this.pr.setRequestProperty("Content-Type", "application/octet-stream");
        return 0;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return -140000;
      }
      catch (SecurityException paramString)
      {
        paramString.printStackTrace();
        return -440000;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        return -240000;
      }
      catch (UnknownHostException paramString)
      {
        paramString.printStackTrace();
        return -520000;
      }
      return -510000;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  int a(em.d paramd, byte[] paramArrayOfByte, java.util.concurrent.atomic.AtomicReference<byte[]> paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +311 -> 314
    //   6: aload_1
    //   7: ifnonnull +6 -> 13
    //   10: goto +304 -> 314
    //   13: aload_1
    //   14: getfield 352	wf7/em$d:ns	I
    //   17: sipush 2048
    //   20: if_icmpne +304 -> 324
    //   23: iconst_1
    //   24: istore 6
    //   26: goto +301 -> 327
    //   29: iload 4
    //   31: istore 5
    //   33: iload 8
    //   35: iload 7
    //   37: if_icmpge +267 -> 304
    //   40: invokestatic 247	wf7/fi:getNetworkType	()I
    //   43: istore 4
    //   45: iload 4
    //   47: ifne +8 -> 55
    //   50: aload_0
    //   51: monitorexit
    //   52: ldc 248
    //   54: ireturn
    //   55: aload_1
    //   56: invokevirtual 355	wf7/em$d:cW	()Z
    //   59: istore 9
    //   61: iload 9
    //   63: ifeq +8 -> 71
    //   66: aload_0
    //   67: monitorexit
    //   68: bipush 239
    //   70: ireturn
    //   71: iload 6
    //   73: ifeq +92 -> 165
    //   76: aload_0
    //   77: getfield 41	wf7/ey:lh	Z
    //   80: aload_0
    //   81: getfield 43	wf7/ey:mC	Lwf7/dt;
    //   84: invokestatic 360	wf7/dn:a	(ZLwf7/dt;)Ljava/lang/String;
    //   87: astore 11
    //   89: aload 11
    //   91: astore 10
    //   93: aload 11
    //   95: ifnull +81 -> 176
    //   98: aload 11
    //   100: invokevirtual 363	java/lang/String:length	()I
    //   103: bipush 7
    //   105: if_icmplt +24 -> 129
    //   108: aload 11
    //   110: astore 10
    //   112: aload 11
    //   114: iconst_0
    //   115: bipush 7
    //   117: invokevirtual 367	java/lang/String:substring	(II)Ljava/lang/String;
    //   120: ldc_w 369
    //   123: invokevirtual 77	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   126: ifne +50 -> 176
    //   129: new 79	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   136: astore 10
    //   138: aload 10
    //   140: ldc_w 369
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 10
    //   149: aload 11
    //   151: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 10
    //   157: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 10
    //   162: goto +14 -> 176
    //   165: aload_0
    //   166: getfield 45	wf7/ey:ps	Lwf7/eu;
    //   169: invokeinterface 374 1 0
    //   174: astore 10
    //   176: aload_0
    //   177: aload 10
    //   179: invokespecial 376	wf7/ey:start	(Ljava/lang/String;)I
    //   182: istore 5
    //   184: iload 5
    //   186: istore 4
    //   188: iload 5
    //   190: ifne +16 -> 206
    //   193: aload_1
    //   194: iconst_1
    //   195: putfield 379	wf7/em$d:nH	Z
    //   198: aload_0
    //   199: aload_2
    //   200: aload_3
    //   201: invokespecial 381	wf7/ey:a	([BLjava/util/concurrent/atomic/AtomicReference;)I
    //   204: istore 4
    //   206: aload_0
    //   207: invokespecial 383	wf7/ey:dj	()Z
    //   210: pop
    //   211: iload 4
    //   213: istore 5
    //   215: iload 4
    //   217: ifeq +87 -> 304
    //   220: iload 4
    //   222: ldc 248
    //   224: if_icmpne +10 -> 234
    //   227: iload 4
    //   229: istore 5
    //   231: goto +73 -> 304
    //   234: iload 4
    //   236: ldc 131
    //   238: if_icmpeq +20 -> 258
    //   241: ldc_w 385
    //   244: invokestatic 387	wf7/fi:I	(Ljava/lang/String;)Z
    //   247: ifeq +11 -> 258
    //   250: ldc_w 388
    //   253: istore 5
    //   255: goto +49 -> 304
    //   258: iload 6
    //   260: ifne +20 -> 280
    //   263: iload 4
    //   265: ldc 131
    //   267: if_icmpeq +13 -> 280
    //   270: aload_0
    //   271: getfield 45	wf7/ey:ps	Lwf7/eu;
    //   274: iconst_0
    //   275: invokeinterface 391 2 0
    //   280: iload 8
    //   282: iload 7
    //   284: iconst_1
    //   285: isub
    //   286: if_icmpge +9 -> 295
    //   289: ldc2_w 392
    //   292: invokestatic 399	java/lang/Thread:sleep	(J)V
    //   295: iload 8
    //   297: iconst_1
    //   298: iadd
    //   299: istore 8
    //   301: goto -272 -> 29
    //   304: aload_0
    //   305: monitorexit
    //   306: iload 5
    //   308: ireturn
    //   309: astore_1
    //   310: aload_0
    //   311: monitorexit
    //   312: aload_1
    //   313: athrow
    //   314: aload_0
    //   315: monitorexit
    //   316: bipush 246
    //   318: ireturn
    //   319: astore 10
    //   321: goto -26 -> 295
    //   324: iconst_0
    //   325: istore 6
    //   327: iconst_3
    //   328: istore 7
    //   330: iload 6
    //   332: ifeq +6 -> 338
    //   335: iconst_1
    //   336: istore 7
    //   338: iconst_0
    //   339: istore 8
    //   341: iconst_m1
    //   342: istore 4
    //   344: goto -315 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	ey
    //   0	347	1	paramd	em.d
    //   0	347	2	paramArrayOfByte	byte[]
    //   0	347	3	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<byte[]>
    //   29	314	4	i	int
    //   31	276	5	j	int
    //   24	307	6	k	int
    //   35	302	7	m	int
    //   33	307	8	n	int
    //   59	3	9	bool	boolean
    //   91	87	10	localObject	Object
    //   319	1	10	localInterruptedException	java.lang.InterruptedException
    //   87	63	11	str	String
    // Exception table:
    //   from	to	target	type
    //   13	23	309	finally
    //   40	45	309	finally
    //   55	61	309	finally
    //   76	89	309	finally
    //   98	108	309	finally
    //   112	129	309	finally
    //   129	162	309	finally
    //   165	176	309	finally
    //   176	184	309	finally
    //   193	206	309	finally
    //   206	211	309	finally
    //   241	250	309	finally
    //   270	280	309	finally
    //   289	295	309	finally
    //   289	295	319	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ey
 * JD-Core Version:    0.7.0.1
 */