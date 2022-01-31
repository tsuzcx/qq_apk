package com.tencent.qphone.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public abstract class b
{
  public static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    paramOutputStream = new DeflaterOutputStream(paramOutputStream);
    try
    {
      paramOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramOutputStream.finish();
      paramOutputStream.flush();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    int i = 1024;
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(paramInputStream);
    paramInputStream = new ByteArrayOutputStream(1024);
    try
    {
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        i = localInflaterInputStream.read(arrayOfByte, 0, i);
        if (i <= 0) {
          break;
        }
        paramInputStream.write(arrayOfByte, 0, i);
      }
      return paramInputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 56	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 57	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 60	java/util/zip/Deflater:reset	()V
    //   12: aload_2
    //   13: aload_0
    //   14: invokevirtual 64	java/util/zip/Deflater:setInput	([B)V
    //   17: aload_2
    //   18: invokevirtual 65	java/util/zip/Deflater:finish	()V
    //   21: new 39	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: aload_0
    //   26: arraylength
    //   27: invokespecial 42	java/io/ByteArrayOutputStream:<init>	(I)V
    //   30: astore_3
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 69	java/util/zip/Deflater:finished	()Z
    //   41: ifne +32 -> 73
    //   44: aload_3
    //   45: aload_1
    //   46: iconst_0
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 73	java/util/zip/Deflater:deflate	([B)I
    //   52: invokevirtual 47	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   63: aload_3
    //   64: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   67: aload_2
    //   68: invokevirtual 80	java/util/zip/Deflater:end	()V
    //   71: aload_0
    //   72: areturn
    //   73: aload_3
    //   74: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_3
    //   81: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   84: goto -17 -> 67
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 31	java/io/IOException:printStackTrace	()V
    //   92: goto -25 -> 67
    //   95: astore_0
    //   96: aload_3
    //   97: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 31	java/io/IOException:printStackTrace	()V
    //   107: goto -7 -> 100
    //   110: astore_1
    //   111: goto -23 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfByte	byte[]
    //   36	13	1	arrayOfByte1	byte[]
    //   58	2	1	localException	java.lang.Exception
    //   77	2	1	arrayOfByte2	byte[]
    //   87	2	1	localIOException1	IOException
    //   102	2	1	localIOException2	IOException
    //   110	1	1	localIOException3	IOException
    //   7	61	2	localDeflater	java.util.zip.Deflater
    //   30	67	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	37	58	java/lang/Exception
    //   37	55	58	java/lang/Exception
    //   73	78	58	java/lang/Exception
    //   80	84	87	java/io/IOException
    //   31	37	95	finally
    //   37	55	95	finally
    //   59	63	95	finally
    //   73	78	95	finally
    //   96	100	102	java/io/IOException
    //   63	67	110	java/io/IOException
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 83	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 84	java/util/zip/Inflater:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 85	java/util/zip/Inflater:reset	()V
    //   12: aload_2
    //   13: aload_0
    //   14: invokevirtual 86	java/util/zip/Inflater:setInput	([B)V
    //   17: new 39	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: aload_0
    //   22: arraylength
    //   23: invokespecial 42	java/io/ByteArrayOutputStream:<init>	(I)V
    //   26: astore_3
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 87	java/util/zip/Inflater:finished	()Z
    //   37: ifne +32 -> 69
    //   40: aload_3
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 90	java/util/zip/Inflater:inflate	([B)I
    //   48: invokevirtual 47	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: astore_1
    //   55: aload_1
    //   56: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   59: aload_3
    //   60: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_2
    //   64: invokevirtual 91	java/util/zip/Inflater:end	()V
    //   67: aload_0
    //   68: areturn
    //   69: aload_3
    //   70: invokevirtual 51	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_3
    //   77: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   80: goto -17 -> 63
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 31	java/io/IOException:printStackTrace	()V
    //   88: goto -25 -> 63
    //   91: astore_0
    //   92: aload_3
    //   93: invokevirtual 77	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_0
    //   97: athrow
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 31	java/io/IOException:printStackTrace	()V
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -23 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   32	13	1	arrayOfByte1	byte[]
    //   54	2	1	localException	java.lang.Exception
    //   73	2	1	arrayOfByte2	byte[]
    //   83	2	1	localIOException1	IOException
    //   98	2	1	localIOException2	IOException
    //   106	1	1	localIOException3	IOException
    //   7	57	2	localInflater	java.util.zip.Inflater
    //   26	67	3	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   27	33	54	java/lang/Exception
    //   33	51	54	java/lang/Exception
    //   69	74	54	java/lang/Exception
    //   76	80	83	java/io/IOException
    //   27	33	91	finally
    //   33	51	91	finally
    //   55	59	91	finally
    //   69	74	91	finally
    //   92	96	98	java/io/IOException
    //   59	63	106	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.b
 * JD-Core Version:    0.7.0.1
 */