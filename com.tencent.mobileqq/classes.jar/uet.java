import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import feedcloud.FeedCloudMeta.StUser;

public class uet
  extends ClickableSpan
{
  public uet(QCirclePushAsyncTextView paramQCirclePushAsyncTextView, FeedCloudMeta.StUser paramStUser) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (QCirclePushAsyncTextView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView) != null) {
      QCirclePushAsyncTextView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(QCirclePushAsyncTextView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uet
 * JD-Core Version:    0.7.0.1
 */