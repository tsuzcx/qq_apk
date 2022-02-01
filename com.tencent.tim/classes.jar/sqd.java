import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1.1;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1.2;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

public class sqd
  implements ImageLoader.ImageLoadListener
{
  sqd(sqc paramsqc, View paramView) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramDrawable != null) && (this.val$targetView != null))
    {
      if (!(this.val$targetView instanceof FrameLayout)) {
        break label39;
      }
      this.val$targetView.post(new VSEntranceWidget.1.1(this, paramDrawable));
    }
    label39:
    while (!(this.val$targetView instanceof ImageView)) {
      return;
    }
    this.val$targetView.post(new VSEntranceWidget.1.2(this, paramDrawable));
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqd
 * JD-Core Version:    0.7.0.1
 */