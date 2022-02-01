package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WxapkgUnpacker
{
  private static final String TAG = "WxapkgUnpacker";
  
  /* Error */
  private static boolean Unpacker(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +80 -> 100
    //   23: new 28	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   30: new 31	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 38	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 44
    //   46: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_2
    //   54: astore 7
    //   56: aconst_null
    //   57: astore 8
    //   59: new 49	java/io/RandomAccessFile
    //   62: dup
    //   63: aload_0
    //   64: ldc 51
    //   66: invokespecial 54	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 58	java/io/RandomAccessFile:readByte	()B
    //   74: bipush 190
    //   76: if_icmpeq +40 -> 116
    //   79: new 60	java/lang/RuntimeException
    //   82: dup
    //   83: ldc 62
    //   85: invokespecial 63	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: new 31	java/io/File
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 38	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore 7
    //   113: goto -57 -> 56
    //   116: aload_2
    //   117: ldc2_w 67
    //   120: invokevirtual 72	java/io/RandomAccessFile:seek	(J)V
    //   123: aload_2
    //   124: invokevirtual 76	java/io/RandomAccessFile:readInt	()I
    //   127: istore 5
    //   129: new 78	java/util/ArrayList
    //   132: dup
    //   133: iload 5
    //   135: invokespecial 81	java/util/ArrayList:<init>	(I)V
    //   138: astore 9
    //   140: iconst_0
    //   141: istore 4
    //   143: iload 4
    //   145: iload 5
    //   147: if_icmpge +212 -> 359
    //   150: aload_2
    //   151: invokevirtual 76	java/io/RandomAccessFile:readInt	()I
    //   154: istore 6
    //   156: iload 6
    //   158: newarray byte
    //   160: astore_0
    //   161: aload_2
    //   162: aload_0
    //   163: iconst_0
    //   164: iload 6
    //   166: invokevirtual 85	java/io/RandomAccessFile:read	([BII)I
    //   169: pop
    //   170: new 31	java/io/File
    //   173: dup
    //   174: new 87	java/lang/String
    //   177: dup
    //   178: aload_0
    //   179: iconst_0
    //   180: iload 6
    //   182: invokespecial 90	java/lang/String:<init>	([BII)V
    //   185: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   188: invokevirtual 38	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 8
    //   193: aload 8
    //   195: astore_0
    //   196: aload 7
    //   198: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +61 -> 262
    //   204: aload 8
    //   206: aload 7
    //   208: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   211: ifne +117 -> 328
    //   214: aload 8
    //   216: astore_0
    //   217: iload_3
    //   218: ifeq +44 -> 262
    //   221: aload 7
    //   223: aload 8
    //   225: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   228: ifne +13 -> 241
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 97	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   238: ifeq +55 -> 293
    //   241: new 28	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   248: aload 7
    //   250: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 44
    //   255: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: astore_0
    //   262: aload 9
    //   264: new 6	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   267: dup
    //   268: aload_0
    //   269: aload_2
    //   270: invokevirtual 76	java/io/RandomAccessFile:readInt	()I
    //   273: aload_2
    //   274: invokevirtual 76	java/io/RandomAccessFile:readInt	()I
    //   277: invokespecial 100	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:<init>	(Ljava/lang/String;II)V
    //   280: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   283: pop
    //   284: iload 4
    //   286: iconst_1
    //   287: iadd
    //   288: istore 4
    //   290: goto -147 -> 143
    //   293: new 28	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   300: aload 7
    //   302: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 44
    //   307: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: getstatic 107	java/io/File:separator	Ljava/lang/String;
    //   313: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 8
    //   318: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_0
    //   325: goto -63 -> 262
    //   328: aload 8
    //   330: aload 7
    //   332: new 28	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   339: aload 7
    //   341: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 44
    //   346: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 111	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   355: astore_0
    //   356: goto -94 -> 262
    //   359: aload 9
    //   361: invokevirtual 115	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   364: astore_0
    //   365: aload_0
    //   366: invokeinterface 121 1 0
    //   371: ifeq +82 -> 453
    //   374: aload_0
    //   375: invokeinterface 125 1 0
    //   380: checkcast 6	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile
    //   383: astore 7
    //   385: new 31	java/io/File
    //   388: dup
    //   389: aload_1
    //   390: aload 7
    //   392: getfield 128	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:name	Ljava/lang/String;
    //   395: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: astore 8
    //   400: aload_2
    //   401: aload 7
    //   403: getfield 133	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:start	I
    //   406: i2l
    //   407: invokevirtual 72	java/io/RandomAccessFile:seek	(J)V
    //   410: aload 7
    //   412: getfield 136	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   415: newarray byte
    //   417: astore 9
    //   419: aload_2
    //   420: aload 9
    //   422: iconst_0
    //   423: aload 7
    //   425: getfield 136	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker$WxapkgFile:length	I
    //   428: invokevirtual 85	java/io/RandomAccessFile:read	([BII)I
    //   431: pop
    //   432: aload 8
    //   434: aload 9
    //   436: invokestatic 140	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker:write	(Ljava/io/File;[B)V
    //   439: goto -74 -> 365
    //   442: astore_0
    //   443: aload_2
    //   444: ifnull +7 -> 451
    //   447: aload_2
    //   448: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   451: aload_0
    //   452: athrow
    //   453: aload_2
    //   454: ifnull +7 -> 461
    //   457: aload_2
    //   458: invokevirtual 66	java/io/RandomAccessFile:close	()V
    //   461: iconst_1
    //   462: ireturn
    //   463: astore_0
    //   464: goto -3 -> 461
    //   467: astore_0
    //   468: goto -370 -> 98
    //   471: astore_1
    //   472: goto -21 -> 451
    //   475: astore_0
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -35 -> 443
    //   481: astore_0
    //   482: aload 8
    //   484: astore_2
    //   485: goto -395 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramString1	String
    //   0	488	1	paramString2	String
    //   0	488	2	paramString3	String
    //   0	488	3	paramBoolean	boolean
    //   141	148	4	i	int
    //   127	21	5	j	int
    //   154	27	6	k	int
    //   54	370	7	localObject1	Object
    //   57	426	8	localObject2	Object
    //   138	297	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   70	89	89	java/lang/Exception
    //   116	140	89	java/lang/Exception
    //   150	193	89	java/lang/Exception
    //   196	214	89	java/lang/Exception
    //   221	241	89	java/lang/Exception
    //   241	262	89	java/lang/Exception
    //   262	284	89	java/lang/Exception
    //   293	325	89	java/lang/Exception
    //   328	356	89	java/lang/Exception
    //   359	365	89	java/lang/Exception
    //   365	439	89	java/lang/Exception
    //   70	89	442	finally
    //   116	140	442	finally
    //   150	193	442	finally
    //   196	214	442	finally
    //   221	241	442	finally
    //   241	262	442	finally
    //   262	284	442	finally
    //   293	325	442	finally
    //   328	356	442	finally
    //   359	365	442	finally
    //   365	439	442	finally
    //   457	461	463	java/lang/Exception
    //   94	98	467	java/lang/Exception
    //   447	451	471	java/lang/Exception
    //   59	70	475	finally
    //   59	70	481	java/lang/Exception
  }
  
  /* Error */
  public static File createFileFromInputStream(Context paramContext, InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 31	java/io/File
    //   6: dup
    //   7: new 28	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   14: aload_0
    //   15: invokevirtual 150	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 153	java/io/File:getPath	()Ljava/lang/String;
    //   21: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 155
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 157	java/io/FileOutputStream
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_0
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 4
    //   56: aload_1
    //   57: aload 4
    //   59: invokevirtual 165	java/io/InputStream:read	([B)I
    //   62: istore_3
    //   63: iload_3
    //   64: ifle +27 -> 91
    //   67: aload_0
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 169	java/io/OutputStream:write	([BII)V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 170	java/io/OutputStream:close	()V
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual 171	java/io/InputStream:close	()V
    //   95: aload_2
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull -9 -> 89
    //   101: aload_0
    //   102: invokevirtual 170	java/io/OutputStream:close	()V
    //   105: aload_2
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   112: aload_2
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   119: goto -32 -> 87
    //   122: astore_0
    //   123: aload 4
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 170	java/io/OutputStream:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: goto -23 -> 126
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -76 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    //   0	158	1	paramInputStream	InputStream
    //   0	158	2	paramString	String
    //   62	10	3	i	int
    //   1	123	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   49	56	78	java/io/IOException
    //   56	63	78	java/io/IOException
    //   67	75	78	java/io/IOException
    //   91	95	78	java/io/IOException
    //   101	105	107	java/io/IOException
    //   83	87	114	java/io/IOException
    //   3	49	122	finally
    //   130	134	136	java/io/IOException
    //   49	56	144	finally
    //   56	63	144	finally
    //   67	75	144	finally
    //   91	95	144	finally
    //   3	49	152	java/io/IOException
  }
  
  public static File getWxapkgFileInAssets(Context paramContext, String paramString)
  {
    File localFile = null;
    Object localObject1 = paramContext.getAssets();
    try
    {
      localObject1 = ((AssetManager)localObject1).open(paramString);
      if (localObject1 != null) {
        localFile = createFileFromInputStream(paramContext, (InputStream)localObject1, paramString);
      }
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  private static boolean unpackAtomically(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      String str1;
      do
      {
        String str2;
        do
        {
          return false;
          str1 = new File(paramString2, paramString3).getAbsolutePath();
          str2 = str1 + "Tmp";
          FileUtils.delete(str2, false);
        } while (!Unpacker(paramString1, paramString2, paramString3, paramBoolean));
        paramString2 = new File(str2);
      } while (!paramString2.exists());
      paramString3 = new File(str1);
      FileUtils.delete(str1, false);
    } while ((!FileUtils.renameFile(paramString2, paramString3)) || (!paramString3.exists()));
    FileUtils.delete(paramString1, true);
    return true;
  }
  
  public static boolean unpackSync(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = unpackSync(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static boolean unpackSync(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = unpackSync(paramString1, paramString2, paramString3, false);
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static boolean unpackSync(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +14 -> 21
    //   10: aload_1
    //   11: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore 4
    //   16: iload 4
    //   18: ifeq +10 -> 28
    //   21: iconst_0
    //   22: istore_3
    //   23: ldc 2
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: new 31	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: aload_2
    //   34: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: invokevirtual 195	java/io/File:exists	()Z
    //   40: ifeq +8 -> 48
    //   43: iconst_1
    //   44: istore_3
    //   45: goto -22 -> 23
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: iload_3
    //   52: invokestatic 218	com/tencent/qqmini/sdk/core/manager/WxapkgUnpacker:unpackAtomically	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   55: istore_3
    //   56: goto -33 -> 23
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramString1	String
    //   0	65	1	paramString2	String
    //   0	65	2	paramString3	String
    //   0	65	3	paramBoolean	boolean
    //   14	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	59	finally
    //   28	43	59	finally
    //   48	56	59	finally
  }
  
  private static void write(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs())) {
      throw new RuntimeException("Create folder fail:" + paramFile.getParentFile().getAbsolutePath());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  static class WxapkgFile
  {
    int length;
    String name;
    int start;
    
    public WxapkgFile(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.start = paramInt1;
      this.length = paramInt2;
    }
    
    public String toString()
    {
      return "WxapkgFile{name='" + this.name + '\'' + ", start=" + this.start + ", length=" + this.length + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker
 * JD-Core Version:    0.7.0.1
 */