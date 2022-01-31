package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import ge;
import java.util.Map;

public class Detector
{
  private ResultPointCallback jdField_a_of_type_ComGoogleZxingResultPointCallback;
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  
  public Detector(BitMatrix paramBitMatrix)
  {
    this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramBitMatrix;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    float f2 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = paramInt1 - (paramInt3 - paramInt1);
    float f1;
    if (paramInt3 < 0)
    {
      f1 = paramInt1 / (paramInt1 - paramInt3);
      paramInt3 = 0;
    }
    for (;;)
    {
      paramInt4 = (int)(paramInt2 - f1 * (paramInt4 - paramInt2));
      if (paramInt4 < 0)
      {
        f1 = paramInt2 / (paramInt2 - paramInt4);
        paramInt4 = i;
      }
      for (;;)
      {
        float f3 = paramInt1;
        return b(paramInt1, paramInt2, (int)(f1 * (paramInt3 - paramInt1) + f3), paramInt4) + f2 - 1.0F;
        if (paramInt3 < this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a()) {
          break label194;
        }
        f1 = (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a() - 1 - paramInt1) / (paramInt3 - paramInt1);
        paramInt3 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
        paramInt3 -= 1;
        break;
        if (paramInt4 >= this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b())
        {
          f1 = (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b() - 1 - paramInt2) / (paramInt4 - paramInt2);
          paramInt4 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b() - 1;
        }
        else
        {
          f1 = 1.0F;
        }
      }
      label194:
      f1 = 1.0F;
    }
  }
  
  private float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    float f1 = a((int)paramResultPoint1.a(), (int)paramResultPoint1.b(), (int)paramResultPoint2.a(), (int)paramResultPoint2.b());
    float f2 = a((int)paramResultPoint2.a(), (int)paramResultPoint2.b(), (int)paramResultPoint1.a(), (int)paramResultPoint1.b());
    if (Float.isNaN(f1)) {
      return f2 / 7.0F;
    }
    if (Float.isNaN(f2)) {
      return f1 / 7.0F;
    }
    return (f1 + f2) / 14.0F;
  }
  
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat)
  {
    int i = (MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint2) / paramFloat) + MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint3) / paramFloat) >> 1) + 7;
    switch (i & 0x3)
    {
    case 1: 
    default: 
      return i;
    case 0: 
      return i + 1;
    case 2: 
      return i - 1;
    }
    throw ReaderException.getInstance();
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt)
  {
    return GridSampler.a().a(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }
  
  private static PerspectiveTransform a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f1 = paramInt - 3.5F;
    float f4;
    float f5;
    float f3;
    if (paramResultPoint4 != null)
    {
      f4 = paramResultPoint4.a();
      f5 = paramResultPoint4.b();
      f3 = f1 - 3.0F;
    }
    for (float f2 = f3;; f2 = f1)
    {
      return PerspectiveTransform.a(3.5F, 3.5F, f1, 3.5F, f2, f3, 3.5F, f1, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint2.a(), paramResultPoint2.b(), f4, f5, paramResultPoint3.a(), paramResultPoint3.b());
      f4 = paramResultPoint2.a() - paramResultPoint1.a() + paramResultPoint3.a();
      f5 = paramResultPoint2.b() - paramResultPoint1.b() + paramResultPoint3.b();
      f3 = f1;
    }
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k;
    int n;
    int m;
    int i;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1))
    {
      k = 1;
      if (k == 0) {
        break label268;
      }
      n = paramInt4;
      m = paramInt3;
      i = paramInt2;
      paramInt4 = paramInt1;
    }
    for (;;)
    {
      int i5 = Math.abs(n - i);
      int i6 = Math.abs(m - paramInt4);
      paramInt1 = -i5;
      int i1;
      label71:
      int i2;
      label81:
      int j;
      int i3;
      label111:
      int i4;
      label119:
      int i7;
      if (i < n)
      {
        i1 = 1;
        if (paramInt4 >= m) {
          break label170;
        }
        i2 = 1;
        paramInt3 = 0;
        paramInt2 = i;
        j = paramInt1 >> 1;
        paramInt1 = paramInt4;
        if (paramInt2 == n + i1) {
          break label265;
        }
        if (k == 0) {
          break label176;
        }
        i3 = paramInt1;
        if (k == 0) {
          break label182;
        }
        i4 = paramInt2;
        if (paramInt3 != 1) {
          break label188;
        }
        i7 = 1;
      }
      for (;;)
      {
        if (i7 == this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i3, i4))
        {
          if (paramInt3 == 2)
          {
            return MathUtils.a(paramInt2, paramInt1, i, paramInt4);
            k = 0;
            break;
            i1 = -1;
            break label71;
            label170:
            i2 = -1;
            break label81;
            label176:
            i3 = paramInt2;
            break label111;
            label182:
            i4 = paramInt1;
            break label119;
            label188:
            i7 = 0;
            continue;
          }
          paramInt3 += 1;
          label198:
          j += i6;
          if (j > 0) {
            if (paramInt1 != m) {}
          }
        }
      }
      label265:
      for (;;)
      {
        if (paramInt3 == 2)
        {
          return MathUtils.a(n + i1, m, i, paramInt4);
          paramInt1 += i2;
          j -= i5;
        }
        for (;;)
        {
          paramInt2 += i1;
          break;
          return (0.0F / 0.0F);
        }
        break label198;
      }
      label268:
      m = paramInt4;
      paramInt4 = paramInt2;
      i = paramInt1;
      n = paramInt3;
    }
  }
  
  protected final float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    return (a(paramResultPoint1, paramResultPoint2) + a(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }
  
  protected final ResultPointCallback a()
  {
    return this.jdField_a_of_type_ComGoogleZxingResultPointCallback;
  }
  
  protected final BitMatrix a()
  {
    return this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  }
  
  public DetectorResult a()
  {
    return a(null);
  }
  
  protected final DetectorResult a(FinderPatternInfo paramFinderPatternInfo)
  {
    FinderPattern localFinderPattern1 = paramFinderPatternInfo.b();
    FinderPattern localFinderPattern2 = paramFinderPatternInfo.c();
    FinderPattern localFinderPattern3 = paramFinderPatternInfo.a();
    float f1 = a(localFinderPattern1, localFinderPattern2, localFinderPattern3);
    if (f1 < 1.0F) {
      throw ReaderException.getInstance();
    }
    int j = a(localFinderPattern1, localFinderPattern2, localFinderPattern3, f1);
    Version localVersion = Version.a(j);
    int i = localVersion.c();
    Object localObject = null;
    paramFinderPatternInfo = (FinderPatternInfo)localObject;
    float f2;
    int k;
    int m;
    if (localVersion.a().length > 0)
    {
      f2 = localFinderPattern2.a();
      float f3 = localFinderPattern1.a();
      float f4 = localFinderPattern3.a();
      float f5 = localFinderPattern2.b();
      float f6 = localFinderPattern1.b();
      float f7 = localFinderPattern3.b();
      float f8 = 1.0F - 3.0F / (i - 7);
      float f9 = localFinderPattern1.a();
      k = (int)((f2 - f3 + f4 - localFinderPattern1.a()) * f8 + f9);
      m = (int)(localFinderPattern1.b() + f8 * (f5 - f6 + f7 - localFinderPattern1.b()));
      i = 4;
      paramFinderPatternInfo = (FinderPatternInfo)localObject;
      if (i <= 16) {
        f2 = i;
      }
    }
    for (;;)
    {
      try
      {
        paramFinderPatternInfo = a(f1, k, m, f2);
        localObject = a(localFinderPattern1, localFinderPattern2, localFinderPattern3, paramFinderPatternInfo, j);
        localObject = a(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix, (PerspectiveTransform)localObject, j);
        if (paramFinderPatternInfo != null) {
          break label289;
        }
        paramFinderPatternInfo = new ResultPoint[3];
        paramFinderPatternInfo[0] = localFinderPattern3;
        paramFinderPatternInfo[1] = localFinderPattern1;
        paramFinderPatternInfo[2] = localFinderPattern2;
        return new DetectorResult((BitMatrix)localObject, paramFinderPatternInfo);
      }
      catch (ReaderException paramFinderPatternInfo)
      {
        i <<= 1;
      }
      break;
      label289:
      paramFinderPatternInfo = new ResultPoint[] { localFinderPattern3, localFinderPattern1, localFinderPattern2, paramFinderPatternInfo };
    }
  }
  
  public final DetectorResult a(Map paramMap)
  {
    if (paramMap == null) {}
    for (ResultPointCallback localResultPointCallback = null;; localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
    {
      this.jdField_a_of_type_ComGoogleZxingResultPointCallback = localResultPointCallback;
      return a(new FinderPatternFinder(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix, this.jdField_a_of_type_ComGoogleZxingResultPointCallback).a(paramMap));
    }
  }
  
  protected final AlignmentPattern a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
  {
    int j = (int)(paramFloat2 * paramFloat1);
    int i = Math.max(0, paramInt1 - j);
    paramInt1 = Math.min(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a() - 1, paramInt1 + j);
    if (paramInt1 - i < paramFloat1 * 3.0F) {
      throw ReaderException.getInstance();
    }
    int k = Math.max(0, paramInt2 - j);
    paramInt2 = Math.min(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b() - 1, j + paramInt2);
    if (paramInt2 - k < paramFloat1 * 3.0F) {
      throw ReaderException.getInstance();
    }
    return new ge(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix, i, k, paramInt1 - i, paramInt2 - k, paramFloat1, this.jdField_a_of_type_ComGoogleZxingResultPointCallback).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.Detector
 * JD-Core Version:    0.7.0.1
 */