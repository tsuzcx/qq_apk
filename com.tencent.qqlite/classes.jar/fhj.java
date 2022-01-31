import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;

public class fhj
  extends BroadcastReceiver
{
  public fhj(MyAppApi paramMyAppApi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqql.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhj
 * JD-Core Version:    0.7.0.1
 */