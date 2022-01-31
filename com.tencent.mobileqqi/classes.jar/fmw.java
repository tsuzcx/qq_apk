import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class fmw
  extends Thread
{
  public fmw(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Card localCard = ProfileCardUtil.a(this.a, this.a.a());
    if (localCard != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet_birth", 2, "card!=null");
      }
      j = (int)localCard.lBirthday;
      i = ProfileUtil.c(j);
      j = ProfileUtil.d(j);
      SharedPreUtils.b(this.a.a(), ConfigServlet.a(i, j));
      i = ConfigServlet.a(new SimpleDateFormat("MM-dd").format(new Date()), ConfigServlet.a(i, j));
      if ((i >= 0) && (i <= 3))
      {
        ConfigServlet.a(this.a, 3);
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet_birth", 2, "birthday coming soon,date diff is " + i);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int j;
      int i;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("SPLASH_ConfigServlet_birth", 2, "not birthday date diff is " + i);
      return;
    }
    QLog.i("SPLASH_ConfigServlet_birth", 2, "card===null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fmw
 * JD-Core Version:    0.7.0.1
 */