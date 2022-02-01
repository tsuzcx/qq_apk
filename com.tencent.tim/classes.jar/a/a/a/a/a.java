package a.a.a.a;

import java.nio.ByteOrder;

public final class a
{
  public final byte[] a;
  public final int b;
  public final ByteOrder c;
  public int d;
  
  public a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ByteOrder paramByteOrder)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramByteOrder;
  }
  
  public static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ByteOrder paramByteOrder)
  {
    return new a(paramArrayOfByte, paramInt1, paramInt2, paramByteOrder);
  }
  
  public int a()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b + this.d;
    int k;
    int j;
    int m;
    if (this.c == ByteOrder.BIG_ENDIAN)
    {
      k = i + 1;
      i = arrayOfByte[i];
      j = k + 1;
      k = arrayOfByte[k];
      m = arrayOfByte[j];
    }
    for (i = (arrayOfByte[(j + 1)] & 0xFF) << 0 | (i & 0xFF) << 24 | (k & 0xFF) << 16 | (m & 0xFF) << 8;; i = (arrayOfByte[(j + 1)] & 0xFF) << 24 | (i & 0xFF) << 0 | (k & 0xFF) << 8 | (m & 0xFF) << 16)
    {
      this.d += 4;
      return i;
      k = i + 1;
      i = arrayOfByte[i];
      j = k + 1;
      k = arrayOfByte[k];
      m = arrayOfByte[j];
    }
  }
  
  public short b()
  {
    byte[] arrayOfByte = this.a;
    int i = this.b + this.d;
    int j;
    if (this.c == ByteOrder.BIG_ENDIAN) {
      j = arrayOfByte[i];
    }
    for (short s = (short)(arrayOfByte[(i + 1)] & 0xFF | j << 8);; s = (short)(arrayOfByte[i] & 0xFF | j << 8))
    {
      this.d += 2;
      return s;
      j = arrayOfByte[(i + 1)];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */