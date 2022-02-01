import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.ImageView;

final class qil
  implements ValueAnimator.AnimatorUpdateListener
{
  qil(ViewGroup paramViewGroup, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("scaleX")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("scaleY")).floatValue();
    this.co.setPivotX(0.5F);
    this.co.setScaleX(f1);
    this.co.setPivotY(0.5F);
    this.co.setScaleY(f2);
    this.co.setTranslationX(((Float)paramValueAnimator.getAnimatedValue("translateX")).floatValue());
    this.co.setTranslationY(((Float)paramValueAnimator.getAnimatedValue("translateY")).floatValue());
    int i = this.co.getWidth();
    int j = this.co.getHeight();
    float f3;
    if (f1 < f2)
    {
      f1 = f2 / f1;
      f2 = i;
      f3 = i;
      this.mH.setPivotX(0.5F);
      this.mH.setScaleX(f1);
      this.mH.setTranslationX((f2 - f3 * f1) * 0.5F);
      this.mH.setPivotY(0.5F);
      this.mH.setScaleY(1.0F);
      this.mH.setTranslationY(0.0F);
    }
    for (;;)
    {
      this.mG.setAlpha(((Float)paramValueAnimator.getAnimatedValue("backgroundAlpha")).floatValue());
      return;
      if (f2 < f1)
      {
        this.mH.setPivotX(0.5F);
        this.mH.setScaleX(1.0F);
        this.mH.setTranslationX(0.0F);
        f1 /= f2;
        f2 = j;
        f3 = j;
        this.mH.setPivotY(0.5F);
        this.mH.setScaleY(f1);
        this.mH.setTranslationY((f2 - f3 * f1) * 0.5F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qil
 * JD-Core Version:    0.7.0.1
 */