import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class bok
  implements Animation.AnimationListener
{
  public bok(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b.show();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bok
 * JD-Core Version:    0.7.0.1
 */