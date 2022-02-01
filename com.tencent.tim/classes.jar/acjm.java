import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acjm
  extends BroadcastReceiver
{
  public acjm(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.isReleased) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.broadcast", 2, "qqHeadBroadcastReceiver onReceive, app isReleased");
      }
    }
    while ((paramIntent == null) || (!"com.tencent.qqhead.getheadreq".equals(paramIntent.getAction()))) {
      return;
    }
    QQAppInterface.d(this.this$0, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjm
 * JD-Core Version:    0.7.0.1
 */