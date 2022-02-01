import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

class wpb
  implements ValueAnimator.AnimatorUpdateListener
{
  wpb(wpa paramwpa) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Double)paramValueAnimator.getAnimatedValue()).doubleValue();
    if (wpa.a(this.b) != null) {
      wpa.a(this.b).setAlpha((float)d);
    }
    if (wpa.a(this.b) != null) {
      wpa.a(this.b).setAlpha((float)d * 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpb
 * JD-Core Version:    0.7.0.1
 */