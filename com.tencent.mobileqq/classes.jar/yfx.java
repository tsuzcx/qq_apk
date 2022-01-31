import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class yfx
  implements Animation.AnimationListener
{
  public yfx(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.a.clearAnimation();
    this.a.leftView.setVisibility(0);
    this.a.a.setVisibility(0);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText("管理");
    this.a.rightViewText.setContentDescription("管理 按钮");
    this.a.c = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfx
 * JD-Core Version:    0.7.0.1
 */