package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.Map;

public class QRCodeReader
  implements Reader
{
  private static final ResultPoint[] jdField_a_of_type_ArrayOfComGoogleZxingResultPoint = new ResultPoint[0];
  private final Decoder jdField_a_of_type_ComGoogleZxingQrcodeDecoderDecoder = new Decoder();
  
  private static float a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int m = paramBitMatrix.b();
    int n = paramBitMatrix.a();
    int j = paramArrayOfInt[0];
    int i = paramArrayOfInt[1];
    int i1 = 1;
    int k = 0;
    if ((j < n) && (i < m))
    {
      if (i1 == paramBitMatrix.a(j, i)) {
        break label112;
      }
      k += 1;
      if (k != 5) {}
    }
    else
    {
      if ((j != n) && (i != m)) {
        break label102;
      }
      throw ReaderException.getInstance();
    }
    if (i1 == 0) {
      i1 = 1;
    }
    label102:
    label112:
    for (;;)
    {
      j += 1;
      i += 1;
      break;
      i1 = 0;
      continue;
      return (j - paramArrayOfInt[0]) / 7.0F;
    }
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    Object localObject = paramBitMatrix.b();
    int[] arrayOfInt = paramBitMatrix.c();
    if ((localObject == null) || (arrayOfInt == null)) {
      throw ReaderException.getInstance();
    }
    float f = a((int[])localObject, paramBitMatrix);
    int k = localObject[1];
    int i1 = arrayOfInt[1];
    int m = localObject[0];
    int j = arrayOfInt[0];
    int i = j;
    if (i1 - k != j - m) {
      i = i1 - k + m;
    }
    int n = Math.round((i - m + 1) / f);
    i1 = Math.round((i1 - k + 1) / f);
    if ((n <= 0) || (i1 <= 0)) {
      throw ReaderException.getInstance();
    }
    if (i1 != n) {
      throw ReaderException.getInstance();
    }
    int i2 = (int)(f / 2.0F);
    localObject = new BitMatrix(n, i1);
    i = 0;
    while (i < i1)
    {
      int i3 = (int)(i * f);
      j = 0;
      while (j < n)
      {
        if (paramBitMatrix.a((int)(j * f) + (m + i2), k + i2 + i3)) {
          ((BitMatrix)localObject).a(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return localObject;
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap)
  {
    return a(paramBinaryBitmap, null);
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      paramBinaryBitmap = a(paramBinaryBitmap.a());
      paramBinaryBitmap = this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderDecoder.a(paramBinaryBitmap, paramMap);
    }
    Object localObject;
    for (paramMap = jdField_a_of_type_ArrayOfComGoogleZxingResultPoint;; paramMap = ((DetectorResult)localObject).a())
    {
      paramMap = new Result(paramBinaryBitmap.a(), paramBinaryBitmap.a(), paramMap, BarcodeFormat.QR_CODE);
      localObject = paramBinaryBitmap.a();
      if (localObject != null) {
        paramMap.a(ResultMetadataType.BYTE_SEGMENTS, localObject);
      }
      paramBinaryBitmap = paramBinaryBitmap.b();
      if (paramBinaryBitmap != null) {
        paramMap.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, paramBinaryBitmap);
      }
      return paramMap;
      localObject = new Detector(paramBinaryBitmap.a()).a(paramMap);
      paramBinaryBitmap = this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderDecoder.a(((DetectorResult)localObject).a(), paramMap);
    }
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeReader
 * JD-Core Version:    0.7.0.1
 */