package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.aor;
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
    //   28: ifne +38 -> 66
    //   31: aload_0
    //   32: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   35: astore 4
    //   37: new 91	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: aload_1
    //   49: arraylength
    //   50: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 4
    //   56: ldc 98
    //   58: aload 5
    //   60: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: getstatic 112	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   69: ifnull +22 -> 91
    //   72: getstatic 115	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 13
    //   77: if_icmple +14 -> 91
    //   80: aload_0
    //   81: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   84: ldc 117
    //   86: ldc 119
    //   88: invokevirtual 107	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   94: astore 4
    //   96: new 91	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 121
    //   102: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: astore 5
    //   107: aload 5
    //   109: aload_1
    //   110: arraylength
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: aload 5
    //   119: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   129: invokevirtual 128	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   132: astore 4
    //   134: aload 4
    //   136: aload_1
    //   137: invokevirtual 134	java/io/OutputStream:write	([B)V
    //   140: aload 4
    //   142: invokevirtual 137	java/io/OutputStream:flush	()V
    //   145: aload 4
    //   147: invokevirtual 139	java/io/OutputStream:close	()V
    //   150: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   153: astore 4
    //   155: new 91	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 141
    //   161: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: astore 5
    //   166: aload 5
    //   168: aload_1
    //   169: arraylength
    //   170: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 4
    //   176: aload 5
    //   178: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 144	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   188: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   191: istore_3
    //   192: aload_0
    //   193: iload_3
    //   194: invokespecial 152	btmsdkobf/ca:r	(I)Z
    //   197: ifeq +71 -> 268
    //   200: aload_0
    //   201: aload_0
    //   202: invokespecial 155	btmsdkobf/ca:aR	()Ljava/lang/String;
    //   205: putfield 157	btmsdkobf/ca:hg	Ljava/lang/String;
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 42	btmsdkobf/ca:hh	I
    //   213: iconst_1
    //   214: iadd
    //   215: putfield 42	btmsdkobf/ca:hh	I
    //   218: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   221: astore_1
    //   222: new 91	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 159
    //   228: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: astore_2
    //   232: aload_2
    //   233: aload_0
    //   234: getfield 157	btmsdkobf/ca:hg	Ljava/lang/String;
    //   237: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_2
    //   242: ldc 164
    //   244: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_2
    //   249: aload_0
    //   250: getfield 42	btmsdkobf/ca:hh	I
    //   253: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: aload_2
    //   259: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 144	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: ldc 165
    //   267: ireturn
    //   268: aload_0
    //   269: invokespecial 168	btmsdkobf/ca:aQ	()V
    //   272: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   275: ldc 170
    //   277: iload_3
    //   278: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   281: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   291: invokevirtual 182	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   294: astore_1
    //   295: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   298: ldc 184
    //   300: aload_1
    //   301: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   304: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokestatic 79	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   314: ldc 189
    //   316: invokevirtual 192	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +21 -> 345
    //   327: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   330: ldc 200
    //   332: aload_1
    //   333: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   336: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokestatic 203	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: ldc 204
    //   344: ireturn
    //   345: aload_1
    //   346: ldc 206
    //   348: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +21 -> 372
    //   354: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   357: ldc 200
    //   359: aload_1
    //   360: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   363: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokestatic 203	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: ldc 211
    //   371: ireturn
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 81	btmsdkobf/ca:hd	Ljava/net/HttpURLConnection;
    //   377: invokevirtual 215	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   380: invokespecial 218	btmsdkobf/ca:a	(Ljava/io/InputStream;)[B
    //   383: astore_1
    //   384: aload_2
    //   385: aload_1
    //   386: invokevirtual 224	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   389: aload_1
    //   390: ifnull +35 -> 425
    //   393: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   396: astore_2
    //   397: new 91	java/lang/StringBuilder
    //   400: dup
    //   401: ldc 226
    //   403: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: astore 4
    //   408: aload 4
    //   410: aload_1
    //   411: arraylength
    //   412: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_2
    //   417: aload 4
    //   419: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 144	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: iconst_0
    //   426: ireturn
    //   427: astore_1
    //   428: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   431: aload_1
    //   432: invokevirtual 227	java/lang/Exception:toString	()Ljava/lang/String;
    //   435: invokestatic 203	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: ldc 228
    //   440: ireturn
    //   441: astore_1
    //   442: goto +164 -> 606
    //   445: astore_1
    //   446: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   449: ldc 230
    //   451: aload_1
    //   452: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   455: ldc 235
    //   457: ireturn
    //   458: astore_1
    //   459: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   462: ldc 237
    //   464: aload_1
    //   465: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: ldc 238
    //   470: ireturn
    //   471: astore_1
    //   472: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   475: ldc 240
    //   477: aload_1
    //   478: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   481: ldc 241
    //   483: ireturn
    //   484: astore_1
    //   485: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   488: ldc 243
    //   490: aload_1
    //   491: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload_1
    //   495: invokevirtual 244	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   498: ldc 245
    //   500: invokestatic 250	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   503: ireturn
    //   504: astore_1
    //   505: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   508: ldc 252
    //   510: aload_1
    //   511: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   514: aload_1
    //   515: invokevirtual 253	java/net/SocketException:toString	()Ljava/lang/String;
    //   518: ldc 254
    //   520: invokestatic 250	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   523: ireturn
    //   524: astore_1
    //   525: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   528: ldc_w 256
    //   531: aload_1
    //   532: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_1
    //   536: invokevirtual 257	java/net/ConnectException:toString	()Ljava/lang/String;
    //   539: ldc_w 258
    //   542: invokestatic 250	btmsdkobf/bz:a	(Ljava/lang/String;I)I
    //   545: ireturn
    //   546: astore_1
    //   547: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   550: ldc_w 260
    //   553: aload_1
    //   554: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   557: ldc_w 261
    //   560: ireturn
    //   561: astore_1
    //   562: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   565: ldc_w 263
    //   568: aload_1
    //   569: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   572: ldc_w 264
    //   575: ireturn
    //   576: astore_1
    //   577: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   580: ldc_w 266
    //   583: aload_1
    //   584: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   587: ldc_w 267
    //   590: ireturn
    //   591: astore_1
    //   592: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   595: ldc_w 269
    //   598: aload_1
    //   599: invokestatic 234	btmsdkobf/eh:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   602: ldc_w 270
    //   605: ireturn
    //   606: aload_1
    //   607: athrow
    //   608: astore 4
    //   610: goto -519 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	ca
    //   0	613	1	paramArrayOfByte	byte[]
    //   0	613	2	paramAtomicReference	AtomicReference<byte[]>
    //   191	87	3	i	int
    //   35	383	4	localObject	Object
    //   608	1	4	localException	Exception
    //   44	133	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   287	342	427	java/lang/Exception
    //   345	369	427	java/lang/Exception
    //   372	389	427	java/lang/Exception
    //   393	425	427	java/lang/Exception
    //   19	66	441	finally
    //   66	91	441	finally
    //   91	265	441	finally
    //   268	287	441	finally
    //   287	342	441	finally
    //   345	369	441	finally
    //   372	389	441	finally
    //   393	425	441	finally
    //   428	438	441	finally
    //   446	455	441	finally
    //   459	468	441	finally
    //   472	481	441	finally
    //   485	504	441	finally
    //   505	524	441	finally
    //   525	546	441	finally
    //   547	557	441	finally
    //   562	572	441	finally
    //   577	587	441	finally
    //   592	602	441	finally
    //   19	66	445	java/lang/Exception
    //   91	265	445	java/lang/Exception
    //   268	287	445	java/lang/Exception
    //   428	438	445	java/lang/Exception
    //   19	66	458	java/io/IOException
    //   66	91	458	java/io/IOException
    //   91	265	458	java/io/IOException
    //   268	287	458	java/io/IOException
    //   287	342	458	java/io/IOException
    //   345	369	458	java/io/IOException
    //   372	389	458	java/io/IOException
    //   393	425	458	java/io/IOException
    //   428	438	458	java/io/IOException
    //   19	66	471	java/net/SocketTimeoutException
    //   66	91	471	java/net/SocketTimeoutException
    //   91	265	471	java/net/SocketTimeoutException
    //   268	287	471	java/net/SocketTimeoutException
    //   287	342	471	java/net/SocketTimeoutException
    //   345	369	471	java/net/SocketTimeoutException
    //   372	389	471	java/net/SocketTimeoutException
    //   393	425	471	java/net/SocketTimeoutException
    //   428	438	471	java/net/SocketTimeoutException
    //   19	66	484	java/lang/SecurityException
    //   66	91	484	java/lang/SecurityException
    //   91	265	484	java/lang/SecurityException
    //   268	287	484	java/lang/SecurityException
    //   287	342	484	java/lang/SecurityException
    //   345	369	484	java/lang/SecurityException
    //   372	389	484	java/lang/SecurityException
    //   393	425	484	java/lang/SecurityException
    //   428	438	484	java/lang/SecurityException
    //   19	66	504	java/net/SocketException
    //   66	91	504	java/net/SocketException
    //   91	265	504	java/net/SocketException
    //   268	287	504	java/net/SocketException
    //   287	342	504	java/net/SocketException
    //   345	369	504	java/net/SocketException
    //   372	389	504	java/net/SocketException
    //   393	425	504	java/net/SocketException
    //   428	438	504	java/net/SocketException
    //   19	66	524	java/net/ConnectException
    //   66	91	524	java/net/ConnectException
    //   91	265	524	java/net/ConnectException
    //   268	287	524	java/net/ConnectException
    //   287	342	524	java/net/ConnectException
    //   345	369	524	java/net/ConnectException
    //   372	389	524	java/net/ConnectException
    //   393	425	524	java/net/ConnectException
    //   428	438	524	java/net/ConnectException
    //   19	66	546	java/net/ProtocolException
    //   66	91	546	java/net/ProtocolException
    //   91	265	546	java/net/ProtocolException
    //   268	287	546	java/net/ProtocolException
    //   287	342	546	java/net/ProtocolException
    //   345	369	546	java/net/ProtocolException
    //   372	389	546	java/net/ProtocolException
    //   393	425	546	java/net/ProtocolException
    //   428	438	546	java/net/ProtocolException
    //   19	66	561	java/lang/IllegalStateException
    //   66	91	561	java/lang/IllegalStateException
    //   91	265	561	java/lang/IllegalStateException
    //   268	287	561	java/lang/IllegalStateException
    //   287	342	561	java/lang/IllegalStateException
    //   345	369	561	java/lang/IllegalStateException
    //   372	389	561	java/lang/IllegalStateException
    //   393	425	561	java/lang/IllegalStateException
    //   428	438	561	java/lang/IllegalStateException
    //   19	66	576	java/lang/IllegalAccessError
    //   66	91	576	java/lang/IllegalAccessError
    //   91	265	576	java/lang/IllegalAccessError
    //   268	287	576	java/lang/IllegalAccessError
    //   287	342	576	java/lang/IllegalAccessError
    //   345	369	576	java/lang/IllegalAccessError
    //   372	389	576	java/lang/IllegalAccessError
    //   393	425	576	java/lang/IllegalAccessError
    //   428	438	576	java/lang/IllegalAccessError
    //   19	66	591	java/net/UnknownHostException
    //   66	91	591	java/net/UnknownHostException
    //   91	265	591	java/net/UnknownHostException
    //   268	287	591	java/net/UnknownHostException
    //   287	342	591	java/net/UnknownHostException
    //   345	369	591	java/net/UnknownHostException
    //   372	389	591	java/net/UnknownHostException
    //   393	425	591	java/net/UnknownHostException
    //   428	438	591	java/net/UnknownHostException
    //   66	91	608	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore 4
    //   7: new 274	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 275	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_3
    //   15: aload_1
    //   16: aload 4
    //   18: invokevirtual 281	java/io/InputStream:read	([B)I
    //   21: istore_2
    //   22: iload_2
    //   23: iconst_m1
    //   24: if_icmpeq +14 -> 38
    //   27: aload_3
    //   28: aload 4
    //   30: iconst_0
    //   31: iload_2
    //   32: invokevirtual 284	java/io/ByteArrayOutputStream:write	([BII)V
    //   35: goto -20 -> 15
    //   38: aload_3
    //   39: invokevirtual 288	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_1
    //   43: aload_3
    //   44: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   47: aload_1
    //   48: areturn
    //   49: astore_3
    //   50: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   53: aload_3
    //   54: invokevirtual 227	java/lang/Exception:toString	()Ljava/lang/String;
    //   57: invokestatic 203	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_1
    //   63: goto +39 -> 102
    //   66: astore_1
    //   67: new 91	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 291
    //   74: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: astore 4
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 294	java/io/IOException:getMessage	()Ljava/lang/String;
    //   85: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: new 69	java/lang/Exception
    //   92: dup
    //   93: aload 4
    //   95: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 295	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: aload_3
    //   103: invokevirtual 289	java/io/ByteArrayOutputStream:close	()V
    //   106: goto +14 -> 120
    //   109: astore_3
    //   110: getstatic 71	btmsdkobf/ca:TAG	Ljava/lang/String;
    //   113: aload_3
    //   114: invokevirtual 227	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: invokestatic 203	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	ca
    //   0	122	1	paramInputStream	java.io.InputStream
    //   21	11	2	i	int
    //   14	30	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   49	54	3	localException1	Exception
    //   109	5	3	localException2	Exception
    //   5	89	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/lang/Exception
    //   15	22	62	finally
    //   27	35	62	finally
    //   38	43	62	finally
    //   67	102	62	finally
    //   15	22	66	java/io/IOException
    //   27	35	66	java/io/IOException
    //   38	43	66	java/io/IOException
    //   102	106	109	java/lang/Exception
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
      StringBuilder localStringBuilder = new StringBuilder("getRedirectUrl() e: ");
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
        if (aor.b == localObject)
        {
          eh.g(TAG, "[http_control]start() no network");
          return -220000;
        }
        if (aor.e == localObject)
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
      localStringBuilder = new StringBuilder("[http_control]start() MalformedURLException e:");
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
          break label461;
        }
        j = 1;
      }
      finally {}
      if (m < k)
      {
        Object localObject = NetworkUtil.getNetworkType();
        if (aor.b == localObject)
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
              localObject = "http://".concat(String.valueOf(str));
            }
          }
        }
        else
        {
          localObject = this.hf.bg();
        }
        i = s((String)localObject);
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("[http_control]start(), ret: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" httpUrl: ");
        localStringBuilder.append((String)localObject);
        eh.f(str, localStringBuilder.toString());
        if (i != 0) {
          break label484;
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
              break label487;
            }
            try
            {
              Thread.sleep(300L);
            }
            catch (InterruptedException localInterruptedException)
            {
              str = TAG;
              localStringBuilder = new StringBuilder("[http_control]sendData() InterruptedException e: ");
              localStringBuilder.append(localInterruptedException.toString());
              eh.h(str, localStringBuilder.toString());
            }
          }
        }
        else
        {
          paramf = TAG;
          paramArrayOfByte = "[http_control]sendData() 发包成功或无网络，不重试， ret: ".concat(String.valueOf(i));
          continue;
        }
      }
      eh.e(TAG, "[http_control]sendData() ret: ".concat(String.valueOf(i)));
      return i;
      int i = -10;
      continue;
      label461:
      int j = 0;
      int k = 3;
      if (j != 0) {
        k = 1;
      }
      int m = 0;
      i = -1;
      continue;
      label484:
      continue;
      label487:
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