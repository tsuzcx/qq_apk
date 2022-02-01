import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class alkf
  implements Manager
{
  private ProxyManager b;
  private Object ep = new Object();
  private ConcurrentHashMap<String, QCallCardInfo> gD = new ConcurrentHashMap();
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  
  public alkf(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = paramQQAppInterface.a();
  }
  
  private EntityManager b()
  {
    if ((this.mEntityManager == null) || (!this.mEntityManager.isOpen())) {}
    synchronized (this.ep)
    {
      if ((this.mEntityManager == null) || (!this.mEntityManager.isOpen())) {
        this.mEntityManager = this.mApp.a().createEntityManager();
      }
      return this.mEntityManager;
    }
  }
  
  private void dGq()
  {
    if ((this.mEntityManager != null) && (this.mEntityManager.isOpen())) {
      this.mEntityManager.close();
    }
  }
  
  public QCallCardInfo a(String paramString)
  {
    if (this.gD.containsKey(paramString)) {
      return (QCallCardInfo)this.gD.get(paramString);
    }
    paramString = b().query(QCallCardInfo.class, false, "uin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null) {
      return (QCallCardInfo)paramString.get(0);
    }
    return null;
  }
  
  public void a(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallCardManager", 2, "saveQcallCard null ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallCardManager", 2, "CardManager saveQcallCard");
    }
    b(paramQCallCardInfo);
    this.b.addMsgQueueAndNotify(paramQCallCardInfo.uin, 0, paramQCallCardInfo.getTableName(), paramQCallCardInfo, 3, null);
  }
  
  public void b(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.gD.containsKey(paramQCallCardInfo.uin))
        {
          this.gD.replace(paramQCallCardInfo.uin, paramQCallCardInfo);
          continue;
        }
      }
      finally {}
      this.gD.put(paramQCallCardInfo.uin, paramQCallCardInfo);
    }
  }
  
  public void onDestroy()
  {
    dGq();
    this.gD.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkf
 * JD-Core Version:    0.7.0.1
 */