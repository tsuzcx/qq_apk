import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;

public class axjr
  implements ValueAnimator.AnimatorUpdateListener
{
  public axjr(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(AEEditorAILoadingView.f(1000.0F, paramValueAnimator.getAnimatedFraction(), 0.0F, 1.0F) * 75.0F - 75.0F);
    AEEditorAILoadingView.b(this.this$0).setPadding(0, i, 0, 0);
    AEEditorAILoadingView.c(this.this$0).setPadding(0, i, 0, 0);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)AEEditorAILoadingView.b(this.this$0).getLayoutParams();
    paramValueAnimator.topMargin = (i + AEEditorAILoadingView.b(this.this$0));
    AEEditorAILoadingView.b(this.this$0).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjr
 * JD-Core Version:    0.7.0.1
 */