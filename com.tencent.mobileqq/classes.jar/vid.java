import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import java.lang.ref.WeakReference;

class vid
  implements behi
{
  private SystemEmoCell jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell;
  private ImageLoader.ImageLoadListener jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener;
  private WeakReference<vjg> jdField_a_of_type_JavaLangRefWeakReference;
  
  public vid(via paramvia, vjg paramvjg, SystemEmoCell paramSystemEmoCell, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell = paramSystemEmoCell;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvjg);
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener = paramImageLoadListener;
  }
  
  public void a(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell != null) && (paramDrawable != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.isDrawableLoaded = true;
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.emoDrawable = paramDrawable;
      via.a(paramDrawable, this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.mHeight);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    }
    for (;;)
    {
      return;
      vjg localvjg = (vjg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localvjg != null)
      {
        if (paramDrawable.getBounds().width() == this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextSystemEmoCell.mWidth) {
          break label111;
        }
        localvjg.c();
        localvjg.postInvalidate();
      }
      while (this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null)
      {
        this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageLoaded(null, paramDrawable, null);
        return;
        label111:
        localvjg.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */