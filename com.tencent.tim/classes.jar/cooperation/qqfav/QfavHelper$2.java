package cooperation.qqfav;

import avja;
import com.tencent.qphone.base.util.QLog;

public final class QfavHelper$2
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "notify(sPluginInstalled) qqfav.apk");
      }
      avja.access$000().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.2
 * JD-Core Version:    0.7.0.1
 */