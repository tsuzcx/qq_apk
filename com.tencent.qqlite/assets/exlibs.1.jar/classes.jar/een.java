import java.net.Socket;
import java.net.SocketException;
import org.apache.http.protocol.HttpRequestHandler;

public class een
  implements HttpRequestHandler
{
  private static String b = "9u23fh$jkf^%43hj";
  private final String jdField_a_of_type_JavaLangString;
  private Socket jdField_a_of_type_JavaNetSocket;
  
  public een(String paramString, Socket paramSocket)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaNetSocket = paramSocket;
    try
    {
      this.jdField_a_of_type_JavaNetSocket.setSendBufferSize(204800);
      this.jdField_a_of_type_JavaNetSocket.setReceiveBufferSize(204800);
      return;
    }
    catch (SocketException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 56 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 48 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 40 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 32 | (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 5)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 0;
  }
  
  public static String a(long paramLong)
  {
    if ((paramLong > 4294967295L) || (paramLong < 0L)) {
      throw new IllegalArgumentException("invalid ip");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 3)
    {
      int j = i * 8;
      localStringBuilder.append((255 << j & paramLong) >> j);
      if (i < 3) {
        localStringBuilder.append(".");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  /* Error */
  public void handle(org.apache.http.HttpRequest paramHttpRequest, org.apache.http.HttpResponse paramHttpResponse, org.apache.http.protocol.HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 76
    //   3: invokeinterface 82 2 0
    //   8: checkcast 84	com/tencent/mobileqq/service/HttpNotify
    //   11: astore_3
    //   12: aload_1
    //   13: invokeinterface 90 1 0
    //   18: invokeinterface 95 1 0
    //   23: getstatic 101	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   26: invokevirtual 107	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   29: astore 26
    //   31: aload 26
    //   33: ldc 109
    //   35: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifne +51 -> 89
    //   41: aload 26
    //   43: ldc 115
    //   45: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +41 -> 89
    //   51: aload 26
    //   53: ldc 117
    //   55: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +31 -> 89
    //   61: new 119	org/apache/http/MethodNotSupportedException
    //   64: dup
    //   65: new 56	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   72: aload 26
    //   74: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 121
    //   79: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 122	org/apache/http/MethodNotSupportedException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: aload 26
    //   91: ldc 109
    //   93: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifne +13 -> 109
    //   99: aload 26
    //   101: ldc 115
    //   103: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +602 -> 708
    //   109: aload_1
    //   110: invokeinterface 90 1 0
    //   115: invokeinterface 125 1 0
    //   120: astore 26
    //   122: aload 26
    //   124: ldc 127
    //   126: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   129: istore 4
    //   131: iload 4
    //   133: iconst_1
    //   134: if_icmpge +21 -> 155
    //   137: ldc 133
    //   139: iconst_1
    //   140: ldc 135
    //   142: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_2
    //   146: sipush 400
    //   149: invokeinterface 146 2 0
    //   154: return
    //   155: aload 26
    //   157: bipush 8
    //   159: iload 4
    //   161: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   164: astore 27
    //   166: aload 26
    //   168: iload 4
    //   170: bipush 7
    //   172: iadd
    //   173: invokevirtual 153	java/lang/String:substring	(I)Ljava/lang/String;
    //   176: astore 26
    //   178: aload 27
    //   180: iconst_0
    //   181: invokestatic 158	com/tencent/mobileqq/utils/Base64Util:a	(Ljava/lang/String;I)[B
    //   184: astore 27
    //   186: new 160	com/tencent/qphone/base/util/Cryptor
    //   189: dup
    //   190: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   193: aload 27
    //   195: getstatic 16	een:b	Ljava/lang/String;
    //   198: invokevirtual 165	java/lang/String:getBytes	()[B
    //   201: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   204: astore 28
    //   206: aload 28
    //   208: ifnull +11 -> 219
    //   211: aload 28
    //   213: arraylength
    //   214: bipush 28
    //   216: if_icmpge +21 -> 237
    //   219: ldc 133
    //   221: iconst_1
    //   222: ldc 171
    //   224: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_2
    //   228: sipush 400
    //   231: invokeinterface 146 2 0
    //   236: return
    //   237: new 103	java/lang/String
    //   240: dup
    //   241: aload 28
    //   243: iconst_0
    //   244: bipush 16
    //   246: invokespecial 174	java/lang/String:<init>	([BII)V
    //   249: astore 27
    //   251: aload 28
    //   253: bipush 20
    //   255: invokestatic 176	een:a	([BI)J
    //   258: lstore 14
    //   260: aload 26
    //   262: iconst_0
    //   263: invokestatic 158	com/tencent/mobileqq/utils/Base64Util:a	(Ljava/lang/String;I)[B
    //   266: astore 26
    //   268: new 160	com/tencent/qphone/base/util/Cryptor
    //   271: dup
    //   272: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   275: aload 26
    //   277: aload 27
    //   279: invokevirtual 165	java/lang/String:getBytes	()[B
    //   282: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   285: astore 26
    //   287: aload 26
    //   289: ifnull +11 -> 300
    //   292: aload 26
    //   294: arraylength
    //   295: bipush 16
    //   297: if_icmpge +21 -> 318
    //   300: ldc 133
    //   302: iconst_1
    //   303: ldc 178
    //   305: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_2
    //   309: sipush 400
    //   312: invokeinterface 146 2 0
    //   317: return
    //   318: lload 14
    //   320: invokestatic 182	eeu:a	(J)Ljava/lang/String;
    //   323: astore 26
    //   325: new 184	java/io/File
    //   328: dup
    //   329: aload 26
    //   331: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   334: astore 27
    //   336: aload 27
    //   338: invokevirtual 189	java/io/File:canRead	()Z
    //   341: ifeq +11 -> 352
    //   344: aload 27
    //   346: invokevirtual 192	java/io/File:isDirectory	()Z
    //   349: ifeq +70 -> 419
    //   352: aload_2
    //   353: sipush 403
    //   356: invokeinterface 146 2 0
    //   361: return
    //   362: astore_1
    //   363: iconst_0
    //   364: istore 4
    //   366: ldc 133
    //   368: iconst_1
    //   369: new 56	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   376: ldc 194
    //   378: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 4
    //   396: ifeq +13 -> 409
    //   399: aload_3
    //   400: lload 14
    //   402: iconst_0
    //   403: lconst_0
    //   404: invokeinterface 200 6 0
    //   409: aload_2
    //   410: sipush 404
    //   413: invokeinterface 146 2 0
    //   418: return
    //   419: aload 27
    //   421: invokevirtual 203	java/io/File:exists	()Z
    //   424: ifeq +13 -> 437
    //   427: aload 27
    //   429: invokevirtual 207	java/io/File:length	()J
    //   432: lconst_0
    //   433: lcmp
    //   434: ifne +21 -> 455
    //   437: ldc 133
    //   439: iconst_1
    //   440: ldc 209
    //   442: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_2
    //   446: sipush 404
    //   449: invokeinterface 146 2 0
    //   454: return
    //   455: lconst_0
    //   456: lstore 12
    //   458: aload_1
    //   459: ldc 211
    //   461: invokeinterface 215 2 0
    //   466: astore_1
    //   467: lload 12
    //   469: lstore 10
    //   471: aload_1
    //   472: ifnull +91 -> 563
    //   475: aload_1
    //   476: invokeinterface 220 1 0
    //   481: astore_1
    //   482: aload_1
    //   483: ldc 222
    //   485: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   488: istore 4
    //   490: aload_1
    //   491: ldc 224
    //   493: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   496: istore 5
    //   498: lload 12
    //   500: lstore 10
    //   502: iload 4
    //   504: ifle +59 -> 563
    //   507: lload 12
    //   509: lstore 10
    //   511: iload 5
    //   513: ifle +50 -> 563
    //   516: lload 12
    //   518: lstore 10
    //   520: iload 5
    //   522: iload 4
    //   524: if_icmple +39 -> 563
    //   527: aload_1
    //   528: iload 4
    //   530: iconst_1
    //   531: iadd
    //   532: iload 5
    //   534: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   537: invokestatic 230	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   540: invokestatic 234	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   543: astore_1
    //   544: lload 12
    //   546: lstore 10
    //   548: aload_1
    //   549: invokevirtual 237	java/lang/Long:longValue	()J
    //   552: lconst_0
    //   553: lcmp
    //   554: ifle +9 -> 563
    //   557: aload_1
    //   558: invokevirtual 237	java/lang/Long:longValue	()J
    //   561: lstore 10
    //   563: ldc 133
    //   565: iconst_2
    //   566: new 56	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   573: ldc 239
    //   575: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 26
    //   580: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: aload_3
    //   590: lload 14
    //   592: lload 10
    //   594: invokeinterface 242 5 0
    //   599: aload_2
    //   600: sipush 200
    //   603: invokeinterface 146 2 0
    //   608: aload 27
    //   610: invokevirtual 207	java/io/File:length	()J
    //   613: lstore 12
    //   615: aload_2
    //   616: ldc 244
    //   618: new 56	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   625: ldc 246
    //   627: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: lload 10
    //   632: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   635: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc 224
    //   640: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: lload 12
    //   645: lconst_1
    //   646: lsub
    //   647: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   650: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: ldc 250
    //   655: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: lload 12
    //   660: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   663: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokeinterface 254 3 0
    //   674: aload_2
    //   675: new 256	com/tencent/mobileqq/service/DataLineHttpFileEntity
    //   678: dup
    //   679: aload 27
    //   681: lload 10
    //   683: ldc_w 258
    //   686: lload 14
    //   688: ldc_w 260
    //   691: aload_3
    //   692: invokespecial 263	com/tencent/mobileqq/service/DataLineHttpFileEntity:<init>	(Ljava/io/File;JLjava/lang/String;JLjava/lang/String;Lcom/tencent/mobileqq/service/HttpNotify;)V
    //   695: invokeinterface 267 2 0
    //   700: return
    //   701: astore_1
    //   702: iconst_1
    //   703: istore 4
    //   705: goto -339 -> 366
    //   708: aload 26
    //   710: ldc 117
    //   712: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq -561 -> 154
    //   718: aload_1
    //   719: invokeinterface 90 1 0
    //   724: invokeinterface 125 1 0
    //   729: astore 27
    //   731: aload_1
    //   732: ldc 211
    //   734: invokeinterface 271 2 0
    //   739: iconst_0
    //   740: aaload
    //   741: invokeinterface 220 1 0
    //   746: astore 26
    //   748: aload 26
    //   750: aload 26
    //   752: bipush 61
    //   754: invokevirtual 274	java/lang/String:indexOf	(I)I
    //   757: iconst_1
    //   758: iadd
    //   759: aload 26
    //   761: bipush 45
    //   763: invokevirtual 274	java/lang/String:indexOf	(I)I
    //   766: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   769: invokestatic 277	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   772: invokevirtual 237	java/lang/Long:longValue	()J
    //   775: lstore 20
    //   777: aload 27
    //   779: ldc_w 279
    //   782: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   785: istore 4
    //   787: aload 27
    //   789: bipush 38
    //   791: iload 4
    //   793: invokevirtual 282	java/lang/String:indexOf	(II)I
    //   796: istore 5
    //   798: iload 4
    //   800: iconst_m1
    //   801: if_icmpeq +9 -> 810
    //   804: iload 5
    //   806: iconst_m1
    //   807: if_icmpne +22 -> 829
    //   810: ldc 133
    //   812: iconst_1
    //   813: ldc_w 284
    //   816: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: aload_2
    //   820: sipush 400
    //   823: invokeinterface 146 2 0
    //   828: return
    //   829: aload 27
    //   831: ldc_w 286
    //   834: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   837: istore 6
    //   839: aload 27
    //   841: bipush 38
    //   843: iload 6
    //   845: invokevirtual 282	java/lang/String:indexOf	(II)I
    //   848: istore 7
    //   850: iload 6
    //   852: iconst_m1
    //   853: if_icmpeq +9 -> 862
    //   856: iload 7
    //   858: iconst_m1
    //   859: if_icmpne +22 -> 881
    //   862: ldc 133
    //   864: iconst_1
    //   865: ldc_w 288
    //   868: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aload_2
    //   872: sipush 400
    //   875: invokeinterface 146 2 0
    //   880: return
    //   881: aload 27
    //   883: ldc_w 290
    //   886: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   889: istore 8
    //   891: aload 27
    //   893: bipush 38
    //   895: iload 8
    //   897: invokevirtual 282	java/lang/String:indexOf	(II)I
    //   900: istore 9
    //   902: iload 8
    //   904: iconst_m1
    //   905: if_icmpeq +9 -> 914
    //   908: iload 9
    //   910: iconst_m1
    //   911: if_icmpne +22 -> 933
    //   914: ldc 133
    //   916: iconst_1
    //   917: ldc_w 292
    //   920: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: aload_2
    //   924: sipush 400
    //   927: invokeinterface 146 2 0
    //   932: return
    //   933: aload 27
    //   935: iload 4
    //   937: iconst_5
    //   938: iadd
    //   939: iload 5
    //   941: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   944: astore 28
    //   946: aload 27
    //   948: iload 6
    //   950: bipush 8
    //   952: iadd
    //   953: iload 7
    //   955: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   958: astore 26
    //   960: aload 27
    //   962: iload 8
    //   964: bipush 9
    //   966: iadd
    //   967: iload 9
    //   969: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   972: invokestatic 277	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   975: invokevirtual 237	java/lang/Long:longValue	()J
    //   978: lstore 14
    //   980: aload 28
    //   982: invokestatic 297	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   985: astore 27
    //   987: new 160	com/tencent/qphone/base/util/Cryptor
    //   990: dup
    //   991: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   994: aload 27
    //   996: getstatic 16	een:b	Ljava/lang/String;
    //   999: invokevirtual 165	java/lang/String:getBytes	()[B
    //   1002: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   1005: astore 28
    //   1007: aload 28
    //   1009: ifnull +11 -> 1020
    //   1012: aload 28
    //   1014: arraylength
    //   1015: bipush 28
    //   1017: if_icmpge +21 -> 1038
    //   1020: ldc 133
    //   1022: iconst_1
    //   1023: ldc 171
    //   1025: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: aload_2
    //   1029: sipush 400
    //   1032: invokeinterface 146 2 0
    //   1037: return
    //   1038: new 103	java/lang/String
    //   1041: dup
    //   1042: aload 28
    //   1044: iconst_0
    //   1045: bipush 16
    //   1047: invokespecial 174	java/lang/String:<init>	([BII)V
    //   1050: astore 27
    //   1052: aload 28
    //   1054: bipush 20
    //   1056: invokestatic 176	een:a	([BI)J
    //   1059: lstore 16
    //   1061: aload 26
    //   1063: invokestatic 297	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   1066: astore 26
    //   1068: new 160	com/tencent/qphone/base/util/Cryptor
    //   1071: dup
    //   1072: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   1075: aload 26
    //   1077: aload 27
    //   1079: invokevirtual 165	java/lang/String:getBytes	()[B
    //   1082: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   1085: astore 26
    //   1087: aload 26
    //   1089: ifnull +11 -> 1100
    //   1092: aload 26
    //   1094: arraylength
    //   1095: bipush 16
    //   1097: if_icmpge +21 -> 1118
    //   1100: ldc 133
    //   1102: iconst_1
    //   1103: ldc 178
    //   1105: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1108: aload_2
    //   1109: sipush 400
    //   1112: invokeinterface 146 2 0
    //   1117: return
    //   1118: lload 16
    //   1120: invokestatic 182	eeu:a	(J)Ljava/lang/String;
    //   1123: astore 27
    //   1125: new 184	java/io/File
    //   1128: dup
    //   1129: aload 27
    //   1131: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   1134: astore 26
    //   1136: aload 26
    //   1138: invokevirtual 203	java/io/File:exists	()Z
    //   1141: ifne +9 -> 1150
    //   1144: aload 26
    //   1146: invokevirtual 300	java/io/File:createNewFile	()Z
    //   1149: pop
    //   1150: iconst_0
    //   1151: istore 5
    //   1153: lconst_0
    //   1154: lstore 12
    //   1156: lload 12
    //   1158: lstore 10
    //   1160: aload_1
    //   1161: instanceof 302
    //   1164: ifeq +70 -> 1234
    //   1167: iload 5
    //   1169: istore 4
    //   1171: lload 12
    //   1173: lstore 10
    //   1175: aload 26
    //   1177: invokevirtual 189	java/io/File:canRead	()Z
    //   1180: ifeq +19 -> 1199
    //   1183: iload 5
    //   1185: istore 4
    //   1187: lload 12
    //   1189: lstore 10
    //   1191: aload 26
    //   1193: invokevirtual 192	java/io/File:isDirectory	()Z
    //   1196: ifeq +75 -> 1271
    //   1199: iload 5
    //   1201: istore 4
    //   1203: lload 12
    //   1205: lstore 10
    //   1207: aload_2
    //   1208: sipush 403
    //   1211: invokeinterface 146 2 0
    //   1216: lload 12
    //   1218: lstore 10
    //   1220: aload_1
    //   1221: checkcast 302	org/apache/http/HttpEntityEnclosingRequest
    //   1224: invokeinterface 306 1 0
    //   1229: invokeinterface 311 1 0
    //   1234: aload_2
    //   1235: ldc 211
    //   1237: aload 26
    //   1239: invokevirtual 207	java/io/File:length	()J
    //   1242: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1245: invokeinterface 254 3 0
    //   1250: aload 26
    //   1252: invokevirtual 207	java/io/File:length	()J
    //   1255: lload 14
    //   1257: lcmp
    //   1258: ifle +593 -> 1851
    //   1261: aload_2
    //   1262: sipush 403
    //   1265: invokeinterface 146 2 0
    //   1270: return
    //   1271: iload 5
    //   1273: istore 4
    //   1275: lload 12
    //   1277: lstore 10
    //   1279: aload_1
    //   1280: checkcast 302	org/apache/http/HttpEntityEnclosingRequest
    //   1283: invokeinterface 306 1 0
    //   1288: astore 28
    //   1290: iload 5
    //   1292: istore 4
    //   1294: lload 12
    //   1296: lstore 10
    //   1298: aload 26
    //   1300: invokevirtual 207	java/io/File:length	()J
    //   1303: lstore 18
    //   1305: lload 20
    //   1307: lload 18
    //   1309: lcmp
    //   1310: ifge +104 -> 1414
    //   1313: iload 5
    //   1315: istore 4
    //   1317: lload 12
    //   1319: lstore 10
    //   1321: aload_2
    //   1322: sipush 206
    //   1325: invokeinterface 146 2 0
    //   1330: lload 12
    //   1332: lstore 10
    //   1334: goto -114 -> 1220
    //   1337: astore 27
    //   1339: ldc 133
    //   1341: iconst_1
    //   1342: new 56	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1349: ldc 194
    //   1351: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: aload 27
    //   1356: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1359: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: iload 4
    //   1370: ifeq +14 -> 1384
    //   1373: aload_3
    //   1374: lload 16
    //   1376: iconst_0
    //   1377: lload 10
    //   1379: invokeinterface 200 6 0
    //   1384: aload_2
    //   1385: sipush 404
    //   1388: invokeinterface 146 2 0
    //   1393: aload_1
    //   1394: checkcast 302	org/apache/http/HttpEntityEnclosingRequest
    //   1397: invokeinterface 306 1 0
    //   1402: invokeinterface 311 1 0
    //   1407: goto -173 -> 1234
    //   1410: astore_1
    //   1411: goto -177 -> 1234
    //   1414: lload 20
    //   1416: lload 18
    //   1418: lcmp
    //   1419: ifle +44 -> 1463
    //   1422: iload 5
    //   1424: istore 4
    //   1426: lload 12
    //   1428: lstore 10
    //   1430: aload_2
    //   1431: sipush 403
    //   1434: invokeinterface 146 2 0
    //   1439: lload 12
    //   1441: lstore 10
    //   1443: goto -223 -> 1220
    //   1446: astore_2
    //   1447: aload_1
    //   1448: checkcast 302	org/apache/http/HttpEntityEnclosingRequest
    //   1451: invokeinterface 306 1 0
    //   1456: invokeinterface 311 1 0
    //   1461: aload_2
    //   1462: athrow
    //   1463: iload 5
    //   1465: istore 4
    //   1467: lload 12
    //   1469: lstore 10
    //   1471: ldc 133
    //   1473: iconst_2
    //   1474: new 56	java/lang/StringBuilder
    //   1477: dup
    //   1478: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1481: ldc_w 313
    //   1484: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: aload 27
    //   1489: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1495: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1498: iload 5
    //   1500: istore 4
    //   1502: lload 12
    //   1504: lstore 10
    //   1506: aload_3
    //   1507: lload 16
    //   1509: lload 18
    //   1511: invokeinterface 242 5 0
    //   1516: iconst_1
    //   1517: istore 6
    //   1519: iload 6
    //   1521: istore 4
    //   1523: lload 12
    //   1525: lstore 10
    //   1527: aload 28
    //   1529: invokeinterface 316 1 0
    //   1534: lstore 20
    //   1536: iload 6
    //   1538: istore 4
    //   1540: lload 12
    //   1542: lstore 10
    //   1544: aload 28
    //   1546: invokeinterface 320 1 0
    //   1551: astore 28
    //   1553: iload 6
    //   1555: istore 4
    //   1557: lload 12
    //   1559: lstore 10
    //   1561: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   1564: ldc2_w 326
    //   1567: ldiv
    //   1568: lstore 22
    //   1570: iconst_0
    //   1571: istore 5
    //   1573: iload 6
    //   1575: istore 4
    //   1577: lload 12
    //   1579: lstore 10
    //   1581: ldc_w 328
    //   1584: newarray byte
    //   1586: astore 29
    //   1588: iload 6
    //   1590: istore 4
    //   1592: lload 12
    //   1594: lstore 10
    //   1596: aload 28
    //   1598: aload 29
    //   1600: invokevirtual 334	java/io/InputStream:read	([B)I
    //   1603: istore 7
    //   1605: lload 12
    //   1607: lstore 10
    //   1609: iload 7
    //   1611: iconst_m1
    //   1612: if_icmpeq -392 -> 1220
    //   1615: lload 12
    //   1617: lstore 10
    //   1619: iload 5
    //   1621: i2l
    //   1622: lload 20
    //   1624: lcmp
    //   1625: ifgt -405 -> 1220
    //   1628: lload 12
    //   1630: lstore 10
    //   1632: iload 5
    //   1634: i2l
    //   1635: lload 18
    //   1637: ladd
    //   1638: lload 14
    //   1640: lcmp
    //   1641: ifgt -421 -> 1220
    //   1644: iload 6
    //   1646: istore 4
    //   1648: lload 12
    //   1650: lstore 10
    //   1652: invokestatic 339	java/lang/Thread:interrupted	()Z
    //   1655: ifeq +22 -> 1677
    //   1658: iload 6
    //   1660: istore 4
    //   1662: lload 12
    //   1664: lstore 10
    //   1666: new 341	java/lang/InterruptedException
    //   1669: dup
    //   1670: ldc_w 343
    //   1673: invokespecial 344	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   1676: athrow
    //   1677: iload 6
    //   1679: istore 4
    //   1681: lload 12
    //   1683: lstore 10
    //   1685: new 346	java/io/FileOutputStream
    //   1688: dup
    //   1689: aload 26
    //   1691: iconst_1
    //   1692: invokespecial 349	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1695: astore 30
    //   1697: iload 6
    //   1699: istore 4
    //   1701: lload 12
    //   1703: lstore 10
    //   1705: aload 30
    //   1707: aload 29
    //   1709: iconst_0
    //   1710: iload 7
    //   1712: invokevirtual 354	java/io/OutputStream:write	([BII)V
    //   1715: iload 6
    //   1717: istore 4
    //   1719: lload 12
    //   1721: lstore 10
    //   1723: aload 30
    //   1725: invokevirtual 357	java/io/OutputStream:close	()V
    //   1728: iload 5
    //   1730: iload 7
    //   1732: iadd
    //   1733: istore 5
    //   1735: lload 12
    //   1737: iload 7
    //   1739: i2l
    //   1740: ladd
    //   1741: lstore 12
    //   1743: iload 6
    //   1745: istore 4
    //   1747: lload 12
    //   1749: lstore 10
    //   1751: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   1754: ldc2_w 326
    //   1757: ldiv
    //   1758: lstore 24
    //   1760: iload 6
    //   1762: istore 4
    //   1764: lload 12
    //   1766: lstore 10
    //   1768: ldc 133
    //   1770: iconst_2
    //   1771: new 56	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1778: ldc_w 359
    //   1781: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload 27
    //   1786: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1789: ldc_w 361
    //   1792: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: iload 5
    //   1797: i2f
    //   1798: lload 24
    //   1800: lload 22
    //   1802: lsub
    //   1803: l2f
    //   1804: fdiv
    //   1805: ldc_w 362
    //   1808: fdiv
    //   1809: invokevirtual 365	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1812: ldc_w 367
    //   1815: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1824: iload 6
    //   1826: istore 4
    //   1828: lload 12
    //   1830: lstore 10
    //   1832: aload_3
    //   1833: lload 16
    //   1835: iload 5
    //   1837: i2l
    //   1838: lload 18
    //   1840: ladd
    //   1841: lload 14
    //   1843: invokeinterface 370 7 0
    //   1848: goto -260 -> 1588
    //   1851: aload 26
    //   1853: invokevirtual 207	java/io/File:length	()J
    //   1856: lload 14
    //   1858: lcmp
    //   1859: ifne -1705 -> 154
    //   1862: aload_3
    //   1863: lload 16
    //   1865: iconst_1
    //   1866: lload 10
    //   1868: invokeinterface 200 6 0
    //   1873: return
    //   1874: astore_1
    //   1875: goto -414 -> 1461
    //   1878: astore_1
    //   1879: goto -645 -> 1234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1882	0	this	een
    //   0	1882	1	paramHttpRequest	org.apache.http.HttpRequest
    //   0	1882	2	paramHttpResponse	org.apache.http.HttpResponse
    //   0	1882	3	paramHttpContext	org.apache.http.protocol.HttpContext
    //   129	1698	4	i	int
    //   496	1340	5	j	int
    //   837	988	6	k	int
    //   848	890	7	m	int
    //   889	78	8	n	int
    //   900	68	9	i1	int
    //   469	1398	10	l1	long
    //   456	1373	12	l2	long
    //   258	1599	14	l3	long
    //   1059	805	16	l4	long
    //   1303	536	18	l5	long
    //   775	848	20	l6	long
    //   1568	233	22	l7	long
    //   1758	41	24	l8	long
    //   29	1823	26	localObject1	Object
    //   164	966	27	localObject2	Object
    //   1337	448	27	localException	java.lang.Exception
    //   204	1393	28	localObject3	Object
    //   1586	122	29	arrayOfByte	byte[]
    //   1695	29	30	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   318	352	362	java/lang/Exception
    //   352	361	362	java/lang/Exception
    //   419	437	362	java/lang/Exception
    //   437	454	362	java/lang/Exception
    //   458	467	362	java/lang/Exception
    //   475	498	362	java/lang/Exception
    //   527	544	362	java/lang/Exception
    //   548	563	362	java/lang/Exception
    //   563	599	362	java/lang/Exception
    //   599	700	701	java/lang/Exception
    //   1175	1183	1337	java/lang/Exception
    //   1191	1199	1337	java/lang/Exception
    //   1207	1216	1337	java/lang/Exception
    //   1279	1290	1337	java/lang/Exception
    //   1298	1305	1337	java/lang/Exception
    //   1321	1330	1337	java/lang/Exception
    //   1430	1439	1337	java/lang/Exception
    //   1471	1498	1337	java/lang/Exception
    //   1506	1516	1337	java/lang/Exception
    //   1527	1536	1337	java/lang/Exception
    //   1544	1553	1337	java/lang/Exception
    //   1561	1570	1337	java/lang/Exception
    //   1581	1588	1337	java/lang/Exception
    //   1596	1605	1337	java/lang/Exception
    //   1652	1658	1337	java/lang/Exception
    //   1666	1677	1337	java/lang/Exception
    //   1685	1697	1337	java/lang/Exception
    //   1705	1715	1337	java/lang/Exception
    //   1723	1728	1337	java/lang/Exception
    //   1751	1760	1337	java/lang/Exception
    //   1768	1824	1337	java/lang/Exception
    //   1832	1848	1337	java/lang/Exception
    //   1393	1407	1410	java/lang/Exception
    //   1175	1183	1446	finally
    //   1191	1199	1446	finally
    //   1207	1216	1446	finally
    //   1279	1290	1446	finally
    //   1298	1305	1446	finally
    //   1321	1330	1446	finally
    //   1339	1368	1446	finally
    //   1373	1384	1446	finally
    //   1384	1393	1446	finally
    //   1430	1439	1446	finally
    //   1471	1498	1446	finally
    //   1506	1516	1446	finally
    //   1527	1536	1446	finally
    //   1544	1553	1446	finally
    //   1561	1570	1446	finally
    //   1581	1588	1446	finally
    //   1596	1605	1446	finally
    //   1652	1658	1446	finally
    //   1666	1677	1446	finally
    //   1685	1697	1446	finally
    //   1705	1715	1446	finally
    //   1723	1728	1446	finally
    //   1751	1760	1446	finally
    //   1768	1824	1446	finally
    //   1832	1848	1446	finally
    //   1447	1461	1874	java/lang/Exception
    //   1220	1234	1878	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     een
 * JD-Core Version:    0.7.0.1
 */