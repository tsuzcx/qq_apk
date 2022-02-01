import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.ArrayList;

public class aovg
  implements Animation.AnimationListener
{
  public aovg(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = false;
    paramAnimation = this.this$0;
    paramAnimation.dRO -= 1;
    if (this.this$0.dRO == 0)
    {
      this.this$0.cOR = false;
      int i = 0;
      while (i < this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        paramAnimation = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(i);
        if (paramAnimation != null) {
          paramAnimation.clearAnimation();
        }
        i += 1;
      }
      this.this$0.HO.clearAnimation();
      this.this$0.cu.remove(this.this$0.dRP);
      paramAnimation = this.this$0.jdField_a_of_type_Aour;
      if (this.this$0.cu.size() < this.this$0.dRQ) {
        bool = true;
      }
      paramAnimation.C(bool, true);
      this.this$0.jdField_a_of_type_Aour.bF(this.this$0.cu);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovg
 * JD-Core Version:    0.7.0.1
 */