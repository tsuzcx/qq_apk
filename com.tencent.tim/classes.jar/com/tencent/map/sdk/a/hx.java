package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.OverSeaRequest;
import com.tencent.map.tools.net.NetResponse;
import java.lang.ref.WeakReference;

public final class hx
  extends AsyncTask<Object, Void, Boolean>
{
  private WeakReference<Context> a;
  private WeakReference<a> b;
  
  public hx(Context paramContext, a parama)
  {
    this.a = new WeakReference(paramContext);
    this.b = new WeakReference(parama);
  }
  
  private Boolean a()
  {
    if (this.a.get() == null) {
      return Boolean.FALSE;
    }
    Context localContext = (Context)this.a.get();
    try
    {
      NetResponse localNetResponse = ((OverSeaRequest)((nh)MapServiceManager.getService(nh.class)).c()).checkAuth(pz.a, "4.2.8", gf.a(localContext).b("worldMapProtocolVersion"), fz.a(), gf.a(localContext).b("worldMapFrontierVersion"));
      if ((localNetResponse == null) || (!localNetResponse.available())) {
        return Boolean.FALSE;
      }
      boolean bool = a(localContext, localNetResponse.toString());
      return Boolean.valueOf(bool);
    }
    catch (Throwable localThrowable)
    {
      or.a(localThrowable.getMessage(), localThrowable);
    }
    return Boolean.FALSE;
  }
  
  /* Error */
  private static boolean a(Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore_2
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokevirtual 116	java/lang/String:length	()I
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 118	org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 121	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: ldc 123
    //   30: ldc 124
    //   32: invokevirtual 128	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   35: ifeq +57 -> 92
    //   38: invokestatic 133	com/tencent/map/sdk/a/jx:d	()Z
    //   41: iconst_0
    //   42: ixor
    //   43: iconst_0
    //   44: ior
    //   45: istore 7
    //   47: iconst_0
    //   48: invokestatic 136	com/tencent/map/sdk/a/jx:a	(Z)V
    //   51: aload_0
    //   52: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   55: ldc 138
    //   57: iconst_0
    //   58: invokevirtual 141	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Z)Z
    //   61: pop
    //   62: aload_1
    //   63: ldc 143
    //   65: invokevirtual 147	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   68: astore 12
    //   70: aload 12
    //   72: ifnonnull +47 -> 119
    //   75: iload 7
    //   77: ireturn
    //   78: astore_1
    //   79: aload_0
    //   80: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   83: ldc 70
    //   85: iconst_0
    //   86: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   89: pop
    //   90: iconst_0
    //   91: ireturn
    //   92: invokestatic 133	com/tencent/map/sdk/a/jx:d	()Z
    //   95: iconst_1
    //   96: ixor
    //   97: iconst_0
    //   98: ior
    //   99: istore 7
    //   101: iconst_1
    //   102: invokestatic 136	com/tencent/map/sdk/a/jx:a	(Z)V
    //   105: aload_0
    //   106: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   109: ldc 138
    //   111: iconst_1
    //   112: invokevirtual 141	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Z)Z
    //   115: pop
    //   116: goto -54 -> 62
    //   119: aload 12
    //   121: ldc 152
    //   123: invokevirtual 154	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   126: istore 6
    //   128: iload 6
    //   130: invokestatic 157	com/tencent/map/sdk/a/jx:f	()I
    //   133: if_icmpeq +17 -> 150
    //   136: iload 7
    //   138: iload_2
    //   139: ior
    //   140: istore 7
    //   142: iload 7
    //   144: ifne +11 -> 155
    //   147: iload 7
    //   149: ireturn
    //   150: iconst_0
    //   151: istore_2
    //   152: goto -16 -> 136
    //   155: aload 12
    //   157: ldc 159
    //   159: invokevirtual 147	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +21 -> 185
    //   167: aload_1
    //   168: ldc 161
    //   170: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +10 -> 185
    //   178: aload_1
    //   179: invokevirtual 116	java/lang/String:length	()I
    //   182: ifne +140 -> 322
    //   185: aload 12
    //   187: ldc 167
    //   189: invokevirtual 147	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   192: astore_1
    //   193: iconst_0
    //   194: newarray int
    //   196: astore 9
    //   198: ldc 169
    //   200: astore 11
    //   202: aload_1
    //   203: ifnull +470 -> 673
    //   206: aload_1
    //   207: ldc 171
    //   209: sipush 1000
    //   212: invokevirtual 128	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: istore_3
    //   216: aload_1
    //   217: ldc 173
    //   219: getstatic 178	com/tencent/map/sdk/a/jy:a	I
    //   222: invokevirtual 128	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   225: istore 4
    //   227: aload_1
    //   228: ldc 152
    //   230: getstatic 180	com/tencent/map/sdk/a/jy:b	I
    //   233: invokevirtual 128	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   236: istore 5
    //   238: aload_1
    //   239: ldc 182
    //   241: invokevirtual 165	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 10
    //   246: aload_1
    //   247: ldc 184
    //   249: invokevirtual 188	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   252: astore 13
    //   254: aload 11
    //   256: astore_1
    //   257: aload 9
    //   259: astore 8
    //   261: aload 10
    //   263: invokestatic 193	com/tencent/map/sdk/a/nl:a	(Ljava/lang/String;)Z
    //   266: ifne +203 -> 469
    //   269: aload 11
    //   271: astore_1
    //   272: aload 9
    //   274: astore 8
    //   276: aload 13
    //   278: ifnull +191 -> 469
    //   281: aload 13
    //   283: invokevirtual 196	org/json/JSONArray:toString	()Ljava/lang/String;
    //   286: astore_1
    //   287: aload 13
    //   289: invokevirtual 197	org/json/JSONArray:length	()I
    //   292: newarray int
    //   294: astore 8
    //   296: iconst_0
    //   297: istore_2
    //   298: iload_2
    //   299: aload 8
    //   301: arraylength
    //   302: if_icmpge +167 -> 469
    //   305: aload 8
    //   307: iload_2
    //   308: aload 13
    //   310: iload_2
    //   311: invokevirtual 200	org/json/JSONArray:optInt	(I)I
    //   314: iastore
    //   315: iload_2
    //   316: iconst_1
    //   317: iadd
    //   318: istore_2
    //   319: goto -21 -> 298
    //   322: new 202	java/net/URL
    //   325: dup
    //   326: aload_1
    //   327: invokespecial 203	java/net/URL:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 207	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   333: checkcast 209	java/net/HttpURLConnection
    //   336: astore_1
    //   337: aload_1
    //   338: ldc 211
    //   340: ldc 213
    //   342: invokevirtual 217	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_1
    //   346: invokevirtual 220	java/net/HttpURLConnection:getResponseCode	()I
    //   349: sipush 200
    //   352: if_icmpne +345 -> 697
    //   355: aload_1
    //   356: ldc 222
    //   358: invokevirtual 225	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore 9
    //   363: aload 9
    //   365: ifnull +22 -> 387
    //   368: aload 9
    //   370: invokevirtual 116	java/lang/String:length	()I
    //   373: ifle +14 -> 387
    //   376: aload 9
    //   378: invokevirtual 228	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   381: ldc 213
    //   383: invokevirtual 232	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   386: pop
    //   387: new 234	java/util/zip/GZIPInputStream
    //   390: dup
    //   391: aload_1
    //   392: invokevirtual 238	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   395: invokespecial 241	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   398: astore_1
    //   399: new 112	java/lang/String
    //   402: dup
    //   403: aload_1
    //   404: invokestatic 246	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   407: invokespecial 249	java/lang/String:<init>	([B)V
    //   410: astore 8
    //   412: invokestatic 254	com/tencent/map/sdk/a/jv:a	()Lcom/tencent/map/sdk/a/jv;
    //   415: pop
    //   416: aload 8
    //   418: invokestatic 255	com/tencent/map/sdk/a/jv:b	(Ljava/lang/String;)I
    //   421: istore_2
    //   422: aload_0
    //   423: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   426: ldc 80
    //   428: iload_2
    //   429: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   432: pop
    //   433: invokestatic 254	com/tencent/map/sdk/a/jv:a	()Lcom/tencent/map/sdk/a/jv;
    //   436: aload 8
    //   438: invokevirtual 256	com/tencent/map/sdk/a/jv:a	(Ljava/lang/String;)Z
    //   441: pop
    //   442: aload_1
    //   443: invokestatic 259	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   446: goto -261 -> 185
    //   449: astore_1
    //   450: aconst_null
    //   451: astore_1
    //   452: aload_1
    //   453: invokestatic 259	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   456: goto -271 -> 185
    //   459: astore_0
    //   460: aload 8
    //   462: astore_1
    //   463: aload_1
    //   464: invokestatic 259	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   467: aload_0
    //   468: athrow
    //   469: iload 5
    //   471: invokestatic 261	com/tencent/map/sdk/a/jx:c	()I
    //   474: if_icmpne +10 -> 484
    //   477: iload_3
    //   478: invokestatic 263	com/tencent/map/sdk/a/jx:a	()I
    //   481: if_icmpeq +43 -> 524
    //   484: new 265	java/io/File
    //   487: dup
    //   488: new 267	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   495: aload_0
    //   496: invokestatic 274	com/tencent/tencentmap/io/QStorageManager:getStorageRootPath	(Landroid/content/Context;)Ljava/lang/String;
    //   499: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: getstatic 281	java/io/File:separator	Ljava/lang/String;
    //   505: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 283
    //   511: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   520: invokestatic 290	com/tencent/map/sdk/a/om:b	(Ljava/io/File;)Z
    //   523: pop
    //   524: iload 5
    //   526: istore_2
    //   527: aload_1
    //   528: astore 9
    //   530: aload 10
    //   532: astore_1
    //   533: aload 12
    //   535: ldc_w 292
    //   538: invokevirtual 188	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   541: astore 11
    //   543: ldc_w 294
    //   546: astore 10
    //   548: aload 11
    //   550: ifnull +10 -> 560
    //   553: aload 11
    //   555: invokevirtual 196	org/json/JSONArray:toString	()Ljava/lang/String;
    //   558: astore 10
    //   560: iload 4
    //   562: iload_3
    //   563: iload_2
    //   564: iload 6
    //   566: aload_1
    //   567: aload 8
    //   569: aload 10
    //   571: invokestatic 297	com/tencent/map/sdk/a/jx:a	(IIIILjava/lang/String;[ILjava/lang/String;)V
    //   574: aload_0
    //   575: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   578: ldc_w 299
    //   581: aload_1
    //   582: invokevirtual 302	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   585: pop
    //   586: aload_0
    //   587: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   590: ldc_w 304
    //   593: aload 9
    //   595: invokevirtual 302	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   598: pop
    //   599: aload_0
    //   600: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   603: ldc_w 306
    //   606: iload_2
    //   607: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   610: pop
    //   611: aload_0
    //   612: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   615: ldc_w 308
    //   618: iload_3
    //   619: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   622: pop
    //   623: aload_0
    //   624: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   627: ldc_w 310
    //   630: iload 4
    //   632: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   635: pop
    //   636: aload_0
    //   637: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   640: ldc_w 312
    //   643: aload 10
    //   645: invokevirtual 302	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   648: pop
    //   649: aload_0
    //   650: invokestatic 68	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   653: ldc 70
    //   655: iload 6
    //   657: invokevirtual 150	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;I)Z
    //   660: pop
    //   661: iload 7
    //   663: ireturn
    //   664: astore_0
    //   665: goto -202 -> 463
    //   668: astore 8
    //   670: goto -218 -> 452
    //   673: ldc 169
    //   675: astore 10
    //   677: aconst_null
    //   678: astore_1
    //   679: iconst_m1
    //   680: istore_2
    //   681: iconst_m1
    //   682: istore 4
    //   684: iconst_m1
    //   685: istore_3
    //   686: aload 9
    //   688: astore 8
    //   690: aload 10
    //   692: astore 9
    //   694: goto -161 -> 533
    //   697: aconst_null
    //   698: astore_1
    //   699: goto -257 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	702	0	paramContext	Context
    //   0	702	1	paramString	java.lang.String
    //   4	677	2	i	int
    //   215	471	3	j	int
    //   225	458	4	k	int
    //   236	289	5	m	int
    //   126	530	6	n	int
    //   45	617	7	i1	int
    //   1	567	8	localObject1	Object
    //   668	1	8	localThrowable	Throwable
    //   688	1	8	localObject2	Object
    //   196	497	9	localObject3	Object
    //   244	447	10	str	java.lang.String
    //   200	354	11	localObject4	Object
    //   68	466	12	localJSONObject	org.json.JSONObject
    //   252	57	13	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   18	27	78	java/lang/Exception
    //   322	363	449	java/lang/Throwable
    //   368	387	449	java/lang/Throwable
    //   387	399	449	java/lang/Throwable
    //   322	363	459	finally
    //   368	387	459	finally
    //   387	399	459	finally
    //   399	442	664	finally
    //   399	442	668	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.hx
 * JD-Core Version:    0.7.0.1
 */