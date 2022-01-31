import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.CountryActivity;

public class wue
  implements Animation.AnimationListener
{
  public wue(CountryActivity paramCountryActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a.isFinishing())
    {
      this.a.jdField_a_of_type_Wul.show();
      this.a.b.setAnimation(null);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wue
 * JD-Core Version:    0.7.0.1
 */