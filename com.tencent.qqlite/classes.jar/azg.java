import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class azg
  implements DialogInterface.OnClickListener
{
  public azg(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://aq.qq.com/007?from=andapp&account=" + NotificationActivity.a(this.a);
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(localIntent.putExtra("url", paramDialogInterface));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azg
 * JD-Core Version:    0.7.0.1
 */