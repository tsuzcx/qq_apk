import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.webviewplugin.Ad;

public class bui
  implements Animation.AnimationListener
{
  public bui(Ad paramAd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838312);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bui
 * JD-Core Version:    0.7.0.1
 */