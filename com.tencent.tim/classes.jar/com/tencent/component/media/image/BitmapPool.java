package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import java.util.LinkedList;

@TargetApi(19)
public abstract class BitmapPool
  extends BucketPool<Bitmap>
{
  public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  public static final int BYTES_PER_PIXEL = 4;
  private static final String TAG = "BitmapPool";
  private int hitCount;
  private int missCount;
  private long totalExpectSize;
  private long totalRealSize;
  
  public BitmapPool(PoolParams paramPoolParams)
  {
    super(paramPoolParams);
  }
  
  private static int getBitmapSize(int paramInt)
  {
    if (paramInt % 4 == 0) {
      return paramInt / 4;
    }
    return paramInt / 4 + 1;
  }
  
  protected Bitmap allocData(int paramInt)
  {
    return Bitmap.createBitmap(1, getBitmapSize(paramInt), BITMAP_CONFIG);
  }
  
  public int getHitCount()
  {
    return this.hitCount;
  }
  
  public int getMissCount()
  {
    return this.missCount;
  }
  
  protected int getSizeForData(Bitmap paramBitmap)
  {
    return paramBitmap.getAllocationByteCount();
  }
  
  public long getTotalExpectSize()
  {
    return this.totalExpectSize;
  }
  
  public long getTotalRealSize()
  {
    return this.totalRealSize;
  }
  
  protected int handleBucketListEmpty(BucketPool<Bitmap>.Bucket<Bitmap> paramBucketPool)
  {
    paramBucketPool.allocCount += 1;
    return paramBucketPool.minSize;
  }
  
  protected boolean handleRecyleData(BucketPool<Bitmap>.Bucket<Bitmap> paramBucketPool, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramBucketPool.dataList.size() < paramBucketPool.itemSize) {
      if (paramBucketPool.allocCount > paramBucketPool.itemSize + 2)
      {
        bool1 = bool2;
        if (paramBucketPool.dataList.size() > paramBucketPool.itemSize / 4 + 1) {}
      }
      else
      {
        paramBucketPool.dataList.add(paramBitmap);
        bool1 = false;
      }
    }
    if (bool1) {
      paramBucketPool.allocCount -= 1;
    }
    return bool1;
  }
  
  protected void hit(int paramInt, Bitmap paramBitmap)
  {
    this.hitCount += 1;
    this.totalRealSize += BitmapUtils.getBitmapAllocSize(paramBitmap);
    this.totalExpectSize += paramInt;
    ImageManagerEnv.getLogger();
  }
  
  protected void miss(int paramInt)
  {
    this.missCount += 1;
    ImageManagerEnv.getLogger();
  }
  
  public void release(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramBitmap.isMutable()) {
          continue;
        }
        super.release(paramBitmap);
      }
      finally {}
    }
  }
  
  protected void releaseData(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
  
  public abstract void resizeCache(float paramFloat);
  
  public abstract void trimToSize(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.BitmapPool
 * JD-Core Version:    0.7.0.1
 */