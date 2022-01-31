import java.net.Socket;
import java.net.SocketException;
import org.apache.http.protocol.HttpRequestHandler;

public class gim
  implements HttpRequestHandler
{
  private static String b = "9u23fh$jkf^%43hj";
  private final String jdField_a_of_type_JavaLangString;
  private Socket jdField_a_of_type_JavaNetSocket;
  
  public gim(String paramString, Socket paramSocket)
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
    //   106: ifeq +599 -> 705
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
    //   195: getstatic 16	gim:b	Ljava/lang/String;
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
    //   255: invokestatic 176	gim:a	([BI)J
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
    //   320: invokestatic 182	git:a	(J)Ljava/lang/String;
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
    //   683: lload 14
    //   685: ldc_w 258
    //   688: aload_3
    //   689: invokespecial 261	com/tencent/mobileqq/service/DataLineHttpFileEntity:<init>	(Ljava/io/File;JJLjava/lang/String;Lcom/tencent/mobileqq/service/HttpNotify;)V
    //   692: invokeinterface 265 2 0
    //   697: return
    //   698: astore_1
    //   699: iconst_1
    //   700: istore 4
    //   702: goto -336 -> 366
    //   705: aload 26
    //   707: ldc 117
    //   709: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq -558 -> 154
    //   715: aload_1
    //   716: invokeinterface 90 1 0
    //   721: invokeinterface 125 1 0
    //   726: astore 27
    //   728: aload_1
    //   729: ldc 211
    //   731: invokeinterface 269 2 0
    //   736: iconst_0
    //   737: aaload
    //   738: invokeinterface 220 1 0
    //   743: astore 26
    //   745: aload 26
    //   747: aload 26
    //   749: bipush 61
    //   751: invokevirtual 272	java/lang/String:indexOf	(I)I
    //   754: iconst_1
    //   755: iadd
    //   756: aload 26
    //   758: bipush 45
    //   760: invokevirtual 272	java/lang/String:indexOf	(I)I
    //   763: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   766: invokestatic 275	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   769: invokevirtual 237	java/lang/Long:longValue	()J
    //   772: lstore 20
    //   774: aload 27
    //   776: ldc_w 277
    //   779: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   782: istore 4
    //   784: aload 27
    //   786: bipush 38
    //   788: iload 4
    //   790: invokevirtual 280	java/lang/String:indexOf	(II)I
    //   793: istore 5
    //   795: iload 4
    //   797: iconst_m1
    //   798: if_icmpeq +9 -> 807
    //   801: iload 5
    //   803: iconst_m1
    //   804: if_icmpne +22 -> 826
    //   807: ldc 133
    //   809: iconst_1
    //   810: ldc_w 282
    //   813: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   816: aload_2
    //   817: sipush 400
    //   820: invokeinterface 146 2 0
    //   825: return
    //   826: aload 27
    //   828: ldc_w 284
    //   831: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   834: istore 6
    //   836: aload 27
    //   838: bipush 38
    //   840: iload 6
    //   842: invokevirtual 280	java/lang/String:indexOf	(II)I
    //   845: istore 7
    //   847: iload 6
    //   849: iconst_m1
    //   850: if_icmpeq +9 -> 859
    //   853: iload 7
    //   855: iconst_m1
    //   856: if_icmpne +22 -> 878
    //   859: ldc 133
    //   861: iconst_1
    //   862: ldc_w 286
    //   865: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: aload_2
    //   869: sipush 400
    //   872: invokeinterface 146 2 0
    //   877: return
    //   878: aload 27
    //   880: ldc_w 288
    //   883: invokevirtual 131	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   886: istore 8
    //   888: aload 27
    //   890: bipush 38
    //   892: iload 8
    //   894: invokevirtual 280	java/lang/String:indexOf	(II)I
    //   897: istore 9
    //   899: iload 8
    //   901: iconst_m1
    //   902: if_icmpeq +9 -> 911
    //   905: iload 9
    //   907: iconst_m1
    //   908: if_icmpne +22 -> 930
    //   911: ldc 133
    //   913: iconst_1
    //   914: ldc_w 290
    //   917: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: aload_2
    //   921: sipush 400
    //   924: invokeinterface 146 2 0
    //   929: return
    //   930: aload 27
    //   932: iload 4
    //   934: iconst_5
    //   935: iadd
    //   936: iload 5
    //   938: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   941: astore 28
    //   943: aload 27
    //   945: iload 6
    //   947: bipush 8
    //   949: iadd
    //   950: iload 7
    //   952: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   955: astore 26
    //   957: aload 27
    //   959: iload 8
    //   961: bipush 9
    //   963: iadd
    //   964: iload 9
    //   966: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   969: invokestatic 275	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   972: invokevirtual 237	java/lang/Long:longValue	()J
    //   975: lstore 14
    //   977: aload 28
    //   979: invokestatic 295	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   982: astore 27
    //   984: new 160	com/tencent/qphone/base/util/Cryptor
    //   987: dup
    //   988: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   991: aload 27
    //   993: getstatic 16	gim:b	Ljava/lang/String;
    //   996: invokevirtual 165	java/lang/String:getBytes	()[B
    //   999: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   1002: astore 28
    //   1004: aload 28
    //   1006: ifnull +11 -> 1017
    //   1009: aload 28
    //   1011: arraylength
    //   1012: bipush 28
    //   1014: if_icmpge +21 -> 1035
    //   1017: ldc 133
    //   1019: iconst_1
    //   1020: ldc 171
    //   1022: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: aload_2
    //   1026: sipush 400
    //   1029: invokeinterface 146 2 0
    //   1034: return
    //   1035: new 103	java/lang/String
    //   1038: dup
    //   1039: aload 28
    //   1041: iconst_0
    //   1042: bipush 16
    //   1044: invokespecial 174	java/lang/String:<init>	([BII)V
    //   1047: astore 27
    //   1049: aload 28
    //   1051: bipush 20
    //   1053: invokestatic 176	gim:a	([BI)J
    //   1056: lstore 16
    //   1058: aload 26
    //   1060: invokestatic 295	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   1063: astore 26
    //   1065: new 160	com/tencent/qphone/base/util/Cryptor
    //   1068: dup
    //   1069: invokespecial 161	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   1072: aload 26
    //   1074: aload 27
    //   1076: invokevirtual 165	java/lang/String:getBytes	()[B
    //   1079: invokevirtual 169	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   1082: astore 26
    //   1084: aload 26
    //   1086: ifnull +11 -> 1097
    //   1089: aload 26
    //   1091: arraylength
    //   1092: bipush 16
    //   1094: if_icmpge +21 -> 1115
    //   1097: ldc 133
    //   1099: iconst_1
    //   1100: ldc 178
    //   1102: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1105: aload_2
    //   1106: sipush 400
    //   1109: invokeinterface 146 2 0
    //   1114: return
    //   1115: lload 16
    //   1117: invokestatic 182	git:a	(J)Ljava/lang/String;
    //   1120: astore 27
    //   1122: new 184	java/io/File
    //   1125: dup
    //   1126: aload 27
    //   1128: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;)V
    //   1131: astore 26
    //   1133: aload 26
    //   1135: invokevirtual 203	java/io/File:exists	()Z
    //   1138: ifne +9 -> 1147
    //   1141: aload 26
    //   1143: invokevirtual 298	java/io/File:createNewFile	()Z
    //   1146: pop
    //   1147: iconst_0
    //   1148: istore 5
    //   1150: lconst_0
    //   1151: lstore 12
    //   1153: lload 12
    //   1155: lstore 10
    //   1157: aload_1
    //   1158: instanceof 300
    //   1161: ifeq +70 -> 1231
    //   1164: iload 5
    //   1166: istore 4
    //   1168: lload 12
    //   1170: lstore 10
    //   1172: aload 26
    //   1174: invokevirtual 189	java/io/File:canRead	()Z
    //   1177: ifeq +19 -> 1196
    //   1180: iload 5
    //   1182: istore 4
    //   1184: lload 12
    //   1186: lstore 10
    //   1188: aload 26
    //   1190: invokevirtual 192	java/io/File:isDirectory	()Z
    //   1193: ifeq +75 -> 1268
    //   1196: iload 5
    //   1198: istore 4
    //   1200: lload 12
    //   1202: lstore 10
    //   1204: aload_2
    //   1205: sipush 403
    //   1208: invokeinterface 146 2 0
    //   1213: lload 12
    //   1215: lstore 10
    //   1217: aload_1
    //   1218: checkcast 300	org/apache/http/HttpEntityEnclosingRequest
    //   1221: invokeinterface 304 1 0
    //   1226: invokeinterface 309 1 0
    //   1231: aload_2
    //   1232: ldc 211
    //   1234: aload 26
    //   1236: invokevirtual 207	java/io/File:length	()J
    //   1239: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1242: invokeinterface 254 3 0
    //   1247: aload 26
    //   1249: invokevirtual 207	java/io/File:length	()J
    //   1252: lload 14
    //   1254: lcmp
    //   1255: ifle +593 -> 1848
    //   1258: aload_2
    //   1259: sipush 403
    //   1262: invokeinterface 146 2 0
    //   1267: return
    //   1268: iload 5
    //   1270: istore 4
    //   1272: lload 12
    //   1274: lstore 10
    //   1276: aload_1
    //   1277: checkcast 300	org/apache/http/HttpEntityEnclosingRequest
    //   1280: invokeinterface 304 1 0
    //   1285: astore 28
    //   1287: iload 5
    //   1289: istore 4
    //   1291: lload 12
    //   1293: lstore 10
    //   1295: aload 26
    //   1297: invokevirtual 207	java/io/File:length	()J
    //   1300: lstore 18
    //   1302: lload 20
    //   1304: lload 18
    //   1306: lcmp
    //   1307: ifge +104 -> 1411
    //   1310: iload 5
    //   1312: istore 4
    //   1314: lload 12
    //   1316: lstore 10
    //   1318: aload_2
    //   1319: sipush 206
    //   1322: invokeinterface 146 2 0
    //   1327: lload 12
    //   1329: lstore 10
    //   1331: goto -114 -> 1217
    //   1334: astore 27
    //   1336: ldc 133
    //   1338: iconst_1
    //   1339: new 56	java/lang/StringBuilder
    //   1342: dup
    //   1343: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1346: ldc 194
    //   1348: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: aload 27
    //   1353: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1356: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: iload 4
    //   1367: ifeq +14 -> 1381
    //   1370: aload_3
    //   1371: lload 16
    //   1373: iconst_0
    //   1374: lload 10
    //   1376: invokeinterface 200 6 0
    //   1381: aload_2
    //   1382: sipush 404
    //   1385: invokeinterface 146 2 0
    //   1390: aload_1
    //   1391: checkcast 300	org/apache/http/HttpEntityEnclosingRequest
    //   1394: invokeinterface 304 1 0
    //   1399: invokeinterface 309 1 0
    //   1404: goto -173 -> 1231
    //   1407: astore_1
    //   1408: goto -177 -> 1231
    //   1411: lload 20
    //   1413: lload 18
    //   1415: lcmp
    //   1416: ifle +44 -> 1460
    //   1419: iload 5
    //   1421: istore 4
    //   1423: lload 12
    //   1425: lstore 10
    //   1427: aload_2
    //   1428: sipush 403
    //   1431: invokeinterface 146 2 0
    //   1436: lload 12
    //   1438: lstore 10
    //   1440: goto -223 -> 1217
    //   1443: astore_2
    //   1444: aload_1
    //   1445: checkcast 300	org/apache/http/HttpEntityEnclosingRequest
    //   1448: invokeinterface 304 1 0
    //   1453: invokeinterface 309 1 0
    //   1458: aload_2
    //   1459: athrow
    //   1460: iload 5
    //   1462: istore 4
    //   1464: lload 12
    //   1466: lstore 10
    //   1468: ldc 133
    //   1470: iconst_2
    //   1471: new 56	java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1478: ldc_w 311
    //   1481: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload 27
    //   1486: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1495: iload 5
    //   1497: istore 4
    //   1499: lload 12
    //   1501: lstore 10
    //   1503: aload_3
    //   1504: lload 16
    //   1506: lload 18
    //   1508: invokeinterface 242 5 0
    //   1513: iconst_1
    //   1514: istore 6
    //   1516: iload 6
    //   1518: istore 4
    //   1520: lload 12
    //   1522: lstore 10
    //   1524: aload 28
    //   1526: invokeinterface 314 1 0
    //   1531: lstore 20
    //   1533: iload 6
    //   1535: istore 4
    //   1537: lload 12
    //   1539: lstore 10
    //   1541: aload 28
    //   1543: invokeinterface 318 1 0
    //   1548: astore 28
    //   1550: iload 6
    //   1552: istore 4
    //   1554: lload 12
    //   1556: lstore 10
    //   1558: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1561: ldc2_w 324
    //   1564: ldiv
    //   1565: lstore 22
    //   1567: iconst_0
    //   1568: istore 5
    //   1570: iload 6
    //   1572: istore 4
    //   1574: lload 12
    //   1576: lstore 10
    //   1578: ldc_w 326
    //   1581: newarray byte
    //   1583: astore 29
    //   1585: iload 6
    //   1587: istore 4
    //   1589: lload 12
    //   1591: lstore 10
    //   1593: aload 28
    //   1595: aload 29
    //   1597: invokevirtual 332	java/io/InputStream:read	([B)I
    //   1600: istore 7
    //   1602: lload 12
    //   1604: lstore 10
    //   1606: iload 7
    //   1608: iconst_m1
    //   1609: if_icmpeq -392 -> 1217
    //   1612: lload 12
    //   1614: lstore 10
    //   1616: iload 5
    //   1618: i2l
    //   1619: lload 20
    //   1621: lcmp
    //   1622: ifgt -405 -> 1217
    //   1625: lload 12
    //   1627: lstore 10
    //   1629: iload 5
    //   1631: i2l
    //   1632: lload 18
    //   1634: ladd
    //   1635: lload 14
    //   1637: lcmp
    //   1638: ifgt -421 -> 1217
    //   1641: iload 6
    //   1643: istore 4
    //   1645: lload 12
    //   1647: lstore 10
    //   1649: invokestatic 337	java/lang/Thread:interrupted	()Z
    //   1652: ifeq +22 -> 1674
    //   1655: iload 6
    //   1657: istore 4
    //   1659: lload 12
    //   1661: lstore 10
    //   1663: new 339	java/lang/InterruptedException
    //   1666: dup
    //   1667: ldc_w 341
    //   1670: invokespecial 342	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   1673: athrow
    //   1674: iload 6
    //   1676: istore 4
    //   1678: lload 12
    //   1680: lstore 10
    //   1682: new 344	java/io/FileOutputStream
    //   1685: dup
    //   1686: aload 26
    //   1688: iconst_1
    //   1689: invokespecial 347	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1692: astore 30
    //   1694: iload 6
    //   1696: istore 4
    //   1698: lload 12
    //   1700: lstore 10
    //   1702: aload 30
    //   1704: aload 29
    //   1706: iconst_0
    //   1707: iload 7
    //   1709: invokevirtual 352	java/io/OutputStream:write	([BII)V
    //   1712: iload 6
    //   1714: istore 4
    //   1716: lload 12
    //   1718: lstore 10
    //   1720: aload 30
    //   1722: invokevirtual 355	java/io/OutputStream:close	()V
    //   1725: iload 5
    //   1727: iload 7
    //   1729: iadd
    //   1730: istore 5
    //   1732: lload 12
    //   1734: iload 7
    //   1736: i2l
    //   1737: ladd
    //   1738: lstore 12
    //   1740: iload 6
    //   1742: istore 4
    //   1744: lload 12
    //   1746: lstore 10
    //   1748: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1751: ldc2_w 324
    //   1754: ldiv
    //   1755: lstore 24
    //   1757: iload 6
    //   1759: istore 4
    //   1761: lload 12
    //   1763: lstore 10
    //   1765: ldc 133
    //   1767: iconst_2
    //   1768: new 56	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1775: ldc_w 357
    //   1778: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: aload 27
    //   1783: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1786: ldc_w 359
    //   1789: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: iload 5
    //   1794: i2f
    //   1795: lload 24
    //   1797: lload 22
    //   1799: lsub
    //   1800: l2f
    //   1801: fdiv
    //   1802: ldc_w 360
    //   1805: fdiv
    //   1806: invokevirtual 363	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1809: ldc_w 365
    //   1812: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1818: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1821: iload 6
    //   1823: istore 4
    //   1825: lload 12
    //   1827: lstore 10
    //   1829: aload_3
    //   1830: lload 16
    //   1832: iload 5
    //   1834: i2l
    //   1835: lload 18
    //   1837: ladd
    //   1838: lload 14
    //   1840: invokeinterface 368 7 0
    //   1845: goto -260 -> 1585
    //   1848: aload 26
    //   1850: invokevirtual 207	java/io/File:length	()J
    //   1853: lload 14
    //   1855: lcmp
    //   1856: ifne -1702 -> 154
    //   1859: aload_3
    //   1860: lload 16
    //   1862: iconst_1
    //   1863: lload 10
    //   1865: invokeinterface 200 6 0
    //   1870: return
    //   1871: astore_1
    //   1872: goto -414 -> 1458
    //   1875: astore_1
    //   1876: goto -645 -> 1231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1879	0	this	gim
    //   0	1879	1	paramHttpRequest	org.apache.http.HttpRequest
    //   0	1879	2	paramHttpResponse	org.apache.http.HttpResponse
    //   0	1879	3	paramHttpContext	org.apache.http.protocol.HttpContext
    //   129	1695	4	i	int
    //   496	1337	5	j	int
    //   834	988	6	k	int
    //   845	890	7	m	int
    //   886	78	8	n	int
    //   897	68	9	i1	int
    //   469	1395	10	l1	long
    //   456	1370	12	l2	long
    //   258	1596	14	l3	long
    //   1056	805	16	l4	long
    //   1300	536	18	l5	long
    //   772	848	20	l6	long
    //   1565	233	22	l7	long
    //   1755	41	24	l8	long
    //   29	1820	26	localObject1	Object
    //   164	963	27	localObject2	Object
    //   1334	448	27	localException	java.lang.Exception
    //   204	1390	28	localObject3	Object
    //   1583	122	29	arrayOfByte	byte[]
    //   1692	29	30	localFileOutputStream	java.io.FileOutputStream
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
    //   599	697	698	java/lang/Exception
    //   1172	1180	1334	java/lang/Exception
    //   1188	1196	1334	java/lang/Exception
    //   1204	1213	1334	java/lang/Exception
    //   1276	1287	1334	java/lang/Exception
    //   1295	1302	1334	java/lang/Exception
    //   1318	1327	1334	java/lang/Exception
    //   1427	1436	1334	java/lang/Exception
    //   1468	1495	1334	java/lang/Exception
    //   1503	1513	1334	java/lang/Exception
    //   1524	1533	1334	java/lang/Exception
    //   1541	1550	1334	java/lang/Exception
    //   1558	1567	1334	java/lang/Exception
    //   1578	1585	1334	java/lang/Exception
    //   1593	1602	1334	java/lang/Exception
    //   1649	1655	1334	java/lang/Exception
    //   1663	1674	1334	java/lang/Exception
    //   1682	1694	1334	java/lang/Exception
    //   1702	1712	1334	java/lang/Exception
    //   1720	1725	1334	java/lang/Exception
    //   1748	1757	1334	java/lang/Exception
    //   1765	1821	1334	java/lang/Exception
    //   1829	1845	1334	java/lang/Exception
    //   1390	1404	1407	java/lang/Exception
    //   1172	1180	1443	finally
    //   1188	1196	1443	finally
    //   1204	1213	1443	finally
    //   1276	1287	1443	finally
    //   1295	1302	1443	finally
    //   1318	1327	1443	finally
    //   1336	1365	1443	finally
    //   1370	1381	1443	finally
    //   1381	1390	1443	finally
    //   1427	1436	1443	finally
    //   1468	1495	1443	finally
    //   1503	1513	1443	finally
    //   1524	1533	1443	finally
    //   1541	1550	1443	finally
    //   1558	1567	1443	finally
    //   1578	1585	1443	finally
    //   1593	1602	1443	finally
    //   1649	1655	1443	finally
    //   1663	1674	1443	finally
    //   1682	1694	1443	finally
    //   1702	1712	1443	finally
    //   1720	1725	1443	finally
    //   1748	1757	1443	finally
    //   1765	1821	1443	finally
    //   1829	1845	1443	finally
    //   1444	1458	1871	java/lang/Exception
    //   1217	1231	1875	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gim
 * JD-Core Version:    0.7.0.1
 */