package com.tencent.qphone.base.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

class b
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  private int d;
  private int e;
  private int f;
  private int g;
  private byte[] h;
  private boolean i = true;
  private int j;
  private Random k = new Random();
  
  private static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    }
    while (paramInt1 < paramInt2)
    {
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
      continue;
      paramInt2 = paramInt1 + paramInt2;
    }
    return l >>> 32 | 0xFFFFFFFF & l;
  }
  
  private void a()
  {
    this.f = 0;
    byte[] arrayOfByte;
    int m;
    if (this.f < 8)
    {
      if (this.i)
      {
        arrayOfByte = this.a;
        m = this.f;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.b[this.f]));
      }
      for (;;)
      {
        this.f += 1;
        break;
        arrayOfByte = this.a;
        m = this.f;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.c[(this.e + this.f)]));
      }
    }
    System.arraycopy(a(this.a), 0, this.c, this.d, 8);
    for (this.f = 0; this.f < 8; this.f += 1)
    {
      arrayOfByte = this.c;
      m = this.d + this.f;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.b[this.f]));
    }
    System.arraycopy(this.a, 0, this.b, 0, 8);
    this.e = this.d;
    this.d += 8;
    this.f = 0;
    this.i = false;
  }
  
  private byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.k.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int m = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = a(paramArrayOfByte, 0, 4);
        l2 = a(paramArrayOfByte, 4, 4);
        l4 = a(this.h, 0, 4);
        l5 = a(this.h, 4, 4);
        l6 = a(this.h, 8, 4);
        l7 = a(this.h, 12, 4);
        l1 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      while (m > 0)
      {
        l1 = l1 + (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        l3 = l3 + ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        m -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = a(paramArrayOfByte, paramInt, 4);
        l2 = a(paramArrayOfByte, paramInt + 4, 4);
        l4 = a(this.h, 0, 4);
        l5 = a(this.h, 4, 4);
        l6 = a(this.h, 8, 4);
        l7 = a(this.h, 12, 4);
        l1 = 0xE3779B90 & 0xFFFFFFFF;
        paramInt = m;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      while (paramInt > 0)
      {
        l2 = l2 - ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        l3 = l3 - ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    paramArrayOfByte2 = a(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = a(paramInt);
    }
    return paramArrayOfByte1;
  }
  
  private int b()
  {
    return this.k.nextInt();
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (this.f = 0; this.f < 8; this.f += 1)
    {
      if (this.j + this.f >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.b;
      int m = this.f;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ paramArrayOfByte[(this.d + paramInt1 + this.f)]));
    }
    this.b = b(this.b);
    if (this.b == null) {
      return false;
    }
    this.j += 8;
    this.d += 8;
    this.f = 0;
    return true;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  private byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((paramInt2 + 10) % 8);
    if (this.f != 0) {
      this.f = (8 - this.f);
    }
    this.c = new byte[this.f + paramInt2 + 10];
    this.a[0] = ((byte)(b() & 0xF8 | this.f));
    int m = 1;
    while (m <= this.f)
    {
      this.a[m] = ((byte)(b() & 0xFF));
      m += 1;
    }
    this.f += 1;
    m = 0;
    while (m < 8)
    {
      this.b[m] = 0;
      m += 1;
    }
    this.g = 1;
    while (this.g <= 2)
    {
      if (this.f < 8)
      {
        paramArrayOfByte2 = this.a;
        m = this.f;
        this.f = (m + 1);
        paramArrayOfByte2[m] = ((byte)(b() & 0xFF));
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    if (paramInt2 > 0)
    {
      if (this.f >= 8) {
        break label414;
      }
      paramArrayOfByte2 = this.a;
      int n = this.f;
      this.f = (n + 1);
      m = paramInt1 + 1;
      paramArrayOfByte2[n] = paramArrayOfByte1[paramInt1];
      paramInt2 -= 1;
      paramInt1 = m;
    }
    label414:
    for (;;)
    {
      if (this.f == 8)
      {
        a();
        break;
        this.g = 1;
        while (this.g <= 7)
        {
          if (this.f < 8)
          {
            paramArrayOfByte1 = this.a;
            paramInt1 = this.f;
            this.f = (paramInt1 + 1);
            paramArrayOfByte1[paramInt1] = 0;
            this.g += 1;
          }
          if (this.f == 8) {
            a();
          }
        }
        return this.c;
      }
      break;
    }
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16)) {
      return null;
    }
    this.b = a(paramArrayOfByte1, paramInt1);
    this.f = (this.b[0] & 0x7);
    int n = paramInt2 - this.f - 10;
    if (n < 0) {
      return null;
    }
    int m = paramInt1;
    while (m < paramArrayOfByte2.length)
    {
      paramArrayOfByte2[m] = 0;
      m += 1;
    }
    this.c = new byte[n];
    this.e = 0;
    this.d = 8;
    this.j = 8;
    this.f += 1;
    this.g = 1;
    for (;;)
    {
      if (this.g <= 2)
      {
        if (this.f < 8)
        {
          this.f += 1;
          this.g += 1;
        }
        if (this.f != 8) {
          continue;
        }
        if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
          return null;
        }
      }
      else
      {
        m = n;
        int i1 = 0;
        for (;;)
        {
          int i2;
          if (m != 0)
          {
            i2 = i1;
            n = m;
            if (this.f < 8)
            {
              this.c[i1] = ((byte)(paramArrayOfByte2[(this.e + paramInt1 + this.f)] ^ this.b[this.f]));
              i2 = i1 + 1;
              n = m - 1;
              this.f += 1;
            }
            i1 = i2;
            m = n;
            if (this.f != 8) {
              continue;
            }
            this.e = (this.d - 8);
            if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
              return null;
            }
          }
          else
          {
            for (this.g = 1; this.g < 8; this.g += 1)
            {
              if (this.f < 8)
              {
                if ((paramArrayOfByte2[(this.e + paramInt1 + this.f)] ^ this.b[this.f]) != 0) {
                  return null;
                }
                this.f += 1;
              }
              if (this.f == 8)
              {
                this.e = this.d;
                if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
                  return null;
                }
                paramArrayOfByte2 = paramArrayOfByte1;
              }
            }
            return this.c;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          i1 = i2;
          m = n;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
  
  protected byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.b
 * JD-Core Version:    0.7.0.1
 */