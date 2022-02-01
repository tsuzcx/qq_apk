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
  public static final String CACHE_DIR_PATH = SDCARD_PATH + FILE_CACHE_PATH;
  private static final float DEFAULT_LOAD_FACTOR = 0.75F;
  public static final String FILE_CACHE_PATH;
  public static final String SDCARD_PATH = Environment.getExternalStorageDirectory() + File.separator + "Tencent" + File.separator;
  private static final long serialVersionUID = 2533500844821654646L;
  private String mDiskCacheDirectory;
  protected Object mLock = new Object();
  private int mMaxEntries = 0;
  private boolean mNeedRecycle = true;
  
  static
  {
    FILE_CACHE_PATH = "QQSec" + File.separator;
  }
  
  public ImageCache(String paramString, int paramInt, Context paramContext)
  {
    super(paramInt, 0.75F, true);
    this.mMaxEntries = paramInt;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      paramString = CACHE_DIR_PATH;
    }
    for (;;)
    {
      this.mDiskCacheDirectory = paramContext.getCacheDir().getAbsolutePath();
      paramString = new File(this.mDiskCacheDirectory);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return;
      paramContext.getCacheDir().getAbsolutePath();
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
    //   92: aload_3
    //   93: monitorexit
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   101: goto -9 -> 92
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   109: aload_3
    //   110: monitorexit
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   123: goto -14 -> 109
    //   126: astore_1
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ImageCache
    //   0	129	1	paramString	String
    //   0	129	2	paramBitmap	Bitmap
    //   10	105	3	localObject	Object
    //   63	21	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   83	92	96	java/lang/Exception
    //   42	83	104	java/io/FileNotFoundException
    //   83	92	104	java/io/FileNotFoundException
    //   97	101	104	java/io/FileNotFoundException
    //   13	40	113	finally
    //   92	94	113	finally
    //   109	111	113	finally
    //   114	116	113	finally
    //   127	129	113	finally
    //   42	83	118	java/io/IOException
    //   83	92	118	java/io/IOException
    //   97	101	118	java/io/IOException
    //   42	83	126	finally
    //   83	92	126	finally
    //   97	101	126	finally
    //   105	109	126	finally
    //   119	123	126	finally
  }
  
  /* Error */
  public Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 42	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: aload 8
    //   21: invokevirtual 104	java/io/File:exists	()Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +46 -> 72
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 170	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 170	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: aload 12
    //   55: monitorexit
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   63: goto -10 -> 53
    //   66: astore_1
    //   67: aload 12
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: new 143	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 144	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_1
    //   80: new 173	java/io/FileInputStream
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore 5
    //   91: aload 5
    //   93: astore 6
    //   95: aload_1
    //   96: astore 7
    //   98: sipush 1024
    //   101: newarray byte
    //   103: astore 4
    //   105: aload 5
    //   107: astore 6
    //   109: aload_1
    //   110: astore 7
    //   112: aload 5
    //   114: aload 4
    //   116: invokevirtual 178	java/io/FileInputStream:read	([B)I
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_m1
    //   122: if_icmpne +163 -> 285
    //   125: aload 5
    //   127: astore 6
    //   129: aload_1
    //   130: astore 7
    //   132: aload_1
    //   133: invokevirtual 182	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   136: astore 4
    //   138: aload 5
    //   140: astore 6
    //   142: aload_1
    //   143: astore 7
    //   145: aload_1
    //   146: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   149: aload 5
    //   151: astore 6
    //   153: aload_1
    //   154: astore 7
    //   156: aload 5
    //   158: invokevirtual 183	java/io/FileInputStream:close	()V
    //   161: aload 5
    //   163: astore 6
    //   165: aload_1
    //   166: astore 7
    //   168: aload 4
    //   170: invokestatic 188	com/tencent/token/utils/m:a	([B)Landroid/graphics/Bitmap;
    //   173: astore 4
    //   175: aload 4
    //   177: astore 6
    //   179: aload 4
    //   181: ifnonnull +78 -> 259
    //   184: new 190	java/io/ObjectInputStream
    //   187: dup
    //   188: new 173	java/io/FileInputStream
    //   191: dup
    //   192: aload 8
    //   194: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokespecial 193	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   200: astore 10
    //   202: aload 10
    //   204: astore 6
    //   206: aload 10
    //   208: invokevirtual 197	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   211: checkcast 199	[B
    //   214: checkcast 199	[B
    //   217: invokestatic 188	com/tencent/token/utils/m:a	([B)Landroid/graphics/Bitmap;
    //   220: astore 7
    //   222: aload 7
    //   224: astore 4
    //   226: aload 4
    //   228: astore 6
    //   230: aload 10
    //   232: ifnull +27 -> 259
    //   235: aload 4
    //   237: astore 8
    //   239: aload 4
    //   241: astore 9
    //   243: aload 5
    //   245: astore 6
    //   247: aload_1
    //   248: astore 7
    //   250: aload 10
    //   252: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   255: aload 4
    //   257: astore 6
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 183	java/io/FileInputStream:close	()V
    //   277: aload 6
    //   279: astore_1
    //   280: aload 12
    //   282: monitorexit
    //   283: aload_1
    //   284: areturn
    //   285: aload 5
    //   287: astore 6
    //   289: aload_1
    //   290: astore 7
    //   292: aload_1
    //   293: aload 4
    //   295: iconst_0
    //   296: iload_2
    //   297: invokevirtual 204	java/io/ByteArrayOutputStream:write	([BII)V
    //   300: goto -195 -> 105
    //   303: astore 6
    //   305: aload 5
    //   307: astore 4
    //   309: aload_1
    //   310: astore 5
    //   312: aconst_null
    //   313: astore_1
    //   314: aload 6
    //   316: invokevirtual 205	java/io/StreamCorruptedException:printStackTrace	()V
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 183	java/io/FileInputStream:close	()V
    //   339: goto -59 -> 280
    //   342: astore 9
    //   344: aload 5
    //   346: astore 6
    //   348: aload_1
    //   349: astore 7
    //   351: aload 9
    //   353: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   356: goto -195 -> 161
    //   359: astore 8
    //   361: aconst_null
    //   362: astore 4
    //   364: aload 5
    //   366: astore 6
    //   368: aload_1
    //   369: astore 7
    //   371: aload 8
    //   373: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   376: aload_1
    //   377: ifnull +7 -> 384
    //   380: aload_1
    //   381: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   384: aload 5
    //   386: ifnull +8 -> 394
    //   389: aload 5
    //   391: invokevirtual 183	java/io/FileInputStream:close	()V
    //   394: aload 4
    //   396: astore_1
    //   397: goto -117 -> 280
    //   400: astore 11
    //   402: aload 4
    //   404: astore 8
    //   406: aload 4
    //   408: astore 9
    //   410: aload 4
    //   412: astore 10
    //   414: aload 5
    //   416: astore 6
    //   418: aload_1
    //   419: astore 7
    //   421: aload 11
    //   423: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   426: aload 4
    //   428: astore 6
    //   430: goto -171 -> 259
    //   433: astore 6
    //   435: aload 5
    //   437: astore 4
    //   439: aload_1
    //   440: astore 5
    //   442: aload 8
    //   444: astore_1
    //   445: goto -131 -> 314
    //   448: astore 7
    //   450: aconst_null
    //   451: astore 10
    //   453: aload 10
    //   455: astore 6
    //   457: aload 7
    //   459: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   462: aload 4
    //   464: astore 6
    //   466: aload 10
    //   468: ifnull -209 -> 259
    //   471: aload 4
    //   473: astore 8
    //   475: aload 4
    //   477: astore 9
    //   479: aload 5
    //   481: astore 6
    //   483: aload_1
    //   484: astore 7
    //   486: aload 10
    //   488: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   491: aload 4
    //   493: astore 6
    //   495: goto -236 -> 259
    //   498: astore 11
    //   500: aload 4
    //   502: astore 8
    //   504: aload 4
    //   506: astore 9
    //   508: aload 4
    //   510: astore 10
    //   512: aload 5
    //   514: astore 6
    //   516: aload_1
    //   517: astore 7
    //   519: aload 11
    //   521: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   524: aload 4
    //   526: astore 6
    //   528: goto -269 -> 259
    //   531: astore 8
    //   533: aload 9
    //   535: astore 4
    //   537: goto -173 -> 364
    //   540: astore 11
    //   542: aconst_null
    //   543: astore 10
    //   545: aload 10
    //   547: ifnull +23 -> 570
    //   550: aload 4
    //   552: astore 8
    //   554: aload 4
    //   556: astore 9
    //   558: aload 5
    //   560: astore 6
    //   562: aload_1
    //   563: astore 7
    //   565: aload 10
    //   567: invokevirtual 200	java/io/ObjectInputStream:close	()V
    //   570: aload 4
    //   572: astore 8
    //   574: aload 4
    //   576: astore 9
    //   578: aload 4
    //   580: astore 10
    //   582: aload 5
    //   584: astore 6
    //   586: aload_1
    //   587: astore 7
    //   589: aload 11
    //   591: athrow
    //   592: astore 8
    //   594: aload 10
    //   596: astore 4
    //   598: aload 5
    //   600: astore 6
    //   602: aload_1
    //   603: astore 7
    //   605: aload 8
    //   607: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   610: aload_1
    //   611: ifnull +7 -> 618
    //   614: aload_1
    //   615: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   618: aload 5
    //   620: ifnull +8 -> 628
    //   623: aload 5
    //   625: invokevirtual 183	java/io/FileInputStream:close	()V
    //   628: aload 4
    //   630: astore_1
    //   631: goto -351 -> 280
    //   634: astore 13
    //   636: aload 4
    //   638: astore 8
    //   640: aload 4
    //   642: astore 9
    //   644: aload 4
    //   646: astore 10
    //   648: aload 5
    //   650: astore 6
    //   652: aload_1
    //   653: astore 7
    //   655: aload 13
    //   657: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   660: goto -90 -> 570
    //   663: astore 4
    //   665: aload 7
    //   667: astore_1
    //   668: aload_1
    //   669: ifnull +7 -> 676
    //   672: aload_1
    //   673: invokevirtual 161	java/io/ByteArrayOutputStream:close	()V
    //   676: aload 6
    //   678: ifnull +8 -> 686
    //   681: aload 6
    //   683: invokevirtual 183	java/io/FileInputStream:close	()V
    //   686: aload 4
    //   688: athrow
    //   689: astore_1
    //   690: aload_1
    //   691: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   694: aload 6
    //   696: astore_1
    //   697: goto -417 -> 280
    //   700: astore 4
    //   702: aload 4
    //   704: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   707: goto -427 -> 280
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   715: aload 4
    //   717: astore_1
    //   718: goto -438 -> 280
    //   721: astore_1
    //   722: aload_1
    //   723: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   726: aload 4
    //   728: astore_1
    //   729: goto -449 -> 280
    //   732: astore_1
    //   733: aload_1
    //   734: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   737: goto -51 -> 686
    //   740: astore 4
    //   742: aconst_null
    //   743: astore 6
    //   745: aconst_null
    //   746: astore_1
    //   747: goto -79 -> 668
    //   750: astore 4
    //   752: aconst_null
    //   753: astore 6
    //   755: goto -87 -> 668
    //   758: astore 7
    //   760: aload 5
    //   762: astore_1
    //   763: aload 4
    //   765: astore 6
    //   767: aload 7
    //   769: astore 4
    //   771: goto -103 -> 668
    //   774: astore 8
    //   776: aconst_null
    //   777: astore 5
    //   779: aconst_null
    //   780: astore_1
    //   781: aconst_null
    //   782: astore 4
    //   784: goto -186 -> 598
    //   787: astore 8
    //   789: aconst_null
    //   790: astore 5
    //   792: aconst_null
    //   793: astore 4
    //   795: goto -197 -> 598
    //   798: astore 8
    //   800: aconst_null
    //   801: astore 4
    //   803: goto -205 -> 598
    //   806: astore 8
    //   808: aconst_null
    //   809: astore 5
    //   811: aconst_null
    //   812: astore_1
    //   813: aconst_null
    //   814: astore 4
    //   816: goto -452 -> 364
    //   819: astore 8
    //   821: aconst_null
    //   822: astore 5
    //   824: aconst_null
    //   825: astore 4
    //   827: goto -463 -> 364
    //   830: astore 6
    //   832: aconst_null
    //   833: astore 5
    //   835: aconst_null
    //   836: astore_1
    //   837: aconst_null
    //   838: astore 4
    //   840: goto -526 -> 314
    //   843: astore 6
    //   845: aconst_null
    //   846: astore 7
    //   848: aconst_null
    //   849: astore 4
    //   851: aload_1
    //   852: astore 5
    //   854: aload 7
    //   856: astore_1
    //   857: goto -543 -> 314
    //   860: astore 11
    //   862: aload 6
    //   864: astore 10
    //   866: goto -321 -> 545
    //   869: astore 7
    //   871: goto -418 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	ImageCache
    //   0	874	1	paramString	String
    //   119	178	2	i	int
    //   24	2	3	bool	boolean
    //   103	542	4	localObject1	Object
    //   663	24	4	localObject2	Object
    //   700	27	4	localIOException1	java.io.IOException
    //   740	1	4	localObject3	Object
    //   750	14	4	localObject4	Object
    //   769	81	4	localObject5	Object
    //   89	764	5	localObject6	Object
    //   93	195	6	localObject7	Object
    //   303	12	6	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   346	83	6	localObject8	Object
    //   433	1	6	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   455	311	6	localObject9	Object
    //   830	1	6	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   843	20	6	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   96	324	7	localObject10	Object
    //   448	10	7	localException1	Exception
    //   484	182	7	str	String
    //   758	10	7	localObject11	Object
    //   846	9	7	localObject12	Object
    //   869	1	7	localException2	Exception
    //   17	221	8	localObject13	Object
    //   359	13	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   404	99	8	localObject14	Object
    //   531	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   552	21	8	localObject15	Object
    //   592	14	8	localIOException2	java.io.IOException
    //   638	1	8	localObject16	Object
    //   774	1	8	localIOException3	java.io.IOException
    //   787	1	8	localIOException4	java.io.IOException
    //   798	1	8	localIOException5	java.io.IOException
    //   806	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   819	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   241	1	9	localObject17	Object
    //   342	10	9	localException3	Exception
    //   408	235	9	localObject18	Object
    //   200	665	10	localObject19	Object
    //   400	22	11	localIOException6	java.io.IOException
    //   498	22	11	localIOException7	java.io.IOException
    //   540	50	11	localObject20	Object
    //   860	1	11	localObject21	Object
    //   4	277	12	localObject22	Object
    //   634	22	13	localIOException8	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   33	41	58	java/io/IOException
    //   45	53	58	java/io/IOException
    //   33	41	66	finally
    //   45	53	66	finally
    //   53	56	66	finally
    //   59	63	66	finally
    //   67	70	66	finally
    //   263	267	66	finally
    //   272	277	66	finally
    //   280	283	66	finally
    //   324	329	66	finally
    //   334	339	66	finally
    //   380	384	66	finally
    //   389	394	66	finally
    //   614	618	66	finally
    //   623	628	66	finally
    //   672	676	66	finally
    //   681	686	66	finally
    //   686	689	66	finally
    //   690	694	66	finally
    //   702	707	66	finally
    //   711	715	66	finally
    //   722	726	66	finally
    //   733	737	66	finally
    //   98	105	303	java/io/StreamCorruptedException
    //   112	120	303	java/io/StreamCorruptedException
    //   132	138	303	java/io/StreamCorruptedException
    //   145	149	303	java/io/StreamCorruptedException
    //   156	161	303	java/io/StreamCorruptedException
    //   168	175	303	java/io/StreamCorruptedException
    //   292	300	303	java/io/StreamCorruptedException
    //   351	356	303	java/io/StreamCorruptedException
    //   145	149	342	java/lang/Exception
    //   156	161	342	java/lang/Exception
    //   98	105	359	java/io/FileNotFoundException
    //   112	120	359	java/io/FileNotFoundException
    //   132	138	359	java/io/FileNotFoundException
    //   145	149	359	java/io/FileNotFoundException
    //   156	161	359	java/io/FileNotFoundException
    //   168	175	359	java/io/FileNotFoundException
    //   292	300	359	java/io/FileNotFoundException
    //   351	356	359	java/io/FileNotFoundException
    //   250	255	400	java/io/IOException
    //   250	255	433	java/io/StreamCorruptedException
    //   421	426	433	java/io/StreamCorruptedException
    //   486	491	433	java/io/StreamCorruptedException
    //   519	524	433	java/io/StreamCorruptedException
    //   565	570	433	java/io/StreamCorruptedException
    //   589	592	433	java/io/StreamCorruptedException
    //   655	660	433	java/io/StreamCorruptedException
    //   184	202	448	java/lang/Exception
    //   486	491	498	java/io/IOException
    //   250	255	531	java/io/FileNotFoundException
    //   421	426	531	java/io/FileNotFoundException
    //   486	491	531	java/io/FileNotFoundException
    //   519	524	531	java/io/FileNotFoundException
    //   565	570	531	java/io/FileNotFoundException
    //   589	592	531	java/io/FileNotFoundException
    //   655	660	531	java/io/FileNotFoundException
    //   184	202	540	finally
    //   421	426	592	java/io/IOException
    //   519	524	592	java/io/IOException
    //   589	592	592	java/io/IOException
    //   655	660	592	java/io/IOException
    //   565	570	634	java/io/IOException
    //   98	105	663	finally
    //   112	120	663	finally
    //   132	138	663	finally
    //   145	149	663	finally
    //   156	161	663	finally
    //   168	175	663	finally
    //   250	255	663	finally
    //   292	300	663	finally
    //   351	356	663	finally
    //   371	376	663	finally
    //   421	426	663	finally
    //   486	491	663	finally
    //   519	524	663	finally
    //   565	570	663	finally
    //   589	592	663	finally
    //   605	610	663	finally
    //   655	660	663	finally
    //   263	267	689	java/io/IOException
    //   272	277	689	java/io/IOException
    //   324	329	700	java/io/IOException
    //   334	339	700	java/io/IOException
    //   380	384	710	java/io/IOException
    //   389	394	710	java/io/IOException
    //   614	618	721	java/io/IOException
    //   623	628	721	java/io/IOException
    //   672	676	732	java/io/IOException
    //   681	686	732	java/io/IOException
    //   9	25	740	finally
    //   72	80	740	finally
    //   80	91	750	finally
    //   314	319	758	finally
    //   9	25	774	java/io/IOException
    //   72	80	774	java/io/IOException
    //   80	91	787	java/io/IOException
    //   98	105	798	java/io/IOException
    //   112	120	798	java/io/IOException
    //   132	138	798	java/io/IOException
    //   145	149	798	java/io/IOException
    //   156	161	798	java/io/IOException
    //   168	175	798	java/io/IOException
    //   292	300	798	java/io/IOException
    //   351	356	798	java/io/IOException
    //   9	25	806	java/io/FileNotFoundException
    //   72	80	806	java/io/FileNotFoundException
    //   80	91	819	java/io/FileNotFoundException
    //   9	25	830	java/io/StreamCorruptedException
    //   72	80	830	java/io/StreamCorruptedException
    //   80	91	843	java/io/StreamCorruptedException
    //   206	222	860	finally
    //   457	462	860	finally
    //   206	222	869	java/lang/Exception
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
    return this.mDiskCacheDirectory + File.separator + paramString;
  }
  
  public void clear()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        g.b("clear cache");
        if (!this.mNeedRecycle) {
          break;
        }
        Iterator localIterator = entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
      }
      g.c("ImageCache is broken");
    }
    super.clear();
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
        Bitmap localBitmap = (Bitmap)paramEntry.getValue();
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
      }
      g.b("recycle bitmap:" + (String)paramEntry.getKey());
      return true;
    }
    g.b("size=" + size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ImageCache
 * JD-Core Version:    0.7.0.1
 */