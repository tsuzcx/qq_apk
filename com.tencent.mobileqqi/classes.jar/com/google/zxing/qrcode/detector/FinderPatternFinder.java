package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder
{
  protected static final int a = 3;
  protected static final int b = 57;
  private static final int c = 2;
  private static final int d = 8;
  private final ResultPointCallback jdField_a_of_type_ComGoogleZxingResultPointCallback;
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  private final List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public FinderPatternFinder(BitMatrix paramBitMatrix)
  {
    this(paramBitMatrix, null);
  }
  
  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback)
  {
    this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramBitMatrix;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ArrayOfInt = new int[5];
    this.jdField_a_of_type_ComGoogleZxingResultPointCallback = paramResultPointCallback;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
    int k = localBitMatrix.b();
    int[] arrayOfInt = a();
    int i = paramInt1;
    while ((i >= 0) && (localBitMatrix.a(paramInt2, i)))
    {
      arrayOfInt[2] += 1;
      i -= 1;
    }
    int j = i;
    if (i < 0) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.a(paramInt2, j)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] += 1;
                j -= 1;
              }
            } while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.a(paramInt2, j)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] += 1;
              j -= 1;
            }
          } while (arrayOfInt[0] > paramInt3);
          paramInt1 += 1;
          while ((paramInt1 < k) && (localBitMatrix.a(paramInt2, paramInt1)))
          {
            arrayOfInt[2] += 1;
            paramInt1 += 1;
          }
        } while (paramInt1 == k);
        while ((paramInt1 < k) && (!localBitMatrix.a(paramInt2, paramInt1)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] += 1;
          paramInt1 += 1;
        }
      } while ((paramInt1 == k) || (arrayOfInt[3] >= paramInt3));
      while ((paramInt1 < k) && (localBitMatrix.a(paramInt2, paramInt1)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] += 1;
        paramInt1 += 1;
      }
    } while ((arrayOfInt[4] >= paramInt3) || (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4 * 2) || (!a(arrayOfInt)));
    return a(arrayOfInt, paramInt1);
  }
  
  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[4] - paramArrayOfInt[3] - paramArrayOfInt[2] / 2.0F;
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return 0;
    }
    Object localObject = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    FinderPattern localFinderPattern;
    if (localIterator.hasNext())
    {
      localFinderPattern = (FinderPattern)localIterator.next();
      if (localFinderPattern.a() < 2) {
        break label99;
      }
      if (localObject == null) {
        localObject = localFinderPattern;
      }
    }
    label99:
    for (;;)
    {
      break;
      this.jdField_a_of_type_Boolean = true;
      return (int)(Math.abs(localObject.a() - localFinderPattern.a()) - Math.abs(localObject.b() - localFinderPattern.b())) / 2;
      return 0;
    }
  }
  
  private boolean a()
  {
    float f2 = 0.0F;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    float f1 = 0.0F;
    int i = 0;
    if (localIterator.hasNext())
    {
      FinderPattern localFinderPattern = (FinderPattern)localIterator.next();
      if (localFinderPattern.a() < 2) {
        break label147;
      }
      f1 = localFinderPattern.c() + f1;
      i += 1;
    }
    label147:
    for (;;)
    {
      break;
      if (i < 3) {}
      do
      {
        return false;
        float f3 = f1 / j;
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          f2 += Math.abs(((FinderPattern)localIterator.next()).c() - f3);
        }
      } while (f2 > 0.05F * f1);
      return true;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = (int)Math.round(paramInt3 * 1.5D);
    BitMatrix localBitMatrix = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
    int m = localBitMatrix.a();
    int n = localBitMatrix.b();
    int[] arrayOfInt = a();
    paramInt3 = paramInt1 + 1;
    int j = paramInt2;
    while ((j >= 0) && (paramInt3 < n) && (localBitMatrix.a(j, paramInt3)))
    {
      arrayOfInt[2] += 1;
      j -= 1;
      paramInt3 += 1;
    }
    int i;
    if (j >= 0)
    {
      i = paramInt3;
      if (paramInt3 != n) {}
    }
    else
    {
      return false;
    }
    while ((j >= 0) && (i < n) && (!localBitMatrix.a(j, i)) && (arrayOfInt[1] <= k))
    {
      arrayOfInt[1] += 1;
      j -= 1;
      i += 1;
    }
    if ((j < 0) || (i == n) || (arrayOfInt[1] > k)) {
      return false;
    }
    while ((j >= 0) && (i < n) && (localBitMatrix.a(j, i)) && (arrayOfInt[0] <= k))
    {
      arrayOfInt[0] += 1;
      j -= 1;
      i += 1;
    }
    if (arrayOfInt[0] > k) {
      return false;
    }
    paramInt3 = paramInt2 + 1;
    while ((paramInt3 < m) && (paramInt1 >= 0) && (localBitMatrix.a(paramInt3, paramInt1)))
    {
      arrayOfInt[2] += 1;
      paramInt3 += 1;
      paramInt1 -= 1;
    }
    if (paramInt3 != m)
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= 0) {}
    }
    else
    {
      return false;
    }
    while ((paramInt3 < m) && (paramInt2 >= 0) && (!localBitMatrix.a(paramInt3, paramInt2)) && (arrayOfInt[3] < k))
    {
      arrayOfInt[3] += 1;
      paramInt3 += 1;
      paramInt2 -= 1;
    }
    if ((paramInt3 == m) || (paramInt2 < 0) || (arrayOfInt[3] >= k)) {
      return false;
    }
    while ((paramInt3 < m) && (paramInt2 >= 0) && (localBitMatrix.a(paramInt3, paramInt2)) && (arrayOfInt[4] < k))
    {
      arrayOfInt[4] += 1;
      paramInt3 += 1;
      paramInt2 -= 1;
    }
    if (arrayOfInt[4] >= k) {
      return false;
    }
    if (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 2 >= paramInt4) {
      return false;
    }
    return a(arrayOfInt);
  }
  
  protected static boolean a(int[] paramArrayOfInt)
  {
    boolean bool = true;
    int i = 0;
    int j = 0;
    if (i < 5)
    {
      k = paramArrayOfInt[i];
      if (k != 0) {}
    }
    while (j < 7)
    {
      int k;
      return false;
      j += k;
      i += 1;
      break;
    }
    i = (j << 8) / 7;
    j = i / 2;
    if ((Math.abs(i - (paramArrayOfInt[0] << 8)) < j) && (Math.abs(i - (paramArrayOfInt[1] << 8)) < j) && (Math.abs(i * 3 - (paramArrayOfInt[2] << 8)) < j * 3) && (Math.abs(i - (paramArrayOfInt[3] << 8)) < j) && (Math.abs(i - (paramArrayOfInt[4] << 8)) < j)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private int[] a()
  {
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    this.jdField_a_of_type_ArrayOfInt[1] = 0;
    this.jdField_a_of_type_ArrayOfInt[2] = 0;
    this.jdField_a_of_type_ArrayOfInt[3] = 0;
    this.jdField_a_of_type_ArrayOfInt[4] = 0;
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  private FinderPattern[] a()
  {
    float f3 = 0.0F;
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i < 3) {
      throw ReaderException.getInstance();
    }
    Iterator localIterator;
    float f1;
    if (i > 3)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      f1 = 0.0F;
      float f2 = 0.0F;
      while (localIterator.hasNext())
      {
        float f4 = ((FinderPattern)localIterator.next()).c();
        f2 += f4;
        f1 = f4 * f4 + f1;
      }
      f2 /= i;
      f1 = (float)Math.sqrt(f1 / i - f2 * f2);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new FinderPatternFinder.FurthestFromAverageComparator(f2, null));
      f1 = Math.max(0.2F * f2, f1);
      int j;
      for (i = 0; (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.size() > 3); i = j + 1)
      {
        j = i;
        if (Math.abs(((FinderPattern)this.jdField_a_of_type_JavaUtilList.get(i)).c() - f2) > f1)
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          j = i - 1;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (f1 = f3; localIterator.hasNext(); f1 += ((FinderPattern)localIterator.next()).c()) {}
      f1 /= this.jdField_a_of_type_JavaUtilList.size();
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new FinderPatternFinder.CenterComparator(f1, null));
      this.jdField_a_of_type_JavaUtilList.subList(3, this.jdField_a_of_type_JavaUtilList.size()).clear();
    }
    return new FinderPattern[] { (FinderPattern)this.jdField_a_of_type_JavaUtilList.get(0), (FinderPattern)this.jdField_a_of_type_JavaUtilList.get(1), (FinderPattern)this.jdField_a_of_type_JavaUtilList.get(2) };
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
    int k = localBitMatrix.a();
    int[] arrayOfInt = a();
    int i = paramInt1;
    while ((i >= 0) && (localBitMatrix.a(i, paramInt2)))
    {
      arrayOfInt[2] += 1;
      i -= 1;
    }
    int j = i;
    if (i < 0) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.a(j, paramInt2)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] += 1;
                j -= 1;
              }
            } while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.a(j, paramInt2)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] += 1;
              j -= 1;
            }
          } while (arrayOfInt[0] > paramInt3);
          paramInt1 += 1;
          while ((paramInt1 < k) && (localBitMatrix.a(paramInt1, paramInt2)))
          {
            arrayOfInt[2] += 1;
            paramInt1 += 1;
          }
        } while (paramInt1 == k);
        while ((paramInt1 < k) && (!localBitMatrix.a(paramInt1, paramInt2)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] += 1;
          paramInt1 += 1;
        }
      } while ((paramInt1 == k) || (arrayOfInt[3] >= paramInt3));
      while ((paramInt1 < k) && (localBitMatrix.a(paramInt1, paramInt2)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] += 1;
        paramInt1 += 1;
      }
    } while ((arrayOfInt[4] >= paramInt3) || (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4) || (!a(arrayOfInt)));
    return a(arrayOfInt, paramInt1);
  }
  
  private boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = (int)Math.round(paramInt3 * 1.5D);
    BitMatrix localBitMatrix = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
    int m = localBitMatrix.a();
    int n = localBitMatrix.b();
    int[] arrayOfInt = a();
    paramInt3 = paramInt1;
    int j = paramInt2;
    while ((j >= 0) && (paramInt3 >= 0) && (localBitMatrix.a(j, paramInt3)))
    {
      arrayOfInt[2] += 1;
      j -= 1;
      paramInt3 -= 1;
    }
    int i;
    if (j >= 0)
    {
      i = paramInt3;
      if (paramInt3 >= 0) {}
    }
    else
    {
      return false;
    }
    while ((j >= 0) && (i >= 0) && (!localBitMatrix.a(j, i)) && (arrayOfInt[1] <= k))
    {
      arrayOfInt[1] += 1;
      j -= 1;
      i -= 1;
    }
    if ((j < 0) || (i < 0) || (arrayOfInt[1] > k)) {
      return false;
    }
    while ((j >= 0) && (i >= 0) && (localBitMatrix.a(j, i)) && (arrayOfInt[0] <= k))
    {
      arrayOfInt[0] += 1;
      j -= 1;
      i -= 1;
    }
    if (arrayOfInt[0] > k) {
      return false;
    }
    paramInt3 = paramInt2 + 1;
    paramInt1 += 1;
    while ((paramInt3 < m) && (paramInt1 < n) && (localBitMatrix.a(paramInt3, paramInt1)))
    {
      arrayOfInt[2] += 1;
      paramInt3 += 1;
      paramInt1 += 1;
    }
    if (paramInt3 != m)
    {
      paramInt2 = paramInt1;
      if (paramInt1 != n) {}
    }
    else
    {
      return false;
    }
    while ((paramInt3 < m) && (paramInt2 < n) && (!localBitMatrix.a(paramInt3, paramInt2)) && (arrayOfInt[3] < k))
    {
      arrayOfInt[3] += 1;
      paramInt3 += 1;
      paramInt2 += 1;
    }
    if ((paramInt3 == m) || (paramInt2 == n) || (arrayOfInt[3] >= k)) {
      return false;
    }
    while ((paramInt3 < m) && (paramInt2 < n) && (localBitMatrix.a(paramInt3, paramInt2)) && (arrayOfInt[4] < k))
    {
      arrayOfInt[4] += 1;
      paramInt3 += 1;
      paramInt2 += 1;
    }
    if (arrayOfInt[4] >= k) {
      return false;
    }
    if (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 2 >= paramInt4) {
      return false;
    }
    return a(arrayOfInt);
  }
  
  protected final BitMatrix a()
  {
    return this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  }
  
  final FinderPatternInfo a(Map paramMap)
  {
    boolean bool3;
    int i2;
    boolean bool1;
    int k;
    int n;
    int j;
    int m;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      bool3 = true;
      int i1 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b();
      i2 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
      i = i1 * 3 / 228;
      if ((i < 3) || (bool3)) {
        i = 3;
      }
      bool1 = false;
      paramMap = new int[5];
      k = i - 1;
      if ((k >= i1) || (bool1)) {
        break label442;
      }
      paramMap[0] = 0;
      paramMap[1] = 0;
      paramMap[2] = 0;
      paramMap[3] = 0;
      paramMap[4] = 0;
      n = 0;
      j = 0;
      m = i;
      i = n;
      label113:
      if (j >= i2) {
        break label369;
      }
      if (!this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(j, k)) {
        break label173;
      }
      n = i;
      if ((i & 0x1) == 1) {
        n = i + 1;
      }
      paramMap[n] += 1;
    }
    for (int i = n;; i = 0)
    {
      label160:
      j += 1;
      break label113;
      bool3 = false;
      break;
      label173:
      if ((i & 0x1) != 0) {
        break label358;
      }
      if (i != 4) {
        break label343;
      }
      if (!a(paramMap)) {
        break label312;
      }
      if (!a(paramMap, k, j, bool3)) {
        break label281;
      }
      m = 2;
      if (!this.jdField_a_of_type_Boolean) {
        break label245;
      }
      bool1 = a();
      label220:
      paramMap[0] = 0;
      paramMap[1] = 0;
      paramMap[2] = 0;
      paramMap[3] = 0;
      paramMap[4] = 0;
    }
    label245:
    i = a();
    if (i > paramMap[2])
    {
      j = k + (i - paramMap[2] - 2);
      i = i2 - 1;
    }
    for (;;)
    {
      k = j;
      j = i;
      break label220;
      label281:
      paramMap[0] = paramMap[2];
      paramMap[1] = paramMap[3];
      paramMap[2] = paramMap[4];
      paramMap[3] = 1;
      paramMap[4] = 0;
      i = 3;
      break label160;
      label312:
      paramMap[0] = paramMap[2];
      paramMap[1] = paramMap[3];
      paramMap[2] = paramMap[4];
      paramMap[3] = 1;
      paramMap[4] = 0;
      i = 3;
      break label160;
      label343:
      i += 1;
      paramMap[i] += 1;
      break label160;
      label358:
      paramMap[i] += 1;
      break label160;
      label369:
      boolean bool2 = bool1;
      i = m;
      if (a(paramMap))
      {
        bool2 = bool1;
        i = m;
        if (a(paramMap, k, i2, bool3))
        {
          j = paramMap[0];
          bool2 = bool1;
          i = j;
          if (this.jdField_a_of_type_Boolean)
          {
            bool2 = a();
            i = j;
          }
        }
      }
      k += i;
      bool1 = bool2;
      break;
      label442:
      paramMap = a();
      ResultPoint.a(paramMap);
      return new FinderPatternInfo(paramMap);
      i = j;
      j = k;
    }
  }
  
  protected final List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected final boolean a(int[] paramArrayOfInt, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    int j = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] + paramArrayOfInt[3] + paramArrayOfInt[4];
    float f2 = a(paramArrayOfInt, paramInt2);
    float f1 = a(paramInt1, (int)f2, paramArrayOfInt[2], j);
    if (!Float.isNaN(f1))
    {
      f2 = b((int)f2, (int)f1, paramArrayOfInt[2], j);
      if ((!Float.isNaN(f2)) && ((!paramBoolean) || ((a((int)f1, (int)f2, paramArrayOfInt[2], j)) && (b((int)f1, (int)f2, paramArrayOfInt[2], j))))) {}
    }
    else
    {
      return false;
    }
    float f3 = j / 7.0F;
    paramInt1 = 0;
    for (;;)
    {
      paramInt2 = i;
      if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramArrayOfInt = (FinderPattern)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        if (paramArrayOfInt.a(f3, f1, f2))
        {
          this.jdField_a_of_type_JavaUtilList.set(paramInt1, paramArrayOfInt.a(f1, f2, f3));
          paramInt2 = 1;
        }
      }
      else
      {
        if (paramInt2 == 0)
        {
          paramArrayOfInt = new FinderPattern(f2, f1, f3);
          this.jdField_a_of_type_JavaUtilList.add(paramArrayOfInt);
          if (this.jdField_a_of_type_ComGoogleZxingResultPointCallback != null) {
            this.jdField_a_of_type_ComGoogleZxingResultPointCallback.a(paramArrayOfInt);
          }
        }
        return true;
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder
 * JD-Core Version:    0.7.0.1
 */