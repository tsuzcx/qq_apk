import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class akqm
  implements ValueAnimator.AnimatorUpdateListener
{
  akqm(akqe paramakqe, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.CF.setAlpha(1.0F - f);
    this.CF.setTranslationY(f * wja.dp2px(25.0F, akqe.a(this.c)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqm
 * JD-Core Version:    0.7.0.1
 */