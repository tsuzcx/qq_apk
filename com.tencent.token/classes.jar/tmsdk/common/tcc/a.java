package tmsdk.common.tcc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class a
{
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k >> 2; j = m + 1)
    {
      m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
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
  
  private static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int j = i;
    if (i > paramInt) {
      j = paramInt;
    }
    i = 0;
    int k = 0;
    int m;
    for (;;)
    {
      m = 8;
      if (i >= j) {
        break;
      }
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((paramInt > j) && (k < paramArrayOfByte.length))
    {
      paramInt = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = m;
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
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = getKey();
    }
    arrayOfByte = makePassword(arrayOfByte);
    if ((paramArrayOfByte1 != null) && (arrayOfByte != null))
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      if (paramArrayOfByte1.length % 4 == 0)
      {
        if (paramArrayOfByte1.length < 8) {
          return null;
        }
        paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
        a(paramArrayOfByte1, paramArrayOfByte2);
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte1 = new int[j];
        int i = 0;
        while (i < j)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int m = paramArrayOfByte2.length - 1;
        i = paramArrayOfByte2[m];
        i = paramArrayOfByte2[0];
        j = (52 / (m + 1) + 6) * -1640531527;
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
          i = paramArrayOfByte2[0] - ((i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4) ^ (k ^ j) + (paramArrayOfByte1[(i & 0x3 ^ n)] ^ i1));
          paramArrayOfByte2[0] = i;
          j += 1640531527;
        }
        i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
        if (i >= 0)
        {
          if (i > paramArrayOfByte2.length - 1 << 2) {
            return null;
          }
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = getKey();
    }
    arrayOfByte = makePassword(arrayOfByte);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        if (paramArrayOfByte1.length == 0) {
          return paramArrayOfByte1;
        }
        if (paramArrayOfByte1.length % 4 == 0) {
          i = (paramArrayOfByte1.length >>> 2) + 1;
        } else {
          i = (paramArrayOfByte1.length >>> 2) + 2;
        }
        int[] arrayOfInt = new int[i];
        a(paramArrayOfByte1, arrayOfInt);
        arrayOfInt[(i - 1)] = paramArrayOfByte1.length;
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte1 = new int[j];
        int i = 0;
        while (i < j)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int i1 = arrayOfInt.length - 1;
        i = arrayOfInt[i1];
        j = arrayOfInt[0];
        j = 52 / (i1 + 1) + 6;
        int m;
        for (int k = 0; j > 0; k = m)
        {
          m = k - 1640531527;
          int i2 = m >>> 2 & 0x3;
          int n = 0;
          k = i;
          for (i = n; i < i1; i = n)
          {
            n = i + 1;
            int i3 = arrayOfInt[n];
            int i4 = arrayOfInt[i];
            k = ((k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4) ^ (i3 ^ m) + (k ^ paramArrayOfByte1[(i & 0x3 ^ i2)])) + i4;
            arrayOfInt[i] = k;
          }
          n = arrayOfInt[0];
          i = arrayOfInt[i1] + ((k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4) ^ (n ^ m) + (paramArrayOfByte1[(i2 ^ i & 0x3)] ^ k));
          arrayOfInt[i1] = i;
          j -= 1;
        }
        paramArrayOfByte2 = new byte[arrayOfInt.length << 2];
        a(arrayOfInt, arrayOfInt.length, paramArrayOfByte2);
      }
    }
    return paramArrayOfByte2;
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
  
  public static byte[] makePassword(byte[] paramArrayOfByte)
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
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label33:
      break label33;
    }
    localObject = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.tcc.a
 * JD-Core Version:    0.7.0.1
 */