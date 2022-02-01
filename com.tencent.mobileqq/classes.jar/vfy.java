import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoCell;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import java.lang.ref.WeakReference;

class vfy
  implements ImageLoader.ImageLoadListener
{
  private int jdField_a_of_type_Int;
  private ImageLoader.ImageLoadListener jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener;
  private WeakReference<vhc> jdField_a_of_type_JavaLangRefWeakReference;
  
  public vfy(vfw paramvfw, int paramInt, vhc paramvhc, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvhc);
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener = paramImageLoadListener;
  }
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null) {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageCanceled(paramString, paramOptions);
    }
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null) {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageFailed(paramString, paramOptions);
    }
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramOptions == null) || (paramOptions.obj == null)) {}
    label136:
    label142:
    label150:
    for (;;)
    {
      return;
      EmoCell localEmoCell = (EmoCell)paramOptions.obj;
      Object localObject;
      if (paramDrawable != null)
      {
        if (!(paramDrawable instanceof BitmapRefDrawable)) {
          break label136;
        }
        localObject = ((BitmapRefDrawable)paramDrawable).newDrawable();
        vfw.a((Drawable)localObject, this.jdField_a_of_type_Int);
        localEmoCell.emoDrawable = ((Drawable)localObject);
        localEmoCell.isDrawableLoaded = true;
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          continue;
        }
        localObject = (vhc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          if (paramDrawable.getBounds().width() == this.jdField_a_of_type_Int) {
            break label142;
          }
          ((vhc)localObject).c();
          ((vhc)localObject).postInvalidate();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener == null) {
          break label150;
        }
        this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageLoaded(paramString, paramDrawable, paramOptions);
        return;
        localObject = paramDrawable;
        break;
        ((vhc)localObject).postInvalidate();
      }
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null) {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageProgress(paramString, paramFloat, paramOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */