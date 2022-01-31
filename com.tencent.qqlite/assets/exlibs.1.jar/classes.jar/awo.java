import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.NearbyActivity;

public class awo
  implements Animation.AnimationListener
{
  public awo(NearbyActivity paramNearbyActivity, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) != null)
      {
        paramAnimation = new Message();
        paramAnimation.what = 1;
        paramAnimation.arg1 = this.jdField_a_of_type_Int;
        paramAnimation.arg2 = 1003;
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 400L);
      }
      return;
    }
    NearbyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awo
 * JD-Core Version:    0.7.0.1
 */