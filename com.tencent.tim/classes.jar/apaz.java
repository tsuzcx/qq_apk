import java.nio.ByteBuffer;
import org.json.JSONObject;

public class apaz
{
  /* Error */
  public static long a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, long paramLong1, java.io.RandomAccessFile paramRandomAccessFile, long paramLong2, int paramInt)
    throws java.net.MalformedURLException, java.net.ProtocolException, java.io.FileNotFoundException, java.io.IOException
  {
    // Byte code:
    //   0: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 15	apaz$d
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: lload_3
    //   12: lload 6
    //   14: iload 8
    //   16: i2l
    //   17: lconst_0
    //   18: lconst_0
    //   19: invokespecial 38	apaz$d:<init>	([B[BJJJJJ)V
    //   22: astore_0
    //   23: new 12	apaz$c
    //   26: dup
    //   27: iload 8
    //   29: sipush 348
    //   32: iadd
    //   33: i2l
    //   34: invokespecial 41	apaz$c:<init>	(J)V
    //   37: astore_1
    //   38: iload 8
    //   40: sipush 364
    //   43: iadd
    //   44: invokestatic 47	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   47: astore 12
    //   49: aload_1
    //   50: aload 12
    //   52: invokevirtual 51	apaz$c:writeTo	(Ljava/nio/ByteBuffer;)V
    //   55: aload_0
    //   56: aload 12
    //   58: invokevirtual 52	apaz$d:writeTo	(Ljava/nio/ByteBuffer;)V
    //   61: aload 5
    //   63: lload 6
    //   65: invokevirtual 57	java/io/RandomAccessFile:seek	(J)V
    //   68: iload 8
    //   70: newarray byte
    //   72: astore_0
    //   73: aload 5
    //   75: aload_0
    //   76: invokevirtual 61	java/io/RandomAccessFile:read	([B)I
    //   79: pop
    //   80: aload 12
    //   82: aload_0
    //   83: invokevirtual 65	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   86: pop
    //   87: new 67	java/net/URL
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: invokevirtual 74	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 76	java/net/HttpURLConnection
    //   101: astore_0
    //   102: aload_0
    //   103: ldc 78
    //   105: invokevirtual 81	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: iconst_1
    //   110: invokevirtual 85	java/net/HttpURLConnection:setDoInput	(Z)V
    //   113: aload_0
    //   114: iconst_1
    //   115: invokevirtual 88	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   118: aload_0
    //   119: invokevirtual 92	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   122: astore_1
    //   123: aload_1
    //   124: aload 12
    //   126: invokevirtual 96	java/nio/ByteBuffer:array	()[B
    //   129: invokevirtual 102	java/io/OutputStream:write	([B)V
    //   132: aload_1
    //   133: invokevirtual 106	java/io/OutputStream:flush	()V
    //   136: aload_0
    //   137: invokevirtual 109	java/net/HttpURLConnection:connect	()V
    //   140: aload_0
    //   141: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   144: astore_2
    //   145: new 115	java/io/ByteArrayOutputStream
    //   148: dup
    //   149: invokespecial 117	java/io/ByteArrayOutputStream:<init>	()V
    //   152: astore 13
    //   154: bipush 25
    //   156: newarray byte
    //   158: astore 5
    //   160: aload_2
    //   161: aload 5
    //   163: invokevirtual 120	java/io/InputStream:read	([B)I
    //   166: istore 9
    //   168: iload 9
    //   170: iconst_m1
    //   171: if_icmpeq +77 -> 248
    //   174: aload 13
    //   176: aload 5
    //   178: iconst_0
    //   179: iload 9
    //   181: invokevirtual 123	java/io/ByteArrayOutputStream:write	([BII)V
    //   184: goto -24 -> 160
    //   187: astore 5
    //   189: aload_0
    //   190: astore 12
    //   192: aload 5
    //   194: astore_0
    //   195: aload_1
    //   196: astore 5
    //   198: aload 13
    //   200: astore_1
    //   201: aload 5
    //   203: ifnull +13 -> 216
    //   206: aload 5
    //   208: invokevirtual 106	java/io/OutputStream:flush	()V
    //   211: aload 5
    //   213: invokevirtual 126	java/io/OutputStream:close	()V
    //   216: aload_1
    //   217: ifnull +11 -> 228
    //   220: aload_1
    //   221: invokevirtual 127	java/io/ByteArrayOutputStream:flush	()V
    //   224: aload_1
    //   225: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 129	java/io/InputStream:close	()V
    //   236: aload 12
    //   238: ifnull +8 -> 246
    //   241: aload 12
    //   243: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   246: aload_0
    //   247: athrow
    //   248: aload 13
    //   250: invokevirtual 135	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   253: invokestatic 138	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   256: astore 12
    //   258: new 12	apaz$c
    //   261: dup
    //   262: aload 12
    //   264: invokespecial 140	apaz$c:<init>	(Ljava/nio/ByteBuffer;)V
    //   267: astore 5
    //   269: new 18	apaz$e
    //   272: dup
    //   273: aload 12
    //   275: invokespecial 141	apaz$e:<init>	(Ljava/nio/ByteBuffer;)V
    //   278: astore 12
    //   280: aload 5
    //   282: getfield 145	apaz$c:aqJ	J
    //   285: lconst_0
    //   286: lcmp
    //   287: ifne +189 -> 476
    //   290: aload 12
    //   292: getfield 149	apaz$e:flag	I
    //   295: istore 9
    //   297: iload 9
    //   299: iconst_1
    //   300: if_icmpne +103 -> 403
    //   303: aload_1
    //   304: ifnull +11 -> 315
    //   307: aload_1
    //   308: invokevirtual 106	java/io/OutputStream:flush	()V
    //   311: aload_1
    //   312: invokevirtual 126	java/io/OutputStream:close	()V
    //   315: aload 13
    //   317: ifnull +13 -> 330
    //   320: aload 13
    //   322: invokevirtual 127	java/io/ByteArrayOutputStream:flush	()V
    //   325: aload 13
    //   327: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   330: aload_2
    //   331: ifnull +7 -> 338
    //   334: aload_2
    //   335: invokevirtual 129	java/io/InputStream:close	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   346: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +52 -> 401
    //   352: ldc 157
    //   354: iconst_2
    //   355: new 159	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   362: ldc 162
    //   364: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   370: lload 10
    //   372: lsub
    //   373: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: ldc 171
    //   378: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: lload_3
    //   382: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc 173
    //   387: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 8
    //   392: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: lload_3
    //   402: lreturn
    //   403: aload 12
    //   405: getfield 186	apaz$e:offset	J
    //   408: lstore_3
    //   409: goto -106 -> 303
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_2
    //   417: aconst_null
    //   418: astore 5
    //   420: aconst_null
    //   421: astore 12
    //   423: goto -222 -> 201
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_2
    //   429: aconst_null
    //   430: astore 5
    //   432: aload_0
    //   433: astore 12
    //   435: aload_1
    //   436: astore_0
    //   437: aconst_null
    //   438: astore_1
    //   439: goto -238 -> 201
    //   442: astore 13
    //   444: aconst_null
    //   445: astore_2
    //   446: aload_1
    //   447: astore 5
    //   449: aload_0
    //   450: astore 12
    //   452: aload 13
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -256 -> 201
    //   460: astore 13
    //   462: aload_1
    //   463: astore 5
    //   465: aload_0
    //   466: astore 12
    //   468: aload 13
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_1
    //   473: goto -272 -> 201
    //   476: ldc2_w 187
    //   479: lstore_3
    //   480: goto -177 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramArrayOfByte1	byte[]
    //   0	483	1	paramArrayOfByte2	byte[]
    //   0	483	2	paramString	String
    //   0	483	3	paramLong1	long
    //   0	483	5	paramRandomAccessFile	java.io.RandomAccessFile
    //   0	483	6	paramLong2	long
    //   0	483	8	paramInt	int
    //   166	135	9	i	int
    //   3	368	10	l	long
    //   47	420	12	localObject1	Object
    //   152	174	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   442	11	13	localObject2	Object
    //   460	9	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   154	160	187	finally
    //   160	168	187	finally
    //   174	184	187	finally
    //   248	297	187	finally
    //   403	409	187	finally
    //   5	102	412	finally
    //   102	123	426	finally
    //   123	145	442	finally
    //   145	154	460	finally
  }
  
  /* Error */
  public static apaz.a a(android.os.Bundle paramBundle, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: ldc 195
    //   8: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 9
    //   13: aload_0
    //   14: ldc 203
    //   16: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_0
    //   22: ldc 205
    //   24: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 11
    //   29: aload_0
    //   30: ldc 207
    //   32: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 14
    //   37: aload_0
    //   38: ldc 209
    //   40: invokevirtual 201	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 15
    //   45: aload_0
    //   46: ldc 211
    //   48: iconst_1
    //   49: invokevirtual 215	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   52: istore_3
    //   53: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +72 -> 128
    //   59: ldc 157
    //   61: iconst_2
    //   62: new 159	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   69: ldc 217
    //   71: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 9
    //   76: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 219
    //   81: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 10
    //   86: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 221
    //   91: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 11
    //   96: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 223
    //   101: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 14
    //   106: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 225
    //   111: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 14
    //   116: invokestatic 231	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   119: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 14
    //   130: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +11 -> 144
    //   136: aload 14
    //   138: invokestatic 241	aqhq:fileExists	(Ljava/lang/String;)Z
    //   141: ifne +39 -> 180
    //   144: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +29 -> 176
    //   150: ldc 157
    //   152: iconst_2
    //   153: new 159	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   160: ldc 243
    //   162: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 14
    //   167: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: areturn
    //   180: new 247	org/apache/http/client/methods/HttpPost
    //   183: dup
    //   184: ldc 249
    //   186: invokespecial 250	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   189: astore 12
    //   191: aload 12
    //   193: ldc 252
    //   195: ldc 254
    //   197: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 12
    //   202: ldc_w 260
    //   205: ldc_w 262
    //   208: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 12
    //   213: ldc_w 264
    //   216: ldc_w 266
    //   219: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 12
    //   224: ldc_w 268
    //   227: ldc_w 270
    //   230: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload 12
    //   235: ldc_w 272
    //   238: ldc_w 274
    //   241: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 12
    //   246: ldc_w 276
    //   249: new 159	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 278
    //   259: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 280
    //   269: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc_w 282
    //   279: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload 12
    //   294: ldc_w 284
    //   297: ldc_w 286
    //   300: invokevirtual 258	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: new 288	java/util/ArrayList
    //   306: dup
    //   307: invokespecial 289	java/util/ArrayList:<init>	()V
    //   310: astore 13
    //   312: iload_3
    //   313: iconst_1
    //   314: if_icmpne +469 -> 783
    //   317: ldc_w 291
    //   320: astore_0
    //   321: aload 13
    //   323: new 293	org/apache/http/message/BasicNameValuePair
    //   326: dup
    //   327: ldc_w 295
    //   330: aload_0
    //   331: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: invokeinterface 303 2 0
    //   339: pop
    //   340: aload 13
    //   342: new 293	org/apache/http/message/BasicNameValuePair
    //   345: dup
    //   346: ldc 195
    //   348: aload 9
    //   350: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: invokeinterface 303 2 0
    //   358: pop
    //   359: aload 13
    //   361: new 293	org/apache/http/message/BasicNameValuePair
    //   364: dup
    //   365: ldc 203
    //   367: aload 10
    //   369: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: invokeinterface 303 2 0
    //   377: pop
    //   378: aload 13
    //   380: new 293	org/apache/http/message/BasicNameValuePair
    //   383: dup
    //   384: ldc 205
    //   386: aload 11
    //   388: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: invokeinterface 303 2 0
    //   396: pop
    //   397: aload 13
    //   399: new 293	org/apache/http/message/BasicNameValuePair
    //   402: dup
    //   403: ldc_w 305
    //   406: aload 14
    //   408: invokestatic 231	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   411: invokestatic 311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   414: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: invokeinterface 303 2 0
    //   422: pop
    //   423: aload 13
    //   425: new 293	org/apache/http/message/BasicNameValuePair
    //   428: dup
    //   429: ldc_w 313
    //   432: aload 14
    //   434: invokestatic 319	ahav:x	(Ljava/lang/String;)[B
    //   437: invokestatic 325	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   440: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: invokeinterface 303 2 0
    //   448: pop
    //   449: aload 13
    //   451: new 293	org/apache/http/message/BasicNameValuePair
    //   454: dup
    //   455: ldc_w 327
    //   458: aload 14
    //   460: invokestatic 330	ahav:t	(Ljava/lang/String;)[B
    //   463: invokestatic 325	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   466: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: invokeinterface 303 2 0
    //   474: pop
    //   475: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +34 -> 512
    //   481: ldc 157
    //   483: iconst_2
    //   484: new 159	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 332
    //   494: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   500: lload 6
    //   502: lsub
    //   503: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload 13
    //   514: new 293	org/apache/http/message/BasicNameValuePair
    //   517: dup
    //   518: ldc_w 334
    //   521: ldc_w 336
    //   524: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: invokeinterface 303 2 0
    //   532: pop
    //   533: aload 13
    //   535: new 293	org/apache/http/message/BasicNameValuePair
    //   538: dup
    //   539: ldc_w 338
    //   542: aload_2
    //   543: invokestatic 342	apaz:eK	(Ljava/lang/String;)I
    //   546: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   549: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: invokeinterface 303 2 0
    //   557: pop
    //   558: aload 13
    //   560: new 293	org/apache/http/message/BasicNameValuePair
    //   563: dup
    //   564: ldc_w 347
    //   567: ldc_w 349
    //   570: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: invokeinterface 303 2 0
    //   578: pop
    //   579: aload 15
    //   581: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   584: ifne +43 -> 627
    //   587: aload 13
    //   589: new 293	org/apache/http/message/BasicNameValuePair
    //   592: dup
    //   593: ldc 209
    //   595: aload 15
    //   597: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: invokeinterface 303 2 0
    //   605: pop
    //   606: aload 13
    //   608: new 293	org/apache/http/message/BasicNameValuePair
    //   611: dup
    //   612: ldc_w 351
    //   615: ldc_w 353
    //   618: invokespecial 297	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: invokeinterface 303 2 0
    //   626: pop
    //   627: aconst_null
    //   628: astore 10
    //   630: aconst_null
    //   631: astore 11
    //   633: aconst_null
    //   634: astore 9
    //   636: aconst_null
    //   637: astore_0
    //   638: aload 10
    //   640: astore_2
    //   641: aload 11
    //   643: astore_1
    //   644: aload 12
    //   646: new 355	org/apache/http/client/entity/UrlEncodedFormEntity
    //   649: dup
    //   650: aload 13
    //   652: ldc_w 357
    //   655: invokespecial 360	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   658: invokevirtual 364	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   661: aload 10
    //   663: astore_2
    //   664: aload 11
    //   666: astore_1
    //   667: new 366	org/apache/http/impl/client/DefaultHttpClient
    //   670: dup
    //   671: invokespecial 367	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   674: aload 12
    //   676: invokevirtual 371	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   679: astore 12
    //   681: aload 10
    //   683: astore_2
    //   684: aload 11
    //   686: astore_1
    //   687: aload 12
    //   689: invokeinterface 377 1 0
    //   694: invokeinterface 383 1 0
    //   699: sipush 200
    //   702: if_icmpne +385 -> 1087
    //   705: aload 10
    //   707: astore_2
    //   708: aload 11
    //   710: astore_1
    //   711: aload 12
    //   713: ldc_w 385
    //   716: invokeinterface 389 2 0
    //   721: astore 9
    //   723: aload 10
    //   725: astore_2
    //   726: aload 11
    //   728: astore_1
    //   729: aload 9
    //   731: arraylength
    //   732: istore 5
    //   734: iconst_0
    //   735: istore 4
    //   737: iconst_0
    //   738: istore_3
    //   739: iload_3
    //   740: iload 5
    //   742: if_icmpge +48 -> 790
    //   745: aload 10
    //   747: astore_2
    //   748: aload 11
    //   750: astore_1
    //   751: aload 9
    //   753: iload_3
    //   754: aaload
    //   755: invokeinterface 394 1 0
    //   760: ldc_w 396
    //   763: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   766: istore 8
    //   768: iload 8
    //   770: ifeq +6 -> 776
    //   773: iconst_1
    //   774: istore 4
    //   776: iload_3
    //   777: iconst_1
    //   778: iadd
    //   779: istore_3
    //   780: goto -41 -> 739
    //   783: ldc_w 401
    //   786: astore_0
    //   787: goto -466 -> 321
    //   790: aload 10
    //   792: astore_2
    //   793: aload 11
    //   795: astore_1
    //   796: aload 12
    //   798: invokeinterface 405 1 0
    //   803: astore 9
    //   805: iload 4
    //   807: ifeq +187 -> 994
    //   810: aload 10
    //   812: astore_2
    //   813: aload 11
    //   815: astore_1
    //   816: new 407	java/util/zip/GZIPInputStream
    //   819: dup
    //   820: aload 9
    //   822: invokeinterface 412 1 0
    //   827: invokespecial 415	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   830: astore_0
    //   831: aload_0
    //   832: invokestatic 421	com/tencent/open/base/http/HttpBaseUtil:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   835: astore 9
    //   837: aload_0
    //   838: astore_2
    //   839: aload_0
    //   840: astore_1
    //   841: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq +34 -> 878
    //   847: aload_0
    //   848: astore_2
    //   849: aload_0
    //   850: astore_1
    //   851: ldc 157
    //   853: iconst_2
    //   854: new 159	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 423
    //   864: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 9
    //   869: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: aload_0
    //   879: astore_2
    //   880: aload_0
    //   881: astore_1
    //   882: new 425	org/json/JSONObject
    //   885: dup
    //   886: aload 9
    //   888: invokespecial 426	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   891: astore 10
    //   893: aload_0
    //   894: astore_2
    //   895: aload_0
    //   896: astore_1
    //   897: aload_0
    //   898: astore 9
    //   900: aload 10
    //   902: ldc_w 428
    //   905: iconst_m1
    //   906: invokevirtual 431	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   909: ifne +178 -> 1087
    //   912: aload_0
    //   913: astore_2
    //   914: aload_0
    //   915: astore_1
    //   916: new 6	apaz$a
    //   919: dup
    //   920: aload 10
    //   922: ldc_w 433
    //   925: invokevirtual 437	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   928: invokespecial 440	apaz$a:<init>	(Lorg/json/JSONObject;)V
    //   931: astore 10
    //   933: aload_0
    //   934: astore 9
    //   936: aload 10
    //   938: astore_1
    //   939: aload_1
    //   940: astore_0
    //   941: aload 9
    //   943: ifnull +10 -> 953
    //   946: aload 9
    //   948: invokevirtual 441	java/util/zip/GZIPInputStream:close	()V
    //   951: aload_1
    //   952: astore_0
    //   953: aload_0
    //   954: astore_1
    //   955: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq -780 -> 178
    //   961: ldc 157
    //   963: iconst_2
    //   964: new 159	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   971: ldc_w 443
    //   974: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   980: lload 6
    //   982: lsub
    //   983: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   986: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   992: aload_0
    //   993: areturn
    //   994: aload 10
    //   996: astore_2
    //   997: aload 11
    //   999: astore_1
    //   1000: aload 9
    //   1002: invokestatic 448	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1005: astore 9
    //   1007: goto -170 -> 837
    //   1010: astore_0
    //   1011: aload_2
    //   1012: astore_1
    //   1013: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1016: ifeq +15 -> 1031
    //   1019: aload_2
    //   1020: astore_1
    //   1021: ldc 157
    //   1023: iconst_2
    //   1024: aload_0
    //   1025: invokestatic 452	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1028: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1031: aload_2
    //   1032: ifnull +7 -> 1039
    //   1035: aload_2
    //   1036: invokevirtual 441	java/util/zip/GZIPInputStream:close	()V
    //   1039: aconst_null
    //   1040: astore_0
    //   1041: goto -88 -> 953
    //   1044: astore_0
    //   1045: aconst_null
    //   1046: astore_0
    //   1047: goto -94 -> 953
    //   1050: astore_0
    //   1051: aload_1
    //   1052: ifnull +7 -> 1059
    //   1055: aload_1
    //   1056: invokevirtual 441	java/util/zip/GZIPInputStream:close	()V
    //   1059: aload_0
    //   1060: athrow
    //   1061: astore_0
    //   1062: aload_1
    //   1063: astore_0
    //   1064: goto -111 -> 953
    //   1067: astore_1
    //   1068: goto -9 -> 1059
    //   1071: astore_2
    //   1072: aload_0
    //   1073: astore_1
    //   1074: aload_2
    //   1075: astore_0
    //   1076: goto -25 -> 1051
    //   1079: astore_1
    //   1080: aload_0
    //   1081: astore_2
    //   1082: aload_1
    //   1083: astore_0
    //   1084: goto -73 -> 1011
    //   1087: aconst_null
    //   1088: astore_1
    //   1089: goto -150 -> 939
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1092	0	paramBundle	android.os.Bundle
    //   0	1092	1	paramString1	String
    //   0	1092	2	paramString2	String
    //   52	728	3	i	int
    //   735	71	4	j	int
    //   732	11	5	k	int
    //   3	978	6	l	long
    //   766	3	8	bool	boolean
    //   11	995	9	localObject1	Object
    //   19	976	10	localObject2	Object
    //   27	971	11	str1	String
    //   189	608	12	localObject3	Object
    //   310	341	13	localArrayList	java.util.ArrayList
    //   35	424	14	str2	String
    //   43	553	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   644	661	1010	java/lang/Exception
    //   667	681	1010	java/lang/Exception
    //   687	705	1010	java/lang/Exception
    //   711	723	1010	java/lang/Exception
    //   729	734	1010	java/lang/Exception
    //   751	768	1010	java/lang/Exception
    //   796	805	1010	java/lang/Exception
    //   816	831	1010	java/lang/Exception
    //   841	847	1010	java/lang/Exception
    //   851	878	1010	java/lang/Exception
    //   882	893	1010	java/lang/Exception
    //   900	912	1010	java/lang/Exception
    //   916	933	1010	java/lang/Exception
    //   1000	1007	1010	java/lang/Exception
    //   1035	1039	1044	java/io/IOException
    //   644	661	1050	finally
    //   667	681	1050	finally
    //   687	705	1050	finally
    //   711	723	1050	finally
    //   729	734	1050	finally
    //   751	768	1050	finally
    //   796	805	1050	finally
    //   816	831	1050	finally
    //   841	847	1050	finally
    //   851	878	1050	finally
    //   882	893	1050	finally
    //   900	912	1050	finally
    //   916	933	1050	finally
    //   1000	1007	1050	finally
    //   1013	1019	1050	finally
    //   1021	1031	1050	finally
    //   946	951	1061	java/io/IOException
    //   1055	1059	1067	java/io/IOException
    //   831	837	1071	finally
    //   831	837	1079	java/lang/Exception
  }
  
  public static int eK(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static class a
  {
    public String cnH;
    public String cnI;
    public String cnJ;
    public String cnK;
    public String cnL;
    public String fid;
    public String uin;
    public String vid;
    
    public a() {}
    
    public a(JSONObject paramJSONObject)
    {
      this.cnH = paramJSONObject.optString("serverip", "");
      this.cnI = paramJSONObject.optString("serverport", "");
      this.cnJ = paramJSONObject.optString("checkkey", "");
      this.cnK = paramJSONObject.optString("exists", "");
      this.uin = paramJSONObject.optString("uin", "");
      this.vid = paramJSONObject.optString("vid", "");
      this.fid = paramJSONObject.optString("fid", "");
      this.cnL = paramJSONObject.optString("complete", "");
    }
  }
  
  public static abstract interface b
  {
    public abstract void cju();
    
    public abstract void cjv();
    
    public abstract void gm(long paramLong);
    
    public abstract void gn(long paramLong);
    
    public abstract void go(long paramLong);
  }
  
  static class c
  {
    public final long aqI;
    public final long aqJ;
    public final long aqK;
    public final long aqL;
    
    public c(long paramLong)
    {
      this.aqI = 2882377846L;
      this.aqJ = 1007L;
      this.aqK = 0L;
      this.aqL = paramLong;
    }
    
    public c(ByteBuffer paramByteBuffer)
    {
      this.aqI = (paramByteBuffer.getInt() & 0xFFFFFFFF);
      this.aqJ = (paramByteBuffer.getInt() & 0xFFFFFFFF);
      this.aqK = (paramByteBuffer.getInt() & 0xFFFFFFFF);
      this.aqL = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    }
    
    public void writeTo(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.putInt((int)(this.aqI & 0xFFFFFFFF));
      paramByteBuffer.putInt((int)(this.aqJ & 0xFFFFFFFF));
      paramByteBuffer.putInt((int)(this.aqK & 0xFFFFFFFF));
      paramByteBuffer.putInt((int)(this.aqL & 0xFFFFFFFF));
    }
  }
  
  static class d
  {
    public final long aqM;
    public final long aqN;
    public final long aqO;
    public final int dSS = 304;
    public final int dST;
    public final long file_size;
    public final byte[] gj;
    public final byte[] go;
    public final long offset;
    
    public d(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
    {
      this.gj = paramArrayOfByte1;
      this.dST = 20;
      this.go = paramArrayOfByte2;
      this.file_size = paramLong1;
      this.offset = paramLong2;
      this.aqM = paramLong3;
      this.aqN = paramLong4;
      this.aqO = paramLong5;
    }
    
    public void writeTo(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.putShort((short)(this.dSS & 0xFFFF));
      byte[] arrayOfByte;
      if (this.gj.length == this.dSS) {
        arrayOfByte = this.gj;
      }
      for (;;)
      {
        paramByteBuffer.put(arrayOfByte, 0, this.dSS);
        paramByteBuffer.putShort((short)(this.dST & 0xFFFF));
        if (this.go.length == this.dST) {
          arrayOfByte = this.go;
        }
        for (;;)
        {
          paramByteBuffer.put(arrayOfByte, 0, this.dST);
          paramByteBuffer.putInt((int)(this.file_size & 0xFFFFFFFF));
          paramByteBuffer.putInt((int)(this.offset & 0xFFFFFFFF));
          paramByteBuffer.putInt((int)(this.aqM & 0xFFFFFFFF));
          paramByteBuffer.putInt((int)(this.aqN & 0xFFFFFFFF));
          paramByteBuffer.putInt((int)(this.aqO & 0xFFFFFFFF));
          return;
          arrayOfByte = new byte[this.dSS];
          if (this.gj.length > this.dSS) {}
          for (int i = this.dSS;; i = this.gj.length)
          {
            System.arraycopy(this.gj, 0, arrayOfByte, 0, i);
            while (i < this.dSS)
            {
              arrayOfByte[i] = 0;
              i += 1;
            }
          }
          arrayOfByte = new byte[this.dST];
          if (this.go.length > this.dST) {}
          for (i = this.dST;; i = this.go.length)
          {
            System.arraycopy(this.go, 0, arrayOfByte, 0, i);
            while (i < this.dST)
            {
              arrayOfByte[i] = 0;
              i += 1;
            }
          }
        }
      }
    }
  }
  
  static class e
  {
    public final long aqP;
    public final int flag;
    public final long offset;
    
    public e(ByteBuffer paramByteBuffer)
    {
      this.flag = (paramByteBuffer.get() & 0xFFFF);
      this.offset = (paramByteBuffer.getInt() & 0xFFFFFFFF);
      this.aqP = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apaz
 * JD-Core Version:    0.7.0.1
 */