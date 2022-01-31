import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;

public final class gb
{
  private static final int jdField_a_of_type_Int = 7973;
  private static final int[][] jdField_a_of_type_Array2dOfInt;
  private static final int jdField_b_of_type_Int = 1335;
  private static final int[][] jdField_b_of_type_Array2dOfInt;
  private static final int jdField_c_of_type_Int = 21522;
  private static final int[][] jdField_c_of_type_Array2dOfInt;
  private static final int[][] d;
  
  static
  {
    a = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
    int[] arrayOfInt1 = { 1, 0, 1, 0, 1 };
    b = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, arrayOfInt1, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    int[] arrayOfInt2 = { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt3 = { 6, 34, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt14 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt15 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt16 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt17 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt18 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt19 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt20 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, arrayOfInt1, { 6, 22, -1, -1, -1, -1, -1 }, arrayOfInt2, { 6, 30, -1, -1, -1, -1, -1 }, arrayOfInt3, { 6, 22, 38, -1, -1, -1, -1 }, arrayOfInt4, arrayOfInt5, { 6, 28, 50, -1, -1, -1, -1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, arrayOfInt9, { 6, 30, 54, 78, -1, -1, -1 }, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 6, 28, 50, 72, 94, -1, -1 }, arrayOfInt13, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, arrayOfInt14, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt15, arrayOfInt16, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, arrayOfInt17, { 6, 34, 60, 86, 112, 138, -1 }, arrayOfInt18, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, arrayOfInt19, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, arrayOfInt20 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 1 };
    arrayOfInt3 = new int[] { 8, 2 };
    arrayOfInt4 = new int[] { 8, 3 };
    arrayOfInt5 = new int[] { 8, 4 };
    arrayOfInt6 = new int[] { 8, 5 };
    arrayOfInt7 = new int[] { 7, 8 };
    d = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 8, 7 }, { 8, 8 }, arrayOfInt7, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
  }
  
  static int a(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    paramInt1 <<= i - 1;
    while (a(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << a(paramInt1) - i;
    }
    return paramInt1;
  }
  
  private static void a(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramByteMatrix.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramByteMatrix.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
  {
    int k = paramByteMatrix.b() - 1;
    int j = paramByteMatrix.a() - 1;
    int m = -1;
    int i = 0;
    if (k > 0)
    {
      if (k != 6) {
        break label247;
      }
      k -= 1;
    }
    label111:
    label247:
    for (;;)
    {
      if ((j >= 0) && (j < paramByteMatrix.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramByteMatrix.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramBitArray.a())
            {
              bool1 = paramBitArray.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (ga.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramByteMatrix.a(i1, j, bool2);
              break;
              bool1 = false;
              break label111;
            }
          }
        }
        j += m;
      }
      else
      {
        m = -m;
        k -= 2;
        j += m;
        break;
        if (i != paramBitArray.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramBitArray.a());
        }
        return;
      }
    }
  }
  
  public static void a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix)
  {
    a(paramByteMatrix);
    a(paramVersion, paramByteMatrix);
    a(paramErrorCorrectionLevel, paramInt, paramByteMatrix);
    b(paramVersion, paramByteMatrix);
    a(paramBitArray, paramInt, paramByteMatrix);
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
  {
    if (!QRCode.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramBitArray.c(paramInt, 5);
    paramBitArray.c(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new BitArray();
    paramErrorCorrectionLevel.c(21522, 15);
    paramBitArray.b(paramErrorCorrectionLevel);
    if (paramBitArray.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramBitArray.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
  {
    BitArray localBitArray = new BitArray();
    a(paramErrorCorrectionLevel, paramInt, localBitArray);
    paramInt = 0;
    if (paramInt < localBitArray.a())
    {
      boolean bool = localBitArray.a(localBitArray.a() - 1 - paramInt);
      paramByteMatrix.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramByteMatrix.a(paramByteMatrix.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramByteMatrix.a(8, paramByteMatrix.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(Version paramVersion, BitArray paramBitArray)
  {
    paramBitArray.c(paramVersion.a(), 6);
    paramBitArray.c(a(paramVersion.a(), 7973), 12);
    if (paramBitArray.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramBitArray.a());
    }
  }
  
  static void a(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    d(paramByteMatrix);
    c(paramByteMatrix);
    c(paramVersion, paramByteMatrix);
    b(paramByteMatrix);
  }
  
  static void a(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramByteMatrix.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramByteMatrix.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 7) {}
    for (;;)
    {
      return;
      BitArray localBitArray = new BitArray();
      a(paramVersion, localBitArray);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localBitArray.a(i);
          i -= 1;
          paramByteMatrix.a(j, paramByteMatrix.a() - 11 + k, bool);
          paramByteMatrix.a(paramByteMatrix.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(ByteMatrix paramByteMatrix)
  {
    int i = 8;
    while (i < paramByteMatrix.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramByteMatrix.a(i, 6))) {
        paramByteMatrix.a(i, 6, j);
      }
      if (a(paramByteMatrix.a(6, i))) {
        paramByteMatrix.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(Version paramVersion, ByteMatrix paramByteMatrix)
  {
    if (paramVersion.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramVersion.a() - 1;
      paramVersion = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramVersion[i];
          int n = paramVersion[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramByteMatrix.a(n, m))) {
              c(n - 2, m - 2, paramByteMatrix);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(ByteMatrix paramByteMatrix)
  {
    if (paramByteMatrix.a(8, paramByteMatrix.a() - 8) == 0) {
      throw new WriterException();
    }
    paramByteMatrix.a(8, paramByteMatrix.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramByteMatrix.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(ByteMatrix paramByteMatrix)
  {
    int i = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.b() - i, 0, paramByteMatrix);
    d(0, paramByteMatrix.b() - i, paramByteMatrix);
    a(0, 7, paramByteMatrix);
    a(paramByteMatrix.b() - 8, 7, paramByteMatrix);
    a(0, paramByteMatrix.b() - 8, paramByteMatrix);
    b(7, 0, paramByteMatrix);
    b(paramByteMatrix.a() - 7 - 1, 0, paramByteMatrix);
    b(7, paramByteMatrix.a() - 7, paramByteMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gb
 * JD-Core Version:    0.7.0.1
 */