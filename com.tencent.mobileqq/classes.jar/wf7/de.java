package wf7;

import java.io.UnsupportedEncodingException;

public class de
{
  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    de.b localb = new de.b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localb.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      if (localb.jX == localb.jW.length) {
        return localb.jW;
      }
      paramArrayOfByte = new byte[localb.jX];
      System.arraycopy(localb.jW, 0, paramArrayOfByte, 0, localb.jX);
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    de.c localc = new de.c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    boolean bool = localc.kf;
    int j = 2;
    int k;
    if (bool)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
    }
    else
    {
      k = paramInt2 % 3;
      paramInt3 = i;
      if (k != 0) {
        if (k != 1)
        {
          if (k != 2) {
            paramInt3 = i;
          } else {
            paramInt3 = i + 3;
          }
        }
        else {
          paramInt3 = i + 2;
        }
      }
    }
    i = paramInt3;
    if (localc.kg)
    {
      i = paramInt3;
      if (paramInt2 > 0)
      {
        k = (paramInt2 - 1) / 57;
        if (localc.kh) {
          i = j;
        } else {
          i = 1;
        }
        i = paramInt3 + (k + 1) * i;
      }
    }
    localc.jW = new byte[i];
    localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((!cF) && (localc.jX != i)) {
      throw new AssertionError();
    }
    return localc.jW;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.de
 * JD-Core Version:    0.7.0.1
 */