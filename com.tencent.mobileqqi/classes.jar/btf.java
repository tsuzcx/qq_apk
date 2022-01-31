import android.content.Intent;
import com.tencent.mobileqq.activity.AddContactsActivity;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import mqq.app.permission.PermissionCallback;

class btf
  implements PermissionCallback
{
  btf(bte parambte) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a, paramInt, paramArrayOfString, new btg(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.startActivity(new Intent(this.a.a, NearbyTroopsActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     btf
 * JD-Core Version:    0.7.0.1
 */