import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class acoi
  extends FullCache
{
  public acoi(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, AppletsAccountInfo.class);
  }
  
  public AppletsAccountInfo b(String paramString)
  {
    return (AppletsAccountInfo)findCache(paramString);
  }
  
  public void b(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletAccountCache", 2, "saveAppletsAccount AppletsAccount = " + paramAppletsAccountInfo);
    }
    addCache(paramAppletsAccountInfo);
    this.proxyManager.transSaveToDatabase();
  }
  
  public void clearCache()
  {
    this.cacheMap.clear();
  }
  
  public void destroy() {}
  
  public void doInit()
  {
    Object localObject = this.app.getEntityManagerFactory().createEntityManager();
    List localList = ((EntityManager)localObject).query(AppletsAccountInfo.class);
    ((EntityManager)localObject).close();
    if (localList != null)
    {
      clearCache();
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)((Iterator)localObject).next();
        this.cacheMap.put(String.valueOf(localAppletsAccountInfo.uin), localAppletsAccountInfo);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("doInit size = ");
      if (localList != null) {
        break label118;
      }
    }
    label118:
    for (int i = 0;; i = localList.size())
    {
      QLog.d("AppletAccountCache", 2, i);
      return;
    }
  }
  
  public String getKey(Entity paramEntity)
  {
    return ((AppletsAccountInfo)paramEntity).uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acoi
 * JD-Core Version:    0.7.0.1
 */