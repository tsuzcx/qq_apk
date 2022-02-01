import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.a;

public class pen
  extends ClickableSpan
{
  public pen(QCircleAsyncTextView paramQCircleAsyncTextView, QCircleAsyncTextView.a parama) {}
  
  public void onClick(@NonNull View paramView)
  {
    QCircleAsyncTextView.a(this.c, true);
    if (this.a != null) {
      this.a.onClick();
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pen
 * JD-Core Version:    0.7.0.1
 */