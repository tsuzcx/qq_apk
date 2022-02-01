package oicq.wlogin_sdk.pow;

import java.nio.ByteBuffer;

public class a
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int[] f;
  public int g;
  public byte[] h;
  public int i;
  public byte[] j;
  public int k;
  public byte[] l;
  public int m;
  public byte[] n;
  public int o;
  public int p;
  
  public int a(byte paramByte1, byte paramByte2)
  {
    return ByteBuffer.wrap(new byte[] { paramByte1, paramByte2 }).getShort();
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte[0];
    this.b = paramArrayOfByte[1];
    this.c = paramArrayOfByte[2];
    this.d = paramArrayOfByte[3];
    this.e = a(paramArrayOfByte[4], paramArrayOfByte[5]);
    this.f = new int[2];
    int i2 = 0;
    int i1 = 6;
    while (i2 < 2)
    {
      this.f[i2] = paramArrayOfByte[i1];
      i2 += 1;
      i1 += 1;
    }
    byte b1 = paramArrayOfByte[8];
    i1 = i1 + 1 + 1;
    this.g = a(b1, paramArrayOfByte[9]);
    int i3 = this.g;
    i2 = i1;
    if (i3 > 0)
    {
      this.h = new byte[i3];
      i3 = 0;
      for (;;)
      {
        i2 = i1;
        if (i3 >= this.g) {
          break;
        }
        this.h[i3] = paramArrayOfByte[i1];
        i3 += 1;
        i1 += 1;
      }
    }
    i3 = i2 + 1;
    b1 = paramArrayOfByte[i2];
    i1 = i3 + 1;
    this.i = a(b1, paramArrayOfByte[i3]);
    i3 = this.i;
    i2 = i1;
    if (i3 > 0)
    {
      this.j = new byte[i3];
      i3 = 0;
      for (;;)
      {
        i2 = i1;
        if (i3 >= this.i) {
          break;
        }
        this.j[i3] = paramArrayOfByte[i1];
        i3 += 1;
        i1 += 1;
      }
    }
    i3 = i2 + 1;
    b1 = paramArrayOfByte[i2];
    i1 = i3 + 1;
    this.k = a(b1, paramArrayOfByte[i3]);
    i3 = this.k;
    i2 = i1;
    if (i3 > 0)
    {
      this.l = new byte[i3];
      i3 = 0;
      for (;;)
      {
        i2 = i1;
        if (i3 >= this.k) {
          break;
        }
        this.l[i3] = paramArrayOfByte[i1];
        i3 += 1;
        i1 += 1;
      }
    }
    if (this.d == 1)
    {
      i3 = i2 + 1;
      b1 = paramArrayOfByte[i2];
      i1 = i3 + 1;
      this.m = a(b1, paramArrayOfByte[i3]);
      i3 = this.m;
      i2 = i1;
      if (i3 > 0)
      {
        this.n = new byte[i3];
        i3 = 0;
        for (;;)
        {
          i2 = i1;
          if (i3 >= this.m) {
            break;
          }
          this.n[i3] = paramArrayOfByte[i1];
          i3 += 1;
          i1 += 1;
        }
      }
      this.o = a(paramArrayOfByte, i2);
      this.p = a(paramArrayOfByte, i2 + 4);
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(new byte[] { paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)], paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)] }).getInt();
  }
  
  public byte[] a()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4096);
    localByteBuffer.put((byte)this.a);
    localByteBuffer.put((byte)this.b);
    localByteBuffer.put((byte)this.c);
    localByteBuffer.put((byte)this.d);
    localByteBuffer.putShort((short)this.e);
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = this.f;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      localByteBuffer.put((byte)arrayOfInt[i1]);
      i1 += 1;
    }
    localByteBuffer.putShort((short)this.g);
    if (this.g > 0) {
      localByteBuffer.put(this.h);
    }
    localByteBuffer.putShort((short)this.i);
    if (this.i > 0) {
      localByteBuffer.put(this.j);
    }
    localByteBuffer.putShort((short)this.k);
    if (this.k > 0) {
      localByteBuffer.put(this.l);
    }
    if (this.d == 1)
    {
      localByteBuffer.putShort((short)this.m);
      localByteBuffer.put(this.n);
      localByteBuffer.putInt(this.o);
      localByteBuffer.putInt(this.p);
    }
    return localByteBuffer.array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.pow.a
 * JD-Core Version:    0.7.0.1
 */