package com.tencent.token.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.c;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ImageCache
  extends LinkedHashMap
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
  
  public ImageCache(int paramInt, Context paramContext)
  {
    super(paramInt, 0.75F, true);
    this.mMaxEntries = paramInt;
    if (!"mounted".equals(Environment.getExternalStorageState())) {
      paramContext.getCacheDir().getAbsolutePath();
    }
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
    return c.b(paramString);
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
    //   7: getfield 75	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: monitorenter
    //   13: new 41	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 103	java/io/File:exists	()Z
    //   26: ifeq +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 139	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +7 -> 42
    //   38: aload_3
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 142	java/io/File:createNewFile	()Z
    //   46: pop
    //   47: new 144	java/io/FileOutputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   55: astore_1
    //   56: new 149	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 150	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore 4
    //   65: aload_2
    //   66: getstatic 156	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 100
    //   71: aload 4
    //   73: invokevirtual 160	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 4
    //   79: aload_1
    //   80: invokevirtual 164	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   83: aload 4
    //   85: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_1
    //   89: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   92: aload_3
    //   93: monitorexit
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   101: goto -9 -> 92
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 169	java/io/FileNotFoundException:printStackTrace	()V
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
    //   120: invokevirtual 170	java/io/IOException:printStackTrace	()V
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
  public final Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/token/utils/ImageCache:mLock	Ljava/lang/Object;
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 41	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 8
    //   19: aload 8
    //   21: invokevirtual 103	java/io/File:exists	()Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +8 -> 34
    //   29: aload 12
    //   31: monitorexit
    //   32: aconst_null
    //   33: areturn
    //   34: new 149	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 150	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore_1
    //   42: new 175	java/io/FileInputStream
    //   45: dup
    //   46: aload 8
    //   48: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore 5
    //   53: aload 5
    //   55: astore 6
    //   57: aload_1
    //   58: astore 7
    //   60: sipush 1024
    //   63: newarray byte
    //   65: astore 4
    //   67: aload 5
    //   69: astore 6
    //   71: aload_1
    //   72: astore 7
    //   74: aload 5
    //   76: aload 4
    //   78: invokevirtual 180	java/io/FileInputStream:read	([B)I
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_m1
    //   84: if_icmpeq +68 -> 152
    //   87: aload 5
    //   89: astore 6
    //   91: aload_1
    //   92: astore 7
    //   94: aload_1
    //   95: aload 4
    //   97: iconst_0
    //   98: iload_2
    //   99: invokevirtual 184	java/io/ByteArrayOutputStream:write	([BII)V
    //   102: goto -35 -> 67
    //   105: astore 6
    //   107: aload 5
    //   109: astore 4
    //   111: aload_1
    //   112: astore 5
    //   114: aconst_null
    //   115: astore_1
    //   116: aload 6
    //   118: invokevirtual 185	java/io/StreamCorruptedException:printStackTrace	()V
    //   121: aload 5
    //   123: ifnull +8 -> 131
    //   126: aload 5
    //   128: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 186	java/io/FileInputStream:close	()V
    //   141: aload 12
    //   143: monitorexit
    //   144: aload_1
    //   145: areturn
    //   146: astore_1
    //   147: aload 12
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: aload 5
    //   154: astore 6
    //   156: aload_1
    //   157: astore 7
    //   159: aload_1
    //   160: invokevirtual 190	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   163: astore 4
    //   165: aload 5
    //   167: astore 6
    //   169: aload_1
    //   170: astore 7
    //   172: aload_1
    //   173: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   176: aload 5
    //   178: astore 6
    //   180: aload_1
    //   181: astore 7
    //   183: aload 5
    //   185: invokevirtual 186	java/io/FileInputStream:close	()V
    //   188: aload 5
    //   190: astore 6
    //   192: aload_1
    //   193: astore 7
    //   195: aload 4
    //   197: invokestatic 195	com/tencent/token/utils/t:a	([B)Landroid/graphics/Bitmap;
    //   200: astore 4
    //   202: aload 4
    //   204: astore 6
    //   206: aload 4
    //   208: ifnonnull +66 -> 274
    //   211: new 197	java/io/ObjectInputStream
    //   214: dup
    //   215: new 175	java/io/FileInputStream
    //   218: dup
    //   219: aload 8
    //   221: invokespecial 176	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 200	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   227: astore 10
    //   229: aload 10
    //   231: astore 6
    //   233: aload 10
    //   235: invokevirtual 204	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   238: checkcast 206	[B
    //   241: invokestatic 195	com/tencent/token/utils/t:a	([B)Landroid/graphics/Bitmap;
    //   244: astore 7
    //   246: aload 7
    //   248: astore 4
    //   250: aload 4
    //   252: astore 8
    //   254: aload 4
    //   256: astore 9
    //   258: aload 5
    //   260: astore 6
    //   262: aload_1
    //   263: astore 7
    //   265: aload 10
    //   267: invokevirtual 207	java/io/ObjectInputStream:close	()V
    //   270: aload 4
    //   272: astore 6
    //   274: aload_1
    //   275: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   278: aload 5
    //   280: invokevirtual 186	java/io/FileInputStream:close	()V
    //   283: aload 6
    //   285: astore_1
    //   286: goto -145 -> 141
    //   289: astore 9
    //   291: aload 5
    //   293: astore 6
    //   295: aload_1
    //   296: astore 7
    //   298: aload 9
    //   300: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   303: goto -115 -> 188
    //   306: astore 8
    //   308: aconst_null
    //   309: astore 4
    //   311: aload 5
    //   313: astore 6
    //   315: aload_1
    //   316: astore 7
    //   318: aload 8
    //   320: invokevirtual 169	java/io/FileNotFoundException:printStackTrace	()V
    //   323: aload_1
    //   324: ifnull +7 -> 331
    //   327: aload_1
    //   328: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   331: aload 5
    //   333: ifnull +8 -> 341
    //   336: aload 5
    //   338: invokevirtual 186	java/io/FileInputStream:close	()V
    //   341: aload 4
    //   343: astore_1
    //   344: goto -203 -> 141
    //   347: astore 11
    //   349: aload 4
    //   351: astore 8
    //   353: aload 4
    //   355: astore 9
    //   357: aload 4
    //   359: astore 10
    //   361: aload 5
    //   363: astore 6
    //   365: aload_1
    //   366: astore 7
    //   368: aload 11
    //   370: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   373: aload 4
    //   375: astore 6
    //   377: goto -103 -> 274
    //   380: astore 6
    //   382: aload 5
    //   384: astore 4
    //   386: aload_1
    //   387: astore 5
    //   389: aload 8
    //   391: astore_1
    //   392: goto -276 -> 116
    //   395: astore 7
    //   397: aconst_null
    //   398: astore 10
    //   400: aload 10
    //   402: astore 6
    //   404: aload 7
    //   406: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   409: aload 4
    //   411: astore 6
    //   413: aload 10
    //   415: ifnull -141 -> 274
    //   418: aload 4
    //   420: astore 8
    //   422: aload 4
    //   424: astore 9
    //   426: aload 5
    //   428: astore 6
    //   430: aload_1
    //   431: astore 7
    //   433: aload 10
    //   435: invokevirtual 207	java/io/ObjectInputStream:close	()V
    //   438: aload 4
    //   440: astore 6
    //   442: goto -168 -> 274
    //   445: astore 11
    //   447: aload 4
    //   449: astore 8
    //   451: aload 4
    //   453: astore 9
    //   455: aload 4
    //   457: astore 10
    //   459: aload 5
    //   461: astore 6
    //   463: aload_1
    //   464: astore 7
    //   466: aload 11
    //   468: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   471: aload 4
    //   473: astore 6
    //   475: goto -201 -> 274
    //   478: astore 8
    //   480: aload 9
    //   482: astore 4
    //   484: goto -173 -> 311
    //   487: astore 11
    //   489: aconst_null
    //   490: astore 10
    //   492: aload 10
    //   494: ifnull +23 -> 517
    //   497: aload 4
    //   499: astore 8
    //   501: aload 4
    //   503: astore 9
    //   505: aload 5
    //   507: astore 6
    //   509: aload_1
    //   510: astore 7
    //   512: aload 10
    //   514: invokevirtual 207	java/io/ObjectInputStream:close	()V
    //   517: aload 4
    //   519: astore 8
    //   521: aload 4
    //   523: astore 9
    //   525: aload 4
    //   527: astore 10
    //   529: aload 5
    //   531: astore 6
    //   533: aload_1
    //   534: astore 7
    //   536: aload 11
    //   538: athrow
    //   539: astore 8
    //   541: aload 10
    //   543: astore 4
    //   545: aload 5
    //   547: astore 6
    //   549: aload_1
    //   550: astore 7
    //   552: aload 8
    //   554: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   557: aload_1
    //   558: ifnull +7 -> 565
    //   561: aload_1
    //   562: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   565: aload 5
    //   567: ifnull +8 -> 575
    //   570: aload 5
    //   572: invokevirtual 186	java/io/FileInputStream:close	()V
    //   575: aload 4
    //   577: astore_1
    //   578: goto -437 -> 141
    //   581: astore 13
    //   583: aload 4
    //   585: astore 8
    //   587: aload 4
    //   589: astore 9
    //   591: aload 4
    //   593: astore 10
    //   595: aload 5
    //   597: astore 6
    //   599: aload_1
    //   600: astore 7
    //   602: aload 13
    //   604: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   607: goto -90 -> 517
    //   610: astore 4
    //   612: aload 7
    //   614: astore_1
    //   615: aload_1
    //   616: ifnull +7 -> 623
    //   619: aload_1
    //   620: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   623: aload 6
    //   625: ifnull +8 -> 633
    //   628: aload 6
    //   630: invokevirtual 186	java/io/FileInputStream:close	()V
    //   633: aload 4
    //   635: athrow
    //   636: astore_1
    //   637: aload_1
    //   638: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   641: aload 6
    //   643: astore_1
    //   644: goto -503 -> 141
    //   647: astore 4
    //   649: aload 4
    //   651: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   654: goto -513 -> 141
    //   657: astore_1
    //   658: aload_1
    //   659: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   662: aload 4
    //   664: astore_1
    //   665: goto -524 -> 141
    //   668: astore_1
    //   669: aload_1
    //   670: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   673: aload 4
    //   675: astore_1
    //   676: goto -535 -> 141
    //   679: astore_1
    //   680: aload_1
    //   681: invokevirtual 170	java/io/IOException:printStackTrace	()V
    //   684: goto -51 -> 633
    //   687: astore 4
    //   689: aconst_null
    //   690: astore 6
    //   692: aconst_null
    //   693: astore_1
    //   694: goto -79 -> 615
    //   697: astore 4
    //   699: aconst_null
    //   700: astore 6
    //   702: goto -87 -> 615
    //   705: astore 7
    //   707: aload 5
    //   709: astore_1
    //   710: aload 4
    //   712: astore 6
    //   714: aload 7
    //   716: astore 4
    //   718: goto -103 -> 615
    //   721: astore 8
    //   723: aconst_null
    //   724: astore 5
    //   726: aconst_null
    //   727: astore_1
    //   728: aconst_null
    //   729: astore 4
    //   731: goto -186 -> 545
    //   734: astore 8
    //   736: aconst_null
    //   737: astore 5
    //   739: aconst_null
    //   740: astore 4
    //   742: goto -197 -> 545
    //   745: astore 8
    //   747: aconst_null
    //   748: astore 4
    //   750: goto -205 -> 545
    //   753: astore 8
    //   755: aconst_null
    //   756: astore 5
    //   758: aconst_null
    //   759: astore_1
    //   760: aconst_null
    //   761: astore 4
    //   763: goto -452 -> 311
    //   766: astore 8
    //   768: aconst_null
    //   769: astore 5
    //   771: aconst_null
    //   772: astore 4
    //   774: goto -463 -> 311
    //   777: astore 6
    //   779: aconst_null
    //   780: astore 5
    //   782: aconst_null
    //   783: astore_1
    //   784: aconst_null
    //   785: astore 4
    //   787: goto -671 -> 116
    //   790: astore 6
    //   792: aconst_null
    //   793: astore 7
    //   795: aconst_null
    //   796: astore 4
    //   798: aload_1
    //   799: astore 5
    //   801: aload 7
    //   803: astore_1
    //   804: goto -688 -> 116
    //   807: astore 11
    //   809: aload 6
    //   811: astore 10
    //   813: goto -321 -> 492
    //   816: astore 7
    //   818: goto -418 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	this	ImageCache
    //   0	821	1	paramString	String
    //   81	18	2	i	int
    //   24	2	3	bool	boolean
    //   65	527	4	localObject1	Object
    //   610	24	4	localObject2	Object
    //   647	27	4	localIOException1	java.io.IOException
    //   687	1	4	localObject3	Object
    //   697	14	4	localObject4	Object
    //   716	81	4	localObject5	Object
    //   51	749	5	localObject6	Object
    //   55	35	6	localObject7	Object
    //   105	12	6	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   154	222	6	localObject8	Object
    //   380	1	6	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   402	311	6	localObject9	Object
    //   777	1	6	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   790	20	6	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   58	309	7	localObject10	Object
    //   395	10	7	localException1	Exception
    //   431	182	7	str	String
    //   705	10	7	localObject11	Object
    //   793	9	7	localObject12	Object
    //   816	1	7	localException2	Exception
    //   17	236	8	localObject13	Object
    //   306	13	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   351	99	8	localObject14	Object
    //   478	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   499	21	8	localObject15	Object
    //   539	14	8	localIOException2	java.io.IOException
    //   585	1	8	localObject16	Object
    //   721	1	8	localIOException3	java.io.IOException
    //   734	1	8	localIOException4	java.io.IOException
    //   745	1	8	localIOException5	java.io.IOException
    //   753	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   766	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   256	1	9	localObject17	Object
    //   289	10	9	localException3	Exception
    //   355	235	9	localObject18	Object
    //   227	585	10	localObject19	Object
    //   347	22	11	localIOException6	java.io.IOException
    //   445	22	11	localIOException7	java.io.IOException
    //   487	50	11	localObject20	Object
    //   807	1	11	localObject21	Object
    //   4	144	12	localObject22	Object
    //   581	22	13	localIOException8	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   60	67	105	java/io/StreamCorruptedException
    //   74	82	105	java/io/StreamCorruptedException
    //   94	102	105	java/io/StreamCorruptedException
    //   159	165	105	java/io/StreamCorruptedException
    //   172	176	105	java/io/StreamCorruptedException
    //   183	188	105	java/io/StreamCorruptedException
    //   195	202	105	java/io/StreamCorruptedException
    //   298	303	105	java/io/StreamCorruptedException
    //   29	32	146	finally
    //   126	131	146	finally
    //   136	141	146	finally
    //   141	144	146	finally
    //   274	283	146	finally
    //   327	331	146	finally
    //   336	341	146	finally
    //   561	565	146	finally
    //   570	575	146	finally
    //   619	623	146	finally
    //   628	633	146	finally
    //   633	636	146	finally
    //   637	641	146	finally
    //   649	654	146	finally
    //   658	662	146	finally
    //   669	673	146	finally
    //   680	684	146	finally
    //   172	176	289	java/lang/Exception
    //   183	188	289	java/lang/Exception
    //   60	67	306	java/io/FileNotFoundException
    //   74	82	306	java/io/FileNotFoundException
    //   94	102	306	java/io/FileNotFoundException
    //   159	165	306	java/io/FileNotFoundException
    //   172	176	306	java/io/FileNotFoundException
    //   183	188	306	java/io/FileNotFoundException
    //   195	202	306	java/io/FileNotFoundException
    //   298	303	306	java/io/FileNotFoundException
    //   265	270	347	java/io/IOException
    //   265	270	380	java/io/StreamCorruptedException
    //   368	373	380	java/io/StreamCorruptedException
    //   433	438	380	java/io/StreamCorruptedException
    //   466	471	380	java/io/StreamCorruptedException
    //   512	517	380	java/io/StreamCorruptedException
    //   536	539	380	java/io/StreamCorruptedException
    //   602	607	380	java/io/StreamCorruptedException
    //   211	229	395	java/lang/Exception
    //   433	438	445	java/io/IOException
    //   265	270	478	java/io/FileNotFoundException
    //   368	373	478	java/io/FileNotFoundException
    //   433	438	478	java/io/FileNotFoundException
    //   466	471	478	java/io/FileNotFoundException
    //   512	517	478	java/io/FileNotFoundException
    //   536	539	478	java/io/FileNotFoundException
    //   602	607	478	java/io/FileNotFoundException
    //   211	229	487	finally
    //   368	373	539	java/io/IOException
    //   466	471	539	java/io/IOException
    //   536	539	539	java/io/IOException
    //   602	607	539	java/io/IOException
    //   512	517	581	java/io/IOException
    //   60	67	610	finally
    //   74	82	610	finally
    //   94	102	610	finally
    //   159	165	610	finally
    //   172	176	610	finally
    //   183	188	610	finally
    //   195	202	610	finally
    //   265	270	610	finally
    //   298	303	610	finally
    //   318	323	610	finally
    //   368	373	610	finally
    //   433	438	610	finally
    //   466	471	610	finally
    //   512	517	610	finally
    //   536	539	610	finally
    //   552	557	610	finally
    //   602	607	610	finally
    //   274	283	636	java/io/IOException
    //   126	131	647	java/io/IOException
    //   136	141	647	java/io/IOException
    //   327	331	657	java/io/IOException
    //   336	341	657	java/io/IOException
    //   561	565	668	java/io/IOException
    //   570	575	668	java/io/IOException
    //   619	623	679	java/io/IOException
    //   628	633	679	java/io/IOException
    //   9	25	687	finally
    //   34	42	687	finally
    //   42	53	697	finally
    //   116	121	705	finally
    //   9	25	721	java/io/IOException
    //   34	42	721	java/io/IOException
    //   42	53	734	java/io/IOException
    //   60	67	745	java/io/IOException
    //   74	82	745	java/io/IOException
    //   94	102	745	java/io/IOException
    //   159	165	745	java/io/IOException
    //   172	176	745	java/io/IOException
    //   183	188	745	java/io/IOException
    //   195	202	745	java/io/IOException
    //   298	303	745	java/io/IOException
    //   9	25	753	java/io/FileNotFoundException
    //   34	42	753	java/io/FileNotFoundException
    //   42	53	766	java/io/FileNotFoundException
    //   9	25	777	java/io/StreamCorruptedException
    //   34	42	777	java/io/StreamCorruptedException
    //   42	53	790	java/io/StreamCorruptedException
    //   233	246	807	finally
    //   404	409	807	finally
    //   233	246	816	java/lang/Exception
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
    return this.mDiskCacheDirectory + File.separator + paramString;
  }
  
  public void clear()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        e.b("clear cache");
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
      e.c("ImageCache is broken");
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
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
      e.b("recycle bitmap:" + (String)paramEntry.getKey());
      return true;
    }
    e.b("size=" + size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.ImageCache
 * JD-Core Version:    0.7.0.1
 */