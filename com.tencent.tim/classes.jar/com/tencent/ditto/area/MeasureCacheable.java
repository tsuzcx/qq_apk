package com.tencent.ditto.area;

import android.support.v4.util.LruCache;
import com.tencent.ditto.utils.DittoLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MeasureCacheable
{
  public static final LruCache<CanvasMeasureCacheKey, TextMeasureCacheItem> mMeasureCache = new LruCache(2048);
  
  public static void removeMeasureCache(Integer paramInteger)
  {
    if (paramInteger == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = mMeasureCache.snapshot().entrySet().iterator();
      while (localIterator.hasNext())
      {
        CanvasMeasureCacheKey localCanvasMeasureCacheKey = (CanvasMeasureCacheKey)((Map.Entry)localIterator.next()).getKey();
        if ((localCanvasMeasureCacheKey != null) && (paramInteger.equals(localCanvasMeasureCacheKey.cacheKey))) {
          mMeasureCache.remove(localCanvasMeasureCacheKey);
        }
      }
    }
  }
  
  public void addMeasureCache(Integer paramInteger, int paramInt1, int paramInt2, TextMeasureCacheItem paramTextMeasureCacheItem)
  {
    if ((paramTextMeasureCacheItem == null) || (paramInteger == null)) {
      return;
    }
    paramInteger = new CanvasMeasureCacheKey(paramInteger, paramInt1, paramInt2);
    mMeasureCache.put(paramInteger, paramTextMeasureCacheItem);
  }
  
  public TextMeasureCacheItem getMeasureCache(Integer paramInteger, int paramInt1, int paramInt2)
  {
    if (paramInteger == null) {
      return null;
    }
    try
    {
      paramInteger = new CanvasMeasureCacheKey(paramInteger, paramInt1, paramInt2);
      paramInteger = (TextMeasureCacheItem)mMeasureCache.get(paramInteger);
      return paramInteger;
    }
    catch (Exception paramInteger)
    {
      for (;;)
      {
        DittoLog.e("DITTO_UI", "", paramInteger);
        paramInteger = null;
      }
    }
  }
  
  public static class CanvasMeasureCacheKey
  {
    public Integer cacheKey;
    public int keyHeightMeasureSpec;
    public int keyWidthMeasureSpec;
    
    public CanvasMeasureCacheKey(Integer paramInteger, int paramInt1, int paramInt2)
    {
      this.cacheKey = paramInteger;
      this.keyWidthMeasureSpec = paramInt1;
      this.keyHeightMeasureSpec = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof CanvasMeasureCacheKey)) {
          return false;
        }
        paramObject = (CanvasMeasureCacheKey)paramObject;
      } while ((this.keyWidthMeasureSpec == paramObject.keyWidthMeasureSpec) && (this.keyHeightMeasureSpec == paramObject.keyHeightMeasureSpec) && (this.cacheKey != null) && (this.cacheKey.equals(paramObject.cacheKey)));
      return false;
    }
    
    public int hashCode()
    {
      int i = this.cacheKey.hashCode();
      i += i * 17 + this.keyWidthMeasureSpec;
      return i + (i * 17 + this.keyHeightMeasureSpec);
    }
  }
  
  public static class TextMeasureCacheItem
  {
    public int keyHeightMeasureSpec;
    public int keyWidthMeasureSpec;
    public int measureHeight;
    public int measuredWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.area.MeasureCacheable
 * JD-Core Version:    0.7.0.1
 */