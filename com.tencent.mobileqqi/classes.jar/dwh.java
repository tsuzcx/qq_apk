import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionCallback;

class dwh
  implements PermissionCallback
{
  dwh(dwg paramdwg) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.jdField_a_of_type_MqqAppAppActivity, paramInt, paramArrayOfString, new dwi(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_MqqAppAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwh
 * JD-Core Version:    0.7.0.1
 */