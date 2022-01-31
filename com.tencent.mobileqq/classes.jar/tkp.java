import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Card;

public class tkp
  implements Runnable
{
  public tkp(QQSettingSettingActivity paramQQSettingSettingActivity, FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingSettingActivity.runOnUiThread(new tkq(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */