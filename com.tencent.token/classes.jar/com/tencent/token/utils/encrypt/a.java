package com.tencent.token.utils.encrypt;

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
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int m = paramInt;
    while (m < paramInt + 4)
    {
      l = l << 8 | paramArrayOfByte[m] & 0xFF;
      m += 1;
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
        l3 = a(paramArrayOfByte, 0);
        l2 = a(paramArrayOfByte, 4);
        l4 = a(this.h, 0);
        l5 = a(this.h, 4);
        l6 = a(this.h, 8);
        l7 = a(this.h, 12);
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
  
  private boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    for (this.f = 0; this.f < 8; this.f += 1)
    {
      if (this.j + this.f >= paramInt) {
        return true;
      }
      byte[] arrayOfByte = this.b;
      int m = this.f;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ paramArrayOfByte[(this.d + 0 + this.f)]));
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
        l3 = a(paramArrayOfByte, 0);
        l2 = a(paramArrayOfByte, 4);
        l4 = a(this.h, 0);
        l5 = a(this.h, 4);
        l6 = a(this.h, 8);
        l7 = a(this.h, 12);
        l1 = 3816266640L;
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
        l2 = l2 - ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        l3 = l3 - ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - 2654435769L & 0xFFFFFFFF;
        m -= 1;
      }
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return null;
    }
    int i3 = paramArrayOfByte1.length;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if ((i3 % 8 != 0) || (i3 < 16)) {
      return null;
    }
    this.b = b(paramArrayOfByte1);
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
        if (!b(paramArrayOfByte1, i3)) {
          return null;
        }
      }
      else
      {
        int i1 = 0;
        m = n;
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
            if (!b(paramArrayOfByte1, i3)) {
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
                if (!b(paramArrayOfByte1, i3)) {
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
    if (paramArrayOfByte2 == null) {
      return null;
    }
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
      this.a[m] = ((byte)(this.k.nextInt() & 0xFF));
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
        paramArrayOfByte2[m] = ((byte)(this.k.nextInt() & 0xFF));
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
        break label422;
      }
      paramArrayOfByte2 = this.a;
      int i2 = this.f;
      this.f = (i2 + 1);
      int i1 = m + 1;
      paramArrayOfByte2[i2] = paramArrayOfByte1[m];
      n -= 1;
      m = i1;
    }
    label422:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.a
 * JD-Core Version:    0.7.0.1
 */