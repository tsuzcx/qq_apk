package com.tencent.ditto.utils;

import android.graphics.Bitmap;

public class DittoBitmapCache
{
  private Bitmap mBitmap;
  
  protected void finalize()
    throws Throwable
  {
    this.mBitmap = null;
    super.finalize();
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (this.mBitmap != null) {
      throw new RuntimeException("delicately set bitmap");
    }
    this.mBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.utils.DittoBitmapCache
 * JD-Core Version:    0.7.0.1
 */