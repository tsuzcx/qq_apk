import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbx
  implements Animation.AnimationListener
{
  public abbx(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.wU.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbx
 * JD-Core Version:    0.7.0.1
 */