import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class csr
  implements Runnable
{
  public csr(FriendListHandler paramFriendListHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatusPush", 2, "handlePushBatchFStatus notifyUI uin:" + this.a.a.a() + " at " + System.currentTimeMillis());
    }
    this.a.a(1, true, Boolean.valueOf(true));
    this.a.a(7, true, Boolean.valueOf(true));
    FriendListHandler.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     csr
 * JD-Core Version:    0.7.0.1
 */