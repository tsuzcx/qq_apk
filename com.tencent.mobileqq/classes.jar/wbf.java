import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView;
import java.lang.ref.WeakReference;

public class wbf
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<QCircleProgressLoadingView> a;
  
  public wbf(QCircleProgressLoadingView paramQCircleProgressLoadingView)
  {
    this.a = new WeakReference(paramQCircleProgressLoadingView);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null)
    {
      Object localObject = (QCircleProgressLoadingView)this.a.get();
      if (localObject != null)
      {
        localObject = ((QCircleProgressLoadingView)localObject).a();
        if ((localObject != null) && (((View)localObject).getBackground() != null)) {
          ((View)localObject).getBackground().setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbf
 * JD-Core Version:    0.7.0.1
 */