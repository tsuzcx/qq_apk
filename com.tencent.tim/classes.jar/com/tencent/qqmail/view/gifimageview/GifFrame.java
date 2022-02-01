package com.tencent.qqmail.view.gifimageview;

import android.graphics.Bitmap;

public class GifFrame
{
  public int delay;
  public Bitmap image;
  public GifFrame nextFrame = null;
  
  public GifFrame(Bitmap paramBitmap, int paramInt)
  {
    this.image = paramBitmap;
    this.delay = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.gifimageview.GifFrame
 * JD-Core Version:    0.7.0.1
 */