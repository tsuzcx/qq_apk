import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.6;

public class aovi
  extends AnimatorListenerAdapter
{
  public aovi(TroopBarPublishActivity.6 param6) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.cOW) {
      this.a.this$0.dXd();
    }
    this.a.this$0.b.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovi
 * JD-Core Version:    0.7.0.1
 */