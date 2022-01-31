import android.os.Handler;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class tso
  implements Runnable
{
  public tso(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tso
 * JD-Core Version:    0.7.0.1
 */