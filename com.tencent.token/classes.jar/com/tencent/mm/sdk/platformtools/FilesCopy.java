package com.tencent.mm.sdk.platformtools;

import java.io.File;

public final class FilesCopy
{
  public static boolean copy(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = new File(paramString1);
    boolean bool = ((File)localObject1).exists();
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject2 = new File(paramString2);
    if (((File)localObject1).isFile())
    {
      if ((!((File)localObject2).isFile()) && (((File)localObject2).exists())) {
        return false;
      }
      copyFile(paramString1, paramString2);
      if (paramBoolean) {
        ((File)localObject1).delete();
      }
    }
    else if (((File)localObject1).isDirectory())
    {
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      if (!((File)localObject2).isDirectory()) {
        return false;
      }
      localObject1 = ((File)localObject1).list();
      while (i < localObject1.length)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(localObject1[i]);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("/");
        localStringBuilder.append(localObject1[i]);
        copy((String)localObject2, localStringBuilder.toString(), paramBoolean);
        i += 1;
      }
    }
    return true;
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
    //   45: if_icmpeq +19 -> 64
    //   48: aload 10
    //   50: astore 9
    //   52: aload 10
    //   54: aload 12
    //   56: iconst_0
    //   57: iload_3
    //   58: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   61: goto -30 -> 31
    //   64: aload 10
    //   66: astore 9
    //   68: new 13	java/io/File
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore_2
    //   77: aload 10
    //   79: astore 9
    //   81: aload 11
    //   83: invokevirtual 89	java/io/InputStream:close	()V
    //   86: aload 10
    //   88: astore 9
    //   90: aload_0
    //   91: invokevirtual 67	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   94: aload_1
    //   95: invokevirtual 73	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   98: invokevirtual 93	java/io/InputStream:available	()I
    //   101: istore_3
    //   102: aload 10
    //   104: astore 9
    //   106: aload_2
    //   107: invokevirtual 20	java/io/File:exists	()Z
    //   110: ifeq +31 -> 141
    //   113: iload_3
    //   114: i2l
    //   115: lstore 4
    //   117: aload 10
    //   119: astore 9
    //   121: aload_2
    //   122: invokevirtual 97	java/io/File:length	()J
    //   125: lstore 6
    //   127: lload 4
    //   129: lload 6
    //   131: lcmp
    //   132: ifne +9 -> 141
    //   135: iconst_1
    //   136: istore 8
    //   138: goto +6 -> 144
    //   141: iconst_0
    //   142: istore 8
    //   144: aload 10
    //   146: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   149: iload 8
    //   151: ireturn
    //   152: astore_1
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: astore_0
    //   158: aload_0
    //   159: iconst_0
    //   160: aload_1
    //   161: aastore
    //   162: goto +47 -> 209
    //   165: astore_1
    //   166: aload 10
    //   168: astore_0
    //   169: goto +13 -> 182
    //   172: astore_0
    //   173: aconst_null
    //   174: astore 9
    //   176: goto +43 -> 219
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: astore 9
    //   185: aload_1
    //   186: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   189: aload_0
    //   190: ifnull +26 -> 216
    //   193: aload_0
    //   194: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_1
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: astore_0
    //   205: aload_0
    //   206: iconst_0
    //   207: aload_1
    //   208: aastore
    //   209: ldc 103
    //   211: aconst_null
    //   212: aload_0
    //   213: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore_0
    //   219: aload 9
    //   221: ifnull +26 -> 247
    //   224: aload 9
    //   226: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   229: goto +18 -> 247
    //   232: astore_1
    //   233: ldc 103
    //   235: aconst_null
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_1
    //   243: aastore
    //   244: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload_0
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	android.content.Context
    //   0	249	1	paramString1	String
    //   0	249	2	paramString2	String
    //   42	72	3	i	int
    //   115	13	4	l1	long
    //   125	5	6	l2	long
    //   136	14	8	bool	boolean
    //   22	203	9	localObject	Object
    //   18	149	10	localFileOutputStream	java.io.FileOutputStream
    //   8	74	11	localInputStream	java.io.InputStream
    //   29	26	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   144	149	152	java/io/IOException
    //   24	31	165	java/lang/Exception
    //   35	43	165	java/lang/Exception
    //   52	61	165	java/lang/Exception
    //   68	77	165	java/lang/Exception
    //   81	86	165	java/lang/Exception
    //   90	102	165	java/lang/Exception
    //   106	113	165	java/lang/Exception
    //   121	127	165	java/lang/Exception
    //   0	20	172	finally
    //   0	20	179	java/lang/Exception
    //   193	197	199	java/io/IOException
    //   24	31	218	finally
    //   35	43	218	finally
    //   52	61	218	finally
    //   68	77	218	finally
    //   81	86	218	finally
    //   90	102	218	finally
    //   106	113	218	finally
    //   121	127	218	finally
    //   185	189	218	finally
    //   224	229	232	java/io/IOException
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
    //   37: if_icmpeq +13 -> 50
    //   40: aload_0
    //   41: aload_1
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   47: goto -19 -> 28
    //   50: iconst_1
    //   51: istore_3
    //   52: aload 4
    //   54: invokevirtual 114	java/io/FileInputStream:close	()V
    //   57: goto +10 -> 67
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   65: iconst_0
    //   66: istore_3
    //   67: aload_0
    //   68: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   71: iload_3
    //   72: ireturn
    //   73: astore_1
    //   74: goto +75 -> 149
    //   77: astore_1
    //   78: goto +12 -> 90
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: goto +65 -> 149
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_0
    //   90: goto +19 -> 109
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: astore 4
    //   99: goto +50 -> 149
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload 5
    //   107: astore 4
    //   109: aload_1
    //   110: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   113: aload 4
    //   115: ifnull +16 -> 131
    //   118: aload 4
    //   120: invokevirtual 114	java/io/FileInputStream:close	()V
    //   123: goto +8 -> 131
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   131: aload_0
    //   132: ifnull +14 -> 146
    //   135: aload_0
    //   136: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: aload 4
    //   151: ifnull +18 -> 169
    //   154: aload 4
    //   156: invokevirtual 114	java/io/FileInputStream:close	()V
    //   159: goto +10 -> 169
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   169: aload_0
    //   170: ifnull +15 -> 185
    //   173: aload_0
    //   174: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   177: goto +8 -> 185
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 115	java/io/IOException:printStackTrace	()V
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramString1	String
    //   0	187	1	paramString2	String
    //   34	10	2	i	int
    //   51	21	3	bool	boolean
    //   11	144	4	localObject1	Object
    //   162	3	4	localIOException	java.io.IOException
    //   1	105	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   52	57	60	java/io/IOException
    //   22	28	73	finally
    //   28	35	73	finally
    //   40	47	73	finally
    //   22	28	77	java/lang/Exception
    //   28	35	77	java/lang/Exception
    //   40	47	77	java/lang/Exception
    //   13	22	81	finally
    //   13	22	87	java/lang/Exception
    //   3	13	93	finally
    //   3	13	102	java/lang/Exception
    //   118	123	126	java/io/IOException
    //   67	71	141	java/io/IOException
    //   135	139	141	java/io/IOException
    //   109	113	148	finally
    //   154	159	162	java/io/IOException
    //   173	177	180	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilesCopy
 * JD-Core Version:    0.7.0.1
 */