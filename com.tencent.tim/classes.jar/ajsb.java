import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ajsb
  implements ValueAnimator.AnimatorUpdateListener
{
  ajsb(ajrz paramajrz, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.b.mIsAttached)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.g.x = i;
      this.b.mWindowManager.updateViewLayout(this.b.mView, this.g);
      return;
    }
    this.ax.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsb
 * JD-Core Version:    0.7.0.1
 */