import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import mqq.app.AppRuntime.Status;

class aksg
  extends ClickableSpan
{
  aksg(akrv paramakrv, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.e);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.aen);
    PublicFragmentActivity.start(akrv.a(this.this$0), paramView, AccountOnlineStateActivity.class);
    if ((akrv.a(this.this$0) != null) && (akrv.a(this.this$0).isShowing()))
    {
      akrv.a(this.this$0).dismiss();
      akrv.a(this.this$0, null);
    }
    anot.a(akrv.a(this.this$0), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksg
 * JD-Core Version:    0.7.0.1
 */