import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.h.a;

public class xuw
  implements Animation.AnimationListener
{
  public xuw(PhotoListPanel.h.a parama, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    akxe.a("PhotoListPanel", "DragHandler", " flyOutAnimation End fAnimLayout:" + this.a.hR + ",## dy = " + (this.qG - this.a.this$0.startY));
    paramAnimation = (RelativeLayout.LayoutParams)this.a.hT.getLayoutParams();
    paramAnimation.topMargin = this.a.z.topMargin;
    this.a.hT.setLayoutParams(paramAnimation);
    this.a.tv.setVisibility(8);
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.a.hT.getWidth() / 2, this.a.hT.getHeight() / 2);
    paramAnimation.addAnimation(this.a.jdField_t_of_type_AndroidViewAnimationAlphaAnimation);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.a.hT.startAnimation(paramAnimation);
    akxe.a("PhotoListPanel", "DragHandler", "startReemergeAnimation fAnimLayout:" + this.a.hR);
    paramAnimation.setAnimationListener(this.a.jdField_t_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    akxe.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xuw
 * JD-Core Version:    0.7.0.1
 */