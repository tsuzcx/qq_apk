package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;
import android.util.LruCache;

class QMImageCacher$1
  extends LruCache<String, Bitmap>
{
  QMImageCacher$1(QMImageCacher paramQMImageCacher, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.QMImageCacher.1
 * JD-Core Version:    0.7.0.1
 */