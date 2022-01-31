import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.FramePerformanceMonitor.FrameRefreshListener;
import com.tencent.mobileqq.ar.GapDataCollector;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;

public class zyi
  implements Runnable
{
  private boolean jdField_a_of_type_Boolean;
  
  private zyi(FramePerformanceMonitor paramFramePerformanceMonitor) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (FramePerformanceMonitor.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor).a() == 0) {
            Thread.sleep(FramePerformanceMonitor.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor));
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      GapDataCollector.RefreshData localRefreshData = FramePerformanceMonitor.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor).a();
      FramePerformanceMonitor.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor).a(localRefreshData);
      Thread.sleep(FramePerformanceMonitor.a(this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyi
 * JD-Core Version:    0.7.0.1
 */