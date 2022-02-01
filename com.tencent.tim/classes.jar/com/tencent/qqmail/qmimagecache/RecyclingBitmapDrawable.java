package com.tencent.qqmail.qmimagecache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class RecyclingBitmapDrawable
  extends BitmapDrawable
{
  static final String LOG_TAG = "CountingBitmapDrawable";
  private int mCacheRefCount = 0;
  private int mDisplayRefCount = 0;
  private boolean mHasBeenDisplayed;
  
  public RecyclingBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  private void checkState()
  {
    try
    {
      if ((this.mCacheRefCount <= 0) && (this.mDisplayRefCount <= 0) && (this.mHasBeenDisplayed) && (hasValidBitmap())) {
        getBitmap().recycle();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private boolean hasValidBitmap()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 34	com/tencent/qqmail/qmimagecache/RecyclingBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: invokevirtual 42	android/graphics/Bitmap:isRecycled	()Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifne +9 -> 26
    //   20: iconst_1
    //   21: istore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: goto -6 -> 22
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	RecyclingBitmapDrawable
    //   15	13	1	bool	boolean
    //   6	6	2	localBitmap	Bitmap
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	16	31	finally
  }
  
  public void setIsCached(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mCacheRefCount += 1;
        checkState();
        return;
      }
      finally {}
      this.mCacheRefCount -= 1;
    }
  }
  
  public void setIsDisplayed(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mDisplayRefCount += 1;
        this.mHasBeenDisplayed = true;
        checkState();
        return;
      }
      finally {}
      this.mDisplayRefCount -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.RecyclingBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */