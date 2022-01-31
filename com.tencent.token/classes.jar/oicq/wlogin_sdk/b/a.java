package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class a
{
  int a = 128;
  int b = 0;
  int c = 0;
  int d = 4;
  int e = 0;
  byte[] f = new byte[this.a];
  int g = 0;
  
  public a() {}
  
  public a(int paramInt)
  {
    this.g = paramInt;
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramArrayOfByte.length;
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (paramInt1 + 2 > paramInt2)) {}
      do
      {
        return -1;
        if (util.buf_to_int16(paramArrayOfByte, paramInt1) == paramInt3) {
          return paramInt1;
        }
        paramInt1 += 2;
      } while (paramInt1 + 2 > paramInt2);
      paramInt1 += util.buf_to_int16(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = a(paramArrayOfByte1, paramInt1, paramInt2, this.g);
    if (i < 0) {
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
    return a(arrayOfByte, paramInt1, paramArrayOfByte2);
  }
  
  int a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if (this.d >= paramInt) {}
    do
    {
      return -1;
      this.e = util.buf_to_int16(paramArrayOfByte1, 2);
    } while (this.d + this.e > paramInt);
    paramArrayOfByte2 = cryptor.decrypt(paramArrayOfByte1, this.d, this.e, paramArrayOfByte2);
    if (paramArrayOfByte2 == null) {
      return -1015;
    }
    if (this.d + paramArrayOfByte2.length > this.a)
    {
      this.a = (this.d + paramArrayOfByte2.length);
      this.f = new byte[this.a];
    }
    this.b = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.f, 0, this.d);
    this.b += this.d;
    System.arraycopy(paramArrayOfByte2, 0, this.f, this.b, paramArrayOfByte2.length);
    this.b += paramArrayOfByte2.length;
    this.e = paramArrayOfByte2.length;
    if (!e().booleanValue()) {
      return -1005;
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    util.int16_to_buf(this.f, this.b, paramInt);
    this.b += 2;
    util.int16_to_buf(this.f, this.b, 0);
    this.b += 2;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.d + paramInt > this.a)
    {
      this.a = (this.d + paramInt + 128);
      byte[] arrayOfByte = new byte[this.a];
      System.arraycopy(this.f, 0, arrayOfByte, 0, this.d);
      this.f = arrayOfByte;
    }
    this.b = (this.d + paramInt);
    System.arraycopy(paramArrayOfByte, 0, this.f, this.d, paramInt);
    this.e = paramInt;
    util.int16_to_buf(this.f, 0, this.g);
    util.int16_to_buf(this.f, 2, this.e);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.a)
    {
      this.a = (paramInt2 + 128);
      this.f = new byte[this.a];
    }
    this.b = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.f, 0, paramInt2);
    this.g = util.buf_to_int16(paramArrayOfByte, paramInt1);
    this.e = (paramInt2 - this.d);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.f, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = a(paramArrayOfByte, paramInt1, paramInt2, this.g);
    if (i < 0) {}
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
      } while (this.d >= paramInt1);
      this.e = util.buf_to_int16(paramArrayOfByte, i + 2);
    } while (this.d + this.e > paramInt1);
    a(paramArrayOfByte, i, this.d + this.e);
    if (!e().booleanValue()) {
      return -1005;
    }
    return this.d + i + this.e;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.a - this.d)
    {
      this.a = (this.d + paramInt + 64);
      byte[] arrayOfByte = new byte[this.a];
      System.arraycopy(this.f, 0, arrayOfByte, 0, this.b);
      this.f = arrayOfByte;
    }
    this.e = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.f, this.b, paramInt);
    this.b += paramInt;
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.e];
    System.arraycopy(this.f, this.d, arrayOfByte, 0, this.e);
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > paramInt) {
        return paramInt;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  public void d()
  {
    util.int16_to_buf(this.f, 2, this.b - this.d);
  }
  
  public Boolean e()
  {
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.b.a
 * JD-Core Version:    0.7.0.1
 */