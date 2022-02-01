package com.tencent.qqmail.qmimagecache;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import moai.core.utilities.Utils;

class ImageDrawableCache$1
  extends LruCache<String, BitmapDrawable>
{
  ImageDrawableCache$1(ImageDrawableCache paramImageDrawableCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, String paramString, BitmapDrawable paramBitmapDrawable1, BitmapDrawable paramBitmapDrawable2)
  {
    if (RecyclingBitmapDrawable.class.isInstance(paramBitmapDrawable1)) {
      ((RecyclingBitmapDrawable)paramBitmapDrawable1).setIsCached(false);
    }
    while (!Utils.hasHoneycomb()) {
      return;
    }
    ImageDrawableCache.access$000(this.this$0).add(new SoftReference(paramBitmapDrawable1.getBitmap()));
  }
  
  protected int sizeOf(String paramString, BitmapDrawable paramBitmapDrawable)
  {
    int j = ImageDrawableCache.getBitmapSize(paramBitmapDrawable) / 1024;
    int i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageDrawableCache.1
 * JD-Core Version:    0.7.0.1
 */