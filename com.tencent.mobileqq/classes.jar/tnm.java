import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tnm
  implements Runnable
{
  public tnm(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      if (QQLSActivity.a(this.a) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.a.a);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "unRegisterScreenListener real mScreenReceiver:" + this.a.a.hashCode() + "context :" + BaseApplicationImpl.getContext().hashCode());
        }
        QQLSActivity.a(this.a, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnm
 * JD-Core Version:    0.7.0.1
 */