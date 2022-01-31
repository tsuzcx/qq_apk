package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public final class gv
{
  public static int f = 300000;
  d a = new d((byte)0);
  int b = 20000;
  int c = 20000;
  int d = 30000;
  int e = 30000;
  private final int g = 2;
  private String h = "10.0.0.172";
  private int i = 80;
  
  private HttpURLConnection a(String paramString1, String paramString2)
  {
    try
    {
      localURL = new URL(paramString1);
      localObject = RqdApplication.i();
      if (localObject == null) {
        break label748;
      }
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        break label742;
      }
      if (((NetworkInfo)localObject).getType() != 0) {
        break label303;
      }
      str1 = android.net.Proxy.getDefaultHost();
      j = android.net.Proxy.getDefaultPort();
      str2 = ((NetworkInfo)localObject).getExtraInfo();
      f = ((NetworkInfo)localObject).getSubtype() + 200000;
      e.a("conn proxy host=" + str1 + "; port=" + j + "; mobile type=" + str2);
      e.d("conn proxy host=" + str1 + "; port=" + j + "; mobile type=" + str2);
      if ((str1 == null) || (-1 == j) || (str2 == null)) {
        break label267;
      }
      if ((str2.toLowerCase(Locale.getDefault()).equals("cmwap")) || (str2.toLowerCase(Locale.getDefault()).equals("uniwap"))) {
        break label699;
      }
      if (!str2.toLowerCase(Locale.getDefault()).equals("3gwap")) {
        break label267;
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        URL localURL;
        Object localObject;
        String str1;
        String str2;
        this.a.a(10003, paramString1.toString() + "-" + paramString1.getMessage(), null);
        paramString1 = null;
        break;
        paramString1 = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
        paramString1 = (HttpURLConnection)localURL.openConnection(new java.net.Proxy(Proxy.Type.HTTP, paramString1));
      }
      this.a.a(10001, "conn is close", null);
      return null;
    }
    catch (Exception paramString1)
    {
      label267:
      label303:
      this.a.a(10003, paramString1.toString() + "-" + paramString1.getMessage(), null);
      paramString1.printStackTrace();
      paramString1 = null;
      break label735;
    }
    paramString1 = (HttpURLConnection)localURL.openConnection();
    if (paramString2.equals("POST"))
    {
      paramString1.setConnectTimeout(this.d);
      paramString1.setReadTimeout(this.e);
    }
    for (;;)
    {
      paramString1.setRequestMethod(paramString2);
      break label735;
      if ((str1 == null) || (-1 == j) || (str2 == null) || (!str2.toLowerCase(Locale.getDefault()).equals("ctwap"))) {
        break label737;
      }
      j = 5;
      break label701;
      f = 100000;
      j = 1;
      break label701;
      str1 = s.f(paramString1);
      localObject = s.g(paramString1);
      if ((str1 == null) || (localObject == null) || (paramString1.length() <= str1.length() + ((String)localObject).length()))
      {
        paramString1 = (HttpURLConnection)localURL.openConnection();
        break;
      }
      e.a("default proxy host: " + android.net.Proxy.getDefaultHost() + ", port: " + android.net.Proxy.getDefaultPort());
      e.d("default proxy host: " + android.net.Proxy.getDefaultHost() + ", port: " + android.net.Proxy.getDefaultPort());
      paramString1 = str1 + android.net.Proxy.getDefaultHost() + paramString1.substring(str1.length() + ((String)localObject).length());
      e.a("wap urlAssem: " + paramString1);
      paramString1 = (HttpURLConnection)new URL(paramString1).openConnection();
      paramString1.setRequestProperty("X-Online-Host", (String)localObject);
      paramString1.setRequestProperty("Host", android.net.Proxy.getDefaultHost());
      break;
      paramString1.setConnectTimeout(this.b);
      paramString1.setReadTimeout(this.c);
    }
    label699:
    int j = 3;
    for (;;)
    {
      label701:
      switch (j)
      {
      }
      break;
      label735:
      return paramString1;
      label737:
      j = 2;
      continue;
      label742:
      j = 6;
      continue;
      label748:
      j = 0;
    }
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    // Byte code:
    //   0: new 237	com/tencent/token/utils/r
    //   3: dup
    //   4: invokespecial 238	com/tencent/token/utils/r:<init>	()V
    //   7: astore 37
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 24
    //   18: aconst_null
    //   19: astore 25
    //   21: aconst_null
    //   22: astore 26
    //   24: aconst_null
    //   25: astore 10
    //   27: aconst_null
    //   28: astore 30
    //   30: aconst_null
    //   31: astore 23
    //   33: aconst_null
    //   34: astore 20
    //   36: aconst_null
    //   37: astore 21
    //   39: aconst_null
    //   40: astore 22
    //   42: aconst_null
    //   43: astore 27
    //   45: aconst_null
    //   46: astore 31
    //   48: aconst_null
    //   49: astore 19
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 240	com/tencent/token/gv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   57: astore 8
    //   59: aload 8
    //   61: ifnonnull +17 -> 78
    //   64: aload 8
    //   66: ifnull +8 -> 74
    //   69: aload 8
    //   71: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: areturn
    //   78: aload_3
    //   79: ifnull +2977 -> 3056
    //   82: aload_3
    //   83: invokevirtual 177	java/lang/String:length	()I
    //   86: ifle +2970 -> 3056
    //   89: aconst_null
    //   90: astore 14
    //   92: aload 4
    //   94: ifnull +2956 -> 3050
    //   97: new 101	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   104: ldc 245
    //   106: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 249	java/lang/String:getBytes	()[B
    //   113: arraylength
    //   114: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 251
    //   119: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: invokevirtual 256	java/io/File:length	()J
    //   127: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   136: ldc_w 261
    //   139: invokevirtual 249	java/lang/String:getBytes	()[B
    //   142: astore 18
    //   144: new 263	java/io/FileInputStream
    //   147: dup
    //   148: aload 4
    //   150: invokespecial 266	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore 14
    //   155: aload_3
    //   156: invokevirtual 249	java/lang/String:getBytes	()[B
    //   159: arraylength
    //   160: aload 18
    //   162: arraylength
    //   163: iadd
    //   164: i2l
    //   165: aload 4
    //   167: invokevirtual 256	java/io/File:length	()J
    //   170: ladd
    //   171: ldc_w 268
    //   174: invokevirtual 249	java/lang/String:getBytes	()[B
    //   177: arraylength
    //   178: i2l
    //   179: ladd
    //   180: lstore 6
    //   182: new 101	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 270
    //   192: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: lload 6
    //   197: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   206: aload 8
    //   208: ldc_w 272
    //   211: ldc_w 274
    //   214: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 8
    //   219: ldc_w 276
    //   222: lload 6
    //   224: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   227: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 8
    //   232: iconst_1
    //   233: invokevirtual 284	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   236: new 286	java/io/DataOutputStream
    //   239: dup
    //   240: aload 8
    //   242: invokevirtual 290	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   245: invokespecial 293	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   248: astore 13
    //   250: aload 31
    //   252: astore 12
    //   254: aload 30
    //   256: astore 11
    //   258: aload 13
    //   260: astore 9
    //   262: aload 8
    //   264: astore 10
    //   266: aload 13
    //   268: astore 15
    //   270: aload 13
    //   272: astore 16
    //   274: aload 13
    //   276: astore 17
    //   278: aload 13
    //   280: aload_3
    //   281: invokevirtual 296	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   284: aload 4
    //   286: ifnull +425 -> 711
    //   289: aload 31
    //   291: astore 12
    //   293: aload 30
    //   295: astore 11
    //   297: aload 13
    //   299: astore 9
    //   301: aload 8
    //   303: astore 10
    //   305: aload 13
    //   307: astore 15
    //   309: aload 13
    //   311: astore 16
    //   313: aload 13
    //   315: astore 17
    //   317: sipush 1024
    //   320: newarray byte
    //   322: astore 28
    //   324: aload 31
    //   326: astore 12
    //   328: aload 30
    //   330: astore 11
    //   332: aload 13
    //   334: astore 9
    //   336: aload 8
    //   338: astore 10
    //   340: aload 13
    //   342: astore 15
    //   344: aload 13
    //   346: astore 16
    //   348: aload 13
    //   350: astore 17
    //   352: aload 14
    //   354: aload 28
    //   356: invokevirtual 300	java/io/FileInputStream:read	([B)I
    //   359: istore 5
    //   361: iload 5
    //   363: iconst_m1
    //   364: if_icmpeq +273 -> 637
    //   367: aload 31
    //   369: astore 12
    //   371: aload 30
    //   373: astore 11
    //   375: aload 13
    //   377: astore 9
    //   379: aload 8
    //   381: astore 10
    //   383: aload 13
    //   385: astore 15
    //   387: aload 13
    //   389: astore 16
    //   391: aload 13
    //   393: astore 17
    //   395: aload 13
    //   397: aload 28
    //   399: iconst_0
    //   400: iload 5
    //   402: invokevirtual 304	java/io/DataOutputStream:write	([BII)V
    //   405: goto -81 -> 324
    //   408: astore 4
    //   410: aload 8
    //   412: astore_3
    //   413: aconst_null
    //   414: astore_2
    //   415: aload 13
    //   417: astore 8
    //   419: aload 23
    //   421: astore 9
    //   423: aload 19
    //   425: astore 10
    //   427: aload 4
    //   429: invokevirtual 305	java/net/SocketTimeoutException:printStackTrace	()V
    //   432: aload_0
    //   433: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   436: sipush 10002
    //   439: new 101	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   446: aload 4
    //   448: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   451: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc_w 308
    //   457: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 4
    //   462: invokevirtual 309	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   465: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: aconst_null
    //   472: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   475: invokestatic 314	com/tencent/token/p:a	()Lcom/tencent/token/p;
    //   478: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   481: getstatic 21	com/tencent/token/gv:f	I
    //   484: invokevirtual 322	com/tencent/token/p:a	(JI)V
    //   487: aload 4
    //   489: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   492: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   495: aload 4
    //   497: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   500: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   503: aload 10
    //   505: ifnull +8 -> 513
    //   508: aload 10
    //   510: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   513: aload 9
    //   515: ifnull +8 -> 523
    //   518: aload 9
    //   520: invokevirtual 330	java/io/InputStream:close	()V
    //   523: aload 8
    //   525: ifnull +8 -> 533
    //   528: aload 8
    //   530: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   533: aload_2
    //   534: astore 4
    //   536: aload_3
    //   537: ifnull +10 -> 547
    //   540: aload_3
    //   541: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   544: aload_2
    //   545: astore 4
    //   547: new 101	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   554: ldc_w 333
    //   557: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 37
    //   562: invokevirtual 335	com/tencent/token/utils/r:a	()J
    //   565: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: ldc_w 337
    //   571: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_1
    //   575: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 339	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   584: new 101	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 333
    //   594: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 37
    //   599: invokevirtual 335	com/tencent/token/utils/r:a	()J
    //   602: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   605: ldc_w 337
    //   608: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: astore_2
    //   612: aload_1
    //   613: ldc_w 341
    //   616: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   619: iconst_m1
    //   620: if_icmpne +1931 -> 2551
    //   623: aload_2
    //   624: aload_1
    //   625: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   634: aload 4
    //   636: areturn
    //   637: aload 31
    //   639: astore 12
    //   641: aload 30
    //   643: astore 11
    //   645: aload 13
    //   647: astore 9
    //   649: aload 8
    //   651: astore 10
    //   653: aload 13
    //   655: astore 15
    //   657: aload 13
    //   659: astore 16
    //   661: aload 13
    //   663: astore 17
    //   665: aload 13
    //   667: ldc_w 268
    //   670: invokevirtual 249	java/lang/String:getBytes	()[B
    //   673: invokevirtual 348	java/io/DataOutputStream:write	([B)V
    //   676: aload 31
    //   678: astore 12
    //   680: aload 30
    //   682: astore 11
    //   684: aload 13
    //   686: astore 9
    //   688: aload 8
    //   690: astore 10
    //   692: aload 13
    //   694: astore 15
    //   696: aload 13
    //   698: astore 16
    //   700: aload 13
    //   702: astore 17
    //   704: aload 13
    //   706: aload 18
    //   708: invokevirtual 348	java/io/DataOutputStream:write	([B)V
    //   711: aload 31
    //   713: astore 12
    //   715: aload 30
    //   717: astore 11
    //   719: aload 13
    //   721: astore 9
    //   723: aload 8
    //   725: astore 10
    //   727: aload 13
    //   729: astore 15
    //   731: aload 13
    //   733: astore 16
    //   735: aload 13
    //   737: astore 17
    //   739: aload 13
    //   741: invokevirtual 351	java/io/DataOutputStream:flush	()V
    //   744: aload 31
    //   746: astore 12
    //   748: aload 30
    //   750: astore 11
    //   752: aload 13
    //   754: astore 9
    //   756: aload 8
    //   758: astore 10
    //   760: aload 13
    //   762: astore 15
    //   764: aload 13
    //   766: astore 16
    //   768: aload 13
    //   770: astore 17
    //   772: aload 13
    //   774: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   777: aconst_null
    //   778: astore 28
    //   780: aconst_null
    //   781: astore 29
    //   783: aconst_null
    //   784: astore 32
    //   786: aconst_null
    //   787: astore 33
    //   789: aconst_null
    //   790: astore 34
    //   792: aconst_null
    //   793: astore 35
    //   795: aconst_null
    //   796: astore 36
    //   798: aconst_null
    //   799: astore 18
    //   801: aload 31
    //   803: astore 12
    //   805: aload 30
    //   807: astore 11
    //   809: aload 33
    //   811: astore 9
    //   813: aload 8
    //   815: astore 10
    //   817: aload 34
    //   819: astore 15
    //   821: aload 35
    //   823: astore 16
    //   825: aload 36
    //   827: astore 17
    //   829: aload 8
    //   831: invokevirtual 354	java/net/HttpURLConnection:getResponseCode	()I
    //   834: istore 5
    //   836: iload 5
    //   838: sipush 200
    //   841: if_icmpeq +17 -> 858
    //   844: iload 5
    //   846: sipush 206
    //   849: if_icmpeq +9 -> 858
    //   852: iload 5
    //   854: iconst_m1
    //   855: if_icmpne +667 -> 1522
    //   858: aload 31
    //   860: astore 12
    //   862: aload 30
    //   864: astore 11
    //   866: aload 33
    //   868: astore 9
    //   870: aload 8
    //   872: astore 10
    //   874: aload 34
    //   876: astore 15
    //   878: aload 35
    //   880: astore 16
    //   882: aload 36
    //   884: astore 17
    //   886: aload 8
    //   888: invokevirtual 357	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   891: astore 13
    //   893: aload 13
    //   895: ifnonnull +393 -> 1288
    //   898: ldc_w 359
    //   901: astore 13
    //   903: aload 31
    //   905: astore 12
    //   907: aload 30
    //   909: astore 11
    //   911: aload 33
    //   913: astore 9
    //   915: aload 8
    //   917: astore 10
    //   919: aload 34
    //   921: astore 15
    //   923: aload 35
    //   925: astore 16
    //   927: aload 36
    //   929: astore 17
    //   931: new 101	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 361
    //   941: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload 13
    //   946: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc_w 363
    //   952: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_2
    //   956: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: ldc_w 365
    //   962: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload_1
    //   966: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 339	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   975: aload 31
    //   977: astore 12
    //   979: aload 30
    //   981: astore 11
    //   983: aload 33
    //   985: astore 9
    //   987: aload 8
    //   989: astore 10
    //   991: aload 34
    //   993: astore 15
    //   995: aload 35
    //   997: astore 16
    //   999: aload 36
    //   1001: astore 17
    //   1003: new 101	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1010: ldc_w 361
    //   1013: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: aload 13
    //   1018: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 363
    //   1024: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: aload_2
    //   1028: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: ldc_w 365
    //   1034: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: astore 38
    //   1039: aload 31
    //   1041: astore 12
    //   1043: aload 30
    //   1045: astore 11
    //   1047: aload 33
    //   1049: astore 9
    //   1051: aload 8
    //   1053: astore 10
    //   1055: aload 34
    //   1057: astore 15
    //   1059: aload 35
    //   1061: astore 16
    //   1063: aload 36
    //   1065: astore 17
    //   1067: aload_1
    //   1068: ldc_w 341
    //   1071: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1074: iconst_m1
    //   1075: if_icmpne +251 -> 1326
    //   1078: aload_1
    //   1079: astore 14
    //   1081: aload 31
    //   1083: astore 12
    //   1085: aload 30
    //   1087: astore 11
    //   1089: aload 33
    //   1091: astore 9
    //   1093: aload 8
    //   1095: astore 10
    //   1097: aload 34
    //   1099: astore 15
    //   1101: aload 35
    //   1103: astore 16
    //   1105: aload 36
    //   1107: astore 17
    //   1109: aload 38
    //   1111: aload 14
    //   1113: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1122: aload 31
    //   1124: astore 12
    //   1126: aload 30
    //   1128: astore 11
    //   1130: aload 33
    //   1132: astore 9
    //   1134: aload 8
    //   1136: astore 10
    //   1138: aload 34
    //   1140: astore 15
    //   1142: aload 35
    //   1144: astore 16
    //   1146: aload 36
    //   1148: astore 17
    //   1150: aload 13
    //   1152: ldc_w 367
    //   1155: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1158: iconst_m1
    //   1159: if_icmpne +43 -> 1202
    //   1162: aload 31
    //   1164: astore 12
    //   1166: aload 30
    //   1168: astore 11
    //   1170: aload 33
    //   1172: astore 9
    //   1174: aload 8
    //   1176: astore 10
    //   1178: aload 34
    //   1180: astore 15
    //   1182: aload 35
    //   1184: astore 16
    //   1186: aload 36
    //   1188: astore 17
    //   1190: aload 13
    //   1192: ldc_w 369
    //   1195: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1198: iconst_m1
    //   1199: if_icmpeq +172 -> 1371
    //   1202: aload 31
    //   1204: astore 12
    //   1206: aload 30
    //   1208: astore 11
    //   1210: aload 33
    //   1212: astore 9
    //   1214: aload 8
    //   1216: astore 10
    //   1218: aload 34
    //   1220: astore 15
    //   1222: aload 35
    //   1224: astore 16
    //   1226: aload 36
    //   1228: astore 17
    //   1230: ldc_w 371
    //   1233: invokestatic 373	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   1236: aload 31
    //   1238: astore 12
    //   1240: aload 30
    //   1242: astore 11
    //   1244: aload 33
    //   1246: astore 9
    //   1248: aload 8
    //   1250: astore 10
    //   1252: aload 34
    //   1254: astore 15
    //   1256: aload 35
    //   1258: astore 16
    //   1260: aload 36
    //   1262: astore 17
    //   1264: aload_0
    //   1265: aload_1
    //   1266: aload_2
    //   1267: aload_3
    //   1268: aload 4
    //   1270: invokespecial 375	com/tencent/token/gv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)[B
    //   1273: astore_2
    //   1274: aload_2
    //   1275: astore_1
    //   1276: aload 8
    //   1278: ifnull -1202 -> 76
    //   1281: aload 8
    //   1283: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   1286: aload_2
    //   1287: areturn
    //   1288: aload 31
    //   1290: astore 12
    //   1292: aload 30
    //   1294: astore 11
    //   1296: aload 33
    //   1298: astore 9
    //   1300: aload 8
    //   1302: astore 10
    //   1304: aload 34
    //   1306: astore 15
    //   1308: aload 35
    //   1310: astore 16
    //   1312: aload 36
    //   1314: astore 17
    //   1316: aload 13
    //   1318: invokevirtual 377	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1321: astore 13
    //   1323: goto -420 -> 903
    //   1326: aload 31
    //   1328: astore 12
    //   1330: aload 30
    //   1332: astore 11
    //   1334: aload 33
    //   1336: astore 9
    //   1338: aload 8
    //   1340: astore 10
    //   1342: aload 34
    //   1344: astore 15
    //   1346: aload 35
    //   1348: astore 16
    //   1350: aload 36
    //   1352: astore 17
    //   1354: aload_1
    //   1355: iconst_0
    //   1356: aload_1
    //   1357: ldc_w 341
    //   1360: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1363: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   1366: astore 14
    //   1368: goto -287 -> 1081
    //   1371: aload 31
    //   1373: astore 12
    //   1375: aload 30
    //   1377: astore 11
    //   1379: aload 33
    //   1381: astore 9
    //   1383: aload 8
    //   1385: astore 10
    //   1387: aload 34
    //   1389: astore 15
    //   1391: aload 35
    //   1393: astore 16
    //   1395: aload 36
    //   1397: astore 17
    //   1399: aload 8
    //   1401: invokevirtual 384	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1404: astore_2
    //   1405: new 324	java/io/ByteArrayOutputStream
    //   1408: dup
    //   1409: invokespecial 385	java/io/ByteArrayOutputStream:<init>	()V
    //   1412: astore_3
    //   1413: aload_2
    //   1414: invokevirtual 387	java/io/InputStream:read	()I
    //   1417: istore 5
    //   1419: iload 5
    //   1421: iconst_m1
    //   1422: if_icmpeq +12 -> 1434
    //   1425: aload_3
    //   1426: iload 5
    //   1428: invokevirtual 389	java/io/ByteArrayOutputStream:write	(I)V
    //   1431: goto -18 -> 1413
    //   1434: aload_3
    //   1435: invokevirtual 390	java/io/ByteArrayOutputStream:flush	()V
    //   1438: aload_3
    //   1439: invokevirtual 393	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1442: astore 4
    //   1444: aload 4
    //   1446: ifnull +9 -> 1455
    //   1449: aload 4
    //   1451: arraylength
    //   1452: ifgt +55 -> 1507
    //   1455: aload_0
    //   1456: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1459: ldc_w 394
    //   1462: aconst_null
    //   1463: aconst_null
    //   1464: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1467: aconst_null
    //   1468: astore 9
    //   1470: aload_3
    //   1471: ifnull +7 -> 1478
    //   1474: aload_3
    //   1475: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   1478: aload_2
    //   1479: ifnull +7 -> 1486
    //   1482: aload_2
    //   1483: invokevirtual 330	java/io/InputStream:close	()V
    //   1486: aload 9
    //   1488: astore 4
    //   1490: aload 8
    //   1492: ifnull -945 -> 547
    //   1495: aload 8
    //   1497: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   1500: aload 9
    //   1502: astore 4
    //   1504: goto -957 -> 547
    //   1507: aload_0
    //   1508: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1511: iconst_0
    //   1512: putfield 396	com/tencent/token/global/d:a	I
    //   1515: aload 4
    //   1517: astore 9
    //   1519: goto -49 -> 1470
    //   1522: aload 31
    //   1524: astore 12
    //   1526: aload 30
    //   1528: astore 11
    //   1530: aload 33
    //   1532: astore 9
    //   1534: aload 8
    //   1536: astore 10
    //   1538: aload 34
    //   1540: astore 15
    //   1542: aload 35
    //   1544: astore 16
    //   1546: aload 36
    //   1548: astore 17
    //   1550: aload_0
    //   1551: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1554: sipush 10005
    //   1557: new 101	java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1564: ldc_w 398
    //   1567: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: iload 5
    //   1572: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: aconst_null
    //   1579: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1582: aload 31
    //   1584: astore 12
    //   1586: aload 30
    //   1588: astore 11
    //   1590: aload 33
    //   1592: astore 9
    //   1594: aload 8
    //   1596: astore 10
    //   1598: aload 34
    //   1600: astore 15
    //   1602: aload 35
    //   1604: astore 16
    //   1606: aload 36
    //   1608: astore 17
    //   1610: new 101	java/lang/StringBuilder
    //   1613: dup
    //   1614: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1617: ldc_w 400
    //   1620: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: aload_1
    //   1624: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: ldc_w 402
    //   1630: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1633: iload 5
    //   1635: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 373	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   1644: aload 31
    //   1646: astore 12
    //   1648: aload 30
    //   1650: astore 11
    //   1652: aload 33
    //   1654: astore 9
    //   1656: aload 8
    //   1658: astore 10
    //   1660: aload 34
    //   1662: astore 15
    //   1664: aload 35
    //   1666: astore 16
    //   1668: aload 36
    //   1670: astore 17
    //   1672: new 101	java/lang/StringBuilder
    //   1675: dup
    //   1676: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1679: ldc_w 404
    //   1682: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: astore_3
    //   1686: aload 31
    //   1688: astore 12
    //   1690: aload 30
    //   1692: astore 11
    //   1694: aload 33
    //   1696: astore 9
    //   1698: aload 8
    //   1700: astore 10
    //   1702: aload 34
    //   1704: astore 15
    //   1706: aload 35
    //   1708: astore 16
    //   1710: aload 36
    //   1712: astore 17
    //   1714: aload_1
    //   1715: ldc_w 341
    //   1718: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1721: iconst_m1
    //   1722: if_icmpne +65 -> 1787
    //   1725: aload_1
    //   1726: astore_2
    //   1727: aload 31
    //   1729: astore 12
    //   1731: aload 30
    //   1733: astore 11
    //   1735: aload 33
    //   1737: astore 9
    //   1739: aload 8
    //   1741: astore 10
    //   1743: aload 34
    //   1745: astore 15
    //   1747: aload 35
    //   1749: astore 16
    //   1751: aload 36
    //   1753: astore 17
    //   1755: aload_3
    //   1756: aload_2
    //   1757: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: ldc_w 402
    //   1763: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: iload 5
    //   1768: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1777: aconst_null
    //   1778: astore 9
    //   1780: aconst_null
    //   1781: astore_2
    //   1782: aconst_null
    //   1783: astore_3
    //   1784: goto -314 -> 1470
    //   1787: aload 31
    //   1789: astore 12
    //   1791: aload 30
    //   1793: astore 11
    //   1795: aload 33
    //   1797: astore 9
    //   1799: aload 8
    //   1801: astore 10
    //   1803: aload 34
    //   1805: astore 15
    //   1807: aload 35
    //   1809: astore 16
    //   1811: aload 36
    //   1813: astore 17
    //   1815: aload_1
    //   1816: iconst_0
    //   1817: aload_1
    //   1818: ldc_w 341
    //   1821: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1824: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   1827: astore_2
    //   1828: goto -101 -> 1727
    //   1831: astore_3
    //   1832: aload_3
    //   1833: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1836: goto -358 -> 1478
    //   1839: astore_2
    //   1840: aload_2
    //   1841: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1844: goto -358 -> 1486
    //   1847: astore 4
    //   1849: aload 4
    //   1851: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1854: goto -1341 -> 513
    //   1857: astore 4
    //   1859: aload 4
    //   1861: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1864: goto -1341 -> 523
    //   1867: astore 4
    //   1869: aload 4
    //   1871: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1874: goto -1341 -> 533
    //   1877: astore_3
    //   1878: aconst_null
    //   1879: astore 8
    //   1881: aconst_null
    //   1882: astore 13
    //   1884: aconst_null
    //   1885: astore_2
    //   1886: aload 24
    //   1888: astore 4
    //   1890: aload 20
    //   1892: astore 14
    //   1894: aload 14
    //   1896: astore 12
    //   1898: aload 4
    //   1900: astore 11
    //   1902: aload 13
    //   1904: astore 9
    //   1906: aload 8
    //   1908: astore 10
    //   1910: aload_3
    //   1911: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   1914: aload 14
    //   1916: astore 12
    //   1918: aload 4
    //   1920: astore 11
    //   1922: aload 13
    //   1924: astore 9
    //   1926: aload 8
    //   1928: astore 10
    //   1930: aload_0
    //   1931: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1934: sipush 10003
    //   1937: new 101	java/lang/StringBuilder
    //   1940: dup
    //   1941: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1944: aload_3
    //   1945: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   1948: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: ldc_w 308
    //   1954: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: aload_3
    //   1958: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1961: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1967: aconst_null
    //   1968: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1971: aload 14
    //   1973: astore 12
    //   1975: aload 4
    //   1977: astore 11
    //   1979: aload 13
    //   1981: astore 9
    //   1983: aload 8
    //   1985: astore 10
    //   1987: aload_3
    //   1988: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   1991: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1994: aload 14
    //   1996: astore 12
    //   1998: aload 4
    //   2000: astore 11
    //   2002: aload 13
    //   2004: astore 9
    //   2006: aload 8
    //   2008: astore 10
    //   2010: aload_3
    //   2011: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   2014: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   2017: aload 14
    //   2019: ifnull +8 -> 2027
    //   2022: aload 14
    //   2024: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2027: aload 4
    //   2029: ifnull +8 -> 2037
    //   2032: aload 4
    //   2034: invokevirtual 330	java/io/InputStream:close	()V
    //   2037: aload 13
    //   2039: ifnull +8 -> 2047
    //   2042: aload 13
    //   2044: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2047: aload_2
    //   2048: astore 4
    //   2050: aload 8
    //   2052: ifnull -1505 -> 547
    //   2055: aload 8
    //   2057: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2060: aload_2
    //   2061: astore 4
    //   2063: goto -1516 -> 547
    //   2066: astore_3
    //   2067: aload_3
    //   2068: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2071: goto -44 -> 2027
    //   2074: astore_3
    //   2075: aload_3
    //   2076: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2079: goto -42 -> 2037
    //   2082: astore_3
    //   2083: aload_3
    //   2084: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2087: goto -40 -> 2047
    //   2090: astore_3
    //   2091: aconst_null
    //   2092: astore 8
    //   2094: aconst_null
    //   2095: astore 13
    //   2097: aconst_null
    //   2098: astore_2
    //   2099: aload 25
    //   2101: astore 4
    //   2103: aload 21
    //   2105: astore 14
    //   2107: aload 14
    //   2109: astore 12
    //   2111: aload 4
    //   2113: astore 11
    //   2115: aload 13
    //   2117: astore 9
    //   2119: aload 8
    //   2121: astore 10
    //   2123: aload_3
    //   2124: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2127: aload 14
    //   2129: astore 12
    //   2131: aload 4
    //   2133: astore 11
    //   2135: aload 13
    //   2137: astore 9
    //   2139: aload 8
    //   2141: astore 10
    //   2143: aload_0
    //   2144: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   2147: sipush 10003
    //   2150: new 101	java/lang/StringBuilder
    //   2153: dup
    //   2154: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2157: aload_3
    //   2158: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2161: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: ldc_w 308
    //   2167: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: aload_3
    //   2171: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2174: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2180: aconst_null
    //   2181: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2184: aload 14
    //   2186: astore 12
    //   2188: aload 4
    //   2190: astore 11
    //   2192: aload 13
    //   2194: astore 9
    //   2196: aload 8
    //   2198: astore 10
    //   2200: aload_3
    //   2201: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2204: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   2207: aload 14
    //   2209: astore 12
    //   2211: aload 4
    //   2213: astore 11
    //   2215: aload 13
    //   2217: astore 9
    //   2219: aload 8
    //   2221: astore 10
    //   2223: aload_3
    //   2224: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2227: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   2230: aload 14
    //   2232: ifnull +8 -> 2240
    //   2235: aload 14
    //   2237: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2240: aload 4
    //   2242: ifnull +8 -> 2250
    //   2245: aload 4
    //   2247: invokevirtual 330	java/io/InputStream:close	()V
    //   2250: aload 13
    //   2252: ifnull +8 -> 2260
    //   2255: aload 13
    //   2257: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2260: aload_2
    //   2261: astore 4
    //   2263: aload 8
    //   2265: ifnull -1718 -> 547
    //   2268: aload 8
    //   2270: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2273: aload_2
    //   2274: astore 4
    //   2276: goto -1729 -> 547
    //   2279: astore_3
    //   2280: aload_3
    //   2281: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2284: goto -44 -> 2240
    //   2287: astore_3
    //   2288: aload_3
    //   2289: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2292: goto -42 -> 2250
    //   2295: astore_3
    //   2296: aload_3
    //   2297: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2300: goto -40 -> 2260
    //   2303: astore_3
    //   2304: aconst_null
    //   2305: astore 8
    //   2307: aconst_null
    //   2308: astore 13
    //   2310: aconst_null
    //   2311: astore_2
    //   2312: aload 26
    //   2314: astore 4
    //   2316: aload 22
    //   2318: astore 14
    //   2320: aload 14
    //   2322: astore 12
    //   2324: aload 4
    //   2326: astore 11
    //   2328: aload 13
    //   2330: astore 9
    //   2332: aload 8
    //   2334: astore 10
    //   2336: aload_3
    //   2337: invokevirtual 406	java/lang/Throwable:printStackTrace	()V
    //   2340: aload 14
    //   2342: astore 12
    //   2344: aload 4
    //   2346: astore 11
    //   2348: aload 13
    //   2350: astore 9
    //   2352: aload 8
    //   2354: astore 10
    //   2356: aload_0
    //   2357: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   2360: sipush 10003
    //   2363: new 101	java/lang/StringBuilder
    //   2366: dup
    //   2367: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2370: aload_3
    //   2371: invokevirtual 407	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2374: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: ldc_w 308
    //   2380: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: aload_3
    //   2384: invokevirtual 408	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2387: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2390: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2393: aconst_null
    //   2394: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2397: aload 14
    //   2399: ifnull +8 -> 2407
    //   2402: aload 14
    //   2404: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2407: aload 4
    //   2409: ifnull +8 -> 2417
    //   2412: aload 4
    //   2414: invokevirtual 330	java/io/InputStream:close	()V
    //   2417: aload 13
    //   2419: ifnull +8 -> 2427
    //   2422: aload 13
    //   2424: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2427: aload_2
    //   2428: astore 4
    //   2430: aload 8
    //   2432: ifnull -1885 -> 547
    //   2435: aload 8
    //   2437: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2440: aload_2
    //   2441: astore 4
    //   2443: goto -1896 -> 547
    //   2446: astore_3
    //   2447: aload_3
    //   2448: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2451: goto -44 -> 2407
    //   2454: astore_3
    //   2455: aload_3
    //   2456: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2459: goto -42 -> 2417
    //   2462: astore_3
    //   2463: aload_3
    //   2464: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2467: goto -40 -> 2427
    //   2470: astore_1
    //   2471: aconst_null
    //   2472: astore 8
    //   2474: aconst_null
    //   2475: astore 9
    //   2477: aload 10
    //   2479: astore 11
    //   2481: aload 27
    //   2483: astore 12
    //   2485: aload 12
    //   2487: ifnull +8 -> 2495
    //   2490: aload 12
    //   2492: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2495: aload 11
    //   2497: ifnull +8 -> 2505
    //   2500: aload 11
    //   2502: invokevirtual 330	java/io/InputStream:close	()V
    //   2505: aload 9
    //   2507: ifnull +8 -> 2515
    //   2510: aload 9
    //   2512: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2515: aload 8
    //   2517: ifnull +8 -> 2525
    //   2520: aload 8
    //   2522: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2525: aload_1
    //   2526: athrow
    //   2527: astore_2
    //   2528: aload_2
    //   2529: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2532: goto -37 -> 2495
    //   2535: astore_2
    //   2536: aload_2
    //   2537: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2540: goto -35 -> 2505
    //   2543: astore_2
    //   2544: aload_2
    //   2545: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2548: goto -33 -> 2515
    //   2551: aload_1
    //   2552: iconst_0
    //   2553: aload_1
    //   2554: ldc_w 341
    //   2557: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2560: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   2563: astore_1
    //   2564: goto -1941 -> 623
    //   2567: astore_1
    //   2568: aconst_null
    //   2569: astore 9
    //   2571: aload 27
    //   2573: astore 12
    //   2575: aload 10
    //   2577: astore 11
    //   2579: goto -94 -> 2485
    //   2582: astore_1
    //   2583: aload 10
    //   2585: astore 8
    //   2587: goto -102 -> 2485
    //   2590: astore_1
    //   2591: aload 27
    //   2593: astore 12
    //   2595: aload_2
    //   2596: astore 11
    //   2598: aload 32
    //   2600: astore 9
    //   2602: goto -117 -> 2485
    //   2605: astore_1
    //   2606: aload_3
    //   2607: astore 12
    //   2609: aload_2
    //   2610: astore 11
    //   2612: aload 32
    //   2614: astore 9
    //   2616: goto -131 -> 2485
    //   2619: astore_1
    //   2620: aload 10
    //   2622: astore 12
    //   2624: aload 9
    //   2626: astore 11
    //   2628: aload 8
    //   2630: astore 9
    //   2632: aload_3
    //   2633: astore 8
    //   2635: goto -150 -> 2485
    //   2638: astore_3
    //   2639: aconst_null
    //   2640: astore 13
    //   2642: aconst_null
    //   2643: astore_2
    //   2644: aload 22
    //   2646: astore 14
    //   2648: aload 26
    //   2650: astore 4
    //   2652: goto -332 -> 2320
    //   2655: astore_3
    //   2656: aconst_null
    //   2657: astore_2
    //   2658: aload 22
    //   2660: astore 14
    //   2662: aload 26
    //   2664: astore 4
    //   2666: aload 15
    //   2668: astore 13
    //   2670: goto -350 -> 2320
    //   2673: astore_3
    //   2674: aload_2
    //   2675: astore 4
    //   2677: aconst_null
    //   2678: astore_2
    //   2679: aload 22
    //   2681: astore 14
    //   2683: aload 29
    //   2685: astore 13
    //   2687: goto -367 -> 2320
    //   2690: astore 9
    //   2692: aload_3
    //   2693: astore 14
    //   2695: aload_2
    //   2696: astore 4
    //   2698: aconst_null
    //   2699: astore_2
    //   2700: aload 9
    //   2702: astore_3
    //   2703: aload 29
    //   2705: astore 13
    //   2707: goto -387 -> 2320
    //   2710: astore 10
    //   2712: aload_3
    //   2713: astore 14
    //   2715: aload_2
    //   2716: astore 9
    //   2718: aload 4
    //   2720: astore_2
    //   2721: aload 10
    //   2723: astore_3
    //   2724: aload 9
    //   2726: astore 4
    //   2728: aload 29
    //   2730: astore 13
    //   2732: goto -412 -> 2320
    //   2735: astore_3
    //   2736: aconst_null
    //   2737: astore 13
    //   2739: aconst_null
    //   2740: astore_2
    //   2741: aload 21
    //   2743: astore 14
    //   2745: aload 25
    //   2747: astore 4
    //   2749: goto -642 -> 2107
    //   2752: astore_3
    //   2753: aconst_null
    //   2754: astore_2
    //   2755: aload 21
    //   2757: astore 14
    //   2759: aload 25
    //   2761: astore 4
    //   2763: aload 16
    //   2765: astore 13
    //   2767: goto -660 -> 2107
    //   2770: astore_3
    //   2771: aload_2
    //   2772: astore 4
    //   2774: aconst_null
    //   2775: astore_2
    //   2776: aload 21
    //   2778: astore 14
    //   2780: aload 28
    //   2782: astore 13
    //   2784: goto -677 -> 2107
    //   2787: astore 9
    //   2789: aload_3
    //   2790: astore 14
    //   2792: aload_2
    //   2793: astore 4
    //   2795: aconst_null
    //   2796: astore_2
    //   2797: aload 9
    //   2799: astore_3
    //   2800: aload 28
    //   2802: astore 13
    //   2804: goto -697 -> 2107
    //   2807: astore 10
    //   2809: aload_3
    //   2810: astore 14
    //   2812: aload_2
    //   2813: astore 9
    //   2815: aload 4
    //   2817: astore_2
    //   2818: aload 10
    //   2820: astore_3
    //   2821: aload 9
    //   2823: astore 4
    //   2825: aload 28
    //   2827: astore 13
    //   2829: goto -722 -> 2107
    //   2832: astore_3
    //   2833: aconst_null
    //   2834: astore 13
    //   2836: aconst_null
    //   2837: astore_2
    //   2838: aload 20
    //   2840: astore 14
    //   2842: aload 24
    //   2844: astore 4
    //   2846: goto -952 -> 1894
    //   2849: astore_3
    //   2850: aconst_null
    //   2851: astore_2
    //   2852: aload 20
    //   2854: astore 14
    //   2856: aload 24
    //   2858: astore 4
    //   2860: aload 17
    //   2862: astore 13
    //   2864: goto -970 -> 1894
    //   2867: astore_3
    //   2868: aload_2
    //   2869: astore 4
    //   2871: aconst_null
    //   2872: astore_2
    //   2873: aload 20
    //   2875: astore 14
    //   2877: aload 18
    //   2879: astore 13
    //   2881: goto -987 -> 1894
    //   2884: astore 9
    //   2886: aload_3
    //   2887: astore 14
    //   2889: aload_2
    //   2890: astore 4
    //   2892: aconst_null
    //   2893: astore_2
    //   2894: aload 9
    //   2896: astore_3
    //   2897: aload 18
    //   2899: astore 13
    //   2901: goto -1007 -> 1894
    //   2904: astore 10
    //   2906: aload_3
    //   2907: astore 14
    //   2909: aload_2
    //   2910: astore 9
    //   2912: aload 4
    //   2914: astore_2
    //   2915: aload 10
    //   2917: astore_3
    //   2918: aload 9
    //   2920: astore 4
    //   2922: aload 18
    //   2924: astore 13
    //   2926: goto -1032 -> 1894
    //   2929: astore 4
    //   2931: aconst_null
    //   2932: astore_2
    //   2933: aload 19
    //   2935: astore 10
    //   2937: aload 23
    //   2939: astore 9
    //   2941: aload 11
    //   2943: astore 8
    //   2945: aload 12
    //   2947: astore_3
    //   2948: goto -2521 -> 427
    //   2951: astore 4
    //   2953: aload 8
    //   2955: astore_3
    //   2956: aconst_null
    //   2957: astore_2
    //   2958: aload 19
    //   2960: astore 10
    //   2962: aload 23
    //   2964: astore 9
    //   2966: aload 11
    //   2968: astore 8
    //   2970: goto -2543 -> 427
    //   2973: astore 4
    //   2975: aconst_null
    //   2976: astore 11
    //   2978: aload 8
    //   2980: astore_3
    //   2981: aconst_null
    //   2982: astore_2
    //   2983: aload 19
    //   2985: astore 10
    //   2987: aload 23
    //   2989: astore 9
    //   2991: aload 11
    //   2993: astore 8
    //   2995: goto -2568 -> 427
    //   2998: astore 4
    //   3000: aload_2
    //   3001: astore 9
    //   3003: aconst_null
    //   3004: astore 11
    //   3006: aload 8
    //   3008: astore_3
    //   3009: aconst_null
    //   3010: astore_2
    //   3011: aload 19
    //   3013: astore 10
    //   3015: aload 11
    //   3017: astore 8
    //   3019: goto -2592 -> 427
    //   3022: astore 12
    //   3024: aload_3
    //   3025: astore 10
    //   3027: aload_2
    //   3028: astore 9
    //   3030: aconst_null
    //   3031: astore 11
    //   3033: aload 8
    //   3035: astore_3
    //   3036: aload 4
    //   3038: astore_2
    //   3039: aload 12
    //   3041: astore 4
    //   3043: aload 11
    //   3045: astore 8
    //   3047: goto -2620 -> 427
    //   3050: aconst_null
    //   3051: astore 18
    //   3053: goto -2823 -> 230
    //   3056: goto -2279 -> 777
    //   3059: astore 4
    //   3061: aload_3
    //   3062: astore 10
    //   3064: aload_2
    //   3065: astore 9
    //   3067: aconst_null
    //   3068: astore 11
    //   3070: aload 8
    //   3072: astore_3
    //   3073: aconst_null
    //   3074: astore_2
    //   3075: aload 11
    //   3077: astore 8
    //   3079: goto -2652 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3082	0	this	gv
    //   0	3082	1	paramString1	String
    //   0	3082	2	paramString2	String
    //   0	3082	3	paramString3	String
    //   0	3082	4	paramFile	File
    //   359	1408	5	j	int
    //   180	43	6	l	long
    //   57	3021	8	localObject1	Object
    //   260	2371	9	localObject2	Object
    //   2690	11	9	localThrowable1	java.lang.Throwable
    //   2716	9	9	str1	String
    //   2787	11	9	localException1	Exception
    //   2813	9	9	str2	String
    //   2884	11	9	localIOException1	IOException
    //   2910	156	9	localObject3	Object
    //   25	2596	10	localObject4	Object
    //   2710	12	10	localThrowable2	java.lang.Throwable
    //   2807	12	10	localException2	Exception
    //   2904	12	10	localIOException2	IOException
    //   2935	128	10	localObject5	Object
    //   13	3063	11	localObject6	Object
    //   10	2936	12	localObject7	Object
    //   3022	18	12	localSocketTimeoutException	java.net.SocketTimeoutException
    //   248	2677	13	localObject8	Object
    //   90	2818	14	localObject9	Object
    //   268	2399	15	localObject10	Object
    //   272	2492	16	localObject11	Object
    //   276	2585	17	localObject12	Object
    //   142	2910	18	arrayOfByte1	byte[]
    //   49	2963	19	localObject13	Object
    //   34	2840	20	localObject14	Object
    //   37	2740	21	localObject15	Object
    //   40	2640	22	localObject16	Object
    //   31	2957	23	localObject17	Object
    //   16	2841	24	localObject18	Object
    //   19	2741	25	localObject19	Object
    //   22	2641	26	localObject20	Object
    //   43	2549	27	localObject21	Object
    //   322	2504	28	arrayOfByte2	byte[]
    //   781	1948	29	localObject22	Object
    //   28	1764	30	localObject23	Object
    //   46	1742	31	localObject24	Object
    //   784	1829	32	localObject25	Object
    //   787	1009	33	localObject26	Object
    //   790	1014	34	localObject27	Object
    //   793	1015	35	localObject28	Object
    //   796	1016	36	localObject29	Object
    //   7	591	37	localr	com.tencent.token.utils.r
    //   1037	73	38	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   278	284	408	java/net/SocketTimeoutException
    //   317	324	408	java/net/SocketTimeoutException
    //   352	361	408	java/net/SocketTimeoutException
    //   395	405	408	java/net/SocketTimeoutException
    //   665	676	408	java/net/SocketTimeoutException
    //   704	711	408	java/net/SocketTimeoutException
    //   739	744	408	java/net/SocketTimeoutException
    //   772	777	408	java/net/SocketTimeoutException
    //   1474	1478	1831	java/lang/Exception
    //   1482	1486	1839	java/lang/Exception
    //   508	513	1847	java/lang/Exception
    //   518	523	1857	java/lang/Exception
    //   528	533	1867	java/lang/Exception
    //   51	59	1877	java/io/IOException
    //   2022	2027	2066	java/lang/Exception
    //   2032	2037	2074	java/lang/Exception
    //   2042	2047	2082	java/lang/Exception
    //   51	59	2090	java/lang/Exception
    //   2235	2240	2279	java/lang/Exception
    //   2245	2250	2287	java/lang/Exception
    //   2255	2260	2295	java/lang/Exception
    //   51	59	2303	java/lang/Throwable
    //   2402	2407	2446	java/lang/Exception
    //   2412	2417	2454	java/lang/Exception
    //   2422	2427	2462	java/lang/Exception
    //   51	59	2470	finally
    //   2490	2495	2527	java/lang/Exception
    //   2500	2505	2535	java/lang/Exception
    //   2510	2515	2543	java/lang/Exception
    //   82	89	2567	finally
    //   97	230	2567	finally
    //   230	250	2567	finally
    //   278	284	2582	finally
    //   317	324	2582	finally
    //   352	361	2582	finally
    //   395	405	2582	finally
    //   665	676	2582	finally
    //   704	711	2582	finally
    //   739	744	2582	finally
    //   772	777	2582	finally
    //   829	836	2582	finally
    //   886	893	2582	finally
    //   931	975	2582	finally
    //   1003	1039	2582	finally
    //   1067	1078	2582	finally
    //   1109	1122	2582	finally
    //   1150	1162	2582	finally
    //   1190	1202	2582	finally
    //   1230	1236	2582	finally
    //   1264	1274	2582	finally
    //   1316	1323	2582	finally
    //   1354	1368	2582	finally
    //   1399	1405	2582	finally
    //   1550	1582	2582	finally
    //   1610	1644	2582	finally
    //   1672	1686	2582	finally
    //   1714	1725	2582	finally
    //   1755	1777	2582	finally
    //   1815	1828	2582	finally
    //   1910	1914	2582	finally
    //   1930	1971	2582	finally
    //   1987	1994	2582	finally
    //   2010	2017	2582	finally
    //   2123	2127	2582	finally
    //   2143	2184	2582	finally
    //   2200	2207	2582	finally
    //   2223	2230	2582	finally
    //   2336	2340	2582	finally
    //   2356	2397	2582	finally
    //   1405	1413	2590	finally
    //   1413	1419	2605	finally
    //   1425	1431	2605	finally
    //   1434	1444	2605	finally
    //   1449	1455	2605	finally
    //   1455	1467	2605	finally
    //   1507	1515	2605	finally
    //   427	503	2619	finally
    //   82	89	2638	java/lang/Throwable
    //   97	230	2638	java/lang/Throwable
    //   230	250	2638	java/lang/Throwable
    //   278	284	2655	java/lang/Throwable
    //   317	324	2655	java/lang/Throwable
    //   352	361	2655	java/lang/Throwable
    //   395	405	2655	java/lang/Throwable
    //   665	676	2655	java/lang/Throwable
    //   704	711	2655	java/lang/Throwable
    //   739	744	2655	java/lang/Throwable
    //   772	777	2655	java/lang/Throwable
    //   829	836	2655	java/lang/Throwable
    //   886	893	2655	java/lang/Throwable
    //   931	975	2655	java/lang/Throwable
    //   1003	1039	2655	java/lang/Throwable
    //   1067	1078	2655	java/lang/Throwable
    //   1109	1122	2655	java/lang/Throwable
    //   1150	1162	2655	java/lang/Throwable
    //   1190	1202	2655	java/lang/Throwable
    //   1230	1236	2655	java/lang/Throwable
    //   1264	1274	2655	java/lang/Throwable
    //   1316	1323	2655	java/lang/Throwable
    //   1354	1368	2655	java/lang/Throwable
    //   1399	1405	2655	java/lang/Throwable
    //   1550	1582	2655	java/lang/Throwable
    //   1610	1644	2655	java/lang/Throwable
    //   1672	1686	2655	java/lang/Throwable
    //   1714	1725	2655	java/lang/Throwable
    //   1755	1777	2655	java/lang/Throwable
    //   1815	1828	2655	java/lang/Throwable
    //   1405	1413	2673	java/lang/Throwable
    //   1413	1419	2690	java/lang/Throwable
    //   1425	1431	2690	java/lang/Throwable
    //   1434	1444	2690	java/lang/Throwable
    //   1449	1455	2710	java/lang/Throwable
    //   1455	1467	2710	java/lang/Throwable
    //   1507	1515	2710	java/lang/Throwable
    //   82	89	2735	java/lang/Exception
    //   97	230	2735	java/lang/Exception
    //   230	250	2735	java/lang/Exception
    //   278	284	2752	java/lang/Exception
    //   317	324	2752	java/lang/Exception
    //   352	361	2752	java/lang/Exception
    //   395	405	2752	java/lang/Exception
    //   665	676	2752	java/lang/Exception
    //   704	711	2752	java/lang/Exception
    //   739	744	2752	java/lang/Exception
    //   772	777	2752	java/lang/Exception
    //   829	836	2752	java/lang/Exception
    //   886	893	2752	java/lang/Exception
    //   931	975	2752	java/lang/Exception
    //   1003	1039	2752	java/lang/Exception
    //   1067	1078	2752	java/lang/Exception
    //   1109	1122	2752	java/lang/Exception
    //   1150	1162	2752	java/lang/Exception
    //   1190	1202	2752	java/lang/Exception
    //   1230	1236	2752	java/lang/Exception
    //   1264	1274	2752	java/lang/Exception
    //   1316	1323	2752	java/lang/Exception
    //   1354	1368	2752	java/lang/Exception
    //   1399	1405	2752	java/lang/Exception
    //   1550	1582	2752	java/lang/Exception
    //   1610	1644	2752	java/lang/Exception
    //   1672	1686	2752	java/lang/Exception
    //   1714	1725	2752	java/lang/Exception
    //   1755	1777	2752	java/lang/Exception
    //   1815	1828	2752	java/lang/Exception
    //   1405	1413	2770	java/lang/Exception
    //   1413	1419	2787	java/lang/Exception
    //   1425	1431	2787	java/lang/Exception
    //   1434	1444	2787	java/lang/Exception
    //   1449	1455	2807	java/lang/Exception
    //   1455	1467	2807	java/lang/Exception
    //   1507	1515	2807	java/lang/Exception
    //   82	89	2832	java/io/IOException
    //   97	230	2832	java/io/IOException
    //   230	250	2832	java/io/IOException
    //   278	284	2849	java/io/IOException
    //   317	324	2849	java/io/IOException
    //   352	361	2849	java/io/IOException
    //   395	405	2849	java/io/IOException
    //   665	676	2849	java/io/IOException
    //   704	711	2849	java/io/IOException
    //   739	744	2849	java/io/IOException
    //   772	777	2849	java/io/IOException
    //   829	836	2849	java/io/IOException
    //   886	893	2849	java/io/IOException
    //   931	975	2849	java/io/IOException
    //   1003	1039	2849	java/io/IOException
    //   1067	1078	2849	java/io/IOException
    //   1109	1122	2849	java/io/IOException
    //   1150	1162	2849	java/io/IOException
    //   1190	1202	2849	java/io/IOException
    //   1230	1236	2849	java/io/IOException
    //   1264	1274	2849	java/io/IOException
    //   1316	1323	2849	java/io/IOException
    //   1354	1368	2849	java/io/IOException
    //   1399	1405	2849	java/io/IOException
    //   1550	1582	2849	java/io/IOException
    //   1610	1644	2849	java/io/IOException
    //   1672	1686	2849	java/io/IOException
    //   1714	1725	2849	java/io/IOException
    //   1755	1777	2849	java/io/IOException
    //   1815	1828	2849	java/io/IOException
    //   1405	1413	2867	java/io/IOException
    //   1413	1419	2884	java/io/IOException
    //   1425	1431	2884	java/io/IOException
    //   1434	1444	2884	java/io/IOException
    //   1449	1455	2904	java/io/IOException
    //   1455	1467	2904	java/io/IOException
    //   1507	1515	2904	java/io/IOException
    //   51	59	2929	java/net/SocketTimeoutException
    //   82	89	2951	java/net/SocketTimeoutException
    //   97	230	2951	java/net/SocketTimeoutException
    //   230	250	2951	java/net/SocketTimeoutException
    //   829	836	2973	java/net/SocketTimeoutException
    //   886	893	2973	java/net/SocketTimeoutException
    //   931	975	2973	java/net/SocketTimeoutException
    //   1003	1039	2973	java/net/SocketTimeoutException
    //   1067	1078	2973	java/net/SocketTimeoutException
    //   1109	1122	2973	java/net/SocketTimeoutException
    //   1150	1162	2973	java/net/SocketTimeoutException
    //   1190	1202	2973	java/net/SocketTimeoutException
    //   1230	1236	2973	java/net/SocketTimeoutException
    //   1264	1274	2973	java/net/SocketTimeoutException
    //   1316	1323	2973	java/net/SocketTimeoutException
    //   1354	1368	2973	java/net/SocketTimeoutException
    //   1399	1405	2973	java/net/SocketTimeoutException
    //   1550	1582	2973	java/net/SocketTimeoutException
    //   1610	1644	2973	java/net/SocketTimeoutException
    //   1672	1686	2973	java/net/SocketTimeoutException
    //   1714	1725	2973	java/net/SocketTimeoutException
    //   1755	1777	2973	java/net/SocketTimeoutException
    //   1815	1828	2973	java/net/SocketTimeoutException
    //   1405	1413	2998	java/net/SocketTimeoutException
    //   1449	1455	3022	java/net/SocketTimeoutException
    //   1455	1467	3022	java/net/SocketTimeoutException
    //   1507	1515	3022	java/net/SocketTimeoutException
    //   1413	1419	3059	java/net/SocketTimeoutException
    //   1425	1431	3059	java/net/SocketTimeoutException
    //   1434	1444	3059	java/net/SocketTimeoutException
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 237	com/tencent/token/utils/r
    //   3: dup
    //   4: invokespecial 238	com/tencent/token/utils/r:<init>	()V
    //   7: astore 37
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 23
    //   18: aconst_null
    //   19: astore 24
    //   21: aconst_null
    //   22: astore 25
    //   24: aconst_null
    //   25: astore 10
    //   27: aconst_null
    //   28: astore 30
    //   30: aconst_null
    //   31: astore 22
    //   33: aconst_null
    //   34: astore 19
    //   36: aconst_null
    //   37: astore 20
    //   39: aconst_null
    //   40: astore 21
    //   42: aconst_null
    //   43: astore 27
    //   45: aconst_null
    //   46: astore 31
    //   48: aconst_null
    //   49: astore 18
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 240	com/tencent/token/gv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   57: astore 8
    //   59: aload 8
    //   61: ifnonnull +17 -> 78
    //   64: aload 8
    //   66: ifnull +8 -> 74
    //   69: aload 8
    //   71: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: areturn
    //   78: aload_3
    //   79: ifnull +2898 -> 2977
    //   82: aload_3
    //   83: invokevirtual 177	java/lang/String:length	()I
    //   86: ifle +2891 -> 2977
    //   89: aconst_null
    //   90: astore 14
    //   92: aload 4
    //   94: ifnull +120 -> 214
    //   97: new 101	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   104: ldc 245
    //   106: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 249	java/lang/String:getBytes	()[B
    //   113: arraylength
    //   114: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 251
    //   119: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: arraylength
    //   125: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   134: ldc_w 261
    //   137: invokevirtual 249	java/lang/String:getBytes	()[B
    //   140: astore 14
    //   142: aload_3
    //   143: invokevirtual 249	java/lang/String:getBytes	()[B
    //   146: arraylength
    //   147: aload 14
    //   149: arraylength
    //   150: iadd
    //   151: aload 4
    //   153: arraylength
    //   154: iadd
    //   155: ldc_w 268
    //   158: invokevirtual 249	java/lang/String:getBytes	()[B
    //   161: arraylength
    //   162: iadd
    //   163: i2l
    //   164: lstore 6
    //   166: new 101	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 270
    //   176: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: lload 6
    //   181: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   190: aload 8
    //   192: ldc_w 272
    //   195: ldc_w 274
    //   198: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 8
    //   203: ldc_w 276
    //   206: lload 6
    //   208: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   211: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload 8
    //   216: iconst_1
    //   217: invokevirtual 284	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   220: new 286	java/io/DataOutputStream
    //   223: dup
    //   224: aload 8
    //   226: invokevirtual 290	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   229: invokespecial 293	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   232: astore 13
    //   234: aload 31
    //   236: astore 12
    //   238: aload 30
    //   240: astore 11
    //   242: aload 13
    //   244: astore 9
    //   246: aload 8
    //   248: astore 10
    //   250: aload 13
    //   252: astore 15
    //   254: aload 13
    //   256: astore 16
    //   258: aload 13
    //   260: astore 17
    //   262: aload 13
    //   264: aload_3
    //   265: invokevirtual 296	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   268: aload 4
    //   270: ifnull +112 -> 382
    //   273: aload 31
    //   275: astore 12
    //   277: aload 30
    //   279: astore 11
    //   281: aload 13
    //   283: astore 9
    //   285: aload 8
    //   287: astore 10
    //   289: aload 13
    //   291: astore 15
    //   293: aload 13
    //   295: astore 16
    //   297: aload 13
    //   299: astore 17
    //   301: aload 13
    //   303: aload 4
    //   305: invokevirtual 348	java/io/DataOutputStream:write	([B)V
    //   308: aload 31
    //   310: astore 12
    //   312: aload 30
    //   314: astore 11
    //   316: aload 13
    //   318: astore 9
    //   320: aload 8
    //   322: astore 10
    //   324: aload 13
    //   326: astore 15
    //   328: aload 13
    //   330: astore 16
    //   332: aload 13
    //   334: astore 17
    //   336: aload 13
    //   338: ldc_w 268
    //   341: invokevirtual 249	java/lang/String:getBytes	()[B
    //   344: invokevirtual 348	java/io/DataOutputStream:write	([B)V
    //   347: aload 31
    //   349: astore 12
    //   351: aload 30
    //   353: astore 11
    //   355: aload 13
    //   357: astore 9
    //   359: aload 8
    //   361: astore 10
    //   363: aload 13
    //   365: astore 15
    //   367: aload 13
    //   369: astore 16
    //   371: aload 13
    //   373: astore 17
    //   375: aload 13
    //   377: aload 14
    //   379: invokevirtual 348	java/io/DataOutputStream:write	([B)V
    //   382: aload 31
    //   384: astore 12
    //   386: aload 30
    //   388: astore 11
    //   390: aload 13
    //   392: astore 9
    //   394: aload 8
    //   396: astore 10
    //   398: aload 13
    //   400: astore 15
    //   402: aload 13
    //   404: astore 16
    //   406: aload 13
    //   408: astore 17
    //   410: aload 13
    //   412: invokevirtual 351	java/io/DataOutputStream:flush	()V
    //   415: aload 31
    //   417: astore 12
    //   419: aload 30
    //   421: astore 11
    //   423: aload 13
    //   425: astore 9
    //   427: aload 8
    //   429: astore 10
    //   431: aload 13
    //   433: astore 15
    //   435: aload 13
    //   437: astore 16
    //   439: aload 13
    //   441: astore 17
    //   443: aload 13
    //   445: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   448: aconst_null
    //   449: astore 28
    //   451: aconst_null
    //   452: astore 29
    //   454: aconst_null
    //   455: astore 32
    //   457: aconst_null
    //   458: astore 33
    //   460: aconst_null
    //   461: astore 34
    //   463: aconst_null
    //   464: astore 35
    //   466: aconst_null
    //   467: astore 36
    //   469: aconst_null
    //   470: astore 26
    //   472: aload 31
    //   474: astore 12
    //   476: aload 30
    //   478: astore 11
    //   480: aload 33
    //   482: astore 9
    //   484: aload 8
    //   486: astore 10
    //   488: aload 34
    //   490: astore 15
    //   492: aload 35
    //   494: astore 16
    //   496: aload 36
    //   498: astore 17
    //   500: aload 8
    //   502: invokevirtual 354	java/net/HttpURLConnection:getResponseCode	()I
    //   505: istore 5
    //   507: iload 5
    //   509: sipush 200
    //   512: if_icmpeq +17 -> 529
    //   515: iload 5
    //   517: sipush 206
    //   520: if_icmpeq +9 -> 529
    //   523: iload 5
    //   525: iconst_m1
    //   526: if_icmpne +901 -> 1427
    //   529: aload 31
    //   531: astore 12
    //   533: aload 30
    //   535: astore 11
    //   537: aload 33
    //   539: astore 9
    //   541: aload 8
    //   543: astore 10
    //   545: aload 34
    //   547: astore 15
    //   549: aload 35
    //   551: astore 16
    //   553: aload 36
    //   555: astore 17
    //   557: aload 8
    //   559: invokevirtual 357	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   562: astore 13
    //   564: aload 13
    //   566: ifnonnull +393 -> 959
    //   569: ldc_w 359
    //   572: astore 13
    //   574: aload 31
    //   576: astore 12
    //   578: aload 30
    //   580: astore 11
    //   582: aload 33
    //   584: astore 9
    //   586: aload 8
    //   588: astore 10
    //   590: aload 34
    //   592: astore 15
    //   594: aload 35
    //   596: astore 16
    //   598: aload 36
    //   600: astore 17
    //   602: new 101	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 361
    //   612: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload 13
    //   617: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: ldc_w 363
    //   623: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc_w 365
    //   633: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_1
    //   637: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 339	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   646: aload 31
    //   648: astore 12
    //   650: aload 30
    //   652: astore 11
    //   654: aload 33
    //   656: astore 9
    //   658: aload 8
    //   660: astore 10
    //   662: aload 34
    //   664: astore 15
    //   666: aload 35
    //   668: astore 16
    //   670: aload 36
    //   672: astore 17
    //   674: new 101	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 361
    //   684: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 13
    //   689: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc_w 363
    //   695: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload_2
    //   699: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: ldc_w 365
    //   705: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: astore 38
    //   710: aload 31
    //   712: astore 12
    //   714: aload 30
    //   716: astore 11
    //   718: aload 33
    //   720: astore 9
    //   722: aload 8
    //   724: astore 10
    //   726: aload 34
    //   728: astore 15
    //   730: aload 35
    //   732: astore 16
    //   734: aload 36
    //   736: astore 17
    //   738: aload_1
    //   739: ldc_w 341
    //   742: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   745: iconst_m1
    //   746: if_icmpne +251 -> 997
    //   749: aload_1
    //   750: astore 14
    //   752: aload 31
    //   754: astore 12
    //   756: aload 30
    //   758: astore 11
    //   760: aload 33
    //   762: astore 9
    //   764: aload 8
    //   766: astore 10
    //   768: aload 34
    //   770: astore 15
    //   772: aload 35
    //   774: astore 16
    //   776: aload 36
    //   778: astore 17
    //   780: aload 38
    //   782: aload 14
    //   784: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   793: aload 31
    //   795: astore 12
    //   797: aload 30
    //   799: astore 11
    //   801: aload 33
    //   803: astore 9
    //   805: aload 8
    //   807: astore 10
    //   809: aload 34
    //   811: astore 15
    //   813: aload 35
    //   815: astore 16
    //   817: aload 36
    //   819: astore 17
    //   821: aload 13
    //   823: ldc_w 367
    //   826: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   829: iconst_m1
    //   830: if_icmpne +43 -> 873
    //   833: aload 31
    //   835: astore 12
    //   837: aload 30
    //   839: astore 11
    //   841: aload 33
    //   843: astore 9
    //   845: aload 8
    //   847: astore 10
    //   849: aload 34
    //   851: astore 15
    //   853: aload 35
    //   855: astore 16
    //   857: aload 36
    //   859: astore 17
    //   861: aload 13
    //   863: ldc_w 369
    //   866: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   869: iconst_m1
    //   870: if_icmpeq +172 -> 1042
    //   873: aload 31
    //   875: astore 12
    //   877: aload 30
    //   879: astore 11
    //   881: aload 33
    //   883: astore 9
    //   885: aload 8
    //   887: astore 10
    //   889: aload 34
    //   891: astore 15
    //   893: aload 35
    //   895: astore 16
    //   897: aload 36
    //   899: astore 17
    //   901: ldc_w 371
    //   904: invokestatic 373	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   907: aload 31
    //   909: astore 12
    //   911: aload 30
    //   913: astore 11
    //   915: aload 33
    //   917: astore 9
    //   919: aload 8
    //   921: astore 10
    //   923: aload 34
    //   925: astore 15
    //   927: aload 35
    //   929: astore 16
    //   931: aload 36
    //   933: astore 17
    //   935: aload_0
    //   936: aload_1
    //   937: aload_2
    //   938: aload_3
    //   939: aload 4
    //   941: invokespecial 411	com/tencent/token/gv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)[B
    //   944: astore_2
    //   945: aload_2
    //   946: astore_1
    //   947: aload 8
    //   949: ifnull -873 -> 76
    //   952: aload 8
    //   954: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   957: aload_2
    //   958: areturn
    //   959: aload 31
    //   961: astore 12
    //   963: aload 30
    //   965: astore 11
    //   967: aload 33
    //   969: astore 9
    //   971: aload 8
    //   973: astore 10
    //   975: aload 34
    //   977: astore 15
    //   979: aload 35
    //   981: astore 16
    //   983: aload 36
    //   985: astore 17
    //   987: aload 13
    //   989: invokevirtual 377	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   992: astore 13
    //   994: goto -420 -> 574
    //   997: aload 31
    //   999: astore 12
    //   1001: aload 30
    //   1003: astore 11
    //   1005: aload 33
    //   1007: astore 9
    //   1009: aload 8
    //   1011: astore 10
    //   1013: aload 34
    //   1015: astore 15
    //   1017: aload 35
    //   1019: astore 16
    //   1021: aload 36
    //   1023: astore 17
    //   1025: aload_1
    //   1026: iconst_0
    //   1027: aload_1
    //   1028: ldc_w 341
    //   1031: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1034: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   1037: astore 14
    //   1039: goto -287 -> 752
    //   1042: aload 31
    //   1044: astore 12
    //   1046: aload 30
    //   1048: astore 11
    //   1050: aload 33
    //   1052: astore 9
    //   1054: aload 8
    //   1056: astore 10
    //   1058: aload 34
    //   1060: astore 15
    //   1062: aload 35
    //   1064: astore 16
    //   1066: aload 36
    //   1068: astore 17
    //   1070: aload 8
    //   1072: invokevirtual 384	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1075: astore_2
    //   1076: new 324	java/io/ByteArrayOutputStream
    //   1079: dup
    //   1080: invokespecial 385	java/io/ByteArrayOutputStream:<init>	()V
    //   1083: astore_3
    //   1084: aload_2
    //   1085: invokevirtual 387	java/io/InputStream:read	()I
    //   1088: istore 5
    //   1090: iload 5
    //   1092: iconst_m1
    //   1093: if_icmpeq +246 -> 1339
    //   1096: aload_3
    //   1097: iload 5
    //   1099: invokevirtual 389	java/io/ByteArrayOutputStream:write	(I)V
    //   1102: goto -18 -> 1084
    //   1105: astore 4
    //   1107: aload_3
    //   1108: astore 10
    //   1110: aconst_null
    //   1111: astore 9
    //   1113: aload 8
    //   1115: astore_3
    //   1116: aconst_null
    //   1117: astore 11
    //   1119: aload 9
    //   1121: astore 8
    //   1123: aload_2
    //   1124: astore 9
    //   1126: aload 11
    //   1128: astore_2
    //   1129: aload 4
    //   1131: invokevirtual 305	java/net/SocketTimeoutException:printStackTrace	()V
    //   1134: aload_0
    //   1135: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1138: sipush 10002
    //   1141: new 101	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1148: aload 4
    //   1150: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   1153: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: ldc_w 308
    //   1159: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: aload 4
    //   1164: invokevirtual 309	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   1167: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: aconst_null
    //   1174: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1177: invokestatic 314	com/tencent/token/p:a	()Lcom/tencent/token/p;
    //   1180: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   1183: getstatic 21	com/tencent/token/gv:f	I
    //   1186: invokevirtual 322	com/tencent/token/p:a	(JI)V
    //   1189: aload 4
    //   1191: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   1194: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1197: aload 4
    //   1199: invokevirtual 306	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   1202: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1205: aload 10
    //   1207: ifnull +8 -> 1215
    //   1210: aload 10
    //   1212: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   1215: aload 9
    //   1217: ifnull +8 -> 1225
    //   1220: aload 9
    //   1222: invokevirtual 330	java/io/InputStream:close	()V
    //   1225: aload 8
    //   1227: ifnull +8 -> 1235
    //   1230: aload 8
    //   1232: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   1235: aload_2
    //   1236: astore 4
    //   1238: aload_3
    //   1239: ifnull +10 -> 1249
    //   1242: aload_3
    //   1243: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   1246: aload_2
    //   1247: astore 4
    //   1249: new 101	java/lang/StringBuilder
    //   1252: dup
    //   1253: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1256: ldc_w 333
    //   1259: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: aload 37
    //   1264: invokevirtual 335	com/tencent/token/utils/r:a	()J
    //   1267: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1270: ldc_w 337
    //   1273: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aload_1
    //   1277: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: invokestatic 339	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   1286: new 101	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1293: ldc_w 333
    //   1296: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: aload 37
    //   1301: invokevirtual 335	com/tencent/token/utils/r:a	()J
    //   1304: invokevirtual 259	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1307: ldc_w 337
    //   1310: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: astore_2
    //   1314: aload_1
    //   1315: ldc_w 341
    //   1318: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1321: iconst_m1
    //   1322: if_icmpne +1134 -> 2456
    //   1325: aload_2
    //   1326: aload_1
    //   1327: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1336: aload 4
    //   1338: areturn
    //   1339: aload_3
    //   1340: invokevirtual 390	java/io/ByteArrayOutputStream:flush	()V
    //   1343: aload_3
    //   1344: invokevirtual 393	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1347: astore 4
    //   1349: aload 4
    //   1351: ifnull +9 -> 1360
    //   1354: aload 4
    //   1356: arraylength
    //   1357: ifgt +55 -> 1412
    //   1360: aload_0
    //   1361: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1364: ldc_w 394
    //   1367: aconst_null
    //   1368: aconst_null
    //   1369: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1372: aconst_null
    //   1373: astore 9
    //   1375: aload_3
    //   1376: ifnull +7 -> 1383
    //   1379: aload_3
    //   1380: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   1383: aload_2
    //   1384: ifnull +7 -> 1391
    //   1387: aload_2
    //   1388: invokevirtual 330	java/io/InputStream:close	()V
    //   1391: aload 9
    //   1393: astore 4
    //   1395: aload 8
    //   1397: ifnull -148 -> 1249
    //   1400: aload 8
    //   1402: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   1405: aload 9
    //   1407: astore 4
    //   1409: goto -160 -> 1249
    //   1412: aload_0
    //   1413: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1416: iconst_0
    //   1417: putfield 396	com/tencent/token/global/d:a	I
    //   1420: aload 4
    //   1422: astore 9
    //   1424: goto -49 -> 1375
    //   1427: aload 31
    //   1429: astore 12
    //   1431: aload 30
    //   1433: astore 11
    //   1435: aload 33
    //   1437: astore 9
    //   1439: aload 8
    //   1441: astore 10
    //   1443: aload 34
    //   1445: astore 15
    //   1447: aload 35
    //   1449: astore 16
    //   1451: aload 36
    //   1453: astore 17
    //   1455: aload_0
    //   1456: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1459: sipush 10005
    //   1462: new 101	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1469: ldc_w 398
    //   1472: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: iload 5
    //   1477: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: aconst_null
    //   1484: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1487: aload 31
    //   1489: astore 12
    //   1491: aload 30
    //   1493: astore 11
    //   1495: aload 33
    //   1497: astore 9
    //   1499: aload 8
    //   1501: astore 10
    //   1503: aload 34
    //   1505: astore 15
    //   1507: aload 35
    //   1509: astore 16
    //   1511: aload 36
    //   1513: astore 17
    //   1515: new 101	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1522: ldc_w 400
    //   1525: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: aload_1
    //   1529: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc_w 402
    //   1535: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: iload 5
    //   1540: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1546: invokestatic 373	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   1549: aload 31
    //   1551: astore 12
    //   1553: aload 30
    //   1555: astore 11
    //   1557: aload 33
    //   1559: astore 9
    //   1561: aload 8
    //   1563: astore 10
    //   1565: aload 34
    //   1567: astore 15
    //   1569: aload 35
    //   1571: astore 16
    //   1573: aload 36
    //   1575: astore 17
    //   1577: new 101	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1584: ldc_w 404
    //   1587: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: astore_3
    //   1591: aload 31
    //   1593: astore 12
    //   1595: aload 30
    //   1597: astore 11
    //   1599: aload 33
    //   1601: astore 9
    //   1603: aload 8
    //   1605: astore 10
    //   1607: aload 34
    //   1609: astore 15
    //   1611: aload 35
    //   1613: astore 16
    //   1615: aload 36
    //   1617: astore 17
    //   1619: aload_1
    //   1620: ldc_w 341
    //   1623: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1626: iconst_m1
    //   1627: if_icmpne +65 -> 1692
    //   1630: aload_1
    //   1631: astore_2
    //   1632: aload 31
    //   1634: astore 12
    //   1636: aload 30
    //   1638: astore 11
    //   1640: aload 33
    //   1642: astore 9
    //   1644: aload 8
    //   1646: astore 10
    //   1648: aload 34
    //   1650: astore 15
    //   1652: aload 35
    //   1654: astore 16
    //   1656: aload 36
    //   1658: astore 17
    //   1660: aload_3
    //   1661: aload_2
    //   1662: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: ldc_w 402
    //   1668: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: iload 5
    //   1673: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1682: aconst_null
    //   1683: astore 9
    //   1685: aconst_null
    //   1686: astore_2
    //   1687: aconst_null
    //   1688: astore_3
    //   1689: goto -314 -> 1375
    //   1692: aload 31
    //   1694: astore 12
    //   1696: aload 30
    //   1698: astore 11
    //   1700: aload 33
    //   1702: astore 9
    //   1704: aload 8
    //   1706: astore 10
    //   1708: aload 34
    //   1710: astore 15
    //   1712: aload 35
    //   1714: astore 16
    //   1716: aload 36
    //   1718: astore 17
    //   1720: aload_1
    //   1721: iconst_0
    //   1722: aload_1
    //   1723: ldc_w 341
    //   1726: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1729: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   1732: astore_2
    //   1733: goto -101 -> 1632
    //   1736: astore_3
    //   1737: aload_3
    //   1738: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1741: goto -358 -> 1383
    //   1744: astore_2
    //   1745: aload_2
    //   1746: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1749: goto -358 -> 1391
    //   1752: astore 4
    //   1754: aload 4
    //   1756: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1759: goto -544 -> 1215
    //   1762: astore 4
    //   1764: aload 4
    //   1766: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1769: goto -544 -> 1225
    //   1772: astore 4
    //   1774: aload 4
    //   1776: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1779: goto -544 -> 1235
    //   1782: astore_3
    //   1783: aconst_null
    //   1784: astore 8
    //   1786: aconst_null
    //   1787: astore 13
    //   1789: aconst_null
    //   1790: astore_2
    //   1791: aload 23
    //   1793: astore 4
    //   1795: aload 19
    //   1797: astore 14
    //   1799: aload 14
    //   1801: astore 12
    //   1803: aload 4
    //   1805: astore 11
    //   1807: aload 13
    //   1809: astore 9
    //   1811: aload 8
    //   1813: astore 10
    //   1815: aload_3
    //   1816: invokevirtual 405	java/io/IOException:printStackTrace	()V
    //   1819: aload 14
    //   1821: astore 12
    //   1823: aload 4
    //   1825: astore 11
    //   1827: aload 13
    //   1829: astore 9
    //   1831: aload 8
    //   1833: astore 10
    //   1835: aload_0
    //   1836: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   1839: sipush 10003
    //   1842: new 101	java/lang/StringBuilder
    //   1845: dup
    //   1846: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1849: aload_3
    //   1850: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   1853: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: ldc_w 308
    //   1859: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: aload_3
    //   1863: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1866: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1872: aconst_null
    //   1873: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1876: aload 14
    //   1878: astore 12
    //   1880: aload 4
    //   1882: astore 11
    //   1884: aload 13
    //   1886: astore 9
    //   1888: aload 8
    //   1890: astore 10
    //   1892: aload_3
    //   1893: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   1896: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1899: aload 14
    //   1901: astore 12
    //   1903: aload 4
    //   1905: astore 11
    //   1907: aload 13
    //   1909: astore 9
    //   1911: aload 8
    //   1913: astore 10
    //   1915: aload_3
    //   1916: invokevirtual 196	java/io/IOException:toString	()Ljava/lang/String;
    //   1919: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   1922: aload 14
    //   1924: ifnull +8 -> 1932
    //   1927: aload 14
    //   1929: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   1932: aload 4
    //   1934: ifnull +8 -> 1942
    //   1937: aload 4
    //   1939: invokevirtual 330	java/io/InputStream:close	()V
    //   1942: aload 13
    //   1944: ifnull +8 -> 1952
    //   1947: aload 13
    //   1949: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   1952: aload_2
    //   1953: astore 4
    //   1955: aload 8
    //   1957: ifnull -708 -> 1249
    //   1960: aload 8
    //   1962: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   1965: aload_2
    //   1966: astore 4
    //   1968: goto -719 -> 1249
    //   1971: astore_3
    //   1972: aload_3
    //   1973: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1976: goto -44 -> 1932
    //   1979: astore_3
    //   1980: aload_3
    //   1981: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1984: goto -42 -> 1942
    //   1987: astore_3
    //   1988: aload_3
    //   1989: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   1992: goto -40 -> 1952
    //   1995: astore_3
    //   1996: aconst_null
    //   1997: astore 8
    //   1999: aconst_null
    //   2000: astore 13
    //   2002: aconst_null
    //   2003: astore_2
    //   2004: aload 24
    //   2006: astore 4
    //   2008: aload 20
    //   2010: astore 14
    //   2012: aload 14
    //   2014: astore 12
    //   2016: aload 4
    //   2018: astore 11
    //   2020: aload 13
    //   2022: astore 9
    //   2024: aload 8
    //   2026: astore 10
    //   2028: aload_3
    //   2029: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2032: aload 14
    //   2034: astore 12
    //   2036: aload 4
    //   2038: astore 11
    //   2040: aload 13
    //   2042: astore 9
    //   2044: aload 8
    //   2046: astore 10
    //   2048: aload_0
    //   2049: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   2052: sipush 10003
    //   2055: new 101	java/lang/StringBuilder
    //   2058: dup
    //   2059: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2062: aload_3
    //   2063: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2066: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: ldc_w 308
    //   2072: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: aload_3
    //   2076: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2079: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: aconst_null
    //   2086: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2089: aload 14
    //   2091: astore 12
    //   2093: aload 4
    //   2095: astore 11
    //   2097: aload 13
    //   2099: astore 9
    //   2101: aload 8
    //   2103: astore 10
    //   2105: aload_3
    //   2106: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2109: invokestatic 122	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   2112: aload 14
    //   2114: astore 12
    //   2116: aload 4
    //   2118: astore 11
    //   2120: aload 13
    //   2122: astore 9
    //   2124: aload 8
    //   2126: astore 10
    //   2128: aload_3
    //   2129: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   2132: invokestatic 124	com/tencent/token/global/e:d	(Ljava/lang/String;)V
    //   2135: aload 14
    //   2137: ifnull +8 -> 2145
    //   2140: aload 14
    //   2142: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2145: aload 4
    //   2147: ifnull +8 -> 2155
    //   2150: aload 4
    //   2152: invokevirtual 330	java/io/InputStream:close	()V
    //   2155: aload 13
    //   2157: ifnull +8 -> 2165
    //   2160: aload 13
    //   2162: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2165: aload_2
    //   2166: astore 4
    //   2168: aload 8
    //   2170: ifnull -921 -> 1249
    //   2173: aload 8
    //   2175: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2178: aload_2
    //   2179: astore 4
    //   2181: goto -932 -> 1249
    //   2184: astore_3
    //   2185: aload_3
    //   2186: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2189: goto -44 -> 2145
    //   2192: astore_3
    //   2193: aload_3
    //   2194: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2197: goto -42 -> 2155
    //   2200: astore_3
    //   2201: aload_3
    //   2202: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2205: goto -40 -> 2165
    //   2208: astore_3
    //   2209: aconst_null
    //   2210: astore 8
    //   2212: aconst_null
    //   2213: astore 13
    //   2215: aconst_null
    //   2216: astore_2
    //   2217: aload 25
    //   2219: astore 4
    //   2221: aload 21
    //   2223: astore 14
    //   2225: aload 14
    //   2227: astore 12
    //   2229: aload 4
    //   2231: astore 11
    //   2233: aload 13
    //   2235: astore 9
    //   2237: aload 8
    //   2239: astore 10
    //   2241: aload_3
    //   2242: invokevirtual 406	java/lang/Throwable:printStackTrace	()V
    //   2245: aload 14
    //   2247: astore 12
    //   2249: aload 4
    //   2251: astore 11
    //   2253: aload 13
    //   2255: astore 9
    //   2257: aload 8
    //   2259: astore 10
    //   2261: aload_0
    //   2262: getfield 34	com/tencent/token/gv:a	Lcom/tencent/token/global/d;
    //   2265: sipush 10003
    //   2268: new 101	java/lang/StringBuilder
    //   2271: dup
    //   2272: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   2275: aload_3
    //   2276: invokevirtual 407	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2279: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: ldc_w 308
    //   2285: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: aload_3
    //   2289: invokevirtual 408	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2292: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2298: aconst_null
    //   2299: invokevirtual 204	com/tencent/token/global/d:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2302: aload 14
    //   2304: ifnull +8 -> 2312
    //   2307: aload 14
    //   2309: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2312: aload 4
    //   2314: ifnull +8 -> 2322
    //   2317: aload 4
    //   2319: invokevirtual 330	java/io/InputStream:close	()V
    //   2322: aload 13
    //   2324: ifnull +8 -> 2332
    //   2327: aload 13
    //   2329: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2332: aload_2
    //   2333: astore 4
    //   2335: aload 8
    //   2337: ifnull -1088 -> 1249
    //   2340: aload 8
    //   2342: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2345: aload_2
    //   2346: astore 4
    //   2348: goto -1099 -> 1249
    //   2351: astore_3
    //   2352: aload_3
    //   2353: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2356: goto -44 -> 2312
    //   2359: astore_3
    //   2360: aload_3
    //   2361: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2364: goto -42 -> 2322
    //   2367: astore_3
    //   2368: aload_3
    //   2369: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2372: goto -40 -> 2332
    //   2375: astore_1
    //   2376: aconst_null
    //   2377: astore 8
    //   2379: aconst_null
    //   2380: astore 9
    //   2382: aload 10
    //   2384: astore 11
    //   2386: aload 27
    //   2388: astore 12
    //   2390: aload 12
    //   2392: ifnull +8 -> 2400
    //   2395: aload 12
    //   2397: invokevirtual 327	java/io/ByteArrayOutputStream:close	()V
    //   2400: aload 11
    //   2402: ifnull +8 -> 2410
    //   2405: aload 11
    //   2407: invokevirtual 330	java/io/InputStream:close	()V
    //   2410: aload 9
    //   2412: ifnull +8 -> 2420
    //   2415: aload 9
    //   2417: invokevirtual 331	java/io/DataOutputStream:close	()V
    //   2420: aload 8
    //   2422: ifnull +8 -> 2430
    //   2425: aload 8
    //   2427: invokevirtual 243	java/net/HttpURLConnection:disconnect	()V
    //   2430: aload_1
    //   2431: athrow
    //   2432: astore_2
    //   2433: aload_2
    //   2434: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2437: goto -37 -> 2400
    //   2440: astore_2
    //   2441: aload_2
    //   2442: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2445: goto -35 -> 2410
    //   2448: astore_2
    //   2449: aload_2
    //   2450: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   2453: goto -33 -> 2420
    //   2456: aload_1
    //   2457: iconst_0
    //   2458: aload_1
    //   2459: ldc_w 341
    //   2462: invokevirtual 345	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2465: invokevirtual 380	java/lang/String:substring	(II)Ljava/lang/String;
    //   2468: astore_1
    //   2469: goto -1144 -> 1325
    //   2472: astore_1
    //   2473: aconst_null
    //   2474: astore 9
    //   2476: aload 27
    //   2478: astore 12
    //   2480: aload 10
    //   2482: astore 11
    //   2484: goto -94 -> 2390
    //   2487: astore_1
    //   2488: aload 10
    //   2490: astore 8
    //   2492: goto -102 -> 2390
    //   2495: astore_1
    //   2496: aload 27
    //   2498: astore 12
    //   2500: aload_2
    //   2501: astore 11
    //   2503: aload 32
    //   2505: astore 9
    //   2507: goto -117 -> 2390
    //   2510: astore_1
    //   2511: aload_3
    //   2512: astore 12
    //   2514: aload_2
    //   2515: astore 11
    //   2517: aload 32
    //   2519: astore 9
    //   2521: goto -131 -> 2390
    //   2524: astore_1
    //   2525: aload 10
    //   2527: astore 12
    //   2529: aload 9
    //   2531: astore 11
    //   2533: aload 8
    //   2535: astore 9
    //   2537: aload_3
    //   2538: astore 8
    //   2540: goto -150 -> 2390
    //   2543: astore_3
    //   2544: aconst_null
    //   2545: astore 13
    //   2547: aconst_null
    //   2548: astore_2
    //   2549: aload 21
    //   2551: astore 14
    //   2553: aload 25
    //   2555: astore 4
    //   2557: goto -332 -> 2225
    //   2560: astore_3
    //   2561: aconst_null
    //   2562: astore_2
    //   2563: aload 21
    //   2565: astore 14
    //   2567: aload 25
    //   2569: astore 4
    //   2571: aload 15
    //   2573: astore 13
    //   2575: goto -350 -> 2225
    //   2578: astore_3
    //   2579: aload_2
    //   2580: astore 4
    //   2582: aconst_null
    //   2583: astore_2
    //   2584: aload 21
    //   2586: astore 14
    //   2588: aload 29
    //   2590: astore 13
    //   2592: goto -367 -> 2225
    //   2595: astore 9
    //   2597: aload_3
    //   2598: astore 14
    //   2600: aload_2
    //   2601: astore 4
    //   2603: aconst_null
    //   2604: astore_2
    //   2605: aload 9
    //   2607: astore_3
    //   2608: aload 29
    //   2610: astore 13
    //   2612: goto -387 -> 2225
    //   2615: astore 10
    //   2617: aload_3
    //   2618: astore 14
    //   2620: aload_2
    //   2621: astore 9
    //   2623: aload 4
    //   2625: astore_2
    //   2626: aload 10
    //   2628: astore_3
    //   2629: aload 9
    //   2631: astore 4
    //   2633: aload 29
    //   2635: astore 13
    //   2637: goto -412 -> 2225
    //   2640: astore_3
    //   2641: aconst_null
    //   2642: astore 13
    //   2644: aconst_null
    //   2645: astore_2
    //   2646: aload 20
    //   2648: astore 14
    //   2650: aload 24
    //   2652: astore 4
    //   2654: goto -642 -> 2012
    //   2657: astore_3
    //   2658: aconst_null
    //   2659: astore_2
    //   2660: aload 20
    //   2662: astore 14
    //   2664: aload 24
    //   2666: astore 4
    //   2668: aload 16
    //   2670: astore 13
    //   2672: goto -660 -> 2012
    //   2675: astore_3
    //   2676: aload_2
    //   2677: astore 4
    //   2679: aconst_null
    //   2680: astore_2
    //   2681: aload 20
    //   2683: astore 14
    //   2685: aload 28
    //   2687: astore 13
    //   2689: goto -677 -> 2012
    //   2692: astore 9
    //   2694: aload_3
    //   2695: astore 14
    //   2697: aload_2
    //   2698: astore 4
    //   2700: aconst_null
    //   2701: astore_2
    //   2702: aload 9
    //   2704: astore_3
    //   2705: aload 28
    //   2707: astore 13
    //   2709: goto -697 -> 2012
    //   2712: astore 10
    //   2714: aload_3
    //   2715: astore 14
    //   2717: aload_2
    //   2718: astore 9
    //   2720: aload 4
    //   2722: astore_2
    //   2723: aload 10
    //   2725: astore_3
    //   2726: aload 9
    //   2728: astore 4
    //   2730: aload 28
    //   2732: astore 13
    //   2734: goto -722 -> 2012
    //   2737: astore_3
    //   2738: aconst_null
    //   2739: astore 13
    //   2741: aconst_null
    //   2742: astore_2
    //   2743: aload 19
    //   2745: astore 14
    //   2747: aload 23
    //   2749: astore 4
    //   2751: goto -952 -> 1799
    //   2754: astore_3
    //   2755: aconst_null
    //   2756: astore_2
    //   2757: aload 19
    //   2759: astore 14
    //   2761: aload 23
    //   2763: astore 4
    //   2765: aload 17
    //   2767: astore 13
    //   2769: goto -970 -> 1799
    //   2772: astore_3
    //   2773: aload_2
    //   2774: astore 4
    //   2776: aconst_null
    //   2777: astore_2
    //   2778: aload 19
    //   2780: astore 14
    //   2782: aload 26
    //   2784: astore 13
    //   2786: goto -987 -> 1799
    //   2789: astore 9
    //   2791: aload_3
    //   2792: astore 14
    //   2794: aload_2
    //   2795: astore 4
    //   2797: aconst_null
    //   2798: astore_2
    //   2799: aload 9
    //   2801: astore_3
    //   2802: aload 26
    //   2804: astore 13
    //   2806: goto -1007 -> 1799
    //   2809: astore 10
    //   2811: aload_3
    //   2812: astore 14
    //   2814: aload_2
    //   2815: astore 9
    //   2817: aload 4
    //   2819: astore_2
    //   2820: aload 10
    //   2822: astore_3
    //   2823: aload 9
    //   2825: astore 4
    //   2827: aload 26
    //   2829: astore 13
    //   2831: goto -1032 -> 1799
    //   2834: astore 4
    //   2836: aconst_null
    //   2837: astore_2
    //   2838: aload 18
    //   2840: astore 10
    //   2842: aload 22
    //   2844: astore 9
    //   2846: aload 11
    //   2848: astore 8
    //   2850: aload 12
    //   2852: astore_3
    //   2853: goto -1724 -> 1129
    //   2856: astore 4
    //   2858: aload 8
    //   2860: astore_3
    //   2861: aconst_null
    //   2862: astore_2
    //   2863: aload 18
    //   2865: astore 10
    //   2867: aload 22
    //   2869: astore 9
    //   2871: aload 11
    //   2873: astore 8
    //   2875: goto -1746 -> 1129
    //   2878: astore 4
    //   2880: aload 8
    //   2882: astore_3
    //   2883: aconst_null
    //   2884: astore_2
    //   2885: aload 18
    //   2887: astore 10
    //   2889: aload 22
    //   2891: astore 9
    //   2893: aload 13
    //   2895: astore 8
    //   2897: goto -1768 -> 1129
    //   2900: astore 4
    //   2902: aconst_null
    //   2903: astore 11
    //   2905: aload 8
    //   2907: astore_3
    //   2908: aconst_null
    //   2909: astore_2
    //   2910: aload 18
    //   2912: astore 10
    //   2914: aload 22
    //   2916: astore 9
    //   2918: aload 11
    //   2920: astore 8
    //   2922: goto -1793 -> 1129
    //   2925: astore 4
    //   2927: aload_2
    //   2928: astore 9
    //   2930: aconst_null
    //   2931: astore 11
    //   2933: aload 8
    //   2935: astore_3
    //   2936: aconst_null
    //   2937: astore_2
    //   2938: aload 18
    //   2940: astore 10
    //   2942: aload 11
    //   2944: astore 8
    //   2946: goto -1817 -> 1129
    //   2949: astore 12
    //   2951: aload_3
    //   2952: astore 10
    //   2954: aload_2
    //   2955: astore 9
    //   2957: aconst_null
    //   2958: astore 11
    //   2960: aload 8
    //   2962: astore_3
    //   2963: aload 4
    //   2965: astore_2
    //   2966: aload 12
    //   2968: astore 4
    //   2970: aload 11
    //   2972: astore 8
    //   2974: goto -1845 -> 1129
    //   2977: goto -2529 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2980	0	this	gv
    //   0	2980	1	paramString1	String
    //   0	2980	2	paramString2	String
    //   0	2980	3	paramString3	String
    //   0	2980	4	paramArrayOfByte	byte[]
    //   505	1167	5	j	int
    //   164	43	6	l	long
    //   57	2916	8	localObject1	Object
    //   244	2292	9	localObject2	Object
    //   2595	11	9	localThrowable1	java.lang.Throwable
    //   2621	9	9	str1	String
    //   2692	11	9	localException1	Exception
    //   2718	9	9	str2	String
    //   2789	11	9	localIOException1	IOException
    //   2815	141	9	localObject3	Object
    //   25	2501	10	localObject4	Object
    //   2615	12	10	localThrowable2	java.lang.Throwable
    //   2712	12	10	localException2	Exception
    //   2809	12	10	localIOException2	IOException
    //   2840	113	10	localObject5	Object
    //   13	2958	11	localObject6	Object
    //   10	2841	12	localObject7	Object
    //   2949	18	12	localSocketTimeoutException	java.net.SocketTimeoutException
    //   232	2662	13	localObject8	Object
    //   90	2723	14	localObject9	Object
    //   252	2320	15	localObject10	Object
    //   256	2413	16	localObject11	Object
    //   260	2506	17	localObject12	Object
    //   49	2890	18	localObject13	Object
    //   34	2745	19	localObject14	Object
    //   37	2645	20	localObject15	Object
    //   40	2545	21	localObject16	Object
    //   31	2884	22	localObject17	Object
    //   16	2746	23	localObject18	Object
    //   19	2646	24	localObject19	Object
    //   22	2546	25	localObject20	Object
    //   470	2358	26	localObject21	Object
    //   43	2454	27	localObject22	Object
    //   449	2282	28	localObject23	Object
    //   452	2182	29	localObject24	Object
    //   28	1669	30	localObject25	Object
    //   46	1647	31	localObject26	Object
    //   455	2063	32	localObject27	Object
    //   458	1243	33	localObject28	Object
    //   461	1248	34	localObject29	Object
    //   464	1249	35	localObject30	Object
    //   467	1250	36	localObject31	Object
    //   7	1293	37	localr	com.tencent.token.utils.r
    //   708	73	38	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1084	1090	1105	java/net/SocketTimeoutException
    //   1096	1102	1105	java/net/SocketTimeoutException
    //   1339	1349	1105	java/net/SocketTimeoutException
    //   1379	1383	1736	java/lang/Exception
    //   1387	1391	1744	java/lang/Exception
    //   1210	1215	1752	java/lang/Exception
    //   1220	1225	1762	java/lang/Exception
    //   1230	1235	1772	java/lang/Exception
    //   51	59	1782	java/io/IOException
    //   1927	1932	1971	java/lang/Exception
    //   1937	1942	1979	java/lang/Exception
    //   1947	1952	1987	java/lang/Exception
    //   51	59	1995	java/lang/Exception
    //   2140	2145	2184	java/lang/Exception
    //   2150	2155	2192	java/lang/Exception
    //   2160	2165	2200	java/lang/Exception
    //   51	59	2208	java/lang/Throwable
    //   2307	2312	2351	java/lang/Exception
    //   2317	2322	2359	java/lang/Exception
    //   2327	2332	2367	java/lang/Exception
    //   51	59	2375	finally
    //   2395	2400	2432	java/lang/Exception
    //   2405	2410	2440	java/lang/Exception
    //   2415	2420	2448	java/lang/Exception
    //   82	89	2472	finally
    //   97	214	2472	finally
    //   214	234	2472	finally
    //   262	268	2487	finally
    //   301	308	2487	finally
    //   336	347	2487	finally
    //   375	382	2487	finally
    //   410	415	2487	finally
    //   443	448	2487	finally
    //   500	507	2487	finally
    //   557	564	2487	finally
    //   602	646	2487	finally
    //   674	710	2487	finally
    //   738	749	2487	finally
    //   780	793	2487	finally
    //   821	833	2487	finally
    //   861	873	2487	finally
    //   901	907	2487	finally
    //   935	945	2487	finally
    //   987	994	2487	finally
    //   1025	1039	2487	finally
    //   1070	1076	2487	finally
    //   1455	1487	2487	finally
    //   1515	1549	2487	finally
    //   1577	1591	2487	finally
    //   1619	1630	2487	finally
    //   1660	1682	2487	finally
    //   1720	1733	2487	finally
    //   1815	1819	2487	finally
    //   1835	1876	2487	finally
    //   1892	1899	2487	finally
    //   1915	1922	2487	finally
    //   2028	2032	2487	finally
    //   2048	2089	2487	finally
    //   2105	2112	2487	finally
    //   2128	2135	2487	finally
    //   2241	2245	2487	finally
    //   2261	2302	2487	finally
    //   1076	1084	2495	finally
    //   1084	1090	2510	finally
    //   1096	1102	2510	finally
    //   1339	1349	2510	finally
    //   1354	1360	2510	finally
    //   1360	1372	2510	finally
    //   1412	1420	2510	finally
    //   1129	1205	2524	finally
    //   82	89	2543	java/lang/Throwable
    //   97	214	2543	java/lang/Throwable
    //   214	234	2543	java/lang/Throwable
    //   262	268	2560	java/lang/Throwable
    //   301	308	2560	java/lang/Throwable
    //   336	347	2560	java/lang/Throwable
    //   375	382	2560	java/lang/Throwable
    //   410	415	2560	java/lang/Throwable
    //   443	448	2560	java/lang/Throwable
    //   500	507	2560	java/lang/Throwable
    //   557	564	2560	java/lang/Throwable
    //   602	646	2560	java/lang/Throwable
    //   674	710	2560	java/lang/Throwable
    //   738	749	2560	java/lang/Throwable
    //   780	793	2560	java/lang/Throwable
    //   821	833	2560	java/lang/Throwable
    //   861	873	2560	java/lang/Throwable
    //   901	907	2560	java/lang/Throwable
    //   935	945	2560	java/lang/Throwable
    //   987	994	2560	java/lang/Throwable
    //   1025	1039	2560	java/lang/Throwable
    //   1070	1076	2560	java/lang/Throwable
    //   1455	1487	2560	java/lang/Throwable
    //   1515	1549	2560	java/lang/Throwable
    //   1577	1591	2560	java/lang/Throwable
    //   1619	1630	2560	java/lang/Throwable
    //   1660	1682	2560	java/lang/Throwable
    //   1720	1733	2560	java/lang/Throwable
    //   1076	1084	2578	java/lang/Throwable
    //   1084	1090	2595	java/lang/Throwable
    //   1096	1102	2595	java/lang/Throwable
    //   1339	1349	2595	java/lang/Throwable
    //   1354	1360	2615	java/lang/Throwable
    //   1360	1372	2615	java/lang/Throwable
    //   1412	1420	2615	java/lang/Throwable
    //   82	89	2640	java/lang/Exception
    //   97	214	2640	java/lang/Exception
    //   214	234	2640	java/lang/Exception
    //   262	268	2657	java/lang/Exception
    //   301	308	2657	java/lang/Exception
    //   336	347	2657	java/lang/Exception
    //   375	382	2657	java/lang/Exception
    //   410	415	2657	java/lang/Exception
    //   443	448	2657	java/lang/Exception
    //   500	507	2657	java/lang/Exception
    //   557	564	2657	java/lang/Exception
    //   602	646	2657	java/lang/Exception
    //   674	710	2657	java/lang/Exception
    //   738	749	2657	java/lang/Exception
    //   780	793	2657	java/lang/Exception
    //   821	833	2657	java/lang/Exception
    //   861	873	2657	java/lang/Exception
    //   901	907	2657	java/lang/Exception
    //   935	945	2657	java/lang/Exception
    //   987	994	2657	java/lang/Exception
    //   1025	1039	2657	java/lang/Exception
    //   1070	1076	2657	java/lang/Exception
    //   1455	1487	2657	java/lang/Exception
    //   1515	1549	2657	java/lang/Exception
    //   1577	1591	2657	java/lang/Exception
    //   1619	1630	2657	java/lang/Exception
    //   1660	1682	2657	java/lang/Exception
    //   1720	1733	2657	java/lang/Exception
    //   1076	1084	2675	java/lang/Exception
    //   1084	1090	2692	java/lang/Exception
    //   1096	1102	2692	java/lang/Exception
    //   1339	1349	2692	java/lang/Exception
    //   1354	1360	2712	java/lang/Exception
    //   1360	1372	2712	java/lang/Exception
    //   1412	1420	2712	java/lang/Exception
    //   82	89	2737	java/io/IOException
    //   97	214	2737	java/io/IOException
    //   214	234	2737	java/io/IOException
    //   262	268	2754	java/io/IOException
    //   301	308	2754	java/io/IOException
    //   336	347	2754	java/io/IOException
    //   375	382	2754	java/io/IOException
    //   410	415	2754	java/io/IOException
    //   443	448	2754	java/io/IOException
    //   500	507	2754	java/io/IOException
    //   557	564	2754	java/io/IOException
    //   602	646	2754	java/io/IOException
    //   674	710	2754	java/io/IOException
    //   738	749	2754	java/io/IOException
    //   780	793	2754	java/io/IOException
    //   821	833	2754	java/io/IOException
    //   861	873	2754	java/io/IOException
    //   901	907	2754	java/io/IOException
    //   935	945	2754	java/io/IOException
    //   987	994	2754	java/io/IOException
    //   1025	1039	2754	java/io/IOException
    //   1070	1076	2754	java/io/IOException
    //   1455	1487	2754	java/io/IOException
    //   1515	1549	2754	java/io/IOException
    //   1577	1591	2754	java/io/IOException
    //   1619	1630	2754	java/io/IOException
    //   1660	1682	2754	java/io/IOException
    //   1720	1733	2754	java/io/IOException
    //   1076	1084	2772	java/io/IOException
    //   1084	1090	2789	java/io/IOException
    //   1096	1102	2789	java/io/IOException
    //   1339	1349	2789	java/io/IOException
    //   1354	1360	2809	java/io/IOException
    //   1360	1372	2809	java/io/IOException
    //   1412	1420	2809	java/io/IOException
    //   51	59	2834	java/net/SocketTimeoutException
    //   82	89	2856	java/net/SocketTimeoutException
    //   97	214	2856	java/net/SocketTimeoutException
    //   214	234	2856	java/net/SocketTimeoutException
    //   262	268	2878	java/net/SocketTimeoutException
    //   301	308	2878	java/net/SocketTimeoutException
    //   336	347	2878	java/net/SocketTimeoutException
    //   375	382	2878	java/net/SocketTimeoutException
    //   410	415	2878	java/net/SocketTimeoutException
    //   443	448	2878	java/net/SocketTimeoutException
    //   500	507	2900	java/net/SocketTimeoutException
    //   557	564	2900	java/net/SocketTimeoutException
    //   602	646	2900	java/net/SocketTimeoutException
    //   674	710	2900	java/net/SocketTimeoutException
    //   738	749	2900	java/net/SocketTimeoutException
    //   780	793	2900	java/net/SocketTimeoutException
    //   821	833	2900	java/net/SocketTimeoutException
    //   861	873	2900	java/net/SocketTimeoutException
    //   901	907	2900	java/net/SocketTimeoutException
    //   935	945	2900	java/net/SocketTimeoutException
    //   987	994	2900	java/net/SocketTimeoutException
    //   1025	1039	2900	java/net/SocketTimeoutException
    //   1070	1076	2900	java/net/SocketTimeoutException
    //   1455	1487	2900	java/net/SocketTimeoutException
    //   1515	1549	2900	java/net/SocketTimeoutException
    //   1577	1591	2900	java/net/SocketTimeoutException
    //   1619	1630	2900	java/net/SocketTimeoutException
    //   1660	1682	2900	java/net/SocketTimeoutException
    //   1720	1733	2900	java/net/SocketTimeoutException
    //   1076	1084	2925	java/net/SocketTimeoutException
    //   1354	1360	2949	java/net/SocketTimeoutException
    //   1360	1372	2949	java/net/SocketTimeoutException
    //   1412	1420	2949	java/net/SocketTimeoutException
  }
  
  public final d a()
  {
    return this.a;
  }
  
  public final byte[] a(String paramString)
  {
    int j = 0;
    byte[] arrayOfByte = null;
    for (;;)
    {
      if (j < 2)
      {
        arrayOfByte = a(paramString, "GET", null, null);
        if (arrayOfByte == null) {}
      }
      else
      {
        return arrayOfByte;
      }
      j += 1;
    }
  }
  
  public final byte[] a(String paramString, ContentValues paramContentValues)
  {
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      Iterator localIterator = paramContentValues.iterator();
      paramContentValues = "";
      for (String str = "";; str = "&")
      {
        localObject = paramContentValues;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        paramContentValues = paramContentValues + str + (String)((Map.Entry)localObject).getKey() + "=" + ((Map.Entry)localObject).getValue();
      }
    }
    Object localObject = null;
    return a(paramString, "POST", (String)localObject, null);
  }
  
  public final byte[] a(String paramString1, File paramFile, ContentValues paramContentValues, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      paramContentValues = paramContentValues.iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localStringBuffer.append("--");
        localStringBuffer.append("-----------------------x10d15y03m09d0");
        localStringBuffer.append("\r\n");
        localStringBuffer.append("Content-Disposition: form-data; name=\"");
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("\"\r\n\r\n");
        localStringBuffer.append(localEntry.getValue());
        localStringBuffer.append("\r\n");
      }
    }
    localStringBuffer.append("--");
    localStringBuffer.append("-----------------------x10d15y03m09d0");
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Content-Disposition: form-data; name=\"");
    localStringBuffer.append("log_file");
    localStringBuffer.append("\"; filename=\"");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("\"\r\n");
    localStringBuffer.append("Content-Type: application/octet-stream\r\n\r\n");
    e.c("testlogfile:" + localStringBuffer);
    return a(paramString1, "POST", localStringBuffer.toString(), paramFile);
  }
  
  public final byte[] a(String paramString1, byte[] paramArrayOfByte, ContentValues paramContentValues, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramContentValues = paramContentValues.valueSet();
    if (paramContentValues.size() > 0)
    {
      paramContentValues = paramContentValues.iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localStringBuffer.append("--");
        localStringBuffer.append("-----------------------x10d15y03m09d0");
        localStringBuffer.append("\r\n");
        localStringBuffer.append("Content-Disposition: form-data; name=\"");
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("\"\r\n\r\n");
        localStringBuffer.append(localEntry.getValue());
        localStringBuffer.append("\r\n");
      }
    }
    localStringBuffer.append("--");
    localStringBuffer.append("-----------------------x10d15y03m09d0");
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Content-Disposition: form-data; name=\"");
    localStringBuffer.append("data_file");
    localStringBuffer.append("\"; filename=\"");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("\"\r\n");
    localStringBuffer.append("Content-Type: application/octet-stream\r\n\r\n");
    e.c("requestUploadFileEnc:" + localStringBuffer);
    return a(paramString1, "POST", localStringBuffer.toString(), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gv
 * JD-Core Version:    0.7.0.1
 */