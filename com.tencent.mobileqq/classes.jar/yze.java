import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.qphone.base.util.QLog;

public class yze
  implements Runnable
{
  public yze(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    try
    {
      this.a.e();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloPanel", 1, "[reportTabExposure] failed, excetion2=", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yze
 * JD-Core Version:    0.7.0.1
 */