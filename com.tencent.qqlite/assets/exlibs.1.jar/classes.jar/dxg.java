import android.content.Intent;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.BaseApplication;

public class dxg
  implements Runnable
{
  public dxg(QQLSRecentManager paramQQLSRecentManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((!QQLSRecentManager.b) && (this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), QQLSActivity.class);
      localIntent.addFlags(67108864);
      localIntent.addFlags(268435456);
      localIntent.addFlags(262144);
      localIntent.addFlags(1073741824);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dxg
 * JD-Core Version:    0.7.0.1
 */