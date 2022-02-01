import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;

public class nsv
  extends AnimatorListenerAdapter
{
  public nsv(ReadInJoyColorBandEntranceButton paramReadInJoyColorBandEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.setClickable(true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsv
 * JD-Core Version:    0.7.0.1
 */