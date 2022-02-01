import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorImageClipFragment;
import dov.com.qq.im.aeeditor.view.ClipConstant.Anchor;
import dov.com.qq.im.aeeditor.view.EditorClipView;

public class axky
  implements ValueAnimator.AnimatorUpdateListener
{
  public axky(AEEditorImageClipFragment paramAEEditorImageClipFragment, EditorClipView paramEditorClipView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.aeu(ClipConstant.Anchor.TOP.v);
    this.b.onScroll(0.0F, i - AEEditorImageClipFragment.b(this.a));
    AEEditorImageClipFragment.d(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axky
 * JD-Core Version:    0.7.0.1
 */