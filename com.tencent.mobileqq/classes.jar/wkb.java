import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;

public class wkb
  extends AnimatorListenerAdapter
{
  public wkb(TopPanelViewNew paramTopPanelViewNew) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wkb
 * JD-Core Version:    0.7.0.1
 */