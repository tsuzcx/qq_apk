package com.tencent.token;

import com.qq.taf.jce.JceStruct;
import tmsdk.common.tcc.TccCryptor;

public final class apu
{
  @Deprecated
  public static JceStruct a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JceStruct paramJceStruct)
  {
    if (paramArrayOfByte2 != null)
    {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2);
      if (paramArrayOfByte1 == null) {
        return null;
      }
      return aqa.a(paramArrayOfByte1, paramJceStruct);
    }
    return null;
  }
  
  public static byte[] a(JceStruct paramJceStruct)
  {
    paramJceStruct = a(aqa.a(paramJceStruct));
    if (paramJceStruct == null) {
      return null;
    }
    return paramJceStruct;
  }
  
  /* Error */
  static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 27	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 33	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 36	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 40	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 43	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 51	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: goto +26 -> 75
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   57: aload_1
    //   58: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   61: aload_2
    //   62: invokevirtual 51	java/util/zip/DeflaterOutputStream:close	()V
    //   65: goto +8 -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_1
    //   76: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 51	java/util/zip/DeflaterOutputStream:close	()V
    //   83: goto +8 -> 91
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	35	1	localIOException1	java.io.IOException
    //   86	2	1	localIOException2	java.io.IOException
    //   16	64	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   53	57	48	finally
    //   17	31	52	java/io/IOException
    //   57	65	68	java/io/IOException
    //   75	83	86	java/io/IOException
  }
  
  @Deprecated
  public static byte[] a(byte[] paramArrayOfByte, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = a(paramJceStruct);
    if (paramJceStruct == null) {
      return null;
    }
    return TccCryptor.encrypt(paramJceStruct, paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 != null) {
      if (paramArrayOfByte2.length == 0) {
        return null;
      }
    }
    try
    {
      paramArrayOfByte1 = TccCryptor.decrypt(paramArrayOfByte2, paramArrayOfByte1);
      if (paramArrayOfByte1 == null) {
        return null;
      }
      return b(paramArrayOfByte1);
    }
    catch (Exception paramArrayOfByte1) {}
    return null;
    return null;
  }
  
  /* Error */
  static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 71	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 73	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 75	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 78	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 27	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 82	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 85	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 47	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 87	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: goto +32 -> 107
    //   78: astore 4
    //   80: aload 4
    //   82: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   85: aload_0
    //   86: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   89: aload_2
    //   90: invokevirtual 87	java/util/zip/InflaterInputStream:close	()V
    //   93: aload_3
    //   94: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   97: goto +8 -> 105
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_0
    //   108: invokevirtual 86	java/io/ByteArrayInputStream:close	()V
    //   111: aload_2
    //   112: invokevirtual 87	java/util/zip/InflaterInputStream:close	()V
    //   115: aload_3
    //   116: invokevirtual 50	java/io/ByteArrayOutputStream:close	()V
    //   119: goto +8 -> 127
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 54	java/io/IOException:printStackTrace	()V
    //   127: aload 4
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	95	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	91	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	1	4	localObject	Object
    //   78	50	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   80	85	73	finally
    //   26	31	78	java/io/IOException
    //   36	41	78	java/io/IOException
    //   44	50	78	java/io/IOException
    //   85	97	100	java/io/IOException
    //   107	119	122	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apu
 * JD-Core Version:    0.7.0.1
 */