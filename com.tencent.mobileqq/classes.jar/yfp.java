import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolder;

public class yfp
  implements Animation.AnimationListener
{
  public yfp(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(46.0F * SpecailCareListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity$ViewHolder.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfp
 * JD-Core Version:    0.7.0.1
 */