import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axjy
  implements Animator.AnimatorListener
{
  public axjy(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.c(this.this$0).setVisibility(8);
    AEEditorAILoadingView.d(this.this$0).playAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjy
 * JD-Core Version:    0.7.0.1
 */