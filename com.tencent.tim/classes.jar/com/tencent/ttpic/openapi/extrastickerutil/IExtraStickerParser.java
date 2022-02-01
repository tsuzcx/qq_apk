package com.tencent.ttpic.openapi.extrastickerutil;

import android.graphics.Bitmap;
import android.opengl.EGLContext;

public abstract interface IExtraStickerParser
{
  public static final int RESULT_AS_BITMAP = 1;
  public static final int RESULT_AS_TEXTURE = 2;
  
  public abstract boolean clear();
  
  public abstract int getResultType();
  
  public abstract void initInGLThread(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean prepare(String paramString1, String paramString2);
  
  public abstract void reset();
  
  public abstract boolean setSize(int paramInt1, int paramInt2);
  
  public abstract Bitmap updateBitmap(float paramFloat);
  
  public abstract int updateTexture(int paramInt, float paramFloat, EGLContext paramEGLContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.extrastickerutil.IExtraStickerParser
 * JD-Core Version:    0.7.0.1
 */