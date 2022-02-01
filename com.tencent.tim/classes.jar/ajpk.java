import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

final class ajpk
  implements DialogInterface.OnClickListener
{
  ajpk(String paramString, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.val$url + "&from=" + this.val$from;
    Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.val$context.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "open download page, url=" + paramDialogInterface);
    }
    if (this.val$from == 1) {
      anot.a(null, "dc00899", "grp_lbs", "", "app_down", "msg_down", 0, 0, "", "", "", "");
    }
    while (this.val$from != 2) {
      return;
    }
    anot.a(null, "dc00899", "grp_lbs", "", "app_down", "pic_down", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpk
 * JD-Core Version:    0.7.0.1
 */