package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.util.Log;

public final class SharpPUtil
{
  private static final String SHARPP_TAG = "SHARPP";
  public static final String TAG = "SharpPUtil";
  public static final String soLibName = "libSharpPDec.so";
  
  public static Bitmap decodeSharpPByFilePath(String paramString)
  {
    SharpPDecoder localSharpPDecoder = new SharpPDecoder();
    int i = localSharpPDecoder.parseHeader(paramString);
    if (i != 0) {
      Log.d("SharpPUtil", "status: " + i);
    }
    do
    {
      return null;
      i = localSharpPDecoder.getSharpPType();
    } while ((3 == i) || (4 == i));
    try
    {
      paramString = localSharpPDecoder.decodeSharpP2PNG2(paramString, 4, 1000);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      Log.e("SharpPUtil", "sharpP so link error, missing native method.");
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static boolean isSharpPFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: bipush 6
    //   2: newarray byte
    //   4: astore_3
    //   5: new 74	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: aload_1
    //   17: aload_3
    //   18: invokevirtual 81	java/io/FileInputStream:read	([B)I
    //   21: pop
    //   22: aload_1
    //   23: ifnull +7 -> 30
    //   26: aload_1
    //   27: invokevirtual 84	java/io/FileInputStream:close	()V
    //   30: new 86	java/lang/String
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 89	java/lang/String:<init>	([B)V
    //   38: astore_0
    //   39: ldc 11
    //   41: new 32	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   48: ldc 91
    //   50: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: ldc 8
    //   67: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ireturn
    //   71: astore_0
    //   72: ldc 11
    //   74: new 32	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   81: ldc 97
    //   83: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 100	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: goto -70 -> 30
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: ldc 11
    //   110: new 32	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   117: ldc 102
    //   119: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 100	java/io/IOException:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: aload_1
    //   137: ifnull -107 -> 30
    //   140: aload_1
    //   141: invokevirtual 84	java/io/FileInputStream:close	()V
    //   144: goto -114 -> 30
    //   147: astore_0
    //   148: ldc 11
    //   150: new 32	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   157: ldc 97
    //   159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 100	java/io/IOException:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: goto -146 -> 30
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 84	java/io/FileInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_0
    //   193: ldc 11
    //   195: new 32	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   202: ldc 97
    //   204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: invokevirtual 100	java/io/IOException:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   220: pop
    //   221: goto -31 -> 190
    //   224: astore_1
    //   225: goto -43 -> 182
    //   228: astore_2
    //   229: goto -123 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramFile	java.io.File
    //   13	128	1	localFileInputStream	java.io.FileInputStream
    //   179	12	1	localObject1	Object
    //   224	1	1	localObject2	Object
    //   103	20	2	localIOException1	java.io.IOException
    //   228	1	2	localIOException2	java.io.IOException
    //   4	31	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	30	71	java/io/IOException
    //   5	14	103	java/io/IOException
    //   140	144	147	java/io/IOException
    //   5	14	179	finally
    //   186	190	192	java/io/IOException
    //   16	22	224	finally
    //   108	136	224	finally
    //   16	22	228	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtil
 * JD-Core Version:    0.7.0.1
 */