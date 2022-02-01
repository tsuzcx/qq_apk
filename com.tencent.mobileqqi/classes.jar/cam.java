import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import java.util.ArrayList;
import java.util.List;

class cam
  implements Runnable
{
  cam(cal paramcal, List paramList) {}
  
  public void run()
  {
    ChatBackgroundSettingActivity.a(this.jdField_a_of_type_Cal.a).clear();
    ChatBackgroundSettingActivity.a(this.jdField_a_of_type_Cal.a).addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Cal.a.e();
    this.jdField_a_of_type_Cal.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cam
 * JD-Core Version:    0.7.0.1
 */