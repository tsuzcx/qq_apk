import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.CountryActivity;

public class chd
  implements Animation.AnimationListener
{
  public chd(CountryActivity paramCountryActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_Chk.show();
    this.a.b.setAnimation(null);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chd
 * JD-Core Version:    0.7.0.1
 */