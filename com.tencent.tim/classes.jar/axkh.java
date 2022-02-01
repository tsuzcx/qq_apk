import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView.2;

public class axkh
  implements Animator.AnimatorListener
{
  public axkh(AEEditorComicLoadingView.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.this$0.cancelLoading();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.this$0.cancelLoading();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkh
 * JD-Core Version:    0.7.0.1
 */