import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

class xyo
  implements Animator.AnimatorListener
{
  xyo(xym paramxym) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((NewFlowCameraActivity.a(this.a.a) != null) && (NewFlowCameraActivity.b(this.a.a) != null) && (NewFlowCameraActivity.a(this.a.a) != null))
    {
      NewFlowCameraActivity.a(this.a.a).setVisibility(8);
      NewFlowCameraActivity.b(this.a.a).setImageBitmap(this.a.b);
      NewFlowCameraActivity.b(this.a.a).setVisibility(0);
      NewFlowCameraActivity.a(this.a.a).setText(NewFlowCameraActivity.c(this.a.a) + "");
      NewFlowCameraActivity.a(this.a.a).setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyo
 * JD-Core Version:    0.7.0.1
 */