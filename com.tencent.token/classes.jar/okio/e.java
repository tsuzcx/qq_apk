package okio;

import java.io.UnsupportedEncodingException;

final class e
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
  
  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[(paramArrayOfByte1.length + 2) / 3 * 4];
    int k = paramArrayOfByte1.length - paramArrayOfByte1.length % 3;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[i] & 0xFF) >> 2)];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[((paramArrayOfByte1[i] & 0x3) << 4 | (paramArrayOfByte1[(i + 1)] & 0xFF) >> 4)];
      m = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[(i + 1)] & 0xF) << 2 | (paramArrayOfByte1[(i + 2)] & 0xFF) >> 6)];
      j = m + 1;
      arrayOfByte[m] = paramArrayOfByte2[(paramArrayOfByte1[(i + 2)] & 0x3F)];
      i += 3;
    }
    switch (paramArrayOfByte1.length % 3)
    {
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(arrayOfByte, "US-ASCII");
        return paramArrayOfByte1;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        throw new AssertionError(paramArrayOfByte1);
      }
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0x3) << 4)];
      i = j + 1;
      arrayOfByte[j] = 61;
      arrayOfByte[i] = 61;
      continue;
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0xFF) >> 2)];
      j = i + 1;
      arrayOfByte[i] = paramArrayOfByte2[((paramArrayOfByte1[k] & 0x3) << 4 | (paramArrayOfByte1[(k + 1)] & 0xFF) >> 4)];
      i = j + 1;
      arrayOfByte[j] = paramArrayOfByte2[((paramArrayOfByte1[(k + 1)] & 0xF) << 2)];
      arrayOfByte[i] = 61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.e
 * JD-Core Version:    0.7.0.1
 */