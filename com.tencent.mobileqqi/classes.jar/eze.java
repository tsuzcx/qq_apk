import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class eze
  implements Runnable
{
  public eze(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    BaseActivity.s = false;
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "startUnlockActivity.mShowGesture set false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eze
 * JD-Core Version:    0.7.0.1
 */