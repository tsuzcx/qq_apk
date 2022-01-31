import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionDialogCallback;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class bmv
  implements PermissionDialogCallback
{
  public bmv(ScannerActivity paramScannerActivity) {}
  
  public void a() {}
  
  public void b()
  {
    this.a.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new bmw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmv
 * JD-Core Version:    0.7.0.1
 */