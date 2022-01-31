import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import java.util.ArrayList;
import java.util.List;

class cgu
  implements Runnable
{
  cgu(cgt paramcgt, List paramList) {}
  
  public void run()
  {
    ChatBackgroundSettingActivity.a(this.jdField_a_of_type_Cgt.a).clear();
    ChatBackgroundSettingActivity.a(this.jdField_a_of_type_Cgt.a).addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Cgt.a.e();
    this.jdField_a_of_type_Cgt.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cgu
 * JD-Core Version:    0.7.0.1
 */