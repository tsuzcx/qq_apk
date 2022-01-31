import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.NearbyActivity;

public class awn
  implements Animation.AnimationListener
{
  public awn(NearbyActivity paramNearbyActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) != null)
      {
        paramAnimation = new Message();
        paramAnimation.what = 1;
        paramAnimation.arg1 = (this.jdField_a_of_type_Int + 1);
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 100L);
      }
    }
    label214:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 6)) {
            break;
          }
        } while (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null);
        paramAnimation = new Message();
        paramAnimation.what = 1;
        paramAnimation.arg1 = (this.jdField_a_of_type_Int + 1);
        paramAnimation.arg2 = 1001;
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 200L);
        return;
        if (this.jdField_a_of_type_Int != 7) {
          break label214;
        }
        if (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity)) {
          break;
        }
      } while (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null);
      paramAnimation = new Message();
      paramAnimation.what = 1;
      paramAnimation.arg1 = (this.jdField_a_of_type_Int + 1);
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 50L);
      return;
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_Int, 7, 70L);
      return;
      if (this.jdField_a_of_type_Int != 8) {
        break;
      }
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, true);
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity)[this.jdField_a_of_type_Int].clearAnimation();
      ((ViewGroup.MarginLayoutParams)NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity)[this.jdField_a_of_type_Int].getLayoutParams()).topMargin = ((int)(55.0F * this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getResources().getDisplayMetrics().density));
      NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity)[this.jdField_a_of_type_Int].requestLayout();
    } while (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null);
    paramAnimation = new Message();
    paramAnimation.what = 1;
    paramAnimation.arg1 = 7;
    paramAnimation.arg2 = 1002;
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).sendMessageDelayed(paramAnimation, 300L);
    return;
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity, this.jdField_a_of_type_Int, 10, 50L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity)[this.jdField_a_of_type_Int].setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awn
 * JD-Core Version:    0.7.0.1
 */