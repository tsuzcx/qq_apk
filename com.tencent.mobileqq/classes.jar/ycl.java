import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class ycl
  implements Animation.AnimationListener
{
  public ycl(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.a.clearAnimation();
    this.a.leftView.setVisibility(4);
    this.a.a.setVisibility(8);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText("完成");
    this.a.rightViewText.setContentDescription("完成 按钮");
    this.a.c = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycl
 * JD-Core Version:    0.7.0.1
 */