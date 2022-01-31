import com.tencent.mobileqq.activity.SecurityProtectActivity;
import com.tencent.mobileqq.utils.HttpDownloadUtil;

public class dnd
  implements Runnable
{
  public dnd(SecurityProtectActivity paramSecurityProtectActivity) {}
  
  public void run()
  {
    HttpDownloadUtil.a(this.a.b, this.a.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnd
 * JD-Core Version:    0.7.0.1
 */