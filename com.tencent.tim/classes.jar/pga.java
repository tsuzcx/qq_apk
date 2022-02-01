import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleInviteBannerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

public class pga
  implements URLDrawableDownListener
{
  public pga(QCircleInviteBannerView paramQCircleInviteBannerView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pga
 * JD-Core Version:    0.7.0.1
 */