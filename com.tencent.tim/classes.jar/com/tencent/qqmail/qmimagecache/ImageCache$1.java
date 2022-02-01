package com.tencent.qqmail.qmimagecache;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class ImageCache$1
  extends LruCache<String, Bitmap>
{
  ImageCache$1(ImageCache paramImageCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString, Bitmap paramBitmap)
  {
    int j = ImageUtil.getBitmapSize(paramBitmap) / 1024;
    int i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */