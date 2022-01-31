package com.tencent.lbsapi.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class a
{
  public static final int a = 79764919;
  public static final int b = 2;
  public static final int c = 7;
  private byte[] d;
  private byte[] e;
  private byte[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private byte[] k;
  private boolean l = true;
  private int m;
  private Random n = new Random();
  
  public static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    }
    while (paramInt1 < paramInt2)
    {
      l1 = l1 << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
      continue;
      paramInt2 = paramInt1 + paramInt2;
    }
    return l1 >>> 32 | 0xFFFFFFFF & l1;
  }
  
  private void a()
  {
    this.i = 0;
    byte[] arrayOfByte;
    int i1;
    if (this.i < 8)
    {
      if (this.l)
      {
        arrayOfByte = this.d;
        i1 = this.i;
        arrayOfByte[i1] = ((byte)(arrayOfByte[i1] ^ this.e[this.i]));
      }
      for (;;)
      {
        this.i += 1;
        break;
        arrayOfByte = this.d;
        i1 = this.i;
        arrayOfByte[i1] = ((byte)(arrayOfByte[i1] ^ this.f[(this.h + this.i)]));
      }
    }
    System.arraycopy(a(this.d), 0, this.f, this.g, 8);
    for (this.i = 0; this.i < 8; this.i += 1)
    {
      arrayOfByte = this.f;
      i1 = this.g + this.i;
      arrayOfByte[i1] = ((byte)(arrayOfByte[i1] ^ this.e[this.i]));
    }
    System.arraycopy(this.d, 0, this.e, 0, 8);
    this.h = this.g;
    this.g += 8;
    this.i = 0;
    this.l = false;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int i1 = 16;
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
        l4 = a(this.k, 0, 4);
        l5 = a(this.k, 4, 4);
        l6 = a(this.k, 8, 4);
        l7 = a(this.k, 12, 4);
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
      while (i1 > 0)
      {
        l1 = l1 + (0x9E3779B9 & 0xFFFFFFFF) & 0xFFFFFFFF;
        l3 = l3 + ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        i1 -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 16;
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
        l4 = a(this.k, 0, 4);
        l5 = a(this.k, 4, 4);
        l6 = a(this.k, 8, 4);
        l7 = a(this.k, 12, 4);
        l1 = 0xE3779B90 & 0xFFFFFFFF;
        paramInt = i1;
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
  
  private int b()
  {
    return this.n.nextInt();
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (this.i = 0; this.i < 8; this.i += 1)
    {
      if (this.m + this.i >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.e;
      int i1 = this.i;
      arrayOfByte[i1] = ((byte)(arrayOfByte[i1] ^ paramArrayOfByte[(this.g + paramInt1 + this.i)]));
    }
    this.e = b(this.e);
    if (this.e == null) {
      return false;
    }
    this.m += 8;
    this.g += 8;
    this.i = 0;
    return true;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }
  
  public byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.h = 0;
    this.g = 0;
    this.k = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16)) {
      return null;
    }
    this.e = a(paramArrayOfByte1, paramInt1);
    this.i = (this.e[0] & 0x7);
    int i2 = paramInt2 - this.i - 10;
    if (i2 < 0) {
      return null;
    }
    int i1 = paramInt1;
    while (i1 < paramArrayOfByte2.length)
    {
      paramArrayOfByte2[i1] = 0;
      i1 += 1;
    }
    this.f = new byte[i2];
    this.h = 0;
    this.g = 8;
    this.m = 8;
    this.i += 1;
    this.j = 1;
    for (;;)
    {
      if (this.j <= 2)
      {
        if (this.i < 8)
        {
          this.i += 1;
          this.j += 1;
        }
        if (this.i != 8) {
          continue;
        }
        if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
          return null;
        }
      }
      else
      {
        i1 = i2;
        int i3 = 0;
        for (;;)
        {
          int i4;
          if (i1 != 0)
          {
            i4 = i3;
            i2 = i1;
            if (this.i < 8)
            {
              this.f[i3] = ((byte)(paramArrayOfByte2[(this.h + paramInt1 + this.i)] ^ this.e[this.i]));
              i4 = i3 + 1;
              i2 = i1 - 1;
              this.i += 1;
            }
            i3 = i4;
            i1 = i2;
            if (this.i != 8) {
              continue;
            }
            this.h = (this.g - 8);
            if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
              return null;
            }
          }
          else
          {
            for (this.j = 1; this.j < 8; this.j += 1)
            {
              if (this.i < 8)
              {
                if ((paramArrayOfByte2[(this.h + paramInt1 + this.i)] ^ this.e[this.i]) != 0) {
                  return null;
                }
                this.i += 1;
              }
              if (this.i == 8)
              {
                this.h = this.g;
                if (!b(paramArrayOfByte1, paramInt1, paramInt2)) {
                  return null;
                }
                paramArrayOfByte2 = paramArrayOfByte1;
              }
            }
            return this.f;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          i3 = i4;
          i1 = i2;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
  
  public byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.d = new byte[8];
    this.e = new byte[8];
    this.i = 1;
    this.j = 0;
    this.h = 0;
    this.g = 0;
    this.k = paramArrayOfByte2;
    this.l = true;
    this.i = ((paramInt2 + 10) % 8);
    if (this.i != 0) {
      this.i = (8 - this.i);
    }
    this.f = new byte[this.i + paramInt2 + 10];
    this.d[0] = ((byte)(b() & 0xF8 | this.i));
    int i1 = 1;
    while (i1 <= this.i)
    {
      this.d[i1] = ((byte)(b() & 0xFF));
      i1 += 1;
    }
    this.i += 1;
    i1 = 0;
    while (i1 < 8)
    {
      this.e[i1] = 0;
      i1 += 1;
    }
    this.j = 1;
    while (this.j <= 2)
    {
      if (this.i < 8)
      {
        paramArrayOfByte2 = this.d;
        i1 = this.i;
        this.i = (i1 + 1);
        paramArrayOfByte2[i1] = ((byte)(b() & 0xFF));
        this.j += 1;
      }
      if (this.i == 8) {
        a();
      }
    }
    if (paramInt2 > 0)
    {
      if (this.i >= 8) {
        break label414;
      }
      paramArrayOfByte2 = this.d;
      int i2 = this.i;
      this.i = (i2 + 1);
      i1 = paramInt1 + 1;
      paramArrayOfByte2[i2] = paramArrayOfByte1[paramInt1];
      paramInt2 -= 1;
      paramInt1 = i1;
    }
    label414:
    for (;;)
    {
      if (this.i == 8)
      {
        a();
        break;
        this.j = 1;
        while (this.j <= 7)
        {
          if (this.i < 8)
          {
            paramArrayOfByte1 = this.d;
            paramInt1 = this.i;
            this.i = (paramInt1 + 1);
            paramArrayOfByte1[paramInt1] = 0;
            this.j += 1;
          }
          if (this.i == 8) {
            a();
          }
        }
        return this.f;
      }
      break;
    }
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.lbsapi.a.a
 * JD-Core Version:    0.7.0.1
 */