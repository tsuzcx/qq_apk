package com.google.zxing;

import java.util.Map;

public abstract interface Reader
{
  public abstract Result a(BinaryBitmap paramBinaryBitmap);
  
  public abstract Result a(BinaryBitmap paramBinaryBitmap, Map paramMap);
  
  public abstract void a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.Reader
 * JD-Core Version:    0.7.0.1
 */