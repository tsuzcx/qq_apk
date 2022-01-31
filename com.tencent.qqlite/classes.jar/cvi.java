import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class cvi
  extends Handler
{
  public cvi(QQAppInterface paramQQAppInterface, Looper paramLooper)
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
    QLog.d(QQAppInterface.jdField_b_of_type_JavaLangString, 2, "getOnlineFriend app is null");
    return;
    long l1 = QQAppInterface.bi;
    long l2 = SystemClock.uptimeMillis();
    long l3 = l2 - this.a.jdField_b_of_type_Long;
    if ((!"0".equals(paramMessage.a())) && (l3 > QQAppInterface.bi))
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQAppInterface.jdField_b_of_type_JavaLangString, 2, "getOnlineFriend");
      }
      this.a.jdField_b_of_type_Long = l2;
      FriendListHandler localFriendListHandler = (FriendListHandler)paramMessage.a(1);
      if (localFriendListHandler != null) {
        localFriendListHandler.d(paramMessage.a(), (byte)0);
      }
    }
    if (l3 < QQAppInterface.bi) {
      l1 = QQAppInterface.bi - l3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQAppInterface.jdField_b_of_type_JavaLangString, 2, "getOnlineFriend send next msg " + l1);
      }
      paramMessage = this.a.a.obtainMessage(0, new WeakReference(paramMessage));
      this.a.a.sendMessageDelayed(paramMessage, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvi
 * JD-Core Version:    0.7.0.1
 */