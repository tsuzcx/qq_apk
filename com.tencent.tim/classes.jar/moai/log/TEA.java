package moai.log;

final class TEA
{
  private static int byte2int(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private static void decrypt16(byte[] paramArrayOfByte1, int paramInt1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    if (paramArrayOfByte1.length < paramInt1 + 8) {
      throw new IndexOutOfBoundsException("len: " + paramArrayOfByte1.length + ", offset: " + paramInt1);
    }
    if (paramArrayOfInt.length != 4) {
      throw new IllegalArgumentException("key error: " + paramArrayOfInt.length);
    }
    int k = byte2int(paramArrayOfByte1, paramInt1);
    int m = byte2int(paramArrayOfByte1, paramInt1 + 4);
    int n = paramArrayOfInt[0];
    int i1 = paramArrayOfInt[1];
    int i2 = paramArrayOfInt[2];
    int i3 = paramArrayOfInt[3];
    int j = -478700656;
    paramInt1 = k;
    k = m;
    while (i < 16)
    {
      k -= ((paramInt1 << 4) + i2 ^ paramInt1 + j ^ (paramInt1 >>> 5) + i3);
      paramInt1 -= ((k << 4) + n ^ k + j ^ (k >>> 5) + i1);
      j += 1640531527;
      i += 1;
    }
    int2byte(paramInt1, paramArrayOfByte2, paramInt2);
    int2byte(k, paramArrayOfByte2, paramInt2 + 4);
  }
  
  public static byte[] decrypt16(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1.length % 8 != 0) {
      throw new IllegalArgumentException("in error: " + paramArrayOfByte1.length);
    }
    if (paramArrayOfByte1.length == 0) {
      return new byte[0];
    }
    paramArrayOfByte2 = genKey(paramArrayOfByte2);
    paramArrayOfByte3 = new byte[8];
    decrypt16(paramArrayOfByte1, paramArrayOfByte1.length - 8, paramArrayOfByte2, paramArrayOfByte3, 0);
    int i = paramArrayOfByte3.length;
    while ((i > 0) && (paramArrayOfByte3[(i - 1)] == 0)) {
      i -= 1;
    }
    if ((i == 0) && (paramArrayOfByte3[0] == 0)) {
      throw new IllegalStateException("encrypt error");
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length - 8 + i];
    int j = 0;
    int k = 0;
    while (k < paramArrayOfByte1.length - 8)
    {
      decrypt16(paramArrayOfByte1, k, paramArrayOfByte2, arrayOfByte, j);
      k += 8;
      j += 8;
    }
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, j, i);
    return arrayOfByte;
  }
  
  private static void encrypt16(byte[] paramArrayOfByte1, int paramInt1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt2)
  {
    int j = 0;
    if (paramArrayOfByte1.length < paramInt1 + 8) {
      throw new IndexOutOfBoundsException("len: " + paramArrayOfByte1.length + ", offset: " + paramInt1);
    }
    if (paramArrayOfInt.length != 4) {
      throw new IllegalArgumentException("key error: " + paramArrayOfInt.length);
    }
    int i = byte2int(paramArrayOfByte1, paramInt1);
    paramInt1 = byte2int(paramArrayOfByte1, paramInt1 + 4);
    int m = paramArrayOfInt[0];
    int n = paramArrayOfInt[1];
    int i1 = paramArrayOfInt[2];
    int i2 = paramArrayOfInt[3];
    int k = 0;
    while (j < 16)
    {
      k -= 1640531527;
      i += ((paramInt1 << 4) + m ^ paramInt1 + k ^ (paramInt1 >>> 5) + n);
      paramInt1 += ((i << 4) + i1 ^ i + k ^ (i >>> 5) + i2);
      j += 1;
    }
    int2byte(i, paramArrayOfByte2, paramInt2);
    int2byte(paramInt1, paramArrayOfByte2, paramInt2 + 4);
  }
  
  public static byte[] encrypt16(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramString = paramString.getBytes();
    return encrypt16(paramString, 0, paramString.length, paramArrayOfByte1, paramArrayOfByte2, 0);
  }
  
  public static byte[] encrypt16(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      paramArrayOfByte3 = new byte[0];
    }
    int[] arrayOfInt;
    int j;
    do
    {
      return paramArrayOfByte3;
      if (paramArrayOfByte1.length < paramInt1 + paramInt2) {
        throw new IndexOutOfBoundsException("len: " + paramArrayOfByte1.length + ", offset: " + paramInt1 + ", inLen: " + paramInt2);
      }
      arrayOfInt = genKey(paramArrayOfByte2);
      int i = paramInt2 / 8;
      j = paramInt2 % 8;
      if (j > 0) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        paramInt2 = (paramInt2 + i) * 8;
        if (paramArrayOfByte3 != null)
        {
          paramArrayOfByte2 = paramArrayOfByte3;
          if (paramArrayOfByte3.length >= paramInt2) {}
        }
        else
        {
          paramArrayOfByte2 = new byte[paramInt2];
        }
        paramInt2 = paramInt1;
        while (paramInt2 < i * 8 + paramInt1)
        {
          encrypt16(paramArrayOfByte1, paramInt2, arrayOfInt, paramArrayOfByte2, paramInt3);
          paramInt2 += 8;
          paramInt3 += 8;
        }
      }
      paramArrayOfByte3 = paramArrayOfByte2;
    } while (j <= 0);
    paramArrayOfByte3 = new byte[8];
    System.arraycopy(paramArrayOfByte1, paramInt2, paramArrayOfByte3, 0, j);
    encrypt16(paramArrayOfByte3, 0, arrayOfInt, paramArrayOfByte2, paramInt3);
    return paramArrayOfByte2;
  }
  
  public static int encrypt16Len(String paramString)
  {
    paramString = paramString.getBytes();
    return encrypt16Len(paramString, 0, paramString.length);
  }
  
  public static int encrypt16Len(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    if (paramArrayOfByte.length < paramInt1 + paramInt2) {
      throw new IndexOutOfBoundsException("len: " + paramArrayOfByte.length + ", offset: " + paramInt1 + ", inLen: " + paramInt2);
    }
    int j = paramInt2 / 8;
    paramInt1 = i;
    if (paramInt2 % 8 > 0) {
      paramInt1 = 1;
    }
    return (paramInt1 + j) * 8;
  }
  
  private static int[] genKey(byte[] paramArrayOfByte)
  {
    return new int[] { byte2int(paramArrayOfByte, 0), byte2int(paramArrayOfByte, 4), byte2int(paramArrayOfByte, 8), byte2int(paramArrayOfByte, 12) };
  }
  
  private static void int2byte(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >>> 0 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >>> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >>> 24 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.TEA
 * JD-Core Version:    0.7.0.1
 */