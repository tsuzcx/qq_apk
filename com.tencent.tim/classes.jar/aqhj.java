import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.startup.step.CheckPermission.a;

final class aqhj
  implements DialogInterface.OnClickListener
{
  aqhj(Activity paramActivity, CheckPermission.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.val$activity.getPackageName(), null));
      this.val$activity.startActivity(paramDialogInterface);
    }
    while (this.a == null) {
      return;
    }
    this.a.reject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhj
 * JD-Core Version:    0.7.0.1
 */