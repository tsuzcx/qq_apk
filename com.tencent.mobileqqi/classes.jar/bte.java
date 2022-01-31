import com.tencent.mobileqq.activity.AddContactsActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class bte
  implements PermissionDialogCallback
{
  public bte(AddContactsActivity paramAddContactsActivity) {}
  
  public void a() {}
  
  public void b()
  {
    this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.ACCESS_FINE_LOCATION", 500) }).request(new btf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bte
 * JD-Core Version:    0.7.0.1
 */