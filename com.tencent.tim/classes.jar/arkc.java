import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView;

public class arkc
  extends AnimatorListenerAdapter
{
  public arkc(CompactCalendarView paramCompactCalendarView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setMode(0);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkc
 * JD-Core Version:    0.7.0.1
 */