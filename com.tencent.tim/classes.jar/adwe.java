import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;

public class adwe
  extends AnimatorListenerAdapter
{
  public adwe(SelectCoverActivity paramSelectCoverActivity, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.Bl.setAlpha(1.0F);
    this.Bm.setVisibility(8);
    this.this$0.h = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.Bl.setAlpha(1.0F);
    this.Bm.setVisibility(8);
    this.this$0.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adwe
 * JD-Core Version:    0.7.0.1
 */