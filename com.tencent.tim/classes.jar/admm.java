import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ar.view.ViewfinderView;

public class admm
  implements ValueAnimator.AnimatorUpdateListener
{
  public admm(ViewfinderView paramViewfinderView, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewfinderView.a(this.b, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.b.postInvalidate(this.bI.left - 6, this.bI.top - 6, this.bI.right + 6, this.bI.bottom + 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admm
 * JD-Core Version:    0.7.0.1
 */