import android.view.View;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

class csi
  implements PermissionDialogCallback
{
  csi(csc paramcsc, View paramView, int paramInt) {}
  
  public void a() {}
  
  public void b()
  {
    this.jdField_a_of_type_Csc.a.a().permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new csj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csi
 * JD-Core Version:    0.7.0.1
 */