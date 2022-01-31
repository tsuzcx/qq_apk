package com.tencent.mm.sdk.platformtools;

import java.io.File;

public final class FilesCopy
{
  public static boolean copy(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists()) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString2);
      if (!((File)localObject).isFile()) {
        break;
      }
    } while ((!localFile.isFile()) && (localFile.exists()));
    copyFile(paramString1, paramString2);
    if (paramBoolean) {
      ((File)localObject).delete();
    }
    for (;;)
    {
      return true;
      if (((File)localObject).isDirectory())
      {
        if (!localFile.exists()) {
          localFile.mkdir();
        }
        if (!localFile.isDirectory()) {
          break;
        }
        localObject = ((File)localObject).list();
        while (i < localObject.length)
        {
          copy(paramString1 + "/" + localObject[i], paramString2 + "/" + localObject[i], paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static boolean copyAssets(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 73	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore 11
    //   10: new 75	java/io/FileOutputStream
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   18: astore 10
    //   20: aload 10
    //   22: astore 9
    //   24: sipush 16384
    //   27: newarray byte
    //   29: astore 12
    //   31: aload 10
    //   33: astore 9
    //   35: aload 11
    //   37: aload 12
    //   39: invokevirtual 82	java/io/InputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpeq +40 -> 85
    //   48: aload 10
    //   50: astore 9
    //   52: aload 10
    //   54: aload 12
    //   56: iconst_0
    //   57: iload_3
    //   58: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   61: goto -30 -> 31
    //   64: astore_1
    //   65: aload 10
    //   67: astore_0
    //   68: aload_0
    //   69: astore 9
    //   71: aload_1
    //   72: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   75: aload_0
    //   76: ifnull +175 -> 251
    //   79: aload_0
    //   80: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: aload 10
    //   87: astore 9
    //   89: new 13	java/io/File
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_2
    //   98: aload 10
    //   100: astore 9
    //   102: aload 11
    //   104: invokevirtual 93	java/io/InputStream:close	()V
    //   107: aload 10
    //   109: astore 9
    //   111: aload_0
    //   112: invokevirtual 67	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   115: aload_1
    //   116: invokevirtual 73	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   119: invokevirtual 97	java/io/InputStream:available	()I
    //   122: istore_3
    //   123: aload 10
    //   125: astore 9
    //   127: aload_2
    //   128: invokevirtual 20	java/io/File:exists	()Z
    //   131: ifeq +53 -> 184
    //   134: iload_3
    //   135: i2l
    //   136: lstore 4
    //   138: aload 10
    //   140: astore 9
    //   142: aload_2
    //   143: invokevirtual 101	java/io/File:length	()J
    //   146: lstore 6
    //   148: lload 4
    //   150: lload 6
    //   152: lcmp
    //   153: ifne +31 -> 184
    //   156: iconst_1
    //   157: istore 8
    //   159: aload 10
    //   161: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   164: iload 8
    //   166: ireturn
    //   167: astore_0
    //   168: ldc 103
    //   170: aconst_null
    //   171: iconst_1
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_0
    //   178: aastore
    //   179: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: iconst_0
    //   183: ireturn
    //   184: iconst_0
    //   185: istore 8
    //   187: goto -28 -> 159
    //   190: astore_0
    //   191: ldc 103
    //   193: aconst_null
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_0
    //   201: aastore
    //   202: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_0
    //   208: aconst_null
    //   209: astore 9
    //   211: aload 9
    //   213: ifnull +8 -> 221
    //   216: aload 9
    //   218: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   221: aload_0
    //   222: athrow
    //   223: astore_1
    //   224: ldc 103
    //   226: aconst_null
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_1
    //   234: aastore
    //   235: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -17 -> 221
    //   241: astore_0
    //   242: goto -31 -> 211
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_0
    //   248: goto -180 -> 68
    //   251: iconst_0
    //   252: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramContext	android.content.Context
    //   0	253	1	paramString1	String
    //   0	253	2	paramString2	String
    //   42	93	3	i	int
    //   136	13	4	l1	long
    //   146	5	6	l2	long
    //   157	29	8	bool	boolean
    //   22	195	9	localObject	Object
    //   18	142	10	localFileOutputStream	java.io.FileOutputStream
    //   8	95	11	localInputStream	java.io.InputStream
    //   29	26	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	31	64	java/lang/Exception
    //   35	43	64	java/lang/Exception
    //   52	61	64	java/lang/Exception
    //   89	98	64	java/lang/Exception
    //   102	107	64	java/lang/Exception
    //   111	123	64	java/lang/Exception
    //   127	134	64	java/lang/Exception
    //   142	148	64	java/lang/Exception
    //   159	164	167	java/io/IOException
    //   79	83	190	java/io/IOException
    //   0	20	207	finally
    //   216	221	223	java/io/IOException
    //   24	31	241	finally
    //   35	43	241	finally
    //   52	61	241	finally
    //   71	75	241	finally
    //   89	98	241	finally
    //   102	107	241	finally
    //   111	123	241	finally
    //   127	134	241	finally
    //   142	148	241	finally
    //   0	20	245	java/lang/Exception
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 111	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 75	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: sipush 16384
    //   25: newarray byte
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 113	java/io/FileInputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: iconst_m1
    //   37: if_icmpeq +45 -> 82
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   47: goto -19 -> 28
    //   50: astore 5
    //   52: aload 4
    //   54: astore_1
    //   55: aload 5
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 114	java/io/FileInputStream:close	()V
    //   72: aload_0
    //   73: ifnull +143 -> 216
    //   76: aload_0
    //   77: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: iconst_1
    //   83: istore_3
    //   84: aload 4
    //   86: invokevirtual 114	java/io/FileInputStream:close	()V
    //   89: aload_0
    //   90: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   93: iload_3
    //   94: ireturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   107: iconst_0
    //   108: istore_3
    //   109: goto -20 -> 89
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   117: goto -45 -> 72
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: aconst_null
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 114	java/io/FileInputStream:close	()V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   160: goto -17 -> 143
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   168: goto -17 -> 151
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_0
    //   174: goto -41 -> 133
    //   177: astore_1
    //   178: goto -45 -> 133
    //   181: astore 5
    //   183: aload_1
    //   184: astore 4
    //   186: aload 5
    //   188: astore_1
    //   189: goto -56 -> 133
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_0
    //   196: aload 5
    //   198: astore_1
    //   199: goto -140 -> 59
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_0
    //   206: aload 4
    //   208: astore_1
    //   209: aload 5
    //   211: astore 4
    //   213: goto -154 -> 59
    //   216: iconst_0
    //   217: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString1	String
    //   0	218	1	paramString2	String
    //   34	10	2	i	int
    //   83	26	3	bool	boolean
    //   11	128	4	localObject1	Object
    //   153	3	4	localIOException	java.io.IOException
    //   184	1	4	str	String
    //   192	15	4	localException1	java.lang.Exception
    //   211	1	4	localException2	java.lang.Exception
    //   1	1	5	localObject2	Object
    //   50	6	5	localException3	java.lang.Exception
    //   181	16	5	localObject3	Object
    //   202	8	5	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	28	50	java/lang/Exception
    //   28	35	50	java/lang/Exception
    //   40	47	50	java/lang/Exception
    //   89	93	95	java/io/IOException
    //   84	89	102	java/io/IOException
    //   68	72	112	java/io/IOException
    //   76	80	120	java/io/IOException
    //   3	13	127	finally
    //   138	143	153	java/io/IOException
    //   147	151	163	java/io/IOException
    //   13	22	171	finally
    //   22	28	177	finally
    //   28	35	177	finally
    //   40	47	177	finally
    //   59	64	181	finally
    //   3	13	192	java/lang/Exception
    //   13	22	202	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilesCopy
 * JD-Core Version:    0.7.0.1
 */