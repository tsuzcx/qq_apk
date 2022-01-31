import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.NearbyActivity;

public class awo
  implements Animation.AnimationListener
{
  public awo(NearbyActivity paramNearbyActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) != null)
    {
      paramAnimation = new Message();
      paramAnimation.what = 1;
      paramAnimation.arg1 = (this.jdField_a_of_type_Int + 1);
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 200L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awo
 * JD-Core Version:    0.7.0.1
 */