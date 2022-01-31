import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.utils.ImageUtil;

public class dgc
  implements URLDrawableDownListener
{
  public dgc(EmoticonPanelViewBinder paramEmoticonPanelViewBinder) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if ((((Boolean)paramView.getTag()).booleanValue()) && (paramURLDrawable != null) && (paramURLDrawable.getIntrinsicWidth() > 0))
    {
      paramURLDrawable = ImageUtil.a(paramURLDrawable);
      if ((paramURLDrawable != null) && (paramURLDrawable.getWidth() > 0)) {
        ((ImageView)paramView).setImageBitmap(ImageUtil.a(paramURLDrawable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgc
 * JD-Core Version:    0.7.0.1
 */