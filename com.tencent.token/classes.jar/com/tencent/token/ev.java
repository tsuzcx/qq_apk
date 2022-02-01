package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

public class ev
{
  private static String j = "10.0.0.172";
  private static int k = 80;
  private int a = 0;
  private Vector b = new Vector();
  private a[] c;
  private final int d;
  private final int e;
  private volatile boolean f = false;
  private boolean g = false;
  private volatile boolean h = false;
  private int[] i = new int[0];
  
  public ev(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.c = new a[paramInt1];
    paramInt2 = m;
    while (paramInt2 < paramInt1)
    {
      this.c[paramInt2] = new a();
      this.c[paramInt2].setPriority(1);
      paramInt2 += 1;
    }
  }
  
  private static HttpURLConnection a(String paramString, ew paramew)
  {
    Object localObject2 = new URL(paramString);
    Object localObject1 = RqdApplication.l();
    String str1;
    int m;
    String str2;
    if (localObject1 != null)
    {
      localObject1 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 0))
      {
        str1 = android.net.Proxy.getDefaultHost();
        m = android.net.Proxy.getDefaultPort();
        g.a("conn proxy host=" + str1 + ", port=" + m);
        str2 = ((NetworkInfo)localObject1).getExtraInfo();
        if ((str1 != null) && (-1 != m) && (str2 != null) && ((str2.toLowerCase(Locale.getDefault()).equals("cmwap")) || (str2.toLowerCase(Locale.getDefault()).equals("uniwap")) || (str2.toLowerCase(Locale.getDefault()).equals("3gwap"))))
        {
          str2 = l.e(paramString);
          str1 = l.f(paramString);
          if ((str2 == null) || (str1 == null) || (paramString.length() <= str2.length() + str1.length()))
          {
            paramString = (HttpURLConnection)((URL)localObject2).openConnection();
            g.a("conn type is mobile type=" + ((NetworkInfo)localObject1).getExtraInfo());
          }
        }
      }
    }
    for (;;)
    {
      paramString.setConnectTimeout(20000);
      paramString.setReadTimeout(30000);
      paramString.setRequestMethod(paramew.e());
      localObject1 = paramew.a.keys();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (String)((Enumeration)localObject1).nextElement();
        paramString.setRequestProperty((String)localObject2, (String)paramew.a.get(localObject2));
      }
      g.a("default proxy host: " + android.net.Proxy.getDefaultHost() + ", port: " + android.net.Proxy.getDefaultPort());
      paramString = str2 + android.net.Proxy.getDefaultHost() + paramString.substring(str2.length() + str1.length());
      g.a("wap urlAssem: " + paramString);
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setRequestProperty("X-Online-Host", str1);
      paramString.setRequestProperty("Host", android.net.Proxy.getDefaultHost());
      break;
      if ((str1 != null) && (-1 != m) && (str2 != null) && (str2.toLowerCase(Locale.getDefault()).equals("ctwap")))
      {
        paramString = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
        paramString = (HttpURLConnection)((URL)localObject2).openConnection(new java.net.Proxy(Proxy.Type.HTTP, paramString));
        break;
      }
      paramString = (HttpURLConnection)((URL)localObject2).openConnection();
      break;
      paramString = (HttpURLConnection)((URL)localObject2).openConnection();
      g.a("conn type is wifi");
      continue;
      paramString = (HttpURLConnection)((URL)localObject2).openConnection();
      g.a("Context is null, don't get connect type");
    }
    return paramString;
  }
  
  private void a(ew paramew, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramew.b().a(paramew, paramInt);
    }
  }
  
  /* Error */
  private void a(ew paramew, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 256	com/tencent/token/ew:b	()Lcom/tencent/token/ex;
    //   4: astore 27
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 25
    //   15: aconst_null
    //   16: astore 18
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 19
    //   24: aconst_null
    //   25: astore 23
    //   27: aconst_null
    //   28: astore 24
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 16
    //   36: aconst_null
    //   37: astore 14
    //   39: aconst_null
    //   40: astore 26
    //   42: aconst_null
    //   43: astore 21
    //   45: aconst_null
    //   46: astore 22
    //   48: aconst_null
    //   49: astore 15
    //   51: iconst_0
    //   52: istore 5
    //   54: aload_0
    //   55: aload_1
    //   56: iconst_1
    //   57: iload_3
    //   58: invokespecial 269	com/tencent/token/ev:a	(Lcom/tencent/token/ew;IZ)V
    //   61: aload_1
    //   62: invokevirtual 271	com/tencent/token/ew:a	()Ljava/lang/String;
    //   65: astore 12
    //   67: iconst_0
    //   68: istore 4
    //   70: aload 12
    //   72: aload_1
    //   73: invokestatic 273	com/tencent/token/ev:a	(Ljava/lang/String;Lcom/tencent/token/ew;)Ljava/net/HttpURLConnection;
    //   76: astore 9
    //   78: aload 9
    //   80: astore 8
    //   82: aload_1
    //   83: invokevirtual 276	com/tencent/token/ew:c	()[B
    //   86: astore 10
    //   88: aload 10
    //   90: ifnull +1932 -> 2022
    //   93: aload 10
    //   95: arraylength
    //   96: ifeq +1926 -> 2022
    //   99: aload 8
    //   101: iconst_1
    //   102: invokevirtual 280	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   105: aload 8
    //   107: invokevirtual 284	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   110: astore 9
    //   112: aload 9
    //   114: aload 10
    //   116: invokevirtual 290	java/io/OutputStream:write	([B)V
    //   119: aload 9
    //   121: invokevirtual 293	java/io/OutputStream:flush	()V
    //   124: aload 9
    //   126: invokevirtual 296	java/io/OutputStream:close	()V
    //   129: aconst_null
    //   130: astore 7
    //   132: aload 24
    //   134: astore 11
    //   136: aload 25
    //   138: astore 13
    //   140: aload 23
    //   142: astore 10
    //   144: new 107	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 298
    //   154: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 271	com/tencent/token/ew:a	()Ljava/lang/String;
    //   161: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 126	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   170: aload 24
    //   172: astore 11
    //   174: aload 25
    //   176: astore 13
    //   178: aload 23
    //   180: astore 10
    //   182: aload 8
    //   184: invokevirtual 301	java/net/HttpURLConnection:getResponseCode	()I
    //   187: istore 6
    //   189: iconst_m1
    //   190: iload 6
    //   192: if_icmpne +317 -> 509
    //   195: aload 12
    //   197: ifnull +312 -> 509
    //   200: aload 24
    //   202: astore 11
    //   204: aload 23
    //   206: astore 10
    //   208: aload 8
    //   210: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   213: aload 24
    //   215: astore 11
    //   217: aload 23
    //   219: astore 10
    //   221: bipush 100
    //   223: i2l
    //   224: invokestatic 310	java/lang/Thread:sleep	(J)V
    //   227: aload 24
    //   229: astore 11
    //   231: aload 23
    //   233: astore 10
    //   235: new 107	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 312
    //   245: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload 6
    //   250: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 314
    //   256: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iconst_0
    //   260: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: ldc_w 316
    //   266: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: bipush 100
    //   271: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 126	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   280: iload 4
    //   282: iconst_1
    //   283: iadd
    //   284: istore 4
    //   286: goto -216 -> 70
    //   289: astore_2
    //   290: aload 24
    //   292: astore 11
    //   294: aload 25
    //   296: astore 13
    //   298: aload 23
    //   300: astore 10
    //   302: aload_2
    //   303: athrow
    //   304: astore 9
    //   306: aconst_null
    //   307: astore_2
    //   308: aload 11
    //   310: astore 12
    //   312: iconst_1
    //   313: istore 5
    //   315: aload_2
    //   316: astore 11
    //   318: aload 7
    //   320: astore 14
    //   322: aload 12
    //   324: astore 10
    //   326: aload 8
    //   328: astore 13
    //   330: new 107	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   337: aload 9
    //   339: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   342: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 319
    //   348: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 9
    //   353: invokevirtual 322	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   356: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 9
    //   364: aload 9
    //   366: astore 10
    //   368: aload_2
    //   369: ifnull +7 -> 376
    //   372: aload_2
    //   373: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   376: aload 12
    //   378: ifnull +8 -> 386
    //   381: aload 12
    //   383: invokevirtual 328	java/io/InputStream:close	()V
    //   386: aload 7
    //   388: ifnull +8 -> 396
    //   391: aload 7
    //   393: invokevirtual 296	java/io/OutputStream:close	()V
    //   396: iload 5
    //   398: istore 4
    //   400: aload 10
    //   402: astore 9
    //   404: aload 15
    //   406: astore 7
    //   408: aload 8
    //   410: ifnull +20 -> 430
    //   413: aload 8
    //   415: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   418: aload 15
    //   420: astore 7
    //   422: aload 10
    //   424: astore 9
    //   426: iload 5
    //   428: istore 4
    //   430: aload 27
    //   432: aload_1
    //   433: iconst_4
    //   434: invokeinterface 261 3 0
    //   439: pop
    //   440: iload 4
    //   442: ifeq +1275 -> 1717
    //   445: aload 27
    //   447: aload_1
    //   448: aload 9
    //   450: invokeinterface 331 3 0
    //   455: new 107	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 333
    //   465: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 9
    //   470: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 126	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   479: aload_1
    //   480: invokevirtual 335	com/tencent/token/ew:d	()I
    //   483: iconst_1
    //   484: if_icmpne +24 -> 508
    //   487: aload_0
    //   488: iconst_1
    //   489: putfield 49	com/tencent/token/ev:h	Z
    //   492: aload_0
    //   493: getfield 51	com/tencent/token/ev:i	[I
    //   496: astore_2
    //   497: aload_2
    //   498: monitorenter
    //   499: aload_0
    //   500: getfield 51	com/tencent/token/ev:i	[I
    //   503: invokevirtual 338	java/lang/Object:notifyAll	()V
    //   506: aload_2
    //   507: monitorexit
    //   508: return
    //   509: iload 6
    //   511: sipush 302
    //   514: if_icmpeq +11 -> 525
    //   517: iload 6
    //   519: sipush 301
    //   522: if_icmpne +244 -> 766
    //   525: iload 4
    //   527: iconst_3
    //   528: if_icmpge +238 -> 766
    //   531: aload 24
    //   533: astore 11
    //   535: aload 25
    //   537: astore 13
    //   539: aload 23
    //   541: astore 10
    //   543: aload 8
    //   545: ldc_w 340
    //   548: invokevirtual 343	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   551: astore 12
    //   553: aload 12
    //   555: ifnull +39 -> 594
    //   558: aload 24
    //   560: astore 11
    //   562: aload 23
    //   564: astore 10
    //   566: aload 8
    //   568: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   571: aload 24
    //   573: astore 11
    //   575: aload 23
    //   577: astore 10
    //   579: ldc2_w 344
    //   582: invokestatic 310	java/lang/Thread:sleep	(J)V
    //   585: iload 4
    //   587: iconst_1
    //   588: iadd
    //   589: istore 4
    //   591: goto -521 -> 70
    //   594: aload 24
    //   596: astore 11
    //   598: aload 25
    //   600: astore 13
    //   602: aload 23
    //   604: astore 10
    //   606: new 267	java/io/IOException
    //   609: dup
    //   610: ldc_w 347
    //   613: invokespecial 348	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   616: athrow
    //   617: astore 9
    //   619: aconst_null
    //   620: astore_2
    //   621: aload 13
    //   623: astore 12
    //   625: aload 14
    //   627: astore 15
    //   629: iconst_1
    //   630: istore 5
    //   632: aload_2
    //   633: astore 11
    //   635: aload 7
    //   637: astore 14
    //   639: aload 12
    //   641: astore 10
    //   643: aload 8
    //   645: astore 13
    //   647: new 107	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   654: aload 9
    //   656: invokevirtual 349	java/lang/Throwable:toString	()Ljava/lang/String;
    //   659: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 319
    //   665: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 9
    //   670: invokevirtual 350	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   673: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: astore 9
    //   681: aload 9
    //   683: astore 10
    //   685: aload_2
    //   686: ifnull +7 -> 693
    //   689: aload_2
    //   690: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   693: aload 12
    //   695: ifnull +8 -> 703
    //   698: aload 12
    //   700: invokevirtual 328	java/io/InputStream:close	()V
    //   703: aload 7
    //   705: ifnull +8 -> 713
    //   708: aload 7
    //   710: invokevirtual 296	java/io/OutputStream:close	()V
    //   713: iload 5
    //   715: istore 4
    //   717: aload 10
    //   719: astore 9
    //   721: aload 15
    //   723: astore 7
    //   725: aload 8
    //   727: ifnull -297 -> 430
    //   730: aload 8
    //   732: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   735: iload 5
    //   737: istore 4
    //   739: aload 10
    //   741: astore 9
    //   743: aload 15
    //   745: astore 7
    //   747: goto -317 -> 430
    //   750: astore_2
    //   751: iload 5
    //   753: istore 4
    //   755: aload 10
    //   757: astore 9
    //   759: aload 15
    //   761: astore 7
    //   763: goto -333 -> 430
    //   766: aload 24
    //   768: astore 11
    //   770: aload 25
    //   772: astore 13
    //   774: aload 23
    //   776: astore 10
    //   778: aload_0
    //   779: aload_1
    //   780: iconst_2
    //   781: iload_3
    //   782: invokespecial 269	com/tencent/token/ev:a	(Lcom/tencent/token/ew;IZ)V
    //   785: iload 6
    //   787: sipush 200
    //   790: if_icmpeq +17 -> 807
    //   793: iload 6
    //   795: sipush 206
    //   798: if_icmpeq +9 -> 807
    //   801: iload 6
    //   803: iconst_m1
    //   804: if_icmpne +794 -> 1598
    //   807: aload 24
    //   809: astore 11
    //   811: aload 25
    //   813: astore 13
    //   815: aload 23
    //   817: astore 10
    //   819: aload 8
    //   821: invokevirtual 353	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   824: astore 9
    //   826: aload 24
    //   828: astore 11
    //   830: aload 25
    //   832: astore 13
    //   834: aload 23
    //   836: astore 10
    //   838: aload_1
    //   839: aload 9
    //   841: putfield 355	com/tencent/token/ew:b	Ljava/lang/String;
    //   844: aload 9
    //   846: ifnonnull +145 -> 991
    //   849: ldc_w 357
    //   852: astore 9
    //   854: iload_3
    //   855: ifne +158 -> 1013
    //   858: aload 24
    //   860: astore 11
    //   862: aload 25
    //   864: astore 13
    //   866: aload 23
    //   868: astore 10
    //   870: aload_1
    //   871: getfield 359	com/tencent/token/ew:e	Z
    //   874: ifeq +139 -> 1013
    //   877: aload 24
    //   879: astore 11
    //   881: aload 25
    //   883: astore 13
    //   885: aload 23
    //   887: astore 10
    //   889: aload 9
    //   891: ldc_w 361
    //   894: invokevirtual 365	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   897: iconst_m1
    //   898: if_icmpne +27 -> 925
    //   901: aload 24
    //   903: astore 11
    //   905: aload 25
    //   907: astore 13
    //   909: aload 23
    //   911: astore 10
    //   913: aload 9
    //   915: ldc_w 367
    //   918: invokevirtual 365	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   921: iconst_m1
    //   922: if_icmpeq +91 -> 1013
    //   925: aload 24
    //   927: astore 11
    //   929: aload 25
    //   931: astore 13
    //   933: aload 23
    //   935: astore 10
    //   937: aload_0
    //   938: aload_1
    //   939: aload_2
    //   940: iconst_1
    //   941: invokespecial 252	com/tencent/token/ev:a	(Lcom/tencent/token/ew;Lcom/tencent/token/ev$a;Z)V
    //   944: iconst_0
    //   945: ifeq +11 -> 956
    //   948: new 369	java/lang/NullPointerException
    //   951: dup
    //   952: invokespecial 370	java/lang/NullPointerException:<init>	()V
    //   955: athrow
    //   956: iconst_0
    //   957: ifeq +11 -> 968
    //   960: new 369	java/lang/NullPointerException
    //   963: dup
    //   964: invokespecial 370	java/lang/NullPointerException:<init>	()V
    //   967: athrow
    //   968: aload 7
    //   970: ifnull +8 -> 978
    //   973: aload 7
    //   975: invokevirtual 296	java/io/OutputStream:close	()V
    //   978: aload 8
    //   980: ifnull -472 -> 508
    //   983: aload 8
    //   985: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   988: return
    //   989: astore_1
    //   990: return
    //   991: aload 24
    //   993: astore 11
    //   995: aload 25
    //   997: astore 13
    //   999: aload 23
    //   1001: astore 10
    //   1003: aload 9
    //   1005: invokevirtual 372	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1008: astore 9
    //   1010: goto -156 -> 854
    //   1013: aload 24
    //   1015: astore 11
    //   1017: aload 25
    //   1019: astore 13
    //   1021: aload 23
    //   1023: astore 10
    //   1025: aload_1
    //   1026: aload 8
    //   1028: invokevirtual 375	java/net/HttpURLConnection:getContentLength	()I
    //   1031: i2l
    //   1032: putfield 378	com/tencent/token/ew:c	J
    //   1035: aload 24
    //   1037: astore 11
    //   1039: aload 25
    //   1041: astore 13
    //   1043: aload 23
    //   1045: astore 10
    //   1047: aload 8
    //   1049: invokevirtual 382	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1052: astore 9
    //   1054: aload 9
    //   1056: astore 11
    //   1058: aload 9
    //   1060: astore 13
    //   1062: aload 9
    //   1064: astore 10
    //   1066: new 324	java/io/ByteArrayOutputStream
    //   1069: dup
    //   1070: invokespecial 383	java/io/ByteArrayOutputStream:<init>	()V
    //   1073: astore 12
    //   1075: aload 12
    //   1077: astore 11
    //   1079: aload 7
    //   1081: astore 14
    //   1083: aload 9
    //   1085: astore 10
    //   1087: aload 8
    //   1089: astore 13
    //   1091: aload 21
    //   1093: astore 15
    //   1095: aload 12
    //   1097: astore 18
    //   1099: aload 9
    //   1101: astore 17
    //   1103: aload 22
    //   1105: astore 20
    //   1107: aload 12
    //   1109: astore 19
    //   1111: aload 9
    //   1113: astore 16
    //   1115: aload 9
    //   1117: invokevirtual 386	java/io/InputStream:read	()I
    //   1120: istore 4
    //   1122: iload 4
    //   1124: iconst_m1
    //   1125: if_icmpeq +248 -> 1373
    //   1128: aload 12
    //   1130: astore 11
    //   1132: aload 7
    //   1134: astore 14
    //   1136: aload 9
    //   1138: astore 10
    //   1140: aload 8
    //   1142: astore 13
    //   1144: aload 21
    //   1146: astore 15
    //   1148: aload 12
    //   1150: astore 18
    //   1152: aload 9
    //   1154: astore 17
    //   1156: aload 22
    //   1158: astore 20
    //   1160: aload 12
    //   1162: astore 19
    //   1164: aload 9
    //   1166: astore 16
    //   1168: aload_0
    //   1169: getfield 45	com/tencent/token/ev:f	Z
    //   1172: ifeq +50 -> 1222
    //   1175: aload 12
    //   1177: astore 11
    //   1179: aload 7
    //   1181: astore 14
    //   1183: aload 9
    //   1185: astore 10
    //   1187: aload 8
    //   1189: astore 13
    //   1191: aload 21
    //   1193: astore 15
    //   1195: aload 12
    //   1197: astore 18
    //   1199: aload 9
    //   1201: astore 17
    //   1203: aload 22
    //   1205: astore 20
    //   1207: aload 12
    //   1209: astore 19
    //   1211: aload 9
    //   1213: astore 16
    //   1215: aload_2
    //   1216: getfield 388	com/tencent/token/ev$a:b	Z
    //   1219: ifeq +54 -> 1273
    //   1222: aload 12
    //   1224: astore 11
    //   1226: aload 7
    //   1228: astore 14
    //   1230: aload 9
    //   1232: astore 10
    //   1234: aload 8
    //   1236: astore 13
    //   1238: aload 21
    //   1240: astore 15
    //   1242: aload 12
    //   1244: astore 18
    //   1246: aload 9
    //   1248: astore 17
    //   1250: aload 22
    //   1252: astore 20
    //   1254: aload 12
    //   1256: astore 19
    //   1258: aload 9
    //   1260: astore 16
    //   1262: new 267	java/io/IOException
    //   1265: dup
    //   1266: ldc_w 390
    //   1269: invokespecial 348	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1272: athrow
    //   1273: aload 12
    //   1275: astore 11
    //   1277: aload 7
    //   1279: astore 14
    //   1281: aload 9
    //   1283: astore 10
    //   1285: aload 8
    //   1287: astore 13
    //   1289: aload 21
    //   1291: astore 15
    //   1293: aload 12
    //   1295: astore 18
    //   1297: aload 9
    //   1299: astore 17
    //   1301: aload 22
    //   1303: astore 20
    //   1305: aload 12
    //   1307: astore 19
    //   1309: aload 9
    //   1311: astore 16
    //   1313: aload 12
    //   1315: iload 4
    //   1317: invokevirtual 392	java/io/ByteArrayOutputStream:write	(I)V
    //   1320: aload 12
    //   1322: astore 11
    //   1324: aload 7
    //   1326: astore 14
    //   1328: aload 9
    //   1330: astore 10
    //   1332: aload 8
    //   1334: astore 13
    //   1336: aload 21
    //   1338: astore 15
    //   1340: aload 12
    //   1342: astore 18
    //   1344: aload 9
    //   1346: astore 17
    //   1348: aload 22
    //   1350: astore 20
    //   1352: aload 12
    //   1354: astore 19
    //   1356: aload 9
    //   1358: astore 16
    //   1360: aload_1
    //   1361: aload_1
    //   1362: getfield 394	com/tencent/token/ew:d	J
    //   1365: lconst_1
    //   1366: ladd
    //   1367: putfield 394	com/tencent/token/ew:d	J
    //   1370: goto -295 -> 1075
    //   1373: aload 12
    //   1375: astore 11
    //   1377: aload 7
    //   1379: astore 14
    //   1381: aload 9
    //   1383: astore 10
    //   1385: aload 8
    //   1387: astore 13
    //   1389: aload 21
    //   1391: astore 15
    //   1393: aload 12
    //   1395: astore 18
    //   1397: aload 9
    //   1399: astore 17
    //   1401: aload 22
    //   1403: astore 20
    //   1405: aload 12
    //   1407: astore 19
    //   1409: aload 9
    //   1411: astore 16
    //   1413: aload 12
    //   1415: invokevirtual 395	java/io/ByteArrayOutputStream:flush	()V
    //   1418: aload 12
    //   1420: astore 11
    //   1422: aload 7
    //   1424: astore 14
    //   1426: aload 9
    //   1428: astore 10
    //   1430: aload 8
    //   1432: astore 13
    //   1434: aload 21
    //   1436: astore 15
    //   1438: aload 12
    //   1440: astore 18
    //   1442: aload 9
    //   1444: astore 17
    //   1446: aload 22
    //   1448: astore 20
    //   1450: aload 12
    //   1452: astore 19
    //   1454: aload 9
    //   1456: astore 16
    //   1458: aload 12
    //   1460: invokevirtual 398	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1463: astore_2
    //   1464: ldc_w 357
    //   1467: astore 21
    //   1469: aload 12
    //   1471: astore 11
    //   1473: aload 7
    //   1475: astore 14
    //   1477: aload 9
    //   1479: astore 10
    //   1481: aload 8
    //   1483: astore 13
    //   1485: aload_2
    //   1486: astore 15
    //   1488: aload 12
    //   1490: astore 18
    //   1492: aload 9
    //   1494: astore 17
    //   1496: aload_2
    //   1497: astore 20
    //   1499: aload 12
    //   1501: astore 19
    //   1503: aload 9
    //   1505: astore 16
    //   1507: aload 27
    //   1509: aload_1
    //   1510: iconst_3
    //   1511: invokeinterface 261 3 0
    //   1516: pop
    //   1517: aload 12
    //   1519: ifnull +8 -> 1527
    //   1522: aload 12
    //   1524: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   1527: aload 9
    //   1529: ifnull +8 -> 1537
    //   1532: aload 9
    //   1534: invokevirtual 328	java/io/InputStream:close	()V
    //   1537: aload 7
    //   1539: ifnull +8 -> 1547
    //   1542: aload 7
    //   1544: invokevirtual 296	java/io/OutputStream:close	()V
    //   1547: iload 5
    //   1549: istore 4
    //   1551: aload 21
    //   1553: astore 9
    //   1555: aload_2
    //   1556: astore 7
    //   1558: aload 8
    //   1560: ifnull -1130 -> 430
    //   1563: aload 8
    //   1565: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   1568: iload 5
    //   1570: istore 4
    //   1572: aload 21
    //   1574: astore 9
    //   1576: aload_2
    //   1577: astore 7
    //   1579: goto -1149 -> 430
    //   1582: astore 7
    //   1584: iload 5
    //   1586: istore 4
    //   1588: aload 21
    //   1590: astore 9
    //   1592: aload_2
    //   1593: astore 7
    //   1595: goto -1165 -> 430
    //   1598: iconst_1
    //   1599: istore 5
    //   1601: aload 24
    //   1603: astore 11
    //   1605: aload 25
    //   1607: astore 13
    //   1609: aload 23
    //   1611: astore 10
    //   1613: new 107	java/lang/StringBuilder
    //   1616: dup
    //   1617: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1620: ldc_w 400
    //   1623: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: iload 6
    //   1628: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1631: ldc_w 402
    //   1634: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload 8
    //   1639: invokevirtual 405	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   1642: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1648: astore 21
    //   1650: aconst_null
    //   1651: astore 12
    //   1653: aload 26
    //   1655: astore_2
    //   1656: aload 20
    //   1658: astore 9
    //   1660: goto -191 -> 1469
    //   1663: astore_1
    //   1664: aconst_null
    //   1665: astore 8
    //   1667: aconst_null
    //   1668: astore 7
    //   1670: aload 19
    //   1672: astore 10
    //   1674: aload 16
    //   1676: astore_2
    //   1677: aload_2
    //   1678: ifnull +7 -> 1685
    //   1681: aload_2
    //   1682: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   1685: aload 10
    //   1687: ifnull +8 -> 1695
    //   1690: aload 10
    //   1692: invokevirtual 328	java/io/InputStream:close	()V
    //   1695: aload 7
    //   1697: ifnull +8 -> 1705
    //   1700: aload 7
    //   1702: invokevirtual 296	java/io/OutputStream:close	()V
    //   1705: aload 8
    //   1707: ifnull +8 -> 1715
    //   1710: aload 8
    //   1712: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   1715: aload_1
    //   1716: athrow
    //   1717: aload 27
    //   1719: aload_1
    //   1720: aload 7
    //   1722: invokeinterface 408 3 0
    //   1727: goto -1248 -> 479
    //   1730: astore_2
    //   1731: goto -1252 -> 479
    //   1734: astore_1
    //   1735: aload_2
    //   1736: monitorexit
    //   1737: aload_1
    //   1738: athrow
    //   1739: astore_1
    //   1740: goto -784 -> 956
    //   1743: astore_1
    //   1744: goto -776 -> 968
    //   1747: astore_1
    //   1748: goto -770 -> 978
    //   1751: astore 10
    //   1753: goto -226 -> 1527
    //   1756: astore 9
    //   1758: goto -221 -> 1537
    //   1761: astore 7
    //   1763: goto -216 -> 1547
    //   1766: astore_2
    //   1767: goto -1391 -> 376
    //   1770: astore_2
    //   1771: goto -1385 -> 386
    //   1774: astore_2
    //   1775: goto -1379 -> 396
    //   1778: astore_2
    //   1779: iload 5
    //   1781: istore 4
    //   1783: aload 10
    //   1785: astore 9
    //   1787: aload 15
    //   1789: astore 7
    //   1791: goto -1361 -> 430
    //   1794: astore_2
    //   1795: goto -1102 -> 693
    //   1798: astore_2
    //   1799: goto -1096 -> 703
    //   1802: astore_2
    //   1803: goto -1090 -> 713
    //   1806: astore_2
    //   1807: goto -122 -> 1685
    //   1810: astore_2
    //   1811: goto -116 -> 1695
    //   1814: astore_2
    //   1815: goto -110 -> 1705
    //   1818: astore_2
    //   1819: goto -104 -> 1715
    //   1822: astore_2
    //   1823: goto -1344 -> 479
    //   1826: astore_1
    //   1827: aload 16
    //   1829: astore_2
    //   1830: aload 19
    //   1832: astore 10
    //   1834: goto -157 -> 1677
    //   1837: astore_1
    //   1838: aload 9
    //   1840: astore 7
    //   1842: aload 16
    //   1844: astore_2
    //   1845: aload 19
    //   1847: astore 10
    //   1849: goto -172 -> 1677
    //   1852: astore_1
    //   1853: aload 16
    //   1855: astore_2
    //   1856: goto -179 -> 1677
    //   1859: astore_1
    //   1860: aload 16
    //   1862: astore_2
    //   1863: aload 19
    //   1865: astore 10
    //   1867: goto -190 -> 1677
    //   1870: astore_1
    //   1871: aload 11
    //   1873: astore_2
    //   1874: aload 14
    //   1876: astore 7
    //   1878: aload 13
    //   1880: astore 8
    //   1882: goto -205 -> 1677
    //   1885: astore 9
    //   1887: aconst_null
    //   1888: astore 8
    //   1890: aconst_null
    //   1891: astore 7
    //   1893: aconst_null
    //   1894: astore_2
    //   1895: aload 14
    //   1897: astore 15
    //   1899: aload 18
    //   1901: astore 12
    //   1903: goto -1274 -> 629
    //   1906: astore 9
    //   1908: aconst_null
    //   1909: astore_2
    //   1910: aload 14
    //   1912: astore 15
    //   1914: aload 18
    //   1916: astore 12
    //   1918: goto -1289 -> 629
    //   1921: astore 10
    //   1923: aload 9
    //   1925: astore 7
    //   1927: aconst_null
    //   1928: astore_2
    //   1929: aload 10
    //   1931: astore 9
    //   1933: aload 14
    //   1935: astore 15
    //   1937: aload 18
    //   1939: astore 12
    //   1941: goto -1312 -> 629
    //   1944: astore 9
    //   1946: aconst_null
    //   1947: astore_2
    //   1948: aload 14
    //   1950: astore 15
    //   1952: aload 18
    //   1954: astore 12
    //   1956: goto -1327 -> 629
    //   1959: astore 9
    //   1961: aconst_null
    //   1962: astore 8
    //   1964: aconst_null
    //   1965: astore 7
    //   1967: aconst_null
    //   1968: astore_2
    //   1969: aload 17
    //   1971: astore 12
    //   1973: goto -1661 -> 312
    //   1976: astore 9
    //   1978: aconst_null
    //   1979: astore_2
    //   1980: aload 17
    //   1982: astore 12
    //   1984: goto -1672 -> 312
    //   1987: astore 10
    //   1989: aload 9
    //   1991: astore 7
    //   1993: aconst_null
    //   1994: astore_2
    //   1995: aload 10
    //   1997: astore 9
    //   1999: aload 17
    //   2001: astore 12
    //   2003: goto -1691 -> 312
    //   2006: astore 9
    //   2008: aconst_null
    //   2009: astore_2
    //   2010: aload 17
    //   2012: astore 12
    //   2014: goto -1702 -> 312
    //   2017: astore 9
    //   2019: goto -1434 -> 585
    //   2022: goto -1890 -> 132
    //   2025: astore 9
    //   2027: aload 18
    //   2029: astore_2
    //   2030: aload 17
    //   2032: astore 12
    //   2034: goto -1722 -> 312
    //   2037: astore 9
    //   2039: aload 20
    //   2041: astore 15
    //   2043: aload 19
    //   2045: astore_2
    //   2046: aload 16
    //   2048: astore 12
    //   2050: goto -1421 -> 629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2053	0	this	ev
    //   0	2053	1	paramew	ew
    //   0	2053	2	parama	a
    //   0	2053	3	paramBoolean	boolean
    //   68	1714	4	m	int
    //   52	1728	5	n	int
    //   187	1440	6	i1	int
    //   31	1547	7	localObject1	Object
    //   1582	1	7	localException1	java.lang.Exception
    //   1593	128	7	locala	a
    //   1761	1	7	localException2	java.lang.Exception
    //   1789	203	7	localObject2	Object
    //   7	1956	8	localObject3	Object
    //   76	49	9	localObject4	Object
    //   304	48	9	localException3	java.lang.Exception
    //   362	107	9	localObject5	Object
    //   617	52	9	localThrowable1	java.lang.Throwable
    //   679	980	9	localObject6	Object
    //   1756	1	9	localIOException1	java.io.IOException
    //   1785	54	9	localObject7	Object
    //   1885	1	9	localThrowable2	java.lang.Throwable
    //   1906	18	9	localThrowable3	java.lang.Throwable
    //   1931	1	9	localObject8	Object
    //   1944	1	9	localThrowable4	java.lang.Throwable
    //   1959	1	9	localException4	java.lang.Exception
    //   1976	14	9	localException5	java.lang.Exception
    //   1997	1	9	localObject9	Object
    //   2006	1	9	localException6	java.lang.Exception
    //   2017	1	9	localThrowable5	java.lang.Throwable
    //   2025	1	9	localException7	java.lang.Exception
    //   2037	1	9	localThrowable6	java.lang.Throwable
    //   86	1605	10	localObject10	Object
    //   1751	33	10	localIOException2	java.io.IOException
    //   1832	34	10	localObject11	Object
    //   1921	9	10	localThrowable7	java.lang.Throwable
    //   1987	9	10	localException8	java.lang.Exception
    //   134	1738	11	localObject12	Object
    //   65	1984	12	localObject13	Object
    //   138	1741	13	localObject14	Object
    //   37	1912	14	localObject15	Object
    //   49	1993	15	localObject16	Object
    //   34	2013	16	localObject17	Object
    //   10	2021	17	localObject18	Object
    //   16	2012	18	localObject19	Object
    //   22	2022	19	localObject20	Object
    //   19	2021	20	localObject21	Object
    //   43	1606	21	str	String
    //   46	1401	22	localObject22	Object
    //   25	1585	23	localObject23	Object
    //   28	1574	24	localObject24	Object
    //   13	1593	25	localObject25	Object
    //   40	1614	26	localObject26	Object
    //   4	1714	27	localex	ex
    // Exception table:
    //   from	to	target	type
    //   208	213	289	java/lang/Throwable
    //   221	227	289	java/lang/Throwable
    //   235	280	289	java/lang/Throwable
    //   144	170	304	java/lang/Exception
    //   182	189	304	java/lang/Exception
    //   208	213	304	java/lang/Exception
    //   221	227	304	java/lang/Exception
    //   235	280	304	java/lang/Exception
    //   302	304	304	java/lang/Exception
    //   543	553	304	java/lang/Exception
    //   566	571	304	java/lang/Exception
    //   579	585	304	java/lang/Exception
    //   606	617	304	java/lang/Exception
    //   778	785	304	java/lang/Exception
    //   819	826	304	java/lang/Exception
    //   838	844	304	java/lang/Exception
    //   870	877	304	java/lang/Exception
    //   889	901	304	java/lang/Exception
    //   913	925	304	java/lang/Exception
    //   937	944	304	java/lang/Exception
    //   1003	1010	304	java/lang/Exception
    //   1025	1035	304	java/lang/Exception
    //   1047	1054	304	java/lang/Exception
    //   1066	1075	304	java/lang/Exception
    //   1613	1650	304	java/lang/Exception
    //   144	170	617	java/lang/Throwable
    //   182	189	617	java/lang/Throwable
    //   302	304	617	java/lang/Throwable
    //   543	553	617	java/lang/Throwable
    //   606	617	617	java/lang/Throwable
    //   778	785	617	java/lang/Throwable
    //   819	826	617	java/lang/Throwable
    //   838	844	617	java/lang/Throwable
    //   870	877	617	java/lang/Throwable
    //   889	901	617	java/lang/Throwable
    //   913	925	617	java/lang/Throwable
    //   937	944	617	java/lang/Throwable
    //   1003	1010	617	java/lang/Throwable
    //   1025	1035	617	java/lang/Throwable
    //   1047	1054	617	java/lang/Throwable
    //   1066	1075	617	java/lang/Throwable
    //   1613	1650	617	java/lang/Throwable
    //   730	735	750	java/lang/Exception
    //   983	988	989	java/lang/Exception
    //   1563	1568	1582	java/lang/Exception
    //   54	67	1663	finally
    //   1717	1727	1730	java/lang/Throwable
    //   499	508	1734	finally
    //   1735	1737	1734	finally
    //   948	956	1739	java/io/IOException
    //   960	968	1743	java/io/IOException
    //   973	978	1747	java/lang/Exception
    //   1522	1527	1751	java/io/IOException
    //   1532	1537	1756	java/io/IOException
    //   1542	1547	1761	java/lang/Exception
    //   372	376	1766	java/io/IOException
    //   381	386	1770	java/io/IOException
    //   391	396	1774	java/lang/Exception
    //   413	418	1778	java/lang/Exception
    //   689	693	1794	java/io/IOException
    //   698	703	1798	java/io/IOException
    //   708	713	1802	java/lang/Exception
    //   1681	1685	1806	java/io/IOException
    //   1690	1695	1810	java/io/IOException
    //   1700	1705	1814	java/lang/Exception
    //   1710	1715	1818	java/lang/Exception
    //   445	479	1822	java/lang/Throwable
    //   82	88	1826	finally
    //   93	112	1826	finally
    //   112	129	1837	finally
    //   144	170	1852	finally
    //   182	189	1852	finally
    //   208	213	1852	finally
    //   221	227	1852	finally
    //   235	280	1852	finally
    //   302	304	1852	finally
    //   543	553	1852	finally
    //   566	571	1852	finally
    //   579	585	1852	finally
    //   606	617	1852	finally
    //   778	785	1852	finally
    //   819	826	1852	finally
    //   838	844	1852	finally
    //   870	877	1852	finally
    //   889	901	1852	finally
    //   913	925	1852	finally
    //   937	944	1852	finally
    //   1003	1010	1852	finally
    //   1025	1035	1852	finally
    //   1047	1054	1852	finally
    //   1066	1075	1852	finally
    //   1613	1650	1852	finally
    //   70	78	1859	finally
    //   330	364	1870	finally
    //   647	681	1870	finally
    //   1115	1122	1870	finally
    //   1168	1175	1870	finally
    //   1215	1222	1870	finally
    //   1262	1273	1870	finally
    //   1313	1320	1870	finally
    //   1360	1370	1870	finally
    //   1413	1418	1870	finally
    //   1458	1464	1870	finally
    //   1507	1517	1870	finally
    //   54	67	1885	java/lang/Throwable
    //   82	88	1906	java/lang/Throwable
    //   93	112	1906	java/lang/Throwable
    //   112	129	1921	java/lang/Throwable
    //   70	78	1944	java/lang/Throwable
    //   54	67	1959	java/lang/Exception
    //   82	88	1976	java/lang/Exception
    //   93	112	1976	java/lang/Exception
    //   112	129	1987	java/lang/Exception
    //   70	78	2006	java/lang/Exception
    //   566	571	2017	java/lang/Throwable
    //   579	585	2017	java/lang/Throwable
    //   1115	1122	2025	java/lang/Exception
    //   1168	1175	2025	java/lang/Exception
    //   1215	1222	2025	java/lang/Exception
    //   1262	1273	2025	java/lang/Exception
    //   1313	1320	2025	java/lang/Exception
    //   1360	1370	2025	java/lang/Exception
    //   1413	1418	2025	java/lang/Exception
    //   1458	1464	2025	java/lang/Exception
    //   1507	1517	2025	java/lang/Exception
    //   1115	1122	2037	java/lang/Throwable
    //   1168	1175	2037	java/lang/Throwable
    //   1215	1222	2037	java/lang/Throwable
    //   1262	1273	2037	java/lang/Throwable
    //   1313	1320	2037	java/lang/Throwable
    //   1360	1370	2037	java/lang/Throwable
    //   1413	1418	2037	java/lang/Throwable
    //   1458	1464	2037	java/lang/Throwable
    //   1507	1517	2037	java/lang/Throwable
  }
  
  public int a(ew paramew)
  {
    synchronized (this.i)
    {
      if ((!this.g) && (this.b.size() < this.e))
      {
        int m = this.a + 1;
        this.a = m;
        paramew.a(m);
        this.b.addElement(paramew);
        paramew.b().a(paramew, 0);
        this.i.notifyAll();
        m = this.a;
        return m;
      }
      return -1;
    }
  }
  
  public void a()
  {
    if ((this.g) || (this.f)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    this.f = true;
    int m = 0;
    while (m < this.d)
    {
      this.c[m].start();
      m += 1;
    }
  }
  
  class a
    extends Thread
  {
    int a = -1;
    volatile boolean b = false;
    
    a() {}
    
    public void run()
    {
      for (;;)
      {
        if (ev.a(ev.this))
        {
          synchronized (ev.b(ev.this))
          {
            label20:
            int i = ev.c(ev.this).size();
            if (i != 0) {}
          }
          try
          {
            ev.b(ev.this).wait();
            label45:
            if (ev.a(ev.this)) {
              break label20;
            }
            return;
            ew localew = (ew)ev.c(ev.this).firstElement();
            if ((ev.d(ev.this)) || (localew.d() == 1))
            {
              ev.c(ev.this).removeElement(localew);
              this.a = localew.d();
            }
            try
            {
              for (;;)
              {
                Thread.sleep(100L);
                label118:
                this.b = false;
                ev.a(ev.this, localew, this, false);
                this.a = -1;
                break;
                try
                {
                  ev.b(ev.this).wait();
                }
                catch (InterruptedException localInterruptedException2) {}
              }
              break label45;
              localObject = finally;
              throw localObject;
            }
            catch (InterruptedException localInterruptedException1)
            {
              break label118;
            }
          }
          catch (InterruptedException localInterruptedException3)
          {
            break label45;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ev
 * JD-Core Version:    0.7.0.1
 */