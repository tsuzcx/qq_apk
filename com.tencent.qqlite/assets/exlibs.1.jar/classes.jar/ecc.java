import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SameStatusActivity;

public class ecc
  implements Runnable
{
  public ecc(SameStatusActivity paramSameStatusActivity) {}
  
  public void run()
  {
    this.a.app.c(false, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecc
 * JD-Core Version:    0.7.0.1
 */