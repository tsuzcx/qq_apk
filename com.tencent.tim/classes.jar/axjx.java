import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axjx
  implements Animator.AnimatorListener
{
  public axjx(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0).setVisibility(8);
    AEEditorAILoadingView.b(this.this$0).setVisibility(0);
    AEEditorAILoadingView.b(this.this$0).playAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjx
 * JD-Core Version:    0.7.0.1
 */