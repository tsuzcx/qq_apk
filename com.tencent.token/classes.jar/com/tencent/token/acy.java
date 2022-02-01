package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class acy
{
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
  }
  
  public static boolean a(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (!paramFile.isDirectory()) {}
    try
    {
      bool = paramFile.delete();
      return bool;
    }
    finally
    {
      try
      {
        File[] arrayOfFile;
        int j;
        int i;
        boolean bool = paramFile.delete();
        return bool;
      }
      finally {}
      paramFile = finally;
      return false;
    }
    arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 16	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 41	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 43
    //   16: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 50	java/io/RandomAccessFile:length	()J
    //   26: lstore_2
    //   27: lload_2
    //   28: l2i
    //   29: istore_1
    //   30: iload_1
    //   31: i2l
    //   32: lload_2
    //   33: lcmp
    //   34: ifne +26 -> 60
    //   37: iload_1
    //   38: newarray byte
    //   40: astore 5
    //   42: aload 4
    //   44: aload 5
    //   46: invokevirtual 54	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload 5
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 55	java/io/RandomAccessFile:close	()V
    //   57: aload 5
    //   59: areturn
    //   60: new 35	java/io/IOException
    //   63: dup
    //   64: ldc 57
    //   66: invokespecial 58	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   69: athrow
    //   70: aconst_null
    //   71: astore 4
    //   73: iconst_0
    //   74: newarray byte
    //   76: astore 5
    //   78: aload 5
    //   80: astore_0
    //   81: aload 4
    //   83: ifnull +21 -> 104
    //   86: aload 5
    //   88: astore_0
    //   89: aload 4
    //   91: invokevirtual 55	java/io/RandomAccessFile:close	()V
    //   94: aload 5
    //   96: areturn
    //   97: astore 4
    //   99: aload 4
    //   101: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: aload 4
    //   109: ifnull +18 -> 127
    //   112: aload 4
    //   114: invokevirtual 55	java/io/RandomAccessFile:close	()V
    //   117: goto +10 -> 127
    //   120: astore 4
    //   122: aload 4
    //   124: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_0
    //   130: goto -60 -> 70
    //   133: astore_0
    //   134: goto -61 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   29	9	1	i	int
    //   26	7	2	l	long
    //   19	71	4	localRandomAccessFile	java.io.RandomAccessFile
    //   97	16	4	localIOException1	java.io.IOException
    //   120	3	4	localIOException2	java.io.IOException
    //   40	55	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	57	97	java/io/IOException
    //   89	94	97	java/io/IOException
    //   73	78	106	finally
    //   112	117	120	java/io/IOException
    //   9	21	129	finally
    //   21	27	133	finally
    //   37	49	133	finally
    //   60	70	133	finally
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    try
    {
      localFileInputStream = new FileInputStream(paramString);
    }
    finally
    {
      int i;
      label34:
      int k;
      int j;
      label109:
      label111:
      break label109;
    }
    try
    {
      paramString = new byte[paramInt];
      i = 0;
      k = localFileInputStream.read(paramString, i, paramInt - i);
      j = i;
      if (k != -1)
      {
        j = i + k;
        i = j;
        if (j < paramInt) {
          break label34;
        }
      }
      if (j == 0)
      {
        ahr.a(localFileInputStream);
        return null;
      }
      if (j < paramInt)
      {
        byte[] arrayOfByte = new byte[j];
        System.arraycopy(paramString, 0, arrayOfByte, 0, j);
        paramString = arrayOfByte;
      }
      ahr.a(localFileInputStream);
      return paramString;
    }
    finally
    {
      paramString = localFileInputStream;
      break label111;
    }
    paramString = null;
    ahr.a(paramString);
    return null;
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 64	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 85	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_3
    //   16: invokevirtual 89	java/io/FileInputStream:available	()I
    //   19: invokespecial 92	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore 4
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_3
    //   31: aload_0
    //   32: invokevirtual 97	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iconst_m1
    //   37: iload_1
    //   38: if_icmpeq +14 -> 52
    //   41: aload 4
    //   43: aload_0
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 103	java/io/OutputStream:write	([BII)V
    //   49: goto -19 -> 30
    //   52: aload 4
    //   54: invokevirtual 107	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: aload_2
    //   61: ifnonnull +9 -> 70
    //   64: ldc 57
    //   66: invokevirtual 112	java/lang/String:getBytes	()[B
    //   69: astore_0
    //   70: aload_3
    //   71: invokestatic 75	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   74: aload 4
    //   76: invokestatic 75	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   79: aload_0
    //   80: areturn
    //   81: astore_0
    //   82: aload 4
    //   84: astore_2
    //   85: goto +10 -> 95
    //   88: astore_0
    //   89: goto +6 -> 95
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_0
    //   96: athrow
    //   97: astore_0
    //   98: aload_3
    //   99: invokestatic 75	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   102: aload_2
    //   103: invokestatic 75	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   35	11	1	i	int
    //   1	102	2	localObject	Object
    //   10	89	3	localFileInputStream	FileInputStream
    //   22	61	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	81	finally
    //   30	36	81	finally
    //   41	49	81	finally
    //   52	58	81	finally
    //   64	70	81	finally
    //   11	24	88	finally
    //   2	11	92	finally
    //   95	97	97	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acy
 * JD-Core Version:    0.7.0.1
 */