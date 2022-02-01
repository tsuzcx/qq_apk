import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView.ScaleXAnimationListener.1;
import java.lang.ref.WeakReference;

public class wbg
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<QCircleProgressLoadingView> a;
  
  public wbg(QCircleProgressLoadingView paramQCircleProgressLoadingView)
  {
    this.a = new WeakReference(paramQCircleProgressLoadingView);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null)
    {
      QCircleProgressLoadingView localQCircleProgressLoadingView = (QCircleProgressLoadingView)this.a.get();
      if (localQCircleProgressLoadingView != null)
      {
        View localView = localQCircleProgressLoadingView.a();
        if ((localView != null) && (localView.getLayoutParams() != null))
        {
          localView.getLayoutParams().width = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
          QCircleProgressLoadingView.a(localQCircleProgressLoadingView).post(new QCircleProgressLoadingView.ScaleXAnimationListener.1(this, localView));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbg
 * JD-Core Version:    0.7.0.1
 */