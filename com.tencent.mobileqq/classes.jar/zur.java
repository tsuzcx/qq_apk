import com.tencent.mobileqq.ar.ARRecord.ARRecordReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class zur
  implements Runnable
{
  public zur(ARRecordReport paramARRecordReport, int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplication.getContext()).a("", "ar_record_record_success", true, 0L, this.jdField_a_of_type_Long, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zur
 * JD-Core Version:    0.7.0.1
 */