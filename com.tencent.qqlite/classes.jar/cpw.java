import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class cpw
  implements Runnable
{
  public cpw(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    BaseActivity.u = false;
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "startUnlockActivity.mShowGesture set false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cpw
 * JD-Core Version:    0.7.0.1
 */