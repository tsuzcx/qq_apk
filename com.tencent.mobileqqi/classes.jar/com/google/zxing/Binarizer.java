package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
  private final LuminanceSource a;
  
  public Binarizer(LuminanceSource paramLuminanceSource)
  {
    this.a = paramLuminanceSource;
  }
  
  public final int a()
  {
    return this.a.a();
  }
  
  public abstract Binarizer a(LuminanceSource paramLuminanceSource);
  
  public final LuminanceSource a()
  {
    return this.a;
  }
  
  public abstract BitArray a(int paramInt, BitArray paramBitArray);
  
  public abstract BitMatrix a();
  
  public final int b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.Binarizer
 * JD-Core Version:    0.7.0.1
 */