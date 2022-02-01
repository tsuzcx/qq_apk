package com.huawei.hianalytics.ab.bc.kl;

import com.huawei.hianalytics.ab.bc.ef.ab;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

public final class de
{
  /* Error */
  public static String ab(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 12	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: new 18	com/huawei/hianalytics/ab/bc/kl/ab
    //   14: dup
    //   15: sipush 1024
    //   18: invokespecial 21	com/huawei/hianalytics/ab/bc/kl/ab:<init>	(I)V
    //   21: astore_3
    //   22: aload_2
    //   23: astore_0
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore 4
    //   31: aload_2
    //   32: astore_0
    //   33: aload_2
    //   34: aload 4
    //   36: invokevirtual 25	java/io/FileInputStream:read	([B)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +32 -> 74
    //   45: aload_2
    //   46: astore_0
    //   47: aload_3
    //   48: aload 4
    //   50: iload_1
    //   51: invokevirtual 28	com/huawei/hianalytics/ab/bc/kl/ab:ab	([BI)V
    //   54: goto -23 -> 31
    //   57: astore_0
    //   58: aload_2
    //   59: astore_0
    //   60: ldc 30
    //   62: ldc 32
    //   64: invokestatic 38	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_2
    //   68: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   71: ldc 43
    //   73: areturn
    //   74: aload_2
    //   75: astore_0
    //   76: aload_3
    //   77: invokevirtual 46	com/huawei/hianalytics/ab/bc/kl/ab:ab	()I
    //   80: ifne +10 -> 90
    //   83: aload_2
    //   84: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   87: ldc 43
    //   89: areturn
    //   90: aload_2
    //   91: astore_0
    //   92: new 48	java/lang/String
    //   95: dup
    //   96: aload_3
    //   97: invokevirtual 52	com/huawei/hianalytics/ab/bc/kl/ab:bc	()[B
    //   100: ldc 54
    //   102: invokespecial 57	java/lang/String:<init>	([BLjava/lang/String;)V
    //   105: astore_3
    //   106: aload_2
    //   107: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   110: aload_3
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_0
    //   117: ldc 30
    //   119: ldc 59
    //   121: invokestatic 38	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   128: ldc 43
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_3
    //   134: aload_0
    //   135: astore_2
    //   136: aload_3
    //   137: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: aload_0
    //   144: astore_3
    //   145: goto -9 -> 136
    //   148: astore_0
    //   149: goto -34 -> 115
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_2
    //   155: goto -97 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramFile	java.io.File
    //   39	12	1	i	int
    //   8	133	2	localObject1	Object
    //   142	1	2	localObject2	Object
    //   154	1	2	localObject3	Object
    //   21	124	3	localObject4	Object
    //   29	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	22	57	java/io/FileNotFoundException
    //   24	31	57	java/io/FileNotFoundException
    //   33	40	57	java/io/FileNotFoundException
    //   47	54	57	java/io/FileNotFoundException
    //   76	83	57	java/io/FileNotFoundException
    //   92	106	57	java/io/FileNotFoundException
    //   0	9	112	java/io/IOException
    //   0	9	131	finally
    //   11	22	142	finally
    //   24	31	142	finally
    //   33	40	142	finally
    //   47	54	142	finally
    //   60	67	142	finally
    //   76	83	142	finally
    //   92	106	142	finally
    //   117	124	142	finally
    //   11	22	148	java/io/IOException
    //   24	31	148	java/io/IOException
    //   33	40	148	java/io/IOException
    //   47	54	148	java/io/IOException
    //   76	83	148	java/io/IOException
    //   92	106	148	java/io/IOException
    //   0	9	152	java/io/FileNotFoundException
  }
  
  public static String ab(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toString("UTF-8");
    }
    finally
    {
      ab(localByteArrayOutputStream);
    }
    ab(localByteArrayOutputStream);
    return paramInputStream;
  }
  
  public static void ab(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      ab.cd("StreamUtil", "closeQuietly(): Exception when closing the closeable!");
    }
  }
  
  /* Error */
  public static void ab(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 87	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: aload_2
    //   14: aload_1
    //   15: ldc 54
    //   17: invokevirtual 92	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   20: invokevirtual 95	java/io/FileOutputStream:write	([B)V
    //   23: aload_2
    //   24: astore_0
    //   25: aload_2
    //   26: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   29: aload_2
    //   30: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   33: return
    //   34: astore_0
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_2
    //   38: astore_0
    //   39: ldc 30
    //   41: ldc 100
    //   43: invokestatic 38	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   50: return
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: ldc 30
    //   58: ldc 102
    //   60: invokestatic 38	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_2
    //   64: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   67: return
    //   68: astore_1
    //   69: aload_3
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic 41	com/huawei/hianalytics/ab/bc/kl/de:ab	(Ljava/io/Closeable;)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: goto -7 -> 71
    //   81: astore_0
    //   82: goto -28 -> 54
    //   85: astore_0
    //   86: goto -49 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramFile	java.io.File
    //   0	89	1	paramString	String
    //   10	54	2	localFileOutputStream	java.io.FileOutputStream
    //   1	69	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	34	java/io/FileNotFoundException
    //   2	11	51	java/io/IOException
    //   2	11	68	finally
    //   13	23	77	finally
    //   25	29	77	finally
    //   39	46	77	finally
    //   56	63	77	finally
    //   13	23	81	java/io/IOException
    //   25	29	81	java/io/IOException
    //   13	23	85	java/io/FileNotFoundException
    //   25	29	85	java/io/FileNotFoundException
  }
  
  private static void ab(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      ab.cd("StreamUtil", "closeStream(): Exception: close OutputStream error!");
    }
  }
  
  public static void ab(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      paramHttpURLConnection.getInputStream().close();
      paramHttpURLConnection.disconnect();
      ab.ab("StreamUtil", " connHttp disconnect");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.cd("StreamUtil", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
      }
    }
  }
  
  public static byte[] ab(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[1024];
    while (!localDeflater.finished()) {
      localByteArrayOutputStream.write(paramArrayOfByte, 0, localDeflater.deflate(paramArrayOfByte));
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localDeflater.end();
    ab(localByteArrayOutputStream);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.kl.de
 * JD-Core Version:    0.7.0.1
 */