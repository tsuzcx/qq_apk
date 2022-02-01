package com.tencent.qqmail.utilities.imageextention;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.qqmail.QMApplicationContext;

public class QMImageCacher
{
  private static final String TAG = "QMImageCacher";
  private LruCache<String, Bitmap> memCache = new QMImageCacher.1(this, ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getMemoryClass() * 1048576 / 4);
  
  public void addImage(String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramBitmap != null)) {
      this.memCache.put(paramString, paramBitmap);
    }
  }
  
  public void clear()
  {
    this.memCache.evictAll();
  }
  
  public void clearAndSetNull()
  {
    this.memCache.evictAll();
    this.memCache = null;
  }
  
  public boolean containImage(String paramString)
  {
    if (paramString == null) {}
    while (this.memCache.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public Bitmap getImage(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (Bitmap)this.memCache.get(paramString);
  }
  
  public void removeImage(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = (Bitmap)this.memCache.remove(paramString);
    } while ((!paramBoolean) || (paramString == null) || (paramString.isRecycled()));
    paramString.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.QMImageCacher
 * JD-Core Version:    0.7.0.1
 */