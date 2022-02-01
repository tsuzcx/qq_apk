package com.tencent.image;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.util.Pair;

final class URLDrawable$3
  extends MQLruCache<String, Object>
{
  URLDrawable$3(int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOfObj(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof Pair)) {
        return ((Integer)((Pair)paramObject).second).intValue();
      }
      if ((paramObject instanceof Bitmap))
      {
        paramString = (Bitmap)paramObject;
        return paramString.getRowBytes() * paramString.getHeight();
      }
    }
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable.3
 * JD-Core Version:    0.7.0.1
 */