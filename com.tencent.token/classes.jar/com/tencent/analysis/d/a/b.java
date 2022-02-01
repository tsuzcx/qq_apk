package com.tencent.analysis.d.a;

public final class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static byte[] b = new byte[0];
  
  private static byte a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramChar -= '0';
      return (byte)paramChar;
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      paramChar = paramChar - c + 10;
      break;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return 0;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      int j = paramArrayOfByte.length;
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length == 0) {
          return null;
        }
        int k = paramArrayOfByte.length;
        int i = 0;
        if (j + 0 <= k)
        {
          localObject = new char[j * 2];
          while (i < j)
          {
            k = paramArrayOfByte[i];
            int m = i * 2;
            char[] arrayOfChar = a;
            localObject[(m + 1)] = arrayOfChar[(k & 0xF)];
            localObject[m] = arrayOfChar[((byte)(k >>> 4) & 0xF)];
            i += 1;
          }
          return new String((char[])localObject);
        }
        Object localObject = new StringBuilder("offset + length(");
        ((StringBuilder)localObject).append(0);
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(") > bytes.length(");
        ((StringBuilder)localObject).append(paramArrayOfByte.length);
        ((StringBuilder)localObject).append(")");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        int j = i << 1;
        char c1 = paramString.charAt(j);
        char c2 = paramString.charAt(j + 1);
        arrayOfByte[i] = ((byte)((a(c1) << 4) + a(c2)));
        i += 1;
      }
      return arrayOfByte;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.d.a.b
 * JD-Core Version:    0.7.0.1
 */