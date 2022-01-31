import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class zyz
  implements Runnable
{
  public zyz(ScanEntranceReport paramScanEntranceReport, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, long paramLong3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("first_init", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("init_delay", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("init_time", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("download_resource", String.valueOf(this.jdField_b_of_type_Boolean));
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_ar_init", true, this.c, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyz
 * JD-Core Version:    0.7.0.1
 */