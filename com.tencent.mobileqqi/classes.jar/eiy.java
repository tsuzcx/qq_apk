import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import java.util.TimerTask;

public class eiy
  extends TimerTask
{
  public eiy(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper == null);
    this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.j);
    this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eiy
 * JD-Core Version:    0.7.0.1
 */