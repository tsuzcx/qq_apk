import android.content.Intent;
import android.os.Handler;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.5;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.5.1.1;

public class vsg
  extends ClickableSpan
{
  public vsg(RegisterVerifyCodeActivity.5 param5, String paramString) {}
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.aPB));
    if (TextUtils.isEmpty(RegisterVerifyCodeActivity.b(this.a.this$0))) {}
    while (!RegisterVerifyCodeActivity.a(this.a.this$0)) {
      return;
    }
    RegisterVerifyCodeActivity.a(this.a.this$0, false);
    this.a.this$0.handler.postDelayed(new RegisterVerifyCodeActivity.5.1.1(this), 1000L);
    paramView = new Intent(this.a.this$0, QQBrowserActivity.class);
    paramView.putExtra("url", RegisterVerifyCodeActivity.b(this.a.this$0));
    paramView.putExtra("hide_more_button", true);
    this.a.this$0.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsg
 * JD-Core Version:    0.7.0.1
 */