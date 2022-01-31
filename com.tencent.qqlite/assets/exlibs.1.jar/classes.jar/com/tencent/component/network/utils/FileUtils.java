package com.tencent.component.network.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;

public class FileUtils
{
  public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new b();
  public static final FileComparator SIMPLE_COMPARATOR = new a();
  private static final BytesBufferPool a = new BytesBufferPool(2, 8192);
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  /* Error */
  private static boolean a(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 51	com/tencent/component/network/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 51	com/tencent/component/network/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 9
    //   28: new 59	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 66	java/io/File:exists	()Z
    //   43: ifeq +47 -> 90
    //   46: aload_3
    //   47: ifnull +30 -> 77
    //   50: aload_3
    //   51: aload_0
    //   52: aload_1
    //   53: aload 8
    //   55: invokeinterface 70 4 0
    //   60: istore 5
    //   62: iload 5
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokevirtual 75	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 8
    //   87: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   90: aload 8
    //   92: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 86	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 66	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 89	java/io/File:mkdirs	()Z
    //   118: istore 5
    //   120: iload 5
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 9
    //   137: aload_1
    //   138: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: new 97	java/io/BufferedOutputStream
    //   145: dup
    //   146: new 99	java/io/FileOutputStream
    //   149: dup
    //   150: aload 8
    //   152: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 104	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_1
    //   159: sipush 1024
    //   162: newarray byte
    //   164: astore_2
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 110	java/io/InputStream:read	([B)I
    //   170: istore 4
    //   172: iload 4
    //   174: ifgt +13 -> 187
    //   177: aload_0
    //   178: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   181: aload_1
    //   182: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   185: iconst_1
    //   186: ireturn
    //   187: aload_1
    //   188: aload_2
    //   189: iconst_0
    //   190: iload 4
    //   192: invokevirtual 116	java/io/OutputStream:write	([BII)V
    //   195: goto -30 -> 165
    //   198: astore_3
    //   199: aload_1
    //   200: astore_2
    //   201: aload_3
    //   202: astore_1
    //   203: ldc 118
    //   205: ldc 120
    //   207: aload_1
    //   208: invokestatic 126	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload 8
    //   213: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   216: aload_0
    //   217: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   220: aload_2
    //   221: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: aload 7
    //   231: astore_2
    //   232: aload_0
    //   233: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   236: aload_2
    //   237: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload 7
    //   245: astore_2
    //   246: goto -14 -> 232
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload_3
    //   253: astore_1
    //   254: goto -22 -> 232
    //   257: astore_1
    //   258: goto -26 -> 232
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_0
    //   264: aload 6
    //   266: astore_2
    //   267: goto -64 -> 203
    //   270: astore_1
    //   271: aload 6
    //   273: astore_2
    //   274: goto -71 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   0	277	3	paramAssetFileComparator	AssetFileComparator
    //   170	21	4	i	int
    //   60	61	5	bool	boolean
    //   4	268	6	localObject1	Object
    //   1	243	7	localObject2	Object
    //   36	176	8	localFile	File
    //   26	110	9	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   159	165	198	java/lang/Throwable
    //   165	172	198	java/lang/Throwable
    //   187	195	198	java/lang/Throwable
    //   38	46	226	finally
    //   50	62	226	finally
    //   77	90	226	finally
    //   90	107	226	finally
    //   107	120	226	finally
    //   135	142	226	finally
    //   142	159	242	finally
    //   159	165	249	finally
    //   165	172	249	finally
    //   187	195	249	finally
    //   203	216	257	finally
    //   38	46	261	java/lang/Throwable
    //   50	62	261	java/lang/Throwable
    //   77	90	261	java/lang/Throwable
    //   90	107	261	java/lang/Throwable
    //   107	120	261	java/lang/Throwable
    //   135	142	261	java/lang/Throwable
    //   142	159	270	java/lang/Throwable
  }
  
  /* Error */
  private static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: ifnull +15 -> 32
    //   20: aload_2
    //   21: aload_0
    //   22: invokeinterface 133 2 0
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 66	java/io/File:exists	()Z
    //   36: ifeq +14 -> 50
    //   39: aload_0
    //   40: invokevirtual 86	java/io/File:isFile	()Z
    //   43: istore 4
    //   45: iload 4
    //   47: ifne +13 -> 60
    //   50: aconst_null
    //   51: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   54: aconst_null
    //   55: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload_1
    //   61: invokevirtual 66	java/io/File:exists	()Z
    //   64: ifeq +36 -> 100
    //   67: aload_3
    //   68: ifnull +28 -> 96
    //   71: aload_3
    //   72: aload_0
    //   73: aload_1
    //   74: invokeinterface 136 3 0
    //   79: istore 4
    //   81: iload 4
    //   83: ifeq +13 -> 96
    //   86: aconst_null
    //   87: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   90: aconst_null
    //   91: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   100: aload_1
    //   101: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 86	java/io/File:isFile	()Z
    //   109: ifeq +7 -> 116
    //   112: aload_2
    //   113: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   116: aload_2
    //   117: invokevirtual 66	java/io/File:exists	()Z
    //   120: ifne +24 -> 144
    //   123: aload_2
    //   124: invokevirtual 89	java/io/File:mkdirs	()Z
    //   127: istore 4
    //   129: iload 4
    //   131: ifne +13 -> 144
    //   134: aconst_null
    //   135: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   138: aconst_null
    //   139: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: new 138	java/io/FileInputStream
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: invokevirtual 143	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   155: astore_0
    //   156: new 99	java/io/FileOutputStream
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokevirtual 144	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   167: astore_3
    //   168: aload_3
    //   169: aload_0
    //   170: lconst_0
    //   171: aload_0
    //   172: invokevirtual 150	java/nio/channels/FileChannel:size	()J
    //   175: invokevirtual 154	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   178: pop2
    //   179: aload_0
    //   180: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   183: aload_3
    //   184: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_0
    //   192: aload 6
    //   194: astore_2
    //   195: ldc 118
    //   197: ldc 156
    //   199: aload_3
    //   200: invokestatic 126	com/tencent/component/network/downloader/impl/ipc/Const:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: invokestatic 79	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   207: aload_2
    //   208: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   211: aload_0
    //   212: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_0
    //   220: aload 5
    //   222: astore_2
    //   223: aload_0
    //   224: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   227: aload_2
    //   228: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: aload 5
    //   236: astore_2
    //   237: goto -14 -> 223
    //   240: astore_1
    //   241: aload_3
    //   242: astore_2
    //   243: goto -20 -> 223
    //   246: astore_1
    //   247: aload_0
    //   248: astore_3
    //   249: aload_2
    //   250: astore_0
    //   251: aload_3
    //   252: astore_2
    //   253: goto -30 -> 223
    //   256: astore_3
    //   257: aload_0
    //   258: astore_2
    //   259: aconst_null
    //   260: astore_0
    //   261: goto -66 -> 195
    //   264: astore 5
    //   266: aload_0
    //   267: astore_2
    //   268: aload_3
    //   269: astore_0
    //   270: aload 5
    //   272: astore_3
    //   273: goto -78 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramFile1	File
    //   0	276	1	paramFile2	File
    //   0	276	2	paramFileFilter	FileFilter
    //   0	276	3	paramFileComparator	FileComparator
    //   43	87	4	bool	boolean
    //   1	234	5	localObject1	Object
    //   264	7	5	localThrowable	Throwable
    //   4	189	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	45	189	java/lang/Throwable
    //   60	67	189	java/lang/Throwable
    //   71	81	189	java/lang/Throwable
    //   96	100	189	java/lang/Throwable
    //   100	116	189	java/lang/Throwable
    //   116	129	189	java/lang/Throwable
    //   144	156	189	java/lang/Throwable
    //   32	45	217	finally
    //   60	67	217	finally
    //   71	81	217	finally
    //   96	100	217	finally
    //   100	116	217	finally
    //   116	129	217	finally
    //   144	156	217	finally
    //   156	168	233	finally
    //   168	179	240	finally
    //   195	207	246	finally
    //   156	168	256	java/lang/Throwable
    //   168	179	264	java/lang/Throwable
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, AssetFileComparator paramAssetFileComparator)
  {
    return a(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  /* Error */
  public static boolean copyFile(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   16: invokevirtual 180	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   19: astore 5
    //   21: new 59	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 66	java/io/File:exists	()Z
    //   34: ifeq +12 -> 46
    //   37: aload_0
    //   38: invokevirtual 86	java/io/File:isFile	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +13 -> 56
    //   46: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   49: aload 5
    //   51: invokevirtual 184	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 138	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 139	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore 4
    //   66: aload 4
    //   68: astore_0
    //   69: aload 4
    //   71: aload 5
    //   73: getfield 190	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   76: iconst_0
    //   77: aload 5
    //   79: getfield 190	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   82: arraylength
    //   83: invokevirtual 193	java/io/InputStream:read	([BII)I
    //   86: istore_2
    //   87: iload_2
    //   88: ifgt +18 -> 106
    //   91: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   94: aload 5
    //   96: invokevirtual 184	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   99: aload 4
    //   101: invokevirtual 194	java/io/InputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: aload 4
    //   108: astore_0
    //   109: aload_1
    //   110: aload 5
    //   112: getfield 190	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 116	java/io/OutputStream:write	([BII)V
    //   120: goto -54 -> 66
    //   123: astore_0
    //   124: aload 4
    //   126: astore_1
    //   127: aload_0
    //   128: astore 4
    //   130: aload_1
    //   131: astore_0
    //   132: ldc 118
    //   134: ldc 196
    //   136: aload 4
    //   138: invokestatic 202	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   145: aload 5
    //   147: invokevirtual 184	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   150: aload_1
    //   151: ifnull -140 -> 11
    //   154: aload_1
    //   155: invokevirtual 194	java/io/InputStream:close	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_0
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_0
    //   166: getstatic 37	com/tencent/component/network/utils/FileUtils:a	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   169: aload 5
    //   171: invokevirtual 184	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 194	java/io/InputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_0
    //   185: goto -3 -> 182
    //   188: astore_0
    //   189: goto -85 -> 104
    //   192: astore_1
    //   193: goto -27 -> 166
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -70 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   0	203	1	paramOutputStream	java.io.OutputStream
    //   86	31	2	i	int
    //   41	2	3	bool	boolean
    //   64	73	4	localObject	Object
    //   196	1	4	localThrowable	Throwable
    //   19	151	5	localBytesBuffer	BytesBufferPool.BytesBuffer
    // Exception table:
    //   from	to	target	type
    //   69	87	123	java/lang/Throwable
    //   109	120	123	java/lang/Throwable
    //   154	158	160	java/lang/Throwable
    //   21	42	163	finally
    //   56	66	163	finally
    //   178	182	184	java/lang/Throwable
    //   99	104	188	java/lang/Throwable
    //   69	87	192	finally
    //   109	120	192	finally
    //   132	142	192	finally
    //   21	42	196	java/lang/Throwable
    //   56	66	196	java/lang/Throwable
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return a(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return bool;
      }
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (paramBoolean) {
          break;
        }
        paramFile.delete();
        return;
      }
      delete(arrayOfFile[i], paramBoolean);
      i += 1;
    }
  }
  
  public static void delete(String paramString)
  {
    delete(paramString, false);
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString), paramBoolean);
  }
  
  /* Error */
  public static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 5
    //   6: aload 5
    //   8: aload_1
    //   9: invokevirtual 237	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   12: invokevirtual 242	android/content/res/AssetFileDescriptor:getLength	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: lreturn
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_0
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 95	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 245	java/io/InputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: i2l
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   42: lload_3
    //   43: lreturn
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   49: ldc2_w 246
    //   52: lreturn
    //   53: astore_0
    //   54: aconst_null
    //   55: astore 5
    //   57: aload_0
    //   58: astore_1
    //   59: aload 5
    //   61: invokestatic 72	com/tencent/component/network/utils/FileUtils:a	(Ljava/io/Closeable;)V
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: astore 5
    //   70: goto -11 -> 59
    //   73: astore_1
    //   74: goto -29 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   0	77	1	paramString	String
    //   34	2	2	i	int
    //   15	28	3	l	long
    //   4	65	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	16	18	java/io/IOException
    //   21	28	44	java/io/IOException
    //   21	28	53	finally
    //   30	35	66	finally
    //   30	35	73	java/io/IOException
  }
  
  public static abstract interface AssetFileComparator
  {
    public abstract boolean equals(Context paramContext, String paramString, File paramFile);
  }
  
  public static abstract interface FileComparator
  {
    public abstract boolean equals(File paramFile1, File paramFile2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */