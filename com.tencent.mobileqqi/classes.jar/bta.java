import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class bta
  implements Animation.AnimationListener
{
  public static final String a = "right";
  public static final int b = 0;
  public static final String b = "left";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  int jdField_a_of_type_Int = -1;
  View jdField_a_of_type_AndroidViewView;
  
  public bta(AccountManageActivity paramAccountManageActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a.postDelayed(new btb(this), 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (String)this.jdField_a_of_type_AndroidViewView.getTag();
    if ((this.jdField_a_of_type_Int == 1) && (paramAnimation.equals("left")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramAnimation.equals("right")))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_Int = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bta
 * JD-Core Version:    0.7.0.1
 */