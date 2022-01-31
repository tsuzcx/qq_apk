import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.transfile.dns.InnerDns;

public class tnc
  implements Runnable
{
  public tnc(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    InnerDns.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnc
 * JD-Core Version:    0.7.0.1
 */