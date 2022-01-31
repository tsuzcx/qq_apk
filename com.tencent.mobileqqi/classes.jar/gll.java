import com.tencent.mobileqq.subaccount.SubAccountProtocManager;

public class gll
  implements Runnable
{
  public gll(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  public void run()
  {
    new glm(this.a, "report_subaccount").start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gll
 * JD-Core Version:    0.7.0.1
 */