package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract interface Writer
{
  public abstract BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2);
  
  public abstract BitMatrix a(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.Writer
 * JD-Core Version:    0.7.0.1
 */