import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.TimerTask;

public class cek
  extends TimerTask
{
  public cek(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      StatisticCollector.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
      MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cek
 * JD-Core Version:    0.7.0.1
 */