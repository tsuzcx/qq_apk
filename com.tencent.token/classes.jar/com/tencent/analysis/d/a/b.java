package com.tencent.analysis.d.a;

public final class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static byte[] b = new byte[0];
  
  private static byte a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return (byte)(paramChar - '0');
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return (byte)(paramChar - 'a' + 10);
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return (byte)(paramChar - 'A' + 10);
    }
    return 0;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    int j;
    do
    {
      return null;
      j = paramArrayOfByte.length;
    } while ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0));
    if (j + 0 > paramArrayOfByte.length) {
      throw new IllegalArgumentException("offset + length(" + 0 + j + ") > bytes.length(" + paramArrayOfByte.length + ")");
    }
    char[] arrayOfChar = new char[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = a[(k & 0xF)];
      k = (byte)(k >>> 4);
      arrayOfChar[(i * 2)] = a[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return b;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      char c1 = paramString.charAt(i << 1);
      char c2 = paramString.charAt((i << 1) + 1);
      arrayOfByte[i] = ((byte)((a(c1) << 4) + a(c2)));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.d.a.b
 * JD-Core Version:    0.7.0.1
 */