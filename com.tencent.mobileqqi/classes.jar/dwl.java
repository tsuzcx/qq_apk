import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public final class dwl
  implements PermissionDialogCallback
{
  public dwl(AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_MqqAppAppActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new dwm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwl
 * JD-Core Version:    0.7.0.1
 */