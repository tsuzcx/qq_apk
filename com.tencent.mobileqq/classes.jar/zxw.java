import com.tencent.mobileqq.ar.ARRecord.ARRecordReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class zxw
  implements Runnable
{
  public zxw(ARRecordReport paramARRecordReport, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a("", "ar_record_active_record_start", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */