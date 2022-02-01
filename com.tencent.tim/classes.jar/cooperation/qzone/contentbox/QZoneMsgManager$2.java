package cooperation.qzone.contentbox;

import avto;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(avto paramavto, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    Object localObject3 = null;
    EntityManager localEntityManager2 = null;
    localEntityManager1 = localEntityManager2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.getApp();
        if (localQQAppInterface != null) {
          continue;
        }
        localEntityManager1 = localEntityManager2;
        localObject1 = localObject3;
        QZLog.e("QZoneMsgManager", "saveMsgToDB error app == null");
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localEntityManager1;
        QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
        if (localEntityManager1 == null) {
          continue;
        }
        localEntityManager1.close();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((EntityManager)localObject1).close();
      }
      return;
      localEntityManager1 = localEntityManager2;
      localObject1 = localObject3;
      this.b.writeArkNewsToBuffer();
      localEntityManager1 = localEntityManager2;
      localObject1 = localObject3;
      localEntityManager2 = localQQAppInterface.a().createEntityManager();
      localEntityManager1 = localEntityManager2;
      localObject1 = localEntityManager2;
      if (this.b.getStatus() == 1000)
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.persist(this.b);
        if (localEntityManager2 != null) {
          localEntityManager2.close();
        }
      }
      else
      {
        localEntityManager1 = localEntityManager2;
        localObject1 = localEntityManager2;
        localEntityManager2.update(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */