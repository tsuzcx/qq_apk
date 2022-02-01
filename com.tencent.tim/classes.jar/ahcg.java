import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransEntity;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy.1;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahcg
  extends acxq
{
  private List<UniformDownloadBPTransEntity> BP;
  
  public ahcg(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private boolean C(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. delEntityFromDB. url=null");
      return false;
    }
    a(UniformDownloadBPTransEntity.tableName(), "mUrl = ?", new String[] { paramString }, null);
    if (paramBoolean)
    {
      QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. delEntityFromDB. bImUpdateDB = true");
      this.a.transSaveToDatabase();
    }
    return true;
  }
  
  private void JP(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = this.BP.iterator();
        localObject = localStringBuilder;
        if (localIterator.hasNext())
        {
          localObject = (UniformDownloadBPTransEntity)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((UniformDownloadBPTransEntity)localObject).mUrl))) {
            continue;
          }
        }
        localStringBuilder = new StringBuilder().append("[UniformDL].>>>removFromCacheEntityList. remove it. url:");
        if (localObject == null)
        {
          paramString = "null";
          QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, paramString);
          this.BP.remove(localObject);
          break;
        }
      }
      finally {}
      paramString = ((UniformDownloadBPTransEntity)localObject).mUrl;
    }
  }
  
  private void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity, ProxyListener paramProxyListener)
  {
    paramProxyListener = this.app.a().createEntityManager();
    if (paramProxyListener == null)
    {
      QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. addEntityToDB. EntityManager. create failed!!");
      return;
    }
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.copyFrom(paramUniformDownloadBPTransEntity);
    if (localUniformDownloadBPTransEntity.getStatus() == 1000) {
      paramProxyListener.persist(localUniformDownloadBPTransEntity);
    }
    for (;;)
    {
      paramProxyListener.close();
      return;
      if (localUniformDownloadBPTransEntity.getStatus() == 1001) {
        paramProxyListener.update(localUniformDownloadBPTransEntity);
      } else {
        QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. addEntityToDB. error status of entity");
      }
    }
  }
  
  private UniformDownloadBPTransEntity b(String paramString)
  {
    Object localObject = "select * from " + UniformDownloadBPTransEntity.tableName() + " where mUrl = " + paramString;
    EntityManager localEntityManager = this.app.a().createEntityManager();
    if (localEntityManager == null)
    {
      QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. queryEntityFromDByUrl. EntityManager. create failed!!");
      return null;
    }
    localObject = localEntityManager.rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
    if (localObject == null)
    {
      localEntityManager.close();
      return null;
    }
    if (((List)localObject).size() > 1) {
      QLog.w("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. count of DB  is over 1 when query url:" + paramString);
    }
    paramString = (UniformDownloadBPTransEntity)((List)localObject).get(0);
    localEntityManager.close();
    return paramString;
  }
  
  private void b(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    if (paramUniformDownloadBPTransEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. addToCacheEntityList. entiy=null");
        return;
      }
      finally {}
      if (this.BP.contains(paramUniformDownloadBPTransEntity))
      {
        QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 1. url:" + paramUniformDownloadBPTransEntity.mUrl);
      }
      else
      {
        Iterator localIterator = this.BP.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)localIterator.next();
            if ((localUniformDownloadBPTransEntity != null) && (localUniformDownloadBPTransEntity.mUrl.equalsIgnoreCase(paramUniformDownloadBPTransEntity.mUrl)))
            {
              QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 2. url:" + paramUniformDownloadBPTransEntity.mUrl);
              break;
            }
          }
        }
        QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL].>>>addToCacheEntityList. add it. url:" + paramUniformDownloadBPTransEntity.mUrl);
        this.BP.add(0, paramUniformDownloadBPTransEntity);
        if (this.BP.size() > 30) {
          this.BP.remove(this.BP.size() - 1);
        }
      }
    }
  }
  
  private UniformDownloadBPTransEntity c(String paramString)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = null;
    if (paramString == null)
    {
      paramString = localUniformDownloadBPTransEntity;
      return paramString;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = this.BP.iterator();
        if (localIterator.hasNext())
        {
          localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)localIterator.next();
          if (localUniformDownloadBPTransEntity == null) {
            continue;
          }
          boolean bool = paramString.equalsIgnoreCase(localUniformDownloadBPTransEntity.mUrl);
          if (!bool) {
            continue;
          }
          paramString = localUniformDownloadBPTransEntity;
          break;
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  private void dmi()
  {
    if (this.BP != null) {
      return;
    }
    Object localObject = "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " order by _id desc limit " + 30 + ") order by _id desc";
    EntityManager localEntityManager = this.app.a().createEntityManager();
    this.BP = localEntityManager.rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
    if (this.BP == null) {
      this.BP = new ArrayList();
    }
    localObject = this.BP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)((Iterator)localObject).next();
      QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. >>>init cache:[ " + localUniformDownloadBPTransEntity.toString() + " ]");
    }
    localEntityManager.close();
  }
  
  private boolean jQ(int paramInt)
  {
    if (this.BP == null)
    {
      QLog.e("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL].>>>getMore. no cache");
      return false;
    }
    if (this.BP.size() == 0) {}
    for (long l = 9223372036854775807L;; l = ((UniformDownloadBPTransEntity)this.BP.get(this.BP.size() - 1)).getId())
    {
      localObject = "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " where _id < " + String.valueOf(l) + " order by _id desc limit " + paramInt + ") order by _id desc";
      localObject = this.app.a().createEntityManager().rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
      if ((localObject != null) && ((localObject == null) || (((List)localObject).size() != 0))) {
        break;
      }
      QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL].>>>getMore. no more. ");
      return false;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b((UniformDownloadBPTransEntity)((Iterator)localObject).next());
    }
    return true;
  }
  
  public void JO(String paramString)
  {
    QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. >>>deleteEntity. url[" + paramString + "]");
    dmi();
    JP(paramString);
    C(paramString, false);
    jQ(1);
  }
  
  public UniformDownloadBPTransEntity a(String paramString)
  {
    dmi();
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = c(paramString);
    if (localUniformDownloadBPTransEntity != null) {
      return localUniformDownloadBPTransEntity;
    }
    return b(paramString);
  }
  
  public void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    QLog.i("UniformDownloadBPTransProxy<FileAssistant>", 1, "[UniformDL]. >>>addEntity. url[" + paramUniformDownloadBPTransEntity.mUrl + "]");
    dmi();
    b(paramUniformDownloadBPTransEntity);
    ThreadManager.executeOnSubThread(new UniformDownloadBPTransProxy.1(this, paramUniformDownloadBPTransEntity));
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  protected void destory() {}
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcg
 * JD-Core Version:    0.7.0.1
 */