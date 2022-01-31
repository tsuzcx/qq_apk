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
  
  private void c(int paramInt)
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
  
  public int a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt >> 5;
      for (paramInt = this.jdField_a_of_type_ArrayOfInt[i] & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF); paramInt == 0; paramInt = this.jdField_a_of_type_ArrayOfInt[i])
      {
        i += 1;
        if (i == this.jdField_a_of_type_ArrayOfInt.length) {
          return this.jdField_a_of_type_Int;
        }
      }
      i = Integer.numberOfTrailingZeros(paramInt) + (i << 5);
      paramInt = i;
    } while (i <= this.jdField_a_of_type_Int);
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
    c(this.jdField_a_of_type_Int + j);
    int i = 0;
    while (i < j)
    {
      a(paramBitArray.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(this.jdField_a_of_type_Int + 1);
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
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {
      return true;
    }
    int i1 = paramInt2 - 1;
    int m = paramInt1 >> 5;
    int i2 = i1 >> 5;
    int j = m;
    while (j <= i2)
    {
      int k;
      if (j > m)
      {
        paramInt2 = 0;
        if (j >= i2) {
          break label115;
        }
        k = 31;
        label67:
        if ((paramInt2 != 0) || (k != 31)) {
          break label125;
        }
        paramInt2 = -1;
        k = this.jdField_a_of_type_ArrayOfInt[j];
        if (!paramBoolean) {
          break label158;
        }
      }
      label158:
      for (int i = paramInt2;; i = 0)
      {
        if ((k & paramInt2) == i) {
          break label164;
        }
        return false;
        paramInt2 = paramInt1 & 0x1F;
        break;
        label115:
        k = i1 & 0x1F;
        break label67;
        label125:
        int n;
        for (i = 0;; i = 1 << n | i)
        {
          n = paramInt2;
          paramInt2 = i;
          if (n > k) {
            break;
          }
          paramInt2 = n + 1;
        }
      }
      label164:
      j += 1;
    }
    return true;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int + 7 >> 3;
  }
  
  public int b(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt >> 5;
      for (paramInt = (this.jdField_a_of_type_ArrayOfInt[i] ^ 0xFFFFFFFF) & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF); paramInt == 0; paramInt = this.jdField_a_of_type_ArrayOfInt[i] ^ 0xFFFFFFFF)
      {
        i += 1;
        if (i == this.jdField_a_of_type_ArrayOfInt.length) {
          return this.jdField_a_of_type_Int;
        }
      }
      i = Integer.numberOfTrailingZeros(paramInt) + (i << 5);
      paramInt = i;
    } while (i <= this.jdField_a_of_type_Int);
    return this.jdField_a_of_type_Int;
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
  
  public void b(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = paramInt >> 5;
    arrayOfInt[i] ^= 1 << (paramInt & 0x1F);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {
      return;
    }
    int i1 = paramInt2 - 1;
    int m = paramInt1 >> 5;
    int i2 = i1 >> 5;
    int j = m;
    label39:
    if (j <= i2)
    {
      if (j <= m) {
        break label106;
      }
      paramInt2 = 0;
      label55:
      if (j >= i2) {
        break label114;
      }
    }
    label106:
    label114:
    for (int k = 31;; k = i1 & 0x1F)
    {
      if ((paramInt2 != 0) || (k != 31)) {
        break label124;
      }
      i = -1;
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[j] = (i | arrayOfInt[j]);
      j += 1;
      break label39;
      break;
      paramInt2 = paramInt1 & 0x1F;
      break label55;
    }
    label124:
    int n = 0;
    int i = paramInt2;
    for (paramInt2 = n;; paramInt2 = 1 << n | paramInt2)
    {
      n = i;
      i = paramInt2;
      if (n > k) {
        break;
      }
      i = n + 1;
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
  
  public void c(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    c(this.jdField_a_of_type_Int + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.7.0.1
 */