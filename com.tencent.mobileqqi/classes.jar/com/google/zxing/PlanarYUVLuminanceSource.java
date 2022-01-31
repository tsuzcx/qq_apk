package com.google.zxing;

public final class PlanarYUVLuminanceSource
  extends LuminanceSource
{
  private final int jdField_a_of_type_Int;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int b;
  private final int c;
  private final int d;
  
  public PlanarYUVLuminanceSource(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
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
    if (paramBoolean) {
      a(paramInt5, paramInt6);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int j = this.d;
    int k = this.jdField_a_of_type_Int;
    j = this.c + j * k;
    k = 0;
    while (k < paramInt2)
    {
      int i1 = paramInt1 / 2;
      int m = j + paramInt1 - 1;
      int n = j;
      while (n < j + i1)
      {
        int i = arrayOfByte[n];
        arrayOfByte[n] = arrayOfByte[m];
        arrayOfByte[m] = i;
        n += 1;
        m -= 1;
      }
      j += this.jdField_a_of_type_Int;
      k += 1;
    }
  }
  
  public LuminanceSource a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new PlanarYUVLuminanceSource(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, this.c + paramInt1, this.d + paramInt2, paramInt3, paramInt4, false);
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
  
  public int[] a()
  {
    int m = a();
    int n = b();
    int[] arrayOfInt = new int[m * n];
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int j = this.d;
    int k = this.jdField_a_of_type_Int;
    int i1 = this.c;
    int i = 0;
    j = j * k + i1;
    while (i < n)
    {
      k = 0;
      while (k < m)
      {
        arrayOfInt[(i * m + k)] = ((arrayOfByte[(j + k)] & 0xFF) * 65793 | 0xFF000000);
        k += 1;
      }
      j += this.jdField_a_of_type_Int;
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.PlanarYUVLuminanceSource
 * JD-Core Version:    0.7.0.1
 */