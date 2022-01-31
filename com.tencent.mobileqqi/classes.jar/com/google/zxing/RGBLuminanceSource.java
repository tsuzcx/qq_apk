package com.google.zxing;

public final class RGBLuminanceSource
  extends LuminanceSource
{
  private final int jdField_a_of_type_Int;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int b;
  private final int c;
  private final int d;
  
  public RGBLuminanceSource(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    super(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int k = i * paramInt1;
      int j = 0;
      if (j < paramInt1)
      {
        int i1 = paramArrayOfInt[(k + j)];
        int m = i1 >> 16 & 0xFF;
        int n = i1 >> 8 & 0xFF;
        i1 &= 0xFF;
        if ((m == n) && (n == i1)) {
          this.jdField_a_of_type_ArrayOfByte[(k + j)] = ((byte)m);
        }
        for (;;)
        {
          j += 1;
          break;
          this.jdField_a_of_type_ArrayOfByte[(k + j)] = ((byte)(i1 + (m + n + n) >> 2));
        }
      }
      i += 1;
    }
  }
  
  private RGBLuminanceSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt5, paramInt6);
    if ((paramInt3 + paramInt5 > paramInt1) || (paramInt4 + paramInt6 > paramInt2)) {
      throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new RGBLuminanceSource(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, this.c + paramInt1, this.d + paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public byte[] a()
  {
    int i = 0;
    int k = a();
    int m = b();
    Object localObject;
    if ((k == this.jdField_a_of_type_Int) && (m == this.b))
    {
      localObject = this.jdField_a_of_type_ArrayOfByte;
      return localObject;
    }
    int n = k * m;
    byte[] arrayOfByte1 = new byte[n];
    int j = this.d * this.jdField_a_of_type_Int + this.c;
    if (k == this.jdField_a_of_type_Int)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, j, arrayOfByte1, 0, n);
      return arrayOfByte1;
    }
    byte[] arrayOfByte2 = this.jdField_a_of_type_ArrayOfByte;
    for (;;)
    {
      localObject = arrayOfByte1;
      if (i >= m) {
        break;
      }
      System.arraycopy(arrayOfByte2, j, arrayOfByte1, i * k, k);
      j += this.jdField_a_of_type_Int;
      i += 1;
    }
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt < 0) || (paramInt >= b())) {
      throw new IllegalArgumentException("Requested row is outside the image: " + paramInt);
    }
    int i = a();
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= i) {}
    }
    else
    {
      arrayOfByte = new byte[i];
    }
    int j = this.d;
    int k = this.jdField_a_of_type_Int;
    int m = this.c;
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, (j + paramInt) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.RGBLuminanceSource
 * JD-Core Version:    0.7.0.1
 */