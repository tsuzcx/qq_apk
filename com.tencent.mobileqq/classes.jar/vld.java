import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class vld
  implements ValueAnimator.AnimatorUpdateListener
{
  vld(vlc paramvlc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (vla.a(this.a.a) == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.l = (this.a.d + this.a.f * f);
    this.a.m = (this.a.e + this.a.g * f);
    this.a.j = (this.a.b + this.a.h * f);
    this.a.k = (this.a.c + this.a.i * f);
    if (this.a.a.a != null) {
      this.a.a.a.a(f);
    }
    if (f == 1.0F) {
      vla.a(this.a.a, null);
    }
    vla.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vld
 * JD-Core Version:    0.7.0.1
 */