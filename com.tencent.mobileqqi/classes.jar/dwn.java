import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionCallback;

class dwn
  implements PermissionCallback
{
  dwn(dwm paramdwm) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.jdField_a_of_type_MqqAppAppActivity, paramInt, paramArrayOfString, new dwo(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_MqqAppAppActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwn
 * JD-Core Version:    0.7.0.1
 */