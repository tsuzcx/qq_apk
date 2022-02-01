import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class tjd
  implements ValueAnimator.AnimatorUpdateListener
{
  tjd(tjc paramtjc, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    this.jdField_a_of_type_Tjc.a(a(this.jdField_a_of_type_Int, this.b, f), a(this.c, this.d, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjd
 * JD-Core Version:    0.7.0.1
 */