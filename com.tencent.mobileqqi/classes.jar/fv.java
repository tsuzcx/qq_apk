import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class fv
{
  private static final int jdField_a_of_type_Int = 21522;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
  private static final int[][] jdField_a_of_type_Array2dOfInt;
  private final byte jdField_a_of_type_Byte;
  private final ErrorCorrectionLevel jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  
  static
  {
    int[] arrayOfInt1 = { 21522, 0 };
    int[] arrayOfInt2 = { 20773, 1 };
    int[] arrayOfInt3 = { 17913, 4 };
    int[] arrayOfInt4 = { 30660, 8 };
    int[] arrayOfInt5 = { 29427, 9 };
    int[] arrayOfInt6 = { 32170, 10 };
    int[] arrayOfInt7 = { 26159, 12 };
    int[] arrayOfInt8 = { 25368, 13 };
    int[] arrayOfInt9 = { 27713, 14 };
    int[] arrayOfInt10 = { 26998, 15 };
    int[] arrayOfInt11 = { 5769, 16 };
    int[] arrayOfInt12 = { 5054, 17 };
    int[] arrayOfInt13 = { 6608, 19 };
    int[] arrayOfInt14 = { 1890, 20 };
    int[] arrayOfInt15 = { 3340, 22 };
    int[] arrayOfInt16 = { 2107, 23 };
    int[] arrayOfInt17 = { 13663, 24 };
    int[] arrayOfInt18 = { 12392, 25 };
    int[] arrayOfInt19 = { 16177, 26 };
    int[] arrayOfInt20 = { 14854, 27 };
    int[] arrayOfInt21 = { 9396, 28 };
    int[] arrayOfInt22 = { 8579, 29 };
    int[] arrayOfInt23 = { 11994, 30 };
    jdField_a_of_type_Array2dOfInt = new int[][] { arrayOfInt1, arrayOfInt2, { 24188, 2 }, { 23371, 3 }, arrayOfInt3, { 16590, 5 }, { 20375, 6 }, { 19104, 7 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 30877, 11 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 7399, 18 }, arrayOfInt13, arrayOfInt14, { 597, 21 }, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, { 11245, 31 } };
  }
  
  private fv(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel = ErrorCorrectionLevel.forBits(paramInt >> 3 & 0x3);
    this.jdField_a_of_type_Byte = ((byte)(paramInt & 0x7));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    paramInt1 ^= paramInt2;
    paramInt2 = jdField_a_of_type_ArrayOfInt[(paramInt1 & 0xF)];
    int i = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 4 & 0xF)];
    int j = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 8 & 0xF)];
    int k = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 12 & 0xF)];
    int m = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 16 & 0xF)];
    int n = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 20 & 0xF)];
    int i1 = jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 24 & 0xF)];
    return jdField_a_of_type_ArrayOfInt[(paramInt1 >>> 28 & 0xF)] + (paramInt2 + i + j + k + m + n + i1);
  }
  
  static fv a(int paramInt1, int paramInt2)
  {
    fv localfv = b(paramInt1, paramInt2);
    if (localfv != null) {
      return localfv;
    }
    return b(paramInt1 ^ 0x5412, paramInt2 ^ 0x5412);
  }
  
  private static fv b(int paramInt1, int paramInt2)
  {
    int j = 2147483647;
    int[][] arrayOfInt = jdField_a_of_type_Array2dOfInt;
    int n = arrayOfInt.length;
    int k = 0;
    int i = 0;
    int[] arrayOfInt1;
    int i1;
    int m;
    if (k < n)
    {
      arrayOfInt1 = arrayOfInt[k];
      i1 = arrayOfInt1[0];
      if ((i1 == paramInt1) || (i1 == paramInt2)) {
        return new fv(arrayOfInt1[1]);
      }
      m = a(paramInt1, i1);
      if (m >= j) {
        break label139;
      }
      i = arrayOfInt1[1];
      j = m;
    }
    label139:
    for (;;)
    {
      if (paramInt1 != paramInt2)
      {
        m = a(paramInt2, i1);
        if (m < j)
        {
          i = arrayOfInt1[1];
          j = m;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (j <= 3) {
          return new fv(i);
        }
        return null;
      }
    }
  }
  
  byte a()
  {
    return this.jdField_a_of_type_Byte;
  }
  
  public ErrorCorrectionLevel a()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fv)) {}
    do
    {
      return false;
      paramObject = (fv)paramObject;
    } while ((this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel != paramObject.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel) || (this.jdField_a_of_type_Byte != paramObject.jdField_a_of_type_Byte));
    return true;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderErrorCorrectionLevel.ordinal() << 3 | this.jdField_a_of_type_Byte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fv
 * JD-Core Version:    0.7.0.1
 */