import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class efk
  implements Runnable
{
  public efk(StartupDirector paramStartupDirector, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = BaseApplicationImpl.a.a();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004842", "0X8004842", 0, 0, "" + this.jdField_a_of_type_Boolean, "" + this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.b, "" + StartupDirector.a(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector), "");
      }
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      Log.i("AutoMonitor", "ActionLoginM, cost=" + this.b);
      localObject = new HashMap();
      ((HashMap)localObject).put("cost", this.b + "");
      StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginM", true, this.b, 0L, (HashMap)localObject, null);
    }
    if (this.c < 0L)
    {
      Log.i("AutoMonitor", "ActionLoginS, cost=" + this.d);
      localObject = new HashMap();
      ((HashMap)localObject).put("cost", this.d + "");
      StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginS", true, this.d, 0L, (HashMap)localObject, null);
    }
    QQAppInterface localQQAppInterface;
    if (BaseApplicationImpl.g == 1)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.a();
      localObject = localQQAppInterface.getAccount();
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label372;
      }
      localObject = "0";
    }
    label372:
    for (;;)
    {
      ReportController.a(localQQAppInterface, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.a, (String)localObject), "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     efk
 * JD-Core Version:    0.7.0.1
 */