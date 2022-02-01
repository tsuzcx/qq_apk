import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axjz
  implements Animator.AnimatorListener
{
  public axjz(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0, AEEditorAILoadingView.a(this.this$0) + 1);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorAILoadingView.a(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjz
 * JD-Core Version:    0.7.0.1
 */