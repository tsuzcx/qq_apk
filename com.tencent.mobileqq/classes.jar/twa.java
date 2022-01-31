import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class twa
  implements Runnable
{
  public twa(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    HttpDownloadUtil.a(this.a.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     twa
 * JD-Core Version:    0.7.0.1
 */