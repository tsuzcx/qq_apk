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

public class ez
{
  private static String j = "10.0.0.172";
  private static int k = 80;
  private int a;
  private Vector b;
  private a[] c;
  private final int d;
  private final int e;
  private volatile boolean f;
  private boolean g;
  private volatile boolean h;
  private int[] i;
  
  public ez(int paramInt1, int paramInt2)
  {
    int m = 0;
    this.a = 0;
    this.b = new Vector();
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = new int[0];
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
  
  private static HttpURLConnection a(String paramString, fa paramfa)
  {
    Object localObject2 = new URL(paramString);
    Object localObject1 = RqdApplication.n();
    if (localObject1 != null)
    {
      localObject1 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).getType() == 0))
      {
        String str = android.net.Proxy.getDefaultHost();
        int m = android.net.Proxy.getDefaultPort();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("conn proxy host=");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(", port=");
        ((StringBuilder)localObject3).append(m);
        g.a(((StringBuilder)localObject3).toString());
        localObject3 = ((NetworkInfo)localObject1).getExtraInfo();
        if ((str != null) && (-1 != m) && (localObject3 != null) && ((((String)localObject3).toLowerCase(Locale.getDefault()).equals("cmwap")) || (((String)localObject3).toLowerCase(Locale.getDefault()).equals("uniwap")) || (((String)localObject3).toLowerCase(Locale.getDefault()).equals("3gwap"))))
        {
          localObject3 = l.e(paramString);
          str = l.f(paramString);
          if ((localObject3 != null) && (str != null) && (paramString.length() > ((String)localObject3).length() + str.length()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("default proxy host: ");
            ((StringBuilder)localObject2).append(android.net.Proxy.getDefaultHost());
            ((StringBuilder)localObject2).append(", port: ");
            ((StringBuilder)localObject2).append(android.net.Proxy.getDefaultPort());
            g.a(((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(android.net.Proxy.getDefaultHost());
            ((StringBuilder)localObject2).append(paramString.substring(((String)localObject3).length() + str.length()));
            paramString = ((StringBuilder)localObject2).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("wap urlAssem: ");
            ((StringBuilder)localObject2).append(paramString);
            g.a(((StringBuilder)localObject2).toString());
            paramString = (HttpURLConnection)new URL(paramString).openConnection();
            paramString.setRequestProperty("X-Online-Host", str);
            paramString.setRequestProperty("Host", android.net.Proxy.getDefaultHost());
          }
          else
          {
            paramString = (HttpURLConnection)((URL)localObject2).openConnection();
          }
        }
        else if ((str != null) && (-1 != m) && (localObject3 != null) && (((String)localObject3).toLowerCase(Locale.getDefault()).equals("ctwap")))
        {
          paramString = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
          paramString = (HttpURLConnection)((URL)localObject2).openConnection(new java.net.Proxy(Proxy.Type.HTTP, paramString));
        }
        else
        {
          paramString = (HttpURLConnection)((URL)localObject2).openConnection();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("conn type is mobile type=");
        ((StringBuilder)localObject2).append(((NetworkInfo)localObject1).getExtraInfo());
        g.a(((StringBuilder)localObject2).toString());
      }
      else
      {
        paramString = (HttpURLConnection)((URL)localObject2).openConnection();
        g.a("conn type is wifi");
      }
    }
    else
    {
      paramString = (HttpURLConnection)((URL)localObject2).openConnection();
      g.a("Context is null, don't get connect type");
    }
    paramString.setConnectTimeout(20000);
    paramString.setReadTimeout(30000);
    paramString.setRequestMethod(paramfa.e());
    localObject1 = paramfa.a.keys();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      localObject2 = (String)((Enumeration)localObject1).nextElement();
      paramString.setRequestProperty((String)localObject2, (String)paramfa.a.get(localObject2));
    }
    return paramString;
  }
  
  private void a(fa paramfa, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramfa.b().a(paramfa, paramInt);
    }
  }
  
  /* Error */
  private void a(fa paramfa, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 253	com/tencent/token/fa:b	()Lcom/tencent/token/fb;
    //   4: astore 16
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_0
    //   10: aload_1
    //   11: iconst_1
    //   12: iload_3
    //   13: invokespecial 266	com/tencent/token/ez:a	(Lcom/tencent/token/fa;IZ)V
    //   16: aload_1
    //   17: invokevirtual 268	com/tencent/token/fa:a	()Ljava/lang/String;
    //   20: astore 8
    //   22: iconst_0
    //   23: istore 4
    //   25: aconst_null
    //   26: astore 7
    //   28: aload 7
    //   30: astore 10
    //   32: aload 7
    //   34: astore 11
    //   36: aload 7
    //   38: astore 12
    //   40: aload 8
    //   42: aload_1
    //   43: invokestatic 270	com/tencent/token/ez:a	(Ljava/lang/String;Lcom/tencent/token/fa;)Ljava/net/HttpURLConnection;
    //   46: astore 7
    //   48: aload 7
    //   50: astore 10
    //   52: aload 7
    //   54: astore 11
    //   56: aload 7
    //   58: astore 12
    //   60: aload_1
    //   61: invokevirtual 273	com/tencent/token/fa:c	()[B
    //   64: astore 13
    //   66: aload 13
    //   68: ifnull +127 -> 195
    //   71: aload 7
    //   73: astore 10
    //   75: aload 7
    //   77: astore 11
    //   79: aload 7
    //   81: astore 12
    //   83: aload 13
    //   85: arraylength
    //   86: ifeq +109 -> 195
    //   89: aload 7
    //   91: astore 10
    //   93: aload 7
    //   95: astore 11
    //   97: aload 7
    //   99: astore 12
    //   101: aload 7
    //   103: iconst_1
    //   104: invokevirtual 277	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   107: aload 7
    //   109: astore 10
    //   111: aload 7
    //   113: astore 11
    //   115: aload 7
    //   117: astore 12
    //   119: aload 7
    //   121: invokevirtual 281	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   124: astore 9
    //   126: aload 9
    //   128: aload 13
    //   130: invokevirtual 287	java/io/OutputStream:write	([B)V
    //   133: aload 9
    //   135: invokevirtual 290	java/io/OutputStream:flush	()V
    //   138: aload 9
    //   140: invokevirtual 293	java/io/OutputStream:close	()V
    //   143: goto +52 -> 195
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: aconst_null
    //   150: astore 8
    //   152: aload 9
    //   154: astore 11
    //   156: goto +1713 -> 1869
    //   159: astore 15
    //   161: aconst_null
    //   162: astore 8
    //   164: aconst_null
    //   165: astore 14
    //   167: aconst_null
    //   168: astore 13
    //   170: aload 9
    //   172: astore 12
    //   174: goto +1175 -> 1349
    //   177: astore 15
    //   179: aconst_null
    //   180: astore 8
    //   182: aconst_null
    //   183: astore 14
    //   185: aconst_null
    //   186: astore 13
    //   188: aload 9
    //   190: astore 12
    //   192: goto +1363 -> 1555
    //   195: aload 7
    //   197: astore 10
    //   199: aload 7
    //   201: astore 11
    //   203: aload 7
    //   205: astore 12
    //   207: new 104	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   214: astore 9
    //   216: aload 7
    //   218: astore 10
    //   220: aload 7
    //   222: astore 11
    //   224: aload 7
    //   226: astore 12
    //   228: aload 9
    //   230: ldc_w 295
    //   233: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 7
    //   239: astore 10
    //   241: aload 7
    //   243: astore 11
    //   245: aload 7
    //   247: astore 12
    //   249: aload 9
    //   251: aload_1
    //   252: invokevirtual 268	com/tencent/token/fa:a	()Ljava/lang/String;
    //   255: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 7
    //   261: astore 10
    //   263: aload 7
    //   265: astore 11
    //   267: aload 7
    //   269: astore 12
    //   271: aload 9
    //   273: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   279: aload 7
    //   281: astore 10
    //   283: aload 7
    //   285: astore 11
    //   287: aload 7
    //   289: astore 12
    //   291: aload 7
    //   293: invokevirtual 298	java/net/HttpURLConnection:getResponseCode	()I
    //   296: istore 6
    //   298: iconst_m1
    //   299: iload 6
    //   301: if_icmpne +1696 -> 1997
    //   304: aload 8
    //   306: ifnull +1691 -> 1997
    //   309: aload 7
    //   311: astore 10
    //   313: aload 7
    //   315: astore 12
    //   317: aload 7
    //   319: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   322: aload 7
    //   324: astore 10
    //   326: aload 7
    //   328: astore 12
    //   330: bipush 100
    //   332: i2l
    //   333: invokestatic 307	java/lang/Thread:sleep	(J)V
    //   336: aload 7
    //   338: astore 10
    //   340: aload 7
    //   342: astore 12
    //   344: new 104	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   351: astore 9
    //   353: aload 7
    //   355: astore 10
    //   357: aload 7
    //   359: astore 12
    //   361: aload 9
    //   363: ldc_w 309
    //   366: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 7
    //   372: astore 10
    //   374: aload 7
    //   376: astore 12
    //   378: aload 9
    //   380: iload 6
    //   382: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 7
    //   388: astore 10
    //   390: aload 7
    //   392: astore 12
    //   394: aload 9
    //   396: ldc_w 311
    //   399: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 7
    //   405: astore 10
    //   407: aload 7
    //   409: astore 12
    //   411: aload 9
    //   413: iconst_0
    //   414: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 7
    //   420: astore 10
    //   422: aload 7
    //   424: astore 12
    //   426: aload 9
    //   428: ldc_w 313
    //   431: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 7
    //   437: astore 10
    //   439: aload 7
    //   441: astore 12
    //   443: aload 9
    //   445: bipush 100
    //   447: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 7
    //   453: astore 10
    //   455: aload 7
    //   457: astore 12
    //   459: aload 9
    //   461: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   467: iload 4
    //   469: iconst_1
    //   470: iadd
    //   471: istore 4
    //   473: goto -445 -> 28
    //   476: astore_2
    //   477: aload 7
    //   479: astore 10
    //   481: aload 7
    //   483: astore 11
    //   485: aload 7
    //   487: astore 12
    //   489: aload_2
    //   490: athrow
    //   491: iload 4
    //   493: iconst_3
    //   494: if_icmpge +89 -> 583
    //   497: aload 7
    //   499: astore 10
    //   501: aload 7
    //   503: astore 11
    //   505: aload 7
    //   507: astore 12
    //   509: aload 7
    //   511: ldc_w 315
    //   514: invokevirtual 318	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   517: astore 8
    //   519: aload 8
    //   521: ifnull +39 -> 560
    //   524: aload 7
    //   526: astore 10
    //   528: aload 7
    //   530: astore 12
    //   532: aload 7
    //   534: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   537: aload 7
    //   539: astore 10
    //   541: aload 7
    //   543: astore 12
    //   545: ldc2_w 319
    //   548: invokestatic 307	java/lang/Thread:sleep	(J)V
    //   551: iload 4
    //   553: iconst_1
    //   554: iadd
    //   555: istore 4
    //   557: goto -529 -> 28
    //   560: aload 7
    //   562: astore 10
    //   564: aload 7
    //   566: astore 11
    //   568: aload 7
    //   570: astore 12
    //   572: new 264	java/io/IOException
    //   575: dup
    //   576: ldc_w 322
    //   579: invokespecial 323	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   582: athrow
    //   583: aload 7
    //   585: astore 10
    //   587: aload 7
    //   589: astore 11
    //   591: aload 7
    //   593: astore 12
    //   595: aload_0
    //   596: aload_1
    //   597: iconst_2
    //   598: iload_3
    //   599: invokespecial 266	com/tencent/token/ez:a	(Lcom/tencent/token/fa;IZ)V
    //   602: iload 6
    //   604: sipush 200
    //   607: if_icmpeq +154 -> 761
    //   610: iload 6
    //   612: sipush 206
    //   615: if_icmpeq +146 -> 761
    //   618: iload 6
    //   620: iconst_m1
    //   621: if_icmpne +6 -> 627
    //   624: goto +137 -> 761
    //   627: aload 7
    //   629: astore 10
    //   631: aload 7
    //   633: astore 11
    //   635: aload 7
    //   637: astore 12
    //   639: new 104	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   646: astore_2
    //   647: aload 7
    //   649: astore 10
    //   651: aload 7
    //   653: astore 11
    //   655: aload 7
    //   657: astore 12
    //   659: aload_2
    //   660: ldc_w 325
    //   663: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload 7
    //   669: astore 10
    //   671: aload 7
    //   673: astore 11
    //   675: aload 7
    //   677: astore 12
    //   679: aload_2
    //   680: iload 6
    //   682: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 7
    //   688: astore 10
    //   690: aload 7
    //   692: astore 11
    //   694: aload 7
    //   696: astore 12
    //   698: aload_2
    //   699: ldc_w 327
    //   702: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 7
    //   708: astore 10
    //   710: aload 7
    //   712: astore 11
    //   714: aload 7
    //   716: astore 12
    //   718: aload_2
    //   719: aload 7
    //   721: invokevirtual 330	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   724: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 7
    //   730: astore 10
    //   732: aload 7
    //   734: astore 11
    //   736: aload 7
    //   738: astore 12
    //   740: aload_2
    //   741: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: astore_2
    //   745: aconst_null
    //   746: astore 8
    //   748: aconst_null
    //   749: astore 9
    //   751: aconst_null
    //   752: astore 10
    //   754: iload 5
    //   756: istore 4
    //   758: goto +310 -> 1068
    //   761: aload 7
    //   763: astore 10
    //   765: aload 7
    //   767: astore 11
    //   769: aload 7
    //   771: astore 12
    //   773: aload 7
    //   775: invokevirtual 333	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   778: astore 8
    //   780: aload 7
    //   782: astore 10
    //   784: aload 7
    //   786: astore 11
    //   788: aload 7
    //   790: astore 12
    //   792: aload_1
    //   793: aload 8
    //   795: putfield 335	com/tencent/token/fa:b	Ljava/lang/String;
    //   798: aload 8
    //   800: ifnonnull +11 -> 811
    //   803: ldc_w 337
    //   806: astore 8
    //   808: goto +22 -> 830
    //   811: aload 7
    //   813: astore 10
    //   815: aload 7
    //   817: astore 11
    //   819: aload 7
    //   821: astore 12
    //   823: aload 8
    //   825: invokevirtual 339	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   828: astore 8
    //   830: iload_3
    //   831: ifne +100 -> 931
    //   834: aload 7
    //   836: astore 10
    //   838: aload 7
    //   840: astore 11
    //   842: aload 7
    //   844: astore 12
    //   846: aload_1
    //   847: getfield 341	com/tencent/token/fa:e	Z
    //   850: ifeq +81 -> 931
    //   853: aload 7
    //   855: astore 10
    //   857: aload 7
    //   859: astore 11
    //   861: aload 7
    //   863: astore 12
    //   865: aload 8
    //   867: ldc_w 343
    //   870: invokevirtual 347	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   873: iconst_m1
    //   874: if_icmpne +27 -> 901
    //   877: aload 7
    //   879: astore 10
    //   881: aload 7
    //   883: astore 11
    //   885: aload 7
    //   887: astore 12
    //   889: aload 8
    //   891: ldc_w 349
    //   894: invokevirtual 347	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   897: iconst_m1
    //   898: if_icmpeq +33 -> 931
    //   901: aload 7
    //   903: astore 10
    //   905: aload 7
    //   907: astore 11
    //   909: aload 7
    //   911: astore 12
    //   913: aload_0
    //   914: aload_1
    //   915: aload_2
    //   916: iconst_1
    //   917: invokespecial 249	com/tencent/token/ez:a	(Lcom/tencent/token/fa;Lcom/tencent/token/ez$a;Z)V
    //   920: aload 7
    //   922: ifnull +8 -> 930
    //   925: aload 7
    //   927: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   930: return
    //   931: aload 7
    //   933: astore 10
    //   935: aload 7
    //   937: astore 11
    //   939: aload 7
    //   941: astore 12
    //   943: aload_1
    //   944: aload 7
    //   946: invokevirtual 352	java/net/HttpURLConnection:getContentLength	()I
    //   949: i2l
    //   950: putfield 355	com/tencent/token/fa:c	J
    //   953: aload 7
    //   955: astore 10
    //   957: aload 7
    //   959: astore 11
    //   961: aload 7
    //   963: astore 12
    //   965: aload 7
    //   967: invokevirtual 359	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   970: astore 8
    //   972: new 361	java/io/ByteArrayOutputStream
    //   975: dup
    //   976: invokespecial 362	java/io/ByteArrayOutputStream:<init>	()V
    //   979: astore 9
    //   981: aload 8
    //   983: invokevirtual 367	java/io/InputStream:read	()I
    //   986: istore 4
    //   988: iload 4
    //   990: iconst_m1
    //   991: if_icmpeq +48 -> 1039
    //   994: aload_0
    //   995: getfield 42	com/tencent/token/ez:f	Z
    //   998: ifeq +30 -> 1028
    //   1001: aload_2
    //   1002: getfield 369	com/tencent/token/ez$a:b	Z
    //   1005: ifne +23 -> 1028
    //   1008: aload 9
    //   1010: iload 4
    //   1012: invokevirtual 371	java/io/ByteArrayOutputStream:write	(I)V
    //   1015: aload_1
    //   1016: aload_1
    //   1017: getfield 373	com/tencent/token/fa:d	J
    //   1020: lconst_1
    //   1021: ladd
    //   1022: putfield 373	com/tencent/token/fa:d	J
    //   1025: goto -44 -> 981
    //   1028: new 264	java/io/IOException
    //   1031: dup
    //   1032: ldc_w 375
    //   1035: invokespecial 323	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1038: athrow
    //   1039: aload 9
    //   1041: invokevirtual 376	java/io/ByteArrayOutputStream:flush	()V
    //   1044: aload 9
    //   1046: invokevirtual 379	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1049: astore_2
    //   1050: ldc_w 337
    //   1053: astore 11
    //   1055: iconst_0
    //   1056: istore 4
    //   1058: aload 9
    //   1060: astore 10
    //   1062: aload_2
    //   1063: astore 9
    //   1065: aload 11
    //   1067: astore_2
    //   1068: aload 16
    //   1070: aload_1
    //   1071: iconst_3
    //   1072: invokeinterface 258 3 0
    //   1077: pop
    //   1078: aload 10
    //   1080: ifnull +11 -> 1091
    //   1083: aload 10
    //   1085: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   1088: goto +3 -> 1091
    //   1091: aload 8
    //   1093: ifnull +8 -> 1101
    //   1096: aload 8
    //   1098: invokevirtual 381	java/io/InputStream:close	()V
    //   1101: aload_2
    //   1102: astore 8
    //   1104: aload 9
    //   1106: astore 10
    //   1108: iload 4
    //   1110: istore 5
    //   1112: aload 7
    //   1114: ifnull +636 -> 1750
    //   1117: aload 7
    //   1119: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   1122: aload_2
    //   1123: astore 8
    //   1125: aload 9
    //   1127: astore 10
    //   1129: iload 4
    //   1131: istore 5
    //   1133: goto +617 -> 1750
    //   1136: aload_2
    //   1137: astore 8
    //   1139: aload 9
    //   1141: astore 10
    //   1143: iload 4
    //   1145: istore 5
    //   1147: goto +603 -> 1750
    //   1150: astore_1
    //   1151: aload 10
    //   1153: astore_2
    //   1154: goto +162 -> 1316
    //   1157: astore_2
    //   1158: aload 8
    //   1160: astore 11
    //   1162: aload 9
    //   1164: astore 8
    //   1166: aload 10
    //   1168: astore 9
    //   1170: aload 11
    //   1172: astore 10
    //   1174: goto +161 -> 1335
    //   1177: astore_2
    //   1178: aload 8
    //   1180: astore 11
    //   1182: aload 9
    //   1184: astore 8
    //   1186: aload 10
    //   1188: astore 9
    //   1190: aload 11
    //   1192: astore 10
    //   1194: goto +347 -> 1541
    //   1197: astore_1
    //   1198: aload 9
    //   1200: astore_2
    //   1201: goto +115 -> 1316
    //   1204: astore_2
    //   1205: aload 8
    //   1207: astore 10
    //   1209: aconst_null
    //   1210: astore 8
    //   1212: goto +123 -> 1335
    //   1215: astore_2
    //   1216: aload 8
    //   1218: astore 10
    //   1220: aconst_null
    //   1221: astore 8
    //   1223: goto +318 -> 1541
    //   1226: astore_1
    //   1227: aconst_null
    //   1228: astore_2
    //   1229: goto +87 -> 1316
    //   1232: astore_2
    //   1233: aload 8
    //   1235: astore 10
    //   1237: aconst_null
    //   1238: astore 8
    //   1240: aconst_null
    //   1241: astore 9
    //   1243: goto +92 -> 1335
    //   1246: astore_2
    //   1247: aload 8
    //   1249: astore 10
    //   1251: aconst_null
    //   1252: astore 8
    //   1254: aconst_null
    //   1255: astore 9
    //   1257: goto +284 -> 1541
    //   1260: astore_1
    //   1261: aconst_null
    //   1262: astore_2
    //   1263: aconst_null
    //   1264: astore 8
    //   1266: aload 10
    //   1268: astore 7
    //   1270: goto +46 -> 1316
    //   1273: astore_2
    //   1274: aconst_null
    //   1275: astore 8
    //   1277: aconst_null
    //   1278: astore 9
    //   1280: aconst_null
    //   1281: astore 10
    //   1283: aload 11
    //   1285: astore 7
    //   1287: goto +48 -> 1335
    //   1290: astore_2
    //   1291: aconst_null
    //   1292: astore 8
    //   1294: aconst_null
    //   1295: astore 9
    //   1297: aconst_null
    //   1298: astore 10
    //   1300: aload 12
    //   1302: astore 7
    //   1304: goto +237 -> 1541
    //   1307: astore_1
    //   1308: aconst_null
    //   1309: astore_2
    //   1310: aconst_null
    //   1311: astore 8
    //   1313: aconst_null
    //   1314: astore 7
    //   1316: aconst_null
    //   1317: astore 11
    //   1319: goto +550 -> 1869
    //   1322: astore_2
    //   1323: aconst_null
    //   1324: astore 8
    //   1326: aconst_null
    //   1327: astore 9
    //   1329: aconst_null
    //   1330: astore 10
    //   1332: aconst_null
    //   1333: astore 7
    //   1335: aconst_null
    //   1336: astore 12
    //   1338: aload 10
    //   1340: astore 13
    //   1342: aload 9
    //   1344: astore 14
    //   1346: aload_2
    //   1347: astore 15
    //   1349: aload 14
    //   1351: astore_2
    //   1352: aload 13
    //   1354: astore 9
    //   1356: aload 7
    //   1358: astore 10
    //   1360: aload 12
    //   1362: astore 11
    //   1364: new 104	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1371: astore 17
    //   1373: aload 14
    //   1375: astore_2
    //   1376: aload 13
    //   1378: astore 9
    //   1380: aload 7
    //   1382: astore 10
    //   1384: aload 12
    //   1386: astore 11
    //   1388: aload 17
    //   1390: aload 15
    //   1392: invokevirtual 382	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1395: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload 14
    //   1401: astore_2
    //   1402: aload 13
    //   1404: astore 9
    //   1406: aload 7
    //   1408: astore 10
    //   1410: aload 12
    //   1412: astore 11
    //   1414: aload 17
    //   1416: ldc_w 384
    //   1419: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: pop
    //   1423: aload 14
    //   1425: astore_2
    //   1426: aload 13
    //   1428: astore 9
    //   1430: aload 7
    //   1432: astore 10
    //   1434: aload 12
    //   1436: astore 11
    //   1438: aload 17
    //   1440: aload 15
    //   1442: invokevirtual 387	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1445: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload 14
    //   1451: astore_2
    //   1452: aload 13
    //   1454: astore 9
    //   1456: aload 7
    //   1458: astore 10
    //   1460: aload 12
    //   1462: astore 11
    //   1464: aload 17
    //   1466: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: astore 15
    //   1471: aload 14
    //   1473: ifnull +11 -> 1484
    //   1476: aload 14
    //   1478: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   1481: goto +3 -> 1484
    //   1484: aload 13
    //   1486: ifnull +11 -> 1497
    //   1489: aload 13
    //   1491: invokevirtual 381	java/io/InputStream:close	()V
    //   1494: goto +3 -> 1497
    //   1497: aload 12
    //   1499: ifnull +11 -> 1510
    //   1502: aload 12
    //   1504: invokevirtual 293	java/io/OutputStream:close	()V
    //   1507: goto +3 -> 1510
    //   1510: aload 15
    //   1512: astore_2
    //   1513: aload 8
    //   1515: astore 9
    //   1517: aload 7
    //   1519: ifnull +221 -> 1740
    //   1522: aload 15
    //   1524: astore_2
    //   1525: goto +206 -> 1731
    //   1528: astore_2
    //   1529: aconst_null
    //   1530: astore 8
    //   1532: aconst_null
    //   1533: astore 9
    //   1535: aconst_null
    //   1536: astore 10
    //   1538: aconst_null
    //   1539: astore 7
    //   1541: aconst_null
    //   1542: astore 12
    //   1544: aload 10
    //   1546: astore 13
    //   1548: aload 9
    //   1550: astore 14
    //   1552: aload_2
    //   1553: astore 15
    //   1555: aload 14
    //   1557: astore_2
    //   1558: aload 13
    //   1560: astore 9
    //   1562: aload 7
    //   1564: astore 10
    //   1566: aload 12
    //   1568: astore 11
    //   1570: new 104	java/lang/StringBuilder
    //   1573: dup
    //   1574: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1577: astore 17
    //   1579: aload 14
    //   1581: astore_2
    //   1582: aload 13
    //   1584: astore 9
    //   1586: aload 7
    //   1588: astore 10
    //   1590: aload 12
    //   1592: astore 11
    //   1594: aload 17
    //   1596: aload 15
    //   1598: invokevirtual 388	java/lang/Exception:toString	()Ljava/lang/String;
    //   1601: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload 14
    //   1607: astore_2
    //   1608: aload 13
    //   1610: astore 9
    //   1612: aload 7
    //   1614: astore 10
    //   1616: aload 12
    //   1618: astore 11
    //   1620: aload 17
    //   1622: ldc_w 384
    //   1625: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: pop
    //   1629: aload 14
    //   1631: astore_2
    //   1632: aload 13
    //   1634: astore 9
    //   1636: aload 7
    //   1638: astore 10
    //   1640: aload 12
    //   1642: astore 11
    //   1644: aload 17
    //   1646: aload 15
    //   1648: invokevirtual 389	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1651: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1654: pop
    //   1655: aload 14
    //   1657: astore_2
    //   1658: aload 13
    //   1660: astore 9
    //   1662: aload 7
    //   1664: astore 10
    //   1666: aload 12
    //   1668: astore 11
    //   1670: aload 17
    //   1672: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: astore 15
    //   1677: aload 14
    //   1679: ifnull +11 -> 1690
    //   1682: aload 14
    //   1684: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   1687: goto +3 -> 1690
    //   1690: aload 13
    //   1692: ifnull +11 -> 1703
    //   1695: aload 13
    //   1697: invokevirtual 381	java/io/InputStream:close	()V
    //   1700: goto +3 -> 1703
    //   1703: aload 12
    //   1705: ifnull +11 -> 1716
    //   1708: aload 12
    //   1710: invokevirtual 293	java/io/OutputStream:close	()V
    //   1713: goto +3 -> 1716
    //   1716: aload 15
    //   1718: astore_2
    //   1719: aload 8
    //   1721: astore 9
    //   1723: aload 7
    //   1725: ifnull +15 -> 1740
    //   1728: aload 15
    //   1730: astore_2
    //   1731: aload 7
    //   1733: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   1736: aload 8
    //   1738: astore 9
    //   1740: iconst_1
    //   1741: istore 5
    //   1743: aload 9
    //   1745: astore 10
    //   1747: aload_2
    //   1748: astore 8
    //   1750: aload 16
    //   1752: aload_1
    //   1753: iconst_4
    //   1754: invokeinterface 258 3 0
    //   1759: pop
    //   1760: iload 5
    //   1762: ifeq +49 -> 1811
    //   1765: aload 16
    //   1767: aload_1
    //   1768: aload 8
    //   1770: invokeinterface 392 3 0
    //   1775: new 104	java/lang/StringBuilder
    //   1778: dup
    //   1779: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1782: astore_2
    //   1783: aload_2
    //   1784: ldc_w 394
    //   1787: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: pop
    //   1791: aload_2
    //   1792: aload 8
    //   1794: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: pop
    //   1798: aload_2
    //   1799: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 123	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1805: goto +19 -> 1824
    //   1808: goto +16 -> 1824
    //   1811: aload 16
    //   1813: aload_1
    //   1814: aload 10
    //   1816: invokeinterface 397 3 0
    //   1821: goto +3 -> 1824
    //   1824: aload_1
    //   1825: invokevirtual 399	com/tencent/token/fa:d	()I
    //   1828: iconst_1
    //   1829: if_icmpne +30 -> 1859
    //   1832: aload_0
    //   1833: iconst_1
    //   1834: putfield 46	com/tencent/token/ez:h	Z
    //   1837: aload_0
    //   1838: getfield 48	com/tencent/token/ez:i	[I
    //   1841: astore_1
    //   1842: aload_1
    //   1843: monitorenter
    //   1844: aload_0
    //   1845: getfield 48	com/tencent/token/ez:i	[I
    //   1848: invokevirtual 402	java/lang/Object:notifyAll	()V
    //   1851: aload_1
    //   1852: monitorexit
    //   1853: return
    //   1854: astore_2
    //   1855: aload_1
    //   1856: monitorexit
    //   1857: aload_2
    //   1858: athrow
    //   1859: return
    //   1860: astore_1
    //   1861: aload 10
    //   1863: astore 7
    //   1865: aload 9
    //   1867: astore 8
    //   1869: aload_2
    //   1870: ifnull +10 -> 1880
    //   1873: aload_2
    //   1874: invokevirtual 380	java/io/ByteArrayOutputStream:close	()V
    //   1877: goto +3 -> 1880
    //   1880: aload 8
    //   1882: ifnull +11 -> 1893
    //   1885: aload 8
    //   1887: invokevirtual 381	java/io/InputStream:close	()V
    //   1890: goto +3 -> 1893
    //   1893: aload 11
    //   1895: ifnull +11 -> 1906
    //   1898: aload 11
    //   1900: invokevirtual 293	java/io/OutputStream:close	()V
    //   1903: goto +3 -> 1906
    //   1906: aload 7
    //   1908: ifnull +8 -> 1916
    //   1911: aload 7
    //   1913: invokevirtual 301	java/net/HttpURLConnection:disconnect	()V
    //   1916: aload_1
    //   1917: athrow
    //   1918: astore 9
    //   1920: goto -1369 -> 551
    //   1923: astore_1
    //   1924: return
    //   1925: astore 10
    //   1927: goto -836 -> 1091
    //   1930: astore 8
    //   1932: goto -831 -> 1101
    //   1935: astore 7
    //   1937: goto -801 -> 1136
    //   1940: astore_2
    //   1941: goto -457 -> 1484
    //   1944: astore_2
    //   1945: goto -448 -> 1497
    //   1948: astore_2
    //   1949: goto -439 -> 1510
    //   1952: astore_2
    //   1953: goto -263 -> 1690
    //   1956: astore_2
    //   1957: goto -254 -> 1703
    //   1960: astore_2
    //   1961: goto -245 -> 1716
    //   1964: astore 7
    //   1966: aload 8
    //   1968: astore 9
    //   1970: goto -230 -> 1740
    //   1973: astore_2
    //   1974: goto -166 -> 1808
    //   1977: astore_2
    //   1978: goto -154 -> 1824
    //   1981: astore_2
    //   1982: goto -102 -> 1880
    //   1985: astore_2
    //   1986: goto -93 -> 1893
    //   1989: astore_2
    //   1990: goto -84 -> 1906
    //   1993: astore_2
    //   1994: goto -78 -> 1916
    //   1997: iload 6
    //   1999: sipush 302
    //   2002: if_icmpeq -1511 -> 491
    //   2005: iload 6
    //   2007: sipush 301
    //   2010: if_icmpne -1427 -> 583
    //   2013: goto -1522 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2016	0	this	ez
    //   0	2016	1	paramfa	fa
    //   0	2016	2	parama	a
    //   0	2016	3	paramBoolean	boolean
    //   23	1121	4	m	int
    //   7	1754	5	n	int
    //   296	1715	6	i1	int
    //   26	1886	7	localObject1	Object
    //   1935	1	7	localException1	java.lang.Exception
    //   1964	1	7	localException2	java.lang.Exception
    //   20	1866	8	localObject2	Object
    //   1930	37	8	localIOException1	java.io.IOException
    //   124	1742	9	localObject3	Object
    //   1918	1	9	localThrowable1	java.lang.Throwable
    //   1968	1	9	localIOException2	java.io.IOException
    //   30	1832	10	localObject4	Object
    //   1925	1	10	localIOException3	java.io.IOException
    //   34	1865	11	localObject5	Object
    //   38	1671	12	localObject6	Object
    //   64	1632	13	localObject7	Object
    //   165	1518	14	localObject8	Object
    //   159	1	15	localThrowable2	java.lang.Throwable
    //   177	1	15	localException3	java.lang.Exception
    //   1347	382	15	localObject9	Object
    //   4	1808	16	localfb	fb
    //   1371	300	17	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   126	143	146	finally
    //   126	143	159	java/lang/Throwable
    //   126	143	177	java/lang/Exception
    //   317	322	476	java/lang/Throwable
    //   330	336	476	java/lang/Throwable
    //   344	353	476	java/lang/Throwable
    //   361	370	476	java/lang/Throwable
    //   378	386	476	java/lang/Throwable
    //   394	403	476	java/lang/Throwable
    //   411	418	476	java/lang/Throwable
    //   426	435	476	java/lang/Throwable
    //   443	451	476	java/lang/Throwable
    //   459	467	476	java/lang/Throwable
    //   1068	1078	1150	finally
    //   1068	1078	1157	java/lang/Throwable
    //   1068	1078	1177	java/lang/Exception
    //   981	988	1197	finally
    //   994	1025	1197	finally
    //   1028	1039	1197	finally
    //   1039	1050	1197	finally
    //   981	988	1204	java/lang/Throwable
    //   994	1025	1204	java/lang/Throwable
    //   1028	1039	1204	java/lang/Throwable
    //   1039	1050	1204	java/lang/Throwable
    //   981	988	1215	java/lang/Exception
    //   994	1025	1215	java/lang/Exception
    //   1028	1039	1215	java/lang/Exception
    //   1039	1050	1215	java/lang/Exception
    //   972	981	1226	finally
    //   972	981	1232	java/lang/Throwable
    //   972	981	1246	java/lang/Exception
    //   40	48	1260	finally
    //   60	66	1260	finally
    //   83	89	1260	finally
    //   101	107	1260	finally
    //   119	126	1260	finally
    //   207	216	1260	finally
    //   228	237	1260	finally
    //   249	259	1260	finally
    //   271	279	1260	finally
    //   291	298	1260	finally
    //   317	322	1260	finally
    //   330	336	1260	finally
    //   344	353	1260	finally
    //   361	370	1260	finally
    //   378	386	1260	finally
    //   394	403	1260	finally
    //   411	418	1260	finally
    //   426	435	1260	finally
    //   443	451	1260	finally
    //   459	467	1260	finally
    //   489	491	1260	finally
    //   509	519	1260	finally
    //   532	537	1260	finally
    //   545	551	1260	finally
    //   572	583	1260	finally
    //   595	602	1260	finally
    //   639	647	1260	finally
    //   659	667	1260	finally
    //   679	686	1260	finally
    //   698	706	1260	finally
    //   718	728	1260	finally
    //   740	745	1260	finally
    //   773	780	1260	finally
    //   792	798	1260	finally
    //   823	830	1260	finally
    //   846	853	1260	finally
    //   865	877	1260	finally
    //   889	901	1260	finally
    //   913	920	1260	finally
    //   943	953	1260	finally
    //   965	972	1260	finally
    //   40	48	1273	java/lang/Throwable
    //   60	66	1273	java/lang/Throwable
    //   83	89	1273	java/lang/Throwable
    //   101	107	1273	java/lang/Throwable
    //   119	126	1273	java/lang/Throwable
    //   207	216	1273	java/lang/Throwable
    //   228	237	1273	java/lang/Throwable
    //   249	259	1273	java/lang/Throwable
    //   271	279	1273	java/lang/Throwable
    //   291	298	1273	java/lang/Throwable
    //   489	491	1273	java/lang/Throwable
    //   509	519	1273	java/lang/Throwable
    //   572	583	1273	java/lang/Throwable
    //   595	602	1273	java/lang/Throwable
    //   639	647	1273	java/lang/Throwable
    //   659	667	1273	java/lang/Throwable
    //   679	686	1273	java/lang/Throwable
    //   698	706	1273	java/lang/Throwable
    //   718	728	1273	java/lang/Throwable
    //   740	745	1273	java/lang/Throwable
    //   773	780	1273	java/lang/Throwable
    //   792	798	1273	java/lang/Throwable
    //   823	830	1273	java/lang/Throwable
    //   846	853	1273	java/lang/Throwable
    //   865	877	1273	java/lang/Throwable
    //   889	901	1273	java/lang/Throwable
    //   913	920	1273	java/lang/Throwable
    //   943	953	1273	java/lang/Throwable
    //   965	972	1273	java/lang/Throwable
    //   40	48	1290	java/lang/Exception
    //   60	66	1290	java/lang/Exception
    //   83	89	1290	java/lang/Exception
    //   101	107	1290	java/lang/Exception
    //   119	126	1290	java/lang/Exception
    //   207	216	1290	java/lang/Exception
    //   228	237	1290	java/lang/Exception
    //   249	259	1290	java/lang/Exception
    //   271	279	1290	java/lang/Exception
    //   291	298	1290	java/lang/Exception
    //   317	322	1290	java/lang/Exception
    //   330	336	1290	java/lang/Exception
    //   344	353	1290	java/lang/Exception
    //   361	370	1290	java/lang/Exception
    //   378	386	1290	java/lang/Exception
    //   394	403	1290	java/lang/Exception
    //   411	418	1290	java/lang/Exception
    //   426	435	1290	java/lang/Exception
    //   443	451	1290	java/lang/Exception
    //   459	467	1290	java/lang/Exception
    //   489	491	1290	java/lang/Exception
    //   509	519	1290	java/lang/Exception
    //   532	537	1290	java/lang/Exception
    //   545	551	1290	java/lang/Exception
    //   572	583	1290	java/lang/Exception
    //   595	602	1290	java/lang/Exception
    //   639	647	1290	java/lang/Exception
    //   659	667	1290	java/lang/Exception
    //   679	686	1290	java/lang/Exception
    //   698	706	1290	java/lang/Exception
    //   718	728	1290	java/lang/Exception
    //   740	745	1290	java/lang/Exception
    //   773	780	1290	java/lang/Exception
    //   792	798	1290	java/lang/Exception
    //   823	830	1290	java/lang/Exception
    //   846	853	1290	java/lang/Exception
    //   865	877	1290	java/lang/Exception
    //   889	901	1290	java/lang/Exception
    //   913	920	1290	java/lang/Exception
    //   943	953	1290	java/lang/Exception
    //   965	972	1290	java/lang/Exception
    //   9	22	1307	finally
    //   9	22	1322	java/lang/Throwable
    //   9	22	1528	java/lang/Exception
    //   1844	1853	1854	finally
    //   1855	1857	1854	finally
    //   1364	1373	1860	finally
    //   1388	1399	1860	finally
    //   1414	1423	1860	finally
    //   1438	1449	1860	finally
    //   1464	1471	1860	finally
    //   1570	1579	1860	finally
    //   1594	1605	1860	finally
    //   1620	1629	1860	finally
    //   1644	1655	1860	finally
    //   1670	1677	1860	finally
    //   532	537	1918	java/lang/Throwable
    //   545	551	1918	java/lang/Throwable
    //   925	930	1923	java/lang/Exception
    //   1083	1088	1925	java/io/IOException
    //   1096	1101	1930	java/io/IOException
    //   1117	1122	1935	java/lang/Exception
    //   1476	1481	1940	java/io/IOException
    //   1489	1494	1944	java/io/IOException
    //   1502	1507	1948	java/lang/Exception
    //   1682	1687	1952	java/io/IOException
    //   1695	1700	1956	java/io/IOException
    //   1708	1713	1960	java/lang/Exception
    //   1731	1736	1964	java/lang/Exception
    //   1765	1805	1973	java/lang/Throwable
    //   1811	1821	1977	java/lang/Throwable
    //   1873	1877	1981	java/io/IOException
    //   1885	1890	1985	java/io/IOException
    //   1898	1903	1989	java/lang/Exception
    //   1911	1916	1993	java/lang/Exception
  }
  
  public int a(fa paramfa)
  {
    synchronized (this.i)
    {
      if ((!this.g) && (this.b.size() < this.e))
      {
        int m = this.a + 1;
        this.a = m;
        paramfa.a(m);
        this.b.addElement(paramfa);
        paramfa.b().a(paramfa, 0);
        this.i.notifyAll();
        m = this.a;
        return m;
      }
      return -1;
    }
  }
  
  public void a()
  {
    if ((!this.g) && (!this.f))
    {
      this.f = true;
      int m = 0;
      while (m < this.d)
      {
        this.c[m].start();
        m += 1;
      }
      return;
    }
    throw new IllegalStateException("HttpCommunicator already in using or disposed!");
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
        label20:
        int i;
        if (ez.a(ez.this)) {
          synchronized (ez.b(ez.this))
          {
            i = ez.c(ez.this).size();
            if (i != 0) {}
          }
        }
        try
        {
          ez.b(ez.this).wait();
          break label95;
          localfa = (fa)ez.c(ez.this).firstElement();
          if (!ez.d(ez.this))
          {
            i = localfa.d();
            if (i != 1)
            {
              ez.b(ez.this).wait();
              label95:
              if (ez.a(ez.this)) {
                break label20;
              }
              return;
            }
          }
          ez.c(ez.this).removeElement(localfa);
          this.a = localfa.d();
        }
        catch (InterruptedException localInterruptedException2)
        {
          try
          {
            fa localfa;
            Thread.sleep(100L);
            label136:
            this.b = false;
            ez.a(ez.this, localfa, this, false);
            this.a = -1;
            continue;
            localObject = finally;
            throw localObject;
            return;
            localInterruptedException2 = localInterruptedException2;
          }
          catch (InterruptedException localInterruptedException1)
          {
            break label136;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ez
 * JD-Core Version:    0.7.0.1
 */