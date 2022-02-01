package com.tencent.mobileqq.triton.font;

import android.graphics.Bitmap;
import com.tencent.mobileqq.triton.jni.TTNativeCall;

public class FontBitmap
{
  @TTNativeCall
  public float ascent;
  @TTNativeCall
  public Bitmap bitmap;
  @TTNativeCall
  public float descent;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.FontBitmap
 * JD-Core Version:    0.7.0.1
 */