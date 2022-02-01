package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FullCache
  extends BaseCache
{
  protected IMCoreAppRuntime app;
  
  public FullCache(IMCoreAppRuntime paramIMCoreAppRuntime, DBDelayManager paramDBDelayManager, Class<? extends Entity> paramClass)
  {
    super(paramDBDelayManager, paramClass);
    this.app = paramIMCoreAppRuntime;
  }
  
  public void addCache(Entity paramEntity, int paramInt, ProxyListener paramProxyListener)
  {
    String str = getKey(paramEntity);
    this.cacheMap.put(str, paramEntity);
    if (paramEntity.getStatus() == 1000)
    {
      this.proxyManager.addQueue(paramEntity, 0, paramInt, paramProxyListener);
      return;
    }
    this.proxyManager.addQueue(paramEntity, 1, paramInt, paramProxyListener);
  }
  
  protected void init()
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    Object localObject = localEntityManager.query(this.clazz, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        this.cacheMap.put(getKey(localEntity), localEntity);
      }
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.FullCache
 * JD-Core Version:    0.7.0.1
 */