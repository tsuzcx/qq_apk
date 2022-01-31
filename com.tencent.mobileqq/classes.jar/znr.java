import com.tencent.qphone.base.util.QLog;

public final class znr
  extends Thread
{
  public void run()
  {
    com.tencent.mobileqq.app.ThreadManager.IsRunTimeShutDown = true;
    QLog.i("ThreadManager", 2, "QQ Runtime ShutDown");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znr
 * JD-Core Version:    0.7.0.1
 */