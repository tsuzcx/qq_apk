package com.google.zxing.common;

public final class BitSource
{
  private int jdField_a_of_type_Int;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public BitSource(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 32) || (paramInt > c())) {
      throw new IllegalArgumentException(String.valueOf(paramInt));
    }
    int j;
    int i;
    int k;
    if (this.b > 0)
    {
      j = 8 - this.b;
      if (paramInt < j)
      {
        i = paramInt;
        j -= i;
        k = this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int];
        this.b = (i + this.b);
        if (this.b == 8)
        {
          this.b = 0;
          this.jdField_a_of_type_Int += 1;
        }
        k = (255 >> 8 - i << j & k) >> j;
        j = paramInt - i;
      }
    }
    for (paramInt = k;; paramInt = i)
    {
      i = paramInt;
      if (j > 0)
      {
        for (;;)
        {
          if (j >= 8)
          {
            paramInt = paramInt << 8 | this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] & 0xFF;
            this.jdField_a_of_type_Int += 1;
            j -= 8;
            continue;
            i = j;
            break;
          }
        }
        i = paramInt;
        if (j > 0)
        {
          i = 8 - j;
          i = paramInt << j | (255 >> i << i & this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int]) >> i;
          this.b = (j + this.b);
        }
      }
      return i;
      i = 0;
      j = paramInt;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c()
  {
    return (this.jdField_a_of_type_ArrayOfByte.length - this.jdField_a_of_type_Int) * 8 - this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.BitSource
 * JD-Core Version:    0.7.0.1
 */