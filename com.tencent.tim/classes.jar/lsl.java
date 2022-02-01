import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class lsl
  implements ValueAnimator.AnimatorUpdateListener
{
  lsl(lsf paramlsf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    lsf.a(this.this$0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    lsf.a(this.this$0).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsl
 * JD-Core Version:    0.7.0.1
 */