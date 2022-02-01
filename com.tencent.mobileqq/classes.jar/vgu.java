import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

public class vgu
  implements ImageLoader.ImageLoadListener
{
  public vgu(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, vhb paramvhb) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    this.jdField_a_of_type_Vhb.f(true);
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgu
 * JD-Core Version:    0.7.0.1
 */