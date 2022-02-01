import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class aozo
  implements ValueAnimator.AnimatorUpdateListener
{
  aozo(aozl paramaozl, aoyk.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f = 1.0F * (100 - i) / 100.0F;
    this.c.description.setAlpha(f);
    f = this.c.description.getHeight() / 2.0F * i / 100.0F;
    this.c.Ia.setTranslationY(f);
    f = i * -180.0F / 100.0F;
    this.c.fO.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozo
 * JD-Core Version:    0.7.0.1
 */