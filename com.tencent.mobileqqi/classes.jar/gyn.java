import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallView;

public class gyn
  implements Animation.AnimationListener
{
  public gyn(AvatarWallView paramAvatarWallView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    paramAnimation = this.a;
    paramAnimation.p -= 1;
    if (this.a.p <= 0)
    {
      this.a.e = true;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(this.a.jdField_a_of_type_Int, this.a.m);
      if (this.a.d)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.e();
        this.a.d = false;
      }
      int j = this.a.getChildCount();
      while (i < j)
      {
        this.a.getChildAt(i).clearAnimation();
        i += 1;
      }
      this.a.jdField_a_of_type_Int = this.a.m;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gyn
 * JD-Core Version:    0.7.0.1
 */