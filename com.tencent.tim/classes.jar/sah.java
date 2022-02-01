import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew;

public class sah
  extends AnimatorListenerAdapter
{
  public sah(TopPanelViewNew paramTopPanelViewNew) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.clearAnimation();
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sah
 * JD-Core Version:    0.7.0.1
 */