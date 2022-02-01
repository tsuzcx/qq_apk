import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView.a;
import feedcloud.FeedCloudMeta.StUser;

public class pgl
  extends ClickableSpan
{
  public pgl(QCirclePushAsyncTextView paramQCirclePushAsyncTextView, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (QCirclePushAsyncTextView.a(this.a) != null) {
      QCirclePushAsyncTextView.a(this.a).e(this.b);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(QCirclePushAsyncTextView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgl
 * JD-Core Version:    0.7.0.1
 */