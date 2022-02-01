package com.tencent.qqmini.sdk.core.utils;

public class SecurityUtil
{
  private static char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String getFileSHA1(String paramString)
  {
    try
    {
      paramString = getHash(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  private static String getHash(String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: new 49	java/io/BufferedInputStream
    //   3: dup
    //   4: new 51	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 57	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 63	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 69	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +28 -> 62
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 73	java/security/MessageDigest:update	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 76	java/io/InputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 76	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 80	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 84	com/tencent/qqmini/sdk/core/utils/SecurityUtil:toHexString	([B)Ljava/lang/String;
    //   77: areturn
    //   78: astore_0
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -37 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   32	9	2	i	int
    //   21	18	3	arrayOfByte	byte[]
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   66	70	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   0	16	86	finally
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(hexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.SecurityUtil
 * JD-Core Version:    0.7.0.1
 */