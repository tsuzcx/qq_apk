import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class zyv
  implements Runnable
{
  public zyv(ScanEntranceReport paramScanEntranceReport, long paramLong1, long paramLong2, String paramString, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("proc_exist", String.valueOf(ScanEntranceReport.a(this.jdField_a_of_type_ComTencentMobileqqArScanEntranceReport)));
    localHashMap.put("proc_restart", String.valueOf(ScanEntranceReport.b(this.jdField_a_of_type_ComTencentMobileqqArScanEntranceReport)));
    localHashMap.put("proc_load_time", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("activity_launch_time", String.valueOf(this.b));
    localHashMap.put("entry_source", this.jdField_a_of_type_JavaLangString);
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_activity_launch", true, this.c, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyv
 * JD-Core Version:    0.7.0.1
 */