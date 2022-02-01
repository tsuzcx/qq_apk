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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +14 -> 21
    //   10: aload_0
    //   11: invokevirtual 44	java/io/File:exists	()Z
    //   14: ifeq +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: new 46	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: new 51	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 57	java/lang/String:getBytes	()[B
    //   40: invokespecial 60	java/io/ByteArrayInputStream:<init>	([B)V
    //   43: astore_0
    //   44: aload_3
    //   45: aload_0
    //   46: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   49: istore_2
    //   50: aload_3
    //   51: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: iload_2
    //   59: ireturn
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_0
    //   63: aload 5
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   70: aload_1
    //   71: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_3
    //   83: aload 4
    //   85: astore_1
    //   86: aload_3
    //   87: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   90: aload_1
    //   91: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: aload 4
    //   99: astore_1
    //   100: goto -14 -> 86
    //   103: astore 4
    //   105: aload_0
    //   106: astore_1
    //   107: aload 4
    //   109: astore_0
    //   110: goto -24 -> 86
    //   113: astore 4
    //   115: aload_1
    //   116: astore_3
    //   117: aload_0
    //   118: astore_1
    //   119: aload 4
    //   121: astore_0
    //   122: goto -36 -> 86
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: aload 4
    //   133: astore_3
    //   134: goto -68 -> 66
    //   137: astore 4
    //   139: aload_3
    //   140: astore_1
    //   141: aload 4
    //   143: astore_3
    //   144: goto -78 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramFile	java.io.File
    //   0	147	1	paramString	String
    //   49	10	2	bool	boolean
    //   31	20	3	localFileInputStream	java.io.FileInputStream
    //   60	7	3	localException1	Exception
    //   82	62	3	localObject1	Object
    //   1	97	4	localObject2	Object
    //   103	5	4	localObject3	Object
    //   113	7	4	localObject4	Object
    //   125	7	4	localException2	Exception
    //   137	5	4	localException3	Exception
    //   4	60	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   23	32	60	java/lang/Exception
    //   23	32	80	finally
    //   32	44	96	finally
    //   44	50	103	finally
    //   66	70	113	finally
    //   32	44	125	java/lang/Exception
    //   44	50	137	java/lang/Exception
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
    for (int i = ((InputStream)localObject).read(); -1 != i; i = ((InputStream)localObject).read()) {
      if (i != paramInputStream1.read()) {
        return false;
      }
    }
    if (paramInputStream1.read() == -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    //   15: new 46	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: aload_3
    //   25: astore_0
    //   26: aload_3
    //   27: invokestatic 83	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/InputStream;)J
    //   30: lstore_1
    //   31: aload_3
    //   32: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   35: lload_1
    //   36: lreturn
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_3
    //   42: astore_0
    //   43: aload 4
    //   45: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   48: aload_3
    //   49: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   52: ldc2_w 7
    //   55: lreturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_0
    //   60: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   63: aload_3
    //   64: athrow
    //   65: astore_3
    //   66: goto -7 -> 59
    //   69: astore 4
    //   71: goto -30 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramFile	java.io.File
    //   30	6	1	l	long
    //   23	26	3	localFileInputStream	java.io.FileInputStream
    //   56	8	3	localObject1	Object
    //   65	1	3	localObject2	Object
    //   37	7	4	localException1	Exception
    //   69	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	24	37	java/lang/Exception
    //   15	24	56	finally
    //   26	31	65	finally
    //   43	48	65	finally
    //   26	31	69	java/lang/Exception
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
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 44	java/io/File:exists	()Z
    //   22: ifeq -15 -> 7
    //   25: new 46	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 92	java/io/InputStream:available	()I
    //   40: newarray byte
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 98	java/io/InputStream:read	([B)I
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   66: aload_1
    //   67: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: astore_2
    //   86: goto -9 -> 77
    //   89: astore_2
    //   90: goto -30 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString	String
    //   33	49	1	localObject1	Object
    //   83	1	1	localObject2	Object
    //   42	14	2	arrayOfByte	byte[]
    //   57	6	2	localException1	Exception
    //   74	12	2	localObject3	Object
    //   89	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   25	34	57	java/lang/Exception
    //   25	34	72	finally
    //   36	43	83	finally
    //   45	51	83	finally
    //   62	66	83	finally
    //   36	43	89	java/lang/Exception
    //   45	51	89	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IOUtil
 * JD-Core Version:    0.7.0.1
 */