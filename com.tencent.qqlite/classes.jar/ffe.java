import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;

public class ffe
  implements TicketUtils.TicketCallback
{
  public ffe(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, long paramLong, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void a()
  {
    LogUtility.a("MyAppApi", "onGetA1Fail ---");
    ThreadManager.b().post(new ffg(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.a("MyAppApi", "onGetA1 ---");
    ThreadManager.b().post(new fff(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ffe
 * JD-Core Version:    0.7.0.1
 */