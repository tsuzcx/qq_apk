import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class azu
  implements DialogInterface.OnClickListener
{
  public azu(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.logout(true);
    SharedPreUtils.a(this.a.app.a(), this.a.app.a(), false);
    this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azu
 * JD-Core Version:    0.7.0.1
 */