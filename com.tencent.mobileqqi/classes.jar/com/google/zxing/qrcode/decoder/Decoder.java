package com.google.zxing.qrcode.decoder;

import com.google.zxing.ReaderException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import fq;
import fr;
import gc;
import gd;
import java.util.Map;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.e);
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    i = paramArrayOfByte.length;
    try
    {
      this.a.a(arrayOfInt, i - paramInt);
      i = j;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i += 1;
      }
      return;
    }
    catch (ReedSolomonException paramArrayOfByte)
    {
      throw ReaderException.getInstance();
    }
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix)
  {
    return a(paramBitMatrix, null);
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix, Map paramMap)
  {
    Object localObject1 = new fq(paramBitMatrix);
    paramBitMatrix = ((fq)localObject1).a();
    ErrorCorrectionLevel localErrorCorrectionLevel = ((fq)localObject1).a().a();
    localObject1 = fr.a(((fq)localObject1).a(), paramBitMatrix, localErrorCorrectionLevel);
    int k = localObject1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject1[i].a();
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    int m = localObject1.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      Object localObject2 = localObject1[j];
      byte[] arrayOfByte2 = localObject2.a();
      int n = localObject2.a();
      a(arrayOfByte2, n);
      k = 0;
      while (k < n)
      {
        arrayOfByte1[i] = arrayOfByte2[k];
        k += 1;
        i += 1;
      }
      j += 1;
    }
    return gc.a(arrayOfByte1, paramBitMatrix, localErrorCorrectionLevel, paramMap);
  }
  
  public DecoderResult a(boolean[][] paramArrayOfBoolean)
  {
    return a(paramArrayOfBoolean, null);
  }
  
  public DecoderResult a(boolean[][] paramArrayOfBoolean, Map paramMap)
  {
    int k = paramArrayOfBoolean.length;
    BitMatrix localBitMatrix = new BitMatrix(k);
    int i = 0;
    while (i < k)
    {
      int j = 0;
      while (j < k)
      {
        if (paramArrayOfBoolean[i][j] != 0) {
          localBitMatrix.a(j, i);
        }
        j += 1;
      }
      i += 1;
    }
    return a(localBitMatrix, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Decoder
 * JD-Core Version:    0.7.0.1
 */