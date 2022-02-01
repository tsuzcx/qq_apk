import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class psi
  implements psj
{
  private EntityManager a()
  {
    return QQStoryContext.a().getEntityManagerFactory().createEntityManager();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<HotSortVideoEntry> M(String paramString)
  {
    List localList = a(a(), HotSortVideoEntry.class, HotSortVideoEntry.class.getSimpleName(), "groupId=?", new String[] { paramString });
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ram.b("Q.qqstory:HotSortVideoManager", "query HotSortVideoEntry id: %s, size: %d", paramString, Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public void a(HotSortVideoEntry paramHotSortVideoEntry)
  {
    EntityManager localEntityManager = a();
    paramHotSortVideoEntry.setStatus(1001);
    localEntityManager.update(paramHotSortVideoEntry);
  }
  
  public void b(List<HotSortVideoEntry> paramList, String paramString, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    Object localObject;
    HotSortVideoEntry localHotSortVideoEntry;
    if (paramBoolean) {
      try
      {
        localObject = M(paramString);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
            localHotSortVideoEntry.setStatus(1001);
            localEntityManager.remove(localHotSortVideoEntry);
          }
        }
        localObject = paramList.iterator();
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    while (((Iterator)localObject).hasNext())
    {
      localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
      localHotSortVideoEntry.groupId = paramString;
      localHotSortVideoEntry.setStatus(1000);
      localEntityManager.persistOrReplace(localHotSortVideoEntry);
    }
    ram.b("Q.qqstory:HotSortVideoManager", "insert HotSortVideoEntry list groupId is %s, size is %d", paramString, Integer.valueOf(paramList.size()));
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void updateList(List<HotSortVideoEntry> paramList)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)paramList.next();
        localHotSortVideoEntry.setStatus(1001);
        localEntityManager.update(localHotSortVideoEntry);
      }
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    localEntityManager.getTransaction().end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psi
 * JD-Core Version:    0.7.0.1
 */