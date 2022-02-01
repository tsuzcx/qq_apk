package wf7;

import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class gk
{
  /* Error */
  public static void a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: aload 5
    //   13: astore_3
    //   14: ldc 12
    //   16: invokestatic 18	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   19: invokevirtual 24	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +124 -> 146
    //   25: aload 5
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 30	java/io/File:exists	()Z
    //   32: ifne +25 -> 57
    //   35: aload 5
    //   37: astore_3
    //   38: aload_0
    //   39: invokevirtual 34	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   42: invokevirtual 37	java/io/File:getParentFile	()Ljava/io/File;
    //   45: invokevirtual 40	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: aload 5
    //   51: astore_3
    //   52: aload_0
    //   53: invokevirtual 43	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: aload 5
    //   59: astore_3
    //   60: new 45	java/io/FileOutputStream
    //   63: dup
    //   64: aload_0
    //   65: iload_2
    //   66: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   69: astore_0
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 53	java/io/FileOutputStream:write	([B)V
    //   75: aload_0
    //   76: ifnull -72 -> 4
    //   79: aload_0
    //   80: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   83: return
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   89: return
    //   90: astore_1
    //   91: aload 4
    //   93: astore_0
    //   94: aload_0
    //   95: astore_3
    //   96: aload_1
    //   97: invokevirtual 61	java/lang/Throwable:printStackTrace	()V
    //   100: aload_0
    //   101: ifnull -97 -> 4
    //   104: aload_0
    //   105: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore_0
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_1
    //   135: aload_0
    //   136: astore_3
    //   137: aload_1
    //   138: astore_0
    //   139: goto -23 -> 116
    //   142: astore_1
    //   143: goto -49 -> 94
    //   146: aconst_null
    //   147: astore_0
    //   148: goto -73 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramFile	File
    //   0	151	1	paramArrayOfByte	byte[]
    //   0	151	2	paramBoolean	boolean
    //   13	124	3	localObject1	Object
    //   9	83	4	localObject2	Object
    //   6	52	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	83	84	java/io/IOException
    //   14	25	90	java/lang/Throwable
    //   28	35	90	java/lang/Throwable
    //   38	49	90	java/lang/Throwable
    //   52	57	90	java/lang/Throwable
    //   60	70	90	java/lang/Throwable
    //   104	108	109	java/io/IOException
    //   14	25	115	finally
    //   28	35	115	finally
    //   38	49	115	finally
    //   52	57	115	finally
    //   60	70	115	finally
    //   96	100	115	finally
    //   120	124	126	java/io/IOException
    //   70	75	134	finally
    //   70	75	142	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iload_2
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: new 26	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 30	java/io/File:exists	()Z
    //   26: ifne +19 -> 45
    //   29: aload_1
    //   30: invokevirtual 34	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   33: invokevirtual 37	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 40	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 43	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 45	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iconst_0
    //   51: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 53	java/io/FileOutputStream:write	([B)V
    //   60: iconst_1
    //   61: istore_2
    //   62: aload_1
    //   63: ifnull -57 -> 6
    //   66: aload_1
    //   67: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   77: iconst_1
    //   78: ireturn
    //   79: astore_0
    //   80: aload_3
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull -77 -> 6
    //   86: aload_0
    //   87: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: aload 4
    //   102: astore_1
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_0
    //   122: goto -19 -> 103
    //   125: astore_0
    //   126: aload_1
    //   127: astore_0
    //   128: goto -46 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramArrayOfByte	byte[]
    //   0	131	1	paramString	String
    //   1	61	2	bool	boolean
    //   12	69	3	localObject1	Object
    //   9	92	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	72	java/io/IOException
    //   13	45	79	java/lang/Throwable
    //   45	55	79	java/lang/Throwable
    //   86	90	92	java/io/IOException
    //   13	45	99	finally
    //   45	55	99	finally
    //   107	111	113	java/io/IOException
    //   55	60	121	finally
    //   55	60	125	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 69	java/io/BufferedInputStream
    //   6: dup
    //   7: new 71	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: new 79	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 81	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore 5
    //   39: aload_0
    //   40: astore 4
    //   42: aload_2
    //   43: astore_3
    //   44: aload_2
    //   45: aload 5
    //   47: invokevirtual 85	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +55 -> 108
    //   56: aload_0
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 88	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -30 -> 39
    //   72: astore 5
    //   74: aload_0
    //   75: astore 4
    //   77: aload_2
    //   78: astore_3
    //   79: aload 5
    //   81: invokevirtual 61	java/lang/Throwable:printStackTrace	()V
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   92: aload 6
    //   94: astore_0
    //   95: aload_2
    //   96: ifnull +10 -> 106
    //   99: aload_2
    //   100: invokevirtual 90	java/io/BufferedInputStream:close	()V
    //   103: aload 6
    //   105: astore_0
    //   106: aload_0
    //   107: areturn
    //   108: aload_0
    //   109: astore 4
    //   111: aload_2
    //   112: astore_3
    //   113: aload_0
    //   114: invokevirtual 94	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: astore 5
    //   119: aload 5
    //   121: astore_3
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   130: aload_3
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull -27 -> 106
    //   136: aload_2
    //   137: invokevirtual 90	java/io/BufferedInputStream:close	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   147: aload_3
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   154: goto -24 -> 130
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   162: goto -70 -> 92
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_0
    //   173: aconst_null
    //   174: astore 4
    //   176: aconst_null
    //   177: astore_2
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 90	java/io/BufferedInputStream:close	()V
    //   196: aload_0
    //   197: athrow
    //   198: astore_3
    //   199: aload_3
    //   200: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   203: goto -15 -> 188
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 60	java/io/IOException:printStackTrace	()V
    //   211: goto -15 -> 196
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 4
    //   218: goto -40 -> 178
    //   221: astore_0
    //   222: aload_3
    //   223: astore_2
    //   224: goto -46 -> 178
    //   227: astore 5
    //   229: aconst_null
    //   230: astore_0
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -159 -> 74
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -166 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramFile	File
    //   50	16	1	i	int
    //   18	175	2	localBufferedInputStream	java.io.BufferedInputStream
    //   206	2	2	localIOException1	IOException
    //   223	10	2	localObject1	Object
    //   31	117	3	localObject2	Object
    //   198	25	3	localIOException2	IOException
    //   28	189	4	localFile	File
    //   37	26	5	arrayOfByte1	byte[]
    //   72	8	5	localThrowable1	java.lang.Throwable
    //   117	3	5	arrayOfByte2	byte[]
    //   227	1	5	localThrowable2	java.lang.Throwable
    //   236	1	5	localThrowable3	java.lang.Throwable
    //   1	103	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	72	java/lang/Throwable
    //   44	51	72	java/lang/Throwable
    //   61	69	72	java/lang/Throwable
    //   113	119	72	java/lang/Throwable
    //   136	140	142	java/io/IOException
    //   126	130	149	java/io/IOException
    //   88	92	157	java/io/IOException
    //   99	103	165	java/io/IOException
    //   3	19	172	finally
    //   183	188	198	java/io/IOException
    //   192	196	206	java/io/IOException
    //   19	27	214	finally
    //   32	39	221	finally
    //   44	51	221	finally
    //   61	69	221	finally
    //   79	84	221	finally
    //   113	119	221	finally
    //   3	19	227	java/lang/Throwable
    //   19	27	236	java/lang/Throwable
  }
  
  public static boolean eV()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      if (str == null) {
        return false;
      }
      boolean bool = str.equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean eW()
  {
    Object localObject = Environment.getExternalStorageDirectory().toString() + "/DCIM";
    File localFile = new File((String)localObject);
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {}
    for (;;)
    {
      return false;
      localObject = new File((String)localObject, ".probe");
      try
      {
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (((File)localObject).createNewFile())
        {
          ((File)localObject).delete();
          return true;
        }
      }
      catch (IOException localIOException) {}
    }
    return false;
  }
  
  public static final String h(String paramString1, String paramString2)
  {
    int i;
    if (0 == 0)
    {
      str = Uri.decode(paramString1);
      if (str != null)
      {
        i = str.indexOf('?');
        paramString1 = str;
        if (i > 0) {
          paramString1 = str.substring(0, i);
        }
        if (!paramString1.endsWith("/"))
        {
          i = paramString1.lastIndexOf('/') + 1;
          if (i <= 0) {}
        }
      }
    }
    for (String str = paramString1.substring(i);; str = null)
    {
      paramString1 = str;
      if (str == null) {
        paramString1 = paramString2;
      }
      paramString2 = paramString1;
      if (paramString1 == null) {
        paramString2 = "downloadfile";
      }
      return paramString2;
    }
  }
  
  public static int i(long paramLong)
  {
    if (!eV()) {
      return 1;
    }
    if (!eW()) {
      return 2;
    }
    gr.a locala = new gr.a();
    gr.b(locala);
    if (locala.sw < paramLong) {
      return 3;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gk
 * JD-Core Version:    0.7.0.1
 */