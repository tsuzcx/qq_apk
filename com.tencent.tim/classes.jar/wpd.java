import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class wpd
  implements ValueAnimator.AnimatorUpdateListener
{
  wpd(wpc paramwpc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (wpc.a(this.b) != null) {
      wpc.a(this.b).setAlpha((float)d);
    }
    if (wpc.a(this.b) != null) {
      wpc.a(this.b).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpd
 * JD-Core Version:    0.7.0.1
 */