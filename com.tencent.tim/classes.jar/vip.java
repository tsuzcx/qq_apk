import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class vip
  implements DialogInterface.OnClickListener
{
  public vip(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.c(this.this$0.app, "dc00898", "", NotificationActivity.d(this.this$0), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.a(this.this$0));
    paramDialogInterface = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
    this.this$0.startActivity(paramDialogInterface.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"));
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vip
 * JD-Core Version:    0.7.0.1
 */