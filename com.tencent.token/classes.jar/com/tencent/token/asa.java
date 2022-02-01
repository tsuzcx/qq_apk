package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class asa
{
  private static String b = "HttpNetwork";
  public asc a;
  private final int c = 5;
  private final int d = 3;
  private String e = "POST";
  private boolean f = false;
  private HttpURLConnection g;
  private String h;
  private int i = 0;
  private asr j;
  private volatile String k = null;
  
  public asa(Context paramContext, asr paramasr)
  {
    this.j = paramasr;
    this.a = new asc(paramContext, paramasr);
  }
  
  /* Error */
  private boolean a(AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 40	com/tencent/token/asa:f	Z
    //   7: aload_0
    //   8: getfield 42	com/tencent/token/asa:i	I
    //   11: iconst_3
    //   12: if_icmplt +7 -> 19
    //   15: aload_0
    //   16: invokespecial 70	com/tencent/token/asa:d	()V
    //   19: aload_0
    //   20: getfield 72	com/tencent/token/asa:h	Ljava/lang/String;
    //   23: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +28 -> 54
    //   29: aload_0
    //   30: getfield 52	com/tencent/token/asa:a	Lcom/tencent/token/asc;
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 81	com/tencent/token/asc:c	()Z
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 83	com/tencent/token/asc:d	()Ljava/lang/String;
    //   43: astore_2
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 89	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   49: aload_2
    //   50: astore_1
    //   51: goto +8 -> 59
    //   54: aload_0
    //   55: getfield 72	com/tencent/token/asa:h	Ljava/lang/String;
    //   58: astore_1
    //   59: invokestatic 94	com/tencent/token/auk:a	()Lcom/tencent/token/ke;
    //   62: astore_2
    //   63: new 96	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 98
    //   69: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: astore_3
    //   73: aload_3
    //   74: aload_1
    //   75: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: ldc 107
    //   82: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: new 96	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 98
    //   98: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: aload_3
    //   103: aload_1
    //   104: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc 107
    //   111: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_3
    //   116: aload_2
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: getstatic 115	com/tencent/token/ke:a	Lcom/tencent/token/ke;
    //   124: astore_3
    //   125: aload_3
    //   126: aload_2
    //   127: if_acmpne +7 -> 134
    //   130: aload_0
    //   131: monitorexit
    //   132: iconst_0
    //   133: ireturn
    //   134: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   137: pop2
    //   138: new 123	java/net/URL
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 124	java/net/URL:<init>	(Ljava/lang/String;)V
    //   146: astore_1
    //   147: getstatic 126	com/tencent/token/ke:d	Lcom/tencent/token/ke;
    //   150: aload_2
    //   151: if_acmpne +36 -> 187
    //   154: aload_0
    //   155: aload_1
    //   156: new 128	java/net/Proxy
    //   159: dup
    //   160: getstatic 134	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   163: invokestatic 136	com/tencent/token/auk:b	()Ljava/lang/String;
    //   166: invokestatic 139	com/tencent/token/auk:c	()I
    //   169: invokestatic 145	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   172: invokespecial 148	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   175: invokevirtual 152	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   178: checkcast 154	java/net/HttpURLConnection
    //   181: putfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   184: goto +34 -> 218
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual 159	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   192: checkcast 154	java/net/HttpURLConnection
    //   195: putfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   198: aload_0
    //   199: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   202: sipush 30000
    //   205: invokevirtual 163	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   208: aload_0
    //   209: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   212: sipush 30000
    //   215: invokevirtual 166	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   218: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   221: pop2
    //   222: getstatic 171	android/os/Build$VERSION:SDK_INT	I
    //   225: bipush 8
    //   227: if_icmpge +11 -> 238
    //   230: ldc 173
    //   232: ldc 175
    //   234: invokestatic 179	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: pop
    //   238: aload_0
    //   239: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   242: iconst_0
    //   243: invokevirtual 183	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   246: aload_0
    //   247: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   250: ldc 185
    //   252: ldc 187
    //   254: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_0
    //   258: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   261: ldc 193
    //   263: ldc 187
    //   265: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_0
    //   269: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   272: iconst_0
    //   273: invokevirtual 196	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   276: ldc 198
    //   278: aload_0
    //   279: getfield 38	com/tencent/token/asa:e	Ljava/lang/String;
    //   282: invokevirtual 204	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   285: ifeq +15 -> 300
    //   288: aload_0
    //   289: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   292: ldc 198
    //   294: invokevirtual 207	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   297: goto +61 -> 358
    //   300: aload_0
    //   301: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   304: ldc 36
    //   306: invokevirtual 207	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   309: aload_0
    //   310: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   313: iconst_1
    //   314: invokevirtual 210	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   317: aload_0
    //   318: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   321: iconst_1
    //   322: invokevirtual 213	java/net/HttpURLConnection:setDoInput	(Z)V
    //   325: aload_0
    //   326: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   329: ldc 215
    //   331: ldc 217
    //   333: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload_0
    //   337: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   340: ldc 219
    //   342: ldc 221
    //   344: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   351: ldc 223
    //   353: ldc 225
    //   355: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload_0
    //   359: monitorexit
    //   360: iconst_1
    //   361: ireturn
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 228	java/io/IOException:printStackTrace	()V
    //   367: aload_0
    //   368: monitorexit
    //   369: iconst_0
    //   370: ireturn
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 229	java/lang/UnsupportedOperationException:printStackTrace	()V
    //   376: aload_0
    //   377: monitorexit
    //   378: iconst_0
    //   379: ireturn
    //   380: astore_1
    //   381: aload_1
    //   382: invokevirtual 230	java/lang/SecurityException:printStackTrace	()V
    //   385: aload_0
    //   386: monitorexit
    //   387: iconst_0
    //   388: ireturn
    //   389: astore_1
    //   390: aload_1
    //   391: invokevirtual 231	java/lang/IllegalArgumentException:printStackTrace	()V
    //   394: aload_0
    //   395: monitorexit
    //   396: iconst_0
    //   397: ireturn
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 232	java/net/UnknownHostException:printStackTrace	()V
    //   403: aload_0
    //   404: monitorexit
    //   405: iconst_0
    //   406: ireturn
    //   407: astore_1
    //   408: aload_1
    //   409: invokevirtual 233	java/net/MalformedURLException:printStackTrace	()V
    //   412: new 96	java/lang/StringBuilder
    //   415: dup
    //   416: ldc 235
    //   418: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload_1
    //   422: invokevirtual 238	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   425: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: new 96	java/lang/StringBuilder
    //   432: dup
    //   433: ldc 235
    //   435: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: aload_1
    //   439: invokevirtual 238	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   442: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_0
    //   447: monitorexit
    //   448: iconst_0
    //   449: ireturn
    //   450: astore_1
    //   451: aload_0
    //   452: monitorexit
    //   453: aload_1
    //   454: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	asa
    //   0	455	1	paramAtomicReference	AtomicReference
    //   33	118	2	localObject1	Object
    //   72	54	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   147	184	362	java/io/IOException
    //   187	218	362	java/io/IOException
    //   218	238	362	java/io/IOException
    //   238	297	362	java/io/IOException
    //   300	358	362	java/io/IOException
    //   147	184	371	java/lang/UnsupportedOperationException
    //   187	218	371	java/lang/UnsupportedOperationException
    //   218	238	371	java/lang/UnsupportedOperationException
    //   238	297	371	java/lang/UnsupportedOperationException
    //   300	358	371	java/lang/UnsupportedOperationException
    //   147	184	380	java/lang/SecurityException
    //   187	218	380	java/lang/SecurityException
    //   218	238	380	java/lang/SecurityException
    //   238	297	380	java/lang/SecurityException
    //   300	358	380	java/lang/SecurityException
    //   147	184	389	java/lang/IllegalArgumentException
    //   187	218	389	java/lang/IllegalArgumentException
    //   218	238	389	java/lang/IllegalArgumentException
    //   238	297	389	java/lang/IllegalArgumentException
    //   300	358	389	java/lang/IllegalArgumentException
    //   147	184	398	java/net/UnknownHostException
    //   187	218	398	java/net/UnknownHostException
    //   218	238	398	java/net/UnknownHostException
    //   238	297	398	java/net/UnknownHostException
    //   300	358	398	java/net/UnknownHostException
    //   138	147	407	java/net/MalformedURLException
    //   2	19	450	finally
    //   19	49	450	finally
    //   54	59	450	finally
    //   59	125	450	finally
    //   134	138	450	finally
    //   138	147	450	finally
    //   147	184	450	finally
    //   187	218	450	finally
    //   218	238	450	finally
    //   238	297	450	finally
    //   300	358	450	finally
    //   363	367	450	finally
    //   372	376	450	finally
    //   381	385	450	finally
    //   390	394	450	finally
    //   399	403	450	finally
    //   408	446	450	finally
  }
  
  /* Error */
  private static byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 2048
    //   3: newarray byte
    //   5: astore 4
    //   7: new 243	java/io/BufferedInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 246	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: new 248	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 249	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_3
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 255	java/io/InputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +14 -> 47
    //   36: aload_3
    //   37: aload 4
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 259	java/io/ByteArrayOutputStream:write	([BII)V
    //   44: goto -20 -> 24
    //   47: aload_3
    //   48: invokevirtual 263	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: astore_0
    //   52: aload_2
    //   53: invokevirtual 266	java/io/BufferedInputStream:close	()V
    //   56: aload_3
    //   57: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_0
    //   70: goto +39 -> 109
    //   73: astore_0
    //   74: new 96	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 270
    //   81: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: aload_0
    //   89: invokevirtual 273	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: new 275	com/tencent/token/arr
    //   99: dup
    //   100: aload 4
    //   102: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokespecial 277	com/tencent/token/arr:<init>	(Ljava/lang/String;)V
    //   108: athrow
    //   109: aload_2
    //   110: invokevirtual 266	java/io/BufferedInputStream:close	()V
    //   113: aload_3
    //   114: invokevirtual 267	java/io/ByteArrayOutputStream:close	()V
    //   117: goto +8 -> 125
    //   120: astore_2
    //   121: aload_2
    //   122: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   125: aload_0
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramInputStream	java.io.InputStream
    //   30	11	1	m	int
    //   15	38	2	localBufferedInputStream	java.io.BufferedInputStream
    //   62	48	2	localException1	Exception
    //   120	2	2	localException2	Exception
    //   23	91	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   5	96	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	60	62	java/lang/Exception
    //   24	31	69	finally
    //   36	44	69	finally
    //   47	52	69	finally
    //   74	109	69	finally
    //   24	31	73	java/io/IOException
    //   36	44	73	java/io/IOException
    //   47	52	73	java/io/IOException
    //   109	117	120	java/lang/Exception
  }
  
  /* Error */
  private int b(byte[] paramArrayOfByte, AtomicReference paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   4: ifnonnull +7 -> 11
    //   7: sipush -10000
    //   10: ireturn
    //   11: ldc 198
    //   13: aload_0
    //   14: getfield 38	com/tencent/token/asa:e	Ljava/lang/String;
    //   17: invokevirtual 204	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   20: ifne +39 -> 59
    //   23: aload_0
    //   24: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   27: astore 4
    //   29: new 96	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: aload_1
    //   41: arraylength
    //   42: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: ldc_w 296
    //   51: aload 5
    //   53: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   62: pop2
    //   63: aload_0
    //   64: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   67: invokevirtual 300	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   70: astore 4
    //   72: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   75: pop2
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 305	java/io/OutputStream:write	([B)V
    //   82: aload 4
    //   84: invokevirtual 308	java/io/OutputStream:flush	()V
    //   87: aload 4
    //   89: invokevirtual 309	java/io/OutputStream:close	()V
    //   92: aload_0
    //   93: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   96: invokevirtual 312	java/net/HttpURLConnection:getResponseCode	()I
    //   99: istore_3
    //   100: iload_3
    //   101: sipush 301
    //   104: if_icmplt +291 -> 395
    //   107: iload_3
    //   108: sipush 305
    //   111: if_icmpgt +284 -> 395
    //   114: iconst_1
    //   115: istore_3
    //   116: goto +3 -> 119
    //   119: iload_3
    //   120: ifeq +99 -> 219
    //   123: aload_0
    //   124: aload_0
    //   125: invokespecial 314	com/tencent/token/asa:e	()Ljava/lang/String;
    //   128: putfield 72	com/tencent/token/asa:h	Ljava/lang/String;
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 42	com/tencent/token/asa:i	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 42	com/tencent/token/asa:i	I
    //   141: new 96	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 316
    //   148: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: astore_1
    //   152: aload_1
    //   153: aload_0
    //   154: getfield 72	com/tencent/token/asa:h	Ljava/lang/String;
    //   157: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: ldc_w 318
    //   165: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: aload_0
    //   171: getfield 42	com/tencent/token/asa:i	I
    //   174: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: new 96	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 316
    //   185: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: astore_1
    //   189: aload_1
    //   190: aload_0
    //   191: getfield 72	com/tencent/token/asa:h	Ljava/lang/String;
    //   194: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: ldc_w 318
    //   202: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: aload_0
    //   208: getfield 42	com/tencent/token/asa:i	I
    //   211: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc_w 319
    //   218: ireturn
    //   219: aload_0
    //   220: invokespecial 70	com/tencent/token/asa:d	()V
    //   223: aload_0
    //   224: aconst_null
    //   225: putfield 44	com/tencent/token/asa:k	Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   232: invokevirtual 323	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   235: pop
    //   236: aload_0
    //   237: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   240: ldc_w 325
    //   243: invokevirtual 329	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_1
    //   247: aload_1
    //   248: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +7 -> 258
    //   254: ldc_w 330
    //   257: ireturn
    //   258: aload_1
    //   259: ldc_w 332
    //   262: invokevirtual 336	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   265: ifne +7 -> 272
    //   268: ldc_w 330
    //   271: ireturn
    //   272: aload_2
    //   273: aload_0
    //   274: getfield 156	com/tencent/token/asa:g	Ljava/net/HttpURLConnection;
    //   277: invokevirtual 340	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   280: invokestatic 342	com/tencent/token/asa:a	(Ljava/io/InputStream;)[B
    //   283: invokevirtual 89	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   293: ldc_w 343
    //   296: ireturn
    //   297: astore_1
    //   298: goto +95 -> 393
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   306: ldc_w 344
    //   309: ireturn
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 228	java/io/IOException:printStackTrace	()V
    //   315: ldc_w 345
    //   318: ireturn
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 346	java/net/SocketTimeoutException:printStackTrace	()V
    //   324: ldc_w 347
    //   327: ireturn
    //   328: astore_1
    //   329: aload_0
    //   330: invokespecial 349	com/tencent/token/asa:b	()Z
    //   333: ifeq +7 -> 340
    //   336: ldc_w 350
    //   339: ireturn
    //   340: aload_1
    //   341: invokevirtual 351	java/net/SocketException:printStackTrace	()V
    //   344: ldc_w 352
    //   347: ireturn
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual 353	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   353: ldc_w 354
    //   356: ireturn
    //   357: astore_1
    //   358: aload_1
    //   359: invokevirtual 355	java/net/ProtocolException:printStackTrace	()V
    //   362: ldc_w 356
    //   365: ireturn
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 357	java/lang/IllegalStateException:printStackTrace	()V
    //   371: ldc_w 358
    //   374: ireturn
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 359	java/lang/IllegalAccessError:printStackTrace	()V
    //   380: ldc_w 360
    //   383: ireturn
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 232	java/net/UnknownHostException:printStackTrace	()V
    //   389: ldc_w 361
    //   392: ireturn
    //   393: aload_1
    //   394: athrow
    //   395: iconst_0
    //   396: istore_3
    //   397: goto -278 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	asa
    //   0	400	1	paramArrayOfByte	byte[]
    //   0	400	2	paramAtomicReference	AtomicReference
    //   99	298	3	m	int
    //   27	61	4	localObject	Object
    //   36	16	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   228	254	288	java/lang/Exception
    //   258	268	288	java/lang/Exception
    //   272	286	288	java/lang/Exception
    //   59	100	297	finally
    //   123	215	297	finally
    //   219	228	297	finally
    //   228	254	297	finally
    //   258	268	297	finally
    //   272	286	297	finally
    //   289	293	297	finally
    //   302	306	297	finally
    //   311	315	297	finally
    //   320	324	297	finally
    //   329	336	297	finally
    //   340	344	297	finally
    //   349	353	297	finally
    //   358	362	297	finally
    //   367	371	297	finally
    //   376	380	297	finally
    //   385	389	297	finally
    //   59	100	301	java/lang/Exception
    //   123	215	301	java/lang/Exception
    //   219	228	301	java/lang/Exception
    //   289	293	301	java/lang/Exception
    //   59	100	310	java/io/IOException
    //   123	215	310	java/io/IOException
    //   219	228	310	java/io/IOException
    //   228	254	310	java/io/IOException
    //   258	268	310	java/io/IOException
    //   272	286	310	java/io/IOException
    //   289	293	310	java/io/IOException
    //   59	100	319	java/net/SocketTimeoutException
    //   123	215	319	java/net/SocketTimeoutException
    //   219	228	319	java/net/SocketTimeoutException
    //   228	254	319	java/net/SocketTimeoutException
    //   258	268	319	java/net/SocketTimeoutException
    //   272	286	319	java/net/SocketTimeoutException
    //   289	293	319	java/net/SocketTimeoutException
    //   59	100	328	java/net/SocketException
    //   123	215	328	java/net/SocketException
    //   219	228	328	java/net/SocketException
    //   228	254	328	java/net/SocketException
    //   258	268	328	java/net/SocketException
    //   272	286	328	java/net/SocketException
    //   289	293	328	java/net/SocketException
    //   59	100	348	org/apache/http/client/ClientProtocolException
    //   123	215	348	org/apache/http/client/ClientProtocolException
    //   219	228	348	org/apache/http/client/ClientProtocolException
    //   228	254	348	org/apache/http/client/ClientProtocolException
    //   258	268	348	org/apache/http/client/ClientProtocolException
    //   272	286	348	org/apache/http/client/ClientProtocolException
    //   289	293	348	org/apache/http/client/ClientProtocolException
    //   59	100	357	java/net/ProtocolException
    //   123	215	357	java/net/ProtocolException
    //   219	228	357	java/net/ProtocolException
    //   228	254	357	java/net/ProtocolException
    //   258	268	357	java/net/ProtocolException
    //   272	286	357	java/net/ProtocolException
    //   289	293	357	java/net/ProtocolException
    //   59	100	366	java/lang/IllegalStateException
    //   123	215	366	java/lang/IllegalStateException
    //   219	228	366	java/lang/IllegalStateException
    //   228	254	366	java/lang/IllegalStateException
    //   258	268	366	java/lang/IllegalStateException
    //   272	286	366	java/lang/IllegalStateException
    //   289	293	366	java/lang/IllegalStateException
    //   59	100	375	java/lang/IllegalAccessError
    //   123	215	375	java/lang/IllegalAccessError
    //   219	228	375	java/lang/IllegalAccessError
    //   228	254	375	java/lang/IllegalAccessError
    //   258	268	375	java/lang/IllegalAccessError
    //   272	286	375	java/lang/IllegalAccessError
    //   289	293	375	java/lang/IllegalAccessError
    //   59	100	384	java/net/UnknownHostException
    //   123	215	384	java/net/UnknownHostException
    //   219	228	384	java/net/UnknownHostException
    //   228	254	384	java/net/UnknownHostException
    //   258	268	384	java/net/UnknownHostException
    //   272	286	384	java/net/UnknownHostException
    //   289	293	384	java/net/UnknownHostException
  }
  
  private boolean b()
  {
    Object localObject = auk.a();
    int m;
    if (ke.c == localObject) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return false;
    }
    localObject = null;
    try
    {
      String str = aun.a(new asb(this));
      localObject = str;
    }
    catch (ars localars)
    {
      new StringBuilder("checkWifiApprovement() WifiApproveException e: ").append(localars.toString());
      new StringBuilder("checkWifiApprovement() WifiApproveException e: ").append(localars.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    this.k = ((String)localObject);
    new StringBuilder("checkWifiApprovement() mWifiApprovementUrl: ").append(this.k);
    new StringBuilder("checkWifiApprovement() mWifiApprovementUrl: ").append(this.k);
    return true;
  }
  
  private boolean c()
  {
    try
    {
      this.f = false;
      this.f = false;
      HttpURLConnection localHttpURLConnection = this.g;
      if (localHttpURLConnection == null) {
        return false;
      }
      this.g.disconnect();
      this.g = null;
      return true;
    }
    finally {}
  }
  
  private void d()
  {
    this.h = null;
    this.i = 0;
  }
  
  private String e()
  {
    try
    {
      String str = this.g.getHeaderField("Location");
      return str;
    }
    catch (Exception localException)
    {
      new StringBuilder("getRedirectUrl() e: ").append(localException.toString());
      new StringBuilder("getRedirectUrl() e: ").append(localException.toString());
    }
    return null;
  }
  
  public final int a(byte[] paramArrayOfByte, AtomicReference arg2)
  {
    if (paramArrayOfByte == null) {
      return -10;
    }
    for (;;)
    {
      int n;
      try
      {
        boolean bool = arx.a();
        if (bool) {
          return -7;
        }
        new StringBuilder("sendData() data.length: ").append(paramArrayOfByte.length);
        new StringBuilder("sendData() data.length: ").append(paramArrayOfByte.length);
        n = 0;
        int m = -1;
        int i1 = m;
        if (n < 5)
        {
          bool = this.f;
          ??? = new AtomicReference();
          if ((!bool) && (!a((AtomicReference)???))) {
            break label430;
          }
          i1 = b(paramArrayOfByte, ???);
          if (i1 == 0)
          {
            c();
            paramArrayOfByte = this.a;
            ??? = (String)((AtomicReference)???).get();
            synchronized (paramArrayOfByte.f)
            {
              paramArrayOfByte.i = ((String)???);
            }
          }
          if (-160000 == i1)
          {
            c();
          }
          else
          {
            c();
            asc localasc;
            if ((-70000 == i1) || (-130000 == i1) || (-170000 == i1)) {
              localasc = this.a;
            }
            synchronized (localasc.h)
            {
              localasc.g += 1;
              if (localasc.g >= localasc.h.size()) {
                localasc.g = 0;
              }
              StringBuilder localStringBuilder = new StringBuilder("gotoNextIp() size: ");
              localStringBuilder.append(localasc.h.size());
              localStringBuilder.append(" mCurIpIdx: ");
              localStringBuilder.append(localasc.g);
              localStringBuilder = new StringBuilder("gotoNextIp() size: ");
              localStringBuilder.append(localasc.h.size());
              localStringBuilder.append(" mCurIpIdx: ");
              localStringBuilder.append(localasc.g);
              m = i1;
              if (4 == n) {
                break label430;
              }
              try
              {
                Thread.sleep(3000L);
                m = i1;
              }
              catch (InterruptedException localInterruptedException)
              {
                new StringBuilder("sendData() InterruptedException e: ").append(localInterruptedException.toString());
                new StringBuilder("sendData() InterruptedException e: ").append(localInterruptedException.toString());
                m = i1;
              }
            }
          }
        }
        return i1;
      }
      finally {}
      label430:
      n += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asa
 * JD-Core Version:    0.7.0.1
 */