import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.pic.Logger;

class vpt
  implements Animation.AnimationListener
{
  vpt(vps paramvps, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Logger.a("PhotoListPanel", "DragHandler", " flyOutAnimation End fAnimLayout:" + this.jdField_a_of_type_Vps.jdField_a_of_type_AndroidWidgetRelativeLayout + ",## dy = " + (this.jdField_a_of_type_Float - this.jdField_a_of_type_Vps.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.b));
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Vps.c.getLayoutParams();
    paramAnimation.topMargin = this.jdField_a_of_type_Vps.d.topMargin;
    this.jdField_a_of_type_Vps.c.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_Vps.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.jdField_a_of_type_Vps.c.getWidth() / 2, this.jdField_a_of_type_Vps.c.getHeight() / 2);
    paramAnimation.addAnimation(this.jdField_a_of_type_Vps.b);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.jdField_a_of_type_Vps.c.startAnimation(paramAnimation);
    Logger.a("PhotoListPanel", "DragHandler", "startReemergeAnimation fAnimLayout:" + this.jdField_a_of_type_Vps.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramAnimation.setAnimationListener(this.jdField_a_of_type_Vps.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Logger.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpt
 * JD-Core Version:    0.7.0.1
 */