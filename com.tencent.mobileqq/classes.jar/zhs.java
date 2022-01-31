import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public class zhs
  implements Runnable
{
  public zhs(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((!this.a.isLogin()) || (this.a.l)) {}
    for (int i = 0;; i = this.a.f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.a.isLogin()), Boolean.valueOf(this.a.l) }));
      }
      BadgeUtils.a(QQAppInterface.l(this.a), i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhs
 * JD-Core Version:    0.7.0.1
 */