import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import java.util.ArrayList;

public class aco
  implements Runnable
{
  public aco(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Acq.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aco
 * JD-Core Version:    0.7.0.1
 */