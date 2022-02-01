package cooperation.qzone.contentbox;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$3
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.val$app.a().createEntityManager();
    try
    {
      localEntityManager.drop(QZoneMsgEntityNew.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      if (localEntityManager != null) {
        localEntityManager.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.3
 * JD-Core Version:    0.7.0.1
 */