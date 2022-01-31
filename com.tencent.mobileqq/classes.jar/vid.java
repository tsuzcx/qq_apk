import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;

public class vid
  implements Animation.AnimationListener
{
  public vid(StructingMsgItemBuilder paramStructingMsgItemBuilder, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */