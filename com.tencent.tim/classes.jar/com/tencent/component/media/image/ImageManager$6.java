package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.utils.LruCache;
import java.util.concurrent.ConcurrentHashMap;

class ImageManager$6
  extends LruCache<Integer, Drawable>
{
  ImageManager$6(ImageManager paramImageManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, Integer paramInteger, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramInteger != null)
    {
      ImageTaskTracer.addImageLruCacheEvictedRecord(paramInteger.intValue());
      ImageManager.access$700(this.this$0).remove(paramInteger);
    }
  }
  
  protected int sizeOf(Integer paramInteger, Drawable paramDrawable)
  {
    return ImageManager.access$600(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.6
 * JD-Core Version:    0.7.0.1
 */