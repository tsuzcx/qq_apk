import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class axla
  implements Animator.AnimatorListener
{
  public axla(AEEditorImageClipFragment paramAEEditorImageClipFragment, EditorClipView paramEditorClipView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.eNk();
    AEEditorImageClipFragment.b(this.a, true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.eNk();
    this.b.onAnimationEnd(null);
    AEEditorImageClipFragment.b(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axla
 * JD-Core Version:    0.7.0.1
 */