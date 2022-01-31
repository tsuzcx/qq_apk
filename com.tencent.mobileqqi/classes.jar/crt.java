import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class crt
  implements Animation.AnimationListener
{
  public crt(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ForwardFriendListActivity.a(this.a).show();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(null);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crt
 * JD-Core Version:    0.7.0.1
 */