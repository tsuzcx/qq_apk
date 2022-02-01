import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import java.lang.ref.SoftReference;

public class aezz
  extends ClickableSpan
{
  public aezz(MessageForQQWalletTips paramMessageForQQWalletTips, String paramString, SoftReference paramSoftReference, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.val$url)) {}
    do
    {
      return;
      paramView = (Context)this.q.get();
    } while (paramView == null);
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", this.val$url);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramView.startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.TJ);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aezz
 * JD-Core Version:    0.7.0.1
 */