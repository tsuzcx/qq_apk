import com.tencent.mobileqq.subaccount.SubAccountProtocManager;

public class gps
  implements Runnable
{
  public gps(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  public void run()
  {
    new gpt(this.a, "report_subaccount").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gps
 * JD-Core Version:    0.7.0.1
 */