import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;

public class epl
  implements Animation.AnimationListener
{
  public epl(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = false;
    if (this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(4);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.b(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if (this.a.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838394);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != paramAnimation);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.clearAnimation();
        if (this.a.c)
        {
          this.a.c = false;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.a(true);
        }
      }
    } while (this.a.jdField_b_of_type_AndroidWidgetImageView == null);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838395);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epl
 * JD-Core Version:    0.7.0.1
 */