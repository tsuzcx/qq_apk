package com.tencent.tmassistantsdk.f;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class e
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
  
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i3 = paramArrayOfByte1.length;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if ((i3 % 8 != 0) || (i3 < 16)) {
      return null;
    }
    this.b = a(paramArrayOfByte1, 0);
    this.f = (this.b[0] & 0x7);
    int n = i3 - this.f - 10;
    if (n < 0) {
      return null;
    }
    int m = 0;
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
        if (!a(paramArrayOfByte1, 0, i3)) {
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
              this.c[i1] = ((byte)(paramArrayOfByte2[(this.e + 0 + this.f)] ^ this.b[this.f]));
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
            if (!a(paramArrayOfByte1, 0, i3)) {
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
                if (!a(paramArrayOfByte1, 0, i3)) {
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
  
  public final byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int n = paramArrayOfByte1.length;
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((n + 10) % 8);
    if (this.f != 0) {
      this.f = (8 - this.f);
    }
    this.c = new byte[this.f + n + 10];
    this.a[0] = ((byte)(this.k.nextInt() & 0xF8 | this.f));
    int m = 1;
    while (m <= this.f)
    {
      this.a[m] = ((byte)this.k.nextInt());
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
        paramArrayOfByte2[m] = ((byte)this.k.nextInt());
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    m = 0;
    if (n > 0)
    {
      if (this.f >= 8) {
        break label408;
      }
      paramArrayOfByte2 = this.a;
      int i2 = this.f;
      this.f = (i2 + 1);
      int i1 = m + 1;
      paramArrayOfByte2[i2] = paramArrayOfByte1[m];
      n -= 1;
      m = i1;
    }
    label408:
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
            m = this.f;
            this.f = (m + 1);
            paramArrayOfByte1[m] = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.e
 * JD-Core Version:    0.7.0.1
 */