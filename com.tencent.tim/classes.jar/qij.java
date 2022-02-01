import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

final class qij
  implements ValueAnimator.AnimatorUpdateListener
{
  qij(ViewGroup paramViewGroup, Drawable paramDrawable, ImageView paramImageView1, ImageView paramImageView2) {}
  
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
    int j;
    float f3;
    if (this.dd != null)
    {
      int i = this.co.getWidth();
      j = this.co.getHeight();
      if (f1 >= f2) {
        break label220;
      }
      f1 = f2 / f1;
      f2 = i;
      f3 = i;
      this.mF.setPivotX(0.5F);
      this.mF.setScaleX(f1);
      this.mF.setTranslationX((f2 - f3 * f1) * 0.5F);
      this.mF.setPivotY(0.5F);
      this.mF.setScaleY(1.0F);
      this.mF.setTranslationY(0.0F);
    }
    for (;;)
    {
      this.mG.setAlpha(((Float)paramValueAnimator.getAnimatedValue("backgroundAlpha")).floatValue());
      return;
      label220:
      if (f2 < f1)
      {
        this.mF.setPivotX(0.5F);
        this.mF.setScaleX(1.0F);
        this.mF.setTranslationX(0.0F);
        f1 /= f2;
        f2 = j;
        f3 = j;
        this.mF.setPivotY(0.5F);
        this.mF.setScaleY(f1);
        this.mF.setTranslationY((f2 - f3 * f1) * 0.5F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qij
 * JD-Core Version:    0.7.0.1
 */