import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;

public class ydc
  extends AnimatorListenerAdapter
{
  public ydc(TopPanelViewNew paramTopPanelViewNew) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydc
 * JD-Core Version:    0.7.0.1
 */