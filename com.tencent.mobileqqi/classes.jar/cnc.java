import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

class cnc
  implements PermissionDialogCallback
{
  cnc(cnb paramcnb, View paramView, int paramInt) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_Cnb.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new cnd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnc
 * JD-Core Version:    0.7.0.1
 */