package btmsdkobf;

import android.content.Context;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
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
  private int a(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   3: ldc 71
    //   5: invokestatic 77	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   12: ifnonnull +7 -> 19
    //   15: sipush -10000
    //   18: ireturn
    //   19: ldc 81
    //   21: aload_0
    //   22: getfield 39	btmsdkobf/ca:hc	Ljava/lang/String;
    //   25: invokevirtual 87	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   28: istore 4
    //   30: iload 4
    //   32: ifeq +182 -> 214
    //   35: getstatic 92	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   38: ifnull +22 -> 60
    //   41: getstatic 95	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 13
    //   46: if_icmple +14 -> 60
    //   49: aload_0
    //   50: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   53: ldc 97
    //   55: ldc 99
    //   57: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   63: new 106	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   70: ldc 109
    //   72: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: arraylength
    //   77: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 77	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   90: invokevirtual 124	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   93: astore 5
    //   95: aload 5
    //   97: aload_1
    //   98: invokevirtual 130	java/io/OutputStream:write	([B)V
    //   101: aload 5
    //   103: invokevirtual 133	java/io/OutputStream:flush	()V
    //   106: aload 5
    //   108: invokevirtual 135	java/io/OutputStream:close	()V
    //   111: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   114: new 106	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   121: ldc 137
    //   123: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: arraylength
    //   128: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 140	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   141: invokevirtual 144	java/net/HttpURLConnection:getResponseCode	()I
    //   144: istore_3
    //   145: aload_0
    //   146: iload_3
    //   147: invokespecial 148	btmsdkobf/ca:r	(I)Z
    //   150: ifeq +109 -> 259
    //   153: aload_0
    //   154: aload_0
    //   155: invokespecial 151	btmsdkobf/ca:aR	()Ljava/lang/String;
    //   158: putfield 153	btmsdkobf/ca:hg	Ljava/lang/String;
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 41	btmsdkobf/ca:hh	I
    //   166: iconst_1
    //   167: iadd
    //   168: putfield 41	btmsdkobf/ca:hh	I
    //   171: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   174: new 106	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   181: ldc 155
    //   183: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_0
    //   187: getfield 153	btmsdkobf/ca:hg	Ljava/lang/String;
    //   190: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 157
    //   195: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 41	btmsdkobf/ca:hh	I
    //   202: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 140	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: ldc 158
    //   213: ireturn
    //   214: aload_0
    //   215: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   218: ldc 160
    //   220: new 106	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   227: ldc 162
    //   229: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: arraylength
    //   234: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -208 -> 35
    //   246: astore_1
    //   247: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   250: ldc 164
    //   252: aload_1
    //   253: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: ldc 169
    //   258: ireturn
    //   259: aload_0
    //   260: invokespecial 172	btmsdkobf/ca:aQ	()V
    //   263: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   266: new 106	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   273: ldc 174
    //   275: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload_3
    //   279: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 77	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   292: invokevirtual 178	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   295: astore_1
    //   296: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   299: new 106	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   306: ldc 180
    //   308: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 77	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   325: ldc 185
    //   327: invokevirtual 189	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore_1
    //   331: aload_1
    //   332: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: ifeq +31 -> 366
    //   338: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   341: new 106	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   348: ldc 197
    //   350: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_1
    //   354: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 200	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: ldc 201
    //   365: ireturn
    //   366: aload_1
    //   367: ldc 203
    //   369: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifne +31 -> 403
    //   375: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   378: new 106	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   385: ldc 197
    //   387: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 200	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: ldc 208
    //   402: ireturn
    //   403: aload_0
    //   404: aload_0
    //   405: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   408: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   411: invokespecial 215	btmsdkobf/ca:a	(Ljava/io/InputStream;)[B
    //   414: astore_1
    //   415: aload_2
    //   416: aload_1
    //   417: invokevirtual 221	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   420: aload_1
    //   421: ifnull +29 -> 450
    //   424: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   427: new 106	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   434: ldc 223
    //   436: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_1
    //   440: arraylength
    //   441: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 140	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: iconst_0
    //   451: ireturn
    //   452: astore_1
    //   453: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   456: aload_1
    //   457: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   460: invokestatic 200	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: ldc 225
    //   465: ireturn
    //   466: astore_1
    //   467: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   470: ldc 227
    //   472: aload_1
    //   473: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   476: ldc 228
    //   478: ireturn
    //   479: astore_1
    //   480: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   483: ldc 230
    //   485: aload_1
    //   486: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   489: ldc 231
    //   491: ireturn
    //   492: astore_1
    //   493: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   496: ldc 233
    //   498: aload_1
    //   499: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   502: ldc 234
    //   504: ireturn
    //   505: astore_1
    //   506: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   509: ldc 236
    //   511: aload_1
    //   512: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   515: aload_1
    //   516: invokevirtual 237	java/net/ConnectException:toString	()Ljava/lang/String;
    //   519: ldc 238
    //   521: invokestatic 243	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   524: ireturn
    //   525: astore_1
    //   526: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   529: ldc 245
    //   531: aload_1
    //   532: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_1
    //   536: invokevirtual 246	java/net/SocketException:toString	()Ljava/lang/String;
    //   539: ldc 247
    //   541: invokestatic 243	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   544: ireturn
    //   545: astore_1
    //   546: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   549: ldc 249
    //   551: aload_1
    //   552: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   555: aload_1
    //   556: invokevirtual 250	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   559: ldc 251
    //   561: invokestatic 243	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   564: ireturn
    //   565: astore_1
    //   566: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   569: ldc 253
    //   571: aload_1
    //   572: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   575: ldc 254
    //   577: ireturn
    //   578: astore_1
    //   579: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   582: ldc_w 256
    //   585: aload_1
    //   586: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   589: ldc_w 257
    //   592: ireturn
    //   593: astore_1
    //   594: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   597: ldc_w 259
    //   600: aload_1
    //   601: invokestatic 168	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   604: ldc_w 260
    //   607: ireturn
    //   608: astore_1
    //   609: aload_1
    //   610: athrow
    //   611: astore 5
    //   613: goto -553 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	ca
    //   0	616	1	paramArrayOfByte	byte[]
    //   0	616	2	paramAtomicReference	AtomicReference
    //   144	135	3	i	int
    //   28	3	4	bool	boolean
    //   93	14	5	localOutputStream	java.io.OutputStream
    //   611	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   19	30	246	java/net/UnknownHostException
    //   35	60	246	java/net/UnknownHostException
    //   60	211	246	java/net/UnknownHostException
    //   214	243	246	java/net/UnknownHostException
    //   259	288	246	java/net/UnknownHostException
    //   288	363	246	java/net/UnknownHostException
    //   366	400	246	java/net/UnknownHostException
    //   403	420	246	java/net/UnknownHostException
    //   424	450	246	java/net/UnknownHostException
    //   453	463	246	java/net/UnknownHostException
    //   288	363	452	java/lang/Exception
    //   366	400	452	java/lang/Exception
    //   403	420	452	java/lang/Exception
    //   424	450	452	java/lang/Exception
    //   19	30	466	java/lang/IllegalAccessError
    //   35	60	466	java/lang/IllegalAccessError
    //   60	211	466	java/lang/IllegalAccessError
    //   214	243	466	java/lang/IllegalAccessError
    //   259	288	466	java/lang/IllegalAccessError
    //   288	363	466	java/lang/IllegalAccessError
    //   366	400	466	java/lang/IllegalAccessError
    //   403	420	466	java/lang/IllegalAccessError
    //   424	450	466	java/lang/IllegalAccessError
    //   453	463	466	java/lang/IllegalAccessError
    //   19	30	479	java/lang/IllegalStateException
    //   35	60	479	java/lang/IllegalStateException
    //   60	211	479	java/lang/IllegalStateException
    //   214	243	479	java/lang/IllegalStateException
    //   259	288	479	java/lang/IllegalStateException
    //   288	363	479	java/lang/IllegalStateException
    //   366	400	479	java/lang/IllegalStateException
    //   403	420	479	java/lang/IllegalStateException
    //   424	450	479	java/lang/IllegalStateException
    //   453	463	479	java/lang/IllegalStateException
    //   19	30	492	java/net/ProtocolException
    //   35	60	492	java/net/ProtocolException
    //   60	211	492	java/net/ProtocolException
    //   214	243	492	java/net/ProtocolException
    //   259	288	492	java/net/ProtocolException
    //   288	363	492	java/net/ProtocolException
    //   366	400	492	java/net/ProtocolException
    //   403	420	492	java/net/ProtocolException
    //   424	450	492	java/net/ProtocolException
    //   453	463	492	java/net/ProtocolException
    //   19	30	505	java/net/ConnectException
    //   35	60	505	java/net/ConnectException
    //   60	211	505	java/net/ConnectException
    //   214	243	505	java/net/ConnectException
    //   259	288	505	java/net/ConnectException
    //   288	363	505	java/net/ConnectException
    //   366	400	505	java/net/ConnectException
    //   403	420	505	java/net/ConnectException
    //   424	450	505	java/net/ConnectException
    //   453	463	505	java/net/ConnectException
    //   19	30	525	java/net/SocketException
    //   35	60	525	java/net/SocketException
    //   60	211	525	java/net/SocketException
    //   214	243	525	java/net/SocketException
    //   259	288	525	java/net/SocketException
    //   288	363	525	java/net/SocketException
    //   366	400	525	java/net/SocketException
    //   403	420	525	java/net/SocketException
    //   424	450	525	java/net/SocketException
    //   453	463	525	java/net/SocketException
    //   19	30	545	java/lang/SecurityException
    //   35	60	545	java/lang/SecurityException
    //   60	211	545	java/lang/SecurityException
    //   214	243	545	java/lang/SecurityException
    //   259	288	545	java/lang/SecurityException
    //   288	363	545	java/lang/SecurityException
    //   366	400	545	java/lang/SecurityException
    //   403	420	545	java/lang/SecurityException
    //   424	450	545	java/lang/SecurityException
    //   453	463	545	java/lang/SecurityException
    //   19	30	565	java/net/SocketTimeoutException
    //   35	60	565	java/net/SocketTimeoutException
    //   60	211	565	java/net/SocketTimeoutException
    //   214	243	565	java/net/SocketTimeoutException
    //   259	288	565	java/net/SocketTimeoutException
    //   288	363	565	java/net/SocketTimeoutException
    //   366	400	565	java/net/SocketTimeoutException
    //   403	420	565	java/net/SocketTimeoutException
    //   424	450	565	java/net/SocketTimeoutException
    //   453	463	565	java/net/SocketTimeoutException
    //   19	30	578	java/io/IOException
    //   35	60	578	java/io/IOException
    //   60	211	578	java/io/IOException
    //   214	243	578	java/io/IOException
    //   259	288	578	java/io/IOException
    //   288	363	578	java/io/IOException
    //   366	400	578	java/io/IOException
    //   403	420	578	java/io/IOException
    //   424	450	578	java/io/IOException
    //   453	463	578	java/io/IOException
    //   19	30	593	java/lang/Exception
    //   60	211	593	java/lang/Exception
    //   214	243	593	java/lang/Exception
    //   259	288	593	java/lang/Exception
    //   453	463	593	java/lang/Exception
    //   19	30	608	finally
    //   35	60	608	finally
    //   60	211	608	finally
    //   214	243	608	finally
    //   247	256	608	finally
    //   259	288	608	finally
    //   288	363	608	finally
    //   366	400	608	finally
    //   403	420	608	finally
    //   424	450	608	finally
    //   453	463	608	finally
    //   467	476	608	finally
    //   480	489	608	finally
    //   493	502	608	finally
    //   506	525	608	finally
    //   526	545	608	finally
    //   546	565	608	finally
    //   566	575	608	finally
    //   579	589	608	finally
    //   594	604	608	finally
    //   35	60	611	java/lang/Exception
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
          eh.h(TAG, localException1.toString());
          return paramInputStream;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          eh.h(TAG, localException2.toString());
        }
      }
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = paramInputStream;
      throw new Exception("-56get Bytes from inputStream when read buffer: " + paramInputStream.getMessage());
    }
    finally {}
  }
  
  private boolean aP()
  {
    eh.f(TAG, "[http_control]stop()");
    if (this.hd == null) {
      return false;
    }
    try
    {
      this.hd.disconnect();
      this.hd = null;
      label30:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label30;
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
      String str = this.hd.getHeaderField("Location");
      return str;
    }
    catch (Exception localException)
    {
      eh.h(TAG, "getRedirectUrl() e: " + localException.toString());
    }
    return null;
  }
  
  private boolean r(int paramInt)
  {
    return (paramInt >= 301) && (paramInt <= 305);
  }
  
  /* Error */
  private int s(String paramString)
  {
    // Byte code:
    //   0: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   3: ldc_w 308
    //   6: invokestatic 77	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 41	btmsdkobf/ca:hh	I
    //   13: iconst_3
    //   14: if_icmplt +7 -> 21
    //   17: aload_0
    //   18: invokespecial 172	btmsdkobf/ca:aQ	()V
    //   21: aload_0
    //   22: getfield 153	btmsdkobf/ca:hg	Ljava/lang/String;
    //   25: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +36 -> 64
    //   31: new 310	java/net/URL
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 311	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: invokestatic 317	com/tmsdk/base/utils/NetworkUtil:getNetworkType	()Ltmsdk/QQPIM/ConnectType;
    //   43: astore_2
    //   44: getstatic 323	tmsdk/QQPIM/ConnectType:CT_NONE	Ltmsdk/QQPIM/ConnectType;
    //   47: aload_2
    //   48: if_acmpne +62 -> 110
    //   51: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   54: ldc_w 325
    //   57: invokestatic 328	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: ldc_w 329
    //   63: ireturn
    //   64: aload_0
    //   65: getfield 153	btmsdkobf/ca:hg	Ljava/lang/String;
    //   68: astore_1
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 332	java/net/MalformedURLException:printStackTrace	()V
    //   77: getstatic 26	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   80: new 106	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 334
    //   90: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 335	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   97: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 200	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc_w 336
    //   109: ireturn
    //   110: getstatic 339	tmsdk/QQPIM/ConnectType:CT_GPRS_WAP	Ltmsdk/QQPIM/ConnectType;
    //   113: aload_2
    //   114: if_acmpne +117 -> 231
    //   117: aload_0
    //   118: aload_1
    //   119: new 341	java/net/Proxy
    //   122: dup
    //   123: getstatic 347	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   126: invokestatic 350	com/tmsdk/base/utils/NetworkUtil:getProxyHost	()Ljava/lang/String;
    //   129: invokestatic 353	com/tmsdk/base/utils/NetworkUtil:getProxyPort	()I
    //   132: invokestatic 359	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   135: invokespecial 362	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   138: invokevirtual 366	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   141: checkcast 101	java/net/HttpURLConnection
    //   144: putfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   147: invokestatic 371	com/tmsdk/base/utils/SDKUtil:getSDKVersion	()I
    //   150: bipush 8
    //   152: if_icmpge +13 -> 165
    //   155: ldc_w 373
    //   158: ldc_w 375
    //   161: invokestatic 381	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: pop
    //   165: aload_0
    //   166: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   169: iconst_0
    //   170: invokevirtual 385	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   173: aload_0
    //   174: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   177: ldc_w 387
    //   180: ldc_w 389
    //   183: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   190: ldc_w 391
    //   193: ldc_w 389
    //   196: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   203: iconst_0
    //   204: invokevirtual 394	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   207: ldc 81
    //   209: aload_0
    //   210: getfield 39	btmsdkobf/ca:hc	Ljava/lang/String;
    //   213: invokevirtual 87	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   216: ifeq +58 -> 274
    //   219: aload_0
    //   220: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   223: ldc 81
    //   225: invokevirtual 397	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   228: goto +139 -> 367
    //   231: aload_0
    //   232: aload_1
    //   233: invokevirtual 400	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   236: checkcast 101	java/net/HttpURLConnection
    //   239: putfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   242: aload_0
    //   243: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   246: sipush 15000
    //   249: invokevirtual 404	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   252: aload_0
    //   253: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   256: sipush 15000
    //   259: invokevirtual 407	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   262: goto -115 -> 147
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 408	java/net/UnknownHostException:printStackTrace	()V
    //   270: ldc_w 409
    //   273: ireturn
    //   274: aload_0
    //   275: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   278: ldc 37
    //   280: invokevirtual 397	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   287: iconst_1
    //   288: invokevirtual 412	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   291: aload_0
    //   292: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   295: iconst_1
    //   296: invokevirtual 415	java/net/HttpURLConnection:setDoInput	(Z)V
    //   299: aload_0
    //   300: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   303: ldc_w 417
    //   306: ldc_w 419
    //   309: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_0
    //   313: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   316: ldc_w 421
    //   319: ldc_w 423
    //   322: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 79	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   329: ldc_w 425
    //   332: ldc_w 427
    //   335: invokevirtual 104	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: goto +29 -> 367
    //   341: astore_1
    //   342: aload_1
    //   343: invokevirtual 428	java/lang/IllegalArgumentException:printStackTrace	()V
    //   346: ldc_w 429
    //   349: ireturn
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 430	java/lang/SecurityException:printStackTrace	()V
    //   355: ldc 251
    //   357: ireturn
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 431	java/io/IOException:printStackTrace	()V
    //   363: ldc_w 257
    //   366: ireturn
    //   367: iconst_0
    //   368: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	ca
    //   0	369	1	paramString	String
    //   43	71	2	localConnectType	ConnectType
    // Exception table:
    //   from	to	target	type
    //   31	40	72	java/net/MalformedURLException
    //   40	60	265	java/net/UnknownHostException
    //   110	147	265	java/net/UnknownHostException
    //   147	165	265	java/net/UnknownHostException
    //   165	228	265	java/net/UnknownHostException
    //   231	262	265	java/net/UnknownHostException
    //   274	338	265	java/net/UnknownHostException
    //   40	60	341	java/lang/IllegalArgumentException
    //   110	147	341	java/lang/IllegalArgumentException
    //   147	165	341	java/lang/IllegalArgumentException
    //   165	228	341	java/lang/IllegalArgumentException
    //   231	262	341	java/lang/IllegalArgumentException
    //   274	338	341	java/lang/IllegalArgumentException
    //   40	60	350	java/lang/SecurityException
    //   110	147	350	java/lang/SecurityException
    //   147	165	350	java/lang/SecurityException
    //   165	228	350	java/lang/SecurityException
    //   231	262	350	java/lang/SecurityException
    //   274	338	350	java/lang/SecurityException
    //   40	60	358	java/io/IOException
    //   110	147	358	java/io/IOException
    //   147	165	358	java/io/IOException
    //   165	228	358	java/io/IOException
    //   231	262	358	java/io/IOException
    //   274	338	358	java/io/IOException
  }
  
  int a(cy.f paramf, byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    int k = 1;
    int i;
    if ((paramArrayOfByte == null) || (paramf == null)) {
      i = -10;
    }
    int j;
    int m;
    Object localObject;
    for (;;)
    {
      return i;
      try
      {
        eh.f(TAG, "[http_control]sendData()");
        if ((paramf.jH != 2048) || (this.hi)) {
          break label493;
        }
        j = 1;
      }
      finally {}
      if (m >= k) {
        break label470;
      }
      localObject = NetworkUtil.getNetworkType();
      if (ConnectType.CT_NONE == localObject)
      {
        eh.g(TAG, "[http_control]sendData() no network");
        i = -220000;
      }
      else
      {
        if (!paramf.bP()) {
          break;
        }
        eh.e(TAG, "[http_control][time_out]sendData(), send time out");
        i = -17;
      }
    }
    if (j != 0)
    {
      localObject = cg.a(this.he);
      if ((localObject == null) || ((((String)localObject).length() >= "http://".length()) && (((String)localObject).substring(0, "http://".length()).equalsIgnoreCase("http://")))) {
        break label467;
      }
      localObject = "http://" + (String)localObject;
      label191:
      int n = s((String)localObject);
      eh.f(TAG, "[http_control]start(), ret: " + n + " httpUrl: " + (String)localObject);
      i = n;
      if (n == 0)
      {
        paramf.jW = true;
        i = a(paramArrayOfByte, paramAtomicReference);
      }
      aP();
      if ((i != 0) && (i != -220000)) {
        break label353;
      }
      eh.f(TAG, "[http_control]sendData() 发包成功或无网络，不重试， ret: " + i);
    }
    label467:
    label470:
    for (;;)
    {
      for (;;)
      {
        eh.e(TAG, "[http_control]sendData() ret: " + i);
        break;
        localObject = this.hf.bg();
        break label191;
        label353:
        if ((i != -60000) && (cx.y("http send")))
        {
          i = -160000;
          eh.f(TAG, "[http_control]sendData() 需要wifi认证，不重试");
        }
        else
        {
          if ((j == 0) && (i != -60000)) {
            this.hf.m(false);
          }
          if (m < k - 1) {}
          try
          {
            Thread.sleep(300L);
            m += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              eh.h(TAG, "[http_control]sendData() InterruptedException e: " + localInterruptedException.toString());
            }
          }
        }
      }
      break label191;
    }
    label493:
    label497:
    for (;;)
    {
      k = 3;
      for (;;)
      {
        if (j == 0) {
          break label497;
        }
        i = -1;
        m = 0;
        break;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ca
 * JD-Core Version:    0.7.0.1
 */