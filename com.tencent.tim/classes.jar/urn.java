import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class urn
  extends ClickableSpan
{
  public urn(CloudFileActivity paramCloudFileActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("uin", this.this$0.app.getCurrentAccountUin());
    paramView.putExtra("hide_more_button", true);
    paramView.putExtra("hide_operation_bar", true);
    this.this$0.startActivity(paramView.putExtra("url", "https://tim.qq.com/htdocs/2.0_lead/more.html"));
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.this$0.getResources().getColor(2131165652));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urn
 * JD-Core Version:    0.7.0.1
 */