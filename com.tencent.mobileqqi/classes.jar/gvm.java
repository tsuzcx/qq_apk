import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.data.TroopBarPostLayoutTab;

public class gvm
  implements Animation.AnimationListener
{
  public gvm(TroopBarPostLayoutTab paramTroopBarPostLayoutTab, TroopBarPageEntity.TypeListEntity paramTypeListEntity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new Intent();
    paramAnimation.setAction("change_post_type");
    paramAnimation.putExtra("post_type", this.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity);
    this.jdField_a_of_type_AndroidViewView.getContext().sendBroadcast(paramAnimation);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPostLayoutTab.a = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPostLayoutTab.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvm
 * JD-Core Version:    0.7.0.1
 */