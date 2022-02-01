package com.tencent.TMG.opengl.texture;

import android.graphics.Bitmap;
import junit.framework.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap mContentBitmap;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContentBitmap = paramBitmap;
      return;
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mContentBitmap;
  }
  
  protected void onFreeBitmap(Bitmap paramBitmap) {}
  
  protected Bitmap onGetBitmap()
  {
    return this.mContentBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.BitmapTexture
 * JD-Core Version:    0.7.0.1
 */