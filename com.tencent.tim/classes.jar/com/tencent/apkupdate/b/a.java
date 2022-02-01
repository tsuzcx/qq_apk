package com.tencent.apkupdate.b;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class a
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
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
    this.b = a(this.b, 0);
    if (this.b == null) {
      return false;
    }
    this.j += 8;
    this.d += 8;
    this.f = 0;
    return true;
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
        l3 = b(paramArrayOfByte, 0, 4);
        l2 = b(paramArrayOfByte, 4, 4);
        l4 = b(this.h, 0, 4);
        l5 = b(this.h, 4, 4);
        l6 = b(this.h, 8, 4);
        l7 = b(this.h, 12, 4);
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
        l1 = l1 + 2654435769L & 0xFFFFFFFF;
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
        l3 = b(paramArrayOfByte, paramInt, 4);
        l2 = b(paramArrayOfByte, paramInt + 4, 4);
        l4 = b(this.h, 0, 4);
        l5 = b(this.h, 4, 4);
        l6 = b(this.h, 8, 4);
        l7 = b(this.h, 12, 4);
        l1 = 3816266640L;
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
        l1 = l1 - 2654435769L & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private static long b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt1 + 4)
    {
      l = l << 8 | paramArrayOfByte[paramInt2] & 0xFF;
      paramInt2 += 1;
    }
    return l >>> 32 | 0xFFFFFFFF & l;
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16)) {
      return null;
    }
    this.b = a(paramArrayOfByte1, 0);
    this.f = (this.b[0] & 0x7);
    int m = paramInt2 - this.f - 10;
    if (m < 0) {
      return null;
    }
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfByte2.length)
    {
      paramArrayOfByte2[paramInt1] = 0;
      paramInt1 += 1;
    }
    this.c = new byte[m];
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
        if (!a(paramArrayOfByte1, 0, paramInt2)) {
          return null;
        }
      }
      else
      {
        paramInt1 = m;
        int n = 0;
        for (;;)
        {
          int i1;
          if (paramInt1 != 0)
          {
            i1 = n;
            m = paramInt1;
            if (this.f < 8)
            {
              this.c[n] = ((byte)(paramArrayOfByte2[(this.e + 0 + this.f)] ^ this.b[this.f]));
              i1 = n + 1;
              m = paramInt1 - 1;
              this.f += 1;
            }
            n = i1;
            paramInt1 = m;
            if (this.f != 8) {
              continue;
            }
            this.e = (this.d - 8);
            if (!a(paramArrayOfByte1, 0, paramInt2)) {
              return null;
            }
          }
          else
          {
            for (this.g = 1; this.g < 8; this.g += 1)
            {
              if (this.f < 8)
              {
                if ((paramArrayOfByte2[(this.e + 0 + this.f)] ^ this.b[this.f]) != 0) {
                  return null;
                }
                this.f += 1;
              }
              if (this.f == 8)
              {
                this.e = this.d;
                if (!a(paramArrayOfByte1, 0, paramInt2)) {
                  return null;
                }
                paramArrayOfByte2 = paramArrayOfByte1;
              }
            }
            return this.c;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          n = i1;
          paramInt1 = m;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  public final byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
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
    this.a[0] = ((byte)(this.k.nextInt() & 0xF8 | this.f));
    paramInt1 = 1;
    while (paramInt1 <= this.f)
    {
      this.a[paramInt1] = ((byte)this.k.nextInt());
      paramInt1 += 1;
    }
    this.f += 1;
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      this.b[paramInt1] = 0;
      paramInt1 += 1;
    }
    this.g = 1;
    while (this.g <= 2)
    {
      if (this.f < 8)
      {
        paramArrayOfByte2 = this.a;
        paramInt1 = this.f;
        this.f = (paramInt1 + 1);
        paramArrayOfByte2[paramInt1] = ((byte)this.k.nextInt());
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    paramInt1 = 0;
    if (paramInt2 > 0)
    {
      if (this.f >= 8) {
        break label404;
      }
      paramArrayOfByte2 = this.a;
      int n = this.f;
      this.f = (n + 1);
      int m = paramInt1 + 1;
      paramArrayOfByte2[n] = paramArrayOfByte1[paramInt1];
      paramInt2 -= 1;
      paramInt1 = m;
    }
    label404:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.b.a
 * JD-Core Version:    0.7.0.1
 */