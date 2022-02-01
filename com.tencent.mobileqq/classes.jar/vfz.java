import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import java.lang.ref.WeakReference;

class vfz
  implements bdom
{
  private SystemEmoCell jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell;
  private ImageLoader.ImageLoadListener jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener;
  private WeakReference<vhc> jdField_a_of_type_JavaLangRefWeakReference;
  
  public vfz(vfw paramvfw, vhc paramvhc, SystemEmoCell paramSystemEmoCell, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell = paramSystemEmoCell;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvhc);
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener = paramImageLoadListener;
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell != null) && (paramDrawable != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.isDrawableLoaded = true;
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.emoDrawable = paramDrawable;
      vfw.a(paramDrawable, this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.mHeight);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    }
    for (;;)
    {
      return;
      vhc localvhc = (vhc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localvhc != null)
      {
        if (paramDrawable.getBounds().width() == this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.mWidth) {
          break label111;
        }
        localvhc.c();
        localvhc.postInvalidate();
      }
      while (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null)
      {
        this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageLoaded(null, paramDrawable, null);
        return;
        label111:
        localvhc.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfz
 * JD-Core Version:    0.7.0.1
 */