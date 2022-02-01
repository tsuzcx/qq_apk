import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class aqiv
{
  private static long asM = 157286400L;
  
  /* Error */
  public static void C(File paramFile)
  {
    // Byte code:
    //   0: new 19	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 21
    //   7: invokespecial 25	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: aload_2
    //   14: invokevirtual 29	java/io/RandomAccessFile:readByte	()B
    //   17: istore_1
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: lconst_0
    //   22: invokevirtual 33	java/io/RandomAccessFile:seek	(J)V
    //   25: aload_2
    //   26: astore_0
    //   27: aload_2
    //   28: iload_1
    //   29: invokevirtual 37	java/io/RandomAccessFile:write	(I)V
    //   32: aload_2
    //   33: ifnull +7 -> 40
    //   36: aload_2
    //   37: invokevirtual 40	java/io/RandomAccessFile:close	()V
    //   40: return
    //   41: astore_3
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: aload_3
    //   47: invokevirtual 43	java/io/IOException:printStackTrace	()V
    //   50: aload_2
    //   51: ifnull -11 -> 40
    //   54: aload_2
    //   55: invokevirtual 40	java/io/RandomAccessFile:close	()V
    //   58: return
    //   59: astore_0
    //   60: return
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 40	java/io/RandomAccessFile:close	()V
    //   72: aload_2
    //   73: athrow
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: goto -5 -> 72
    //   80: astore_2
    //   81: goto -17 -> 64
    //   84: astore_3
    //   85: goto -41 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	File
    //   17	12	1	i	int
    //   10	45	2	localRandomAccessFile	java.io.RandomAccessFile
    //   61	12	2	localObject1	Object
    //   80	1	2	localObject2	Object
    //   41	6	3	localIOException1	java.io.IOException
    //   84	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	11	41	java/io/IOException
    //   54	58	59	java/io/IOException
    //   0	11	61	finally
    //   36	40	74	java/io/IOException
    //   68	72	76	java/io/IOException
    //   13	18	80	finally
    //   20	25	80	finally
    //   27	32	80	finally
    //   46	50	80	finally
    //   13	18	84	java/io/IOException
    //   20	25	84	java/io/IOException
    //   27	32	84	java/io/IOException
  }
  
  private static boolean G(File paramFile)
  {
    if (!paramFile.getName().endsWith(".cfg")) {
      new File(paramFile.getAbsolutePath() + ".cfg").delete();
    }
    return paramFile.delete();
  }
  
  public static void UL(String paramString)
  {
    paramString = new File(acbn.bmv + paramString + ".cfg");
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "delCfgFile");
    }
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  /* Error */
  public static void aM(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 47	java/io/File
    //   5: dup
    //   6: getstatic 87	acbn:bmv	Ljava/lang/String;
    //   9: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 103	java/io/File:exists	()Z
    //   19: ifne +9 -> 28
    //   22: aload 4
    //   24: invokevirtual 112	java/io/File:mkdir	()Z
    //   27: pop
    //   28: new 47	java/io/File
    //   31: dup
    //   32: new 61	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   39: getstatic 87	acbn:bmv	Ljava/lang/String;
    //   42: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 53
    //   51: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 103	java/io/File:exists	()Z
    //   65: ifne +8 -> 73
    //   68: aload_0
    //   69: invokevirtual 115	java/io/File:createNewFile	()Z
    //   72: pop
    //   73: new 117	java/io/FileOutputStream
    //   76: dup
    //   77: aload_0
    //   78: iconst_0
    //   79: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   82: astore_0
    //   83: aload_0
    //   84: astore_3
    //   85: new 61	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   92: ldc 122
    //   94: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_1
    //   98: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 127
    //   103: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 4
    //   115: aload_0
    //   116: astore_3
    //   117: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +31 -> 151
    //   123: aload_0
    //   124: astore_3
    //   125: ldc 94
    //   127: iconst_2
    //   128: new 61	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   135: ldc 129
    //   137: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 4
    //   142: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: astore_3
    //   153: aload_0
    //   154: aload 4
    //   156: invokevirtual 133	java/lang/String:getBytes	()[B
    //   159: invokevirtual 138	java/io/OutputStream:write	([B)V
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 139	java/io/OutputStream:close	()V
    //   170: return
    //   171: astore_0
    //   172: ldc 94
    //   174: iconst_1
    //   175: new 61	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   182: ldc 141
    //   184: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload_0
    //   198: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   201: return
    //   202: astore 4
    //   204: aload_3
    //   205: astore_0
    //   206: aload 4
    //   208: astore_3
    //   209: ldc 94
    //   211: iconst_1
    //   212: new 61	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   219: ldc 150
    //   221: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 151	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   228: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aload_3
    //   235: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload_0
    //   239: ifnull -69 -> 170
    //   242: aload_0
    //   243: invokevirtual 139	java/io/OutputStream:close	()V
    //   246: return
    //   247: astore_0
    //   248: ldc 94
    //   250: iconst_1
    //   251: new 61	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   258: ldc 141
    //   260: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   267: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload_0
    //   274: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: return
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_0
    //   282: aload_0
    //   283: astore_3
    //   284: ldc 94
    //   286: iconst_1
    //   287: new 61	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   294: ldc 141
    //   296: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 4
    //   301: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: aload 4
    //   312: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_0
    //   316: ifnull -146 -> 170
    //   319: aload_0
    //   320: invokevirtual 139	java/io/OutputStream:close	()V
    //   323: return
    //   324: astore_0
    //   325: ldc 94
    //   327: iconst_1
    //   328: new 61	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   335: ldc 141
    //   337: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: aload_0
    //   351: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: return
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_3
    //   358: aload_3
    //   359: ifnull +7 -> 366
    //   362: aload_3
    //   363: invokevirtual 139	java/io/OutputStream:close	()V
    //   366: aload_0
    //   367: athrow
    //   368: astore_3
    //   369: ldc 94
    //   371: iconst_1
    //   372: new 61	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   379: ldc 141
    //   381: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_3
    //   385: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aload_3
    //   395: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   398: goto -32 -> 366
    //   401: astore_0
    //   402: goto -44 -> 358
    //   405: astore 4
    //   407: aload_0
    //   408: astore_3
    //   409: aload 4
    //   411: astore_0
    //   412: goto -54 -> 358
    //   415: astore 4
    //   417: goto -135 -> 282
    //   420: astore_3
    //   421: goto -212 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramString	String
    //   0	424	1	paramInt1	int
    //   0	424	2	paramInt2	int
    //   1	362	3	localObject1	Object
    //   368	27	3	localException	Exception
    //   408	1	3	str	String
    //   420	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   12	143	4	localObject2	Object
    //   202	5	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   278	33	4	localIOException1	java.io.IOException
    //   405	5	4	localObject3	Object
    //   415	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   166	170	171	java/lang/Exception
    //   2	28	202	java/io/FileNotFoundException
    //   28	73	202	java/io/FileNotFoundException
    //   73	83	202	java/io/FileNotFoundException
    //   242	246	247	java/lang/Exception
    //   2	28	278	java/io/IOException
    //   28	73	278	java/io/IOException
    //   73	83	278	java/io/IOException
    //   319	323	324	java/lang/Exception
    //   2	28	355	finally
    //   28	73	355	finally
    //   73	83	355	finally
    //   362	366	368	java/lang/Exception
    //   85	115	401	finally
    //   117	123	401	finally
    //   125	151	401	finally
    //   153	162	401	finally
    //   284	315	401	finally
    //   209	238	405	finally
    //   85	115	415	java/io/IOException
    //   117	123	415	java/io/IOException
    //   125	151	415	java/io/IOException
    //   153	162	415	java/io/IOException
    //   85	115	420	java/io/FileNotFoundException
    //   117	123	420	java/io/FileNotFoundException
    //   125	151	420	java/io/FileNotFoundException
    //   153	162	420	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean d(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 47	java/io/File
    //   6: dup
    //   7: new 61	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   14: getstatic 87	acbn:bmv	Ljava/lang/String;
    //   17: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 53
    //   26: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 8
    //   37: aload 8
    //   39: invokevirtual 103	java/io/File:exists	()Z
    //   42: ifne +5 -> 47
    //   45: iconst_1
    //   46: ireturn
    //   47: new 155	java/io/FileInputStream
    //   50: dup
    //   51: aload 8
    //   53: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_0
    //   57: sipush 4096
    //   60: newarray byte
    //   62: astore 7
    //   64: new 159	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 160	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: astore 6
    //   77: aload_0
    //   78: astore 5
    //   80: aload_0
    //   81: aload 7
    //   83: invokevirtual 166	java/io/InputStream:read	([B)I
    //   86: istore_2
    //   87: iload_2
    //   88: iconst_m1
    //   89: if_icmpeq +82 -> 171
    //   92: aload 4
    //   94: astore 6
    //   96: aload_0
    //   97: astore 5
    //   99: aload 4
    //   101: aload 7
    //   103: iconst_0
    //   104: iload_2
    //   105: invokevirtual 169	java/io/ByteArrayOutputStream:write	([BII)V
    //   108: goto -35 -> 73
    //   111: astore 5
    //   113: aload_0
    //   114: astore_1
    //   115: aload 4
    //   117: astore_0
    //   118: aload 5
    //   120: astore 4
    //   122: ldc 94
    //   124: iconst_1
    //   125: new 61	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   132: ldc 171
    //   134: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 151	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload 4
    //   150: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 173	java/io/InputStream:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 4
    //   173: astore 6
    //   175: aload_0
    //   176: astore 5
    //   178: aload 4
    //   180: invokevirtual 174	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   183: ldc 176
    //   185: invokevirtual 180	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   188: astore 7
    //   190: aload 7
    //   192: ifnull +17 -> 209
    //   195: aload 4
    //   197: astore 6
    //   199: aload_0
    //   200: astore 5
    //   202: aload 7
    //   204: arraylength
    //   205: iconst_4
    //   206: if_icmpge +125 -> 331
    //   209: aload 4
    //   211: astore 6
    //   213: aload_0
    //   214: astore 5
    //   216: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +18 -> 237
    //   222: aload 4
    //   224: astore 6
    //   226: aload_0
    //   227: astore 5
    //   229: ldc 94
    //   231: iconst_2
    //   232: ldc 182
    //   234: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: iconst_0
    //   239: iconst_0
    //   240: iastore
    //   241: aload_1
    //   242: iconst_1
    //   243: iconst_0
    //   244: iastore
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   255: aload_0
    //   256: ifnull +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 173	java/io/InputStream:close	()V
    //   263: iconst_0
    //   264: ireturn
    //   265: astore_1
    //   266: ldc 94
    //   268: iconst_1
    //   269: new 61	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   276: ldc 184
    //   278: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: aload_1
    //   292: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: goto -40 -> 255
    //   298: astore_0
    //   299: ldc 94
    //   301: iconst_1
    //   302: new 61	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   309: ldc 184
    //   311: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_0
    //   315: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload_0
    //   325: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   328: goto -65 -> 263
    //   331: aload 4
    //   333: astore 6
    //   335: aload_0
    //   336: astore 5
    //   338: aload 7
    //   340: iconst_1
    //   341: aaload
    //   342: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   345: istore_2
    //   346: aload 4
    //   348: astore 6
    //   350: aload_0
    //   351: astore 5
    //   353: aload 7
    //   355: iconst_3
    //   356: aaload
    //   357: invokestatic 190	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   360: istore_3
    //   361: iload_2
    //   362: iload_3
    //   363: if_icmpne +88 -> 451
    //   366: aload 4
    //   368: ifnull +8 -> 376
    //   371: aload 4
    //   373: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   376: aload_0
    //   377: ifnull -332 -> 45
    //   380: aload_0
    //   381: invokevirtual 173	java/io/InputStream:close	()V
    //   384: iconst_1
    //   385: ireturn
    //   386: astore_0
    //   387: ldc 94
    //   389: iconst_1
    //   390: new 61	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   397: ldc 184
    //   399: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_0
    //   403: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   406: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: aload_0
    //   413: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: iconst_1
    //   417: ireturn
    //   418: astore_1
    //   419: ldc 94
    //   421: iconst_1
    //   422: new 61	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   429: ldc 184
    //   431: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   438: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: aload_1
    //   445: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   448: goto -72 -> 376
    //   451: aload_1
    //   452: iconst_0
    //   453: iload_2
    //   454: iastore
    //   455: aload_1
    //   456: iconst_1
    //   457: iload_3
    //   458: iastore
    //   459: aload 4
    //   461: ifnull +8 -> 469
    //   464: aload 4
    //   466: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   469: aload_0
    //   470: ifnull +7 -> 477
    //   473: aload_0
    //   474: invokevirtual 173	java/io/InputStream:close	()V
    //   477: iconst_0
    //   478: ireturn
    //   479: astore_1
    //   480: ldc 94
    //   482: iconst_1
    //   483: new 61	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   490: ldc 184
    //   492: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_1
    //   496: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   499: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: aload_1
    //   506: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: goto -40 -> 469
    //   512: astore_0
    //   513: ldc 94
    //   515: iconst_1
    //   516: new 61	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   523: ldc 184
    //   525: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_0
    //   529: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   532: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: aload_0
    //   539: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   542: goto -65 -> 477
    //   545: astore_0
    //   546: ldc 94
    //   548: iconst_1
    //   549: new 61	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   556: ldc 184
    //   558: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_0
    //   562: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   565: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: aload_0
    //   572: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   575: goto -414 -> 161
    //   578: astore_0
    //   579: ldc 94
    //   581: iconst_1
    //   582: new 61	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   589: ldc 184
    //   591: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_0
    //   595: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   598: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: aload_0
    //   605: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   608: goto -439 -> 169
    //   611: astore 7
    //   613: aconst_null
    //   614: astore_1
    //   615: aconst_null
    //   616: astore_0
    //   617: aload_1
    //   618: astore 6
    //   620: aload_0
    //   621: astore 5
    //   623: ldc 94
    //   625: iconst_1
    //   626: new 61	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   633: ldc 184
    //   635: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 7
    //   640: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   643: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: aload 7
    //   651: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: aload_1
    //   655: astore 6
    //   657: aload_0
    //   658: astore 5
    //   660: aload 8
    //   662: invokevirtual 80	java/io/File:delete	()Z
    //   665: pop
    //   666: aload_1
    //   667: ifnull +7 -> 674
    //   670: aload_1
    //   671: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   674: aload_0
    //   675: ifnull +7 -> 682
    //   678: aload_0
    //   679: invokevirtual 173	java/io/InputStream:close	()V
    //   682: iconst_0
    //   683: ireturn
    //   684: astore_1
    //   685: ldc 94
    //   687: iconst_1
    //   688: new 61	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   695: ldc 184
    //   697: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload_1
    //   701: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   704: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: aload_1
    //   711: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   714: goto -40 -> 674
    //   717: astore_0
    //   718: ldc 94
    //   720: iconst_1
    //   721: new 61	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   728: ldc 184
    //   730: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_0
    //   734: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   737: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: aload_0
    //   744: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   747: goto -65 -> 682
    //   750: astore_1
    //   751: aconst_null
    //   752: astore 4
    //   754: aconst_null
    //   755: astore_0
    //   756: aload 4
    //   758: ifnull +8 -> 766
    //   761: aload 4
    //   763: invokevirtual 172	java/io/ByteArrayOutputStream:close	()V
    //   766: aload_0
    //   767: ifnull +7 -> 774
    //   770: aload_0
    //   771: invokevirtual 173	java/io/InputStream:close	()V
    //   774: aload_1
    //   775: athrow
    //   776: astore 4
    //   778: ldc 94
    //   780: iconst_1
    //   781: new 61	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   788: ldc 184
    //   790: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 4
    //   795: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   798: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: aload 4
    //   806: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   809: goto -43 -> 766
    //   812: astore_0
    //   813: ldc 94
    //   815: iconst_1
    //   816: new 61	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   823: ldc 184
    //   825: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_0
    //   829: invokevirtual 152	java/io/IOException:getMessage	()Ljava/lang/String;
    //   832: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: aload_0
    //   839: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   842: goto -68 -> 774
    //   845: astore_1
    //   846: aconst_null
    //   847: astore 4
    //   849: goto -93 -> 756
    //   852: astore_1
    //   853: aload 6
    //   855: astore 4
    //   857: aload 5
    //   859: astore_0
    //   860: goto -104 -> 756
    //   863: astore 4
    //   865: aload_1
    //   866: astore 5
    //   868: aload 4
    //   870: astore_1
    //   871: aload_0
    //   872: astore 4
    //   874: aload 5
    //   876: astore_0
    //   877: goto -121 -> 756
    //   880: astore 7
    //   882: aconst_null
    //   883: astore_1
    //   884: goto -267 -> 617
    //   887: astore 7
    //   889: aload 4
    //   891: astore_1
    //   892: goto -275 -> 617
    //   895: astore 4
    //   897: aconst_null
    //   898: astore_0
    //   899: aload 5
    //   901: astore_1
    //   902: goto -780 -> 122
    //   905: astore 4
    //   907: aconst_null
    //   908: astore 5
    //   910: aload_0
    //   911: astore_1
    //   912: aload 5
    //   914: astore_0
    //   915: goto -793 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	918	0	paramString	String
    //   0	918	1	paramArrayOfInt	int[]
    //   86	368	2	i	int
    //   360	98	3	j	int
    //   71	691	4	localObject1	Object
    //   776	29	4	localIOException1	java.io.IOException
    //   847	9	4	localObject2	Object
    //   863	6	4	localObject3	Object
    //   872	18	4	str1	String
    //   895	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   905	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	97	5	str2	String
    //   111	8	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   176	737	5	localObject4	Object
    //   75	779	6	localObject5	Object
    //   62	292	7	localObject6	Object
    //   611	39	7	localIOException2	java.io.IOException
    //   880	1	7	localIOException3	java.io.IOException
    //   887	1	7	localIOException4	java.io.IOException
    //   35	626	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   80	87	111	java/io/FileNotFoundException
    //   99	108	111	java/io/FileNotFoundException
    //   178	190	111	java/io/FileNotFoundException
    //   202	209	111	java/io/FileNotFoundException
    //   216	222	111	java/io/FileNotFoundException
    //   229	237	111	java/io/FileNotFoundException
    //   338	346	111	java/io/FileNotFoundException
    //   353	361	111	java/io/FileNotFoundException
    //   250	255	265	java/io/IOException
    //   259	263	298	java/io/IOException
    //   380	384	386	java/io/IOException
    //   371	376	418	java/io/IOException
    //   464	469	479	java/io/IOException
    //   473	477	512	java/io/IOException
    //   157	161	545	java/io/IOException
    //   165	169	578	java/io/IOException
    //   47	57	611	java/io/IOException
    //   670	674	684	java/io/IOException
    //   678	682	717	java/io/IOException
    //   47	57	750	finally
    //   761	766	776	java/io/IOException
    //   770	774	812	java/io/IOException
    //   57	73	845	finally
    //   80	87	852	finally
    //   99	108	852	finally
    //   178	190	852	finally
    //   202	209	852	finally
    //   216	222	852	finally
    //   229	237	852	finally
    //   338	346	852	finally
    //   353	361	852	finally
    //   623	654	852	finally
    //   660	666	852	finally
    //   122	153	863	finally
    //   57	73	880	java/io/IOException
    //   80	87	887	java/io/IOException
    //   99	108	887	java/io/IOException
    //   178	190	887	java/io/IOException
    //   202	209	887	java/io/IOException
    //   216	222	887	java/io/IOException
    //   229	237	887	java/io/IOException
    //   338	346	887	java/io/IOException
    //   353	361	887	java/io/IOException
    //   47	57	895	java/io/FileNotFoundException
    //   57	73	905	java/io/FileNotFoundException
  }
  
  public static void edU()
  {
    Object localObject1 = new File(acbn.bmv);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isFile()) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  public static void edV()
  {
    Object localObject1 = new File(acbn.bmv);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(5, -15);
    ((Calendar)localObject2).set(11, 0);
    ((Calendar)localObject2).set(12, 0);
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l3 = ((Calendar)localObject2).getTimeInMillis();
    if (((File)localObject1).exists())
    {
      localObject2 = ((File)localObject1).listFiles();
      if (localObject2 != null) {}
    }
    else
    {
      return;
      break label182;
    }
    label84:
    localObject1 = new TreeMap();
    int j = localObject2.length;
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      File localFile;
      long l2;
      if (i < j)
      {
        localFile = localObject2[i];
        l2 = l1;
        if (!localFile.isFile()) {}
      }
      else
      {
        try
        {
          if (localFile.lastModified() < l3)
          {
            G(localFile);
            l2 = l1;
          }
          else
          {
            ((TreeMap)localObject1).put(Long.valueOf(localFile.lastModified()), localFile);
            l2 = localFile.length();
            l2 = l1 + l2;
          }
        }
        catch (Exception localException)
        {
          label182:
          l2 = l1;
        }
        l2 = l1;
        if (l2 <= asM) {
          break label84;
        }
        localObject2 = ((TreeMap)localObject1).entrySet().iterator();
        l1 = l2;
        l2 = l1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFile = (File)((Map.Entry)((Iterator)localObject2).next()).getValue();
        l2 = localFile.length();
        if (G(localFile)) {
          l1 -= l2;
        }
        for (;;)
        {
          break;
        }
      }
      i += 1;
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqiv
 * JD-Core Version:    0.7.0.1
 */