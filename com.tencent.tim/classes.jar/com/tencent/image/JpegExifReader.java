package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class JpegExifReader
{
  private static final String BIG_ENDIAN_BYTE_ORDER = "MM";
  private static final byte[] BYTES_PER_FORMAT = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private static final int DIRECTORY_LENGTH = 12;
  private static final byte E0 = -32;
  private static final byte E1 = -31;
  private static final byte E15 = -17;
  private static final String EXIF = "EXIF";
  private static final int EXPOSURE_TIME_TAG = 33434;
  private static final byte FF = -1;
  private static final String LITTLE_ENDIAN_BYTE_ORDER = "II";
  private static final int ORIENTATION_TAG = 274;
  private static final String REPORT_ACTION = "actReadJpegOrientation";
  private static final byte SEGMENTS_END = -38;
  private static final int SUB_IFD_OFFSET_TAG = 34665;
  private static final String TAG = "JpegExifReader";
  private static final int TIFF_HEADER_OFFSET = 6;
  public static JpegExifReaderInterface jpegExifReaderInterface;
  private static boolean sIsEnable = true;
  private static boolean sIsReadDpc = false;
  
  private static short getInt16(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return (short)(paramArrayOfByte[0] & 0xFF00 | paramArrayOfByte[1] & 0xFF);
    }
    return (short)(paramArrayOfByte[1] & 0xFF00 | paramArrayOfByte[0] & 0xFF);
  }
  
  private static int getInt32(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  public static int getRotationDegree(String paramString)
  {
    switch (readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private static int getUnsignedInt16(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 8 & 0xFF00 | paramArrayOfByte[1] & 0xFF;
    }
    return paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getUnsignedInt32(boolean paramBoolean, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramBoolean) {
      return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] & 0xFF;
    }
    return paramArrayOfByte[3] << 24 & 0xFF000000 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[0] & 0xFF;
  }
  
  private static long getValue(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
    throws Exception
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("JpegExifReader", 2, "get value format code: " + paramInt);
      }
      return 0L;
    case 3: 
      return getUnsignedInt16(paramBoolean, paramArrayOfByte);
    case 4: 
      return getUnsignedInt32(paramBoolean, paramArrayOfByte);
    case 6: 
      return paramArrayOfByte[0];
    case 8: 
      return getInt16(paramBoolean, paramArrayOfByte);
    }
    return getInt32(paramBoolean, paramArrayOfByte);
  }
  
  public static void initJpegExifReader(JpegExifReaderInterface paramJpegExifReaderInterface)
  {
    jpegExifReaderInterface = paramJpegExifReaderInterface;
  }
  
  /* Error */
  public static boolean isCrashJpeg(String paramString)
  {
    // Byte code:
    //   0: getstatic 145	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 24
    //   5: if_icmplt +9 -> 14
    //   8: iconst_0
    //   9: istore 8
    //   11: iload 8
    //   13: ireturn
    //   14: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore 10
    //   19: iconst_0
    //   20: istore 9
    //   22: iconst_0
    //   23: istore 8
    //   25: aconst_null
    //   26: astore 14
    //   28: iconst_0
    //   29: istore_3
    //   30: new 153	java/io/BufferedInputStream
    //   33: dup
    //   34: new 155	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: sipush 1024
    //   45: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   48: astore 15
    //   50: iconst_0
    //   51: istore_2
    //   52: iload_3
    //   53: istore_1
    //   54: iconst_2
    //   55: newarray byte
    //   57: astore 14
    //   59: iload_3
    //   60: istore_1
    //   61: aload 15
    //   63: aload 14
    //   65: iconst_0
    //   66: iconst_2
    //   67: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   70: iconst_2
    //   71: if_icmpne +33 -> 104
    //   74: aload 14
    //   76: iconst_0
    //   77: baload
    //   78: sipush 255
    //   81: iand
    //   82: sipush 255
    //   85: if_icmpne +198 -> 283
    //   88: aload 14
    //   90: iconst_1
    //   91: baload
    //   92: sipush 255
    //   95: iand
    //   96: sipush 216
    //   99: if_icmpne +184 -> 283
    //   102: iconst_1
    //   103: istore_2
    //   104: iconst_2
    //   105: istore 4
    //   107: iload 4
    //   109: istore_3
    //   110: iload_2
    //   111: ifeq +1464 -> 1575
    //   114: iload 4
    //   116: istore_1
    //   117: iconst_4
    //   118: newarray byte
    //   120: astore 16
    //   122: iload 4
    //   124: istore_1
    //   125: aload 15
    //   127: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   130: sipush 255
    //   133: iand
    //   134: i2b
    //   135: istore_3
    //   136: iload 4
    //   138: iconst_1
    //   139: iadd
    //   140: istore_2
    //   141: iload_2
    //   142: istore_1
    //   143: aload 15
    //   145: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   148: sipush 255
    //   151: iand
    //   152: i2b
    //   153: istore 4
    //   155: iload 4
    //   157: bipush 218
    //   159: if_icmpne +129 -> 288
    //   162: ldc 170
    //   164: astore 14
    //   166: iload_2
    //   167: istore_1
    //   168: aload 14
    //   170: astore 16
    //   172: iload_1
    //   173: istore_2
    //   174: iload 8
    //   176: istore 7
    //   178: aload 15
    //   180: ifnull +18 -> 198
    //   183: aload 15
    //   185: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   188: iload 8
    //   190: istore 7
    //   192: iload_1
    //   193: istore_2
    //   194: aload 14
    //   196: astore 16
    //   198: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   201: lstore 12
    //   203: iload 7
    //   205: istore 8
    //   207: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -199 -> 11
    //   213: ldc 44
    //   215: iconst_2
    //   216: new 104	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   223: ldc 175
    //   225: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iload 7
    //   230: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   233: ldc 180
    //   235: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload_2
    //   239: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 182
    //   244: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload 12
    //   249: lload 10
    //   251: lsub
    //   252: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc 187
    //   257: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_0
    //   261: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 189
    //   266: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 16
    //   271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iload 7
    //   282: ireturn
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -181 -> 104
    //   288: iload_2
    //   289: iconst_1
    //   290: iadd
    //   291: istore_2
    //   292: iload_2
    //   293: istore_1
    //   294: aload 15
    //   296: aload 14
    //   298: iconst_0
    //   299: iconst_2
    //   300: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   303: iconst_2
    //   304: if_icmpeq +12 -> 316
    //   307: ldc 194
    //   309: astore 14
    //   311: iload_2
    //   312: istore_1
    //   313: goto -145 -> 168
    //   316: iload_2
    //   317: iconst_2
    //   318: iadd
    //   319: istore_2
    //   320: aload 14
    //   322: iconst_0
    //   323: baload
    //   324: bipush 8
    //   326: ishl
    //   327: ldc 71
    //   329: iand
    //   330: aload 14
    //   332: iconst_1
    //   333: baload
    //   334: sipush 255
    //   337: iand
    //   338: ior
    //   339: iconst_2
    //   340: isub
    //   341: istore 5
    //   343: iload_3
    //   344: iconst_m1
    //   345: if_icmpne +1250 -> 1595
    //   348: iload 4
    //   350: bipush 224
    //   352: if_icmpne +1243 -> 1595
    //   355: iload_2
    //   356: istore_1
    //   357: aload 15
    //   359: iload 5
    //   361: i2l
    //   362: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   365: iload 5
    //   367: i2l
    //   368: lcmp
    //   369: ifne +1216 -> 1585
    //   372: iload_2
    //   373: iload 5
    //   375: iadd
    //   376: istore 4
    //   378: goto -256 -> 122
    //   381: iload_2
    //   382: istore_1
    //   383: aload 15
    //   385: aload 16
    //   387: iconst_0
    //   388: iconst_4
    //   389: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   392: iconst_4
    //   393: if_icmpeq +12 -> 405
    //   396: ldc 200
    //   398: astore 14
    //   400: iload_2
    //   401: istore_1
    //   402: goto -234 -> 168
    //   405: iload_2
    //   406: iconst_4
    //   407: iadd
    //   408: istore_2
    //   409: iload_2
    //   410: istore_1
    //   411: ldc 25
    //   413: new 202	java/lang/String
    //   416: dup
    //   417: aload 16
    //   419: invokespecial 205	java/lang/String:<init>	([B)V
    //   422: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   425: ifne +12 -> 437
    //   428: ldc 210
    //   430: astore 14
    //   432: iload_2
    //   433: istore_1
    //   434: goto -266 -> 168
    //   437: iload_2
    //   438: istore_1
    //   439: aload 15
    //   441: ldc2_w 211
    //   444: invokevirtual 215	java/io/BufferedInputStream:skip	(J)J
    //   447: ldc2_w 211
    //   450: lcmp
    //   451: ifeq +12 -> 463
    //   454: ldc 217
    //   456: astore 14
    //   458: iload_2
    //   459: istore_1
    //   460: goto -292 -> 168
    //   463: iload_2
    //   464: iconst_2
    //   465: iadd
    //   466: istore_3
    //   467: iload_3
    //   468: istore_1
    //   469: aload 15
    //   471: aload 14
    //   473: iconst_0
    //   474: iconst_2
    //   475: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   478: iconst_2
    //   479: if_icmpeq +12 -> 491
    //   482: ldc 219
    //   484: astore 14
    //   486: iload_3
    //   487: istore_1
    //   488: goto -320 -> 168
    //   491: iload_3
    //   492: iconst_2
    //   493: iadd
    //   494: istore_2
    //   495: iload_2
    //   496: istore_1
    //   497: new 202	java/lang/String
    //   500: dup
    //   501: aload 14
    //   503: invokespecial 205	java/lang/String:<init>	([B)V
    //   506: astore 17
    //   508: iload_2
    //   509: istore_1
    //   510: ldc 11
    //   512: aload 17
    //   514: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   517: ifeq +32 -> 549
    //   520: iconst_1
    //   521: istore 7
    //   523: iload_2
    //   524: istore_1
    //   525: aload 15
    //   527: ldc2_w 211
    //   530: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   533: ldc2_w 211
    //   536: lcmp
    //   537: ifeq +64 -> 601
    //   540: ldc 221
    //   542: astore 14
    //   544: iload_2
    //   545: istore_1
    //   546: goto -378 -> 168
    //   549: iload_2
    //   550: istore_1
    //   551: ldc 32
    //   553: aload 17
    //   555: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   558: ifeq +9 -> 567
    //   561: iconst_0
    //   562: istore 7
    //   564: goto -41 -> 523
    //   567: iload_2
    //   568: istore_1
    //   569: new 104	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   576: ldc 223
    //   578: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 17
    //   583: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc 225
    //   588: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: astore 14
    //   596: iload_2
    //   597: istore_1
    //   598: goto -430 -> 168
    //   601: iload_2
    //   602: istore_1
    //   603: aload 15
    //   605: aload 16
    //   607: iconst_0
    //   608: iconst_4
    //   609: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   612: iconst_4
    //   613: if_icmpeq +12 -> 625
    //   616: ldc 227
    //   618: astore 14
    //   620: iload_2
    //   621: istore_1
    //   622: goto -454 -> 168
    //   625: iload_2
    //   626: bipush 6
    //   628: iadd
    //   629: istore_2
    //   630: iload_2
    //   631: istore_1
    //   632: iload 7
    //   634: aload 16
    //   636: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   639: bipush 8
    //   641: isub
    //   642: istore 4
    //   644: iload 4
    //   646: ifle +29 -> 675
    //   649: iload_2
    //   650: istore_1
    //   651: aload 15
    //   653: iload 4
    //   655: i2l
    //   656: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   659: iload 4
    //   661: i2l
    //   662: lcmp
    //   663: ifeq +12 -> 675
    //   666: ldc 229
    //   668: astore 14
    //   670: iload_2
    //   671: istore_1
    //   672: goto -504 -> 168
    //   675: iload_2
    //   676: istore_1
    //   677: aload 15
    //   679: aload 14
    //   681: iconst_0
    //   682: iconst_2
    //   683: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   686: iconst_2
    //   687: if_icmpeq +12 -> 699
    //   690: ldc 231
    //   692: astore 14
    //   694: iload_2
    //   695: istore_1
    //   696: goto -528 -> 168
    //   699: iload_2
    //   700: iload 4
    //   702: iconst_2
    //   703: iadd
    //   704: iadd
    //   705: istore_2
    //   706: iload_2
    //   707: istore_1
    //   708: iload 7
    //   710: aload 14
    //   712: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   715: istore 5
    //   717: iconst_0
    //   718: istore 4
    //   720: iload 4
    //   722: iload 5
    //   724: if_icmpge +583 -> 1307
    //   727: iload_2
    //   728: istore_1
    //   729: aload 15
    //   731: aload 14
    //   733: iconst_0
    //   734: iconst_2
    //   735: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   738: iconst_2
    //   739: if_icmpeq +12 -> 751
    //   742: ldc 233
    //   744: astore 14
    //   746: iload_2
    //   747: istore_1
    //   748: goto -580 -> 168
    //   751: iload_2
    //   752: iconst_2
    //   753: iadd
    //   754: istore_2
    //   755: iload_2
    //   756: istore_1
    //   757: iload 7
    //   759: aload 14
    //   761: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   764: ldc 41
    //   766: if_icmpne +514 -> 1280
    //   769: iload_2
    //   770: istore_1
    //   771: aload 15
    //   773: aload 14
    //   775: iconst_0
    //   776: iconst_2
    //   777: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   780: iconst_2
    //   781: if_icmpeq +12 -> 793
    //   784: ldc 235
    //   786: astore 14
    //   788: iload_2
    //   789: istore_1
    //   790: goto -622 -> 168
    //   793: iload_2
    //   794: iconst_2
    //   795: iadd
    //   796: istore_2
    //   797: iload_2
    //   798: istore_1
    //   799: iload 7
    //   801: aload 14
    //   803: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   806: istore 4
    //   808: iload_2
    //   809: istore_1
    //   810: aload 15
    //   812: aload 16
    //   814: iconst_0
    //   815: iconst_4
    //   816: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   819: iconst_4
    //   820: if_icmpeq +12 -> 832
    //   823: ldc 237
    //   825: astore 14
    //   827: iload_2
    //   828: istore_1
    //   829: goto -661 -> 168
    //   832: iload_2
    //   833: iconst_4
    //   834: iadd
    //   835: istore_2
    //   836: iload_2
    //   837: istore_1
    //   838: iload 7
    //   840: aload 16
    //   842: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   845: pop
    //   846: iload_2
    //   847: istore_1
    //   848: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   851: iload 4
    //   853: baload
    //   854: istore 5
    //   856: iload_2
    //   857: istore_1
    //   858: aload 15
    //   860: aload 16
    //   862: iconst_0
    //   863: iconst_4
    //   864: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   867: iconst_4
    //   868: if_icmpeq +12 -> 880
    //   871: ldc 239
    //   873: astore 14
    //   875: iload_2
    //   876: istore_1
    //   877: goto -709 -> 168
    //   880: iload_2
    //   881: iconst_4
    //   882: iadd
    //   883: istore_2
    //   884: iload_2
    //   885: istore_1
    //   886: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +31 -> 920
    //   892: iload_2
    //   893: istore_1
    //   894: ldc 44
    //   896: iconst_2
    //   897: new 104	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   904: ldc 241
    //   906: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: iload 4
    //   911: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   914: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: iload_2
    //   921: istore_1
    //   922: iload 4
    //   924: iload 7
    //   926: aload 16
    //   928: invokestatic 243	com/tencent/image/JpegExifReader:getValue	(IZ[B)J
    //   931: iload_3
    //   932: i2l
    //   933: ladd
    //   934: iload_2
    //   935: i2l
    //   936: lsub
    //   937: lstore 12
    //   939: iload_2
    //   940: istore_1
    //   941: aload 15
    //   943: lload 12
    //   945: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   948: lload 12
    //   950: lcmp
    //   951: ifeq +12 -> 963
    //   954: ldc 245
    //   956: astore 14
    //   958: iload_2
    //   959: istore_1
    //   960: goto -792 -> 168
    //   963: iload_2
    //   964: istore_1
    //   965: aload 15
    //   967: aload 14
    //   969: iconst_0
    //   970: iconst_2
    //   971: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   974: iconst_2
    //   975: if_icmpeq +12 -> 987
    //   978: ldc 247
    //   980: astore 14
    //   982: iload_2
    //   983: istore_1
    //   984: goto -816 -> 168
    //   987: iload_2
    //   988: iconst_2
    //   989: iadd
    //   990: istore_2
    //   991: iload_2
    //   992: istore_1
    //   993: iload 7
    //   995: aload 14
    //   997: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1000: istore 4
    //   1002: iconst_0
    //   1003: istore_3
    //   1004: iload_3
    //   1005: iload 4
    //   1007: if_icmpge +242 -> 1249
    //   1010: iload_2
    //   1011: istore_1
    //   1012: aload 15
    //   1014: aload 14
    //   1016: iconst_0
    //   1017: iconst_2
    //   1018: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1021: iconst_2
    //   1022: if_icmpeq +12 -> 1034
    //   1025: ldc 249
    //   1027: astore 14
    //   1029: iload_2
    //   1030: istore_1
    //   1031: goto -863 -> 168
    //   1034: iload_2
    //   1035: iconst_2
    //   1036: iadd
    //   1037: istore_2
    //   1038: iload_2
    //   1039: istore_1
    //   1040: iload 7
    //   1042: aload 14
    //   1044: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1047: ldc 27
    //   1049: if_icmpne +173 -> 1222
    //   1052: iload_2
    //   1053: istore_1
    //   1054: aload 15
    //   1056: aload 14
    //   1058: iconst_0
    //   1059: iconst_2
    //   1060: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1063: iconst_2
    //   1064: if_icmpeq +12 -> 1076
    //   1067: ldc 251
    //   1069: astore 14
    //   1071: iload_2
    //   1072: istore_1
    //   1073: goto -905 -> 168
    //   1076: iload_2
    //   1077: iconst_2
    //   1078: iadd
    //   1079: istore_2
    //   1080: iload_2
    //   1081: istore_1
    //   1082: iload 7
    //   1084: aload 14
    //   1086: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1089: istore 5
    //   1091: iload_2
    //   1092: istore_1
    //   1093: aload 15
    //   1095: aload 16
    //   1097: iconst_0
    //   1098: iconst_4
    //   1099: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1102: iconst_4
    //   1103: if_icmpeq +12 -> 1115
    //   1106: ldc 253
    //   1108: astore 14
    //   1110: iload_2
    //   1111: istore_1
    //   1112: goto -944 -> 168
    //   1115: iload_2
    //   1116: iconst_4
    //   1117: iadd
    //   1118: istore_2
    //   1119: iload_2
    //   1120: istore_1
    //   1121: iload 7
    //   1123: aload 16
    //   1125: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1128: pop
    //   1129: iload_2
    //   1130: istore_1
    //   1131: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1134: iload 5
    //   1136: baload
    //   1137: istore 6
    //   1139: iload_2
    //   1140: istore_1
    //   1141: aload 15
    //   1143: aload 16
    //   1145: iconst_0
    //   1146: iconst_4
    //   1147: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1150: iconst_4
    //   1151: if_icmpeq +12 -> 1163
    //   1154: ldc 255
    //   1156: astore 14
    //   1158: iload_2
    //   1159: istore_1
    //   1160: goto -992 -> 168
    //   1163: iload_2
    //   1164: iconst_4
    //   1165: iadd
    //   1166: istore_2
    //   1167: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +30 -> 1200
    //   1173: ldc 44
    //   1175: iconst_2
    //   1176: new 104	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1183: ldc_w 257
    //   1186: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: iload 5
    //   1191: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1194: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1197: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1200: iload_2
    //   1201: istore_1
    //   1202: iload 5
    //   1204: bipush 12
    //   1206: if_icmpne +416 -> 1622
    //   1209: iconst_1
    //   1210: istore 8
    //   1212: iload_2
    //   1213: istore_1
    //   1214: ldc_w 259
    //   1217: astore 14
    //   1219: goto -1051 -> 168
    //   1222: iload_2
    //   1223: istore_1
    //   1224: aload 15
    //   1226: ldc2_w 260
    //   1229: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1232: ldc2_w 260
    //   1235: lcmp
    //   1236: ifeq +381 -> 1617
    //   1239: ldc_w 263
    //   1242: astore 14
    //   1244: iload_2
    //   1245: istore_1
    //   1246: goto -1078 -> 168
    //   1249: iload_2
    //   1250: istore_1
    //   1251: iload_2
    //   1252: istore_3
    //   1253: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1256: ifeq +319 -> 1575
    //   1259: iload_2
    //   1260: istore_1
    //   1261: ldc 44
    //   1263: iconst_2
    //   1264: ldc_w 265
    //   1267: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1270: ldc_w 259
    //   1273: astore 14
    //   1275: iload_2
    //   1276: istore_1
    //   1277: goto -1109 -> 168
    //   1280: iload_2
    //   1281: istore_1
    //   1282: aload 15
    //   1284: ldc2_w 260
    //   1287: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1290: ldc2_w 260
    //   1293: lcmp
    //   1294: ifeq +337 -> 1631
    //   1297: ldc_w 263
    //   1300: astore 14
    //   1302: iload_2
    //   1303: istore_1
    //   1304: goto -1136 -> 168
    //   1307: iload_2
    //   1308: istore_1
    //   1309: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1312: ifeq +253 -> 1565
    //   1315: iload_2
    //   1316: istore_1
    //   1317: ldc 44
    //   1319: iconst_2
    //   1320: ldc_w 267
    //   1323: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1326: ldc_w 259
    //   1329: astore 14
    //   1331: iload_2
    //   1332: istore_1
    //   1333: goto -1165 -> 168
    //   1336: astore 15
    //   1338: aload 14
    //   1340: astore 16
    //   1342: iload_1
    //   1343: istore_2
    //   1344: iload 8
    //   1346: istore 7
    //   1348: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq -1153 -> 198
    //   1354: ldc 44
    //   1356: iconst_2
    //   1357: ldc_w 259
    //   1360: aload 15
    //   1362: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1365: aload 14
    //   1367: astore 16
    //   1369: iload_1
    //   1370: istore_2
    //   1371: iload 8
    //   1373: istore 7
    //   1375: goto -1177 -> 198
    //   1378: astore 15
    //   1380: iconst_0
    //   1381: istore_1
    //   1382: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1385: ifeq +14 -> 1399
    //   1388: ldc 44
    //   1390: iconst_2
    //   1391: ldc_w 259
    //   1394: aload 15
    //   1396: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1399: aload 14
    //   1401: ifnull +150 -> 1551
    //   1404: aload 14
    //   1406: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1409: ldc_w 259
    //   1412: astore 16
    //   1414: iload_1
    //   1415: istore_2
    //   1416: iload 9
    //   1418: istore 7
    //   1420: goto -1222 -> 198
    //   1423: astore 14
    //   1425: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1428: ifeq +14 -> 1442
    //   1431: ldc 44
    //   1433: iconst_2
    //   1434: ldc_w 259
    //   1437: aload 14
    //   1439: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1442: ldc_w 259
    //   1445: astore 16
    //   1447: iload_1
    //   1448: istore_2
    //   1449: iload 9
    //   1451: istore 7
    //   1453: goto -1255 -> 198
    //   1456: astore_0
    //   1457: aconst_null
    //   1458: astore 15
    //   1460: aload 15
    //   1462: ifnull +8 -> 1470
    //   1465: aload 15
    //   1467: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1470: aload_0
    //   1471: athrow
    //   1472: astore 14
    //   1474: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1477: ifeq -7 -> 1470
    //   1480: ldc 44
    //   1482: iconst_2
    //   1483: ldc_w 259
    //   1486: aload 14
    //   1488: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1491: goto -21 -> 1470
    //   1494: astore_0
    //   1495: goto -35 -> 1460
    //   1498: astore_0
    //   1499: aload 14
    //   1501: astore 15
    //   1503: goto -43 -> 1460
    //   1506: astore 16
    //   1508: aload 15
    //   1510: astore 14
    //   1512: aload 16
    //   1514: astore 15
    //   1516: goto -134 -> 1382
    //   1519: astore 14
    //   1521: aload 15
    //   1523: astore 16
    //   1525: aload 14
    //   1527: astore 15
    //   1529: aload 16
    //   1531: astore 14
    //   1533: goto -151 -> 1382
    //   1536: astore 16
    //   1538: aload 15
    //   1540: astore 14
    //   1542: iload_2
    //   1543: istore_1
    //   1544: aload 16
    //   1546: astore 15
    //   1548: goto -166 -> 1382
    //   1551: ldc_w 259
    //   1554: astore 16
    //   1556: iload_1
    //   1557: istore_2
    //   1558: iload 9
    //   1560: istore 7
    //   1562: goto -1364 -> 198
    //   1565: ldc_w 259
    //   1568: astore 14
    //   1570: iload_2
    //   1571: istore_1
    //   1572: goto -1404 -> 168
    //   1575: ldc_w 259
    //   1578: astore 14
    //   1580: iload_3
    //   1581: istore_1
    //   1582: goto -1414 -> 168
    //   1585: ldc_w 272
    //   1588: astore 14
    //   1590: iload_2
    //   1591: istore_1
    //   1592: goto -1424 -> 168
    //   1595: iload_3
    //   1596: iconst_m1
    //   1597: if_icmpne +10 -> 1607
    //   1600: iload 4
    //   1602: bipush 225
    //   1604: if_icmpeq -1223 -> 381
    //   1607: ldc_w 274
    //   1610: astore 14
    //   1612: iload_2
    //   1613: istore_1
    //   1614: goto -1446 -> 168
    //   1617: iload_2
    //   1618: bipush 10
    //   1620: iadd
    //   1621: istore_1
    //   1622: iload_3
    //   1623: iconst_1
    //   1624: iadd
    //   1625: istore_3
    //   1626: iload_1
    //   1627: istore_2
    //   1628: goto -624 -> 1004
    //   1631: iload_2
    //   1632: bipush 10
    //   1634: iadd
    //   1635: istore_2
    //   1636: iload 4
    //   1638: iconst_1
    //   1639: iadd
    //   1640: istore 4
    //   1642: goto -922 -> 720
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1645	0	paramString	String
    //   53	1574	1	i	int
    //   51	1585	2	j	int
    //   29	1597	3	k	int
    //   105	1536	4	m	int
    //   341	866	5	n	int
    //   1137	1	6	i1	int
    //   176	1385	7	bool1	boolean
    //   9	1363	8	bool2	boolean
    //   20	1539	9	bool3	boolean
    //   17	233	10	l1	long
    //   201	748	12	l2	long
    //   26	1379	14	localObject1	Object
    //   1423	15	14	localIOException1	IOException
    //   1472	28	14	localIOException2	IOException
    //   1510	1	14	localObject2	Object
    //   1519	7	14	localThrowable1	java.lang.Throwable
    //   1531	80	14	localObject3	Object
    //   48	1235	15	localBufferedInputStream	java.io.BufferedInputStream
    //   1336	25	15	localIOException3	IOException
    //   1378	17	15	localThrowable2	java.lang.Throwable
    //   1458	89	15	localObject4	Object
    //   120	1326	16	localObject5	Object
    //   1506	7	16	localThrowable3	java.lang.Throwable
    //   1523	7	16	localObject6	Object
    //   1536	9	16	localThrowable4	java.lang.Throwable
    //   1554	1	16	str1	String
    //   506	76	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   183	188	1336	java/io/IOException
    //   30	50	1378	java/lang/Throwable
    //   1404	1409	1423	java/io/IOException
    //   30	50	1456	finally
    //   1465	1470	1472	java/io/IOException
    //   54	59	1494	finally
    //   61	74	1494	finally
    //   117	122	1494	finally
    //   125	136	1494	finally
    //   143	155	1494	finally
    //   294	307	1494	finally
    //   357	372	1494	finally
    //   383	396	1494	finally
    //   411	428	1494	finally
    //   439	454	1494	finally
    //   469	482	1494	finally
    //   497	508	1494	finally
    //   510	520	1494	finally
    //   525	540	1494	finally
    //   551	561	1494	finally
    //   569	596	1494	finally
    //   603	616	1494	finally
    //   632	644	1494	finally
    //   651	666	1494	finally
    //   677	690	1494	finally
    //   708	717	1494	finally
    //   729	742	1494	finally
    //   757	769	1494	finally
    //   771	784	1494	finally
    //   799	808	1494	finally
    //   810	823	1494	finally
    //   838	846	1494	finally
    //   848	856	1494	finally
    //   858	871	1494	finally
    //   886	892	1494	finally
    //   894	920	1494	finally
    //   922	939	1494	finally
    //   941	954	1494	finally
    //   965	978	1494	finally
    //   993	1002	1494	finally
    //   1012	1025	1494	finally
    //   1040	1052	1494	finally
    //   1054	1067	1494	finally
    //   1082	1091	1494	finally
    //   1093	1106	1494	finally
    //   1121	1129	1494	finally
    //   1131	1139	1494	finally
    //   1141	1154	1494	finally
    //   1167	1200	1494	finally
    //   1224	1239	1494	finally
    //   1253	1259	1494	finally
    //   1261	1270	1494	finally
    //   1282	1297	1494	finally
    //   1309	1315	1494	finally
    //   1317	1326	1494	finally
    //   1382	1399	1498	finally
    //   54	59	1506	java/lang/Throwable
    //   61	74	1506	java/lang/Throwable
    //   117	122	1506	java/lang/Throwable
    //   125	136	1506	java/lang/Throwable
    //   143	155	1506	java/lang/Throwable
    //   294	307	1506	java/lang/Throwable
    //   357	372	1506	java/lang/Throwable
    //   383	396	1506	java/lang/Throwable
    //   411	428	1506	java/lang/Throwable
    //   439	454	1506	java/lang/Throwable
    //   469	482	1506	java/lang/Throwable
    //   993	1002	1506	java/lang/Throwable
    //   1012	1025	1506	java/lang/Throwable
    //   1040	1052	1506	java/lang/Throwable
    //   1054	1067	1506	java/lang/Throwable
    //   1082	1091	1506	java/lang/Throwable
    //   1093	1106	1506	java/lang/Throwable
    //   1121	1129	1506	java/lang/Throwable
    //   1131	1139	1506	java/lang/Throwable
    //   1141	1154	1506	java/lang/Throwable
    //   1224	1239	1506	java/lang/Throwable
    //   1253	1259	1506	java/lang/Throwable
    //   1261	1270	1506	java/lang/Throwable
    //   497	508	1519	java/lang/Throwable
    //   510	520	1519	java/lang/Throwable
    //   525	540	1519	java/lang/Throwable
    //   551	561	1519	java/lang/Throwable
    //   569	596	1519	java/lang/Throwable
    //   603	616	1519	java/lang/Throwable
    //   632	644	1519	java/lang/Throwable
    //   651	666	1519	java/lang/Throwable
    //   677	690	1519	java/lang/Throwable
    //   708	717	1519	java/lang/Throwable
    //   729	742	1519	java/lang/Throwable
    //   757	769	1519	java/lang/Throwable
    //   771	784	1519	java/lang/Throwable
    //   799	808	1519	java/lang/Throwable
    //   810	823	1519	java/lang/Throwable
    //   838	846	1519	java/lang/Throwable
    //   848	856	1519	java/lang/Throwable
    //   858	871	1519	java/lang/Throwable
    //   886	892	1519	java/lang/Throwable
    //   894	920	1519	java/lang/Throwable
    //   922	939	1519	java/lang/Throwable
    //   941	954	1519	java/lang/Throwable
    //   965	978	1519	java/lang/Throwable
    //   1282	1297	1519	java/lang/Throwable
    //   1309	1315	1519	java/lang/Throwable
    //   1317	1326	1519	java/lang/Throwable
    //   1167	1200	1536	java/lang/Throwable
  }
  
  /* Error */
  public static int readOrientation(String paramString)
  {
    // Byte code:
    //   0: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: getstatic 57	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   8: ifne +24 -> 32
    //   11: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   14: ifnull +18 -> 32
    //   17: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   20: invokeinterface 277 1 0
    //   25: putstatic 55	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   28: iconst_1
    //   29: putstatic 57	com/tencent/image/JpegExifReader:sIsReadDpc	Z
    //   32: getstatic 55	com/tencent/image/JpegExifReader:sIsEnable	Z
    //   35: ifne +51 -> 86
    //   38: new 279	android/media/ExifInterface
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 280	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +29 -> 77
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: ireturn
    //   55: astore_0
    //   56: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +13 -> 72
    //   62: ldc 44
    //   64: iconst_2
    //   65: ldc_w 282
    //   68: aload_0
    //   69: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: aconst_null
    //   73: astore_0
    //   74: goto -27 -> 47
    //   77: aload_0
    //   78: ldc_w 284
    //   81: iconst_1
    //   82: invokevirtual 288	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   85: ireturn
    //   86: aconst_null
    //   87: astore 10
    //   89: iconst_0
    //   90: istore_3
    //   91: ldc_w 259
    //   94: astore 9
    //   96: new 153	java/io/BufferedInputStream
    //   99: dup
    //   100: new 155	java/io/FileInputStream
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   108: sipush 512
    //   111: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   114: astore 12
    //   116: iconst_0
    //   117: istore_2
    //   118: aload 9
    //   120: astore 11
    //   122: iload_3
    //   123: istore_1
    //   124: iconst_2
    //   125: newarray byte
    //   127: astore 14
    //   129: aload 9
    //   131: astore 11
    //   133: iload_3
    //   134: istore_1
    //   135: aload 12
    //   137: aload 14
    //   139: iconst_0
    //   140: iconst_2
    //   141: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   144: iconst_2
    //   145: if_icmpne +33 -> 178
    //   148: aload 14
    //   150: iconst_0
    //   151: baload
    //   152: sipush 255
    //   155: iand
    //   156: sipush 255
    //   159: if_icmpne +231 -> 390
    //   162: aload 14
    //   164: iconst_1
    //   165: baload
    //   166: sipush 255
    //   169: iand
    //   170: sipush 216
    //   173: if_icmpne +217 -> 390
    //   176: iconst_1
    //   177: istore_2
    //   178: iconst_2
    //   179: istore_3
    //   180: aload 9
    //   182: astore 13
    //   184: iload_3
    //   185: istore 4
    //   187: iload_2
    //   188: ifeq +1572 -> 1760
    //   191: aload 9
    //   193: astore 11
    //   195: iload_3
    //   196: istore_1
    //   197: iconst_4
    //   198: newarray byte
    //   200: astore 13
    //   202: iload_3
    //   203: istore_2
    //   204: aload 9
    //   206: astore 11
    //   208: iload_2
    //   209: istore_1
    //   210: aload 12
    //   212: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   215: sipush 255
    //   218: iand
    //   219: i2b
    //   220: istore_3
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: aload 9
    //   227: astore 11
    //   229: iload_2
    //   230: istore_1
    //   231: aload 12
    //   233: invokevirtual 168	java/io/BufferedInputStream:read	()I
    //   236: sipush 255
    //   239: iand
    //   240: i2b
    //   241: istore 4
    //   243: iload 4
    //   245: bipush 218
    //   247: if_icmpne +148 -> 395
    //   250: ldc 170
    //   252: astore 9
    //   254: iload_2
    //   255: istore_1
    //   256: iconst_1
    //   257: istore_2
    //   258: aload 9
    //   260: astore 11
    //   262: iload_1
    //   263: istore 4
    //   265: iload_2
    //   266: istore_3
    //   267: aload 12
    //   269: ifnull +1479 -> 1748
    //   272: aload 12
    //   274: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   277: iload_1
    //   278: istore_3
    //   279: iload_2
    //   280: istore_1
    //   281: iload_3
    //   282: istore_2
    //   283: invokestatic 151	android/os/SystemClock:uptimeMillis	()J
    //   286: lload 6
    //   288: lsub
    //   289: lstore 6
    //   291: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   294: ifnull +21 -> 315
    //   297: getstatic 134	com/tencent/image/JpegExifReader:jpegExifReaderInterface	Lcom/tencent/image/JpegExifReader$JpegExifReaderInterface;
    //   300: aconst_null
    //   301: ldc 37
    //   303: iconst_1
    //   304: lload 6
    //   306: iload_2
    //   307: i2l
    //   308: aconst_null
    //   309: aconst_null
    //   310: invokeinterface 292 10 0
    //   315: iload_1
    //   316: istore_3
    //   317: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq -267 -> 53
    //   323: ldc 44
    //   325: iconst_2
    //   326: new 104	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 294
    //   336: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_1
    //   340: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc 180
    //   345: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload_2
    //   349: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc 182
    //   354: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: lload 6
    //   359: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   362: ldc 187
    //   364: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc_w 296
    //   374: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 9
    //   379: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iload_1
    //   389: ireturn
    //   390: iconst_0
    //   391: istore_2
    //   392: goto -214 -> 178
    //   395: iload_2
    //   396: iconst_1
    //   397: iadd
    //   398: istore_2
    //   399: aload 9
    //   401: astore 11
    //   403: iload_2
    //   404: istore_1
    //   405: aload 12
    //   407: aload 14
    //   409: iconst_0
    //   410: iconst_2
    //   411: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   414: iconst_2
    //   415: if_icmpeq +14 -> 429
    //   418: ldc 194
    //   420: astore 9
    //   422: iload_2
    //   423: istore_1
    //   424: iconst_1
    //   425: istore_2
    //   426: goto -168 -> 258
    //   429: iload_2
    //   430: iconst_2
    //   431: iadd
    //   432: istore_2
    //   433: aload 14
    //   435: iconst_0
    //   436: baload
    //   437: bipush 8
    //   439: ishl
    //   440: ldc 71
    //   442: iand
    //   443: aload 14
    //   445: iconst_1
    //   446: baload
    //   447: sipush 255
    //   450: iand
    //   451: ior
    //   452: iconst_2
    //   453: isub
    //   454: istore 5
    //   456: iload_3
    //   457: iconst_m1
    //   458: if_icmpne +39 -> 497
    //   461: iload 4
    //   463: bipush 224
    //   465: if_icmpne +32 -> 497
    //   468: aload 9
    //   470: astore 11
    //   472: iload_2
    //   473: istore_1
    //   474: aload 12
    //   476: iload 5
    //   478: i2l
    //   479: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   482: iload 5
    //   484: i2l
    //   485: lcmp
    //   486: ifne +1295 -> 1781
    //   489: iload_2
    //   490: iload 5
    //   492: iadd
    //   493: istore_2
    //   494: goto -290 -> 204
    //   497: iload_3
    //   498: iconst_m1
    //   499: if_icmpne +1294 -> 1793
    //   502: iload 4
    //   504: bipush 225
    //   506: if_icmpeq +1287 -> 1793
    //   509: iload 4
    //   511: bipush 225
    //   513: if_icmple +121 -> 634
    //   516: iload 4
    //   518: bipush 239
    //   520: if_icmpge +114 -> 634
    //   523: aload 9
    //   525: astore 11
    //   527: iload_2
    //   528: istore_1
    //   529: aload 12
    //   531: iload 5
    //   533: i2l
    //   534: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   537: iload 5
    //   539: i2l
    //   540: lcmp
    //   541: ifne +51 -> 592
    //   544: aload 9
    //   546: astore 11
    //   548: iload_2
    //   549: istore_1
    //   550: new 104	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   557: aload 9
    //   559: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: ldc_w 298
    //   565: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload 4
    //   570: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: ldc_w 300
    //   576: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: astore 9
    //   584: iload_2
    //   585: iload 5
    //   587: iadd
    //   588: istore_2
    //   589: goto -385 -> 204
    //   592: aload 9
    //   594: astore 11
    //   596: iload_2
    //   597: istore_1
    //   598: new 104	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 298
    //   608: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: iload 4
    //   613: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   616: ldc_w 302
    //   619: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: astore 9
    //   627: iload_2
    //   628: istore_1
    //   629: iconst_1
    //   630: istore_2
    //   631: goto -373 -> 258
    //   634: aload 9
    //   636: astore 11
    //   638: iload_2
    //   639: istore_1
    //   640: new 104	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 304
    //   650: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: iload 4
    //   655: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: astore 9
    //   663: iload_2
    //   664: istore_1
    //   665: iconst_1
    //   666: istore_2
    //   667: goto -409 -> 258
    //   670: aload 9
    //   672: astore 11
    //   674: iload_2
    //   675: istore_1
    //   676: aload 12
    //   678: aload 13
    //   680: iconst_0
    //   681: iconst_4
    //   682: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   685: iconst_4
    //   686: if_icmpeq +14 -> 700
    //   689: ldc 200
    //   691: astore 9
    //   693: iload_2
    //   694: istore_1
    //   695: iconst_1
    //   696: istore_2
    //   697: goto -439 -> 258
    //   700: aload 9
    //   702: astore 11
    //   704: iload_2
    //   705: istore_1
    //   706: ldc 25
    //   708: new 202	java/lang/String
    //   711: dup
    //   712: aload 13
    //   714: invokespecial 205	java/lang/String:<init>	([B)V
    //   717: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   720: ifne +14 -> 734
    //   723: ldc 210
    //   725: astore 9
    //   727: iload_2
    //   728: istore_1
    //   729: iconst_1
    //   730: istore_2
    //   731: goto -473 -> 258
    //   734: aload 9
    //   736: astore 11
    //   738: iload_2
    //   739: istore_1
    //   740: aload 12
    //   742: ldc2_w 211
    //   745: invokevirtual 215	java/io/BufferedInputStream:skip	(J)J
    //   748: ldc2_w 211
    //   751: lcmp
    //   752: ifeq +14 -> 766
    //   755: ldc 217
    //   757: astore 9
    //   759: iload_2
    //   760: istore_1
    //   761: iconst_1
    //   762: istore_2
    //   763: goto -505 -> 258
    //   766: iload_2
    //   767: iconst_2
    //   768: iadd
    //   769: istore_2
    //   770: aload 9
    //   772: astore 11
    //   774: iload_2
    //   775: istore_1
    //   776: aload 12
    //   778: aload 14
    //   780: iconst_0
    //   781: iconst_2
    //   782: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   785: iconst_2
    //   786: if_icmpeq +14 -> 800
    //   789: ldc 219
    //   791: astore 9
    //   793: iload_2
    //   794: istore_1
    //   795: iconst_1
    //   796: istore_2
    //   797: goto -539 -> 258
    //   800: iload_2
    //   801: iconst_2
    //   802: iadd
    //   803: istore_2
    //   804: aload 9
    //   806: astore 11
    //   808: iload_2
    //   809: istore_1
    //   810: new 202	java/lang/String
    //   813: dup
    //   814: aload 14
    //   816: invokespecial 205	java/lang/String:<init>	([B)V
    //   819: astore 10
    //   821: aload 9
    //   823: astore 11
    //   825: iload_2
    //   826: istore_1
    //   827: ldc 11
    //   829: aload 10
    //   831: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   834: ifeq +38 -> 872
    //   837: iconst_1
    //   838: istore 8
    //   840: aload 9
    //   842: astore 11
    //   844: iload_2
    //   845: istore_1
    //   846: aload 12
    //   848: ldc2_w 211
    //   851: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   854: ldc2_w 211
    //   857: lcmp
    //   858: ifeq +76 -> 934
    //   861: ldc 221
    //   863: astore 9
    //   865: iload_2
    //   866: istore_1
    //   867: iconst_1
    //   868: istore_2
    //   869: goto -611 -> 258
    //   872: aload 9
    //   874: astore 11
    //   876: iload_2
    //   877: istore_1
    //   878: ldc 32
    //   880: aload 10
    //   882: invokevirtual 208	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   885: ifeq +9 -> 894
    //   888: iconst_0
    //   889: istore 8
    //   891: goto -51 -> 840
    //   894: aload 9
    //   896: astore 11
    //   898: iload_2
    //   899: istore_1
    //   900: new 104	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   907: ldc 223
    //   909: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 10
    //   914: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: ldc 225
    //   919: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: astore 9
    //   927: iload_2
    //   928: istore_1
    //   929: iconst_1
    //   930: istore_2
    //   931: goto -673 -> 258
    //   934: aload 9
    //   936: astore 11
    //   938: iload_2
    //   939: istore_1
    //   940: aload 12
    //   942: aload 13
    //   944: iconst_0
    //   945: iconst_4
    //   946: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   949: iconst_4
    //   950: if_icmpeq +14 -> 964
    //   953: ldc 227
    //   955: astore 9
    //   957: iload_2
    //   958: istore_1
    //   959: iconst_1
    //   960: istore_2
    //   961: goto -703 -> 258
    //   964: iload_2
    //   965: bipush 6
    //   967: iadd
    //   968: istore_2
    //   969: aload 9
    //   971: astore 11
    //   973: iload_2
    //   974: istore_1
    //   975: iload 8
    //   977: aload 13
    //   979: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   982: bipush 8
    //   984: isub
    //   985: istore_3
    //   986: iload_3
    //   987: ifle +33 -> 1020
    //   990: aload 9
    //   992: astore 11
    //   994: iload_2
    //   995: istore_1
    //   996: aload 12
    //   998: iload_3
    //   999: i2l
    //   1000: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1003: iload_3
    //   1004: i2l
    //   1005: lcmp
    //   1006: ifeq +14 -> 1020
    //   1009: ldc 229
    //   1011: astore 9
    //   1013: iload_2
    //   1014: istore_1
    //   1015: iconst_1
    //   1016: istore_2
    //   1017: goto -759 -> 258
    //   1020: aload 9
    //   1022: astore 11
    //   1024: iload_2
    //   1025: istore_1
    //   1026: aload 12
    //   1028: aload 14
    //   1030: iconst_0
    //   1031: iconst_2
    //   1032: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1035: iconst_2
    //   1036: if_icmpeq +14 -> 1050
    //   1039: ldc 231
    //   1041: astore 9
    //   1043: iload_2
    //   1044: istore_1
    //   1045: iconst_1
    //   1046: istore_2
    //   1047: goto -789 -> 258
    //   1050: iload_2
    //   1051: iload_3
    //   1052: iconst_2
    //   1053: iadd
    //   1054: iadd
    //   1055: istore_2
    //   1056: aload 9
    //   1058: astore 11
    //   1060: iload_2
    //   1061: istore_1
    //   1062: iload 8
    //   1064: aload 14
    //   1066: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1069: istore 5
    //   1071: iconst_0
    //   1072: istore 4
    //   1074: aload 9
    //   1076: astore 10
    //   1078: iload_2
    //   1079: istore_3
    //   1080: iload 4
    //   1082: iload 5
    //   1084: if_icmpge +206 -> 1290
    //   1087: aload 9
    //   1089: astore 11
    //   1091: iload_2
    //   1092: istore_1
    //   1093: aload 12
    //   1095: aload 14
    //   1097: iconst_0
    //   1098: iconst_2
    //   1099: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1102: iconst_2
    //   1103: if_icmpeq +15 -> 1118
    //   1106: ldc_w 306
    //   1109: astore 9
    //   1111: iload_2
    //   1112: istore_1
    //   1113: iconst_1
    //   1114: istore_2
    //   1115: goto -857 -> 258
    //   1118: iload_2
    //   1119: iconst_2
    //   1120: iadd
    //   1121: istore_2
    //   1122: aload 9
    //   1124: astore 11
    //   1126: iload_2
    //   1127: istore_1
    //   1128: iload 8
    //   1130: aload 14
    //   1132: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1135: sipush 274
    //   1138: if_icmpne +377 -> 1515
    //   1141: aload 9
    //   1143: astore 11
    //   1145: iload_2
    //   1146: istore_1
    //   1147: aload 12
    //   1149: aload 14
    //   1151: iconst_0
    //   1152: iconst_2
    //   1153: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1156: iconst_2
    //   1157: if_icmpeq +15 -> 1172
    //   1160: ldc_w 308
    //   1163: astore 9
    //   1165: iload_2
    //   1166: istore_1
    //   1167: iconst_1
    //   1168: istore_2
    //   1169: goto -911 -> 258
    //   1172: iload_2
    //   1173: iconst_2
    //   1174: iadd
    //   1175: istore_2
    //   1176: aload 9
    //   1178: astore 11
    //   1180: iload_2
    //   1181: istore_1
    //   1182: iload 8
    //   1184: aload 14
    //   1186: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1189: istore 4
    //   1191: aload 9
    //   1193: astore 11
    //   1195: iload_2
    //   1196: istore_1
    //   1197: aload 12
    //   1199: aload 13
    //   1201: iconst_0
    //   1202: iconst_4
    //   1203: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1206: iconst_4
    //   1207: if_icmpeq +14 -> 1221
    //   1210: ldc 237
    //   1212: astore 9
    //   1214: iload_2
    //   1215: istore_1
    //   1216: iconst_1
    //   1217: istore_2
    //   1218: goto -960 -> 258
    //   1221: iload_2
    //   1222: iconst_4
    //   1223: iadd
    //   1224: istore_3
    //   1225: aload 9
    //   1227: astore 11
    //   1229: iload_3
    //   1230: istore_1
    //   1231: iload 8
    //   1233: aload 13
    //   1235: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1238: getstatic 64	com/tencent/image/JpegExifReader:BYTES_PER_FORMAT	[B
    //   1241: iload 4
    //   1243: baload
    //   1244: imul
    //   1245: istore_2
    //   1246: iload_2
    //   1247: iconst_4
    //   1248: if_icmple +87 -> 1335
    //   1251: aload 9
    //   1253: astore 11
    //   1255: iload_3
    //   1256: istore_1
    //   1257: new 104	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 310
    //   1267: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: iload 4
    //   1272: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1275: ldc_w 312
    //   1278: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: iload_2
    //   1282: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: astore 10
    //   1290: aload 10
    //   1292: astore 11
    //   1294: iload_3
    //   1295: istore_1
    //   1296: aload 10
    //   1298: astore 13
    //   1300: iload_3
    //   1301: istore 4
    //   1303: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1306: ifeq +454 -> 1760
    //   1309: aload 10
    //   1311: astore 11
    //   1313: iload_3
    //   1314: istore_1
    //   1315: ldc 44
    //   1317: iconst_2
    //   1318: ldc_w 267
    //   1321: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1324: aload 10
    //   1326: astore 9
    //   1328: iload_3
    //   1329: istore_1
    //   1330: iconst_1
    //   1331: istore_2
    //   1332: goto -1074 -> 258
    //   1335: aload 9
    //   1337: astore 11
    //   1339: iload_3
    //   1340: istore_1
    //   1341: aload 12
    //   1343: aload 13
    //   1345: iconst_0
    //   1346: iconst_4
    //   1347: invokevirtual 165	java/io/BufferedInputStream:read	([BII)I
    //   1350: iconst_4
    //   1351: if_icmpeq +466 -> 1817
    //   1354: ldc_w 314
    //   1357: astore 9
    //   1359: iload_3
    //   1360: istore_1
    //   1361: iconst_1
    //   1362: istore_2
    //   1363: goto -1105 -> 258
    //   1366: aload 9
    //   1368: astore 11
    //   1370: iload_2
    //   1371: istore_1
    //   1372: new 104	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1379: ldc_w 316
    //   1382: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: iload 4
    //   1387: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1390: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: astore 9
    //   1395: iconst_1
    //   1396: istore_1
    //   1397: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1400: ifeq +372 -> 1772
    //   1403: ldc 44
    //   1405: iconst_2
    //   1406: new 104	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1413: ldc_w 318
    //   1416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: iload_1
    //   1420: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1423: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1429: iload_1
    //   1430: istore_3
    //   1431: iload_2
    //   1432: istore_1
    //   1433: iload_3
    //   1434: istore_2
    //   1435: goto -1177 -> 258
    //   1438: aload 9
    //   1440: astore 11
    //   1442: iload_2
    //   1443: istore_1
    //   1444: iload 8
    //   1446: aload 13
    //   1448: invokestatic 124	com/tencent/image/JpegExifReader:getUnsignedInt16	(Z[B)I
    //   1451: istore_3
    //   1452: iload_3
    //   1453: istore_1
    //   1454: goto -57 -> 1397
    //   1457: aload 9
    //   1459: astore 11
    //   1461: iload_2
    //   1462: istore_1
    //   1463: iload 8
    //   1465: aload 13
    //   1467: invokestatic 126	com/tencent/image/JpegExifReader:getUnsignedInt32	(Z[B)J
    //   1470: l2i
    //   1471: istore_3
    //   1472: iload_3
    //   1473: istore_1
    //   1474: goto -77 -> 1397
    //   1477: aload 9
    //   1479: astore 11
    //   1481: iload_2
    //   1482: istore_1
    //   1483: iload 8
    //   1485: aload 13
    //   1487: invokestatic 128	com/tencent/image/JpegExifReader:getInt16	(Z[B)S
    //   1490: istore_3
    //   1491: iload_3
    //   1492: istore_1
    //   1493: goto -96 -> 1397
    //   1496: aload 9
    //   1498: astore 11
    //   1500: iload_2
    //   1501: istore_1
    //   1502: iload 8
    //   1504: aload 13
    //   1506: invokestatic 130	com/tencent/image/JpegExifReader:getInt32	(Z[B)I
    //   1509: istore_3
    //   1510: iload_3
    //   1511: istore_1
    //   1512: goto -115 -> 1397
    //   1515: aload 9
    //   1517: astore 11
    //   1519: iload_2
    //   1520: istore_1
    //   1521: aload 12
    //   1523: ldc2_w 260
    //   1526: invokestatic 198	com/tencent/image/JpegExifReader:skip	(Ljava/io/InputStream;J)J
    //   1529: ldc2_w 260
    //   1532: lcmp
    //   1533: ifeq +15 -> 1548
    //   1536: ldc_w 263
    //   1539: astore 9
    //   1541: iload_2
    //   1542: istore_1
    //   1543: iconst_1
    //   1544: istore_2
    //   1545: goto -1287 -> 258
    //   1548: iload_2
    //   1549: bipush 10
    //   1551: iadd
    //   1552: istore_2
    //   1553: iload 4
    //   1555: iconst_1
    //   1556: iadd
    //   1557: istore 4
    //   1559: goto -485 -> 1074
    //   1562: astore 10
    //   1564: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1567: ifeq +14 -> 1581
    //   1570: ldc 44
    //   1572: iconst_2
    //   1573: ldc_w 259
    //   1576: aload 10
    //   1578: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1581: iload_2
    //   1582: istore_3
    //   1583: iload_1
    //   1584: istore_2
    //   1585: iload_3
    //   1586: istore_1
    //   1587: goto -1304 -> 283
    //   1590: astore 11
    //   1592: ldc_w 259
    //   1595: astore 9
    //   1597: iconst_0
    //   1598: istore_2
    //   1599: iconst_1
    //   1600: istore_1
    //   1601: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1604: ifeq +14 -> 1618
    //   1607: ldc 44
    //   1609: iconst_2
    //   1610: ldc_w 259
    //   1613: aload 11
    //   1615: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1618: aload 9
    //   1620: astore 11
    //   1622: iload_2
    //   1623: istore 4
    //   1625: iload_1
    //   1626: istore_3
    //   1627: aload 10
    //   1629: ifnull +119 -> 1748
    //   1632: aload 10
    //   1634: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1637: goto -1354 -> 283
    //   1640: astore 10
    //   1642: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1645: ifeq +14 -> 1659
    //   1648: ldc 44
    //   1650: iconst_2
    //   1651: ldc_w 259
    //   1654: aload 10
    //   1656: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1659: goto -1376 -> 283
    //   1662: astore_0
    //   1663: aconst_null
    //   1664: astore 12
    //   1666: aload 12
    //   1668: ifnull +8 -> 1676
    //   1671: aload 12
    //   1673: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   1676: aload_0
    //   1677: athrow
    //   1678: astore 9
    //   1680: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1683: ifeq -7 -> 1676
    //   1686: ldc 44
    //   1688: iconst_2
    //   1689: ldc_w 259
    //   1692: aload 9
    //   1694: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1697: goto -21 -> 1676
    //   1700: astore_0
    //   1701: goto -35 -> 1666
    //   1704: astore_0
    //   1705: aload 10
    //   1707: astore 12
    //   1709: goto -43 -> 1666
    //   1712: astore 9
    //   1714: aload 12
    //   1716: astore 10
    //   1718: aload 9
    //   1720: astore 12
    //   1722: aload 11
    //   1724: astore 9
    //   1726: iconst_1
    //   1727: istore_3
    //   1728: iload_1
    //   1729: istore_2
    //   1730: iload_3
    //   1731: istore_1
    //   1732: aload 12
    //   1734: astore 11
    //   1736: goto -135 -> 1601
    //   1739: astore 11
    //   1741: aload 12
    //   1743: astore 10
    //   1745: goto -144 -> 1601
    //   1748: aload 11
    //   1750: astore 9
    //   1752: iload 4
    //   1754: istore_2
    //   1755: iload_3
    //   1756: istore_1
    //   1757: goto -1474 -> 283
    //   1760: aload 13
    //   1762: astore 9
    //   1764: iload 4
    //   1766: istore_1
    //   1767: iconst_1
    //   1768: istore_2
    //   1769: goto -1511 -> 258
    //   1772: iload_1
    //   1773: istore_3
    //   1774: iload_2
    //   1775: istore_1
    //   1776: iload_3
    //   1777: istore_2
    //   1778: goto -1520 -> 258
    //   1781: ldc_w 272
    //   1784: astore 9
    //   1786: iload_2
    //   1787: istore_1
    //   1788: iconst_1
    //   1789: istore_2
    //   1790: goto -1532 -> 258
    //   1793: iload_3
    //   1794: iconst_m1
    //   1795: if_icmpne +10 -> 1805
    //   1798: iload 4
    //   1800: bipush 225
    //   1802: if_icmpeq -1132 -> 670
    //   1805: ldc_w 274
    //   1808: astore 9
    //   1810: iload_2
    //   1811: istore_1
    //   1812: iconst_1
    //   1813: istore_2
    //   1814: goto -1556 -> 258
    //   1817: iload_3
    //   1818: iconst_4
    //   1819: iadd
    //   1820: istore_2
    //   1821: iload 4
    //   1823: tableswitch	default:+41 -> 1864, 3:+-385->1438, 4:+-366->1457, 5:+-457->1366, 6:+44->1867, 7:+-457->1366, 8:+-346->1477, 9:+-327->1496
    //   1865: impdep1
    //   1866: dconst_0
    //   1867: aload 13
    //   1869: iconst_0
    //   1870: baload
    //   1871: istore_1
    //   1872: goto -475 -> 1397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1875	0	paramString	String
    //   123	1749	1	i	int
    //   117	1704	2	j	int
    //   52	1768	3	k	int
    //   185	1637	4	m	int
    //   454	631	5	n	int
    //   3	355	6	l	long
    //   838	665	8	bool	boolean
    //   94	1525	9	localObject1	Object
    //   1678	15	9	localIOException1	IOException
    //   1712	7	9	localThrowable1	java.lang.Throwable
    //   1724	85	9	localObject2	Object
    //   87	1238	10	localObject3	Object
    //   1562	71	10	localIOException2	IOException
    //   1640	66	10	localIOException3	IOException
    //   1716	28	10	localObject4	Object
    //   120	1398	11	localObject5	Object
    //   1590	24	11	localThrowable2	java.lang.Throwable
    //   1620	115	11	localObject6	Object
    //   1739	10	11	localThrowable3	java.lang.Throwable
    //   114	1628	12	localObject7	Object
    //   182	1686	13	localObject8	Object
    //   127	1058	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	47	55	java/io/IOException
    //   272	277	1562	java/io/IOException
    //   96	116	1590	java/lang/Throwable
    //   1632	1637	1640	java/io/IOException
    //   96	116	1662	finally
    //   1671	1676	1678	java/io/IOException
    //   124	129	1700	finally
    //   135	148	1700	finally
    //   197	202	1700	finally
    //   210	221	1700	finally
    //   231	243	1700	finally
    //   405	418	1700	finally
    //   474	489	1700	finally
    //   529	544	1700	finally
    //   550	584	1700	finally
    //   598	627	1700	finally
    //   640	663	1700	finally
    //   676	689	1700	finally
    //   706	723	1700	finally
    //   740	755	1700	finally
    //   776	789	1700	finally
    //   810	821	1700	finally
    //   827	837	1700	finally
    //   846	861	1700	finally
    //   878	888	1700	finally
    //   900	927	1700	finally
    //   940	953	1700	finally
    //   975	986	1700	finally
    //   996	1009	1700	finally
    //   1026	1039	1700	finally
    //   1062	1071	1700	finally
    //   1093	1106	1700	finally
    //   1128	1141	1700	finally
    //   1147	1160	1700	finally
    //   1182	1191	1700	finally
    //   1197	1210	1700	finally
    //   1231	1246	1700	finally
    //   1257	1290	1700	finally
    //   1303	1309	1700	finally
    //   1315	1324	1700	finally
    //   1341	1354	1700	finally
    //   1372	1395	1700	finally
    //   1397	1429	1700	finally
    //   1444	1452	1700	finally
    //   1463	1472	1700	finally
    //   1483	1491	1700	finally
    //   1502	1510	1700	finally
    //   1521	1536	1700	finally
    //   1601	1618	1704	finally
    //   124	129	1712	java/lang/Throwable
    //   135	148	1712	java/lang/Throwable
    //   197	202	1712	java/lang/Throwable
    //   210	221	1712	java/lang/Throwable
    //   231	243	1712	java/lang/Throwable
    //   405	418	1712	java/lang/Throwable
    //   474	489	1712	java/lang/Throwable
    //   529	544	1712	java/lang/Throwable
    //   550	584	1712	java/lang/Throwable
    //   598	627	1712	java/lang/Throwable
    //   640	663	1712	java/lang/Throwable
    //   676	689	1712	java/lang/Throwable
    //   706	723	1712	java/lang/Throwable
    //   740	755	1712	java/lang/Throwable
    //   776	789	1712	java/lang/Throwable
    //   810	821	1712	java/lang/Throwable
    //   827	837	1712	java/lang/Throwable
    //   846	861	1712	java/lang/Throwable
    //   878	888	1712	java/lang/Throwable
    //   900	927	1712	java/lang/Throwable
    //   940	953	1712	java/lang/Throwable
    //   975	986	1712	java/lang/Throwable
    //   996	1009	1712	java/lang/Throwable
    //   1026	1039	1712	java/lang/Throwable
    //   1062	1071	1712	java/lang/Throwable
    //   1093	1106	1712	java/lang/Throwable
    //   1128	1141	1712	java/lang/Throwable
    //   1147	1160	1712	java/lang/Throwable
    //   1182	1191	1712	java/lang/Throwable
    //   1197	1210	1712	java/lang/Throwable
    //   1231	1246	1712	java/lang/Throwable
    //   1257	1290	1712	java/lang/Throwable
    //   1303	1309	1712	java/lang/Throwable
    //   1315	1324	1712	java/lang/Throwable
    //   1341	1354	1712	java/lang/Throwable
    //   1372	1395	1712	java/lang/Throwable
    //   1444	1452	1712	java/lang/Throwable
    //   1463	1472	1712	java/lang/Throwable
    //   1483	1491	1712	java/lang/Throwable
    //   1502	1510	1712	java/lang/Throwable
    //   1521	1536	1712	java/lang/Throwable
    //   1397	1429	1739	java/lang/Throwable
  }
  
  private static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    long l1 = paramLong;
    for (;;)
    {
      if (l1 > 0L)
      {
        long l2 = paramInputStream.skip(l1);
        if (l2 > 0L)
        {
          l1 -= l2;
          continue;
        }
        if (l2 != 0L) {
          break;
        }
        if (paramInputStream.read() != -1) {}
      }
      else
      {
        return paramLong - l1;
      }
      l1 -= 1L;
    }
    throw new IOException("skip() return a negative value.");
  }
  
  public static abstract interface JpegExifReaderInterface
  {
    public abstract void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3);
    
    public abstract boolean readEnableFromDPC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.JpegExifReader
 * JD-Core Version:    0.7.0.1
 */