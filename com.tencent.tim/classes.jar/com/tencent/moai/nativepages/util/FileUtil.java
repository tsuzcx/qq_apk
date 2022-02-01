package com.tencent.moai.nativepages.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtil
{
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 15	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 18	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 20	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 21	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore_1
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 27	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +42 -> 76
    //   37: aload_0
    //   38: aload_1
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 33	java/io/OutputStream:write	([BII)V
    //   44: goto -17 -> 27
    //   47: astore 4
    //   49: aload_3
    //   50: astore_1
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 39	java/io/InputStream:close	()V
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 40	java/io/OutputStream:close	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_3
    //   77: invokevirtual 39	java/io/InputStream:close	()V
    //   80: aload_0
    //   81: invokevirtual 40	java/io/OutputStream:close	()V
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 39	java/io/InputStream:close	()V
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 40	java/io/OutputStream:close	()V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   107: goto -15 -> 92
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   115: goto -15 -> 100
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   123: goto -57 -> 66
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 39	java/io/InputStream:close	()V
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 40	java/io/OutputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_3
    //   157: aload_3
    //   158: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   161: goto -15 -> 146
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 36	java/io/IOException:printStackTrace	()V
    //   169: goto -15 -> 154
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: goto -37 -> 138
    //   178: astore_1
    //   179: goto -41 -> 138
    //   182: astore 4
    //   184: aload_1
    //   185: astore_3
    //   186: aload 4
    //   188: astore_1
    //   189: goto -51 -> 138
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_0
    //   195: aload 4
    //   197: astore_1
    //   198: goto -144 -> 54
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_0
    //   205: aload_3
    //   206: astore_1
    //   207: aload 4
    //   209: astore_3
    //   210: goto -156 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString1	String
    //   0	213	1	paramString2	String
    //   32	9	2	i	int
    //   11	132	3	localObject1	Object
    //   156	2	3	localIOException1	IOException
    //   185	1	3	str	String
    //   192	14	3	localIOException2	IOException
    //   209	1	3	localIOException3	IOException
    //   1	1	4	localObject2	Object
    //   47	5	4	localIOException4	IOException
    //   182	14	4	localObject3	Object
    //   201	7	4	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   21	27	47	java/io/IOException
    //   27	33	47	java/io/IOException
    //   37	44	47	java/io/IOException
    //   76	84	47	java/io/IOException
    //   88	92	102	java/io/IOException
    //   96	100	110	java/io/IOException
    //   62	66	118	java/io/IOException
    //   70	74	126	java/io/IOException
    //   3	12	133	finally
    //   142	146	156	java/io/IOException
    //   150	154	164	java/io/IOException
    //   12	21	172	finally
    //   21	27	178	finally
    //   27	33	178	finally
    //   37	44	178	finally
    //   76	84	178	finally
    //   54	58	182	finally
    //   3	12	192	java/io/IOException
    //   12	21	201	java/io/IOException
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  public static boolean fileExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static String readContentFromAssetFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      paramString = new ByteArrayOutputStream();
      for (int i = paramContext.read(); i != -1; i = paramContext.read()) {
        paramString.write(i);
      }
      paramContext.close();
      paramContext = paramString.toString();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */