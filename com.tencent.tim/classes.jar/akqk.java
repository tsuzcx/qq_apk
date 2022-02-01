import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class akqk
  implements ValueAnimator.AnimatorUpdateListener
{
  akqk(akqe paramakqe) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (akqe.a(this.c) != null)
    {
      akqe.a(this.c).setAlpha(f);
      akqe.a(this.c).setTranslationY((1.0F - f) * wja.dp2px(25.0F, akqe.a(this.c)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqk
 * JD-Core Version:    0.7.0.1
 */