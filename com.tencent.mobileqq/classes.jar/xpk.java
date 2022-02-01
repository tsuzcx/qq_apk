import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.ImageView;

class xpk
  implements ValueAnimator.AnimatorUpdateListener
{
  xpk(xpj paramxpj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.a.setImageAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      return;
    }
    this.a.a.setImageResource(2130850680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpk
 * JD-Core Version:    0.7.0.1
 */