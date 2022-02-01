import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xuf
  extends sxy
{
  public xuf.a a = new xuf.a();
  boolean bjr = true;
  public Rect bn;
  public int cutValue;
  public AIORichMediaData e;
  public boolean isDownloading;
  public boolean isEnterImage;
  public int orientation = -2;
  public int progress;
  Rect startSrcRect;
  
  public xuf(AIORichMediaData paramAIORichMediaData)
  {
    this.e = paramAIORichMediaData;
    this.isImgCenterCropMode = true;
  }
  
  @Deprecated
  public static URLDrawable a(akxw paramakxw)
  {
    return aoop.b(paramakxw, 1);
  }
  
  private Drawable aE()
  {
    if ((this.e == null) || (!AIOFilePicData.class.isInstance(this.e))) {}
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    do
    {
      File localFile2;
      do
      {
        File localFile1;
        do
        {
          return null;
          localFile1 = this.e.c(18);
          localFile2 = this.e.c(20);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
          localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
          if ((localFile1 == null) || (BaseApplicationImpl.sImageCache.get(this.e.cH(18)) == null)) {
            break;
          }
        } while (aoop.eI(localFile1.getAbsolutePath()) != 0);
        return URLDrawable.getDrawable(this.e.cH(18), localURLDrawableOptions);
        if ((localFile2 == null) || (BaseApplicationImpl.sImageCache.get(this.e.cH(20)) == null)) {
          break;
        }
      } while (aoop.eI(localFile2.getAbsolutePath()) != 0);
      return URLDrawable.getDrawable(this.e.cH(20), localURLDrawableOptions);
    } while (this.e.c(16) == null);
    return URLDrawable.getDrawable(this.e.cH(16), localURLDrawableOptions);
  }
  
  private Drawable aF()
  {
    if ((this.e == null) || (!AIOFileVideoData.class.isInstance(this.e))) {
      return null;
    }
    Object localObject = (AIOFileVideoData)this.e;
    File localFile = ((AIOFileVideoData)localObject).c(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(((AIOFileVideoData)localObject).cH(0)) != null)) {
      return URLDrawable.getDrawable(this.e.cH(0), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      localObject = URLDrawable.getDrawable(this.e.cH(0), localURLDrawableOptions);
      ((URLDrawable)localObject).downloadImediatly();
      return localObject;
    }
    return null;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        if (!AIOImageData.class.isInstance(this.e)) {
          continue;
        }
        localObject1 = this.e.c(2);
        localObject3 = this.e.c(4);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        if ((localObject1 == null) || (BaseApplicationImpl.sImageCache.get(this.e.cH(2)) == null)) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.e.cH(2), localURLDrawableOptions);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label397;
        }
        QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        return null;
        if (!AIOShortVideoData.class.isInstance(this.e)) {
          continue;
        }
        Object localObject2 = (AIOShortVideoData)this.e;
        Object localObject3 = ((AIOShortVideoData)localObject2).c(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
        if ((localObject3 == null) || (BaseApplicationImpl.sImageCache.get(((AIOShortVideoData)localObject2).cH(0)) == null)) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.e.cH(0), localURLDrawableOptions);
        continue;
        if (localObject3 == null) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.e.cH(0), localURLDrawableOptions);
        ((URLDrawable)localObject2).downloadImediatly();
        continue;
        if (!AIOFilePicData.class.isInstance(this.e)) {
          continue;
        }
        localObject2 = aE();
        continue;
        if (!AIOFileVideoData.class.isInstance(this.e)) {
          continue;
        }
        localObject2 = aF();
        continue;
        return localObject2;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
      }
      localObject3 = getThumbRect();
      if ((localObject1 != null) && ((((Drawable)localObject1).getIntrinsicHeight() * 3 < ((Drawable)localObject1).getIntrinsicWidth()) || (((Drawable)localObject1).getIntrinsicWidth() * 3 < ((Drawable)localObject1).getIntrinsicHeight()))) {
        this.isImgCenterCropMode = false;
      }
      if ((localObject1 == null) || (localObject3 == null)) {
        break label397;
      }
      this.cutValue = getCutValue((Rect)localObject3, (Drawable)localObject1);
      if (((Drawable)localObject1).getIntrinsicHeight() == -1) {
        break label397;
      }
      if (((Drawable)localObject1).getIntrinsicWidth() != -1) {
        continue;
      }
      return null;
      if ((localObject3 != null) && (BaseApplicationImpl.sImageCache.get(this.e.cH(4)) != null))
      {
        localObject1 = URLDrawable.getDrawable(this.e.cH(4), localURLDrawableOptions);
      }
      else
      {
        if (this.e.c(1) == null) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.e.cH(1), localURLDrawableOptions);
        ((URLDrawable)localObject1).downloadImediatly();
      }
    }
    label397:
    return null;
  }
  
  public int getCutValue()
  {
    return this.cutValue;
  }
  
  public Rect getStartSrcRect()
  {
    return this.startSrcRect;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Rect getThumbRect()
  {
    if ((this.isEnterImage) && (this.bjr)) {
      return this.bn;
    }
    return super.getThumbRect();
  }
  
  public static class a
  {
    boolean biW = false;
    boolean biX = false;
    boolean bjA = false;
    boolean bjs = false;
    public boolean bjt = false;
    boolean bju = false;
    boolean bjv = false;
    boolean bjw = false;
    boolean bjx = false;
    boolean bjy = false;
    boolean bjz = false;
    public int progress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuf
 * JD-Core Version:    0.7.0.1
 */