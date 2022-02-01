import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class abbq
  implements Animation.AnimationListener
{
  public abbq(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.leftView.clearAnimation();
    this.this$0.ie.clearAnimation();
    this.this$0.leftView.setVisibility(0);
    this.this$0.ie.setVisibility(0);
    this.this$0.rightViewText.setClickable(true);
    this.this$0.rightViewText.setText(SpecailCareListActivity.bfj);
    this.this$0.rightViewText.setContentDescription(acfp.m(2131714686));
    this.this$0.bBO = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbq
 * JD-Core Version:    0.7.0.1
 */