import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.b;
import java.util.HashSet;

public class albs
  implements Animator.AnimatorListener
{
  public albs(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, PersonalityLabelGalleryActivity.b paramb, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.bs.remove(Long.valueOf(this.a.XM));
    paramAnimator = (FrameLayout.LayoutParams)this.val$container.getLayoutParams();
    paramAnimator.height = -2;
    this.val$container.setLayoutParams(paramAnimator);
    this.val$container.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.bs.remove(Long.valueOf(this.a.XM));
    paramAnimator = (FrameLayout.LayoutParams)this.val$container.getLayoutParams();
    paramAnimator.height = -2;
    this.val$container.setLayoutParams(paramAnimator);
    this.val$container.setTag(Boolean.valueOf(false));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albs
 * JD-Core Version:    0.7.0.1
 */