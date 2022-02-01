import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ayjy
  implements ValueAnimator.AnimatorUpdateListener
{
  ayjy(ayjw.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.c.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.c.translateXValue = (this.c.mV + this.c.mf * (1.0F - f));
    this.c.translateYValue = (this.c.mZ + this.c.mg * (1.0F - f));
    this.c.scaleValue = (this.c.mT + this.c.na * (1.0F - f));
    this.c.nI = (this.c.mU + this.c.nb * (1.0F - f));
    if (f == 1.0F)
    {
      this.c.a.b = null;
      this.c.a.setMode(4);
    }
    ayjw.b(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjy
 * JD-Core Version:    0.7.0.1
 */