import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public final class dwc
  implements PermissionDialogCallback
{
  public dwc(AppActivity paramAppActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_MqqAppAppActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new dwd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwc
 * JD-Core Version:    0.7.0.1
 */