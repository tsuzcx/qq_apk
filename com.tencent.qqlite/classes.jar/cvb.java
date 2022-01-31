import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;

public class cvb
  extends BroadcastReceiver
{
  public cvb(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadreq".equals(paramIntent.getAction()))) {
      QQAppInterface.a(this.a, paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvb
 * JD-Core Version:    0.7.0.1
 */