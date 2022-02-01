import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class rgc
  implements ValueAnimator.AnimatorUpdateListener
{
  rgc(rgb.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (rgb.a(this.c.a) == null) {
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
      rgb.a(this.c.a, null);
    }
    rgb.a(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgc
 * JD-Core Version:    0.7.0.1
 */