import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;

public class hno
  extends BroadcastReceiver
{
  public hno(MyAppApi paramMyAppApi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.i.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hno
 * JD-Core Version:    0.7.0.1
 */