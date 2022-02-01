import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbk
  implements Animation.AnimationListener
{
  public abbk(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.At.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368698);
    paramAnimation.setMargins(0, (int)(24.0F * SpecailCareListActivity.e(this.this$0)), 0, 0);
    this.a.At.setLayoutParams(paramAnimation);
    this.a.At.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbk
 * JD-Core Version:    0.7.0.1
 */