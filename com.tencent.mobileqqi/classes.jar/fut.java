import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.QLog;

class fut
  implements Runnable
{
  fut(fus paramfus) {}
  
  public void run()
  {
    QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  thread start. . .");
    this.a.a(false);
    for (;;)
    {
      if (!this.a.b()) {}
      try
      {
        Thread.sleep(1000L);
        boolean bool = this.a.b();
        if (bool)
        {
          this.a.a(true);
          QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  thread exit. . .");
          return;
        }
        Message localMessage = new Message();
        localMessage.what = 1;
        this.a.a.a.sendMessage(localMessage);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fut
 * JD-Core Version:    0.7.0.1
 */