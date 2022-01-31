import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.LooperMonitorHelper;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class zcx
  implements Printer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private long c;
  
  public zcx(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    LooperMonitorHelper.jdField_a_of_type_Int = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.c = SystemClock.uptimeMillis();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_b_of_type_Int)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.jdField_b_of_type_Int);
      }
    }
    long l;
    do
    {
      do
      {
        return;
      } while ((this.c == 0L) || (!paramString.startsWith("<<")));
      this.jdField_a_of_type_Long += 1L;
      l = SystemClock.uptimeMillis() - this.c;
      this.c = 0L;
      this.jdField_b_of_type_Long += l;
      if (l <= LooperMonitorHelper.jdField_a_of_type_Int) {
        break;
      }
      if (!UnifiedMonitor.a().whetherReportThisTime(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_Int = 0;
        return;
      }
      paramString = this.jdField_a_of_type_JavaLangString;
      HashMap localHashMap = UnifiedMonitor.a();
      UnifiedMonitor.a().addEvent(this.jdField_b_of_type_Int, paramString, (int)l, this.jdField_a_of_type_Int, localHashMap);
      this.jdField_a_of_type_Int = 0;
    } while (!QLog.isColorLevel());
    QLog.d("AutoMonitor", 2, "MainLooper, cost=" + l + ", " + paramString);
    return;
    if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_b_of_type_Int)) {
      UnifiedMonitor.a().notifyNotTimeout(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.jdField_a_of_type_Long + ", totalCost = " + this.jdField_b_of_type_Long + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcx
 * JD-Core Version:    0.7.0.1
 */