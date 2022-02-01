import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axka
  implements ValueAnimator.AnimatorUpdateListener
{
  public axka(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((AEEditorAILoadingView.a(this.this$0) >= 2) && (AEEditorAILoadingView.a(this.this$0)))
    {
      AEEditorAILoadingView.a(this.this$0, false);
      AEEditorAILoadingView.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axka
 * JD-Core Version:    0.7.0.1
 */