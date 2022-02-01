package tmsdk.common.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import b.a;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.d.a.b.e;
import tmsdk.common.e.k;

public class b
{
  private static String a = "HttpNetwork";
  private final int b = 5;
  private final int c = 3;
  private String d = "POST";
  private boolean e = false;
  private HttpURLConnection f;
  private d g;
  private String h;
  private int i = 0;
  private e j;
  private volatile String k = null;
  
  public b(Context paramContext, boolean paramBoolean, e parame)
  {
    this.j = parame;
    this.g = new d(paramContext, paramBoolean, parame);
  }
  
  private void a(int paramInt)
  {
    if ((-70000 == paramInt) || (-130000 == paramInt) || (-170000 == paramInt)) {
      this.g.d();
    }
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore 5
    //   7: new 65	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 68	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_3
    //   16: new 70	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 71	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore 4
    //   25: aload_1
    //   26: aload 5
    //   28: invokevirtual 77	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +15 -> 49
    //   37: aload 4
    //   39: aload 5
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 81	java/io/ByteArrayOutputStream:write	([BII)V
    //   46: goto -21 -> 25
    //   49: aload 4
    //   51: invokevirtual 85	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   54: astore_1
    //   55: aload_3
    //   56: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   59: aload 4
    //   61: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: areturn
    //   73: astore_1
    //   74: goto +46 -> 120
    //   77: astore_1
    //   78: new 94	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   85: astore 5
    //   87: aload 5
    //   89: ldc 97
    //   91: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 5
    //   97: aload_1
    //   98: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 107	tmsdk/common/b/a
    //   108: dup
    //   109: bipush 200
    //   111: aload 5
    //   113: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 113	tmsdk/common/b/a:<init>	(ILjava/lang/String;)V
    //   119: athrow
    //   120: aload_3
    //   121: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   124: aload 4
    //   126: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   129: goto +8 -> 137
    //   132: astore_3
    //   133: aload_3
    //   134: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	b
    //   0	139	1	paramInputStream	java.io.InputStream
    //   31	12	2	m	int
    //   15	41	3	localBufferedInputStream	java.io.BufferedInputStream
    //   66	55	3	localException1	Exception
    //   132	2	3	localException2	Exception
    //   23	102	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   5	107	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	66	java/lang/Exception
    //   25	32	73	finally
    //   37	46	73	finally
    //   49	55	73	finally
    //   78	120	73	finally
    //   25	32	77	java/io/IOException
    //   37	46	77	java/io/IOException
    //   49	55	77	java/io/IOException
    //   120	129	132	java/lang/Exception
  }
  
  /* Error */
  private int b(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   4: ifnonnull +7 -> 11
    //   7: sipush -10000
    //   10: ireturn
    //   11: ldc 132
    //   13: aload_0
    //   14: getfield 38	tmsdk/common/d/a/a/b:d	Ljava/lang/String;
    //   17: invokevirtual 138	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   20: ifeq +6 -> 26
    //   23: goto +46 -> 69
    //   26: aload_0
    //   27: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   30: astore 5
    //   32: new 94	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   39: astore 6
    //   41: aload 6
    //   43: ldc 140
    //   45: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 6
    //   51: aload_1
    //   52: arraylength
    //   53: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: ldc 145
    //   61: aload 6
    //   63: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   72: lstore_3
    //   73: aload_0
    //   74: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   77: invokevirtual 161	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   80: astore 5
    //   82: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   85: lload_3
    //   86: lsub
    //   87: lstore_3
    //   88: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   91: astore 6
    //   93: new 94	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   100: astore 6
    //   102: aload 6
    //   104: ldc 165
    //   106: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: lload_3
    //   113: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 6
    //   119: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: pop
    //   123: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   126: astore 6
    //   128: new 94	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   135: astore 6
    //   137: aload 6
    //   139: ldc 165
    //   141: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 6
    //   147: lload_3
    //   148: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 6
    //   154: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: pop
    //   158: aload_0
    //   159: getfield 46	tmsdk/common/d/a/a/b:j	Ltmsdk/common/d/a/b/e;
    //   162: astore 6
    //   164: aload 5
    //   166: aload_1
    //   167: invokevirtual 173	java/io/OutputStream:write	([B)V
    //   170: aload 5
    //   172: invokevirtual 176	java/io/OutputStream:flush	()V
    //   175: aload 5
    //   177: invokevirtual 177	java/io/OutputStream:close	()V
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   185: invokevirtual 181	java/net/HttpURLConnection:getResponseCode	()I
    //   188: invokespecial 184	tmsdk/common/d/a/a/b:b	(I)Z
    //   191: ifeq +122 -> 313
    //   194: aload_0
    //   195: aload_0
    //   196: invokespecial 186	tmsdk/common/d/a/a/b:i	()Ljava/lang/String;
    //   199: putfield 188	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   202: aload_0
    //   203: aload_0
    //   204: getfield 42	tmsdk/common/d/a/a/b:i	I
    //   207: iconst_1
    //   208: iadd
    //   209: putfield 42	tmsdk/common/d/a/a/b:i	I
    //   212: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   215: astore_1
    //   216: new 94	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   223: astore_1
    //   224: aload_1
    //   225: ldc 190
    //   227: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: aload_0
    //   233: getfield 188	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   236: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: ldc 192
    //   243: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: aload_0
    //   249: getfield 42	tmsdk/common/d/a/a/b:i	I
    //   252: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_1
    //   257: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: pop
    //   261: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   264: astore_1
    //   265: new 94	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   272: astore_1
    //   273: aload_1
    //   274: ldc 190
    //   276: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_1
    //   281: aload_0
    //   282: getfield 188	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   285: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: ldc 192
    //   292: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload_0
    //   298: getfield 42	tmsdk/common/d/a/a/b:i	I
    //   301: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: pop
    //   310: ldc 193
    //   312: ireturn
    //   313: aload_0
    //   314: invokespecial 195	tmsdk/common/d/a/a/b:h	()V
    //   317: aload_0
    //   318: invokespecial 197	tmsdk/common/d/a/a/b:e	()V
    //   321: aload_0
    //   322: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   325: invokevirtual 201	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   328: astore_1
    //   329: aload_1
    //   330: ifnull +78 -> 408
    //   333: aload_1
    //   334: invokevirtual 202	java/lang/Object:toString	()Ljava/lang/String;
    //   337: astore_1
    //   338: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   341: astore 5
    //   343: new 94	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   350: astore 5
    //   352: aload 5
    //   354: ldc 204
    //   356: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 5
    //   362: aload_1
    //   363: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 5
    //   369: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: pop
    //   373: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   376: astore 5
    //   378: new 94	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   385: astore 5
    //   387: aload 5
    //   389: ldc 204
    //   391: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 5
    //   397: aload_1
    //   398: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 5
    //   404: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: pop
    //   408: aload_0
    //   409: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   412: ldc 206
    //   414: invokevirtual 210	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   417: astore_1
    //   418: aload_1
    //   419: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   422: ifeq +14 -> 436
    //   425: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   428: astore_1
    //   429: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   432: astore_1
    //   433: ldc 56
    //   435: ireturn
    //   436: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   439: astore 5
    //   441: new 94	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   448: astore 5
    //   450: aload 5
    //   452: ldc 218
    //   454: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 5
    //   460: aload_1
    //   461: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 5
    //   467: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: pop
    //   471: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   474: astore 5
    //   476: new 94	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   483: astore 5
    //   485: aload 5
    //   487: ldc 218
    //   489: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 5
    //   495: aload_1
    //   496: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 5
    //   502: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: pop
    //   506: aload_1
    //   507: ldc 220
    //   509: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: ifne +14 -> 526
    //   515: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   518: astore_1
    //   519: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   522: astore_1
    //   523: ldc 56
    //   525: ireturn
    //   526: aload_2
    //   527: aload_0
    //   528: aload_0
    //   529: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   532: invokevirtual 228	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   535: invokespecial 230	tmsdk/common/d/a/a/b:a	(Ljava/io/InputStream;)[B
    //   538: invokevirtual 236	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   541: iconst_0
    //   542: ireturn
    //   543: astore_1
    //   544: aload_1
    //   545: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   548: ldc 237
    //   550: ireturn
    //   551: astore_1
    //   552: goto +85 -> 637
    //   555: astore_1
    //   556: aload_1
    //   557: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   560: ldc 238
    //   562: ireturn
    //   563: astore_1
    //   564: aload_1
    //   565: invokevirtual 239	java/io/IOException:printStackTrace	()V
    //   568: ldc 240
    //   570: ireturn
    //   571: astore_1
    //   572: aload_1
    //   573: invokevirtual 241	java/net/SocketTimeoutException:printStackTrace	()V
    //   576: ldc 55
    //   578: ireturn
    //   579: astore_1
    //   580: aload_0
    //   581: invokespecial 244	tmsdk/common/d/a/a/b:d	()Z
    //   584: ifeq +6 -> 590
    //   587: ldc 245
    //   589: ireturn
    //   590: aload_1
    //   591: invokevirtual 246	java/net/SocketException:printStackTrace	()V
    //   594: ldc 247
    //   596: ireturn
    //   597: astore_1
    //   598: aload_1
    //   599: invokevirtual 248	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   602: ldc 249
    //   604: ireturn
    //   605: astore_1
    //   606: aload_1
    //   607: invokevirtual 250	java/net/ProtocolException:printStackTrace	()V
    //   610: ldc 251
    //   612: ireturn
    //   613: astore_1
    //   614: aload_1
    //   615: invokevirtual 252	java/lang/IllegalStateException:printStackTrace	()V
    //   618: ldc 253
    //   620: ireturn
    //   621: astore_1
    //   622: aload_1
    //   623: invokevirtual 254	java/lang/IllegalAccessError:printStackTrace	()V
    //   626: ldc 255
    //   628: ireturn
    //   629: astore_1
    //   630: aload_1
    //   631: invokevirtual 256	java/net/UnknownHostException:printStackTrace	()V
    //   634: ldc 54
    //   636: ireturn
    //   637: aload_1
    //   638: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	this	b
    //   0	639	1	paramArrayOfByte	byte[]
    //   0	639	2	paramAtomicReference	AtomicReference
    //   72	76	3	l	long
    //   30	471	5	localObject1	Object
    //   39	124	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   321	329	543	java/lang/Exception
    //   333	408	543	java/lang/Exception
    //   408	433	543	java/lang/Exception
    //   436	523	543	java/lang/Exception
    //   526	541	543	java/lang/Exception
    //   69	310	551	finally
    //   313	321	551	finally
    //   321	329	551	finally
    //   333	408	551	finally
    //   408	433	551	finally
    //   436	523	551	finally
    //   526	541	551	finally
    //   544	548	551	finally
    //   556	560	551	finally
    //   564	568	551	finally
    //   572	576	551	finally
    //   580	587	551	finally
    //   590	594	551	finally
    //   598	602	551	finally
    //   606	610	551	finally
    //   614	618	551	finally
    //   622	626	551	finally
    //   630	634	551	finally
    //   69	310	555	java/lang/Exception
    //   313	321	555	java/lang/Exception
    //   544	548	555	java/lang/Exception
    //   69	310	563	java/io/IOException
    //   313	321	563	java/io/IOException
    //   321	329	563	java/io/IOException
    //   333	408	563	java/io/IOException
    //   408	433	563	java/io/IOException
    //   436	523	563	java/io/IOException
    //   526	541	563	java/io/IOException
    //   544	548	563	java/io/IOException
    //   69	310	571	java/net/SocketTimeoutException
    //   313	321	571	java/net/SocketTimeoutException
    //   321	329	571	java/net/SocketTimeoutException
    //   333	408	571	java/net/SocketTimeoutException
    //   408	433	571	java/net/SocketTimeoutException
    //   436	523	571	java/net/SocketTimeoutException
    //   526	541	571	java/net/SocketTimeoutException
    //   544	548	571	java/net/SocketTimeoutException
    //   69	310	579	java/net/SocketException
    //   313	321	579	java/net/SocketException
    //   321	329	579	java/net/SocketException
    //   333	408	579	java/net/SocketException
    //   408	433	579	java/net/SocketException
    //   436	523	579	java/net/SocketException
    //   526	541	579	java/net/SocketException
    //   544	548	579	java/net/SocketException
    //   69	310	597	org/apache/http/client/ClientProtocolException
    //   313	321	597	org/apache/http/client/ClientProtocolException
    //   321	329	597	org/apache/http/client/ClientProtocolException
    //   333	408	597	org/apache/http/client/ClientProtocolException
    //   408	433	597	org/apache/http/client/ClientProtocolException
    //   436	523	597	org/apache/http/client/ClientProtocolException
    //   526	541	597	org/apache/http/client/ClientProtocolException
    //   544	548	597	org/apache/http/client/ClientProtocolException
    //   69	310	605	java/net/ProtocolException
    //   313	321	605	java/net/ProtocolException
    //   321	329	605	java/net/ProtocolException
    //   333	408	605	java/net/ProtocolException
    //   408	433	605	java/net/ProtocolException
    //   436	523	605	java/net/ProtocolException
    //   526	541	605	java/net/ProtocolException
    //   544	548	605	java/net/ProtocolException
    //   69	310	613	java/lang/IllegalStateException
    //   313	321	613	java/lang/IllegalStateException
    //   321	329	613	java/lang/IllegalStateException
    //   333	408	613	java/lang/IllegalStateException
    //   408	433	613	java/lang/IllegalStateException
    //   436	523	613	java/lang/IllegalStateException
    //   526	541	613	java/lang/IllegalStateException
    //   544	548	613	java/lang/IllegalStateException
    //   69	310	621	java/lang/IllegalAccessError
    //   313	321	621	java/lang/IllegalAccessError
    //   321	329	621	java/lang/IllegalAccessError
    //   333	408	621	java/lang/IllegalAccessError
    //   408	433	621	java/lang/IllegalAccessError
    //   436	523	621	java/lang/IllegalAccessError
    //   526	541	621	java/lang/IllegalAccessError
    //   544	548	621	java/lang/IllegalAccessError
    //   69	310	629	java/net/UnknownHostException
    //   313	321	629	java/net/UnknownHostException
    //   321	329	629	java/net/UnknownHostException
    //   333	408	629	java/net/UnknownHostException
    //   408	433	629	java/net/UnknownHostException
    //   436	523	629	java/net/UnknownHostException
    //   526	541	629	java/net/UnknownHostException
    //   544	548	629	java/net/UnknownHostException
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  private boolean d()
  {
    Object localObject1 = tmsdk.common.e.f.a();
    int m;
    if (a.c == localObject1) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return false;
    }
    localObject1 = null;
    try
    {
      String str = k.a(new c(this));
      localObject1 = str;
    }
    catch (tmsdk.common.b.b localb)
    {
      Object localObject2 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkWifiApprovement() WifiApproveException e: ");
      ((StringBuilder)localObject2).append(localb.toString());
      ((StringBuilder)localObject2).toString();
      localObject2 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkWifiApprovement() WifiApproveException e: ");
      ((StringBuilder)localObject2).append(localb.toString());
      ((StringBuilder)localObject2).toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    this.k = ((String)localObject1);
    localObject1 = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkWifiApprovement() mWifiApprovementUrl: ");
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).toString();
    localObject1 = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkWifiApprovement() mWifiApprovementUrl: ");
    ((StringBuilder)localObject1).append(this.k);
    ((StringBuilder)localObject1).toString();
    return true;
  }
  
  private void e()
  {
    this.k = null;
  }
  
  private boolean f()
  {
    return this.e;
  }
  
  private void g()
  {
    if (this.i >= 3) {
      h();
    }
  }
  
  private void h()
  {
    this.h = null;
    this.i = 0;
  }
  
  private String i()
  {
    String str = a;
    try
    {
      str = this.f.getHeaderField("Location");
      return str;
    }
    catch (Exception localException)
    {
      Object localObject = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRedirectUrl() e: ");
      ((StringBuilder)localObject).append(localException.toString());
      ((StringBuilder)localObject).toString();
      localObject = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRedirectUrl() e: ");
      ((StringBuilder)localObject).append(localException.toString());
      ((StringBuilder)localObject).toString();
    }
    return null;
  }
  
  public int a(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    if (paramArrayOfByte == null) {
      return -10;
    }
    try
    {
      boolean bool = tmsdk.common.c.a.f.a();
      if (bool) {
        return -7;
      }
      Object localObject1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendData() data.length: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      ((StringBuilder)localObject1).toString();
      localObject1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendData() data.length: ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      ((StringBuilder)localObject1).toString();
      int m = -1;
      int n = 0;
      int i1;
      for (;;)
      {
        i1 = m;
        if (n >= 5) {
          break;
        }
        bool = f();
        localObject1 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendData() hasStart: ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).toString();
        localObject1 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendData() hasStart: ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).toString();
        localObject1 = new AtomicReference();
        if ((bool) || (a((AtomicReference)localObject1)))
        {
          i1 = b(paramArrayOfByte, paramAtomicReference);
          if (i1 == 0)
          {
            paramArrayOfByte = a;
            paramArrayOfByte = a;
            b();
            this.g.a((String)((AtomicReference)localObject1).get());
            break;
          }
          if (-160000 == i1)
          {
            paramArrayOfByte = a;
            paramArrayOfByte = a;
            b();
            break;
          }
          localObject1 = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sendData() ret: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).toString();
          localObject1 = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sendData() ret: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).toString();
          b();
          a(i1);
          m = i1;
          if (4 != n) {
            try
            {
              Thread.sleep(3000L);
              m = i1;
            }
            catch (InterruptedException localInterruptedException)
            {
              Object localObject2 = a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("sendData() InterruptedException e: ");
              ((StringBuilder)localObject2).append(localInterruptedException.toString());
              ((StringBuilder)localObject2).toString();
              localObject2 = a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("sendData() InterruptedException e: ");
              ((StringBuilder)localObject2).append(localInterruptedException.toString());
              ((StringBuilder)localObject2).toString();
              m = i1;
            }
          }
        }
        n += 1;
      }
      return i1;
    }
    finally {}
  }
  
  public d a()
  {
    return this.g;
  }
  
  /* Error */
  public boolean a(AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   5: astore 4
    //   7: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   10: astore 4
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 40	tmsdk/common/d/a/a/b:e	Z
    //   17: aload_0
    //   18: invokespecial 344	tmsdk/common/d/a/a/b:g	()V
    //   21: aload_0
    //   22: getfield 188	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   25: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +33 -> 61
    //   31: aload_0
    //   32: getfield 52	tmsdk/common/d/a/a/b:g	Ltmsdk/common/d/a/a/d;
    //   35: invokevirtual 346	tmsdk/common/d/a/a/d:c	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload 5
    //   42: astore 4
    //   44: aload_1
    //   45: ifnull +22 -> 67
    //   48: aload_1
    //   49: aload 5
    //   51: invokevirtual 236	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   54: aload 5
    //   56: astore 4
    //   58: goto +9 -> 67
    //   61: aload_0
    //   62: getfield 188	tmsdk/common/d/a/a/b:h	Ljava/lang/String;
    //   65: astore 4
    //   67: invokestatic 263	tmsdk/common/e/f:a	()Lb/a;
    //   70: astore_1
    //   71: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   74: astore 5
    //   76: new 94	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   83: astore 5
    //   85: aload 5
    //   87: ldc_w 348
    //   90: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 5
    //   96: aload 4
    //   98: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 5
    //   104: ldc_w 350
    //   107: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: aload_1
    //   114: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 5
    //   120: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: pop
    //   124: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   127: astore 5
    //   129: new 94	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   136: astore 5
    //   138: aload 5
    //   140: ldc_w 348
    //   143: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 5
    //   149: aload 4
    //   151: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 5
    //   157: ldc_w 350
    //   160: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload_1
    //   167: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: pop
    //   177: getstatic 355	b/a:a	Lb/a;
    //   180: aload_1
    //   181: if_acmpne +15 -> 196
    //   184: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   187: astore_1
    //   188: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: iconst_0
    //   195: ireturn
    //   196: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   199: lstore_2
    //   200: new 357	java/net/URL
    //   203: dup
    //   204: aload 4
    //   206: invokespecial 359	java/net/URL:<init>	(Ljava/lang/String;)V
    //   209: astore 4
    //   211: getstatic 361	b/a:d	Lb/a;
    //   214: aload_1
    //   215: if_acmpne +37 -> 252
    //   218: aload_0
    //   219: aload 4
    //   221: new 363	java/net/Proxy
    //   224: dup
    //   225: getstatic 369	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   228: invokestatic 370	tmsdk/common/e/f:c	()Ljava/lang/String;
    //   231: invokestatic 372	tmsdk/common/e/f:d	()I
    //   234: invokestatic 378	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   237: invokespecial 381	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   240: invokevirtual 385	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   243: checkcast 147	java/net/HttpURLConnection
    //   246: putfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   249: goto +35 -> 284
    //   252: aload_0
    //   253: aload 4
    //   255: invokevirtual 388	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   258: checkcast 147	java/net/HttpURLConnection
    //   261: putfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   264: aload_0
    //   265: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   268: sipush 30000
    //   271: invokevirtual 391	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   274: aload_0
    //   275: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   278: sipush 30000
    //   281: invokevirtual 394	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   284: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   287: lload_2
    //   288: lsub
    //   289: lstore_2
    //   290: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   293: astore_1
    //   294: new 94	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   301: astore_1
    //   302: aload_1
    //   303: ldc_w 396
    //   306: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_1
    //   311: lload_2
    //   312: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: pop
    //   321: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   324: astore_1
    //   325: new 94	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   332: astore_1
    //   333: aload_1
    //   334: ldc_w 396
    //   337: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: lload_2
    //   343: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_1
    //   348: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: pop
    //   352: invokestatic 400	tmsdk/common/e/i:a	()I
    //   355: bipush 8
    //   357: if_icmpge +13 -> 370
    //   360: ldc_w 402
    //   363: ldc_w 404
    //   366: invokestatic 408	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   369: pop
    //   370: aload_0
    //   371: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   374: iconst_0
    //   375: invokevirtual 412	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   378: aload_0
    //   379: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   382: ldc_w 414
    //   385: ldc_w 416
    //   388: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_0
    //   392: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   395: ldc_w 418
    //   398: ldc_w 416
    //   401: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_0
    //   405: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   408: iconst_0
    //   409: invokevirtual 421	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   412: ldc 132
    //   414: aload_0
    //   415: getfield 38	tmsdk/common/d/a/a/b:d	Ljava/lang/String;
    //   418: invokevirtual 138	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   421: ifeq +15 -> 436
    //   424: aload_0
    //   425: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   428: ldc 132
    //   430: invokevirtual 424	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   433: goto +67 -> 500
    //   436: aload_0
    //   437: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   440: ldc 36
    //   442: invokevirtual 424	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   445: aload_0
    //   446: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   449: iconst_1
    //   450: invokevirtual 427	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   453: aload_0
    //   454: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   457: iconst_1
    //   458: invokevirtual 430	java/net/HttpURLConnection:setDoInput	(Z)V
    //   461: aload_0
    //   462: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   465: ldc_w 432
    //   468: ldc_w 434
    //   471: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: aload_0
    //   475: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   478: ldc_w 436
    //   481: ldc_w 438
    //   484: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload_0
    //   488: getfield 130	tmsdk/common/d/a/a/b:f	Ljava/net/HttpURLConnection;
    //   491: ldc_w 440
    //   494: ldc_w 442
    //   497: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload_0
    //   501: monitorexit
    //   502: iconst_1
    //   503: ireturn
    //   504: astore_1
    //   505: aload_1
    //   506: invokevirtual 239	java/io/IOException:printStackTrace	()V
    //   509: aload_0
    //   510: monitorexit
    //   511: iconst_0
    //   512: ireturn
    //   513: astore_1
    //   514: aload_1
    //   515: invokevirtual 443	java/lang/UnsupportedOperationException:printStackTrace	()V
    //   518: aload_0
    //   519: monitorexit
    //   520: iconst_0
    //   521: ireturn
    //   522: astore_1
    //   523: aload_1
    //   524: invokevirtual 444	java/lang/SecurityException:printStackTrace	()V
    //   527: aload_0
    //   528: monitorexit
    //   529: iconst_0
    //   530: ireturn
    //   531: astore_1
    //   532: aload_1
    //   533: invokevirtual 445	java/lang/IllegalArgumentException:printStackTrace	()V
    //   536: aload_0
    //   537: monitorexit
    //   538: iconst_0
    //   539: ireturn
    //   540: astore_1
    //   541: aload_1
    //   542: invokevirtual 256	java/net/UnknownHostException:printStackTrace	()V
    //   545: aload_0
    //   546: monitorexit
    //   547: iconst_0
    //   548: ireturn
    //   549: astore_1
    //   550: aload_1
    //   551: invokevirtual 446	java/net/MalformedURLException:printStackTrace	()V
    //   554: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   557: astore 4
    //   559: new 94	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   566: astore 4
    //   568: aload 4
    //   570: ldc_w 448
    //   573: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 4
    //   579: aload_1
    //   580: invokevirtual 449	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   583: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 4
    //   589: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: pop
    //   593: getstatic 163	tmsdk/common/d/a/a/b:a	Ljava/lang/String;
    //   596: astore 4
    //   598: new 94	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   605: astore 4
    //   607: aload 4
    //   609: ldc_w 448
    //   612: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 4
    //   618: aload_1
    //   619: invokevirtual 449	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   622: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 4
    //   628: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: pop
    //   632: aload_0
    //   633: monitorexit
    //   634: iconst_0
    //   635: ireturn
    //   636: astore_1
    //   637: aload_0
    //   638: monitorexit
    //   639: aload_1
    //   640: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	this	b
    //   0	641	1	paramAtomicReference	AtomicReference
    //   199	144	2	l	long
    //   5	622	4	localObject1	Object
    //   38	134	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   211	249	504	java/io/IOException
    //   252	284	504	java/io/IOException
    //   284	370	504	java/io/IOException
    //   370	433	504	java/io/IOException
    //   436	500	504	java/io/IOException
    //   211	249	513	java/lang/UnsupportedOperationException
    //   252	284	513	java/lang/UnsupportedOperationException
    //   284	370	513	java/lang/UnsupportedOperationException
    //   370	433	513	java/lang/UnsupportedOperationException
    //   436	500	513	java/lang/UnsupportedOperationException
    //   211	249	522	java/lang/SecurityException
    //   252	284	522	java/lang/SecurityException
    //   284	370	522	java/lang/SecurityException
    //   370	433	522	java/lang/SecurityException
    //   436	500	522	java/lang/SecurityException
    //   211	249	531	java/lang/IllegalArgumentException
    //   252	284	531	java/lang/IllegalArgumentException
    //   284	370	531	java/lang/IllegalArgumentException
    //   370	433	531	java/lang/IllegalArgumentException
    //   436	500	531	java/lang/IllegalArgumentException
    //   211	249	540	java/net/UnknownHostException
    //   252	284	540	java/net/UnknownHostException
    //   284	370	540	java/net/UnknownHostException
    //   370	433	540	java/net/UnknownHostException
    //   436	500	540	java/net/UnknownHostException
    //   200	211	549	java/net/MalformedURLException
    //   2	40	636	finally
    //   48	54	636	finally
    //   61	67	636	finally
    //   67	192	636	finally
    //   196	200	636	finally
    //   200	211	636	finally
    //   211	249	636	finally
    //   252	284	636	finally
    //   284	370	636	finally
    //   370	433	636	finally
    //   436	500	636	finally
    //   505	509	636	finally
    //   514	518	636	finally
    //   523	527	636	finally
    //   532	536	636	finally
    //   541	545	636	finally
    //   550	632	636	finally
  }
  
  public boolean b()
  {
    try
    {
      Object localObject1 = a;
      this.e = false;
      this.e = false;
      localObject1 = this.f;
      if (localObject1 == null) {
        return false;
      }
      this.f.disconnect();
      this.f = null;
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.a.b
 * JD-Core Version:    0.7.0.1
 */