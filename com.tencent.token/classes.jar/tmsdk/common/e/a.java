package tmsdk.common.e;

import java.io.UnsupportedEncodingException;

public class a
{
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localc.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localc.b == localc.a.length) {
        return localc.a;
      }
      paramArrayOfByte = new byte[localc.b];
      System.arraycopy(localc.a, 0, paramArrayOfByte, 0, localc.b);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(c(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    d locald = new d(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    if (locald.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      default: 
        paramInt3 = i;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      case 1: 
        paramInt3 = i + 2;
      }
    }
    i = paramInt3;
    if (locald.e)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        int j = (paramInt2 - 1) / 57;
        if (locald.f) {
          i = 2;
        } else {
          i = 1;
        }
        i = paramInt3 + (j + 1) * i;
      }
    }
    locald.a = new byte[i];
    locald.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!a) && (locald.b != i)) {
      throw new AssertionError();
    }
    return locald.a;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.e.a
 * JD-Core Version:    0.7.0.1
 */