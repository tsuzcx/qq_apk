import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;

public class ucb
  extends ClickableSpan
{
  public ucb(QCirclePushAsyncTextView paramQCirclePushAsyncTextView) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (QCirclePushAsyncTextView.a(this.a) != null) {
      QCirclePushAsyncTextView.a(this.a).a();
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucb
 * JD-Core Version:    0.7.0.1
 */