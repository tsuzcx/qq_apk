package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BitmapReference
{
  private static final String TAG = "BitmapReference";
  static int releaseCount = 0;
  private static Set<Bitmap> sBitmapMemSet = Collections.synchronizedSet(new HashSet());
  private static Releaser<Bitmap> sReleaser;
  private volatile boolean isReleased = false;
  private Bitmap mBitmap;
  
  @TargetApi(19)
  public static BitmapReference getBitmapReference(Bitmap paramBitmap)
  {
    Object localObject;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      localObject = null;
    }
    BitmapReference localBitmapReference;
    do
    {
      do
      {
        return localObject;
        localBitmapReference = new BitmapReference();
        localBitmapReference.mBitmap = paramBitmap;
        localObject = localBitmapReference;
      } while (ImageManager.sCloseNativeAndCache);
      localObject = localBitmapReference;
    } while (!paramBitmap.isMutable());
    sBitmapMemSet.add(paramBitmap);
    return localBitmapReference;
  }
  
  public static void setGlobalReleaser(Releaser<Bitmap> paramReleaser)
  {
    sReleaser = paramReleaser;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      release();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("BitmapReference", "catch an exception:" + Log.getStackTraceString(localThrowable));
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getAllocSize()
  {
    return BitmapUtils.getBitmapAllocSize(this.mBitmap);
  }
  
  public Bitmap getBitmap()
  {
    if (this.mBitmap.isRecycled()) {
      return null;
    }
    return this.mBitmap;
  }
  
  public final Bitmap.Config getConfig()
  {
    return this.mBitmap.getConfig();
  }
  
  public final int getHeight()
  {
    return this.mBitmap.getHeight();
  }
  
  public final int getRowBytes()
  {
    return this.mBitmap.getRowBytes();
  }
  
  public final int getWidth()
  {
    return this.mBitmap.getWidth();
  }
  
  public final boolean hasAlpha()
  {
    return this.mBitmap.hasAlpha();
  }
  
  public final boolean isMutable()
  {
    return this.mBitmap.isMutable();
  }
  
  public final boolean isRecycled()
  {
    return this.mBitmap.isRecycled();
  }
  
  @TargetApi(19)
  public void release()
  {
    if ((this.isReleased) || (ImageManager.sCloseNativeAndCache)) {}
    do
    {
      return;
      this.isReleased = true;
    } while ((!sBitmapMemSet.remove(this.mBitmap)) || (this.mBitmap.isRecycled()) || (!this.mBitmap.isMutable()));
    if (sReleaser != null)
    {
      sReleaser.release(this.mBitmap);
      return;
    }
    this.mBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.BitmapReference
 * JD-Core Version:    0.7.0.1
 */