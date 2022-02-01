import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ajsc
  implements ValueAnimator.AnimatorUpdateListener
{
  ajsc(ajrz paramajrz, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.b.mIsAttached)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.g.y = i;
      this.b.mWindowManager.updateViewLayout(this.b.mView, this.g);
      return;
    }
    this.ay.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsc
 * JD-Core Version:    0.7.0.1
 */