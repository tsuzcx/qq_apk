import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class azk
  implements DialogInterface.OnClickListener
{
  public azk(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://haoma.qq.com/m/expire.html?num=" + NotificationActivity.a(this.a);
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azk
 * JD-Core Version:    0.7.0.1
 */