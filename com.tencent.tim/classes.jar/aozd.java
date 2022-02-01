import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.troop.createNewTroop.AbsNewTroopBaseView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;

public class aozd
  extends AnimatorListenerAdapter
{
  public aozd(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.b.a != null) {
      this.b.a.Rs(this.b.cPr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozd
 * JD-Core Version:    0.7.0.1
 */