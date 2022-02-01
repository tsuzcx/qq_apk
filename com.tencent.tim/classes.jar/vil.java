import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class vil
  implements DialogInterface.OnClickListener
{
  public vil(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.c(this.this$0.app, "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.b(this.this$0), "");
    if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.c(this.this$0))) {
      MiniAppLauncher.startMiniApp(this.this$0, NotificationActivity.c(this.this$0), 2098, null);
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vil
 * JD-Core Version:    0.7.0.1
 */