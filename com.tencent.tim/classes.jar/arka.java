import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView;

public class arka
  implements ValueAnimator.AnimatorUpdateListener
{
  public arka(CompactCalendarView paramCompactCalendarView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.b.getLayoutParams();
    paramValueAnimator.height = i;
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arka
 * JD-Core Version:    0.7.0.1
 */