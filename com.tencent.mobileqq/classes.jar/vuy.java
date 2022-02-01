import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBannerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

public class vuy
  implements URLDrawableDownListener
{
  public vuy(QCircleBannerView paramQCircleBannerView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */