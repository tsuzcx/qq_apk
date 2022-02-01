import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbi
  implements Animation.AnimationListener
{
  public abbi(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.a.wS.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(46.0F * SpecailCareListActivity.a(this.this$0)), 0, (int)(10.0F * SpecailCareListActivity.b(this.this$0)), 0);
    this.a.wS.setLayoutParams(paramAnimation);
    this.a.wS.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbi
 * JD-Core Version:    0.7.0.1
 */