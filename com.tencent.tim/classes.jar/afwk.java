import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class afwk
  implements DialogInterface.OnClickListener
{
  afwk(afwh paramafwh, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$context != null) {}
    try
    {
      paramDialogInterface = new Intent(this.val$context, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", afwh.a(this.a));
      this.val$context.startActivity(paramDialogInterface);
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog click confirm " + afwh.a(this.a));
      }
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwk
 * JD-Core Version:    0.7.0.1
 */