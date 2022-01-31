import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class zlb
  extends BroadcastReceiver
{
  public zlb(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.l) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.broadcast", 2, "qqHeadBroadcastReceiver onReceive, app isReleased");
      }
    }
    String str;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      str = paramIntent.getAction();
      if ("com.tencent.qqhead.getheadreq".equals(str)) {
        ThreadManager.post(new zlc(this, paramContext, paramIntent), 8, null, true);
      }
    } while (!"com.tencent.qqhead.refreshheadreq".equals(str));
    ThreadManager.post(new zld(this, paramContext, paramIntent), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zlb
 * JD-Core Version:    0.7.0.1
 */