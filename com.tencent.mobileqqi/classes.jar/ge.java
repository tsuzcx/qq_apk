import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.AlignmentPattern;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ge
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final ResultPointCallback jdField_a_of_type_ComGoogleZxingResultPointCallback;
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  private final List jdField_a_of_type_JavaUtilList;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int b;
  private final int c;
  private final int d;
  
  public ge(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, ResultPointCallback paramResultPointCallback)
  {
    this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramBitMatrix;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_ComGoogleZxingResultPointCallback = paramResultPointCallback;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
    int j = localBitMatrix.b();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    int i = paramInt1;
    while ((i >= 0) && (localBitMatrix.a(paramInt2, i)) && (arrayOfInt[1] <= paramInt3))
    {
      arrayOfInt[1] += 1;
      i -= 1;
    }
    if ((i < 0) || (arrayOfInt[1] > paramInt3)) {}
    do
    {
      do
      {
        do
        {
          return (0.0F / 0.0F);
          while ((i >= 0) && (!localBitMatrix.a(paramInt2, i)) && (arrayOfInt[0] <= paramInt3))
          {
            arrayOfInt[0] += 1;
            i -= 1;
          }
        } while (arrayOfInt[0] > paramInt3);
        paramInt1 += 1;
        while ((paramInt1 < j) && (localBitMatrix.a(paramInt2, paramInt1)) && (arrayOfInt[1] <= paramInt3))
        {
          arrayOfInt[1] += 1;
          paramInt1 += 1;
        }
      } while ((paramInt1 == j) || (arrayOfInt[1] > paramInt3));
      while ((paramInt1 < j) && (!localBitMatrix.a(paramInt2, paramInt1)) && (arrayOfInt[2] <= paramInt3))
      {
        arrayOfInt[2] += 1;
        paramInt1 += 1;
      }
    } while ((arrayOfInt[2] > paramInt3) || (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) * 5 >= paramInt4 * 2) || (!a(arrayOfInt)));
    return a(arrayOfInt, paramInt1);
  }
  
  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[2] - paramArrayOfInt[1] / 2.0F;
  }
  
  private AlignmentPattern a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramArrayOfInt[2];
    float f1 = a(paramArrayOfInt, paramInt2);
    float f2 = a(paramInt1, (int)f1, paramArrayOfInt[1] * 2, i + j + k);
    if (!Float.isNaN(f2))
    {
      float f3 = (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2]) / 3.0F;
      paramArrayOfInt = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramArrayOfInt.hasNext())
      {
        AlignmentPattern localAlignmentPattern = (AlignmentPattern)paramArrayOfInt.next();
        if (localAlignmentPattern.a(f3, f2, f1)) {
          return localAlignmentPattern.a(f2, f1, f3);
        }
      }
      paramArrayOfInt = new AlignmentPattern(f1, f2, f3);
      this.jdField_a_of_type_JavaUtilList.add(paramArrayOfInt);
      if (this.jdField_a_of_type_ComGoogleZxingResultPointCallback != null) {
        this.jdField_a_of_type_ComGoogleZxingResultPointCallback.a(paramArrayOfInt);
      }
    }
    return null;
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    float f1 = this.jdField_a_of_type_Float;
    float f2 = f1 / 2.0F;
    int i = 0;
    while (i < 3)
    {
      if (Math.abs(f1 - paramArrayOfInt[i]) >= f2) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public AlignmentPattern a()
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.d;
    int i2 = n + this.c;
    int i3 = this.b;
    int[] arrayOfInt = new int[3];
    int k = 0;
    while (k < i1)
    {
      if ((k & 0x1) == 0) {}
      int i4;
      for (int i = k + 1 >> 1;; i = -(k + 1 >> 1))
      {
        i4 = i3 + (i1 >> 1) + i;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        i = n;
        while ((i < i2) && (!this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i, i4))) {
          i += 1;
        }
      }
      int j = 0;
      int m = i;
      i = j;
      Object localObject;
      for (;;)
      {
        if (m < i2) {
          if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(m, i4))
          {
            if (i == 1)
            {
              arrayOfInt[i] += 1;
              m += 1;
              continue;
            }
            if (i == 2) {
              if (a(arrayOfInt))
              {
                localObject = a(arrayOfInt, i4, m);
                if (localObject == null) {
                  break;
                }
              }
            }
          }
        }
      }
      AlignmentPattern localAlignmentPattern;
      do
      {
        return localObject;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = 1;
        arrayOfInt[2] = 0;
        i = 1;
        break;
        i += 1;
        arrayOfInt[i] += 1;
        break;
        j = i;
        if (i == 1) {
          j = i + 1;
        }
        arrayOfInt[j] += 1;
        i = j;
        break;
        if (!a(arrayOfInt)) {
          break label299;
        }
        localAlignmentPattern = a(arrayOfInt, i4, i2);
        localObject = localAlignmentPattern;
      } while (localAlignmentPattern != null);
      label299:
      k += 1;
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return (AlignmentPattern)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    throw ReaderException.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ge
 * JD-Core Version:    0.7.0.1
 */