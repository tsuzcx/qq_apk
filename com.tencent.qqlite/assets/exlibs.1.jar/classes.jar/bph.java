import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class bph
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
  
  public bph(TroopMemberListActivity paramTroopMemberListActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.postDelayed(new bpi(this), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bph
 * JD-Core Version:    0.7.0.1
 */