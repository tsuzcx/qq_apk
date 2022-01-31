package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;

public class GlobalHistogramBinarizer
  extends Binarizer
{
  private static final int jdField_a_of_type_Int = 5;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final int jdField_b_of_type_Int = 3;
  private static final int c = 32;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[32];
  private byte[] jdField_b_of_type_ArrayOfByte;
  
  public GlobalHistogramBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
    this.b = jdField_a_of_type_ArrayOfByte;
  }
  
  private static int a(int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i3 = paramArrayOfInt.length;
    int i = 0;
    int m = 0;
    int j = 0;
    int i1;
    for (int n = 0; i < i3; n = i1)
    {
      k = m;
      if (paramArrayOfInt[i] > m)
      {
        k = paramArrayOfInt[i];
        j = i;
      }
      i1 = n;
      if (paramArrayOfInt[i] > n) {
        i1 = paramArrayOfInt[i];
      }
      i += 1;
      m = k;
    }
    m = 0;
    i = 0;
    int k = i2;
    if (k < i3)
    {
      i1 = k - j;
      i1 *= paramArrayOfInt[k] * i1;
      if (i1 <= m) {
        break label251;
      }
      m = k;
      i = i1;
    }
    for (;;)
    {
      k += 1;
      i1 = m;
      m = i;
      i = i1;
      break;
      if (j > i)
      {
        i1 = i;
        m = j;
      }
      for (;;)
      {
        if (m - i1 <= i3 >> 4) {
          throw ReaderException.getInstance();
        }
        j = m - 1;
        k = -1;
        i = m - 1;
        if (i > i1)
        {
          i2 = i - i1;
          i2 = i2 * i2 * (m - i) * (n - paramArrayOfInt[i]);
          if (i2 <= k) {
            break label231;
          }
          k = i;
          j = i2;
        }
        for (;;)
        {
          i -= 1;
          i2 = k;
          k = j;
          j = i2;
          break;
          return j << 3;
          label231:
          i2 = j;
          j = k;
          k = i2;
        }
        m = i;
        i1 = j;
      }
      label251:
      i1 = i;
      i = m;
      m = i1;
    }
  }
  
  private void a(int paramInt)
  {
    if (this.b.length < paramInt) {
      this.b = new byte[paramInt];
    }
    paramInt = 0;
    while (paramInt < 32)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      paramInt += 1;
    }
  }
  
  public Binarizer a(LuminanceSource paramLuminanceSource)
  {
    return new GlobalHistogramBinarizer(paramLuminanceSource);
  }
  
  public BitArray a(int paramInt, BitArray paramBitArray)
  {
    int i = 1;
    Object localObject = a();
    int m = ((LuminanceSource)localObject).a();
    if ((paramBitArray == null) || (paramBitArray.a() < m)) {
      paramBitArray = new BitArray(m);
    }
    int[] arrayOfInt;
    for (;;)
    {
      a(m);
      localObject = ((LuminanceSource)localObject).a(paramInt, this.b);
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      paramInt = 0;
      while (paramInt < m)
      {
        j = (localObject[paramInt] & 0xFF) >> 3;
        arrayOfInt[j] += 1;
        paramInt += 1;
      }
      paramBitArray.a();
    }
    int n = a(arrayOfInt);
    int j = localObject[0];
    paramInt = localObject[1] & 0xFF;
    j &= 0xFF;
    while (i < m - 1)
    {
      int k = localObject[(i + 1)] & 0xFF;
      if ((paramInt << 2) - j - k >> 1 < n) {
        paramBitArray.a(i);
      }
      i += 1;
      j = paramInt;
      paramInt = k;
    }
    return paramBitArray;
  }
  
  public BitMatrix a()
  {
    Object localObject = a();
    int k = ((LuminanceSource)localObject).a();
    int m = ((LuminanceSource)localObject).b();
    BitMatrix localBitMatrix = new BitMatrix(k, m);
    a(k);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = 1;
    int j;
    while (i < 5)
    {
      byte[] arrayOfByte = ((LuminanceSource)localObject).a(m * i / 5, this.b);
      n = (k << 2) / 5;
      j = k / 5;
      while (j < n)
      {
        int i1 = (arrayOfByte[j] & 0xFF) >> 3;
        arrayOfInt[i1] += 1;
        j += 1;
      }
      i += 1;
    }
    int n = a(arrayOfInt);
    localObject = ((LuminanceSource)localObject).a();
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        if ((localObject[(i * k + j)] & 0xFF) < n) {
          localBitMatrix.a(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return localBitMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.common.GlobalHistogramBinarizer
 * JD-Core Version:    0.7.0.1
 */