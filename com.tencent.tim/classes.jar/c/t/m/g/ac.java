package c.t.m.g;

import java.io.IOException;
import java.io.OutputStream;

public final class ac
{
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  private static int a(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      return paramChar - 'A';
    }
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return paramChar - 'a' + 26;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0' + 26 + 26;
    }
    switch (paramChar)
    {
    default: 
      throw new RuntimeException("unexpected code: ".concat(String.valueOf(paramChar)));
    case '+': 
      return 62;
    case '/': 
      return 63;
    }
    return 0;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3 / 2);
    int i = 0;
    while (i <= j - 3)
    {
      int k = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
      localStringBuffer.append(a[(k >> 18 & 0x3F)]);
      localStringBuffer.append(a[(k >> 12 & 0x3F)]);
      localStringBuffer.append(a[(k >> 6 & 0x3F)]);
      localStringBuffer.append(a[(k & 0x3F)]);
      i += 3;
    }
    if (i == j - 2)
    {
      j = paramArrayOfByte[i];
      i = (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | (j & 0xFF) << 16;
      localStringBuffer.append(a[(i >> 18 & 0x3F)]);
      localStringBuffer.append(a[(i >> 12 & 0x3F)]);
      localStringBuffer.append(a[(i >> 6 & 0x3F)]);
      localStringBuffer.append("=");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (i == j - 1)
      {
        i = (paramArrayOfByte[i] & 0xFF) << 16;
        localStringBuffer.append(a[(i >> 18 & 0x3F)]);
        localStringBuffer.append(a[(i >> 12 & 0x3F)]);
        localStringBuffer.append("==");
      }
    }
  }
  
  private static void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    int j = paramString.length();
    for (;;)
    {
      if ((i < j) && (paramString.charAt(i) <= ' '))
      {
        i += 1;
      }
      else
      {
        if (i == j) {
          break;
        }
        int k = (a(paramString.charAt(i)) << 18) + (a(paramString.charAt(i + 1)) << 12) + (a(paramString.charAt(i + 2)) << 6) + a(paramString.charAt(i + 3));
        paramOutputStream.write(k >> 16 & 0xFF);
        if (paramString.charAt(i + 2) == '=') {
          break;
        }
        paramOutputStream.write(k >> 8 & 0xFF);
        if (paramString.charAt(i + 3) == '=') {
          break;
        }
        paramOutputStream.write(k & 0xFF);
        i += 4;
      }
    }
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 79	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 81	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 83	c/t/m/g/ac:a	(Ljava/lang/String;Ljava/io/OutputStream;)V
    //   13: aload_1
    //   14: invokevirtual 87	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 90	java/io/ByteArrayOutputStream:close	()V
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: new 22	java/lang/RuntimeException
    //   28: dup
    //   29: invokespecial 91	java/lang/RuntimeException:<init>	()V
    //   32: athrow
    //   33: astore_1
    //   34: getstatic 97	java/lang/System:err	Ljava/io/PrintStream;
    //   37: new 99	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 101
    //   43: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 103	java/io/IOException:toString	()Ljava/lang/String;
    //   50: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 112	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramString	String
    //   7	12	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   33	14	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   8	13	24	java/io/IOException
    //   18	22	33	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ac
 * JD-Core Version:    0.7.0.1
 */