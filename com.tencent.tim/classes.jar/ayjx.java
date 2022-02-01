import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ayjx
  implements ValueAnimator.AnimatorUpdateListener
{
  ayjx(ayjw.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.c.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.c.translateXValue = (this.c.mV + this.c.mf * f);
    this.c.translateYValue = (this.c.mZ + this.c.mg * f);
    this.c.scaleValue = (this.c.mT + this.c.na * f);
    this.c.nI = (this.c.mU + this.c.nb * f);
    if (this.c.a.a != null) {
      this.c.a.a.ad(f);
    }
    if (f == 1.0F) {
      this.c.a.setMode(5);
    }
    ayjw.a(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjx
 * JD-Core Version:    0.7.0.1
 */