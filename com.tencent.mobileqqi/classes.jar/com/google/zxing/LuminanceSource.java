package com.google.zxing;

public abstract class LuminanceSource
{
  private final int a;
  private final int b;
  
  protected LuminanceSource(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public LuminanceSource a()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract byte[] a();
  
  public abstract byte[] a(int paramInt, byte[] paramArrayOfByte);
  
  public final int b()
  {
    return this.b;
  }
  
  public LuminanceSource b()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final String toString()
  {
    byte[] arrayOfByte = new byte[this.a];
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i = 0;
    while (i < this.b)
    {
      arrayOfByte = a(i, arrayOfByte);
      int j = 0;
      if (j < this.a)
      {
        int k = arrayOfByte[j] & 0xFF;
        char c;
        if (k < 64) {
          c = '#';
        }
        for (;;)
        {
          localStringBuilder.append(c);
          j += 1;
          break;
          if (k < 128) {
            c = '+';
          } else if (k < 192) {
            c = '.';
          } else {
            c = ' ';
          }
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.LuminanceSource
 * JD-Core Version:    0.7.0.1
 */