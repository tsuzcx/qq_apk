import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

class xdj
  extends ClickableSpan
{
  xdj(xci paramxci) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if ((this.this$0.mContext instanceof Activity))
    {
      localIntent = new Intent(this.this$0.mContext, EditActivity.class);
      paramView = ((acdu)this.this$0.app.getManager(53)).a(this.this$0.sessionInfo.aTl);
      if ((paramView == null) || (!paramView.hasRenamed())) {
        break label193;
      }
    }
    label193:
    for (paramView = paramView.discussionName;; paramView = "")
    {
      localIntent.putExtra("title", 2131692887);
      localIntent.putExtra("action", 102);
      localIntent.putExtra("limit", 48);
      localIntent.putExtra("current", paramView);
      localIntent.putExtra("canPostNull", false);
      localIntent.putExtra("multiLine", false);
      localIntent.putExtra("selfSet_leftViewText", this.this$0.mContext.getString(2131690700));
      ((Activity)this.this$0.mContext).startActivityForResult(localIntent, 6002);
      anot.a(this.this$0.app, "CliOper", "", "", "0X800666A", "0X800666A", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdj
 * JD-Core Version:    0.7.0.1
 */