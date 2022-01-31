import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionCallback;

class dwk
  implements PermissionCallback
{
  dwk(dwj paramdwj) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.jdField_a_of_type_MqqAppAppActivity, paramInt, paramArrayOfString, new dwl(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PlusPanelUtils.a(this.a.jdField_a_of_type_MqqAppAppActivity, this.a.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dwk
 * JD-Core Version:    0.7.0.1
 */