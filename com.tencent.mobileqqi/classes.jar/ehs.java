import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.TimerTask;

public class ehs
  extends TimerTask
{
  public ehs(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b);
    StatisticCollector.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
    BaseApplicationImpl.a.post(MainAssistObserver.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehs
 * JD-Core Version:    0.7.0.1
 */