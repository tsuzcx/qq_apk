import com.tencent.mobileqq.activity.LoginActivity;
import mqq.app.permission.PermissionCallback;

class cth
  implements PermissionCallback
{
  cth(ctg paramctg) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LoginActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity, this.a.jdField_a_of_type_AndroidViewView);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LoginActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity, this.a.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cth
 * JD-Core Version:    0.7.0.1
 */