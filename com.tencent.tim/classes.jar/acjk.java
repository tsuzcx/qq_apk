import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class acjk
  extends Handler
{
  public acjk(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (QQAppInterface)((WeakReference)paramMessage.obj).get();
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQAppInterface", 2, "getOnlineFriend app is null");
    return;
    long l1 = QQAppInterface.cxr;
    long l3 = SystemClock.uptimeMillis();
    long l2 = Math.abs(l3 - this.this$0.QG);
    if ((!"0".equals(paramMessage.getCurrentAccountUin())) && (l2 >= QQAppInterface.cxr))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getOnlineFriend");
      }
      this.this$0.QG = l3;
      FriendListHandler localFriendListHandler = (FriendListHandler)paramMessage.getBusinessHandler(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.e(paramMessage.getCurrentAccountUin(), (byte)0);
      }
    }
    if (l2 < QQAppInterface.cxr) {
      l1 = QQAppInterface.cxr - l2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getOnlineFriend send next msg " + l1);
    }
    paramMessage = this.this$0.cw.obtainMessage(0, new WeakReference(paramMessage));
    this.this$0.cw.sendMessageDelayed(paramMessage, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjk
 * JD-Core Version:    0.7.0.1
 */