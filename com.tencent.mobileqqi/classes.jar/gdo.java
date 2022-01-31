import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;

public class gdo
  implements DialogInterface.OnClickListener
{
  public gdo(PermissionsDialog paramPermissionsDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.parse("package:" + PermissionsDialog.a(this.a).getPackageName()));
      PermissionsDialog.a(this.a).startActivity(paramDialogInterface);
      PermissionsDialog.a(this.a).finish();
      PermissionsDialog.a(this.a).b();
    }
    while (paramInt != 0) {
      return;
    }
    PermissionsDialog.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdo
 * JD-Core Version:    0.7.0.1
 */