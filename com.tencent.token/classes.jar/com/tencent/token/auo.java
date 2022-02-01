package com.tencent.token;

import android.text.TextUtils;
import btmsdkobf.bc;
import btmsdkobf.eg;
import com.tmsdk.base.AbsTMSBaseConfig;
import tmsdk.common.tcc.TccCryptor;

public final class auo
{
  private static volatile boolean a = false;
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    try
    {
      String str = bc.o().getTccSoName();
      localStringBuilder = new StringBuilder("loadLibraryIfNot libraryName:[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      eg.e("TccUtil", localStringBuilder.toString());
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.loadLibrary(str);
      a = true;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder("loadLibraryIfNot e:[");
      localStringBuilder.append(localThrowable.getMessage());
      localStringBuilder.append("]");
      eg.h("TccUtil", localStringBuilder.toString());
      localThrowable.printStackTrace();
      a = false;
    }
    return a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (bc.o().isJavaTCC())
    {
      byte[] arrayOfByte = paramArrayOfByte2;
      if (paramArrayOfByte2 == null) {
        arrayOfByte = aun.a();
      }
      arrayOfByte = aun.a(arrayOfByte);
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
          aun.a(paramArrayOfByte1, arrayOfInt);
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
          aun.a(arrayOfByte, paramArrayOfByte1);
          int i1 = arrayOfInt.length - 1;
          i = arrayOfInt[i1];
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
          aun.a(arrayOfInt, arrayOfInt.length, paramArrayOfByte2);
        }
      }
      return paramArrayOfByte2;
    }
    return TccCryptor.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static boolean b()
  {
    if (bc.o().isJavaTCC()) {
      return true;
    }
    return TccCryptor.getProcBitStatus() == 109;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (bc.o().isJavaTCC())
    {
      byte[] arrayOfByte = paramArrayOfByte2;
      if (paramArrayOfByte2 == null) {
        arrayOfByte = aun.a();
      }
      arrayOfByte = aun.a(arrayOfByte);
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
          aun.a(paramArrayOfByte1, paramArrayOfByte2);
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
          aun.a(arrayOfByte, paramArrayOfByte1);
          int m = paramArrayOfByte2.length - 1;
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
          i = paramArrayOfByte2[m];
          if (i >= 0)
          {
            if (i > paramArrayOfByte2.length - 1 << 2) {
              return null;
            }
            paramArrayOfByte1 = new byte[i];
            aun.a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
            return paramArrayOfByte1;
          }
        }
        return null;
      }
      return paramArrayOfByte1;
    }
    return TccCryptor.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.auo
 * JD-Core Version:    0.7.0.1
 */