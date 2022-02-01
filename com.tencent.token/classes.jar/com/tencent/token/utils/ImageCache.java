package com.tencent.token.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.token.global.g;
import com.tencent.token.utils.encrypt.c;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ImageCache
  extends LinkedHashMap<String, Bitmap>
{
  public static final String CACHE_DIR_PATH;
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  public static final String FILE_CACHE_PATH;
  public static final String SDCARD_PATH;
  private static final long serialVersionUID = 2533500844821654646L;
  private String mDiskCacheDirectory;
  protected Object mLock = new Object();
  private int mMaxEntries = 0;
  private boolean mNeedRecycle = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Tencent");
    localStringBuilder.append(File.separator);
    SDCARD_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQSec");
    localStringBuilder.append(File.separator);
    FILE_CACHE_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_PATH);
    localStringBuilder.append(FILE_CACHE_PATH);
    CACHE_DIR_PATH = localStringBuilder.toString();
  }
  
  public ImageCache(String paramString, int paramInt, Context paramContext)
  {
    super(paramInt, 0.75F, true);
    this.mMaxEntries = paramInt;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      paramString = CACHE_DIR_PATH;
    } else {
      paramContext.getCacheDir().getAbsolutePath();
    }
    this.mDiskCacheDirectory = paramContext.getCacheDir().getAbsolutePath();
    paramString = new File(this.mDiskCacheDirectory);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public Bitmap a(Object paramObject)
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
  
  public boolean a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return false;
  }
  
  /* Error */
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 76	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: new 42	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 104	java/io/File:exists	()Z
    //   26: ifeq +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 133	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +7 -> 42
    //   38: aload_3
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 136	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 138	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: new 143	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 144	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore 4
    //   65: aload_2
    //   66: getstatic 150	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 100
    //   71: aload 4
    //   73: invokevirtual 154	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 4
    //   79: aload_1
    //   80: invokevirtual 158	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   83: aload 4
    //   85: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_1
    //   89: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: aload_1
    //   97: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   100: aload_3
    //   101: monitorexit
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: goto +20 -> 125
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   113: goto +8 -> 121
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 164	java/io/FileNotFoundException:printStackTrace	()V
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
  public Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
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
    //   27: new 42	java/io/File
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 12
    //   37: aload 12
    //   39: invokevirtual 104	java/io/File:exists	()Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifne +8 -> 52
    //   47: aload 11
    //   49: monitorexit
    //   50: aconst_null
    //   51: areturn
    //   52: new 143	java/io/ByteArrayOutputStream
    //   55: dup
    //   56: invokespecial 144	java/io/ByteArrayOutputStream:<init>	()V
    //   59: astore_1
    //   60: new 170	java/io/FileInputStream
    //   63: dup
    //   64: aload 12
    //   66: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   106: invokevirtual 175	java/io/FileInputStream:read	([B)I
    //   109: istore_2
    //   110: iload_2
    //   111: iconst_m1
    //   112: if_icmpne +297 -> 409
    //   115: aload 5
    //   117: astore 9
    //   119: aload 6
    //   121: astore 7
    //   123: aload 10
    //   125: astore 8
    //   127: aload_1
    //   128: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   131: astore 13
    //   133: aload 5
    //   135: astore 9
    //   137: aload 6
    //   139: astore 7
    //   141: aload 10
    //   143: astore 8
    //   145: aload_1
    //   146: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   149: aload 5
    //   151: astore 9
    //   153: aload 6
    //   155: astore 7
    //   157: aload 10
    //   159: astore 8
    //   161: aload 4
    //   163: invokevirtual 180	java/io/FileInputStream:close	()V
    //   166: goto +22 -> 188
    //   169: astore 14
    //   171: aload 5
    //   173: astore 9
    //   175: aload 6
    //   177: astore 7
    //   179: aload 10
    //   181: astore 8
    //   183: aload 14
    //   185: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   188: aload 5
    //   190: astore 9
    //   192: aload 6
    //   194: astore 7
    //   196: aload 10
    //   198: astore 8
    //   200: aload 13
    //   202: invokestatic 185	com/tencent/token/utils/m:a	([B)Landroid/graphics/Bitmap;
    //   205: astore 5
    //   207: aload 5
    //   209: ifnonnull +173 -> 382
    //   212: new 187	java/io/ObjectInputStream
    //   215: dup
    //   216: new 170	java/io/FileInputStream
    //   219: dup
    //   220: aload 12
    //   222: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   225: invokespecial 190	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   228: astore 9
    //   230: aload 9
    //   232: astore 7
    //   234: aload 9
    //   236: invokevirtual 194	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   239: checkcast 196	[B
    //   242: checkcast 196	[B
    //   245: invokestatic 185	com/tencent/token/utils/m:a	([B)Landroid/graphics/Bitmap;
    //   248: astore 6
    //   250: aload 6
    //   252: astore 7
    //   254: aload 6
    //   256: astore 8
    //   258: aload 9
    //   260: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   263: goto +123 -> 386
    //   266: astore 5
    //   268: aload 6
    //   270: astore 9
    //   272: aload 6
    //   274: astore 7
    //   276: aload 6
    //   278: astore 8
    //   280: aload 5
    //   282: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   285: goto +101 -> 386
    //   288: astore 8
    //   290: aload 9
    //   292: astore 6
    //   294: goto +16 -> 310
    //   297: astore 6
    //   299: aconst_null
    //   300: astore 7
    //   302: goto +42 -> 344
    //   305: astore 8
    //   307: aconst_null
    //   308: astore 6
    //   310: aload 6
    //   312: astore 7
    //   314: aload 8
    //   316: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   319: aload 6
    //   321: ifnull +61 -> 382
    //   324: aload 6
    //   326: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   329: goto +53 -> 382
    //   332: astore 6
    //   334: aload 6
    //   336: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   339: goto +43 -> 382
    //   342: astore 6
    //   344: aload 7
    //   346: ifnull +18 -> 364
    //   349: aload 7
    //   351: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   354: goto +10 -> 364
    //   357: astore 7
    //   359: aload 7
    //   361: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   364: aload 6
    //   366: athrow
    //   367: astore 6
    //   369: goto +118 -> 487
    //   372: astore 6
    //   374: goto +136 -> 510
    //   377: astore 6
    //   379: goto +154 -> 533
    //   382: aload 5
    //   384: astore 6
    //   386: aload_1
    //   387: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   390: aload 4
    //   392: invokevirtual 180	java/io/FileInputStream:close	()V
    //   395: goto +8 -> 403
    //   398: astore_1
    //   399: aload_1
    //   400: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   403: aload 6
    //   405: astore_1
    //   406: goto +325 -> 731
    //   409: aload 5
    //   411: astore 9
    //   413: aload 6
    //   415: astore 7
    //   417: aload 10
    //   419: astore 8
    //   421: aload_1
    //   422: aload 13
    //   424: iconst_0
    //   425: iload_2
    //   426: invokevirtual 201	java/io/ByteArrayOutputStream:write	([BII)V
    //   429: goto -339 -> 90
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
    //   577: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   580: aload 7
    //   582: ifnull +11 -> 593
    //   585: aload 7
    //   587: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   590: goto +3 -> 593
    //   593: aload 5
    //   595: astore_1
    //   596: aload 6
    //   598: ifnull +133 -> 731
    //   601: aload 6
    //   603: invokevirtual 180	java/io/FileInputStream:close	()V
    //   606: aload 5
    //   608: astore_1
    //   609: goto +122 -> 731
    //   612: aload 4
    //   614: invokevirtual 163	java/io/IOException:printStackTrace	()V
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
    //   642: invokevirtual 164	java/io/FileNotFoundException:printStackTrace	()V
    //   645: aload 7
    //   647: ifnull +11 -> 658
    //   650: aload 7
    //   652: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   655: goto +3 -> 658
    //   658: aload 5
    //   660: astore_1
    //   661: aload 6
    //   663: ifnull +68 -> 731
    //   666: aload 6
    //   668: invokevirtual 180	java/io/FileInputStream:close	()V
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
    //   699: invokevirtual 202	java/io/StreamCorruptedException:printStackTrace	()V
    //   702: aload 7
    //   704: ifnull +11 -> 715
    //   707: aload 7
    //   709: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   712: goto +3 -> 715
    //   715: aload 5
    //   717: astore_1
    //   718: aload 6
    //   720: ifnull +11 -> 731
    //   723: aload 6
    //   725: invokevirtual 180	java/io/FileInputStream:close	()V
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
    //   752: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   755: goto +3 -> 758
    //   758: aload 4
    //   760: ifnull +15 -> 775
    //   763: aload 4
    //   765: invokevirtual 180	java/io/FileInputStream:close	()V
    //   768: goto +7 -> 775
    //   771: aload_1
    //   772: invokevirtual 163	java/io/IOException:printStackTrace	()V
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
    //   109	317	2	i	int
    //   42	2	3	bool	boolean
    //   19	745	4	localObject1	Object
    //   783	1	4	localIOException1	java.io.IOException
    //   791	1	4	localIOException2	java.io.IOException
    //   803	1	4	localIOException3	java.io.IOException
    //   25	183	5	localBitmap	Bitmap
    //   266	144	5	localIOException4	java.io.IOException
    //   432	1	5	localObject2	Object
    //   444	19	5	localObject3	Object
    //   467	1	5	localObject4	Object
    //   485	47	5	localObject5	Object
    //   547	1	5	localObject6	Object
    //   566	163	5	localObject7	Object
    //   736	70	5	localObject8	Object
    //   10	283	6	localObject9	Object
    //   297	1	6	localObject10	Object
    //   308	17	6	localObject11	Object
    //   332	3	6	localIOException5	java.io.IOException
    //   342	23	6	localObject12	Object
    //   367	1	6	localIOException6	java.io.IOException
    //   372	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   377	1	6	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   384	52	6	localObject13	Object
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
    //   16	334	7	localObject17	Object
    //   357	3	7	localIOException9	java.io.IOException
    //   415	293	7	localObject18	Object
    //   81	198	8	localObject19	Object
    //   288	1	8	localException1	Exception
    //   305	10	8	localException2	Exception
    //   419	120	8	localObject20	Object
    //   559	17	8	localIOException10	java.io.IOException
    //   620	21	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   677	21	8	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   22	665	9	localObject21	Object
    //   13	405	10	localObject22	Object
    //   4	775	11	localObject23	Object
    //   35	186	12	localFile	File
    //   88	335	13	arrayOfByte	byte[]
    //   169	15	14	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   145	149	169	java/lang/Exception
    //   161	166	169	java/lang/Exception
    //   258	263	266	java/io/IOException
    //   234	250	288	java/lang/Exception
    //   212	230	297	finally
    //   212	230	305	java/lang/Exception
    //   324	329	332	java/io/IOException
    //   234	250	342	finally
    //   314	319	342	finally
    //   349	354	357	java/io/IOException
    //   334	339	367	java/io/IOException
    //   359	364	367	java/io/IOException
    //   364	367	367	java/io/IOException
    //   324	329	372	java/io/FileNotFoundException
    //   334	339	372	java/io/FileNotFoundException
    //   349	354	372	java/io/FileNotFoundException
    //   359	364	372	java/io/FileNotFoundException
    //   364	367	372	java/io/FileNotFoundException
    //   324	329	377	java/io/StreamCorruptedException
    //   334	339	377	java/io/StreamCorruptedException
    //   349	354	377	java/io/StreamCorruptedException
    //   359	364	377	java/io/StreamCorruptedException
    //   364	367	377	java/io/StreamCorruptedException
    //   386	395	398	java/io/IOException
    //   83	90	432	finally
    //   102	110	432	finally
    //   127	133	432	finally
    //   145	149	432	finally
    //   161	166	432	finally
    //   183	188	432	finally
    //   200	207	432	finally
    //   258	263	432	finally
    //   280	285	432	finally
    //   324	329	432	finally
    //   334	339	432	finally
    //   349	354	432	finally
    //   359	364	432	finally
    //   364	367	432	finally
    //   421	429	432	finally
    //   83	90	440	java/io/IOException
    //   102	110	440	java/io/IOException
    //   127	133	440	java/io/IOException
    //   145	149	440	java/io/IOException
    //   161	166	440	java/io/IOException
    //   183	188	440	java/io/IOException
    //   200	207	440	java/io/IOException
    //   280	285	440	java/io/IOException
    //   421	429	440	java/io/IOException
    //   83	90	449	java/io/FileNotFoundException
    //   102	110	449	java/io/FileNotFoundException
    //   127	133	449	java/io/FileNotFoundException
    //   145	149	449	java/io/FileNotFoundException
    //   161	166	449	java/io/FileNotFoundException
    //   183	188	449	java/io/FileNotFoundException
    //   200	207	449	java/io/FileNotFoundException
    //   258	263	449	java/io/FileNotFoundException
    //   280	285	449	java/io/FileNotFoundException
    //   421	429	449	java/io/FileNotFoundException
    //   83	90	458	java/io/StreamCorruptedException
    //   102	110	458	java/io/StreamCorruptedException
    //   127	133	458	java/io/StreamCorruptedException
    //   145	149	458	java/io/StreamCorruptedException
    //   161	166	458	java/io/StreamCorruptedException
    //   183	188	458	java/io/StreamCorruptedException
    //   200	207	458	java/io/StreamCorruptedException
    //   258	263	458	java/io/StreamCorruptedException
    //   280	285	458	java/io/StreamCorruptedException
    //   421	429	458	java/io/StreamCorruptedException
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
    //   386	395	799	finally
    //   399	403	799	finally
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
  
  public Bitmap b(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.mLock)
    {
      paramString = (Bitmap)super.put(paramString, paramBitmap);
      return paramString;
    }
  }
  
  public String c(String paramString)
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
      g.b("clear cache");
      if (this.mNeedRecycle)
      {
        Iterator localIterator = entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          } else {
            g.c("ImageCache is broken");
          }
        }
      }
      super.clear();
      return;
    }
  }
  
  public String d(String paramString)
  {
    return c.b(paramString);
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recycle bitmap:");
      ((StringBuilder)localObject).append((String)paramEntry.getKey());
      g.b(((StringBuilder)localObject).toString());
      return true;
    }
    paramEntry = new StringBuilder();
    paramEntry.append("size=");
    paramEntry.append(size());
    g.b(paramEntry.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ImageCache
 * JD-Core Version:    0.7.0.1
 */