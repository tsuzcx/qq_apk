import com.tencent.mobileqq.subaccount.SubAccountProtocManager;

public class glk
  implements Runnable
{
  public glk(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  public void run()
  {
    new gll(this.a, "report_subaccount").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     glk
 * JD-Core Version:    0.7.0.1
 */