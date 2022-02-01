import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbj
  implements Animation.AnimationListener
{
  public abbj(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.ib.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(10);
    paramAnimation.addRule(1, 2131368698);
    paramAnimation.setMargins(0, (int)(22.0F * SpecailCareListActivity.c(this.this$0)), (int)(23.0F * SpecailCareListActivity.d(this.this$0) + this.cnB), 0);
    this.a.ib.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbj
 * JD-Core Version:    0.7.0.1
 */