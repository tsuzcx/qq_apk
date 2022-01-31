import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class tnu
  implements Runnable
{
  public tnu(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("moveTaskToBack", 2, "moveTaskToBackInSubThread");
    }
    try
    {
      this.a.moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("moveTaskToBack", 2, "moveTaskToBack e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnu
 * JD-Core Version:    0.7.0.1
 */