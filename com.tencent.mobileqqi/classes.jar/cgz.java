import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import java.util.ArrayList;
import java.util.List;

public class cgz
  implements Runnable
{
  public cgz(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ChatBackgroundSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity).clear();
      ChatBackgroundSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity).addAll(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgz
 * JD-Core Version:    0.7.0.1
 */