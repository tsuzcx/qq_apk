import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;

class arll
  implements ValueAnimator.AnimatorUpdateListener
{
  arll(arlj paramarlj, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    float f1 = this.Cr;
    float f2 = paramValueAnimator.floatValue();
    float f3 = this.Cs;
    float f4 = this.Cr;
    this.this$0.et.setAlpha(f2 * (f3 - f4) + f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arll
 * JD-Core Version:    0.7.0.1
 */