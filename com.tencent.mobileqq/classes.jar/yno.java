import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;

public class yno
  implements Runnable
{
  public yno(CmGameAvHandler paramCmGameAvHandler) {}
  
  public void run()
  {
    CmGameAvHandler.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */