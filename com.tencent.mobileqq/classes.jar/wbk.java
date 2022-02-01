import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;

public class wbk
  extends ClickableSpan
{
  public wbk(QCirclePushAsyncTextView paramQCirclePushAsyncTextView) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (QCirclePushAsyncTextView.a(this.a) != null) {
      QCirclePushAsyncTextView.a(this.a).b();
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#03081A"));
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(bdep.a(13.0F));
    aadv.a(paramTextPaint, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */