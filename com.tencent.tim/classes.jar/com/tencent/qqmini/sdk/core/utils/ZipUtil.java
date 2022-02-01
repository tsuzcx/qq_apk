package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil
{
  public static long getUncompressedFileSize(String paramString)
  {
    long l2;
    if (TextUtils.isEmpty(paramString)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        paramString = new ZipFile(paramString).entries();
        long l1 = 0L;
        l2 = l1;
        if (!paramString.hasMoreElements()) {
          continue;
        }
        ZipEntry localZipEntry = (ZipEntry)paramString.nextElement();
        if (!localZipEntry.isDirectory())
        {
          l2 = localZipEntry.getSize();
          l1 = l2 + l1;
        }
        for (;;)
        {
          break;
        }
      }
      catch (Exception paramString)
      {
        return -1L;
      }
    }
  }
  
  /* Error */
  public static int unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +38 -> 47
    //   12: ldc 59
    //   14: new 61	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   21: ldc 64
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 74	java/lang/String:toString	()Ljava/lang/String;
    //   30: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 76
    //   35: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 83	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: bipush 9
    //   46: ireturn
    //   47: new 85	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 89	java/io/File:exists	()Z
    //   62: ifne +9 -> 71
    //   65: aload 6
    //   67: invokevirtual 92	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 85	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: new 94	com/tencent/qqmini/sdk/core/utils/QZipFile
    //   83: dup
    //   84: aload_0
    //   85: invokespecial 97	com/tencent/qqmini/sdk/core/utils/QZipFile:<init>	(Ljava/io/File;)V
    //   88: astore 9
    //   90: sipush 8192
    //   93: newarray byte
    //   95: astore 10
    //   97: new 61	java/lang/StringBuilder
    //   100: dup
    //   101: sipush 512
    //   104: invokespecial 100	java/lang/StringBuilder:<init>	(I)V
    //   107: astore 11
    //   109: aload 9
    //   111: invokevirtual 101	com/tencent/qqmini/sdk/core/utils/QZipFile:entries	()Ljava/util/Enumeration;
    //   114: astore 12
    //   116: iload_3
    //   117: istore_2
    //   118: aload 12
    //   120: invokeinterface 36 1 0
    //   125: ifeq +577 -> 702
    //   128: aload 12
    //   130: invokeinterface 40 1 0
    //   135: checkcast 42	java/util/zip/ZipEntry
    //   138: astore 13
    //   140: aload 13
    //   142: invokevirtual 104	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   145: astore_0
    //   146: aload_0
    //   147: ldc 106
    //   149: invokevirtual 109	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   152: ifne -36 -> 116
    //   155: aload 11
    //   157: iconst_0
    //   158: aload 11
    //   160: invokevirtual 113	java/lang/StringBuilder:length	()I
    //   163: invokevirtual 117	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 11
    //   169: aload_1
    //   170: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   176: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 13
    //   186: invokevirtual 45	java/util/zip/ZipEntry:isDirectory	()Z
    //   189: ifeq +83 -> 272
    //   192: new 85	java/io/File
    //   195: dup
    //   196: aload 11
    //   198: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 89	java/io/File:exists	()Z
    //   209: ifne -93 -> 116
    //   212: aload_0
    //   213: invokevirtual 92	java/io/File:mkdirs	()Z
    //   216: pop
    //   217: goto -101 -> 116
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 124	java/io/FileNotFoundException:printStackTrace	()V
    //   225: iconst_5
    //   226: istore_2
    //   227: aload 9
    //   229: invokevirtual 127	com/tencent/qqmini/sdk/core/utils/QZipFile:close	()V
    //   232: iload_2
    //   233: ireturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   239: bipush 8
    //   241: ireturn
    //   242: astore_0
    //   243: ldc 59
    //   245: ldc 130
    //   247: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_0
    //   253: ldc 59
    //   255: ldc 135
    //   257: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iconst_2
    //   261: ireturn
    //   262: astore_0
    //   263: ldc 59
    //   265: ldc 137
    //   267: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: iconst_3
    //   271: ireturn
    //   272: aload 9
    //   274: aload 13
    //   276: invokevirtual 141	com/tencent/qqmini/sdk/core/utils/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   279: astore_0
    //   280: new 143	java/util/zip/CheckedInputStream
    //   283: dup
    //   284: aload_0
    //   285: new 145	java/util/zip/CRC32
    //   288: dup
    //   289: invokespecial 146	java/util/zip/CRC32:<init>	()V
    //   292: invokespecial 149	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   295: astore 6
    //   297: new 85	java/io/File
    //   300: dup
    //   301: new 70	java/lang/String
    //   304: dup
    //   305: aload 11
    //   307: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: ldc 151
    //   312: invokevirtual 155	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   315: ldc 157
    //   317: invokespecial 160	java/lang/String:<init>	([BLjava/lang/String;)V
    //   320: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   323: astore 8
    //   325: aload 8
    //   327: invokevirtual 89	java/io/File:exists	()Z
    //   330: ifne +24 -> 354
    //   333: aload 8
    //   335: invokevirtual 164	java/io/File:getParentFile	()Ljava/io/File;
    //   338: astore 14
    //   340: aload 14
    //   342: invokevirtual 89	java/io/File:exists	()Z
    //   345: ifne +9 -> 354
    //   348: aload 14
    //   350: invokevirtual 92	java/io/File:mkdirs	()Z
    //   353: pop
    //   354: new 166	java/io/BufferedOutputStream
    //   357: dup
    //   358: new 168	java/io/FileOutputStream
    //   361: dup
    //   362: aload 8
    //   364: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   367: invokespecial 172	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   370: invokestatic 178	com/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream:obtain	(Ljava/io/OutputStream;)Lcom/tencent/qqmini/sdk/core/utils/RecycleableBufferedOutputStream;
    //   373: astore 8
    //   375: aload 13
    //   377: invokevirtual 49	java/util/zip/ZipEntry:getSize	()J
    //   380: lstore 4
    //   382: lload 4
    //   384: lconst_0
    //   385: lcmp
    //   386: ifle +34 -> 420
    //   389: aload 6
    //   391: aload 10
    //   393: iconst_0
    //   394: sipush 8192
    //   397: invokevirtual 182	java/util/zip/CheckedInputStream:read	([BII)I
    //   400: istore_2
    //   401: aload 8
    //   403: aload 10
    //   405: iconst_0
    //   406: iload_2
    //   407: invokevirtual 188	java/io/OutputStream:write	([BII)V
    //   410: lload 4
    //   412: iload_2
    //   413: i2l
    //   414: lsub
    //   415: lstore 4
    //   417: goto -35 -> 382
    //   420: aload 13
    //   422: invokevirtual 191	java/util/zip/ZipEntry:getCrc	()J
    //   425: aload 6
    //   427: invokevirtual 195	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   430: invokeinterface 200 1 0
    //   435: lcmp
    //   436: ifeq +77 -> 513
    //   439: iconst_4
    //   440: istore_2
    //   441: ldc 59
    //   443: new 61	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   450: ldc 202
    //   452: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 13
    //   457: invokevirtual 191	java/util/zip/ZipEntry:getCrc	()J
    //   460: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 133	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 6
    //   471: ifnull +8 -> 479
    //   474: aload 6
    //   476: invokevirtual 206	java/util/zip/CheckedInputStream:close	()V
    //   479: aload_0
    //   480: ifnull +7 -> 487
    //   483: aload_0
    //   484: invokevirtual 209	java/io/InputStream:close	()V
    //   487: aload 8
    //   489: ifnull +213 -> 702
    //   492: aload 8
    //   494: invokevirtual 212	java/io/OutputStream:flush	()V
    //   497: aload 8
    //   499: invokevirtual 213	java/io/OutputStream:close	()V
    //   502: iconst_4
    //   503: istore_2
    //   504: goto -277 -> 227
    //   507: astore_0
    //   508: iconst_4
    //   509: istore_2
    //   510: goto -283 -> 227
    //   513: aload 6
    //   515: ifnull +8 -> 523
    //   518: aload 6
    //   520: invokevirtual 206	java/util/zip/CheckedInputStream:close	()V
    //   523: aload_0
    //   524: ifnull +7 -> 531
    //   527: aload_0
    //   528: invokevirtual 209	java/io/InputStream:close	()V
    //   531: aload 8
    //   533: ifnull -417 -> 116
    //   536: aload 8
    //   538: invokevirtual 212	java/io/OutputStream:flush	()V
    //   541: aload 8
    //   543: invokevirtual 213	java/io/OutputStream:close	()V
    //   546: goto -430 -> 116
    //   549: astore_0
    //   550: goto -434 -> 116
    //   553: astore_0
    //   554: aconst_null
    //   555: astore_1
    //   556: aconst_null
    //   557: astore 6
    //   559: aload 7
    //   561: ifnull +8 -> 569
    //   564: aload 7
    //   566: invokevirtual 206	java/util/zip/CheckedInputStream:close	()V
    //   569: aload 6
    //   571: ifnull +8 -> 579
    //   574: aload 6
    //   576: invokevirtual 209	java/io/InputStream:close	()V
    //   579: aload_1
    //   580: ifnull +11 -> 591
    //   583: aload_1
    //   584: invokevirtual 212	java/io/OutputStream:flush	()V
    //   587: aload_1
    //   588: invokevirtual 213	java/io/OutputStream:close	()V
    //   591: aload_0
    //   592: athrow
    //   593: astore_0
    //   594: aload_0
    //   595: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   598: bipush 6
    //   600: istore_2
    //   601: goto -374 -> 227
    //   604: astore_0
    //   605: aload_0
    //   606: invokevirtual 214	java/lang/Exception:printStackTrace	()V
    //   609: bipush 7
    //   611: istore_2
    //   612: goto -385 -> 227
    //   615: astore_1
    //   616: goto -137 -> 479
    //   619: astore_0
    //   620: goto -133 -> 487
    //   623: astore 6
    //   625: goto -102 -> 523
    //   628: astore_0
    //   629: goto -98 -> 531
    //   632: astore 7
    //   634: goto -65 -> 569
    //   637: astore 6
    //   639: goto -60 -> 579
    //   642: astore_1
    //   643: goto -52 -> 591
    //   646: astore 8
    //   648: aconst_null
    //   649: astore_1
    //   650: aload_0
    //   651: astore 6
    //   653: aload 8
    //   655: astore_0
    //   656: goto -97 -> 559
    //   659: astore 7
    //   661: aconst_null
    //   662: astore_1
    //   663: aload_0
    //   664: astore 8
    //   666: aload 7
    //   668: astore_0
    //   669: aload 6
    //   671: astore 7
    //   673: aload 8
    //   675: astore 6
    //   677: goto -118 -> 559
    //   680: astore 7
    //   682: aload 8
    //   684: astore_1
    //   685: aload_0
    //   686: astore 8
    //   688: aload 7
    //   690: astore_0
    //   691: aload 6
    //   693: astore 7
    //   695: aload 8
    //   697: astore 6
    //   699: goto -140 -> 559
    //   702: goto -475 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	paramString1	String
    //   0	705	1	paramString2	String
    //   117	495	2	i	int
    //   4	113	3	j	int
    //   380	36	4	l	long
    //   55	520	6	localObject1	Object
    //   623	1	6	localIOException1	java.io.IOException
    //   637	1	6	localIOException2	java.io.IOException
    //   651	47	6	localObject2	Object
    //   1	564	7	localObject3	Object
    //   632	1	7	localIOException3	java.io.IOException
    //   659	8	7	localObject4	Object
    //   671	1	7	localObject5	Object
    //   680	9	7	localObject6	Object
    //   693	1	7	localObject7	Object
    //   323	219	8	localObject8	Object
    //   646	8	8	localObject9	Object
    //   664	32	8	str	String
    //   88	185	9	localQZipFile	QZipFile
    //   95	309	10	arrayOfByte	byte[]
    //   107	199	11	localStringBuilder	java.lang.StringBuilder
    //   114	15	12	localEnumeration	Enumeration
    //   138	318	13	localZipEntry	ZipEntry
    //   338	11	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   90	116	220	java/io/FileNotFoundException
    //   118	217	220	java/io/FileNotFoundException
    //   474	479	220	java/io/FileNotFoundException
    //   483	487	220	java/io/FileNotFoundException
    //   492	502	220	java/io/FileNotFoundException
    //   518	523	220	java/io/FileNotFoundException
    //   527	531	220	java/io/FileNotFoundException
    //   536	546	220	java/io/FileNotFoundException
    //   564	569	220	java/io/FileNotFoundException
    //   574	579	220	java/io/FileNotFoundException
    //   583	591	220	java/io/FileNotFoundException
    //   591	593	220	java/io/FileNotFoundException
    //   227	232	234	java/io/IOException
    //   80	90	242	java/util/zip/ZipException
    //   80	90	252	java/io/IOException
    //   80	90	262	java/lang/Exception
    //   492	502	507	java/io/IOException
    //   536	546	549	java/io/IOException
    //   272	280	553	finally
    //   90	116	593	java/io/IOException
    //   118	217	593	java/io/IOException
    //   591	593	593	java/io/IOException
    //   90	116	604	java/lang/Exception
    //   118	217	604	java/lang/Exception
    //   474	479	604	java/lang/Exception
    //   483	487	604	java/lang/Exception
    //   492	502	604	java/lang/Exception
    //   518	523	604	java/lang/Exception
    //   527	531	604	java/lang/Exception
    //   536	546	604	java/lang/Exception
    //   564	569	604	java/lang/Exception
    //   574	579	604	java/lang/Exception
    //   583	591	604	java/lang/Exception
    //   591	593	604	java/lang/Exception
    //   474	479	615	java/io/IOException
    //   483	487	619	java/io/IOException
    //   518	523	623	java/io/IOException
    //   527	531	628	java/io/IOException
    //   564	569	632	java/io/IOException
    //   574	579	637	java/io/IOException
    //   583	591	642	java/io/IOException
    //   280	297	646	finally
    //   297	354	659	finally
    //   354	375	659	finally
    //   375	382	680	finally
    //   389	410	680	finally
    //   420	439	680	finally
    //   441	469	680	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ZipUtil
 * JD-Core Version:    0.7.0.1
 */