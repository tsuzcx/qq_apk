import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class tsa
  implements ValueAnimator.AnimatorUpdateListener
{
  tsa(trz paramtrz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (trz.a(this.b))
    {
      this.b.setProgress(1.0F);
      return;
    }
    this.b.setProgress(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsa
 * JD-Core Version:    0.7.0.1
 */