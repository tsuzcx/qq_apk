import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class arnd
{
  public static byte[] K(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  private static void b(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k >> 2)
    {
      int m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = ((paramArrayOfByte[m] & 0xFF) << 24 | n);
      i += 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  private static void b(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int j = i;
    if (i > paramInt) {
      j = paramInt;
    }
    int k = 0;
    i = 0;
    while (i < j)
    {
      int m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
      k = m + 1;
    }
    if ((paramInt > j) && (k < paramArrayOfByte.length))
    {
      paramInt = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = 8;
      while ((j <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> j & 0xFF));
        j += 8;
        paramInt += 1;
      }
    }
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = K(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    if ((paramArrayOfByte1.length % 4 != 0) || (paramArrayOfByte1.length < 8)) {
      return null;
    }
    paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
    b(paramArrayOfByte1, paramArrayOfByte2);
    if (arrayOfByte.length % 4 == 0) {}
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
    }
    b(arrayOfByte, paramArrayOfByte1);
    int m = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[m];
    i = paramArrayOfByte2[0];
    int j = (52 / (m + 1) + 6) * -1640531527;
    while (j != 0)
    {
      int n = j >>> 2 & 0x3;
      int k = i;
      i = m;
      while (i > 0)
      {
        i1 = paramArrayOfByte2[(i - 1)];
        k = paramArrayOfByte2[i] - ((k ^ j) + (i1 ^ paramArrayOfByte1[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        paramArrayOfByte2[i] = k;
        i -= 1;
      }
      int i1 = paramArrayOfByte2[m];
      i = paramArrayOfByte2[0] - ((paramArrayOfByte1[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
      paramArrayOfByte2[0] = i;
      j += 1640531527;
    }
    i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
    if ((i < 0) || (i > paramArrayOfByte2.length - 1 << 2)) {
      return null;
    }
    paramArrayOfByte1 = new byte[i];
    b(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
    return paramArrayOfByte1;
  }
  
  public static byte[] getKey()
  {
    try
    {
      byte[] arrayOfByte = "DFG#$%^#%$RGHR(&*M<><".getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnd
 * JD-Core Version:    0.7.0.1
 */