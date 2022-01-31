import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.dingdong.data.OfficeCenterSharedPref;

public class tlc
  implements Runnable
{
  public tlc(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + localQQAppInterface.getLongAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlc
 * JD-Core Version:    0.7.0.1
 */