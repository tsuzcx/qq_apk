import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class aawt
  implements Animation.AnimationListener
{
  public aawt(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.E = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    this.this$0.hZ.setAnimation(this.this$0.E);
    paramAnimation = (FrameLayout.LayoutParams)this.this$0.hZ.getLayoutParams();
    paramAnimation.setMargins(0, 0, 0, this.this$0.aV.getHeight());
    this.this$0.hZ.setLayoutParams(paramAnimation);
    this.this$0.OB.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawt
 * JD-Core Version:    0.7.0.1
 */