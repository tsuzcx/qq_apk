package wns_proxy;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class GZIP
{
  private static final int BTYPE_DYNAMIC = 2;
  private static final int BTYPE_FIXED = 1;
  private static final int BTYPE_NONE = 0;
  private static final int BTYPE_RESERVED = 3;
  private static final int EOB_CODE = 256;
  private static final int FCOMMENT_MASK = 16;
  private static final int FEXTRA_MASK = 4;
  private static final int FHCRC_MASK = 2;
  private static final int FNAME_MASK = 8;
  private static final int FTEXT_MASK = 1;
  private static final int MAX_BITS = 16;
  private static final int MAX_CODE_DISTANCES = 31;
  private static final int MAX_CODE_LENGTHS = 18;
  private static final int MAX_CODE_LITERALS = 287;
  private static byte[] buffer;
  private static int buffer_bit;
  private static int buffer_byte;
  private static int buffer_index;
  private static byte[] distance_extra_bits;
  private static short[] distance_values;
  private static byte[] dynamic_length_order;
  private static byte[] length_extra_bits;
  private static short[] length_values;
  private static byte[] uncompressed;
  private static int uncompressed_index;
  
  private static int[] createHuffmanTree(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt2 = new int[17];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      j = paramArrayOfByte[i];
      arrayOfInt2[j] += 1;
      i += 1;
    }
    arrayOfInt2[0] = 0;
    int[] arrayOfInt1 = new int[17];
    i = 1;
    int j = 0;
    while (i <= 16)
    {
      j = j + arrayOfInt2[(i - 1)] << 1;
      arrayOfInt1[i] = j;
      i += 1;
    }
    arrayOfInt2 = new int[(paramInt << 1) + 16];
    int k = 0;
    for (i = 1; k <= paramInt; i = j)
    {
      int m = paramArrayOfByte[k];
      j = i;
      if (m != 0)
      {
        int i1 = arrayOfInt1[m];
        arrayOfInt1[m] = (i1 + 1);
        m -= 1;
        j = 0;
        if (m >= 0)
        {
          int n;
          if ((1 << m & i1) == 0)
          {
            n = arrayOfInt2[j] >> 16;
            if (n == 0)
            {
              arrayOfInt2[j] |= i << 16;
              j = i + 1;
            }
          }
          for (;;)
          {
            m -= 1;
            n = i;
            i = j;
            j = n;
            break;
            j = i;
            i = n;
            continue;
            n = arrayOfInt2[j] & 0xFFFF;
            if (n == 0)
            {
              arrayOfInt2[j] |= i;
              j = i + 1;
            }
            else
            {
              j = i;
              i = n;
            }
          }
        }
        arrayOfInt2[j] = (0x80000000 | k);
        j = i;
      }
      k += 1;
    }
    return arrayOfInt2;
  }
  
  private static byte[] decodeCodeLengths(int[] paramArrayOfInt, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int j = 0;
    int i = 0;
    if (i < paramInt)
    {
      int n = readCode(paramArrayOfInt);
      if (n >= 16)
      {
        int k;
        int m;
        if (n == 16)
        {
          k = readBits(2);
          m = k + 3;
          k = j;
          for (;;)
          {
            n = k;
            j = i;
            if (m <= 0) {
              break;
            }
            arrayOfByte[i] = ((byte)k);
            i += 1;
            m -= 1;
          }
        }
        if (n == 17) {}
        for (j = readBits(3) + 3;; j = readBits(7) + 11)
        {
          k = 0;
          m = j;
          break;
        }
      }
      if (n != 0)
      {
        j = i + 1;
        arrayOfByte[i] = ((byte)n);
      }
      for (;;)
      {
        i = j;
        j = n;
        break;
        j = i + 1;
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] inflate(byte[] paramArrayOfByte)
    throws IOException
  {
    return inflate(paramArrayOfByte, 0);
  }
  
  /* Error */
  private static byte[] inflate(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: putstatic 72	wns_proxy/GZIP:buffer	[B
    //   7: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   10: iload_1
    //   11: iadd
    //   12: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   15: bipush 16
    //   17: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   20: ldc 75
    //   22: if_icmpne +13 -> 35
    //   25: bipush 8
    //   27: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   30: bipush 8
    //   32: if_icmpeq +66 -> 98
    //   35: new 66	java/io/IOException
    //   38: dup
    //   39: ldc 77
    //   41: invokespecial 80	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: astore_0
    //   46: iconst_0
    //   47: putstatic 82	wns_proxy/GZIP:uncompressed_index	I
    //   50: iconst_0
    //   51: putstatic 84	wns_proxy/GZIP:buffer_bit	I
    //   54: iconst_0
    //   55: putstatic 86	wns_proxy/GZIP:buffer_byte	I
    //   58: iconst_0
    //   59: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   62: aconst_null
    //   63: putstatic 88	wns_proxy/GZIP:dynamic_length_order	[B
    //   66: aconst_null
    //   67: putstatic 90	wns_proxy/GZIP:distance_extra_bits	[B
    //   70: aconst_null
    //   71: putstatic 92	wns_proxy/GZIP:length_extra_bits	[B
    //   74: aconst_null
    //   75: putstatic 94	wns_proxy/GZIP:uncompressed	[B
    //   78: aconst_null
    //   79: putstatic 72	wns_proxy/GZIP:buffer	[B
    //   82: aconst_null
    //   83: putstatic 96	wns_proxy/GZIP:distance_values	[S
    //   86: aconst_null
    //   87: putstatic 98	wns_proxy/GZIP:length_values	[S
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    //   98: bipush 8
    //   100: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   103: istore_1
    //   104: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   107: bipush 6
    //   109: iadd
    //   110: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   113: iload_1
    //   114: iconst_4
    //   115: iand
    //   116: ifeq +15 -> 131
    //   119: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   122: bipush 16
    //   124: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   127: iadd
    //   128: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   131: iload_1
    //   132: bipush 8
    //   134: iand
    //   135: ifeq +23 -> 158
    //   138: getstatic 72	wns_proxy/GZIP:buffer	[B
    //   141: astore_0
    //   142: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   145: istore_2
    //   146: iload_2
    //   147: iconst_1
    //   148: iadd
    //   149: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   152: aload_0
    //   153: iload_2
    //   154: baload
    //   155: ifne -24 -> 131
    //   158: iload_1
    //   159: bipush 16
    //   161: iand
    //   162: ifeq +23 -> 185
    //   165: getstatic 72	wns_proxy/GZIP:buffer	[B
    //   168: astore_0
    //   169: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   172: istore_2
    //   173: iload_2
    //   174: iconst_1
    //   175: iadd
    //   176: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   179: aload_0
    //   180: iload_2
    //   181: baload
    //   182: ifne -24 -> 158
    //   185: iload_1
    //   186: iconst_2
    //   187: iand
    //   188: ifeq +11 -> 199
    //   191: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   194: iconst_2
    //   195: iadd
    //   196: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   199: getstatic 74	wns_proxy/GZIP:buffer_index	I
    //   202: istore_1
    //   203: getstatic 72	wns_proxy/GZIP:buffer	[B
    //   206: arraylength
    //   207: iconst_4
    //   208: isub
    //   209: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   212: bipush 16
    //   214: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   217: bipush 16
    //   219: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   222: bipush 16
    //   224: ishl
    //   225: ior
    //   226: newarray byte
    //   228: putstatic 94	wns_proxy/GZIP:uncompressed	[B
    //   231: iload_1
    //   232: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   235: bipush 31
    //   237: newarray byte
    //   239: dup
    //   240: iconst_0
    //   241: ldc 11
    //   243: bastore
    //   244: dup
    //   245: iconst_1
    //   246: ldc 11
    //   248: bastore
    //   249: dup
    //   250: iconst_2
    //   251: ldc 11
    //   253: bastore
    //   254: dup
    //   255: iconst_3
    //   256: ldc 11
    //   258: bastore
    //   259: dup
    //   260: iconst_4
    //   261: ldc 11
    //   263: bastore
    //   264: dup
    //   265: iconst_5
    //   266: ldc 11
    //   268: bastore
    //   269: dup
    //   270: bipush 6
    //   272: ldc 11
    //   274: bastore
    //   275: dup
    //   276: bipush 7
    //   278: ldc 11
    //   280: bastore
    //   281: dup
    //   282: bipush 8
    //   284: ldc 9
    //   286: bastore
    //   287: dup
    //   288: bipush 9
    //   290: ldc 9
    //   292: bastore
    //   293: dup
    //   294: bipush 10
    //   296: ldc 9
    //   298: bastore
    //   299: dup
    //   300: bipush 11
    //   302: ldc 9
    //   304: bastore
    //   305: dup
    //   306: bipush 12
    //   308: ldc 7
    //   310: bastore
    //   311: dup
    //   312: bipush 13
    //   314: ldc 7
    //   316: bastore
    //   317: dup
    //   318: bipush 14
    //   320: ldc 7
    //   322: bastore
    //   323: dup
    //   324: bipush 15
    //   326: ldc 7
    //   328: bastore
    //   329: dup
    //   330: bipush 16
    //   332: ldc 13
    //   334: bastore
    //   335: dup
    //   336: bipush 17
    //   338: ldc 13
    //   340: bastore
    //   341: dup
    //   342: bipush 18
    //   344: ldc 13
    //   346: bastore
    //   347: dup
    //   348: bipush 19
    //   350: ldc 13
    //   352: bastore
    //   353: dup
    //   354: bipush 20
    //   356: ldc 19
    //   358: bastore
    //   359: dup
    //   360: bipush 21
    //   362: ldc 19
    //   364: bastore
    //   365: dup
    //   366: bipush 22
    //   368: ldc 19
    //   370: bastore
    //   371: dup
    //   372: bipush 23
    //   374: ldc 19
    //   376: bastore
    //   377: dup
    //   378: bipush 24
    //   380: ldc 99
    //   382: bastore
    //   383: dup
    //   384: bipush 25
    //   386: ldc 99
    //   388: bastore
    //   389: dup
    //   390: bipush 26
    //   392: ldc 99
    //   394: bastore
    //   395: dup
    //   396: bipush 27
    //   398: ldc 99
    //   400: bastore
    //   401: dup
    //   402: bipush 28
    //   404: ldc 11
    //   406: bastore
    //   407: dup
    //   408: bipush 29
    //   410: ldc 100
    //   412: bastore
    //   413: dup
    //   414: bipush 30
    //   416: ldc 100
    //   418: bastore
    //   419: putstatic 92	wns_proxy/GZIP:length_extra_bits	[B
    //   422: bipush 31
    //   424: newarray short
    //   426: dup
    //   427: iconst_0
    //   428: ldc 13
    //   430: sastore
    //   431: dup
    //   432: iconst_1
    //   433: ldc 19
    //   435: sastore
    //   436: dup
    //   437: iconst_2
    //   438: ldc 99
    //   440: sastore
    //   441: dup
    //   442: iconst_3
    //   443: ldc 101
    //   445: sastore
    //   446: dup
    //   447: iconst_4
    //   448: ldc 102
    //   450: sastore
    //   451: dup
    //   452: iconst_5
    //   453: ldc 22
    //   455: sastore
    //   456: dup
    //   457: bipush 6
    //   459: ldc 103
    //   461: sastore
    //   462: dup
    //   463: bipush 7
    //   465: ldc 104
    //   467: sastore
    //   468: dup
    //   469: bipush 8
    //   471: ldc 105
    //   473: sastore
    //   474: dup
    //   475: bipush 9
    //   477: ldc 106
    //   479: sastore
    //   480: dup
    //   481: bipush 10
    //   483: ldc 107
    //   485: sastore
    //   486: dup
    //   487: bipush 11
    //   489: ldc 108
    //   491: sastore
    //   492: dup
    //   493: bipush 12
    //   495: ldc 109
    //   497: sastore
    //   498: dup
    //   499: bipush 13
    //   501: ldc 110
    //   503: sastore
    //   504: dup
    //   505: bipush 14
    //   507: ldc 111
    //   509: sastore
    //   510: dup
    //   511: bipush 15
    //   513: ldc 26
    //   515: sastore
    //   516: dup
    //   517: bipush 16
    //   519: ldc 112
    //   521: sastore
    //   522: dup
    //   523: bipush 17
    //   525: ldc 113
    //   527: sastore
    //   528: dup
    //   529: bipush 18
    //   531: ldc 114
    //   533: sastore
    //   534: dup
    //   535: bipush 19
    //   537: ldc 115
    //   539: sastore
    //   540: dup
    //   541: bipush 20
    //   543: ldc 116
    //   545: sastore
    //   546: dup
    //   547: bipush 21
    //   549: ldc 117
    //   551: sastore
    //   552: dup
    //   553: bipush 22
    //   555: ldc 100
    //   557: sastore
    //   558: dup
    //   559: bipush 23
    //   561: ldc 118
    //   563: sastore
    //   564: dup
    //   565: bipush 24
    //   567: ldc 119
    //   569: sastore
    //   570: dup
    //   571: bipush 25
    //   573: ldc 120
    //   575: sastore
    //   576: dup
    //   577: bipush 26
    //   579: ldc 121
    //   581: sastore
    //   582: dup
    //   583: bipush 27
    //   585: ldc 122
    //   587: sastore
    //   588: dup
    //   589: bipush 28
    //   591: ldc 123
    //   593: sastore
    //   594: dup
    //   595: bipush 29
    //   597: ldc 11
    //   599: sastore
    //   600: dup
    //   601: bipush 30
    //   603: ldc 11
    //   605: sastore
    //   606: putstatic 98	wns_proxy/GZIP:length_values	[S
    //   609: bipush 30
    //   611: newarray byte
    //   613: dup
    //   614: iconst_0
    //   615: ldc 11
    //   617: bastore
    //   618: dup
    //   619: iconst_1
    //   620: ldc 11
    //   622: bastore
    //   623: dup
    //   624: iconst_2
    //   625: ldc 11
    //   627: bastore
    //   628: dup
    //   629: iconst_3
    //   630: ldc 11
    //   632: bastore
    //   633: dup
    //   634: iconst_4
    //   635: ldc 9
    //   637: bastore
    //   638: dup
    //   639: iconst_5
    //   640: ldc 9
    //   642: bastore
    //   643: dup
    //   644: bipush 6
    //   646: ldc 7
    //   648: bastore
    //   649: dup
    //   650: bipush 7
    //   652: ldc 7
    //   654: bastore
    //   655: dup
    //   656: bipush 8
    //   658: ldc 13
    //   660: bastore
    //   661: dup
    //   662: bipush 9
    //   664: ldc 13
    //   666: bastore
    //   667: dup
    //   668: bipush 10
    //   670: ldc 19
    //   672: bastore
    //   673: dup
    //   674: bipush 11
    //   676: ldc 19
    //   678: bastore
    //   679: dup
    //   680: bipush 12
    //   682: ldc 99
    //   684: bastore
    //   685: dup
    //   686: bipush 13
    //   688: ldc 99
    //   690: bastore
    //   691: dup
    //   692: bipush 14
    //   694: ldc 101
    //   696: bastore
    //   697: dup
    //   698: bipush 15
    //   700: ldc 101
    //   702: bastore
    //   703: dup
    //   704: bipush 16
    //   706: ldc 102
    //   708: bastore
    //   709: dup
    //   710: bipush 17
    //   712: ldc 102
    //   714: bastore
    //   715: dup
    //   716: bipush 18
    //   718: ldc 22
    //   720: bastore
    //   721: dup
    //   722: bipush 19
    //   724: ldc 22
    //   726: bastore
    //   727: dup
    //   728: bipush 20
    //   730: ldc 103
    //   732: bastore
    //   733: dup
    //   734: bipush 21
    //   736: ldc 103
    //   738: bastore
    //   739: dup
    //   740: bipush 22
    //   742: ldc 104
    //   744: bastore
    //   745: dup
    //   746: bipush 23
    //   748: ldc 104
    //   750: bastore
    //   751: dup
    //   752: bipush 24
    //   754: ldc 105
    //   756: bastore
    //   757: dup
    //   758: bipush 25
    //   760: ldc 105
    //   762: bastore
    //   763: dup
    //   764: bipush 26
    //   766: ldc 124
    //   768: bastore
    //   769: dup
    //   770: bipush 27
    //   772: ldc 124
    //   774: bastore
    //   775: dup
    //   776: bipush 28
    //   778: ldc 106
    //   780: bastore
    //   781: dup
    //   782: bipush 29
    //   784: ldc 106
    //   786: bastore
    //   787: putstatic 90	wns_proxy/GZIP:distance_extra_bits	[B
    //   790: bipush 30
    //   792: newarray short
    //   794: dup
    //   795: iconst_0
    //   796: ldc 9
    //   798: sastore
    //   799: dup
    //   800: iconst_1
    //   801: ldc 7
    //   803: sastore
    //   804: dup
    //   805: iconst_2
    //   806: ldc 13
    //   808: sastore
    //   809: dup
    //   810: iconst_3
    //   811: ldc 19
    //   813: sastore
    //   814: dup
    //   815: iconst_4
    //   816: ldc 99
    //   818: sastore
    //   819: dup
    //   820: iconst_5
    //   821: ldc 102
    //   823: sastore
    //   824: dup
    //   825: bipush 6
    //   827: ldc 103
    //   829: sastore
    //   830: dup
    //   831: bipush 7
    //   833: ldc 106
    //   835: sastore
    //   836: dup
    //   837: bipush 8
    //   839: ldc 108
    //   841: sastore
    //   842: dup
    //   843: bipush 9
    //   845: ldc 125
    //   847: sastore
    //   848: dup
    //   849: bipush 10
    //   851: ldc 126
    //   853: sastore
    //   854: dup
    //   855: bipush 11
    //   857: ldc 127
    //   859: sastore
    //   860: dup
    //   861: bipush 12
    //   863: ldc 128
    //   865: sastore
    //   866: dup
    //   867: bipush 13
    //   869: ldc 129
    //   871: sastore
    //   872: dup
    //   873: bipush 14
    //   875: ldc 130
    //   877: sastore
    //   878: dup
    //   879: bipush 15
    //   881: ldc 131
    //   883: sastore
    //   884: dup
    //   885: bipush 16
    //   887: ldc 132
    //   889: sastore
    //   890: dup
    //   891: bipush 17
    //   893: ldc 133
    //   895: sastore
    //   896: dup
    //   897: bipush 18
    //   899: ldc 134
    //   901: sastore
    //   902: dup
    //   903: bipush 19
    //   905: ldc 135
    //   907: sastore
    //   908: dup
    //   909: bipush 20
    //   911: ldc 136
    //   913: sastore
    //   914: dup
    //   915: bipush 21
    //   917: ldc 137
    //   919: sastore
    //   920: dup
    //   921: bipush 22
    //   923: ldc 138
    //   925: sastore
    //   926: dup
    //   927: bipush 23
    //   929: ldc 139
    //   931: sastore
    //   932: dup
    //   933: bipush 24
    //   935: ldc 140
    //   937: sastore
    //   938: dup
    //   939: bipush 25
    //   941: ldc 141
    //   943: sastore
    //   944: dup
    //   945: bipush 26
    //   947: ldc 142
    //   949: sastore
    //   950: dup
    //   951: bipush 27
    //   953: ldc 143
    //   955: sastore
    //   956: dup
    //   957: bipush 28
    //   959: ldc 144
    //   961: sastore
    //   962: dup
    //   963: bipush 29
    //   965: ldc 145
    //   967: sastore
    //   968: putstatic 96	wns_proxy/GZIP:distance_values	[S
    //   971: bipush 19
    //   973: newarray byte
    //   975: dup
    //   976: iconst_0
    //   977: ldc 17
    //   979: bastore
    //   980: dup
    //   981: iconst_1
    //   982: ldc 108
    //   984: bastore
    //   985: dup
    //   986: iconst_2
    //   987: ldc 28
    //   989: bastore
    //   990: dup
    //   991: iconst_3
    //   992: ldc 11
    //   994: bastore
    //   995: dup
    //   996: iconst_4
    //   997: ldc 22
    //   999: bastore
    //   1000: dup
    //   1001: iconst_5
    //   1002: ldc 102
    //   1004: bastore
    //   1005: dup
    //   1006: bipush 6
    //   1008: ldc 103
    //   1010: bastore
    //   1011: dup
    //   1012: bipush 7
    //   1014: ldc 101
    //   1016: bastore
    //   1017: dup
    //   1018: bipush 8
    //   1020: ldc 104
    //   1022: bastore
    //   1023: dup
    //   1024: bipush 9
    //   1026: ldc 99
    //   1028: bastore
    //   1029: dup
    //   1030: bipush 10
    //   1032: ldc 105
    //   1034: bastore
    //   1035: dup
    //   1036: bipush 11
    //   1038: ldc 19
    //   1040: bastore
    //   1041: dup
    //   1042: bipush 12
    //   1044: ldc 124
    //   1046: bastore
    //   1047: dup
    //   1048: bipush 13
    //   1050: ldc 13
    //   1052: bastore
    //   1053: dup
    //   1054: bipush 14
    //   1056: ldc 106
    //   1058: bastore
    //   1059: dup
    //   1060: bipush 15
    //   1062: ldc 7
    //   1064: bastore
    //   1065: dup
    //   1066: bipush 16
    //   1068: ldc 146
    //   1070: bastore
    //   1071: dup
    //   1072: bipush 17
    //   1074: ldc 9
    //   1076: bastore
    //   1077: dup
    //   1078: bipush 18
    //   1080: ldc 107
    //   1082: bastore
    //   1083: putstatic 88	wns_proxy/GZIP:dynamic_length_order	[B
    //   1086: iconst_1
    //   1087: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   1090: istore_1
    //   1091: iconst_2
    //   1092: invokestatic 62	wns_proxy/GZIP:readBits	(I)I
    //   1095: istore_2
    //   1096: iload_2
    //   1097: ifne +63 -> 1160
    //   1100: invokestatic 149	wns_proxy/GZIP:inflateStored	()V
    //   1103: iload_1
    //   1104: ifeq -18 -> 1086
    //   1107: getstatic 94	wns_proxy/GZIP:uncompressed	[B
    //   1110: astore_0
    //   1111: iconst_0
    //   1112: putstatic 82	wns_proxy/GZIP:uncompressed_index	I
    //   1115: iconst_0
    //   1116: putstatic 84	wns_proxy/GZIP:buffer_bit	I
    //   1119: iconst_0
    //   1120: putstatic 86	wns_proxy/GZIP:buffer_byte	I
    //   1123: iconst_0
    //   1124: putstatic 74	wns_proxy/GZIP:buffer_index	I
    //   1127: aconst_null
    //   1128: putstatic 88	wns_proxy/GZIP:dynamic_length_order	[B
    //   1131: aconst_null
    //   1132: putstatic 90	wns_proxy/GZIP:distance_extra_bits	[B
    //   1135: aconst_null
    //   1136: putstatic 92	wns_proxy/GZIP:length_extra_bits	[B
    //   1139: aconst_null
    //   1140: putstatic 94	wns_proxy/GZIP:uncompressed	[B
    //   1143: aconst_null
    //   1144: putstatic 72	wns_proxy/GZIP:buffer	[B
    //   1147: aconst_null
    //   1148: putstatic 96	wns_proxy/GZIP:distance_values	[S
    //   1151: aconst_null
    //   1152: putstatic 98	wns_proxy/GZIP:length_values	[S
    //   1155: ldc 2
    //   1157: monitorexit
    //   1158: aload_0
    //   1159: areturn
    //   1160: iload_2
    //   1161: iconst_1
    //   1162: if_icmpne +9 -> 1171
    //   1165: invokestatic 152	wns_proxy/GZIP:inflateFixed	()V
    //   1168: goto -65 -> 1103
    //   1171: iload_2
    //   1172: iconst_2
    //   1173: if_icmpne +9 -> 1182
    //   1176: invokestatic 155	wns_proxy/GZIP:inflateDynamic	()V
    //   1179: goto -76 -> 1103
    //   1182: new 66	java/io/IOException
    //   1185: dup
    //   1186: ldc 157
    //   1188: invokespecial 80	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1192	0	paramArrayOfByte	byte[]
    //   0	1192	1	paramInt	int
    //   145	1029	2	i	int
    // Exception table:
    //   from	to	target	type
    //   3	35	45	finally
    //   35	45	45	finally
    //   98	113	45	finally
    //   119	131	45	finally
    //   138	152	45	finally
    //   165	179	45	finally
    //   191	199	45	finally
    //   199	1086	45	finally
    //   1086	1096	45	finally
    //   1100	1103	45	finally
    //   1107	1111	45	finally
    //   1165	1168	45	finally
    //   1176	1179	45	finally
    //   1182	1192	45	finally
    //   46	92	92	finally
    //   1111	1155	92	finally
  }
  
  private static void inflateBlock(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    for (;;)
    {
      int i = readCode(paramArrayOfInt1);
      if (i == 256) {
        break;
      }
      if (i > 256)
      {
        i -= 257;
        j = length_values[i];
        int k = length_extra_bits[i];
        i = j;
        if (k > 0) {
          i = j + readBits(k);
        }
        j = readCode(paramArrayOfInt2);
        k = distance_values[j];
        int m = distance_extra_bits[j];
        j = k;
        if (m > 0) {
          j = k + readBits(m);
        }
        m = uncompressed_index;
        k = 0;
        while (k < i)
        {
          arrayOfByte = uncompressed;
          int n = uncompressed_index;
          uncompressed_index = n + 1;
          arrayOfByte[n] = uncompressed[(m - j + k)];
          k += 1;
        }
      }
      byte[] arrayOfByte = uncompressed;
      int j = uncompressed_index;
      uncompressed_index = j + 1;
      arrayOfByte[j] = ((byte)i);
    }
  }
  
  private static void inflateDynamic()
  {
    int j = readBits(5) + 257;
    int k = readBits(5) + 1;
    int m = readBits(4);
    Object localObject = new byte[19];
    int i = 0;
    while (i < m + 4)
    {
      localObject[dynamic_length_order[i]] = ((byte)readBits(3));
      i += 1;
    }
    localObject = createHuffmanTree((byte[])localObject, 18);
    inflateBlock(createHuffmanTree(decodeCodeLengths((int[])localObject, j), j - 1), createHuffmanTree(decodeCodeLengths((int[])localObject, k), k - 1));
  }
  
  private static void inflateFixed()
  {
    int m = 280;
    int n = 256;
    int i1 = 144;
    int k = 0;
    Object localObject = new byte[288];
    int j = 0;
    for (;;)
    {
      i = i1;
      if (j >= 144) {
        break;
      }
      localObject[j] = 8;
      j += 1;
    }
    for (;;)
    {
      j = n;
      if (i >= 256) {
        break;
      }
      localObject[i] = 9;
      i += 1;
    }
    for (;;)
    {
      i = m;
      if (j >= 280) {
        break;
      }
      localObject[j] = 7;
      j += 1;
    }
    while (i < 288)
    {
      localObject[i] = 8;
      i += 1;
    }
    localObject = createHuffmanTree((byte[])localObject, 287);
    byte[] arrayOfByte = new byte[32];
    int i = k;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = 5;
      i += 1;
    }
    inflateBlock((int[])localObject, createHuffmanTree(arrayOfByte, 31));
  }
  
  private static void inflateStored()
  {
    buffer_bit = 0;
    int i = readBits(16);
    readBits(16);
    System.arraycopy(buffer, buffer_index, uncompressed, uncompressed_index, i);
    buffer_index += i;
    uncompressed_index = i + uncompressed_index;
  }
  
  public static byte[] inflateSyn(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return inflate(paramArrayOfByte, paramInt);
  }
  
  public static DataInputStream openDataInputStream(byte[] paramArrayOfByte)
    throws IOException
  {
    return new DataInputStream(new ByteArrayInputStream(inflate(paramArrayOfByte)));
  }
  
  private static int readBits(int paramInt)
  {
    byte[] arrayOfByte;
    int i;
    if (buffer_bit == 0)
    {
      arrayOfByte = buffer;
      i = buffer_index;
      buffer_index = i + 1;
      i = arrayOfByte[i] & 0xFF;
      buffer_byte = i;
    }
    int j;
    for (;;)
    {
      j = buffer_bit;
      int k = 8 - j;
      j = i;
      i = k;
      while (i < paramInt)
      {
        arrayOfByte = buffer;
        k = buffer_index;
        buffer_index = k + 1;
        buffer_byte = arrayOfByte[k] & 0xFF;
        j |= buffer_byte << i;
        i += 8;
      }
      i = buffer_byte >> buffer_bit;
    }
    buffer_bit = buffer_bit + paramInt & 0x7;
    return (1 << paramInt) - 1 & j;
  }
  
  private static int readCode(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    if (i >= 0)
    {
      if (buffer_bit == 0)
      {
        byte[] arrayOfByte = buffer;
        int j = buffer_index;
        buffer_index = j + 1;
        buffer_byte = arrayOfByte[j] & 0xFF;
      }
      if ((buffer_byte & 1 << buffer_bit) == 0) {}
      for (i = paramArrayOfInt[(i >> 16)];; i = paramArrayOfInt[(i & 0xFFFF)])
      {
        buffer_bit = buffer_bit + 1 & 0x7;
        break;
      }
    }
    return i & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wns_proxy.GZIP
 * JD-Core Version:    0.7.0.1
 */