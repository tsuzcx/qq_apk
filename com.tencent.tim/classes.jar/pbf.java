import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;

class pbf
  implements ValueAnimator.AnimatorUpdateListener
{
  pbf(pbc parampbc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    if ((pbc.a(this.this$0) != null) && (pbc.a(this.this$0).getBackground() != null)) {
      pbc.a(this.this$0).getBackground().setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbf
 * JD-Core Version:    0.7.0.1
 */