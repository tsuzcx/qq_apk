import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class aqhn
  implements DialogInterface.OnClickListener
{
  aqhn(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.val$activity.getPackageName(), null));
      this.val$activity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhn
 * JD-Core Version:    0.7.0.1
 */