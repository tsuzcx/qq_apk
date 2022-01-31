package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;

public class BitmapCreatorGetter
{
  BitmapCreator a;
  
  public BitmapCreator a()
  {
    return this.a;
  }
  
  public void a(BitmapCreator paramBitmapCreator)
  {
    this.a = paramBitmapCreator;
  }
  
  protected Bitmap b(Bitmap paramBitmap)
  {
    if (this.a == null) {
      return paramBitmap;
    }
    return this.a.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.BitmapCreatorGetter
 * JD-Core Version:    0.7.0.1
 */