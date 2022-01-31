import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class yyb
  implements Animation.AnimationListener
{
  yyb(yya paramyya) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.a.a.b.removeView(this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.a = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyb
 * JD-Core Version:    0.7.0.1
 */