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

public class ew
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
  
  public ew(int paramInt1, int paramInt2)
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
  
  private static HttpURLConnection a(String paramString, ex paramex)
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
      paramString.setRequestMethod(paramex.e());
      localObject1 = paramex.a.keys();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (String)((Enumeration)localObject1).nextElement();
        paramString.setRequestProperty((String)localObject2, (String)paramex.a.get(localObject2));
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
  
  private void a(ex paramex, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramex.b().a(paramex, paramInt);
    }
  }
  
  /* Error */
  private void a(ex paramex, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 256	com/tencent/token/ex:b	()Lcom/tencent/token/ey;
    //   4: astore 27
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 21
    //   15: aconst_null
    //   16: astore 17
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 19
    //   24: aconst_null
    //   25: astore 24
    //   27: aconst_null
    //   28: astore 25
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 16
    //   36: aconst_null
    //   37: astore 15
    //   39: aconst_null
    //   40: astore 26
    //   42: aconst_null
    //   43: astore 23
    //   45: aconst_null
    //   46: astore 22
    //   48: aconst_null
    //   49: astore 14
    //   51: iconst_0
    //   52: istore 5
    //   54: aload_0
    //   55: aload_1
    //   56: iconst_1
    //   57: iload_3
    //   58: invokespecial 269	com/tencent/token/ew:a	(Lcom/tencent/token/ex;IZ)V
    //   61: aload_1
    //   62: invokevirtual 271	com/tencent/token/ex:a	()Ljava/lang/String;
    //   65: astore 12
    //   67: iconst_0
    //   68: istore 4
    //   70: aload 12
    //   72: aload_1
    //   73: invokestatic 273	com/tencent/token/ew:a	(Ljava/lang/String;Lcom/tencent/token/ex;)Ljava/net/HttpURLConnection;
    //   76: astore 9
    //   78: aload 9
    //   80: astore 8
    //   82: aload_1
    //   83: invokevirtual 276	com/tencent/token/ex:c	()[B
    //   86: astore 10
    //   88: aload 10
    //   90: ifnull +1934 -> 2024
    //   93: aload 10
    //   95: arraylength
    //   96: ifeq +1928 -> 2024
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
    //   132: aload 25
    //   134: astore 11
    //   136: aload 21
    //   138: astore 13
    //   140: aload 24
    //   142: astore 10
    //   144: new 107	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 298
    //   154: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 271	com/tencent/token/ex:a	()Ljava/lang/String;
    //   161: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 126	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   170: aload 25
    //   172: astore 11
    //   174: aload 21
    //   176: astore 13
    //   178: aload 24
    //   180: astore 10
    //   182: aload 8
    //   184: invokevirtual 301	java/net/HttpURLConnection:getResponseCode	()I
    //   187: istore 6
    //   189: iconst_m1
    //   190: iload 6
    //   192: if_icmpne +321 -> 513
    //   195: aload 12
    //   197: ifnull +316 -> 513
    //   200: aload 25
    //   202: astore 11
    //   204: aload 24
    //   206: astore 10
    //   208: aload 8
    //   210: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   213: aload 25
    //   215: astore 11
    //   217: aload 24
    //   219: astore 10
    //   221: bipush 100
    //   223: i2l
    //   224: invokestatic 310	java/lang/Thread:sleep	(J)V
    //   227: aload 25
    //   229: astore 11
    //   231: aload 24
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
    //   290: aload 25
    //   292: astore 11
    //   294: aload 21
    //   296: astore 13
    //   298: aload 24
    //   300: astore 10
    //   302: aload_2
    //   303: athrow
    //   304: astore 9
    //   306: aconst_null
    //   307: astore_2
    //   308: aload 11
    //   310: astore 12
    //   312: aload 14
    //   314: astore 15
    //   316: iconst_1
    //   317: istore 5
    //   319: aload_2
    //   320: astore 11
    //   322: aload 7
    //   324: astore 14
    //   326: aload 12
    //   328: astore 10
    //   330: aload 8
    //   332: astore 13
    //   334: new 107	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   341: aload 9
    //   343: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc_w 319
    //   352: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 9
    //   357: invokevirtual 322	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: astore 9
    //   368: aload 9
    //   370: astore 10
    //   372: aload_2
    //   373: ifnull +7 -> 380
    //   376: aload_2
    //   377: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   380: aload 12
    //   382: ifnull +8 -> 390
    //   385: aload 12
    //   387: invokevirtual 328	java/io/InputStream:close	()V
    //   390: aload 7
    //   392: ifnull +8 -> 400
    //   395: aload 7
    //   397: invokevirtual 296	java/io/OutputStream:close	()V
    //   400: iload 5
    //   402: istore 4
    //   404: aload 10
    //   406: astore 7
    //   408: aload 15
    //   410: astore 9
    //   412: aload 8
    //   414: ifnull +20 -> 434
    //   417: aload 8
    //   419: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   422: aload 15
    //   424: astore 9
    //   426: aload 10
    //   428: astore 7
    //   430: iload 5
    //   432: istore 4
    //   434: aload 27
    //   436: aload_1
    //   437: iconst_4
    //   438: invokeinterface 261 3 0
    //   443: pop
    //   444: iload 4
    //   446: ifeq +1273 -> 1719
    //   449: aload 27
    //   451: aload_1
    //   452: aload 7
    //   454: invokeinterface 331 3 0
    //   459: new 107	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 333
    //   469: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 7
    //   474: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 126	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   483: aload_1
    //   484: invokevirtual 335	com/tencent/token/ex:d	()I
    //   487: iconst_1
    //   488: if_icmpne +24 -> 512
    //   491: aload_0
    //   492: iconst_1
    //   493: putfield 49	com/tencent/token/ew:h	Z
    //   496: aload_0
    //   497: getfield 51	com/tencent/token/ew:i	[I
    //   500: astore_1
    //   501: aload_1
    //   502: monitorenter
    //   503: aload_0
    //   504: getfield 51	com/tencent/token/ew:i	[I
    //   507: invokevirtual 338	java/lang/Object:notifyAll	()V
    //   510: aload_1
    //   511: monitorexit
    //   512: return
    //   513: iload 6
    //   515: sipush 302
    //   518: if_icmpeq +11 -> 529
    //   521: iload 6
    //   523: sipush 301
    //   526: if_icmpne +240 -> 766
    //   529: iload 4
    //   531: iconst_3
    //   532: if_icmpge +234 -> 766
    //   535: aload 25
    //   537: astore 11
    //   539: aload 21
    //   541: astore 13
    //   543: aload 24
    //   545: astore 10
    //   547: aload 8
    //   549: ldc_w 340
    //   552: invokevirtual 343	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   555: astore 12
    //   557: aload 12
    //   559: ifnull +39 -> 598
    //   562: aload 25
    //   564: astore 11
    //   566: aload 24
    //   568: astore 10
    //   570: aload 8
    //   572: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   575: aload 25
    //   577: astore 11
    //   579: aload 24
    //   581: astore 10
    //   583: ldc2_w 344
    //   586: invokestatic 310	java/lang/Thread:sleep	(J)V
    //   589: iload 4
    //   591: iconst_1
    //   592: iadd
    //   593: istore 4
    //   595: goto -525 -> 70
    //   598: aload 25
    //   600: astore 11
    //   602: aload 21
    //   604: astore 13
    //   606: aload 24
    //   608: astore 10
    //   610: new 267	java/io/IOException
    //   613: dup
    //   614: ldc_w 347
    //   617: invokespecial 348	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   620: athrow
    //   621: astore 9
    //   623: aconst_null
    //   624: astore_2
    //   625: aload 13
    //   627: astore 12
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
    //   719: astore 7
    //   721: aload 15
    //   723: astore 9
    //   725: aload 8
    //   727: ifnull -293 -> 434
    //   730: aload 8
    //   732: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   735: iload 5
    //   737: istore 4
    //   739: aload 10
    //   741: astore 7
    //   743: aload 15
    //   745: astore 9
    //   747: goto -313 -> 434
    //   750: astore_2
    //   751: iload 5
    //   753: istore 4
    //   755: aload 10
    //   757: astore 7
    //   759: aload 15
    //   761: astore 9
    //   763: goto -329 -> 434
    //   766: aload 25
    //   768: astore 11
    //   770: aload 21
    //   772: astore 13
    //   774: aload 24
    //   776: astore 10
    //   778: aload_0
    //   779: aload_1
    //   780: iconst_2
    //   781: iload_3
    //   782: invokespecial 269	com/tencent/token/ew:a	(Lcom/tencent/token/ex;IZ)V
    //   785: iload 6
    //   787: sipush 200
    //   790: if_icmpeq +17 -> 807
    //   793: iload 6
    //   795: sipush 206
    //   798: if_icmpeq +9 -> 807
    //   801: iload 6
    //   803: iconst_m1
    //   804: if_icmpne +794 -> 1598
    //   807: aload 25
    //   809: astore 11
    //   811: aload 21
    //   813: astore 13
    //   815: aload 24
    //   817: astore 10
    //   819: aload 8
    //   821: invokevirtual 353	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   824: astore 9
    //   826: aload 25
    //   828: astore 11
    //   830: aload 21
    //   832: astore 13
    //   834: aload 24
    //   836: astore 10
    //   838: aload_1
    //   839: aload 9
    //   841: putfield 355	com/tencent/token/ex:b	Ljava/lang/String;
    //   844: aload 9
    //   846: ifnonnull +145 -> 991
    //   849: ldc_w 357
    //   852: astore 9
    //   854: iload_3
    //   855: ifne +158 -> 1013
    //   858: aload 25
    //   860: astore 11
    //   862: aload 21
    //   864: astore 13
    //   866: aload 24
    //   868: astore 10
    //   870: aload_1
    //   871: getfield 359	com/tencent/token/ex:e	Z
    //   874: ifeq +139 -> 1013
    //   877: aload 25
    //   879: astore 11
    //   881: aload 21
    //   883: astore 13
    //   885: aload 24
    //   887: astore 10
    //   889: aload 9
    //   891: ldc_w 361
    //   894: invokevirtual 365	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   897: iconst_m1
    //   898: if_icmpne +27 -> 925
    //   901: aload 25
    //   903: astore 11
    //   905: aload 21
    //   907: astore 13
    //   909: aload 24
    //   911: astore 10
    //   913: aload 9
    //   915: ldc_w 367
    //   918: invokevirtual 365	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   921: iconst_m1
    //   922: if_icmpeq +91 -> 1013
    //   925: aload 25
    //   927: astore 11
    //   929: aload 21
    //   931: astore 13
    //   933: aload 24
    //   935: astore 10
    //   937: aload_0
    //   938: aload_1
    //   939: aload_2
    //   940: iconst_1
    //   941: invokespecial 252	com/tencent/token/ew:a	(Lcom/tencent/token/ex;Lcom/tencent/token/ew$a;Z)V
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
    //   980: ifnull -468 -> 512
    //   983: aload 8
    //   985: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   988: return
    //   989: astore_1
    //   990: return
    //   991: aload 25
    //   993: astore 11
    //   995: aload 21
    //   997: astore 13
    //   999: aload 24
    //   1001: astore 10
    //   1003: aload 9
    //   1005: invokevirtual 372	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1008: astore 9
    //   1010: goto -156 -> 854
    //   1013: aload 25
    //   1015: astore 11
    //   1017: aload 21
    //   1019: astore 13
    //   1021: aload 24
    //   1023: astore 10
    //   1025: aload_1
    //   1026: aload 8
    //   1028: invokevirtual 375	java/net/HttpURLConnection:getContentLength	()I
    //   1031: i2l
    //   1032: putfield 378	com/tencent/token/ex:c	J
    //   1035: aload 25
    //   1037: astore 11
    //   1039: aload 21
    //   1041: astore 13
    //   1043: aload 24
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
    //   1091: aload 23
    //   1093: astore 20
    //   1095: aload 12
    //   1097: astore 18
    //   1099: aload 9
    //   1101: astore 17
    //   1103: aload 22
    //   1105: astore 21
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
    //   1144: aload 23
    //   1146: astore 20
    //   1148: aload 12
    //   1150: astore 18
    //   1152: aload 9
    //   1154: astore 17
    //   1156: aload 22
    //   1158: astore 21
    //   1160: aload 12
    //   1162: astore 19
    //   1164: aload 9
    //   1166: astore 16
    //   1168: aload_0
    //   1169: getfield 45	com/tencent/token/ew:f	Z
    //   1172: ifeq +50 -> 1222
    //   1175: aload 12
    //   1177: astore 11
    //   1179: aload 7
    //   1181: astore 14
    //   1183: aload 9
    //   1185: astore 10
    //   1187: aload 8
    //   1189: astore 13
    //   1191: aload 23
    //   1193: astore 20
    //   1195: aload 12
    //   1197: astore 18
    //   1199: aload 9
    //   1201: astore 17
    //   1203: aload 22
    //   1205: astore 21
    //   1207: aload 12
    //   1209: astore 19
    //   1211: aload 9
    //   1213: astore 16
    //   1215: aload_2
    //   1216: getfield 388	com/tencent/token/ew$a:b	Z
    //   1219: ifeq +54 -> 1273
    //   1222: aload 12
    //   1224: astore 11
    //   1226: aload 7
    //   1228: astore 14
    //   1230: aload 9
    //   1232: astore 10
    //   1234: aload 8
    //   1236: astore 13
    //   1238: aload 23
    //   1240: astore 20
    //   1242: aload 12
    //   1244: astore 18
    //   1246: aload 9
    //   1248: astore 17
    //   1250: aload 22
    //   1252: astore 21
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
    //   1289: aload 23
    //   1291: astore 20
    //   1293: aload 12
    //   1295: astore 18
    //   1297: aload 9
    //   1299: astore 17
    //   1301: aload 22
    //   1303: astore 21
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
    //   1336: aload 23
    //   1338: astore 20
    //   1340: aload 12
    //   1342: astore 18
    //   1344: aload 9
    //   1346: astore 17
    //   1348: aload 22
    //   1350: astore 21
    //   1352: aload 12
    //   1354: astore 19
    //   1356: aload 9
    //   1358: astore 16
    //   1360: aload_1
    //   1361: aload_1
    //   1362: getfield 394	com/tencent/token/ex:d	J
    //   1365: lconst_1
    //   1366: ladd
    //   1367: putfield 394	com/tencent/token/ex:d	J
    //   1370: goto -295 -> 1075
    //   1373: aload 12
    //   1375: astore 11
    //   1377: aload 7
    //   1379: astore 14
    //   1381: aload 9
    //   1383: astore 10
    //   1385: aload 8
    //   1387: astore 13
    //   1389: aload 23
    //   1391: astore 20
    //   1393: aload 12
    //   1395: astore 18
    //   1397: aload 9
    //   1399: astore 17
    //   1401: aload 22
    //   1403: astore 21
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
    //   1434: aload 23
    //   1436: astore 20
    //   1438: aload 12
    //   1440: astore 18
    //   1442: aload 9
    //   1444: astore 17
    //   1446: aload 22
    //   1448: astore 21
    //   1450: aload 12
    //   1452: astore 19
    //   1454: aload 9
    //   1456: astore 16
    //   1458: aload 12
    //   1460: invokevirtual 398	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1463: astore_2
    //   1464: ldc_w 357
    //   1467: astore 15
    //   1469: aload 12
    //   1471: astore 11
    //   1473: aload 7
    //   1475: astore 14
    //   1477: aload 9
    //   1479: astore 10
    //   1481: aload 8
    //   1483: astore 13
    //   1485: aload_2
    //   1486: astore 20
    //   1488: aload 12
    //   1490: astore 18
    //   1492: aload 9
    //   1494: astore 17
    //   1496: aload_2
    //   1497: astore 21
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
    //   1551: aload 15
    //   1553: astore 7
    //   1555: aload_2
    //   1556: astore 9
    //   1558: aload 8
    //   1560: ifnull -1126 -> 434
    //   1563: aload 8
    //   1565: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   1568: iload 5
    //   1570: istore 4
    //   1572: aload 15
    //   1574: astore 7
    //   1576: aload_2
    //   1577: astore 9
    //   1579: goto -1145 -> 434
    //   1582: astore 7
    //   1584: iload 5
    //   1586: istore 4
    //   1588: aload 15
    //   1590: astore 7
    //   1592: aload_2
    //   1593: astore 9
    //   1595: goto -1161 -> 434
    //   1598: iconst_1
    //   1599: istore 5
    //   1601: aload 25
    //   1603: astore 11
    //   1605: aload 21
    //   1607: astore 13
    //   1609: aload 24
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
    //   1648: astore_2
    //   1649: aconst_null
    //   1650: astore 12
    //   1652: aload_2
    //   1653: astore 15
    //   1655: aload 26
    //   1657: astore_2
    //   1658: aload 20
    //   1660: astore 9
    //   1662: goto -193 -> 1469
    //   1665: astore_1
    //   1666: aconst_null
    //   1667: astore 8
    //   1669: aconst_null
    //   1670: astore 7
    //   1672: aload 19
    //   1674: astore 10
    //   1676: aload 16
    //   1678: astore_2
    //   1679: aload_2
    //   1680: ifnull +7 -> 1687
    //   1683: aload_2
    //   1684: invokevirtual 325	java/io/ByteArrayOutputStream:close	()V
    //   1687: aload 10
    //   1689: ifnull +8 -> 1697
    //   1692: aload 10
    //   1694: invokevirtual 328	java/io/InputStream:close	()V
    //   1697: aload 7
    //   1699: ifnull +8 -> 1707
    //   1702: aload 7
    //   1704: invokevirtual 296	java/io/OutputStream:close	()V
    //   1707: aload 8
    //   1709: ifnull +8 -> 1717
    //   1712: aload 8
    //   1714: invokevirtual 304	java/net/HttpURLConnection:disconnect	()V
    //   1717: aload_1
    //   1718: athrow
    //   1719: aload 27
    //   1721: aload_1
    //   1722: aload 9
    //   1724: invokeinterface 408 3 0
    //   1729: goto -1246 -> 483
    //   1732: astore_2
    //   1733: goto -1250 -> 483
    //   1736: astore_2
    //   1737: aload_1
    //   1738: monitorexit
    //   1739: aload_2
    //   1740: athrow
    //   1741: astore_1
    //   1742: goto -786 -> 956
    //   1745: astore_1
    //   1746: goto -778 -> 968
    //   1749: astore_1
    //   1750: goto -772 -> 978
    //   1753: astore 10
    //   1755: goto -228 -> 1527
    //   1758: astore 9
    //   1760: goto -223 -> 1537
    //   1763: astore 7
    //   1765: goto -218 -> 1547
    //   1768: astore_2
    //   1769: goto -1389 -> 380
    //   1772: astore_2
    //   1773: goto -1383 -> 390
    //   1776: astore_2
    //   1777: goto -1377 -> 400
    //   1780: astore_2
    //   1781: iload 5
    //   1783: istore 4
    //   1785: aload 10
    //   1787: astore 7
    //   1789: aload 15
    //   1791: astore 9
    //   1793: goto -1359 -> 434
    //   1796: astore_2
    //   1797: goto -1104 -> 693
    //   1800: astore_2
    //   1801: goto -1098 -> 703
    //   1804: astore_2
    //   1805: goto -1092 -> 713
    //   1808: astore_2
    //   1809: goto -122 -> 1687
    //   1812: astore_2
    //   1813: goto -116 -> 1697
    //   1816: astore_2
    //   1817: goto -110 -> 1707
    //   1820: astore_2
    //   1821: goto -104 -> 1717
    //   1824: astore_2
    //   1825: goto -1342 -> 483
    //   1828: astore_1
    //   1829: aload 16
    //   1831: astore_2
    //   1832: aload 19
    //   1834: astore 10
    //   1836: goto -157 -> 1679
    //   1839: astore_1
    //   1840: aload 9
    //   1842: astore 7
    //   1844: aload 16
    //   1846: astore_2
    //   1847: aload 19
    //   1849: astore 10
    //   1851: goto -172 -> 1679
    //   1854: astore_1
    //   1855: aload 16
    //   1857: astore_2
    //   1858: goto -179 -> 1679
    //   1861: astore_1
    //   1862: aload 16
    //   1864: astore_2
    //   1865: aload 19
    //   1867: astore 10
    //   1869: goto -190 -> 1679
    //   1872: astore_1
    //   1873: aload 11
    //   1875: astore_2
    //   1876: aload 14
    //   1878: astore 7
    //   1880: aload 13
    //   1882: astore 8
    //   1884: goto -205 -> 1679
    //   1887: astore 9
    //   1889: aconst_null
    //   1890: astore 8
    //   1892: aconst_null
    //   1893: astore 7
    //   1895: aconst_null
    //   1896: astore_2
    //   1897: aload 17
    //   1899: astore 12
    //   1901: goto -1272 -> 629
    //   1904: astore 9
    //   1906: aconst_null
    //   1907: astore_2
    //   1908: aload 17
    //   1910: astore 12
    //   1912: goto -1283 -> 629
    //   1915: astore 10
    //   1917: aload 9
    //   1919: astore 7
    //   1921: aconst_null
    //   1922: astore_2
    //   1923: aload 10
    //   1925: astore 9
    //   1927: aload 17
    //   1929: astore 12
    //   1931: goto -1302 -> 629
    //   1934: astore 9
    //   1936: aconst_null
    //   1937: astore_2
    //   1938: aload 17
    //   1940: astore 12
    //   1942: goto -1313 -> 629
    //   1945: astore 9
    //   1947: aconst_null
    //   1948: astore 8
    //   1950: aconst_null
    //   1951: astore 7
    //   1953: aconst_null
    //   1954: astore_2
    //   1955: aload 14
    //   1957: astore 15
    //   1959: aload 18
    //   1961: astore 12
    //   1963: goto -1647 -> 316
    //   1966: astore 9
    //   1968: aconst_null
    //   1969: astore_2
    //   1970: aload 14
    //   1972: astore 15
    //   1974: aload 18
    //   1976: astore 12
    //   1978: goto -1662 -> 316
    //   1981: astore 10
    //   1983: aload 9
    //   1985: astore 7
    //   1987: aconst_null
    //   1988: astore_2
    //   1989: aload 10
    //   1991: astore 9
    //   1993: aload 14
    //   1995: astore 15
    //   1997: aload 18
    //   1999: astore 12
    //   2001: goto -1685 -> 316
    //   2004: astore 9
    //   2006: aconst_null
    //   2007: astore_2
    //   2008: aload 14
    //   2010: astore 15
    //   2012: aload 18
    //   2014: astore 12
    //   2016: goto -1700 -> 316
    //   2019: astore 9
    //   2021: goto -1432 -> 589
    //   2024: goto -1892 -> 132
    //   2027: astore 9
    //   2029: aload 20
    //   2031: astore 15
    //   2033: aload 18
    //   2035: astore_2
    //   2036: aload 17
    //   2038: astore 12
    //   2040: goto -1724 -> 316
    //   2043: astore 9
    //   2045: aload 21
    //   2047: astore 15
    //   2049: aload 19
    //   2051: astore_2
    //   2052: aload 16
    //   2054: astore 12
    //   2056: goto -1427 -> 629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2059	0	this	ew
    //   0	2059	1	paramex	ex
    //   0	2059	2	parama	a
    //   0	2059	3	paramBoolean	boolean
    //   68	1716	4	m	int
    //   52	1730	5	n	int
    //   187	1440	6	i1	int
    //   31	1544	7	localObject1	Object
    //   1582	1	7	localException1	java.lang.Exception
    //   1590	113	7	localObject2	Object
    //   1763	1	7	localException2	java.lang.Exception
    //   1787	199	7	localObject3	Object
    //   7	1942	8	localObject4	Object
    //   76	49	9	localObject5	Object
    //   304	52	9	localException3	java.lang.Exception
    //   366	59	9	localObject6	Object
    //   621	48	9	localThrowable1	java.lang.Throwable
    //   679	1044	9	localObject7	Object
    //   1758	1	9	localIOException1	java.io.IOException
    //   1791	50	9	localObject8	Object
    //   1887	1	9	localThrowable2	java.lang.Throwable
    //   1904	14	9	localThrowable3	java.lang.Throwable
    //   1925	1	9	localObject9	Object
    //   1934	1	9	localThrowable4	java.lang.Throwable
    //   1945	1	9	localException4	java.lang.Exception
    //   1966	18	9	localException5	java.lang.Exception
    //   1991	1	9	localObject10	Object
    //   2004	1	9	localException6	java.lang.Exception
    //   2019	1	9	localThrowable5	java.lang.Throwable
    //   2027	1	9	localException7	java.lang.Exception
    //   2043	1	9	localThrowable6	java.lang.Throwable
    //   86	1607	10	localObject11	Object
    //   1753	33	10	localIOException2	java.io.IOException
    //   1834	34	10	localObject12	Object
    //   1915	9	10	localThrowable7	java.lang.Throwable
    //   1981	9	10	localException8	java.lang.Exception
    //   134	1740	11	localObject13	Object
    //   65	1990	12	localObject14	Object
    //   138	1743	13	localObject15	Object
    //   49	1960	14	localObject16	Object
    //   37	2011	15	localObject17	Object
    //   34	2019	16	localObject18	Object
    //   16	2021	17	localObject19	Object
    //   10	2024	18	localObject20	Object
    //   22	2028	19	localObject21	Object
    //   19	2011	20	localObject22	Object
    //   13	2033	21	localObject23	Object
    //   46	1401	22	localObject24	Object
    //   43	1392	23	localObject25	Object
    //   25	1585	24	localObject26	Object
    //   28	1574	25	localObject27	Object
    //   40	1616	26	localObject28	Object
    //   4	1716	27	localey	ey
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
    //   547	557	304	java/lang/Exception
    //   570	575	304	java/lang/Exception
    //   583	589	304	java/lang/Exception
    //   610	621	304	java/lang/Exception
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
    //   1613	1649	304	java/lang/Exception
    //   144	170	621	java/lang/Throwable
    //   182	189	621	java/lang/Throwable
    //   302	304	621	java/lang/Throwable
    //   547	557	621	java/lang/Throwable
    //   610	621	621	java/lang/Throwable
    //   778	785	621	java/lang/Throwable
    //   819	826	621	java/lang/Throwable
    //   838	844	621	java/lang/Throwable
    //   870	877	621	java/lang/Throwable
    //   889	901	621	java/lang/Throwable
    //   913	925	621	java/lang/Throwable
    //   937	944	621	java/lang/Throwable
    //   1003	1010	621	java/lang/Throwable
    //   1025	1035	621	java/lang/Throwable
    //   1047	1054	621	java/lang/Throwable
    //   1066	1075	621	java/lang/Throwable
    //   1613	1649	621	java/lang/Throwable
    //   730	735	750	java/lang/Exception
    //   983	988	989	java/lang/Exception
    //   1563	1568	1582	java/lang/Exception
    //   54	67	1665	finally
    //   1719	1729	1732	java/lang/Throwable
    //   503	512	1736	finally
    //   1737	1739	1736	finally
    //   948	956	1741	java/io/IOException
    //   960	968	1745	java/io/IOException
    //   973	978	1749	java/lang/Exception
    //   1522	1527	1753	java/io/IOException
    //   1532	1537	1758	java/io/IOException
    //   1542	1547	1763	java/lang/Exception
    //   376	380	1768	java/io/IOException
    //   385	390	1772	java/io/IOException
    //   395	400	1776	java/lang/Exception
    //   417	422	1780	java/lang/Exception
    //   689	693	1796	java/io/IOException
    //   698	703	1800	java/io/IOException
    //   708	713	1804	java/lang/Exception
    //   1683	1687	1808	java/io/IOException
    //   1692	1697	1812	java/io/IOException
    //   1702	1707	1816	java/lang/Exception
    //   1712	1717	1820	java/lang/Exception
    //   449	483	1824	java/lang/Throwable
    //   82	88	1828	finally
    //   93	112	1828	finally
    //   112	129	1839	finally
    //   144	170	1854	finally
    //   182	189	1854	finally
    //   208	213	1854	finally
    //   221	227	1854	finally
    //   235	280	1854	finally
    //   302	304	1854	finally
    //   547	557	1854	finally
    //   570	575	1854	finally
    //   583	589	1854	finally
    //   610	621	1854	finally
    //   778	785	1854	finally
    //   819	826	1854	finally
    //   838	844	1854	finally
    //   870	877	1854	finally
    //   889	901	1854	finally
    //   913	925	1854	finally
    //   937	944	1854	finally
    //   1003	1010	1854	finally
    //   1025	1035	1854	finally
    //   1047	1054	1854	finally
    //   1066	1075	1854	finally
    //   1613	1649	1854	finally
    //   70	78	1861	finally
    //   334	368	1872	finally
    //   647	681	1872	finally
    //   1115	1122	1872	finally
    //   1168	1175	1872	finally
    //   1215	1222	1872	finally
    //   1262	1273	1872	finally
    //   1313	1320	1872	finally
    //   1360	1370	1872	finally
    //   1413	1418	1872	finally
    //   1458	1464	1872	finally
    //   1507	1517	1872	finally
    //   54	67	1887	java/lang/Throwable
    //   82	88	1904	java/lang/Throwable
    //   93	112	1904	java/lang/Throwable
    //   112	129	1915	java/lang/Throwable
    //   70	78	1934	java/lang/Throwable
    //   54	67	1945	java/lang/Exception
    //   82	88	1966	java/lang/Exception
    //   93	112	1966	java/lang/Exception
    //   112	129	1981	java/lang/Exception
    //   70	78	2004	java/lang/Exception
    //   570	575	2019	java/lang/Throwable
    //   583	589	2019	java/lang/Throwable
    //   1115	1122	2027	java/lang/Exception
    //   1168	1175	2027	java/lang/Exception
    //   1215	1222	2027	java/lang/Exception
    //   1262	1273	2027	java/lang/Exception
    //   1313	1320	2027	java/lang/Exception
    //   1360	1370	2027	java/lang/Exception
    //   1413	1418	2027	java/lang/Exception
    //   1458	1464	2027	java/lang/Exception
    //   1507	1517	2027	java/lang/Exception
    //   1115	1122	2043	java/lang/Throwable
    //   1168	1175	2043	java/lang/Throwable
    //   1215	1222	2043	java/lang/Throwable
    //   1262	1273	2043	java/lang/Throwable
    //   1313	1320	2043	java/lang/Throwable
    //   1360	1370	2043	java/lang/Throwable
    //   1413	1418	2043	java/lang/Throwable
    //   1458	1464	2043	java/lang/Throwable
    //   1507	1517	2043	java/lang/Throwable
  }
  
  public int a(ex paramex)
  {
    synchronized (this.i)
    {
      if ((!this.g) && (this.b.size() < this.e))
      {
        int m = this.a + 1;
        this.a = m;
        paramex.a(m);
        this.b.addElement(paramex);
        paramex.b().a(paramex, 0);
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
        if (ew.a(ew.this))
        {
          synchronized (ew.b(ew.this))
          {
            label20:
            int i = ew.c(ew.this).size();
            if (i != 0) {}
          }
          try
          {
            ew.b(ew.this).wait();
            label45:
            if (ew.a(ew.this)) {
              break label20;
            }
            return;
            ex localex = (ex)ew.c(ew.this).firstElement();
            if ((ew.d(ew.this)) || (localex.d() == 1))
            {
              ew.c(ew.this).removeElement(localex);
              this.a = localex.d();
            }
            try
            {
              for (;;)
              {
                Thread.sleep(100L);
                label118:
                this.b = false;
                ew.a(ew.this, localex, this, false);
                this.a = -1;
                break;
                try
                {
                  ew.b(ew.this).wait();
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
 * Qualified Name:     com.tencent.token.ew
 * JD-Core Version:    0.7.0.1
 */