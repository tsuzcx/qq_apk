package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.BarcodeFormat;
import com.tencent.mobileqq.mini.zxing.BinaryBitmap;
import com.tencent.mobileqq.mini.zxing.ChecksumException;
import com.tencent.mobileqq.mini.zxing.DecodeHintType;
import com.tencent.mobileqq.mini.zxing.FormatException;
import com.tencent.mobileqq.mini.zxing.NotFoundException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader
  extends UPCEANReader
{
  private final UPCEANReader ean13Reader = new EAN13Reader();
  
  private static Result maybeReturnResult(Result paramResult)
    throws FormatException
  {
    Object localObject = paramResult.getText();
    if (((String)localObject).charAt(0) == '0')
    {
      localObject = new Result(((String)localObject).substring(1), null, paramResult.getResultPoints(), BarcodeFormat.UPC_A);
      if (paramResult.getResultMetadata() != null) {
        ((Result)localObject).putAllMetadata(paramResult.getResultMetadata());
      }
      return localObject;
    }
    throw FormatException.getFormatInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap)
    throws NotFoundException, FormatException
  {
    return maybeReturnResult(this.ean13Reader.decode(paramBinaryBitmap));
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException
  {
    return maybeReturnResult(this.ean13Reader.decode(paramBinaryBitmap, paramMap));
  }
  
  protected int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
    throws NotFoundException
  {
    return this.ean13Reader.decodeMiddle(paramBitArray, paramArrayOfInt, paramStringBuilder);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException, ChecksumException
  {
    return maybeReturnResult(this.ean13Reader.decodeRow(paramInt, paramBitArray, paramMap));
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
    throws NotFoundException, FormatException, ChecksumException
  {
    return maybeReturnResult(this.ean13Reader.decodeRow(paramInt, paramBitArray, paramArrayOfInt, paramMap));
  }
  
  BarcodeFormat getBarcodeFormat()
  {
    return BarcodeFormat.UPC_A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCAReader
 * JD-Core Version:    0.7.0.1
 */