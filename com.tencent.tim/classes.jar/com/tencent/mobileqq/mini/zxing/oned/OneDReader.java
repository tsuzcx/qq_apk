package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Reader;
import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.ResultMetadataType;
import com.tencent.mobileqq.mini.zxing.ResultPoint;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map<Lcom.tencent.mobileqq.mini.zxing.DecodeHintType;*>;

public abstract class OneDReader
  implements Reader
{
  private Result doDecode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException
  {
    int i1 = paramBinaryBitmap.getWidth();
    int m = paramBinaryBitmap.getHeight();
    Object localObject1 = new BitArray(i1);
    int i;
    int j;
    label49:
    int i2;
    label67:
    int i3;
    int n;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      if (i == 0) {
        break label140;
      }
      j = 8;
      i2 = Math.max(1, m >> j);
      if (i == 0) {
        break label146;
      }
      i = m;
      i3 = m / 2;
      j = 0;
      if (j < i)
      {
        n = (j + 1) / 2;
        if ((j & 0x1) != 0) {
          break label152;
        }
        k = 1;
        label100:
        if (k == 0) {
          break label158;
        }
      }
    }
    label140:
    label146:
    label152:
    label158:
    for (int k = n;; k = -n)
    {
      n = i3 + k * i2;
      if ((n >= 0) && (n < m)) {
        break label166;
      }
      throw NotFoundException.getNotFoundInstance();
      i = 0;
      break;
      j = 5;
      break label49;
      i = 15;
      break label67;
      k = 0;
      break label100;
    }
    label398:
    for (;;)
    {
      try
      {
        label166:
        Object localObject2 = paramBinaryBitmap.getBlackRow(n, (BitArray)localObject1);
        localObject1 = localObject2;
        k = 0;
        localObject3 = localObject1;
        localObject2 = paramMap;
        if (k < 2)
        {
          if (k != 1) {
            break label398;
          }
          ((BitArray)localObject1).reverse();
          if ((paramMap == null) || (!paramMap.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK))) {
            break label398;
          }
          localObject2 = new HashMap();
          ((Map)localObject2).putAll(paramMap);
          ((Map)localObject2).remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
          paramMap = (Map<DecodeHintType, ?>)localObject2;
          try
          {
            localObject2 = decodeRow(n, (BitArray)localObject1, paramMap);
            if (k == 1)
            {
              ((Result)localObject2).putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
              localObject3 = ((Result)localObject2).getResultPoints();
              if (localObject3 != null)
              {
                localObject3[0] = new ResultPoint(i1 - localObject3[0].getX() - 1.0F, localObject3[0].getY());
                localObject3[1] = new ResultPoint(i1 - localObject3[1].getX() - 1.0F, localObject3[1].getY());
              }
            }
            return localObject2;
          }
          catch (ReaderException localReaderException)
          {
            k += 1;
          }
        }
      }
      catch (NotFoundException localNotFoundException)
      {
        Map<DecodeHintType, ?> localMap = paramMap;
        Object localObject3 = localObject1;
        j += 1;
        localObject1 = localObject3;
        paramMap = localMap;
      }
    }
  }
  
  protected static float patternMatchVariance(int[] paramArrayOfInt1, int[] paramArrayOfInt2, float paramFloat)
  {
    int m = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < m)
    {
      i += paramArrayOfInt1[j];
      k += paramArrayOfInt2[j];
      j += 1;
    }
    if (i < k) {}
    float f1;
    label144:
    for (;;)
    {
      return (1.0F / 1.0F);
      float f3 = i / k;
      f1 = 0.0F;
      j = 0;
      if (j >= m) {
        break;
      }
      k = paramArrayOfInt1[j];
      float f2 = paramArrayOfInt2[j] * f3;
      if (k > f2) {}
      for (f2 = k - f2;; f2 -= k)
      {
        if (f2 > paramFloat * f3) {
          break label144;
        }
        f1 += f2;
        j += 1;
        break;
      }
    }
    return f1 / i;
  }
  
  protected static void recordPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
    throws NotFoundException
  {
    int k = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, k, 0);
    int m = paramBitArray.getSize();
    if (paramInt >= m) {
      throw NotFoundException.getNotFoundInstance();
    }
    if (!paramBitArray.get(paramInt)) {}
    int i;
    for (int n = 1;; n = 0)
    {
      int j = 0;
      i = paramInt;
      paramInt = j;
      for (;;)
      {
        if (i >= m) {
          break label140;
        }
        if (paramBitArray.get(i) == n) {
          break;
        }
        paramArrayOfInt[paramInt] += 1;
        i += 1;
      }
    }
    paramInt += 1;
    if (paramInt == k) {}
    label140:
    for (;;)
    {
      if ((paramInt != k) && ((paramInt != k - 1) || (i != m)))
      {
        throw NotFoundException.getNotFoundInstance();
        paramArrayOfInt[paramInt] = 1;
        if (n == 0) {}
        for (n = 1;; n = 0) {
          break;
        }
      }
      return;
    }
  }
  
  protected static void recordPatternInReverse(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
    throws NotFoundException
  {
    int i = paramArrayOfInt.length;
    boolean bool = paramBitArray.get(paramInt);
    while ((paramInt > 0) && (i >= 0))
    {
      int j = paramInt - 1;
      paramInt = j;
      if (paramBitArray.get(j) != bool)
      {
        i -= 1;
        if (!bool)
        {
          bool = true;
          paramInt = j;
        }
        else
        {
          bool = false;
          paramInt = j;
        }
      }
    }
    if (i >= 0) {
      throw NotFoundException.getNotFoundInstance();
    }
    recordPattern(paramBitArray, paramInt + 1, paramArrayOfInt);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, FormatException
  {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException
  {
    try
    {
      Result localResult = doDecode(paramBinaryBitmap, paramMap);
      return localResult;
    }
    catch (NotFoundException localNotFoundException)
    {
      if (paramMap == null) {
        break label178;
      }
    }
    Object localObject;
    if (paramMap.containsKey(DecodeHintType.TRY_HARDER))
    {
      i = 1;
      if ((i == 0) || (!paramBinaryBitmap.isRotateSupported())) {
        break label185;
      }
      paramBinaryBitmap = paramBinaryBitmap.rotateCounterClockwise();
      paramMap = doDecode(paramBinaryBitmap, paramMap);
      localObject = paramMap.getResultMetadata();
      if ((localObject == null) || (!((Map)localObject).containsKey(ResultMetadataType.ORIENTATION))) {
        break label188;
      }
    }
    label178:
    label185:
    label188:
    for (int i = (((Integer)((Map)localObject).get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;; i = 270)
    {
      paramMap.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
      localObject = paramMap.getResultPoints();
      if (localObject != null)
      {
        int j = paramBinaryBitmap.getHeight();
        i = 0;
        for (;;)
        {
          if (i < localObject.length)
          {
            localObject[i] = new ResultPoint(j - localObject[i].getY() - 1.0F, localObject[i].getX());
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
      }
      return paramMap;
      throw ((Throwable)localObject);
    }
  }
  
  public abstract Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, ChecksumException, FormatException;
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.OneDReader
 * JD-Core Version:    0.7.0.1
 */