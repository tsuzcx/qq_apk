package com.google.zxing.common;

public final class BitArray
{
  private int jdField_a_of_type_Int;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public BitArray()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
  }
  
  public BitArray(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfInt = a(paramInt);
  }
  
  private static int[] a(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  private void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_ArrayOfInt.length << 5)
    {
      int[] arrayOfInt = a(paramInt);
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = paramInt >> 5;
    arrayOfInt[i] |= 1 << (paramInt & 0x1F);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfInt[(paramInt1 >> 5)] = paramInt2;
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (a(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public void a(BitArray paramBitArray)
  {
    int j = paramBitArray.jdField_a_of_type_Int;
    b(this.jdField_a_of_type_Int + j);
    int i = 0;
    while (i < j)
    {
      a(paramBitArray.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(this.jdField_a_of_type_Int + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i = this.jdField_a_of_type_Int >> 5;
      arrayOfInt[i] |= 1 << (this.jdField_a_of_type_Int & 0x1F);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ArrayOfInt[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int + 7 >> 3;
  }
  
  public void b()
  {
    int[] arrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    int j = this.jdField_a_of_type_Int;
    int i = 0;
    while (i < j)
    {
      if (a(j - i - 1))
      {
        int k = i >> 5;
        arrayOfInt[k] |= 1 << (i & 0x1F);
      }
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    b(this.jdField_a_of_type_Int + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public void b(BitArray paramBitArray)
  {
    if (this.jdField_a_of_type_ArrayOfInt.length != paramBitArray.jdField_a_of_type_ArrayOfInt.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] ^= paramBitArray.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (a(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.7.0.1
 */