import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView;

public class arke
  extends AnimatorListenerAdapter
{
  public arke(CompactCalendarView paramCompactCalendarView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setMode(1);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arke
 * JD-Core Version:    0.7.0.1
 */