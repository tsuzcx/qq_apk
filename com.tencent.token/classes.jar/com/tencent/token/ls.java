package com.tencent.token;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public final class ls
{
  private static byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private long[] b = new long[4];
  private long[] c = new long[2];
  private byte[] d = new byte[64];
  private byte[] e = new byte[16];
  
  public ls()
  {
    a();
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 & paramLong2 | paramLong4 & (0xFFFFFFFF ^ paramLong2)) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  public static String a(File paramFile)
  {
    Object localObject1 = new FileInputStream(paramFile);
    Object localObject2 = new byte[1024];
    paramFile = new char[16];
    paramFile[0] = 48;
    paramFile[1] = 49;
    paramFile[2] = 50;
    paramFile[3] = 51;
    paramFile[4] = 52;
    paramFile[5] = 53;
    paramFile[6] = 54;
    paramFile[7] = 55;
    paramFile[8] = 56;
    paramFile[9] = 57;
    paramFile[10] = 97;
    paramFile[11] = 98;
    paramFile[12] = 99;
    paramFile[13] = 100;
    paramFile[14] = 101;
    paramFile[15] = 102;
    paramFile;
    for (;;)
    {
      int j;
      int i;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        j = 0;
        i = ((FileInputStream)localObject1).read((byte[])localObject2, 0, 1024);
        if (i != -1)
        {
          localMessageDigest.update((byte[])localObject2, 0, i);
          continue;
        }
        ((FileInputStream)localObject1).close();
        localObject1 = localMessageDigest.digest();
        localObject2 = new char[32];
        i = 0;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = new String((char[])localObject2);
      return paramFile;
      while (j < 16)
      {
        int k = localObject1[j];
        int m = i + 1;
        localObject2[i] = paramFile[(k >>> 4 & 0xF)];
        i = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        j += 1;
      }
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      label12:
      int i;
      break label12;
    }
    paramString = paramString.getBytes();
    localObject = new ls();
    ((ls)localObject).a();
    ((ls)localObject).a(new ByteArrayInputStream(paramString), paramString.length);
    paramString = new byte[8];
    a(paramString, ((ls)localObject).c, 8);
    i = (int)(localObject.c[0] >>> 3) & 0x3F;
    if (i < 56) {
      i = 56 - i;
    } else {
      i = 120 - i;
    }
    ((ls)localObject).a(a, i);
    ((ls)localObject).a(paramString, 8);
    a(((ls)localObject).e, ((ls)localObject).b, 16);
    localObject = ((ls)localObject).e;
    paramString = "";
    i = 0;
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      int j = localObject[i];
      paramString = new char[16];
      paramString[0] = 48;
      paramString[1] = 49;
      paramString[2] = 50;
      paramString[3] = 51;
      paramString[4] = 52;
      paramString[5] = 53;
      paramString[6] = 54;
      paramString[7] = 55;
      paramString[8] = 56;
      paramString[9] = 57;
      paramString[10] = 65;
      paramString[11] = 66;
      paramString[12] = 67;
      paramString[13] = 68;
      paramString[14] = 69;
      paramString[15] = 70;
      paramString;
      localStringBuilder.append(new String(new char[] { paramString[(j >>> 4 & 0xF)], paramString[(j & 0xF)] }));
      paramString = localStringBuilder.toString();
      i += 1;
    }
    return paramString;
  }
  
  private void a()
  {
    long[] arrayOfLong = this.c;
    arrayOfLong[0] = 0L;
    arrayOfLong[1] = 0L;
    arrayOfLong = this.b;
    arrayOfLong[0] = 1732584193L;
    arrayOfLong[1] = 4023233417L;
    arrayOfLong[2] = 2562383102L;
    arrayOfLong[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = this.b;
    long l4 = arrayOfLong[0];
    long l1 = arrayOfLong[1];
    long l2 = arrayOfLong[2];
    long l3 = arrayOfLong[3];
    arrayOfLong = new long[16];
    int i = 0;
    int j = 0;
    while (i < 64)
    {
      int m = paramArrayOfByte[i];
      int k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l5 = k;
      m = paramArrayOfByte[(i + 1)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l6 = k;
      m = paramArrayOfByte[(i + 2)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      long l7 = k;
      m = paramArrayOfByte[(i + 3)];
      k = m;
      if (m < 0) {
        k = m & 0xFF;
      }
      arrayOfLong[j] = (l5 | l6 << 8 | l7 << 16 | k << 24);
      j += 1;
      i += 4;
    }
    l4 = a(l4, l1, l2, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[1], 12L, 3905402710L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[3], 22L, 3250441966L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[5], 12L, 1200080426L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[7], 22L, 4249261313L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[9], 12L, 2336552879L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[11], 22L, 2304563134L);
    l4 = a(l4, l1, l2, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l4, l1, l2, arrayOfLong[13], 12L, 4254626195L);
    l2 = a(l2, l3, l4, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l2, l3, l4, arrayOfLong[15], 22L, 1236535329L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[6], 9L, 3225465664L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[0], 20L, 3921069994L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[10], 9L, 38016083L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[4], 20L, 3889429448L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[14], 9L, 3275163606L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[8], 20L, 1163531501L);
    l4 = b(l4, l1, l2, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l4, l1, l2, arrayOfLong[2], 9L, 4243563512L);
    l2 = b(l2, l3, l4, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l2, l3, l4, arrayOfLong[12], 20L, 2368359562L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[8], 11L, 2272392833L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[14], 23L, 4259657740L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[4], 11L, 1272893353L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[10], 23L, 3200236656L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[0], 11L, 3936430074L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[6], 23L, 76029189L);
    l4 = c(l4, l1, l2, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l4, l1, l2, arrayOfLong[12], 11L, 3873151461L);
    l2 = c(l2, l3, l4, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l2, l3, l4, arrayOfLong[2], 23L, 3299628645L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[7], 10L, 1126891415L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[5], 21L, 4237533241L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[3], 10L, 2399980690L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[1], 21L, 2240044497L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[15], 10L, 4264355552L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[13], 21L, 1309151649L);
    l4 = d(l4, l1, l2, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l4, l1, l2, arrayOfLong[11], 10L, 3174756917L);
    l2 = d(l2, l3, l4, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l2, l3, l4, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l4;
    paramArrayOfByte[1] += l1;
    paramArrayOfByte[2] += l2;
    paramArrayOfByte[3] += l3;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    Object localObject = this.c;
    int k = 0;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramInt << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramInt >>> 29);
    int m = 64 - j;
    int i;
    if (paramInt >= m)
    {
      localObject = this.d;
      i = 0;
      while (i < m)
      {
        localObject[(j + i)] = paramArrayOfByte[(i + 0)];
        i += 1;
      }
      a(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        j = 0;
        while (j < 64)
        {
          arrayOfByte[(j + 0)] = paramArrayOfByte[(i + j)];
          j += 1;
        }
        a(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    else
    {
      i = 0;
    }
    arrayOfByte = this.d;
    while (k < paramInt - i)
    {
      arrayOfByte[(j + k)] = paramArrayOfByte[(i + k)];
      k += 1;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(0xFF & paramArrayOfLong[j] >>> 24));
      j += 1;
      i += 4;
    }
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte1 = new byte[64];
    Object localObject = this.c;
    int k = 0;
    int j = (int)(localObject[0] >>> 3) & 0x3F;
    long l2 = localObject[0];
    long l1 = paramLong << 3;
    l2 += l1;
    localObject[0] = l2;
    if (l2 < l1) {
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramLong >>> 29);
    int m = 64 - j;
    int i;
    if (paramLong >= m)
    {
      localObject = new byte[m];
      try
      {
        paramInputStream.read((byte[])localObject, 0, m);
        byte[] arrayOfByte2 = this.d;
        i = 0;
        while (i < m)
        {
          arrayOfByte2[(j + i)] = localObject[(i + 0)];
          i += 1;
        }
        a(this.d);
        i = m;
        while (i + 63 < paramLong) {
          try
          {
            paramInputStream.read(arrayOfByte1);
            a(arrayOfByte1);
            i += 64;
          }
          catch (Exception paramInputStream)
          {
            paramInputStream.printStackTrace();
            return false;
          }
        }
        m = 0;
        j = i;
        i = m;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
        return false;
      }
    }
    else
    {
      m = 0;
      i = j;
      j = m;
    }
    arrayOfByte1 = new byte[(int)(paramLong - j)];
    try
    {
      paramInputStream.read(arrayOfByte1);
      paramInputStream = this.d;
      m = arrayOfByte1.length;
      j = k;
      while (j < m)
      {
        paramInputStream[(i + j)] = arrayOfByte1[(j + 0)];
        j += 1;
      }
      return true;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return false;
  }
  
  private static long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)((paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1);
    int j = (int)paramLong6;
    return (i >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 ^ paramLong2 ^ paramLong4) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
  
  private static long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    int i = (int)(paramLong1 + ((paramLong3 ^ (paramLong4 ^ 0xFFFFFFFF | paramLong2)) + paramLong5 + paramLong7));
    return (i << (int)paramLong6 | i >>> (int)(32L - paramLong6)) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ls
 * JD-Core Version:    0.7.0.1
 */