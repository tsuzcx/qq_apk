package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
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

public class fc
{
  public static int f = 300000;
  e a = new e();
  int b = 20000;
  int c = 20000;
  int d = 30000;
  int e = 30000;
  private final int g = 2;
  
  private byte[] a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    return a(paramString1, paramString2, paramString3, true, paramFile);
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 10
    //   3: new 49	com/tencent/token/utils/k
    //   6: dup
    //   7: invokespecial 50	com/tencent/token/utils/k:<init>	()V
    //   10: astore 16
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual 53	com/tencent/token/fc:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +13 -> 33
    //   23: aload_1
    //   24: ifnull +7 -> 31
    //   27: aload_1
    //   28: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_3
    //   34: ifnull +307 -> 341
    //   37: aload_3
    //   38: invokevirtual 64	java/lang/String:length	()I
    //   41: ifle +300 -> 341
    //   44: aload 5
    //   46: ifnull +2533 -> 2579
    //   49: new 66	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   56: astore 9
    //   58: aload 9
    //   60: ldc 69
    //   62: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 9
    //   68: aload_3
    //   69: invokevirtual 77	java/lang/String:getBytes	()[B
    //   72: arraylength
    //   73: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 9
    //   79: ldc 82
    //   81: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: aload 5
    //   89: invokevirtual 87	java/io/File:length	()J
    //   92: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 9
    //   98: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   104: ldc 101
    //   106: invokevirtual 77	java/lang/String:getBytes	()[B
    //   109: astore 11
    //   111: new 103	java/io/FileInputStream
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore 12
    //   122: aload_3
    //   123: invokevirtual 77	java/lang/String:getBytes	()[B
    //   126: arraylength
    //   127: aload 11
    //   129: arraylength
    //   130: iadd
    //   131: i2l
    //   132: aload 5
    //   134: invokevirtual 87	java/io/File:length	()J
    //   137: ladd
    //   138: ldc 108
    //   140: invokevirtual 77	java/lang/String:getBytes	()[B
    //   143: arraylength
    //   144: i2l
    //   145: ladd
    //   146: lstore 7
    //   148: new 66	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   155: astore 9
    //   157: aload 9
    //   159: ldc 110
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 9
    //   167: lload 7
    //   169: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 9
    //   175: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: ldc 112
    //   184: ldc 114
    //   186: invokevirtual 118	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_1
    //   190: ldc 120
    //   192: lload 7
    //   194: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   197: invokevirtual 118	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto +3 -> 203
    //   203: aload_1
    //   204: iconst_1
    //   205: invokevirtual 128	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   208: new 130	java/io/DataOutputStream
    //   211: dup
    //   212: aload_1
    //   213: invokevirtual 134	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   216: invokespecial 137	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore 9
    //   221: aload 9
    //   223: aload_3
    //   224: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   227: aload 5
    //   229: ifnull +55 -> 284
    //   232: sipush 1024
    //   235: newarray byte
    //   237: astore 13
    //   239: aload 12
    //   241: aload 13
    //   243: invokevirtual 144	java/io/FileInputStream:read	([B)I
    //   246: istore 6
    //   248: iload 6
    //   250: iconst_m1
    //   251: if_icmpeq +16 -> 267
    //   254: aload 9
    //   256: aload 13
    //   258: iconst_0
    //   259: iload 6
    //   261: invokevirtual 148	java/io/DataOutputStream:write	([BII)V
    //   264: goto -25 -> 239
    //   267: aload 9
    //   269: ldc 108
    //   271: invokevirtual 77	java/lang/String:getBytes	()[B
    //   274: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   277: aload 9
    //   279: aload 11
    //   281: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   284: aload 9
    //   286: invokevirtual 154	java/io/DataOutputStream:flush	()V
    //   289: aload 9
    //   291: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   294: goto +47 -> 341
    //   297: astore_3
    //   298: aload 9
    //   300: astore 5
    //   302: goto +891 -> 1193
    //   305: astore 15
    //   307: aload 9
    //   309: astore 11
    //   311: goto +892 -> 1203
    //   314: astore 15
    //   316: aload 9
    //   318: astore 12
    //   320: goto +891 -> 1211
    //   323: astore 15
    //   325: aload 9
    //   327: astore 12
    //   329: goto +890 -> 1219
    //   332: astore 15
    //   334: aload 9
    //   336: astore 12
    //   338: goto +889 -> 1227
    //   341: aload_1
    //   342: invokevirtual 160	java/net/HttpURLConnection:getResponseCode	()I
    //   345: istore 6
    //   347: new 66	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   354: astore 9
    //   356: aload 9
    //   358: ldc 162
    //   360: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 9
    //   366: iload 6
    //   368: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 9
    //   374: ldc 164
    //   376: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 9
    //   382: aload 10
    //   384: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 166
    //   390: aload 9
    //   392: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 171	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: iload 6
    //   400: sipush 200
    //   403: if_icmpeq +184 -> 587
    //   406: iload 6
    //   408: sipush 206
    //   411: if_icmpeq +176 -> 587
    //   414: iload 6
    //   416: iconst_m1
    //   417: if_icmpne +6 -> 423
    //   420: goto +167 -> 587
    //   423: aload_0
    //   424: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   427: astore_2
    //   428: new 66	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   435: astore_3
    //   436: aload_3
    //   437: ldc 173
    //   439: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_3
    //   444: iload 6
    //   446: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_2
    //   451: sipush 10005
    //   454: aload_3
    //   455: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   461: new 66	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   468: astore_2
    //   469: aload_2
    //   470: ldc 178
    //   472: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_2
    //   477: aload 10
    //   479: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_2
    //   484: ldc 180
    //   486: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_2
    //   491: iload 6
    //   493: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_2
    //   498: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 182	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   504: new 66	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   511: astore_3
    //   512: aload_3
    //   513: ldc 184
    //   515: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 10
    //   521: ldc 186
    //   523: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   526: iconst_m1
    //   527: if_icmpne +9 -> 536
    //   530: aload 10
    //   532: astore_2
    //   533: goto +17 -> 550
    //   536: aload 10
    //   538: iconst_0
    //   539: aload 10
    //   541: ldc 186
    //   543: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   546: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   549: astore_2
    //   550: aload_3
    //   551: aload_2
    //   552: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_3
    //   557: ldc 180
    //   559: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_3
    //   564: iload 6
    //   566: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_3
    //   571: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   577: aconst_null
    //   578: astore_2
    //   579: aconst_null
    //   580: astore_3
    //   581: aconst_null
    //   582: astore 9
    //   584: goto +338 -> 922
    //   587: aload_1
    //   588: invokevirtual 199	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   591: astore 9
    //   593: aload 9
    //   595: ifnonnull +10 -> 605
    //   598: ldc 201
    //   600: astore 9
    //   602: goto +10 -> 612
    //   605: aload 9
    //   607: invokevirtual 204	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   610: astore 9
    //   612: new 66	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   619: astore 11
    //   621: aload 11
    //   623: ldc 206
    //   625: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 11
    //   631: aload 9
    //   633: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 11
    //   639: ldc 208
    //   641: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: aload 11
    //   647: aload_2
    //   648: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 11
    //   654: ldc 210
    //   656: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 11
    //   662: aload 10
    //   664: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 11
    //   670: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 212	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   676: new 66	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   683: astore 12
    //   685: aload 12
    //   687: ldc 206
    //   689: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 12
    //   695: aload 9
    //   697: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 12
    //   703: ldc 208
    //   705: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 12
    //   711: aload_2
    //   712: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 12
    //   718: ldc 210
    //   720: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload 10
    //   726: ldc 186
    //   728: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   731: iconst_m1
    //   732: if_icmpne +10 -> 742
    //   735: aload 10
    //   737: astore 11
    //   739: goto +18 -> 757
    //   742: aload 10
    //   744: iconst_0
    //   745: aload 10
    //   747: ldc 186
    //   749: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   752: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   755: astore 11
    //   757: aload 12
    //   759: aload 11
    //   761: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 12
    //   767: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   773: iload 4
    //   775: ifeq +51 -> 826
    //   778: aload 9
    //   780: ldc 214
    //   782: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   785: iconst_m1
    //   786: if_icmpne +14 -> 800
    //   789: aload 9
    //   791: ldc 216
    //   793: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   796: iconst_m1
    //   797: if_icmpeq +29 -> 826
    //   800: ldc 218
    //   802: invokestatic 182	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   805: aload_0
    //   806: aload 10
    //   808: aload_2
    //   809: aload_3
    //   810: aload 5
    //   812: invokespecial 220	com/tencent/token/fc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)[B
    //   815: astore_2
    //   816: aload_1
    //   817: ifnull +7 -> 824
    //   820: aload_1
    //   821: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   824: aload_2
    //   825: areturn
    //   826: aload_1
    //   827: invokevirtual 224	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   830: astore 5
    //   832: aload 5
    //   834: astore_2
    //   835: new 226	java/io/ByteArrayOutputStream
    //   838: dup
    //   839: invokespecial 227	java/io/ByteArrayOutputStream:<init>	()V
    //   842: astore_3
    //   843: aload_2
    //   844: invokevirtual 231	java/io/InputStream:read	()I
    //   847: istore 6
    //   849: iload 6
    //   851: iconst_m1
    //   852: if_icmpeq +12 -> 864
    //   855: aload_3
    //   856: iload 6
    //   858: invokevirtual 234	java/io/ByteArrayOutputStream:write	(I)V
    //   861: goto -18 -> 843
    //   864: aload_3
    //   865: invokevirtual 235	java/io/ByteArrayOutputStream:flush	()V
    //   868: aload_3
    //   869: invokevirtual 238	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   872: astore 9
    //   874: aload 9
    //   876: ifnull +26 -> 902
    //   879: aload 9
    //   881: arraylength
    //   882: ifgt +6 -> 888
    //   885: goto +17 -> 902
    //   888: aload_0
    //   889: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   892: invokevirtual 240	com/tencent/token/global/e:c	()V
    //   895: aload 9
    //   897: astore 5
    //   899: goto +15 -> 914
    //   902: aload_0
    //   903: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   906: ldc 241
    //   908: invokevirtual 243	com/tencent/token/global/e:b	(I)V
    //   911: aconst_null
    //   912: astore 5
    //   914: aload_3
    //   915: astore 9
    //   917: aload_2
    //   918: astore_3
    //   919: aload 5
    //   921: astore_2
    //   922: aload 9
    //   924: ifnull +18 -> 942
    //   927: aload 9
    //   929: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   932: goto +10 -> 942
    //   935: astore 5
    //   937: aload 5
    //   939: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   942: aload_3
    //   943: ifnull +15 -> 958
    //   946: aload_3
    //   947: invokevirtual 248	java/io/InputStream:close	()V
    //   950: goto +8 -> 958
    //   953: astore_3
    //   954: aload_3
    //   955: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   958: aload_1
    //   959: ifnull +7 -> 966
    //   962: aload_1
    //   963: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   966: aload_2
    //   967: astore_1
    //   968: goto +1405 -> 2373
    //   971: astore_2
    //   972: goto +42 -> 1014
    //   975: astore_2
    //   976: goto +61 -> 1037
    //   979: astore_2
    //   980: goto +80 -> 1060
    //   983: astore_2
    //   984: goto +99 -> 1083
    //   987: astore 5
    //   989: aload_3
    //   990: astore 10
    //   992: aconst_null
    //   993: astore 9
    //   995: aload 5
    //   997: astore_3
    //   998: aload 9
    //   1000: astore 5
    //   1002: aload_2
    //   1003: astore 9
    //   1005: aload_1
    //   1006: astore_2
    //   1007: goto +1508 -> 2515
    //   1010: astore_2
    //   1011: aconst_null
    //   1012: astore 9
    //   1014: aconst_null
    //   1015: astore 11
    //   1017: aload_2
    //   1018: astore 15
    //   1020: aload_3
    //   1021: astore 13
    //   1023: aload_1
    //   1024: astore 12
    //   1026: aload 5
    //   1028: astore 14
    //   1030: goto +238 -> 1268
    //   1033: astore_2
    //   1034: aconst_null
    //   1035: astore 9
    //   1037: aconst_null
    //   1038: astore 12
    //   1040: aload_2
    //   1041: astore 15
    //   1043: aload_3
    //   1044: astore 13
    //   1046: aload_1
    //   1047: astore 11
    //   1049: aload 5
    //   1051: astore 14
    //   1053: goto +465 -> 1518
    //   1056: astore_2
    //   1057: aconst_null
    //   1058: astore 9
    //   1060: aconst_null
    //   1061: astore 12
    //   1063: aload_2
    //   1064: astore 15
    //   1066: aload_3
    //   1067: astore 13
    //   1069: aload_1
    //   1070: astore 11
    //   1072: aload 5
    //   1074: astore 14
    //   1076: goto +725 -> 1801
    //   1079: astore_2
    //   1080: aconst_null
    //   1081: astore 9
    //   1083: aconst_null
    //   1084: astore 12
    //   1086: aload_2
    //   1087: astore 15
    //   1089: aload_3
    //   1090: astore 13
    //   1092: aload_1
    //   1093: astore 11
    //   1095: aload 5
    //   1097: astore 14
    //   1099: goto +985 -> 2084
    //   1102: astore_3
    //   1103: aconst_null
    //   1104: astore 5
    //   1106: goto +132 -> 1238
    //   1109: astore 15
    //   1111: aconst_null
    //   1112: astore 11
    //   1114: aconst_null
    //   1115: astore 9
    //   1117: aconst_null
    //   1118: astore 13
    //   1120: aload_1
    //   1121: astore 12
    //   1123: aload_2
    //   1124: astore 14
    //   1126: goto +142 -> 1268
    //   1129: astore 15
    //   1131: aconst_null
    //   1132: astore 12
    //   1134: aconst_null
    //   1135: astore 9
    //   1137: aconst_null
    //   1138: astore 13
    //   1140: aload_1
    //   1141: astore 11
    //   1143: aload_2
    //   1144: astore 14
    //   1146: goto +372 -> 1518
    //   1149: astore 15
    //   1151: aconst_null
    //   1152: astore 12
    //   1154: aconst_null
    //   1155: astore 9
    //   1157: aconst_null
    //   1158: astore 13
    //   1160: aload_1
    //   1161: astore 11
    //   1163: aload_2
    //   1164: astore 14
    //   1166: goto +635 -> 1801
    //   1169: astore 15
    //   1171: aconst_null
    //   1172: astore 12
    //   1174: aconst_null
    //   1175: astore 9
    //   1177: aconst_null
    //   1178: astore 13
    //   1180: aload_1
    //   1181: astore 11
    //   1183: aload_2
    //   1184: astore 14
    //   1186: goto +898 -> 2084
    //   1189: astore_3
    //   1190: aconst_null
    //   1191: astore 5
    //   1193: aconst_null
    //   1194: astore_2
    //   1195: goto +43 -> 1238
    //   1198: astore 15
    //   1200: aconst_null
    //   1201: astore 11
    //   1203: goto +53 -> 1256
    //   1206: astore 15
    //   1208: aconst_null
    //   1209: astore 12
    //   1211: goto +295 -> 1506
    //   1214: astore 15
    //   1216: aconst_null
    //   1217: astore 12
    //   1219: goto +570 -> 1789
    //   1222: astore 15
    //   1224: aconst_null
    //   1225: astore 12
    //   1227: goto +845 -> 2072
    //   1230: astore_3
    //   1231: aconst_null
    //   1232: astore 5
    //   1234: aconst_null
    //   1235: astore_2
    //   1236: aconst_null
    //   1237: astore_1
    //   1238: aconst_null
    //   1239: astore 10
    //   1241: aload_2
    //   1242: astore 9
    //   1244: aload_1
    //   1245: astore_2
    //   1246: goto +1269 -> 2515
    //   1249: astore 15
    //   1251: aconst_null
    //   1252: astore 11
    //   1254: aconst_null
    //   1255: astore_1
    //   1256: aconst_null
    //   1257: astore 13
    //   1259: aconst_null
    //   1260: astore 9
    //   1262: aconst_null
    //   1263: astore 14
    //   1265: aload_1
    //   1266: astore 12
    //   1268: aload 11
    //   1270: astore_1
    //   1271: aload 13
    //   1273: astore 5
    //   1275: aload 12
    //   1277: astore_2
    //   1278: aload 14
    //   1280: astore_3
    //   1281: aload 15
    //   1283: invokevirtual 249	java/lang/Throwable:printStackTrace	()V
    //   1286: aload 11
    //   1288: astore_1
    //   1289: aload 13
    //   1291: astore 5
    //   1293: aload 12
    //   1295: astore_2
    //   1296: aload 14
    //   1298: astore_3
    //   1299: aload_0
    //   1300: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1303: astore 17
    //   1305: aload 11
    //   1307: astore_1
    //   1308: aload 13
    //   1310: astore 5
    //   1312: aload 12
    //   1314: astore_2
    //   1315: aload 14
    //   1317: astore_3
    //   1318: new 66	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1325: astore 18
    //   1327: aload 11
    //   1329: astore_1
    //   1330: aload 13
    //   1332: astore 5
    //   1334: aload 12
    //   1336: astore_2
    //   1337: aload 14
    //   1339: astore_3
    //   1340: aload 18
    //   1342: aload 15
    //   1344: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1347: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload 11
    //   1353: astore_1
    //   1354: aload 13
    //   1356: astore 5
    //   1358: aload 12
    //   1360: astore_2
    //   1361: aload 14
    //   1363: astore_3
    //   1364: aload 18
    //   1366: ldc 252
    //   1368: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload 11
    //   1374: astore_1
    //   1375: aload 13
    //   1377: astore 5
    //   1379: aload 12
    //   1381: astore_2
    //   1382: aload 14
    //   1384: astore_3
    //   1385: aload 18
    //   1387: aload 15
    //   1389: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1392: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 11
    //   1398: astore_1
    //   1399: aload 13
    //   1401: astore 5
    //   1403: aload 12
    //   1405: astore_2
    //   1406: aload 14
    //   1408: astore_3
    //   1409: aload 17
    //   1411: sipush 10003
    //   1414: aload 18
    //   1416: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1422: aload 13
    //   1424: ifnull +16 -> 1440
    //   1427: aload 13
    //   1429: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   1432: goto +8 -> 1440
    //   1435: astore_1
    //   1436: aload_1
    //   1437: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1440: aload 14
    //   1442: ifnull +16 -> 1458
    //   1445: aload 14
    //   1447: invokevirtual 248	java/io/InputStream:close	()V
    //   1450: goto +8 -> 1458
    //   1453: astore_1
    //   1454: aload_1
    //   1455: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1458: aload 11
    //   1460: ifnull +16 -> 1476
    //   1463: aload 11
    //   1465: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   1468: goto +8 -> 1476
    //   1471: astore_1
    //   1472: aload_1
    //   1473: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1476: aload 9
    //   1478: astore_1
    //   1479: aload 12
    //   1481: ifnull +892 -> 2373
    //   1484: aload 12
    //   1486: astore 11
    //   1488: aload 9
    //   1490: astore_1
    //   1491: aload 11
    //   1493: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   1496: goto +877 -> 2373
    //   1499: astore 15
    //   1501: aconst_null
    //   1502: astore 12
    //   1504: aconst_null
    //   1505: astore_1
    //   1506: aconst_null
    //   1507: astore 13
    //   1509: aconst_null
    //   1510: astore 9
    //   1512: aconst_null
    //   1513: astore 14
    //   1515: aload_1
    //   1516: astore 11
    //   1518: aload 12
    //   1520: astore_1
    //   1521: aload 13
    //   1523: astore 5
    //   1525: aload 11
    //   1527: astore_2
    //   1528: aload 14
    //   1530: astore_3
    //   1531: aload 15
    //   1533: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1536: aload 12
    //   1538: astore_1
    //   1539: aload 13
    //   1541: astore 5
    //   1543: aload 11
    //   1545: astore_2
    //   1546: aload 14
    //   1548: astore_3
    //   1549: aload_0
    //   1550: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1553: astore 17
    //   1555: aload 12
    //   1557: astore_1
    //   1558: aload 13
    //   1560: astore 5
    //   1562: aload 11
    //   1564: astore_2
    //   1565: aload 14
    //   1567: astore_3
    //   1568: new 66	java/lang/StringBuilder
    //   1571: dup
    //   1572: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1575: astore 18
    //   1577: aload 12
    //   1579: astore_1
    //   1580: aload 13
    //   1582: astore 5
    //   1584: aload 11
    //   1586: astore_2
    //   1587: aload 14
    //   1589: astore_3
    //   1590: aload 18
    //   1592: aload 15
    //   1594: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1597: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 12
    //   1603: astore_1
    //   1604: aload 13
    //   1606: astore 5
    //   1608: aload 11
    //   1610: astore_2
    //   1611: aload 14
    //   1613: astore_3
    //   1614: aload 18
    //   1616: ldc 252
    //   1618: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1621: pop
    //   1622: aload 12
    //   1624: astore_1
    //   1625: aload 13
    //   1627: astore 5
    //   1629: aload 11
    //   1631: astore_2
    //   1632: aload 14
    //   1634: astore_3
    //   1635: aload 18
    //   1637: aload 15
    //   1639: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1642: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload 12
    //   1648: astore_1
    //   1649: aload 13
    //   1651: astore 5
    //   1653: aload 11
    //   1655: astore_2
    //   1656: aload 14
    //   1658: astore_3
    //   1659: aload 17
    //   1661: sipush 10003
    //   1664: aload 18
    //   1666: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1672: aload 12
    //   1674: astore_1
    //   1675: aload 13
    //   1677: astore 5
    //   1679: aload 11
    //   1681: astore_2
    //   1682: aload 14
    //   1684: astore_3
    //   1685: aload 15
    //   1687: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1690: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1693: aload 12
    //   1695: astore_1
    //   1696: aload 13
    //   1698: astore 5
    //   1700: aload 11
    //   1702: astore_2
    //   1703: aload 14
    //   1705: astore_3
    //   1706: aload 15
    //   1708: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1711: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1714: aload 13
    //   1716: ifnull +16 -> 1732
    //   1719: aload 13
    //   1721: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   1724: goto +8 -> 1732
    //   1727: astore_1
    //   1728: aload_1
    //   1729: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1732: aload 14
    //   1734: ifnull +16 -> 1750
    //   1737: aload 14
    //   1739: invokevirtual 248	java/io/InputStream:close	()V
    //   1742: goto +8 -> 1750
    //   1745: astore_1
    //   1746: aload_1
    //   1747: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1750: aload 12
    //   1752: ifnull +16 -> 1768
    //   1755: aload 12
    //   1757: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   1760: goto +8 -> 1768
    //   1763: astore_1
    //   1764: aload_1
    //   1765: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1768: aload 9
    //   1770: astore_1
    //   1771: aload 11
    //   1773: ifnull +600 -> 2373
    //   1776: aload 9
    //   1778: astore_1
    //   1779: goto -288 -> 1491
    //   1782: astore 15
    //   1784: aconst_null
    //   1785: astore 12
    //   1787: aconst_null
    //   1788: astore_1
    //   1789: aconst_null
    //   1790: astore 13
    //   1792: aconst_null
    //   1793: astore 9
    //   1795: aconst_null
    //   1796: astore 14
    //   1798: aload_1
    //   1799: astore 11
    //   1801: aload 12
    //   1803: astore_1
    //   1804: aload 13
    //   1806: astore 5
    //   1808: aload 11
    //   1810: astore_2
    //   1811: aload 14
    //   1813: astore_3
    //   1814: aload 15
    //   1816: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   1819: aload 12
    //   1821: astore_1
    //   1822: aload 13
    //   1824: astore 5
    //   1826: aload 11
    //   1828: astore_2
    //   1829: aload 14
    //   1831: astore_3
    //   1832: aload_0
    //   1833: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1836: astore 17
    //   1838: aload 12
    //   1840: astore_1
    //   1841: aload 13
    //   1843: astore 5
    //   1845: aload 11
    //   1847: astore_2
    //   1848: aload 14
    //   1850: astore_3
    //   1851: new 66	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1858: astore 18
    //   1860: aload 12
    //   1862: astore_1
    //   1863: aload 13
    //   1865: astore 5
    //   1867: aload 11
    //   1869: astore_2
    //   1870: aload 14
    //   1872: astore_3
    //   1873: aload 18
    //   1875: aload 15
    //   1877: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   1880: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: pop
    //   1884: aload 12
    //   1886: astore_1
    //   1887: aload 13
    //   1889: astore 5
    //   1891: aload 11
    //   1893: astore_2
    //   1894: aload 14
    //   1896: astore_3
    //   1897: aload 18
    //   1899: ldc 252
    //   1901: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: pop
    //   1905: aload 12
    //   1907: astore_1
    //   1908: aload 13
    //   1910: astore 5
    //   1912: aload 11
    //   1914: astore_2
    //   1915: aload 14
    //   1917: astore_3
    //   1918: aload 18
    //   1920: aload 15
    //   1922: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1925: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: pop
    //   1929: aload 12
    //   1931: astore_1
    //   1932: aload 13
    //   1934: astore 5
    //   1936: aload 11
    //   1938: astore_2
    //   1939: aload 14
    //   1941: astore_3
    //   1942: aload 17
    //   1944: sipush 10003
    //   1947: aload 18
    //   1949: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1952: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1955: aload 12
    //   1957: astore_1
    //   1958: aload 13
    //   1960: astore 5
    //   1962: aload 11
    //   1964: astore_2
    //   1965: aload 14
    //   1967: astore_3
    //   1968: aload 15
    //   1970: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   1973: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1976: aload 12
    //   1978: astore_1
    //   1979: aload 13
    //   1981: astore 5
    //   1983: aload 11
    //   1985: astore_2
    //   1986: aload 14
    //   1988: astore_3
    //   1989: aload 15
    //   1991: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   1994: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1997: aload 13
    //   1999: ifnull +16 -> 2015
    //   2002: aload 13
    //   2004: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2007: goto +8 -> 2015
    //   2010: astore_1
    //   2011: aload_1
    //   2012: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2015: aload 14
    //   2017: ifnull +16 -> 2033
    //   2020: aload 14
    //   2022: invokevirtual 248	java/io/InputStream:close	()V
    //   2025: goto +8 -> 2033
    //   2028: astore_1
    //   2029: aload_1
    //   2030: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2033: aload 12
    //   2035: ifnull +16 -> 2051
    //   2038: aload 12
    //   2040: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2043: goto +8 -> 2051
    //   2046: astore_1
    //   2047: aload_1
    //   2048: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2051: aload 9
    //   2053: astore_1
    //   2054: aload 11
    //   2056: ifnull +317 -> 2373
    //   2059: aload 9
    //   2061: astore_1
    //   2062: goto -571 -> 1491
    //   2065: astore 15
    //   2067: aconst_null
    //   2068: astore 12
    //   2070: aconst_null
    //   2071: astore_1
    //   2072: aconst_null
    //   2073: astore 13
    //   2075: aconst_null
    //   2076: astore 9
    //   2078: aconst_null
    //   2079: astore 14
    //   2081: aload_1
    //   2082: astore 11
    //   2084: aload 12
    //   2086: astore_1
    //   2087: aload 13
    //   2089: astore 5
    //   2091: aload 11
    //   2093: astore_2
    //   2094: aload 14
    //   2096: astore_3
    //   2097: aload 15
    //   2099: invokevirtual 261	java/net/SocketTimeoutException:printStackTrace	()V
    //   2102: aload 12
    //   2104: astore_1
    //   2105: aload 13
    //   2107: astore 5
    //   2109: aload 11
    //   2111: astore_2
    //   2112: aload 14
    //   2114: astore_3
    //   2115: aload_0
    //   2116: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   2119: astore 17
    //   2121: aload 12
    //   2123: astore_1
    //   2124: aload 13
    //   2126: astore 5
    //   2128: aload 11
    //   2130: astore_2
    //   2131: aload 14
    //   2133: astore_3
    //   2134: new 66	java/lang/StringBuilder
    //   2137: dup
    //   2138: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2141: astore 18
    //   2143: aload 12
    //   2145: astore_1
    //   2146: aload 13
    //   2148: astore 5
    //   2150: aload 11
    //   2152: astore_2
    //   2153: aload 14
    //   2155: astore_3
    //   2156: aload 18
    //   2158: aload 15
    //   2160: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2163: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: pop
    //   2167: aload 12
    //   2169: astore_1
    //   2170: aload 13
    //   2172: astore 5
    //   2174: aload 11
    //   2176: astore_2
    //   2177: aload 14
    //   2179: astore_3
    //   2180: aload 18
    //   2182: ldc 252
    //   2184: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: pop
    //   2188: aload 12
    //   2190: astore_1
    //   2191: aload 13
    //   2193: astore 5
    //   2195: aload 11
    //   2197: astore_2
    //   2198: aload 14
    //   2200: astore_3
    //   2201: aload 18
    //   2203: aload 15
    //   2205: invokevirtual 263	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   2208: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2211: pop
    //   2212: aload 12
    //   2214: astore_1
    //   2215: aload 13
    //   2217: astore 5
    //   2219: aload 11
    //   2221: astore_2
    //   2222: aload 14
    //   2224: astore_3
    //   2225: aload 17
    //   2227: sipush 10002
    //   2230: aload 18
    //   2232: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2235: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2238: aload 12
    //   2240: astore_1
    //   2241: aload 13
    //   2243: astore 5
    //   2245: aload 11
    //   2247: astore_2
    //   2248: aload 14
    //   2250: astore_3
    //   2251: invokestatic 268	com/tencent/token/bv:a	()Lcom/tencent/token/bv;
    //   2254: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   2257: getstatic 275	com/tencent/token/fc:f	I
    //   2260: invokevirtual 278	com/tencent/token/bv:a	(JI)V
    //   2263: aload 12
    //   2265: astore_1
    //   2266: aload 13
    //   2268: astore 5
    //   2270: aload 11
    //   2272: astore_2
    //   2273: aload 14
    //   2275: astore_3
    //   2276: aload 15
    //   2278: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2281: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   2284: aload 12
    //   2286: astore_1
    //   2287: aload 13
    //   2289: astore 5
    //   2291: aload 11
    //   2293: astore_2
    //   2294: aload 14
    //   2296: astore_3
    //   2297: aload 15
    //   2299: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2302: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2305: aload 13
    //   2307: ifnull +16 -> 2323
    //   2310: aload 13
    //   2312: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2315: goto +8 -> 2323
    //   2318: astore_1
    //   2319: aload_1
    //   2320: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2323: aload 14
    //   2325: ifnull +16 -> 2341
    //   2328: aload 14
    //   2330: invokevirtual 248	java/io/InputStream:close	()V
    //   2333: goto +8 -> 2341
    //   2336: astore_1
    //   2337: aload_1
    //   2338: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2341: aload 12
    //   2343: ifnull +16 -> 2359
    //   2346: aload 12
    //   2348: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2351: goto +8 -> 2359
    //   2354: astore_1
    //   2355: aload_1
    //   2356: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2359: aload 9
    //   2361: astore_1
    //   2362: aload 11
    //   2364: ifnull +9 -> 2373
    //   2367: aload 9
    //   2369: astore_1
    //   2370: goto -879 -> 1491
    //   2373: new 66	java/lang/StringBuilder
    //   2376: dup
    //   2377: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2380: astore_2
    //   2381: aload_2
    //   2382: ldc_w 280
    //   2385: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2388: pop
    //   2389: aload_2
    //   2390: aload 16
    //   2392: invokevirtual 282	com/tencent/token/utils/k:a	()J
    //   2395: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2398: pop
    //   2399: aload_2
    //   2400: ldc_w 284
    //   2403: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2406: pop
    //   2407: aload_2
    //   2408: aload 10
    //   2410: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: pop
    //   2414: aload_2
    //   2415: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2418: invokestatic 212	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   2421: new 66	java/lang/StringBuilder
    //   2424: dup
    //   2425: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2428: astore_2
    //   2429: aload_2
    //   2430: ldc_w 280
    //   2433: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: pop
    //   2437: aload_2
    //   2438: aload 16
    //   2440: invokevirtual 282	com/tencent/token/utils/k:a	()J
    //   2443: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2446: pop
    //   2447: aload_2
    //   2448: ldc_w 284
    //   2451: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: pop
    //   2455: aload 10
    //   2457: ldc 186
    //   2459: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2462: iconst_m1
    //   2463: if_icmpne +6 -> 2469
    //   2466: goto +18 -> 2484
    //   2469: aload 10
    //   2471: iconst_0
    //   2472: aload 10
    //   2474: ldc 186
    //   2476: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2479: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   2482: astore 10
    //   2484: aload_2
    //   2485: aload 10
    //   2487: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: pop
    //   2491: aload_2
    //   2492: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2495: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2498: aload_1
    //   2499: areturn
    //   2500: astore 11
    //   2502: aload 5
    //   2504: astore 10
    //   2506: aload_3
    //   2507: astore 9
    //   2509: aload_1
    //   2510: astore 5
    //   2512: aload 11
    //   2514: astore_3
    //   2515: aload 10
    //   2517: ifnull +16 -> 2533
    //   2520: aload 10
    //   2522: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2525: goto +8 -> 2533
    //   2528: astore_1
    //   2529: aload_1
    //   2530: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2533: aload 9
    //   2535: ifnull +16 -> 2551
    //   2538: aload 9
    //   2540: invokevirtual 248	java/io/InputStream:close	()V
    //   2543: goto +8 -> 2551
    //   2546: astore_1
    //   2547: aload_1
    //   2548: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2551: aload 5
    //   2553: ifnull +16 -> 2569
    //   2556: aload 5
    //   2558: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2561: goto +8 -> 2569
    //   2564: astore_1
    //   2565: aload_1
    //   2566: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2569: aload_2
    //   2570: ifnull +7 -> 2577
    //   2573: aload_2
    //   2574: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   2577: aload_3
    //   2578: athrow
    //   2579: aconst_null
    //   2580: astore 11
    //   2582: aconst_null
    //   2583: astore 12
    //   2585: goto -2382 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2588	0	this	fc
    //   0	2588	1	paramString1	String
    //   0	2588	2	paramString2	String
    //   0	2588	3	paramString3	String
    //   0	2588	4	paramBoolean	boolean
    //   0	2588	5	paramFile	File
    //   246	611	6	i	int
    //   146	47	7	l	long
    //   56	2483	9	localObject1	Object
    //   1	2520	10	localObject2	Object
    //   109	2254	11	localObject3	Object
    //   2500	13	11	localObject4	Object
    //   2580	1	11	localObject5	Object
    //   120	2464	12	localObject6	Object
    //   237	2074	13	localObject7	Object
    //   1028	1301	14	localObject8	Object
    //   305	1	15	localThrowable1	java.lang.Throwable
    //   314	1	15	localException1	Exception
    //   323	1	15	localIOException1	IOException
    //   332	1	15	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1018	70	15	str	String
    //   1109	1	15	localThrowable2	java.lang.Throwable
    //   1129	1	15	localException2	Exception
    //   1149	1	15	localIOException2	IOException
    //   1169	1	15	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1198	1	15	localThrowable3	java.lang.Throwable
    //   1206	1	15	localException3	Exception
    //   1214	1	15	localIOException3	IOException
    //   1222	1	15	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1249	139	15	localThrowable4	java.lang.Throwable
    //   1499	208	15	localException4	Exception
    //   1782	208	15	localIOException4	IOException
    //   2065	233	15	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   10	2429	16	localk	com.tencent.token.utils.k
    //   1303	923	17	locale	e
    //   1325	906	18	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   221	227	297	finally
    //   232	239	297	finally
    //   239	248	297	finally
    //   254	264	297	finally
    //   267	284	297	finally
    //   284	294	297	finally
    //   221	227	305	java/lang/Throwable
    //   232	239	305	java/lang/Throwable
    //   239	248	305	java/lang/Throwable
    //   254	264	305	java/lang/Throwable
    //   267	284	305	java/lang/Throwable
    //   284	294	305	java/lang/Throwable
    //   221	227	314	java/lang/Exception
    //   232	239	314	java/lang/Exception
    //   239	248	314	java/lang/Exception
    //   254	264	314	java/lang/Exception
    //   267	284	314	java/lang/Exception
    //   284	294	314	java/lang/Exception
    //   221	227	323	java/io/IOException
    //   232	239	323	java/io/IOException
    //   239	248	323	java/io/IOException
    //   254	264	323	java/io/IOException
    //   267	284	323	java/io/IOException
    //   284	294	323	java/io/IOException
    //   221	227	332	java/net/SocketTimeoutException
    //   232	239	332	java/net/SocketTimeoutException
    //   239	248	332	java/net/SocketTimeoutException
    //   254	264	332	java/net/SocketTimeoutException
    //   267	284	332	java/net/SocketTimeoutException
    //   284	294	332	java/net/SocketTimeoutException
    //   927	932	935	java/lang/Exception
    //   946	950	953	java/lang/Exception
    //   879	885	971	java/lang/Throwable
    //   888	895	971	java/lang/Throwable
    //   902	911	971	java/lang/Throwable
    //   879	885	975	java/lang/Exception
    //   888	895	975	java/lang/Exception
    //   902	911	975	java/lang/Exception
    //   879	885	979	java/io/IOException
    //   888	895	979	java/io/IOException
    //   902	911	979	java/io/IOException
    //   879	885	983	java/net/SocketTimeoutException
    //   888	895	983	java/net/SocketTimeoutException
    //   902	911	983	java/net/SocketTimeoutException
    //   843	849	987	finally
    //   855	861	987	finally
    //   864	874	987	finally
    //   879	885	987	finally
    //   888	895	987	finally
    //   902	911	987	finally
    //   843	849	1010	java/lang/Throwable
    //   855	861	1010	java/lang/Throwable
    //   864	874	1010	java/lang/Throwable
    //   843	849	1033	java/lang/Exception
    //   855	861	1033	java/lang/Exception
    //   864	874	1033	java/lang/Exception
    //   843	849	1056	java/io/IOException
    //   855	861	1056	java/io/IOException
    //   864	874	1056	java/io/IOException
    //   843	849	1079	java/net/SocketTimeoutException
    //   855	861	1079	java/net/SocketTimeoutException
    //   864	874	1079	java/net/SocketTimeoutException
    //   835	843	1102	finally
    //   835	843	1109	java/lang/Throwable
    //   835	843	1129	java/lang/Exception
    //   835	843	1149	java/io/IOException
    //   835	843	1169	java/net/SocketTimeoutException
    //   37	44	1189	finally
    //   49	200	1189	finally
    //   203	221	1189	finally
    //   341	398	1189	finally
    //   423	530	1189	finally
    //   536	550	1189	finally
    //   550	577	1189	finally
    //   587	593	1189	finally
    //   605	612	1189	finally
    //   612	735	1189	finally
    //   742	757	1189	finally
    //   757	773	1189	finally
    //   778	800	1189	finally
    //   800	816	1189	finally
    //   826	832	1189	finally
    //   37	44	1198	java/lang/Throwable
    //   49	200	1198	java/lang/Throwable
    //   203	221	1198	java/lang/Throwable
    //   341	398	1198	java/lang/Throwable
    //   423	530	1198	java/lang/Throwable
    //   536	550	1198	java/lang/Throwable
    //   550	577	1198	java/lang/Throwable
    //   587	593	1198	java/lang/Throwable
    //   605	612	1198	java/lang/Throwable
    //   612	735	1198	java/lang/Throwable
    //   742	757	1198	java/lang/Throwable
    //   757	773	1198	java/lang/Throwable
    //   778	800	1198	java/lang/Throwable
    //   800	816	1198	java/lang/Throwable
    //   826	832	1198	java/lang/Throwable
    //   37	44	1206	java/lang/Exception
    //   49	200	1206	java/lang/Exception
    //   203	221	1206	java/lang/Exception
    //   341	398	1206	java/lang/Exception
    //   423	530	1206	java/lang/Exception
    //   536	550	1206	java/lang/Exception
    //   550	577	1206	java/lang/Exception
    //   587	593	1206	java/lang/Exception
    //   605	612	1206	java/lang/Exception
    //   612	735	1206	java/lang/Exception
    //   742	757	1206	java/lang/Exception
    //   757	773	1206	java/lang/Exception
    //   778	800	1206	java/lang/Exception
    //   800	816	1206	java/lang/Exception
    //   826	832	1206	java/lang/Exception
    //   37	44	1214	java/io/IOException
    //   49	200	1214	java/io/IOException
    //   203	221	1214	java/io/IOException
    //   341	398	1214	java/io/IOException
    //   423	530	1214	java/io/IOException
    //   536	550	1214	java/io/IOException
    //   550	577	1214	java/io/IOException
    //   587	593	1214	java/io/IOException
    //   605	612	1214	java/io/IOException
    //   612	735	1214	java/io/IOException
    //   742	757	1214	java/io/IOException
    //   757	773	1214	java/io/IOException
    //   778	800	1214	java/io/IOException
    //   800	816	1214	java/io/IOException
    //   826	832	1214	java/io/IOException
    //   37	44	1222	java/net/SocketTimeoutException
    //   49	200	1222	java/net/SocketTimeoutException
    //   203	221	1222	java/net/SocketTimeoutException
    //   341	398	1222	java/net/SocketTimeoutException
    //   423	530	1222	java/net/SocketTimeoutException
    //   536	550	1222	java/net/SocketTimeoutException
    //   550	577	1222	java/net/SocketTimeoutException
    //   587	593	1222	java/net/SocketTimeoutException
    //   605	612	1222	java/net/SocketTimeoutException
    //   612	735	1222	java/net/SocketTimeoutException
    //   742	757	1222	java/net/SocketTimeoutException
    //   757	773	1222	java/net/SocketTimeoutException
    //   778	800	1222	java/net/SocketTimeoutException
    //   800	816	1222	java/net/SocketTimeoutException
    //   826	832	1222	java/net/SocketTimeoutException
    //   12	19	1230	finally
    //   12	19	1249	java/lang/Throwable
    //   1427	1432	1435	java/lang/Exception
    //   1445	1450	1453	java/lang/Exception
    //   1463	1468	1471	java/lang/Exception
    //   12	19	1499	java/lang/Exception
    //   1719	1724	1727	java/lang/Exception
    //   1737	1742	1745	java/lang/Exception
    //   1755	1760	1763	java/lang/Exception
    //   12	19	1782	java/io/IOException
    //   2002	2007	2010	java/lang/Exception
    //   2020	2025	2028	java/lang/Exception
    //   2038	2043	2046	java/lang/Exception
    //   12	19	2065	java/net/SocketTimeoutException
    //   2310	2315	2318	java/lang/Exception
    //   2328	2333	2336	java/lang/Exception
    //   2346	2351	2354	java/lang/Exception
    //   1281	1286	2500	finally
    //   1299	1305	2500	finally
    //   1318	1327	2500	finally
    //   1340	1351	2500	finally
    //   1364	1372	2500	finally
    //   1385	1396	2500	finally
    //   1409	1422	2500	finally
    //   1531	1536	2500	finally
    //   1549	1555	2500	finally
    //   1568	1577	2500	finally
    //   1590	1601	2500	finally
    //   1614	1622	2500	finally
    //   1635	1646	2500	finally
    //   1659	1672	2500	finally
    //   1685	1693	2500	finally
    //   1706	1714	2500	finally
    //   1814	1819	2500	finally
    //   1832	1838	2500	finally
    //   1851	1860	2500	finally
    //   1873	1884	2500	finally
    //   1897	1905	2500	finally
    //   1918	1929	2500	finally
    //   1942	1955	2500	finally
    //   1968	1976	2500	finally
    //   1989	1997	2500	finally
    //   2097	2102	2500	finally
    //   2115	2121	2500	finally
    //   2134	2143	2500	finally
    //   2156	2167	2500	finally
    //   2180	2188	2500	finally
    //   2201	2212	2500	finally
    //   2225	2238	2500	finally
    //   2251	2263	2500	finally
    //   2276	2284	2500	finally
    //   2297	2305	2500	finally
    //   2520	2525	2528	java/lang/Exception
    //   2538	2543	2546	java/lang/Exception
    //   2556	2561	2564	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 49	com/tencent/token/utils/k
    //   3: dup
    //   4: invokespecial 50	com/tencent/token/utils/k:<init>	()V
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 23
    //   12: aconst_null
    //   13: astore 14
    //   15: aconst_null
    //   16: astore 19
    //   18: aconst_null
    //   19: astore 20
    //   21: aconst_null
    //   22: astore 21
    //   24: aconst_null
    //   25: astore 15
    //   27: aconst_null
    //   28: astore 16
    //   30: aconst_null
    //   31: astore 17
    //   33: aconst_null
    //   34: astore 18
    //   36: aconst_null
    //   37: astore 13
    //   39: aconst_null
    //   40: astore 12
    //   42: aconst_null
    //   43: astore 22
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 53	com/tencent/token/fc:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   51: astore 9
    //   53: aload 9
    //   55: ifnonnull +15 -> 70
    //   58: aload 9
    //   60: ifnull +8 -> 68
    //   63: aload 9
    //   65: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_3
    //   71: ifnull +324 -> 395
    //   74: aload_3
    //   75: invokevirtual 64	java/lang/String:length	()I
    //   78: ifle +317 -> 395
    //   81: aload 5
    //   83: ifnull +2655 -> 2738
    //   86: new 66	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   93: astore 10
    //   95: aload 10
    //   97: ldc 69
    //   99: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 10
    //   105: aload_3
    //   106: invokevirtual 77	java/lang/String:getBytes	()[B
    //   109: arraylength
    //   110: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 10
    //   116: ldc 82
    //   118: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: aload 5
    //   126: arraylength
    //   127: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 10
    //   133: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   139: ldc 101
    //   141: invokevirtual 77	java/lang/String:getBytes	()[B
    //   144: astore 11
    //   146: aload_3
    //   147: invokevirtual 77	java/lang/String:getBytes	()[B
    //   150: arraylength
    //   151: aload 11
    //   153: arraylength
    //   154: iadd
    //   155: aload 5
    //   157: arraylength
    //   158: iadd
    //   159: ldc 108
    //   161: invokevirtual 77	java/lang/String:getBytes	()[B
    //   164: arraylength
    //   165: iadd
    //   166: i2l
    //   167: lstore 7
    //   169: new 66	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   176: astore 10
    //   178: aload 10
    //   180: ldc 110
    //   182: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 10
    //   188: lload 7
    //   190: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 10
    //   196: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   202: aload 9
    //   204: ldc 112
    //   206: ldc 114
    //   208: invokevirtual 118	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 9
    //   213: ldc 120
    //   215: lload 7
    //   217: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   220: invokevirtual 118	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto +3 -> 226
    //   226: aload 9
    //   228: iconst_1
    //   229: invokevirtual 128	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   232: new 130	java/io/DataOutputStream
    //   235: dup
    //   236: aload 9
    //   238: invokevirtual 134	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   241: invokespecial 137	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   244: astore 10
    //   246: aload 10
    //   248: aload_3
    //   249: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   252: aload 5
    //   254: ifnull +27 -> 281
    //   257: aload 10
    //   259: aload 5
    //   261: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   264: aload 10
    //   266: ldc 108
    //   268: invokevirtual 77	java/lang/String:getBytes	()[B
    //   271: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   274: aload 10
    //   276: aload 11
    //   278: invokevirtual 151	java/io/DataOutputStream:write	([B)V
    //   281: aload 10
    //   283: invokevirtual 154	java/io/DataOutputStream:flush	()V
    //   286: aload 10
    //   288: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   291: goto +104 -> 395
    //   294: astore_1
    //   295: aload 10
    //   297: astore 5
    //   299: aconst_null
    //   300: astore_3
    //   301: aload 12
    //   303: astore_2
    //   304: goto +2372 -> 2676
    //   307: astore 13
    //   309: aconst_null
    //   310: astore 11
    //   312: aload 11
    //   314: astore_2
    //   315: aload 10
    //   317: astore 12
    //   319: aload 9
    //   321: astore 14
    //   323: goto +1067 -> 1390
    //   326: astore 13
    //   328: aconst_null
    //   329: astore 11
    //   331: aload 11
    //   333: astore_2
    //   334: aload 10
    //   336: astore 12
    //   338: aload 16
    //   340: astore 15
    //   342: aload 9
    //   344: astore 14
    //   346: goto +1302 -> 1648
    //   349: astore 13
    //   351: aconst_null
    //   352: astore 11
    //   354: aload 11
    //   356: astore_2
    //   357: aload 10
    //   359: astore 12
    //   361: aload 17
    //   363: astore 15
    //   365: aload 9
    //   367: astore 14
    //   369: goto +1576 -> 1945
    //   372: astore 13
    //   374: aconst_null
    //   375: astore 11
    //   377: aload 11
    //   379: astore_2
    //   380: aload 10
    //   382: astore 12
    //   384: aload 18
    //   386: astore 15
    //   388: aload 9
    //   390: astore 14
    //   392: goto +1850 -> 2242
    //   395: aload 9
    //   397: invokevirtual 160	java/net/HttpURLConnection:getResponseCode	()I
    //   400: istore 6
    //   402: new 66	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   409: astore 10
    //   411: aload 10
    //   413: ldc 162
    //   415: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 10
    //   421: iload 6
    //   423: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 10
    //   429: ldc 164
    //   431: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 10
    //   437: aload_1
    //   438: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc 166
    //   444: aload 10
    //   446: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 171	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: iload 6
    //   454: sipush 200
    //   457: if_icmpeq +181 -> 638
    //   460: iload 6
    //   462: sipush 206
    //   465: if_icmpeq +173 -> 638
    //   468: iload 6
    //   470: iconst_m1
    //   471: if_icmpne +6 -> 477
    //   474: goto +164 -> 638
    //   477: aload_0
    //   478: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   481: astore_2
    //   482: new 66	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   489: astore_3
    //   490: aload_3
    //   491: ldc 173
    //   493: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_3
    //   498: iload 6
    //   500: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload_2
    //   505: sipush 10005
    //   508: aload_3
    //   509: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   515: new 66	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   522: astore_2
    //   523: aload_2
    //   524: ldc 178
    //   526: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: aload_1
    //   532: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_2
    //   537: ldc 180
    //   539: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_2
    //   544: iload 6
    //   546: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_2
    //   551: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 182	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   557: new 66	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   564: astore_3
    //   565: aload_3
    //   566: ldc 184
    //   568: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_1
    //   573: ldc 186
    //   575: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   578: iconst_m1
    //   579: if_icmpne +8 -> 587
    //   582: aload_1
    //   583: astore_2
    //   584: goto +15 -> 599
    //   587: aload_1
    //   588: iconst_0
    //   589: aload_1
    //   590: ldc 186
    //   592: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   595: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   598: astore_2
    //   599: aload_3
    //   600: aload_2
    //   601: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_3
    //   606: ldc 180
    //   608: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_3
    //   613: iload 6
    //   615: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_3
    //   620: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   626: aconst_null
    //   627: astore 10
    //   629: aload 10
    //   631: astore_2
    //   632: aload 23
    //   634: astore_3
    //   635: goto +336 -> 971
    //   638: aload 9
    //   640: invokevirtual 199	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   643: astore 10
    //   645: aload 10
    //   647: ifnonnull +10 -> 657
    //   650: ldc 201
    //   652: astore 10
    //   654: goto +10 -> 664
    //   657: aload 10
    //   659: invokevirtual 204	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   662: astore 10
    //   664: new 66	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   671: astore 11
    //   673: aload 11
    //   675: ldc 206
    //   677: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload 11
    //   683: aload 10
    //   685: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload 11
    //   691: ldc 208
    //   693: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 11
    //   699: aload_2
    //   700: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload 11
    //   706: ldc 210
    //   708: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 11
    //   714: aload_1
    //   715: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 11
    //   721: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 212	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   727: new 66	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   734: astore 23
    //   736: aload 23
    //   738: ldc 206
    //   740: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 23
    //   746: aload 10
    //   748: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 23
    //   754: ldc 208
    //   756: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 23
    //   762: aload_2
    //   763: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload 23
    //   769: ldc 210
    //   771: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_1
    //   776: ldc 186
    //   778: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   781: iconst_m1
    //   782: if_icmpne +9 -> 791
    //   785: aload_1
    //   786: astore 11
    //   788: goto +16 -> 804
    //   791: aload_1
    //   792: iconst_0
    //   793: aload_1
    //   794: ldc 186
    //   796: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   799: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   802: astore 11
    //   804: aload 23
    //   806: aload 11
    //   808: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 23
    //   814: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   820: iload 4
    //   822: ifeq +53 -> 875
    //   825: aload 10
    //   827: ldc 214
    //   829: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   832: iconst_m1
    //   833: if_icmpne +14 -> 847
    //   836: aload 10
    //   838: ldc 216
    //   840: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   843: iconst_m1
    //   844: if_icmpeq +31 -> 875
    //   847: ldc 218
    //   849: invokestatic 182	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   852: aload_0
    //   853: aload_1
    //   854: aload_2
    //   855: aload_3
    //   856: iconst_1
    //   857: aload 5
    //   859: invokespecial 287	com/tencent/token/fc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z[B)[B
    //   862: astore_2
    //   863: aload 9
    //   865: ifnull +8 -> 873
    //   868: aload 9
    //   870: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   873: aload_2
    //   874: areturn
    //   875: aload 9
    //   877: invokevirtual 224	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   880: astore_3
    //   881: aload_3
    //   882: astore 10
    //   884: new 226	java/io/ByteArrayOutputStream
    //   887: dup
    //   888: invokespecial 227	java/io/ByteArrayOutputStream:<init>	()V
    //   891: astore_2
    //   892: aload 10
    //   894: invokevirtual 231	java/io/InputStream:read	()I
    //   897: istore 6
    //   899: iload 6
    //   901: iconst_m1
    //   902: if_icmpeq +12 -> 914
    //   905: aload_2
    //   906: iload 6
    //   908: invokevirtual 234	java/io/ByteArrayOutputStream:write	(I)V
    //   911: goto -19 -> 892
    //   914: aload_2
    //   915: invokevirtual 235	java/io/ByteArrayOutputStream:flush	()V
    //   918: aload_2
    //   919: invokevirtual 238	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   922: astore 5
    //   924: aload 5
    //   926: ifnull +25 -> 951
    //   929: aload 5
    //   931: arraylength
    //   932: ifgt +6 -> 938
    //   935: goto +16 -> 951
    //   938: aload_0
    //   939: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   942: invokevirtual 240	com/tencent/token/global/e:c	()V
    //   945: aload 5
    //   947: astore_3
    //   948: goto +15 -> 963
    //   951: aload_0
    //   952: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   955: ldc 241
    //   957: invokevirtual 243	com/tencent/token/global/e:b	(I)V
    //   960: aload 22
    //   962: astore_3
    //   963: aload_3
    //   964: astore 5
    //   966: aload_2
    //   967: astore_3
    //   968: aload 5
    //   970: astore_2
    //   971: aload_3
    //   972: ifnull +15 -> 987
    //   975: aload_3
    //   976: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   979: goto +8 -> 987
    //   982: astore_3
    //   983: aload_3
    //   984: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   987: aload 10
    //   989: ifnull +16 -> 1005
    //   992: aload 10
    //   994: invokevirtual 248	java/io/InputStream:close	()V
    //   997: goto +8 -> 1005
    //   1000: astore_3
    //   1001: aload_3
    //   1002: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1005: aload 9
    //   1007: ifnull +8 -> 1015
    //   1010: aload 9
    //   1012: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   1015: aload_2
    //   1016: astore_3
    //   1017: goto +1530 -> 2547
    //   1020: astore 11
    //   1022: aload 5
    //   1024: astore 10
    //   1026: aload 11
    //   1028: astore 5
    //   1030: goto +61 -> 1091
    //   1033: astore 11
    //   1035: aload 5
    //   1037: astore 10
    //   1039: aload 11
    //   1041: astore 5
    //   1043: goto +62 -> 1105
    //   1046: astore 11
    //   1048: aload 5
    //   1050: astore 10
    //   1052: aload 11
    //   1054: astore 5
    //   1056: goto +63 -> 1119
    //   1059: astore 11
    //   1061: aload 5
    //   1063: astore 10
    //   1065: aload 11
    //   1067: astore 5
    //   1069: goto +64 -> 1133
    //   1072: astore_1
    //   1073: aconst_null
    //   1074: astore 5
    //   1076: aload 10
    //   1078: astore_3
    //   1079: aload 9
    //   1081: astore 10
    //   1083: goto +1589 -> 2672
    //   1086: astore 5
    //   1088: aconst_null
    //   1089: astore 10
    //   1091: aload_2
    //   1092: astore 15
    //   1094: aload 10
    //   1096: astore_2
    //   1097: goto +70 -> 1167
    //   1100: astore 5
    //   1102: aconst_null
    //   1103: astore 10
    //   1105: aload_2
    //   1106: astore 15
    //   1108: aload 10
    //   1110: astore_2
    //   1111: goto +81 -> 1192
    //   1114: astore 5
    //   1116: aconst_null
    //   1117: astore 10
    //   1119: aload_2
    //   1120: astore 15
    //   1122: aload 10
    //   1124: astore_2
    //   1125: goto +92 -> 1217
    //   1128: astore 5
    //   1130: aconst_null
    //   1131: astore 10
    //   1133: aload_2
    //   1134: astore 15
    //   1136: aload 10
    //   1138: astore_2
    //   1139: goto +103 -> 1242
    //   1142: astore_1
    //   1143: aload 10
    //   1145: astore_3
    //   1146: aconst_null
    //   1147: astore 5
    //   1149: aload 13
    //   1151: astore_2
    //   1152: aload 9
    //   1154: astore 10
    //   1156: goto +1516 -> 2672
    //   1159: astore 5
    //   1161: aconst_null
    //   1162: astore_2
    //   1163: aload 14
    //   1165: astore 15
    //   1167: aconst_null
    //   1168: astore 12
    //   1170: aload 5
    //   1172: astore 13
    //   1174: aload_3
    //   1175: astore 11
    //   1177: aload 9
    //   1179: astore 14
    //   1181: goto +209 -> 1390
    //   1184: astore 5
    //   1186: aconst_null
    //   1187: astore_2
    //   1188: aload 19
    //   1190: astore 15
    //   1192: aconst_null
    //   1193: astore 12
    //   1195: aload 5
    //   1197: astore 13
    //   1199: aload_3
    //   1200: astore 11
    //   1202: aload 9
    //   1204: astore 14
    //   1206: goto +442 -> 1648
    //   1209: astore 5
    //   1211: aconst_null
    //   1212: astore_2
    //   1213: aload 20
    //   1215: astore 15
    //   1217: aconst_null
    //   1218: astore 12
    //   1220: aload 5
    //   1222: astore 13
    //   1224: aload_3
    //   1225: astore 11
    //   1227: aload 9
    //   1229: astore 14
    //   1231: goto +714 -> 1945
    //   1234: astore 5
    //   1236: aconst_null
    //   1237: astore_2
    //   1238: aload 21
    //   1240: astore 15
    //   1242: aconst_null
    //   1243: astore 12
    //   1245: aload 5
    //   1247: astore 13
    //   1249: aload_3
    //   1250: astore 11
    //   1252: aload 9
    //   1254: astore 14
    //   1256: goto +986 -> 2242
    //   1259: astore_1
    //   1260: aconst_null
    //   1261: astore_3
    //   1262: aload_3
    //   1263: astore 5
    //   1265: aload 12
    //   1267: astore_2
    //   1268: goto +1408 -> 2676
    //   1271: astore 13
    //   1273: aconst_null
    //   1274: astore 11
    //   1276: aload 11
    //   1278: astore 12
    //   1280: aload 12
    //   1282: astore_2
    //   1283: aload 9
    //   1285: astore 14
    //   1287: goto +103 -> 1390
    //   1290: astore 13
    //   1292: aconst_null
    //   1293: astore 11
    //   1295: aload 11
    //   1297: astore 12
    //   1299: aload 12
    //   1301: astore_2
    //   1302: aload 16
    //   1304: astore 15
    //   1306: aload 9
    //   1308: astore 14
    //   1310: goto +338 -> 1648
    //   1313: astore 13
    //   1315: aconst_null
    //   1316: astore 11
    //   1318: aload 11
    //   1320: astore 12
    //   1322: aload 12
    //   1324: astore_2
    //   1325: aload 17
    //   1327: astore 15
    //   1329: aload 9
    //   1331: astore 14
    //   1333: goto +612 -> 1945
    //   1336: astore 13
    //   1338: aconst_null
    //   1339: astore 11
    //   1341: aload 11
    //   1343: astore 12
    //   1345: aload 12
    //   1347: astore_2
    //   1348: aload 18
    //   1350: astore 15
    //   1352: aload 9
    //   1354: astore 14
    //   1356: goto +886 -> 2242
    //   1359: astore_1
    //   1360: aconst_null
    //   1361: astore_3
    //   1362: aload_3
    //   1363: astore 5
    //   1365: aload 5
    //   1367: astore 9
    //   1369: aload 12
    //   1371: astore_2
    //   1372: goto +1304 -> 2676
    //   1375: astore 13
    //   1377: aconst_null
    //   1378: astore 11
    //   1380: aload 11
    //   1382: astore 12
    //   1384: aload 12
    //   1386: astore_2
    //   1387: aload_2
    //   1388: astore 14
    //   1390: aload 11
    //   1392: astore_3
    //   1393: aload 12
    //   1395: astore 5
    //   1397: aload 15
    //   1399: astore 9
    //   1401: aload 14
    //   1403: astore 10
    //   1405: aload 13
    //   1407: invokevirtual 249	java/lang/Throwable:printStackTrace	()V
    //   1410: aload 11
    //   1412: astore_3
    //   1413: aload 12
    //   1415: astore 5
    //   1417: aload 15
    //   1419: astore 9
    //   1421: aload 14
    //   1423: astore 10
    //   1425: aload_0
    //   1426: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1429: astore 16
    //   1431: aload 11
    //   1433: astore_3
    //   1434: aload 12
    //   1436: astore 5
    //   1438: aload 15
    //   1440: astore 9
    //   1442: aload 14
    //   1444: astore 10
    //   1446: new 66	java/lang/StringBuilder
    //   1449: dup
    //   1450: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1453: astore 17
    //   1455: aload 11
    //   1457: astore_3
    //   1458: aload 12
    //   1460: astore 5
    //   1462: aload 15
    //   1464: astore 9
    //   1466: aload 14
    //   1468: astore 10
    //   1470: aload 17
    //   1472: aload 13
    //   1474: invokevirtual 250	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1477: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload 11
    //   1483: astore_3
    //   1484: aload 12
    //   1486: astore 5
    //   1488: aload 15
    //   1490: astore 9
    //   1492: aload 14
    //   1494: astore 10
    //   1496: aload 17
    //   1498: ldc 252
    //   1500: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: pop
    //   1504: aload 11
    //   1506: astore_3
    //   1507: aload 12
    //   1509: astore 5
    //   1511: aload 15
    //   1513: astore 9
    //   1515: aload 14
    //   1517: astore 10
    //   1519: aload 17
    //   1521: aload 13
    //   1523: invokevirtual 255	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1526: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: pop
    //   1530: aload 11
    //   1532: astore_3
    //   1533: aload 12
    //   1535: astore 5
    //   1537: aload 15
    //   1539: astore 9
    //   1541: aload 14
    //   1543: astore 10
    //   1545: aload 16
    //   1547: sipush 10003
    //   1550: aload 17
    //   1552: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1555: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1558: aload 15
    //   1560: ifnull +16 -> 1576
    //   1563: aload 15
    //   1565: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   1568: goto +8 -> 1576
    //   1571: astore_3
    //   1572: aload_3
    //   1573: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1576: aload 11
    //   1578: ifnull +16 -> 1594
    //   1581: aload 11
    //   1583: invokevirtual 248	java/io/InputStream:close	()V
    //   1586: goto +8 -> 1594
    //   1589: astore_3
    //   1590: aload_3
    //   1591: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1594: aload 12
    //   1596: ifnull +16 -> 1612
    //   1599: aload 12
    //   1601: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   1604: goto +8 -> 1612
    //   1607: astore_3
    //   1608: aload_3
    //   1609: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1612: aload_2
    //   1613: astore_3
    //   1614: aload 14
    //   1616: ifnull +931 -> 2547
    //   1619: aload 14
    //   1621: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   1624: aload_2
    //   1625: astore_3
    //   1626: goto +921 -> 2547
    //   1629: astore 13
    //   1631: aconst_null
    //   1632: astore 11
    //   1634: aload 11
    //   1636: astore 12
    //   1638: aload 12
    //   1640: astore_2
    //   1641: aload_2
    //   1642: astore 14
    //   1644: aload 16
    //   1646: astore 15
    //   1648: aload 11
    //   1650: astore_3
    //   1651: aload 12
    //   1653: astore 5
    //   1655: aload 15
    //   1657: astore 9
    //   1659: aload 14
    //   1661: astore 10
    //   1663: aload 13
    //   1665: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1668: aload 11
    //   1670: astore_3
    //   1671: aload 12
    //   1673: astore 5
    //   1675: aload 15
    //   1677: astore 9
    //   1679: aload 14
    //   1681: astore 10
    //   1683: aload_0
    //   1684: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1687: astore 16
    //   1689: aload 11
    //   1691: astore_3
    //   1692: aload 12
    //   1694: astore 5
    //   1696: aload 15
    //   1698: astore 9
    //   1700: aload 14
    //   1702: astore 10
    //   1704: new 66	java/lang/StringBuilder
    //   1707: dup
    //   1708: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1711: astore 17
    //   1713: aload 11
    //   1715: astore_3
    //   1716: aload 12
    //   1718: astore 5
    //   1720: aload 15
    //   1722: astore 9
    //   1724: aload 14
    //   1726: astore 10
    //   1728: aload 17
    //   1730: aload 13
    //   1732: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1735: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: pop
    //   1739: aload 11
    //   1741: astore_3
    //   1742: aload 12
    //   1744: astore 5
    //   1746: aload 15
    //   1748: astore 9
    //   1750: aload 14
    //   1752: astore 10
    //   1754: aload 17
    //   1756: ldc 252
    //   1758: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: pop
    //   1762: aload 11
    //   1764: astore_3
    //   1765: aload 12
    //   1767: astore 5
    //   1769: aload 15
    //   1771: astore 9
    //   1773: aload 14
    //   1775: astore 10
    //   1777: aload 17
    //   1779: aload 13
    //   1781: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1784: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: aload 11
    //   1790: astore_3
    //   1791: aload 12
    //   1793: astore 5
    //   1795: aload 15
    //   1797: astore 9
    //   1799: aload 14
    //   1801: astore 10
    //   1803: aload 16
    //   1805: sipush 10003
    //   1808: aload 17
    //   1810: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   1816: aload 11
    //   1818: astore_3
    //   1819: aload 12
    //   1821: astore 5
    //   1823: aload 15
    //   1825: astore 9
    //   1827: aload 14
    //   1829: astore 10
    //   1831: aload 13
    //   1833: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1836: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   1839: aload 11
    //   1841: astore_3
    //   1842: aload 12
    //   1844: astore 5
    //   1846: aload 15
    //   1848: astore 9
    //   1850: aload 14
    //   1852: astore 10
    //   1854: aload 13
    //   1856: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1859: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   1862: aload 15
    //   1864: ifnull +16 -> 1880
    //   1867: aload 15
    //   1869: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   1872: goto +8 -> 1880
    //   1875: astore_3
    //   1876: aload_3
    //   1877: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1880: aload 11
    //   1882: ifnull +16 -> 1898
    //   1885: aload 11
    //   1887: invokevirtual 248	java/io/InputStream:close	()V
    //   1890: goto +8 -> 1898
    //   1893: astore_3
    //   1894: aload_3
    //   1895: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1898: aload 12
    //   1900: ifnull +16 -> 1916
    //   1903: aload 12
    //   1905: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   1908: goto +8 -> 1916
    //   1911: astore_3
    //   1912: aload_3
    //   1913: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   1916: aload_2
    //   1917: astore_3
    //   1918: aload 14
    //   1920: ifnull +627 -> 2547
    //   1923: goto -304 -> 1619
    //   1926: astore 13
    //   1928: aconst_null
    //   1929: astore 11
    //   1931: aload 11
    //   1933: astore 12
    //   1935: aload 12
    //   1937: astore_2
    //   1938: aload_2
    //   1939: astore 14
    //   1941: aload 17
    //   1943: astore 15
    //   1945: aload 11
    //   1947: astore_3
    //   1948: aload 12
    //   1950: astore 5
    //   1952: aload 15
    //   1954: astore 9
    //   1956: aload 14
    //   1958: astore 10
    //   1960: aload 13
    //   1962: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   1965: aload 11
    //   1967: astore_3
    //   1968: aload 12
    //   1970: astore 5
    //   1972: aload 15
    //   1974: astore 9
    //   1976: aload 14
    //   1978: astore 10
    //   1980: aload_0
    //   1981: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   1984: astore 16
    //   1986: aload 11
    //   1988: astore_3
    //   1989: aload 12
    //   1991: astore 5
    //   1993: aload 15
    //   1995: astore 9
    //   1997: aload 14
    //   1999: astore 10
    //   2001: new 66	java/lang/StringBuilder
    //   2004: dup
    //   2005: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2008: astore 17
    //   2010: aload 11
    //   2012: astore_3
    //   2013: aload 12
    //   2015: astore 5
    //   2017: aload 15
    //   2019: astore 9
    //   2021: aload 14
    //   2023: astore 10
    //   2025: aload 17
    //   2027: aload 13
    //   2029: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   2032: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: pop
    //   2036: aload 11
    //   2038: astore_3
    //   2039: aload 12
    //   2041: astore 5
    //   2043: aload 15
    //   2045: astore 9
    //   2047: aload 14
    //   2049: astore 10
    //   2051: aload 17
    //   2053: ldc 252
    //   2055: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2058: pop
    //   2059: aload 11
    //   2061: astore_3
    //   2062: aload 12
    //   2064: astore 5
    //   2066: aload 15
    //   2068: astore 9
    //   2070: aload 14
    //   2072: astore 10
    //   2074: aload 17
    //   2076: aload 13
    //   2078: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2081: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload 11
    //   2087: astore_3
    //   2088: aload 12
    //   2090: astore 5
    //   2092: aload 15
    //   2094: astore 9
    //   2096: aload 14
    //   2098: astore 10
    //   2100: aload 16
    //   2102: sipush 10003
    //   2105: aload 17
    //   2107: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2110: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2113: aload 11
    //   2115: astore_3
    //   2116: aload 12
    //   2118: astore 5
    //   2120: aload 15
    //   2122: astore 9
    //   2124: aload 14
    //   2126: astore 10
    //   2128: aload 13
    //   2130: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   2133: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   2136: aload 11
    //   2138: astore_3
    //   2139: aload 12
    //   2141: astore 5
    //   2143: aload 15
    //   2145: astore 9
    //   2147: aload 14
    //   2149: astore 10
    //   2151: aload 13
    //   2153: invokevirtual 259	java/io/IOException:toString	()Ljava/lang/String;
    //   2156: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2159: aload 15
    //   2161: ifnull +16 -> 2177
    //   2164: aload 15
    //   2166: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2169: goto +8 -> 2177
    //   2172: astore_3
    //   2173: aload_3
    //   2174: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2177: aload 11
    //   2179: ifnull +16 -> 2195
    //   2182: aload 11
    //   2184: invokevirtual 248	java/io/InputStream:close	()V
    //   2187: goto +8 -> 2195
    //   2190: astore_3
    //   2191: aload_3
    //   2192: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2195: aload 12
    //   2197: ifnull +16 -> 2213
    //   2200: aload 12
    //   2202: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2205: goto +8 -> 2213
    //   2208: astore_3
    //   2209: aload_3
    //   2210: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2213: aload_2
    //   2214: astore_3
    //   2215: aload 14
    //   2217: ifnull +330 -> 2547
    //   2220: goto -601 -> 1619
    //   2223: astore 13
    //   2225: aconst_null
    //   2226: astore 11
    //   2228: aload 11
    //   2230: astore 12
    //   2232: aload 12
    //   2234: astore_2
    //   2235: aload_2
    //   2236: astore 14
    //   2238: aload 18
    //   2240: astore 15
    //   2242: aload 11
    //   2244: astore_3
    //   2245: aload 12
    //   2247: astore 5
    //   2249: aload 15
    //   2251: astore 9
    //   2253: aload 14
    //   2255: astore 10
    //   2257: aload 13
    //   2259: invokevirtual 261	java/net/SocketTimeoutException:printStackTrace	()V
    //   2262: aload 11
    //   2264: astore_3
    //   2265: aload 12
    //   2267: astore 5
    //   2269: aload 15
    //   2271: astore 9
    //   2273: aload 14
    //   2275: astore 10
    //   2277: aload_0
    //   2278: getfield 27	com/tencent/token/fc:a	Lcom/tencent/token/global/e;
    //   2281: astore 16
    //   2283: aload 11
    //   2285: astore_3
    //   2286: aload 12
    //   2288: astore 5
    //   2290: aload 15
    //   2292: astore 9
    //   2294: aload 14
    //   2296: astore 10
    //   2298: new 66	java/lang/StringBuilder
    //   2301: dup
    //   2302: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2305: astore 17
    //   2307: aload 11
    //   2309: astore_3
    //   2310: aload 12
    //   2312: astore 5
    //   2314: aload 15
    //   2316: astore 9
    //   2318: aload 14
    //   2320: astore 10
    //   2322: aload 17
    //   2324: aload 13
    //   2326: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2329: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2332: pop
    //   2333: aload 11
    //   2335: astore_3
    //   2336: aload 12
    //   2338: astore 5
    //   2340: aload 15
    //   2342: astore 9
    //   2344: aload 14
    //   2346: astore 10
    //   2348: aload 17
    //   2350: ldc 252
    //   2352: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: pop
    //   2356: aload 11
    //   2358: astore_3
    //   2359: aload 12
    //   2361: astore 5
    //   2363: aload 15
    //   2365: astore 9
    //   2367: aload 14
    //   2369: astore 10
    //   2371: aload 17
    //   2373: aload 13
    //   2375: invokevirtual 263	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   2378: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2381: pop
    //   2382: aload 11
    //   2384: astore_3
    //   2385: aload 12
    //   2387: astore 5
    //   2389: aload 15
    //   2391: astore 9
    //   2393: aload 14
    //   2395: astore 10
    //   2397: aload 16
    //   2399: sipush 10002
    //   2402: aload 17
    //   2404: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2407: invokevirtual 176	com/tencent/token/global/e:a	(ILjava/lang/String;)V
    //   2410: aload 11
    //   2412: astore_3
    //   2413: aload 12
    //   2415: astore 5
    //   2417: aload 15
    //   2419: astore 9
    //   2421: aload 14
    //   2423: astore 10
    //   2425: invokestatic 268	com/tencent/token/bv:a	()Lcom/tencent/token/bv;
    //   2428: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   2431: getstatic 275	com/tencent/token/fc:f	I
    //   2434: invokevirtual 278	com/tencent/token/bv:a	(JI)V
    //   2437: aload 11
    //   2439: astore_3
    //   2440: aload 12
    //   2442: astore 5
    //   2444: aload 15
    //   2446: astore 9
    //   2448: aload 14
    //   2450: astore 10
    //   2452: aload 13
    //   2454: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2457: invokestatic 99	com/tencent/token/global/g:a	(Ljava/lang/String;)V
    //   2460: aload 11
    //   2462: astore_3
    //   2463: aload 12
    //   2465: astore 5
    //   2467: aload 15
    //   2469: astore 9
    //   2471: aload 14
    //   2473: astore 10
    //   2475: aload 13
    //   2477: invokevirtual 262	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   2480: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2483: aload 15
    //   2485: ifnull +16 -> 2501
    //   2488: aload 15
    //   2490: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2493: goto +8 -> 2501
    //   2496: astore_3
    //   2497: aload_3
    //   2498: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2501: aload 11
    //   2503: ifnull +16 -> 2519
    //   2506: aload 11
    //   2508: invokevirtual 248	java/io/InputStream:close	()V
    //   2511: goto +8 -> 2519
    //   2514: astore_3
    //   2515: aload_3
    //   2516: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2519: aload 12
    //   2521: ifnull +16 -> 2537
    //   2524: aload 12
    //   2526: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2529: goto +8 -> 2537
    //   2532: astore_3
    //   2533: aload_3
    //   2534: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2537: aload_2
    //   2538: astore_3
    //   2539: aload 14
    //   2541: ifnull +6 -> 2547
    //   2544: goto -925 -> 1619
    //   2547: new 66	java/lang/StringBuilder
    //   2550: dup
    //   2551: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2554: astore_2
    //   2555: aload_2
    //   2556: ldc_w 280
    //   2559: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2562: pop
    //   2563: aload_2
    //   2564: aload 24
    //   2566: invokevirtual 282	com/tencent/token/utils/k:a	()J
    //   2569: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2572: pop
    //   2573: aload_2
    //   2574: ldc_w 284
    //   2577: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: pop
    //   2581: aload_2
    //   2582: aload_1
    //   2583: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2586: pop
    //   2587: aload_2
    //   2588: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2591: invokestatic 212	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   2594: new 66	java/lang/StringBuilder
    //   2597: dup
    //   2598: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   2601: astore_2
    //   2602: aload_2
    //   2603: ldc_w 280
    //   2606: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: pop
    //   2610: aload_2
    //   2611: aload 24
    //   2613: invokevirtual 282	com/tencent/token/utils/k:a	()J
    //   2616: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2619: pop
    //   2620: aload_2
    //   2621: ldc_w 284
    //   2624: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2627: pop
    //   2628: aload_1
    //   2629: ldc 186
    //   2631: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2634: iconst_m1
    //   2635: if_icmpne +6 -> 2641
    //   2638: goto +15 -> 2653
    //   2641: aload_1
    //   2642: iconst_0
    //   2643: aload_1
    //   2644: ldc 186
    //   2646: invokevirtual 190	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2649: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   2652: astore_1
    //   2653: aload_2
    //   2654: aload_1
    //   2655: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: pop
    //   2659: aload_2
    //   2660: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2663: invokestatic 196	com/tencent/token/global/g:d	(Ljava/lang/String;)V
    //   2666: aload_3
    //   2667: areturn
    //   2668: astore_1
    //   2669: aload 9
    //   2671: astore_2
    //   2672: aload 10
    //   2674: astore 9
    //   2676: aload_2
    //   2677: ifnull +15 -> 2692
    //   2680: aload_2
    //   2681: invokevirtual 244	java/io/ByteArrayOutputStream:close	()V
    //   2684: goto +8 -> 2692
    //   2687: astore_2
    //   2688: aload_2
    //   2689: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2692: aload_3
    //   2693: ifnull +15 -> 2708
    //   2696: aload_3
    //   2697: invokevirtual 248	java/io/InputStream:close	()V
    //   2700: goto +8 -> 2708
    //   2703: astore_2
    //   2704: aload_2
    //   2705: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2708: aload 5
    //   2710: ifnull +16 -> 2726
    //   2713: aload 5
    //   2715: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   2718: goto +8 -> 2726
    //   2721: astore_2
    //   2722: aload_2
    //   2723: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   2726: aload 9
    //   2728: ifnull +8 -> 2736
    //   2731: aload 9
    //   2733: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   2736: aload_1
    //   2737: athrow
    //   2738: aconst_null
    //   2739: astore 11
    //   2741: goto -2515 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2744	0	this	fc
    //   0	2744	1	paramString1	String
    //   0	2744	2	paramString2	String
    //   0	2744	3	paramString3	String
    //   0	2744	4	paramBoolean	boolean
    //   0	2744	5	paramArrayOfByte	byte[]
    //   400	507	6	i	int
    //   167	49	7	l	long
    //   51	2681	9	localObject1	Object
    //   93	2580	10	localObject2	Object
    //   144	663	11	localObject3	Object
    //   1020	7	11	localThrowable1	java.lang.Throwable
    //   1033	7	11	localException1	Exception
    //   1046	7	11	localIOException1	IOException
    //   1059	7	11	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   1175	1565	11	str	String
    //   40	2485	12	localObject4	Object
    //   37	1	13	localObject5	Object
    //   307	1	13	localThrowable2	java.lang.Throwable
    //   326	1	13	localException2	Exception
    //   349	1	13	localIOException2	IOException
    //   372	778	13	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1172	76	13	arrayOfByte	byte[]
    //   1271	1	13	localThrowable3	java.lang.Throwable
    //   1290	1	13	localException3	Exception
    //   1313	1	13	localIOException3	IOException
    //   1336	1	13	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1375	147	13	localThrowable4	java.lang.Throwable
    //   1629	226	13	localException4	Exception
    //   1926	226	13	localIOException4	IOException
    //   2223	253	13	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   13	2527	14	localObject6	Object
    //   25	2464	15	localObject7	Object
    //   28	2370	16	locale	e
    //   31	2372	17	localStringBuilder1	StringBuilder
    //   34	2205	18	localObject8	Object
    //   16	1173	19	localObject9	Object
    //   19	1195	20	localObject10	Object
    //   22	1217	21	localObject11	Object
    //   43	918	22	localObject12	Object
    //   10	803	23	localStringBuilder2	StringBuilder
    //   7	2605	24	localk	com.tencent.token.utils.k
    // Exception table:
    //   from	to	target	type
    //   246	252	294	finally
    //   257	281	294	finally
    //   281	291	294	finally
    //   246	252	307	java/lang/Throwable
    //   257	281	307	java/lang/Throwable
    //   281	291	307	java/lang/Throwable
    //   246	252	326	java/lang/Exception
    //   257	281	326	java/lang/Exception
    //   281	291	326	java/lang/Exception
    //   246	252	349	java/io/IOException
    //   257	281	349	java/io/IOException
    //   281	291	349	java/io/IOException
    //   246	252	372	java/net/SocketTimeoutException
    //   257	281	372	java/net/SocketTimeoutException
    //   281	291	372	java/net/SocketTimeoutException
    //   975	979	982	java/lang/Exception
    //   992	997	1000	java/lang/Exception
    //   929	935	1020	java/lang/Throwable
    //   938	945	1020	java/lang/Throwable
    //   951	960	1020	java/lang/Throwable
    //   929	935	1033	java/lang/Exception
    //   938	945	1033	java/lang/Exception
    //   951	960	1033	java/lang/Exception
    //   929	935	1046	java/io/IOException
    //   938	945	1046	java/io/IOException
    //   951	960	1046	java/io/IOException
    //   929	935	1059	java/net/SocketTimeoutException
    //   938	945	1059	java/net/SocketTimeoutException
    //   951	960	1059	java/net/SocketTimeoutException
    //   892	899	1072	finally
    //   905	911	1072	finally
    //   914	924	1072	finally
    //   929	935	1072	finally
    //   938	945	1072	finally
    //   951	960	1072	finally
    //   892	899	1086	java/lang/Throwable
    //   905	911	1086	java/lang/Throwable
    //   914	924	1086	java/lang/Throwable
    //   892	899	1100	java/lang/Exception
    //   905	911	1100	java/lang/Exception
    //   914	924	1100	java/lang/Exception
    //   892	899	1114	java/io/IOException
    //   905	911	1114	java/io/IOException
    //   914	924	1114	java/io/IOException
    //   892	899	1128	java/net/SocketTimeoutException
    //   905	911	1128	java/net/SocketTimeoutException
    //   914	924	1128	java/net/SocketTimeoutException
    //   884	892	1142	finally
    //   884	892	1159	java/lang/Throwable
    //   884	892	1184	java/lang/Exception
    //   884	892	1209	java/io/IOException
    //   884	892	1234	java/net/SocketTimeoutException
    //   74	81	1259	finally
    //   86	223	1259	finally
    //   226	246	1259	finally
    //   395	452	1259	finally
    //   477	582	1259	finally
    //   587	599	1259	finally
    //   599	626	1259	finally
    //   638	645	1259	finally
    //   657	664	1259	finally
    //   664	785	1259	finally
    //   791	804	1259	finally
    //   804	820	1259	finally
    //   825	847	1259	finally
    //   847	863	1259	finally
    //   875	881	1259	finally
    //   74	81	1271	java/lang/Throwable
    //   86	223	1271	java/lang/Throwable
    //   226	246	1271	java/lang/Throwable
    //   395	452	1271	java/lang/Throwable
    //   477	582	1271	java/lang/Throwable
    //   587	599	1271	java/lang/Throwable
    //   599	626	1271	java/lang/Throwable
    //   638	645	1271	java/lang/Throwable
    //   657	664	1271	java/lang/Throwable
    //   664	785	1271	java/lang/Throwable
    //   791	804	1271	java/lang/Throwable
    //   804	820	1271	java/lang/Throwable
    //   825	847	1271	java/lang/Throwable
    //   847	863	1271	java/lang/Throwable
    //   875	881	1271	java/lang/Throwable
    //   74	81	1290	java/lang/Exception
    //   86	223	1290	java/lang/Exception
    //   226	246	1290	java/lang/Exception
    //   395	452	1290	java/lang/Exception
    //   477	582	1290	java/lang/Exception
    //   587	599	1290	java/lang/Exception
    //   599	626	1290	java/lang/Exception
    //   638	645	1290	java/lang/Exception
    //   657	664	1290	java/lang/Exception
    //   664	785	1290	java/lang/Exception
    //   791	804	1290	java/lang/Exception
    //   804	820	1290	java/lang/Exception
    //   825	847	1290	java/lang/Exception
    //   847	863	1290	java/lang/Exception
    //   875	881	1290	java/lang/Exception
    //   74	81	1313	java/io/IOException
    //   86	223	1313	java/io/IOException
    //   226	246	1313	java/io/IOException
    //   395	452	1313	java/io/IOException
    //   477	582	1313	java/io/IOException
    //   587	599	1313	java/io/IOException
    //   599	626	1313	java/io/IOException
    //   638	645	1313	java/io/IOException
    //   657	664	1313	java/io/IOException
    //   664	785	1313	java/io/IOException
    //   791	804	1313	java/io/IOException
    //   804	820	1313	java/io/IOException
    //   825	847	1313	java/io/IOException
    //   847	863	1313	java/io/IOException
    //   875	881	1313	java/io/IOException
    //   74	81	1336	java/net/SocketTimeoutException
    //   86	223	1336	java/net/SocketTimeoutException
    //   226	246	1336	java/net/SocketTimeoutException
    //   395	452	1336	java/net/SocketTimeoutException
    //   477	582	1336	java/net/SocketTimeoutException
    //   587	599	1336	java/net/SocketTimeoutException
    //   599	626	1336	java/net/SocketTimeoutException
    //   638	645	1336	java/net/SocketTimeoutException
    //   657	664	1336	java/net/SocketTimeoutException
    //   664	785	1336	java/net/SocketTimeoutException
    //   791	804	1336	java/net/SocketTimeoutException
    //   804	820	1336	java/net/SocketTimeoutException
    //   825	847	1336	java/net/SocketTimeoutException
    //   847	863	1336	java/net/SocketTimeoutException
    //   875	881	1336	java/net/SocketTimeoutException
    //   45	53	1359	finally
    //   45	53	1375	java/lang/Throwable
    //   1563	1568	1571	java/lang/Exception
    //   1581	1586	1589	java/lang/Exception
    //   1599	1604	1607	java/lang/Exception
    //   45	53	1629	java/lang/Exception
    //   1867	1872	1875	java/lang/Exception
    //   1885	1890	1893	java/lang/Exception
    //   1903	1908	1911	java/lang/Exception
    //   45	53	1926	java/io/IOException
    //   2164	2169	2172	java/lang/Exception
    //   2182	2187	2190	java/lang/Exception
    //   2200	2205	2208	java/lang/Exception
    //   45	53	2223	java/net/SocketTimeoutException
    //   2488	2493	2496	java/lang/Exception
    //   2506	2511	2514	java/lang/Exception
    //   2524	2529	2532	java/lang/Exception
    //   1405	1410	2668	finally
    //   1425	1431	2668	finally
    //   1446	1455	2668	finally
    //   1470	1481	2668	finally
    //   1496	1504	2668	finally
    //   1519	1530	2668	finally
    //   1545	1558	2668	finally
    //   1663	1668	2668	finally
    //   1683	1689	2668	finally
    //   1704	1713	2668	finally
    //   1728	1739	2668	finally
    //   1754	1762	2668	finally
    //   1777	1788	2668	finally
    //   1803	1816	2668	finally
    //   1831	1839	2668	finally
    //   1854	1862	2668	finally
    //   1960	1965	2668	finally
    //   1980	1986	2668	finally
    //   2001	2010	2668	finally
    //   2025	2036	2668	finally
    //   2051	2059	2668	finally
    //   2074	2085	2668	finally
    //   2100	2113	2668	finally
    //   2128	2136	2668	finally
    //   2151	2159	2668	finally
    //   2257	2262	2668	finally
    //   2277	2283	2668	finally
    //   2298	2307	2668	finally
    //   2322	2333	2668	finally
    //   2348	2356	2668	finally
    //   2371	2382	2668	finally
    //   2397	2410	2668	finally
    //   2425	2437	2668	finally
    //   2452	2460	2668	finally
    //   2475	2483	2668	finally
    //   2680	2684	2687	java/lang/Exception
    //   2696	2700	2703	java/lang/Exception
    //   2713	2718	2721	java/lang/Exception
  }
  
  public static int b()
  {
    Object localObject1 = RqdApplication.n();
    if (localObject1 != null)
    {
      Object localObject2 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject2 != null)
      {
        if (((NetworkInfo)localObject2).getType() == 0)
        {
          localObject1 = android.net.Proxy.getDefaultHost();
          int i = android.net.Proxy.getDefaultPort();
          String str = ((NetworkInfo)localObject2).getExtraInfo();
          f = ((NetworkInfo)localObject2).getSubtype() + 200000;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("conn proxy host=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("; port=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("; mobile type=");
          ((StringBuilder)localObject2).append(str);
          g.a(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("conn proxy host=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("; port=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("; mobile type=");
          ((StringBuilder)localObject2).append(str);
          g.d(((StringBuilder)localObject2).toString());
          if ((localObject1 != null) && (-1 != i) && (str != null) && ((str.toLowerCase(Locale.getDefault()).equals("cmwap")) || (str.toLowerCase(Locale.getDefault()).equals("uniwap")) || (str.toLowerCase(Locale.getDefault()).equals("3gwap")))) {
            return 3;
          }
          if ((localObject1 != null) && (-1 != i) && (str != null) && (str.toLowerCase(Locale.getDefault()).equals("ctwap"))) {
            return 5;
          }
          return 2;
        }
        f = 100000;
        return 1;
      }
      return 6;
    }
    return 0;
  }
  
  public e a()
  {
    return this.a;
  }
  
  HttpURLConnection a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        switch (b())
        {
        case 6: 
          localObject = paramString1.getProtocol();
          continue;
          this.a.a(10001, "conn is close");
          return null;
        case 5: 
          localObject = new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort());
          paramString1 = (HttpURLConnection)paramString1.openConnection(new java.net.Proxy(Proxy.Type.HTTP, (SocketAddress)localObject));
          continue;
          if (((String)localObject).toLowerCase().equals("https")) {
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
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1.toString());
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        paramString2.a(10003, ((StringBuilder)localObject).toString());
        paramString1.printStackTrace();
        return null;
      }
      catch (IOException paramString1)
      {
        paramString2 = this.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1.toString());
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        paramString2.a(10003, ((StringBuilder)localObject).toString());
        return null;
      }
    }
  }
  
  public byte[] a(String paramString)
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
  
  public byte[] a(String paramString, ContentValues paramContentValues)
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
  
  public byte[] a(String paramString1, File paramFile, ContentValues paramContentValues, String paramString2)
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
    paramContentValues = new StringBuilder();
    paramContentValues.append("testlogfile:");
    paramContentValues.append(localStringBuffer);
    g.c(paramContentValues.toString());
    return a(paramString1, "POST", localStringBuffer.toString(), paramFile);
  }
  
  public byte[] a(String paramString1, byte[] paramArrayOfByte, ContentValues paramContentValues, String paramString2)
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
    paramContentValues = new StringBuilder();
    paramContentValues.append("requestUploadFileEnc:");
    paramContentValues.append(localStringBuffer);
    g.c(paramContentValues.toString());
    return a(paramString1, "POST", localStringBuffer.toString(), true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fc
 * JD-Core Version:    0.7.0.1
 */