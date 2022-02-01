import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.CheckPermission.a;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public final class anms
  implements QQPermissionCallback
{
  public anms(CheckPermission.a parama, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CheckPermission.showSDCardExplainDialog(this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission$a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqStartupStepCheckPermission$a.bK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anms
 * JD-Core Version:    0.7.0.1
 */