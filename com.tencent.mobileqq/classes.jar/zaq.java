import android.os.SystemClock;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

public class zaq
  implements Runnable
{
  public zaq(BaseBusinessHandler paramBaseBusinessHandler, BusinessObserver paramBusinessObserver, int paramInt, MqqHandler paramMqqHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_MqqOsMqqHandler == BaseBusinessHandler.a()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_MqqOsMqqHandler == BaseBusinessHandler.a()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (BaseBusinessHandler.c() == -1) {
        BaseBusinessHandler.a(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > BaseBusinessHandler.c())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.getClass().getName(), (int)l1, BaseBusinessHandler.d(), null);
        }
        BaseBusinessHandler.b(0);
      }
    }
    else
    {
      return;
    }
    BaseBusinessHandler.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zaq
 * JD-Core Version:    0.7.0.1
 */