import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;

public final class aktu
  extends ClickableSpan
{
  public aktu(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, aqju paramaqju, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$200(this.c)) {}
    for (paramView = "0X800AE75";; paramView = "0X800AE76")
    {
      anot.a(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if ((this.i != null) && (this.i.isShowing())) {
        this.i.dismiss();
      }
      if (OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$200(this.c)) {
        break;
      }
      paramView = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.access$300(this.c), true, null);
      OnlineStatusPermissionChecker.a(this.val$context, paramView);
      return;
    }
    OnlineStatusPermissionChecker.a(this.val$app, this.val$context, this.c, true);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktu
 * JD-Core Version:    0.7.0.1
 */