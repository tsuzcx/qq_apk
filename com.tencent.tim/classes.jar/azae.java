import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class azae
  implements Manager
{
  public static long akW = 86400000L;
  public AtomicBoolean dJ;
  public PriorityBlockingQueue<azaf> f;
  public QQAppInterface mApp;
  Timer mTimer;
  
  public static void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  public void a(azaf paramazaf)
  {
    azaa.a(paramazaf, this.mApp);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + paramazaf.o.busiType);
    }
  }
  
  public void onDestroy()
  {
    log("onDestroy", null);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer.purge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azae
 * JD-Core Version:    0.7.0.1
 */