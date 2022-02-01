import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

public class amcb
  extends BrowserAnimation
  implements IBrowserAnimationListener
{
  private RichMediaBaseData a;
  public Rect bn;
  public int cutValue;
  Rect startSrcRect;
  
  public amcb() {}
  
  public amcb(RichMediaBaseData paramRichMediaBaseData)
  {
    this.a = paramRichMediaBaseData;
  }
  
  public Drawable getAnimationDrawable()
  {
    for (;;)
    {
      try
      {
        Drawable localDrawable;
        if ((this.a instanceof AIOPictureData))
        {
          localDrawable = new amcs().a((AIOPictureData)this.a);
          localObject2 = getThumbRect();
          if ((localDrawable != null) && ((localDrawable.getIntrinsicHeight() * 3 < localDrawable.getIntrinsicWidth()) || (localDrawable.getIntrinsicWidth() * 3 < localDrawable.getIntrinsicHeight()))) {
            this.isImgCenterCropMode = false;
          }
          if ((localDrawable != null) && (localObject2 != null))
          {
            this.cutValue = getCutValue((Rect)localObject2, localDrawable);
            if (localDrawable.getIntrinsicHeight() == -1) {
              break;
            }
            localObject2 = localDrawable;
            if (localDrawable.getIntrinsicWidth() != -1) {
              return localObject2;
            }
            break;
          }
        }
        else
        {
          if ((this.a instanceof AIOVideoData))
          {
            localDrawable = new amct().a((AIOVideoData)this.a);
            continue;
          }
          if ((this.a instanceof AIOFilePictureData))
          {
            localDrawable = new amco().a((AIOFilePictureData)this.a);
            continue;
          }
          if (!(this.a instanceof AIOFileVideoData)) {
            break label219;
          }
          localDrawable = new amcp().a((AIOFileVideoData)this.a);
          continue;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        }
        return null;
      }
      label219:
      Object localObject1 = null;
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  public BrowserAnimation getBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    paramRichMediaBaseData = new amcb(paramRichMediaBaseData);
    paramRichMediaBaseData.bn = this.bn;
    return paramRichMediaBaseData;
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
    if (this.bn != null) {
      return this.bn;
    }
    return super.getThumbRect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcb
 * JD-Core Version:    0.7.0.1
 */