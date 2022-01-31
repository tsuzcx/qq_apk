package uilib.doraemon;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.token.ip;

class f
  implements ValueAnimator.AnimatorUpdateListener
{
  f(e parame) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (e.a(this.a))
    {
      e.b(this.a).cancel();
      this.a.d(1.0F);
      return;
    }
    this.a.d(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.f
 * JD-Core Version:    0.7.0.1
 */