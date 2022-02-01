import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class aoru
  implements Animation.AnimationListener
{
  public aoru(AbsPublishActivity paramAbsPublishActivity, Animation paramAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
    this.this$0.HN.setVisibility(8);
    this.this$0.HN.clearAnimation();
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.clearAnimation();
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.removeAllItem();
    this.this$0.HO.clearAnimation();
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.startAnimation(this.aS);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoru
 * JD-Core Version:    0.7.0.1
 */