import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qphone.base.util.QLog;

public class tku
  implements Runnable
{
  public tku(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    boolean bool = ApolloGameUtil.a(this.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "[updateCmshowStatus] isApolloUser=", Boolean.valueOf(bool) });
    }
    if (bool) {
      this.a.m();
    }
    this.a.c();
    if (bool) {
      this.a.d();
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */