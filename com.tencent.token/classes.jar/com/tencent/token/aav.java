package com.tencent.token;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class aav
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
    return 0xFFFFFFFF & l | l >>> 32;
  }
  
  private void a()
  {
    byte[] arrayOfByte;
    for (this.f = 0;; this.f += 1)
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.i)
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.b[m]));
      }
      else
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.c[(this.e + m)]));
      }
    }
    System.arraycopy(a(this.a), 0, this.c, this.d, 8);
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      arrayOfByte = this.c;
      int n = this.d + m;
      arrayOfByte[n] = ((byte)(arrayOfByte[n] ^ this.b[m]));
    }
    System.arraycopy(this.a, 0, this.b, 0, 8);
    int m = this.d;
    this.e = m;
    this.d = (m + 8);
    this.f = 0;
    this.i = false;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int m = 16;
    for (;;)
    {
      long l1;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l1 = a(paramArrayOfByte, 0);
        l2 = a(paramArrayOfByte, 4);
        l4 = a(this.h, 0);
        l5 = a(this.h, 4);
        l6 = a(this.h, 8);
        l7 = a(this.h, 12);
        l3 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return null;
      while (m > 0)
      {
        l3 = l3 + 2654435769L & 0xFFFFFFFF;
        l1 = l1 + ((l2 << 4) + l4 ^ l2 + l3 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l1 << 4) + l6 ^ l1 + l3 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
        m -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if (paramInt % 8 == 0)
    {
      if (paramInt < 16) {
        return null;
      }
      this.b = b(paramArrayOfByte1);
      this.f = (this.b[0] & 0x7);
      int n = paramInt - this.f - 10;
      if (n < 0) {
        return null;
      }
      int m = 0;
      while (m < 8)
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
        m = this.g;
        if (m > 2) {
          break;
        }
        i1 = this.f;
        if (i1 < 8)
        {
          this.f = (i1 + 1);
          this.g = (m + 1);
        }
        if (this.f == 8)
        {
          if (!b(paramArrayOfByte1, paramInt)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      int i1 = 0;
      m = n;
      while (m != 0)
      {
        int i3 = this.f;
        int i2 = i1;
        n = m;
        if (i3 < 8)
        {
          this.c[i1] = ((byte)(paramArrayOfByte2[(this.e + 0 + i3)] ^ this.b[i3]));
          i2 = i1 + 1;
          n = m - 1;
          this.f = (i3 + 1);
        }
        i1 = i2;
        m = n;
        if (this.f == 8)
        {
          this.e = (this.d - 8);
          if (!b(paramArrayOfByte1, paramInt)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          i1 = i2;
          m = n;
        }
      }
      for (this.g = 1; this.g < 8; this.g += 1)
      {
        m = this.f;
        if (m < 8)
        {
          if ((paramArrayOfByte2[(this.e + 0 + m)] ^ this.b[m]) != 0) {
            return null;
          }
          this.f = (m + 1);
        }
        if (this.f == 8)
        {
          this.e = this.d;
          if (!b(paramArrayOfByte1, paramInt)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      return this.c;
    }
    return null;
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    int m;
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.j + m >= paramInt) {
        return true;
      }
      byte[] arrayOfByte = this.b;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ paramArrayOfByte[(this.d + 0 + m)]));
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
      long l1;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l1 = a(paramArrayOfByte, 0);
        l2 = a(paramArrayOfByte, 4);
        l4 = a(this.h, 0);
        l5 = a(this.h, 4);
        l6 = a(this.h, 8);
        l7 = a(this.h, 12);
        l3 = 3816266640L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return null;
      while (m > 0)
      {
        l2 = l2 - ((l1 << 4) + l6 ^ l1 + l3 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
        l1 = l1 - ((l2 << 4) + l4 ^ l2 + l3 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l3 = l3 - 2654435769L & 0xFFFFFFFF;
        m -= 1;
      }
    }
  }
  
  private byte[] b(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((paramInt + 10) % 8);
    int m = this.f;
    if (m != 0) {
      this.f = (8 - m);
    }
    this.c = new byte[this.f + paramInt + 10];
    this.a[0] = ((byte)(this.k.nextInt() & 0xF8 | this.f));
    m = 1;
    for (;;)
    {
      n = this.f;
      if (m > n) {
        break;
      }
      this.a[m] = ((byte)(this.k.nextInt() & 0xFF));
      m += 1;
    }
    this.f = (n + 1);
    m = 0;
    while (m < 8)
    {
      this.b[m] = 0;
      m += 1;
    }
    this.g = 1;
    while (this.g <= 2)
    {
      m = this.f;
      if (m < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (m + 1);
        paramArrayOfByte2[m] = ((byte)(this.k.nextInt() & 0xFF));
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    m = 0;
    int n = paramInt;
    while (n > 0)
    {
      int i2 = this.f;
      int i1 = n;
      paramInt = m;
      if (i2 < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (i2 + 1);
        paramArrayOfByte2[i2] = paramArrayOfByte1[m];
        i1 = n - 1;
        paramInt = m + 1;
      }
      n = i1;
      m = paramInt;
      if (this.f == 8)
      {
        a();
        n = i1;
        m = paramInt;
      }
    }
    this.g = 1;
    for (;;)
    {
      paramInt = this.g;
      if (paramInt > 7) {
        break;
      }
      m = this.f;
      if (m < 8)
      {
        paramArrayOfByte1 = this.a;
        this.f = (m + 1);
        paramArrayOfByte1[m] = 0;
        this.g = (paramInt + 1);
      }
      if (this.f == 8) {
        a();
      }
    }
    return this.c;
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return null;
    }
    return a(paramArrayOfByte1, paramArrayOfByte1.length, paramArrayOfByte2);
  }
  
  public final byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return null;
    }
    return b(paramArrayOfByte1, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aav
 * JD-Core Version:    0.7.0.1
 */