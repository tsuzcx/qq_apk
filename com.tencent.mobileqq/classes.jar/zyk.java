import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.NeonControl.AvgConsumeReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class zyk
  implements Runnable
{
  public zyk(NeonControl paramNeonControl, NeonControl.AvgConsumeReport paramAvgConsumeReport, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b));
    localHashMap.put("selimg_frame_consume", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_selimg_frame_consume", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqArNeonControl$AvgConsumeReport.b) }));
      ARDebugReport.a().a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyk
 * JD-Core Version:    0.7.0.1
 */