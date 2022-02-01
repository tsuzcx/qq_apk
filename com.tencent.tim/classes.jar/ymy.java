import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class ymy
  implements Animator.AnimatorListener
{
  ymy(ymw paramymw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.bnD = true;
    paramAnimator = new Intent(this.a.a, SearchContactsActivity.class);
    paramAnimator.putExtra("from_key", this.a.a.xf());
    paramAnimator.putExtra("fromType", 13);
    this.a.a.startActivity(paramAnimator);
    this.a.a.overridePendingTransition(0, 0);
    aqfp.Sz(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */