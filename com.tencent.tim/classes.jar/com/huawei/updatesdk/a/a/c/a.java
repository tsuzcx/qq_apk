package com.huawei.updatesdk.a.a.c;

public class a
{
  private static char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    char[] arrayOfChar1 = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    int i = 0;
    int m;
    if (i < paramInt)
    {
      m = (paramArrayOfByte[i] & 0xFF) << 8;
      if (i + 1 >= paramInt) {
        break label227;
      }
      m |= paramArrayOfByte[(i + 1)] & 0xFF;
    }
    label208:
    label227:
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (i + 2 < paramInt) {
        m |= paramArrayOfByte[(i + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar2 = a;
        if (n != 0)
        {
          n = m & 0x3F;
          label104:
          arrayOfChar1[(j + 3)] = arrayOfChar2[n];
          m >>= 6;
          arrayOfChar2 = a;
          if (k == 0) {
            break label208;
          }
        }
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfChar1[(j + 2)] = arrayOfChar2[k];
          k = m >> 6;
          arrayOfChar1[(j + 1)] = a[(k & 0x3F)];
          arrayOfChar1[(j + 0)] = a[(k >> 6 & 0x3F)];
          j += 4;
          i += 3;
          break;
          n = 64;
          break label104;
        }
        return String.valueOf(arrayOfChar1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */