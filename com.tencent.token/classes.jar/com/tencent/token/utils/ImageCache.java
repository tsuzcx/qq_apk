package com.tencent.token.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.token.abt;
import com.tencent.token.xv;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ImageCache
  extends LinkedHashMap<String, Bitmap>
{
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  private static final long serialVersionUID = 2533500844821654646L;
  private String mDiskCacheDirectory;
  protected Object mLock = new Object();
  private int mMaxEntries = 0;
  private boolean mNeedRecycle = true;
  
  public ImageCache(int paramInt, Context paramContext)
  {
    super(paramInt, 0.75F, true);
    this.mMaxEntries = paramInt;
    this.mDiskCacheDirectory = paramContext.getCacheDir().getAbsolutePath();
    paramContext = new File(this.mDiskCacheDirectory);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return false;
  }
  
  public static String d(String paramString)
  {
    return abt.b(paramString);
  }
  
  public final Bitmap a(Object paramObject)
  {
    try
    {
      paramObject = (Bitmap)super.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public final boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 36	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: new 44	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 57	java/io/File:exists	()Z
    //   26: ifeq +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 94	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +7 -> 42
    //   38: aload_3
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 97	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 99	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: new 104	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore 4
    //   65: aload_2
    //   66: getstatic 111	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 100
    //   71: aload 4
    //   73: invokevirtual 115	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 4
    //   79: aload_1
    //   80: invokevirtual 119	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   83: aload 4
    //   85: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_1
    //   89: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   100: aload_3
    //   101: monitorexit
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: goto +20 -> 125
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   113: goto +8 -> 121
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 125	java/io/FileNotFoundException:printStackTrace	()V
    //   121: aload_3
    //   122: monitorexit
    //   123: iconst_0
    //   124: ireturn
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_3
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	ImageCache
    //   0	132	1	paramString	String
    //   0	132	2	paramBitmap	Bitmap
    //   10	119	3	localObject	Object
    //   63	21	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   83	92	95	java/lang/Exception
    //   42	83	104	finally
    //   83	92	104	finally
    //   96	100	104	finally
    //   109	113	104	finally
    //   117	121	104	finally
    //   42	83	108	java/io/IOException
    //   83	92	108	java/io/IOException
    //   96	100	108	java/io/IOException
    //   42	83	116	java/io/FileNotFoundException
    //   83	92	116	java/io/FileNotFoundException
    //   96	100	116	java/io/FileNotFoundException
    //   13	40	127	finally
    //   100	102	127	finally
    //   121	123	127	finally
    //   125	127	127	finally
    //   128	130	127	finally
  }
  
  /* Error */
  public final Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   4: astore 11
    //   6: aload 11
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 5
    //   27: new 44	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 12
    //   37: aload 12
    //   39: invokevirtual 57	java/io/File:exists	()Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifne +8 -> 52
    //   47: aload 11
    //   49: monitorexit
    //   50: aconst_null
    //   51: areturn
    //   52: new 104	java/io/ByteArrayOutputStream
    //   55: dup
    //   56: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   59: astore_1
    //   60: new 130	java/io/FileInputStream
    //   63: dup
    //   64: aload 12
    //   66: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: astore 4
    //   71: aload 5
    //   73: astore 9
    //   75: aload 6
    //   77: astore 7
    //   79: aload 10
    //   81: astore 8
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore 13
    //   90: aload 5
    //   92: astore 9
    //   94: aload 6
    //   96: astore 7
    //   98: aload 10
    //   100: astore 8
    //   102: aload 4
    //   104: aload 13
    //   106: invokevirtual 135	java/io/FileInputStream:read	([B)I
    //   109: istore_2
    //   110: iload_2
    //   111: iconst_m1
    //   112: if_icmpeq +26 -> 138
    //   115: aload 5
    //   117: astore 9
    //   119: aload 6
    //   121: astore 7
    //   123: aload 10
    //   125: astore 8
    //   127: aload_1
    //   128: aload 13
    //   130: iconst_0
    //   131: iload_2
    //   132: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   135: goto -45 -> 90
    //   138: aload 5
    //   140: astore 9
    //   142: aload 6
    //   144: astore 7
    //   146: aload 10
    //   148: astore 8
    //   150: aload_1
    //   151: invokevirtual 143	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   154: astore 13
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 7
    //   164: aload 10
    //   166: astore 8
    //   168: aload_1
    //   169: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   172: aload 5
    //   174: astore 9
    //   176: aload 6
    //   178: astore 7
    //   180: aload 10
    //   182: astore 8
    //   184: aload 4
    //   186: invokevirtual 144	java/io/FileInputStream:close	()V
    //   189: goto +22 -> 211
    //   192: astore 14
    //   194: aload 5
    //   196: astore 9
    //   198: aload 6
    //   200: astore 7
    //   202: aload 10
    //   204: astore 8
    //   206: aload 14
    //   208: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   211: aload 5
    //   213: astore 9
    //   215: aload 6
    //   217: astore 7
    //   219: aload 10
    //   221: astore 8
    //   223: aload 13
    //   225: invokestatic 149	com/tencent/token/aaz:a	([B)Landroid/graphics/Bitmap;
    //   228: astore 5
    //   230: aload 5
    //   232: ifnonnull +173 -> 405
    //   235: new 151	java/io/ObjectInputStream
    //   238: dup
    //   239: new 130	java/io/FileInputStream
    //   242: dup
    //   243: aload 12
    //   245: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   248: invokespecial 154	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   251: astore 9
    //   253: aload 9
    //   255: astore 7
    //   257: aload 9
    //   259: invokevirtual 158	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   262: checkcast 160	[B
    //   265: checkcast 160	[B
    //   268: invokestatic 149	com/tencent/token/aaz:a	([B)Landroid/graphics/Bitmap;
    //   271: astore 6
    //   273: aload 6
    //   275: astore 7
    //   277: aload 6
    //   279: astore 8
    //   281: aload 9
    //   283: invokevirtual 161	java/io/ObjectInputStream:close	()V
    //   286: goto +123 -> 409
    //   289: astore 5
    //   291: aload 6
    //   293: astore 9
    //   295: aload 6
    //   297: astore 7
    //   299: aload 6
    //   301: astore 8
    //   303: aload 5
    //   305: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   308: goto +101 -> 409
    //   311: astore 8
    //   313: aload 9
    //   315: astore 6
    //   317: goto +16 -> 333
    //   320: astore 6
    //   322: aconst_null
    //   323: astore 7
    //   325: goto +42 -> 367
    //   328: astore 8
    //   330: aconst_null
    //   331: astore 6
    //   333: aload 6
    //   335: astore 7
    //   337: aload 8
    //   339: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   342: aload 6
    //   344: ifnull +61 -> 405
    //   347: aload 6
    //   349: invokevirtual 161	java/io/ObjectInputStream:close	()V
    //   352: goto +53 -> 405
    //   355: astore 6
    //   357: aload 6
    //   359: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   362: goto +43 -> 405
    //   365: astore 6
    //   367: aload 7
    //   369: ifnull +18 -> 387
    //   372: aload 7
    //   374: invokevirtual 161	java/io/ObjectInputStream:close	()V
    //   377: goto +10 -> 387
    //   380: astore 7
    //   382: aload 7
    //   384: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   387: aload 6
    //   389: athrow
    //   390: astore 6
    //   392: goto +95 -> 487
    //   395: astore 6
    //   397: goto +113 -> 510
    //   400: astore 6
    //   402: goto +131 -> 533
    //   405: aload 5
    //   407: astore 6
    //   409: aload_1
    //   410: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   413: aload 4
    //   415: invokevirtual 144	java/io/FileInputStream:close	()V
    //   418: goto +8 -> 426
    //   421: astore_1
    //   422: aload_1
    //   423: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   426: aload 6
    //   428: astore_1
    //   429: goto +302 -> 731
    //   432: astore 5
    //   434: aload_1
    //   435: astore 6
    //   437: goto +308 -> 745
    //   440: astore 6
    //   442: aload 9
    //   444: astore 5
    //   446: goto +41 -> 487
    //   449: astore 6
    //   451: aload 7
    //   453: astore 5
    //   455: goto +55 -> 510
    //   458: astore 6
    //   460: aload 8
    //   462: astore 5
    //   464: goto +69 -> 533
    //   467: astore 5
    //   469: aconst_null
    //   470: astore 4
    //   472: aload_1
    //   473: astore 6
    //   475: goto +270 -> 745
    //   478: astore 6
    //   480: aconst_null
    //   481: astore 4
    //   483: aload 4
    //   485: astore 5
    //   487: aload_1
    //   488: astore 7
    //   490: aload 6
    //   492: astore 8
    //   494: aload 4
    //   496: astore 6
    //   498: goto +70 -> 568
    //   501: astore 6
    //   503: aconst_null
    //   504: astore 4
    //   506: aload 4
    //   508: astore 5
    //   510: aload_1
    //   511: astore 7
    //   513: aload 6
    //   515: astore 8
    //   517: aload 4
    //   519: astore 6
    //   521: goto +112 -> 633
    //   524: astore 6
    //   526: aconst_null
    //   527: astore 4
    //   529: aload 4
    //   531: astore 5
    //   533: aload_1
    //   534: astore 7
    //   536: aload 6
    //   538: astore 8
    //   540: aload 4
    //   542: astore 6
    //   544: goto +146 -> 690
    //   547: astore 5
    //   549: aconst_null
    //   550: astore 4
    //   552: aload 4
    //   554: astore 6
    //   556: goto +189 -> 745
    //   559: astore 8
    //   561: aconst_null
    //   562: astore 6
    //   564: aload 6
    //   566: astore 5
    //   568: aload 7
    //   570: astore 4
    //   572: aload 6
    //   574: astore_1
    //   575: aload 8
    //   577: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   580: aload 7
    //   582: ifnull +11 -> 593
    //   585: aload 7
    //   587: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   590: goto +3 -> 593
    //   593: aload 5
    //   595: astore_1
    //   596: aload 6
    //   598: ifnull +133 -> 731
    //   601: aload 6
    //   603: invokevirtual 144	java/io/FileInputStream:close	()V
    //   606: aload 5
    //   608: astore_1
    //   609: goto +122 -> 731
    //   612: aload 4
    //   614: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   617: goto +114 -> 731
    //   620: astore 8
    //   622: aconst_null
    //   623: astore 6
    //   625: aload 6
    //   627: astore 5
    //   629: aload 4
    //   631: astore 7
    //   633: aload 7
    //   635: astore 4
    //   637: aload 6
    //   639: astore_1
    //   640: aload 8
    //   642: invokevirtual 125	java/io/FileNotFoundException:printStackTrace	()V
    //   645: aload 7
    //   647: ifnull +11 -> 658
    //   650: aload 7
    //   652: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   655: goto +3 -> 658
    //   658: aload 5
    //   660: astore_1
    //   661: aload 6
    //   663: ifnull +68 -> 731
    //   666: aload 6
    //   668: invokevirtual 144	java/io/FileInputStream:close	()V
    //   671: aload 5
    //   673: astore_1
    //   674: goto +57 -> 731
    //   677: astore 8
    //   679: aconst_null
    //   680: astore 6
    //   682: aload 6
    //   684: astore 5
    //   686: aload 9
    //   688: astore 7
    //   690: aload 7
    //   692: astore 4
    //   694: aload 6
    //   696: astore_1
    //   697: aload 8
    //   699: invokevirtual 162	java/io/StreamCorruptedException:printStackTrace	()V
    //   702: aload 7
    //   704: ifnull +11 -> 715
    //   707: aload 7
    //   709: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   712: goto +3 -> 715
    //   715: aload 5
    //   717: astore_1
    //   718: aload 6
    //   720: ifnull +11 -> 731
    //   723: aload 6
    //   725: invokevirtual 144	java/io/FileInputStream:close	()V
    //   728: aload 5
    //   730: astore_1
    //   731: aload 11
    //   733: monitorexit
    //   734: aload_1
    //   735: areturn
    //   736: astore 5
    //   738: aload 4
    //   740: astore 6
    //   742: aload_1
    //   743: astore 4
    //   745: aload 6
    //   747: ifnull +11 -> 758
    //   750: aload 6
    //   752: invokevirtual 122	java/io/ByteArrayOutputStream:close	()V
    //   755: goto +3 -> 758
    //   758: aload 4
    //   760: ifnull +15 -> 775
    //   763: aload 4
    //   765: invokevirtual 144	java/io/FileInputStream:close	()V
    //   768: goto +7 -> 775
    //   771: aload_1
    //   772: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   775: aload 5
    //   777: athrow
    //   778: aload 11
    //   780: monitorexit
    //   781: aload_1
    //   782: athrow
    //   783: astore 4
    //   785: aload 5
    //   787: astore_1
    //   788: goto -176 -> 612
    //   791: astore 4
    //   793: aload 5
    //   795: astore_1
    //   796: goto -184 -> 612
    //   799: astore_1
    //   800: goto -22 -> 778
    //   803: astore 4
    //   805: aload 5
    //   807: astore_1
    //   808: goto -196 -> 612
    //   811: astore_1
    //   812: goto -41 -> 771
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	this	ImageCache
    //   0	815	1	paramString	String
    //   109	23	2	i	int
    //   42	2	3	bool	boolean
    //   19	745	4	localObject1	Object
    //   783	1	4	localIOException1	java.io.IOException
    //   791	1	4	localIOException2	java.io.IOException
    //   803	1	4	localIOException3	java.io.IOException
    //   25	206	5	localBitmap	Bitmap
    //   289	117	5	localIOException4	java.io.IOException
    //   432	1	5	localObject2	Object
    //   444	19	5	localObject3	Object
    //   467	1	5	localObject4	Object
    //   485	47	5	localObject5	Object
    //   547	1	5	localObject6	Object
    //   566	163	5	localObject7	Object
    //   736	70	5	localObject8	Object
    //   10	306	6	localObject9	Object
    //   320	1	6	localObject10	Object
    //   331	17	6	localObject11	Object
    //   355	3	6	localIOException5	java.io.IOException
    //   365	23	6	localObject12	Object
    //   390	1	6	localIOException6	java.io.IOException
    //   395	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   400	1	6	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   407	29	6	localObject13	Object
    //   440	1	6	localIOException7	java.io.IOException
    //   449	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   458	1	6	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   473	1	6	str	String
    //   478	13	6	localIOException8	java.io.IOException
    //   496	1	6	localObject14	Object
    //   501	13	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   519	1	6	localObject15	Object
    //   524	13	6	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   542	209	6	localObject16	Object
    //   16	357	7	localObject17	Object
    //   380	72	7	localIOException9	java.io.IOException
    //   488	220	7	localObject18	Object
    //   81	221	8	localObject19	Object
    //   311	1	8	localException1	Exception
    //   328	133	8	localException2	Exception
    //   492	47	8	localObject20	Object
    //   559	17	8	localIOException10	java.io.IOException
    //   620	21	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   677	21	8	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   22	665	9	localObject21	Object
    //   13	207	10	localObject22	Object
    //   4	775	11	localObject23	Object
    //   35	209	12	localFile	File
    //   88	136	13	arrayOfByte	byte[]
    //   192	15	14	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   168	172	192	java/lang/Exception
    //   184	189	192	java/lang/Exception
    //   281	286	289	java/io/IOException
    //   257	273	311	java/lang/Exception
    //   235	253	320	finally
    //   235	253	328	java/lang/Exception
    //   347	352	355	java/io/IOException
    //   257	273	365	finally
    //   337	342	365	finally
    //   372	377	380	java/io/IOException
    //   357	362	390	java/io/IOException
    //   382	387	390	java/io/IOException
    //   387	390	390	java/io/IOException
    //   347	352	395	java/io/FileNotFoundException
    //   357	362	395	java/io/FileNotFoundException
    //   372	377	395	java/io/FileNotFoundException
    //   382	387	395	java/io/FileNotFoundException
    //   387	390	395	java/io/FileNotFoundException
    //   347	352	400	java/io/StreamCorruptedException
    //   357	362	400	java/io/StreamCorruptedException
    //   372	377	400	java/io/StreamCorruptedException
    //   382	387	400	java/io/StreamCorruptedException
    //   387	390	400	java/io/StreamCorruptedException
    //   409	418	421	java/io/IOException
    //   83	90	432	finally
    //   102	110	432	finally
    //   127	135	432	finally
    //   150	156	432	finally
    //   168	172	432	finally
    //   184	189	432	finally
    //   206	211	432	finally
    //   223	230	432	finally
    //   281	286	432	finally
    //   303	308	432	finally
    //   347	352	432	finally
    //   357	362	432	finally
    //   372	377	432	finally
    //   382	387	432	finally
    //   387	390	432	finally
    //   83	90	440	java/io/IOException
    //   102	110	440	java/io/IOException
    //   127	135	440	java/io/IOException
    //   150	156	440	java/io/IOException
    //   168	172	440	java/io/IOException
    //   184	189	440	java/io/IOException
    //   206	211	440	java/io/IOException
    //   223	230	440	java/io/IOException
    //   303	308	440	java/io/IOException
    //   83	90	449	java/io/FileNotFoundException
    //   102	110	449	java/io/FileNotFoundException
    //   127	135	449	java/io/FileNotFoundException
    //   150	156	449	java/io/FileNotFoundException
    //   168	172	449	java/io/FileNotFoundException
    //   184	189	449	java/io/FileNotFoundException
    //   206	211	449	java/io/FileNotFoundException
    //   223	230	449	java/io/FileNotFoundException
    //   281	286	449	java/io/FileNotFoundException
    //   303	308	449	java/io/FileNotFoundException
    //   83	90	458	java/io/StreamCorruptedException
    //   102	110	458	java/io/StreamCorruptedException
    //   127	135	458	java/io/StreamCorruptedException
    //   150	156	458	java/io/StreamCorruptedException
    //   168	172	458	java/io/StreamCorruptedException
    //   184	189	458	java/io/StreamCorruptedException
    //   206	211	458	java/io/StreamCorruptedException
    //   223	230	458	java/io/StreamCorruptedException
    //   281	286	458	java/io/StreamCorruptedException
    //   303	308	458	java/io/StreamCorruptedException
    //   60	71	467	finally
    //   60	71	478	java/io/IOException
    //   60	71	501	java/io/FileNotFoundException
    //   60	71	524	java/io/StreamCorruptedException
    //   27	43	547	finally
    //   52	60	547	finally
    //   27	43	559	java/io/IOException
    //   52	60	559	java/io/IOException
    //   27	43	620	java/io/FileNotFoundException
    //   52	60	620	java/io/FileNotFoundException
    //   27	43	677	java/io/StreamCorruptedException
    //   52	60	677	java/io/StreamCorruptedException
    //   575	580	736	finally
    //   640	645	736	finally
    //   697	702	736	finally
    //   585	590	783	java/io/IOException
    //   601	606	783	java/io/IOException
    //   650	655	791	java/io/IOException
    //   666	671	791	java/io/IOException
    //   47	50	799	finally
    //   409	418	799	finally
    //   422	426	799	finally
    //   585	590	799	finally
    //   601	606	799	finally
    //   612	617	799	finally
    //   650	655	799	finally
    //   666	671	799	finally
    //   707	712	799	finally
    //   723	728	799	finally
    //   731	734	799	finally
    //   750	755	799	finally
    //   763	768	799	finally
    //   771	775	799	finally
    //   775	778	799	finally
    //   778	781	799	finally
    //   707	712	803	java/io/IOException
    //   723	728	803	java/io/IOException
    //   750	755	811	java/io/IOException
    //   763	768	811	java/io/IOException
  }
  
  public final Bitmap b(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.mLock)
    {
      paramString = (Bitmap)super.put(paramString, paramBitmap);
      return paramString;
    }
  }
  
  public final String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mDiskCacheDirectory);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void clear()
  {
    synchronized (this.mLock)
    {
      xv.b("clear cache");
      if (this.mNeedRecycle)
      {
        Iterator localIterator = entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          } else {
            xv.c("ImageCache is broken");
          }
        }
      }
      super.clear();
      return;
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, Bitmap> paramEntry)
  {
    if (size() > this.mMaxEntries)
    {
      if (this.mNeedRecycle)
      {
        localObject = (Bitmap)paramEntry.getValue();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          ((Bitmap)localObject).recycle();
        }
      }
      Object localObject = new StringBuilder("recycle bitmap:");
      ((StringBuilder)localObject).append((String)paramEntry.getKey());
      xv.b(((StringBuilder)localObject).toString());
      return true;
    }
    paramEntry = new StringBuilder("size=");
    paramEntry.append(size());
    xv.b(paramEntry.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ImageCache
 * JD-Core Version:    0.7.0.1
 */