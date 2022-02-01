import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbp
  implements Animation.AnimationListener
{
  public abbp(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.At.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131368698);
    paramAnimation.setMargins(0, (int)(36.0F * SpecailCareListActivity.i(this.this$0)), (int)(30.0F * SpecailCareListActivity.j(this.this$0)), 0);
    this.a.At.setLayoutParams(paramAnimation);
    this.a.At.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbp
 * JD-Core Version:    0.7.0.1
 */