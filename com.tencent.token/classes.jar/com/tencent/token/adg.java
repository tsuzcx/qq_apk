package com.tencent.token;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class adg
{
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 8
    //   2: astore_1
    //   3: new 10	java/io/BufferedReader
    //   6: dup
    //   7: new 12	java/io/FileReader
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 16	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   15: invokespecial 19	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 23	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull +9 -> 34
    //   28: aload_2
    //   29: invokestatic 26	com/tencent/token/adg:a	(Ljava/io/Closeable;)V
    //   32: aload_0
    //   33: areturn
    //   34: goto +15 -> 49
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_1
    //   40: astore_2
    //   41: aload_0
    //   42: ifnull +13 -> 55
    //   45: aload_0
    //   46: astore_2
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: invokestatic 26	com/tencent/token/adg:a	(Ljava/io/Closeable;)V
    //   53: aload_0
    //   54: astore_2
    //   55: aload_2
    //   56: areturn
    //   57: astore_0
    //   58: goto -21 -> 37
    //   61: astore_0
    //   62: aload_2
    //   63: astore_0
    //   64: goto -25 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramFile	File
    //   2	46	1	str	String
    //   18	45	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	57	finally
    //   19	24	61	finally
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 36	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 38	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 44	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 48	java/io/BufferedOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 51	java/io/BufferedOutputStream:flush	()V
    //   25: aload_0
    //   26: invokestatic 26	com/tencent/token/adg:a	(Ljava/io/Closeable;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_0
    //   34: invokestatic 26	com/tencent/token/adg:a	(Ljava/io/Closeable;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: astore_0
    //   40: goto -9 -> 31
    //   43: astore_1
    //   44: goto -11 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramString	String
    //   0	47	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	16	39	finally
    //   16	25	43	finally
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 56	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 59	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 61
    //   16: invokespecial 64	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 68	java/io/RandomAccessFile:length	()J
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
    //   46: invokevirtual 71	java/io/RandomAccessFile:readFully	([B)V
    //   49: aload 5
    //   51: astore_0
    //   52: aload 4
    //   54: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   57: aload 5
    //   59: areturn
    //   60: new 54	java/io/IOException
    //   63: dup
    //   64: ldc 8
    //   66: invokespecial 73	java/io/IOException:<init>	(Ljava/lang/String;)V
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
    //   91: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   94: aload 5
    //   96: areturn
    //   97: astore 4
    //   99: aload 4
    //   101: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: aload 4
    //   109: ifnull +18 -> 127
    //   112: aload 4
    //   114: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   117: goto +10 -> 127
    //   120: astore 4
    //   122: aload 4
    //   124: invokevirtual 76	java/io/IOException:printStackTrace	()V
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
        agn.a(localFileInputStream);
        return null;
      }
      if (j < paramInt)
      {
        byte[] arrayOfByte = new byte[j];
        System.arraycopy(paramString, 0, arrayOfByte, 0, j);
        paramString = arrayOfByte;
      }
      agn.a(localFileInputStream);
      return paramString;
    }
    finally
    {
      paramString = localFileInputStream;
      break label111;
    }
    paramString = null;
    agn.a(paramString);
    return null;
  }
  
  public static boolean b(File paramFile)
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
        b(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 83	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 114	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_3
    //   16: invokevirtual 118	java/io/FileInputStream:available	()I
    //   19: invokespecial 121	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore 4
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_0
    //   30: aload_3
    //   31: aload_0
    //   32: invokevirtual 126	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iconst_m1
    //   37: iload_1
    //   38: if_icmpeq +14 -> 52
    //   41: aload 4
    //   43: aload_0
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 131	java/io/OutputStream:write	([BII)V
    //   49: goto -19 -> 30
    //   52: aload 4
    //   54: invokevirtual 135	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: aload_2
    //   61: ifnonnull +9 -> 70
    //   64: ldc 8
    //   66: invokevirtual 140	java/lang/String:getBytes	()[B
    //   69: astore_0
    //   70: aload_3
    //   71: invokestatic 91	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   74: aload 4
    //   76: invokestatic 91	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
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
    //   99: invokestatic 91	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   102: aload_2
    //   103: invokestatic 91	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
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
 * Qualified Name:     com.tencent.token.adg
 * JD-Core Version:    0.7.0.1
 */