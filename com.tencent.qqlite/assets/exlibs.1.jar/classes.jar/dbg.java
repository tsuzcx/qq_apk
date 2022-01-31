import android.app.Activity;
import com.tencent.mobileqq.activity.UpgradeTipsDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;

public class dbg
  implements Runnable
{
  public dbg(UpgradeController paramUpgradeController, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    new UpgradeTipsDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbg
 * JD-Core Version:    0.7.0.1
 */