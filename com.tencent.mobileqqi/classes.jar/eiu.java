import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionCallback;

public class eiu
  implements PermissionCallback
{
  public eiu(MainAssistObserver paramMainAssistObserver, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new eiv(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eiu
 * JD-Core Version:    0.7.0.1
 */