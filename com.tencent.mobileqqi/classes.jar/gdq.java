import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;

public class gdq
  implements DialogInterface.OnClickListener
{
  public gdq(PermissionsDialog paramPermissionsDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      PermissionsDialog.a(this.a).b();
    }
    while (paramInt != 0) {
      return;
    }
    PermissionsDialog.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gdq
 * JD-Core Version:    0.7.0.1
 */