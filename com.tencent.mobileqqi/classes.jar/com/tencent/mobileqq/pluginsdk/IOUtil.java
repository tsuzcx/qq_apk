package com.tencent.mobileqq.pluginsdk;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class IOUtil
{
  public static final long CRC32_VALUE_INVALID = -1L;
  private static final String TAG = "IOUtil";
  
  public static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static void closeZipFile(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile)
    {
      paramZipFile.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean contentEquals(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: aload_0
    //   5: invokevirtual 44	java/io/File:exists	()Z
    //   8: ifeq +7 -> 15
    //   11: aload_1
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore 7
    //   23: aconst_null
    //   24: astore_3
    //   25: aconst_null
    //   26: astore 5
    //   28: aconst_null
    //   29: astore 6
    //   31: new 46	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_0
    //   40: new 51	java/io/ByteArrayInputStream
    //   43: dup
    //   44: aload_1
    //   45: invokevirtual 57	java/lang/String:getBytes	()[B
    //   48: invokespecial 60	java/io/ByteArrayInputStream:<init>	([B)V
    //   51: astore_1
    //   52: aload_0
    //   53: aload_1
    //   54: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   57: istore_2
    //   58: aload_0
    //   59: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   62: aload_1
    //   63: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aload 7
    //   72: astore_0
    //   73: aload 6
    //   75: astore_1
    //   76: aload_1
    //   77: astore_3
    //   78: aload_0
    //   79: astore 4
    //   81: aload 5
    //   83: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   86: aload_0
    //   87: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   90: aload_1
    //   91: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_0
    //   97: aload 4
    //   99: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   102: aload_3
    //   103: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   106: aload_0
    //   107: athrow
    //   108: astore_1
    //   109: aload 5
    //   111: astore_3
    //   112: aload_0
    //   113: astore 4
    //   115: aload_1
    //   116: astore_0
    //   117: goto -20 -> 97
    //   120: astore 5
    //   122: aload_1
    //   123: astore_3
    //   124: aload_0
    //   125: astore 4
    //   127: aload 5
    //   129: astore_0
    //   130: goto -33 -> 97
    //   133: astore 5
    //   135: aload 6
    //   137: astore_1
    //   138: goto -62 -> 76
    //   141: astore 5
    //   143: goto -67 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	java.io.File
    //   0	146	1	paramString	String
    //   57	10	2	bool	boolean
    //   24	100	3	localObject1	Object
    //   18	108	4	localFile	java.io.File
    //   26	1	5	localObject2	Object
    //   68	42	5	localException1	Exception
    //   120	8	5	localObject3	Object
    //   133	1	5	localException2	Exception
    //   141	1	5	localException3	Exception
    //   29	107	6	localObject4	Object
    //   21	50	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   31	40	68	java/lang/Exception
    //   31	40	96	finally
    //   81	86	96	finally
    //   40	52	108	finally
    //   52	58	120	finally
    //   40	52	133	java/lang/Exception
    //   52	58	141	java/lang/Exception
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    int i = ((InputStream)localObject).read();
    if (-1 != i) {
      if (i == paramInputStream1.read()) {}
    }
    while (paramInputStream1.read() != -1)
    {
      return false;
      i = ((InputStream)localObject).read();
      break;
    }
    return true;
  }
  
  /* Error */
  public static long getCRC32Value(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 44	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 7
    //   14: lreturn
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: new 46	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 83	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/InputStream;)J
    //   33: lstore_1
    //   34: aload_0
    //   35: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   38: lload_1
    //   39: lreturn
    //   40: astore_3
    //   41: aload 4
    //   43: astore_0
    //   44: aload_3
    //   45: astore 4
    //   47: aload_0
    //   48: astore_3
    //   49: aload 4
    //   51: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   54: aload_0
    //   55: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: ldc2_w 7
    //   61: lreturn
    //   62: astore_0
    //   63: aload_3
    //   64: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   67: aload_0
    //   68: athrow
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: astore_0
    //   76: goto -13 -> 63
    //   79: astore 4
    //   81: goto -34 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile	java.io.File
    //   33	6	1	l	long
    //   16	1	3	localObject1	Object
    //   40	5	3	localException1	Exception
    //   48	25	3	localFile	java.io.File
    //   18	32	4	localException2	Exception
    //   69	5	4	localObject2	Object
    //   79	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   20	29	40	java/lang/Exception
    //   20	29	62	finally
    //   49	54	62	finally
    //   29	34	69	finally
    //   29	34	79	java/lang/Exception
  }
  
  public static long getCRC32Value(InputStream paramInputStream)
    throws Exception
  {
    long l1 = System.currentTimeMillis();
    int i = paramInputStream.available();
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, j);
    }
    long l2 = localCRC32.getValue();
    if (QLog.isColorLevel()) {
      QLog.d("IOUtil", 2, "getCRC32Value fileTotalSize = " + i + " takeTime = " + (System.currentTimeMillis() - l1));
    }
    return l2;
  }
  
  /* Error */
  public static byte[] readByte(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 40	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 44	java/io/File:exists	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: aconst_null
    //   30: astore_2
    //   31: new 46	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 92	java/io/InputStream:available	()I
    //   44: newarray byte
    //   46: astore_0
    //   47: aload_1
    //   48: aload_0
    //   49: invokevirtual 98	java/io/InputStream:read	([B)I
    //   52: pop
    //   53: aload_1
    //   54: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_0
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   70: aload_1
    //   71: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_1
    //   77: aload_0
    //   78: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_2
    //   84: aload_1
    //   85: astore_0
    //   86: aload_2
    //   87: astore_1
    //   88: goto -11 -> 77
    //   91: astore_2
    //   92: goto -28 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   17	54	1	localObject1	Object
    //   76	9	1	localObject2	Object
    //   87	1	1	localObject3	Object
    //   30	37	2	str	String
    //   83	4	2	localObject4	Object
    //   91	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	40	59	java/lang/Exception
    //   31	40	76	finally
    //   66	70	76	finally
    //   40	53	83	finally
    //   40	53	91	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IOUtil
 * JD-Core Version:    0.7.0.1
 */