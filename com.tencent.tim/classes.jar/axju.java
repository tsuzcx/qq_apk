import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axju
  implements ValueAnimator.AnimatorUpdateListener
{
  public axju(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AEEditorAILoadingView.c(this.this$0).setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axju
 * JD-Core Version:    0.7.0.1
 */