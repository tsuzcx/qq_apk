package android.support.v4.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CircularProgressDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CircularProgressDrawable$1(CircularProgressDrawable paramCircularProgressDrawable, CircularProgressDrawable.Ring paramRing) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CircularProgressDrawable.access$000(this.this$0, f, this.val$ring);
    CircularProgressDrawable.access$100(this.this$0, f, this.val$ring, false);
    this.this$0.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.CircularProgressDrawable.1
 * JD-Core Version:    0.7.0.1
 */