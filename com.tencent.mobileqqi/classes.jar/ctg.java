import android.view.View;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class ctg
  implements PermissionDialogCallback
{
  public ctg(LoginActivity paramLoginActivity, View paramView) {}
  
  public void a()
  {
    LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new cth(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctg
 * JD-Core Version:    0.7.0.1
 */