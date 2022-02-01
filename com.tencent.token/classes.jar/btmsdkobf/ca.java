package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.tmsdk.base.utils.NetworkUtil;
import com.tmsdk.base.utils.SDKUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.QQPIM.ConnectType;

public class ca
{
  private static String TAG = "HttpNetwork";
  private final int ha = 3;
  private final int hb = 3;
  private String hc = "POST";
  private HttpURLConnection hd;
  private cl he;
  private dp hf;
  private String hg;
  private int hh = 0;
  private boolean hi = false;
  
  public ca(Context paramContext, cl paramcl, dp paramdp, boolean paramBoolean)
  {
    this.he = paramcl;
    this.hf = paramdp;
    this.hi = paramBoolean;
  }
  
  /* Error */
  private int a(byte[] paramArrayOfByte, AtomicReference<byte[]> paramAtomicReference)
  {
    // Byte code:
    //   0: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   3: ldc 73
    //   5: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   12: ifnonnull +7 -> 19
    //   15: sipush -10000
    //   18: ireturn
    //   19: ldc 83
    //   21: aload_0
    //   22: getfield 40	btmsdkobf/ca:hc	Ljava/lang/String;
    //   25: invokevirtual 89	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   28: ifeq +6 -> 34
    //   31: goto +46 -> 77
    //   34: aload_0
    //   35: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   38: astore 4
    //   40: new 91	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   47: astore 5
    //   49: aload 5
    //   51: ldc 94
    //   53: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: aload_1
    //   60: arraylength
    //   61: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: ldc 103
    //   69: aload 5
    //   71: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: getstatic 117	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   80: ifnull +22 -> 102
    //   83: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   86: bipush 13
    //   88: if_icmple +14 -> 102
    //   91: aload_0
    //   92: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   95: ldc 122
    //   97: ldc 124
    //   99: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   105: astore 4
    //   107: new 91	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   114: astore 5
    //   116: aload 5
    //   118: ldc 126
    //   120: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 5
    //   126: aload_1
    //   127: arraylength
    //   128: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload 5
    //   136: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   146: invokevirtual 130	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   149: astore 4
    //   151: aload 4
    //   153: aload_1
    //   154: invokevirtual 136	java/io/OutputStream:write	([B)V
    //   157: aload 4
    //   159: invokevirtual 139	java/io/OutputStream:flush	()V
    //   162: aload 4
    //   164: invokevirtual 141	java/io/OutputStream:close	()V
    //   167: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   170: astore 4
    //   172: new 91	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   179: astore 5
    //   181: aload 5
    //   183: ldc 143
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: aload_1
    //   192: arraylength
    //   193: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 4
    //   199: aload 5
    //   201: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 146	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_0
    //   208: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   211: invokevirtual 150	java/net/HttpURLConnection:getResponseCode	()I
    //   214: istore_3
    //   215: aload_0
    //   216: iload_3
    //   217: invokespecial 154	btmsdkobf/ca:r	(I)Z
    //   220: ifeq +76 -> 296
    //   223: aload_0
    //   224: aload_0
    //   225: invokespecial 157	btmsdkobf/ca:aR	()Ljava/lang/String;
    //   228: putfield 159	btmsdkobf/ca:hg	Ljava/lang/String;
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 42	btmsdkobf/ca:hh	I
    //   236: iconst_1
    //   237: iadd
    //   238: putfield 42	btmsdkobf/ca:hh	I
    //   241: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   244: astore_1
    //   245: new 91	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: ldc 161
    //   256: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: aload_0
    //   262: getfield 159	btmsdkobf/ca:hg	Ljava/lang/String;
    //   265: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_2
    //   270: ldc 163
    //   272: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: aload_0
    //   278: getfield 42	btmsdkobf/ca:hh	I
    //   281: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: aload_2
    //   287: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 146	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: ldc 164
    //   295: ireturn
    //   296: aload_0
    //   297: invokespecial 167	btmsdkobf/ca:aQ	()V
    //   300: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   303: astore_1
    //   304: new 91	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   311: astore 4
    //   313: aload 4
    //   315: ldc 169
    //   317: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 4
    //   323: iload_3
    //   324: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: aload 4
    //   331: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_0
    //   338: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   341: invokevirtual 173	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   344: astore_1
    //   345: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   348: astore 4
    //   350: new 91	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   357: astore 5
    //   359: aload 5
    //   361: ldc 175
    //   363: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 5
    //   369: aload_1
    //   370: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 4
    //   376: aload 5
    //   378: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_0
    //   385: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   388: ldc 180
    //   390: invokevirtual 184	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore_1
    //   394: aload_1
    //   395: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   398: ifeq +43 -> 441
    //   401: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   404: astore_2
    //   405: new 91	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   412: astore 4
    //   414: aload 4
    //   416: ldc 192
    //   418: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 4
    //   424: aload_1
    //   425: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_2
    //   430: aload 4
    //   432: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 195	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: ldc 196
    //   440: ireturn
    //   441: aload_1
    //   442: ldc 198
    //   444: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   447: ifne +43 -> 490
    //   450: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   453: astore_2
    //   454: new 91	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   461: astore 4
    //   463: aload 4
    //   465: ldc 192
    //   467: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 4
    //   473: aload_1
    //   474: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_2
    //   479: aload 4
    //   481: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 195	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: ldc 203
    //   489: ireturn
    //   490: aload_0
    //   491: aload_0
    //   492: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   495: invokevirtual 207	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   498: invokespecial 210	btmsdkobf/ca:a	(Ljava/io/InputStream;)[B
    //   501: astore_1
    //   502: aload_2
    //   503: aload_1
    //   504: invokevirtual 216	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   507: aload_1
    //   508: ifnull +41 -> 549
    //   511: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   514: astore_2
    //   515: new 91	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   522: astore 4
    //   524: aload 4
    //   526: ldc 218
    //   528: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 4
    //   534: aload_1
    //   535: arraylength
    //   536: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload_2
    //   541: aload 4
    //   543: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 146	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: iconst_0
    //   550: ireturn
    //   551: astore_1
    //   552: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   555: aload_1
    //   556: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   559: invokestatic 195	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: ldc 220
    //   564: ireturn
    //   565: astore_1
    //   566: goto +159 -> 725
    //   569: astore_1
    //   570: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   573: ldc 222
    //   575: aload_1
    //   576: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   579: ldc 227
    //   581: ireturn
    //   582: astore_1
    //   583: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   586: ldc 229
    //   588: aload_1
    //   589: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   592: ldc 230
    //   594: ireturn
    //   595: astore_1
    //   596: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   599: ldc 232
    //   601: aload_1
    //   602: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   605: ldc 233
    //   607: ireturn
    //   608: astore_1
    //   609: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   612: ldc 235
    //   614: aload_1
    //   615: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: aload_1
    //   619: invokevirtual 236	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   622: ldc 237
    //   624: invokestatic 242	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   627: ireturn
    //   628: astore_1
    //   629: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   632: ldc 244
    //   634: aload_1
    //   635: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload_1
    //   639: invokevirtual 245	java/net/SocketException:toString	()Ljava/lang/String;
    //   642: ldc 246
    //   644: invokestatic 242	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   647: ireturn
    //   648: astore_1
    //   649: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   652: ldc 248
    //   654: aload_1
    //   655: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   658: aload_1
    //   659: invokevirtual 249	java/net/ConnectException:toString	()Ljava/lang/String;
    //   662: ldc 250
    //   664: invokestatic 242	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   667: ireturn
    //   668: astore_1
    //   669: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   672: ldc 252
    //   674: aload_1
    //   675: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   678: ldc 253
    //   680: ireturn
    //   681: astore_1
    //   682: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   685: ldc 255
    //   687: aload_1
    //   688: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   691: ldc_w 256
    //   694: ireturn
    //   695: astore_1
    //   696: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   699: ldc_w 258
    //   702: aload_1
    //   703: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   706: ldc_w 259
    //   709: ireturn
    //   710: astore_1
    //   711: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   714: ldc_w 261
    //   717: aload_1
    //   718: invokestatic 226	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   721: ldc_w 262
    //   724: ireturn
    //   725: aload_1
    //   726: athrow
    //   727: astore 4
    //   729: goto -627 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	this	ca
    //   0	732	1	paramArrayOfByte	byte[]
    //   0	732	2	paramAtomicReference	AtomicReference<byte[]>
    //   214	110	3	i	int
    //   38	504	4	localObject	Object
    //   727	1	4	localException	Exception
    //   47	330	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   337	438	551	java/lang/Exception
    //   441	487	551	java/lang/Exception
    //   490	507	551	java/lang/Exception
    //   511	549	551	java/lang/Exception
    //   19	31	565	finally
    //   34	77	565	finally
    //   77	102	565	finally
    //   102	293	565	finally
    //   296	337	565	finally
    //   337	438	565	finally
    //   441	487	565	finally
    //   490	507	565	finally
    //   511	549	565	finally
    //   552	562	565	finally
    //   570	579	565	finally
    //   583	592	565	finally
    //   596	605	565	finally
    //   609	628	565	finally
    //   629	648	565	finally
    //   649	668	565	finally
    //   669	678	565	finally
    //   682	691	565	finally
    //   696	706	565	finally
    //   711	721	565	finally
    //   19	31	569	java/lang/Exception
    //   34	77	569	java/lang/Exception
    //   102	293	569	java/lang/Exception
    //   296	337	569	java/lang/Exception
    //   552	562	569	java/lang/Exception
    //   19	31	582	java/io/IOException
    //   34	77	582	java/io/IOException
    //   77	102	582	java/io/IOException
    //   102	293	582	java/io/IOException
    //   296	337	582	java/io/IOException
    //   337	438	582	java/io/IOException
    //   441	487	582	java/io/IOException
    //   490	507	582	java/io/IOException
    //   511	549	582	java/io/IOException
    //   552	562	582	java/io/IOException
    //   19	31	595	java/net/SocketTimeoutException
    //   34	77	595	java/net/SocketTimeoutException
    //   77	102	595	java/net/SocketTimeoutException
    //   102	293	595	java/net/SocketTimeoutException
    //   296	337	595	java/net/SocketTimeoutException
    //   337	438	595	java/net/SocketTimeoutException
    //   441	487	595	java/net/SocketTimeoutException
    //   490	507	595	java/net/SocketTimeoutException
    //   511	549	595	java/net/SocketTimeoutException
    //   552	562	595	java/net/SocketTimeoutException
    //   19	31	608	java/lang/SecurityException
    //   34	77	608	java/lang/SecurityException
    //   77	102	608	java/lang/SecurityException
    //   102	293	608	java/lang/SecurityException
    //   296	337	608	java/lang/SecurityException
    //   337	438	608	java/lang/SecurityException
    //   441	487	608	java/lang/SecurityException
    //   490	507	608	java/lang/SecurityException
    //   511	549	608	java/lang/SecurityException
    //   552	562	608	java/lang/SecurityException
    //   19	31	628	java/net/SocketException
    //   34	77	628	java/net/SocketException
    //   77	102	628	java/net/SocketException
    //   102	293	628	java/net/SocketException
    //   296	337	628	java/net/SocketException
    //   337	438	628	java/net/SocketException
    //   441	487	628	java/net/SocketException
    //   490	507	628	java/net/SocketException
    //   511	549	628	java/net/SocketException
    //   552	562	628	java/net/SocketException
    //   19	31	648	java/net/ConnectException
    //   34	77	648	java/net/ConnectException
    //   77	102	648	java/net/ConnectException
    //   102	293	648	java/net/ConnectException
    //   296	337	648	java/net/ConnectException
    //   337	438	648	java/net/ConnectException
    //   441	487	648	java/net/ConnectException
    //   490	507	648	java/net/ConnectException
    //   511	549	648	java/net/ConnectException
    //   552	562	648	java/net/ConnectException
    //   19	31	668	java/net/ProtocolException
    //   34	77	668	java/net/ProtocolException
    //   77	102	668	java/net/ProtocolException
    //   102	293	668	java/net/ProtocolException
    //   296	337	668	java/net/ProtocolException
    //   337	438	668	java/net/ProtocolException
    //   441	487	668	java/net/ProtocolException
    //   490	507	668	java/net/ProtocolException
    //   511	549	668	java/net/ProtocolException
    //   552	562	668	java/net/ProtocolException
    //   19	31	681	java/lang/IllegalStateException
    //   34	77	681	java/lang/IllegalStateException
    //   77	102	681	java/lang/IllegalStateException
    //   102	293	681	java/lang/IllegalStateException
    //   296	337	681	java/lang/IllegalStateException
    //   337	438	681	java/lang/IllegalStateException
    //   441	487	681	java/lang/IllegalStateException
    //   490	507	681	java/lang/IllegalStateException
    //   511	549	681	java/lang/IllegalStateException
    //   552	562	681	java/lang/IllegalStateException
    //   19	31	695	java/lang/IllegalAccessError
    //   34	77	695	java/lang/IllegalAccessError
    //   77	102	695	java/lang/IllegalAccessError
    //   102	293	695	java/lang/IllegalAccessError
    //   296	337	695	java/lang/IllegalAccessError
    //   337	438	695	java/lang/IllegalAccessError
    //   441	487	695	java/lang/IllegalAccessError
    //   490	507	695	java/lang/IllegalAccessError
    //   511	549	695	java/lang/IllegalAccessError
    //   552	562	695	java/lang/IllegalAccessError
    //   19	31	710	java/net/UnknownHostException
    //   34	77	710	java/net/UnknownHostException
    //   77	102	710	java/net/UnknownHostException
    //   102	293	710	java/net/UnknownHostException
    //   296	337	710	java/net/UnknownHostException
    //   337	438	710	java/net/UnknownHostException
    //   441	487	710	java/net/UnknownHostException
    //   490	507	710	java/net/UnknownHostException
    //   511	549	710	java/net/UnknownHostException
    //   552	562	710	java/net/UnknownHostException
    //   77	102	727	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore 4
    //   7: new 266	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 267	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_3
    //   15: aload_1
    //   16: aload 4
    //   18: invokevirtual 273	java/io/InputStream:read	([B)I
    //   21: istore_2
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +14 -> 38
    //   27: aload_3
    //   28: aload 4
    //   30: iconst_0
    //   31: iload_2
    //   32: invokevirtual 276	java/io/ByteArrayOutputStream:write	([BII)V
    //   35: goto -20 -> 15
    //   38: aload_3
    //   39: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_1
    //   43: aload_3
    //   44: invokevirtual 281	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_3
    //   50: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   53: aload_3
    //   54: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   57: invokestatic 195	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_1
    //   63: goto +45 -> 108
    //   66: astore_1
    //   67: new 91	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: ldc_w 283
    //   81: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: aload_1
    //   88: invokevirtual 286	java/io/IOException:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: new 69	java/lang/Exception
    //   98: dup
    //   99: aload 4
    //   101: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 289	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: aload_3
    //   109: invokevirtual 281	java/io/ByteArrayOutputStream:close	()V
    //   112: goto +14 -> 126
    //   115: astore_3
    //   116: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   119: aload_3
    //   120: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   123: invokestatic 195	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	ca
    //   0	128	1	paramInputStream	java.io.InputStream
    //   21	11	2	i	int
    //   14	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   49	60	3	localException1	Exception
    //   115	5	3	localException2	Exception
    //   5	95	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/lang/Exception
    //   15	22	62	finally
    //   27	35	62	finally
    //   38	43	62	finally
    //   67	108	62	finally
    //   15	22	66	java/io/IOException
    //   27	35	66	java/io/IOException
    //   38	43	66	java/io/IOException
    //   108	112	115	java/lang/Exception
  }
  
  private boolean aP()
  {
    eh.f(TAG, "[http_control]stop()");
    HttpURLConnection localHttpURLConnection = this.hd;
    if (localHttpURLConnection == null) {
      return false;
    }
    try
    {
      localHttpURLConnection.disconnect();
      this.hd = null;
      label29:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label29;
    }
  }
  
  private void aQ()
  {
    this.hg = null;
    this.hh = 0;
  }
  
  private String aR()
  {
    eh.e(TAG, "[http_control]getRedirectUrl()");
    try
    {
      String str1 = this.hd.getHeaderField("Location");
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedirectUrl() e: ");
      localStringBuilder.append(localException.toString());
      eh.h(str2, localStringBuilder.toString());
    }
    return null;
  }
  
  private boolean r(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  private int s(String paramString)
  {
    eh.f(TAG, "[http_control]start()");
    if (this.hh >= 3) {
      aQ();
    }
    if (!TextUtils.isEmpty(this.hg)) {
      paramString = this.hg;
    }
    try
    {
      paramString = new URL(paramString);
      Object localObject;
      try
      {
        localObject = NetworkUtil.getNetworkType();
        if (ConnectType.CT_NONE == localObject)
        {
          eh.g(TAG, "[http_control]start() no network");
          return -220000;
        }
        if (ConnectType.CT_GPRS_WAP == localObject)
        {
          this.hd = ((HttpURLConnection)paramString.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(NetworkUtil.getProxyHost(), NetworkUtil.getProxyPort()))));
        }
        else
        {
          this.hd = ((HttpURLConnection)paramString.openConnection());
          this.hd.setReadTimeout(15000);
          this.hd.setConnectTimeout(15000);
        }
        if (SDKUtil.getSDKVersion() < 8) {
          System.setProperty("http.keepAlive", "false");
        }
        this.hd.setUseCaches(false);
        this.hd.setRequestProperty("Pragma", "no-cache");
        this.hd.setRequestProperty("Cache-Control", "no-cache");
        this.hd.setInstanceFollowRedirects(false);
        if ("GET".equalsIgnoreCase(this.hc))
        {
          this.hd.setRequestMethod("GET");
          return 0;
        }
        this.hd.setRequestMethod("POST");
        this.hd.setDoOutput(true);
        this.hd.setDoInput(true);
        this.hd.setRequestProperty("Accept", "*/*");
        this.hd.setRequestProperty("Accept-Charset", "utf-8");
        this.hd.setRequestProperty("Content-Type", "application/octet-stream");
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
      StringBuilder localStringBuilder;
      return -510000;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[http_control]start() MalformedURLException e:");
      localStringBuilder.append(paramString.toString());
      eh.h((String)localObject, localStringBuilder.toString());
    }
  }
  
  int a(cy.f paramf, byte[] paramArrayOfByte, AtomicReference<byte[]> paramAtomicReference)
  {
    if ((paramArrayOfByte != null) && (paramf != null)) {}
    for (;;)
    {
      try
      {
        eh.f(TAG, "[http_control]sendData()");
        if ((paramf.jH != 2048) || (this.hi)) {
          break label527;
        }
        j = 1;
      }
      finally {}
      if (m < k)
      {
        Object localObject = NetworkUtil.getNetworkType();
        if (ConnectType.CT_NONE == localObject)
        {
          eh.g(TAG, "[http_control]sendData() no network");
          return -220000;
        }
        if (paramf.bP())
        {
          eh.e(TAG, "[http_control][time_out]sendData(), send time out");
          i = -17;
          return i;
        }
        if (j != 0)
        {
          str = cg.a(this.he);
          localObject = str;
          if (str != null) {
            if (str.length() >= 7)
            {
              localObject = str;
              if (str.substring(0, 7).equalsIgnoreCase("http://")) {}
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("http://");
              ((StringBuilder)localObject).append(str);
              localObject = ((StringBuilder)localObject).toString();
            }
          }
        }
        else
        {
          localObject = this.hf.bg();
        }
        i = s((String)localObject);
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[http_control]start(), ret: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" httpUrl: ");
        localStringBuilder.append((String)localObject);
        eh.f(str, localStringBuilder.toString());
        if (i != 0) {
          break label550;
        }
        paramf.jW = true;
        i = a(paramArrayOfByte, paramAtomicReference);
        aP();
        if ((i != 0) && (i != -220000))
        {
          if ((i != -60000) && (cx.y("http send")))
          {
            i = -160000;
            paramf = TAG;
            paramArrayOfByte = "[http_control]sendData() 需要wifi认证，不重试";
            eh.f(paramf, paramArrayOfByte);
          }
          else
          {
            if ((j == 0) && (i != -60000)) {
              this.hf.m(false);
            }
            if (m >= k - 1) {
              break label553;
            }
            try
            {
              Thread.sleep(300L);
            }
            catch (InterruptedException localInterruptedException)
            {
              str = TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[http_control]sendData() InterruptedException e: ");
              localStringBuilder.append(localInterruptedException.toString());
              eh.h(str, localStringBuilder.toString());
            }
          }
        }
        else
        {
          paramf = TAG;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("[http_control]sendData() 发包成功或无网络，不重试， ret: ");
          paramArrayOfByte.append(i);
          paramArrayOfByte = paramArrayOfByte.toString();
          continue;
        }
      }
      paramf = TAG;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[http_control]sendData() ret: ");
      paramArrayOfByte.append(i);
      eh.e(paramf, paramArrayOfByte.toString());
      return i;
      int i = -10;
      continue;
      label527:
      int j = 0;
      int k = 3;
      if (j != 0) {
        k = 1;
      }
      int m = 0;
      i = -1;
      continue;
      label550:
      continue;
      label553:
      m += 1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ca
 * JD-Core Version:    0.7.0.1
 */