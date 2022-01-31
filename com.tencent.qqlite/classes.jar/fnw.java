import com.tencent.util.TimeCostTrace;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.PerfTracer;
import java.util.concurrent.ConcurrentHashMap;

public final class fnw
  implements Runnable
{
  public fnw(String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (PerfTracer.a(this.jdField_a_of_type_JavaLangString))
      {
        LocalMultiProcConfig.a(this.jdField_a_of_type_JavaLangString, 0L);
        LocalMultiProcConfig.a(this.jdField_a_of_type_JavaLangString, 0L);
      }
    }
    else if (this.b != null)
    {
      if (!PerfTracer.a(this.b)) {
        break label102;
      }
      LocalMultiProcConfig.a(this.b, this.jdField_a_of_type_Long);
    }
    label102:
    do
    {
      return;
      Long localLong = (Long)PerfTracer.a().remove(this.jdField_a_of_type_JavaLangString);
      if (!PerfTracer.b(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      TimeCostTrace.a("qzone_launch").b(this.jdField_a_of_type_JavaLangString);
      break;
      PerfTracer.a().put(this.b, Long.valueOf(this.jdField_a_of_type_Long));
    } while (!PerfTracer.b(this.b));
    TimeCostTrace.a("qzone_launch").a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fnw
 * JD-Core Version:    0.7.0.1
 */