import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.CpuBusyness;

public class zks
  implements Runnable
{
  public zks(ThreadRegulator paramThreadRegulator) {}
  
  public void run()
  {
    if (ThreadRegulator.a(this.a) == null) {}
    ThreadRegulator.CpuBusyness localCpuBusyness;
    do
    {
      return;
      localCpuBusyness = ThreadRegulator.a(this.a);
      ThreadRegulator.a(this.a, null);
    } while (localCpuBusyness == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zks
 * JD-Core Version:    0.7.0.1
 */