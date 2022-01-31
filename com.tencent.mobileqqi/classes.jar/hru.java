import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;

public class hru
  implements TicketUtils.TicketCallback
{
  public hru(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, long paramLong, Activity paramActivity) {}
  
  public void a()
  {
    LogUtility.a("MyAppApi", "onGetA1Fail ---");
    ThreadManager.b().post(new hrw(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.a("MyAppApi", "onGetA1 ---");
    ThreadManager.b().post(new hrv(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hru
 * JD-Core Version:    0.7.0.1
 */