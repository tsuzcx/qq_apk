import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public final class dwf
  implements PermissionDialogCallback
{
  public dwf(AppActivity paramAppActivity, QQAppInterface paramQQAppInterface) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_MqqAppAppActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new dwg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwf
 * JD-Core Version:    0.7.0.1
 */