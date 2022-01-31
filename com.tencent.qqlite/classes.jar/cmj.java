import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class cmj
  implements Animation.AnimationListener
{
  public cmj(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new FrameLayout.LayoutParams(-1, -1);
    SelectMemberActivity.a(this.a).setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmj
 * JD-Core Version:    0.7.0.1
 */