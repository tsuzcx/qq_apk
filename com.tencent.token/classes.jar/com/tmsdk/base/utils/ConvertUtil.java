package com.tmsdk.base.utils;

public class ConvertUtil
{
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static final String bytesToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() < 2) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(str.toUpperCase());
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return "";
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return 0;
      }
      if (paramArrayOfByte.length != 4) {
        return 0;
      }
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
    }
    return 0;
  }
  
  public static final String bytesToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append((char)paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase();
  }
  
  public static byte[] hexStringToByte(String paramString)
  {
    int i = 0;
    if ((paramString != null) && (paramString.trim().length() > 0))
    {
      int j = paramString.length() / 2;
      byte[] arrayOfByte = new byte[j];
      paramString = paramString.toCharArray();
      while (i < j)
      {
        int k = i * 2;
        int m = a(paramString[k]);
        arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  /* Error */
  public static byte[] inputStreamToBytes(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +7 -> 8
    //   4: iconst_0
    //   5: newarray byte
    //   7: areturn
    //   8: new 75	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 76	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_2
    //   16: sipush 1024
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_0
    //   23: aload_3
    //   24: invokevirtual 81	java/io/InputStream:read	([B)I
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_m1
    //   30: if_icmpeq +13 -> 43
    //   33: aload_2
    //   34: aload_3
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual 85	java/io/ByteArrayOutputStream:write	([BII)V
    //   40: goto -18 -> 22
    //   43: aload_2
    //   44: invokevirtual 89	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 92	java/io/ByteArrayOutputStream:close	()V
    //   52: aload_0
    //   53: areturn
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   59: aload_0
    //   60: areturn
    //   61: astore_0
    //   62: goto +25 -> 87
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   70: iconst_0
    //   71: newarray byte
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 92	java/io/ByteArrayOutputStream:close	()V
    //   78: aload_0
    //   79: areturn
    //   80: astore_2
    //   81: aload_2
    //   82: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   85: aload_0
    //   86: areturn
    //   87: aload_2
    //   88: invokevirtual 92	java/io/ByteArrayOutputStream:close	()V
    //   91: goto +8 -> 99
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramInputStream	java.io.InputStream
    //   27	10	1	i	int
    //   15	34	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   54	21	2	localIOException1	java.io.IOException
    //   80	8	2	localIOException2	java.io.IOException
    //   94	2	2	localIOException3	java.io.IOException
    //   21	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/io/IOException
    //   16	22	61	finally
    //   22	28	61	finally
    //   33	40	61	finally
    //   43	48	61	finally
    //   66	74	61	finally
    //   16	22	65	java/io/IOException
    //   22	28	65	java/io/IOException
    //   33	40	65	java/io/IOException
    //   43	48	65	java/io/IOException
    //   74	78	80	java/io/IOException
    //   87	91	94	java/io/IOException
  }
  
  public static byte[] intToBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public static byte stringToByte(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.trim().length() > 0)
      {
        byte b = Byte.valueOf(paramString).byteValue();
        return b;
      }
      return -1;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length()];
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length())
    {
      arrayOfByte[i] = ((byte)arrayOfChar[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int stringToInt(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.trim().length() > 0)
      {
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      return -1;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public static long stringToLong(String paramString)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramString != null) {
      l1 = l2;
    }
    try
    {
      if (paramString.trim().length() > 0) {
        l1 = Long.valueOf(paramString).longValue();
      }
      return l1;
    }
    catch (Exception paramString) {}
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.ConvertUtil
 * JD-Core Version:    0.7.0.1
 */