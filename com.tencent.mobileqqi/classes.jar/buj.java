import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Ad;

public class buj
  implements Animation.AnimationListener
{
  public buj(Ad paramAd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838313);
      paramAnimation = (AbsoluteLayout.LayoutParams)this.a.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramAnimation.y = (this.a.b.getHeight() - this.a.e);
      this.a.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
      paramAnimation.height = this.a.f;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     buj
 * JD-Core Version:    0.7.0.1
 */