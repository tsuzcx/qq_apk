import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

final class aqmy
  extends ClickableSpan
{
  aqmy(Context paramContext, ajws paramajws) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.val$context, QQBrowserActivity.class);
    paramView.putExtra("url", this.b.jV());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "mVideoData.topicInfo.getTopicJumpUrl() :" + this.b.jV());
    }
    this.val$context.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#00aced"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmy
 * JD-Core Version:    0.7.0.1
 */