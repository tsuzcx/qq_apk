import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.d;

public class abbm
  implements Animation.AnimationListener
{
  public abbm(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.wU.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbm
 * JD-Core Version:    0.7.0.1
 */