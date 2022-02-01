import java.util.Map;
import java.util.jar.Attributes;

public class aszp
{
  public static String F(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp6_5 = arrayOfChar1;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 97;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 98;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 99;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 100;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 101;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 102;
    tmp90_84;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4 & 0xF)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 13
    //   18: aconst_null
    //   19: astore 12
    //   21: aconst_null
    //   22: astore 11
    //   24: iconst_0
    //   25: istore_3
    //   26: new 39	java/util/jar/JarFile
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 42	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: aload 11
    //   38: astore 7
    //   40: aload 10
    //   42: astore_0
    //   43: aload 6
    //   45: astore 5
    //   47: aload 13
    //   49: astore 8
    //   51: aload 12
    //   53: astore 9
    //   55: aload 6
    //   57: aload_1
    //   58: invokevirtual 46	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnonnull +36 -> 99
    //   66: iconst_2
    //   67: istore 4
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 48	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 51	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: iload 4
    //   83: istore_3
    //   84: aload 6
    //   86: ifnull +11 -> 97
    //   89: aload 6
    //   91: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   94: iload 4
    //   96: istore_3
    //   97: iload_3
    //   98: ireturn
    //   99: aload 11
    //   101: astore 7
    //   103: aload 10
    //   105: astore_0
    //   106: aload 6
    //   108: astore 5
    //   110: aload 13
    //   112: astore 8
    //   114: aload 12
    //   116: astore 9
    //   118: aload 6
    //   120: aload_1
    //   121: invokevirtual 58	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   124: astore_1
    //   125: aload_1
    //   126: astore 7
    //   128: aload_1
    //   129: astore_0
    //   130: aload 6
    //   132: astore 5
    //   134: aload_1
    //   135: astore 8
    //   137: aload_1
    //   138: astore 9
    //   140: ldc 60
    //   142: invokestatic 66	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   145: astore 11
    //   147: aload_1
    //   148: astore 7
    //   150: aload_1
    //   151: astore_0
    //   152: aload 6
    //   154: astore 5
    //   156: aload_1
    //   157: astore 8
    //   159: aload_1
    //   160: astore 9
    //   162: sipush 8192
    //   165: newarray byte
    //   167: astore 10
    //   169: aload_1
    //   170: astore 7
    //   172: aload_1
    //   173: astore_0
    //   174: aload 6
    //   176: astore 5
    //   178: aload_1
    //   179: astore 8
    //   181: aload_1
    //   182: astore 9
    //   184: aload_1
    //   185: aload 10
    //   187: invokevirtual 72	java/io/InputStream:read	([B)I
    //   190: istore 4
    //   192: iload 4
    //   194: iconst_m1
    //   195: if_icmpeq +70 -> 265
    //   198: aload_1
    //   199: astore 7
    //   201: aload_1
    //   202: astore_0
    //   203: aload 6
    //   205: astore 5
    //   207: aload_1
    //   208: astore 8
    //   210: aload_1
    //   211: astore 9
    //   213: aload 11
    //   215: aload 10
    //   217: iconst_0
    //   218: iload 4
    //   220: invokevirtual 76	java/security/MessageDigest:update	([BII)V
    //   223: goto -54 -> 169
    //   226: astore_1
    //   227: aload 7
    //   229: astore_0
    //   230: aload 6
    //   232: astore 5
    //   234: aload_1
    //   235: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   238: iconst_3
    //   239: istore_3
    //   240: aload 7
    //   242: ifnull +8 -> 250
    //   245: aload 7
    //   247: invokevirtual 80	java/io/InputStream:close	()V
    //   250: aload 6
    //   252: ifnull -155 -> 97
    //   255: aload 6
    //   257: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   260: iconst_3
    //   261: ireturn
    //   262: astore_0
    //   263: iconst_3
    //   264: ireturn
    //   265: aload_1
    //   266: astore 7
    //   268: aload_1
    //   269: astore_0
    //   270: aload 6
    //   272: astore 5
    //   274: aload_1
    //   275: astore 8
    //   277: aload_1
    //   278: astore 9
    //   280: aload 11
    //   282: invokevirtual 84	java/security/MessageDigest:digest	()[B
    //   285: astore 10
    //   287: aload_1
    //   288: astore 7
    //   290: aload_1
    //   291: astore_0
    //   292: aload 6
    //   294: astore 5
    //   296: aload_1
    //   297: astore 8
    //   299: aload_1
    //   300: astore 9
    //   302: aload 10
    //   304: iconst_0
    //   305: aload_2
    //   306: iconst_0
    //   307: aload 10
    //   309: arraylength
    //   310: invokestatic 90	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 80	java/io/InputStream:close	()V
    //   321: aload 6
    //   323: ifnull -226 -> 97
    //   326: aload 6
    //   328: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: iconst_0
    //   335: ireturn
    //   336: astore_1
    //   337: aconst_null
    //   338: astore 6
    //   340: aload 9
    //   342: astore_0
    //   343: aload 6
    //   345: astore 5
    //   347: aload_1
    //   348: invokevirtual 91	java/lang/OutOfMemoryError:printStackTrace	()V
    //   351: sipush 144
    //   354: istore_3
    //   355: aload 9
    //   357: ifnull +8 -> 365
    //   360: aload 9
    //   362: invokevirtual 80	java/io/InputStream:close	()V
    //   365: aload 6
    //   367: ifnull -270 -> 97
    //   370: aload 6
    //   372: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   375: sipush 144
    //   378: ireturn
    //   379: astore_0
    //   380: sipush 144
    //   383: ireturn
    //   384: astore_1
    //   385: aconst_null
    //   386: astore 6
    //   388: aload 8
    //   390: astore_0
    //   391: aload 6
    //   393: astore 5
    //   395: aload_1
    //   396: invokevirtual 92	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   399: sipush 139
    //   402: istore_3
    //   403: aload 8
    //   405: ifnull +8 -> 413
    //   408: aload 8
    //   410: invokevirtual 80	java/io/InputStream:close	()V
    //   413: aload 6
    //   415: ifnull -318 -> 97
    //   418: aload 6
    //   420: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   423: sipush 139
    //   426: ireturn
    //   427: astore_0
    //   428: sipush 139
    //   431: ireturn
    //   432: astore_1
    //   433: aconst_null
    //   434: astore 5
    //   436: aload 7
    //   438: astore_0
    //   439: aload_0
    //   440: ifnull +7 -> 447
    //   443: aload_0
    //   444: invokevirtual 80	java/io/InputStream:close	()V
    //   447: aload 5
    //   449: ifnull +8 -> 457
    //   452: aload 5
    //   454: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   457: aload_1
    //   458: athrow
    //   459: astore_0
    //   460: goto -379 -> 81
    //   463: astore_0
    //   464: iconst_2
    //   465: ireturn
    //   466: astore_0
    //   467: goto -146 -> 321
    //   470: astore_0
    //   471: goto -221 -> 250
    //   474: astore_0
    //   475: goto -110 -> 365
    //   478: astore_0
    //   479: goto -66 -> 413
    //   482: astore_0
    //   483: goto -36 -> 447
    //   486: astore_0
    //   487: goto -30 -> 457
    //   490: astore_1
    //   491: goto -52 -> 439
    //   494: astore_1
    //   495: goto -107 -> 388
    //   498: astore_1
    //   499: goto -159 -> 340
    //   502: astore_1
    //   503: aconst_null
    //   504: astore 6
    //   506: aload 5
    //   508: astore 7
    //   510: goto -283 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramString1	String
    //   0	513	1	paramString2	String
    //   0	513	2	paramArrayOfByte	byte[]
    //   25	378	3	i	int
    //   67	152	4	j	int
    //   1	506	5	localObject1	Object
    //   34	471	6	localJarFile	java.util.jar.JarFile
    //   10	499	7	localObject2	Object
    //   7	402	8	localObject3	Object
    //   4	357	9	localObject4	Object
    //   13	295	10	arrayOfByte	byte[]
    //   22	259	11	localMessageDigest	java.security.MessageDigest
    //   19	96	12	localObject5	Object
    //   16	95	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	226	java/io/IOException
    //   118	125	226	java/io/IOException
    //   140	147	226	java/io/IOException
    //   162	169	226	java/io/IOException
    //   184	192	226	java/io/IOException
    //   213	223	226	java/io/IOException
    //   280	287	226	java/io/IOException
    //   302	313	226	java/io/IOException
    //   255	260	262	java/io/IOException
    //   326	331	333	java/io/IOException
    //   26	36	336	java/lang/OutOfMemoryError
    //   370	375	379	java/io/IOException
    //   26	36	384	java/security/NoSuchAlgorithmException
    //   418	423	427	java/io/IOException
    //   26	36	432	finally
    //   73	81	459	java/io/IOException
    //   89	94	463	java/io/IOException
    //   317	321	466	java/io/IOException
    //   245	250	470	java/io/IOException
    //   360	365	474	java/io/IOException
    //   408	413	478	java/io/IOException
    //   443	447	482	java/io/IOException
    //   452	457	486	java/io/IOException
    //   55	62	490	finally
    //   118	125	490	finally
    //   140	147	490	finally
    //   162	169	490	finally
    //   184	192	490	finally
    //   213	223	490	finally
    //   234	238	490	finally
    //   280	287	490	finally
    //   302	313	490	finally
    //   347	351	490	finally
    //   395	399	490	finally
    //   55	62	494	java/security/NoSuchAlgorithmException
    //   118	125	494	java/security/NoSuchAlgorithmException
    //   140	147	494	java/security/NoSuchAlgorithmException
    //   162	169	494	java/security/NoSuchAlgorithmException
    //   184	192	494	java/security/NoSuchAlgorithmException
    //   213	223	494	java/security/NoSuchAlgorithmException
    //   280	287	494	java/security/NoSuchAlgorithmException
    //   302	313	494	java/security/NoSuchAlgorithmException
    //   55	62	498	java/lang/OutOfMemoryError
    //   118	125	498	java/lang/OutOfMemoryError
    //   140	147	498	java/lang/OutOfMemoryError
    //   162	169	498	java/lang/OutOfMemoryError
    //   184	192	498	java/lang/OutOfMemoryError
    //   213	223	498	java/lang/OutOfMemoryError
    //   280	287	498	java/lang/OutOfMemoryError
    //   302	313	498	java/lang/OutOfMemoryError
    //   26	36	502	java/io/IOException
  }
  
  public static int a(Map<String, Attributes> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return 17;
    }
    paramMap = (Attributes)paramMap.get(paramString1);
    if (paramMap == null) {
      return 7;
    }
    if (true == paramString2.equals(paramMap.getValue("SHA1-Digest"))) {
      return 0;
    }
    return 143;
  }
  
  /* Error */
  public static Map<String, Attributes> z(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 39	java/util/jar/JarFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 42	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 119	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +17 -> 36
    //   22: aload_3
    //   23: astore_0
    //   24: aload_1
    //   25: ifnull +9 -> 34
    //   28: aload_1
    //   29: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   32: aload_3
    //   33: astore_0
    //   34: aload_0
    //   35: areturn
    //   36: aload_1
    //   37: astore_0
    //   38: aload_2
    //   39: invokevirtual 125	java/util/jar/Manifest:getEntries	()Ljava/util/Map;
    //   42: astore_2
    //   43: aload_2
    //   44: astore_0
    //   45: aload_1
    //   46: ifnull -12 -> 34
    //   49: aload_1
    //   50: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   53: aload_2
    //   54: areturn
    //   55: astore_0
    //   56: aload_2
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: invokevirtual 91	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_3
    //   68: astore_0
    //   69: aload_1
    //   70: ifnull -36 -> 34
    //   73: aload_1
    //   74: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 79	java/io/IOException:printStackTrace	()V
    //   91: aload_3
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull -60 -> 34
    //   97: aload_1
    //   98: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 54	java/util/jar/JarFile:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: goto -6 -> 117
    //   126: astore_1
    //   127: goto -18 -> 109
    //   130: astore_2
    //   131: goto -46 -> 85
    //   134: astore_2
    //   135: goto -74 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   10	88	1	localJarFile	java.util.jar.JarFile
    //   106	12	1	localObject1	Object
    //   126	1	1	localObject2	Object
    //   17	40	2	localObject3	Object
    //   58	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   82	6	2	localIOException1	java.io.IOException
    //   130	1	2	localIOException2	java.io.IOException
    //   134	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	91	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   2	11	58	java/lang/OutOfMemoryError
    //   73	77	79	java/io/IOException
    //   2	11	82	java/io/IOException
    //   97	101	103	java/io/IOException
    //   2	11	106	finally
    //   28	32	119	java/io/IOException
    //   113	117	122	java/io/IOException
    //   13	18	126	finally
    //   38	43	126	finally
    //   63	67	126	finally
    //   87	91	126	finally
    //   13	18	130	java/io/IOException
    //   38	43	130	java/io/IOException
    //   13	18	134	java/lang/OutOfMemoryError
    //   38	43	134	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszp
 * JD-Core Version:    0.7.0.1
 */