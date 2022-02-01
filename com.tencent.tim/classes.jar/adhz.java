import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class adhz
{
  private static final FileFilter CPU_FILTER = new adia();
  private static long Tc;
  private static int cGh = -1;
  private static int cGi = -1;
  private static int cGj;
  
  static
  {
    Tc = -1L;
    cGj = -1;
  }
  
  public static int BI()
  {
    if (cGj != -1) {
      return cGj;
    }
    cGh = getNumberOfCPUCores();
    cGi = BK();
    Tc = p(BaseApplicationImpl.getApplication().getApplicationContext());
    if ((cGh >= 8) || ((cGh >= 4) && (cGi > 2355.1999999999998D) && (Tc > 2048L)))
    {
      cGj = 0;
      if ((Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) || (Build.MODEL.equalsIgnoreCase("vivo Y37A")) || (Build.MODEL.equalsIgnoreCase("Nexus 6")) || (Build.MODEL.equalsIgnoreCase("ATH-AL00"))) {
        cGj = 1;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARDeviceInfo", 1, "getDeviceCapability. Build.MODEL = " + Build.MODEL + ", deviceCapability = " + cGj + ", numberOfCPUCores = " + cGh + ", cpuMaxFreqMHz = " + cGi + ", totalMemoryMB = " + Tc);
      return cGj;
      if ((cGh <= 2) || (cGi < 1331.2D) || (Tc <= 1024L)) {
        cGj = 2;
      } else {
        cGj = 1;
      }
    }
  }
  
  private static int BJ()
  {
    return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
  }
  
  /* Error */
  public static int BK()
  {
    // Byte code:
    //   0: getstatic 18	adhz:cGi	I
    //   3: iconst_m1
    //   4: if_icmpeq +7 -> 11
    //   7: getstatic 18	adhz:cGi	I
    //   10: ireturn
    //   11: getstatic 64	android/os/Build:MODEL	Ljava/lang/String;
    //   14: ldc 133
    //   16: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   19: ifeq +13 -> 32
    //   22: sipush 1824
    //   25: putstatic 18	adhz:cGi	I
    //   28: getstatic 18	adhz:cGi	I
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_3
    //   34: iconst_0
    //   35: istore 4
    //   37: iconst_m1
    //   38: istore_0
    //   39: iload_3
    //   40: invokestatic 37	adhz:getNumberOfCPUCores	()I
    //   43: if_icmpge +319 -> 362
    //   46: new 82	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   53: ldc 135
    //   55: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 137
    //   64: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 5
    //   72: ldc 80
    //   74: iconst_1
    //   75: new 82	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   82: ldc 139
    //   84: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 5
    //   89: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: iload_0
    //   99: istore_2
    //   100: new 120	java/io/File
    //   103: dup
    //   104: aload 5
    //   106: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 5
    //   111: iload_0
    //   112: istore_2
    //   113: aload 5
    //   115: invokevirtual 143	java/io/File:exists	()Z
    //   118: ifeq +229 -> 347
    //   121: iload_0
    //   122: istore_2
    //   123: sipush 128
    //   126: newarray byte
    //   128: astore 6
    //   130: iload_0
    //   131: istore_2
    //   132: new 145	java/io/FileInputStream
    //   135: dup
    //   136: aload 5
    //   138: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 5
    //   143: aload 5
    //   145: aload 6
    //   147: invokevirtual 152	java/io/FileInputStream:read	([B)I
    //   150: pop
    //   151: iconst_0
    //   152: istore_1
    //   153: aload 6
    //   155: iload_1
    //   156: baload
    //   157: invokestatic 158	java/lang/Character:isDigit	(I)Z
    //   160: ifeq +17 -> 177
    //   163: iload_1
    //   164: aload 6
    //   166: arraylength
    //   167: if_icmpge +10 -> 177
    //   170: iload_1
    //   171: iconst_1
    //   172: iadd
    //   173: istore_1
    //   174: goto -21 -> 153
    //   177: new 68	java/lang/String
    //   180: dup
    //   181: aload 6
    //   183: iconst_0
    //   184: iload_1
    //   185: invokespecial 161	java/lang/String:<init>	([BII)V
    //   188: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: sipush 1000
    //   194: idiv
    //   195: istore_2
    //   196: ldc 80
    //   198: iconst_1
    //   199: new 82	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   206: ldc 169
    //   208: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload_2
    //   212: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_0
    //   222: istore_1
    //   223: iload_2
    //   224: iload_0
    //   225: if_icmple +5 -> 230
    //   228: iload_2
    //   229: istore_1
    //   230: iload_1
    //   231: istore_2
    //   232: aload 5
    //   234: invokevirtual 172	java/io/FileInputStream:close	()V
    //   237: iload_1
    //   238: istore_0
    //   239: iload 4
    //   241: istore_1
    //   242: iload_3
    //   243: iconst_1
    //   244: iadd
    //   245: istore_3
    //   246: iload_1
    //   247: istore 4
    //   249: goto -210 -> 39
    //   252: astore 6
    //   254: ldc 80
    //   256: iconst_1
    //   257: new 82	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   264: ldc 174
    //   266: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 6
    //   271: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   274: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: iload_0
    //   284: istore_2
    //   285: aload 5
    //   287: invokevirtual 172	java/io/FileInputStream:close	()V
    //   290: iconst_1
    //   291: istore_1
    //   292: goto -50 -> 242
    //   295: astore 6
    //   297: iload_0
    //   298: istore_2
    //   299: aload 5
    //   301: invokevirtual 172	java/io/FileInputStream:close	()V
    //   304: iload_0
    //   305: istore_2
    //   306: aload 6
    //   308: athrow
    //   309: astore 5
    //   311: ldc 80
    //   313: iconst_1
    //   314: new 82	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   321: ldc 177
    //   323: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 5
    //   328: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   331: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: iconst_1
    //   341: istore_1
    //   342: iload_2
    //   343: istore_0
    //   344: goto -102 -> 242
    //   347: iload_0
    //   348: istore_2
    //   349: ldc 80
    //   351: iconst_1
    //   352: ldc 179
    //   354: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: iconst_1
    //   358: istore_1
    //   359: goto -117 -> 242
    //   362: iload_0
    //   363: istore_1
    //   364: iload 4
    //   366: ifeq +117 -> 483
    //   369: invokestatic 182	adhz:BL	()I
    //   372: istore_1
    //   373: ldc 80
    //   375: iconst_1
    //   376: new 82	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   383: ldc 184
    //   385: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload_1
    //   389: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: iload_1
    //   399: istore_2
    //   400: iload_0
    //   401: istore_3
    //   402: iload_1
    //   403: iconst_m1
    //   404: if_icmpne +169 -> 573
    //   407: iload_1
    //   408: istore_2
    //   409: new 145	java/io/FileInputStream
    //   412: dup
    //   413: ldc 186
    //   415: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   418: astore 6
    //   420: ldc 189
    //   422: aload 6
    //   424: invokestatic 193	adhz:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   427: istore_2
    //   428: iload_2
    //   429: istore_1
    //   430: iload_1
    //   431: istore_2
    //   432: ldc 80
    //   434: iconst_1
    //   435: new 82	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   442: ldc 195
    //   444: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: iload_1
    //   448: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: iload_0
    //   458: istore_2
    //   459: iload_1
    //   460: iload_0
    //   461: if_icmple +5 -> 466
    //   464: iload_1
    //   465: istore_2
    //   466: iload_1
    //   467: istore 4
    //   469: iload_2
    //   470: istore_3
    //   471: aload 6
    //   473: invokevirtual 172	java/io/FileInputStream:close	()V
    //   476: iload_2
    //   477: istore_0
    //   478: iload_1
    //   479: iload_0
    //   480: if_icmple +131 -> 611
    //   483: iload_1
    //   484: putstatic 18	adhz:cGi	I
    //   487: iload_1
    //   488: ireturn
    //   489: astore 5
    //   491: iload_1
    //   492: istore_2
    //   493: ldc 80
    //   495: iconst_1
    //   496: new 82	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   503: ldc 197
    //   505: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 5
    //   510: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   513: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: iload_1
    //   523: istore 4
    //   525: iload_0
    //   526: istore_3
    //   527: aload 6
    //   529: invokevirtual 172	java/io/FileInputStream:close	()V
    //   532: goto -54 -> 478
    //   535: astore 5
    //   537: iload 4
    //   539: istore_2
    //   540: iload_3
    //   541: istore_0
    //   542: ldc 80
    //   544: iconst_1
    //   545: new 82	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   552: ldc 199
    //   554: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload 5
    //   559: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   562: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iload_0
    //   572: istore_3
    //   573: iload_3
    //   574: istore_0
    //   575: iload_2
    //   576: istore_1
    //   577: goto -99 -> 478
    //   580: astore 5
    //   582: iload_1
    //   583: istore_2
    //   584: aload 6
    //   586: invokevirtual 172	java/io/FileInputStream:close	()V
    //   589: iload_1
    //   590: istore_2
    //   591: aload 5
    //   593: athrow
    //   594: astore 5
    //   596: goto -54 -> 542
    //   599: astore 5
    //   601: iload_2
    //   602: istore_1
    //   603: goto -21 -> 582
    //   606: astore 5
    //   608: goto -117 -> 491
    //   611: iload_0
    //   612: istore_1
    //   613: goto -130 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	574	0	i	int
    //   152	461	1	j	int
    //   99	503	2	k	int
    //   33	541	3	m	int
    //   35	503	4	n	int
    //   70	230	5	localObject1	Object
    //   309	18	5	localException1	java.lang.Exception
    //   489	20	5	localException2	java.lang.Exception
    //   535	23	5	localException3	java.lang.Exception
    //   580	12	5	localObject2	Object
    //   594	1	5	localException4	java.lang.Exception
    //   599	1	5	localObject3	Object
    //   606	1	5	localException5	java.lang.Exception
    //   128	54	6	arrayOfByte	byte[]
    //   252	18	6	localException6	java.lang.Exception
    //   295	12	6	localObject4	Object
    //   418	167	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   143	151	252	java/lang/Exception
    //   153	170	252	java/lang/Exception
    //   177	221	252	java/lang/Exception
    //   143	151	295	finally
    //   153	170	295	finally
    //   177	221	295	finally
    //   254	283	295	finally
    //   100	111	309	java/lang/Exception
    //   113	121	309	java/lang/Exception
    //   123	130	309	java/lang/Exception
    //   132	143	309	java/lang/Exception
    //   232	237	309	java/lang/Exception
    //   285	290	309	java/lang/Exception
    //   299	304	309	java/lang/Exception
    //   306	309	309	java/lang/Exception
    //   349	357	309	java/lang/Exception
    //   420	428	489	java/lang/Exception
    //   471	476	535	java/lang/Exception
    //   527	532	535	java/lang/Exception
    //   420	428	580	finally
    //   409	420	594	java/lang/Exception
    //   584	589	594	java/lang/Exception
    //   591	594	594	java/lang/Exception
    //   432	457	599	finally
    //   493	522	599	finally
    //   432	457	606	java/lang/Exception
  }
  
  /* Error */
  private static int BL()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_m1
    //   4: istore_1
    //   5: new 203	java/io/BufferedReader
    //   8: dup
    //   9: new 205	java/io/FileReader
    //   12: dup
    //   13: ldc 207
    //   15: invokespecial 208	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: iload_1
    //   24: istore_0
    //   25: aload 4
    //   27: ifnull +138 -> 165
    //   30: aload 4
    //   32: astore_2
    //   33: aload 4
    //   35: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +287 -> 327
    //   43: aload 4
    //   45: astore_2
    //   46: ldc 80
    //   48: iconst_1
    //   49: new 82	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   56: ldc 216
    //   58: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_3
    //   62: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aload 4
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 6
    //   81: aload_3
    //   82: astore 5
    //   84: aload 6
    //   86: astore_3
    //   87: goto -48 -> 39
    //   90: iload_0
    //   91: iconst_m1
    //   92: if_icmpeq +103 -> 195
    //   95: aload 4
    //   97: astore_2
    //   98: aload 5
    //   100: iconst_0
    //   101: iload_0
    //   102: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   105: astore_3
    //   106: aload_3
    //   107: ifnull +215 -> 322
    //   110: aload 4
    //   112: astore_2
    //   113: aload_3
    //   114: invokevirtual 223	java/lang/String:length	()I
    //   117: ifle +205 -> 322
    //   120: aload 4
    //   122: astore_2
    //   123: aload_3
    //   124: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   127: sipush 1000
    //   130: idiv
    //   131: istore_0
    //   132: aload 4
    //   134: astore_2
    //   135: ldc 80
    //   137: iconst_1
    //   138: new 82	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   145: ldc 225
    //   147: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_0
    //   151: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: iload_0
    //   161: iconst_m1
    //   162: if_icmple +160 -> 322
    //   165: iload_0
    //   166: istore_1
    //   167: aload 4
    //   169: ifnull +10 -> 179
    //   172: aload 4
    //   174: invokevirtual 226	java/io/BufferedReader:close	()V
    //   177: iload_0
    //   178: istore_1
    //   179: iload_1
    //   180: ireturn
    //   181: aload 4
    //   183: astore_2
    //   184: aload 5
    //   186: bipush 9
    //   188: invokevirtual 230	java/lang/String:indexOf	(I)I
    //   191: istore_0
    //   192: goto -102 -> 90
    //   195: aload 4
    //   197: astore_2
    //   198: ldc 80
    //   200: iconst_1
    //   201: new 82	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   208: ldc 232
    //   210: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_0
    //   214: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload_1
    //   224: istore_0
    //   225: goto -60 -> 165
    //   228: astore_2
    //   229: aload 4
    //   231: astore_3
    //   232: aload_2
    //   233: astore 4
    //   235: aload_3
    //   236: astore_2
    //   237: ldc 80
    //   239: iconst_1
    //   240: new 82	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   247: ldc 234
    //   249: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 4
    //   254: invokevirtual 175	java/lang/Exception:toString	()Ljava/lang/String;
    //   257: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_3
    //   267: ifnull -88 -> 179
    //   270: aload_3
    //   271: invokevirtual 226	java/io/BufferedReader:close	()V
    //   274: iconst_m1
    //   275: ireturn
    //   276: astore_2
    //   277: aload_2
    //   278: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   281: iconst_m1
    //   282: ireturn
    //   283: astore_2
    //   284: aload_2
    //   285: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   288: iload_0
    //   289: ireturn
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 226	java/io/BufferedReader:close	()V
    //   301: aload_3
    //   302: athrow
    //   303: astore_2
    //   304: aload_2
    //   305: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   308: goto -7 -> 301
    //   311: astore_3
    //   312: goto -19 -> 293
    //   315: astore 4
    //   317: aconst_null
    //   318: astore_3
    //   319: goto -84 -> 235
    //   322: iconst_m1
    //   323: istore_0
    //   324: goto -159 -> 165
    //   327: aload 5
    //   329: ifnonnull -148 -> 181
    //   332: iconst_m1
    //   333: istore_0
    //   334: goto -244 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	310	0	i	int
    //   4	220	1	j	int
    //   32	166	2	localObject1	Object
    //   228	5	2	localException1	java.lang.Exception
    //   236	1	2	localObject2	Object
    //   276	2	2	localIOException1	IOException
    //   283	2	2	localIOException2	IOException
    //   292	6	2	localObject3	Object
    //   303	2	2	localIOException3	IOException
    //   38	233	3	localObject4	Object
    //   290	12	3	localObject5	Object
    //   311	1	3	localObject6	Object
    //   318	1	3	localObject7	Object
    //   21	232	4	localObject8	Object
    //   315	1	4	localException2	java.lang.Exception
    //   1	327	5	localObject9	Object
    //   79	6	6	str	String
    // Exception table:
    //   from	to	target	type
    //   33	39	228	java/lang/Exception
    //   46	71	228	java/lang/Exception
    //   74	81	228	java/lang/Exception
    //   98	106	228	java/lang/Exception
    //   113	120	228	java/lang/Exception
    //   123	132	228	java/lang/Exception
    //   135	160	228	java/lang/Exception
    //   184	192	228	java/lang/Exception
    //   198	223	228	java/lang/Exception
    //   270	274	276	java/io/IOException
    //   172	177	283	java/io/IOException
    //   5	23	290	finally
    //   297	301	303	java/io/IOException
    //   33	39	311	finally
    //   46	71	311	finally
    //   74	81	311	finally
    //   98	106	311	finally
    //   113	120	311	finally
    //   123	132	311	finally
    //   135	160	311	finally
    //   184	192	311	finally
    //   198	223	311	finally
    //   237	266	311	finally
    //   5	23	315	java/lang/Exception
  }
  
  private static int extractValue(byte[] paramArrayOfByte, int paramInt)
  {
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if (Character.isDigit(paramArrayOfByte[paramInt]))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (Character.isDigit(paramArrayOfByte[i]))) {
          i += 1;
        }
        return Integer.parseInt(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
      }
      paramInt += 1;
    }
    return -1;
  }
  
  /* Error */
  private static int getCoresFromFileInfo(String paramString)
  {
    // Byte code:
    //   0: new 145	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 203	java/io/BufferedReader
    //   12: dup
    //   13: new 245	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 248	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: invokevirtual 226	java/io/BufferedReader:close	()V
    //   35: aload 4
    //   37: invokestatic 251	adhz:getCoresFromFileString	(Ljava/lang/String;)I
    //   40: istore_1
    //   41: iload_1
    //   42: istore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 254	java/io/InputStream:close	()V
    //   51: iload_1
    //   52: istore_2
    //   53: iload_2
    //   54: ireturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: iconst_m1
    //   59: istore_2
    //   60: aload_0
    //   61: ifnull -8 -> 53
    //   64: aload_0
    //   65: invokevirtual 254	java/io/InputStream:close	()V
    //   68: iconst_m1
    //   69: ireturn
    //   70: astore_0
    //   71: iconst_m1
    //   72: ireturn
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 254	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: athrow
    //   86: astore_0
    //   87: iload_1
    //   88: ireturn
    //   89: astore_0
    //   90: goto -6 -> 84
    //   93: astore_3
    //   94: goto -18 -> 76
    //   97: astore_3
    //   98: goto -40 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   40	48	1	i	int
    //   42	18	2	j	int
    //   24	8	3	localBufferedReader	java.io.BufferedReader
    //   73	12	3	localObject1	Object
    //   93	1	3	localObject2	Object
    //   97	1	3	localIOException	IOException
    //   29	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	9	55	java/io/IOException
    //   64	68	70	java/io/IOException
    //   0	9	73	finally
    //   47	51	86	java/io/IOException
    //   80	84	89	java/io/IOException
    //   9	41	93	finally
    //   9	41	97	java/io/IOException
  }
  
  static int getCoresFromFileString(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$"))) {
      return -1;
    }
    return Integer.valueOf(paramString.substring(2)).intValue() + 1;
  }
  
  public static int getNumberOfCPUCores()
  {
    if (cGh != -1) {
      return cGh;
    }
    if (Build.VERSION.SDK_INT <= 10)
    {
      cGh = 1;
      return cGh;
    }
    try
    {
      i = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
      int j = i;
      if (i == -1) {
        j = getCoresFromFileInfo("/sys/devices/system/cpu/present");
      }
      i = j;
      if (j == -1) {
        i = BJ();
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    cGh = i;
    return i;
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long p(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 22	adhz:Tc	J
    //   3: ldc2_w 19
    //   6: lcmp
    //   7: ifeq +7 -> 14
    //   10: getstatic 22	adhz:Tc	J
    //   13: lreturn
    //   14: getstatic 278	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 16
    //   19: if_icmplt +43 -> 62
    //   22: new 291	android/app/ActivityManager$MemoryInfo
    //   25: dup
    //   26: invokespecial 292	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   29: astore 4
    //   31: aload_0
    //   32: ldc_w 294
    //   35: invokevirtual 300	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast 302	android/app/ActivityManager
    //   41: aload 4
    //   43: invokevirtual 306	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   46: aload 4
    //   48: getfield 309	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   51: ldc2_w 310
    //   54: ldiv
    //   55: putstatic 22	adhz:Tc	J
    //   58: getstatic 22	adhz:Tc	J
    //   61: lreturn
    //   62: new 145	java/io/FileInputStream
    //   65: dup
    //   66: ldc_w 313
    //   69: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   72: astore_0
    //   73: ldc_w 315
    //   76: aload_0
    //   77: invokestatic 193	adhz:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   80: istore_1
    //   81: iload_1
    //   82: i2l
    //   83: lstore_2
    //   84: aload_0
    //   85: invokevirtual 172	java/io/FileInputStream:close	()V
    //   88: lload_2
    //   89: ldc2_w 116
    //   92: ldiv
    //   93: putstatic 22	adhz:Tc	J
    //   96: getstatic 22	adhz:Tc	J
    //   99: lreturn
    //   100: astore 4
    //   102: aload_0
    //   103: invokevirtual 172	java/io/FileInputStream:close	()V
    //   106: aload 4
    //   108: athrow
    //   109: astore_0
    //   110: ldc2_w 19
    //   113: lstore_2
    //   114: goto -26 -> 88
    //   117: astore_0
    //   118: goto -30 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	android.content.Context
    //   80	2	1	i	int
    //   83	31	2	l	long
    //   29	18	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   100	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   73	81	100	finally
    //   62	73	109	java/io/IOException
    //   102	109	109	java/io/IOException
    //   84	88	117	java/io/IOException
  }
  
  private static int parseFileForValue(String paramString, FileInputStream paramFileInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    int m;
    int j;
    int i;
    int k;
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      k = i;
      if (j >= m) {
        break label129;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        break label129;
      }
      if (k == paramString.length() - 1)
      {
        i = extractValue(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    for (;;)
    {
      if (j < m)
      {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
          break;
        }
        label129:
        j = k + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhz
 * JD-Core Version:    0.7.0.1
 */