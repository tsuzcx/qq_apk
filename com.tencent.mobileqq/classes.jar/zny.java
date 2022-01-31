import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.CpuBusyness;

public class zny
  implements Runnable
{
  public zny(ThreadRegulator paramThreadRegulator) {}
  
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
 * Qualified Name:     zny
 * JD-Core Version:    0.7.0.1
 */