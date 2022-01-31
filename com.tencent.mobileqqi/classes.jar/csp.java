import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class csp
  implements Runnable
{
  public csp(Leba paramLeba) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "init leba list when init UI in refreshAllListInUI()");
    }
    Leba.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csp
 * JD-Core Version:    0.7.0.1
 */