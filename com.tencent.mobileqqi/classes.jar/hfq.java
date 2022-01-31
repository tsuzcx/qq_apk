import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

class hfq
  implements PermissionDialogCallback
{
  hfq(hfp paramhfp, BaseActivity paramBaseActivity) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200) }).request(new hfr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfq
 * JD-Core Version:    0.7.0.1
 */