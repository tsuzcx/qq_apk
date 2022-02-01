import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;

class aoqw
  implements ValueAnimator.AnimatorUpdateListener
{
  aoqw(aoqv paramaoqv) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    aoqv.a(this.a).setPadding(aqcx.dip2px(aoqv.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqw
 * JD-Core Version:    0.7.0.1
 */