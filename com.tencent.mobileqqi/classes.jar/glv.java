import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.BaseApplication;

public class glv
  implements Runnable
{
  public glv(GroupSystemMsgController paramGroupSystemMsgController, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("group_display", this.jdField_a_of_type_JavaLangString).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glv
 * JD-Core Version:    0.7.0.1
 */