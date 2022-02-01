package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public final class ajn
{
  public static int f = 300000;
  public xh a = new xh();
  int b = 20000;
  int c = 20000;
  int d = 30000;
  int e = 30000;
  private final int g = 2;
  
  private HttpURLConnection a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        localObject1 = RqdApplication.p();
        if (localObject1 == null) {
          break label583;
        }
        Object localObject2 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject2 == null) {
          break label577;
        }
        if (((NetworkInfo)localObject2).getType() == 0)
        {
          localObject1 = android.net.Proxy.getDefaultHost();
          i = android.net.Proxy.getDefaultPort();
          String str = ((NetworkInfo)localObject2).getExtraInfo();
          f = ((NetworkInfo)localObject2).getSubtype() + 200000;
          localObject2 = new StringBuilder("conn proxy host=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("; port=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("; mobile type=");
          ((StringBuilder)localObject2).append(str);
          xj.a(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder("conn proxy host=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("; port=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("; mobile type=");
          ((StringBuilder)localObject2).append(str);
          xj.c(((StringBuilder)localObject2).toString());
          if ((localObject1 != null) && (-1 != i) && (str != null) && ((str.toLowerCase(Locale.getDefault()).equals("cmwap")) || (str.toLowerCase(Locale.getDefault()).equals("uniwap")) || (str.toLowerCase(Locale.getDefault()).equals("3gwap")))) {
            break label567;
          }
          if ((localObject1 == null) || (-1 == i) || (str == null) || (!str.toLowerCase(Locale.getDefault()).equals("ctwap"))) {
            break label572;
          }
          i = 5;
          break label585;
        }
        f = 100000;
        i = 1;
      }
      catch (Exception paramString1)
      {
        paramString2 = this.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1.toString());
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(paramString1.getMessage());
        paramString2.a(10003, ((StringBuilder)localObject1).toString(), null);
        paramString1.printStackTrace();
        return null;
      }
      catch (IOException paramString1)
      {
        paramString2 = this.a;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1.toString());
        ((StringBuilder)localObject1).append("-");
        ((StringBuilder)localObject1).append(paramString1.getMessage());
        paramString2.a(10003, ((StringBuilder)localObject1).toString(), null);
        return null;
      }
      localObject1 = paramString1.getProtocol();
      continue;
      this.a.a(10001, "conn is close", null);
      return null;
      localObject1 = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
      paramString1 = (HttpURLConnection)paramString1.openConnection(new java.net.Proxy(Proxy.Type.HTTP, (SocketAddress)localObject1));
      continue;
      if (((String)localObject1).toLowerCase().equals("https")) {
        paramString1 = (HttpsURLConnection)paramString1.openConnection();
      } else {
        paramString1 = (HttpURLConnection)paramString1.openConnection();
      }
      if (paramString2.equals("POST"))
      {
        paramString1.setConnectTimeout(this.d);
        paramString1.setReadTimeout(this.e);
      }
      else
      {
        paramString1.setConnectTimeout(this.b);
        paramString1.setReadTimeout(this.c);
      }
      paramString1.setRequestMethod(paramString2);
      return paramString1;
      label567:
      int i = 3;
      break label585;
      label572:
      i = 2;
      break label585;
      label577:
      i = 6;
      break label585;
      label583:
      i = 0;
      label585:
      switch (i)
      {
      }
    }
  }
  
  private byte[] a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    return b(paramString1, paramString2, paramString3, paramFile);
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 12
    //   3: new 212	com/tencent/token/aan
    //   6: dup
    //   7: invokespecial 213	com/tencent/token/aan:<init>	()V
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 11
    //   15: aconst_null
    //   16: astore 13
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokespecial 215	com/tencent/token/ajn:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   24: astore 8
    //   26: aload 8
    //   28: ifnonnull +15 -> 43
    //   31: aload 8
    //   33: ifnull +8 -> 41
    //   36: aload 8
    //   38: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_3
    //   44: ifnull +283 -> 327
    //   47: aload_3
    //   48: invokevirtual 221	java/lang/String:length	()I
    //   51: ifle +276 -> 327
    //   54: aload 4
    //   56: ifnull +2561 -> 2617
    //   59: new 91	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 223
    //   65: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: astore 9
    //   70: aload 9
    //   72: aload_3
    //   73: invokevirtual 227	java/lang/String:getBytes	()[B
    //   76: arraylength
    //   77: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 9
    //   83: ldc 229
    //   85: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 9
    //   91: aload 4
    //   93: arraylength
    //   94: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 9
    //   100: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   106: ldc 231
    //   108: invokevirtual 227	java/lang/String:getBytes	()[B
    //   111: astore 10
    //   113: aload_3
    //   114: invokevirtual 227	java/lang/String:getBytes	()[B
    //   117: arraylength
    //   118: aload 10
    //   120: arraylength
    //   121: iadd
    //   122: aload 4
    //   124: arraylength
    //   125: iadd
    //   126: ldc 233
    //   128: invokevirtual 227	java/lang/String:getBytes	()[B
    //   131: arraylength
    //   132: iadd
    //   133: i2l
    //   134: lstore 6
    //   136: ldc 235
    //   138: lload 6
    //   140: invokestatic 239	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   143: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   146: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   149: aload 8
    //   151: ldc 245
    //   153: ldc 247
    //   155: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 8
    //   160: ldc 253
    //   162: lload 6
    //   164: invokestatic 239	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   167: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto +3 -> 173
    //   173: aload 8
    //   175: iconst_1
    //   176: invokevirtual 257	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   179: new 259	java/io/DataOutputStream
    //   182: dup
    //   183: aload 8
    //   185: invokevirtual 263	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   188: invokespecial 266	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   191: astore 9
    //   193: aload 9
    //   195: aload_3
    //   196: invokevirtual 269	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   199: aload 4
    //   201: ifnull +27 -> 228
    //   204: aload 9
    //   206: aload 4
    //   208: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   211: aload 9
    //   213: ldc 233
    //   215: invokevirtual 227	java/lang/String:getBytes	()[B
    //   218: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   221: aload 9
    //   223: aload 10
    //   225: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   228: aload 9
    //   230: invokevirtual 276	java/io/DataOutputStream:flush	()V
    //   233: aload 9
    //   235: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   238: goto +89 -> 327
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_2
    //   244: aload 11
    //   246: astore 10
    //   248: goto +2305 -> 2553
    //   251: astore 13
    //   253: aconst_null
    //   254: astore 10
    //   256: aload 10
    //   258: astore 11
    //   260: aload 11
    //   262: astore_1
    //   263: aload 8
    //   265: astore 14
    //   267: goto +1016 -> 1283
    //   270: astore 13
    //   272: aconst_null
    //   273: astore 10
    //   275: aload 10
    //   277: astore 11
    //   279: aload 11
    //   281: astore_1
    //   282: aload 8
    //   284: astore 14
    //   286: goto +1251 -> 1537
    //   289: astore 13
    //   291: aconst_null
    //   292: astore 10
    //   294: aload 10
    //   296: astore 11
    //   298: aload 11
    //   300: astore_1
    //   301: aload 8
    //   303: astore 14
    //   305: goto +1523 -> 1828
    //   308: astore 13
    //   310: aconst_null
    //   311: astore 10
    //   313: aload 10
    //   315: astore 11
    //   317: aload 11
    //   319: astore_1
    //   320: aload 8
    //   322: astore 14
    //   324: goto +1795 -> 2119
    //   327: aload 8
    //   329: invokevirtual 282	java/net/HttpURLConnection:getResponseCode	()I
    //   332: istore 5
    //   334: new 91	java/lang/StringBuilder
    //   337: dup
    //   338: ldc_w 284
    //   341: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: astore 9
    //   346: aload 9
    //   348: iload 5
    //   350: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 9
    //   356: ldc_w 286
    //   359: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 9
    //   365: aload 12
    //   367: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: ldc_w 288
    //   374: aload 9
    //   376: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 293	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: iload 5
    //   384: sipush 200
    //   387: if_icmpeq +166 -> 553
    //   390: iload 5
    //   392: sipush 206
    //   395: if_icmpeq +158 -> 553
    //   398: iload 5
    //   400: iconst_m1
    //   401: if_icmpne +6 -> 407
    //   404: goto +149 -> 553
    //   407: aload_0
    //   408: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   411: sipush 10005
    //   414: ldc_w 295
    //   417: iload 5
    //   419: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   422: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   425: aconst_null
    //   426: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   429: new 91	java/lang/StringBuilder
    //   432: dup
    //   433: ldc_w 300
    //   436: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   439: astore_1
    //   440: aload_1
    //   441: aload 12
    //   443: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_1
    //   448: ldc_w 302
    //   451: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_1
    //   456: iload 5
    //   458: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_1
    //   463: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   469: new 91	java/lang/StringBuilder
    //   472: dup
    //   473: ldc_w 304
    //   476: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   479: astore_2
    //   480: aload 12
    //   482: ldc_w 306
    //   485: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   488: iconst_m1
    //   489: if_icmpne +9 -> 498
    //   492: aload 12
    //   494: astore_1
    //   495: goto +18 -> 513
    //   498: aload 12
    //   500: iconst_0
    //   501: aload 12
    //   503: ldc_w 306
    //   506: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   509: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   512: astore_1
    //   513: aload_2
    //   514: aload_1
    //   515: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 302
    //   523: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_2
    //   528: iload 5
    //   530: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload_2
    //   535: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   541: aconst_null
    //   542: astore 4
    //   544: aload 4
    //   546: astore_1
    //   547: aload 13
    //   549: astore_2
    //   550: goto +302 -> 852
    //   553: aload 8
    //   555: invokevirtual 317	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   558: astore 9
    //   560: aload 9
    //   562: ifnonnull +11 -> 573
    //   565: ldc_w 319
    //   568: astore 9
    //   570: goto +10 -> 580
    //   573: aload 9
    //   575: invokevirtual 171	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   578: astore 9
    //   580: new 91	java/lang/StringBuilder
    //   583: dup
    //   584: ldc_w 321
    //   587: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   590: astore 10
    //   592: aload 10
    //   594: aload 9
    //   596: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 10
    //   602: ldc_w 323
    //   605: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 10
    //   611: aload_2
    //   612: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 10
    //   618: ldc_w 325
    //   621: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 10
    //   627: aload 12
    //   629: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 10
    //   635: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 327	com/tencent/token/xj:b	(Ljava/lang/String;)V
    //   641: new 91	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 321
    //   648: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: astore 14
    //   653: aload 14
    //   655: aload 9
    //   657: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 14
    //   663: ldc_w 323
    //   666: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 14
    //   672: aload_2
    //   673: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 14
    //   679: ldc_w 325
    //   682: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 12
    //   688: ldc_w 306
    //   691: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   694: iconst_m1
    //   695: if_icmpne +10 -> 705
    //   698: aload 12
    //   700: astore 10
    //   702: goto +19 -> 721
    //   705: aload 12
    //   707: iconst_0
    //   708: aload 12
    //   710: ldc_w 306
    //   713: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   716: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   719: astore 10
    //   721: aload 14
    //   723: aload 10
    //   725: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 14
    //   731: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   737: aload 9
    //   739: ldc_w 329
    //   742: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   745: iconst_m1
    //   746: if_icmpne +367 -> 1113
    //   749: aload 9
    //   751: ldc_w 331
    //   754: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   757: iconst_m1
    //   758: if_icmpeq +6 -> 764
    //   761: goto +352 -> 1113
    //   764: aload 8
    //   766: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   769: astore_2
    //   770: aload_2
    //   771: astore 4
    //   773: new 337	java/io/ByteArrayOutputStream
    //   776: dup
    //   777: invokespecial 338	java/io/ByteArrayOutputStream:<init>	()V
    //   780: astore_1
    //   781: aload 4
    //   783: invokevirtual 343	java/io/InputStream:read	()I
    //   786: istore 5
    //   788: iload 5
    //   790: iconst_m1
    //   791: if_icmpeq +12 -> 803
    //   794: aload_1
    //   795: iload 5
    //   797: invokevirtual 345	java/io/ByteArrayOutputStream:write	(I)V
    //   800: goto -19 -> 781
    //   803: aload_1
    //   804: invokevirtual 346	java/io/ByteArrayOutputStream:flush	()V
    //   807: aload_1
    //   808: invokevirtual 349	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   811: astore_3
    //   812: aload_3
    //   813: ifnull +24 -> 837
    //   816: aload_3
    //   817: arraylength
    //   818: ifgt +6 -> 824
    //   821: goto +16 -> 837
    //   824: aload_0
    //   825: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   828: iconst_0
    //   829: putfield 351	com/tencent/token/xh:a	I
    //   832: aload_3
    //   833: astore_2
    //   834: goto +18 -> 852
    //   837: aload_0
    //   838: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   841: ldc_w 352
    //   844: aconst_null
    //   845: aconst_null
    //   846: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   849: aload 13
    //   851: astore_2
    //   852: aload_1
    //   853: ifnull +15 -> 868
    //   856: aload_1
    //   857: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   860: goto +8 -> 868
    //   863: astore_1
    //   864: aload_1
    //   865: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   868: aload 4
    //   870: ifnull +16 -> 886
    //   873: aload 4
    //   875: invokevirtual 354	java/io/InputStream:close	()V
    //   878: goto +8 -> 886
    //   881: astore_1
    //   882: aload_1
    //   883: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   886: aload 8
    //   888: ifnull +8 -> 896
    //   891: aload 8
    //   893: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   896: goto +1520 -> 2416
    //   899: astore 9
    //   901: aload_3
    //   902: astore 4
    //   904: aload 9
    //   906: astore_3
    //   907: aload_1
    //   908: astore 10
    //   910: aload 4
    //   912: astore_1
    //   913: goto +118 -> 1031
    //   916: astore 9
    //   918: aload_3
    //   919: astore 4
    //   921: aload 9
    //   923: astore_3
    //   924: aload_1
    //   925: astore 10
    //   927: aload 4
    //   929: astore_1
    //   930: goto +123 -> 1053
    //   933: astore 9
    //   935: aload_3
    //   936: astore 4
    //   938: aload 9
    //   940: astore_3
    //   941: aload_1
    //   942: astore 10
    //   944: aload 4
    //   946: astore_1
    //   947: goto +128 -> 1075
    //   950: astore 9
    //   952: aload_3
    //   953: astore 4
    //   955: aload 9
    //   957: astore_3
    //   958: aload_1
    //   959: astore 10
    //   961: aload 4
    //   963: astore_1
    //   964: goto +133 -> 1097
    //   967: astore_3
    //   968: aconst_null
    //   969: astore 9
    //   971: aload_1
    //   972: astore_2
    //   973: aload 4
    //   975: astore_1
    //   976: aload 9
    //   978: astore 4
    //   980: goto +1562 -> 2542
    //   983: astore_3
    //   984: aload_1
    //   985: astore 10
    //   987: goto +42 -> 1029
    //   990: astore_3
    //   991: aload_1
    //   992: astore 10
    //   994: goto +57 -> 1051
    //   997: astore_3
    //   998: aload_1
    //   999: astore 10
    //   1001: goto +72 -> 1073
    //   1004: astore_3
    //   1005: aload_1
    //   1006: astore 10
    //   1008: goto +87 -> 1095
    //   1011: astore_1
    //   1012: aload 4
    //   1014: astore_2
    //   1015: aconst_null
    //   1016: astore 9
    //   1018: aload 11
    //   1020: astore 10
    //   1022: goto +1531 -> 2553
    //   1025: astore_3
    //   1026: aconst_null
    //   1027: astore 10
    //   1029: aconst_null
    //   1030: astore_1
    //   1031: aconst_null
    //   1032: astore 9
    //   1034: aload_3
    //   1035: astore 13
    //   1037: aload_2
    //   1038: astore 11
    //   1040: aload 8
    //   1042: astore 14
    //   1044: goto +239 -> 1283
    //   1047: astore_3
    //   1048: aconst_null
    //   1049: astore 10
    //   1051: aconst_null
    //   1052: astore_1
    //   1053: aconst_null
    //   1054: astore 9
    //   1056: aload_3
    //   1057: astore 13
    //   1059: aload_2
    //   1060: astore 11
    //   1062: aload 8
    //   1064: astore 14
    //   1066: goto +471 -> 1537
    //   1069: astore_3
    //   1070: aconst_null
    //   1071: astore 10
    //   1073: aconst_null
    //   1074: astore_1
    //   1075: aconst_null
    //   1076: astore 9
    //   1078: aload_3
    //   1079: astore 13
    //   1081: aload_2
    //   1082: astore 11
    //   1084: aload 8
    //   1086: astore 14
    //   1088: goto +740 -> 1828
    //   1091: astore_3
    //   1092: aconst_null
    //   1093: astore 10
    //   1095: aconst_null
    //   1096: astore_1
    //   1097: aconst_null
    //   1098: astore 9
    //   1100: aload_3
    //   1101: astore 13
    //   1103: aload_2
    //   1104: astore 11
    //   1106: aload 8
    //   1108: astore 14
    //   1110: goto +1009 -> 2119
    //   1113: ldc_w 356
    //   1116: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1119: aload_0
    //   1120: aload_1
    //   1121: aload_2
    //   1122: aload_3
    //   1123: aload 4
    //   1125: invokespecial 358	com/tencent/token/ajn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)[B
    //   1128: astore_1
    //   1129: aload 8
    //   1131: ifnull +8 -> 1139
    //   1134: aload 8
    //   1136: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   1139: aload_1
    //   1140: areturn
    //   1141: astore_1
    //   1142: aconst_null
    //   1143: astore_2
    //   1144: aload_2
    //   1145: astore 9
    //   1147: aload 11
    //   1149: astore 10
    //   1151: goto +1402 -> 2553
    //   1154: astore 13
    //   1156: aconst_null
    //   1157: astore 10
    //   1159: aload 10
    //   1161: astore 11
    //   1163: aload 11
    //   1165: astore 9
    //   1167: aload 9
    //   1169: astore_1
    //   1170: aload 8
    //   1172: astore 14
    //   1174: goto +109 -> 1283
    //   1177: astore 13
    //   1179: aconst_null
    //   1180: astore 10
    //   1182: aload 10
    //   1184: astore 11
    //   1186: aload 11
    //   1188: astore 9
    //   1190: aload 9
    //   1192: astore_1
    //   1193: aload 8
    //   1195: astore 14
    //   1197: goto +340 -> 1537
    //   1200: astore 13
    //   1202: aconst_null
    //   1203: astore 10
    //   1205: aload 10
    //   1207: astore 11
    //   1209: aload 11
    //   1211: astore 9
    //   1213: aload 9
    //   1215: astore_1
    //   1216: aload 8
    //   1218: astore 14
    //   1220: goto +608 -> 1828
    //   1223: astore 13
    //   1225: aconst_null
    //   1226: astore 10
    //   1228: aload 10
    //   1230: astore 11
    //   1232: aload 11
    //   1234: astore 9
    //   1236: aload 9
    //   1238: astore_1
    //   1239: aload 8
    //   1241: astore 14
    //   1243: goto +876 -> 2119
    //   1246: astore_1
    //   1247: aconst_null
    //   1248: astore_2
    //   1249: aload_2
    //   1250: astore 9
    //   1252: aload 9
    //   1254: astore 8
    //   1256: aload 11
    //   1258: astore 10
    //   1260: goto +1293 -> 2553
    //   1263: astore 13
    //   1265: aconst_null
    //   1266: astore 10
    //   1268: aload 10
    //   1270: astore 11
    //   1272: aload 11
    //   1274: astore 9
    //   1276: aload 9
    //   1278: astore 14
    //   1280: aload 14
    //   1282: astore_1
    //   1283: aload 10
    //   1285: astore_2
    //   1286: aload 11
    //   1288: astore_3
    //   1289: aload 9
    //   1291: astore 4
    //   1293: aload 14
    //   1295: astore 8
    //   1297: aload 13
    //   1299: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
    //   1302: aload 10
    //   1304: astore_2
    //   1305: aload 11
    //   1307: astore_3
    //   1308: aload 9
    //   1310: astore 4
    //   1312: aload 14
    //   1314: astore 8
    //   1316: aload_0
    //   1317: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1320: astore 16
    //   1322: aload 10
    //   1324: astore_2
    //   1325: aload 11
    //   1327: astore_3
    //   1328: aload 9
    //   1330: astore 4
    //   1332: aload 14
    //   1334: astore 8
    //   1336: new 91	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1343: astore 17
    //   1345: aload 10
    //   1347: astore_2
    //   1348: aload 11
    //   1350: astore_3
    //   1351: aload 9
    //   1353: astore 4
    //   1355: aload 14
    //   1357: astore 8
    //   1359: aload 17
    //   1361: aload 13
    //   1363: invokevirtual 360	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1366: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: pop
    //   1370: aload 10
    //   1372: astore_2
    //   1373: aload 11
    //   1375: astore_3
    //   1376: aload 9
    //   1378: astore 4
    //   1380: aload 14
    //   1382: astore 8
    //   1384: aload 17
    //   1386: ldc_w 362
    //   1389: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: pop
    //   1393: aload 10
    //   1395: astore_2
    //   1396: aload 11
    //   1398: astore_3
    //   1399: aload 9
    //   1401: astore 4
    //   1403: aload 14
    //   1405: astore 8
    //   1407: aload 17
    //   1409: aload 13
    //   1411: invokevirtual 363	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1414: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 10
    //   1420: astore_2
    //   1421: aload 11
    //   1423: astore_3
    //   1424: aload 9
    //   1426: astore 4
    //   1428: aload 14
    //   1430: astore 8
    //   1432: aload 16
    //   1434: sipush 10003
    //   1437: aload 17
    //   1439: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: aconst_null
    //   1443: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1446: aload 10
    //   1448: ifnull +16 -> 1464
    //   1451: aload 10
    //   1453: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   1456: goto +8 -> 1464
    //   1459: astore_2
    //   1460: aload_2
    //   1461: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1464: aload 11
    //   1466: ifnull +16 -> 1482
    //   1469: aload 11
    //   1471: invokevirtual 354	java/io/InputStream:close	()V
    //   1474: goto +8 -> 1482
    //   1477: astore_2
    //   1478: aload_2
    //   1479: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1482: aload 9
    //   1484: ifnull +16 -> 1500
    //   1487: aload 9
    //   1489: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   1492: goto +8 -> 1500
    //   1495: astore_2
    //   1496: aload_2
    //   1497: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1500: aload_1
    //   1501: astore_2
    //   1502: aload 14
    //   1504: ifnull +912 -> 2416
    //   1507: aload 14
    //   1509: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   1512: aload_1
    //   1513: astore_2
    //   1514: goto +902 -> 2416
    //   1517: astore 13
    //   1519: aconst_null
    //   1520: astore 10
    //   1522: aload 10
    //   1524: astore 11
    //   1526: aload 11
    //   1528: astore 9
    //   1530: aload 9
    //   1532: astore 14
    //   1534: aload 14
    //   1536: astore_1
    //   1537: aload 10
    //   1539: astore_2
    //   1540: aload 11
    //   1542: astore_3
    //   1543: aload 9
    //   1545: astore 4
    //   1547: aload 14
    //   1549: astore 8
    //   1551: aload 13
    //   1553: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1556: aload 10
    //   1558: astore_2
    //   1559: aload 11
    //   1561: astore_3
    //   1562: aload 9
    //   1564: astore 4
    //   1566: aload 14
    //   1568: astore 8
    //   1570: aload_0
    //   1571: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1574: astore 16
    //   1576: aload 10
    //   1578: astore_2
    //   1579: aload 11
    //   1581: astore_3
    //   1582: aload 9
    //   1584: astore 4
    //   1586: aload 14
    //   1588: astore 8
    //   1590: new 91	java/lang/StringBuilder
    //   1593: dup
    //   1594: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1597: astore 17
    //   1599: aload 10
    //   1601: astore_2
    //   1602: aload 11
    //   1604: astore_3
    //   1605: aload 9
    //   1607: astore 4
    //   1609: aload 14
    //   1611: astore 8
    //   1613: aload 17
    //   1615: aload 13
    //   1617: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1620: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: pop
    //   1624: aload 10
    //   1626: astore_2
    //   1627: aload 11
    //   1629: astore_3
    //   1630: aload 9
    //   1632: astore 4
    //   1634: aload 14
    //   1636: astore 8
    //   1638: aload 17
    //   1640: ldc_w 362
    //   1643: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1646: pop
    //   1647: aload 10
    //   1649: astore_2
    //   1650: aload 11
    //   1652: astore_3
    //   1653: aload 9
    //   1655: astore 4
    //   1657: aload 14
    //   1659: astore 8
    //   1661: aload 17
    //   1663: aload 13
    //   1665: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1668: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: pop
    //   1672: aload 10
    //   1674: astore_2
    //   1675: aload 11
    //   1677: astore_3
    //   1678: aload 9
    //   1680: astore 4
    //   1682: aload 14
    //   1684: astore 8
    //   1686: aload 16
    //   1688: sipush 10003
    //   1691: aload 17
    //   1693: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1696: aconst_null
    //   1697: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1700: aload 10
    //   1702: astore_2
    //   1703: aload 11
    //   1705: astore_3
    //   1706: aload 9
    //   1708: astore 4
    //   1710: aload 14
    //   1712: astore 8
    //   1714: aload 13
    //   1716: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1719: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   1722: aload 10
    //   1724: astore_2
    //   1725: aload 11
    //   1727: astore_3
    //   1728: aload 9
    //   1730: astore 4
    //   1732: aload 14
    //   1734: astore 8
    //   1736: aload 13
    //   1738: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1741: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1744: aload 10
    //   1746: ifnull +16 -> 1762
    //   1749: aload 10
    //   1751: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   1754: goto +8 -> 1762
    //   1757: astore_2
    //   1758: aload_2
    //   1759: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1762: aload 11
    //   1764: ifnull +16 -> 1780
    //   1767: aload 11
    //   1769: invokevirtual 354	java/io/InputStream:close	()V
    //   1772: goto +8 -> 1780
    //   1775: astore_2
    //   1776: aload_2
    //   1777: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1780: aload 9
    //   1782: ifnull +16 -> 1798
    //   1785: aload 9
    //   1787: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   1790: goto +8 -> 1798
    //   1793: astore_2
    //   1794: aload_2
    //   1795: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1798: aload_1
    //   1799: astore_2
    //   1800: aload 14
    //   1802: ifnull +614 -> 2416
    //   1805: goto -298 -> 1507
    //   1808: astore 13
    //   1810: aconst_null
    //   1811: astore 10
    //   1813: aload 10
    //   1815: astore 11
    //   1817: aload 11
    //   1819: astore 9
    //   1821: aload 9
    //   1823: astore 14
    //   1825: aload 14
    //   1827: astore_1
    //   1828: aload 10
    //   1830: astore_2
    //   1831: aload 11
    //   1833: astore_3
    //   1834: aload 9
    //   1836: astore 4
    //   1838: aload 14
    //   1840: astore 8
    //   1842: aload 13
    //   1844: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1847: aload 10
    //   1849: astore_2
    //   1850: aload 11
    //   1852: astore_3
    //   1853: aload 9
    //   1855: astore 4
    //   1857: aload 14
    //   1859: astore 8
    //   1861: aload_0
    //   1862: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1865: astore 16
    //   1867: aload 10
    //   1869: astore_2
    //   1870: aload 11
    //   1872: astore_3
    //   1873: aload 9
    //   1875: astore 4
    //   1877: aload 14
    //   1879: astore 8
    //   1881: new 91	java/lang/StringBuilder
    //   1884: dup
    //   1885: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1888: astore 17
    //   1890: aload 10
    //   1892: astore_2
    //   1893: aload 11
    //   1895: astore_3
    //   1896: aload 9
    //   1898: astore 4
    //   1900: aload 14
    //   1902: astore 8
    //   1904: aload 17
    //   1906: aload 13
    //   1908: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   1911: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload 10
    //   1917: astore_2
    //   1918: aload 11
    //   1920: astore_3
    //   1921: aload 9
    //   1923: astore 4
    //   1925: aload 14
    //   1927: astore 8
    //   1929: aload 17
    //   1931: ldc_w 362
    //   1934: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: pop
    //   1938: aload 10
    //   1940: astore_2
    //   1941: aload 11
    //   1943: astore_3
    //   1944: aload 9
    //   1946: astore 4
    //   1948: aload 14
    //   1950: astore 8
    //   1952: aload 17
    //   1954: aload 13
    //   1956: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1959: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: pop
    //   1963: aload 10
    //   1965: astore_2
    //   1966: aload 11
    //   1968: astore_3
    //   1969: aload 9
    //   1971: astore 4
    //   1973: aload 14
    //   1975: astore 8
    //   1977: aload 16
    //   1979: sipush 10003
    //   1982: aload 17
    //   1984: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1987: aconst_null
    //   1988: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1991: aload 10
    //   1993: astore_2
    //   1994: aload 11
    //   1996: astore_3
    //   1997: aload 9
    //   1999: astore 4
    //   2001: aload 14
    //   2003: astore 8
    //   2005: aload 13
    //   2007: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   2010: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   2013: aload 10
    //   2015: astore_2
    //   2016: aload 11
    //   2018: astore_3
    //   2019: aload 9
    //   2021: astore 4
    //   2023: aload 14
    //   2025: astore 8
    //   2027: aload 13
    //   2029: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   2032: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2035: aload 10
    //   2037: ifnull +16 -> 2053
    //   2040: aload 10
    //   2042: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2045: goto +8 -> 2053
    //   2048: astore_2
    //   2049: aload_2
    //   2050: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2053: aload 11
    //   2055: ifnull +16 -> 2071
    //   2058: aload 11
    //   2060: invokevirtual 354	java/io/InputStream:close	()V
    //   2063: goto +8 -> 2071
    //   2066: astore_2
    //   2067: aload_2
    //   2068: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2071: aload 9
    //   2073: ifnull +16 -> 2089
    //   2076: aload 9
    //   2078: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2081: goto +8 -> 2089
    //   2084: astore_2
    //   2085: aload_2
    //   2086: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2089: aload_1
    //   2090: astore_2
    //   2091: aload 14
    //   2093: ifnull +323 -> 2416
    //   2096: goto -589 -> 1507
    //   2099: astore 13
    //   2101: aconst_null
    //   2102: astore 10
    //   2104: aload 10
    //   2106: astore 11
    //   2108: aload 11
    //   2110: astore 9
    //   2112: aload 9
    //   2114: astore 14
    //   2116: aload 14
    //   2118: astore_1
    //   2119: aload 10
    //   2121: astore_2
    //   2122: aload 11
    //   2124: astore_3
    //   2125: aload 9
    //   2127: astore 4
    //   2129: aload 14
    //   2131: astore 8
    //   2133: aload 13
    //   2135: invokevirtual 365	java/net/SocketTimeoutException:printStackTrace	()V
    //   2138: aload 10
    //   2140: astore_2
    //   2141: aload 11
    //   2143: astore_3
    //   2144: aload 9
    //   2146: astore 4
    //   2148: aload 14
    //   2150: astore 8
    //   2152: aload_0
    //   2153: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   2156: astore 16
    //   2158: aload 10
    //   2160: astore_2
    //   2161: aload 11
    //   2163: astore_3
    //   2164: aload 9
    //   2166: astore 4
    //   2168: aload 14
    //   2170: astore 8
    //   2172: new 91	java/lang/StringBuilder
    //   2175: dup
    //   2176: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   2179: astore 17
    //   2181: aload 10
    //   2183: astore_2
    //   2184: aload 11
    //   2186: astore_3
    //   2187: aload 9
    //   2189: astore 4
    //   2191: aload 14
    //   2193: astore 8
    //   2195: aload 17
    //   2197: aload 13
    //   2199: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2202: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: pop
    //   2206: aload 10
    //   2208: astore_2
    //   2209: aload 11
    //   2211: astore_3
    //   2212: aload 9
    //   2214: astore 4
    //   2216: aload 14
    //   2218: astore 8
    //   2220: aload 17
    //   2222: ldc_w 362
    //   2225: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2228: pop
    //   2229: aload 10
    //   2231: astore_2
    //   2232: aload 11
    //   2234: astore_3
    //   2235: aload 9
    //   2237: astore 4
    //   2239: aload 14
    //   2241: astore 8
    //   2243: aload 17
    //   2245: aload 13
    //   2247: invokevirtual 367	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   2250: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: pop
    //   2254: aload 10
    //   2256: astore_2
    //   2257: aload 11
    //   2259: astore_3
    //   2260: aload 9
    //   2262: astore 4
    //   2264: aload 14
    //   2266: astore 8
    //   2268: aload 16
    //   2270: sipush 10002
    //   2273: aload 17
    //   2275: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2278: aconst_null
    //   2279: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2282: aload 10
    //   2284: astore_2
    //   2285: aload 11
    //   2287: astore_3
    //   2288: aload 9
    //   2290: astore 4
    //   2292: aload 14
    //   2294: astore 8
    //   2296: invokestatic 372	com/tencent/token/sb:a	()Lcom/tencent/token/sb;
    //   2299: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   2302: getstatic 89	com/tencent/token/ajn:f	I
    //   2305: invokevirtual 381	com/tencent/token/sb:a	(JI)V
    //   2308: aload 10
    //   2310: astore_2
    //   2311: aload 11
    //   2313: astore_3
    //   2314: aload 9
    //   2316: astore 4
    //   2318: aload 14
    //   2320: astore 8
    //   2322: aload 13
    //   2324: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2327: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   2330: aload 10
    //   2332: astore_2
    //   2333: aload 11
    //   2335: astore_3
    //   2336: aload 9
    //   2338: astore 4
    //   2340: aload 14
    //   2342: astore 8
    //   2344: aload 13
    //   2346: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2349: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2352: aload 10
    //   2354: ifnull +16 -> 2370
    //   2357: aload 10
    //   2359: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2362: goto +8 -> 2370
    //   2365: astore_2
    //   2366: aload_2
    //   2367: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2370: aload 11
    //   2372: ifnull +16 -> 2388
    //   2375: aload 11
    //   2377: invokevirtual 354	java/io/InputStream:close	()V
    //   2380: goto +8 -> 2388
    //   2383: astore_2
    //   2384: aload_2
    //   2385: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2388: aload 9
    //   2390: ifnull +16 -> 2406
    //   2393: aload 9
    //   2395: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2398: goto +8 -> 2406
    //   2401: astore_2
    //   2402: aload_2
    //   2403: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2406: aload_1
    //   2407: astore_2
    //   2408: aload 14
    //   2410: ifnull +6 -> 2416
    //   2413: goto -906 -> 1507
    //   2416: new 91	java/lang/StringBuilder
    //   2419: dup
    //   2420: ldc_w 383
    //   2423: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2426: astore_1
    //   2427: aload_1
    //   2428: aload 15
    //   2430: invokevirtual 385	com/tencent/token/aan:a	()J
    //   2433: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2436: pop
    //   2437: aload_1
    //   2438: ldc_w 390
    //   2441: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2444: pop
    //   2445: aload_1
    //   2446: aload 12
    //   2448: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: pop
    //   2452: aload_1
    //   2453: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2456: invokestatic 327	com/tencent/token/xj:b	(Ljava/lang/String;)V
    //   2459: new 91	java/lang/StringBuilder
    //   2462: dup
    //   2463: ldc_w 383
    //   2466: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2469: astore_1
    //   2470: aload_1
    //   2471: aload 15
    //   2473: invokevirtual 385	com/tencent/token/aan:a	()J
    //   2476: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2479: pop
    //   2480: aload_1
    //   2481: ldc_w 390
    //   2484: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: pop
    //   2488: aload 12
    //   2490: ldc_w 306
    //   2493: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2496: iconst_m1
    //   2497: if_icmpne +6 -> 2503
    //   2500: goto +19 -> 2519
    //   2503: aload 12
    //   2505: iconst_0
    //   2506: aload 12
    //   2508: ldc_w 306
    //   2511: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2514: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   2517: astore 12
    //   2519: aload_1
    //   2520: aload 12
    //   2522: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2525: pop
    //   2526: aload_1
    //   2527: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2530: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2533: aload_2
    //   2534: areturn
    //   2535: astore 9
    //   2537: aload_3
    //   2538: astore_1
    //   2539: aload 9
    //   2541: astore_3
    //   2542: aload_2
    //   2543: astore 10
    //   2545: aload 4
    //   2547: astore 9
    //   2549: aload_1
    //   2550: astore_2
    //   2551: aload_3
    //   2552: astore_1
    //   2553: aload 10
    //   2555: ifnull +16 -> 2571
    //   2558: aload 10
    //   2560: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2563: goto +8 -> 2571
    //   2566: astore_3
    //   2567: aload_3
    //   2568: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2571: aload_2
    //   2572: ifnull +15 -> 2587
    //   2575: aload_2
    //   2576: invokevirtual 354	java/io/InputStream:close	()V
    //   2579: goto +8 -> 2587
    //   2582: astore_2
    //   2583: aload_2
    //   2584: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2587: aload 9
    //   2589: ifnull +16 -> 2605
    //   2592: aload 9
    //   2594: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2597: goto +8 -> 2605
    //   2600: astore_2
    //   2601: aload_2
    //   2602: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2605: aload 8
    //   2607: ifnull +8 -> 2615
    //   2610: aload 8
    //   2612: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   2615: aload_1
    //   2616: athrow
    //   2617: aconst_null
    //   2618: astore 10
    //   2620: goto -2447 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2623	0	this	ajn
    //   0	2623	1	paramString1	String
    //   0	2623	2	paramString2	String
    //   0	2623	3	paramString3	String
    //   0	2623	4	paramArrayOfByte	byte[]
    //   332	464	5	i	int
    //   134	29	6	l	long
    //   24	2587	8	localObject1	Object
    //   68	682	9	localObject2	Object
    //   899	6	9	localThrowable1	java.lang.Throwable
    //   916	6	9	localException1	Exception
    //   933	6	9	localIOException1	IOException
    //   950	6	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   969	1425	9	localObject3	Object
    //   2535	5	9	localObject4	Object
    //   2547	46	9	arrayOfByte	byte[]
    //   111	2508	10	localObject5	Object
    //   13	2363	11	localObject6	Object
    //   1	2520	12	str1	String
    //   16	1	13	localObject7	Object
    //   251	1	13	localThrowable2	java.lang.Throwable
    //   270	1	13	localException2	Exception
    //   289	1	13	localIOException2	IOException
    //   308	542	13	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1035	67	13	str2	String
    //   1154	1	13	localThrowable3	java.lang.Throwable
    //   1177	1	13	localException3	Exception
    //   1200	1	13	localIOException3	IOException
    //   1223	1	13	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1263	147	13	localThrowable4	java.lang.Throwable
    //   1517	220	13	localException4	Exception
    //   1808	220	13	localIOException4	IOException
    //   2099	246	13	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   265	2144	14	localObject8	Object
    //   10	2462	15	localaan	aan
    //   1320	949	16	localxh	xh
    //   1343	931	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   193	199	241	finally
    //   204	228	241	finally
    //   228	238	241	finally
    //   193	199	251	java/lang/Throwable
    //   204	228	251	java/lang/Throwable
    //   228	238	251	java/lang/Throwable
    //   193	199	270	java/lang/Exception
    //   204	228	270	java/lang/Exception
    //   228	238	270	java/lang/Exception
    //   193	199	289	java/io/IOException
    //   204	228	289	java/io/IOException
    //   228	238	289	java/io/IOException
    //   193	199	308	java/net/SocketTimeoutException
    //   204	228	308	java/net/SocketTimeoutException
    //   228	238	308	java/net/SocketTimeoutException
    //   856	860	863	java/lang/Exception
    //   873	878	881	java/lang/Exception
    //   816	821	899	java/lang/Throwable
    //   824	832	899	java/lang/Throwable
    //   837	849	899	java/lang/Throwable
    //   816	821	916	java/lang/Exception
    //   824	832	916	java/lang/Exception
    //   837	849	916	java/lang/Exception
    //   816	821	933	java/io/IOException
    //   824	832	933	java/io/IOException
    //   837	849	933	java/io/IOException
    //   816	821	950	java/net/SocketTimeoutException
    //   824	832	950	java/net/SocketTimeoutException
    //   837	849	950	java/net/SocketTimeoutException
    //   781	788	967	finally
    //   794	800	967	finally
    //   803	812	967	finally
    //   816	821	967	finally
    //   824	832	967	finally
    //   837	849	967	finally
    //   781	788	983	java/lang/Throwable
    //   794	800	983	java/lang/Throwable
    //   803	812	983	java/lang/Throwable
    //   781	788	990	java/lang/Exception
    //   794	800	990	java/lang/Exception
    //   803	812	990	java/lang/Exception
    //   781	788	997	java/io/IOException
    //   794	800	997	java/io/IOException
    //   803	812	997	java/io/IOException
    //   781	788	1004	java/net/SocketTimeoutException
    //   794	800	1004	java/net/SocketTimeoutException
    //   803	812	1004	java/net/SocketTimeoutException
    //   773	781	1011	finally
    //   773	781	1025	java/lang/Throwable
    //   773	781	1047	java/lang/Exception
    //   773	781	1069	java/io/IOException
    //   773	781	1091	java/net/SocketTimeoutException
    //   47	54	1141	finally
    //   59	170	1141	finally
    //   173	193	1141	finally
    //   327	382	1141	finally
    //   407	492	1141	finally
    //   498	513	1141	finally
    //   513	541	1141	finally
    //   553	560	1141	finally
    //   573	580	1141	finally
    //   580	698	1141	finally
    //   705	721	1141	finally
    //   721	761	1141	finally
    //   764	770	1141	finally
    //   1113	1129	1141	finally
    //   47	54	1154	java/lang/Throwable
    //   59	170	1154	java/lang/Throwable
    //   173	193	1154	java/lang/Throwable
    //   327	382	1154	java/lang/Throwable
    //   407	492	1154	java/lang/Throwable
    //   498	513	1154	java/lang/Throwable
    //   513	541	1154	java/lang/Throwable
    //   553	560	1154	java/lang/Throwable
    //   573	580	1154	java/lang/Throwable
    //   580	698	1154	java/lang/Throwable
    //   705	721	1154	java/lang/Throwable
    //   721	761	1154	java/lang/Throwable
    //   764	770	1154	java/lang/Throwable
    //   1113	1129	1154	java/lang/Throwable
    //   47	54	1177	java/lang/Exception
    //   59	170	1177	java/lang/Exception
    //   173	193	1177	java/lang/Exception
    //   327	382	1177	java/lang/Exception
    //   407	492	1177	java/lang/Exception
    //   498	513	1177	java/lang/Exception
    //   513	541	1177	java/lang/Exception
    //   553	560	1177	java/lang/Exception
    //   573	580	1177	java/lang/Exception
    //   580	698	1177	java/lang/Exception
    //   705	721	1177	java/lang/Exception
    //   721	761	1177	java/lang/Exception
    //   764	770	1177	java/lang/Exception
    //   1113	1129	1177	java/lang/Exception
    //   47	54	1200	java/io/IOException
    //   59	170	1200	java/io/IOException
    //   173	193	1200	java/io/IOException
    //   327	382	1200	java/io/IOException
    //   407	492	1200	java/io/IOException
    //   498	513	1200	java/io/IOException
    //   513	541	1200	java/io/IOException
    //   553	560	1200	java/io/IOException
    //   573	580	1200	java/io/IOException
    //   580	698	1200	java/io/IOException
    //   705	721	1200	java/io/IOException
    //   721	761	1200	java/io/IOException
    //   764	770	1200	java/io/IOException
    //   1113	1129	1200	java/io/IOException
    //   47	54	1223	java/net/SocketTimeoutException
    //   59	170	1223	java/net/SocketTimeoutException
    //   173	193	1223	java/net/SocketTimeoutException
    //   327	382	1223	java/net/SocketTimeoutException
    //   407	492	1223	java/net/SocketTimeoutException
    //   498	513	1223	java/net/SocketTimeoutException
    //   513	541	1223	java/net/SocketTimeoutException
    //   553	560	1223	java/net/SocketTimeoutException
    //   573	580	1223	java/net/SocketTimeoutException
    //   580	698	1223	java/net/SocketTimeoutException
    //   705	721	1223	java/net/SocketTimeoutException
    //   721	761	1223	java/net/SocketTimeoutException
    //   764	770	1223	java/net/SocketTimeoutException
    //   1113	1129	1223	java/net/SocketTimeoutException
    //   18	26	1246	finally
    //   18	26	1263	java/lang/Throwable
    //   1451	1456	1459	java/lang/Exception
    //   1469	1474	1477	java/lang/Exception
    //   1487	1492	1495	java/lang/Exception
    //   18	26	1517	java/lang/Exception
    //   1749	1754	1757	java/lang/Exception
    //   1767	1772	1775	java/lang/Exception
    //   1785	1790	1793	java/lang/Exception
    //   18	26	1808	java/io/IOException
    //   2040	2045	2048	java/lang/Exception
    //   2058	2063	2066	java/lang/Exception
    //   2076	2081	2084	java/lang/Exception
    //   18	26	2099	java/net/SocketTimeoutException
    //   2357	2362	2365	java/lang/Exception
    //   2375	2380	2383	java/lang/Exception
    //   2393	2398	2401	java/lang/Exception
    //   1297	1302	2535	finally
    //   1316	1322	2535	finally
    //   1336	1345	2535	finally
    //   1359	1370	2535	finally
    //   1384	1393	2535	finally
    //   1407	1418	2535	finally
    //   1432	1446	2535	finally
    //   1551	1556	2535	finally
    //   1570	1576	2535	finally
    //   1590	1599	2535	finally
    //   1613	1624	2535	finally
    //   1638	1647	2535	finally
    //   1661	1672	2535	finally
    //   1686	1700	2535	finally
    //   1714	1722	2535	finally
    //   1736	1744	2535	finally
    //   1842	1847	2535	finally
    //   1861	1867	2535	finally
    //   1881	1890	2535	finally
    //   1904	1915	2535	finally
    //   1929	1938	2535	finally
    //   1952	1963	2535	finally
    //   1977	1991	2535	finally
    //   2005	2013	2535	finally
    //   2027	2035	2535	finally
    //   2133	2138	2535	finally
    //   2152	2158	2535	finally
    //   2172	2181	2535	finally
    //   2195	2206	2535	finally
    //   2220	2229	2535	finally
    //   2243	2254	2535	finally
    //   2268	2282	2535	finally
    //   2296	2308	2535	finally
    //   2322	2330	2535	finally
    //   2344	2352	2535	finally
    //   2558	2563	2566	java/lang/Exception
    //   2575	2579	2582	java/lang/Exception
    //   2592	2597	2600	java/lang/Exception
  }
  
  /* Error */
  private byte[] b(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 12
    //   3: new 212	com/tencent/token/aan
    //   6: dup
    //   7: invokespecial 213	com/tencent/token/aan:<init>	()V
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 13
    //   15: aconst_null
    //   16: astore 14
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokespecial 215	com/tencent/token/ajn:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   24: astore 8
    //   26: aload 8
    //   28: ifnonnull +15 -> 43
    //   31: aload 8
    //   33: ifnull +8 -> 41
    //   36: aload 8
    //   38: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_3
    //   44: ifnull +327 -> 371
    //   47: aload_3
    //   48: invokevirtual 221	java/lang/String:length	()I
    //   51: ifle +320 -> 371
    //   54: aload 4
    //   56: ifnull +2601 -> 2657
    //   59: new 91	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 223
    //   65: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: astore 9
    //   70: aload 9
    //   72: aload_3
    //   73: invokevirtual 227	java/lang/String:getBytes	()[B
    //   76: arraylength
    //   77: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 9
    //   83: ldc 229
    //   85: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 9
    //   91: aload 4
    //   93: invokevirtual 394	java/io/File:length	()J
    //   96: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 9
    //   102: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   108: ldc 231
    //   110: invokevirtual 227	java/lang/String:getBytes	()[B
    //   113: astore 10
    //   115: new 396	java/io/FileInputStream
    //   118: dup
    //   119: aload 4
    //   121: invokespecial 399	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: astore 11
    //   126: aload_3
    //   127: invokevirtual 227	java/lang/String:getBytes	()[B
    //   130: arraylength
    //   131: aload 10
    //   133: arraylength
    //   134: iadd
    //   135: i2l
    //   136: aload 4
    //   138: invokevirtual 394	java/io/File:length	()J
    //   141: ladd
    //   142: ldc 233
    //   144: invokevirtual 227	java/lang/String:getBytes	()[B
    //   147: arraylength
    //   148: i2l
    //   149: ladd
    //   150: lstore 6
    //   152: ldc 235
    //   154: lload 6
    //   156: invokestatic 239	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   159: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   162: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   165: aload 8
    //   167: ldc 245
    //   169: ldc 247
    //   171: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 8
    //   176: ldc 253
    //   178: lload 6
    //   180: invokestatic 239	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   183: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto +3 -> 189
    //   189: aload 8
    //   191: iconst_1
    //   192: invokevirtual 257	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   195: new 259	java/io/DataOutputStream
    //   198: dup
    //   199: aload 8
    //   201: invokevirtual 263	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   204: invokespecial 266	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   207: astore 9
    //   209: aload 9
    //   211: aload_3
    //   212: invokevirtual 269	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   215: aload 4
    //   217: ifnull +55 -> 272
    //   220: sipush 1024
    //   223: newarray byte
    //   225: astore 16
    //   227: aload 11
    //   229: aload 16
    //   231: invokevirtual 402	java/io/FileInputStream:read	([B)I
    //   234: istore 5
    //   236: iload 5
    //   238: iconst_m1
    //   239: if_icmpeq +16 -> 255
    //   242: aload 9
    //   244: aload 16
    //   246: iconst_0
    //   247: iload 5
    //   249: invokevirtual 405	java/io/DataOutputStream:write	([BII)V
    //   252: goto -25 -> 227
    //   255: aload 9
    //   257: ldc 233
    //   259: invokevirtual 227	java/lang/String:getBytes	()[B
    //   262: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   265: aload 9
    //   267: aload 10
    //   269: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   272: aload 9
    //   274: invokevirtual 276	java/io/DataOutputStream:flush	()V
    //   277: aload 9
    //   279: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   282: goto +89 -> 371
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_2
    //   288: aload 13
    //   290: astore 10
    //   292: goto +2301 -> 2593
    //   295: astore 13
    //   297: aconst_null
    //   298: astore 10
    //   300: aload 10
    //   302: astore 11
    //   304: aload 11
    //   306: astore_1
    //   307: aload 8
    //   309: astore 14
    //   311: goto +1015 -> 1326
    //   314: astore 13
    //   316: aconst_null
    //   317: astore 10
    //   319: aload 10
    //   321: astore 11
    //   323: aload 11
    //   325: astore_1
    //   326: aload 8
    //   328: astore 14
    //   330: goto +1249 -> 1579
    //   333: astore 13
    //   335: aconst_null
    //   336: astore 10
    //   338: aload 10
    //   340: astore 11
    //   342: aload 11
    //   344: astore_1
    //   345: aload 8
    //   347: astore 14
    //   349: goto +1520 -> 1869
    //   352: astore 13
    //   354: aconst_null
    //   355: astore 10
    //   357: aload 10
    //   359: astore 11
    //   361: aload 11
    //   363: astore_1
    //   364: aload 8
    //   366: astore 14
    //   368: goto +1791 -> 2159
    //   371: aload 8
    //   373: invokevirtual 282	java/net/HttpURLConnection:getResponseCode	()I
    //   376: istore 5
    //   378: new 91	java/lang/StringBuilder
    //   381: dup
    //   382: ldc_w 284
    //   385: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: astore 9
    //   390: aload 9
    //   392: iload 5
    //   394: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 9
    //   400: ldc_w 286
    //   403: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 9
    //   409: aload 12
    //   411: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc_w 288
    //   418: aload 9
    //   420: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 293	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: iload 5
    //   428: sipush 200
    //   431: if_icmpeq +166 -> 597
    //   434: iload 5
    //   436: sipush 206
    //   439: if_icmpeq +158 -> 597
    //   442: iload 5
    //   444: iconst_m1
    //   445: if_icmpne +6 -> 451
    //   448: goto +149 -> 597
    //   451: aload_0
    //   452: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   455: sipush 10005
    //   458: ldc_w 295
    //   461: iload 5
    //   463: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   466: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   469: aconst_null
    //   470: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   473: new 91	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 300
    //   480: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: astore_1
    //   484: aload_1
    //   485: aload 12
    //   487: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_1
    //   492: ldc_w 302
    //   495: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload_1
    //   500: iload 5
    //   502: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_1
    //   507: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   513: new 91	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 304
    //   520: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: astore_2
    //   524: aload 12
    //   526: ldc_w 306
    //   529: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   532: iconst_m1
    //   533: if_icmpne +9 -> 542
    //   536: aload 12
    //   538: astore_1
    //   539: goto +18 -> 557
    //   542: aload 12
    //   544: iconst_0
    //   545: aload 12
    //   547: ldc_w 306
    //   550: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   553: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   556: astore_1
    //   557: aload_2
    //   558: aload_1
    //   559: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_2
    //   564: ldc_w 302
    //   567: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_2
    //   572: iload 5
    //   574: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_2
    //   579: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   585: aconst_null
    //   586: astore 4
    //   588: aload 4
    //   590: astore_1
    //   591: aload 14
    //   593: astore_2
    //   594: goto +302 -> 896
    //   597: aload 8
    //   599: invokevirtual 317	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   602: astore 9
    //   604: aload 9
    //   606: ifnonnull +11 -> 617
    //   609: ldc_w 319
    //   612: astore 9
    //   614: goto +10 -> 624
    //   617: aload 9
    //   619: invokevirtual 171	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   622: astore 9
    //   624: new 91	java/lang/StringBuilder
    //   627: dup
    //   628: ldc_w 321
    //   631: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   634: astore 10
    //   636: aload 10
    //   638: aload 9
    //   640: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 10
    //   646: ldc_w 323
    //   649: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: pop
    //   653: aload 10
    //   655: aload_2
    //   656: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 10
    //   662: ldc_w 325
    //   665: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 10
    //   671: aload 12
    //   673: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 327	com/tencent/token/xj:b	(Ljava/lang/String;)V
    //   685: new 91	java/lang/StringBuilder
    //   688: dup
    //   689: ldc_w 321
    //   692: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   695: astore 11
    //   697: aload 11
    //   699: aload 9
    //   701: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 11
    //   707: ldc_w 323
    //   710: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload 11
    //   716: aload_2
    //   717: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 11
    //   723: ldc_w 325
    //   726: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 12
    //   732: ldc_w 306
    //   735: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   738: iconst_m1
    //   739: if_icmpne +10 -> 749
    //   742: aload 12
    //   744: astore 10
    //   746: goto +19 -> 765
    //   749: aload 12
    //   751: iconst_0
    //   752: aload 12
    //   754: ldc_w 306
    //   757: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   760: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   763: astore 10
    //   765: aload 11
    //   767: aload 10
    //   769: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 11
    //   775: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   781: aload 9
    //   783: ldc_w 329
    //   786: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   789: iconst_m1
    //   790: if_icmpne +367 -> 1157
    //   793: aload 9
    //   795: ldc_w 331
    //   798: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   801: iconst_m1
    //   802: if_icmpeq +6 -> 808
    //   805: goto +352 -> 1157
    //   808: aload 8
    //   810: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   813: astore_2
    //   814: aload_2
    //   815: astore 4
    //   817: new 337	java/io/ByteArrayOutputStream
    //   820: dup
    //   821: invokespecial 338	java/io/ByteArrayOutputStream:<init>	()V
    //   824: astore_1
    //   825: aload 4
    //   827: invokevirtual 343	java/io/InputStream:read	()I
    //   830: istore 5
    //   832: iload 5
    //   834: iconst_m1
    //   835: if_icmpeq +12 -> 847
    //   838: aload_1
    //   839: iload 5
    //   841: invokevirtual 345	java/io/ByteArrayOutputStream:write	(I)V
    //   844: goto -19 -> 825
    //   847: aload_1
    //   848: invokevirtual 346	java/io/ByteArrayOutputStream:flush	()V
    //   851: aload_1
    //   852: invokevirtual 349	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   855: astore_3
    //   856: aload_3
    //   857: ifnull +24 -> 881
    //   860: aload_3
    //   861: arraylength
    //   862: ifgt +6 -> 868
    //   865: goto +16 -> 881
    //   868: aload_0
    //   869: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   872: iconst_0
    //   873: putfield 351	com/tencent/token/xh:a	I
    //   876: aload_3
    //   877: astore_2
    //   878: goto +18 -> 896
    //   881: aload_0
    //   882: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   885: ldc_w 352
    //   888: aconst_null
    //   889: aconst_null
    //   890: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   893: aload 14
    //   895: astore_2
    //   896: aload_1
    //   897: ifnull +15 -> 912
    //   900: aload_1
    //   901: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   904: goto +8 -> 912
    //   907: astore_1
    //   908: aload_1
    //   909: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   912: aload 4
    //   914: ifnull +16 -> 930
    //   917: aload 4
    //   919: invokevirtual 354	java/io/InputStream:close	()V
    //   922: goto +8 -> 930
    //   925: astore_1
    //   926: aload_1
    //   927: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   930: aload 8
    //   932: ifnull +8 -> 940
    //   935: aload 8
    //   937: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   940: goto +1516 -> 2456
    //   943: astore 9
    //   945: aload_3
    //   946: astore 4
    //   948: aload 9
    //   950: astore_3
    //   951: aload_1
    //   952: astore 10
    //   954: aload 4
    //   956: astore_1
    //   957: goto +118 -> 1075
    //   960: astore 9
    //   962: aload_3
    //   963: astore 4
    //   965: aload 9
    //   967: astore_3
    //   968: aload_1
    //   969: astore 10
    //   971: aload 4
    //   973: astore_1
    //   974: goto +123 -> 1097
    //   977: astore 9
    //   979: aload_3
    //   980: astore 4
    //   982: aload 9
    //   984: astore_3
    //   985: aload_1
    //   986: astore 10
    //   988: aload 4
    //   990: astore_1
    //   991: goto +128 -> 1119
    //   994: astore 9
    //   996: aload_3
    //   997: astore 4
    //   999: aload 9
    //   1001: astore_3
    //   1002: aload_1
    //   1003: astore 10
    //   1005: aload 4
    //   1007: astore_1
    //   1008: goto +133 -> 1141
    //   1011: astore_3
    //   1012: aconst_null
    //   1013: astore 9
    //   1015: aload_1
    //   1016: astore_2
    //   1017: aload 4
    //   1019: astore_1
    //   1020: aload 9
    //   1022: astore 4
    //   1024: goto +1558 -> 2582
    //   1027: astore_3
    //   1028: aload_1
    //   1029: astore 10
    //   1031: goto +42 -> 1073
    //   1034: astore_3
    //   1035: aload_1
    //   1036: astore 10
    //   1038: goto +57 -> 1095
    //   1041: astore_3
    //   1042: aload_1
    //   1043: astore 10
    //   1045: goto +72 -> 1117
    //   1048: astore_3
    //   1049: aload_1
    //   1050: astore 10
    //   1052: goto +87 -> 1139
    //   1055: astore_1
    //   1056: aload 4
    //   1058: astore_2
    //   1059: aconst_null
    //   1060: astore 9
    //   1062: aload 13
    //   1064: astore 10
    //   1066: goto +1527 -> 2593
    //   1069: astore_3
    //   1070: aconst_null
    //   1071: astore 10
    //   1073: aconst_null
    //   1074: astore_1
    //   1075: aconst_null
    //   1076: astore 9
    //   1078: aload_3
    //   1079: astore 13
    //   1081: aload_2
    //   1082: astore 11
    //   1084: aload 8
    //   1086: astore 14
    //   1088: goto +238 -> 1326
    //   1091: astore_3
    //   1092: aconst_null
    //   1093: astore 10
    //   1095: aconst_null
    //   1096: astore_1
    //   1097: aconst_null
    //   1098: astore 9
    //   1100: aload_3
    //   1101: astore 13
    //   1103: aload_2
    //   1104: astore 11
    //   1106: aload 8
    //   1108: astore 14
    //   1110: goto +469 -> 1579
    //   1113: astore_3
    //   1114: aconst_null
    //   1115: astore 10
    //   1117: aconst_null
    //   1118: astore_1
    //   1119: aconst_null
    //   1120: astore 9
    //   1122: aload_3
    //   1123: astore 13
    //   1125: aload_2
    //   1126: astore 11
    //   1128: aload 8
    //   1130: astore 14
    //   1132: goto +737 -> 1869
    //   1135: astore_3
    //   1136: aconst_null
    //   1137: astore 10
    //   1139: aconst_null
    //   1140: astore_1
    //   1141: aconst_null
    //   1142: astore 9
    //   1144: aload_3
    //   1145: astore 13
    //   1147: aload_2
    //   1148: astore 11
    //   1150: aload 8
    //   1152: astore 14
    //   1154: goto +1005 -> 2159
    //   1157: ldc_w 356
    //   1160: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1163: aload_0
    //   1164: aload_1
    //   1165: aload_2
    //   1166: aload_3
    //   1167: aload 4
    //   1169: invokespecial 407	com/tencent/token/ajn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)[B
    //   1172: astore_1
    //   1173: aload 8
    //   1175: ifnull +8 -> 1183
    //   1178: aload 8
    //   1180: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   1183: aload_1
    //   1184: areturn
    //   1185: astore_1
    //   1186: aconst_null
    //   1187: astore_2
    //   1188: aload_2
    //   1189: astore 9
    //   1191: aload 13
    //   1193: astore 10
    //   1195: goto +1398 -> 2593
    //   1198: astore 13
    //   1200: aconst_null
    //   1201: astore 10
    //   1203: aload 10
    //   1205: astore 11
    //   1207: aload 11
    //   1209: astore 9
    //   1211: aload 9
    //   1213: astore_1
    //   1214: aload 8
    //   1216: astore 14
    //   1218: goto +108 -> 1326
    //   1221: astore 13
    //   1223: aconst_null
    //   1224: astore 10
    //   1226: aload 10
    //   1228: astore 11
    //   1230: aload 11
    //   1232: astore 9
    //   1234: aload 9
    //   1236: astore_1
    //   1237: aload 8
    //   1239: astore 14
    //   1241: goto +338 -> 1579
    //   1244: astore 13
    //   1246: aconst_null
    //   1247: astore 10
    //   1249: aload 10
    //   1251: astore 11
    //   1253: aload 11
    //   1255: astore 9
    //   1257: aload 9
    //   1259: astore_1
    //   1260: aload 8
    //   1262: astore 14
    //   1264: goto +605 -> 1869
    //   1267: astore 13
    //   1269: aconst_null
    //   1270: astore 10
    //   1272: aload 10
    //   1274: astore 11
    //   1276: aload 11
    //   1278: astore 9
    //   1280: aload 9
    //   1282: astore_1
    //   1283: aload 8
    //   1285: astore 14
    //   1287: goto +872 -> 2159
    //   1290: astore_1
    //   1291: aconst_null
    //   1292: astore_2
    //   1293: aload_2
    //   1294: astore 9
    //   1296: aload 9
    //   1298: astore 8
    //   1300: aload 13
    //   1302: astore 10
    //   1304: goto +1289 -> 2593
    //   1307: astore 13
    //   1309: aconst_null
    //   1310: astore 10
    //   1312: aload 10
    //   1314: astore 11
    //   1316: aload 11
    //   1318: astore 9
    //   1320: aload 9
    //   1322: astore_1
    //   1323: aload_1
    //   1324: astore 14
    //   1326: aload 10
    //   1328: astore_2
    //   1329: aload 11
    //   1331: astore_3
    //   1332: aload 9
    //   1334: astore 4
    //   1336: aload 14
    //   1338: astore 8
    //   1340: aload 13
    //   1342: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
    //   1345: aload 10
    //   1347: astore_2
    //   1348: aload 11
    //   1350: astore_3
    //   1351: aload 9
    //   1353: astore 4
    //   1355: aload 14
    //   1357: astore 8
    //   1359: aload_0
    //   1360: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1363: astore 16
    //   1365: aload 10
    //   1367: astore_2
    //   1368: aload 11
    //   1370: astore_3
    //   1371: aload 9
    //   1373: astore 4
    //   1375: aload 14
    //   1377: astore 8
    //   1379: new 91	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1386: astore 17
    //   1388: aload 10
    //   1390: astore_2
    //   1391: aload 11
    //   1393: astore_3
    //   1394: aload 9
    //   1396: astore 4
    //   1398: aload 14
    //   1400: astore 8
    //   1402: aload 17
    //   1404: aload 13
    //   1406: invokevirtual 360	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1409: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: pop
    //   1413: aload 10
    //   1415: astore_2
    //   1416: aload 11
    //   1418: astore_3
    //   1419: aload 9
    //   1421: astore 4
    //   1423: aload 14
    //   1425: astore 8
    //   1427: aload 17
    //   1429: ldc_w 362
    //   1432: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: aload 10
    //   1438: astore_2
    //   1439: aload 11
    //   1441: astore_3
    //   1442: aload 9
    //   1444: astore 4
    //   1446: aload 14
    //   1448: astore 8
    //   1450: aload 17
    //   1452: aload 13
    //   1454: invokevirtual 363	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1457: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload 10
    //   1463: astore_2
    //   1464: aload 11
    //   1466: astore_3
    //   1467: aload 9
    //   1469: astore 4
    //   1471: aload 14
    //   1473: astore 8
    //   1475: aload 16
    //   1477: sipush 10003
    //   1480: aload 17
    //   1482: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: aconst_null
    //   1486: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1489: aload 10
    //   1491: ifnull +16 -> 1507
    //   1494: aload 10
    //   1496: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   1499: goto +8 -> 1507
    //   1502: astore_2
    //   1503: aload_2
    //   1504: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1507: aload 11
    //   1509: ifnull +16 -> 1525
    //   1512: aload 11
    //   1514: invokevirtual 354	java/io/InputStream:close	()V
    //   1517: goto +8 -> 1525
    //   1520: astore_2
    //   1521: aload_2
    //   1522: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1525: aload 9
    //   1527: ifnull +16 -> 1543
    //   1530: aload 9
    //   1532: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   1535: goto +8 -> 1543
    //   1538: astore_2
    //   1539: aload_2
    //   1540: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1543: aload_1
    //   1544: astore_2
    //   1545: aload 14
    //   1547: ifnull +909 -> 2456
    //   1550: aload 14
    //   1552: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   1555: aload_1
    //   1556: astore_2
    //   1557: goto +899 -> 2456
    //   1560: astore 13
    //   1562: aconst_null
    //   1563: astore 10
    //   1565: aload 10
    //   1567: astore 11
    //   1569: aload 11
    //   1571: astore 9
    //   1573: aload 9
    //   1575: astore_1
    //   1576: aload_1
    //   1577: astore 14
    //   1579: aload 10
    //   1581: astore_2
    //   1582: aload 11
    //   1584: astore_3
    //   1585: aload 9
    //   1587: astore 4
    //   1589: aload 14
    //   1591: astore 8
    //   1593: aload 13
    //   1595: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1598: aload 10
    //   1600: astore_2
    //   1601: aload 11
    //   1603: astore_3
    //   1604: aload 9
    //   1606: astore 4
    //   1608: aload 14
    //   1610: astore 8
    //   1612: aload_0
    //   1613: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1616: astore 16
    //   1618: aload 10
    //   1620: astore_2
    //   1621: aload 11
    //   1623: astore_3
    //   1624: aload 9
    //   1626: astore 4
    //   1628: aload 14
    //   1630: astore 8
    //   1632: new 91	java/lang/StringBuilder
    //   1635: dup
    //   1636: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1639: astore 17
    //   1641: aload 10
    //   1643: astore_2
    //   1644: aload 11
    //   1646: astore_3
    //   1647: aload 9
    //   1649: astore 4
    //   1651: aload 14
    //   1653: astore 8
    //   1655: aload 17
    //   1657: aload 13
    //   1659: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1662: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: pop
    //   1666: aload 10
    //   1668: astore_2
    //   1669: aload 11
    //   1671: astore_3
    //   1672: aload 9
    //   1674: astore 4
    //   1676: aload 14
    //   1678: astore 8
    //   1680: aload 17
    //   1682: ldc_w 362
    //   1685: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload 10
    //   1691: astore_2
    //   1692: aload 11
    //   1694: astore_3
    //   1695: aload 9
    //   1697: astore 4
    //   1699: aload 14
    //   1701: astore 8
    //   1703: aload 17
    //   1705: aload 13
    //   1707: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1710: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload 10
    //   1716: astore_2
    //   1717: aload 11
    //   1719: astore_3
    //   1720: aload 9
    //   1722: astore 4
    //   1724: aload 14
    //   1726: astore 8
    //   1728: aload 16
    //   1730: sipush 10003
    //   1733: aload 17
    //   1735: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: aconst_null
    //   1739: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   1742: aload 10
    //   1744: astore_2
    //   1745: aload 11
    //   1747: astore_3
    //   1748: aload 9
    //   1750: astore 4
    //   1752: aload 14
    //   1754: astore 8
    //   1756: aload 13
    //   1758: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1761: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   1764: aload 10
    //   1766: astore_2
    //   1767: aload 11
    //   1769: astore_3
    //   1770: aload 9
    //   1772: astore 4
    //   1774: aload 14
    //   1776: astore 8
    //   1778: aload 13
    //   1780: invokevirtual 192	java/lang/Exception:toString	()Ljava/lang/String;
    //   1783: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   1786: aload 10
    //   1788: ifnull +16 -> 1804
    //   1791: aload 10
    //   1793: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   1796: goto +8 -> 1804
    //   1799: astore_2
    //   1800: aload_2
    //   1801: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1804: aload 11
    //   1806: ifnull +16 -> 1822
    //   1809: aload 11
    //   1811: invokevirtual 354	java/io/InputStream:close	()V
    //   1814: goto +8 -> 1822
    //   1817: astore_2
    //   1818: aload_2
    //   1819: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1822: aload 9
    //   1824: ifnull +16 -> 1840
    //   1827: aload 9
    //   1829: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   1832: goto +8 -> 1840
    //   1835: astore_2
    //   1836: aload_2
    //   1837: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   1840: aload_1
    //   1841: astore_2
    //   1842: aload 14
    //   1844: ifnull +612 -> 2456
    //   1847: goto -297 -> 1550
    //   1850: astore 13
    //   1852: aconst_null
    //   1853: astore 10
    //   1855: aload 10
    //   1857: astore 11
    //   1859: aload 11
    //   1861: astore 9
    //   1863: aload 9
    //   1865: astore_1
    //   1866: aload_1
    //   1867: astore 14
    //   1869: aload 10
    //   1871: astore_2
    //   1872: aload 11
    //   1874: astore_3
    //   1875: aload 9
    //   1877: astore 4
    //   1879: aload 14
    //   1881: astore 8
    //   1883: aload 13
    //   1885: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   1888: aload 10
    //   1890: astore_2
    //   1891: aload 11
    //   1893: astore_3
    //   1894: aload 9
    //   1896: astore 4
    //   1898: aload 14
    //   1900: astore 8
    //   1902: aload_0
    //   1903: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   1906: astore 16
    //   1908: aload 10
    //   1910: astore_2
    //   1911: aload 11
    //   1913: astore_3
    //   1914: aload 9
    //   1916: astore 4
    //   1918: aload 14
    //   1920: astore 8
    //   1922: new 91	java/lang/StringBuilder
    //   1925: dup
    //   1926: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1929: astore 17
    //   1931: aload 10
    //   1933: astore_2
    //   1934: aload 11
    //   1936: astore_3
    //   1937: aload 9
    //   1939: astore 4
    //   1941: aload 14
    //   1943: astore 8
    //   1945: aload 17
    //   1947: aload 13
    //   1949: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   1952: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload 10
    //   1958: astore_2
    //   1959: aload 11
    //   1961: astore_3
    //   1962: aload 9
    //   1964: astore 4
    //   1966: aload 14
    //   1968: astore 8
    //   1970: aload 17
    //   1972: ldc_w 362
    //   1975: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: pop
    //   1979: aload 10
    //   1981: astore_2
    //   1982: aload 11
    //   1984: astore_3
    //   1985: aload 9
    //   1987: astore 4
    //   1989: aload 14
    //   1991: astore 8
    //   1993: aload 17
    //   1995: aload 13
    //   1997: invokevirtual 202	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2000: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2003: pop
    //   2004: aload 10
    //   2006: astore_2
    //   2007: aload 11
    //   2009: astore_3
    //   2010: aload 9
    //   2012: astore 4
    //   2014: aload 14
    //   2016: astore 8
    //   2018: aload 16
    //   2020: sipush 10003
    //   2023: aload 17
    //   2025: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2028: aconst_null
    //   2029: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2032: aload 10
    //   2034: astore_2
    //   2035: aload 11
    //   2037: astore_3
    //   2038: aload 9
    //   2040: astore 4
    //   2042: aload 14
    //   2044: astore 8
    //   2046: aload 13
    //   2048: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   2051: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   2054: aload 10
    //   2056: astore_2
    //   2057: aload 11
    //   2059: astore_3
    //   2060: aload 9
    //   2062: astore 4
    //   2064: aload 14
    //   2066: astore 8
    //   2068: aload 13
    //   2070: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   2073: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2076: aload 10
    //   2078: ifnull +16 -> 2094
    //   2081: aload 10
    //   2083: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2086: goto +8 -> 2094
    //   2089: astore_2
    //   2090: aload_2
    //   2091: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2094: aload 11
    //   2096: ifnull +16 -> 2112
    //   2099: aload 11
    //   2101: invokevirtual 354	java/io/InputStream:close	()V
    //   2104: goto +8 -> 2112
    //   2107: astore_2
    //   2108: aload_2
    //   2109: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2112: aload 9
    //   2114: ifnull +16 -> 2130
    //   2117: aload 9
    //   2119: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2122: goto +8 -> 2130
    //   2125: astore_2
    //   2126: aload_2
    //   2127: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2130: aload_1
    //   2131: astore_2
    //   2132: aload 14
    //   2134: ifnull +322 -> 2456
    //   2137: goto -587 -> 1550
    //   2140: astore 13
    //   2142: aconst_null
    //   2143: astore 10
    //   2145: aload 10
    //   2147: astore 11
    //   2149: aload 11
    //   2151: astore 9
    //   2153: aload 9
    //   2155: astore_1
    //   2156: aload_1
    //   2157: astore 14
    //   2159: aload 10
    //   2161: astore_2
    //   2162: aload 11
    //   2164: astore_3
    //   2165: aload 9
    //   2167: astore 4
    //   2169: aload 14
    //   2171: astore 8
    //   2173: aload 13
    //   2175: invokevirtual 365	java/net/SocketTimeoutException:printStackTrace	()V
    //   2178: aload 10
    //   2180: astore_2
    //   2181: aload 11
    //   2183: astore_3
    //   2184: aload 9
    //   2186: astore 4
    //   2188: aload 14
    //   2190: astore 8
    //   2192: aload_0
    //   2193: getfield 27	com/tencent/token/ajn:a	Lcom/tencent/token/xh;
    //   2196: astore 16
    //   2198: aload 10
    //   2200: astore_2
    //   2201: aload 11
    //   2203: astore_3
    //   2204: aload 9
    //   2206: astore 4
    //   2208: aload 14
    //   2210: astore 8
    //   2212: new 91	java/lang/StringBuilder
    //   2215: dup
    //   2216: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   2219: astore 17
    //   2221: aload 10
    //   2223: astore_2
    //   2224: aload 11
    //   2226: astore_3
    //   2227: aload 9
    //   2229: astore 4
    //   2231: aload 14
    //   2233: astore 8
    //   2235: aload 17
    //   2237: aload 13
    //   2239: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2242: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: pop
    //   2246: aload 10
    //   2248: astore_2
    //   2249: aload 11
    //   2251: astore_3
    //   2252: aload 9
    //   2254: astore 4
    //   2256: aload 14
    //   2258: astore 8
    //   2260: aload 17
    //   2262: ldc_w 362
    //   2265: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: pop
    //   2269: aload 10
    //   2271: astore_2
    //   2272: aload 11
    //   2274: astore_3
    //   2275: aload 9
    //   2277: astore 4
    //   2279: aload 14
    //   2281: astore 8
    //   2283: aload 17
    //   2285: aload 13
    //   2287: invokevirtual 367	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   2290: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: pop
    //   2294: aload 10
    //   2296: astore_2
    //   2297: aload 11
    //   2299: astore_3
    //   2300: aload 9
    //   2302: astore 4
    //   2304: aload 14
    //   2306: astore 8
    //   2308: aload 16
    //   2310: sipush 10002
    //   2313: aload 17
    //   2315: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2318: aconst_null
    //   2319: invokevirtual 147	com/tencent/token/xh:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   2322: aload 10
    //   2324: astore_2
    //   2325: aload 11
    //   2327: astore_3
    //   2328: aload 9
    //   2330: astore 4
    //   2332: aload 14
    //   2334: astore 8
    //   2336: invokestatic 372	com/tencent/token/sb:a	()Lcom/tencent/token/sb;
    //   2339: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   2342: getstatic 89	com/tencent/token/ajn:f	I
    //   2345: invokevirtual 381	com/tencent/token/sb:a	(JI)V
    //   2348: aload 10
    //   2350: astore_2
    //   2351: aload 11
    //   2353: astore_3
    //   2354: aload 9
    //   2356: astore 4
    //   2358: aload 14
    //   2360: astore 8
    //   2362: aload 13
    //   2364: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2367: invokestatic 112	com/tencent/token/xj:a	(Ljava/lang/String;)V
    //   2370: aload 10
    //   2372: astore_2
    //   2373: aload 11
    //   2375: astore_3
    //   2376: aload 9
    //   2378: astore 4
    //   2380: aload 14
    //   2382: astore 8
    //   2384: aload 13
    //   2386: invokevirtual 366	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2389: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2392: aload 10
    //   2394: ifnull +16 -> 2410
    //   2397: aload 10
    //   2399: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2402: goto +8 -> 2410
    //   2405: astore_2
    //   2406: aload_2
    //   2407: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2410: aload 11
    //   2412: ifnull +16 -> 2428
    //   2415: aload 11
    //   2417: invokevirtual 354	java/io/InputStream:close	()V
    //   2420: goto +8 -> 2428
    //   2423: astore_2
    //   2424: aload_2
    //   2425: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2428: aload 9
    //   2430: ifnull +16 -> 2446
    //   2433: aload 9
    //   2435: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2438: goto +8 -> 2446
    //   2441: astore_2
    //   2442: aload_2
    //   2443: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2446: aload_1
    //   2447: astore_2
    //   2448: aload 14
    //   2450: ifnull +6 -> 2456
    //   2453: goto -903 -> 1550
    //   2456: new 91	java/lang/StringBuilder
    //   2459: dup
    //   2460: ldc_w 383
    //   2463: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2466: astore_1
    //   2467: aload_1
    //   2468: aload 15
    //   2470: invokevirtual 385	com/tencent/token/aan:a	()J
    //   2473: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2476: pop
    //   2477: aload_1
    //   2478: ldc_w 390
    //   2481: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: pop
    //   2485: aload_1
    //   2486: aload 12
    //   2488: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: pop
    //   2492: aload_1
    //   2493: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2496: invokestatic 327	com/tencent/token/xj:b	(Ljava/lang/String;)V
    //   2499: new 91	java/lang/StringBuilder
    //   2502: dup
    //   2503: ldc_w 383
    //   2506: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2509: astore_1
    //   2510: aload_1
    //   2511: aload 15
    //   2513: invokevirtual 385	com/tencent/token/aan:a	()J
    //   2516: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2519: pop
    //   2520: aload_1
    //   2521: ldc_w 390
    //   2524: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: pop
    //   2528: aload 12
    //   2530: ldc_w 306
    //   2533: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2536: iconst_m1
    //   2537: if_icmpne +6 -> 2543
    //   2540: goto +19 -> 2559
    //   2543: aload 12
    //   2545: iconst_0
    //   2546: aload 12
    //   2548: ldc_w 306
    //   2551: invokevirtual 310	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2554: invokevirtual 314	java/lang/String:substring	(II)Ljava/lang/String;
    //   2557: astore 12
    //   2559: aload_1
    //   2560: aload 12
    //   2562: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: pop
    //   2566: aload_1
    //   2567: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2570: invokestatic 114	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   2573: aload_2
    //   2574: areturn
    //   2575: astore 9
    //   2577: aload_3
    //   2578: astore_1
    //   2579: aload 9
    //   2581: astore_3
    //   2582: aload_2
    //   2583: astore 10
    //   2585: aload 4
    //   2587: astore 9
    //   2589: aload_1
    //   2590: astore_2
    //   2591: aload_3
    //   2592: astore_1
    //   2593: aload 10
    //   2595: ifnull +16 -> 2611
    //   2598: aload 10
    //   2600: invokevirtual 353	java/io/ByteArrayOutputStream:close	()V
    //   2603: goto +8 -> 2611
    //   2606: astore_3
    //   2607: aload_3
    //   2608: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2611: aload_2
    //   2612: ifnull +15 -> 2627
    //   2615: aload_2
    //   2616: invokevirtual 354	java/io/InputStream:close	()V
    //   2619: goto +8 -> 2627
    //   2622: astore_2
    //   2623: aload_2
    //   2624: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2627: aload 9
    //   2629: ifnull +16 -> 2645
    //   2632: aload 9
    //   2634: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   2637: goto +8 -> 2645
    //   2640: astore_2
    //   2641: aload_2
    //   2642: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   2645: aload 8
    //   2647: ifnull +8 -> 2655
    //   2650: aload 8
    //   2652: invokevirtual 218	java/net/HttpURLConnection:disconnect	()V
    //   2655: aload_1
    //   2656: athrow
    //   2657: aconst_null
    //   2658: astore 10
    //   2660: aload 10
    //   2662: astore 11
    //   2664: goto -2475 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2667	0	this	ajn
    //   0	2667	1	paramString1	String
    //   0	2667	2	paramString2	String
    //   0	2667	3	paramString3	String
    //   0	2667	4	paramFile	File
    //   234	606	5	i	int
    //   150	29	6	l	long
    //   24	2627	8	localObject1	Object
    //   68	726	9	localObject2	Object
    //   943	6	9	localThrowable1	java.lang.Throwable
    //   960	6	9	localException1	Exception
    //   977	6	9	localIOException1	IOException
    //   994	6	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1013	1421	9	localObject3	Object
    //   2575	5	9	localObject4	Object
    //   2587	46	9	localFile	File
    //   113	2548	10	localObject5	Object
    //   124	2539	11	localObject6	Object
    //   1	2560	12	str1	String
    //   13	276	13	localObject7	Object
    //   295	1	13	localThrowable2	java.lang.Throwable
    //   314	1	13	localException2	Exception
    //   333	1	13	localIOException2	IOException
    //   352	711	13	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1079	113	13	str2	String
    //   1198	1	13	localThrowable3	java.lang.Throwable
    //   1221	1	13	localException3	Exception
    //   1244	1	13	localIOException3	IOException
    //   1267	34	13	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1307	146	13	localThrowable4	java.lang.Throwable
    //   1560	219	13	localException4	Exception
    //   1850	219	13	localIOException4	IOException
    //   2140	245	13	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   16	2433	14	localObject8	Object
    //   10	2502	15	localaan	aan
    //   225	2084	16	localObject9	Object
    //   1386	928	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   209	215	285	finally
    //   220	227	285	finally
    //   227	236	285	finally
    //   242	252	285	finally
    //   255	272	285	finally
    //   272	282	285	finally
    //   209	215	295	java/lang/Throwable
    //   220	227	295	java/lang/Throwable
    //   227	236	295	java/lang/Throwable
    //   242	252	295	java/lang/Throwable
    //   255	272	295	java/lang/Throwable
    //   272	282	295	java/lang/Throwable
    //   209	215	314	java/lang/Exception
    //   220	227	314	java/lang/Exception
    //   227	236	314	java/lang/Exception
    //   242	252	314	java/lang/Exception
    //   255	272	314	java/lang/Exception
    //   272	282	314	java/lang/Exception
    //   209	215	333	java/io/IOException
    //   220	227	333	java/io/IOException
    //   227	236	333	java/io/IOException
    //   242	252	333	java/io/IOException
    //   255	272	333	java/io/IOException
    //   272	282	333	java/io/IOException
    //   209	215	352	java/net/SocketTimeoutException
    //   220	227	352	java/net/SocketTimeoutException
    //   227	236	352	java/net/SocketTimeoutException
    //   242	252	352	java/net/SocketTimeoutException
    //   255	272	352	java/net/SocketTimeoutException
    //   272	282	352	java/net/SocketTimeoutException
    //   900	904	907	java/lang/Exception
    //   917	922	925	java/lang/Exception
    //   860	865	943	java/lang/Throwable
    //   868	876	943	java/lang/Throwable
    //   881	893	943	java/lang/Throwable
    //   860	865	960	java/lang/Exception
    //   868	876	960	java/lang/Exception
    //   881	893	960	java/lang/Exception
    //   860	865	977	java/io/IOException
    //   868	876	977	java/io/IOException
    //   881	893	977	java/io/IOException
    //   860	865	994	java/net/SocketTimeoutException
    //   868	876	994	java/net/SocketTimeoutException
    //   881	893	994	java/net/SocketTimeoutException
    //   825	832	1011	finally
    //   838	844	1011	finally
    //   847	856	1011	finally
    //   860	865	1011	finally
    //   868	876	1011	finally
    //   881	893	1011	finally
    //   825	832	1027	java/lang/Throwable
    //   838	844	1027	java/lang/Throwable
    //   847	856	1027	java/lang/Throwable
    //   825	832	1034	java/lang/Exception
    //   838	844	1034	java/lang/Exception
    //   847	856	1034	java/lang/Exception
    //   825	832	1041	java/io/IOException
    //   838	844	1041	java/io/IOException
    //   847	856	1041	java/io/IOException
    //   825	832	1048	java/net/SocketTimeoutException
    //   838	844	1048	java/net/SocketTimeoutException
    //   847	856	1048	java/net/SocketTimeoutException
    //   817	825	1055	finally
    //   817	825	1069	java/lang/Throwable
    //   817	825	1091	java/lang/Exception
    //   817	825	1113	java/io/IOException
    //   817	825	1135	java/net/SocketTimeoutException
    //   47	54	1185	finally
    //   59	186	1185	finally
    //   189	209	1185	finally
    //   371	426	1185	finally
    //   451	536	1185	finally
    //   542	557	1185	finally
    //   557	585	1185	finally
    //   597	604	1185	finally
    //   617	624	1185	finally
    //   624	742	1185	finally
    //   749	765	1185	finally
    //   765	805	1185	finally
    //   808	814	1185	finally
    //   1157	1173	1185	finally
    //   47	54	1198	java/lang/Throwable
    //   59	186	1198	java/lang/Throwable
    //   189	209	1198	java/lang/Throwable
    //   371	426	1198	java/lang/Throwable
    //   451	536	1198	java/lang/Throwable
    //   542	557	1198	java/lang/Throwable
    //   557	585	1198	java/lang/Throwable
    //   597	604	1198	java/lang/Throwable
    //   617	624	1198	java/lang/Throwable
    //   624	742	1198	java/lang/Throwable
    //   749	765	1198	java/lang/Throwable
    //   765	805	1198	java/lang/Throwable
    //   808	814	1198	java/lang/Throwable
    //   1157	1173	1198	java/lang/Throwable
    //   47	54	1221	java/lang/Exception
    //   59	186	1221	java/lang/Exception
    //   189	209	1221	java/lang/Exception
    //   371	426	1221	java/lang/Exception
    //   451	536	1221	java/lang/Exception
    //   542	557	1221	java/lang/Exception
    //   557	585	1221	java/lang/Exception
    //   597	604	1221	java/lang/Exception
    //   617	624	1221	java/lang/Exception
    //   624	742	1221	java/lang/Exception
    //   749	765	1221	java/lang/Exception
    //   765	805	1221	java/lang/Exception
    //   808	814	1221	java/lang/Exception
    //   1157	1173	1221	java/lang/Exception
    //   47	54	1244	java/io/IOException
    //   59	186	1244	java/io/IOException
    //   189	209	1244	java/io/IOException
    //   371	426	1244	java/io/IOException
    //   451	536	1244	java/io/IOException
    //   542	557	1244	java/io/IOException
    //   557	585	1244	java/io/IOException
    //   597	604	1244	java/io/IOException
    //   617	624	1244	java/io/IOException
    //   624	742	1244	java/io/IOException
    //   749	765	1244	java/io/IOException
    //   765	805	1244	java/io/IOException
    //   808	814	1244	java/io/IOException
    //   1157	1173	1244	java/io/IOException
    //   47	54	1267	java/net/SocketTimeoutException
    //   59	186	1267	java/net/SocketTimeoutException
    //   189	209	1267	java/net/SocketTimeoutException
    //   371	426	1267	java/net/SocketTimeoutException
    //   451	536	1267	java/net/SocketTimeoutException
    //   542	557	1267	java/net/SocketTimeoutException
    //   557	585	1267	java/net/SocketTimeoutException
    //   597	604	1267	java/net/SocketTimeoutException
    //   617	624	1267	java/net/SocketTimeoutException
    //   624	742	1267	java/net/SocketTimeoutException
    //   749	765	1267	java/net/SocketTimeoutException
    //   765	805	1267	java/net/SocketTimeoutException
    //   808	814	1267	java/net/SocketTimeoutException
    //   1157	1173	1267	java/net/SocketTimeoutException
    //   18	26	1290	finally
    //   18	26	1307	java/lang/Throwable
    //   1494	1499	1502	java/lang/Exception
    //   1512	1517	1520	java/lang/Exception
    //   1530	1535	1538	java/lang/Exception
    //   18	26	1560	java/lang/Exception
    //   1791	1796	1799	java/lang/Exception
    //   1809	1814	1817	java/lang/Exception
    //   1827	1832	1835	java/lang/Exception
    //   18	26	1850	java/io/IOException
    //   2081	2086	2089	java/lang/Exception
    //   2099	2104	2107	java/lang/Exception
    //   2117	2122	2125	java/lang/Exception
    //   18	26	2140	java/net/SocketTimeoutException
    //   2397	2402	2405	java/lang/Exception
    //   2415	2420	2423	java/lang/Exception
    //   2433	2438	2441	java/lang/Exception
    //   1340	1345	2575	finally
    //   1359	1365	2575	finally
    //   1379	1388	2575	finally
    //   1402	1413	2575	finally
    //   1427	1436	2575	finally
    //   1450	1461	2575	finally
    //   1475	1489	2575	finally
    //   1593	1598	2575	finally
    //   1612	1618	2575	finally
    //   1632	1641	2575	finally
    //   1655	1666	2575	finally
    //   1680	1689	2575	finally
    //   1703	1714	2575	finally
    //   1728	1742	2575	finally
    //   1756	1764	2575	finally
    //   1778	1786	2575	finally
    //   1883	1888	2575	finally
    //   1902	1908	2575	finally
    //   1922	1931	2575	finally
    //   1945	1956	2575	finally
    //   1970	1979	2575	finally
    //   1993	2004	2575	finally
    //   2018	2032	2575	finally
    //   2046	2054	2575	finally
    //   2068	2076	2575	finally
    //   2173	2178	2575	finally
    //   2192	2198	2575	finally
    //   2212	2221	2575	finally
    //   2235	2246	2575	finally
    //   2260	2269	2575	finally
    //   2283	2294	2575	finally
    //   2308	2322	2575	finally
    //   2336	2348	2575	finally
    //   2362	2370	2575	finally
    //   2384	2392	2575	finally
    //   2598	2603	2606	java/lang/Exception
    //   2615	2619	2622	java/lang/Exception
    //   2632	2637	2640	java/lang/Exception
  }
  
  public final byte[] a(String paramString)
  {
    int i = 0;
    byte[] arrayOfByte = null;
    while (i < 2)
    {
      arrayOfByte = a(paramString, "GET", null, null);
      if (arrayOfByte != null) {
        return arrayOfByte;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public final byte[] a(String paramString, ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.valueSet();
    if (((Set)localObject).size() > 0)
    {
      paramContentValues = "";
      String str = "";
      Iterator localIterator = ((Set)localObject).iterator();
      for (;;)
      {
        localObject = paramContentValues;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContentValues);
        localStringBuilder.append(str);
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(((Map.Entry)localObject).getValue());
        paramContentValues = localStringBuilder.toString();
        str = "&";
      }
    }
    localObject = null;
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
    xj.c("testlogfile:".concat(String.valueOf(localStringBuffer)));
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
    xj.c("requestUploadFileEnc:".concat(String.valueOf(localStringBuffer)));
    return a(paramString1, "POST", localStringBuffer.toString(), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajn
 * JD-Core Version:    0.7.0.1
 */